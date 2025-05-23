package com.tencent.qqnt.audio.tts.api.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tts.data.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.audio.tts.api.ITtsAbility;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/audio/tts/api/impl/TtsAbilityNtImpl;", "Lcom/tencent/qqnt/audio/tts/api/ITtsAbility;", "", "init", "Lcom/tencent/qqnt/audio/tts/api/ITtsAbility$a;", "listener", "setStateListener", "", "isWorking", "Lcom/tencent/mobileqq/tts/data/i;", "ttsPlayParams", "speak", "Landroid/content/Context;", "context", "gainFocus", "muteAudioFocus", "stop", "destroy", "", "robotUin", "Lcom/tencent/qqnt/audio/tts/api/ITtsAbility$b;", "voiceTypeListener", "getRobotTargetTtsId", "Lcom/tencent/qqnt/audio/tts/api/ITtsAbility$a;", "Z", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "<init>", "()V", "Companion", "a", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class TtsAbilityNtImpl implements ITtsAbility {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "TtsAbilityNtImpl";

    @NotNull
    private Handler handler;
    private boolean isWorking;

    @Nullable
    private ITtsAbility.a listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/audio/tts/api/impl/TtsAbilityNtImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.audio.tts.api.impl.TtsAbilityNtImpl$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36428);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TtsAbilityNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.handler = new Handler(Looper.getMainLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void speak$lambda$0(TtsAbilityNtImpl this$0, i ttsPlayParams) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ttsPlayParams, "$ttsPlayParams");
        ITtsAbility.a aVar = this$0.listener;
        if (aVar != null) {
            aVar.f(ttsPlayParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void speak$lambda$1(TtsAbilityNtImpl this$0, i ttsPlayParams) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ttsPlayParams, "$ttsPlayParams");
        ITtsAbility.a aVar = this$0.listener;
        if (aVar != null) {
            aVar.e(ttsPlayParams.e());
        }
        this$0.isWorking = false;
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.isWorking = false;
            this.handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public void getRobotTargetTtsId(@Nullable String robotUin, @NotNull ITtsAbility.b voiceTypeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) robotUin, (Object) voiceTypeListener);
        } else {
            Intrinsics.checkNotNullParameter(voiceTypeListener, "voiceTypeListener");
            voiceTypeListener.a("1");
        }
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            QLog.i(TAG, 1, "[init]");
        }
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public boolean isWorking() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isWorking;
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public void muteAudioFocus(@NotNull Context context, boolean gainFocus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, Boolean.valueOf(gainFocus));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.i(TAG, 1, "[muteAudioFocus] request=" + gainFocus);
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public void setStateListener(@Nullable ITtsAbility.a listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            this.listener = listener;
        }
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public boolean speak(@NotNull final i ttsPlayParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) ttsPlayParams)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ttsPlayParams, "ttsPlayParams");
        this.isWorking = true;
        this.handler.post(new Runnable() { // from class: com.tencent.qqnt.audio.tts.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                TtsAbilityNtImpl.speak$lambda$0(TtsAbilityNtImpl.this, ttsPlayParams);
            }
        });
        this.handler.postDelayed(new Runnable() { // from class: com.tencent.qqnt.audio.tts.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                TtsAbilityNtImpl.speak$lambda$1(TtsAbilityNtImpl.this, ttsPlayParams);
            }
        }, 5000L);
        return true;
    }

    @Override // com.tencent.qqnt.audio.tts.api.ITtsAbility
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.isWorking = false;
            this.handler.removeCallbacksAndMessages(null);
        }
    }
}
