package com.tencent.mobileqq.zplan.smallhome.network;

import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.libra.trace.LibraTraceConst;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import mqq.util.WeakReference;
import org.json.JSONObject;
import pu4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002R*\u0010\t\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/network/ConfigHelper;", "", "", "Lcom/tencent/mobileqq/zplan/smallhome/network/ConfigHelper$MaterialState;", "Lpu4/g;", "a", "b", "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "configCache", "<init>", "()V", "MaterialState", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ConfigHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final ConfigHelper f335704a = new ConfigHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static WeakReference<Map<MaterialState, g>> configCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/smallhome/network/ConfigHelper$MaterialState;", "", "(Ljava/lang/String;I)V", "Normal", "Downloading", V2TIMManager.GROUP_TYPE_MEETING, "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum MaterialState {
        Normal,
        Downloading,
        Meeting
    }

    ConfigHelper() {
    }

    private final Map<MaterialState, g> a() {
        String str;
        String str2;
        String str3;
        String str4;
        String optString;
        String optString2;
        String optString3;
        String optString4;
        String optString5;
        String optString6;
        String optString7;
        String optString8;
        JSONObject U1 = ZPlanFeatureSwitch.f369852a.U1();
        JSONObject optJSONObject = U1 != null ? U1.optJSONObject(LibraTraceConst.Node.IMAGE_DOWNLOADING) : null;
        JSONObject optJSONObject2 = U1 != null ? U1.optJSONObject("normal") : null;
        JSONObject optJSONObject3 = U1 != null ? U1.optJSONObject("meeting") : null;
        g gVar = new g();
        String str5 = "png";
        if (optJSONObject == null || (str = optJSONObject.optString("firstFrameType", "png")) == null) {
            str = "png";
        }
        gVar.f427437d = str;
        String str6 = "https://image.superqqshow.qq.com/small-home-float/zplan_float_icon_smallhome_download.png";
        if (optJSONObject != null && (optString8 = optJSONObject.optString("firstFrameUrl", "https://image.superqqshow.qq.com/small-home-float/zplan_float_icon_smallhome_download.png")) != null) {
            str6 = optString8;
        }
        gVar.f427436c = str6;
        String str7 = "apng";
        if (optJSONObject == null || (str2 = optJSONObject.optString("type", "apng")) == null) {
            str2 = "apng";
        }
        gVar.f427435b = str2;
        String str8 = "https://image.superqqshow.qq.com/small-home-float/zplan_float_icon_smallhome_download_apng.png";
        if (optJSONObject != null && (optString7 = optJSONObject.optString("url", "https://image.superqqshow.qq.com/small-home-float/zplan_float_icon_smallhome_download_apng.png")) != null) {
            str8 = optString7;
        }
        gVar.f427434a = str8;
        g gVar2 = new g();
        if (optJSONObject2 == null || (str3 = optJSONObject2.optString("firstFrameType", "png")) == null) {
            str3 = "png";
        }
        gVar2.f427437d = str3;
        String str9 = "https://image.superqqshow.qq.com/small-home-float/zplan_float_icon_smallhome_normal.png";
        if (optJSONObject2 != null && (optString6 = optJSONObject2.optString("firstFrameUrl", "https://image.superqqshow.qq.com/small-home-float/zplan_float_icon_smallhome_normal.png")) != null) {
            str9 = optString6;
        }
        gVar2.f427436c = str9;
        if (optJSONObject2 == null || (str4 = optJSONObject2.optString("type", "apng")) == null) {
            str4 = "apng";
        }
        gVar2.f427435b = str4;
        String str10 = "https://image.superqqshow.qq.com/small-home-float/zplan_float_icon_smallhome_normal_apng.png";
        if (optJSONObject2 != null && (optString5 = optJSONObject2.optString("url", "https://image.superqqshow.qq.com/small-home-float/zplan_float_icon_smallhome_normal_apng.png")) != null) {
            str10 = optString5;
        }
        gVar2.f427434a = str10;
        g gVar3 = new g();
        if (optJSONObject3 != null && (optString4 = optJSONObject3.optString("firstFrameType", "png")) != null) {
            str5 = optString4;
        }
        gVar3.f427437d = str5;
        String str11 = "https://image.ymzx.qq.com/client/meeting_image/zplan_float_icon_smallhome_meeting_v2.png";
        if (optJSONObject3 != null && (optString3 = optJSONObject3.optString("firstFrameUrl", "https://image.ymzx.qq.com/client/meeting_image/zplan_float_icon_smallhome_meeting_v2.png")) != null) {
            str11 = optString3;
        }
        gVar3.f427436c = str11;
        if (optJSONObject3 != null && (optString2 = optJSONObject3.optString("type", "apng")) != null) {
            str7 = optString2;
        }
        gVar3.f427435b = str7;
        String str12 = "https://image.ymzx.qq.com/client/meeting_image/zplan_float_icon_smallhome_meeting_apng_v2.png";
        if (optJSONObject3 != null && (optString = optJSONObject3.optString("url", "https://image.ymzx.qq.com/client/meeting_image/zplan_float_icon_smallhome_meeting_apng_v2.png")) != null) {
            str12 = optString;
        }
        gVar3.f427434a = str12;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(MaterialState.Downloading, gVar);
        linkedHashMap.put(MaterialState.Normal, gVar2);
        linkedHashMap.put(MaterialState.Meeting, gVar3);
        configCache = new WeakReference<>(linkedHashMap);
        return linkedHashMap;
    }

    public final Map<MaterialState, g> b() {
        WeakReference<Map<MaterialState, g>> weakReference = configCache;
        Map<MaterialState, g> map = weakReference != null ? weakReference.get() : null;
        return map == null ? a() : map;
    }
}
