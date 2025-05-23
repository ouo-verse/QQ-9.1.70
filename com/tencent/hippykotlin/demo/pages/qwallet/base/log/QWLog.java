package com.tencent.hippykotlin.demo.pages.qwallet.base.log;

import com.tencent.kuikly.core.log.KLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class QWLog {
    public static final QWLog INSTANCE = new QWLog();
    public static final Lazy clsLog$delegate;
    public static final Lazy iosDebugLog$delegate;
    public static final Lazy kLog$delegate;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<KLogDelegate>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.base.log.QWLog$kLog$2
            @Override // kotlin.jvm.functions.Function0
            public final KLogDelegate invoke() {
                return new KLogDelegate();
            }
        });
        kLog$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IOSDebugLogDelegate>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.base.log.QWLog$iosDebugLog$2
            @Override // kotlin.jvm.functions.Function0
            public final IOSDebugLogDelegate invoke() {
                return new IOSDebugLogDelegate();
            }
        });
        iosDebugLog$delegate = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ClsLogDelegate>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.base.log.QWLog$clsLog$2
            @Override // kotlin.jvm.functions.Function0
            public final ClsLogDelegate invoke() {
                return new ClsLogDelegate();
            }
        });
        clsLog$delegate = lazy3;
    }

    public static void w$default(String str) {
        QWLog qWLog = INSTANCE;
        KLogDelegate kLog = qWLog.getKLog();
        String tag = qWLog.getTag("HbDetailViewModel");
        kLog.getClass();
        KLog.INSTANCE.e(tag, str);
        IOSDebugLogDelegate iosDebugLog = qWLog.getIosDebugLog();
        String tag2 = qWLog.getTag("HbDetailViewModel");
        iosDebugLog.getClass();
        iosDebugLog.print("[warn]" + tag2 + str);
    }

    public final void e(String str) {
        KLogDelegate kLog = getKLog();
        String tag = getTag("QWalletGatewaySSOModule");
        kLog.getClass();
        KLog.INSTANCE.e(tag, str);
        IOSDebugLogDelegate iosDebugLog = getIosDebugLog();
        String tag2 = getTag("QWalletGatewaySSOModule");
        iosDebugLog.getClass();
        iosDebugLog.print("[error]" + tag2 + str);
        getClsLog().getClass();
        QWClsLog.INSTANCE.report$enumunboxing$(4, "QWalletGatewaySSOModule", str);
    }

    public final ClsLogDelegate getClsLog() {
        return (ClsLogDelegate) clsLog$delegate.getValue();
    }

    public final IOSDebugLogDelegate getIosDebugLog() {
        return (IOSDebugLogDelegate) iosDebugLog$delegate.getValue();
    }

    public final KLogDelegate getKLog() {
        return (KLogDelegate) kLog$delegate.getValue();
    }

    public final String getTag(String str) {
        if (str.length() == 0) {
            return "[QWLog]";
        }
        return "[QWLog][" + str + ']';
    }

    public final void i(String str, String str2, boolean z16) {
        KLogDelegate kLog = getKLog();
        String tag = getTag(str);
        if (kLog.isIOS) {
            KLog.INSTANCE.e(tag, str2);
        } else {
            KLog.INSTANCE.i(tag, str2);
        }
        IOSDebugLogDelegate iosDebugLog = getIosDebugLog();
        String tag2 = getTag(str);
        iosDebugLog.getClass();
        iosDebugLog.print("[info]" + tag2 + str2);
        if (z16) {
            getClsLog().getClass();
            QWClsLog qWClsLog = QWClsLog.INSTANCE;
            if (str.length() == 0) {
                str = "Normal";
            }
            qWClsLog.report$enumunboxing$(2, str, str2);
        }
    }
}
