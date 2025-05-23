package com.tencent.mobileqq.vas.config.business.qvip;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import hd0.c;
import java.io.UnsupportedEncodingException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class QVipStickerProcessor extends BaseQVipConfigProcessor<QVipStickerConfig> {
    public static final int CMD = 189;
    private static final String KEY_ENABLE_STICKER = "emojiStickerEnable";
    private static final String KEY_MAX_SHOW_NUM = "emojiMaxShowNum";
    private static final String KEY_MAX_STICK_NUM = "emojiMaxStickNum";
    private static final String PREF_DIVIDER = "_";
    public static final String PREF_STICKER_NAME = "sticker_pref";
    public static final String STICKER_ENABLE = "is_sticker_enable";
    public static int STICKER_MAX_COUNT = 5;
    public static final String STICKER_MAX_SEND_NUM = "sticker_max_send_num";
    public static final String STICKER_MAX_SHOW_NUM = "sticker_max_show_num";
    private static final String TAG = "QVipStickerProcessor";
    public static int sEnableSticker = -1;
    public static int sStickerMaxSendNum = 5;
    public static int sStickerMaxShowNum = 5;

    @Override // com.tencent.mobileqq.config.l
    public Class<QVipStickerConfig> clazz() {
        return QVipStickerConfig.class;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 189;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipStickerConfig migrateDefaultContent() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        String currentAccountUin = waitAppRuntime.getCurrentAccountUin();
        SharedPreferences.Editor edit = waitAppRuntime.getApp().getSharedPreferences(PREF_STICKER_NAME, 0).edit();
        edit.putInt("sticker_max_show_num_" + currentAccountUin, STICKER_MAX_COUNT);
        edit.apply();
        edit.putInt("sticker_max_send_num_" + currentAccountUin, STICKER_MAX_COUNT);
        edit.commit();
        return new QVipStickerConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipStickerConfig migrateOldContent() {
        return new QVipStickerConfig();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    public QVipStickerConfig parsed(ai[] aiVarArr) {
        ai[] aiVarArr2 = aiVarArr;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        String currentAccountUin = waitAppRuntime.getCurrentAccountUin();
        int length = aiVarArr2.length;
        int i3 = 0;
        int i16 = -1;
        while (i3 < length) {
            ai aiVar = aiVarArr2[i3];
            int i17 = aiVar.f202267a;
            if (i17 < i16) {
                c.g(TAG, "received old task id " + i17 + ", latest task id: " + i16);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(new String(aiVar.f202268b.getBytes("utf-8")));
                    QLog.d(TAG, 1, "configJson=" + jSONObject);
                    SharedPreferences.Editor edit = waitAppRuntime.getApp().getSharedPreferences(PREF_STICKER_NAME, 0).edit();
                    sEnableSticker = jSONObject.optInt(KEY_ENABLE_STICKER, -1);
                    QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").encodeInt("is_sticker_enable_" + currentAccountUin, sEnableSticker);
                    if (jSONObject.has(KEY_MAX_SHOW_NUM)) {
                        int optInt = jSONObject.optInt(KEY_MAX_SHOW_NUM);
                        sStickerMaxShowNum = optInt;
                        if (optInt <= 0) {
                            sStickerMaxShowNum = STICKER_MAX_COUNT;
                        }
                        edit.putInt("sticker_max_show_num_" + currentAccountUin, sStickerMaxShowNum);
                        edit.apply();
                    }
                    if (jSONObject.has(KEY_MAX_STICK_NUM)) {
                        int optInt2 = jSONObject.optInt(KEY_MAX_STICK_NUM);
                        sStickerMaxSendNum = optInt2;
                        if (optInt2 <= 0) {
                            sStickerMaxSendNum = STICKER_MAX_COUNT;
                        }
                        edit.putInt("sticker_max_send_num_" + currentAccountUin, sStickerMaxSendNum);
                        edit.commit();
                    }
                    i16 = i17;
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                    c.g(TAG, "item.content=" + aiVar.f202268b + " e=" + e16);
                } catch (JSONException e17) {
                    e17.printStackTrace();
                    c.g(TAG, "item.content=" + aiVar.f202268b + " e=" + e17);
                }
            }
            i3++;
            aiVarArr2 = aiVarArr;
        }
        return new QVipStickerConfig();
    }
}
