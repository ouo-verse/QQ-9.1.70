package com.tencent.mobileqq.tvideo.base;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TVideoLayerTabFragmentFactory {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public @interface TVideoLayerTabFragmentType {
        public static final int FEEDS = 0;
        public static final int HIPPY = 2;
        public static final int INVALID = -1;
        public static final int WEB = 1;
    }

    public static Fragment a() {
        return b(0, 1, null);
    }

    public static Fragment b(@TVideoLayerTabFragmentType int i3, int i16, Map<String, String> map) {
        Fragment ph5;
        if (i3 != 1) {
            if (i3 != 2) {
                ph5 = new TVideoLayerFeedsPageFragment();
            } else {
                ph5 = TVideoHippyFragment.Eh(c(map), (HashMap) map);
            }
        } else {
            ph5 = TVideoTabChannelWebFragment.ph(d(map));
        }
        Bundle arguments = ph5.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            ph5.setArguments(arguments);
        }
        arguments.putInt("channelId", i16);
        return ph5;
    }

    private static String c(Map<String, String> map) {
        if (map == null) {
            return "TenVideoPublicChannel";
        }
        String str = map.get("moduleName");
        if (TextUtils.isEmpty(str)) {
            return "TenVideoPublicChannel";
        }
        return str;
    }

    private static String d(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        String str = map.get("url");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter(NodeProps.MARGIN_TOP, map.get(NodeProps.MARGIN_TOP)).appendQueryParameter("channelId", map.get("channelId")).appendQueryParameter("cid", map.get("cid")).appendQueryParameter("vid", map.get("vid")).appendQueryParameter("material_vid", map.get("material_vid"));
        return buildUpon.toString();
    }
}
