package com.tencent.ams.dsdk.core.mosaic;

import android.text.TextUtils;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.view.video.VideoLoader;
import com.tencent.ams.mosaic.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKDefaultMosaicVideoLoader implements f.InterfaceC0685f {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_SRC = "src";
    private static final String KEY_VID = "vid";
    private static final String TAG = "DKDefaultMosaicVideoLoader";
    private VideoLoader mVideoLoader;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class DefaultMosaicVideoLoaderListener implements VideoLoader.VideoLoadListener {
        static IPatchRedirector $redirector_;
        private final f.InterfaceC0685f.a listener;

        public DefaultMosaicVideoLoaderListener(f.InterfaceC0685f.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            } else {
                this.listener = aVar;
            }
        }

        @Override // com.tencent.ams.dsdk.view.video.VideoLoader.VideoLoadListener
        public void onLoadFinish(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            f.InterfaceC0685f.a aVar = this.listener;
            if (aVar != null) {
                aVar.onLoadFinish(str);
            }
        }

        @Override // com.tencent.ams.dsdk.view.video.VideoLoader.VideoLoadListener
        public void onLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            f.InterfaceC0685f.a aVar = this.listener;
            if (aVar != null) {
                aVar.onLoadStart();
            }
        }
    }

    public DKDefaultMosaicVideoLoader(VideoLoader videoLoader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) videoLoader);
        } else {
            this.mVideoLoader = videoLoader;
        }
    }

    @Override // com.tencent.ams.mosaic.f.InterfaceC0685f
    public void loadVideo(String str, f.InterfaceC0685f.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        VideoLoader videoLoader = this.mVideoLoader;
        if (videoLoader != null) {
            DefaultMosaicVideoLoaderListener defaultMosaicVideoLoaderListener = new DefaultMosaicVideoLoaderListener(aVar);
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("src");
                if (!TextUtils.isEmpty(optString)) {
                    videoLoader.loadVideoByUrl(optString, defaultMosaicVideoLoaderListener);
                    return;
                }
                String optString2 = jSONObject.optString("vid");
                if (!TextUtils.isEmpty(optString2)) {
                    videoLoader.loadVideoByVid(optString2, defaultMosaicVideoLoaderListener);
                    return;
                }
            } catch (Throwable th5) {
                DLog.e(TAG, "parse video load params error.", th5);
                if (aVar != null) {
                    aVar.onLoadStart();
                }
            }
        } else if (aVar != null) {
            aVar.onLoadStart();
        }
        if (aVar != null) {
            aVar.onLoadFinish(null);
        }
    }
}
