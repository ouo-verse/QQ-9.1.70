package com.tencent.mobileqq.qwallet.hb.detail;

import android.view.View;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001.B\u0017\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020$\u00a2\u0006\u0004\b+\u0010,J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016R\u0016\u0010\u0019\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR2\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0 0\u001a8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR \u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u001a8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001e\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/detail/CoverStoryBaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "hbSkinData", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "storyRes", "", "w", "", com.tencent.luggage.wxa.c8.c.f123400v, "r", "scrollOffset", "intermediateOffset", "totalScrollRange", "t", "Lcom/tencent/mobileqq/qwallet/hb/detail/HbSkinState;", "state", ReportConstant.COSTREPORT_PREFIX, "", "isVisible", "onVisibilityChanged", "u", "E", "Z", "positionInited", "Landroidx/lifecycle/Observer;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/Observer;", "p", "()Landroidx/lifecycle/Observer;", "stateObserver", "Lkotlin/Triple;", "G", "o", "scrollInfoObserver", "", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "visibleObserver", "Landroid/view/View;", "itemView", "skinId", "<init>", "(Landroid/view/View;I)V", "I", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public abstract class CoverStoryBaseViewHolder extends RecyclerView.ViewHolder implements LifecycleObserver {

    /* renamed from: E, reason: from kotlin metadata */
    private boolean positionInited;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Observer<HbSkinState> stateObserver;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Observer<Triple<Float, Float, Float>> scrollInfoObserver;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Observer<Integer> visibleObserver;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverStoryBaseViewHolder(@NotNull final View itemView, int i3) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.stateObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CoverStoryBaseViewHolder.x(itemView, this, (HbSkinState) obj);
            }
        };
        this.scrollInfoObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CoverStoryBaseViewHolder.v(CoverStoryBaseViewHolder.this, (Triple) obj);
            }
        };
        this.visibleObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.hb.detail.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CoverStoryBaseViewHolder.y(CoverStoryBaseViewHolder.this, (Integer) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(CoverStoryBaseViewHolder this$0, Triple triple) {
        float coerceAtLeast;
        float coerceAtMost;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float floatValue = ((Number) triple.getFirst()).floatValue();
        float floatValue2 = ((Number) triple.getSecond()).floatValue();
        float floatValue3 = ((Number) triple.getThird()).floatValue();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((floatValue - floatValue2) / ((0.8f * floatValue3) - floatValue2), 0.0f);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, 1.0f);
        this$0.r(coerceAtMost);
        this$0.t(floatValue, floatValue2, floatValue3);
        if (!this$0.positionInited) {
            this$0.positionInited = true;
            this$0.u();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(View itemView, CoverStoryBaseViewHolder this$0, HbSkinState it) {
        boolean z16;
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it == HbSkinState.EXPANDED) {
            z16 = true;
        } else {
            z16 = false;
        }
        itemView.setClickable(z16);
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.s(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(CoverStoryBaseViewHolder this$0, Integer num) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int layoutPosition = this$0.getLayoutPosition();
        if (num != null && num.intValue() == layoutPosition) {
            z16 = true;
        } else {
            z16 = false;
        }
        this$0.onVisibilityChanged(z16);
    }

    @NotNull
    public final Observer<Triple<Float, Float, Float>> o() {
        return this.scrollInfoObserver;
    }

    @NotNull
    public final Observer<HbSkinState> p() {
        return this.stateObserver;
    }

    @NotNull
    public final Observer<Integer> q() {
        return this.visibleObserver;
    }

    public void s(@NotNull HbSkinState state) {
        Intrinsics.checkNotNullParameter(state, "state");
    }

    public abstract void w(@Nullable HbSkinData hbSkinData, @NotNull HbSkinData.StoryRes storyRes);

    public void u() {
    }

    public void onVisibilityChanged(boolean isVisible) {
    }

    public void r(float alpha) {
    }

    public void t(float scrollOffset, float intermediateOffset, float totalScrollRange) {
    }
}
