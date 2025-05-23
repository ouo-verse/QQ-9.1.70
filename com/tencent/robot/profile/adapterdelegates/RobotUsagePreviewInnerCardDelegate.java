package com.tencent.robot.profile.adapterdelegates;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.profile.adapterdelegates.RobotUsagePreviewInnerCardDelegate;
import com.tencent.robot.profile.data.RobotProfileUsagePreviewData;
import hn2.o;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n44.g;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0014J.\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J&\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0014R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/robot/profile/adapterdelegates/RobotUsagePreviewInnerCardDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcom/tencent/robot/profile/data/o$b;", "Lcom/tencent/robot/profile/adapterdelegates/RobotUsagePreviewInnerCardDelegate$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "r", "holder", "", "payloads", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "Ln44/g$d;", "d", "Ln44/g$d;", "imageClickListener", "<init>", "(Ln44/g$d;)V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotUsagePreviewInnerCardDelegate extends AbsListItemAdapterDelegate<RobotProfileUsagePreviewData.RobotUsage, RobotProfileUsagePreviewData.RobotUsage, a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g.d imageClickListener;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/profile/adapterdelegates/RobotUsagePreviewInnerCardDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/robot/profile/data/o$b;", "robotUsage", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lhn2/o;", "E", "Lhn2/o;", "getBinding", "()Lhn2/o;", "binding", "Ln44/g$d;", UserInfo.SEX_FEMALE, "Ln44/g$d;", "imageClickListener", "<init>", "(Lhn2/o;Ln44/g$d;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final o binding;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final g.d imageClickListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull o binding, @NotNull g.d imageClickListener) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            Intrinsics.checkNotNullParameter(imageClickListener, "imageClickListener");
            this.binding = binding;
            this.imageClickListener = imageClickListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void n(a this$0, int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            g.d dVar = this$0.imageClickListener;
            ImageView imageView = this$0.binding.f405400b;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.groupRobotProfileImgImageview");
            dVar.a(imageView, i3);
            EventCollector.getInstance().onViewClicked(view);
        }

        public final void m(@NotNull RobotProfileUsagePreviewData.RobotUsage robotUsage, final int position) {
            Intrinsics.checkNotNullParameter(robotUsage, "robotUsage");
            this.binding.f405401c.setText(robotUsage.getName());
            this.binding.f405401c.setTextColor(this.itemView.getContext().getColor(R.color.qui_common_text_secondary));
            ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).loadImageWithLoading(robotUsage.getUrl(), this.binding.f405400b, this.itemView.getResources().getDrawable(R.drawable.kw6));
            this.binding.f405400b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.profile.adapterdelegates.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RobotUsagePreviewInnerCardDelegate.a.n(RobotUsagePreviewInnerCardDelegate.a.this, position, view);
                }
            });
        }
    }

    public RobotUsagePreviewInnerCardDelegate(@NotNull g.d imageClickListener) {
        Intrinsics.checkNotNullParameter(imageClickListener, "imageClickListener");
        this.imageClickListener = imageClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull RobotProfileUsagePreviewData.RobotUsage item, @NotNull List<RobotProfileUsagePreviewData.RobotUsage> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull RobotProfileUsagePreviewData.RobotUsage item, @NotNull a holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void m(@NotNull RobotProfileUsagePreviewData.RobotUsage item, @NotNull a holder, @NotNull List<Object> payloads, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.m(item, position);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        o g16 = o.g(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026.context), parent, false)");
        return new a(g16, this.imageClickListener);
    }
}
