package com.tencent.mobileqq.guild.feed.mvi;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.guild.feed.mvi.b;
import com.tencent.mobileqq.guild.feed.mvi.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0002J\u000f\u0010\n\u001a\u00028\u0000H$\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00018\u00008\u00000\fJ+\u0010\u0014\u001a\u00020\b2!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00028\u00000\u000fH\u0004J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aR)\u0010\u001f\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00018\u00008\u00000\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR)\u0010#\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00018\u00008\u00000\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\"R!\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010&R\u0011\u0010)\u001a\u00028\u00008F\u00a2\u0006\u0006\u001a\u0004\b(\u0010\u000b\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/mvi/BaseViewModel;", "Lcom/tencent/mobileqq/guild/feed/mvi/b;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/feed/mvi/c;", "I", "Landroidx/lifecycle/ViewModel;", "Lkotlinx/coroutines/channels/Channel;", WadlProxyConsts.CHANNEL, "", "P1", "W1", "()Lcom/tencent/mobileqq/guild/feed/mvi/b;", "Landroidx/lifecycle/LiveData;", "kotlin.jvm.PlatformType", "X1", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, "update", ICustomDataEditor.STRING_ARRAY_PARAM_2, "i", "Z1", "(Lcom/tencent/mobileqq/guild/feed/mvi/c;)V", "replayState", "U1", "(Lcom/tencent/mobileqq/guild/feed/mvi/c;Lcom/tencent/mobileqq/guild/feed/mvi/b;)V", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Lazy;", "S1", "()Landroidx/lifecycle/MutableLiveData;", "uiStateLiveData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Q1", "()Landroidx/lifecycle/LiveData;", "state", BdhLogUtil.LogTag.Tag_Conn, "T1", "()Lkotlinx/coroutines/channels/Channel;", "_action", "R1", "uiState", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class BaseViewModel<S extends b, I extends c> extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy _action;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy uiStateLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy state;

    public BaseViewModel() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MutableLiveData<S>>(this) { // from class: com.tencent.mobileqq.guild.feed.mvi.BaseViewModel$uiStateLiveData$2
            final /* synthetic */ BaseViewModel<S, I> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MutableLiveData<S> invoke() {
                return new MutableLiveData<>(this.this$0.W1());
            }
        });
        this.uiStateLiveData = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LiveData<S>>(this) { // from class: com.tencent.mobileqq.guild.feed.mvi.BaseViewModel$state$2
            final /* synthetic */ BaseViewModel<S, I> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveData<S> invoke() {
                MutableLiveData S1;
                S1 = this.this$0.S1();
                LiveData<S> distinctUntilChanged = Transformations.distinctUntilChanged(S1);
                Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "distinctUntilChanged(this)");
                return distinctUntilChanged;
            }
        });
        this.state = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Channel<I>>(this) { // from class: com.tencent.mobileqq.guild.feed.mvi.BaseViewModel$_action$2
            final /* synthetic */ BaseViewModel<S, I> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Channel<I> invoke() {
                Channel<I> Channel$default = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
                this.this$0.P1(Channel$default);
                return Channel$default;
            }
        });
        this._action = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1(Channel<I> channel) {
        FlowKt.launchIn(FlowKt.onEach(FlowKt.consumeAsFlow(channel), new BaseViewModel$collectIntent$1(this, null)), ViewModelKt.getViewModelScope(this));
    }

    private final LiveData<S> Q1() {
        return (LiveData) this.state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableLiveData<S> S1() {
        return (MutableLiveData) this.uiStateLiveData.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Channel<I> T1() {
        return (Channel) this._action.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(BaseViewModel this$0, Function1 update) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(update, "$update");
        S value = this$0.S1().getValue();
        Intrinsics.checkNotNull(value);
        this$0.S1().setValue((b) update.invoke(value));
    }

    @NotNull
    public final S R1() {
        S value = S1().getValue();
        Intrinsics.checkNotNull(value);
        return value;
    }

    public void U1(@NotNull I i3, @NotNull S replayState) {
        Intrinsics.checkNotNullParameter(i3, "i");
        Intrinsics.checkNotNullParameter(replayState, "replayState");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract S W1();

    @NotNull
    public final LiveData<S> X1() {
        return Q1();
    }

    public final void Z1(@NotNull I i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new BaseViewModel$sendIntent$1(this, i3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a2(@NotNull final Function1<? super S, ? extends S> update) {
        Intrinsics.checkNotNullParameter(update, "update");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.mvi.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseViewModel.b2(BaseViewModel.this, update);
            }
        });
    }
}
