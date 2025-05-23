package com.tencent.mobileqq.flock.repeat.part;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.flock.repeat.FlockRepeatType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/flock/repeat/part/FlockRepeatSetResultPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "onBackEvent", "Lcom/tencent/mobileqq/flock/repeat/b;", "d", "Lkotlin/Lazy;", "x9", "()Lcom/tencent/mobileqq/flock/repeat/b;", "viewModel", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockRepeatSetResultPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public FlockRepeatSetResultPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.repeat.b>() { // from class: com.tencent.mobileqq.flock.repeat.part.FlockRepeatSetResultPart$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockRepeatSetResultPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.flock.repeat.b invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.flock.repeat.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    FlockRepeatSetResultPart flockRepeatSetResultPart = FlockRepeatSetResultPart.this;
                    Intent intent = flockRepeatSetResultPart.getActivity().getIntent();
                    Intrinsics.checkNotNullExpressionValue(intent, "activity.intent");
                    return com.tencent.mobileqq.flock.publish.a.d(flockRepeatSetResultPart, intent);
                }
            });
            this.viewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.mobileqq.flock.repeat.b x9() {
        return (com.tencent.mobileqq.flock.repeat.b) this.viewModel.getValue();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Intent intent = new Intent();
        intent.putExtra("key_flock_repeat_type", x9().S1());
        if (x9().S1() != FlockRepeatType.NONE) {
            intent.putExtra("key_flock_repeat_end_time", x9().Q1());
        }
        Activity activity = getActivity();
        if (activity != null) {
            activity.setResult(200, intent);
        }
        return super.onBackEvent();
    }
}
