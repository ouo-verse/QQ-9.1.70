package com.tencent.robot.aio.playvideo;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.aio.playvideo.PlayVideoUIState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LifecycleEventObserver;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
final class PlayVideoVM$lifeEventObserver$2 extends Lambda implements Function0<LifecycleEventObserver> {
    final /* synthetic */ PlayVideoVM this$0;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f367289a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f367289a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayVideoVM$lifeEventObserver$2(PlayVideoVM playVideoVM) {
        super(0);
        this.this$0 = playVideoVM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PlayVideoVM this$0, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = a.f367289a[event.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                QLog.i("PlayVideoVM", 1, "resume");
                this$0.updateUI(PlayVideoUIState.Resume.f367279d);
                return;
            }
            return;
        }
        QLog.i("PlayVideoVM", 1, "pause");
        this$0.updateUI(PlayVideoUIState.Pause.f367278d);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final LifecycleEventObserver invoke() {
        final PlayVideoVM playVideoVM = this.this$0;
        return new LifecycleEventObserver() { // from class: com.tencent.robot.aio.playvideo.s
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                PlayVideoVM$lifeEventObserver$2.b(PlayVideoVM.this, lifecycleOwner, event);
            }
        };
    }
}
