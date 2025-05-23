package com.pay.network.model;

import com.pay.http.APBaseHttpAns;
import com.pay.http.APBaseHttpReq;
import com.pay.http.APHttpHandle;
import com.pay.http.IAPHttpAnsObserver;
import com.pay.tool.APProductItem;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.midas.comm.APLog;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import cooperation.qqcircle.report.QCircleLpReportDc05502;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class APMpAns extends APBaseHttpAns {
    private String beginTime;
    private String endTime;
    private String firstsave_present_count;
    private List<APProductItem> mGoodsList;
    private String mpJson;
    private List<String> mpList;
    private List<String> mpPresentList;
    private List<String> mpValueList;
    private String rate;

    public APMpAns(APHttpHandle aPHttpHandle, IAPHttpAnsObserver iAPHttpAnsObserver, HashMap<String, APBaseHttpReq> hashMap, String str) {
        super(aPHttpHandle, iAPHttpAnsObserver, hashMap, str);
        this.rate = "";
        this.firstsave_present_count = "";
        this.beginTime = "";
        this.endTime = "";
        this.mpJson = "";
        this.mpValueList = new ArrayList();
        this.mpPresentList = new ArrayList();
        this.mpList = new ArrayList();
        this.mGoodsList = new ArrayList();
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getFirstsave_present_count() {
        return this.firstsave_present_count;
    }

    public String getMpJson() {
        return this.mpJson;
    }

    public List<String> getMpList() {
        return this.mpList;
    }

    public List<String> getMpPresentList() {
        return this.mpPresentList;
    }

    public List<String> getMpValueList() {
        return this.mpValueList;
    }

    public List<APProductItem> getProductList() {
        return this.mGoodsList;
    }

    public String getRate() {
        return this.rate;
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onFinishAns(byte[] bArr, APBaseHttpReq aPBaseHttpReq) {
        super.onFinishAns(bArr, aPBaseHttpReq);
        String str = new String(bArr);
        this.mpJson = str;
        APLog.i("APMpAns", "resultData=" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int parseInt = Integer.parseInt(jSONObject.getString("ret").toString());
            this.resultCode = parseInt;
            if (parseInt == 0) {
                if (jSONObject.has("product_list")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("product_list");
                    this.mGoodsList.clear();
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                        APProductItem aPProductItem = new APProductItem();
                        try {
                            aPProductItem.name = jSONObject2.getString("name");
                            aPProductItem.productId = jSONObject2.getString("productid");
                            aPProductItem.price = jSONObject2.getString("price");
                            aPProductItem.num = jSONObject2.getString(WidgetCacheConstellationData.NUM);
                            this.mGoodsList.add(aPProductItem);
                        } catch (Exception unused) {
                        }
                    }
                }
                this.rate = jSONObject.getString("rate");
                APCommMethod.transformStrToList(jSONObject.getString("list"), this.mpList);
                this.firstsave_present_count = jSONObject.getString("firstsave_present_count");
                APCommMethod.transformStrToMpInfoList(jSONObject.getString("present_level"), this.mpValueList, this.mpPresentList);
                this.beginTime = jSONObject.getString(QCircleLpReportDc05502.KEY_BEGIN_TIME);
                this.endTime = jSONObject.getString("end_time");
                return;
            }
            this.resultMsg = jSONObject.getString("msg");
            String str2 = jSONObject.getString(CheckForwardServlet.KEY_ERR_CODE).toString();
            if (!str2.equals("")) {
                this.resultMsg = "\u7cfb\u7edf\u7e41\u5fd9,\u8bf7\u7a0d\u540e\u518d\u8bd5\n(" + str2 + ")";
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void setBeginTime(String str) {
        this.beginTime = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setFirstsave_present_count(String str) {
        this.firstsave_present_count = str;
    }

    public void setMpList(List<String> list) {
        this.mpList = list;
    }

    public void setMpPresentList(List<String> list) {
        this.mpPresentList = list;
    }

    public void setMpValueList(List<String> list) {
        this.mpValueList = list;
    }

    public void setRate(String str) {
        this.rate = str;
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onErrorAns(APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onStartAns(APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onStopAns(APBaseHttpReq aPBaseHttpReq) {
    }

    @Override // com.pay.http.APBaseHttpAns
    public void onReceiveAns(byte[] bArr, int i3, long j3, APBaseHttpReq aPBaseHttpReq) {
    }
}
