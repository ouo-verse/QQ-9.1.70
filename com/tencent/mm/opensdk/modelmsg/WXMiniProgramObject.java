package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.util.HashMap;

/* loaded from: classes9.dex */
public class WXMiniProgramObject implements WXMediaMessage.IMediaObject {
    public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
    public static final int MINIPROGRAM_TYPE_TEST = 1;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    private static final String TAG = "MicroMsg.SDK.WXMiniProgramObject";
    public String path;
    public String userName;
    public String webpageUrl;
    public boolean withShareTicket;
    public int miniprogramType = 0;
    public int disableforward = 0;
    public boolean isUpdatableMessage = false;
    public boolean isSecretMessage = false;
    private HashMap<String, String> extraInfoMap = null;

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        String str;
        if (b.b(this.webpageUrl)) {
            str = "webPageUrl is null";
        } else if (b.b(this.userName)) {
            str = "userName is null";
        } else {
            int i3 = this.miniprogramType;
            if (i3 >= 0 && i3 <= 2) {
                return true;
            }
            str = "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW";
        }
        Log.e(TAG, str);
        return false;
    }

    public String getExtra(String str, String str2) {
        HashMap<String, String> hashMap = this.extraInfoMap;
        if (hashMap != null) {
            String str3 = hashMap.get(str);
            if (str3 != null) {
                return str3;
            }
            return str2;
        }
        return null;
    }

    public void putExtra(String str, String str2) {
        if (this.extraInfoMap == null) {
            this.extraInfoMap = new HashMap<>();
        }
        if (!b.b(str)) {
            this.extraInfoMap.put(str, str2);
        }
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxminiprogram_webpageurl", this.webpageUrl);
        bundle.putString("_wxminiprogram_username", this.userName);
        bundle.putString("_wxminiprogram_path", this.path);
        bundle.putBoolean("_wxminiprogram_withsharetiket", this.withShareTicket);
        bundle.putInt("_wxminiprogram_type", this.miniprogramType);
        bundle.putInt("_wxminiprogram_disableforward", this.disableforward);
        bundle.putBoolean("_wxminiprogram_isupdatablemsg", this.isUpdatableMessage);
        bundle.putBoolean("_wxminiprogram_issecretmsg", this.isSecretMessage);
        HashMap<String, String> hashMap = this.extraInfoMap;
        if (hashMap != null) {
            bundle.putSerializable("_wxminiprogram_extrainfo", hashMap);
        }
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public int type() {
        return 36;
    }

    @Override // com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
        this.userName = bundle.getString("_wxminiprogram_username");
        this.path = bundle.getString("_wxminiprogram_path");
        this.withShareTicket = bundle.getBoolean("_wxminiprogram_withsharetiket");
        this.miniprogramType = bundle.getInt("_wxminiprogram_type");
        this.disableforward = bundle.getInt("_wxminiprogram_disableforward");
        this.isUpdatableMessage = bundle.getBoolean("_wxminiprogram_isupdatablemsg");
        this.isSecretMessage = bundle.getBoolean("_wxminiprogram_issecretmsg");
        this.extraInfoMap = (HashMap) bundle.getSerializable("_wxminiprogram_extrainfo");
    }
}
