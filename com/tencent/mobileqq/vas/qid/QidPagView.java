package com.tencent.mobileqq.vas.qid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.vas.util.NinePatchUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGText;
import org.libpag.PAGView;

/* loaded from: classes20.dex */
public class QidPagView extends VasPagView {
    public static final int DESIGN_PAG_HEIGHT = 550;
    public static final int DESIGN_PAG_WIDTH = 375;
    private static final float SCREEN_RADIO = ((float) ah.M()) / 750.0f;
    public static final String TAG = "QidPagView";
    private PAGView mCurrentPag;
    private QidData mQidInfo;
    private int mQidInfoWidth;
    public boolean restoreQrCodeColor;

    /* loaded from: classes20.dex */
    public static class QidData {
        public Bitmap avatarBitmap;
        public String limixiuPath;
        public String nickName;
        public String pagUrl;
        public String qidBgPath;
        public String qidInfo;
        public int qrCodeColor;
        public Drawable qrDrawable;
        public String savePath;
        public String uin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a implements Function1<PAGView, Unit> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(PAGView pAGView) {
            QidPagView.this.updateQidCard(pAGView);
            return null;
        }
    }

    public QidPagView(@NotNull Context context) {
        this(context, null);
    }

    private void createBitmap(Drawable drawable, int i3, int i16, int i17, Bitmap bitmap) {
        if (bitmap != null) {
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, i16, i17);
            if (QQTheme.isNowThemeIsNight() && (drawable instanceof BitmapDrawable)) {
                drawable.clearColorFilter();
            } else if (i3 == 3 && !QQTheme.isNowThemeIsNight()) {
                drawable.setColorFilter(this.mQidInfo.qrCodeColor, PorterDuff.Mode.SRC_ATOP);
            }
            drawable.draw(canvas);
            if (this.restoreQrCodeColor) {
                drawable.clearColorFilter();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCmShowImageLayer(PAGFile pAGFile, int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        URLDrawable drawable = URLDrawable.getDrawable(str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + System.currentTimeMillis(), (URLDrawable.URLDrawableOptions) null);
        drawable.setURLDrawableListener(new c(pAGFile, i3, str));
        drawable.startDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleImageLayer(PAGFile pAGFile, int i3, Drawable drawable) {
        handleImageLayer(pAGFile, i3, drawableToBitmap(drawable, i3));
    }

    private void handleQidImageLayer(PAGFile pAGFile, int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        URLDrawable drawable = URLDrawable.getDrawable(str, (URLDrawable.URLDrawableOptions) null);
        if (drawable.getStatus() == 1) {
            handleImageLayer(pAGFile, i3, drawable);
        } else {
            drawable.setURLDrawableListener(new b(pAGFile, i3));
            drawable.startDownload();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateQidCard(PAGView pAGView) {
        this.mCurrentPag = pAGView;
        QidData qidData = this.mQidInfo;
        if (qidData == null || TextUtils.isEmpty(qidData.pagUrl)) {
            return;
        }
        pAGView.setScaleMode(3);
        File checkQidPagFile = QidCardManager.checkQidPagFile(this.mQidInfo.pagUrl);
        if (checkQidPagFile == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "QID_QR, localFile,empty ");
                return;
            }
            return;
        }
        PAGFile Load = PagViewMonitor.Load(checkQidPagFile.getAbsolutePath());
        if (Load == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "QID_QR, pagFile,empty ");
                return;
            }
            return;
        }
        if (Load.numTexts() > 2) {
            PAGText textData = Load.getTextData(0);
            textData.text = this.mQidInfo.qidInfo;
            textData.fontFamily = "monospace";
            Load.replaceText(0, textData);
            if (!TextUtils.isEmpty(textData.text)) {
                TextPaint textPaint = new TextPaint();
                textPaint.setTextSize(textData.fontSize * SCREEN_RADIO);
                textPaint.setTypeface(Typeface.MONOSPACE);
                this.mQidInfoWidth = (int) (Layout.getDesiredWidth(textData.text, textPaint) * 0.9f);
            }
            PAGText textData2 = Load.getTextData(1);
            textData2.text = this.mQidInfo.nickName;
            Load.replaceText(1, textData2);
            PAGText textData3 = Load.getTextData(2);
            textData3.text = this.mQidInfo.uin;
            Load.replaceText(2, textData3);
        }
        if (Load.numImages() > 4) {
            handleQidImageLayer(Load, 1, this.mQidInfo.qidBgPath);
            handleImageLayer(Load, 2, this.mQidInfo.avatarBitmap);
            handleImageLayer(Load, 3, this.mQidInfo.qrDrawable);
            handleCmShowImageLayer(Load, 4, this.mQidInfo.limixiuPath);
        }
        pAGView.setComposition(Load);
        pAGView.setRepeatCount(0);
        pAGView.play();
    }

    public void clearTheme() {
        Drawable drawable;
        QidData qidData = this.mQidInfo;
        if (qidData != null && (drawable = qidData.qrDrawable) != null) {
            drawable.clearColorFilter();
        }
    }

    Bitmap drawableToBitmap(Drawable drawable, int i3) {
        Bitmap.Config config;
        Bitmap bitmap = null;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap2 = ((BitmapDrawable) drawable).getBitmap();
            if (i3 != 3) {
                return bitmap2;
            }
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            if (i3 == 1) {
                float f16 = SCREEN_RADIO;
                int i16 = (int) (603.0f * f16);
                int i17 = (int) (71.0f * f16);
                Rect rect = new Rect((int) (40.0f * f16), 2, ((int) (this.mQidInfoWidth + (f16 * 205.0f))) * 2, i17);
                if (!(drawable instanceof URLDrawable)) {
                    return null;
                }
                Drawable currDrawable = ((URLDrawable) drawable).getCurrDrawable();
                if (!(currDrawable instanceof RegionDrawable)) {
                    return null;
                }
                Bitmap bitmap3 = ((RegionDrawable) currDrawable).getBitmap();
                if (bitmap3 != null) {
                    return NinePatchUtil.createNineBitmap(bitmap3, new NinePatchUtil.NinePatchParams(2 * i16, i17, bitmap3.getWidth() / 2, 1, bitmap3.getHeight() / 2, 1), rect);
                }
            } else {
                try {
                    if (drawable.getOpacity() != -1) {
                        config = Bitmap.Config.ARGB_8888;
                    } else {
                        config = Bitmap.Config.RGB_565;
                    }
                    bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
                    createBitmap(drawable, i3, intrinsicWidth, intrinsicHeight, bitmap);
                } catch (OutOfMemoryError unused) {
                }
            }
        }
        return bitmap;
    }

