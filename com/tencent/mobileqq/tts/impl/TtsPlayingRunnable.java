package com.tencent.mobileqq.tts.impl;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tts.ITtsPlayer;
import com.tencent.mobileqq.tts.data.i;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001\tB\u001f\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/tts/impl/TtsPlayingRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mobileqq/tts/impl/a;", "", "getSpeech", "", TencentLocation.RUN_MODE, "Lcom/tencent/mobileqq/tts/ITtsPlayer;", "player", "a", "stop", "", "isRunning", "", "d", "I", "cookie", "Lcom/tencent/mobileqq/tts/data/i;", "e", "Lcom/tencent/mobileqq/tts/data/i;", "ttsPlayParams", "Lcom/tencent/mobileqq/tts/impl/TtsControllerImpl;", "f", "Lcom/tencent/mobileqq/tts/impl/TtsControllerImpl;", "controller", h.F, "Z", "i", "isBlockOnAcquiringStream", "Ljava/io/InputStream;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/io/InputStream;", "inputStream", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/tts/ITtsPlayer;", "ttsPlayer", "<init>", "(ILcom/tencent/mobileqq/tts/data/i;Lcom/tencent/mobileqq/tts/impl/TtsControllerImpl;)V", "D", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TtsPlayingRunnable implements Runnable, a {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ITtsPlayer ttsPlayer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int cookie;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i ttsPlayParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TtsControllerImpl controller;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isRunning;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isBlockOnAcquiringStream;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private InputStream inputStream;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/tts/impl/TtsPlayingRunnable$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tts.impl.TtsPlayingRunnable$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36137);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TtsPlayingRunnable(int i3, @NotNull i ttsPlayParams, @NotNull TtsControllerImpl controller) {
        Intrinsics.checkNotNullParameter(ttsPlayParams, "ttsPlayParams");
        Intrinsics.checkNotNullParameter(controller, "controller");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), ttsPlayParams, controller);
            return;
        }
        this.cookie = i3;
        this.ttsPlayParams = ttsPlayParams;
        this.controller = controller;
    }

    @Override // com.tencent.mobileqq.tts.impl.a
    public void a(@NotNull ITtsPlayer player) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) player);
            return;
        }
        Intrinsics.checkNotNullParameter(player, "player");
        this.isRunning = true;
        this.ttsPlayer = player;
        ThreadManagerV2.excute(this, 128, null, false);
    }

    @Override // com.tencent.mobileqq.tts.impl.a
    @NotNull
    public String getSpeech() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.ttsPlayParams.e();
    }

    @Override // com.tencent.mobileqq.tts.impl.a
    public boolean isRunning() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.isBlockOnAcquiringStream) {
            return true;
        }
        ITtsPlayer iTtsPlayer = this.ttsPlayer;
        if (iTtsPlayer != null && iTtsPlayer.isPlaying()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.ttsPlayParams.e().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.w("TtsPlayingRunnable", 1, "[speak] args error. cookie:" + this.cookie);
            this.controller.notifyError(this.cookie, 0, "");
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("TtsPlayingRunnable", 4, "[speak] start connecting to server. cookie:" + this.cookie);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.controller.notifyPlayLoading(this.cookie);
        this.isBlockOnAcquiringStream = true;
        InputStream inputStream = this.controller.getInputStream(this.ttsPlayParams);
        this.inputStream = inputStream;
        this.isBlockOnAcquiringStream = false;
        if (inputStream == null) {
            QLog.i("TtsPlayingRunnable", 1, "[speak] input stream is null. cookie:" + this.cookie + " params = " + this.ttsPlayParams);
            this.controller.notifyNoNetwork(this.cookie);
            this.isRunning = false;
            return;
        }
        if (!this.isRunning) {
            QLog.d("TtsPlayingRunnable", 1, "[speak] stream prepared but shouldn't speak. cookie:" + this.cookie);
            this.controller.notifyError(this.cookie, 0, "");
            return;
        }
        ITtsPlayer iTtsPlayer = this.ttsPlayer;
        if (iTtsPlayer == null) {
            QLog.e("TtsPlayingRunnable", 1, "[speak] ttsPlayer is null cookie:" + this.cookie);
            this.controller.notifyError(this.cookie, 0, "");
            return;
        }
        if (iTtsPlayer != null) {
            iTtsPlayer.setDataStream(inputStream);
            iTtsPlayer.start(0);
            this.controller.notifyPlayStart(this.cookie, this.ttsPlayParams);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            QLog.i("TtsPlayingRunnable", 1, "[speak] connection is built, start playing, cookie:" + this.cookie + " costTime = " + currentTimeMillis2 + " params = " + this.ttsPlayParams);
        }
    }

    @Override // com.tencent.mobileqq.tts.impl.a
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TtsPlayingRunnable", 1, "[stop] stop tts. cookie: " + this.cookie);
        }
        this.isRunning = false;
        this.controller.notifyUserStop(this.cookie);
        ITtsPlayer iTtsPlayer = this.ttsPlayer;
        if (iTtsPlayer != null) {
            iTtsPlayer.stop();
        }
    }
}
