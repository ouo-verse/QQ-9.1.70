package com.tencent.mobileqq.guild.discoveryv2.content.model;

import androidx.lifecycle.ViewModelKt;
import com.tencent.mobileqq.guild.discoveryv2.RecommendAdMessage;
import com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\b\t*\u0001\u0017\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\f8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/model/CategoryTabViewModel;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/BaseFeedViewModel;", "Lcom/tencent/mvi/base/route/j;", "message", "", "D0", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/i;", "pullToRefreshArgs", "c2", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/g;", "loadMoreArgs", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "account", "onAccountChanged", "", "H", "I", "subTabId", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "tag", "com/tencent/mobileqq/guild/discoveryv2/content/model/CategoryTabViewModel$networkHelper$1", "J", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/CategoryTabViewModel$networkHelper$1;", "networkHelper", "<init>", "(I)V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class CategoryTabViewModel extends BaseFeedViewModel {

    /* renamed from: H, reason: from kotlin metadata */
    private final int subTabId;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final CategoryTabViewModel$networkHelper$1 networkHelper;

    public CategoryTabViewModel() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object k2(com.tencent.mobileqq.guild.discoveryv2.net.a aVar, RecommendAdMessage recommendAdMessage, Continuation continuation) {
        aVar.d(recommendAdMessage);
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel, com.tencent.mobileqq.guild.discoveryv2.content.model.f
    public void D0(@NotNull com.tencent.mvi.base.route.j message) {
        Intrinsics.checkNotNullParameter(message, "message");
        super.D0(message);
        FlowKt.launchIn(FlowKt.merge(FlowKt.onEach(FlowKt.callbackFlow(new CategoryTabViewModel$init$$inlined$eventFlow$1(message, null)), new CategoryTabViewModel$init$1(this.networkHelper.getAdDecorator()))), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel
    public void a2(@NotNull LoadMoreArgs loadMoreArgs) {
        Intrinsics.checkNotNullParameter(loadMoreArgs, "loadMoreArgs");
        FlowKt.launchIn(FlowKt.onEach(this.networkHelper.d(), new CategoryTabViewModel$loadMoreFormServer$1(this, loadMoreArgs, null)), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel
    public void c2(@NotNull PullToRefreshArgs pullToRefreshArgs) {
        Intrinsics.checkNotNullParameter(pullToRefreshArgs, "pullToRefreshArgs");
        FlowKt.launchIn(FlowKt.onEach(FlowKt.transformWhile(this.networkHelper.g(false), new CategoryTabViewModel$pullToRefreshFromServer$1(null)), new CategoryTabViewModel$pullToRefreshFromServer$2(this, pullToRefreshArgs, null)), ViewModelKt.getViewModelScope(this));
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel
    @NotNull
    public String getTag() {
        return this.tag;
    }

    @Override // com.tencent.mobileqq.guild.discoveryv2.content.base.BaseFeedViewModel, com.tencent.mobileqq.guild.discoveryv2.content.model.f
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        this.networkHelper.e();
    }

    public CategoryTabViewModel(int i3) {
        this.subTabId = i3;
        this.tag = "CategoryTabViewModel";
        this.networkHelper = new CategoryTabViewModel$networkHelper$1(this);
    }

    public /* synthetic */ CategoryTabViewModel(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 0 : i3);
    }
}
