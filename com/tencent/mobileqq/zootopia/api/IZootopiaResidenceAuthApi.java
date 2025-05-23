package com.tencent.mobileqq.zootopia.api;

import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0007H&JD\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u000fH&J:\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\r2\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u000fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/IZootopiaResidenceAuthApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkResidenceVisitAuth", "", IProfileProtocolConst.PARAM_TARGET_UIN, "", "callback", "Lkotlin/Function2;", "", "sendChannelResidenceAuthArk", ISchemeApi.KEY_GUILD_ID_TYPE, "", "guildId", "", "ownerUin", "Lkotlin/Function3;", "sendResidenceAuthArk", "groupId", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZootopiaResidenceAuthApi extends QRouteApi {
    void checkResidenceVisitAuth(@NotNull String targetUin, @NotNull Function2<? super Boolean, ? super String, Unit> callback);

    void sendChannelResidenceAuthArk(int guildIdType, long guildId, long ownerUin, @NotNull Function3<? super Boolean, ? super Boolean, ? super String, Unit> callback);

    void sendResidenceAuthArk(@NotNull String targetUin, long groupId, @NotNull Function3<? super Boolean, ? super Boolean, ? super String, Unit> callback);
}
