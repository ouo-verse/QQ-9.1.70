package com.tencent.mobileqq.guild.setting.group.groupshow.delegate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import az1.e;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.setting.group.groupshow.delegate.LoadingAdapterDelegate;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0002\u0018\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0014H\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/delegate/LoadingAdapterDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", "Laz1/e;", "Laz1/a;", "Lcom/tencent/mobileqq/guild/setting/group/groupshow/delegate/LoadingAdapterDelegate$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "o", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "holder", "", "payloads", "", "p", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", h.F, "<init>", "()V", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LoadingAdapterDelegate extends AbsListItemAdapterDelegate<e, az1.a, a> {

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/delegate/LoadingAdapterDelegate$b;", "Lcom/tencent/mobileqq/guild/setting/group/groupshow/delegate/LoadingAdapterDelegate$a;", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", UserInfo.SEX_FEMALE, "I", "mDelayTime", "", "G", "Z", "mIsAnimatorStart", "Ljava/lang/Runnable;", "H", "Ljava/lang/Runnable;", "mShowRunnable", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends a {

        /* renamed from: F, reason: from kotlin metadata */
        private final int mDelayTime;

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
            this.mShowRunnable = new Runnable() { // from class: bz1.b
                @Override // java.lang.Runnable
                public final void run() {
                    LoadingAdapterDelegate.b.r(LoadingAdapterDelegate.b.this);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void r(b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.getMScanningLightView() != null && this$0.mIsAnimatorStart) {
                View mScanningLightView = this$0.getMScanningLightView();
                Intrinsics.checkNotNull(mScanningLightView);
                mScanningLightView.setVisibility(0);
            }
        }

        @Override // com.tencent.mobileqq.guild.setting.group.groupshow.delegate.LoadingAdapterDelegate.a
        public void l() {
            if (!this.mIsAnimatorStart) {
                View mScanningLightView = getMScanningLightView();
                Intrinsics.checkNotNull(mScanningLightView);
                mScanningLightView.setVisibility(4);
                View mScanningLightView2 = getMScanningLightView();
                Intrinsics.checkNotNull(mScanningLightView2);
                mScanningLightView2.postDelayed(this.mShowRunnable, this.mDelayTime);
                this.mIsAnimatorStart = true;
            }
        }

        @Override // com.tencent.mobileqq.guild.setting.group.groupshow.delegate.LoadingAdapterDelegate.a
        public void m() {
            this.mIsAnimatorStart = false;
            View mScanningLightView = getMScanningLightView();
            Intrinsics.checkNotNull(mScanningLightView);
            mScanningLightView.removeCallbacks(this.mShowRunnable);
            View mScanningLightView2 = getMScanningLightView();
            Intrinsics.checkNotNull(mScanningLightView2);
            mScanningLightView2.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    public void h(@NotNull RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ((a) holder).m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean j(@NotNull az1.a item, @NotNull List<az1.a> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull e item, @NotNull a holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public a d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View scanningLightView = LayoutInflater.from(parent.getContext()).inflate(R.layout.emh, (ViewGroup) new FrameLayout(parent.getContext()), false);
        Intrinsics.checkNotNullExpressionValue(scanningLightView, "scanningLightView");
        b bVar = new b(scanningLightView);
        bVar.p(scanningLightView);
        scanningLightView.setVisibility(0);
        return bVar;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000e\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/group/groupshow/delegate/LoadingAdapterDelegate$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "E", "Landroid/view/View;", "o", "()Landroid/view/View;", "p", "(Landroid/view/View;)V", "mScanningLightView", "itemView", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @Nullable
        private View mScanningLightView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        @Nullable
        /* renamed from: o, reason: from getter */
        public final View getMScanningLightView() {
            return this.mScanningLightView;
        }

        public final void p(@Nullable View view) {
            this.mScanningLightView = view;
        }

        public void l() {
        }

        public void m() {
        }
    }
}
