package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_COMM.sparkle_word;
import NS_MOBILE_FEEDS.cell_decorate;
import NS_MOBILE_FEEDS.cell_summary;
import NS_MOBILE_FEEDS.cnst.PROTO_EXT_TO_UGCSVR_FOR_FONT;
import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.stcustomPraise;
import PROTO_EXT_TO_UGCSVR.Font;
import android.graphics.Color;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.text.font.FontManager;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellSummary implements SmartParcelable {
    public static final String KEY_FONT_ID = "diy_font_id";
    public static final String KEY_FONT_TYPE = "diy_font_type";
    public static final String KEY_FONT_URL = "diy_font_url";
    public static final String KEY_SUPER_FONT_INFO = "sparkle_json";
    public static final String SUMMARY_RECOMM_TAB = "recomm_summary";
    public static final String SUMMARY_TAB = "summary";

    @NeedParcel
    public int actionType;

    @NeedParcel
    public String actionUrl;

    @NeedParcel
    public QzoneBarrageEffectData.BarrageEffectInfo barrageEffectInfo;

    @NeedParcel
    public String customPraiseStr;
    public String displayReadeableStr;
    public String displayStr;

    @NeedParcel
    public CommFontInfo fontInfo;

    @NeedParcel
    public int isMore;

    @NeedParcel
    public Map<String, String> mapExt;

    @NeedParcel
    public String more_info;

    @NeedParcel
    public SparkleWord sparkleWord;

    @NeedParcel
    public String summary;
    public Integer summaryAreaCacheKey;

    @NeedParcel
    public ArrayList<PictureItem> summarypic;
    public QzoneSuperPersonalFontData.SuperFontInfo superFontInfo;
    public String uniKey;

    @NeedParcel
    public boolean autoPlayPetPraise = true;
    public int minLine = -1;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class SparkleWord implements SmartParcelable {

        @NeedParcel
        public int span_time;

        @NeedParcel
        public ArrayList<Integer> sparkle_color = null;

        @NeedParcel
        public Map<String, String> extend_info = null;

        public static SparkleWord creat(sparkle_word sparkle_wordVar) {
            if (sparkle_wordVar == null) {
                return null;
            }
            SparkleWord sparkleWord = new SparkleWord();
            if (sparkle_wordVar.sparkle_color != null) {
                sparkleWord.sparkle_color = new ArrayList<>(2);
                Iterator<String> it = sparkle_wordVar.sparkle_color.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    try {
                        if (!TextUtils.isEmpty(next)) {
                            if (!next.startsWith("#")) {
                                next = "#" + next;
                            }
                            sparkleWord.sparkle_color.add(Integer.valueOf(Color.parseColor(next)));
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            sparkleWord.span_time = (int) sparkle_wordVar.span_time;
            sparkleWord.extend_info = sparkle_wordVar.extend_info;
            return sparkleWord;
        }

        public boolean isEmpty() {
            ArrayList<Integer> arrayList;
            return this.span_time == 0 || (arrayList = this.sparkle_color) == null || arrayList.size() < 2;
        }
    }

    public static QzoneSuperPersonalFontData.SuperFontInfo getSuperFontInfo(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = map.get("sparkle_json");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return QzoneSuperPersonalFontData.SuperFontInfo.fromJson(str);
    }

    public String getFontBGUrl(boolean z16) {
        JSONObject jSONObject;
        Map<String, String> map = this.mapExt;
        if (map == null || map.isEmpty()) {
            return null;
        }
        if (getFontId(z16) > 0) {
            try {
                if (!this.mapExt.containsKey("diy_font_bgurl")) {
                    return null;
                }
                jSONObject = new JSONObject(this.mapExt.get("diy_font_bgurl"));
                if (jSONObject.isNull("strFontBgAndFile")) {
                    return null;
                }
            } catch (Exception unused) {
                return null;
            }
        }
        return jSONObject.getString("strFontBgAndFile");
    }

    public int getFontId(boolean z16) {
        Map<String, String> map = this.mapExt;
        if (map != null && !map.isEmpty()) {
            try {
                int intValue = Integer.valueOf(this.mapExt.get("diy_font_id")).intValue();
                if (!z16 || FontManager.isFontEnable()) {
                    return intValue;
                }
                return -1;
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public int getFontSize() {
        CommFontInfo commFontInfo = this.fontInfo;
        if (commFontInfo != null) {
            return commFontInfo.fontSize;
        }
        return 0;
    }

    public int getFontType(boolean z16) {
        Map<String, String> map = this.mapExt;
        if (map != null && !map.isEmpty() && getFontId(z16) > 0) {
            try {
                return Integer.valueOf(this.mapExt.get("diy_font_type")).intValue();
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public String getFontUrl(boolean z16) {
        if (this.mapExt == null || getFontId(z16) <= 0) {
            return null;
        }
        return this.mapExt.get("diy_font_url");
    }

    public int getHideFlag() {
        CommFontInfo commFontInfo = this.fontInfo;
        if (commFontInfo != null) {
            return commFontInfo.hideFlag;
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("CellSummary {\n");
        if (!TextUtils.isEmpty(this.summary)) {
            sb5.append("summary=");
            sb5.append(this.summary);
            sb5.append("\n");
        }
        sb5.append("isMore=");
        sb5.append(this.actionType);
        sb5.append("\n");
        sb5.append("actionType=");
        sb5.append(this.actionType);
        sb5.append("\n");
        if (this.summarypic != null) {
            for (int i3 = 0; i3 < this.summarypic.size(); i3++) {
                sb5.append("summarypic[");
                sb5.append(i3);
                sb5.append("]: ");
                sb5.append(this.summarypic.get(i3).toString());
                sb5.append("\n");
            }
        }
        sb5.append("}");
        return sb5.toString();
    }

    public static CellSummary create(l lVar) {
        stcustomPraise stcustompraise;
        if (lVar == null || lVar.f50348e == null) {
            return null;
        }
        CellSummary cellSummary = new CellSummary();
        cell_decorate cell_decorateVar = lVar.f50347d0;
        if (cell_decorateVar != null && (stcustompraise = cell_decorateVar.customPraise) != null && stcustompraise.iItemId > 0 && !TextUtils.isEmpty(stcustompraise.strPraisePic)) {
            try {
                cellSummary.customPraiseStr = "{img:" + URLEncoder.encode(lVar.f50347d0.customPraise.strPraisePic, "UTF-8") + ",w:0,h:0}";
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        cell_summary cell_summaryVar = lVar.f50348e;
        cellSummary.summary = cell_summaryVar.summary;
        cellSummary.isMore = cell_summaryVar.hasmore;
        cellSummary.actionType = cell_summaryVar.actiontype;
        cellSummary.more_info = cell_summaryVar.more_info;
        ArrayList<s_picdata> arrayList = cell_summaryVar.summarypic;
        if (arrayList != null && arrayList.size() > 0) {
            cellSummary.summarypic = new ArrayList<>();
            for (int i3 = 0; i3 < lVar.f50348e.summarypic.size(); i3++) {
                cellSummary.summarypic.add(com.qzone.proxy.feedcomponent.util.e.m(lVar.f50348e.summarypic.get(i3)));
            }
        }
        Map<String, String> map = lVar.f50348e.mapExt;
        cellSummary.mapExt = map;
        cellSummary.superFontInfo = getSuperFontInfo(map);
        cellSummary.sparkleWord = SparkleWord.creat(lVar.f50348e.sparkleword);
        cellSummary.fontInfo = CommFontInfo.crate(lVar.f50348e.mapProtoExt);
        cellSummary.barrageEffectInfo = QzoneBarrageEffectData.BarrageEffectInfo.fromFeedsJceData(lVar.f50348e.mapProtoExt.get(UNIVERSAL_MALL_QUAL.value));
        cellSummary.actionUrl = lVar.f50348e.actionurl;
        return cellSummary;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class CommFontInfo implements SmartParcelable {

        @NeedParcel
        public int fontSize = 0;

        @NeedParcel
        public int hideFlag = 0;

        public static CommFontInfo crate(Map<String, byte[]> map) {
            Font font;
            if (map == null) {
                return null;
            }
            CommFontInfo commFontInfo = new CommFontInfo();
            byte[] bArr = map.get(PROTO_EXT_TO_UGCSVR_FOR_FONT.value);
            if (bArr != null && (font = (Font) com.qzone.adapter.feedcomponent.i.H().u(Font.class, bArr)) != null) {
                commFontInfo.fontSize = font.font_size;
                commFontInfo.hideFlag = font.hideFlag;
            }
            return commFontInfo;
        }
    }

    public QzoneSuperPersonalFontData.SuperFontInfo getSuperFontInfo(boolean z16) {
        if (z16 && !FontManager.isSuperFontEnable()) {
            return null;
        }
        QzoneSuperPersonalFontData.SuperFontInfo superFontInfo = this.superFontInfo;
        return superFontInfo != null ? superFontInfo : getSuperFontInfo();
    }

    public QzoneSuperPersonalFontData.SuperFontInfo getSuperFontInfo() {
        Map<String, String> map = this.mapExt;
        if (map == null || map.isEmpty()) {
            return null;
        }
        String str = this.mapExt.get("sparkle_json");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return QzoneSuperPersonalFontData.SuperFontInfo.fromJson(str);
    }
}
