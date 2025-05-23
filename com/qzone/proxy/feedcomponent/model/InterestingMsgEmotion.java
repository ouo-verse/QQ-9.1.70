package com.qzone.proxy.feedcomponent.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class InterestingMsgEmotion implements SmartParcelable {

    @NeedParcel
    public int mEmotionHeight_b;

    @NeedParcel
    public int mEmotionHeight_s;

    @NeedParcel
    public int mEmotionID;

    @NeedParcel
    public String mEmotionText;

    @NeedParcel
    public int mEmotionWidth_b;

    @NeedParcel
    public int mEmotionWidth_s;

    @NeedParcel
    public Map<String, String> mExtendInfo;

    @NeedParcel
    public String mRapidEmotionUrl_b;

    @NeedParcel
    public String mRapidEmotionUrl_s;

    public InterestingMsgEmotion() {
        this.mRapidEmotionUrl_s = "";
        this.mRapidEmotionUrl_b = "";
        this.mEmotionText = "";
        this.mExtendInfo = null;
    }

    public InterestingMsgEmotion(int i3, String str, String str2, int i16, int i17, int i18, int i19, String str3, Map<String, String> map) {
        this.mEmotionID = i3;
        this.mRapidEmotionUrl_s = str;
        this.mRapidEmotionUrl_b = str2;
        this.mEmotionWidth_s = i16;
        this.mEmotionHeight_s = i17;
        this.mEmotionWidth_b = i18;
        this.mEmotionHeight_b = i19;
        this.mEmotionText = str3;
        this.mExtendInfo = map;
    }
}
