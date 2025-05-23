package com.tencent.ttpic.offlineset.beans;

import java.util.List;

/* loaded from: classes27.dex */
public class PagSettingJsonBean {
    public int lowDeviceYear = 2015;
    public float lowScale = 0.5f;
    public List<PagDeviceSetting> phoneSetting;

    /* loaded from: classes27.dex */
    public static class PagDeviceSetting {
        public String brand;
        public String model;
        public int needLowScale = 0;
        public float scale = 0.5f;
        public boolean notRealTime = false;
        public int encodeBackgroud = 0;
        public boolean needSoftDecode = false;
    }
}
