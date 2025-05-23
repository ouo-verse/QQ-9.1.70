package com.tencent.qqnt.audio.record.util;

import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.mediafocus.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/audio/record/util/b;", "", "", "d", "Landroid/content/Context;", "context", "", "mute", "c", "Lcom/tencent/mobileqq/mediafocus/b$c;", "b", "Lcom/tencent/mobileqq/mediafocus/b$c;", "mOnMediaFocusChangeListener", "<init>", "()V", "qq_audio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f352553a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b.c mOnMediaFocusChangeListener;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36333);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f352553a = new b();
            mOnMediaFocusChangeListener = new b.c() { // from class: com.tencent.qqnt.audio.record.util.a
                @Override // com.tencent.mobileqq.mediafocus.b.c
                public final void a(int i3) {
                    b.b(i3);
                }
            };
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int i3) {
        if (i3 == -1 || i3 == 2 || i3 == 3) {
            f352553a.d();
        }
    }

    private final void d() {
        if (QLog.isColorLevel()) {
            QLog.d("RecordUtil", 1, "notifyAudioFocusLoss");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004a, code lost:
    
        if (r8.requestAudioFocus(null, 3, 2) == 1) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        if (r8.abandonAudioFocus(null) == 1) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(@NotNull Context context, boolean mute) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(mute))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager = (AudioManager) systemService;
        if (mute) {
            com.tencent.mobileqq.mediafocus.b.i().l(1, mOnMediaFocusChangeListener);
        } else {
            com.tencent.mobileqq.mediafocus.b.i().d(mOnMediaFocusChangeListener);
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecordUtil", 2, "muteAudioFocus bMute=" + mute + " result=" + z16);
        }
        return z16;
    }
}
