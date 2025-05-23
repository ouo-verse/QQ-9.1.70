package com.tencent.mobileqq.springhb.preload;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.spring_hb.Preload$NYCommonInfo;
import tencent.im.spring_hb.Preload$SsoNYGetPreloadReq;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\t"}, d2 = {"Ltencent/im/spring_hb/Preload$SsoNYGetPreloadReq;", "", "c", "Ltencent/im/spring_hb/Preload$NYCommonInfo;", "b", "Lcom/tencent/mobileqq/springhb/preload/h;", "", "isSimple", "a", "springhb-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ToStringExtKt {
    @NotNull
    public static final String a(@NotNull h hVar, boolean z16) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        int length = hVar.f289508b.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject = hVar.f289508b.getJSONObject(i3);
            sb5.append("mid=" + jSONObject.optString("module_id") + " res{");
            JSONArray optJSONArray = jSONObject.optJSONArray(DKConfiguration.Directory.RESOURCES);
            StringBuilder sb6 = new StringBuilder();
            int length2 = optJSONArray.length();
            for (int i16 = 0; i16 < length2; i16++) {
                sb6.append("[");
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i16);
                sb6.append("zipResName=" + jSONObject2.optString(IPreloadServiceProxy.KEY_RESID));
                if (z16) {
                    sb6.append(" url=" + jSONObject2.optString("url"));
                    sb6.append(" urlPath=" + jSONObject2.optString("url_path"));
                    sb6.append(" invalidTime=" + jSONObject2.optString("invalid_time"));
                    sb6.append(" netType=" + jSONObject2.optString("net_type"));
                }
                sb6.append("] ");
            }
            sb6.append("}");
            sb5.append((CharSequence) sb6);
        }
        sb5.append("}");
        sb5.append(" res-zip{");
        List<SpringHbZipMappingBean> zipMappingList = hVar.f289509c;
        Intrinsics.checkNotNullExpressionValue(zipMappingList, "zipMappingList");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(zipMappingList, " ", null, null, 0, null, ToStringExtKt$toStringEx$str$1.INSTANCE, 30, null);
        sb5.append(joinToString$default);
        sb5.append("}");
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "modelStr.toString()");
        return sb7;
    }

    @NotNull
    public static final String b(@NotNull Preload$NYCommonInfo preload$NYCommonInfo) {
        Intrinsics.checkNotNullParameter(preload$NYCommonInfo, "<this>");
        return "{platform=" + preload$NYCommonInfo.platform.get() + " qqVersion=" + preload$NYCommonInfo.qqVersion.get() + " sysVer=" + preload$NYCommonInfo.ver.get() + " appId=" + preload$NYCommonInfo.appid.get() + '}';
    }

    @NotNull
    public static final String c(@NotNull Preload$SsoNYGetPreloadReq preload$SsoNYGetPreloadReq) {
        Intrinsics.checkNotNullParameter(preload$SsoNYGetPreloadReq, "<this>");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ver=");
        sb5.append(preload$SsoNYGetPreloadReq.ver.get());
        sb5.append(" scene=");
        sb5.append(preload$SsoNYGetPreloadReq.scene.get());
        sb5.append(" commonInfo=");
        Preload$NYCommonInfo commonInfo = preload$SsoNYGetPreloadReq.commonInfo;
        Intrinsics.checkNotNullExpressionValue(commonInfo, "commonInfo");
        sb5.append(b(commonInfo));
        return sb5.toString();
    }
}
