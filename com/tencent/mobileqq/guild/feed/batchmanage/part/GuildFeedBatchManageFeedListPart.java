package com.tencent.mobileqq.guild.feed.batchmanage.part;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareItemDiffCallback;
import com.tencent.mobileqq.guild.feed.feedsquare.adapter.GuildFeedSquareListAdapter;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils;
import com.tencent.mobileqq.guild.feed.util.RecyclerViewExtKt;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\f*\u0002*5\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001c\u0010\f\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\u0002J\u001e\u0010\u0011\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001c\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0017J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001aH\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u0004\u0018\u00010\u00178VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageFeedListPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lvi1/e;", "Lco1/g;", "", "F9", "C9", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij1/g;", "uiStateData", "E9", "D9", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "items", "", "scrollTop", "H9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "position", "m6", "notifyDataSetChanged", "", "payload", "U0", "y", "V3", "B1", "g6", "onPartDestroy", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "feedRecyclerView", "com/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageFeedListPart$b", "e", "Lcom/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageFeedListPart$b;", "adapterHolder", "Lcom/tencent/mobileqq/guild/feed/batchmanage/viewmodel/e;", "f", "Lcom/tencent/mobileqq/guild/feed/batchmanage/viewmodel/e;", "viewModel", tl.h.F, "Z", "isFirstScreenListLoaded", "com/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageFeedListPart$c", "i", "Lcom/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageFeedListPart$c;", "loadMoreListener", "O0", "()Landroid/view/View;", "hostView", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedBatchManageFeedListPart extends Part implements vi1.e, co1.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView feedRecyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e viewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstScreenListLoaded;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b adapterHolder = new b();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c loadMoreListener = new c();

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u0012\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00020\u001f8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0005\u0010 \u001a\u0004\b\u000b\u0010!\"\u0004\b\"\u0010#\u00a8\u0006%"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageFeedListPart$b", "", "", "a", "Z", "e", "()Z", "i", "(Z)V", "isInitialized", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "b", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "()Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "f", "(Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;)V", "concatAdapter", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;", "c", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;", "d", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;", "j", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;)V", "loadMoreAdapter", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareListAdapter;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareListAdapter;", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareListAdapter;", tl.h.F, "(Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/GuildFeedSquareListAdapter;)V", "feedListAdapter", "Lwi1/c;", "Lwi1/c;", "()Lwi1/c;", "g", "(Lwi1/c;)V", "emptyAdapter", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isInitialized;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public RFWConcatAdapter concatAdapter;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public com.tencent.mobileqq.guild.feed.feedsquare.adapter.j loadMoreAdapter;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public GuildFeedSquareListAdapter feedListAdapter;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public wi1.c emptyAdapter;

        b() {
        }

        @NotNull
        public final RFWConcatAdapter a() {
            RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
            if (rFWConcatAdapter != null) {
                return rFWConcatAdapter;
            }
            Intrinsics.throwUninitializedPropertyAccessException("concatAdapter");
            return null;
        }

        @NotNull
        public final wi1.c b() {
            wi1.c cVar = this.emptyAdapter;
            if (cVar != null) {
                return cVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("emptyAdapter");
            return null;
        }

        @NotNull
        public final GuildFeedSquareListAdapter c() {
            GuildFeedSquareListAdapter guildFeedSquareListAdapter = this.feedListAdapter;
            if (guildFeedSquareListAdapter != null) {
                return guildFeedSquareListAdapter;
            }
            Intrinsics.throwUninitializedPropertyAccessException("feedListAdapter");
            return null;
        }

        @NotNull
        public final com.tencent.mobileqq.guild.feed.feedsquare.adapter.j d() {
            com.tencent.mobileqq.guild.feed.feedsquare.adapter.j jVar = this.loadMoreAdapter;
            if (jVar != null) {
                return jVar;
            }
            Intrinsics.throwUninitializedPropertyAccessException("loadMoreAdapter");
            return null;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsInitialized() {
            return this.isInitialized;
        }

        public final void f(@NotNull RFWConcatAdapter rFWConcatAdapter) {
            Intrinsics.checkNotNullParameter(rFWConcatAdapter, "<set-?>");
            this.concatAdapter = rFWConcatAdapter;
        }

        public final void g(@NotNull wi1.c cVar) {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.emptyAdapter = cVar;
        }

        public final void h(@NotNull GuildFeedSquareListAdapter guildFeedSquareListAdapter) {
            Intrinsics.checkNotNullParameter(guildFeedSquareListAdapter, "<set-?>");
            this.feedListAdapter = guildFeedSquareListAdapter;
        }

        public final void i(boolean z16) {
            this.isInitialized = z16;
        }

        public final void j(@NotNull com.tencent.mobileqq.guild.feed.feedsquare.adapter.j jVar) {
            Intrinsics.checkNotNullParameter(jVar, "<set-?>");
            this.loadMoreAdapter = jVar;
        }
    }

    private final void C9() {
        RecyclerView recyclerView = this.feedRecyclerView;
        if (recyclerView == null) {
            return;
        }
        Intrinsics.checkNotNull(recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView recyclerView2 = this.feedRecyclerView;
        Intrinsics.checkNotNull(recyclerView2);
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext());
        safeLinearLayoutManager.setOrientation(1);
        recyclerView2.setLayoutManager(safeLinearLayoutManager);
        RecyclerView recyclerView3 = this.feedRecyclerView;
        Intrinsics.checkNotNull(recyclerView3);
        recyclerView3.setItemAnimator(null);
        RecyclerView recyclerView4 = this.feedRecyclerView;
        Intrinsics.checkNotNull(recyclerView4);
        recyclerView4.setOverScrollMode(2);
    }

    private final void D9(UIStateData<List<ij1.g>> uiStateData) {
        this.adapterHolder.c().setItems(new ArrayList());
        this.adapterHolder.d().setLoadState(false, !uiStateData.getIsFinish());
        if (!uiStateData.getIsLoadMore()) {
            this.adapterHolder.d().hide();
        }
        if (uiStateData.getIsFinish()) {
            this.adapterHolder.b().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9(UIStateData<List<ij1.g>> uiStateData) {
        Integer num;
        ArrayList arrayList;
        boolean z16;
        boolean z17;
        int state = uiStateData.getState();
        List<ij1.g> data = uiStateData.getData();
        if (data != null) {
            num = Integer.valueOf(data.size());
        } else {
            num = null;
        }
        QLog.i("GuildFeedBatchManageFeedListPart", 1, "handlerUiStatus, state[" + state + "], size[" + num + "], loadMore[" + uiStateData.getIsLoadMore() + "], isFinish[" + uiStateData.getIsFinish() + "], isCache[" + uiStateData.isCacheData() + "]");
        if (uiStateData.getState() == 0) {
            D9(uiStateData);
            return;
        }
        if (com.tencent.mobileqq.guild.feed.feedsquare.utils.s.a(uiStateData, UIStateDataUtils.InsertType.NewFeed)) {
            if (this.adapterHolder.c().getItems() != null && (!r0.isEmpty())) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                Logger.f235387a.d().i("GuildFeedBatchManageFeedListPart", 1, "handlerUiStatus is insert from pushNewFeed");
                return;
            }
        }
        List<ij1.g> data2 = uiStateData.getData();
        if (data2 != null) {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : data2) {
                if (com.tencent.mobileqq.guild.feed.batchmanage.b.INSTANCE.a((ij1.g) obj)) {
                    arrayList2.add(obj);
                }
            }
            arrayList = new ArrayList();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.mobileqq.guild.feed.feedsquare.data.h((ij1.g) it.next()));
            }
        } else {
            arrayList = new ArrayList();
        }
        if (uiStateData.getPos() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        H9(arrayList, z16);
        com.tencent.mobileqq.guild.feed.feedsquare.adapter.j d16 = this.adapterHolder.d();
        d16.show();
        d16.setLoadState(false, !uiStateData.getIsFinish());
    }

    private final void F9() {
        b bVar = this.adapterHolder;
        bVar.g(new wi1.c());
        GuildFeedSquareListAdapter guildFeedSquareListAdapter = new GuildFeedSquareListAdapter(new GuildFeedSquareItemDiffCallback(), yj1.d.f450494a);
        guildFeedSquareListAdapter.setHasStableIds(true);
        bVar.h(guildFeedSquareListAdapter);
        com.tencent.mobileqq.guild.feed.feedsquare.adapter.j jVar = new com.tencent.mobileqq.guild.feed.feedsquare.adapter.j(0, 0, 0, 7, null);
        jVar.setHasStableIds(true);
        jVar.registerLoadMoreListener(this.loadMoreListener);
        jVar.i0("\u6682\u65e0\u66f4\u591a\u5185\u5bb9");
        bVar.j(jVar);
        bVar.f(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(false).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{bVar.b(), bVar.c(), bVar.d()}));
        bVar.i(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void H9(final List<com.tencent.mobileqq.guild.feed.feedsquare.data.h> items, final boolean scrollTop) {
        if (items.size() > 0) {
            this.adapterHolder.b().hide();
        }
        this.adapterHolder.c().setItems(items, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.o
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedBatchManageFeedListPart.I9(scrollTop, this, items);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(boolean z16, GuildFeedBatchManageFeedListPart this$0, List items) {
        String str;
        long j3;
        Intent intent;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(items, "$items");
        boolean z17 = false;
        if (z16) {
            this$0.B1(0);
        }
        if (this$0.isFirstScreenListLoaded) {
            this$0.isFirstScreenListLoaded = false;
            Activity activity = this$0.getActivity();
            if (activity != null && (intent = activity.getIntent()) != null) {
                str = intent.getStringExtra("default_select_feed_id");
            } else {
                str = null;
            }
            Iterator it = items.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(((com.tencent.mobileqq.guild.feed.feedsquare.data.h) it.next()).getBlockData().b().idd, str)) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0 && i3 < items.size()) {
                z17 = true;
            }
            if (z17) {
                j3 = ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) items.get(i3)).getBlockData().b().channelInfo.sign.channelId;
            } else {
                j3 = 0;
            }
            this$0.broadcastMessage("broadcast_first_screen_dataset", new Pair(Integer.valueOf(i3), Long.valueOf(j3)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
    
        if (r4 >= r0) goto L10;
     */
    @Override // vi1.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void B1(int position) {
        int i3;
        RecyclerView.Adapter adapter;
        if (position >= 0) {
            RecyclerView recyclerView = this.feedRecyclerView;
            if (recyclerView != null && (adapter = recyclerView.getAdapter()) != null) {
                i3 = adapter.getNUM_BACKGOURND_ICON();
            } else {
                i3 = 0;
            }
        }
        QLog.w("GuildFeedBatchManageFeedListPart", 1, "scroll to invalid position: " + position);
        RecyclerView recyclerView2 = this.feedRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.scrollToPosition(position);
        }
    }

    @Override // co1.g
    @Nullable
    public View O0() {
        return this.feedRecyclerView;
    }

    @Override // vi1.a
    public void U0(@NotNull Object payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (this.adapterHolder.getIsInitialized()) {
            GuildFeedSquareListAdapter c16 = this.adapterHolder.c();
            c16.notifyItemRangeChanged(0, c16.getNUM_BACKGOURND_ICON(), payload);
        }
    }

    @Override // vi1.h
    public void g6() {
        RecyclerView recyclerView = this.feedRecyclerView;
        if (recyclerView != null) {
            RecyclerViewExtKt.b(recyclerView);
        }
    }

    @Override // vi1.a
    public void m6(int position) {
        if (this.adapterHolder.getIsInitialized()) {
            this.adapterHolder.c().notifyItemChanged(position);
        }
    }

    @Override // vi1.a
    @SuppressLint({"NotifyDataSetChanged"})
    public void notifyDataSetChanged() {
        if (this.adapterHolder.getIsInitialized()) {
            this.adapterHolder.c().notifyDataSetChanged();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        RecyclerView recyclerView = new RecyclerView(getContext());
        LinearLayout linearLayout = (LinearLayout) rootView.findViewById(R.id.f166090ed2);
        int childCount = linearLayout.getChildCount() - 1;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 1.0f;
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(recyclerView, childCount, layoutParams);
        this.feedRecyclerView = recyclerView;
        C9();
        F9();
        RecyclerView recyclerView2 = this.feedRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.adapterHolder.a());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        LiveData<UIStateData<List<ij1.g>>> b26;
        super.onPartCreate(activity, savedInstanceState);
        RFWIocAbilityProvider.g().registerIoc(getPartRootView(), this, vi1.e.class);
        com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e eVar = (com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e) getViewModel(com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e.class);
        this.viewModel = eVar;
        if (eVar != null && (b26 = eVar.b2()) != null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            final GuildFeedBatchManageFeedListPart$onPartCreate$1 guildFeedBatchManageFeedListPart$onPartCreate$1 = new GuildFeedBatchManageFeedListPart$onPartCreate$1(this);
            b26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.part.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedBatchManageFeedListPart.G9(Function1.this, obj);
                }
            });
        }
        this.isFirstScreenListLoaded = true;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        this.adapterHolder.d().unRegisterLoadMoreListener(this.loadMoreListener);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), vi1.e.class);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/batchmanage/part/GuildFeedBatchManageFeedListPart$c", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ILoadMoreProvider$LoadMoreListener {
        c() {
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreStart() {
            com.tencent.mobileqq.guild.feed.batchmanage.viewmodel.e eVar = GuildFeedBatchManageFeedListPart.this.viewModel;
            if (eVar != null) {
                eVar.loadMore();
            }
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreEnd(boolean hasMore) {
        }
    }

    @Override // vi1.h
    public void V3(int y16) {
    }
}
