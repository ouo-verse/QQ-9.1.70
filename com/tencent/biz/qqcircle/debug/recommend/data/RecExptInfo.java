package com.tencent.biz.qqcircle.debug.recommend.data;

import com.tencent.biz.qqcircle.utils.h;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class RecExptInfo {
    public String exptConfig;
    public String exptIntro;
    public String exptName;
    public String exptSubSceneID;
    public String jsonString;

    public static RecExptInfo obtainDefault() {
        RecExptInfo recExptInfo = new RecExptInfo();
        recExptInfo.exptName = h.a(R.string.f182603gx);
        recExptInfo.exptConfig = "";
        recExptInfo.jsonString = "";
        recExptInfo.exptSubSceneID = "";
        return recExptInfo;
    }
}
