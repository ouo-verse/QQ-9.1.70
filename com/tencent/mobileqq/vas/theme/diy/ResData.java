package com.tencent.mobileqq.vas.theme.diy;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ResData implements Serializable {
    static final String BUNDLE_KEY_INDEX = "index";
    static final String BUNDLE_KEY_TYPE = "type";
    public static final int RES_DATA_STATE_DEALED = 5;
    static final int RES_DATA_STATE_DEALING = 4;
    static final int RES_DATA_STATE_ERROR = -1;
    public static final int RES_DATA_STATE_INIT = 0;
    static final int RES_DATA_STATE_LOADED = 2;
    static final int RES_DATA_STATE_LOADING = 1;
    static final int RES_DATA_STATE_OK = 2;
    public static final int RES_LOADING_TYPE_AIO = 3;
    public static final int RES_LOADING_TYPE_MSG = 2;
    public static final int RES_LOADING_TYPE_SETTING = 1;
    static final int RES_TYPE_JSON_BG = 100;
    static final int RES_TYPE_JSON_STYLE = 200;
    static final int RES_TYPE_PIC_JPG_BG_BIG_ORG = 115;
    static final int RES_TYPE_PIC_JPG_BG_CUSTOM = 120;
    public static final int RES_TYPE_PIC_JPG_BG_CUSTOM_ORG = 121;
    static final int RES_TYPE_PIC_JPG_BG_PREVIEW = 110;
    static final int RES_TYPE_PIC_JPG_BG_THUM = 117;
    static final int RES_TYPE_PIC_JPG_STYLE_THUM = 202;
    static final int RES_TYPE_PIC_PNG_STYLE_SHOT = 201;
    static final int RES_TYPE_ZIP_STYLE = 207;
    String dealThemeID;
    String dealedName;
    int from;

    /* renamed from: id, reason: collision with root package name */
    public String f310908id;
    int index;
    public int loadingType;
    String name;
    public String path;
    int resID;
    public int state;
    public int type;
    public String url;

    public ResData() {
    }

    public ResData(String str, String str2, int i3, String str3, String str4, int i16, int i17, int i18, int i19) {
        this.name = str;
        this.f310908id = str2;
        this.index = i3;
        this.path = str3;
        this.url = str4;
        this.state = i16;
        this.type = i17;
        this.from = i19;
    }
}
