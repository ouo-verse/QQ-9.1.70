package com.tencent.biz.qrcode.util;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.widget.share.ShareActionSheetWithPreview;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qrcode/util/i;", "", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetWithPreview;", "shareActionSheet", "", "a", "Landroid/app/Activity;", "curActivity", "Landroid/graphics/Bitmap;", "preView", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f95067a = new i();

    i() {
    }

    private final void a(ShareActionSheetWithPreview shareActionSheet) {
        ArrayList arrayList = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(26);
        Intrinsics.checkNotNullExpressionValue(build, "build(ShareActionSheetBu\u2026etItem.ACTION_SEND_TO_PC)");
        arrayList.add(build);
        ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(2);
        Intrinsics.checkNotNullExpressionValue(build2, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_FRIEND)");
        arrayList.add(build2);
        ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(3);
        Intrinsics.checkNotNullExpressionValue(build3, "build(ShareActionSheetBu\u2026tem.ACTION_SEND_TO_QZONE)");
        arrayList.add(build3);
        boolean e06 = WXShareHelper.b0().e0();
        boolean f06 = WXShareHelper.b0().f0();
        if (QLog.isColorLevel()) {
            QLog.d("QRDisplayMyCardButtonPart", 2, " showMyQrCodeActionSheet() isWxInstalled = " + e06 + " isWxSupportApi =" + f06);
        }
        if (e06 && f06) {
            ShareActionSheetBuilder.ActionSheetItem build4 = ShareActionSheetBuilder.ActionSheetItem.build(9);
            Intrinsics.checkNotNullExpressionValue(build4, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_WECHAT)");
            arrayList.add(build4);
            ShareActionSheetBuilder.ActionSheetItem build5 = ShareActionSheetBuilder.ActionSheetItem.build(10);
            Intrinsics.checkNotNullExpressionValue(build5, "build(ShareActionSheetBu\u2026ON_SEND_TO_WECHAT_CIRCLE)");
            arrayList.add(build5);
        }
        ArrayList arrayList2 = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build6 = ShareActionSheetBuilder.ActionSheetItem.build(39);
        Intrinsics.checkNotNullExpressionValue(build6, "build(ShareActionSheetBu\u2026ionSheetItem.ACTION_SAVE)");
        arrayList2.add(build6);
        ShareActionSheetBuilder.ActionSheetItem build7 = ShareActionSheetBuilder.ActionSheetItem.build(1);
        Intrinsics.checkNotNullExpressionValue(build7, "build(ShareActionSheetBu\u2026heetItem.ACTION_COPYLINK)");
        arrayList2.add(build7);
        shareActionSheet.setActionSheetItems(arrayList, arrayList2);
    }

    @NotNull
    public final ShareActionSheetWithPreview b(@NotNull Activity curActivity, @NotNull Bitmap preView) {
        Intrinsics.checkNotNullParameter(curActivity, "curActivity");
        Intrinsics.checkNotNullParameter(preView, "preView");
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        curActivity.getIntent().putExtra("big_brother_source_key", "biz_src_jc_gxl_ctcshare");
        param.canceledOnTouchOutside = true;
        param.context = curActivity;
        param.fullScreen = true;
        param.f317475lp = new ViewGroup.LayoutParams(-1, -2);
        ShareActionSheetWithPreview shareActionSheetWithPreview = new ShareActionSheetWithPreview(param);
        shareActionSheetWithPreview.D0(preView);
        shareActionSheetWithPreview.C0(curActivity.getResources().getString(R.string.cfc) + "\uff0c" + curActivity.getResources().getString(R.string.f2035150e));
        Intent intent = new Intent();
        intent.putExtra("forward_type", 27);
        shareActionSheetWithPreview.setIntentForStartForwardRecentActivity(intent);
        shareActionSheetWithPreview.setRowVisibility(8, 0, 0);
        a(shareActionSheetWithPreview);
        return shareActionSheetWithPreview;
    }
}
