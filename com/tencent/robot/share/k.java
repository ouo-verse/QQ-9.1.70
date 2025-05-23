package com.tencent.robot.share;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.robot.data.RobotInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 A2\u00020\u0001:\u0005\u0014\u0018\u001c \u000fB+\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010<\u001a\u000204\u0012\u0006\u0010=\u001a\u000208\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b?\u0010@J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010\u0012\u001a\u00020\u0006R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u00060\u0017R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u00060\u001bR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u00060\u001fR\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u00060#R\u00020\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00100R\u0016\u00103\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00105R\u001c\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006B"}, d2 = {"Lcom/tencent/robot/share/k;", "", "Landroid/view/View;", "view", "", "action", "", "k", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "i", "g", "source", "j", "f", "e", "", tl.h.F, "l", "Lmqq/util/WeakReference;", "a", "Lmqq/util/WeakReference;", "mActivityRef", "Lcom/tencent/robot/share/k$d;", "b", "Lcom/tencent/robot/share/k$d;", "mItemClickListener", "Lcom/tencent/robot/share/k$a;", "c", "Lcom/tencent/robot/share/k$a;", "mCancelListener", "Lcom/tencent/robot/share/k$c;", "d", "Lcom/tencent/robot/share/k$c;", "mDismissListener", "Lcom/tencent/robot/share/k$e;", "Lcom/tencent/robot/share/k$e;", "mShowListener", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "mCustomArkBundle", "", "Ljava/util/List;", "mSharePaths", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "mCurrentSelectItem", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "mShareActionSheet", "I", "mAction", "Lcom/tencent/robot/data/RobotInfo;", "Lcom/tencent/robot/data/RobotInfo;", "mRobotInfo", "mRoot", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "mSubBusiness", "robotInfo", "subBusiness", "root", "<init>", "(Landroid/app/Activity;Lcom/tencent/robot/data/RobotInfo;Ljava/lang/String;Landroid/view/View;)V", DomainData.DOMAIN_NAME, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Activity> mActivityRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d mItemClickListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mCancelListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mDismissListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mShowListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle mCustomArkBundle;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> mSharePaths;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ShareActionSheetBuilder.ActionSheetItem mCurrentSelectItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ShareActionSheet mShareActionSheet;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int mAction;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotInfo mRobotInfo;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<View> mRoot;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mSubBusiness;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/share/k$a;", "Landroid/content/DialogInterface$OnCancelListener;", "Landroid/content/DialogInterface;", "dialog", "", "onCancel", "<init>", "(Lcom/tencent/robot/share/k;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private final class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(@NotNull DialogInterface dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            k.this.e();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/share/k$c;", "Landroid/content/DialogInterface$OnDismissListener;", "Landroid/content/DialogInterface;", "dialog", "", "onDismiss", "<init>", "(Lcom/tencent/robot/share/k;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private final class c implements DialogInterface.OnDismissListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(@NotNull DialogInterface dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            k.this.e();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/robot/share/k$d;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "", "w6", "<init>", "(Lcom/tencent/robot/share/k;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private final class d implements ShareActionSheet.c {
        public d() {
        }

        @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
        public void w6(@NotNull View view, @NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull ShareActionSheet shareActionSheet) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
            ShareActionSheet shareActionSheet2 = k.this.mShareActionSheet;
            if (shareActionSheet2 != null) {
                shareActionSheet2.dismiss();
            }
            k.this.e();
            int i3 = item.action;
            k.this.mCurrentSelectItem = item;
            k.this.k(view, i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/share/k$e;", "Landroid/content/DialogInterface$OnShowListener;", "Landroid/content/DialogInterface;", "dialog", "", "onShow", "<init>", "(Lcom/tencent/robot/share/k;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private final class e implements DialogInterface.OnShowListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(@NotNull DialogInterface dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
        }
    }

    public k(@NotNull Activity activity, @NotNull RobotInfo robotInfo, @NotNull String subBusiness, @Nullable View view) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(robotInfo, "robotInfo");
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        this.mItemClickListener = new d();
        this.mCancelListener = new a();
        this.mDismissListener = new c();
        this.mShowListener = new e();
        this.mCustomArkBundle = new Bundle();
        this.mSharePaths = new ArrayList();
        this.mAction = -1;
        this.mSubBusiness = subBusiness;
        this.mActivityRef = new WeakReference<>(activity);
        this.mRoot = new WeakReference<>(view);
        this.mRobotInfo = robotInfo;
    }

    private final void g(View view, int action) {
        Activity activity = this.mActivityRef.get();
        if (h(activity)) {
            QLog.e("robot.share.RobotShareActionSheet", 1, "handleShare activity null");
            QQToast.makeText(activity, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
            return;
        }
        if (activity == null) {
            return;
        }
        RobotShareActionExecutor robotShareActionExecutor = new RobotShareActionExecutor(activity, new n(this.mRobotInfo));
        if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action != 9) {
                        if (action != 10) {
                            if (action != 23) {
                                if (action != 171) {
                                    if (action != 72) {
                                        if (action != 73) {
                                            QLog.e("robot.share.RobotShareActionSheet", 1, "handleShare activity null");
                                            QQToast.makeText(activity, "\u5206\u4eab\u7c7b\u578b\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
                                            return;
                                        }
                                    } else {
                                        ShareActionSheetBuilder.ActionSheetItem actionSheetItem = this.mCurrentSelectItem;
                                        if (actionSheetItem != null) {
                                            String uin = actionSheetItem.uin;
                                            int i3 = actionSheetItem.uinType;
                                            Intrinsics.checkNotNullExpressionValue(uin, "uin");
                                            robotShareActionExecutor.k(uin, i3);
                                            j(view, 1);
                                            return;
                                        }
                                        return;
                                    }
                                } else {
                                    robotShareActionExecutor.l();
                                    j(view, 2);
                                    return;
                                }
                            } else {
                                robotShareActionExecutor.g();
                                j(view, 6);
                                return;
                            }
                        } else {
                            robotShareActionExecutor.p();
                            j(view, 4);
                            return;
                        }
                    } else {
                        robotShareActionExecutor.q();
                        j(view, 3);
                        return;
                    }
                } else {
                    robotShareActionExecutor.m();
                    j(view, 5);
                    return;
                }
            }
            robotShareActionExecutor.j();
            j(view, 1);
            return;
        }
        robotShareActionExecutor.i();
        j(view, 7);
    }

    private final boolean h(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    private final void i(Activity activity) {
        if (activity.getIntent() != null) {
            activity.getIntent().putExtra("big_brother_source_key", "biz_src_qqagent");
        }
    }

    private final void j(View view, int source) {
        Map mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("share_source", String.valueOf(source)));
        VideoReport.setElementId(view, "em_share_item");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        View view2 = this.mRoot.get();
        if (view2 != null) {
            VideoReport.setLogicParent(view, view2);
        }
        VideoReport.reportEvent("dt_clck", view, mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(View view, int action) {
        Activity activity = this.mActivityRef.get();
        this.mAction = action;
        if (h(activity)) {
            QLog.e("robot.share.RobotShareActionSheet", 1, "share(), activity is null");
            QQToast.makeText(MobileQQ.sMobileQQ, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
        } else {
            if (activity == null) {
                return;
            }
            g(view, action);
        }
    }

    public final void l() {
        List listOf;
        List listOf2;
        Activity activity = this.mActivityRef.get();
        if (h(activity)) {
            QLog.e("robot.share.RobotShareActionSheet", 1, "showActionSheet(), context null");
            return;
        }
        if (activity == null) {
            return;
        }
        i(activity);
        List<Integer> list = this.mSharePaths;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{2, 171, 3, 9, 10});
        list.addAll(listOf);
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1, 23});
        Intent intent = activity.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
        intent.putExtra("big_brother_source_key", "biz_src_qqagent");
        String robotUin = this.mRobotInfo.getRobotUin();
        if (robotUin == null) {
            robotUin = "";
        }
        ShareActionSheet b16 = new l(activity, robotUin, this.mSubBusiness).a(listOf2).e(this.mSharePaths).b();
        b16.setItemClickListenerV3(this.mItemClickListener);
        b16.setOnDismissListener(this.mDismissListener);
        b16.setCancelListener(this.mCancelListener);
        b16.setOnShowListener(this.mShowListener);
        this.mShareActionSheet = b16;
        b16.show();
        f();
    }

    public /* synthetic */ k(Activity activity, RobotInfo robotInfo, String str, View view, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, robotInfo, str, (i3 & 8) != 0 ? null : view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
    }

    private final void f() {
    }
}
