package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_video_nagative_feedback;
import NS_MOBILE_FEEDS.nagative_fb_info;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellNegativeFeedback implements SmartParcelable {

    @NeedParcel
    public ArrayList<negativeFbInfo> nagativeFbInfos = null;

    @NeedParcel
    public String leftTitle = "";

    @NeedParcel
    public String buttonTxt = "";

    @NeedParcel
    public String toastTxt = "";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class negativeFbInfo implements SmartParcelable {

        @NeedParcel
        public String attach_info;

        @NeedParcel
        public String fb_name;

        @NeedParcel
        public String fb_tag_txt;

        @NeedParcel
        public int fb_type;

        /* renamed from: id, reason: collision with root package name */
        @NeedParcel
        public int f50231id;

        @NeedParcel
        public String tag_name;

        @NeedParcel
        public int tag_type;
    }

    public static CellNegativeFeedback create(l lVar) {
        if (lVar == null || lVar.f50363l0 == null) {
            return null;
        }
        CellNegativeFeedback cellNegativeFeedback = new CellNegativeFeedback();
        cell_video_nagative_feedback cell_video_nagative_feedbackVar = lVar.f50363l0;
        cellNegativeFeedback.leftTitle = cell_video_nagative_feedbackVar.leftTitle;
        cellNegativeFeedback.buttonTxt = cell_video_nagative_feedbackVar.buttonTxt;
        cellNegativeFeedback.toastTxt = cell_video_nagative_feedbackVar.toastTxt;
        if (cell_video_nagative_feedbackVar.vecNagFbInfo != null) {
            cellNegativeFeedback.nagativeFbInfos = new ArrayList<>();
            Iterator<nagative_fb_info> it = lVar.f50363l0.vecNagFbInfo.iterator();
            while (it.hasNext()) {
                nagative_fb_info next = it.next();
                if (next != null) {
                    negativeFbInfo negativefbinfo = new negativeFbInfo();
                    negativefbinfo.fb_type = next.fb_type;
                    negativefbinfo.fb_name = next.fb_name;
                    negativefbinfo.tag_type = next.tag_type;
                    negativefbinfo.tag_name = next.tag_name;
                    negativefbinfo.attach_info = next.attach_info;
                    negativefbinfo.fb_tag_txt = next.fb_tag_txt;
                    negativefbinfo.f50231id = next.f24989id;
                    cellNegativeFeedback.nagativeFbInfos.add(negativefbinfo);
                }
            }
        }
        return cellNegativeFeedback;
    }
}
