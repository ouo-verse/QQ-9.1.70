package com.tencent.gamecenter.wadl.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import jl0.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0016\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH&J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0013\u001a\u00020\u0002H&J\b\u0010\u0014\u001a\u00020\u0002H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/gamecenter/wadl/api/IQQGameDualDownloadService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isKingCard", "", "status", "", "setDualSwitch", "", "switchId", "getCacheDualSwitch", "Ljl0/a;", "callback", "getAutoDualGameSwitch", "", "switchIds", "getDualSwitchAsync", "jsonParams", "doDualDownload", "isFlowSwitchOn", "hasSimCard", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGameDualDownloadService extends QRouteApi {
    void doDualDownload(@Nullable String jsonParams);

    void getAutoDualGameSwitch(int switchId, @NotNull a callback);

    int getCacheDualSwitch();

    void getDualSwitchAsync(@NotNull List<Integer> switchIds);

    boolean hasSimCard();

    boolean isFlowSwitchOn();

    boolean isKingCard();

    void setDualSwitch(int status, int switchId);

    void setDualSwitch(@NotNull String status);
}
