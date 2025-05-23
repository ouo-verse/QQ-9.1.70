package com.tencent.biz.richframework.part.adapter;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.richframework.collection.RFWComparableWeakRef;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/richframework/part/adapter/ViewHolderVisibleAwareNotifier$onPageChangeCallback$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageSelected", "", "position", "", "part-adapter_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class ViewHolderVisibleAwareNotifier$onPageChangeCallback$1 extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ ViewHolderVisibleAwareNotifier this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewHolderVisibleAwareNotifier$onPageChangeCallback$1(ViewHolderVisibleAwareNotifier viewHolderVisibleAwareNotifier) {
        this.this$0 = viewHolderVisibleAwareNotifier;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(final int position) {
        RFWComparableWeakRef rFWComparableWeakRef;
        final RecyclerView recyclerView;
        super.onPageSelected(position);
        if (position >= 0) {
            rFWComparableWeakRef = this.this$0.hostRecyclerViewWrf;
            if (rFWComparableWeakRef != null && (recyclerView = (RecyclerView) rFWComparableWeakRef.get()) != null) {
                Intrinsics.checkNotNullExpressionValue(recyclerView, "hostRecyclerViewWrf?.get() ?: return");
                recyclerView.post(new Runnable() { // from class: com.tencent.biz.richframework.part.adapter.ViewHolderVisibleAwareNotifier$onPageChangeCallback$1$onPageSelected$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public final void run() {
                        RFWComparableWeakRef rFWComparableWeakRef2;
                        RecyclerView.ViewHolder viewHolder;
                        int i3;
                        RFWComparableWeakRef rFWComparableWeakRef3;
                        boolean contains;
                        RFWComparableWeakRef rFWComparableWeakRef4;
                        boolean contains2;
                        int i16;
                        if (RFWApplication.isDebug()) {
                            int i17 = RFWLog.USR;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("onPageChangeCallback prePos is ");
                            i16 = ViewHolderVisibleAwareNotifier$onPageChangeCallback$1.this.this$0.currentPagePos;
                            sb5.append(i16);
                            RFWLog.i("ViewHolderVisibleAwareNotifier", i17, sb5.toString());
                        }
                        ViewHolderVisibleAwareNotifier$onPageChangeCallback$1.this.this$0.currentPagePos = position;
                        RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(position);
                        rFWComparableWeakRef2 = ViewHolderVisibleAwareNotifier$onPageChangeCallback$1.this.this$0.currentVisibleViewHolder;
                        if (rFWComparableWeakRef2 != null) {
                            viewHolder = (RecyclerView.ViewHolder) rFWComparableWeakRef2.get();
                        } else {
                            viewHolder = null;
                        }
                        if ((viewHolder instanceof VisibleAware) && (!Intrinsics.areEqual(viewHolder, findViewHolderForAdapterPosition))) {
                            ((VisibleAware) viewHolder).onVisibleChanged(false);
                            LinkedHashSet<RFWComparableWeakRef<RecyclerView.ViewHolder>> attachWindowViewHolders = ViewHolderVisibleAwareNotifier$onPageChangeCallback$1.this.this$0.getAttachWindowViewHolders();
                            rFWComparableWeakRef4 = ViewHolderVisibleAwareNotifier$onPageChangeCallback$1.this.this$0.currentVisibleViewHolder;
                            contains2 = CollectionsKt___CollectionsKt.contains(attachWindowViewHolders, rFWComparableWeakRef4);
                            ViewHolderVisibleAwareNotifier$onPageChangeCallback$1.this.this$0.logViewHolderStatus("onPageChangeCallback", viewHolder, false, contains2);
                        }
                        if (!(findViewHolderForAdapterPosition instanceof VisibleAware)) {
                            ViewHolderVisibleAwareNotifier$onPageChangeCallback$1.this.this$0.currentVisibleViewHolder = null;
                            if (RFWApplication.isDebug()) {
                                int i18 = RFWLog.USR;
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("onPageChangeCallback not find viewHolder:");
                                i3 = ViewHolderVisibleAwareNotifier$onPageChangeCallback$1.this.this$0.currentPagePos;
                                sb6.append(i3);
                                RFWLog.i("ViewHolderVisibleAwareNotifier", i18, sb6.toString());
                                return;
                            }
                            return;
                        }
                        if (!Intrinsics.areEqual(viewHolder, findViewHolderForAdapterPosition)) {
                            ViewHolderVisibleAwareNotifier$onPageChangeCallback$1.this.this$0.currentVisibleViewHolder = new RFWComparableWeakRef(findViewHolderForAdapterPosition);
                            LinkedHashSet<RFWComparableWeakRef<RecyclerView.ViewHolder>> attachWindowViewHolders2 = ViewHolderVisibleAwareNotifier$onPageChangeCallback$1.this.this$0.getAttachWindowViewHolders();
                            rFWComparableWeakRef3 = ViewHolderVisibleAwareNotifier$onPageChangeCallback$1.this.this$0.currentVisibleViewHolder;
                            contains = CollectionsKt___CollectionsKt.contains(attachWindowViewHolders2, rFWComparableWeakRef3);
                            ((VisibleAware) findViewHolderForAdapterPosition).onVisibleChanged(true);
                            ViewHolderVisibleAwareNotifier$onPageChangeCallback$1.this.this$0.logViewHolderStatus("onPageChangeCallback", findViewHolderForAdapterPosition, true, contains);
                            return;
                        }
                        if (RFWApplication.isDebug()) {
                            RFWLog.i("ViewHolderVisibleAwareNotifier", RFWLog.USR, "onPageChangeCallback same holder change pos to " + position);
                        }
                    }
                });
                return;
            }
            return;
        }
        if (RFWApplication.isDebug()) {
            RFWLog.i("ViewHolderVisibleAwareNotifier", RFWLog.USR, "onPageChangeCallback position:" + position + " viewPager2 inner error");
        }
    }
}
