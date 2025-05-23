package com.huawei.hms.support.api.entity.core;

import android.content.Intent;
import com.huawei.hms.core.aidl.annotation.Packed;

/* compiled from: P */
/* loaded from: classes2.dex */
public class JosGetNoticeResp extends JosBaseResp {

    @Packed
    private Intent noticeIntent;

    public Intent getNoticeIntent() {
        return (Intent) get(this.noticeIntent);
    }

    public void setNoticeIntent(Intent intent) {
        this.noticeIntent = intent;
    }

    private static <T> T get(T t16) {
        return t16;
    }
}
