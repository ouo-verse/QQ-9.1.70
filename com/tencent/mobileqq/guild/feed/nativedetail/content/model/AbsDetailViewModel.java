package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.guild.feed.nativedetail.content.model.v;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bC\u0010DJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u001c\u0010\t\u001a\u00020\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u001c\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u001c\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u001c\u0010\u0013\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u001c\u0010\u0015\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eJ\u001c\u0010\u0016\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u001e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fJ\u0018\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010$\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u0018\u0010%\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aR\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010'R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000f0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00140&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010'R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010'R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u000f0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010'R'\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u000b03j\b\u0012\u0004\u0012\u00020\u000b`48\u0006\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00030>8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010?\u001a\u0004\b@\u0010A\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/AbsDetailViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/v;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/u;", "i", "", "U1", "Lkotlin/Function1;", "eventHandler", "L", "", "Lhl1/g;", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/x;", "observer", "F1", "N", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/c;", "d", "A1", "I", "", "message", "", "msgObject", "S1", "Q1", "R1", "", "dataChangedSource", "O1", "payload", "P1", "N1", "T1", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "preloadState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "loadDataState", BdhLogUtil.LogTag.Tag_Conn, "loadMoreState", "D", "dataChangedState", "E", "itemDataChangedState", UserInfo.SEX_FEMALE, "reloadState", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "G", "Ljava/util/ArrayList;", "M1", "()Ljava/util/ArrayList;", "contentDataList", "Lkotlinx/coroutines/channels/Channel;", "H", "Lkotlinx/coroutines/channels/Channel;", "eventChannel", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/Flow;", "getEventFlow", "()Lkotlinx/coroutines/flow/Flow;", "eventFlow", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class AbsDetailViewModel extends BaseViewModel implements v {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Channel<u> eventChannel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Flow<u> eventFlow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<x> preloadState = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<x> loadDataState = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<x> loadMoreState = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<DataChangedState> dataChangedState = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<x> itemDataChangedState = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<x> reloadState = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<hl1.g> contentDataList = new ArrayList<>();

    public AbsDetailViewModel() {
        Channel<u> Channel$default = ChannelKt.Channel$default(0, null, null, 7, null);
        this.eventChannel = Channel$default;
        this.eventFlow = FlowKt.receiveAsFlow(Channel$default);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public final void A1(@NotNull LifecycleOwner owner, @NotNull Observer<x> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.reloadState.observe(owner, observer);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public final void F1(@NotNull LifecycleOwner owner, @NotNull Observer<x> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.preloadState.observe(owner, observer);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void I(@NotNull LifecycleOwner owner, @NotNull Observer<x> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.itemDataChangedState.observe(owner, observer);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void L(@NotNull Function1<? super u, Unit> eventHandler) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        FlowKt.launchIn(FlowKt.onEach(FlowKt.consumeAsFlow(this.eventChannel), new AbsDetailViewModel$collectEventFlow$1(eventHandler, null)), ViewModelKt.getViewModelScope(this));
    }

    @NotNull
    public final ArrayList<hl1.g> M1() {
        return this.contentDataList;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public final void N(@NotNull LifecycleOwner owner, @NotNull Observer<x> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.loadDataState.observe(owner, observer);
    }

    public final void N1(@NotNull String message, @Nullable Object msgObject) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.itemDataChangedState.setValue(new x(message, msgObject));
    }

    public final void O1(int dataChangedSource) {
        this.dataChangedState.setValue(new DataChangedState(dataChangedSource, null, 2, null));
    }

    public final void P1(int dataChangedSource, @Nullable Object payload) {
        this.dataChangedState.setValue(new DataChangedState(dataChangedSource, payload));
    }

    public final void Q1(@NotNull String message, @Nullable Object msgObject) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.loadDataState.setValue(new x(message, msgObject));
    }

    public final void R1(@NotNull String message, @Nullable Object msgObject) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.loadMoreState.setValue(new x(message, msgObject));
    }

    public final void S1(@NotNull String message, @Nullable Object msgObject) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.preloadState.setValue(new x(message, msgObject));
    }

    public final void T1(@NotNull String message, @Nullable Object msgObject) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.reloadState.setValue(new x(message, msgObject));
    }

    public final void U1(@NotNull u i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AbsDetailViewModel$sendEvent$1(this, i3, null), 3, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    @Nullable
    public Object a0(@Nullable String str, @Nullable Object obj) {
        return v.a.a(this, str, obj);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public final void b(@NotNull LifecycleOwner owner, @NotNull Observer<x> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.loadMoreState.observe(owner, observer);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public boolean c(@Nullable String str, @Nullable Object obj) {
        return v.a.b(this, str, obj);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public final void d(@NotNull LifecycleOwner owner, @NotNull Observer<DataChangedState> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.dataChangedState.observe(owner, observer);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    @NotNull
    public final List<hl1.g> i() {
        return this.contentDataList;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void onDestroy() {
        v.a.c(this);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void s(@NotNull LoadDataArgs loadDataArgs) {
        v.a.d(this, loadDataArgs);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.model.v
    public void t0(@NotNull LoadDataArgs loadDataArgs) {
        v.a.e(this, loadDataArgs);
    }
}
