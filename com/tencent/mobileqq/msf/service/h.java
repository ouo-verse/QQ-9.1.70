package com.tencent.mobileqq.msf.service;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.msf.sdk.MsfMessagePair;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.rfix.loader.utils.RFixConstants;
import common.config.service.QzoneConfig;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: c, reason: collision with root package name */
    private static final String f250917c = "MSF.S.IPCTransportManager";

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f250918d;

    /* renamed from: a, reason: collision with root package name */
    private int f250919a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f250920b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final h f250921a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16778);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f250921a = new h(null);
            }
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_AUDIO_DECODE_MODE);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f250918d = new int[]{716800, 655360, QzoneConfig.DEFAULT_PHOTOVIEW_LIST_SIZE_TO_FINISH, 204800, RFixConstants.MD5_FILE_BUF_LENGTH};
        }
    }

    /* synthetic */ h(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
    }

    @Nullable
    private d b() {
        Iterator<String> it = e.f250885c.keySet().iterator();
        while (it.hasNext()) {
            d dVar = e.f250885c.get(it.next());
            if (dVar != null && dVar.d() != null) {
                return dVar;
            }
        }
        return null;
    }

    public static h d() {
        return b.f250921a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.f250920b) {
            return;
        }
        d b16 = b();
        if (b16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d(f250917c, 2, "adjustTransPackageLenIfNeed, but appProcessInfo = null");
                return;
            }
            return;
        }
        FromServiceMsg fromServiceMsg = new FromServiceMsg();
        fromServiceMsg.setServiceCmd("test_ipc_package_length");
        fromServiceMsg.setBusinessFail(-2);
        fromServiceMsg.setRequestSsoSeq(-1);
        MsfMessagePair msfMessagePair = new MsfMessagePair(null, fromServiceMsg);
        int i3 = 0;
        while (true) {
            int[] iArr = f250918d;
            if (i3 >= iArr.length) {
                break;
            }
            int i16 = iArr[i3];
            try {
                fromServiceMsg.putWupBuffer(new byte[i16]);
                e.f250886d.a(msfMessagePair, b16.d());
                this.f250919a = i16;
                QLog.d(f250917c, 1, "adjustTransPackageLenIfNeed suc, len = " + this.f250919a);
                break;
            } catch (Throwable th5) {
                if (i3 == f250918d.length - 1) {
                    this.f250919a = i16;
                    QLog.d(f250917c, 1, "adjustTransPackageLenIfNeed fail, last len = " + this.f250919a);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f250917c, 2, "adjustTransPackageLenIfNeed throw e: ", th5);
                }
                i3++;
            }
        }
        this.f250920b = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        a();
        return this.f250919a;
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f250919a = f250918d[0];
            this.f250920b = false;
        }
    }
}
