package com.qzone.widget.eventwidget;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.Observable;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.util.al;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.e;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import n7.a;
import yo.f;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a extends Observable {

    /* renamed from: f, reason: collision with root package name */
    private static final al<a, Void> f60844f = new C0502a();

    /* renamed from: d, reason: collision with root package name */
    private QZoneEventWidgetData f60845d;

    /* renamed from: e, reason: collision with root package name */
    private final b f60846e;

    /* compiled from: P */
    /* renamed from: com.qzone.widget.eventwidget.a$a, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    class C0502a extends al<a, Void> {
        C0502a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Void r16) {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f60847a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f60848b;

        /* renamed from: c, reason: collision with root package name */
        String f60849c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f60850d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f60851e = new C0503a();

        /* compiled from: P */
        /* renamed from: com.qzone.widget.eventwidget.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes37.dex */
        class C0503a implements a.InterfaceC10828a {
            C0503a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("QZoneEventWidgetService", 2, "DbCacheManager onClosed QZoneCommWidgetService table:" + b.this.f60849c);
                }
                b bVar = b.this;
                bVar.f60847a = 0L;
                bVar.f60848b = null;
            }
        }

        public b(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f60849c = str;
            this.f60850d = cls;
        }
    }

    a() {
        super("EventWidget");
        this.f60846e = new b("TABLE_EVENTWIDGET", QZoneEventWidgetData.class);
    }

    public static a G() {
        return f60844f.get(null);
    }

    private void I(long j3) {
        b bVar = this.f60846e;
        if (bVar.f60847a != j3) {
            synchronized (bVar) {
                b bVar2 = this.f60846e;
                if (bVar2.f60847a != j3) {
                    D(bVar2);
                }
            }
        }
    }

    public QZoneEventWidgetData E(long j3) {
        if (this.f60845d != null && j3 == LoginData.getInstance().getUin()) {
            return this.f60845d;
        }
        DbCacheManager F = F(j3);
        if (F == null) {
            return null;
        }
        F.r0("uin=?");
        F.t0(new String[]{"" + j3});
        return (QZoneEventWidgetData) F.k0("uin=?", new String[]{"" + j3});
    }

    public DbCacheManager F(long j3) {
        I(j3);
        return this.f60846e.f60848b;
    }

    public void K(long j3, QZoneEventWidgetData qZoneEventWidgetData) {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECOND_KEY_EVENTWIDGET_WEBSO_PRELOAD, 0) == 1) {
            String H = H(j3, qZoneEventWidgetData);
            if (!TextUtils.isEmpty(H) && e.E(H) && !WebSoService.j().v(H)) {
                WebSoService.j().E(H, null);
            }
        }
        QZoneEventWidgetData E = E(j3);
        if (j3 == LoginData.getInstance().getUin()) {
            this.f60845d = qZoneEventWidgetData;
        }
        if (E != null && E.equals(qZoneEventWidgetData)) {
            J(j3, qZoneEventWidgetData, false);
            return;
        }
        DbCacheManager F = F(j3);
        if (F != null) {
            if (qZoneEventWidgetData == null) {
                F.b0("uin=?", new String[]{j3 + ""});
            } else {
                F.r0("uin=?");
                F.t0(new String[]{"" + j3});
                F.o0(qZoneEventWidgetData, 2);
            }
        }
        J(j3, qZoneEventWidgetData, true);
    }

    public void J(long j3, QZoneEventWidgetData qZoneEventWidgetData, boolean z16) {
        notify(1, Long.valueOf(j3), qZoneEventWidgetData, Boolean.valueOf(z16));
    }

    public static String H(long j3, QZoneEventWidgetData qZoneEventWidgetData) {
        if (qZoneEventWidgetData == null || TextUtils.isEmpty(qZoneEventWidgetData.strJumpUrl)) {
            return null;
        }
        return f.i(qZoneEventWidgetData.strJumpUrl, "{uin}", j3);
    }

    private void D(b bVar) {
        DbCacheManager dbCacheManager;
        if (bVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != bVar.f60847a || (dbCacheManager = bVar.f60848b) == null || dbCacheManager.isClosed()) {
            bVar.f60847a = uin;
            DbCacheManager e16 = c.g().e(bVar.f60850d, uin, bVar.f60849c);
            bVar.f60848b = e16;
            e16.U(bVar.f60851e);
        }
    }
}
