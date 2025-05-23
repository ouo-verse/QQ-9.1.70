package com.qq.wx.voice.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ManagerInfoRecord {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences.Editor f41122a;

    /* renamed from: b, reason: collision with root package name */
    private SharedPreferences f41123b;

    public void add(boolean z16, String str) {
        synchronized (this) {
            if ("wifi" == str) {
                if (z16) {
                    this.f41122a.putInt("wifi_success", this.f41123b.getInt("wifi_success", 0) + 1);
                    this.f41122a.commit();
                } else {
                    this.f41122a.putInt("wifi_fail", this.f41123b.getInt("wifi_fail", 0) + 1);
                    this.f41122a.commit();
                }
            } else if (QADNetStatus.G_2 == str) {
                if (z16) {
                    this.f41122a.putInt("2g_success", this.f41123b.getInt("2g_success", 0) + 1);
                    this.f41122a.commit();
                } else {
                    this.f41122a.putInt("2g_fail", this.f41123b.getInt("2g_fail", 0) + 1);
                    this.f41122a.commit();
                }
            } else if ("ct3g" == str) {
                if (z16) {
                    this.f41122a.putInt("ct3g_success", this.f41123b.getInt("ct3g_success", 0) + 1);
                    this.f41122a.commit();
                } else {
                    this.f41122a.putInt("ct3g_fail", this.f41123b.getInt("ct3g_fail", 0) + 1);
                    this.f41122a.commit();
                }
            } else if ("cu3g" == str) {
                if (z16) {
                    this.f41122a.putInt("cu3g_success", this.f41123b.getInt("cu3g_success", 0) + 1);
                    this.f41122a.commit();
                } else {
                    this.f41122a.putInt("cu3g_fail", this.f41123b.getInt("cu3g_fail", 0) + 1);
                    this.f41122a.commit();
                }
            } else if (z16) {
                this.f41122a.putInt("other_success", this.f41123b.getInt("other_success", 0) + 1);
                this.f41122a.commit();
            } else {
                this.f41122a.putInt("other_fail", this.f41123b.getInt("other_fail", 0) + 1);
                this.f41122a.commit();
            }
            this.f41122a.putInt("count", this.f41123b.getInt("count", 0) + 1);
            this.f41122a.commit();
        }
    }

    public void clear() {
        synchronized (this) {
            this.f41122a.clear().commit();
        }
    }

    public int get(boolean z16, String str) {
        synchronized (this) {
            if ("wifi" == str) {
                if (z16) {
                    return this.f41123b.getInt("wifi_success", 0);
                }
                return this.f41123b.getInt("wifi_fail", 0);
            }
            if (QADNetStatus.G_2 == str) {
                if (z16) {
                    return this.f41123b.getInt("2g_success", 0);
                }
                return this.f41123b.getInt("2g_fail", 0);
            }
            if ("ct3g" == str) {
                if (z16) {
                    return this.f41123b.getInt("ct3g_success", 0);
                }
                return this.f41123b.getInt("ct3g_fail", 0);
            }
            if ("cu3g" == str) {
                if (z16) {
                    return this.f41123b.getInt("cu3g_success", 0);
                }
                return this.f41123b.getInt("cu3g_fail", 0);
            }
            if (z16) {
                return this.f41123b.getInt("other_success", 0);
            }
            return this.f41123b.getInt("other_fail", 0);
        }
    }

    public String getRecordStr() {
        return "&2g_fail=" + get(false, QADNetStatus.G_2) + "&2g_success=" + get(true, QADNetStatus.G_2) + "&ct3g_fail=" + get(false, "ct3g") + "&ct3g_success=" + get(true, "ct3g") + "&cu3g_fail=" + get(false, "cu3g") + "&cu3g_success=" + get(true, "cu3g") + "&other_fail=" + get(false, "other") + "&other_success=" + get(true, "other") + "&wifi_fail=" + get(false, "wifi") + "&wifi_success=" + get(true, "wifi");
    }

    public void init(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("wxvoicesdk", 0);
        this.f41123b = sharedPreferences;
        this.f41122a = sharedPreferences.edit();
    }

    public boolean isNeedUpdate() {
        synchronized (this) {
            if (this.f41123b.getInt("count", 0) < 10) {
                return false;
            }
            return true;
        }
    }
}
