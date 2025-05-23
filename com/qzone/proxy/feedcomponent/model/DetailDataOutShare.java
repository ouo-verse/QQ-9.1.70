package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_operation;
import NS_MOBILE_FEEDS.s_arkshare;
import NS_MOBILE_FEEDS.s_outshare;
import NS_MOBILE_FEEDS.s_picurl;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ProgressTracer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class DetailDataOutShare implements SmartParcelable {

    @NeedParcel
    public String action_url;

    @NeedParcel
    public String ark_content;

    @NeedParcel
    public String ark_id;

    @NeedParcel
    public Map<Integer, PictureUrl> mapPhotoUrl;

    @NeedParcel
    public String sSummary;

    @NeedParcel
    public String sTitle;

    @NeedParcel
    public String view_id;

    public void readFrom(Parcel parcel) {
        this.sTitle = parcel.readString();
        this.sSummary = parcel.readString();
        this.mapPhotoUrl = parcel.readHashMap(getClass().getClassLoader());
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("DetailDataOutShare{");
        if (!TextUtils.isEmpty(this.sTitle)) {
            sb5.append("sTitle: ");
            sb5.append(this.sTitle);
            sb5.append(", ");
        }
        if (!TextUtils.isEmpty(this.sSummary)) {
            sb5.append("sSummary: ");
            sb5.append(this.sSummary);
            sb5.append("\n");
        }
        Map<Integer, PictureUrl> map = this.mapPhotoUrl;
        if (map != null) {
            sb5.append("mapPhotoUrl {");
            sb5.append("\n");
            for (Map.Entry<Integer, PictureUrl> entry : map.entrySet()) {
                sb5.append(entry.getKey());
                sb5.append(ProgressTracer.SEPARATOR);
                sb5.append(entry.getValue());
                sb5.append("\n");
            }
            sb5.append("}");
            sb5.append("\n");
        }
        sb5.append("}");
        return sb5.toString();
    }

    public static DetailDataOutShare create(l lVar) {
        cell_operation cell_operationVar;
        if (lVar == null || (cell_operationVar = lVar.f50378t) == null || cell_operationVar.share_info == null) {
            return null;
        }
        DetailDataOutShare detailDataOutShare = new DetailDataOutShare();
        s_outshare s_outshareVar = lVar.f50378t.share_info;
        detailDataOutShare.sTitle = s_outshareVar.title;
        detailDataOutShare.sSummary = s_outshareVar.summary;
        Map<Integer, s_picurl> map = s_outshareVar.photourl;
        if (map != null && map.size() > 0) {
            detailDataOutShare.mapPhotoUrl = new HashMap();
            for (Map.Entry<Integer, s_picurl> entry : lVar.f50378t.share_info.photourl.entrySet()) {
                detailDataOutShare.mapPhotoUrl.put(entry.getKey(), com.qzone.proxy.feedcomponent.util.e.n(entry.getValue()));
            }
        }
        s_outshare s_outshareVar2 = lVar.f50378t.share_info;
        s_arkshare s_arkshareVar = s_outshareVar2.ark_sharedata;
        if (s_arkshareVar != null) {
            detailDataOutShare.ark_content = s_arkshareVar.ark_content;
            detailDataOutShare.ark_id = s_arkshareVar.ark_id;
            detailDataOutShare.view_id = s_arkshareVar.view_id;
        }
        detailDataOutShare.action_url = s_outshareVar2.action_url;
        return detailDataOutShare;
    }
}
