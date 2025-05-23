package com.tencent.ams.dsdk.view.video.glvideo;

import android.content.Context;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKCustomAbilityProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.DKHippyViewEvent;
import com.tencent.ams.dsdk.core.hippy.DKEngineInstanceManager;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.view.video.DKVideoView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.common.HippyMap;
import java.lang.reflect.Constructor;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKGLVideoView extends DKVideoView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKGLVideoView";
    private DKGLVideoPlayer videoPlayer;

    public DKGLVideoView(Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        }
    }

    public void setFormatType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        DKGLVideoPlayer dKGLVideoPlayer = this.videoPlayer;
        if (dKGLVideoPlayer != null) {
            dKGLVideoPlayer.setFormatType(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.dsdk.view.video.DKVideoView
    public DKGLVideoPlayer createPlayer(Context context, int i3) {
        DKGLVideoPlayer dKGLVideoPlayer;
        DKCustomAbilityProvider customAbilityProvider;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (DKGLVideoPlayer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, i3);
        }
        DKEngine engine = DKEngineInstanceManager.getEngine(i3);
        if (engine == null || (customAbilityProvider = engine.getCustomAbilityProvider()) == null) {
            dKGLVideoPlayer = null;
        } else {
            DLog.i(TAG, "use engine provider video player.");
            dKGLVideoPlayer = customAbilityProvider.getDKGLVideoPlayer(context);
        }
        if (dKGLVideoPlayer == null) {
            DLog.i(TAG, "use global video player provider.");
            dKGLVideoPlayer = createPlayer(context);
        }
        this.videoPlayer = dKGLVideoPlayer;
        return dKGLVideoPlayer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.dsdk.view.video.DKVideoView
    public DKGLVideoPlayer createPlayer(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DKGLVideoPlayer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        Class<? extends DKGLVideoPlayer> gLPlayerClass = DKConfiguration.getGLPlayerClass();
        DKGLVideoPlayer dKGLVideoPlayer = null;
        if (gLPlayerClass != null) {
            try {
                Constructor<? extends DKGLVideoPlayer> constructor = gLPlayerClass.getConstructor(Context.class);
                if (constructor != null) {
                    dKGLVideoPlayer = constructor.newInstance(context);
                }
            } catch (Throwable th5) {
                DLog.e(TAG, "create outside video player error.", th5);
            }
        }
        if (dKGLVideoPlayer == null) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("errorCode", 10001);
            hippyMap.pushString("errorInfo", "glplayer init error!");
            new DKHippyViewEvent("onError").send(this, hippyMap);
        }
        return dKGLVideoPlayer;
    }
}
