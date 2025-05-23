package com.tencent.mobileqq.videoplatform.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* loaded from: classes20.dex */
public class PlayerState {
    static IPatchRedirector $redirector_ = null;
    public static final HashMap<Integer, String> PLAYER_SATE_MAP;
    public static final int STATE_BUFFERING = 5;
    public static final int STATE_COMPLETE = 8;
    public static final int STATE_ERROR = 7;
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSE = 6;
    public static final int STATE_PLAYING = 4;
    public static final int STATE_PREPARING = 3;
    public static final int STATE_RELEASED = 9;
    public static final int STATE_SDK_INITED = 2;
    public static final int STATE_SDK_INITING = 1;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14635);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap<Integer, String> hashMap = new HashMap<>();
        PLAYER_SATE_MAP = hashMap;
        hashMap.put(0, "STATE_IDLE");
        hashMap.put(1, "STATE_SDK_INITING");
        hashMap.put(2, "STATE_SDK_INITED");
        hashMap.put(3, "STATE_PREPARING");
        hashMap.put(4, "STATE_PLAYING");
        hashMap.put(5, "STATE_BUFFERING");
        hashMap.put(6, "STATE_PAUSE");
        hashMap.put(7, "STATE_ERROR");
        hashMap.put(8, "STATE_COMPLETE");
        hashMap.put(9, "STATE_RELEASED");
    }

    public PlayerState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getStateStr(int i3) {
        String str = PLAYER_SATE_MAP.get(Integer.valueOf(i3));
        if (str == null) {
            return "";
        }
        return str;
    }
}
