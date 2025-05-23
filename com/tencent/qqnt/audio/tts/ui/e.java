package com.tencent.qqnt.audio.tts.ui;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.UiThread;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.audio.tts.api.ITtsAbility;
import com.tencent.qqnt.audio.tts.api.impl.TtsAbilityNtImpl;
import com.tencent.qqnt.audio.tts.ui.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u0003\u001f#(B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0007J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\"\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0007J\u0006\u0010\u001c\u001a\u00020\nJ\u0006\u0010\u001d\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\nR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R0\u0010*\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040&j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/audio/tts/ui/e;", "", "", "sessionId", "Lcom/tencent/qqnt/audio/tts/ui/e$b;", tl.h.F, "Lcom/tencent/qqnt/audio/tts/api/ITtsAbility$a;", "i", "", "stringResId", "", "p", "", "errorMsg", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "g", "v", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "j", "w", "l", "Lcom/tencent/qqnt/audio/tts/ui/b;", "playData", "Lcom/tencent/qqnt/audio/tts/ui/e$c;", "listener", "o", "t", "k", "u", "a", "J", "waitingId", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "uiHandler", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "sessionStates", "d", "Lcom/tencent/qqnt/audio/tts/ui/e$b;", "currentPlayState", "Lcom/tencent/qqnt/audio/tts/api/ITtsAbility;", "e", "Lcom/tencent/qqnt/audio/tts/api/ITtsAbility;", "ttsAbility", "<init>", "()V", "f", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final e f352597g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long waitingId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler uiHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Long, b> sessionStates;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b currentPlayState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ITtsAbility ttsAbility;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/audio/tts/ui/e$a;", "", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "runnable", "", "c", "Lcom/tencent/qqnt/audio/tts/ui/e;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/qqnt/audio/tts/ui/e;", "b", "()Lcom/tencent/qqnt/audio/tts/ui/e;", "", "IS_AUTO_TRIGGER_FALSE", "I", "IS_AUTO_TRIGGER_TRUE", "IS_PROLOGUE_FALSE", "IS_PROLOGUE_TRUE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.audio.tts.ui.e$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(Handler handler, Runnable runnable) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }

        @NotNull
        public final e b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return e.f352597g;
            }
            return (e) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u0015\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\u0006\u0010*\u001a\u00020%\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J4\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\"\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J?\u0010\u0017\u001a\u00020\u0004*\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001`\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0004R\u0017\u0010\u001e\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00105\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010-\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R$\u0010;\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R0\u0010@\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0=0<j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0=`>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010?R\"\u0010D\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\u001b\u001a\u0004\bA\u0010\u001d\"\u0004\bB\u0010CR\"\u0010G\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001b\u001a\u0004\bE\u0010\u001d\"\u0004\bF\u0010C\u00a8\u0006J"}, d2 = {"Lcom/tencent/qqnt/audio/tts/ui/e$b;", "", "Lcom/tencent/mobileqq/tts/data/i;", "params", "", "t", "", "errorCode", "u", "Lcom/tencent/qqnt/audio/tts/ui/b;", "data", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "f", "Lcom/tencent/qqnt/audio/tts/ui/e$c;", "listener", "e", DomainData.DOMAIN_NAME, "p", "r", "", "duration", "g", "(Ljava/util/HashMap;Lcom/tencent/qqnt/audio/tts/ui/b;Ljava/lang/Long;)V", "l", "a", "J", "i", "()J", "sessionId", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler", "Lcom/tencent/qqnt/audio/tts/api/ITtsAbility;", "c", "Lcom/tencent/qqnt/audio/tts/api/ITtsAbility;", "getTts", "()Lcom/tencent/qqnt/audio/tts/api/ITtsAbility;", QQWinkConstants.TAB_TTS, "", "d", "Z", "k", "()Z", "w", "(Z)V", "isPlaying", "j", "setLoading", "isLoading", "Lcom/tencent/qqnt/audio/tts/ui/b;", tl.h.F, "()Lcom/tencent/qqnt/audio/tts/ui/b;", "v", "(Lcom/tencent/qqnt/audio/tts/ui/b;)V", "playData", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "listeners", "getPlayStartTime", "setPlayStartTime", "(J)V", "playStartTime", "getLoadStartTime", "setLoadStartTime", "loadStartTime", "<init>", "(JLandroid/os/Handler;Lcom/tencent/qqnt/audio/tts/api/ITtsAbility;)V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long sessionId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Handler handler;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ITtsAbility tts;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private volatile boolean isPlaying;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private volatile boolean isLoading;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.qqnt.audio.tts.ui.b playData;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<WeakReference<c>> listeners;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long playStartTime;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private long loadStartTime;

        public b(long j3, @NotNull Handler handler, @NotNull ITtsAbility tts) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(tts, "tts");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), handler, tts);
                return;
            }
            this.sessionId = j3;
            this.handler = handler;
            this.tts = tts;
            this.listeners = new ArrayList<>();
        }

        private final void f(com.tencent.qqnt.audio.tts.ui.b data, HashMap<String, String> params) {
            String str;
            params.put("param_char_count", String.valueOf(data.d().length()));
            String g16 = data.g();
            if (g16 == null) {
                g16 = "(null)";
            }
            params.put("param_voice_type", g16);
            params.put("param_bot_uin", data.b());
            params.put("param_delay_ms", String.valueOf(System.currentTimeMillis() - this.loadStartTime));
            params.put("param_self_uin", data.e());
            params.put("msg_id", String.valueOf(data.c()));
            if (data.h()) {
                str = "1";
            } else {
                str = "0";
            }
            params.put("is_auto_play", str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Iterator<T> it = this$0.listeners.iterator();
            while (it.hasNext()) {
                c cVar = (c) ((WeakReference) it.next()).get();
                if (cVar != null) {
                    cVar.q(this$0.sessionId);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void o(b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.loadStartTime = System.currentTimeMillis();
            this$0.isPlaying = true;
            this$0.isLoading = true;
            Iterator<T> it = this$0.listeners.iterator();
            while (it.hasNext()) {
                c cVar = (c) ((WeakReference) it.next()).get();
                if (cVar != null) {
                    cVar.n(this$0.sessionId);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void q(b this$0, com.tencent.mobileqq.tts.data.i params) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(params, "$params");
            this$0.isLoading = false;
            Iterator<T> it = this$0.listeners.iterator();
            while (it.hasNext()) {
                c cVar = (c) ((WeakReference) it.next()).get();
                if (cVar != null) {
                    cVar.a(this$0.sessionId);
                }
            }
            this$0.playStartTime = System.currentTimeMillis();
            this$0.t(params);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void s(b this$0, int i3) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.isPlaying) {
                this$0.tts.muteAudioFocus(BaseApplication.getContext(), false);
            }
            this$0.isPlaying = false;
            this$0.isLoading = false;
            Iterator<T> it = this$0.listeners.iterator();
            while (it.hasNext()) {
                c cVar = (c) ((WeakReference) it.next()).get();
                if (cVar != null) {
                    cVar.i(this$0.sessionId);
                }
            }
            this$0.u(i3);
        }

        private final void t(com.tencent.mobileqq.tts.data.i params) {
            int i3;
            com.tencent.qqnt.audio.tts.ui.b bVar = this.playData;
            if (bVar != null) {
                a aVar = a.f352581a;
                HashMap<String, String> hashMap = new HashMap<>();
                f(bVar, hashMap);
                String str = "0";
                hashMap.put("param_error_code", "0");
                if (params.h()) {
                    str = "1";
                }
                hashMap.put("is_hit_cache", str);
                Unit unit = Unit.INSTANCE;
                aVar.b("aio_tts_play_start", hashMap);
                HashMap<String, Object> hashMap2 = new HashMap<>();
                g(hashMap2, bVar, null);
                if (bVar.h()) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                hashMap2.put("trigger_type", Integer.valueOf(i3));
                aVar.c("ev_bas_start_reading", hashMap2);
            }
        }

        private final void u(int errorCode) {
            String str;
            com.tencent.qqnt.audio.tts.ui.b bVar = this.playData;
            if (bVar == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - this.playStartTime;
            this.playStartTime = 0L;
            if (currentTimeMillis > MiniBoxNoticeInfo.MIN_5) {
                QLog.i("TtsViewController", 1, "[reportPlayStop] invalid duration. duration=" + currentTimeMillis + ", error=" + errorCode + ", session=" + this.sessionId);
                return;
            }
            a aVar = a.f352581a;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bot_uin", bVar.b());
            String g16 = bVar.g();
            if (g16 == null) {
                g16 = "(null)";
            }
            hashMap.put(ITroopAIVoiceChatApi.AI_CHAT_TYPE, g16);
            hashMap.put("msg_id", String.valueOf(bVar.c()));
            String str2 = "0";
            String str3 = "1";
            if (!bVar.h()) {
                str = "0";
            } else {
                str = "1";
            }
            hashMap.put("is_auto_play", str);
            if (errorCode == 1) {
                str2 = "1";
            }
            hashMap.put("is_stop_by_user", str2);
            hashMap.put("play_time_ms", String.valueOf(currentTimeMillis));
            Unit unit = Unit.INSTANCE;
            aVar.b("aio_tts_play_end", hashMap);
            if (errorCode == 0) {
                HashMap<String, Object> hashMap2 = new HashMap<>();
                g(hashMap2, bVar, Long.valueOf(currentTimeMillis));
                aVar.c("ev_bas_reading_end", hashMap2);
                return;
            }
            HashMap<String, Object> hashMap3 = new HashMap<>();
            g(hashMap3, bVar, Long.valueOf(currentTimeMillis));
            aVar.c("ev_bas_stop_reading", hashMap3);
            if (errorCode == 2 || errorCode == 3) {
                HashMap<String, String> hashMap4 = new HashMap<>();
                f(bVar, hashMap4);
                if (errorCode != 2) {
                    str3 = "2";
                }
                hashMap4.put("param_error_code", str3);
                aVar.b("aio_tts_play_start", hashMap4);
            }
        }

        @UiThread
        public final void e(@Nullable c listener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) listener);
                return;
            }
            if (listener == null) {
                return;
            }
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((WeakReference) it.next()).get(), listener)) {
                    return;
                }
            }
            this.listeners.add(new WeakReference<>(listener));
        }

        public final void g(@NotNull HashMap<String, Object> hashMap, @NotNull com.tencent.qqnt.audio.tts.ui.b data, @Nullable Long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, this, hashMap, data, l3);
                return;
            }
            Intrinsics.checkNotNullParameter(hashMap, "<this>");
            Intrinsics.checkNotNullParameter(data, "data");
            hashMap.put("msg_id", String.valueOf(this.sessionId));
            hashMap.put("text_content", data.d());
            hashMap.put("touin", data.e());
            if (l3 != null) {
                hashMap.put("spend", Long.valueOf((l3.longValue() / 1000) + 1));
            }
            String g16 = data.g();
            if (g16 == null) {
                g16 = "";
            }
            hashMap.put("current_timbre", g16);
            hashMap.put("is_prologue", Integer.valueOf(data.i() ? 1 : 0));
        }

        @Nullable
        public final com.tencent.qqnt.audio.tts.ui.b h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (com.tencent.qqnt.audio.tts.ui.b) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.playData;
        }

        public final long i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.sessionId;
        }

        public final boolean j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.isLoading;
        }

        public final boolean k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.isPlaying;
        }

        public final void l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
                e.INSTANCE.c(this.handler, new Runnable() { // from class: com.tencent.qqnt.audio.tts.ui.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.b.m(e.b.this);
                    }
                });
            } else {
                iPatchRedirector.redirect((short) 21, (Object) this);
            }
        }

        public final void n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
                e.INSTANCE.c(this.handler, new Runnable() { // from class: com.tencent.qqnt.audio.tts.ui.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.b.o(e.b.this);
                    }
                });
            } else {
                iPatchRedirector.redirect((short) 17, (Object) this);
            }
        }

        public final void p(@NotNull final com.tencent.mobileqq.tts.data.i params) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, (Object) params);
                return;
            }
            Intrinsics.checkNotNullParameter(params, "params");
            this.tts.muteAudioFocus(BaseApplication.getContext(), true);
            e.INSTANCE.c(this.handler, new Runnable() { // from class: com.tencent.qqnt.audio.tts.ui.g
                @Override // java.lang.Runnable
                public final void run() {
                    e.b.q(e.b.this, params);
                }
            });
        }

        public final void r(final int errorCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
                e.INSTANCE.c(this.handler, new Runnable() { // from class: com.tencent.qqnt.audio.tts.ui.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.b.s(e.b.this, errorCode);
                    }
                });
            } else {
                iPatchRedirector.redirect((short) 19, (Object) this, errorCode);
            }
        }

        public final void v(@Nullable com.tencent.qqnt.audio.tts.ui.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
            } else {
                this.playData = bVar;
            }
        }

        public final void w(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else {
                this.isPlaying = z16;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/audio/tts/ui/e$c;", "", "", "sessionId", "", DomainData.DOMAIN_NAME, "a", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public interface c {
        void a(long sessionId);

        void i(long sessionId);

        void n(long sessionId);

        void q(long sessionId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\u001a\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/qqnt/audio/tts/ui/e$d", "Lcom/tencent/qqnt/audio/tts/api/ITtsAbility$a;", "", "g", "Lcom/tencent/mobileqq/tts/data/i;", "params", "f", "c", "b", "", "text", "e", "a", "", "retCode", "errorMsg", "onError", tl.h.F, "d", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class d implements ITtsAbility.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility.a
        public void a() {
            Long l3;
            com.tencent.qqnt.audio.tts.ui.b h16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                b bVar = e.this.currentPlayState;
                if (bVar != null) {
                    l3 = Long.valueOf(bVar.i());
                } else {
                    l3 = null;
                }
                boolean z16 = true;
                QLog.i("TtsViewController", 1, "onNoNetwork, session=" + l3);
                b bVar2 = e.this.currentPlayState;
                if (bVar2 != null) {
                    bVar2.r(2);
                }
                b bVar3 = e.this.currentPlayState;
                if (bVar3 == null || (h16 = bVar3.h()) == null || h16.h()) {
                    z16 = false;
                }
                if (z16) {
                    e.this.p(R.string.f236807fc);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this);
        }

        @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility.a
        public void b() {
            Long l3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                b bVar = e.this.currentPlayState;
                if (bVar != null) {
                    l3 = Long.valueOf(bVar.i());
                } else {
                    l3 = null;
                }
                QLog.i("TtsViewController", 1, "onPlayResumed, session=" + l3);
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility.a
        public void c() {
            Long l3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                b bVar = e.this.currentPlayState;
                if (bVar != null) {
                    l3 = Long.valueOf(bVar.i());
                } else {
                    l3 = null;
                }
                QLog.i("TtsViewController", 1, "onPlayPaused, session=" + l3);
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility.a
        public void d() {
            Long l3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                b bVar = e.this.currentPlayState;
                if (bVar != null) {
                    l3 = Long.valueOf(bVar.i());
                } else {
                    l3 = null;
                }
                QLog.i("TtsViewController", 1, "onFirstTtsPlay, session=" + l3);
                b bVar2 = e.this.currentPlayState;
                if (bVar2 != null) {
                    bVar2.l();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 10, (Object) this);
        }

        @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility.a
        public void e(@Nullable String text) {
            Long l3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                b bVar = e.this.currentPlayState;
                if (bVar != null) {
                    l3 = Long.valueOf(bVar.i());
                } else {
                    l3 = null;
                }
                QLog.i("TtsViewController", 1, "onPlayComplete, session=" + l3);
                b bVar2 = e.this.currentPlayState;
                if (bVar2 != null) {
                    bVar2.r(0);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) text);
        }

        @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility.a
        public void f(@NotNull com.tencent.mobileqq.tts.data.i params) {
            Long l3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) params);
                return;
            }
            Intrinsics.checkNotNullParameter(params, "params");
            b bVar = e.this.currentPlayState;
            if (bVar != null) {
                l3 = Long.valueOf(bVar.i());
            } else {
                l3 = null;
            }
            QLog.i("TtsViewController", 1, "onPlayStart, session=" + l3);
            b bVar2 = e.this.currentPlayState;
            if (bVar2 != null) {
                bVar2.p(params);
            }
        }

        @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility.a
        public void g() {
            Long l3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                b bVar = e.this.currentPlayState;
                if (bVar != null) {
                    l3 = Long.valueOf(bVar.i());
                } else {
                    l3 = null;
                }
                QLog.i("TtsViewController", 1, "onPlayLoading, session=" + l3);
                b bVar2 = e.this.currentPlayState;
                if (bVar2 != null) {
                    bVar2.n();
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility.a
        public void h() {
            Long l3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                b bVar = e.this.currentPlayState;
                if (bVar != null) {
                    l3 = Long.valueOf(bVar.i());
                } else {
                    l3 = null;
                }
                QLog.i("TtsViewController", 1, "onStopByUser, session=" + l3);
                b bVar2 = e.this.currentPlayState;
                if (bVar2 != null) {
                    bVar2.r(1);
                    return;
                }
                return;
            }
            iPatchRedirector.redirect((short) 9, (Object) this);
        }

        @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility.a
        public void onError(int retCode, @Nullable String errorMsg) {
            Long l3;
            boolean z16;
            com.tencent.qqnt.audio.tts.ui.b h16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                b bVar = e.this.currentPlayState;
                if (bVar != null) {
                    l3 = Long.valueOf(bVar.i());
                } else {
                    l3 = null;
                }
                boolean z17 = true;
                QLog.i("TtsViewController", 1, "onError, session=" + l3 + ", retCode=" + retCode + " errMsg=" + errorMsg);
                b bVar2 = e.this.currentPlayState;
                if (bVar2 != null) {
                    bVar2.r(3);
                }
                b bVar3 = e.this.currentPlayState;
                if (bVar3 != null && (h16 = bVar3.h()) != null && !h16.h()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (errorMsg != null && errorMsg.length() != 0) {
                        z17 = false;
                    }
                    if (z17) {
                        e.this.p(R.string.f236797fb);
                        return;
                    } else {
                        e.this.q(errorMsg);
                        return;
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, retCode, (Object) errorMsg);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36529);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
            f352597g = new e();
        }
    }

    e() {
        ITtsAbility ttsAbilityNtImpl;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.sessionStates = new HashMap<>();
        try {
            ttsAbilityNtImpl = (ITtsAbility) QRoute.api(ITtsAbility.class);
        } catch (Exception unused) {
            ttsAbilityNtImpl = new TtsAbilityNtImpl();
        }
        Intrinsics.checkNotNullExpressionValue(ttsAbilityNtImpl, "try {\n        QRoute.api\u2026 TtsAbilityNtImpl()\n    }");
        this.ttsAbility = ttsAbilityNtImpl;
        ttsAbilityNtImpl.init();
        ttsAbilityNtImpl.setStateListener(i());
    }

    private final void g() {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
        } else {
            throw new RuntimeException("TtsViewController should be called in main thread");
        }
    }

    private final b h(long sessionId) {
        HashMap<Long, b> hashMap = this.sessionStates;
        Long valueOf = Long.valueOf(sessionId);
        b bVar = hashMap.get(valueOf);
        if (bVar == null) {
            bVar = new b(sessionId, this.uiHandler, this.ttsAbility);
            hashMap.put(valueOf, bVar);
        }
        return bVar;
    }

    private final ITtsAbility.a i() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(final int stringResId) {
        final BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            this.uiHandler.post(new Runnable() { // from class: com.tencent.qqnt.audio.tts.ui.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.r(BaseApplication.this, stringResId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(final String errorMsg) {
        final BaseApplication context = BaseApplication.getContext();
        if (context != null) {
            this.uiHandler.post(new Runnable() { // from class: com.tencent.qqnt.audio.tts.ui.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.s(BaseApplication.this, errorMsg);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(BaseApplication context, int i3) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, 1, context.getResources().getString(i3), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(BaseApplication context, String errorMsg) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        QQToast.makeText(context, 1, errorMsg, 0).show();
    }

    private final void v() {
        Long l3;
        b bVar = this.currentPlayState;
        if (bVar != null) {
            l3 = Long.valueOf(bVar.i());
        } else {
            l3 = null;
        }
        QLog.i("TtsViewController", 1, "[stopCurrentSession] session=" + l3);
        if (this.currentPlayState != null) {
            this.ttsAbility.stop();
        }
        this.currentPlayState = null;
    }

    @MainThread
    public final long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.waitingId;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (this.currentPlayState != null) {
            return true;
        }
        return false;
    }

    @MainThread
    public final boolean l(long sessionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, sessionId)).booleanValue();
        }
        g();
        b bVar = this.currentPlayState;
        if (bVar == null || bVar.i() != sessionId || !bVar.k() || !bVar.j()) {
            return false;
        }
        return true;
    }

    @MainThread
    public final boolean m(long sessionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, sessionId)).booleanValue();
        }
        g();
        b bVar = this.currentPlayState;
        if (bVar == null || bVar.i() != sessionId || !bVar.k()) {
            return false;
        }
        return true;
    }

    @MainThread
    public final boolean n(long sessionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, sessionId)).booleanValue();
        }
        g();
        if (this.waitingId == sessionId) {
            return true;
        }
        return false;
    }

    @MainThread
    public final boolean o(long sessionId, @NotNull com.tencent.qqnt.audio.tts.ui.b playData, @Nullable c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, Long.valueOf(sessionId), playData, listener)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(playData, "playData");
        g();
        QLog.d("TtsViewController", 1, "[play] sessionId=" + sessionId);
        b bVar = this.currentPlayState;
        if (bVar != null && bVar.i() == sessionId) {
            z16 = true;
        }
        if (!z16) {
            v();
        }
        b h16 = h(sessionId);
        h16.w(true);
        h16.v(playData);
        h16.e(listener);
        this.currentPlayState = h16;
        return this.ttsAbility.speak(new com.tencent.mobileqq.tts.data.i(playData.c(), playData.b(), playData.d(), playData.a(), 1, playData.g(), playData.h(), playData.f(), false, 256, null));
    }

    public final void t() {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        b bVar = this.currentPlayState;
        if (bVar != null) {
            l3 = Long.valueOf(bVar.i());
        } else {
            l3 = null;
        }
        QLog.i("TtsViewController", 1, "[stopAll] current session, session=" + l3);
        v();
    }

    public final void u() {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        b bVar = this.currentPlayState;
        if (bVar != null) {
            l3 = Long.valueOf(bVar.i());
        } else {
            l3 = null;
        }
        QLog.i("TtsViewController", 1, "[stopAndClearStates] current session, session=" + l3);
        v();
        this.sessionStates.clear();
    }

    @MainThread
    public final void w(long sessionId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, sessionId);
        } else {
            this.waitingId = sessionId;
        }
    }
}
