package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository;

import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.addcontact.api.IAddContactSessionRepo;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/i;", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c {
    @NotNull
    public static final i a() {
        QRouteApi api = QRoute.api(IAddContactSessionRepo.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAddContactSessionRepo::class.java)");
        IAddContactSessionRepo iAddContactSessionRepo = (IAddContactSessionRepo) api;
        return new i(iAddContactSessionRepo.getSession(AddContactDataType.f293812GROUP), iAddContactSessionRepo.getSession(AddContactDataType.PERSON), iAddContactSessionRepo.getSession(AddContactDataType.GUILD), iAddContactSessionRepo.getSession(AddContactDataType.FLOCK));
    }
}
