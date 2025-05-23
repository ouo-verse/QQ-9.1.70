package com.tencent.mobileqq.guild.channellist;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.summary.GuildSummaryUIData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.util.WeakReferenceHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import st1.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010&\u001a\u00020\u0017\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u000f\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00130\u0012H\u0002J\u001a\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00130\u0015H\u0002J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00190\u00132\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J.\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0000\u0010\u001b*\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020\u0004J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0016R\u0014\u0010&\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010%R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/s;", "Landroid/os/Handler$Callback;", "", "delay", "", "b", "c", "com/tencent/mobileqq/guild/channellist/s$b", "j", "()Lcom/tencent/mobileqq/guild/channellist/s$b;", "i", "", "source", tl.h.F, "Landroid/view/View;", "view", "", "d", "", "Lkotlin/Pair;", "f", "", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "", "g", "T", "start", "end", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "k", "Landroid/os/Message;", "msg", "", "handleMessage", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class s implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/channellist/s$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState == 0 && !s.this.handler.hasMessages(10)) {
                s.this.handler.sendEmptyMessageDelayed(10, 250L);
            }
        }
    }

    public s(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        this.handler = new WeakReferenceHandler(Looper.getMainLooper(), this);
        recyclerView.addOnScrollListener(j());
    }

    private final void b(long delay) {
        if (!this.handler.hasMessages(10)) {
            this.handler.sendEmptyMessageDelayed(10, delay);
        }
        if (!this.handler.hasMessages(11)) {
            this.handler.sendEmptyMessageDelayed(11, delay);
        }
        Logger.f235387a.d().i("Guild.NewHome.subFrag.SummaryRefreshHelper", 1, "beginTimer");
    }

    private final void c() {
        this.handler.removeMessages(10);
        this.handler.removeMessages(11);
        Logger.f235387a.d().i("Guild.NewHome.subFrag.SummaryRefreshHelper", 1, "endTimer");
    }

    private final Object d(View view) {
        if (view != null) {
            return view.getTag(R.id.w1p);
        }
        return null;
    }

    private final List<Pair<String, String>> e() {
        List<Pair<String, String>> emptyList;
        List plus;
        int collectionSizeOrDefault;
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (!(adapter instanceof com.tencent.mobileqq.guild.channellist.b)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        Pair<Integer, Integer> g16 = g(this.recyclerView);
        Pair pair = TuplesKt.to(Integer.valueOf(Math.max(0, g16.getFirst().intValue())), g16.getSecond());
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        List<c> items = ((com.tencent.mobileqq.guild.channellist.b) adapter).getItems();
        Intrinsics.checkNotNullExpressionValue(items, "items");
        plus = CollectionsKt___CollectionsKt.plus((Collection) m(items, Math.max(0, intValue - 15), intValue), (Iterable) m(items, intValue2, Math.min(items.size(), intValue2 + 15)));
        ArrayList<TextChannelData> arrayList = new ArrayList();
        for (Object obj : plus) {
            if (obj instanceof TextChannelData) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (TextChannelData textChannelData : arrayList) {
            arrayList2.add(new Pair(String.valueOf(textChannelData.getGuildId()), String.valueOf(textChannelData.getChannelUin())));
        }
        return arrayList2;
    }

    private final List<Pair<String, String>> f() {
        ArrayList arrayList = new ArrayList();
        int childCount = this.recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            Object d16 = d(this.recyclerView.getChildAt(i3));
            if (d16 instanceof TextChannelData) {
                TextChannelData textChannelData = (TextChannelData) d16;
                arrayList.add(new Pair(String.valueOf(textChannelData.getGuildId()), String.valueOf(textChannelData.getChannelUin())));
            } else if (d16 instanceof AppChannelData) {
                AppChannelData appChannelData = (AppChannelData) d16;
                arrayList.add(new Pair(String.valueOf(appChannelData.getGuildId()), String.valueOf(appChannelData.getChannelUin())));
            }
        }
        return arrayList;
    }

    private final Pair<Integer, Integer> g(RecyclerView recycleView) {
        RecyclerView.LayoutManager layoutManager = recycleView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        return new Pair<>(Integer.valueOf(linearLayoutManager.findFirstVisibleItemPosition()), Integer.valueOf(linearLayoutManager.findLastVisibleItemPosition()));
    }

    private final void h(String source) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Object first;
        List<Pair<String, String>> f16 = f();
        List<Pair<String, String>> e16 = e();
        ArrayList arrayList = new ArrayList();
        List<Pair<String, String>> list = f16;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList2.add(new f.PullParam((String) pair.getFirst(), (String) pair.getSecond()));
        }
        arrayList.addAll(arrayList2);
        List<Pair<String, String>> list2 = e16;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            Pair pair2 = (Pair) it5.next();
            arrayList3.add(new f.PullParam((String) pair2.getFirst(), (String) pair2.getSecond()));
        }
        arrayList.addAll(arrayList3);
        if (arrayList.isEmpty()) {
            return;
        }
        com.tencent.mobileqq.guild.message.summary.b bVar = com.tencent.mobileqq.guild.message.summary.b.f230813a;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
        bVar.a(arrayList, !ch.j0(((f.PullParam) first).getGuildId()));
    }

    private final void i() {
        List listOf;
        List listOf2;
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0) {
            return;
        }
        int childCount = this.recyclerView.getChildCount() - 1;
        for (int i3 = 0; i3 < childCount; i3++) {
            Object d16 = d(this.recyclerView.getChildAt(i3));
            if (d16 instanceof TextChannelData) {
                TextChannelData textChannelData = (TextChannelData) d16;
                if (textChannelData.getMsgData().getSummaryUIData() != null) {
                    GuildSummaryUIData summaryUIData = textChannelData.getMsgData().getSummaryUIData();
                    Intrinsics.checkNotNull(summaryUIData);
                    if (summaryUIData.getLastTime() > 0) {
                        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(7);
                        adapter.notifyItemChanged(i3 + findFirstVisibleItemPosition, listOf2);
                    }
                }
            } else if (d16 instanceof AppChannelData) {
                AppChannelData appChannelData = (AppChannelData) d16;
                if (appChannelData.getMsgData().getSummaryUIData() != null) {
                    GuildSummaryUIData summaryUIData2 = appChannelData.getMsgData().getSummaryUIData();
                    Intrinsics.checkNotNull(summaryUIData2);
                    if (summaryUIData2.getLastTime() > 0) {
                        listOf = CollectionsKt__CollectionsJVMKt.listOf(7);
                        adapter.notifyItemChanged(i3 + findFirstVisibleItemPosition, listOf);
                    }
                }
            }
        }
    }

    private final b j() {
        return new b();
    }

    private final <T> List<T> m(List<T> list, int i3, int i16) {
        Pair pair;
        try {
            if (i3 <= i16) {
                pair = TuplesKt.to(Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                pair = TuplesKt.to(Integer.valueOf(i16), Integer.valueOf(i3));
            }
            int intValue = ((Number) pair.component1()).intValue();
            int intValue2 = ((Number) pair.component2()).intValue();
            if (intValue < 0) {
                intValue = 0;
            }
            if (intValue2 > list.size()) {
                intValue2 = list.size();
            }
            return list.subList(intValue, intValue2);
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 != 10) {
            if (i3 != 11) {
                return false;
            }
            if (!this.handler.hasMessages(11)) {
                this.handler.sendEmptyMessageDelayed(11, 60000L);
            }
            i();
            return true;
        }
        if (!this.handler.hasMessages(10)) {
            this.handler.sendEmptyMessageDelayed(10, 2000L);
        }
        h("TIMER");
        return true;
    }

    public final void k() {
        c();
    }

    public final void l() {
        b(500L);
    }
}
