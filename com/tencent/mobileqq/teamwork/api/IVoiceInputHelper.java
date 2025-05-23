package com.tencent.mobileqq.teamwork.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IVoiceInputHelper extends QRouteApi {
    public static final String APP_ID = "wxcd8072f67d2d78d4";
    public static final long DELAY_AUDIO_PERMISSION_UNCERTAIN = 10000;
    public static final int ERROR_AUDIO_PERMISSION_DENIED = 1830001;
    public static final int ERROR_AUDIO_PERMISSION_UNCERTAIN = 1830002;
    public static final String METHOD_RECORD_CHECK_PERMISSION = "recordCheckPermission";
    public static final String METHOD_VOICE_INPUT_SETUP = "voiceInputSetup";
    public static final String METHOD_VOICE_INPUT_START = "voiceInputStart";
    public static final String METHOD_VOICE_INPUT_STOP = "voiceInputStop";
    public static final int MSG_AUDIO_PERMISSION_UNCERTAIN = 1;
    public static final int REQUEST_CODE_AUDIO_PERMISSION = 1818;

    boolean checkPermission(String str);

    void destroy();

    boolean isInitialized();

    void preInit(AppInterface appInterface);

    boolean setup();

    boolean start(String str);

    boolean stop();
}
