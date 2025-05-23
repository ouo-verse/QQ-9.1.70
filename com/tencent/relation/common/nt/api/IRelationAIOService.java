package com.tencent.relation.common.nt.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J \u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/relation/common/nt/api/IRelationAIOService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "enterContactStrangerAIO", "", "context", "Landroid/content/Context;", "toPhone", "", "getNameFromPhone", "mobileNumber", "ntPrepareContactStrangerTempChat", "appInterface", "Lcom/tencent/common/app/AppInterface;", "nickName", "ntPrepareTroopMemberStrangerTempChat", "toUid", "troopUin", "relation-common-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IRelationAIOService extends QRouteApi {
    void enterContactStrangerAIO(@NotNull Context context, @NotNull String toPhone);

    @NotNull
    String getNameFromPhone(@NotNull String mobileNumber);

    void ntPrepareContactStrangerTempChat(@NotNull AppInterface appInterface, @NotNull String nickName, @NotNull String toPhone);

    void ntPrepareTroopMemberStrangerTempChat(@NotNull AppInterface appInterface, @NotNull String nickName, @NotNull String toUid, @NotNull String troopUin);
}
