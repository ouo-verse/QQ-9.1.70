package com.tencent.mobileqq.troop.troopapps.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopapps/api/impl/e;", "", "Lcom/tencent/mobileqq/studymode/StudyModeChangeListener;", "listener", "", "d", "c", "Lmqq/util/WeakReference;", "b", "Lmqq/util/WeakReference;", "ref", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f299400a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<StudyModeChangeListener> ref;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56537);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f299400a = new e();
            ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).registerStudyModeChangeListener(new StudyModeChangeListener() { // from class: com.tencent.mobileqq.troop.troopapps.api.impl.d
                @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
                public final void onChange(boolean z16) {
                    e.b(z16);
                }
            });
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(boolean z16) {
        StudyModeChangeListener studyModeChangeListener;
        WeakReference<StudyModeChangeListener> weakReference = ref;
        if (weakReference != null && (studyModeChangeListener = weakReference.get()) != null) {
            studyModeChangeListener.onChange(z16);
        }
    }

    public final void c(@NotNull StudyModeChangeListener listener) {
        StudyModeChangeListener studyModeChangeListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        WeakReference<StudyModeChangeListener> weakReference = ref;
        if (weakReference != null) {
            studyModeChangeListener = weakReference.get();
        } else {
            studyModeChangeListener = null;
        }
        if (Intrinsics.areEqual(studyModeChangeListener, listener)) {
            ref = null;
        }
    }

    public final void d(@NotNull StudyModeChangeListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            ref = new WeakReference<>(listener);
        }
    }
}
