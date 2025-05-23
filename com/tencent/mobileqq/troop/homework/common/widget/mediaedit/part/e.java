package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/e;", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/part/HWAudioRecordPart;", "a", "Ljava/lang/ref/WeakReference;", "partRef", "<init>", "(Ljava/lang/ref/WeakReference;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<HWAudioRecordPart> partRef;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull WeakReference<HWAudioRecordPart> partRef) {
        super(Looper.getMainLooper());
        Intrinsics.checkNotNullParameter(partRef, "partRef");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) partRef);
        } else {
            this.partRef = partRef;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(@NotNull Message msg2) {
        HWAudioRecordPart hWAudioRecordPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 != 3) {
            if (i3 != 101) {
                if (i3 == 102 && (hWAudioRecordPart = this.partRef.get()) != null) {
                    hWAudioRecordPart.E9(msg2.obj.toString());
                    return;
                }
                return;
            }
            HWAudioRecordPart hWAudioRecordPart2 = this.partRef.get();
            if (hWAudioRecordPart2 != null) {
                hWAudioRecordPart2.D9();
                return;
            }
            return;
        }
        HWAudioRecordPart hWAudioRecordPart3 = this.partRef.get();
        if (hWAudioRecordPart3 != null) {
            hWAudioRecordPart3.F9();
        }
    }
}
