package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.k;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Vector;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtFeedbackJsCallHandler implements GdtJsCallHandler {
    public static final String TAG = "GdtFeedbackJsCallHandler";
    private final List<AdFeedbackDialogFragment.Listener> mListenerList = new Vector();

    @Nullable
    private WeakReference<GdtAdWebPlugin> mWebPlugin;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements AdFeedbackDialogFragment.Listener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f109234a;

        a(String str) {
            this.f109234a = str;
        }

        @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
        public void onResult(AdFeedbackDialogFragment.Result result) {
            AdError adError;
            if (result != null && (adError = result.result) != null) {
                GdtFeedbackJsCallHandler.this.sendResult2Web(this.f109234a, result.action, adError.getErrorCode());
                GdtFeedbackJsCallHandler.this.mListenerList.remove(this);
            } else {
                AdLog.e(GdtFeedbackJsCallHandler.TAG, "[onResult] error, params are null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResult2Web(String str, int i3, int i16) {
        GdtAdWebPlugin gdtAdWebPlugin;
        WeakReference<GdtAdWebPlugin> weakReference = this.mWebPlugin;
        if (weakReference != null && (gdtAdWebPlugin = weakReference.get()) != null) {
            AdLog.i(TAG, "sendResult2Web actionType = " + i3);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action_type", i3);
                jSONObject.put("error_code", i16);
                gdtAdWebPlugin.callJs(str, jSONObject.toString());
            } catch (Throwable th5) {
                AdLog.e(TAG, "sendResult2Web error ", th5);
            }
        }
    }

    @Override // com.tencent.gdtad.jsbridge.GdtJsCallHandler
    public boolean handleJsCallRequest(@Nullable GdtAdWebPlugin gdtAdWebPlugin, String str, String... strArr) {
        Activity activity;
        if (gdtAdWebPlugin != null) {
            activity = gdtAdWebPlugin.getActivity();
        } else {
            activity = null;
        }
        if (gdtAdWebPlugin != null && activity != null && strArr.length != 0) {
            a aVar = new a(str);
            this.mWebPlugin = new WeakReference<>(gdtAdWebPlugin);
            try {
                ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(k.a(strArr[0], new WeakReference(aVar), new WeakReference(activity)));
            } catch (Throwable th5) {
                GdtLog.e(TAG, "handleJsCallRequest", th5);
            }
            this.mListenerList.add(aVar);
            return true;
        }
        AdLog.e(TAG, "handleJsCallRequest error");
        return false;
    }
}
