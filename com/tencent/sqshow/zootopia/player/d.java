package com.tencent.sqshow.zootopia.player;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J2\u0010\u0010\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/d;", "", "Lcom/tencent/sqshow/zootopia/player/f;", "options", "Lcom/tencent/sqshow/zootopia/player/q;", "player", "", "a", "", "c", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "b", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f372208a = new d();

    d() {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027 A[Catch: Exception -> 0x0011, TryCatch #0 {Exception -> 0x0011, blocks: (B:24:0x0006, B:26:0x000c, B:5:0x0016, B:8:0x001d, B:9:0x0021, B:11:0x0027, B:14:0x002f, B:21:0x0033), top: B:23:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(f options, int module, int errorType, int errorCode, String extraInfo) {
        List<ka4.a> d16;
        if (options != null) {
            try {
                e playerListenerSet = options.getPlayerListenerSet();
                if (playerListenerSet != null) {
                    d16 = playerListenerSet.d();
                    if (d16 != null && d16.size() > 0) {
                        for (ka4.a aVar : d16) {
                            if (aVar != null) {
                                aVar.onVideoPlayError(module, errorType, errorCode, extraInfo);
                            }
                        }
                        return;
                    }
                    QLog.d("PlayerListenerDispatchUtils", 2, "dispatch onVideoPlayError() listeners is empty");
                }
            } catch (Exception e16) {
                QLog.d("PlayerListenerDispatchUtils", 2, "dispatch onVideoPlayError() error " + e16);
                return;
            }
        }
        d16 = null;
        if (d16 != null) {
            while (r4.hasNext()) {
            }
            return;
        }
        QLog.d("PlayerListenerDispatchUtils", 2, "dispatch onVideoPlayError() listeners is empty");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028 A[Catch: Exception -> 0x0012, TryCatch #0 {Exception -> 0x0012, blocks: (B:24:0x0007, B:26:0x000d, B:5:0x0017, B:8:0x001e, B:9:0x0022, B:11:0x0028, B:14:0x0030, B:21:0x0035), top: B:23:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(f options, q player) {
        List<ka4.b> e16;
        if (options != null) {
            try {
                e playerListenerSet = options.getPlayerListenerSet();
                if (playerListenerSet != null) {
                    e16 = playerListenerSet.e();
                    if (e16 != null && e16.size() > 0) {
                        for (ka4.b bVar : e16) {
                            if (bVar != null) {
                                bVar.a(player);
                            }
                        }
                        return true;
                    }
                    QLog.d("PlayerListenerDispatchUtils", 1, "dispatch onVideoPrepared() listeners is empty, player:" + player);
                    return false;
                }
            } catch (Exception e17) {
                QLog.d("PlayerListenerDispatchUtils", 1, "dispatch onVideoPrepared() error: " + e17);
                return false;
            }
        }
        e16 = null;
        if (e16 != null) {
            while (r5.hasNext()) {
            }
            return true;
        }
        QLog.d("PlayerListenerDispatchUtils", 1, "dispatch onVideoPrepared() listeners is empty, player:" + player);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0023 A[Catch: Exception -> 0x000d, TryCatch #0 {Exception -> 0x000d, blocks: (B:28:0x0002, B:30:0x0008, B:4:0x0012, B:9:0x0019, B:10:0x001d, B:12:0x0023, B:15:0x002b), top: B:27:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(f options, q player) {
        List<ma4.a> f16;
        if (options != null) {
            try {
                e playerListenerSet = options.getPlayerListenerSet();
                if (playerListenerSet != null) {
                    f16 = playerListenerSet.f();
                    if (f16 == null && !f16.isEmpty()) {
                        for (ma4.a aVar : f16) {
                            if (aVar != null) {
                                aVar.a(player);
                            }
                        }
                    }
                    return;
                }
            } catch (Exception e16) {
                QLog.d("PlayerListenerDispatchUtils", 2, "dispatch onInitSuccess() error " + e16);
                return;
            }
        }
        f16 = null;
        if (f16 == null) {
            return;
        }
        while (r2.hasNext()) {
        }
    }
}
