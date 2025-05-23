package com.tencent.mobileqq.tts.impl;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.injector.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.tts.ITtsController;
import com.tencent.mobileqq.tts.ITtsPlayer;
import com.tencent.mobileqq.tts.data.TtsNetStreamParam;
import com.tencent.mobileqq.tts.data.e;
import com.tencent.mobileqq.tts.data.i;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.audio.tts.api.ITtsPsKey;
import com.tencent.qqnt.audio.tts.api.impl.TtsAbilityImpl;
import com.tencent.qqnt.audio.tts.ui.TtsPlayType;
import com.tencent.util.WeakReferenceHandler;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TtsControllerImpl implements ITtsController, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    public static final int DATA_DONE = 1;
    public static final int DATA_LOADING = 0;
    private static final String TAG = "TtsController";
    public static final String TTS_APPID_AND_QQ = "201908021016";

    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Foundation/QQAudio/Inject_SpeakContentProcessor.yml", version = 1)
    private static ArrayList<Class<? extends yt2.a>> speakContentProcessorsClz;
    private int businessId;
    private final AtomicBoolean doneCallbackFlag;
    private Handler handler;
    private final AtomicInteger playCookie;
    private com.tencent.mobileqq.tts.impl.a playingRunnable;
    private final List<yt2.a> processors;
    private xt2.a ttsListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements com.tencent.mobileqq.tts.silk.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final int f303388a;

        a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TtsControllerImpl.this, i3);
            } else {
                this.f303388a = i3;
            }
        }

        @Override // com.tencent.mobileqq.tts.silk.a
        public void a() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (TtsControllerImpl.this.playingRunnable != null) {
                str = TtsControllerImpl.this.playingRunnable.getSpeech();
            } else {
                str = "";
            }
            TtsControllerImpl.this.notifyComplete(this.f303388a, str);
        }

        @Override // com.tencent.mobileqq.tts.silk.a
        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                TtsControllerImpl.this.notifyFirstTtsPlay(this.f303388a);
            }
        }

        @Override // com.tencent.mobileqq.tts.silk.a
        public void e(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            } else {
                TtsControllerImpl.this.notifyError(this.f303388a, i3, str);
            }
        }

        @Override // com.tencent.mobileqq.tts.silk.a
        public void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                TtsControllerImpl.this.handler.removeMessages(0);
                TtsControllerImpl.this.handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }

        @Override // com.tencent.mobileqq.tts.silk.a
        public void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                TtsControllerImpl.this.handler.removeMessages(0);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38825);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        ArrayList<Class<? extends yt2.a>> arrayList = new ArrayList<>();
        speakContentProcessorsClz = arrayList;
        arrayList.add(k.class);
    }

    public TtsControllerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.businessId = 0;
        this.playCookie = new AtomicInteger(0);
        this.doneCallbackFlag = new AtomicBoolean(false);
        this.processors = new ArrayList();
        QLog.d(TAG, 1, "TtsControllerImpl construct");
        Iterator<Class<? extends yt2.a>> it = speakContentProcessorsClz.iterator();
        while (it.hasNext()) {
            Class<? extends yt2.a> next = it.next();
            try {
                this.processors.add(next.newInstance());
            } catch (IllegalAccessException | InstantiationException e16) {
                QLog.w(TAG, 1, "newInstance failed clz: " + next, e16);
            }
        }
    }

    private TtsNetStreamParam buildRequestParam(i iVar) {
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("AND_");
        com.tencent.mobileqq.inject.a aVar = com.tencent.mobileqq.inject.a.f238063a;
        sb5.append(aVar.getAppId());
        sb5.append("_");
        sb5.append(aVar.getSubVersion());
        TtsNetStreamParam.a h16 = new TtsNetStreamParam.a().b(TTS_APPID_AND_QQ).m(getCurrentAccountUin().longValue()).j(Long.parseLong(iVar.c())).k(iVar.e()).l(MD5Utils.toMD5(iVar.e())).e(sb5.toString()).i(NetworkUtil.getNetWorkType()).d(this.businessId).f(getKeyFromTicketManager()).g(iVar.a()).n(iVar.g()).h(iVar.b());
        if (iVar.f() == TtsPlayType.TYPE_AUTO_TTS) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        return h16.c(Integer.valueOf(i3)).a();
    }

    private static Long getCurrentAccountUin() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.w(TAG, 1, "getCurrentAccountUin appRuntime is null");
            return 0L;
        }
        try {
            return Long.valueOf(Long.parseLong(peekAppRuntime.getCurrentAccountUin()));
        } catch (NumberFormatException e16) {
            QLog.w(TAG, 1, "getCurrentAccountUin error: ", e16);
            return 0L;
        }
    }

    private InputStream getInputStreamFromCache(i iVar) {
        if (iVar.f() == TtsPlayType.TYPE_AUTO_TTS) {
            return null;
        }
        InputStream c16 = e.a().c(iVar.e(), iVar.c(), iVar.g());
        if (c16 != null && QLog.isColorLevel()) {
            QLog.i(TAG, 1, "[getInputStream] from cache. model=" + iVar.a() + " voiceType=" + iVar.g());
        }
        return c16;
    }

    private static String getKeyFromTicketManager() {
        if (TtsAbilityImpl.getUsePskeyInsteadOfSkey()) {
            return ((ITtsPsKey) QRoute.api(ITtsPsKey.class)).getPsKeySync();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return ((TicketManager) peekAppRuntime.getManager(2)).getRealSkey(peekAppRuntime.getCurrentAccountUin());
    }

    @NonNull
    private com.tencent.mobileqq.tts.silk.a getPlayerCallback(int i3) {
        return new a(i3);
    }

    private boolean hasAlreadyDoneCallback() {
        return !this.doneCallbackFlag.compareAndSet(false, true);
    }

    private static void logSpeakParams(i iVar) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, iVar.toString());
        }
    }

    private String processText(String str) {
        Iterator<yt2.a> it = this.processors.iterator();
        while (it.hasNext()) {
            str = it.next().a(str);
        }
        return str.replaceAll("/", " ");
    }

    private int resetCallbackFlag() {
        this.doneCallbackFlag.set(false);
        return this.playCookie.incrementAndGet();
    }

    private boolean shouldNotCallback(int i3, String str) {
        if (i3 == this.playCookie.get() && !hasAlreadyDoneCallback()) {
            return false;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "[tag] has already done callback. tag" + str + " cookie: " + i3 + ", playCookie: " + this.playCookie.get());
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.tts.ITtsController
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            QLog.d(TAG, 1, "[destroy] release resources.");
            this.ttsListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputStream getInputStream(i iVar) {
        InputStream inputStreamFromCache = getInputStreamFromCache(iVar);
        if (inputStreamFromCache != null) {
            iVar.i(true);
            return inputStreamFromCache;
        }
        try {
            return e.b().a(buildRequestParam(iVar));
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[getInputStream] error: ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.tts.ITtsController
    public String getSpeech() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        com.tencent.mobileqq.tts.impl.a aVar = this.playingRunnable;
        if (aVar != null) {
            return aVar.getSpeech();
        }
        return "";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        xt2.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 0) {
            xt2.a aVar2 = this.ttsListener;
            if (aVar2 != null) {
                aVar2.c();
                return false;
            }
            return false;
        }
        if (i3 == 1 && (aVar = this.ttsListener) != null) {
            aVar.b();
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.tts.ITtsController
    public void init(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        QLog.d(TAG, 1, "[init] businessId: ", Integer.valueOf(i3));
        this.businessId = i3;
        this.handler = new WeakReferenceHandler(this);
    }

    @Override // com.tencent.mobileqq.tts.ITtsController
    public boolean isWorking() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.tts.impl.a aVar = this.playingRunnable;
        if (aVar != null) {
            return aVar.isRunning();
        }
        return false;
    }

    void notifyComplete(int i3, String str) {
        xt2.a aVar;
        if (!shouldNotCallback(i3, "notifyComplete") && (aVar = this.ttsListener) != null) {
            aVar.e(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyError(int i3, int i16, String str) {
        xt2.a aVar;
        if (!shouldNotCallback(i3, "notifyError") && (aVar = this.ttsListener) != null) {
            aVar.onError(i16, str);
        }
    }

    void notifyFirstTtsPlay(int i3) {
        xt2.a aVar;
        if (i3 == this.playCookie.get() && (aVar = this.ttsListener) != null) {
            aVar.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyNoNetwork(int i3) {
        xt2.a aVar;
        if (!shouldNotCallback(i3, "notifyNoNetwork") && (aVar = this.ttsListener) != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyPlayLoading(int i3) {
        xt2.a aVar;
        if (i3 == this.playCookie.get() && (aVar = this.ttsListener) != null) {
            aVar.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyPlayStart(int i3, i iVar) {
        xt2.a aVar;
        if (i3 == this.playCookie.get() && (aVar = this.ttsListener) != null) {
            aVar.f(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void notifyUserStop(int i3) {
        xt2.a aVar;
        if (!shouldNotCallback(i3, "notifyUserStop") && (aVar = this.ttsListener) != null) {
            aVar.h();
        }
    }

    @Override // com.tencent.mobileqq.tts.ITtsController
    public void setTtsListener(xt2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            this.ttsListener = aVar;
        }
    }

    @Override // com.tencent.mobileqq.tts.ITtsController
    @MainThread
    public void speak(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            speak(new i(0L, str2, str, null, null, null, false, TtsPlayType.TYPE_TEXT));
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        }
    }

    @Override // com.tencent.mobileqq.tts.ITtsController
    @MainThread
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.mobileqq.tts.impl.a aVar = this.playingRunnable;
        if (aVar != null) {
            aVar.stop();
            this.playingRunnable = null;
        }
    }

    @Override // com.tencent.mobileqq.tts.ITtsController
    @MainThread
    public boolean speak(i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) iVar)).booleanValue();
        }
        if (iVar != null && !TextUtils.isEmpty(iVar.e())) {
            int resetCallbackFlag = resetCallbackFlag();
            iVar.j(processText(iVar.e()));
            if (TextUtils.isEmpty(iVar.e())) {
                QLog.w(TAG, 1, "[speak] processText text error");
                return false;
            }
            logSpeakParams(iVar);
            stop();
            if (QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("robot_tts_enable_slice", false)) {
                this.playingRunnable = new TtsSlicePlayingRunnable(resetCallbackFlag, iVar, this);
            } else {
                this.playingRunnable = new TtsPlayingRunnable(resetCallbackFlag, iVar, this);
            }
            ITtsPlayer iTtsPlayer = (ITtsPlayer) QRoute.api(ITtsPlayer.class);
            iTtsPlayer.setPlayerCallback(getPlayerCallback(resetCallbackFlag));
            this.playingRunnable.a(iTtsPlayer);
            return true;
        }
        QLog.w(TAG, 1, "[speak] args error");
        return false;
    }
}