    public Bitmap getBitmap() {
        PAGView pAGView = this.mCurrentPag;
        if (pAGView != null) {
            pAGView.flush();
            return this.mCurrentPag.getBitmap();
        }
        return null;
    }

    public void updateQR(QidData qidData) {
        if (qidData == null) {
            return;
        }
        api().build();
        this.mQidInfo = qidData;
        api().postAction(new a());
    }

    public void updateTheme(int i3) {
        Drawable drawable;
        QidData qidData = this.mQidInfo;
        if (qidData != null && (drawable = qidData.qrDrawable) != null) {
            drawable.setColorFilter(i3, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public QidPagView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QidPagView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.restoreQrCodeColor = false;
    }

    private void handleImageLayer(PAGFile pAGFile, int i3, Bitmap bitmap) {
        if (bitmap != null) {
            PAGImage FromBitmap = PAGImage.FromBitmap(bitmap);
            if (i3 == 1 && FromBitmap != null) {
                FromBitmap.setScaleMode(1);
            }
            pAGFile.replaceImage(i3, FromBitmap);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "QID_QR,replaceImage bitmap is empty " + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PAGFile f310583d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f310584e;

        b(PAGFile pAGFile, int i3) {
            this.f310583d = pAGFile;
            this.f310584e = i3;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QidPagView.this.handleImageLayer(this.f310583d, this.f310584e, uRLDrawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PAGFile f310586d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f310587e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f310588f;

        c(PAGFile pAGFile, int i3, String str) {
            this.f310586d = pAGFile;
            this.f310587e = i3;
            this.f310588f = str;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            if (!TextUtils.equals(this.f310588f, QidCardManager.CM_SHOW_DEFAULT_GIRL_URL) && !TextUtils.equals(this.f310588f, QidCardManager.CM_SHOW_DEFAULT_BOY_URL)) {
                QidPagView.this.mQidInfo.limixiuPath = QidCardManager.getCmShowFailPath();
                if (!TextUtils.isEmpty(QidPagView.this.mQidInfo.limixiuPath)) {
                    QidPagView qidPagView = QidPagView.this;
                    qidPagView.handleCmShowImageLayer(this.f310586d, this.f310587e, qidPagView.mQidInfo.limixiuPath);
                }
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            QidPagView.this.handleImageLayer(this.f310586d, this.f310587e, uRLDrawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
