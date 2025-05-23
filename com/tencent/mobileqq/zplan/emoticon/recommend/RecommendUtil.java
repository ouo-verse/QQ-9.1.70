package com.tencent.mobileqq.zplan.emoticon.recommend;

import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.zplan.aio.panel.page.EmoticonPageBuilder;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.model.ZPlanActionType;
import com.tencent.mobileqq.zplan.model.ZPlanEmo2DInfo;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.report.capability.decode.TVKDeviceDecodeCapabilityReportConstant;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.utils.featureswitch.model.ZPlanEmoticonSizeConfig;
import com.tencent.zplan.meme.Priority;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;
import t74.l;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J \u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001b\u0010\u0013\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/recommend/RecommendUtil;", "", "", "portraitId", "Lcom/tencent/mobileqq/zplan/model/e;", "d", "Lorg/json/JSONObject;", "emoticonJson", "f", "c", "", "selfUin", "", "e", "", "g", "b", "Lkotlin/Lazy;", "()Z", "enableRecommendRecordTABAndQQMC", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RecommendUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final RecommendUtil f333314a = new RecommendUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy enableRecommendRecordTABAndQQMC;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.zplan.emoticon.recommend.RecommendUtil$enableRecommendRecordTABAndQQMC$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(RecommendTABHelper.f333312a.a());
            }
        });
        enableRecommendRecordTABAndQQMC = lazy;
    }

    RecommendUtil() {
    }

    private final boolean b() {
        return ((Boolean) enableRecommendRecordTABAndQQMC.getValue()).booleanValue();
    }

    private final ZPlanActionInfo d(int portraitId) {
        List<? extends com.tencent.mobileqq.zplan.aio.panel.panel.a> listOf;
        com.tencent.mobileqq.zplan.aio.panel.page.a a16;
        List<ZPlanActionInfo> v3;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.a.f261779e);
        Intrinsics.checkNotNull(f16);
        BaseApplication context = BaseApplication.context;
        Panel.Companion companion = Panel.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new EmoticonPageBuilder(f16, context, null, 4, null));
        Panel i3 = companion.i(listOf);
        Object obj = null;
        if (i3 == null || (a16 = com.tencent.mobileqq.zplan.aio.panel.page.a.INSTANCE.a(i3)) == null || (v3 = a16.v()) == null) {
            return null;
        }
        Iterator<T> it = v3.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ZPlanActionInfo) next).getId() == portraitId) {
                obj = next;
                break;
            }
        }
        return (ZPlanActionInfo) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, JSONObject jSONObject, String selfUin) {
        ZPlanActionInfo c16;
        Intrinsics.checkNotNullParameter(selfUin, "$selfUin");
        RecommendUtil recommendUtil = f333314a;
        if (recommendUtil.b() && (c16 = recommendUtil.c(i3, jSONObject)) != null) {
            com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.m(c16, selfUin, Priority.HIGH, null);
        }
    }

    public final ZPlanActionInfo c(int portraitId, JSONObject emoticonJson) {
        ZPlanActionInfo f16;
        return (!a.f333316a.b() || (f16 = f(emoticonJson)) == null) ? d(portraitId) : f16;
    }

    public final boolean e(int portraitId, String selfUin, JSONObject emoticonJson) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        ZPlanActionInfo c16 = c(portraitId, emoticonJson);
        return (c16 == null || ZPlanEmoticonUtil.f333176e.A(c16, selfUin) == null) ? false : true;
    }

    public final void g(final int portraitId, final String selfUin, final JSONObject emoticonJson) {
        Intrinsics.checkNotNullParameter(selfUin, "selfUin");
        if (portraitId <= 0) {
            return;
        }
        l.f435563a.f(new Runnable() { // from class: com.tencent.mobileqq.zplan.emoticon.recommend.b
            @Override // java.lang.Runnable
            public final void run() {
                RecommendUtil.h(portraitId, emoticonJson, selfUin);
            }
        });
    }

    private final ZPlanActionInfo f(JSONObject emoticonJson) {
        JSONObject optJSONObject;
        ZPlanActionType zPlanActionType;
        if (emoticonJson == null || (optJSONObject = emoticonJson.optJSONObject("action_info")) == null) {
            return null;
        }
        ZPlanActionInfo zPlanActionInfo = new ZPlanActionInfo(0, null, 0, null, null, 0, 0, null, null, 0, 0, 0, 0, null, null, null, 0, 0, 0, 0, null, null, 4194303, null);
        zPlanActionInfo.y(emoticonJson.optInt(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, -1));
        zPlanActionInfo.C(emoticonJson.optString("zh_name"));
        JSONArray optJSONArray = emoticonJson.optJSONArray("type");
        zPlanActionInfo.D(optJSONArray != null ? optJSONArray.optInt(0, -1) : -1);
        if (zPlanActionInfo.getOriginType() != 1 && zPlanActionInfo.getOriginType() != 100) {
            zPlanActionType = ZPlanActionType.ACTION;
        } else {
            zPlanActionType = ZPlanActionType.MEME;
        }
        zPlanActionInfo.G(zPlanActionType);
        zPlanActionInfo.x(emoticonJson.optString("icon_url"));
        zPlanActionInfo.E(emoticonJson.optInt("player_number", 1));
        zPlanActionInfo.r(emoticonJson.optInt("duration", 0));
        zPlanActionInfo.I(emoticonJson.optLong("timestamp", 0L));
        zPlanActionInfo.A(optJSONObject.optString("male_default_url"));
        zPlanActionInfo.v(optJSONObject.optString("female_default_url"));
        ZPlanEmoticonSizeConfig zPlanEmoticonSizeConfig = ZPlanQQMC.INSTANCE.getZPlanEmoticonSizeConfig();
        zPlanActionInfo.u(zPlanEmoticonSizeConfig.getEncodeWidth());
        zPlanActionInfo.t(zPlanEmoticonSizeConfig.getEncodeHeight());
        zPlanActionInfo.J(zPlanEmoticonSizeConfig.getRecordWidth());
        zPlanActionInfo.w(zPlanEmoticonSizeConfig.getRecordHeight());
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("rec_info");
        if (optJSONObject2 != null && optJSONObject2.has("width") && optJSONObject2.has("height")) {
            zPlanActionInfo.J(optJSONObject2.optInt("width"));
            zPlanActionInfo.w(optJSONObject2.optInt("height"));
        }
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("emo_2d_info");
        if (optJSONObject3 != null) {
            zPlanActionInfo.s(new ZPlanEmo2DInfo(optJSONObject3.optString("male_zip_url"), optJSONObject3.optString("female_zip_url"), optJSONObject3.optInt(TVKDeviceDecodeCapabilityReportConstant.DECODING_CAPABILITY_PARAM_FRAME_RATE, 10)));
        }
        zPlanActionInfo.H(optJSONObject.optString("sticker_id_conf", ""));
        String it = emoticonJson.optString("emotion_meta_data", "");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!(it.length() > 0)) {
            it = null;
        }
        if (it != null) {
            zPlanActionInfo.B(new JSONObject(it).optString("ext_json", ""));
        }
        return zPlanActionInfo;
    }
}
