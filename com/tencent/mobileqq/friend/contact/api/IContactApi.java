package com.tencent.mobileqq.friend.contact.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import wc1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J\u0010\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/friend/contact/api/IContactApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "Lwc1/a;", "getContactRefreshViewWrapClass", "getContactDragRefreshViewWrapClass", "qqfriend_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IContactApi extends QRouteApi {
    @NotNull
    Class<? extends a> getContactDragRefreshViewWrapClass();

    @NotNull
    Class<? extends a> getContactRefreshViewWrapClass();
}
