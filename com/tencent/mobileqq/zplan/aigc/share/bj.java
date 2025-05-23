package com.tencent.mobileqq.zplan.aigc.share;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.av.zplan.avatar.utils.ThreadUtil;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.eh;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.xhsapi.XhsShareHelper;
import com.tencent.mobileqq.zplan.aigc.SuitParentFragment;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneShareManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\b\u0006*\u0001:\u0018\u0000 $2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\u0006\u0010\u001c\u001a\u00020\u000fJD\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\u0002H\u0016J\u001e\u0010(\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&J\u000e\u0010)\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010*\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010+\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010,\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010.\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010-\u001a\u00020\u0005H\u0016J\u0012\u0010/\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u00100\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00101R\u0016\u00103\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u00102R\u0014\u00105\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u00104R\u0018\u00107\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u00106R\u0018\u00108\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00106R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010;\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/share/bj;", "Lcom/tencent/mobileqq/zplan/aigc/share/g;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, UserInfo.SEX_FEMALE, "", "dstWidth", "dstHeight", "O", "D", "H", "", "M", "Landroid/app/Activity;", "context", "", "E", "", "P", "e", "Lcom/tencent/mobileqq/zplan/aigc/share/h;", "shareWithPicView", "T", "Lcom/tencent/mobileqq/zplan/aigc/share/bk;", "data", ExifInterface.LATITUDE_SOUTH, "getData", "U", "N", "", "ugcId", "bgBitmap", "wordBitmap", "avatarBitmap", "maskBitmap", "clothBitmap", tl.h.F, "originalBitmap", "", "scale", "G", "L", "c", "b", "g", "action", "d", "a", "f", "Lcom/tencent/mobileqq/zplan/aigc/share/h;", "Lcom/tencent/mobileqq/zplan/aigc/share/bk;", "suitShareData", "I", "qrcodeSize", "Landroid/graphics/Bitmap;", "resultBitmap", "shareNoQrBitmap", "shareNoQrAndHeadBitmap", "com/tencent/mobileqq/zplan/aigc/share/bj$c", "Lcom/tencent/mobileqq/zplan/aigc/share/bj$c;", "xhsCallback", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class bj implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private h shareWithPicView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private SuitShareData suitShareData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Bitmap resultBitmap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Bitmap shareNoQrBitmap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Bitmap shareNoQrAndHeadBitmap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int qrcodeSize = ViewUtils.dip2px(328.0f);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final c xhsCallback = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/aigc/share/bj$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bitmap f330632b;

        b(Bitmap bitmap) {
            this.f330632b = bitmap;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            bj.this.P(this.f330632b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/aigc/share/bj$c", "Lcom/tencent/mobileqq/xhsapi/XhsShareHelper$e;", "", "sessionId", "", "onSuccess", "", "errorCode", "errorMessage", "", "throwable", "onError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements XhsShareHelper.e {
        c() {
        }

        @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
        public void onError(String sessionId, int errorCode, String errorMessage, Throwable throwable) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            QLog.e("SuitShareArkPresenter", 1, "shareToXHS onError " + errorCode + " " + errorMessage);
        }

        @Override // com.tencent.mobileqq.xhsapi.XhsShareHelper.e
        public void onSuccess(String sessionId) {
            QLog.i("SuitShareArkPresenter", 1, "shareToXHS onSuccess");
        }
    }

    private final Bitmap D(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap resultBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(resultBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        Paint paint = new Paint();
        paint.setColor(Color.argb(13, 0, 0, 0));
        canvas.drawRect(0.0f, 0.0f, width, height, paint);
        Intrinsics.checkNotNullExpressionValue(resultBitmap, "resultBitmap");
        return resultBitmap;
    }

    private final boolean E(Activity context) {
        if (!WXShareHelper.b0().e0()) {
            QQToast.makeText(context, context.getString(R.string.f173257ih1), 0).show();
            return false;
        }
        if (WXShareHelper.b0().f0()) {
            return true;
        }
        QQToast.makeText(context, context.getString(R.string.f173258ih2), 0).show();
        return false;
    }

    private final Bitmap F(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 73, 0, bitmap.getWidth() - 73, bitmap.getHeight());
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(bitmap, 73,\u2026idth - 73, bitmap.height)");
        return createBitmap;
    }

    private final Bitmap H() {
        SuitShareData suitShareData = this.suitShareData;
        SuitShareData suitShareData2 = null;
        if (suitShareData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
            suitShareData = null;
        }
        Resources resources = suitShareData.getApp().getApplicationContext().getResources();
        AIGCHelper aIGCHelper = AIGCHelper.f330685a;
        SuitShareData suitShareData3 = this.suitShareData;
        if (suitShareData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
            suitShareData3 = null;
        }
        com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.u e16 = com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.u.f().i("https://ti.qq.com/new_open_qq/index.html?appid=42&url=" + URLEncoder.encode(aIGCHelper.a(suitShareData3.getUgcId(), SuitParentFragment.AigcSuitPreviewFromValue.SCHEME.getValue()), "UTF-8")).h(this.qrcodeSize).f(-16777216).g(BitmapFactory.decodeResource(resources, R.drawable.ihj)).e();
        SuitShareData suitShareData4 = this.suitShareData;
        if (suitShareData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
        } else {
            suitShareData2 = suitShareData4;
        }
        Bitmap i3 = com.tencent.sqshow.zootopia.nativeui.view.dialog.actionsheet.t.i(suitShareData2.getApp().getApplicationContext(), e16);
        Intrinsics.checkNotNullExpressionValue(i3, "getQrCodeImg(suitShareDa\u2026ionContext, qrCodeParams)");
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(long j3, Bitmap resultForLittleWorld) {
        Intrinsics.checkNotNullParameter(resultForLittleWorld, "$resultForLittleWorld");
        com.tencent.mobileqq.zplan.aigc.share.b bVar = com.tencent.mobileqq.zplan.aigc.share.b.f330597a;
        bVar.c(resultForLittleWorld, "temp_suit_share_" + j3 + "_0_0.png", "suit_cache_dir");
        bVar.j(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(long j3, Bitmap copy1) {
        com.tencent.mobileqq.zplan.aigc.share.b bVar = com.tencent.mobileqq.zplan.aigc.share.b.f330597a;
        Intrinsics.checkNotNullExpressionValue(copy1, "copy1");
        bVar.c(copy1, "temp_suit_share_" + j3 + "_1_0.png", "suit_cache_dir");
        bVar.k(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(long j3, Bitmap result) {
        com.tencent.mobileqq.zplan.aigc.share.b bVar = com.tencent.mobileqq.zplan.aigc.share.b.f330597a;
        Intrinsics.checkNotNullExpressionValue(result, "result");
        bVar.c(result, "temp_suit_share_" + j3 + "_2_0.png", "suit_cache_dir");
        bVar.i(true);
    }

    private final String M() {
        SuitShareData suitShareData = this.suitShareData;
        SuitShareData suitShareData2 = null;
        if (suitShareData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
            suitShareData = null;
        }
        IFriendNameService iFriendNameService = (IFriendNameService) suitShareData.getApp().getRuntimeService(IFriendNameService.class, "all");
        SuitShareData suitShareData3 = this.suitShareData;
        if (suitShareData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
        } else {
            suitShareData2 = suitShareData3;
        }
        String friendNick = iFriendNameService.getFriendNick(suitShareData2.getApp().getCurrentUin());
        Intrinsics.checkNotNullExpressionValue(friendNick, "suitShareData.app\n      \u2026ShareData.app.currentUin)");
        return friendNick;
    }

    private final Bitmap O(Bitmap bitmap, int dstWidth, int dstHeight) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        if (height * 4 < dstHeight) {
            float f16 = dstHeight / height;
            matrix.postScale(f16, f16, width / 2.0f, height / 2.0f);
        } else {
            matrix.postScale(4.0f, 4.0f, width / 2.0f, height / 2.0f);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        Bitmap croppedBitmap = Bitmap.createBitmap(createBitmap, (createBitmap.getWidth() / 2) - (dstWidth / 2), (createBitmap.getHeight() / 2) - (dstHeight / 2), dstWidth, dstHeight);
        eh.a(croppedBitmap, 100);
        Intrinsics.checkNotNullExpressionValue(croppedBitmap, "croppedBitmap");
        return D(croppedBitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(final Bitmap bitmap) {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.bg
            @Override // java.lang.Runnable
            public final void run() {
                bj.Q(bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x012e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Q(Bitmap bitmap) {
        OutputStream outputStream;
        OutputStream openOutputStream;
        StringBuilder sb5;
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        final boolean z16 = false;
        final Uri uri = null;
        OutputStream outputStream2 = null;
        if (!bitmap.isRecycled()) {
            Uri EXTERNAL_CONTENT_URI = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intrinsics.checkNotNullExpressionValue(EXTERNAL_CONTENT_URI, "EXTERNAL_CONTENT_URI");
            ContentResolver contentResolver = BaseApplication.getContext().getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContext().contentResolver");
            String str = "zplan_share_suit_poster_" + String.valueOf(System.currentTimeMillis());
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", str);
            contentValues.put(InputMethodUtil.SOUGOU_URI_DISPLAYNAME, str);
            contentValues.put(JobDbManager.COL_UP_MIME_TYPE, "image/jpeg");
            Uri insert = contentResolver.insert(EXTERNAL_CONTENT_URI, contentValues);
            try {
                if (insert != null) {
                    try {
                        openOutputStream = contentResolver.openOutputStream(insert);
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        outputStream = null;
                        QLog.e("SuitShareArkPresenter", 1, "saveToLocalInner, error = " + e);
                        if (outputStream != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitShareArkPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.az
                            @Override // java.lang.Runnable
                            public final void run() {
                                bj.R(z16, uri);
                            }
                        });
                    } catch (IllegalStateException e17) {
                        e = e17;
                        outputStream = null;
                        QLog.e("SuitShareArkPresenter", 1, "saveToLocalInner, error = " + e);
                        if (outputStream != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitShareArkPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.az
                            @Override // java.lang.Runnable
                            public final void run() {
                                bj.R(z16, uri);
                            }
                        });
                    } catch (OutOfMemoryError e18) {
                        e = e18;
                        outputStream = null;
                        QLog.e("SuitShareArkPresenter", 1, "saveToLocalInner, error = " + e);
                        if (outputStream != null) {
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitShareArkPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.az
                            @Override // java.lang.Runnable
                            public final void run() {
                                bj.R(z16, uri);
                            }
                        });
                    } catch (Throwable th5) {
                        th = th5;
                        if (outputStream2 != null) {
                        }
                        throw th;
                    }
                } else {
                    openOutputStream = null;
                }
                if (openOutputStream != null) {
                    try {
                        z16 = bitmap.compress(Bitmap.CompressFormat.PNG, 75, openOutputStream);
                    } catch (FileNotFoundException e19) {
                        outputStream = openOutputStream;
                        e = e19;
                        QLog.e("SuitShareArkPresenter", 1, "saveToLocalInner, error = " + e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e26) {
                                e = e26;
                                sb5 = new StringBuilder();
                                sb5.append("saveToLocalInner finally, error = ");
                                sb5.append(e);
                                QLog.e("SuitShareArkPresenter", 1, sb5.toString());
                                if (!z16) {
                                }
                                uri = insert;
                                QLog.d("SuitShareArkPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.az
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        bj.R(z16, uri);
                                    }
                                });
                            }
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitShareArkPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.az
                            @Override // java.lang.Runnable
                            public final void run() {
                                bj.R(z16, uri);
                            }
                        });
                    } catch (IllegalStateException e27) {
                        outputStream = openOutputStream;
                        e = e27;
                        QLog.e("SuitShareArkPresenter", 1, "saveToLocalInner, error = " + e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e28) {
                                e = e28;
                                sb5 = new StringBuilder();
                                sb5.append("saveToLocalInner finally, error = ");
                                sb5.append(e);
                                QLog.e("SuitShareArkPresenter", 1, sb5.toString());
                                if (!z16) {
                                }
                                uri = insert;
                                QLog.d("SuitShareArkPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.az
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        bj.R(z16, uri);
                                    }
                                });
                            }
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitShareArkPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.az
                            @Override // java.lang.Runnable
                            public final void run() {
                                bj.R(z16, uri);
                            }
                        });
                    } catch (OutOfMemoryError e29) {
                        outputStream = openOutputStream;
                        e = e29;
                        QLog.e("SuitShareArkPresenter", 1, "saveToLocalInner, error = " + e);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e36) {
                                e = e36;
                                sb5 = new StringBuilder();
                                sb5.append("saveToLocalInner finally, error = ");
                                sb5.append(e);
                                QLog.e("SuitShareArkPresenter", 1, sb5.toString());
                                if (!z16) {
                                    QLog.e("SuitShareArkPresenter", 1, "saveToLocalInner delete file:" + insert);
                                    py3.b.e(contentResolver, insert, null, null);
                                }
                                uri = insert;
                                QLog.d("SuitShareArkPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.az
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        bj.R(z16, uri);
                                    }
                                });
                            }
                        }
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitShareArkPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.az
                            @Override // java.lang.Runnable
                            public final void run() {
                                bj.R(z16, uri);
                            }
                        });
                    } catch (Throwable th6) {
                        th = th6;
                        outputStream2 = openOutputStream;
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e37) {
                                QLog.e("SuitShareArkPresenter", 1, "saveToLocalInner finally, error = " + e37);
                            }
                        }
                        throw th;
                    }
                }
                if (openOutputStream != null) {
                    try {
                        openOutputStream.close();
                    } catch (IOException e38) {
                        e = e38;
                        sb5 = new StringBuilder();
                        sb5.append("saveToLocalInner finally, error = ");
                        sb5.append(e);
                        QLog.e("SuitShareArkPresenter", 1, sb5.toString());
                        if (!z16) {
                        }
                        uri = insert;
                        QLog.d("SuitShareArkPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.az
                            @Override // java.lang.Runnable
                            public final void run() {
                                bj.R(z16, uri);
                            }
                        });
                    }
                }
                if (!z16 && insert != null) {
                    QLog.e("SuitShareArkPresenter", 1, "saveToLocalInner delete file:" + insert);
                    py3.b.e(contentResolver, insert, null, null);
                }
                uri = insert;
            } catch (Throwable th7) {
                th = th7;
                outputStream2 = outputStream;
            }
        }
        QLog.d("SuitShareArkPresenter", 1, "bitmap:" + bitmap + ", bitmap.isRecycled:" + bitmap.isRecycled());
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.az
            @Override // java.lang.Runnable
            public final void run() {
                bj.R(z16, uri);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(final bj this$0, Bitmap bitmap, final Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            SuitShareData suitShareData = this$0.suitShareData;
            if (suitShareData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
                suitShareData = null;
            }
            final String c16 = com.tencent.mobileqq.zplan.aigc.share.b.f330597a.c(bitmap, "temp_suit_share_" + suitShareData.getUgcId() + "_0_1.png", "suit_cache_dir");
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.ax
                @Override // java.lang.Runnable
                public final void run() {
                    bj.X(c16, this$0, activity);
                }
            });
        } catch (OutOfMemoryError unused) {
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.ay
                @Override // java.lang.Runnable
                public final void run() {
                    bj.W();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(String str, bj this$0, Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str == null || str.length() == 0) {
            QQToastUtil.showQQToast(1, R.string.xlf);
            return;
        }
        AIGCHelper aIGCHelper = AIGCHelper.f330685a;
        SuitShareData suitShareData = this$0.suitShareData;
        SuitShareData suitShareData2 = null;
        if (suitShareData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
            suitShareData = null;
        }
        String encode = URLEncoder.encode(aIGCHelper.a(suitShareData.getUgcId(), SuitParentFragment.AigcSuitPreviewFromValue.LITTLE_WORLD.getValue()), "UTF-8");
        String str2 = ("mqqapi://qcircle/openqqpublish?mediaPath=" + str + "&target=3") + "&tag=\u8d85\u7ea7QQ\u79c0\u9b54\u6cd5\u670d\u88c5\u5de5\u574a";
        SuitShareData suitShareData3 = this$0.suitShareData;
        if (suitShareData3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
            suitShareData3 = null;
        }
        String name = suitShareData3.getName();
        SuitShareData suitShareData4 = this$0.suitShareData;
        if (suitShareData4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
        } else {
            suitShareData2 = suitShareData4;
        }
        String str3 = (((str2 + "&content=" + name + ", " + suitShareData2.getPrompt()) + "&WINK_PUBLISH_TASK_ID=zplan-AIdesign") + "&tianshu_activity_item_value=1") + "&task_jump_url=" + encode;
        QLog.i("SuitShareArkPresenter", 1, "shareToLittleWorld schemeUrl:" + str3);
        QCircleSchemeLauncher.d(activity, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(bj this$0, Bitmap bitmap, final Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            SuitShareData suitShareData = this$0.suitShareData;
            if (suitShareData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
                suitShareData = null;
            }
            final String c16 = com.tencent.mobileqq.zplan.aigc.share.b.f330597a.c(bitmap, "temp_suit_share_" + suitShareData.getUgcId() + "_2_1.png", "suit_cache_dir");
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.bi
                @Override // java.lang.Runnable
                public final void run() {
                    bj.Z(c16, activity);
                }
            });
        } catch (OutOfMemoryError unused) {
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.aq
                @Override // java.lang.Runnable
                public final void run() {
                    bj.a0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(final bj this$0, Bitmap bitmap, final Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            SuitShareData suitShareData = this$0.suitShareData;
            if (suitShareData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
                suitShareData = null;
            }
            final String c16 = com.tencent.mobileqq.zplan.aigc.share.b.f330597a.c(bitmap, "temp_suit_share_" + suitShareData.getUgcId() + "_2_1.png", "suit_cache_dir");
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.at
                @Override // java.lang.Runnable
                public final void run() {
                    bj.c0(c16, this$0, activity);
                }
            });
        } catch (OutOfMemoryError unused) {
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.au
                @Override // java.lang.Runnable
                public final void run() {
                    bj.d0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(String str, bj this$0, Activity activity) {
        List listOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str == null || str.length() == 0) {
            QQToastUtil.showQQToast(1, R.string.xlf);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QQToastUtil.showQQToast(1, R.string.hiu);
            QLog.e("SuitShareArkPresenter", 1, "shareToQZone failed\uff0c appRuntime is null!");
            return;
        }
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        userInfo.qzone_uin = peekAppRuntime.getAccount();
        Intent intent = new Intent();
        AIGCHelper aIGCHelper = AIGCHelper.f330685a;
        SuitShareData suitShareData = this$0.suitShareData;
        if (suitShareData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
            suitShareData = null;
        }
        String a16 = aIGCHelper.a(suitShareData.getUgcId(), SuitParentFragment.AigcSuitPreviewFromValue.QZONE.getValue());
        intent.putExtra(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_APPID, "qzevent_6");
        intent.putExtra(QZoneShareManager.QZONE_SHARE_THIRD_PARTY_URL, a16);
        String str2 = userInfo.qzone_uin;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(str);
        QZoneHelper.forwardToWriteMood(activity, str2, "\u6211\u5728\u9b54\u6cd5\u670d\u88c5\u5de5\u574a\u521b\u4f5c\u4e86\u4e00\u4ef6\u670d\u88c5\uff0c\u5feb\u6765\u56f4\u89c2\u5427", new ArrayList(listOf), null, null, 20001, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(bj this$0, final Bitmap bitmap, final int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            SuitShareData suitShareData = this$0.suitShareData;
            if (suitShareData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
                suitShareData = null;
            }
            final String c16 = com.tencent.mobileqq.zplan.aigc.share.b.f330597a.c(bitmap, "temp_suit_share_" + suitShareData.getUgcId() + "_1_1.png", "suit_cache_dir");
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.ar
                @Override // java.lang.Runnable
                public final void run() {
                    bj.f0(c16, i3, bitmap);
                }
            });
        } catch (OutOfMemoryError unused) {
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.as
                @Override // java.lang.Runnable
                public final void run() {
                    bj.g0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(final bj this$0, Bitmap bitmap, final Activity activity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            SuitShareData suitShareData = this$0.suitShareData;
            if (suitShareData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
                suitShareData = null;
            }
            String c16 = com.tencent.mobileqq.zplan.aigc.share.b.f330597a.c(bitmap, "temp_suit_share_" + suitShareData.getUgcId() + "_1_1.png", "suit_cache_dir");
            final File file = c16 != null ? new File(c16) : null;
            final Boolean valueOf = file != null ? Boolean.valueOf(file.exists()) : null;
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.av
                @Override // java.lang.Runnable
                public final void run() {
                    bj.i0(valueOf, activity, file, this$0);
                }
            });
        } catch (OutOfMemoryError unused) {
            ThreadUtil.f77341a.d(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.aw
                @Override // java.lang.Runnable
                public final void run() {
                    bj.j0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(Boolean bool, Activity activity, File file, bj this$0) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
            QQToastUtil.showQQToast(1, R.string.xlf);
            return;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QQToastUtil.showQQToast(1, R.string.hiu);
            QLog.e("SuitShareArkPresenter", 1, "shareToXHS failed\uff0c appRuntime is null!");
            return;
        }
        XhsShareHelper xhsShareHelper = new XhsShareHelper();
        if (xhsShareHelper.i("AIGC suit share", activity)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new XhsShareHelper.c(file, null, null));
            xhsShareHelper.l("AIGC suit share", new WeakReference<>(activity), new XhsShareHelper.b("", "", arrayListOf), new WeakReference<>(this$0.xhsCallback));
        } else {
            QLog.e("SuitShareArkPresenter", 1, "shareToXHS failed\uff0c no support");
        }
    }

    public final Bitmap G(Bitmap originalBitmap, Bitmap maskBitmap, float scale) {
        Intrinsics.checkNotNullParameter(originalBitmap, "originalBitmap");
        Intrinsics.checkNotNullParameter(maskBitmap, "maskBitmap");
        Bitmap croppedBitmap = Bitmap.createBitmap(originalBitmap.getWidth(), originalBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(croppedBitmap);
        Paint paint = new Paint(1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(originalBitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(maskBitmap, 0.0f, scale * (-26.0f), paint);
        Intrinsics.checkNotNullExpressionValue(croppedBitmap, "croppedBitmap");
        return croppedBitmap;
    }

    public final Bitmap L(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap outputBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(outputBitmap);
        Paint paint = new Paint(1);
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        Paint paint2 = new Paint(1);
        paint2.setColor(-16777216);
        float f16 = width / 2.0f;
        canvas2.drawCircle(f16, height / 2.0f, f16, paint2);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
        Intrinsics.checkNotNullExpressionValue(outputBitmap, "outputBitmap");
        return outputBitmap;
    }

    public final boolean N() {
        h hVar = this.shareWithPicView;
        if (hVar != null) {
            return hVar.isShowing();
        }
        return false;
    }

    public void S(SuitShareData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.suitShareData = data;
    }

    public void T(h shareWithPicView) {
        Intrinsics.checkNotNullParameter(shareWithPicView, "shareWithPicView");
        this.shareWithPicView = shareWithPicView;
    }

    public void U() {
        h hVar = this.shareWithPicView;
        if (hVar != null) {
            hVar.show();
        }
        h hVar2 = this.shareWithPicView;
        if (hVar2 != null) {
            hVar2.a(this.resultBitmap);
        }
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.g
    public void e(Bitmap bitmap) {
        this.resultBitmap = bitmap;
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.g
    public SuitShareData getData() {
        SuitShareData suitShareData = this.suitShareData;
        if (suitShareData != null) {
            return suitShareData;
        }
        Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
        return null;
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.g
    public void a(final Activity context) {
        if (context == null) {
            QLog.e("SuitShareArkPresenter", 1, "share to XHS failed");
            return;
        }
        final Bitmap bitmap = this.resultBitmap;
        if (bitmap == null) {
            QLog.e("SuitShareArkPresenter", 1, "shareToWeChat failed, shareNoQrBitmap is null!");
        } else {
            ThreadUtil.f77341a.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.bd
                @Override // java.lang.Runnable
                public final void run() {
                    bj.h0(bj.this, bitmap, context);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.g
    public void b(final Activity context) {
        if (context == null) {
            QLog.e("SuitShareArkPresenter", 1, "shareToQZone failed, activity is null!");
            return;
        }
        final Bitmap bitmap = this.resultBitmap;
        if (bitmap == null) {
            QLog.e("SuitShareArkPresenter", 1, "shareToQZone failed, resultBitmap is null!");
        } else {
            ThreadUtil.f77341a.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.bh
                @Override // java.lang.Runnable
                public final void run() {
                    bj.b0(bj.this, bitmap, context);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.g
    public void c(final Activity context) {
        if (context == null) {
            QLog.e("SuitShareArkPresenter", 1, "shareToQQ failed, activity is null!");
            return;
        }
        final Bitmap bitmap = this.resultBitmap;
        if (bitmap == null) {
            QLog.e("SuitShareArkPresenter", 1, "shareToQQ failed, resultBitmap is null!");
        } else {
            ThreadUtil.f77341a.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.bc
                @Override // java.lang.Runnable
                public final void run() {
                    bj.Y(bj.this, bitmap, context);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.g
    public void d(Activity context, final int action) {
        if (context != null && E(context)) {
            final Bitmap bitmap = this.resultBitmap;
            if (bitmap == null) {
                QLog.e("SuitShareArkPresenter", 1, "shareToWeChat failed, shareNoQrBitmap is null!");
                return;
            } else {
                ThreadUtil.f77341a.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.bf
                    @Override // java.lang.Runnable
                    public final void run() {
                        bj.e0(bj.this, bitmap, action);
                    }
                });
                return;
            }
        }
        QLog.e("SuitShareArkPresenter", 1, "shareToWeChat failed");
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.g
    public void g(final Activity context) {
        if (context == null) {
            QLog.e("SuitShareArkPresenter", 1, "shareToLittleWorld failed");
            return;
        }
        final Bitmap bitmap = this.shareNoQrAndHeadBitmap;
        if (bitmap == null) {
            QLog.e("SuitShareArkPresenter", 1, "shareToLittleWorld failed, shareNoQrAndHeadBitmap is null!");
        } else {
            ThreadUtil.f77341a.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.be
                @Override // java.lang.Runnable
                public final void run() {
                    bj.V(bj.this, bitmap, context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(boolean z16, Uri uri) {
        if (z16) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uri);
            BaseApplication.getContext().sendBroadcast(intent);
            QQToast.makeText(BaseApplication.getContext(), 2, BaseApplication.getContext().getString(R.string.xbt), 1).show();
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 1, R.string.xs7, 1).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(String str, Activity activity) {
        if (str == null || str.length() == 0) {
            QQToastUtil.showQQToast(1, R.string.xlf);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, str);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, str);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ((IForwardOption) QRoute.api(IForwardOption.class)).startForwardActivityForResult(activity, intent, 21);
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.g
    public void f(Activity context) {
        if (context == null) {
            QLog.e("SuitShareArkPresenter", 1, "saveToLocal failed");
            return;
        }
        Bitmap bitmap = this.resultBitmap;
        if (bitmap == null) {
            QQToastUtil.showQQToast(1, R.string.cwi);
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(QBaseActivity.sTopActivity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QR_DISPLAY, QQPermissionConstants.Business.SCENE.QR_DISPLAY));
        if (qQPermission == null) {
            return;
        }
        if (qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            P(bitmap);
        } else {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new b(bitmap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W() {
        QQToastUtil.showQQToast(1, R.string.xlg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0() {
        QQToastUtil.showQQToast(1, R.string.xlg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0() {
        QQToastUtil.showQQToast(1, R.string.xlg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(String str, int i3, Bitmap bitmap) {
        if (str == null || str.length() == 0) {
            QQToastUtil.showQQToast(1, R.string.xlf);
            return;
        }
        if (i3 == 9) {
            WXShareHelper.b0().u0(str, bitmap, 0);
            return;
        }
        if (i3 != 10) {
            QLog.d("SuitShareArkPresenter", 1, "[shareToWeChat] unexpected action:" + i3);
            return;
        }
        WXShareHelper.b0().u0(str, bitmap, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0() {
        QQToastUtil.showQQToast(1, R.string.xlg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0() {
        QQToastUtil.showQQToast(1, R.string.xlg);
    }

    @Override // com.tencent.mobileqq.zplan.aigc.share.g
    public Bitmap h(final long ugcId, Bitmap bgBitmap, Bitmap wordBitmap, Bitmap avatarBitmap, Bitmap maskBitmap, Bitmap clothBitmap) {
        if (bgBitmap == null) {
            return null;
        }
        Bitmap O = O(bgBitmap, 900, 1470);
        int width = O.getWidth();
        float f16 = width / 300.0f;
        final Bitmap createBitmap = Bitmap.createBitmap(width, O.getHeight(), O.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(O, 0.0f, 0.0f, (Paint) null);
        if (wordBitmap != null) {
            canvas.drawBitmap(Bitmap.createScaledBitmap(wordBitmap, 900, 1470, true), 0.0f, 0.0f, (Paint) null);
        }
        if (avatarBitmap != null) {
            Bitmap scaledAvatarBitmap = Bitmap.createScaledBitmap(avatarBitmap, (int) ((1320.0f / avatarBitmap.getHeight()) * avatarBitmap.getWidth()), gdt_analysis_event.EVENT_QUERY_URL_BY_CGI_FAILED, true);
            Intrinsics.checkNotNullExpressionValue(scaledAvatarBitmap, "scaledAvatarBitmap");
            if (maskBitmap != null) {
                scaledAvatarBitmap = G(scaledAvatarBitmap, maskBitmap, f16);
            }
            canvas.drawBitmap(scaledAvatarBitmap, 7.0f * f16, 21.6f * f16, (Paint) null);
        }
        if (clothBitmap != null) {
            canvas.drawBitmap(Bitmap.createScaledBitmap(clothBitmap, 195, 195, true), (width - r5.getWidth()) - (17 * f16), 139.0f * f16, (Paint) null);
        }
        Bitmap copy0 = createBitmap.copy(createBitmap.getConfig(), true);
        Intrinsics.checkNotNullExpressionValue(copy0, "copy0");
        final Bitmap F = F(copy0);
        this.shareNoQrAndHeadBitmap = F;
        ThreadUtil threadUtil = ThreadUtil.f77341a;
        threadUtil.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.ap
            @Override // java.lang.Runnable
            public final void run() {
                bj.I(ugcId, F);
            }
        });
        SuitShareData suitShareData = this.suitShareData;
        if (suitShareData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("suitShareData");
            suitShareData = null;
        }
        Drawable qqHeadDrawable = suitShareData.getQqHeadDrawable();
        if (qqHeadDrawable != null) {
            Bitmap createBitmap2 = Bitmap.createBitmap(qqHeadDrawable.getIntrinsicWidth(), qqHeadDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            qqHeadDrawable.setBounds(0, 0, canvas2.getWidth(), canvas2.getHeight());
            qqHeadDrawable.draw(canvas2);
            Bitmap scaledHeadBitmap = Bitmap.createScaledBitmap(createBitmap2, 150, 150, true);
            Intrinsics.checkNotNullExpressionValue(scaledHeadBitmap, "scaledHeadBitmap");
            float f17 = 14 * f16;
            canvas.drawBitmap(L(scaledHeadBitmap), f17, (r12 - r4.getHeight()) - f17, (Paint) null);
        }
        String M = M();
        if (M.codePointCount(0, M.length()) > 6) {
            String substring = M.substring(0, M.offsetByCodePoints(0, 6));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            M = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#000000"));
        paint.setTextSize(12 * f16);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        float f18 = 72 * f16;
        float f19 = ((r12 - 150) - (14 * f16)) + (16 * f16);
        canvas.drawText(M, f18, f19, paint);
        Paint paint2 = new Paint();
        paint2.setColor(Color.parseColor("#595959"));
        float f26 = 9 * f16;
        paint2.setTextSize(f26);
        canvas.drawText("\u8fd9\u662f\u6211\u7684\u9b54\u6cd5\u521b\u4f5c\uff0c\u4f60\u4e5f\u6765", f18, (17 * f16) + f19, paint2);
        Paint paint3 = new Paint();
        paint3.setColor(Color.parseColor("#595959"));
        paint3.setTextSize(f26);
        canvas.drawText("\u9b54\u6cd5\u5de5\u574a\u8bd5\u4e00\u4e0b\u5427\uff01", f18, f19 + (30 * f16), paint3);
        final Bitmap copy = createBitmap.copy(createBitmap.getConfig(), true);
        this.shareNoQrBitmap = copy;
        threadUtil.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.ba
            @Override // java.lang.Runnable
            public final void run() {
                bj.J(ugcId, copy);
            }
        });
        Bitmap scaledQrBitmap = Bitmap.createScaledBitmap(H(), 210, 210, true);
        com.tencent.mobileqq.zplan.aigc.share.b bVar = com.tencent.mobileqq.zplan.aigc.share.b.f330597a;
        Intrinsics.checkNotNullExpressionValue(scaledQrBitmap, "scaledQrBitmap");
        canvas.drawBitmap(bVar.b(scaledQrBitmap, -1, 11 * f16, 1.14f), (float) ((width - r3.getWidth()) - (f16 * 10.5d)), (r12 - r3.getHeight()) - (10 * f16), (Paint) null);
        threadUtil.c(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.share.bb
            @Override // java.lang.Runnable
            public final void run() {
                bj.K(ugcId, createBitmap);
            }
        });
        return createBitmap;
    }
}
