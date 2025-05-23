package com.qzone.proxy.feedcomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes39.dex */
public class InterestingMsgPicturesTabInfo implements SmartParcelable {

    @NeedParcel
    public Map<String, String> mExtendInfo;

    @NeedParcel
    public ArrayList<InterestingMsgEmotion> mRapidEmotions;

    @NeedParcel
    public long mTabID;

    @NeedParcel
    public String mZipMD5Value;

    @NeedParcel
    public String mZipUrl;

    public InterestingMsgPicturesTabInfo() {
        this.mRapidEmotions = null;
        this.mZipUrl = "";
        this.mZipMD5Value = "";
        this.mExtendInfo = null;
    }

    public InterestingMsgPicturesTabInfo(long j3, ArrayList<InterestingMsgEmotion> arrayList, String str, String str2, Map<String, String> map) {
        this.mTabID = j3;
        this.mRapidEmotions = arrayList;
        this.mZipUrl = str;
        this.mZipMD5Value = str2;
        this.mExtendInfo = map;
    }
}
