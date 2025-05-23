package com.tencent.gdtad.kuikly.module;

import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.util.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArrayList<AdFeedbackDialogFragment.Listener> f109307a = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements AdFeedbackDialogFragment.Listener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f109308a;

        a(h hVar) {
            this.f109308a = hVar;
        }

        @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
        public void onResult(AdFeedbackDialogFragment.Result result) {
            AdError adError;
            if (result != null && (adError = result.result) != null) {
                d.this.c(this.f109308a, adError.getErrorCode(), result.action);
                d.this.f109307a.remove(this);
            } else {
                QLog.e("GdtKuiklyModuleFeedbackHandler", 1, "[onResult] error, result is null");
                d.this.c(this.f109308a, 1, 0);
                d.this.f109307a.remove(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(h hVar, int i3, int i16) {
        if (hVar == null) {
            QLog.i("GdtKuiklyModuleFeedbackHandler", 1, "[callback] error, callback is null, errorCode:" + i3 + " actionType:" + i16);
            return;
        }
        QLog.i("GdtKuiklyModuleFeedbackHandler", 1, "[callback] errorCode:" + i3 + " actionType:" + i16);
        JSONObject newJSONObject = AdJSONUtil.newJSONObject();
        AdJSONUtil.put(newJSONObject, "error_code", Integer.valueOf(i3));
        if (i16 != Integer.MIN_VALUE) {
            AdJSONUtil.put(newJSONObject, "action_type", Integer.valueOf(i16));
        }
        hVar.invoke(newJSONObject);
    }

    private AdFeedbackDialogFragment.Listener d(h hVar) {
        return new a(hVar);
    }

    public void e(e eVar) {
        Object obj;
        if (eVar == null) {
            QLog.e("GdtKuiklyModuleFeedbackHandler", 1, "[handle] error, params is null");
            return;
        }
        if (!wm0.b.m().s()) {
            QLog.e("GdtKuiklyModuleFeedbackHandler", 1, "[handle] error, not enabled");
            c(eVar.f109311b, 1, 0);
            return;
        }
        QLog.i("GdtKuiklyModuleFeedbackHandler", 1, "[handle] value:" + eVar.f109313d);
        GdtAd gdtAd = null;
        String optString = AdJSONUtil.optString(AdJSONUtil.optJSONObject(AdJSONUtil.newJSONObject(eVar.f109313d), "context"), "pageName", null);
        AdFeedbackDialogFragment.Listener d16 = d(eVar.f109311b);
        AdFeedbackParams a16 = k.a(eVar.f109313d, new WeakReference(d16), new WeakReference(eVar.f109310a));
        if (a16 != null) {
            obj = a16.f61346ad;
        } else {
            obj = null;
        }
        if (obj instanceof GdtAd) {
            gdtAd = (GdtAd) obj;
        }
        com.tencent.gdtad.kuikly.a.l("GdtKuiklyModuleFeedbackHandler", "[handle]", AdMetricID.Kuikly.Module.FEEDBACK, gdtAd, null, optString, eVar.f109312c);
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(a16);
        } catch (Throwable th5) {
            QLog.e("GdtKuiklyModuleFeedbackHandler", 1, "[handle]", th5);
            c(eVar.f109311b, 1, 0);
        }
        this.f109307a.add(d16);
    }
}
