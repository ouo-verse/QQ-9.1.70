package com.tencent.oskplayer.proxy;

import android.webkit.URLUtil;
import com.tencent.oskplayer.util.MD5;
import com.tencent.oskplayer.util.PlayerUtils;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DefaultVideoKeyGenerator implements VideoKeyGenerator {
    @Override // com.tencent.oskplayer.proxy.VideoKeyGenerator
    public String generate(String str) {
        URL url;
        if (!URLUtil.isNetworkUrl(str)) {
            return str;
        }
        try {
            url = new URL(str);
        } catch (MalformedURLException e16) {
            PlayerUtils.log(6, "DefaultVideoKeyGenerator", PlayerUtils.getPrintableStackTrace(e16));
            url = null;
        }
        if (url == null) {
            return null;
        }
        return MD5.md5(str).substring(0, 20);
    }
}
