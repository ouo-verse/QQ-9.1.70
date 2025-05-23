package com.tencent.mobileqq.gamecenter.api.impl;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMallLebaApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public class GameMallLebaApiImpl implements IGameMallLebaApi {
    private static final String TAG = "GameMallLebaApiImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> buildReportExtMap(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16, boolean z17) {
        String str;
        String str2;
        HashMap<String, String> hashMap = new HashMap<>();
        if (z17) {
            str = "20";
        } else {
            str = "8";
        }
        hashMap.put("ext4", str);
        if (z16) {
            str2 = "2";
        } else {
            str2 = "1";
        }
        hashMap.put("ext3", str2);
        if (RedTouch.hasRedTouch(appInfo)) {
            hashMap.put("ext2", "1");
            hashMap.put("ext29", String.valueOf(appInfo.type.get()));
            if (appInfo.missions.get() != null && appInfo.missions.get().size() > 0) {
                hashMap.put("ext41", appInfo.missions.get().get(0));
            }
            String str3 = appInfo.extend.get();
            if (!TextUtils.isEmpty(str3)) {
                try {
                    hashMap.put("ext8", new JSONObject(str3).optString("tianshu_footageid"));
                } catch (Exception unused) {
                    QLog.d(TAG, 1, "[buildReportExtMap] parse failed, json=" + str3);
                }
            }
        } else {
            hashMap.put("ext2", "2");
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMallLebaApi
    public void reportLebaItemClick(@Nullable final BusinessInfoCheckUpdate.AppInfo appInfo, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameMallLebaApiImpl.2
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.gamecenter.utils.f.Z("", "1", "978", "9067", "906703", "914299", "", GameMallLebaApiImpl.this.buildReportExtMap(appInfo, z16, true));
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMallLebaApi
    public void reportLebaItemExpose(@Nullable final BusinessInfoCheckUpdate.AppInfo appInfo, final boolean z16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.GameMallLebaApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.gamecenter.utils.f.Z("", "1", "978", "9067", "906703", "914298", "", GameMallLebaApiImpl.this.buildReportExtMap(appInfo, z16, false));
            }
        }, 16, null, true);
    }
}
