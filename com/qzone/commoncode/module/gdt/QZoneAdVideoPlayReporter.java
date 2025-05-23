package com.qzone.commoncode.module.gdt;

import android.net.Uri;
import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.qzone.reborn.feedx.event.ad.QZoneAdClickEvent;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* loaded from: classes39.dex */
public class QZoneAdVideoPlayReporter {

    /* renamed from: a, reason: collision with root package name */
    private a f46194a;

    /* renamed from: b, reason: collision with root package name */
    private GdtAd f46195b;

    /* renamed from: c, reason: collision with root package name */
    private int f46196c;

    /* renamed from: d, reason: collision with root package name */
    private long f46197d;

    /* renamed from: e, reason: collision with root package name */
    private long f46198e = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* renamed from: f, reason: collision with root package name */
    private long f46199f = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* renamed from: g, reason: collision with root package name */
    private boolean f46200g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f46201h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f46202i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f46203j = false;

    /* loaded from: classes39.dex */
    private static final class a implements SimpleEventReceiver {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QZoneAdVideoPlayReporter> f46204d;

        public a(WeakReference<QZoneAdVideoPlayReporter> weakReference) {
            this.f46204d = weakReference;
        }

        private void a(QZoneAdClickEvent qZoneAdClickEvent) {
            if (qZoneAdClickEvent == null) {
                QLog.i("QZoneAdVideoPlayReporter", 1, "[onReceiveEventClickEvent] error, event is null");
                return;
            }
            WeakReference<QZoneAdVideoPlayReporter> weakReference = this.f46204d;
            QZoneAdVideoPlayReporter qZoneAdVideoPlayReporter = weakReference != null ? weakReference.get() : null;
            if (qZoneAdVideoPlayReporter == null) {
                QLog.i("QZoneAdVideoPlayReporter", 1, "[onReceiveEventClickEvent] error, reporter is null");
                return;
            }
            String traceId = qZoneAdClickEvent.getAd() != null ? qZoneAdClickEvent.getAd().getTraceId() : null;
            if (!TextUtils.isEmpty(traceId) && TextUtils.equals(traceId, qZoneAdVideoPlayReporter.f() != null ? qZoneAdVideoPlayReporter.f().getTraceId() : null)) {
                qZoneAdVideoPlayReporter.j();
            } else {
                QLog.d("QZoneAdVideoPlayReporter", 1, "[onReceiveEventClickEvent] not the same ad");
            }
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public ArrayList<Class> getEventClass() {
            ArrayList<Class> arrayList = new ArrayList<>();
            arrayList.add(QZoneAdClickEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
            if (simpleBaseEvent instanceof QZoneAdClickEvent) {
                a((QZoneAdClickEvent) simpleBaseEvent);
            }
        }
    }

    public QZoneAdVideoPlayReporter(GdtAd gdtAd, int i3, long j3) {
        this.f46195b = gdtAd;
        this.f46196c = i3;
        this.f46197d = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GdtAd f() {
        return this.f46195b;
    }

    private int g() {
        boolean z16 = this.f46200g;
        if (!z16 && !this.f46201h) {
            return 11;
        }
        if (z16 && !this.f46201h) {
            return 12;
        }
        if (z16 || !this.f46201h) {
            return (z16 && this.f46201h) ? 14 : 0;
        }
        return 13;
    }

    private int h() {
        return this.f46202i ? 2 : 3;
    }

    private boolean i() {
        if (this.f46203j) {
            if (this.f46197d > 0) {
                long j3 = this.f46198e;
                if (j3 >= 0) {
                    long j16 = this.f46199f;
                    if (j16 >= 0 && j16 >= j3) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (this.f46197d > 0) {
            long j17 = this.f46198e;
            if (j17 >= 0) {
                long j18 = this.f46199f;
                if (j18 > 0 && j18 > j17) {
                    return true;
                }
            }
        }
        return false;
    }

    private void n() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.commoncode.module.gdt.QZoneAdVideoPlayReporter.1
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneAdVideoPlayReporter.this.f46194a != null) {
                    QLog.e("QZoneAdVideoPlayReporter", 1, "[registerReceiver] error, mEventReceiver is not null");
                    return;
                }
                QLog.i("QZoneAdVideoPlayReporter", 1, "[registerReceiver]");
                QZoneAdVideoPlayReporter.this.f46194a = new a(new WeakReference(QZoneAdVideoPlayReporter.this));
                SimpleEventBus.getInstance().registerReceiver(QZoneAdVideoPlayReporter.this.f46194a);
            }
        });
    }

