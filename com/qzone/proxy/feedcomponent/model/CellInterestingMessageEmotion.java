package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_COMM.msgb_rapidemotion;
import NS_MOBILE_FEEDS.cell_msgb_rapidemotion;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellInterestingMessageEmotion implements SmartParcelable {

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
    public String mRapidEmotionUrl_s = "";

    @NeedParcel
    public String mRapidEmotionUrl_b = "";

    @NeedParcel
    public Map<String, String> mExtendInfo = null;

    public static CellInterestingMessageEmotion create(l lVar) {
        cell_msgb_rapidemotion cell_msgb_rapidemotionVar;
        if (lVar == null || (cell_msgb_rapidemotionVar = lVar.O) == null || cell_msgb_rapidemotionVar.emotion == null) {
            return null;
        }
        CellInterestingMessageEmotion cellInterestingMessageEmotion = new CellInterestingMessageEmotion();
        msgb_rapidemotion msgb_rapidemotionVar = lVar.O.emotion;
        cellInterestingMessageEmotion.mEmotionID = msgb_rapidemotionVar.emotion_id;
        cellInterestingMessageEmotion.mRapidEmotionUrl_s = msgb_rapidemotionVar.rapid_emotion_url_s;
        cellInterestingMessageEmotion.mRapidEmotionUrl_b = msgb_rapidemotionVar.rapid_emotion_url_b;
        cellInterestingMessageEmotion.mEmotionWidth_s = msgb_rapidemotionVar.emotion_width_s;
        cellInterestingMessageEmotion.mEmotionHeight_s = msgb_rapidemotionVar.emotion_height_s;
        cellInterestingMessageEmotion.mEmotionWidth_b = msgb_rapidemotionVar.emotion_width_b;
        cellInterestingMessageEmotion.mEmotionHeight_b = msgb_rapidemotionVar.emotion_height_b;
        cellInterestingMessageEmotion.mEmotionText = msgb_rapidemotionVar.emotion_text;
        cellInterestingMessageEmotion.mExtendInfo = msgb_rapidemotionVar.extend_info;
        return cellInterestingMessageEmotion;
    }
}
