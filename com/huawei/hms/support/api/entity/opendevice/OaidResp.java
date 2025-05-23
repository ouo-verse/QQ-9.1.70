package com.huawei.hms.support.api.entity.opendevice;

import android.app.PendingIntent;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* compiled from: P */
/* loaded from: classes2.dex */
public class OaidResp extends AbstractMessageEntity {

    /* renamed from: id, reason: collision with root package name */
    @Packed
    public String f37552id;

    @Packed
    public boolean isTrackLimited;

    @Packed
    public PendingIntent settingIntent;

    public String getId() {
        return this.f37552id;
    }

    public PendingIntent getSettingIntent() {
        return this.settingIntent;
    }

    public boolean isTrackLimited() {
        return this.isTrackLimited;
    }

    public void setId(String str) {
        this.f37552id = str;
    }

    public void setSettingIntent(PendingIntent pendingIntent) {
        this.settingIntent = pendingIntent;
    }

    public void setTrackLimited(boolean z16) {
        this.isTrackLimited = z16;
    }
}
