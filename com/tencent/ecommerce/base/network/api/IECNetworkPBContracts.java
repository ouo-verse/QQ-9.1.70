package com.tencent.ecommerce.base.network.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a2\u0006\u0002\u0010\u0007J+\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00028\u00002\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "P", BdhLogUtil.LogTag.Tag_Req, "", "decodeResponse", "rsp", "", "([B)Ljava/lang/Object;", "encodeRequestParams", "params", WadlProxyConsts.CHANNEL, "", "reqExt", "Lorg/json/JSONObject;", "(Ljava/lang/Object;ILorg/json/JSONObject;)[B", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECNetworkPBContracts<P, R> {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ byte[] a(IECNetworkPBContracts iECNetworkPBContracts, Object obj, int i3, JSONObject jSONObject, int i16, Object obj2) {
            if (obj2 == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                if ((i16 & 4) != 0) {
                    jSONObject = null;
                }
                return iECNetworkPBContracts.encodeRequestParams(obj, i3, jSONObject);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeRequestParams");
        }
    }

    R decodeResponse(@NotNull byte[] rsp);

    @NotNull
    byte[] encodeRequestParams(P params, int channel, @Nullable JSONObject reqExt);
}
