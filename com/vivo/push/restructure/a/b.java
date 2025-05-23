package com.vivo.push.restructure.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.u;
import com.vivo.push.util.v;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private Intent f387794a;

    /* renamed from: c, reason: collision with root package name */
    private com.vivo.push.restructure.request.a.a f387796c;

    /* renamed from: e, reason: collision with root package name */
    private InsideNotificationItem f387798e;

    /* renamed from: f, reason: collision with root package name */
    private UnvarnishedMessage f387799f;

    /* renamed from: b, reason: collision with root package name */
    private String f387795b = "";

    /* renamed from: d, reason: collision with root package name */
    private String f387797d = "";

    public b(Intent intent) {
        this.f387794a = intent;
    }

    private boolean m() {
        if (j() == 4) {
            return true;
        }
        return false;
    }

    private boolean n() {
        if (j() == 3) {
            return true;
        }
        return false;
    }

    private InsideNotificationItem o() {
        Exception e16;
        InsideNotificationItem insideNotificationItem;
        String stringExtra;
        InsideNotificationItem insideNotificationItem2 = this.f387798e;
        if (insideNotificationItem2 != null) {
            return insideNotificationItem2;
        }
        Intent intent = this.f387794a;
        InsideNotificationItem insideNotificationItem3 = null;
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra("notification_v1");
            } catch (Exception e17) {
                e16 = e17;
                insideNotificationItem = null;
            }
            if (stringExtra != null) {
                insideNotificationItem = v.a(stringExtra);
                if (insideNotificationItem != null) {
                    try {
                        insideNotificationItem.setMsgId(Long.parseLong(a()));
                    } catch (Exception e18) {
                        e16 = e18;
                        u.a("ReceivedMessageImpl", "getNotificationMessage " + e16.getMessage());
                        insideNotificationItem3 = insideNotificationItem;
                        this.f387798e = insideNotificationItem3;
                        return insideNotificationItem3;
                    }
                }
                insideNotificationItem3 = insideNotificationItem;
            }
        }
        this.f387798e = insideNotificationItem3;
        return insideNotificationItem3;
    }

    private UnvarnishedMessage p() {
        UnvarnishedMessage unvarnishedMessage = this.f387799f;
        if (unvarnishedMessage != null) {
            return unvarnishedMessage;
        }
        Intent intent = this.f387794a;
        UnvarnishedMessage unvarnishedMessage2 = null;
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("msg_v1");
                if (!TextUtils.isEmpty(stringExtra)) {
                    UnvarnishedMessage unvarnishedMessage3 = new UnvarnishedMessage(stringExtra);
                    try {
                        unvarnishedMessage3.setMsgId(Long.parseLong(a()));
                        unvarnishedMessage2 = unvarnishedMessage3;
                    } catch (Exception e16) {
                        e = e16;
                        unvarnishedMessage2 = unvarnishedMessage3;
                        u.a("ReceivedMessageImpl", "getTransmissionMessage " + e.getMessage());
                        this.f387799f = unvarnishedMessage2;
                        return unvarnishedMessage2;
                    }
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        this.f387799f = unvarnishedMessage2;
        return unvarnishedMessage2;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String a() {
        long j3;
        Bundle extras;
        Intent intent = this.f387794a;
        if (intent != null && (extras = intent.getExtras()) != null) {
            j3 = extras.getLong("notify_id", 0L);
        } else {
            j3 = 0;
        }
        if (j3 != 0) {
            return String.valueOf(j3);
        }
        return "";
    }

    @Override // com.vivo.push.restructure.a.a
    public final Intent b() {
        return this.f387794a;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String c() {
        if (TextUtils.isEmpty(this.f387795b)) {
            this.f387795b = this.f387794a.getStringExtra(CheckForwardServlet.KEY_REQ_ID);
        }
        return this.f387795b;
    }

    @Override // com.vivo.push.restructure.a.a
    public final long d() {
        Intent intent = this.f387794a;
        if (intent == null) {
            return 0L;
        }
        return intent.getLongExtra("ipc_start_time", 0L);
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean e() {
        Intent intent = this.f387794a;
        if (intent == null) {
            return false;
        }
        return intent.getBooleanExtra("core_support_monitor", false);
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean f() {
        Bundle extras;
        Intent intent = this.f387794a;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return false;
        }
        return extras.getBoolean("client_collect_node", false);
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean g() {
        com.vivo.push.restructure.request.a.a h16 = h();
        if (h16 != null && h16.a() == 2018) {
            return true;
        }
        return false;
    }

    @Override // com.vivo.push.restructure.a.a
    public final com.vivo.push.restructure.request.a.a h() {
        String stringExtra;
        com.vivo.push.restructure.request.a.a.a aVar;
        if (this.f387796c == null && (stringExtra = this.f387794a.getStringExtra("cf_content")) != null) {
            try {
                aVar = new com.vivo.push.restructure.request.a.a.a(stringExtra);
            } catch (JSONException unused) {
                aVar = null;
            }
            if (aVar != null) {
                this.f387796c = com.vivo.push.restructure.request.a.a.f387812a.a(aVar);
            }
        }
        return this.f387796c;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String i() {
        if (TextUtils.isEmpty(this.f387797d)) {
            this.f387797d = this.f387794a.getStringExtra("content");
        }
        return this.f387797d;
    }

    @Override // com.vivo.push.restructure.a.a
    public final int j() {
        Intent intent = this.f387794a;
        if (intent == null) {
            return -1;
        }
        int intExtra = intent.getIntExtra("command", -1);
        if (intExtra < 0) {
            return this.f387794a.getIntExtra("method", -1);
        }
        return intExtra;
    }

    @Override // com.vivo.push.restructure.a.a
    public final int k() {
        if (this.f387794a == null) {
            return 0;
        }
        if (m() && o() != null) {
            return o().getTargetType();
        }
        if (!n() || p() == null) {
            return 0;
        }
        return p().getTargetType();
    }

    @Override // com.vivo.push.restructure.a.a
    public final String l() {
        if (this.f387794a == null) {
            return "";
        }
        if (m() && o() != null) {
            return o().getTragetContent();
        }
        if (!n() || p() == null) {
            return "";
        }
        return p().getTragetContent();
    }
}
