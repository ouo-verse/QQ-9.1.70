package com.qzone.feed.business.model;

import NS_MOBILE_FEEDS.mobile_festival_rsp;
import android.net.Uri;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FestivalResponse implements SmartParcelable {
    public String attachInfo;

    @NeedParcel
    public long endTime;

    @NeedParcel
    public long interval;

    @NeedParcel
    public int playFlag;

    @NeedParcel
    public long playTime;

    @NeedParcel
    public ArrayList<String> playUrlList;

    @NeedParcel
    public long startTime;
    private Uri uri;

    public static FestivalResponse convertFromRsp(mobile_festival_rsp mobile_festival_rspVar) {
        FestivalResponse festivalResponse = new FestivalResponse();
        festivalResponse.playFlag = mobile_festival_rspVar.play_flag;
        festivalResponse.playUrlList = mobile_festival_rspVar.play_url_list;
        festivalResponse.playTime = mobile_festival_rspVar.play_time;
        festivalResponse.interval = mobile_festival_rspVar.interval;
        festivalResponse.startTime = mobile_festival_rspVar.start_time;
        festivalResponse.endTime = mobile_festival_rspVar.end_time;
        festivalResponse.attachInfo = mobile_festival_rspVar.attach_info;
        return festivalResponse;
    }

    public String getParameter(String str) {
        try {
            if (this.uri == null) {
                this.uri = Uri.parse(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + this.attachInfo);
            }
            return this.uri.getQueryParameter(str);
        } catch (Exception unused) {
            return "";
        }
    }
}
