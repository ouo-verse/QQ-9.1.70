package com.tencent.ttpic.offlineset.beans;

import java.util.List;
import java.util.Map;

/* loaded from: classes27.dex */
public class AIBeautyParamsJsonBean {
    public List<BeautyConfigSet> aiBeautySets;
    public boolean isNeedBabyFace = true;

    /* loaded from: classes27.dex */
    public static class BeautyConfigSet {
        public int endAge;
        public boolean faceCosmetic;
        public int gender;
        public Map<String, Param> params;
        public int startAge;
        public String tag;

        public boolean isCurrent(int i3, int i16) {
            if (i3 >= this.startAge && i3 <= this.endAge && this.gender == i16) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes27.dex */
    public static class Param {
        public float def;
        public float max;
    }
}
