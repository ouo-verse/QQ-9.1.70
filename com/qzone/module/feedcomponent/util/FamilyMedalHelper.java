package com.qzone.module.feedcomponent.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.UserMedal;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FamilyMedalHelper {
    private static final byte[] INSTANCE_LOCK = new byte[0];
    private static FamilyMedalHelper sInstance;
    private UserMedal familyMedal;
    private Receiver receiver = new Receiver();
    private String encryptedData = null;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class Receiver extends BroadcastReceiver {
        Receiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str;
            String str2;
            if ("didSelectedNewFamilyIcon".equals(intent.getStringExtra("event"))) {
                String stringExtra = intent.getStringExtra("data");
                String str3 = null;
                long j3 = -1;
                if (stringExtra != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        j3 = jSONObject.optLong("uin");
                        str = jSONObject.optString("icon_url");
                        try {
                            str3 = jSONObject.optString("jump_url");
                        } catch (Exception e16) {
                            e = e16;
                            com.qzone.proxy.feedcomponent.b.d("FAMILY", "parse response err:" + stringExtra, e);
                            str2 = str3;
                            str3 = str;
                            if (j3 == i.H().j0()) {
                                return;
                            } else {
                                return;
                            }
                        }
                    } catch (Exception e17) {
                        e = e17;
                        str = null;
                    }
                    str2 = str3;
                    str3 = str;
                } else {
                    str2 = null;
                }
                if (j3 == i.H().j0() || str3 == null) {
                    return;
                }
                UserMedal userMedal = new UserMedal();
                userMedal.medalType = 5;
                userMedal.picUrl = str3;
                userMedal.jumpUrl = str2;
                FamilyMedalHelper.this.familyMedal = userMedal;
            }
        }
    }

    FamilyMedalHelper() {
        FeedGlobalEnv.getContext().registerReceiver(this.receiver, new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT"));
    }

    public static FamilyMedalHelper g() {
        if (sInstance == null) {
            synchronized (INSTANCE_LOCK) {
                if (sInstance == null) {
                    sInstance = new FamilyMedalHelper();
                }
            }
        }
        return sInstance;
    }

    public UserMedal getSelfFamilyMedal() {
        return this.familyMedal;
    }

    public void setSelfFamilyMedal(UserMedal userMedal) {
        this.familyMedal = userMedal;
    }
}
