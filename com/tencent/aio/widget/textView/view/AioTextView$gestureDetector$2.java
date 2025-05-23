package com.tencent.aio.widget.textView.view;

import android.content.Context;
import android.text.Spanned;
import android.text.StaticLayout;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.aio.widget.textView.view.AioTextView$gestureDetector$2;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/GestureDetector;", "invoke"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class AioTextView$gestureDetector$2 extends Lambda implements Function0<GestureDetector> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Context $context;
    final /* synthetic */ AioTextView this$0;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/aio/widget/textView/view/AioTextView$gestureDetector$2$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onDoubleTap", "", "event", "Landroid/view/MotionEvent;", e.a.NAME, "", "onSingleTapConfirmed", "simple-textView_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.widget.textView.view.AioTextView$gestureDetector$2$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        AnonymousClass1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) AioTextView$gestureDetector$2.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@NotNull MotionEvent event) {
            boolean s16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this, (Object) event)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(event, "event");
            s16 = AioTextView$gestureDetector$2.this.this$0.s(event, new Function4<b, StaticLayout, Spanned, MotionEvent, Boolean>() { // from class: com.tencent.aio.widget.textView.view.AioTextView$gestureDetector$2$1$onDoubleTap$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(4);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AioTextView$gestureDetector$2.AnonymousClass1.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Boolean invoke(b bVar, StaticLayout staticLayout, Spanned spanned, MotionEvent motionEvent) {
                    return Boolean.valueOf(invoke2(bVar, staticLayout, spanned, motionEvent));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(@NotNull b movementMethod, @Nullable StaticLayout staticLayout, @Nullable Spanned spanned, @NotNull MotionEvent motionEvent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 1, this, movementMethod, staticLayout, spanned, motionEvent)).booleanValue();
                    }
                    Intrinsics.checkNotNullParameter(movementMethod, "movementMethod");
                    Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
                    return movementMethod.a(AioTextView$gestureDetector$2.this.this$0, staticLayout, spanned, motionEvent);
                }
            });
            return s16;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(@NotNull MotionEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) event);
            } else {
                Intrinsics.checkNotNullParameter(event, "event");
                AioTextView$gestureDetector$2.this.this$0.s(event, new Function4<b, StaticLayout, Spanned, MotionEvent, Boolean>() { // from class: com.tencent.aio.widget.textView.view.AioTextView$gestureDetector$2$1$onLongPress$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(4);
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AioTextView$gestureDetector$2.AnonymousClass1.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Boolean invoke(b bVar, StaticLayout staticLayout, Spanned spanned, MotionEvent motionEvent) {
                        return Boolean.valueOf(invoke2(bVar, staticLayout, spanned, motionEvent));
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final boolean invoke2(@NotNull b movementMethod, @Nullable StaticLayout staticLayout, @Nullable Spanned spanned, @NotNull MotionEvent motionEvent) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            return ((Boolean) iPatchRedirector2.redirect((short) 1, this, movementMethod, staticLayout, spanned, motionEvent)).booleanValue();
                        }
                        Intrinsics.checkNotNullParameter(movementMethod, "movementMethod");
                        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
                        return movementMethod.b(AioTextView$gestureDetector$2.this.this$0, staticLayout, spanned, motionEvent);
                    }
                });
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(@NotNull MotionEvent event) {
            boolean s16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) event)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(event, "event");
            s16 = AioTextView$gestureDetector$2.this.this$0.s(event, new Function4<b, StaticLayout, Spanned, MotionEvent, Boolean>() { // from class: com.tencent.aio.widget.textView.view.AioTextView$gestureDetector$2$1$onSingleTapConfirmed$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(4);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AioTextView$gestureDetector$2.AnonymousClass1.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Boolean invoke(b bVar, StaticLayout staticLayout, Spanned spanned, MotionEvent motionEvent) {
                    return Boolean.valueOf(invoke2(bVar, staticLayout, spanned, motionEvent));
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2(@NotNull b movementMethod, @Nullable StaticLayout staticLayout, @Nullable Spanned spanned, @NotNull MotionEvent motionEvent) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 1, this, movementMethod, staticLayout, spanned, motionEvent)).booleanValue();
                    }
                    Intrinsics.checkNotNullParameter(movementMethod, "movementMethod");
                    Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
                    return movementMethod.c(AioTextView$gestureDetector$2.this.this$0, staticLayout, spanned, motionEvent);
                }
            });
            return s16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AioTextView$gestureDetector$2(AioTextView aioTextView, Context context) {
        super(0);
        this.this$0 = aioTextView;
        this.$context = context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioTextView, (Object) context);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final GestureDetector invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) ? new GestureDetector(this.$context, new AnonymousClass1()) : (GestureDetector) iPatchRedirector.redirect((short) 1, (Object) this);
    }
}
