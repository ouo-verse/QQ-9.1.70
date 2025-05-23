package com.qzone.reborn.repair.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.qzone.common.account.LoginData;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.wink.api.IWinkMediaHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.PhotoInfo;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002J*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004J\u0018\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u0018J\u001a\u0010\u001c\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u001a\u0010\u001d\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u001a\u0010\u001e\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\"\u0010 \u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020\u0004J\"\u0010#\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\"\u001a\u00020!2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020!R\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0017\u0010+\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/qzone/reborn/repair/utils/o;", "", "Landroid/content/Context;", "context", "", "r", "", "Lcom/tencent/mobileqq/component/qrcode/f;", "p", "icon", "msg", "", "J", "picWidth", "picHeight", "Lkotlin/Pair;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "codeView", "Lcom/tencent/mobileqq/component/qrcode/g;", "callback", "o", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "G", "shareAction", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/layer/share/f;", "shareContext", "w", ReportConstant.COSTREPORT_PREFIX, "b", "I", "CONTAINER_MARGIN_DP", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()I", "PREVIEW_VIEW_BOTTOM_AREA_HEIGHT", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f59329a = new o();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int CONTAINER_MARGIN_DP = ImmersiveUtils.dpToPx(32.0f);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final int PREVIEW_VIEW_BOTTOM_AREA_HEIGHT = ImmersiveUtils.dpToPx(60.0f);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/repair/utils/o$a", "Lcom/tencent/mobileqq/component/qrcode/a;", "", "color", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a extends com.tencent.mobileqq.component.qrcode.a {
        a(List<com.tencent.mobileqq.component.qrcode.f> list) {
            super(list);
        }

        @Override // com.tencent.mobileqq.component.qrcode.a
        public List<Integer> a(int color) {
            int collectionSizeOrDefault;
            List<com.tencent.mobileqq.component.qrcode.f> b16 = b();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (com.tencent.mobileqq.component.qrcode.f fVar : b16) {
                vd0.b b17 = vd0.b.b(color);
                arrayList.add(Integer.valueOf(vd0.b.a(b17.d(), b17.c(), b17.e()).i()));
            }
            return arrayList;
        }
    }

    o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(final Activity activity, Bitmap bitmap) {
        final String m3 = f59329a.m(activity, bitmap);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.m
            @Override // java.lang.Runnable
            public final void run() {
                o.B(m3, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(String str, Activity activity) {
        if (TextUtils.isEmpty(str)) {
            f59329a.J(1, R.string.byy);
            return;
        }
        QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        userInfo.qzone_uin = peekAppRuntime != null ? peekAppRuntime.getAccount() : null;
        QZoneHelper.forwardToPublishMood(activity, userInfo, str, com.qzone.util.l.a(R.string.i1w), "", QZoneContant.REQUEST_CODE_PHOTO_REPAIR_SHARE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(BaseResp baseResp) {
        if (baseResp.errCode != 0) {
            f59329a.J(1, R.string.f171047bz3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Activity activity, final Bitmap bitmap, final int i3) {
        final String m3 = f59329a.m(activity, bitmap);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.n
            @Override // java.lang.Runnable
            public final void run() {
                o.F(m3, i3, bitmap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(String str, int i3, Bitmap bitmap) {
        if (TextUtils.isEmpty(str)) {
            f59329a.J(1, R.string.byy);
        } else if (i3 == 9) {
            WXShareHelper.b0().u0(str, bitmap, 0);
        } else {
            if (i3 != 10) {
                return;
            }
            WXShareHelper.b0().u0(str, bitmap, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(final Activity activity, Bitmap bitmap) {
        final String m3 = f59329a.m(activity, bitmap);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.k
            @Override // java.lang.Runnable
            public final void run() {
                o.I(m3, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(String str, Activity activity) {
        if (TextUtils.isEmpty(str)) {
            f59329a.J(1, R.string.byy);
        } else {
            com.qzone.business.share.d.f44790a.h(activity, str);
        }
    }

    private final void J(final int icon, final int msg2) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.repair.utils.d
            @Override // java.lang.Runnable
            public final void run() {
                o.K(icon, msg2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(int i3, int i16) {
        try {
            com.tencent.biz.qrcode.util.h.T(i3, i16);
        } catch (Exception e16) {
            QLog.d("QZonePhotoRepairSharePreviewHelper", 1, "showQQToast error: " + e16.getMessage());
        }
    }

    private final int r(Context context) {
        return pl.a.f426446a.o(context) - (CONTAINER_MARGIN_DP * 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(final Activity activity, Bitmap bitmap) {
        final String m3 = f59329a.m(activity, bitmap);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.e
            @Override // java.lang.Runnable
            public final void run() {
                o.v(m3, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(String str, Activity activity) {
        if (TextUtils.isEmpty(str)) {
            f59329a.J(1, R.string.byy);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, str);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, str);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, str);
        bundle.putBoolean("key_flag_from_plugin", true);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, str);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ForwardBaseOption.startForwardActivityForResult(activity, intent, (Class<?>) ForwardRecentActivity.class, 21, -1, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final Activity activity, Bitmap bitmap, final com.qzone.reborn.layer.share.f shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        final String m3 = f59329a.m(activity, bitmap);
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.l
            @Override // java.lang.Runnable
            public final void run() {
                o.y(m3, shareContext, activity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(String str, com.qzone.reborn.layer.share.f shareContext, Activity activity) {
        Intrinsics.checkNotNullParameter(shareContext, "$shareContext");
        if (TextUtils.isEmpty(str)) {
            f59329a.J(1, R.string.byy);
            return;
        }
        if (!((IWinkMediaHelper) QRoute.api(IWinkMediaHelper.class)).isSupportImageFormat(new File(str))) {
            f59329a.J(1, R.string.hit);
            return;
        }
        ho.i.q(activity, "mqqapi://qcircle/openqqpublish?target=3&exit_dialog=1&mediaPath=" + str + "&xsj_camera_clck_ref_pgid=" + f59329a.s(shareContext));
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String m(Activity activity, Bitmap bitmap) {
        BufferedOutputStream bufferedOutputStream;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        BufferedOutputStream bufferedOutputStream2 = null;
        if (activity == null) {
            return null;
        }
        String str = "photo_repair_share_" + System.currentTimeMillis() + LoginData.getInstance().getUin() + ".jpg";
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(new File(AppConstants.SDCARD_PATH, "repair").getAbsolutePath()));
        file.mkdirs();
        if (file.canWrite()) {
            File file2 = new File(file.getAbsolutePath(), str);
            String absolutePath = file2.getAbsolutePath();
            if (file2.exists()) {
                file2.delete();
            }
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Exception e16) {
                e = e16;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (bufferedOutputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e17) {
                        QLog.e("QZonePhotoRepairSharePreviewHelper", 1, e17.getMessage());
                    }
                    return absolutePath;
                } catch (Throwable th6) {
                    th = th6;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Exception e18) {
                            QLog.e("QZonePhotoRepairSharePreviewHelper", 1, e18.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e = e19;
                QLog.e("QZonePhotoRepairSharePreviewHelper", 1, e.getMessage());
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e26) {
                        QLog.e("QZonePhotoRepairSharePreviewHelper", 1, e26.getMessage());
                    }
                }
                return null;
            }
        }
        return null;
    }

    public final Pair<Integer, Integer> n(Context context, int picWidth, int picHeight) {
        Intrinsics.checkNotNullParameter(context, "context");
        int o16 = pl.a.f426446a.o(context);
        int r16 = r(context);
        float f16 = o16;
        int i3 = (int) (1.0666667f * f16);
        int i16 = (int) (0.6933333f * f16);
        int i17 = (int) (f16 * 0.296f);
        if (picWidth > 0 && picHeight > 0) {
            float f17 = (picHeight * 1.0f) / picWidth;
            int i18 = picWidth > r16 ? r16 : picWidth < i16 ? i16 : picWidth;
            int i19 = (int) (i18 * f17);
            if (picHeight > i3 || i19 > i3) {
                i19 = i3;
            } else if (picHeight < i17 || i19 < i17) {
                i19 = i17;
            }
            QLog.i("QZonePhotoRepairSharePreviewHelper", 1, "calculatePicWH picWidth:" + picWidth + " picHeight:" + picHeight + ", maxWidth:" + r16 + " maxHeight:" + i3 + ", minWidth:" + i16 + " minHeight:" + i17 + ", realWidth:" + i18 + " realHeight:" + i19);
            return new Pair<>(Integer.valueOf(i18), Integer.valueOf(i19));
        }
        QLog.e("QZonePhotoRepairSharePreviewHelper", 1, "calculatePicWH picWidth:" + picWidth + " picHeight:" + picHeight);
        return new Pair<>(Integer.valueOf(r16), Integer.valueOf(i3));
    }

    public final void o(QUIColorfulQRCodeView codeView, com.tencent.mobileqq.component.qrcode.g callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (codeView == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(8, new com.tencent.mobileqq.component.qrcode.d(13, 11, 12.0f, 0.3f));
        hashMap.put(9, new com.tencent.mobileqq.component.qrcode.d(14, 12, 12.0f, 0.3f));
        codeView.q();
        codeView.e(false);
        codeView.setIsAdjustDarkLogo(false);
        codeView.setTargetGenerateQRCodeParams(new com.tencent.mobileqq.component.qrcode.e(8, 9, hashMap, ErrorCorrectionLevel.Q));
        codeView.k(-16777216, new a(f59329a.p()));
        codeView.f("https://ti.qq.com/open_qq/index.html?v=40517&hb=1&ac=1&url=mqzone%3A%2F%2Farouse%2Fphotorepair%2Fmainpage", callback);
    }

    public final int q() {
        return PREVIEW_VIEW_BOTTOM_AREA_HEIGHT;
    }

    public final String s(com.qzone.reborn.layer.share.f shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        PhotoInfo photoInfo = shareContext.f58179c;
        if (photoInfo != null && shareContext.f58180d != null) {
            if (photoInfo.isVideo()) {
                if (com.qzone.preview.d.f(shareContext.f58180d)) {
                    return WinkDaTongReportConstant.ElementParamValue.QZONE_ALBUM_VIDEO_LAYER_PAGE;
                }
                return WinkDaTongReportConstant.ElementParamValue.QZONE_SHUOSHUO_VIDEO_LAYER_PAGE;
            }
            if (com.qzone.preview.d.f(shareContext.f58180d)) {
                return WinkDaTongReportConstant.ElementParamValue.QZONE_ALBUM_PIC_LAYER_PAGE;
            }
            return WinkDaTongReportConstant.ElementParamValue.QZONE_SHUOSHUO_PIC_LAYER_PAGE;
        }
        return "";
    }

    public final void w(final Activity activity, final com.qzone.reborn.layer.share.f shareContext, final Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (activity != null && bitmap != null) {
            try {
                RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.x(activity, bitmap, shareContext);
                    }
                });
            } catch (Exception unused) {
                J(1, R.string.hit);
            }
        } else {
            QLog.e("QZonePhotoRepairSharePreviewHelper", 1, "[shareToQCircle] activity: " + activity + ", bitmap: " + bitmap);
        }
    }

    private final List<com.tencent.mobileqq.component.qrcode.f> p() {
        List<com.tencent.mobileqq.component.qrcode.f> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.component.qrcode.f[]{new com.tencent.mobileqq.component.qrcode.f(0.0d, 0.0d, 0.0d), new com.tencent.mobileqq.component.qrcode.f(0.0d, 0.0d, 0.0d), new com.tencent.mobileqq.component.qrcode.f(0.0d, 0.0d, 0.0d)});
        return listOf;
    }

    public final void C(final Activity activity, final Bitmap bitmap, final int shareAction) {
        if (activity != null && bitmap != null) {
            if (!WXShareHelper.b0().e0()) {
                J(0, R.string.bz9);
                return;
            } else if (!WXShareHelper.b0().f0()) {
                J(0, R.string.bzg);
                return;
            } else {
                WXShareHelper.b0().A(new WXShareHelper.a() { // from class: com.qzone.reborn.repair.utils.c
                    @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
                    public final void onWXShareResp(BaseResp baseResp) {
                        o.D(baseResp);
                    }
                });
                RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.E(activity, bitmap, shareAction);
                    }
                });
                return;
            }
        }
        QLog.e("QZonePhotoRepairSharePreviewHelper", 1, "[shareToWeChat] activity: " + activity + ", bitmap: " + bitmap);
    }

    public final void G(final Activity activity, final Bitmap bitmap) {
        if (activity != null && bitmap != null) {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.h
                @Override // java.lang.Runnable
                public final void run() {
                    o.H(activity, bitmap);
                }
            });
            return;
        }
        QLog.e("QZonePhotoRepairSharePreviewHelper", 1, "[shareToXhs] activity: " + activity + ", bitmap: " + bitmap);
    }

    public final void z(final Activity activity, final Bitmap bitmap) {
        if (activity != null && bitmap != null) {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.g
                @Override // java.lang.Runnable
                public final void run() {
                    o.A(activity, bitmap);
                }
            });
            return;
        }
        QLog.e("QZonePhotoRepairSharePreviewHelper", 1, "[shareToQZone] activity: " + activity + ", bitmap: " + bitmap);
    }

    public final void t(final Activity activity, final Bitmap bitmap) {
        if (activity != null && bitmap != null) {
            try {
                RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.reborn.repair.utils.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        o.u(activity, bitmap);
                    }
                });
            } catch (OutOfMemoryError unused) {
                J(1, R.string.f171047bz3);
            }
        } else {
            QLog.e("QZonePhotoRepairSharePreviewHelper", 1, "[shareToFriend] activity: " + activity + ", bitmap: " + bitmap);
        }
    }
}