    private void o() {
        GdtAd gdtAd = this.f46195b;
        String str = null;
        String urlForImpression = gdtAd != null ? gdtAd.getUrlForImpression() : null;
        if (TextUtils.isEmpty(urlForImpression)) {
            QLog.e("QZoneAdVideoPlayReporter", 1, "[report] error, urlForImpression is null");
            return;
        }
        if (!i()) {
            QLog.e("QZoneAdVideoPlayReporter", 1, "[report] error, " + this);
            return;
        }
        JSONObject e16 = e();
        if (e16 != null && !JSONObject.NULL.equals(e16)) {
            String jSONObject = e16.toString();
            QLog.i("QZoneAdVideoPlayReporter", 2, "[report] json:" + jSONObject);
            try {
                str = Uri.parse(urlForImpression).buildUpon().appendQueryParameter("video", jSONObject).build().toString();
            } catch (Throwable th5) {
                QLog.e("QZoneAdVideoPlayReporter", 1, "[report]", th5);
            }
            if (TextUtils.isEmpty(str)) {
                QLog.e("QZoneAdVideoPlayReporter", 1, "[report] error, reportUrl is null");
                return;
            } else {
                QZoneAdReporter.c(str);
                p();
                return;
            }
        }
        QLog.e("QZoneAdVideoPlayReporter", 1, "[report] error, json is null, " + this);
    }

    private void q() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.commoncode.module.gdt.QZoneAdVideoPlayReporter.2
            @Override // java.lang.Runnable
            public void run() {
                if (QZoneAdVideoPlayReporter.this.f46194a == null) {
                    QLog.e("QZoneAdVideoPlayReporter", 1, "[unRegisterReceiver] error, mEventReceiver is null");
                    return;
                }
                QLog.i("QZoneAdVideoPlayReporter", 1, "[unRegisterReceiver]");
                SimpleEventBus.getInstance().unRegisterReceiver(QZoneAdVideoPlayReporter.this.f46194a);
                QZoneAdVideoPlayReporter.this.f46194a = null;
            }
        });
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("durationTimeMillis", this.f46197d);
            jSONObject.put("startTimeMillis", this.f46198e);
            jSONObject.put("endTimeMillis", this.f46199f);
            jSONObject.put("startByLoop", this.f46201h);
            jSONObject.put("stopByClick", this.f46202i);
            jSONObject.put("failed", this.f46203j);
            return jSONObject.toString();
        } catch (Throwable th5) {
            QLog.e("QZoneAdVideoPlayReporter", 1, "[VideoReporter][toString]", th5);
            return null;
        }
    }

    private JSONObject e() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bt", String.valueOf(this.f46198e));
            jSONObject.put(FileReaderHelper.ET_EXT, String.valueOf(this.f46199f));
            jSONObject.put("bf", String.valueOf(this.f46198e == 0 ? 1 : 0));
            jSONObject.put("ef", String.valueOf(this.f46199f == this.f46197d ? 1 : 0));
            jSONObject.put("pp", String.valueOf(this.f46196c));
            jSONObject.put(Constants.KEYS.PLACEMENTS, String.valueOf(this.f46203j ? 2 : 0));
            jSONObject.put("pa", String.valueOf(g()));
            jSONObject.put("ft", String.valueOf(h()));
            return jSONObject;
        } catch (Throwable th5) {
            QLog.e("QZoneAdVideoPlayReporter", 1, "[VideoReporter][createVideoAttachment]", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        QLog.i("QZoneAdVideoPlayReporter", 2, "[onClick]");
        this.f46202i = true;
    }

    private void p() {
        QLog.i("QZoneAdVideoPlayReporter", 2, "[reset]");
        q();
        this.f46198e = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.f46199f = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        this.f46200g = false;
        this.f46201h = false;
        this.f46202i = false;
        this.f46203j = false;
    }

    public void k(long j3) {
        QLog.i("QZoneAdVideoPlayReporter", 2, "[onError]");
        this.f46199f = j3;
        this.f46203j = true;
        o();
    }

    public void l(long j3, boolean z16, boolean z17) {
        QLog.i("QZoneAdVideoPlayReporter", 2, "[onStart]");
        n();
        this.f46198e = j3;
        this.f46200g = z16;
        this.f46201h = z17;
    }

    public void m(long j3) {
        QLog.i("QZoneAdVideoPlayReporter", 2, "[onStop]");
        this.f46199f = j3;
        o();
    }
}
