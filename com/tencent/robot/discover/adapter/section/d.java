package com.tencent.robot.discover.adapter.section;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.qqui.RoundRectImageView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import h44.OpenRobotProfileCardArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J*\u0010\u000f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/robot/discover/adapter/section/d;", "Lcom/tencent/robot/discover/adapter/section/e;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "Lk34/a;", "data", "", "position", "", "", "payload", "v", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "e", "Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "t", "()Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;", "y", "(Lcom/tencent/mobileqq/guild/widget/qqui/RoundRectImageView;)V", "avatar", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "u", "()Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Landroid/widget/TextView;)V", "robotName", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "getArrow", "()Landroid/widget/ImageView;", HippyTKDListViewAdapter.X, "(Landroid/widget/ImageView;)V", "arrow", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public RoundRectImageView avatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView robotName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public ImageView arrow;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(d this$0, k34.a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.mRootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        k34.c cVar = (k34.c) aVar;
        ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, String.valueOf(cVar.getRobotBase().robotUin), cVar.getTroopUin(), 1, 0, null, 48, null));
        EventCollector.getInstance().onViewClicked(view);
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
        View findViewById = containerView.findViewById(R.id.head);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.head)");
        y((RoundRectImageView) findViewById);
        t().setCornerRadiusAndMode(containerView.getResources().getDimensionPixelSize(R.dimen.c_7), 1);
        View findViewById2 = containerView.findViewById(R.id.f771043g);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.robot_name_tv)");
        z((TextView) findViewById2);
        View findViewById3 = containerView.findViewById(R.id.f7620411);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.robot_add_iv)");
        x((ImageView) findViewById3);
    }

    @NotNull
    public final RoundRectImageView t() {
        RoundRectImageView roundRectImageView = this.avatar;
        if (roundRectImageView != null) {
            return roundRectImageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("avatar");
        return null;
    }

    @NotNull
    public final TextView u() {
        TextView textView = this.robotName;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("robotName");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final k34.a data, int position, @Nullable List<Object> payload) {
        if (data instanceof k34.c) {
            k34.c cVar = (k34.c) data;
            u().setText(cVar.getRobotBase().robotName);
            n34.c.f418125a.a(String.valueOf(cVar.getRobotBase().robotUin), t());
            this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.discover.adapter.section.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d.w(d.this, data, view);
                }
            });
        }
    }

    public final void x(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.arrow = imageView;
    }

    public final void y(@NotNull RoundRectImageView roundRectImageView) {
        Intrinsics.checkNotNullParameter(roundRectImageView, "<set-?>");
        this.avatar = roundRectImageView;
    }

    public final void z(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.robotName = textView;
    }
}
