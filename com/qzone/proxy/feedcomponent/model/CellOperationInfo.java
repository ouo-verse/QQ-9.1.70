package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_operation;
import NS_MOBILE_FEEDS.s_op_btn;
import NS_MOBILE_FEEDS.s_outshare;
import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_FEEDS.s_schema;
import android.text.TextUtils;
import com.google.protobuf.MapFieldLite;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ProgressTracer;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellOperationInfo implements SmartParcelable {
    static final int OPRATION_FEED_TRACE_INFO = 52;

    @NeedParcel
    public int IsVideoPlayExpose;

    @NeedParcel
    public int actionType;

    @NeedParcel
    public String actionUrl;

    @NeedParcel
    public boolean appInstalled;

    @NeedParcel
    public String appid;

    @NeedParcel
    public Map<Integer, String> busiParam;

    @NeedParcel
    public Map<String, String> bypassParam;

    @NeedParcel
    public Map<Integer, Map<String, String>> click_stream_report;

    @NeedParcel
    public Map<Integer, String> cookie;

    @NeedParcel
    public String downloadUrl;

    @NeedParcel
    public Map<Integer, String> droplist_cookie;

    @NeedParcel
    public Map<Integer, String> feedReportCookie;

    @NeedParcel
    public String gdtAdvButtonGifUrl;

    @NeedParcel
    public String gdtTangramAdJson;

    @NeedParcel
    public String genericUrl;

    @NeedParcel
    public int hasReportExposure;

    @NeedParcel
    public boolean isWeishiGdtTangramAdv;

    @NeedParcel
    public long offlineResourceBid;

    @NeedParcel
    public ArrayList<OpBtn> opBtns;

    @NeedParcel
    public Map<Integer, PictureUrl> photoUrl;

    @NeedParcel
    public String postParams;

    @NeedParcel
    public String qbossTrace;

    @NeedParcel
    public String qqUrl;

    @NeedParcel
    public String qzoneFeedid;

    @NeedParcel
    public Map<Integer, String> rank_param;

    @NeedParcel
    public String schemaPageUrl;

    @NeedParcel
    public DetailDataOutShare shareData;

    @NeedParcel
    public String summary;

    @NeedParcel
    public String title;

    @NeedParcel
    public int userPost;

    @NeedParcel
    public String weixinUrl;

    @NeedParcel
    public boolean yingYongBao = false;
    private final Object mLock = new Object();

    /* JADX WARN: Multi-variable type inference failed */
    private static <K, V> HashMap<K, V> safeCopyMap(Map<? extends K, ? extends V> map) {
        V v3;
        MapFieldLite mapFieldLite = (HashMap<K, V>) new HashMap();
        try {
            for (Object obj : map.keySet().toArray()) {
                if (obj != null && (v3 = map.get(obj)) != null) {
                    mapFieldLite.put(obj, v3);
                }
            }
        } catch (ConcurrentModificationException e16) {
            e16.printStackTrace();
        }
        return mapFieldLite;
    }

    public Map<Integer, String> cloneFeedReportCookieSync() {
        Map<Integer, String> map = this.feedReportCookie;
        if (map == null) {
            return null;
        }
        return safeCopyMap(map);
    }

    public String getOprationFeedTraceInfo() {
        Map<Integer, String> map = this.busiParam;
        if (map == null) {
            return null;
        }
        return map.get(52);
    }

    public void putAllFeedReportCookieSync(Map<Integer, String> map) {
        synchronized (this.mLock) {
            Map<Integer, String> map2 = this.feedReportCookie;
            if (map2 != null && map != null) {
                map2.putAll(map);
            }
        }
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellOperationInfo {\n");
        Map<Integer, String> map = this.busiParam;
        if (map != null) {
            sb5.append("busiParam {");
            sb5.append("\n");
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(ProgressTracer.SEPARATOR);
                sb5.append((Object) entry.getValue());
                sb5.append("\n");
            }
            sb5.append("}");
            sb5.append("\n");
        }
        Map<String, String> map2 = this.bypassParam;
        if (map2 != null) {
            sb5.append("bypassParam {");
            sb5.append("\n");
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                sb5.append((Object) entry2.getKey());
                sb5.append(ProgressTracer.SEPARATOR);
                sb5.append((Object) entry2.getValue());
                sb5.append("\n");
            }
            sb5.append("}");
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.weixinUrl)) {
            sb5.append("weixinUrl: ");
            sb5.append(this.weixinUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.qqUrl)) {
            sb5.append("qqUrl: ");
            sb5.append(this.qqUrl);
            sb5.append("\n");
        }
        if (this.shareData != null) {
            sb5.append("shareData: ");
            sb5.append(this.shareData.toString());
            sb5.append("\n");
        }
        sb5.append("actionType: ");
        sb5.append(this.actionType);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.actionUrl)) {
            sb5.append("actionUrl: ");
            sb5.append(this.actionUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.genericUrl)) {
            sb5.append("actionUrl: ");
            sb5.append(this.genericUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.title)) {
            sb5.append("actionUrl: ");
            sb5.append(this.title);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.summary)) {
            sb5.append("actionUrl: ");
            sb5.append(this.summary);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.downloadUrl)) {
            sb5.append("downloadUrl: ");
            sb5.append(this.downloadUrl);
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.appid)) {
            sb5.append("appid: ");
            sb5.append(this.appid);
            sb5.append("\n");
        }
        sb5.append("userPost: ");
        sb5.append(this.userPost);
        sb5.append("\n");
        if (!TextUtils.isEmpty(this.postParams)) {
            sb5.append("postParams: ");
            sb5.append(this.postParams);
            sb5.append("\n");
        }
        Map<Integer, String> map3 = this.cookie;
        if (map3 != null) {
            sb5.append("cookie {");
            sb5.append("\n");
            for (Map.Entry<Integer, String> entry3 : map3.entrySet()) {
                sb5.append(entry3.getKey());
                sb5.append(ProgressTracer.SEPARATOR);
                sb5.append((Object) entry3.getValue());
                sb5.append("\n");
            }
            sb5.append("}");
            sb5.append("\n");
        }
        Map<Integer, String> map4 = this.droplist_cookie;
        if (map4 != null) {
            sb5.append("droplist_cookie {");
            sb5.append("\n");
            for (Map.Entry<Integer, String> entry4 : map4.entrySet()) {
                sb5.append(entry4.getKey());
                sb5.append(ProgressTracer.SEPARATOR);
                sb5.append((Object) entry4.getValue());
                sb5.append("\n");
            }
            sb5.append("}");
            sb5.append("\n");
        }
        Map<Integer, PictureUrl> map5 = this.photoUrl;
        if (map5 != null) {
            sb5.append("photoUrl {");
            sb5.append("\n");
            for (Map.Entry<Integer, PictureUrl> entry5 : map5.entrySet()) {
                sb5.append(entry5.getKey());
                sb5.append(ProgressTracer.SEPARATOR);
                sb5.append(entry5.getValue());
                sb5.append("\n");
            }
            sb5.append("}");
            sb5.append("\n");
        }
        if (!TextUtils.isEmpty(this.qbossTrace)) {
            sb5.append("qbossTrace: ");
            sb5.append(this.qbossTrace);
            sb5.append("\n");
        }
        sb5.append("hasReportExposure: ");
        sb5.append(this.hasReportExposure);
        sb5.append("\n");
        Map<Integer, String> map6 = this.feedReportCookie;
        if (map6 != null) {
            sb5.append("feedReportCookie {");
            sb5.append("\n");
            for (Map.Entry<Integer, String> entry6 : map6.entrySet()) {
                sb5.append(entry6.getKey());
                sb5.append(ProgressTracer.SEPARATOR);
                sb5.append((Object) entry6.getValue());
                sb5.append("\n");
            }
            sb5.append("}");
            sb5.append("\n");
        }
        sb5.append("offlineResourceBid: ");
        sb5.append(this.offlineResourceBid);
        sb5.append("\n");
        sb5.append("}");
        return sb5.toString();
    }

    public static CellOperationInfo create(l lVar) {
        if (lVar == null || lVar.f50378t == null) {
            return null;
        }
        CellOperationInfo cellOperationInfo = new CellOperationInfo();
        cell_operation cell_operationVar = lVar.f50378t;
        cellOperationInfo.weixinUrl = cell_operationVar.weixin_url;
        cellOperationInfo.busiParam = cell_operationVar.busi_param;
        cellOperationInfo.bypassParam = cell_operationVar.bypass_param;
        cellOperationInfo.qqUrl = cell_operationVar.qq_url;
        cellOperationInfo.shareData = DetailDataOutShare.create(lVar);
        cell_operation cell_operationVar2 = lVar.f50378t;
        s_schema s_schemaVar = cell_operationVar2.schema_info;
        if (s_schemaVar != null) {
            cellOperationInfo.actionType = s_schemaVar.actiontype;
            cellOperationInfo.actionUrl = s_schemaVar.actionurl;
            cellOperationInfo.downloadUrl = s_schemaVar.downloadurl;
            cellOperationInfo.appid = s_schemaVar.appid;
            cellOperationInfo.userPost = s_schemaVar.usepost;
            cellOperationInfo.postParams = s_schemaVar.postparams;
            cellOperationInfo.schemaPageUrl = s_schemaVar.schemapageurl;
            cellOperationInfo.yingYongBao = s_schemaVar.yingyongbao;
        }
        s_outshare s_outshareVar = cell_operationVar2.share_info;
        if (s_outshareVar != null) {
            cellOperationInfo.title = s_outshareVar.title;
            cellOperationInfo.summary = s_outshareVar.summary;
            Map<Integer, s_picurl> map = s_outshareVar.photourl;
            if (map != null && map.size() > 0) {
                cellOperationInfo.photoUrl = new HashMap();
                for (Map.Entry<Integer, s_picurl> entry : lVar.f50378t.share_info.photourl.entrySet()) {
                    cellOperationInfo.photoUrl.put(entry.getKey(), com.qzone.proxy.feedcomponent.util.e.n(entry.getValue()));
                }
            }
        }
        cell_operation cell_operationVar3 = lVar.f50378t;
        cellOperationInfo.genericUrl = cell_operationVar3.generic_url;
        cellOperationInfo.cookie = cell_operationVar3.recomm_cookie;
        cellOperationInfo.droplist_cookie = cell_operationVar3.droplist_cookie;
        cellOperationInfo.click_stream_report = cell_operationVar3.click_stream_report;
        cellOperationInfo.qbossTrace = cell_operationVar3.qboss_trace;
        ArrayList<s_op_btn> arrayList = cell_operationVar3.custom_btn;
        if (arrayList != null && !arrayList.isEmpty()) {
            cellOperationInfo.opBtns = new ArrayList<>();
            Iterator<s_op_btn> it = lVar.f50378t.custom_btn.iterator();
            while (it.hasNext()) {
                s_op_btn next = it.next();
                if (next != null) {
                    OpBtn opBtn = new OpBtn();
                    opBtn.actiontype = next.btn_actiontype;
                    opBtn.url = next.btn_url;
                    opBtn.color = next.btn_color;
                    opBtn.title = next.btn_title;
                    cellOperationInfo.opBtns.add(opBtn);
                }
            }
        }
        cellOperationInfo.hasReportExposure = 0;
        cellOperationInfo.IsVideoPlayExpose = 0;
        cell_operation cell_operationVar4 = lVar.f50378t;
        cellOperationInfo.feedReportCookie = cell_operationVar4.feed_report_cookie;
        cellOperationInfo.offlineResourceBid = cell_operationVar4.offline_resource_bid;
        cellOperationInfo.gdtAdvButtonGifUrl = cell_operationVar4.button_gif_url;
        cellOperationInfo.qzoneFeedid = cell_operationVar4.qzone_feedid;
        cellOperationInfo.rank_param = cell_operationVar4.rank_param;
        return cellOperationInfo;
    }
}
