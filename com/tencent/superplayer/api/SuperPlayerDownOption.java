package com.tencent.superplayer.api;

import com.tencent.superplayer.utils.LogUtil;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes26.dex */
public class SuperPlayerDownOption {
    public static final int BBR = 2;
    public static final int CUBIC_BYTES = 0;
    public static final int GOOGLE_CC = 4;
    public static final int PCC = 3;
    public static final int QUIC_DEPEND_ON_PROBE = 1;
    public static final int QUIC_FORCE_ENABLE = 2;
    public static final int QUIC_NOT_ENABLE = 0;
    public static final int RENO_BYTES = 1;
    private static final String TAG = "SuperPlayerDownOption";
    public String bandwidthReportHost;
    public int emergencyTimSForPrePlayer;
    public int emergencyTimeS;
    public String pcdnChargeId;
    public int pcdnMinBuffTime;
    public int pcdnProtectBuffTime;
    public int safeTimeS;
    public int safeTimeSForPrePlayer;
    public boolean enableP2P = false;
    public boolean enableBandwidthStats = true;
    public int quicEnableMode = 0;
    public boolean enableQuicPlaintext = false;
    public boolean enablePcdn = false;
    public boolean enableQuicConnectionMigration = false;
    public boolean enableFlvPreloadMode = false;
    public boolean enableXP2P = false;
    public boolean enablePreLoadPlayLimitData = false;
    public boolean enablePreloadLimitSpeed = true;
    public boolean enableDownStrategyOnlyEffectSelf = false;
    public int quicCongestionType = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface CongestionType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes26.dex */
    public @interface QuicEnableMode {
    }

    SuperPlayerDownOption() {
    }

    public static SuperPlayerDownOption obtain() {
        return new SuperPlayerDownOption();
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enableP2P", this.enableP2P);
            jSONObject.put("quicEnableMode", this.quicEnableMode);
            jSONObject.put("enablePcdn", this.enablePcdn);
            jSONObject.put("enableQuicPlaintext", this.enableQuicPlaintext);
            jSONObject.put("quicCongestionType", this.quicCongestionType);
            jSONObject.put("enableQuicConnectionMigration", this.enableQuicConnectionMigration);
            jSONObject.put("enableFlvPreloadMode", this.enableFlvPreloadMode);
        } catch (JSONException e16) {
            LogUtil.e(TAG, "", e16);
        }
        return jSONObject.toString();
    }

    public Map<String, String> toReportMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("enableP2P", String.valueOf(this.enableP2P));
        hashMap.put("quicEnableMode", String.valueOf(this.quicEnableMode));
        hashMap.put("enableQuicPlaintext", String.valueOf(this.enableQuicPlaintext));
        hashMap.put("quicCongestionType", String.valueOf(this.quicCongestionType));
        hashMap.put("enablePcdn", String.valueOf(this.enablePcdn));
        hashMap.put("enableQuicConnectionMigration", String.valueOf(this.enableQuicConnectionMigration));
        hashMap.put("enableFlvPreloadMode", String.valueOf(this.enableFlvPreloadMode));
        return hashMap;
    }

    public String toString() {
        return "SuperPlayerDownOption[\nenableP2P:" + this.enableP2P + "\nquicEnableMode:" + this.quicEnableMode + "\nenablePcdn:" + this.enablePcdn + "\nenableQuicPlaintext:" + this.enableQuicPlaintext + "\nquicCongestionType:" + this.quicCongestionType + "\nenableQuicConnectionMigration:" + this.enableQuicConnectionMigration + "\nenableFlvPreloadMode:" + this.enableFlvPreloadMode + "\nenablePrePlayerLimitSpeed:" + this.enablePreloadLimitSpeed + "\ndownStrategyEffectForCurrentPlayer:" + this.enableDownStrategyOnlyEffectSelf + "\ninitBusinessDownStrategy:" + this.emergencyTimeS + "|" + this.safeTimeS + "|" + this.emergencyTimSForPrePlayer + "|" + this.safeTimeSForPrePlayer + "]";
    }
}
