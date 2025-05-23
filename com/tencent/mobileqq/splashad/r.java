package com.tencent.mobileqq.splashad;

import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.splashad.processor.TianShuSplashProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/splashad/r;", "", "", "type", "", "d", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Lcom/tencent/mobileqq/splashad/processor/d;", "a", "e", "", "isColdStartup", "", "c", "", "timestamp", "", "f", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class r {
    static IPatchRedirector $redirector_;

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.mobileqq.splashad.processor.d a(int type, MMKVOptionEntity entity) {
        long decodeLong = entity.decodeLong(d(type), 0L);
        if (decodeLong > 0 && decodeLong <= System.currentTimeMillis()) {
            return e(type);
        }
        return null;
    }

    private final String d(int type) {
        return SplashADUtil.i(MobileQQ.sMobileQQ) + "_splash_type_" + type;
    }

    private final com.tencent.mobileqq.splashad.processor.d e(int type) {
        if (type != 1) {
            if (type != 2) {
                if (type != 4) {
                    QLog.d("SplashController", 1, "Not support splash type:" + type);
                    return null;
                }
                return new com.tencent.mobileqq.splashad.processor.h();
            }
            return new com.tencent.mobileqq.splashad.processor.c();
        }
        return new TianShuSplashProcessor();
    }

    public final void b(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, type);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU)");
        from.encodeLong(d(type), 0L);
    }

    @NotNull
    public final List<com.tencent.mobileqq.splashad.processor.d> c(boolean isColdStartup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, isColdStartup);
        }
        ArrayList arrayList = new ArrayList();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU)");
        com.tencent.mobileqq.splashad.processor.d a16 = a(1, from);
        if (a16 != null) {
            arrayList.add(a16);
        }
        if (isColdStartup) {
            arrayList.add(new com.tencent.mobileqq.splashad.processor.c());
            com.tencent.mobileqq.splashad.processor.d a17 = a(4, from);
            if (a17 != null) {
                arrayList.add(a17);
            }
        } else {
            arrayList.add(new com.tencent.mobileqq.splashad.processor.b());
        }
        return arrayList;
    }

    public final void f(int type, long timestamp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(type), Long.valueOf(timestamp));
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_TIAN_SHU)");
        from.encodeLong(d(type), timestamp);
        QLog.d("SplashController", 1, "saveSplashTypeAndTimestamp type:" + type + ", timestamp:" + timestamp);
    }
}
