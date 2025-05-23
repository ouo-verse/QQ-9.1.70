package g30;

import circlesearch.CircleSearchExhibition$StSuggestionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {
    protected qq_ad_get.QQAdGetRsp.AdInfo a(CircleSearchExhibition$StSuggestionInfo circleSearchExhibition$StSuggestionInfo) {
        if (circleSearchExhibition$StSuggestionInfo.suggest_type.get() != 4) {
            return null;
        }
        access.AdGetRsp adGetRsp = new access.AdGetRsp();
        try {
            adGetRsp.mergeFrom(circleSearchExhibition$StSuggestionInfo.game_ad.ad_buffer.get().toByteArray());
        } catch (Exception e16) {
            QLog.e("QFSStSuggestionInfoTransformer", 1, "parse gameAd adBuffer error:", e16);
        }
        List<qq_ad_get.QQAdGetRsp.PosAdInfo> list = adGetRsp.qq_ad_get_rsp.pos_ads_info.get();
        if (list.isEmpty()) {
            return null;
        }
        List<qq_ad_get.QQAdGetRsp.AdInfo> list2 = list.get(0).ads_info.get();
        if (list2.isEmpty()) {
            return null;
        }
        return list2.get(0);
    }

    public void b(b bVar) {
        if (bVar != null && bVar.a() != null) {
            bVar.c("EXTRA_SUGGESTION_AD_DATA", a(bVar.a()));
        }
    }
}
