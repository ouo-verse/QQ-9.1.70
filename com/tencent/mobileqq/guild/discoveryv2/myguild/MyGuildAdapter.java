package com.tencent.mobileqq.guild.discoveryv2.myguild;

import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003'()B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b%\u0010&J,\u0010\u000b\u001a\u00020\n2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\f\u001a\u00020\nJ\u0014\u0010\u000f\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\rJ\u0006\u0010\u0010\u001a\u00020\nR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010$\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d8\u0006@BX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0012\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildAdapter;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/h;", "", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/j;", "myGuildList", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/aa;", "myGuildRecommendList", "Ljava/lang/Runnable;", "commitCallback", "", "q0", "showEmptyView", "Lkotlin/Function0;", "refreshBlock", "p0", "n0", "Lcom/tencent/mobileqq/guild/q;", "I", "Lcom/tencent/mobileqq/guild/q;", "iChangeTopCallback", "", "J", "Ljava/util/List;", "l0", "()Ljava/util/List;", "setMyGuildRecommends", "(Ljava/util/List;)V", "myGuildRecommends", "", "<set-?>", "K", "m0", "()I", "getUiState$annotations", "()V", "uiState", "<init>", "(Lcom/tencent/mobileqq/guild/q;)V", "a", "UiState", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MyGuildAdapter extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<h> {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.q iChangeTopCallback;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private List<MyGuildRecommendData> myGuildRecommends;

    /* renamed from: K, reason: from kotlin metadata */
    private int uiState;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildAdapter$UiState;", "", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes13.dex */
    public @interface UiState {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.f217507a;
        public static final int EMPTY_VIEW = 2;
        public static final int MY_GUILD_AND_RECOMMEND_GUILD = 5;
        public static final int NO_DATA = 0;
        public static final int NO_NETWORK = 1;
        public static final int ONLY_MY_GUILD = 3;
        public static final int ONLY_RECOMMEND_GUILD = 4;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildAdapter$UiState$a;", "", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.discoveryv2.myguild.MyGuildAdapter$UiState$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f217507a = new Companion();

            Companion() {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildAdapter$a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/h;", "p0", "p1", "", "b", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a extends DiffUtil.ItemCallback<h> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull h p06, @NotNull h p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            return Intrinsics.areEqual(p06, p16);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull h p06, @NotNull h p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            Intrinsics.checkNotNullParameter(p16, "p1");
            if (p06 == p16) {
                return true;
            }
            if ((p06 instanceof MyGuildData) && (p16 instanceof MyGuildData)) {
                return Intrinsics.areEqual(((MyGuildData) p06).getGuildId(), ((MyGuildData) p16).getGuildId());
            }
            if ((p06 instanceof MyGuildRecommendData) && (p16 instanceof MyGuildRecommendData)) {
                return Intrinsics.areEqual(((MyGuildRecommendData) p06).getGuildId(), ((MyGuildRecommendData) p16).getGuildId());
            }
            return Intrinsics.areEqual(p06.getClass(), p16.getClass());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\b\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildAdapter$b;", "Landroidx/viewbinding/ViewBinding;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "E", "Landroidx/viewbinding/ViewBinding;", "l", "()Landroidx/viewbinding/ViewBinding;", "binding", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b<T extends ViewBinding> extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final T binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull T binding) {
            super(binding.getMRv());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        @NotNull
        public final T l() {
            return this.binding;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyGuildAdapter(@NotNull com.tencent.mobileqq.guild.q iChangeTopCallback) {
        super(new a(), new com.tencent.mobileqq.guild.widget.adapterdelegates.h());
        Intrinsics.checkNotNullParameter(iChangeTopCallback, "iChangeTopCallback");
        this.iChangeTopCallback = iChangeTopCallback;
        this.myGuildRecommends = new ArrayList();
        this.f236209m.c(new MyGuildTopAnchorDelegate());
        this.f236209m.c(new MyGuildDelegate(iChangeTopCallback));
        this.f236209m.c(new MyGuildBottomSpaceDelegate());
        this.f236209m.c(new MyGuildEmptyDelegate());
        this.f236209m.c(new MyGuildNoNetworkDelegate());
        this.f236209m.c(new MyGuildSpaceDelegate());
        this.f236209m.c(new MyGuildRecommendTitleDelegate());
        this.f236209m.c(new MyGuildRecommendItemDelegate());
    }

    @NotNull
    public final List<MyGuildRecommendData> l0() {
        return this.myGuildRecommends;
    }

    /* renamed from: m0, reason: from getter */
    public final int getUiState() {
        return this.uiState;
    }

    public final void n0() {
        List emptyList;
        this.uiState = 0;
        AsyncListDiffer<T> asyncListDiffer = this.C;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        asyncListDiffer.submitList(emptyList);
    }

    public final void p0(@NotNull Function0<Unit> refreshBlock) {
        List listOf;
        Intrinsics.checkNotNullParameter(refreshBlock, "refreshBlock");
        this.uiState = 1;
        AsyncListDiffer<T> asyncListDiffer = this.C;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new MyGuildNoNetworkData(refreshBlock));
        asyncListDiffer.submitList(listOf);
    }

    public final void q0(@NotNull List<MyGuildData> myGuildList, @NotNull List<MyGuildRecommendData> myGuildRecommendList, @Nullable Runnable commitCallback) {
        List<MyGuildRecommendData> mutableList;
        List listOf;
        List plus;
        List plus2;
        List plus3;
        List plus4;
        List plus5;
        List listOf2;
        List plus6;
        List listOf3;
        List plus7;
        List plus8;
        List listOf4;
        Intrinsics.checkNotNullParameter(myGuildList, "myGuildList");
        Intrinsics.checkNotNullParameter(myGuildRecommendList, "myGuildRecommendList");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) myGuildRecommendList);
        this.myGuildRecommends = mutableList;
        if (myGuildList.isEmpty() && myGuildRecommendList.isEmpty()) {
            this.uiState = 2;
            AsyncListDiffer<T> asyncListDiffer = this.C;
            listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new h[]{am.f217557a, new MyGuildNoJoinedData(true)});
            asyncListDiffer.submitList(listOf4, commitCallback);
            return;
        }
        if (myGuildRecommendList.isEmpty()) {
            this.uiState = 3;
            AsyncListDiffer<T> asyncListDiffer2 = this.C;
            listOf3 = CollectionsKt__CollectionsJVMKt.listOf(am.f217557a);
            plus7 = CollectionsKt___CollectionsKt.plus((Collection) listOf3, (Iterable) myGuildList);
            plus8 = CollectionsKt___CollectionsKt.plus((Collection<? extends i>) ((Collection<? extends Object>) plus7), i.f217563a);
            asyncListDiffer2.submitList(plus8, commitCallback);
            return;
        }
        if (myGuildList.isEmpty()) {
            this.uiState = 4;
            AsyncListDiffer<T> asyncListDiffer3 = this.C;
            listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new h[]{am.f217557a, new MyGuildNoJoinedData(false), aj.f217555a});
            plus6 = CollectionsKt___CollectionsKt.plus((Collection) listOf2, (Iterable) myGuildRecommendList);
            asyncListDiffer3.submitList(plus6, commitCallback);
            return;
        }
        this.uiState = 5;
        AsyncListDiffer<T> asyncListDiffer4 = this.C;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(am.f217557a);
        plus = CollectionsKt___CollectionsKt.plus((Collection) listOf, (Iterable) myGuildList);
        plus2 = CollectionsKt___CollectionsKt.plus((Collection<? extends MyGuildSpaceData>) ((Collection<? extends Object>) plus), new MyGuildSpaceData(myGuildList.size()));
        plus3 = CollectionsKt___CollectionsKt.plus((Collection<? extends aj>) ((Collection<? extends Object>) plus2), aj.f217555a);
        plus4 = CollectionsKt___CollectionsKt.plus((Collection) plus3, (Iterable) myGuildRecommendList);
        plus5 = CollectionsKt___CollectionsKt.plus((Collection<? extends i>) ((Collection<? extends Object>) plus4), i.f217563a);
        asyncListDiffer4.submitList(plus5, commitCallback);
    }

    public final void showEmptyView() {
        List<MyGuildData> emptyList;
        List<MyGuildRecommendData> emptyList2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        q0(emptyList, emptyList2, new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.g
            @Override // java.lang.Runnable
            public final void run() {
                MyGuildAdapter.o0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0() {
    }
}
