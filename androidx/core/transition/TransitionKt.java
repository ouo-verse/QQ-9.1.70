package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001a\u00c9\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u00f8\u0001\u0000\u001a5\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u00f8\u0001\u0000\u001a5\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u00f8\u0001\u0000\u001a5\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u00f8\u0001\u0000\u001a5\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u00f8\u0001\u0000\u001a5\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0013"}, d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", "onStart", "onCancel", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class TransitionKt {
    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener addListener(@NotNull Transition addListener, @NotNull Function1<? super Transition, Unit> onEnd, @NotNull Function1<? super Transition, Unit> onStart, @NotNull Function1<? super Transition, Unit> onCancel, @NotNull Function1<? super Transition, Unit> onResume, @NotNull Function1<? super Transition, Unit> onPause) {
        Intrinsics.checkNotNullParameter(addListener, "$this$addListener");
        Intrinsics.checkNotNullParameter(onEnd, "onEnd");
        Intrinsics.checkNotNullParameter(onStart, "onStart");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(onResume, "onResume");
        Intrinsics.checkNotNullParameter(onPause, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        addListener.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition addListener, Function1 onEnd, Function1 function1, Function1 function12, Function1 onResume, Function1 onPause, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            onEnd = new Function1<Transition, Unit>() { // from class: androidx.core.transition.TransitionKt$addListener$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            };
        }
        if ((i3 & 2) != 0) {
            function1 = new Function1<Transition, Unit>() { // from class: androidx.core.transition.TransitionKt$addListener$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            };
        }
        Function1 onStart = function1;
        if ((i3 & 4) != 0) {
            function12 = new Function1<Transition, Unit>() { // from class: androidx.core.transition.TransitionKt$addListener$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            };
        }
        Function1 onCancel = function12;
        if ((i3 & 8) != 0) {
            onResume = new Function1<Transition, Unit>() { // from class: androidx.core.transition.TransitionKt$addListener$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            };
        }
        if ((i3 & 16) != 0) {
            onPause = new Function1<Transition, Unit>() { // from class: androidx.core.transition.TransitionKt$addListener$5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
                    invoke2(transition);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Transition it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }
            };
        }
        Intrinsics.checkNotNullParameter(addListener, "$this$addListener");
        Intrinsics.checkNotNullParameter(onEnd, "onEnd");
        Intrinsics.checkNotNullParameter(onStart, "onStart");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        Intrinsics.checkNotNullParameter(onResume, "onResume");
        Intrinsics.checkNotNullParameter(onPause, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        addListener.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnCancel(@NotNull Transition doOnCancel, @NotNull final Function1<? super Transition, Unit> action) {
        Intrinsics.checkNotNullParameter(doOnCancel, "$this$doOnCancel");
        Intrinsics.checkNotNullParameter(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
                Function1.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }
        };
        doOnCancel.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnEnd(@NotNull Transition doOnEnd, @NotNull final Function1<? super Transition, Unit> action) {
        Intrinsics.checkNotNullParameter(doOnEnd, "$this$doOnEnd");
        Intrinsics.checkNotNullParameter(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
                Function1.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }
        };
        doOnEnd.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnPause(@NotNull Transition doOnPause, @NotNull final Function1<? super Transition, Unit> action) {
        Intrinsics.checkNotNullParameter(doOnPause, "$this$doOnPause");
        Intrinsics.checkNotNullParameter(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
                Function1.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }
        };
        doOnPause.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnResume(@NotNull Transition doOnResume, @NotNull final Function1<? super Transition, Unit> action) {
        Intrinsics.checkNotNullParameter(doOnResume, "$this$doOnResume");
        Intrinsics.checkNotNullParameter(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
                Function1.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }
        };
        doOnResume.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @NotNull
    public static final Transition.TransitionListener doOnStart(@NotNull Transition doOnStart, @NotNull final Function1<? super Transition, Unit> action) {
        Intrinsics.checkNotNullParameter(doOnStart, "$this$doOnStart");
        Intrinsics.checkNotNullParameter(action, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@NotNull Transition transition) {
                Intrinsics.checkNotNullParameter(transition, "transition");
                Function1.this.invoke(transition);
            }
        };
        doOnStart.addListener(transitionListener);
        return transitionListener;
    }
}
