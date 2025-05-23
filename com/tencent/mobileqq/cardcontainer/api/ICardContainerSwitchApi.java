package com.tencent.mobileqq.cardcontainer.api;

import com.tencent.mobileqq.cardcontainer.data.CardContainerSwitchState;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H&J\b\u0010\u000f\u001a\u00020\u0002H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/cardcontainer/api/ICardContainerSwitchApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "remoteShowCardContainerSwitch", "Lcom/tencent/mobileqq/cardcontainer/api/a;", "listener", "", "setCardContainerSwitchChangedListener", "removeCardContainerSwitchChangedListener", "Lcom/tencent/mobileqq/cardcontainer/data/CardContainerSwitchState;", "getRemoteCardContainerSwitchState", "state", "setRemoteCardContainerSwitchState", "show", "setLocalCardContainerSwitchShowingState", "getLocalCardContainerSwitchShowingState", "cardcontainer_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface ICardContainerSwitchApi extends QRouteApi {
    boolean getLocalCardContainerSwitchShowingState();

    @NotNull
    CardContainerSwitchState getRemoteCardContainerSwitchState();

    boolean remoteShowCardContainerSwitch();

    void removeCardContainerSwitchChangedListener();

    void setCardContainerSwitchChangedListener(@NotNull a listener);

    void setLocalCardContainerSwitchShowingState(boolean show);

    void setRemoteCardContainerSwitchState(@NotNull CardContainerSwitchState state);
}
