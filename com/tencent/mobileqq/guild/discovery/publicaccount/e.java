package com.tencent.mobileqq.guild.discovery.publicaccount;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel;
import com.tencent.mobileqq.guild.discoveryv2.content.base.MVPFeedsDataPart;
import com.tencent.mobileqq.guild.discoveryv2.content.model.RecommendViewModel;
import com.tencent.mobileqq.guild.discoveryv2.jump.GuildPropsParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSourceInfoBid;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/publicaccount/e;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/MVPFeedsDataPart;", "", "getLogTag", "", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/BaseFeedViewModel;", "J9", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "U9", "()Ljava/lang/String;", "busiInfo", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends MVPFeedsDataPart {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String busiInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f216777a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f216778b;

        public a(ViewModelStoreOwner viewModelStoreOwner, e eVar) {
            this.f216777a = viewModelStoreOwner;
            this.f216778b = eVar;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new RecommendViewModel(new GuildPropsParam(15, GGProSourceInfoBid.CHANNEL, 4, this.f216778b.getBusiInfo())), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    public e(@NotNull String busiInfo) {
        Intrinsics.checkNotNullParameter(busiInfo, "busiInfo");
        this.busiInfo = busiInfo;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.MVPFeedsDataPart
    @NotNull
    public List<BaseFeedViewModel> J9() {
        List<BaseFeedViewModel> listOf;
        c.Companion companion = ef1.c.INSTANCE;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        ViewModel viewModel = new ViewModelProvider(partHost, new a(partHost, this)).get(RecommendViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(viewModel);
        return listOf;
    }

    @NotNull
    /* renamed from: U9, reason: from getter */
    public final String getBusiInfo() {
        return this.busiInfo;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "PublicAccountContentPart";
    }
}
