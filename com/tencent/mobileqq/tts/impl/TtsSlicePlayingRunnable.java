package com.tencent.mobileqq.tts.impl;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tts.ITtsPlayer;
import com.tencent.mobileqq.tts.data.i;
import com.tencent.mobileqq.tts.stream.c;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001\u0004B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b(\u0010)J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R$\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u00030#j\b\u0012\u0004\u0012\u00020\u0003`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/tts/impl/TtsSlicePlayingRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mobileqq/tts/impl/a;", "", "b", "getSpeech", "", TencentLocation.RUN_MODE, "Lcom/tencent/mobileqq/tts/ITtsPlayer;", "player", "a", "stop", "", "isRunning", "", "d", "I", "cookie", "Lcom/tencent/mobileqq/tts/data/i;", "e", "Lcom/tencent/mobileqq/tts/data/i;", "ttsPlayParams", "Lcom/tencent/mobileqq/tts/impl/TtsControllerImpl;", "f", "Lcom/tencent/mobileqq/tts/impl/TtsControllerImpl;", "controller", h.F, "Z", "i", "Lcom/tencent/mobileqq/tts/ITtsPlayer;", "ttsPlayer", "Lcom/tencent/mobileqq/tts/stream/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/tts/stream/c;", "textStreamSegment", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "textSliceList", "<init>", "(ILcom/tencent/mobileqq/tts/data/i;Lcom/tencent/mobileqq/tts/impl/TtsControllerImpl;)V", "D", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TtsSlicePlayingRunnable implements Runnable, com.tencent.mobileqq.tts.impl.a {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<String> textSliceList;

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
    private ITtsPlayer ttsPlayer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.tts.stream.c textStreamSegment;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/tts/impl/TtsSlicePlayingRunnable$a", "Lcom/tencent/mobileqq/tts/stream/c$b;", "", "text", "", "isEnd", "", "a", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements c.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TtsSlicePlayingRunnable.this);
            }
        }

        @Override // com.tencent.mobileqq.tts.stream.c.b
        public void a(@NotNull String text, boolean isEnd) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, text, Boolean.valueOf(isEnd));
            } else {
                Intrinsics.checkNotNullParameter(text, "text");
                TtsSlicePlayingRunnable.this.textSliceList.add(text);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/tts/impl/TtsSlicePlayingRunnable$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tts.impl.TtsSlicePlayingRunnable$b, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36219);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TtsSlicePlayingRunnable(int i3, @NotNull i ttsPlayParams, @NotNull TtsControllerImpl controller) {
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
        com.tencent.mobileqq.tts.stream.c cVar = new com.tencent.mobileqq.tts.stream.c();
        this.textStreamSegment = cVar;
        this.textSliceList = new ArrayList<>();
        cVar.e(new a());
    }

    private final String b(String str) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return "(empty)";
        }
        return str.charAt(0) + "|" + str.length();
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isRunning;
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
            QLog.w("TtsSlicePlayingRunnable", 4, "[speak] speech is empty. cookie:" + this.cookie + " sessionId:" + this.ttsPlayParams.d());
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("TtsSlicePlayingRunnable", 4, "[speak] start connecting to server. cookie:" + this.cookie + " sessionId:" + this.ttsPlayParams.d());
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.textStreamSegment.a(this.ttsPlayParams.e());
        this.textStreamSegment.b();
        if (this.textSliceList.isEmpty()) {
            QLog.w("TtsSlicePlayingRunnable", 1, "[speak] textSliceList is empty. cookie:" + this.cookie);
            return;
        }
        this.controller.notifyPlayLoading(this.cookie);
        com.tencent.mobileqq.tts.stream.b bVar = new com.tencent.mobileqq.tts.stream.b();
        ITtsPlayer iTtsPlayer = this.ttsPlayer;
        ITtsPlayer iTtsPlayer2 = null;
        if (iTtsPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ttsPlayer");
            iTtsPlayer = null;
        }
        iTtsPlayer.setDataStreams(bVar);
        ITtsPlayer iTtsPlayer3 = this.ttsPlayer;
        if (iTtsPlayer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ttsPlayer");
        } else {
            iTtsPlayer2 = iTtsPlayer3;
        }
        iTtsPlayer2.start();
        Iterator<String> it = this.textSliceList.iterator();
        boolean z17 = true;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String textSlice = it.next();
            if (!this.isRunning) {
                QLog.d("TtsSlicePlayingRunnable", 1, "[speak] stream prepared but shouldn't speak. cookie:" + this.cookie);
                break;
            }
            InputStream inputStream = this.controller.getInputStream(this.ttsPlayParams);
            if (inputStream == null) {
                QLog.i("TtsSlicePlayingRunnable", 1, "[speak] input stream is null. cookie:" + this.cookie + " ttsPlayParams = " + this.ttsPlayParams);
                this.controller.notifyNoNetwork(this.cookie);
                this.isRunning = false;
                return;
            }
            if (!this.isRunning) {
                QLog.d("TtsSlicePlayingRunnable", 1, "[speak] stream prepared but shouldn't speak. cookie:" + this.cookie);
                return;
            }
            bVar.c(inputStream, false);
            if (z17) {
                this.controller.notifyPlayStart(this.cookie, this.ttsPlayParams);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                QLog.i("TtsSlicePlayingRunnable", 1, "[speak] connection is built, start playing, cookie:" + this.cookie + " costTime = " + currentTimeMillis2 + " params = " + this.ttsPlayParams);
                z17 = false;
            } else {
                int i3 = this.cookie;
                int f16 = bVar.f();
                Intrinsics.checkNotNullExpressionValue(textSlice, "textSlice");
                QLog.i("TtsSlicePlayingRunnable", 1, "a slice is enqueued. cookie:" + i3 + " queue:" + f16 + " text:" + b(textSlice));
            }
        }
        bVar.d();
        QLog.i("TtsSlicePlayingRunnable", 1, "all slices are enqueued. cookie:" + this.cookie + "}");
    }

    @Override // com.tencent.mobileqq.tts.impl.a
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TtsSlicePlayingRunnable", 1, "[stop] stop tts. cookie: " + this.cookie);
        }
        this.isRunning = false;
        this.controller.notifyUserStop(this.cookie);
        ITtsPlayer iTtsPlayer = this.ttsPlayer;
        if (iTtsPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ttsPlayer");
            iTtsPlayer = null;
        }
        iTtsPlayer.stop();
    }
}
