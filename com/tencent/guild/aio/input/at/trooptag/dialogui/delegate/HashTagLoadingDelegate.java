package com.tencent.guild.aio.input.at.trooptag.dialogui.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.aio.input.at.trooptag.dialogui.delegate.HashTagLoadingDelegate;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import cp0.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001a2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u001b\u001cB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0014J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0015H\u0014J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0015H\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/aio/input/at/trooptag/dialogui/delegate/HashTagLoadingDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Lcp0/h;", "Lcp0/a;", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/delegate/HashTagLoadingDelegate$b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "holder", "", "", "payloads", "", "p", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "g", h.F, "<init>", "()V", "d", "a", "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class HashTagLoadingDelegate extends AbsListItemAdapterDelegate<cp0.h, a, b> {

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\t\u00a2\u0006\u0004\b\u001a\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guild/aio/input/at/trooptag/dialogui/delegate/HashTagLoadingDelegate$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "", "E", "I", "mDelayTime", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "getMScanningLightView", "()Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Landroid/view/View;)V", "mScanningLightView", "", "G", "Z", "mIsAnimatorStart", "Ljava/lang/Runnable;", "H", "Ljava/lang/Runnable;", "mShowRunnable", "itemView", "<init>", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final int mDelayTime;

        /* renamed from: F, reason: from kotlin metadata */
        @Nullable
        private View mScanningLightView;

        /* renamed from: G, reason: from kotlin metadata */
        private boolean mIsAnimatorStart;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final Runnable mShowRunnable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.mDelayTime = 300;
            this.mShowRunnable = new Runnable() { // from class: hp0.e
                @Override // java.lang.Runnable
                public final void run() {
                    HashTagLoadingDelegate.b.p(HashTagLoadingDelegate.b.this);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            View view = this$0.mScanningLightView;
            if (view != null && this$0.mIsAnimatorStart && view != null) {
                view.setVisibility(0);
            }
        }

        public final void m() {
            if (!this.mIsAnimatorStart) {
                View view = this.mScanningLightView;
                if (view != null) {
                    view.setVisibility(4);
                }
                View view2 = this.mScanningLightView;
                if (view2 != null) {
                    view2.postDelayed(this.mShowRunnable, this.mDelayTime);
                }
                this.mIsAnimatorStart = true;
            }
        }

        public final void o() {
            this.mIsAnimatorStart = false;
            View view = this.mScanningLightView;
            if (view != null) {
                view.removeCallbacks(this.mShowRunnable);
            }
            View view2 = this.mScanningLightView;
            if (view2 != null) {
                view2.setVisibility(4);
            }
        }

        public final void q(@Nullable View view) {
            this.mScanningLightView = view;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void g(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void h(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ((b) holder).o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull a item, @NotNull List<a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof cp0.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull cp0.h item, @NotNull b holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public b d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        LayoutInflater.from(parent.getContext()).inflate(R.layout.et8, (ViewGroup) frameLayout, true);
        View childAt = frameLayout.getChildAt(0);
        b bVar = new b(frameLayout);
        bVar.q(childAt);
        childAt.setVisibility(0);
        return bVar;
    }
}
