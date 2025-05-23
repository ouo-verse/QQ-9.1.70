package com.tencent.mobileqq.troop.filemanager;

import android.os.SystemClock;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static long f295751a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76360);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f295751a = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void a(b bVar) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ boolean b(b bVar) {
        throw null;
    }

    public static void c(long j3, TroopFileTransferManager.Item item, int i3) {
        TroopFileError.j(e.b(), j3, item.FileName, item.Status, i3);
    }

    public static void d(long j3, TroopFileTransferManager.Item item) {
        QQAppInterface b16 = e.b();
        if (b16 == null) {
            return;
        }
        if (item.troopuin == 0) {
            String valueOf = String.valueOf(j3);
            e.b.e("TroopFileDataCenter", e.b.f295938b, "saveStatus. item.troopuin=0, change to:" + LogUtil.wrapLogUin(valueOf));
            item.troopuin = j3;
        }
        if (item.troopuin == 0) {
            e.b.b("TroopFileDataCenter", e.b.f295938b, "saveStatus. item.troopuin=0 err");
        } else {
            b16.getProxyManager().n().h(item);
        }
    }

    public static void e(long j3, TroopFileTransferManager.Item item, int i3) {
        f(j3, item, i3, 0);
    }

    public static void f(long j3, TroopFileTransferManager.Item item, int i3, int i16) {
        boolean z16;
        if (item.Status != i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        item.IsNewStatus = z16;
        if (z16) {
            c.d(j3, item, i3, i16);
        }
        item.Status = i3;
        item.ErrorCode = i16;
        item.Pausing = 0;
        if (item.W2MPause == 1) {
            item.W2MPause = 0;
        }
        d(j3, item);
        item.StatusUpdateTimeMs = 0L;
        h(j3, item);
        item.IsNewStatus = false;
        c(j3, item, i16);
    }

    public static void g(long j3, TroopFileTransferManager.Item item, int i3, TroopFileError.b bVar) {
        boolean z16;
        if (item.Status != i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        item.IsNewStatus = z16;
        item.Status = i3;
        item.ErrorCode = bVar.f301877b;
        item.Pausing = 0;
        if (item.W2MPause == 1) {
            item.W2MPause = 0;
        }
        d(j3, item);
        item.StatusUpdateTimeMs = 0L;
        h(j3, item);
        item.IsNewStatus = false;
        TroopFileError.g(e.b(), bVar);
    }

    public static void h(long j3, TroopFileTransferManager.Item item) {
        long uptimeMillis = SystemClock.uptimeMillis() - f295751a;
        long uptimeMillis2 = SystemClock.uptimeMillis();
        long j16 = item.StatusUpdateTimeMs;
        long j17 = uptimeMillis2 - j16;
        long j18 = f295751a;
        if (j18 == 0 || j16 == 0 || j17 > 5000 || j17 < 0 || uptimeMillis > 1000 || uptimeMillis < 0) {
            f295751a = j18 + uptimeMillis;
            item.StatusUpdateTimeMs = j16 + j17;
            QQAppInterface b16 = e.b();
            if (b16 != null) {
                ((TroopFileHandler) b16.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).F2(item.getInfo(j3));
            }
        }
    }
}
