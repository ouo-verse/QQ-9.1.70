package com.tencent.robot.profile.adapterdelegates;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.robot.profile.data.RobotBlacklistInfoData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0016J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f0\u0004H\u0016J2\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004H\u0014R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/robot/profile/adapterdelegates/b;", "Lcom/tencent/robot/profile/adapterdelegates/g;", "Lcom/tencent/robot/profile/data/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "holder", "", "payloads", "c", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "blackListIconContainer", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "blackListTv", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "f", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "robotEmptyIcon", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b extends g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout blackListIconContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView blackListTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIEmptyState robotEmptyIcon;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.robot.profile.data.g item, @NotNull List<com.tencent.robot.profile.data.g> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof RobotBlacklistInfoData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull com.tencent.robot.profile.data.g item, @NotNull SectionViewHolder<?> holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.onBindViewHolder2((b) item, (SectionViewHolder) holder, position, payloads);
        Context context = holder.itemView.getContext();
        holder.itemView.setBackgroundColor(context.getColor(R.color.qui_common_bg_bottom_light));
        TextView textView = this.blackListTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blackListTv");
            textView = null;
        }
        textView.setTextColor(context.getColor(R.color.qui_common_text_primary));
        QUIEmptyState qUIEmptyState = this.robotEmptyIcon;
        if (qUIEmptyState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotEmptyIcon");
            qUIEmptyState = null;
        }
        qUIEmptyState.setImageView(14);
        TextView textView3 = this.blackListTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blackListTv");
        } else {
            textView2 = textView3;
        }
        textView2.setText(HardCodeUtil.qqStr(R.string.f222666e5));
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.hod;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<com.tencent.robot.profile.data.g>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        Context context = itemView.getContext();
        View findViewById = itemView.findViewById(R.id.t8s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026lack_list_icon_container)");
        this.blackListIconContainer = (FrameLayout) findViewById;
        View findViewById2 = itemView.findViewById(R.id.t8u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.black_list_tv)");
        this.blackListTv = (TextView) findViewById2;
        this.robotEmptyIcon = new QUIEmptyState.Builder(context).setThemeType(0).setImageType(14).setBackgroundColorType(0).setHalfScreenState(true).build();
        FrameLayout frameLayout = this.blackListIconContainer;
        QUIEmptyState qUIEmptyState = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blackListIconContainer");
            frameLayout = null;
        }
        QUIEmptyState qUIEmptyState2 = this.robotEmptyIcon;
        if (qUIEmptyState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotEmptyIcon");
        } else {
            qUIEmptyState = qUIEmptyState2;
        }
        frameLayout.addView(qUIEmptyState);
    }
}
