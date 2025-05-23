package com.tencent.qqnt.aio.robot.screenshot;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.aio.data.AIOContact;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.aio.event.MsgForwardEvent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IGuildDataApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.action.api.IRobotPreviewApi;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u001d\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J8\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010%\u001a\u00020\u000bH\u0002J:\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/aio/robot/screenshot/LongShotManagerForRobot;", "", "", "path", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "p", "j", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "exitOnDismiss", "Lcom/tencent/qqnt/aio/adapter/api/c;", "exit", "subBusiness", h.F, DomainData.DOMAIN_NAME, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "shareActionSheet", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "preView", "r", "filePathTmp", "Landroid/os/Bundle;", "k", "v", "", "source", "o", "w", "toWeChatCircle", HippyTKDListViewAdapter.X, "l", "i", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "y", "<init>", "()V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class LongShotManagerForRobot {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy<LongShotManagerForRobot> f352058b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/robot/screenshot/LongShotManagerForRobot$a;", "", "Lcom/tencent/qqnt/aio/robot/screenshot/LongShotManagerForRobot;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/qqnt/aio/robot/screenshot/LongShotManagerForRobot;", "sInstance", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.robot.screenshot.LongShotManagerForRobot$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final LongShotManagerForRobot b() {
            return (LongShotManagerForRobot) LongShotManagerForRobot.f352058b.getValue();
        }

        public final LongShotManagerForRobot a() {
            return b();
        }

        Companion() {
        }
    }

    static {
        Lazy<LongShotManagerForRobot> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LongShotManagerForRobot>() { // from class: com.tencent.qqnt.aio.robot.screenshot.LongShotManagerForRobot$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LongShotManagerForRobot invoke() {
                return new LongShotManagerForRobot();
            }
        });
        f352058b = lazy;
    }

    private final void g(Activity activity) {
        if (l(activity)) {
            i(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Activity activity, Bitmap bitmap, String path, boolean exitOnDismiss, com.tencent.qqnt.aio.adapter.api.c exit, String subBusiness) {
        AIOContact a16;
        String j3;
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "activity.getIntent()");
        intent.putExtra("big_brother_source_key", "biz_src_qqagent");
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = activity;
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        String str = "";
        if (fragmentActivity != null && (a16 = com.tencent.qqnt.aio.utils.a.f352276a.a(fragmentActivity)) != null && (j3 = a16.j()) != null) {
            str = j3;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("agent_uin", ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(str));
        hashMap.put("sub_biz_source", subBusiness);
        param.deReportParams = hashMap;
        QRouteApi api = QRoute.api(IRobotPreviewApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRobotPreviewApi::class.java)");
        ShareActionSheetV2 shareActionSheetV2 = (ShareActionSheetV2) ((IRobotPreviewApi) api).createPreviewActionSheet(param, bitmap);
        if (shareActionSheetV2 == null) {
            return;
        }
        q(shareActionSheetV2);
        shareActionSheetV2.setRowVisibility(8, 0, 0);
        r(activity, shareActionSheetV2, bitmap, path, exitOnDismiss, exit);
        shareActionSheetV2.show();
    }

    private final void i(Activity activity) {
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity != null) {
            com.tencent.qqnt.aio.utils.c.f352293a.a(fragmentActivity, MsgForwardEvent.ExitMultiForward.f188621d);
        }
    }

    private final void j(Activity activity, String path) {
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        intent.putExtras(new Bundle());
        intent.putExtra("forward_type", 1);
        intent.setData(Uri.parse(path));
        activity.startActivityForResult(intent, 17005);
    }

    private final Bundle k(String filePathTmp) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, filePathTmp);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, filePathTmp);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, filePathTmp);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, filePathTmp);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putBoolean("isFromAIO", true);
        bundle.putInt(ForwardRecentActivity.SELECTION_MODE, 2);
        return bundle;
    }

    private final boolean l(Activity activity) {
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        if (fragmentActivity == null) {
            return false;
        }
        MultiSelectEvent.GetSelectMode getSelectMode = new MultiSelectEvent.GetSelectMode(false, 1, null);
        com.tencent.qqnt.aio.utils.c.f352293a.a(fragmentActivity, getSelectMode);
        return getSelectMode.a();
    }

    private final boolean m() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
        if (currentUin == null) {
            return false;
        }
        return TabDataHelper.isExtendTabShow(BaseApplication.getContext(), currentUin, "GUILD") && (((IGuildDataApi) QRoute.api(IGuildDataApi.class)).getGuildIds().isEmpty() ^ true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object n(String str, Continuation<? super Bitmap> continuation) {
        return CorountineFunKt.i(i.d.f261782e, "LongShotManagerForRobot.loadPreviewBitmap", null, new LongShotManagerForRobot$loadPreviewBitmap$2(str, null), continuation, 4, null);
    }

    private final void o(int source) {
        HashMap hashMap = new HashMap();
        hashMap.put("share_source", Integer.valueOf(source));
        com.tencent.mobileqq.aio.utils.b.l("em_share_item", hashMap);
    }

    private final void p(String path, Activity activity) {
        File file = new File(path);
        AIOGalleryUtils.p(activity, file, Utils.Crc64String(file.getAbsolutePath()), null);
    }

    private final void q(ShareActionSheetV2 shareActionSheet) {
        ArrayList arrayList = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(2);
        Intrinsics.checkNotNullExpressionValue(build, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_FRIEND)");
        arrayList.add(build);
        if (m()) {
            ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(171);
            Intrinsics.checkNotNullExpressionValue(build2, "build(ShareActionSheetBu\u2026m.ACTION_SEND_TO_CHANNEL)");
            arrayList.add(build2);
        }
        ShareActionSheetBuilder.ActionSheetItem build3 = ShareActionSheetBuilder.ActionSheetItem.build(3);
        Intrinsics.checkNotNullExpressionValue(build3, "build(ShareActionSheetBu\u2026tem.ACTION_SEND_TO_QZONE)");
        arrayList.add(build3);
        ShareActionSheetBuilder.ActionSheetItem build4 = ShareActionSheetBuilder.ActionSheetItem.build(9);
        Intrinsics.checkNotNullExpressionValue(build4, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_WECHAT)");
        arrayList.add(build4);
        ShareActionSheetBuilder.ActionSheetItem build5 = ShareActionSheetBuilder.ActionSheetItem.build(10);
        Intrinsics.checkNotNullExpressionValue(build5, "build(ShareActionSheetBu\u2026ON_SEND_TO_WECHAT_CIRCLE)");
        arrayList.add(build5);
        ArrayList arrayList2 = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build6 = ShareActionSheetBuilder.ActionSheetItem.build(39);
        Intrinsics.checkNotNullExpressionValue(build6, "build(ShareActionSheetBu\u2026ionSheetItem.ACTION_SAVE)");
        arrayList2.add(build6);
        shareActionSheet.setActionSheetItems(arrayList, arrayList2);
    }

    private final void r(final Activity activity, ShareActionSheetV2 shareActionSheet, final Bitmap preView, final String path, boolean exitOnDismiss, final com.tencent.qqnt.aio.adapter.api.c exit) {
        shareActionSheet.setItemClickListenerV2(new ShareActionSheet.OnItemClickListener() { // from class: com.tencent.qqnt.aio.robot.screenshot.a
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
            public final void onItemClick(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet2) {
                LongShotManagerForRobot.s(LongShotManagerForRobot.this, activity, path, exit, preView, actionSheetItem, shareActionSheet2);
            }
        });
        if (exitOnDismiss) {
            shareActionSheet.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.qqnt.aio.robot.screenshot.b
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    LongShotManagerForRobot.t(com.tencent.qqnt.aio.adapter.api.c.this, dialogInterface);
                }
            });
            shareActionSheet.setCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.qqnt.aio.robot.screenshot.c
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    LongShotManagerForRobot.u(com.tencent.qqnt.aio.adapter.api.c.this, dialogInterface);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(LongShotManagerForRobot this$0, Activity activity, String path, com.tencent.qqnt.aio.adapter.api.c exit, Bitmap preView, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(path, "$path");
        Intrinsics.checkNotNullParameter(exit, "$exit");
        Intrinsics.checkNotNullParameter(preView, "$preView");
        shareActionSheet.dismiss();
        int i3 = actionSheetItem.action;
        if (i3 == 2) {
            this$0.j(activity, path);
            exit.a();
            return;
        }
        if (i3 == 3) {
            this$0.w(activity, path);
            exit.a();
            return;
        }
        if (i3 == 9) {
            this$0.x(false, preView, path);
            exit.a();
            this$0.g(activity);
            return;
        }
        if (i3 == 10) {
            this$0.o(4);
            this$0.x(true, preView, path);
            exit.a();
            this$0.g(activity);
            return;
        }
        if (i3 != 39) {
            if (i3 != 171) {
                return;
            }
            this$0.v(activity, path);
            exit.a();
            return;
        }
        this$0.o(6);
        this$0.p(path, activity);
        exit.a();
        this$0.g(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(com.tencent.qqnt.aio.adapter.api.c exit, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(exit, "$exit");
        exit.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(com.tencent.qqnt.aio.adapter.api.c exit, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(exit, "$exit");
        exit.a();
    }

    private final void x(boolean toWeChatCircle, Bitmap preView, String path) {
        if (!WXShareHelper.b0().e0()) {
            QLog.e("LongShotManagerForRobot", 1, "shareToWeChat failed, wx not installed");
            QQToastUtil.showQQToast(1, R.string.f173257ih1);
        } else if (!WXShareHelper.b0().f0()) {
            QLog.e("LongShotManagerForRobot", 1, "shareToWeChat failed, wx version too low");
            QQToastUtil.showQQToast(1, R.string.f173258ih2);
        } else {
            WXShareHelper.b0().w0(path, preView, toWeChatCircle ? 1 : 0, true);
        }
    }

    private final void v(Activity activity, String path) {
        o(7);
        Intent intent = new Intent();
        intent.putExtras(k(path));
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, intent, 17004);
    }

    private final void w(Activity activity, String path) {
        o(2);
        QZoneHelper.forwardToPublishMood(activity, QZoneHelper.UserInfo.getInstance(), path, "", "", 17004);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y(Activity activity, Bitmap bitmap, String path, com.tencent.qqnt.aio.adapter.api.c exit, boolean exitOnDismiss, String subBusiness) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(exit, "exit");
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        if (bitmap == null) {
            LifecycleOwner lifecycleOwner = activity instanceof LifecycleOwner ? (LifecycleOwner) activity : null;
            if (lifecycleOwner == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) == null) {
                return;
            }
            CorountineFunKt.e(lifecycleScope, "LongShotManagerForRobot.showPreviewShareActionSheet", null, null, null, new LongShotManagerForRobot$showPreviewShareActionSheetForRobot$1(this, path, activity, exitOnDismiss, exit, subBusiness, null), 14, null);
            return;
        }
        h(activity, bitmap, path, exitOnDismiss, exit, subBusiness);
    }
}
