package com.tencent.mobileqq.vas.pendant.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.image.AbsAsyncDrawable;
import com.tencent.mobileqq.vas.image.ILoaderSucessCallback;
import com.tencent.mobileqq.vas.pendant.drawable.bean.DiyPendantSticker;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IDiyPendantDrawable;
import com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantDrawable;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0016\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002?@B\u000f\u0012\u0006\u0010(\u001a\u00020%\u00a2\u0006\u0004\b<\u0010=J$\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0011H\u0017J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!J\u0012\u0010$\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010*R\u001e\u0010/\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00107R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010#\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/drawable/DiyPendantDrawable;", "Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable;", "Lcom/tencent/mobileqq/vas/pendant/drawable/interfaces/IDiyPendantDrawable;", "Lcom/tencent/mobileqq/vas/pendant/drawable/interfaces/IPendantDrawable;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Rect;", "bounds", "", "text", "", "E", "", "recycle", "uinAndDiyId", "setPendantDiy", "getUinAndDiyId", "", "isLoadSucess", "Lcom/tencent/mobileqq/vas/image/ILoaderSucessCallback;", "callback", "doLoadTask", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "dither", "setDither", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "", "Lcom/tencent/mobileqq/vas/pendant/drawable/interfaces/IDiyPendantDrawable$Sticker;", "D", "onBoundsChange", "Landroid/graphics/drawable/Drawable;", "d", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "e", "Landroid/graphics/Paint;", "f", "textPaint", tl.h.F, "Ljava/util/List;", com.tencent.luggage.wxa.c8.c.B, "Lcom/tencent/mobileqq/vas/pendant/drawable/VasDiyPendantFetcher;", "i", "Lcom/tencent/mobileqq/vas/pendant/drawable/VasDiyPendantFetcher;", "fetcher", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", BdhLogUtil.LogTag.Tag_Conn, "I", "radius", NodeProps.PADDING_TOP, "", "scaleFactor", "<init>", "(Landroid/graphics/drawable/Drawable;)V", UserInfo.SEX_FEMALE, "a", "b", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class DiyPendantDrawable extends AbsAsyncDrawable implements IDiyPendantDrawable, IPendantDrawable {

    /* renamed from: C, reason: from kotlin metadata */
    private int radius;

    /* renamed from: D, reason: from kotlin metadata */
    private int paddingTop;

    /* renamed from: E, reason: from kotlin metadata */
    private double scaleFactor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Drawable defaultDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint textPaint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends IDiyPendantDrawable.Sticker> stickers;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VasDiyPendantFetcher fetcher;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String uinAndDiyId;

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0004\u0018\u00002\u00020\u0001B9\b\u0000\u0012\u0006\u0010<\u001a\u00020\u0018\u0012\u0006\u0010=\u001a\u00020\b\u0012\u0006\u0010>\u001a\u00020\u0010\u0012\u0006\u0010?\u001a\u00020\u0018\u0012\u0006\u0010@\u001a\u00020\u0018\u0012\u0006\u0010A\u001a\u00020\u0018\u00a2\u0006\u0004\bB\u0010CJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001a\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\"\u0010'\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\"\u0010+\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\"\u00103\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00107\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010.\u001a\u0004\b5\u00100\"\u0004\b6\u00102R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/drawable/DiyPendantDrawable$b;", "Lcom/tencent/mobileqq/vas/pendant/drawable/interfaces/IDiyPendantDrawable$Sticker;", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Paint;", "paint", "", "draw", "", "a", "D", "getMRadians", "()D", "setMRadians", "(D)V", "mRadians", "", "b", "Ljava/lang/String;", "getMText", "()Ljava/lang/String;", "setMText", "(Ljava/lang/String;)V", "mText", "", "c", "I", "getMFontId", "()I", "setMFontId", "(I)V", "mFontId", "d", "getMFontType", "setMFontType", "mFontType", "e", "getMFontColor", "setMFontColor", "mFontColor", "f", "getMIndex", "setMIndex", "mIndex", "Landroid/graphics/Rect;", "g", "Landroid/graphics/Rect;", "getMDst", "()Landroid/graphics/Rect;", "setMDst", "(Landroid/graphics/Rect;)V", "mDst", tl.h.F, "getMTextBounds", "setMTextBounds", "mTextBounds", "", "i", "Z", "isReportFontUsed", "index", "angle", "text", MessageForRichState.SIGN_MSG_FONT_ID, MessageForRichState.SIGN_MSG_FONT_TYPE, "fontColor", "<init>", "(Lcom/tencent/mobileqq/vas/pendant/drawable/DiyPendantDrawable;IDLjava/lang/String;III)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public final class b implements IDiyPendantDrawable.Sticker {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private double mRadians;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String mText;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int mFontId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int mFontType;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int mFontColor;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int mIndex;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Rect mDst;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private Rect mTextBounds;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private boolean isReportFontUsed;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ DiyPendantDrawable f310468j;

        public b(DiyPendantDrawable diyPendantDrawable, int i3, @NotNull double d16, String text, int i16, int i17, int i18) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.f310468j = diyPendantDrawable;
            this.mDst = new Rect();
            this.mTextBounds = new Rect();
            this.mRadians = d16 * 0.017453292519943295d;
            this.mIndex = i3;
            this.mText = text;
            this.mFontColor = i18;
            this.mFontId = i16;
            this.mFontType = i17;
        }

        @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IDiyPendantDrawable.Sticker
        public void draw(@NotNull Canvas canvas, @Nullable Paint paint) {
            boolean z16;
            double coerceAtMost;
            boolean z17;
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Bitmap fetchDiyPaster = this.f310468j.fetcher.fetchDiyPaster(this.f310468j, this.mIndex);
            if (fetchDiyPaster != null) {
                Rect bounds = this.f310468j.getBounds();
                Intrinsics.checkNotNullExpressionValue(bounds, "bounds");
                int width = bounds.width();
                int height = bounds.height();
                int sin = (int) ((width / 2) + (Math.sin(this.mRadians) * this.f310468j.radius));
                int cos = (int) ((height / 2) - (Math.cos(this.mRadians) * this.f310468j.radius));
                int width2 = ((int) (fetchDiyPaster.getWidth() * this.f310468j.scaleFactor)) / 2;
                int height2 = ((int) (fetchDiyPaster.getHeight() * this.f310468j.scaleFactor)) / 2;
                this.mDst.set(sin - width2, (cos - height2) + (this.f310468j.paddingTop / 2), sin + width2, cos + height2 + (this.f310468j.paddingTop / 2));
                Rect rect = this.mDst;
                int i3 = rect.left;
                int i16 = bounds.left;
                if (i3 < i16) {
                    rect.right += i16 - i3;
                    rect.left = i16;
                }
                int i17 = rect.top;
                int i18 = bounds.top;
                if (i17 < i18) {
                    rect.bottom += i18 - i17;
                    rect.top = i18;
                }
                int i19 = rect.right;
                int i26 = bounds.right;
                if (i19 > i26) {
                    rect.left += i26 - i19;
                    rect.right = i26;
                }
                int i27 = rect.bottom;
                int i28 = bounds.bottom;
                if (i27 > i28) {
                    rect.top += i28 - i27;
                    rect.bottom = i28;
                }
                canvas.drawBitmap(fetchDiyPaster, (Rect) null, rect, paint);
                if (!TextUtils.isEmpty(this.mText)) {
                    if (!this.isReportFontUsed) {
                        this.isReportFontUsed = true;
                        ReportInfo.report$default(VasCommonReporter.getHistoryFeature().setValue1("pendant_sticker_font").setValue2(this.mText).setNum1(this.mFontId).setNum2(this.mFontType).setNum3(1L), false, 1, null);
                    }
                    double d16 = 10;
                    int i29 = (int) (this.f310468j.scaleFactor * d16);
                    Rect rect2 = this.mTextBounds;
                    Rect rect3 = this.mDst;
                    rect2.set(rect3.left + i29, rect3.top + i29, rect3.right - i29, rect3.bottom - i29);
                    DiyPendantDrawable diyPendantDrawable = this.f310468j;
                    float E = diyPendantDrawable.E(diyPendantDrawable.textPaint, this.mTextBounds, this.mText);
                    if (this.mFontType == 1) {
                        Paint paint2 = new Paint();
                        paint2.setTextSize(E);
                        int measureText = (int) paint2.measureText(this.mText);
                        coerceAtMost = RangesKt___RangesKt.coerceAtMost(E + (d16 * this.f310468j.scaleFactor), this.mTextBounds.height());
                        Bitmap fetchTextBitmap = this.f310468j.fetcher.fetchTextBitmap(this.f310468j, this.mText, this.mFontId, this.mFontType, E, this.mFontColor, measureText, (int) coerceAtMost, paint);
                        if (fetchTextBitmap != null) {
                            int centerX = this.mDst.centerX();
                            int centerY = this.mDst.centerY();
                            this.mTextBounds.set(centerX - (fetchTextBitmap.getWidth() / 2), centerY - (fetchTextBitmap.getHeight() / 2), centerX + (fetchTextBitmap.getWidth() / 2), centerY + (fetchTextBitmap.getHeight() / 2));
                            canvas.drawBitmap(fetchTextBitmap, (Rect) null, this.mTextBounds, paint);
                        }
                        if (QLog.isColorLevel()) {
                            String str = this.mText;
                            int i36 = this.mFontId;
                            int i37 = this.mFontColor;
                            if (fetchTextBitmap != null) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            QLog.d("DiyPendantDrawable", 2, "draw textInfo text = " + str + " fontId = " + i36 + " fontType = 1 color = " + i37 + " fontBitmap Existed = " + z17);
                            return;
                        }
                        return;
                    }
                    Typeface fetchTextTypeface = this.f310468j.fetcher.fetchTextTypeface(this.f310468j, this.mFontId, this.mFontType);
                    if (fetchTextTypeface != null) {
                        this.f310468j.textPaint.setTypeface(fetchTextTypeface);
                    }
                    this.f310468j.textPaint.setColor(this.mFontColor);
                    this.f310468j.textPaint.setTextAlign(Paint.Align.CENTER);
                    this.f310468j.textPaint.setTextSize(E);
                    Paint.FontMetrics fontMetrics = this.f310468j.textPaint.getFontMetrics();
                    Intrinsics.checkNotNullExpressionValue(fontMetrics, "textPaint.fontMetrics");
                    Rect rect4 = this.mTextBounds;
                    canvas.drawText(this.mText, rect4.centerX(), (((rect4.bottom + rect4.top) - fontMetrics.bottom) - fontMetrics.top) / 2, this.f310468j.textPaint);
                    if (QLog.isColorLevel()) {
                        String str2 = this.mText;
                        int i38 = this.mFontId;
                        int i39 = this.mFontType;
                        int i46 = this.mFontColor;
                        if (fetchTextTypeface != null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        QLog.d("DiyPendantDrawable", 2, "draw textInfo text = " + str2 + " fontId = " + i38 + " fontType = " + i39 + " color = " + i46 + " localTypeFace Existed = " + z16);
                    }
                }
            }
        }
    }

    public DiyPendantDrawable(@NotNull Drawable defaultDrawable) {
        Intrinsics.checkNotNullParameter(defaultDrawable, "defaultDrawable");
        this.defaultDrawable = defaultDrawable;
        this.paint = new Paint(6);
        this.textPaint = new Paint();
        VasDiyPendantFetcher n3 = VasDiyPendantFetcher.n();
        Intrinsics.checkNotNullExpressionValue(n3, "getFetcher()");
        this.fetcher = n3;
        setTargetDrawableBuild(new Function0<Drawable>() { // from class: com.tencent.mobileqq.vas.pendant.drawable.DiyPendantDrawable.1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Drawable invoke() {
                return DiyPendantDrawable.this.defaultDrawable;
            }
        });
        AbsAsyncDrawable.load$default(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float E(Paint paint, Rect bounds, String text) {
        int width = bounds.width();
        if (width <= 0) {
            return 0.0f;
        }
        TextPaint textPaint = new TextPaint(paint);
        float height = bounds.height();
        textPaint.setTextSize(height);
        while (true) {
            if ((textPaint.measureText(text) > width || Math.ceil(textPaint.getFontMetrics().descent - textPaint.getFontMetrics().ascent) > bounds.height()) && height > 0.0f) {
                height -= 1.0f;
                textPaint.setTextSize(height);
            }
        }
        return height;
    }

    @Nullable
    public final synchronized List<IDiyPendantDrawable.Sticker> D() {
        int i3;
        List list = this.stickers;
        if (list != null) {
            return list;
        }
        List<DiyPendantSticker> fetchDiyBaseInfo = this.fetcher.fetchDiyBaseInfo(this);
        if (fetchDiyBaseInfo != null) {
            int i16 = 1;
            if (!fetchDiyBaseInfo.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                int size = fetchDiyBaseInfo.size();
                int i17 = 0;
                while (i17 < size) {
                    DiyPendantSticker diyPendantSticker = fetchDiyBaseInfo.get(i17);
                    try {
                        i3 = Color.parseColor(diyPendantSticker.fontColor);
                    } catch (Exception e16) {
                        Object[] objArr = new Object[2];
                        objArr[0] = "parse sticker text color failed.";
                        objArr[i16] = e16.getMessage();
                        QLog.e("DiyPendantDrawable", i16, objArr);
                        i3 = -16777216;
                    }
                    double d16 = diyPendantSticker.angle;
                    String str = diyPendantSticker.text;
                    Intrinsics.checkNotNullExpressionValue(str, "sticker.text");
                    arrayList.add(new b(this, i17, d16, str, diyPendantSticker.fontId, diyPendantSticker.fontType, i3));
                    i17++;
                    i16 = 1;
                }
                this.stickers = arrayList;
                return arrayList;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    public void doLoadTask(@NotNull ILoaderSucessCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        List<IDiyPendantDrawable.Sticker> D = D();
        if (D != null && (!D.isEmpty())) {
            Iterator<IDiyPendantDrawable.Sticker> it = D.iterator();
            while (it.hasNext()) {
                it.next().draw(canvas, this.paint);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable, com.tencent.mobileqq.vas.pendant.drawable.interfaces.Invalidatable
    public /* bridge */ /* synthetic */ Object getCallback() {
        return getCallback();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IDiyPendantDrawable
    @NotNull
    public String getUinAndDiyId() {
        String str = this.uinAndDiyId;
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable
    /* renamed from: isLoadSucess */
    public boolean getIsLoadSuccess() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void onBoundsChange(@Nullable Rect bounds) {
        super.onBoundsChange(bounds);
        if (bounds == null) {
            return;
        }
        int width = bounds.width();
        this.paddingTop = Math.abs(bounds.height() - width);
        double d16 = width / 250;
        this.scaleFactor = d16;
        this.radius = (int) (100 * d16);
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (alpha != this.paint.getAlpha()) {
            this.paint.setAlpha(alpha);
            invalidateSelf();
        }
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public void setDither(boolean dither) {
        this.paint.setDither(dither);
        invalidateSelf();
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IDiyPendantDrawable
    public void setPendantDiy(@Nullable String uinAndDiyId) {
        this.uinAndDiyId = uinAndDiyId;
        QLog.i("DiyPendantDrawable", 1, "uinAndDiyId is " + uinAndDiyId);
    }

    @Override // com.tencent.mobileqq.vas.pendant.drawable.interfaces.IPendantDrawable
    public void recycle() {
    }
}
