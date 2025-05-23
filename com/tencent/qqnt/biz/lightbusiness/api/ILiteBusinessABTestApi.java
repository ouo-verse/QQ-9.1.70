package com.tencent.qqnt.biz.lightbusiness.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/api/ILiteBusinessABTestApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getForceMsgListShowIdStr", "", "light_business_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface ILiteBusinessABTestApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        @NotNull
        public static String a(@NotNull ILiteBusinessABTestApi iLiteBusinessABTestApi) {
            return "";
        }
    }

    @NotNull
    String getForceMsgListShowIdStr();
}
