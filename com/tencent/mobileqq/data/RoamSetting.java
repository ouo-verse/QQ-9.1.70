package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes10.dex */
public class RoamSetting extends Entity {
    public static final String SETTING_REVISION = "setting_revision";

    @unique
    public String path;
    public String value;

    public RoamSetting() {
    }

    public static int getIntValue(RoamSetting roamSetting, int i3) {
        if (roamSetting == null) {
            return i3;
        }
        String str = roamSetting.value;
        if (str != null && str.length() != 0) {
            try {
                return Integer.parseInt(roamSetting.value);
            } catch (Exception e16) {
                e16.printStackTrace();
                return i3;
            }
        }
        return i3;
    }

    public RoamSetting(String str, String str2) {
        this.path = str;
        this.value = str2;
    }
}
