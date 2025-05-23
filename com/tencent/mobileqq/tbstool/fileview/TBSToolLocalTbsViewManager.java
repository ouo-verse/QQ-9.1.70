package com.tencent.mobileqq.tbstool.fileview;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tbstool.TBSToolClientUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.reader.ITbsReader;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.ReaderEngine;
import com.tencent.tbs.reader.TbsReaderView;
import java.io.File;
import java.util.Iterator;
import java.util.Stack;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TBSToolLocalTbsViewManager {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static TBSToolLocalTbsViewManager f291417b;

    /* renamed from: a, reason: collision with root package name */
    private final Stack<Pair<Integer, j>> f291418a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements re4.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // re4.c
        public void log(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            } else if (QLog.isColorLevel()) {
                QLog.d("TBSToolLocalTbsViewManager<FileAssistant>:" + str, 2, str2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends TBSOneCallback<File> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TBSToolLocalTbsViewManager.this);
            }
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCompleted(File file) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) file);
                return;
            }
            QLog.i("TBSToolLocalTbsViewManager<FileAssistant>", 1, "tbs reader engine download complete.");
            TBSToolLocalTbsViewManager.this.o();
            ReportController.o(null, "dc00898", "", "", "0X800B00A", "0X800B00A", 1, 0, "", "", "", "");
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        public void onError(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
                return;
            }
            QLog.i("TBSToolLocalTbsViewManager<FileAssistant>", 1, "tbs reader engine download error. code[" + i3 + "] msg[" + str + "]");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("");
            sb5.append(i3);
            ReportController.o(null, "dc00898", "", "", "0X800B00A", "0X800B00A", 2, 0, sb5.toString(), "", "", "");
        }

        @Override // com.tencent.tbs.one.TBSOneCallback
        public void onProgressChanged(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            QLog.i("TBSToolLocalTbsViewManager<FileAssistant>", 1, "tbs progress: oldProgress[" + i3 + "] newProgress[" + i16 + "]");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31387);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f291417b = null;
        }
    }

    public TBSToolLocalTbsViewManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f291418a = new Stack<>();
        }
    }

    private <T> T j(Activity activity, Function1<j, T> function1) {
        if (function1 == null || activity == null) {
            return null;
        }
        j m3 = m(activity);
        if (m3 == null) {
            QLog.d("TBSToolLocalTbsViewManager<FileAssistant>", 1, "doActionR find record hashcode fail:" + function1.hashCode());
            return null;
        }
        return function1.invoke(m3);
    }

    private void k(Activity activity, com.tencent.mobileqq.tbstool.fileview.b<j> bVar) {
        if (bVar != null && activity != null) {
            j m3 = m(activity);
            if (m3 == null) {
                QLog.d("TBSToolLocalTbsViewManager<FileAssistant>", 1, "doAction find record hashcode fail:" + bVar.hashCode());
                return;
            }
            bVar.execute(m3);
        }
    }

    public static TBSToolLocalTbsViewManager l() {
        if (f291417b == null) {
            f291417b = new TBSToolLocalTbsViewManager();
            ReaderEngine.getInstance().setLoggingHandler(BaseApplication.context, new a());
        }
        return f291417b;
    }

    private j m(Activity activity) {
        int hashCode = activity.hashCode();
        Iterator<Pair<Integer, j>> it = this.f291418a.iterator();
        while (it.hasNext()) {
            Pair<Integer, j> next = it.next();
            if (next.getFirst().intValue() == hashCode) {
                return next.getSecond();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(new ITbsReaderCallback() { // from class: com.tencent.mobileqq.tbstool.fileview.h
            @Override // com.tencent.tbs.reader.ITbsReaderCallback
            public final void onCallBackAction(Integer num, Object obj, Object obj2) {
                TBSToolLocalTbsViewManager.this.r(num, obj, obj2);
            }
        }) { // from class: com.tencent.mobileqq.tbstool.fileview.TBSToolLocalTbsViewManager.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ITbsReaderCallback f291419d;

            {
                this.f291419d = r5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TBSToolLocalTbsViewManager.this, (Object) r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ReaderEngine.getInstance().initReaderEntryAsync(BaseApplication.getContext(), this.f291419d);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(Integer num, Object obj, Object obj2) {
        QLog.i("TBSToolLocalTbsViewManager<FileAssistant>", 1, "initTbsReaderEntry: eventType[" + num + "] code[" + obj.toString() + "]");
        Integer num2 = (Integer) obj;
        Iterator<Pair<Integer, j>> it = this.f291418a.iterator();
        while (it.hasNext()) {
            it.next().getSecond().e(num2.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean s(Activity activity, j jVar) {
        return Boolean.valueOf(jVar.d(activity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(j jVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(MiniGamePAHippyBaseFragment.KEY_THEME, QQTheme.isNowThemeIsNight());
        jVar.c(Integer.valueOf(ITbsReader.READER_EVENT_NIGHT_MODE_CHANGED), bundle, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TbsReaderView u(Activity activity, String str, long j3, LocalTbsViewManager.e eVar, j jVar) {
        return jVar.f(activity, str, j3, eVar);
    }

    public void A(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            i.g(z16);
        }
    }

    public void B(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            i.h(z16);
        }
    }

    public void C(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
        } else {
            QLog.d("TBSToolLocalTbsViewManager<FileAssistant>", 1, "showMenuButton");
            k(activity, new com.tencent.mobileqq.tbstool.fileview.b() { // from class: com.tencent.mobileqq.tbstool.fileview.g
                @Override // com.tencent.mobileqq.tbstool.fileview.b
                public final void execute(Object obj) {
                    ((j) obj).h();
                }
            });
        }
    }

    public void g(Activity activity, String str, LocalTbsViewManager.e eVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, activity, str, eVar, Boolean.valueOf(z16));
            return;
        }
        j m3 = m(activity);
        if (m3 == null) {
            m3 = new j();
            int hashCode = activity.hashCode();
            this.f291418a.push(new Pair<>(Integer.valueOf(hashCode), m3));
            QLog.d("TBSToolLocalTbsViewManager<FileAssistant>", 1, "push record hashcode: " + hashCode);
        }
        m3.a(activity, str, eVar, z16);
    }

    public void h(Activity activity, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, activity, Long.valueOf(j3));
        } else {
            TBSToolClientUtils.f291401a.m(activity, j3);
        }
    }

    public void i(Activity activity, final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, i3);
        } else {
            k(activity, new com.tencent.mobileqq.tbstool.fileview.b() { // from class: com.tencent.mobileqq.tbstool.fileview.d
                @Override // com.tencent.mobileqq.tbstool.fileview.b
                public final void execute(Object obj) {
                    ((j) obj).b(i3);
                }
            });
        }
    }

    public boolean n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, z16)).booleanValue();
        }
        QLog.i("TBSToolLocalTbsViewManager<FileAssistant>", 1, "tbs reader engine init. isForeground[" + z16 + "]");
        b bVar = new b();
        if (ReaderEngine.getInstance().isEngineLoaded()) {
            QLog.i("TBSToolLocalTbsViewManager<FileAssistant>", 1, "tbs reader engine has loaded in memory.");
            o();
            return true;
        }
        boolean fileEnginePreLoad = ReaderEngine.getInstance().fileEnginePreLoad(BaseApplication.getContext(), bVar, z16);
        if (fileEnginePreLoad) {
            QLog.i("TBSToolLocalTbsViewManager<FileAssistant>", 1, "tbs reader engine had downloaded.");
            o();
        } else {
            QLog.i("TBSToolLocalTbsViewManager<FileAssistant>", 1, "tbs reader engine not download.");
            ReportController.o(null, "dc00898", "", "", "0X800B009", "0X800B009", 0, 0, "", "", "", "");
        }
        return fileEnginePreLoad;
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (ReaderEngine.getInstance().getVersionCode() >= 5060010) {
            return true;
        }
        return false;
    }

    public boolean v(final Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity)).booleanValue();
        }
        Boolean bool = (Boolean) j(activity, new Function1() { // from class: com.tencent.mobileqq.tbstool.fileview.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Boolean s16;
                s16 = TBSToolLocalTbsViewManager.s(activity, (j) obj);
                return s16;
            }
        });
        if (bool != null && bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public void w(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        int hashCode = activity.hashCode();
        if (QLog.isDevelopLevel()) {
            QLog.d("TBSToolLocalTbsViewManager<FileAssistant>", 4, "LocalTbsViewManager destroy activity[" + hashCode + "]");
        }
        i(activity, 30006);
        if (!this.f291418a.isEmpty() && this.f291418a.pop().getFirst().intValue() != hashCode) {
            QLog.d("TBSToolLocalTbsViewManager<FileAssistant>", 1, "LocalTbsViewManager top activity wrong hashcode");
        }
    }

    public void x(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
        } else {
            QLog.d("TBSToolLocalTbsViewManager<FileAssistant>", 1, "onThemeChange");
            k(activity, new com.tencent.mobileqq.tbstool.fileview.b() { // from class: com.tencent.mobileqq.tbstool.fileview.e
                @Override // com.tencent.mobileqq.tbstool.fileview.b
                public final void execute(Object obj) {
                    TBSToolLocalTbsViewManager.t((j) obj);
                }
            });
        }
    }

    public TbsReaderView y(final Activity activity, final String str, final long j3, final LocalTbsViewManager.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (TbsReaderView) iPatchRedirector.redirect((short) 11, this, activity, str, Long.valueOf(j3), eVar);
        }
        return (TbsReaderView) j(activity, new Function1() { // from class: com.tencent.mobileqq.tbstool.fileview.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TbsReaderView u16;
                u16 = TBSToolLocalTbsViewManager.u(activity, str, j3, eVar, (j) obj);
                return u16;
            }
        });
    }

    public void z(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            if (this.f291418a.isEmpty()) {
                return;
            }
            this.f291418a.peek().getSecond().g(str);
        }
    }
}
