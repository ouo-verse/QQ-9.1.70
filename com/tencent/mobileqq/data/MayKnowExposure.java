package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MayKnowExposure extends Entity {
    public static final int EXPOSE_ACTION_CLICK_ADD = 3;
    public static final int EXPOSE_ACTION_CLICK_PROFILE = 2;
    public static final int EXPOSE_ACTION_SHOWUP = 1;
    public static final int EXPOSE_ENTRANCE_BABYQ = 7;
    public static final int EXPOSE_ENTRANCE_CONTACTS_ADDFRIEND = 3;
    public static final int EXPOSE_ENTRANCE_CONTACTS_NEWFRIEND = 2;
    public static final int EXPOSE_ENTRANCE_CONTACT_BANNER = 8;
    public static final int EXPOSE_ENTRANCE_CONVERSATION_ADDFRIEND = 4;
    public static final int EXPOSE_ENTRANCE_CONVERSATION_NEWFRIEND = 1;
    public static final int EXPOSE_ENTRANCE_DEFAULT = 0;
    public static final int EXPOSE_ENTRANCE_FIND_PEOPLE_SEARCH = 11;
    public static final int EXPOSE_ENTRANCE_NEWFRIEND_ADDFRIEND = 6;
    public static final int EXPOSE_ENTRANCE_PUSH_NOTICE = 9;
    public static final int EXPOSE_ENTRANCE_QZONE = 5;
    public static final int EXPOSE_ENTRANCE_SELECT_FINDNEWFRIEND = 10;
    public static final int EXPOSURE_FIND_SEARCH_BANNER = 12;
    public static final int EXPOSURE_PAGE_ADDFRIEND = 21;
    public static final int EXPOSURE_PAGE_CONTACT_BANNER = 24;
    public static final int EXPOSURE_PAGE_CONTACT_RECOMMEND_TAB = 20;
    public static final int EXPOSURE_PAGE_CONVERSION_RECOMMEND = 25;
    public static final int EXPOSURE_PAGE_DEFAULT = 0;
    public static final int EXPOSURE_PAGE_EXTEND_FRIEND_ENTRANCE = 53;
    public static final int EXPOSURE_PAGE_FINDNEWFRIEND = 28;
    public static final int EXPOSURE_PAGE_FIND_PEOPLE = 52;
    public static final int EXPOSURE_PAGE_FIND_SEARCH_BANNER = 54;
    public static final int EXPOSURE_PAGE_MAYKNOWALL = 3;
    public static final int EXPOSURE_PAGE_NEWFRIEND = 23;
    public static final int EXPOSURE_PAGE_QZONE = 4;
    public byte[] acBuffer;
    public int actionId;
    public byte[] additive;
    public int entranceId;
    public int exposeCnt;
    public int exposeTime;
    public int pageId;

    @notColumn
    public long startExploseTime;
    public String uin;

    public MayKnowExposure() {
    }

    public static String generateKey(MayKnowExposure mayKnowExposure) {
        StringBuffer stringBuffer = new StringBuffer(20);
        stringBuffer.append(mayKnowExposure.uin);
        stringBuffer.append("_");
        stringBuffer.append(mayKnowExposure.pageId);
        stringBuffer.append("_");
        stringBuffer.append(mayKnowExposure.entranceId);
        stringBuffer.append("_");
        stringBuffer.append(mayKnowExposure.actionId);
        return stringBuffer.toString();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(20);
        stringBuffer.append("uin:");
        stringBuffer.append(this.uin);
        stringBuffer.append(";pageId:");
        stringBuffer.append(this.pageId);
        stringBuffer.append(";entranceId:");
        stringBuffer.append(this.entranceId);
        stringBuffer.append(";actionId:");
        stringBuffer.append(this.actionId);
        stringBuffer.append(";exposeCnt");
        stringBuffer.append(this.exposeCnt);
        stringBuffer.append(";exposeTime");
        stringBuffer.append(this.exposeTime);
        stringBuffer.append(";startExploseTime");
        stringBuffer.append(this.startExploseTime);
        return stringBuffer.toString();
    }

    public MayKnowExposure(String str, int i3, int i16, int i17, byte[] bArr, byte[] bArr2) {
        this.uin = str;
        this.pageId = i3;
        this.entranceId = i16;
        this.actionId = i17;
        this.acBuffer = bArr;
        this.additive = bArr2;
    }

    public static String generateKey(MayKnowRecommend mayKnowRecommend, int i3, int i16, int i17) {
        StringBuffer stringBuffer = new StringBuffer(20);
        stringBuffer.append(mayKnowRecommend.uin);
        stringBuffer.append("_");
        stringBuffer.append(i3);
        stringBuffer.append("_");
        stringBuffer.append(i16);
        stringBuffer.append("_");
        stringBuffer.append(i17);
        return stringBuffer.toString();
    }
}
