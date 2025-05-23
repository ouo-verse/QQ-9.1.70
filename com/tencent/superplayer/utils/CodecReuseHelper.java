package com.tencent.superplayer.utils;

import android.text.TextUtils;
import com.tencent.superplayer.config.ConfigManager;
import com.tencent.tmediacodec.reuse.ReusePolicy;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CodecReuseHelper {
    private static final String TAG = "CodecReuseHelper";
    private static volatile CodecReuseHelper mInstance;
    private boolean hasLoadHardwareList = false;
    private boolean isDeviceSupport = false;

    CodecReuseHelper() {
    }

    public static CodecReuseHelper get() {
        if (mInstance == null) {
            synchronized (CodecReuseHelper.class) {
                if (mInstance == null) {
                    mInstance = new CodecReuseHelper();
                }
            }
        }
        return mInstance;
    }

    public ReusePolicy.EraseType getEraseType() {
        return ReusePolicy.EraseType.values()[Math.max(Math.min(ConfigManager.get().getConfig("codecReuse").getInt("codec_erase_policy", ReusePolicy.EraseType.SAME.ordinal()), ReusePolicy.EraseType.values().length - 1), 0)];
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003a, code lost:
    
        r5.isDeviceSupport = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isDeviceSupport() {
        if (!this.hasLoadHardwareList) {
            try {
                JSONArray jSONArray = new JSONArray(ConfigManager.get().getConfig("codecReuse").getString("white_hardware_list", ""));
                int i3 = 0;
                while (true) {
                    if (i3 >= jSONArray.length()) {
                        break;
                    }
                    String string = jSONArray.getString(i3);
                    if (!TextUtils.isEmpty(string) && TextUtils.equals(string, HardwareUtil.getDeviceName())) {
                        break;
                    }
                    i3++;
                }
            } catch (JSONException e16) {
                LogUtil.e(TAG, "isDeviceSupport error,", e16);
            }
        }
        this.hasLoadHardwareList = true;
        return this.isDeviceSupport;
    }
}
