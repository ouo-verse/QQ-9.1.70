package com.tencent.mobileqq.zplan.aigc;

import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: P */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/zplan/aigc/AigcAvatarFragment$initLoading$listener$1", "Luk0/e;", "", "type", "eventData", "", "onEvent", "", "d", "Z", "a", "()Z", "setDone", "(Z)V", "done", "Lkotlinx/coroutines/CancellableContinuation;", "e", "Lkotlinx/coroutines/CancellableContinuation;", "getContRef", "()Lkotlinx/coroutines/CancellableContinuation;", "b", "(Lkotlinx/coroutines/CancellableContinuation;)V", "contRef", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AigcAvatarFragment$initLoading$listener$1 implements uk0.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean done;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CancellableContinuation<? super Unit> contRef;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ AigcAvatarFragment f329865f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AigcAvatarFragment$initLoading$listener$1(AigcAvatarFragment aigcAvatarFragment) {
        this.f329865f = aigcAvatarFragment;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getDone() {
        return this.done;
    }

    public final void b(CancellableContinuation<? super Unit> cancellableContinuation) {
        this.contRef = cancellableContinuation;
    }

    @Override // uk0.e
    public void onEvent(String type, String eventData) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(eventData, "eventData");
        this.f329865f.isFirstFrame = true;
        this.f329865f.Gi();
        final AigcAvatarFragment aigcAvatarFragment = this.f329865f;
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$initLoading$listener$1$onEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FrameLayout fi5;
                ImageView mi5;
                if (AigcAvatarFragment.this.getView() == null) {
                    return;
                }
                fi5 = AigcAvatarFragment.this.fi();
                fi5.setVisibility(0);
                mi5 = AigcAvatarFragment.this.mi();
                mi5.setVisibility(8);
            }
        });
        synchronized (this) {
            this.done = true;
            CancellableContinuation<? super Unit> cancellableContinuation = this.contRef;
            if (cancellableContinuation != null) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(Unit.INSTANCE));
            }
            this.contRef = null;
            Unit unit = Unit.INSTANCE;
        }
        QLog.i("AigcAvatarFragment", 1, "FIRST_FRAME");
    }
}
