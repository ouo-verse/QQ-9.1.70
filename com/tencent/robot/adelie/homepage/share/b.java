package com.tencent.robot.adelie.homepage.share;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001eB!\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J&\u0010\u0011\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/robot/adelie/homepage/share/b;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$c;", "Landroid/view/View;", "view", "", "source", "", "p0", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "o0", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "w6", "Lmqq/util/WeakReference;", "J0", "Lmqq/util/WeakReference;", "mActivityRef", "K0", "mLogicParentRef", "Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;", "param", "logicParent", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/widget/share/ShareActionSheetV2$Param;Landroid/view/View;)V", "L0", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends ShareActionSheetV2 implements ShareActionSheet.c {

    /* renamed from: J0, reason: from kotlin metadata */
    @NotNull
    private final WeakReference<Activity> mActivityRef;

    /* renamed from: K0, reason: from kotlin metadata */
    @NotNull
    private final WeakReference<View> mLogicParentRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Activity activity, @NotNull ShareActionSheetV2.Param param, @Nullable View view) {
        super(param);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(param, "param");
        this.mActivityRef = new WeakReference<>(activity);
        this.mLogicParentRef = new WeakReference<>(view);
        ArrayList arrayList = new ArrayList();
        ShareActionSheetBuilder.ActionSheetItem build = ShareActionSheetBuilder.ActionSheetItem.build(2);
        Intrinsics.checkNotNullExpressionValue(build, "build(ShareActionSheetBu\u2026em.ACTION_SEND_TO_FRIEND)");
        arrayList.add(build);
        ShareActionSheetBuilder.ActionSheetItem build2 = ShareActionSheetBuilder.ActionSheetItem.build(171);
        Intrinsics.checkNotNullExpressionValue(build2, "build(ShareActionSheetBu\u2026m.ACTION_SEND_TO_CHANNEL)");
        arrayList.add(build2);
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
        ShareActionSheetBuilder.ActionSheetItem build6 = ShareActionSheetBuilder.ActionSheetItem.build(1);
        Intrinsics.checkNotNullExpressionValue(build6, "build(ShareActionSheetBu\u2026heetItem.ACTION_COPYLINK)");
        arrayList2.add(build6);
        setRowVisibility(0, 0, 0);
        setIntentForStartForwardRecentActivity(new Intent());
        setActionSheetItems(arrayList, arrayList2);
        setItemClickListenerV3(this);
    }

    private final boolean o0(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    private final void p0(View view, int source) {
        Map mapOf;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("share_source", String.valueOf(source)));
        VideoReport.setElementId(view, "em_share_item");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        View view2 = this.mLogicParentRef.get();
        if (view2 == null) {
            return;
        }
        VideoReport.setLogicParent(view, view2);
        QLog.d("AdelieHomePageShareActionSheet", 1, "report click id=em_share_item reportParams=" + mapOf);
        VideoReport.reportEvent("clck", view, mapOf);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
    public void w6(@Nullable View view, @Nullable ShareActionSheetBuilder.ActionSheetItem item, @Nullable ShareActionSheet shareActionSheet) {
        dismiss();
        if (view != null && item != null && shareActionSheet != null) {
            Activity activity = this.mActivityRef.get();
            if (o0(activity)) {
                QLog.e("AdelieHomePageShareActionSheet", 1, "handleShare activity null");
                QQToast.makeText(activity, "\u5206\u4eab\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
                return;
            }
            if (activity == null) {
                return;
            }
            AdelieHomePageShareActionExecutor adelieHomePageShareActionExecutor = new AdelieHomePageShareActionExecutor(activity, new d());
            int i3 = item.action;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 9) {
                            if (i3 != 10) {
                                if (i3 != 72) {
                                    if (i3 != 73) {
                                        if (i3 != 171) {
                                            QLog.e("AdelieHomePageShareActionSheet", 1, "handleShare activity null");
                                            QQToast.makeText(activity, "\u5206\u4eab\u7c7b\u578b\u5f02\u5e38\uff0c\u8bf7\u91cd\u8bd5~", 0).show();
                                            return;
                                        } else {
                                            adelieHomePageShareActionExecutor.i();
                                            p0(view, ShareSource.CHANNEL.getValue());
                                            return;
                                        }
                                    }
                                } else {
                                    String uin = item.uin;
                                    int i16 = item.uinType;
                                    Intrinsics.checkNotNullExpressionValue(uin, "uin");
                                    adelieHomePageShareActionExecutor.h(uin, i16);
                                    p0(view, ShareSource.FRIEND.getValue());
                                    return;
                                }
                            } else {
                                adelieHomePageShareActionExecutor.m();
                                p0(view, ShareSource.WECHAT_CIRCLE.getValue());
                                return;
                            }
                        } else {
                            adelieHomePageShareActionExecutor.n();
                            p0(view, ShareSource.WECHAT.getValue());
                            return;
                        }
                    } else {
                        adelieHomePageShareActionExecutor.j();
                        p0(view, ShareSource.QZONE.getValue());
                        return;
                    }
                }
                adelieHomePageShareActionExecutor.g();
                p0(view, ShareSource.FRIEND.getValue());
                return;
            }
            adelieHomePageShareActionExecutor.f();
            p0(view, ShareSource.URL.getValue());
        }
    }
}
