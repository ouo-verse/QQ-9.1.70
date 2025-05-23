package com.qzone.reborn.part.publish.mood.sync;

import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes37.dex */
public class o extends ql.a {
    private final MutableLiveData<Boolean> C;
    private final MutableLiveData<Boolean> D;
    private String E;
    private String F;
    private String G;

    /* renamed from: m, reason: collision with root package name */
    private final MutableLiveData<Boolean> f58736m;

    public o() {
        Boolean bool = Boolean.FALSE;
        this.f58736m = new MutableLiveData<>(bool);
        this.C = new MutableLiveData<>(bool);
        this.D = new MutableLiveData<>(bool);
    }

    @Override // ql.a
    public boolean M1() {
        return false;
    }

    public String O1() {
        return this.G;
    }

    public String P1() {
        return this.F;
    }

    public String Q1() {
        return this.E;
    }

    public MutableLiveData<Boolean> R1() {
        return this.D;
    }

    public int S1() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_KEY_SYNC_QFS_MEMORY_COUNT_THRESHOLD, 1);
    }

    public MutableLiveData<Boolean> T1() {
        return this.f58736m;
    }

    public MutableLiveData<Boolean> U1() {
        return this.C;
    }

    public void W1(boolean z16) {
        int v3 = u5.c.v();
        if (z16 && v3 >= S1()) {
            RFWLog.i("QZonePublishSyncStatusViewModel", RFWLog.CLR, "has satisfied sync qfs condition, no need to add again");
        } else {
            u5.c.y(z16 ? v3 + 1 : 0);
        }
    }

    public boolean X1() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_KEY_PUBLISH_PAGE_SYNC_QCIRCLE_PART_SHOW, 1) == 1;
    }

    public boolean Z1() {
        return u5.c.v() >= S1();
    }

    public void b2(String str) {
        this.G = str;
    }

    public void c2(String str) {
        this.F = str;
    }

    public void d2(String str) {
        this.E = str;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QZonePublishSyncStatusViewModel";
    }

    public static boolean a2(Intent intent) {
        if (intent == null) {
            return false;
        }
        return TextUtils.equals(intent.getStringExtra("ACTION_QCIRCLE_SYNC_PREVIEW"), "ACTION_QCIRCLE_PREVIEW_VAL_TRUE");
    }
}
