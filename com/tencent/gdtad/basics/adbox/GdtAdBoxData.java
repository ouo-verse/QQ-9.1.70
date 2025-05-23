package com.tencent.gdtad.basics.adbox;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtAdBoxData implements Serializable {
    private List<GdtAd> ads;
    private String json;
    private String refId;

    public GdtAdBoxData(String str) {
        this.ads = new ArrayList();
        this.json = str;
        a(str);
    }

    private void a(String str) {
        try {
            List<qq_ad_get.QQAdGetRsp.PosAdInfo> list = ((qq_ad_get.QQAdGetRsp) qq_ad_get.QQAdGetRsp.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp(), new JSONObject(str)))).pos_ads_info.get();
            if (list != null && !list.isEmpty()) {
                List<GdtAd> list2 = this.ads;
                if (list2 != null) {
                    list2.clear();
                }
                Iterator<qq_ad_get.QQAdGetRsp.PosAdInfo> it = list.iterator();
                while (it.hasNext()) {
                    List<qq_ad_get.QQAdGetRsp.AdInfo> list3 = it.next().ads_info.get();
                    if (list3 != null && !list3.isEmpty()) {
                        for (qq_ad_get.QQAdGetRsp.AdInfo adInfo : list3) {
                            if (this.ads == null) {
                                this.ads = new ArrayList();
                            }
                            this.ads.add(new GdtAd(adInfo));
                        }
                    }
                    GdtLog.e("GdtAdBoxData", "convertJson2GdtAds() adInfos.isEmpty");
                }
                if (this.ads != null) {
                    GdtLog.d("GdtAdBoxData", "convertJson2GdtAds() result = [" + Arrays.toString(this.ads.toArray()) + "]");
                    return;
                }
                return;
            }
            GdtLog.e("GdtAdBoxData", "convertJson2GdtAds() posAdInfos.isEmpty");
        } catch (Exception e16) {
            GdtLog.e("GdtAdBoxData", "convertJson2GdtAds", e16);
        }
    }

    public List<GdtAd> getAds() {
        return this.ads;
    }

    public String getRefId() {
        return this.refId;
    }

    public void setAds(List<GdtAd> list) {
        this.ads = list;
    }

    public GdtAdBoxData setRefId(String str) {
        this.refId = str;
        return this;
    }

    public GdtAdBoxData(List<GdtAd> list) {
        new ArrayList();
        this.ads = list;
    }
}
