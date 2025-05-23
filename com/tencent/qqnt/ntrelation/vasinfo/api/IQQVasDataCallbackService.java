package com.tencent.qqnt.ntrelation.vasinfo.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import hx3.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kx3.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&J8\u0010\u000e\u001a\u00020\u00052\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/ntrelation/vasinfo/api/IQQVasDataCallbackService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", "Lkx3/a;", "data", "", "vasInfoToCallback", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "uids", "trace", "Lhx3/b;", "iQueryGeneralDataCallback", "registerVasInfoCallback", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes22.dex */
public interface IQQVasDataCallbackService extends QRouteApi {
    void registerVasInfoCallback(@NotNull ArrayList<String> uids, @Nullable String trace, @NotNull b<a> iQueryGeneralDataCallback);

    void vasInfoToCallback(@Nullable e<a> data);
}
