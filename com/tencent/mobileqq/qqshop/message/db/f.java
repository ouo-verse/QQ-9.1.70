package com.tencent.mobileqq.qqshop.message.db;

import android.os.SystemClock;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqshop/message/db/f;", "", "Lcom/tencent/mobileqq/qqshop/message/db/a;", AppConstants.Key.COLUMN_MSG_DATA, "", "g", "", "msgTime", "", "msgCount", "", "d", "e", "", "c", "Lcom/tencent/mobileqq/qqshop/message/db/b;", "b", "Lcom/tencent/mobileqq/qqshop/message/db/b;", "msgDao", "<init>", "()V", "qqshop-feature-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f274497a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b msgDao;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30074);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f274497a = new f();
            msgDao = QQShopMsgDatabase.INSTANCE.a().c();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f() {
        try {
            msgDao.delete(f274497a.c());
        } catch (Exception e16) {
            QLog.e("QQShopMsgDataSource", 1, "[lruDeleteMsg] error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(a msgData) {
        int i3;
        int coerceAtLeast;
        EcshopConfBean.MsgTabPageConfig msgTabPageConfig;
        Intrinsics.checkNotNullParameter(msgData, "$msgData");
        try {
            if (QLog.isDebugVersion()) {
                QLog.d("QQShopMsgDataSource", 4, "[setMsg] msgData=" + msgData);
            }
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            b bVar = msgDao;
            bVar.c(msgData);
            long currentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis();
            EcshopConfBean ecshopConfBean = EcshopConfUtil.getEcshopConfBean();
            if (ecshopConfBean != null && (msgTabPageConfig = ecshopConfBean.msgTabPageConfig) != null) {
                i3 = msgTabPageConfig.maxDailyMsgCount;
            } else {
                i3 = 30;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i3, 5);
            bVar.d(coerceAtLeast, f274497a.c());
            QLog.d("QQShopMsgDataSource", 1, "setMsg, maxDailyMsgCount=" + i3 + " insertTime=" + (currentThreadTimeMillis2 - currentThreadTimeMillis) + " lruTime=$" + (SystemClock.currentThreadTimeMillis() - currentThreadTimeMillis2));
        } catch (Exception e16) {
            QLog.e("QQShopMsgDataSource", 1, "[setMsg] error", e16);
        }
    }

    @NotNull
    public final String c() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUid();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final List<a> d(long msgTime, int msgCount) {
        List<a> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, this, Long.valueOf(msgTime), Integer.valueOf(msgCount));
        }
        try {
            if (QLog.isDebugVersion()) {
                QLog.d("QQShopMsgDataSource", 4, "[getMsgList] msgTime=" + msgTime + ", msgCount=" + msgCount);
            }
            if (msgTime <= 0) {
                return msgDao.b(msgCount, c());
            }
            return msgDao.a(msgTime, msgCount, c());
        } catch (Exception e16) {
            QLog.e("QQShopMsgDataSource", 1, "[getMsgList] error", e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqshop.message.db.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.f();
                }
            }, 32, null, false);
        }
    }

    public final void g(@NotNull final a msgData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgData);
        } else {
            Intrinsics.checkNotNullParameter(msgData, "msgData");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqshop.message.db.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.h(a.this);
                }
            }, 32, null, true);
        }
    }
}
