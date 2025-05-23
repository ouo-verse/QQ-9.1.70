package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.event.QFSPublicAccountFollowUserReadEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import feedcloud.FeedCloudOfficialaccount$TopUserDetail;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001+B\u001d\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u001c\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010\u0016\u001a\u00020\u0006J\u0012\u0010\u0019\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0\u001aH\u0016R\u0014\u0010\u0013\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010 R \u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010#\u00a8\u0006,"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/QFSPublicAccountFollowListContainer;", "Landroid/widget/FrameLayout;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/qcircle/api/event/QFSPublicAccountFollowUserReadEvent;", "", "objectUin", "", "i", "", "Lfeedcloud/FeedCloudOfficialaccount$TopUserDetail;", "topUserDetails", "g", h.F, "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/a;", "f", "oldItem", "newItem", "", "d", "title", "users", "j", "e", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "userRecyclerView", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "observer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountFollowListContainer extends FrameLayout implements SimpleEventReceiver<QFSPublicAccountFollowUserReadEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView userRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<List<FeedCloudOfficialaccount$TopUserDetail>> observer;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/QFSPublicAccountFollowListContainer$b", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lfeedcloud/FeedCloudOfficialaccount$TopUserDetail;", "oldItem", "newItem", "", "b", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends DiffUtil.ItemCallback<FeedCloudOfficialaccount$TopUserDetail> {
        b() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull FeedCloudOfficialaccount$TopUserDetail oldItem, @NotNull FeedCloudOfficialaccount$TopUserDetail newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return QFSPublicAccountFollowListContainer.this.d(oldItem, newItem);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull FeedCloudOfficialaccount$TopUserDetail oldItem, @NotNull FeedCloudOfficialaccount$TopUserDetail newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return Intrinsics.areEqual(oldItem, newItem);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/QFSPublicAccountFollowListContainer$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traversePage(recyclerView);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPublicAccountFollowListContainer(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QFSPublicAccountFollowListContainer this$0, List topUserDetails) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(topUserDetails, "topUserDetails");
        this$0.g(topUserDetails);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d(FeedCloudOfficialaccount$TopUserDetail oldItem, FeedCloudOfficialaccount$TopUserDetail newItem) {
        if (Intrinsics.areEqual(oldItem.uin.get(), newItem.uin.get()) && oldItem.show_aperture.get() == newItem.show_aperture.get()) {
            return true;
        }
        return false;
    }

    private final a f() {
        if (this.userRecyclerView.getAdapter() != null) {
            RecyclerView.Adapter adapter = this.userRecyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist.QFSPublicAccountFollowListAdapter");
            return (a) adapter;
        }
        return new a(new b());
    }

    private final void g(List<FeedCloudOfficialaccount$TopUserDetail> topUserDetails) {
        if (topUserDetails.isEmpty()) {
            setVisibility(8);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
            return;
        }
        a f16 = f();
        setVisibility(0);
        this.userRecyclerView.setAdapter(f16);
        f16.submitList(topUserDetails);
        SimpleEventBus.getInstance().registerReceiver(this);
        h();
    }

    private final void h() {
        this.userRecyclerView.addOnScrollListener(new c());
    }

    private final void i(String objectUin) {
        RecyclerView.Adapter adapter;
        List<FeedCloudOfficialaccount$TopUserDetail> currentList = f().getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "adapter.currentList");
        int i3 = -1;
        int i16 = 0;
        for (Object obj : currentList) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            FeedCloudOfficialaccount$TopUserDetail feedCloudOfficialaccount$TopUserDetail = (FeedCloudOfficialaccount$TopUserDetail) obj;
            if (feedCloudOfficialaccount$TopUserDetail.show_aperture.get() && Intrinsics.areEqual(feedCloudOfficialaccount$TopUserDetail.uin.get(), objectUin)) {
                feedCloudOfficialaccount$TopUserDetail.show_aperture.set(false);
                i3 = i16;
            }
            i16 = i17;
        }
        if (i3 >= 0 && (adapter = this.userRecyclerView.getAdapter()) != null) {
            adapter.notifyItemChanged(i3);
        }
    }

    public final void e() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<QFSPublicAccountFollowUserReadEvent>> getEventClass() {
        ArrayList<Class<QFSPublicAccountFollowUserReadEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSPublicAccountFollowUserReadEvent.class);
        return arrayListOf;
    }

    public final void j(@NotNull String title, @NotNull List<FeedCloudOfficialaccount$TopUserDetail> users) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(users, "users");
        QLog.i("QFSPublicAccountFollowListContainer", 1, "updateUI, title:" + title + ", listSize:" + users.size());
        this.title.setText(title);
        this.observer.onChanged(users);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (!(event instanceof QFSPublicAccountFollowUserReadEvent)) {
            return;
        }
        i(((QFSPublicAccountFollowUserReadEvent) event).getUin());
    }

    public /* synthetic */ QFSPublicAccountFollowListContainer(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QFSPublicAccountFollowListContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.g59, (ViewGroup) this, true);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        View findViewById = findViewById(R.id.f31900sa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qcircl\u2026ublic_account_title_name)");
        this.title = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.f31890s_);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qcircl\u2026blic_account_follow_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.userRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        setVisibility(8);
        this.observer = new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPublicAccountFollowListContainer.b(QFSPublicAccountFollowListContainer.this, (List) obj);
            }
        };
    }
}
