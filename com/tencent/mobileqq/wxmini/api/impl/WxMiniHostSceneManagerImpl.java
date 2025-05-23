package com.tencent.mobileqq.wxmini.api.impl;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.wxmini.api.IWxMiniHostSceneManager;
import com.tencent.mobileqq.wxmini.impl.util.j;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;

/* compiled from: P */
/* loaded from: classes35.dex */
public class WxMiniHostSceneManagerImpl implements IWxMiniHostSceneManager {
    private String appendParams(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str4 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str4 = ContainerUtils.FIELD_DELIMITER;
        }
        sb5.append(str4);
        sb5.append(str2);
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(str3);
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniHostSceneManager
    public int combine(String str, String str2, String str3, int i3) {
        return j.a(str, str2, str3, i3);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniHostSceneManager
    public int convertFromRefer(int i3) {
        return j.c(i3);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniHostSceneManager
    public int formatHostScene(String str, int i3) {
        return j.d(str, i3);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniHostSceneManager
    public int transformDropDownHostScene(int i3, boolean z16, int i16) {
        return j.e(i3, z16, i16);
    }

    @Override // com.tencent.mobileqq.wxmini.api.IWxMiniHostSceneManager
    public String formatShareGuildFeedsUrl(String str) {
        return appendParams(str, "host_scene", String.valueOf(j.c(1075)));
    }
}
