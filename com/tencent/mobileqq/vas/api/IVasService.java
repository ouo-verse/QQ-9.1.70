package com.tencent.mobileqq.vas.api;

import com.tencent.mobileqq.activity.specialcare.api.IQvipSpecialSoundManager;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vas.manager.api.IGXHManager;
import com.tencent.mobileqq.vas.manager.api.IJsbCallManager;
import com.tencent.mobileqq.vas.manager.api.IKingCardManager;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.tianshu.ITianshuWebManager;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.vipav.api.IVipFunCallManager;
import com.tencent.mobileqq.vip.IGameCardManager;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020#X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020'X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0012\u0010*\u001a\u00020+X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0012\u0010.\u001a\u00020/X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0012\u00102\u001a\u000203X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0012\u00106\u001a\u000207X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109R\u0012\u0010:\u001a\u00020;X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u0012\u0010>\u001a\u00020?X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b@\u0010AR\u0012\u0010B\u001a\u00020CX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010E\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasService;", "Lmqq/app/api/IRuntimeService;", "appIconSwitchManager", "Lcom/tencent/mobileqq/vas/api/IVasAppIconSwitchManager;", "getAppIconSwitchManager", "()Lcom/tencent/mobileqq/vas/api/IVasAppIconSwitchManager;", "funCallManager", "Lcom/tencent/mobileqq/vas/vipav/api/IVipFunCallManager;", "getFunCallManager", "()Lcom/tencent/mobileqq/vas/vipav/api/IVipFunCallManager;", "gameCardManager", "Lcom/tencent/mobileqq/vip/IGameCardManager;", "getGameCardManager", "()Lcom/tencent/mobileqq/vip/IGameCardManager;", "gxh", "Lcom/tencent/mobileqq/vas/manager/api/IGXHManager;", "getGxh", "()Lcom/tencent/mobileqq/vas/manager/api/IGXHManager;", "jceRequset", "Lcom/tencent/mobileqq/vas/api/IJce;", "getJceRequset", "()Lcom/tencent/mobileqq/vas/api/IJce;", "jsbCallManager", "Lcom/tencent/mobileqq/vas/manager/api/IJsbCallManager;", "getJsbCallManager", "()Lcom/tencent/mobileqq/vas/manager/api/IJsbCallManager;", "kingCardManager", "Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "getKingCardManager", "()Lcom/tencent/mobileqq/vas/manager/api/IKingCardManager;", "pbRequest", "Lcom/tencent/mobileqq/vas/api/IPbProtocol;", "getPbRequest", "()Lcom/tencent/mobileqq/vas/api/IPbProtocol;", "specialSoundManager", "Lcom/tencent/mobileqq/activity/specialcare/api/IQvipSpecialSoundManager;", "getSpecialSoundManager", "()Lcom/tencent/mobileqq/activity/specialcare/api/IQvipSpecialSoundManager;", "themeSwitchManager", "Lcom/tencent/mobileqq/vas/manager/api/IThemeSwitchManager;", "getThemeSwitchManager", "()Lcom/tencent/mobileqq/vas/manager/api/IThemeSwitchManager;", "tianshuWebManager", "Lcom/tencent/mobileqq/vas/tianshu/ITianshuWebManager;", "getTianshuWebManager", "()Lcom/tencent/mobileqq/vas/tianshu/ITianshuWebManager;", "vasFtManager", "Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager;", "getVasFtManager", "()Lcom/tencent/mobileqq/vas/treasurecard/api/IVasFTManager;", "vasHybridRoute", "Lcom/tencent/mobileqq/vas/api/IVasHybridRoute;", "getVasHybridRoute", "()Lcom/tencent/mobileqq/vas/api/IVasHybridRoute;", "vasSchemeManager", "Lcom/tencent/mobileqq/vas/api/IVasSchemeManager;", "getVasSchemeManager", "()Lcom/tencent/mobileqq/vas/api/IVasSchemeManager;", "vasThemeFontApi", "Lcom/tencent/mobileqq/vas/api/IVasThemeFontApi;", "getVasThemeFontApi", "()Lcom/tencent/mobileqq/vas/api/IVasThemeFontApi;", "vasUpdateManager", "Lcom/tencent/mobileqq/vas/api/IVasUpdateManager;", "getVasUpdateManager", "()Lcom/tencent/mobileqq/vas/api/IVasUpdateManager;", "vipDataProxy", "Lcom/tencent/mobileqq/vas/api/IVipDataRequestProxy;", "getVipDataProxy", "()Lcom/tencent/mobileqq/vas/api/IVipDataRequestProxy;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IVasService extends IRuntimeService {
    @NotNull
    IVasAppIconSwitchManager getAppIconSwitchManager();

    @NotNull
    IVipFunCallManager getFunCallManager();

    @NotNull
    IGameCardManager getGameCardManager();

    @NotNull
    IGXHManager getGxh();

    @NotNull
    IJce getJceRequset();

    @NotNull
    IJsbCallManager getJsbCallManager();

    @NotNull
    IKingCardManager getKingCardManager();

    @NotNull
    IPbProtocol getPbRequest();

    @NotNull
    IQvipSpecialSoundManager getSpecialSoundManager();

    @NotNull
    IThemeSwitchManager getThemeSwitchManager();

    @NotNull
    ITianshuWebManager getTianshuWebManager();

    @NotNull
    IVasFTManager getVasFtManager();

    @NotNull
    IVasHybridRoute getVasHybridRoute();

    @NotNull
    IVasSchemeManager getVasSchemeManager();

    @NotNull
    IVasThemeFontApi getVasThemeFontApi();

    @NotNull
    IVasUpdateManager getVasUpdateManager();

    @NotNull
    IVipDataRequestProxy getVipDataProxy();
}
