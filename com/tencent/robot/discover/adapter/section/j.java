package com.tencent.robot.discover.adapter.section;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobot;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import h44.OpenRobotProfileCardArgs;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000bH\u0014J(\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0015H\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/robot/discover/adapter/section/j;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobot;", "", "robotUin", "", "t", "data", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "view", "elementParams", "u", "", "getViewStubLayoutId", "containerView", "onInitView", "", "position", "", "payload", "r", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "d", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "mAvatar", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mRedDot", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mRobotName", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class j extends Section<GroupRobot> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RoundRectImageView mAvatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView mRedDot;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView mRobotName;

    private final Map<String, Object> q(GroupRobot data) {
        Map<String, Object> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("bot_name", data.baseInfo.robotName), TuplesKt.to("bot_uin", Long.valueOf(data.baseInfo.robotUin)), TuplesKt.to("rank", Integer.valueOf(this.mPosition + 1)));
        return mapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(j this$0, String robotUin, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(robotUin, "$robotUin");
        this$0.t(robotUin);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void t(String robotUin) {
        Context context = this.mRootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, robotUin, "", 1, 0, null, 48, null));
        ImageView imageView = this.mRedDot;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
            imageView = null;
        }
        if (imageView.getVisibility() == 0) {
            n34.d.f418126a.c(robotUin);
            ImageView imageView3 = this.mRedDot;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
            } else {
                imageView2 = imageView3;
            }
            imageView2.setVisibility(8);
        }
    }

    private final void u(View view, Map<String, ? extends Object> elementParams) {
        VideoReport.setElementId(view, "em_bas_recently_used_robot_avatar");
        if (elementParams != null) {
            VideoReport.setElementParams(view, elementParams);
        }
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.f7627418);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.robot_avatar)");
        this.mAvatar = (RoundRectImageView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.f763241c);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026.id.robot_avatar_red_dot)");
        this.mRedDot = (ImageView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f110846jm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.tv_robot_name)");
        this.mRobotName = (TextView) findViewById3;
        RoundRectImageView roundRectImageView = this.mAvatar;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            roundRectImageView = null;
        }
        roundRectImageView.setCornerRadiusAndMode(this.mRootView.getResources().getDimensionPixelSize(R.dimen.c_7), 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull GroupRobot data, int position, @Nullable List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        final String valueOf = String.valueOf(data.baseInfo.robotUin);
        n34.c cVar = n34.c.f418125a;
        RoundRectImageView roundRectImageView = this.mAvatar;
        ImageView imageView = null;
        if (roundRectImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAvatar");
            roundRectImageView = null;
        }
        cVar.a(valueOf, roundRectImageView);
        TextView textView = this.mRobotName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRobotName");
            textView = null;
        }
        textView.setText(data.baseInfo.robotName);
        n34.d dVar = n34.d.f418126a;
        ImageView imageView2 = this.mRedDot;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
        } else {
            imageView = imageView2;
        }
        dVar.a(imageView, "", valueOf);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.discover.adapter.section.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.s(j.this, valueOf, view);
            }
        });
        View mRootView = this.mRootView;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        u(mRootView, q(data));
    }
}
