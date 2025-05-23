package com.qq.e.comm.plugin.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.k.z;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.vivo.push.PushClientConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f39374a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f39375b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f39376c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, b> f39377d = new ConcurrentHashMap();

    a() {
    }

    private int a(int i3) {
        if (i3 == 0) {
            return 4001051;
        }
        if (i3 == 3) {
            return 4001052;
        }
        if (i3 == 6) {
            return 4001053;
        }
        if (i3 != 8) {
            return i3 != 9 ? 0 : 4001055;
        }
        return 4001054;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b8 A[Catch: Exception -> 0x00c3, TRY_LEAVE, TryCatch #0 {Exception -> 0x00c3, blocks: (B:4:0x0007, B:7:0x0016, B:9:0x0024, B:11:0x0035, B:13:0x0042, B:15:0x004e, B:17:0x005f, B:30:0x00a0, B:32:0x00a4, B:34:0x00b1, B:35:0x00b4, B:37:0x00b8, B:39:0x0077, B:42:0x0082, B:45:0x008d), top: B:2:0x0005 }] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        b bVar;
        char c16;
        try {
            if (intent == null) {
                GDTLogger.e(String.format("%s onReceive null intent", "MarketDownloadReceiver"));
                return;
            }
            String stringExtra = intent.getStringExtra("type");
            if (TextUtils.isEmpty(stringExtra)) {
                GDTLogger.e(String.format("%s onReceive error empty type:%s", "MarketDownloadReceiver", stringExtra));
                return;
            }
            String stringExtra2 = intent.getStringExtra(PushClientConstants.TAG_PKG_NAME);
            if (!TextUtils.isEmpty(stringExtra2)) {
                bVar = this.f39377d.get(stringExtra2);
            } else {
                bVar = null;
            }
            if (bVar == null) {
                GDTLogger.e(String.format("%s onReceive error empty packageName:%s", "MarketDownloadReceiver", stringExtra2));
                return;
            }
            com.qq.e.comm.plugin.stat.b a16 = z.a(bVar);
            int hashCode = stringExtra.hashCode();
            if (hashCode != 1507423) {
                if (hashCode != 1537214) {
                    if (hashCode == 1596796 && stringExtra.equals("4000")) {
                        c16 = 2;
                        if (c16 == 0) {
                            if (c16 != 1) {
                                if (c16 == 2) {
                                    a(a16);
                                    return;
                                }
                                return;
                            } else {
                                int intExtra = intent.getIntExtra(VirtualAppProxy.KEY_DOWNLOAD_STATUS, -9999);
                                if (intExtra == 9) {
                                    a(stringExtra2);
                                }
                                a(intExtra, a16);
                                return;
                            }
                        }
                        a(intent.getBooleanExtra("postbackCheckRlt", false), a16);
                        return;
                    }
                    c16 = '\uffff';
                    if (c16 == 0) {
                    }
                } else {
                    if (stringExtra.equals(TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID)) {
                        c16 = 1;
                        if (c16 == 0) {
                        }
                    }
                    c16 = '\uffff';
                    if (c16 == 0) {
                    }
                }
            } else {
                if (stringExtra.equals("1000")) {
                    c16 = 0;
                    if (c16 == 0) {
                    }
                }
                c16 = '\uffff';
                if (c16 == 0) {
                }
            }
        } catch (Exception e16) {
            GDTLogger.e(e16.getMessage());
        }
    }

    private void a(boolean z16, com.qq.e.comm.plugin.stat.b bVar) {
        StatTracer.trackEvent(z16 ? 4001049 : 4001050, 0, bVar);
    }

    private void a(int i3, com.qq.e.comm.plugin.stat.b bVar) {
        int a16 = a(i3);
        if (a16 != 0) {
            StatTracer.trackEvent(a16, 0, bVar);
        }
    }

    private void a(com.qq.e.comm.plugin.stat.b bVar) {
        StatTracer.trackEvent(4001056, 0, bVar);
    }

    public static void a(b bVar) {
        if (bVar != null) {
            try {
                if (TextUtils.isEmpty(bVar.a())) {
                    return;
                }
                synchronized (f39374a) {
                    if (f39375b == null) {
                        f39375b = new a();
                        GDTLogger.d(String.format("%s init instance", "MarketDownloadReceiver"));
                    }
                    String a16 = bVar.a();
                    if (f39375b.f39377d != null && !f39375b.f39377d.containsKey(a16)) {
                        f39375b.f39377d.put(a16, bVar);
                        GDTLogger.d(String.format("%s try receive package:%s postback data", "MarketDownloadReceiver", a16));
                    }
                    if (!f39376c) {
                        GDTADManager.getInstance().getAppContext().registerReceiver(f39375b, new IntentFilter("com.oplus.market.download.action"));
                        GDTLogger.d(String.format("%s register broadcast receiver", "MarketDownloadReceiver"));
                        f39376c = true;
                    }
                }
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
    }

    public static void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            synchronized (f39374a) {
                if (f39375b == null) {
                    GDTLogger.d(String.format("%s tryUnReceive package:%s data with null install", "MarketDownloadReceiver", str));
                    return;
                }
                if (f39375b.f39377d != null && f39375b.f39377d.containsKey(str)) {
                    f39375b.f39377d.remove(str);
                    GDTLogger.d(String.format("%s try unReceive package:%s postback data", "MarketDownloadReceiver", str));
                }
                if (f39375b.f39377d != null && f39375b.f39377d.isEmpty() && f39376c) {
                    GDTADManager.getInstance().getAppContext().unregisterReceiver(f39375b);
                    GDTLogger.d(String.format("%s unregister broadcast receiver", "MarketDownloadReceiver"));
                    f39376c = false;
                }
            }
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
    }
}
