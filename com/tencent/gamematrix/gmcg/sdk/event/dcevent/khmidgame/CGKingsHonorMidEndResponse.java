package com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGKingsHonorMidEndResponse {
    private int ack;
    private Data data;
    private List<Pair<String, Boolean>> mConditionResults;
    private int retry_times;
    public long seq;
    public String type;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Data {
        public List<String> buttons;
        public List<Text> conditionTexts;
        public int failCount;
        public boolean isPass;
        public String mainText;
        public List<TextField> mainTextFields;
        public int missionCode;
        public String vid;
        public String vtitle;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class Text {
        public boolean finish;
        public String text;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class TextField {
        public boolean clickable;
        public String field;
        public boolean highlight;
        public String url;
    }

    public List<Pair<String, Boolean>> getConditionResults() {
        List<Text> list;
        List<Pair<String, Boolean>> list2 = this.mConditionResults;
        if (list2 != null) {
            return list2;
        }
        ArrayList arrayList = new ArrayList();
        this.mConditionResults = arrayList;
        Data data = this.data;
        if (data != null && (list = data.conditionTexts) != null) {
            for (Text text : list) {
                this.mConditionResults.add(new Pair<>(text.text, Boolean.valueOf(text.finish)));
            }
            return this.mConditionResults;
        }
        return arrayList;
    }

    @Nullable
    public Integer getFailCount() {
        Data data = this.data;
        if (data != null) {
            return Integer.valueOf(data.failCount);
        }
        return null;
    }

    @Nullable
    public Integer getMissionCode() {
        Data data = this.data;
        if (data != null) {
            return Integer.valueOf(data.missionCode);
        }
        return null;
    }

    @Nullable
    public String getResultTitle() {
        Data data = this.data;
        if (data != null) {
            return data.mainText;
        }
        return null;
    }

    @Nullable
    public String getVid() {
        Data data = this.data;
        if (data != null) {
            return data.vid;
        }
        return null;
    }

    public boolean isPass() {
        Data data = this.data;
        if (data != null && data.isPass) {
            return true;
        }
        return false;
    }
}
