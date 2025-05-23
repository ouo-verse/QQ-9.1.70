package com.tencent.ttpic.offlineset.beans;

import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FilterConfigBean {
    public List<FilterParam> filterConfigList;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class FilterParam {
        public int disable = 0;
        public String filterID;
        public Map<String, Float> params;
        public float strength;
    }
}
