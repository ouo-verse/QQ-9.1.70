package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

/* loaded from: classes9.dex */
public class WXChannelJumpMiniProgramInfo extends WXChannelBaseJumpInfo {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXChannelJumpMiniProgramInfo";
    public String path;
    public String username;

    @Override // com.tencent.mm.opensdk.modelbiz.WXChannelBaseJumpInfo, com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public boolean checkArgs() {
        String str;
        String str2 = this.username;
        if (str2 != null && str2.length() > 0) {
            String str3 = this.path;
            if (str3 != null && str3.length() >= 10240) {
                str = "checkArgs fail, path is invalid";
            } else {
                return super.checkArgs();
            }
        } else {
            str = "checkArgs fail, username is null";
        }
        Log.e(TAG, str);
        return false;
    }

    @Override // com.tencent.mm.opensdk.modelbiz.WXChannelBaseJumpInfo, com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public void serialize(Bundle bundle) {
        super.serialize(bundle);
        bundle.putString("wx_channel_jump_mini_program_username", this.username);
        bundle.putString("wx_channel_jump_mini_program_path", this.path);
    }

    @Override // com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public int type() {
        return 1;
    }

    @Override // com.tencent.mm.opensdk.modelbiz.WXChannelBaseJumpInfo, com.tencent.mm.opensdk.modelbiz.IWXChannelJumpInfo
    public void unserialize(Bundle bundle) {
        super.unserialize(bundle);
        this.username = bundle.getString("wx_channel_jump_mini_program_username");
        this.path = bundle.getString("wx_channel_jump_mini_program_path");
    }
}
