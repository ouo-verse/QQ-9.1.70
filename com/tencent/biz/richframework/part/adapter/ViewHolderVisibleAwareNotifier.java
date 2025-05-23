package com.tencent.biz.richframework.part.adapter;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.UiThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.collection.RFWComparableWeakRef;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;
import com.tencent.richframework.lifecycle.RFWViewLifecycleUtil;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007*\u0001F\b&\u0018\u0000 K2\u00020\u0001:\u0001KB\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0003J\b\u0010\u000f\u001a\u00020\u0004H\u0003J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0011\u001a\u00020\u0004H\u0007J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bJ\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bH\u0007J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bH\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\bH\u0007J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0004H&R\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR3\u0010\"\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0 0\u001fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0 `!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R0\u0010&\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0 0\u001fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0 `!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010#R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u001eR\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001e\u0010-\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010,R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R2\u00104\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0 0\u001fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0 `!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010#R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010<\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u001e\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010\u001eR\u0014\u0010E\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010\u001eR\u0014\u0010G\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006L"}, d2 = {"Lcom/tencent/biz/richframework/part/adapter/ViewHolderVisibleAwareNotifier;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "triggerVisibleChange", "", "tag", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "newVisible", "isOnWindow", "logViewHolderStatus", "onVisibleChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, VRReportDefine$ReportKey.INSTALL, "unInstall", "viewHolder", "registerViewHolder", "notifyViewAttachedToWindow", "notifyViewDetachedFromWindow", "notifyViewRecycled", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "onAwareDestroyed", "enableVisibleAware", "Z", "Ljava/util/LinkedHashSet;", "Lcom/tencent/biz/richframework/collection/RFWComparableWeakRef;", "Lkotlin/collections/LinkedHashSet;", "attachWindowViewHolders", "Ljava/util/LinkedHashSet;", "getAttachWindowViewHolders", "()Ljava/util/LinkedHashSet;", "allViewHolders", "lifecycleVisible", "Lcom/tencent/biz/richframework/part/adapter/NotifyMode;", "notifyMode", "Lcom/tencent/biz/richframework/part/adapter/NotifyMode;", "hostRecyclerViewWrf", "Lcom/tencent/biz/richframework/collection/RFWComparableWeakRef;", "currentVisibleViewHolder", "", "currentPagePos", "I", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "visibleViewHolders", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageChangeCallback", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "adapterChangeListener", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Ljava/lang/Runnable;", "triggerTask", "Ljava/lang/Runnable;", "Ljava/lang/ref/WeakReference;", "lifecycleOwnerWrf", "Ljava/lang/ref/WeakReference;", "extendBlock", "useAttach", "com/tencent/biz/richframework/part/adapter/ViewHolderVisibleAwareNotifier$attachStateChangeListener$1", "attachStateChangeListener", "Lcom/tencent/biz/richframework/part/adapter/ViewHolderVisibleAwareNotifier$attachStateChangeListener$1;", "<init>", "()V", "Companion", "part-adapter_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public abstract class ViewHolderVisibleAwareNotifier implements LifecycleEventObserver {
    private RFWComparableWeakRef<RecyclerView.ViewHolder> currentVisibleViewHolder;
    private RFWComparableWeakRef<RecyclerView> hostRecyclerViewWrf;
    private WeakReference<LifecycleOwner> lifecycleOwnerWrf;
    private boolean lifecycleVisible;
    private boolean enableVisibleAware = true;

    @NotNull
    private final LinkedHashSet<RFWComparableWeakRef<RecyclerView.ViewHolder>> attachWindowViewHolders = new LinkedHashSet<>();
    private final LinkedHashSet<RFWComparableWeakRef<RecyclerView.ViewHolder>> allViewHolders = new LinkedHashSet<>();
    private NotifyMode notifyMode = NotifyMode.ON_ATTACH_WINDOW;
    private int currentPagePos = Integer.MIN_VALUE;
    private Handler handler = new Handler(Looper.getMainLooper());
    private LinkedHashSet<RFWComparableWeakRef<RecyclerView.ViewHolder>> visibleViewHolders = new LinkedHashSet<>();
    private final ViewPager2.OnPageChangeCallback onPageChangeCallback = new ViewHolderVisibleAwareNotifier$onPageChangeCallback$1(this);
    private final RecyclerView.AdapterDataObserver adapterChangeListener = new RecyclerView.AdapterDataObserver() { // from class: com.tencent.biz.richframework.part.adapter.ViewHolderVisibleAwareNotifier$adapterChangeListener$1
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int positionStart, int itemCount, @Nullable Object payload) {
            onItemRangeChanged(positionStart, itemCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int positionStart, int itemCount) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int positionStart, int itemCount) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int fromPosition, int toPosition, int itemCount) {
        }
    };
    private final RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.tencent.biz.richframework.part.adapter.ViewHolderVisibleAwareNotifier$onScrollListener$1
        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            ViewHolderVisibleAwareNotifier.this.triggerVisibleChange(recyclerView);
        }
    };
    private final Runnable triggerTask = new Runnable() { // from class: com.tencent.biz.richframework.part.adapter.ViewHolderVisibleAwareNotifier$triggerTask$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public final void run() {
            RFWComparableWeakRef rFWComparableWeakRef;
            RecyclerView it;
            rFWComparableWeakRef = ViewHolderVisibleAwareNotifier.this.hostRecyclerViewWrf;
            if (rFWComparableWeakRef != null && (it = (RecyclerView) rFWComparableWeakRef.get()) != null) {
                ViewHolderVisibleAwareNotifier viewHolderVisibleAwareNotifier = ViewHolderVisibleAwareNotifier.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                viewHolderVisibleAwareNotifier.triggerVisibleChange(it);
            }
        }
    };
    private final boolean extendBlock = RFWConfig.getConfigValue("enable_aware_lifecycle_extend_block", true);
    private final boolean useAttach = RFWConfig.getConfigValue("enable_aware_lifecycle_use_attach", true);
    private final ViewHolderVisibleAwareNotifier$attachStateChangeListener$1 attachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.tencent.biz.richframework.part.adapter.ViewHolderVisibleAwareNotifier$attachStateChangeListener$1
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View childRecyclerView) {
            WeakReference weakReference;
            boolean z16;
            Lifecycle lifecycle;
            Intrinsics.checkNotNullParameter(childRecyclerView, "childRecyclerView");
            weakReference = ViewHolderVisibleAwareNotifier.this.lifecycleOwnerWrf;
            if (weakReference == null) {
                z16 = ViewHolderVisibleAwareNotifier.this.extendBlock;
                LifecycleOwner viewLifecycleOwner = RFWViewLifecycleUtil.getViewLifecycleOwner(childRecyclerView, z16);
                int i3 = RFWLog.USR;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("postRecyclerView getOwner:");
                sb5.append(viewLifecycleOwner);
                sb5.append(" adapter:");
                RecyclerView.Adapter adapter = null;
                if (!(childRecyclerView instanceof RecyclerView)) {
                    childRecyclerView = null;
                }
                RecyclerView recyclerView = (RecyclerView) childRecyclerView;
                if (recyclerView != null) {
                    adapter = recyclerView.getAdapter();
                }
                sb5.append(adapter);
                RFWLog.i("ViewHolderVisibleAwareNotifier", i3, sb5.toString());
                ViewHolderVisibleAwareNotifier.this.lifecycleOwnerWrf = new WeakReference(viewLifecycleOwner);
                if (viewLifecycleOwner != null && (lifecycle = viewLifecycleOwner.getLifecycle()) != null) {
                    lifecycle.addObserver(ViewHolderVisibleAwareNotifier.this);
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View recyclerView) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final void logViewHolderStatus(String tag, RecyclerView.ViewHolder holder, boolean newVisible, boolean isOnWindow) {
        if (RFWApplication.isDebug()) {
            RFWLog.i("ViewHolderVisibleAwareNotifier", RFWLog.USR, tag + ":hashCode:" + holder.hashCode() + TokenParser.SP + " position:" + holder.getAdapterPosition() + " newVisible:" + newVisible + " isOnWindow:" + isOnWindow);
        }
    }

    @UiThread
    private final void onDestroy() {
        Iterator<T> it = this.allViewHolders.iterator();
        while (it.hasNext()) {
            Object obj = (RecyclerView.ViewHolder) ((RFWComparableWeakRef) it.next()).get();
            if (obj != null) {
                Intrinsics.checkNotNullExpressionValue(obj, "viewHolderWrf.get() ?: return@forEach");
                if ((obj instanceof VisibleAware) && this.notifyMode != NotifyMode.NONE) {
                    ((VisibleAware) obj).onDestroy();
                }
            }
        }
        this.allViewHolders.clear();
        this.attachWindowViewHolders.clear();
        this.currentVisibleViewHolder = null;
        onAwareDestroyed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @UiThread
    private final void onVisibleChanged(boolean newVisible) {
        RecyclerView.ViewHolder viewHolder;
        if (this.lifecycleVisible == newVisible) {
            return;
        }
        NotifyMode notifyMode = this.notifyMode;
        if (notifyMode == NotifyMode.ON_ATTACH_WINDOW) {
            Iterator<T> it = this.attachWindowViewHolders.iterator();
            while (it.hasNext()) {
                RecyclerView.ViewHolder viewHolder2 = (RecyclerView.ViewHolder) ((RFWComparableWeakRef) it.next()).get();
                if (viewHolder2 != 0) {
                    Intrinsics.checkNotNullExpressionValue(viewHolder2, "viewHolderWrf.get() ?: return@forEach");
                    if (viewHolder2 instanceof VisibleAware) {
                        ((VisibleAware) viewHolder2).onVisibleChanged(newVisible);
                        logViewHolderStatus("onVisibleChanged", viewHolder2, newVisible, true);
                    }
                }
            }
        } else if (notifyMode == NotifyMode.ON_PAGE_SELECT) {
            RFWComparableWeakRef<RecyclerView.ViewHolder> rFWComparableWeakRef = this.currentVisibleViewHolder;
            if (rFWComparableWeakRef != null) {
                viewHolder = rFWComparableWeakRef.get();
            } else {
                viewHolder = null;
            }
            if (viewHolder instanceof VisibleAware) {
                ((VisibleAware) viewHolder).onVisibleChanged(newVisible);
                if (RFWApplication.isDebug()) {
                    RFWLog.i("ViewHolderVisibleAwareNotifier", RFWLog.USR, " onVisibleChanged:hashCode:" + viewHolder.hashCode() + TokenParser.SP + " position:" + viewHolder.getAdapterPosition() + " newVisible:" + newVisible);
                }
            }
        } else if (notifyMode == NotifyMode.ON_SCROLL_AREA_VISIBLE) {
            Iterator<T> it5 = this.visibleViewHolders.iterator();
            while (it5.hasNext()) {
                RecyclerView.ViewHolder viewHolder3 = (RecyclerView.ViewHolder) ((RFWComparableWeakRef) it5.next()).get();
                if (viewHolder3 != 0) {
                    Intrinsics.checkNotNullExpressionValue(viewHolder3, "viewHolderWrf.get() ?: return@forEach");
                    if (viewHolder3 instanceof VisibleAware) {
                        ((VisibleAware) viewHolder3).onVisibleChanged(newVisible);
                        logViewHolderStatus("onVisibleChanged", viewHolder3, newVisible, true);
                    }
                }
            }
        }
        this.lifecycleVisible = newVisible;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void triggerVisibleChange(RecyclerView recyclerView) {
        boolean z16;
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if (RFWApplication.isDebug()) {
                    RFWLog.i("ViewHolderVisibleAwareNotifier", RFWLog.USR, "firstVisiblePos:" + findFirstVisibleItemPosition + " lastVisibleItemPos:" + findLastVisibleItemPosition);
                }
                for (RFWComparableWeakRef<RecyclerView.ViewHolder> rFWComparableWeakRef : this.attachWindowViewHolders) {
                    RecyclerView.ViewHolder viewHolder = rFWComparableWeakRef.get();
                    if (viewHolder != null) {
                        Intrinsics.checkNotNullExpressionValue(viewHolder, "viewHolderWrf.get() ?: return@forEach");
                        int adapterPosition = viewHolder.getAdapterPosition();
                        if (findFirstVisibleItemPosition <= adapterPosition && findLastVisibleItemPosition >= adapterPosition) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        Object obj = null;
                        if (z16 && !this.visibleViewHolders.contains(rFWComparableWeakRef)) {
                            this.visibleViewHolders.add(rFWComparableWeakRef);
                            if (viewHolder instanceof VisibleAware) {
                                obj = viewHolder;
                            }
                            VisibleAware visibleAware = (VisibleAware) obj;
                            if (visibleAware != null) {
                                visibleAware.onVisibleChanged(true);
                            }
                            logViewHolderStatus("onScrollStateChanged", viewHolder, true, true);
                        } else if (!z16 && this.visibleViewHolders.contains(rFWComparableWeakRef)) {
                            this.visibleViewHolders.remove(rFWComparableWeakRef);
                            if (viewHolder instanceof VisibleAware) {
                                obj = viewHolder;
                            }
                            VisibleAware visibleAware2 = (VisibleAware) obj;
                            if (visibleAware2 != null) {
                                visibleAware2.onVisibleChanged(false);
                            }
                            logViewHolderStatus("onScrollStateChanged", viewHolder, true, true);
                        }
                    }
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        }
    }

    @NotNull
    public final LinkedHashSet<RFWComparableWeakRef<RecyclerView.ViewHolder>> getAttachWindowViewHolders() {
        return this.attachWindowViewHolders;
    }

    @UiThread
    public final void install(@NotNull final RecyclerView recyclerView) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.hostRecyclerViewWrf = new RFWComparableWeakRef<>(recyclerView);
        if (recyclerView.isAttachedToWindow()) {
            LifecycleOwner viewLifecycleOwner = RFWViewLifecycleUtil.getViewLifecycleOwner(recyclerView, this.extendBlock);
            this.lifecycleOwnerWrf = new WeakReference<>(viewLifecycleOwner);
            if (viewLifecycleOwner != null && (lifecycle = viewLifecycleOwner.getLifecycle()) != null) {
                lifecycle.addObserver(this);
            }
        } else if (this.useAttach) {
            recyclerView.addOnAttachStateChangeListener(this.attachStateChangeListener);
        } else {
            recyclerView.post(new Runnable() { // from class: com.tencent.biz.richframework.part.adapter.ViewHolderVisibleAwareNotifier$install$1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z16;
                    Lifecycle lifecycle2;
                    RecyclerView recyclerView2 = recyclerView;
                    z16 = ViewHolderVisibleAwareNotifier.this.extendBlock;
                    LifecycleOwner viewLifecycleOwner2 = RFWViewLifecycleUtil.getViewLifecycleOwner(recyclerView2, z16);
                    RFWLog.i("ViewHolderVisibleAwareNotifier", RFWLog.USR, "postRecyclerView getOwner:" + viewLifecycleOwner2 + " adapter:" + recyclerView.getAdapter());
                    ViewHolderVisibleAwareNotifier.this.lifecycleOwnerWrf = new WeakReference(viewLifecycleOwner2);
                    if (viewLifecycleOwner2 != null && (lifecycle2 = viewLifecycleOwner2.getLifecycle()) != null) {
                        lifecycle2.addObserver(ViewHolderVisibleAwareNotifier.this);
                    }
                }
            });
        }
        if (!this.enableVisibleAware) {
            this.notifyMode = NotifyMode.NONE;
            return;
        }
        if (recyclerView.getParent() instanceof ViewPager2) {
            this.notifyMode = NotifyMode.ON_PAGE_SELECT;
            ViewParent parent = recyclerView.getParent();
            if (parent != null) {
                ((ViewPager2) parent).registerOnPageChangeCallback(this.onPageChangeCallback);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
        }
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            this.notifyMode = NotifyMode.ON_SCROLL_AREA_VISIBLE;
            recyclerView.addOnScrollListener(this.onScrollListener);
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.registerAdapterDataObserver(this.adapterChangeListener);
                return;
            }
            return;
        }
        this.notifyMode = NotifyMode.ON_ATTACH_WINDOW;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @UiThread
    public final void notifyViewAttachedToWindow(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (RFWApplication.isDebug()) {
            RFWLog.i("ViewHolderVisibleAwareNotifier", RFWLog.USR, "notifyViewAttachedToWindow: attach hashCode" + viewHolder.hashCode() + " position:" + viewHolder.getAdapterPosition());
        }
        registerViewHolder(viewHolder);
        this.attachWindowViewHolders.add(new RFWComparableWeakRef<>(viewHolder));
        if ((viewHolder instanceof VisibleAware) && this.notifyMode != NotifyMode.NONE) {
            VisibleAware visibleAware = (VisibleAware) viewHolder;
            visibleAware.onAttachedChanged(true);
            NotifyMode notifyMode = this.notifyMode;
            if (notifyMode == NotifyMode.ON_ATTACH_WINDOW) {
                if (this.lifecycleVisible) {
                    visibleAware.onVisibleChanged(true);
                    logViewHolderStatus("notifyViewAttachedToWindow", viewHolder, true, true);
                    return;
                }
                return;
            }
            if (notifyMode == NotifyMode.ON_PAGE_SELECT && this.currentVisibleViewHolder == null && viewHolder.getAdapterPosition() == this.currentPagePos) {
                this.currentVisibleViewHolder = new RFWComparableWeakRef<>(viewHolder);
                if (this.lifecycleVisible) {
                    ((VisibleAware) viewHolder).onVisibleChanged(true);
                    logViewHolderStatus("notifyViewAttachedToWindow", viewHolder, true, true);
                    return;
                }
                return;
            }
            if (this.notifyMode == NotifyMode.ON_SCROLL_AREA_VISIBLE) {
                this.handler.removeCallbacks(this.triggerTask);
                this.handler.post(this.triggerTask);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @UiThread
    public final void notifyViewDetachedFromWindow(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (RFWApplication.isDebug()) {
            RFWLog.i("ViewHolderVisibleAwareNotifier", RFWLog.USR, "notifyViewDetachedFromWindow: detached: hashCode" + viewHolder.hashCode() + " position:" + viewHolder.getAdapterPosition());
        }
        this.attachWindowViewHolders.remove(new RFWComparableWeakRef(viewHolder));
        if ((viewHolder instanceof VisibleAware) && this.notifyMode != NotifyMode.NONE) {
            VisibleAware visibleAware = (VisibleAware) viewHolder;
            visibleAware.onAttachedChanged(false);
            NotifyMode notifyMode = this.notifyMode;
            if (notifyMode == NotifyMode.ON_ATTACH_WINDOW) {
                visibleAware.onVisibleChanged(false);
            } else if (notifyMode == NotifyMode.ON_SCROLL_AREA_VISIBLE && this.visibleViewHolders.remove(new RFWComparableWeakRef(viewHolder))) {
                visibleAware.onVisibleChanged(false);
                logViewHolderStatus("notifyViewDetachedFromWindow", viewHolder, false, false);
            }
        }
    }

    @UiThread
    public final void notifyViewRecycled(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (this.notifyMode == NotifyMode.ON_SCROLL_AREA_VISIBLE && RFWApplication.isDebug()) {
            RFWLog.i("ViewHolderVisibleAwareNotifier", RFWLog.USR, "viewRecycled: " + viewHolder.getAdapterPosition());
        }
    }

    public abstract void onAwareDestroyed();

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME) {
            onVisibleChanged(true);
        } else if (event == Lifecycle.Event.ON_PAUSE) {
            onVisibleChanged(false);
        }
        if (event == Lifecycle.Event.ON_DESTROY) {
            if (RFWApplication.isDebug()) {
                RFWLog.i("ViewHolderVisibleAwareNotifier", RFWLog.USR, "source:" + source + " destroy");
            }
            onDestroy();
            source.getLifecycle().removeObserver(this);
        }
    }

    public final void registerViewHolder(@NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        this.allViewHolders.add(new RFWComparableWeakRef<>(viewHolder));
    }

    @UiThread
    public final void unInstall() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        WeakReference<LifecycleOwner> weakReference = this.lifecycleOwnerWrf;
        if (weakReference != null && (lifecycleOwner = weakReference.get()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
    }
}
