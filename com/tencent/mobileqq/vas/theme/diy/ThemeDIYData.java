package com.tencent.mobileqq.vas.theme.diy;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeDIYData implements Serializable {
    public static final int ITEM_SAVE_ERR = -1;
    public static final int ITEM_SAVE_ING = 4;
    public static final int ITEM_SAVE_INIT = 3;
    public static final int ITEM_SAVE_OK = 6;
    public static final int ITEM_SET_CHANGE = 2;
    public static final int ITEM_SET_INIT = 0;
    public int dealInt;
    public String dealSpkey;
    public String defaultButtonText;
    public int mSaveStatus;
    public int mSetStatus;
    public int orgMarkColor;
    public String orgSpKey;
    public String pageName;
    public int position;
    public int themeBgID;
    public String themeShot;
    public ResData tryOnBgBigOrgRD;
    public ResData tryOnBgBigRD;

    public ThemeDIYData(int i3, String str, int i16, String str2, int i17, int i18) {
        this.themeBgID = i3;
        this.orgSpKey = str;
        this.orgMarkColor = i16;
        this.dealSpkey = str2;
        this.dealInt = i17;
        this.position = i18;
    }
}
