package com.tencent.mobileqq.guild.recently;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel;
import com.tencent.mobileqq.guild.discoveryv2.content.base.MVPFeedsDataPart;
import com.tencent.mobileqq.guild.discoveryv2.content.model.PullToRefreshState;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProRecentViewedData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import ef1.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh1.MVPFeedsRefreshUIState;
import qh1.MVPFeedsUIState;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0006\u0010\f\u001a\u00020\u0004J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/recently/g;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/MVPFeedsDataPart;", "", com.tencent.luggage.wxa.c8.c.G, "", "Y9", "", "X9", "getLogTag", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/BaseFeedViewModel;", "J9", "V9", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/j;", "pullToRefreshState", "T9", "Lcom/tencent/mobileqq/guild/recently/GuildRecentlyViewedViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/recently/GuildRecentlyViewedViewModel;", "mViewModel", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g extends MVPFeedsDataPart {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GuildRecentlyViewedViewModel mViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f231980a;

        public a(ViewModelStoreOwner viewModelStoreOwner) {
            this.f231980a = viewModelStoreOwner;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new GuildRecentlyViewedViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    public g() {
        MVPFeedsUIState mVPFeedsUIState = (MVPFeedsUIState) ((MVPFeedsDataPart) this).uiStateFlow.getValue();
        MutableStateFlow mutableStateFlow = ((MVPFeedsDataPart) this).uiStateFlow;
        MVPFeedsUIState c16 = MVPFeedsUIState.c(mVPFeedsUIState, null, MVPFeedsRefreshUIState.c(mVPFeedsUIState.getRefreshState(), null, null, false, X9(), 7, null), null, false, 13, null);
        QLog.d(((MVPFeedsDataPart) this).TAG, 4, "updateUIState " + c16);
        mutableStateFlow.setValue(c16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9() {
        QQToastUtil.showQQToast(2, "\u5df2\u6e05\u7a7a\u6d4f\u89c8\u8bb0\u5f55");
    }

    private final String X9() {
        return "- " + HardCodeUtil.qqStr(R.string.f152771aa) + " -";
    }

    private final void Y9(int pos) {
        QLog.d(getTAG(), 4, "handleRecentViewTimeByPosition pos=" + pos);
        GuildRecentlyViewedViewModel guildRecentlyViewedViewModel = this.mViewModel;
        if (guildRecentlyViewedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            guildRecentlyViewedViewModel = null;
        }
        List<GProRecentViewedData> x26 = guildRecentlyViewedViewModel.x2();
        if (pos >= 0 && pos < x26.size()) {
            long j3 = x26.get(pos).recentViewTime;
            QLog.d(getTAG(), 4, "handleRecentViewTimeByPosition time=" + j3);
            broadcastMessage("message_update_time_show", Long.valueOf(j3));
        }
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.MVPFeedsDataPart
    @NotNull
    public List<BaseFeedViewModel> J9() {
        List<BaseFeedViewModel> listOf;
        c.Companion companion = ef1.c.INSTANCE;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        ViewModel viewModel = new ViewModelProvider(partHost, new a(partHost)).get(GuildRecentlyViewedViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.mViewModel = (GuildRecentlyViewedViewModel) viewModel;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(viewModel);
        return listOf;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.MVPFeedsDataPart
    public void T9(@NotNull PullToRefreshState pullToRefreshState) {
        Intrinsics.checkNotNullParameter(pullToRefreshState, "pullToRefreshState");
        super.T9(pullToRefreshState);
        Y9(0);
    }

    public final void V9() {
        MutableStateFlow mutableStateFlow = ((MVPFeedsDataPart) this).uiStateFlow;
        MVPFeedsUIState a16 = MVPFeedsUIState.INSTANCE.a();
        ri1.a f16 = ri1.a.f();
        Intrinsics.checkNotNullExpressionValue(f16, "ok()");
        MVPFeedsUIState c16 = MVPFeedsUIState.c(a16, f16, null, null, false, 14, null);
        QLog.d(((MVPFeedsDataPart) this).TAG, 4, "updateUIState " + c16);
        mutableStateFlow.setValue(c16);
        GuildRecentlyViewedViewModel guildRecentlyViewedViewModel = this.mViewModel;
        if (guildRecentlyViewedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            guildRecentlyViewedViewModel = null;
        }
        guildRecentlyViewedViewModel.clear();
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.recently.f
            @Override // java.lang.Runnable
            public final void run() {
                g.W9();
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "RecentlyViewDataPart";
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.MVPFeedsDataPart, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "message_recyclerview_scroll") && (args instanceof Integer)) {
            Y9(((Number) args).intValue());
        }
    }
}
