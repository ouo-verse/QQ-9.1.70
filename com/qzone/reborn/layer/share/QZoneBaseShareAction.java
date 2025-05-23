package com.qzone.reborn.layer.share;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.BasePictureViewer;
import com.qzone.reborn.layer.part.QZoneBasePictureViewerPart;
import com.qzone.util.aj;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qqguildsdk.data.type.IChannelType;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.sharpP.SharpPDecoderHelper;
import com.tencent.sharpP.SharpPDecoderWrapper;
import com.tencent.sharpP.SharpPUtils;
import cooperation.qzone.cache.CacheManager;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.WeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import libavif.AvifDecoder;
import libavif.AvifImage;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class QZoneBaseShareAction {

    /* renamed from: a, reason: collision with root package name */
    public Dialog f58106a;

    /* renamed from: b, reason: collision with root package name */
    protected f f58107b;

    /* renamed from: c, reason: collision with root package name */
    private Activity f58108c;

    /* renamed from: d, reason: collision with root package name */
    public PhotoInfo f58109d;

    /* renamed from: e, reason: collision with root package name */
    public PhotoParam f58110e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<PhotoInfo> f58111f;

    /* renamed from: g, reason: collision with root package name */
    protected int f58112g = 0;

    /* renamed from: h, reason: collision with root package name */
    private Handler f58113h = new b(this);

    /* renamed from: i, reason: collision with root package name */
    public ShareActionSheetBuilder.ActionSheetItem f58114i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f58127d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PhotoInfo f58128e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f58129f;

        a(boolean z16, PhotoInfo photoInfo, int i3) {
            this.f58127d = z16;
            this.f58128e = photoInfo;
            this.f58129f = i3;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            Message obtain = Message.obtain();
            obtain.obj = new QZoneResult(QZoneBaseShareAction.this.o(this.f58129f));
            QZoneBaseShareAction.this.r().sendMessage(obtain);
            QZLog.d("QZoneFeedxBaseShareAction", 1, "onImageCancel url", str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            Message obtain = Message.obtain();
            obtain.obj = new QZoneResult(QZoneBaseShareAction.this.o(this.f58129f));
            QZoneBaseShareAction.this.r().sendMessage(obtain);
            QZLog.d("QZoneFeedxBaseShareAction", 1, "onImageFailed url", str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            this.f58128e.setImageDrawable(drawable);
            Message obtain = Message.obtain();
            obtain.obj = new QZoneResult(QZoneBaseShareAction.this.p(this.f58129f));
            QZoneBaseShareAction.this.r().sendMessage(obtain);
            QZLog.d("QZoneFeedxBaseShareAction", 1, "onImageLoaded url", str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            if (this.f58127d) {
                int i3 = (int) (f16 * 100.0f);
                if (i3 > 99) {
                    i3 = 99;
                }
                Message obtain = Message.obtain();
                QZoneResult qZoneResult = new QZoneResult(1000060);
                Bundle bundle = new Bundle();
                bundle.putInt("progress", i3);
                bundle.putLong("totalSize", Long.valueOf(options != null ? options.totalSize : 0L).longValue());
                qZoneResult.setData(bundle);
                obtain.obj = qZoneResult;
                QZoneBaseShareAction.this.r().sendMessage(obtain);
            }
        }
    }

    public QZoneBaseShareAction(Activity activity) {
        this.f58108c = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o(int i3) {
        if (i3 == 1) {
            return 1000062;
        }
        if (i3 == 2) {
            return 1000064;
        }
        if (i3 == 3) {
            return 1000066;
        }
        if (i3 == 4) {
            return 1000068;
        }
        return IChannelType.APP_SUB_CHANNEL_TYPE_CODM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p(int i3) {
        if (i3 == 1) {
            return 1000061;
        }
        if (i3 == 2) {
            return 1000063;
        }
        if (i3 == 3) {
            return 1000065;
        }
        if (i3 == 4) {
            return 1000067;
        }
        return 1000069;
    }

    public static File q(ImageLoader imageLoader, PhotoInfo photoInfo) {
        File imageFile = !TextUtils.isEmpty(photoInfo.orgUrl) ? imageLoader.getImageFile(photoInfo.orgUrl) : null;
        if ((imageFile == null || !imageFile.exists()) && !TextUtils.isEmpty(photoInfo.downloadUrl)) {
            imageFile = imageLoader.getImageFile(photoInfo.downloadUrl);
        }
        if ((imageFile == null || !imageFile.exists()) && photoInfo.photoType == 2) {
            imageFile = imageLoader.getImageFile(QZoneBasePictureViewerPart.Ca(photoInfo));
        }
        if (imageFile == null || !imageFile.exists()) {
            imageFile = imageLoader.getImageFile(photoInfo.bigUrl);
        }
        return (imageFile != null || photoInfo.hasLoaded) ? imageFile : imageLoader.getImageFile(photoInfo.currentUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(PhotoInfo photoInfo) {
        if (QZoneBasePictureViewerPart.Qa(photoInfo) && photoInfo != null && ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) == null) {
            return true;
        }
        if (photoInfo == null || photoInfo.photoType != 2 || ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) != null) {
            return false;
        }
        String Ca = QZoneBasePictureViewerPart.Ca(photoInfo);
        File imageFile = ImageLoader.getInstance().getImageFile(Ca);
        if (imageFile == null) {
            return true;
        }
        if (SharpPUtils.isSharpP(imageFile)) {
            ImageLoader.getInstance().removeImageFile(Ca);
            return true;
        }
        QZLog.i("QZoneFeedxBaseShareAction", 1, "-----needn't to download file for sharpp gif.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(f fVar) {
        String str;
        String str2;
        String str3;
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("invalid share context, ");
        if (fVar != null && fVar.f58180d != null) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(" curKey is ");
            String str4 = "";
            if (TextUtils.isEmpty(fVar.f58180d.curKey)) {
                str2 = "";
            } else {
                str2 = fVar.f58180d.curKey;
            }
            sb6.append(str2);
            sb6.append(" ugcKey is ");
            if (TextUtils.isEmpty(fVar.f58180d.ugcKey)) {
                str3 = "";
            } else {
                str3 = fVar.f58180d.ugcKey;
            }
            sb6.append(str3);
            sb6.append(" cellId is ");
            if (!TextUtils.isEmpty(fVar.f58180d.cell_id)) {
                str4 = fVar.f58180d.cell_id;
            }
            sb6.append(str4);
            str = sb6.toString();
        } else {
            str = "all info is null";
        }
        sb5.append(str);
        objArr[0] = sb5.toString();
        RFWLog.e("QZoneFeedxBaseShareAction", i3, objArr);
    }

    public void B(String str) {
        if (n() == null || n().isFinishing()) {
            return;
        }
        if (this.f58106a == null) {
            ReportDialog reportDialog = new ReportDialog(n(), R.style.f174269ui);
            this.f58106a = reportDialog;
            reportDialog.setContentView(R.layout.bqd);
            this.f58106a.findViewById(R.id.kja).setVisibility(8);
            this.f58106a.findViewById(R.id.cib).setVisibility(0);
        }
        ((TextView) this.f58106a.findViewById(R.id.dialogText)).setText(str);
        this.f58106a.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        ArrayList<PhotoInfo> arrayList = this.f58111f;
        if (arrayList == null || arrayList.isEmpty() || this.f58112g > this.f58111f.size() - 1) {
            return;
        }
        this.f58112g++;
        RFWLog.i("QZoneFeedxBaseShareAction", RFWLog.USR, "update index is " + this.f58112g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(final int i3, final String str, final Handler handler) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.share.QZoneBaseShareAction.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<PhotoInfo> arrayList = QZoneBaseShareAction.this.f58111f;
                if (arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                if (QZoneBaseShareAction.this.f58112g > r0.f58111f.size() - 1) {
                    return;
                }
                if (QZoneBaseShareAction.this.f58112g == 0) {
                    RFWLog.i("QZoneFeedxBaseShareAction", RFWLog.USR, "save ing");
                    Message obtain = Message.obtain();
                    obtain.what = 4;
                    handler.sendMessage(obtain);
                }
                QZoneBaseShareAction.this.r().post(new Runnable() { // from class: com.qzone.reborn.layer.share.QZoneBaseShareAction.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QZoneBaseShareAction qZoneBaseShareAction = QZoneBaseShareAction.this;
                        if (qZoneBaseShareAction.f58112g >= qZoneBaseShareAction.f58111f.size() || QZoneBaseShareAction.this.f58112g < 0) {
                            return;
                        }
                        RFWLog.i("QZoneFeedxBaseShareAction", RFWLog.USR, "org download, index is " + QZoneBaseShareAction.this.f58112g);
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        QZoneBaseShareAction qZoneBaseShareAction2 = QZoneBaseShareAction.this;
                        qZoneBaseShareAction2.z(i3, qZoneBaseShareAction2.f58111f.get(qZoneBaseShareAction2.f58112g));
                    }
                });
                if (QZoneBaseShareAction.this.f58112g == r0.f58111f.size() - 1) {
                    RFWLog.i("QZoneFeedxBaseShareAction", RFWLog.USR, "save long pic, index is " + QZoneBaseShareAction.this.f58112g);
                    QZoneBaseShareAction qZoneBaseShareAction = QZoneBaseShareAction.this;
                    qZoneBaseShareAction.h(qZoneBaseShareAction.f58111f, str, handler);
                }
            }
        });
    }

    public void f(final int i3, final String str, final Handler handler) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.share.QZoneBaseShareAction.2
            @Override // java.lang.Runnable
            public void run() {
                QZoneBaseShareAction qZoneBaseShareAction = QZoneBaseShareAction.this;
                PhotoInfo photoInfo = qZoneBaseShareAction.f58109d;
                if (!qZoneBaseShareAction.w(photoInfo)) {
                    if (QZoneBaseShareAction.this.u(photoInfo)) {
                        QZoneBaseShareAction.this.r().post(new Runnable() { // from class: com.qzone.reborn.layer.share.QZoneBaseShareAction.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                QZoneBaseShareAction qZoneBaseShareAction2 = QZoneBaseShareAction.this;
                                qZoneBaseShareAction2.k(i3, qZoneBaseShareAction2.f58109d, false);
                            }
                        });
                        return;
                    } else {
                        QZoneBaseShareAction.this.g(photoInfo, str, handler);
                        return;
                    }
                }
                QZoneBaseShareAction.this.r().post(new Runnable() { // from class: com.qzone.reborn.layer.share.QZoneBaseShareAction.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        QZoneBaseShareAction.this.y(i3);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0287 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02c2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(ArrayList<PhotoInfo> arrayList, String str, Handler handler) {
        String str2;
        String str3;
        String str4;
        Bitmap c16;
        int i3;
        int i16;
        PhotoInfo next;
        Bitmap bitmap;
        Message obtain = Message.obtain();
        if (arrayList != null && !arrayList.isEmpty()) {
            if (!CacheManager.isExternalAvailable()) {
                obtain.what = 3;
                QZLog.i("QZoneFeedxBaseShareAction", 1, "copyPictures-save error sd is not writable");
                handler.sendMessage(obtain);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ImageLoader imageLoader = ImageLoader.getInstance();
            Iterator<PhotoInfo> it = arrayList.iterator();
            while (true) {
                String str5 = ".jpeg";
                if (it.hasNext()) {
                    next = it.next();
                    File q16 = q(imageLoader, next);
                    if (q16 == null || !q16.exists()) {
                        break;
                    }
                    String Ua = QZoneBasePictureViewerPart.Ua(q16.getAbsolutePath());
                    if (Ua == null) {
                        obtain.what = 1;
                        QZLog.i("QZoneFeedxBaseShareAction", 1, "copyPictures-save error postfix == null");
                        handler.sendMessage(obtain);
                        return;
                    }
                    arrayList2.add(Ua);
                    arrayList3.add(q16);
                } else {
                    int i17 = n().getResources().getDisplayMetrics().widthPixels;
                    Runtime runtime = Runtime.getRuntime();
                    long maxMemory = runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory());
                    ArrayList arrayList4 = new ArrayList();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    int i18 = 0;
                    int i19 = 0;
                    while (true) {
                        str2 = "avif";
                        if (i18 >= arrayList2.size()) {
                            break;
                        }
                        if (((String) arrayList2.get(i18)).equals("sharpp")) {
                            SharpPDecoderWrapper.SharpPFeatureWrapper featureInfo = new SharpPDecoderHelper(((File) arrayList3.get(i18)).getAbsolutePath()).getFeatureInfo();
                            if (featureInfo != null) {
                                i3 = featureInfo.getWidth();
                                i16 = featureInfo.getHeight();
                            }
                            i16 = -1;
                            i3 = -1;
                        } else if (((String) arrayList2.get(i18)).equals("avif")) {
                            AvifImage g16 = AvifDecoder.c(FileUtils.readFile(((File) arrayList3.get(i18)).getAbsolutePath())).g();
                            if (g16 != null) {
                                i3 = g16.b();
                                i16 = g16.a();
                            }
                            i16 = -1;
                            i3 = -1;
                        } else {
                            BitmapFactory.decodeFile(((File) arrayList3.get(i18)).getAbsolutePath(), options);
                            i3 = options.outWidth;
                            i16 = options.outHeight;
                        }
                        if (i3 > 0 && i16 > 0) {
                            int i26 = (int) ((i16 * i17) / i3);
                            arrayList4.add(Integer.valueOf(i26));
                            i19 += i26;
                        } else {
                            arrayList4.add(0);
                        }
                        i18++;
                    }
                    int i27 = i17 * i19 * 2;
                    int i28 = i19;
                    while (true) {
                        str3 = str2;
                        str4 = str5;
                        if (i27 <= maxMemory * 0.85d) {
                            break;
                        }
                        int size = arrayList3.size() - 1;
                        i28 -= ((Integer) arrayList4.get(size)).intValue();
                        i27 -= (((Integer) arrayList4.get(size)).intValue() * i17) * 2;
                        arrayList3.remove(size);
                        arrayList2.remove(size);
                        arrayList4.remove(size);
                        str5 = str4;
                        str2 = str3;
                    }
                    if (i28 > 0 && i17 > 0) {
                        Bitmap createBitmap = Bitmap.createBitmap(i17, i28, Bitmap.Config.RGB_565);
                        options.inJustDecodeBounds = false;
                        int i29 = 0;
                        for (int i36 = 0; i36 < arrayList2.size(); i36++) {
                            try {
                            } catch (Throwable th5) {
                                th = th5;
                            }
                            if ("sharpp".equals(arrayList2.get(i36))) {
                                QZLog.i("QZoneFeedxBaseShareAction", "sharpp file");
                                c16 = SharpPUtils.decodeSharpP(((File) arrayList3.get(i36)).getAbsolutePath());
                            } else {
                                String str6 = str3;
                                try {
                                } catch (Throwable th6) {
                                    th = th6;
                                    str3 = str6;
                                    QZLog.w("QZoneFeedxBaseShareAction", "copy picture error ", th);
                                }
                                if (((String) arrayList2.get(i36)).equals(str6)) {
                                    str3 = str6;
                                    c16 = com.tencent.qzone.image.api.a.c().a((File) arrayList3.get(i36), ((File) arrayList3.get(i36)).getAbsolutePath(), 0, 0);
                                } else {
                                    str3 = str6;
                                    if ("gif".equals(arrayList2.get(i36))) {
                                        QZLog.i("QZoneFeedxBaseShareAction", "gif file");
                                    } else {
                                        QZLog.i("QZoneFeedxBaseShareAction", "webp file");
                                    }
                                    c16 = com.qzone.util.image.c.c(BitmapFactory.decodeFile(((File) arrayList3.get(i36)).getAbsolutePath(), options), 90);
                                    if (c16 == null) {
                                        try {
                                            if (i36 < arrayList4.size() && ((Integer) arrayList4.get(i36)).intValue() > 0) {
                                                PhotoUtils.drawBitmap(createBitmap, com.qzone.util.image.c.F(c16, i17 / c16.getWidth()), i29);
                                                i29 += ((Integer) arrayList4.get(i36)).intValue();
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            QZLog.w("QZoneFeedxBaseShareAction", "copy picture error ", th);
                                        }
                                    }
                                }
                            }
                            if (c16 == null) {
                            }
                        }
                        Bitmap F = createBitmap.getHeight() > 29999 ? com.qzone.util.image.c.F(createBitmap, 29999 / createBitmap.getHeight()) : createBitmap;
                        String str7 = System.currentTimeMillis() + str4;
                        String str8 = str + str7;
                        if (com.qzone.util.image.c.W(F, str, str7, Bitmap.CompressFormat.JPEG, 90, true)) {
                            obtain.what = 2;
                            obtain.obj = str8;
                            QZLog.i("QZoneFeedxBaseShareAction", "------file save success:" + str7);
                        } else {
                            obtain.what = 1;
                            QZLog.i("QZoneFeedxBaseShareAction", "------file save error:" + str7);
                        }
                        handler.sendMessage(obtain);
                        return;
                    }
                    obtain.what = 1;
                    handler.sendMessage(obtain);
                    QZLog.i("QZoneFeedxBaseShareAction", "------file save error: width: " + i17 + ", height: " + i28);
                    return;
                }
            }
            obtain.what = -1;
            QZLog.i("QZoneFeedxBaseShareAction", 1, "copyPictures-save error file == null");
            Drawable imageByUrlInMemory = ImageManager.getInstance().getImageByUrlInMemory(next.bigUrl);
            if ((imageByUrlInMemory instanceof ImageDrawable) && (bitmap = ((ImageDrawable) imageByUrlInMemory).getBitmapRef().getBitmap()) != null && !bitmap.isRecycled()) {
                String str9 = str + (System.currentTimeMillis() + ".jpeg");
                boolean V = com.qzone.util.image.c.V(bitmap, str9, Bitmap.CompressFormat.JPEG, 90, false);
                obtain.what = V ? 2 : 1;
                if (V) {
                    QZLog.i("QZoneFeedxBaseShareAction", 1, "copyPictures-loadBitmap saveSuccess");
                    obtain.obj = str9;
                }
            }
            handler.sendMessage(obtain);
            return;
        }
        obtain.what = 1;
        QZLog.i("QZoneFeedxBaseShareAction", 1, "copyPictures-save error photoInfos == null");
        handler.sendMessage(obtain);
    }

    public void i() {
        try {
            Dialog dialog = this.f58106a;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.f58106a.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    abstract void j(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem);

    public void k(int i3, final PhotoInfo photoInfo, boolean z16) {
        final a aVar = new a(z16, photoInfo, i3);
        final ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.justCover = false;
        obtain.needShowGifAnimation = true;
        obtain.type = AppConstants.HTTP_TYPE_QZONE_DOWNLOAD_BIG_PIC;
        obtain.needCallBackProcessPercent = true;
        obtain.isNeedPieceLoad = true;
        if (i3 != 1 && i3 != 3 && i3 != 4 && i3 != 5) {
            if (i3 == 2) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.layer.share.QZoneBaseShareAction.4
                    @Override // java.lang.Runnable
                    public void run() {
                        ImageLoader.getInstance().getImageFile(photoInfo.orgUrl);
                        QZoneBaseShareAction qZoneBaseShareAction = QZoneBaseShareAction.this;
                        qZoneBaseShareAction.m(qZoneBaseShareAction.r(), aVar, obtain, 1000063, photoInfo);
                    }
                });
            }
        } else {
            if (i3 == 3 || i3 == 4 || i3 == 5) {
                photoInfo.showGifState = PhotoInfo.SHOW_NEITHER_GIF_NOR_PLAY;
            }
            l(r(), aVar, obtain, p(i3), photoInfo, z16);
        }
    }

    public Activity n() {
        return this.f58108c;
    }

    public Handler r() {
        return this.f58113h;
    }

    public abstract int[] s();

    public void t(f fVar, ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (v(fVar)) {
            A(fVar);
            return;
        }
        this.f58107b = fVar;
        this.f58109d = fVar.f58179c;
        this.f58111f = fVar.f58181e;
        this.f58110e = fVar.f58180d;
        this.f58114i = actionSheetItem;
        j(fVar, actionSheetItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(Message message) {
        QLog.d("QZoneFeedxBaseShareAction", 1, "onHandleMessage:" + message);
    }

    public void y(int i3) {
        z(i3, this.f58109d);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    private static class b extends WeakReferenceHandler<QZoneBaseShareAction> {
        b(QZoneBaseShareAction qZoneBaseShareAction) {
            super(qZoneBaseShareAction);
        }

        @Override // cooperation.qzone.util.WeakReferenceHandler
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void handleMessage(QZoneBaseShareAction qZoneBaseShareAction, Message message) {
            if (message != null) {
                qZoneBaseShareAction.x(message);
            }
        }
    }

    public void z(int i3, PhotoInfo photoInfo) {
        k(i3, photoInfo, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(PhotoInfo photoInfo) {
        return photoInfo != null && !TextUtils.isEmpty(photoInfo.downloadUrl) && ImageLoader.getInstance().getImageFile(photoInfo.downloadUrl) == null && ImageLoader.getInstance().getImageFile(photoInfo.orgUrl) == null;
    }

    private boolean v(f fVar) {
        return fVar == null || fVar.f58179c == null || fVar.f58180d == null;
    }

    public void l(Handler handler, ImageLoader.ImageLoadListener imageLoadListener, ImageLoader.Options options, int i3, PhotoInfo photoInfo, boolean z16) {
        String a16;
        if (photoInfo == null) {
            return;
        }
        if (z16) {
            a16 = aj.b(photoInfo);
        } else {
            a16 = aj.a(photoInfo);
        }
        if (photoInfo.photoType == 2 && (i3 == 1000065 || i3 == 1000067 || i3 == 1000069)) {
            a16 = BasePictureViewer.V3(photoInfo);
        }
        QLog.d("QzonePhotoUtil", 1, "downloadImage, shouldDownloadOrigin: " + z16 + ", url: " + a16);
        if (ImageLoader.getInstance().loadImage(a16, imageLoadListener, options) != null) {
            QZLog.d("QZoneFeedxBaseShareAction", 1, "orgImg != null  url:", a16);
            Message obtain = Message.obtain();
            obtain.obj = new QZoneResult(i3);
            handler.sendMessage(obtain);
            return;
        }
        QLog.d("QZoneFeedxBaseShareAction", 1, "get org_img is null");
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x014f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0195 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d9 A[Catch: OutOfMemoryError -> 0x0149, TryCatch #1 {OutOfMemoryError -> 0x0149, blocks: (B:52:0x00d3, B:54:0x00d9, B:56:0x00ef, B:80:0x00e2), top: B:51:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ef A[Catch: OutOfMemoryError -> 0x0149, TRY_LEAVE, TryCatch #1 {OutOfMemoryError -> 0x0149, blocks: (B:52:0x00d3, B:54:0x00d9, B:56:0x00ef, B:80:0x00e2), top: B:51:0x00d3 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e2 A[Catch: OutOfMemoryError -> 0x0149, TryCatch #1 {OutOfMemoryError -> 0x0149, blocks: (B:52:0x00d3, B:54:0x00d9, B:56:0x00ef, B:80:0x00e2), top: B:51:0x00d3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void g(PhotoInfo photoInfo, String str, Handler handler) {
        String str2;
        int i3;
        int i16;
        Bitmap bitmap;
        String str3;
        boolean z16;
        boolean z17;
        Bitmap a16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("copyPicture: ");
        if (photoInfo != null) {
            str2 = photoInfo.downloadUrl;
        } else {
            str2 = "null";
        }
        sb5.append(str2);
        QLog.d("QzonePhotoUtil", 1, sb5.toString());
        Message obtain = Message.obtain();
        String str4 = "QZoneFeedxBaseShareAction";
        if (photoInfo == null) {
            obtain.what = 1;
            QZLog.i("QZoneFeedxBaseShareAction", 1, "copyPictrue-save error photoInfo == null");
            handler.sendMessage(obtain);
            return;
        }
        File q16 = q(ImageLoader.getInstance(), photoInfo);
        if (q16 == null) {
            i3 = 2;
            i16 = 1;
        } else {
            if (q16.exists()) {
                String Ua = QZoneBasePictureViewerPart.Ua(q16.getAbsolutePath());
                if (Ua == null) {
                    obtain.what = 1;
                    QZLog.i("QZoneFeedxBaseShareAction", 1, "copyPictrue-save error postfix == null");
                    handler.sendMessage(obtain);
                    return;
                }
                boolean equals = Ua.equals("webp");
                if (equals) {
                    try {
                        Bitmap decodeFile = BitmapFactory.decodeFile(q16.getAbsolutePath());
                        if (decodeFile != null) {
                            String str5 = str + (System.currentTimeMillis() + ".jpeg");
                            try {
                                z17 = com.qzone.util.image.c.V(decodeFile, str5, Bitmap.CompressFormat.JPEG, 90, true);
                                str3 = str5;
                            } catch (OutOfMemoryError e16) {
                                e = e16;
                                str3 = str5;
                                QZLog.w("QZoneFeedxBaseShareAction", "Out of Memory ", e);
                                z16 = false;
                                if (!Ua.equals("sharpp")) {
                                }
                                QZLog.i("QZoneFeedxBaseShareAction", "sharpp file");
                                try {
                                    if (!Ua.equals("sharpp")) {
                                    }
                                    if (a16 != null) {
                                    }
                                } catch (OutOfMemoryError e17) {
                                    e = e17;
                                }
                                if (!equals) {
                                }
                                if (equals) {
                                    obtain.what = 2;
                                    obtain.obj = str3;
                                }
                                handler.sendMessage(obtain);
                                return;
                            }
                        } else {
                            z17 = false;
                            str3 = null;
                        }
                        z16 = z17;
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        str3 = null;
                    }
                } else {
                    z16 = false;
                    str3 = null;
                }
                if (!Ua.equals("sharpp") || Ua.equals("avif")) {
                    QZLog.i("QZoneFeedxBaseShareAction", "sharpp file");
                    if (!Ua.equals("sharpp")) {
                        a16 = SharpPUtils.decodeSharpP(q16.getAbsolutePath());
                    } else {
                        a16 = com.tencent.qzone.image.api.a.c().a(q16, photoInfo.bigUrl, 0, 0);
                    }
                    if (a16 != null) {
                        StringBuilder sb6 = new StringBuilder();
                        try {
                            sb6.append(System.currentTimeMillis());
                            sb6.append(".jpeg");
                            String sb7 = sb6.toString();
                            String str6 = str + sb7;
                            try {
                                if (com.qzone.util.image.c.V(a16, str6, Bitmap.CompressFormat.JPEG, 90, true)) {
                                    obtain.what = 2;
                                    obtain.obj = str6;
                                    handler.sendMessage(obtain);
                                    str4 = "QZoneFeedxBaseShareAction";
                                    try {
                                        QZLog.i(str4, "------sharpp file save success:" + sb7);
                                        return;
                                    } catch (OutOfMemoryError e19) {
                                        e = e19;
                                        str3 = str6;
                                        QZLog.w(str4, "Out of Memory ", e);
                                        if (!equals) {
                                        }
                                        if (equals) {
                                        }
                                        handler.sendMessage(obtain);
                                        return;
                                    }
                                }
                                str3 = str6;
                            } catch (OutOfMemoryError e26) {
                                e = e26;
                                str4 = "QZoneFeedxBaseShareAction";
                            }
                        } catch (OutOfMemoryError e27) {
                            e = e27;
                            str4 = "QZoneFeedxBaseShareAction";
                        }
                    }
                }
                if ((!equals && !z16) || !equals) {
                    String str7 = str + (System.currentTimeMillis() + "." + Ua);
                    com.tencent.component.network.utils.FileUtils.copyFiles(new File(q16.getAbsolutePath()), new File(str7));
                    obtain.what = 2;
                    obtain.obj = str7;
                } else if (equals && z16) {
                    obtain.what = 2;
                    obtain.obj = str3;
                }
                handler.sendMessage(obtain);
                return;
            }
            i16 = 1;
            i3 = 2;
        }
        obtain.what = i16;
        QZLog.i("QZoneFeedxBaseShareAction", i16, "copyPictrue-save error file == null");
        Drawable imageByUrlInMemory = ImageManager.getInstance().getImageByUrlInMemory(photoInfo.bigUrl);
        if ((imageByUrlInMemory instanceof ImageDrawable) && (bitmap = ((ImageDrawable) imageByUrlInMemory).getBitmapRef().getBitmap()) != null && !bitmap.isRecycled()) {
            String str8 = str + (System.currentTimeMillis() + ".jpeg");
            boolean V = com.qzone.util.image.c.V(bitmap, str8, Bitmap.CompressFormat.JPEG, 90, false);
            obtain.what = V ? i3 : 1;
            if (V) {
                QZLog.i("QZoneFeedxBaseShareAction", 1, "copyPictrue-loadBitmap saveSuccess");
                obtain.obj = str8;
            }
        }
        handler.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D() {
    }

    public void m(Handler handler, ImageLoader.ImageLoadListener imageLoadListener, ImageLoader.Options options, int i3, PhotoInfo photoInfo) {
    }
}
