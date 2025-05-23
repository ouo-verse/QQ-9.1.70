package com.tencent.ttpic.offlineset.beans;

import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FilterSettingJsonBean {
    public GaussSetting gaussSetting;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class GassResizeSet {
        public String brand;
        public String model;
        public boolean needResize = true;
        public float scale = -1.0f;
        public int maxSize = -1;
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class GaussSetting {
        public List<GassResizeSet> phoneGassSet;
        public int gaussSuperPhone = 2016;
        public int gaussMidderPhone = 2014;
        public float superMaxSize = 720.0f;
        public float midMaxSize = 360.0f;
        public float lowMaxSize = 360.0f;
    }
}
