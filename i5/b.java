package i5;

import com.qzone.common.account.LoginData;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheWeatherData;
import com.qzone.proxy.personalitycomponent.model.WidgetWeatherData;
import cooperation.qzone.model.LocalImageShootInfo;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import n7.a;
import u5.d;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static b f407231b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f407232c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final a f407233a = new a("QZoneWeatherCacheV2", WidgetCacheWeatherData.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        long f407234a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f407235b;

        /* renamed from: c, reason: collision with root package name */
        String f407236c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f407237d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f407238e = new C10504a();

        /* compiled from: P */
        /* renamed from: i5.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        class C10504a implements a.InterfaceC10828a {
            C10504a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                a aVar2 = a.this;
                aVar2.f407234a = 0L;
                aVar2.f407235b = null;
            }
        }

        public a(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f407236c = str;
            this.f407237d = cls;
        }
    }

    b() {
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "\u52a0\u8f7dWeather\u7f13\u5b58\uff0c\u73b0\u6709\u603b\u7f13\u5b58\u6570:" + f());
    }

    public static b e() {
        if (f407231b == null) {
            synchronized (f407232c) {
                if (f407231b == null) {
                    f407231b = new b();
                }
            }
        }
        return f407231b;
    }

    private int f() {
        DbCacheManager g16 = g();
        if (g16 != null) {
            return g16.e0();
        }
        return 0;
    }

    private DbCacheManager g() {
        c(this.f407233a);
        return this.f407233a.f407235b;
    }

    private boolean i(WidgetCacheWeatherData widgetCacheWeatherData) {
        ArrayList<? extends IDBCacheDataWrapper> g06;
        DbCacheManager g16 = g();
        if (g16 != null && (g06 = g16.g0()) != null) {
            int size = g06.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (j(widgetCacheWeatherData, (WidgetCacheWeatherData) g06.get(i3))) {
                    return true;
                }
            }
        }
        return false;
    }

    public void d() {
        DbCacheManager g16 = g();
        if (g16 != null && g16.e0() > 500) {
            g16.V(300, null);
        }
    }

    public WidgetCacheWeatherData h() {
        DbCacheManager g16 = g();
        if (g16 == null) {
            return null;
        }
        return (WidgetCacheWeatherData) g16.k0(WidgetCacheWeatherData.WIDGET_FLAG + "=?", new String[]{"0"});
    }

    private void a(WidgetCacheWeatherData widgetCacheWeatherData) {
        DbCacheManager g16;
        if (widgetCacheWeatherData == null || i(widgetCacheWeatherData) || (g16 = g()) == null) {
            return;
        }
        g16.o0(widgetCacheWeatherData, 1);
    }

    private void c(a aVar) {
        DbCacheManager dbCacheManager;
        if (aVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != aVar.f407234a || (dbCacheManager = aVar.f407235b) == null || dbCacheManager.isClosed()) {
            aVar.f407234a = uin;
            DbCacheManager e16 = c.g().e(aVar.f407237d, uin, aVar.f407236c);
            aVar.f407235b = e16;
            e16.U(aVar.f407238e);
        }
    }

    public void b(WidgetCacheWeatherData widgetCacheWeatherData) {
        DbCacheManager g16;
        if (widgetCacheWeatherData == null || (g16 = g()) == null) {
            return;
        }
        String str = WidgetCacheWeatherData.WIDGET_FLAG + "=?";
        if (g16.k0(str, new String[]{"0"}) == null) {
            g16.o0(widgetCacheWeatherData, 1);
        } else {
            g16.v0(widgetCacheWeatherData, str, null);
        }
    }

    public void k(WidgetWeatherData widgetWeatherData, LocalImageShootInfo localImageShootInfo) {
        if (widgetWeatherData == null || localImageShootInfo == null) {
            return;
        }
        a(WidgetCacheWeatherData.createFromBusinessData(widgetWeatherData, localImageShootInfo.gpsInfo, localImageShootInfo.captureTime));
    }

    private boolean j(WidgetCacheWeatherData widgetCacheWeatherData, WidgetCacheWeatherData widgetCacheWeatherData2) {
        if (widgetCacheWeatherData == null || widgetCacheWeatherData2 == null) {
            return false;
        }
        return widgetCacheWeatherData.gpstype == widgetCacheWeatherData2.gpstype && k5.a.b((double) (widgetCacheWeatherData.latitude * 1000000.0f), (double) (widgetCacheWeatherData.longtitude * 1000000.0f), (double) (widgetCacheWeatherData2.latitude * 1000000.0f), (double) (widgetCacheWeatherData2.longtitude * 1000000.0f)) <= ((double) d.a()) && widgetCacheWeatherData.shootTime == widgetCacheWeatherData2.shootTime;
    }
}
