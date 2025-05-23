package com.tencent.mobileqq.troop.addcontact.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/addcontact/api/IAddContactSessionRepo;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getSession", "", "type", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "setSession", "", "latestSession", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IAddContactSessionRepo extends QRouteApi {
    @NotNull
    byte[] getSession(@NotNull AddContactDataType type);

    void setSession(@NotNull AddContactDataType type, @NotNull byte[] latestSession);
}
