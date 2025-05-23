package hynb.b;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;

/* compiled from: P */
/* loaded from: classes28.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f406620a = {IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, 102, 97, 69, 70, 97, 102, PublicAccountH5AbilityPluginImpl.OPENCAMERA, 83, 68, 102, 97, Constants.SDK_SEND_CHANNEL_DATA_TYPE, 100, 97, 102};

    /* renamed from: b, reason: collision with root package name */
    public static String f406621b;

    public static String a() {
        String str;
        if (TextUtils.isEmpty(f406621b)) {
            try {
                str = new String(f406620a, "utf-8");
            } catch (Exception e16) {
                hynb.p.g.f406799a.a("HYNSLinkConfig", String.format("getTeaDefaultKey. e: %s", e16.getCause()));
                str = null;
            }
            f406621b = str;
        }
        return f406621b;
    }
}
