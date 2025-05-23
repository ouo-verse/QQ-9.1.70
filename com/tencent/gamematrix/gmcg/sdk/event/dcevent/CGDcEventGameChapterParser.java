package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGDcEventGameChapterParser implements GmCgDcEventParser {
    private final ResultListener mResultListener;

    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onGmCgDcEventGameChapter(@Nullable Integer num);
    }

    public CGDcEventGameChapterParser(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }

    private void onResult(@Nullable Integer num) {
        ResultListener resultListener = this.mResultListener;
        if (resultListener != null) {
            resultListener.onGmCgDcEventGameChapter(num);
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public void parseDcEventDataFromReceive(String str) {
        JSONObject jsonObjectFromJsonObject;
        JSONObject jsonObjectFromJsonObject2;
        Integer num;
        JSONObject jsonObjectFromString = CGJsonUtil.getJsonObjectFromString(str);
        if (jsonObjectFromString == null || (jsonObjectFromJsonObject = CGJsonUtil.getJsonObjectFromJsonObject(jsonObjectFromString, "commonNotifyEvent")) == null || (jsonObjectFromJsonObject2 = CGJsonUtil.getJsonObjectFromJsonObject(jsonObjectFromJsonObject, "desc")) == null) {
            return;
        }
        int intFromJsonObject = CGJsonUtil.getIntFromJsonObject(jsonObjectFromJsonObject2, "game_chapter", -1);
        if (intFromJsonObject >= 0) {
            num = Integer.valueOf(intFromJsonObject);
        } else {
            num = null;
        }
        onResult(num);
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_COMMON_NOTIFY_EVENT;
    }
}
