package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
@SuppressLint({"RestrictedApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    private static boolean hasSimpleTarget(Transition transition) {
        if (FragmentTransitionImpl.isNullOrEmpty(transition.getTargetIds()) && FragmentTransitionImpl.isNullOrEmpty(transition.getTargetNames()) && FragmentTransitionImpl.isNullOrEmpty(transition.getTargetTypes())) {
            return false;
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void addTargets(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i3 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i3 < transitionCount) {
                addTargets(transitionSet.getTransitionAt(i3), arrayList);
                i3++;
            }
            return;
        }
        if (!hasSimpleTarget(transition) && FragmentTransitionImpl.isNullOrEmpty(transition.getTargets())) {
            int size = arrayList.size();
            while (i3 < size) {
                transition.addTarget(arrayList.get(i3));
                i3++;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public boolean canHandle(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((Transition) obj).mo41clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            if (transition2 != null) {
                transition = transition2;
            } else {
                transition = null;
            }
        }
        if (transition3 != null) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        return transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void removeTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int size;
        Transition transition = (Transition) obj;
        int i3 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i3 < transitionCount) {
                replaceTargets(transitionSet.getTransitionAt(i3), arrayList, arrayList2);
                i3++;
            }
            return;
        }
        if (!hasSimpleTarget(transition)) {
            List<View> targets = transition.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    size = 0;
                } else {
                    size = arrayList2.size();
                }
                while (i3 < size) {
                    transition.addTarget(arrayList2.get(i3));
                    i3++;
                }
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    transition.removeTarget(arrayList.get(size2));
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleHideFragmentView(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new Transition.TransitionListener() { // from class: androidx.transition.FragmentTransitionSupport.2
            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@NonNull Transition transition) {
                transition.removeListener(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((View) arrayList.get(i3)).setVisibility(0);
                }
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionStart(@NonNull Transition transition) {
                transition.removeListener(this);
                transition.addListener(this);
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionCancel(@NonNull Transition transition) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionPause(@NonNull Transition transition) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionResume(@NonNull Transition transition) {
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void scheduleRemoveTargets(Object obj, final Object obj2, final ArrayList<View> arrayList, final Object obj3, final ArrayList<View> arrayList2, final Object obj4, final ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new TransitionListenerAdapter() { // from class: androidx.transition.FragmentTransitionSupport.3
            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@NonNull Transition transition) {
                transition.removeListener(this);
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public void onTransitionStart(@NonNull Transition transition) {
                Object obj5 = obj2;
                if (obj5 != null) {
                    FragmentTransitionSupport.this.replaceTargets(obj5, arrayList, null);
                }
                Object obj6 = obj3;
                if (obj6 != null) {
                    FragmentTransitionSupport.this.replaceTargets(obj6, arrayList2, null);
                }
                Object obj7 = obj4;
                if (obj7 != null) {
                    FragmentTransitionSupport.this.replaceTargets(obj7, arrayList3, null);
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.transition.FragmentTransitionSupport.1
                @Override // androidx.transition.Transition.EpicenterCallback
                public Rect onGetEpicenter(@NonNull Transition transition) {
                    return rect;
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setListenerForTransitionEnd(@NonNull Fragment fragment, @NonNull Object obj, @NonNull CancellationSignal cancellationSignal, @NonNull final Runnable runnable) {
        final Transition transition = (Transition) obj;
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.transition.FragmentTransitionSupport.4
            @Override // androidx.core.os.CancellationSignal.OnCancelListener
            public void onCancel() {
                transition.cancel();
            }
        });
        transition.addListener(new Transition.TransitionListener() { // from class: androidx.transition.FragmentTransitionSupport.5
            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionEnd(@NonNull Transition transition2) {
                runnable.run();
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionCancel(@NonNull Transition transition2) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionPause(@NonNull Transition transition2) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionResume(@NonNull Transition transition2) {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public void onTransitionStart(@NonNull Transition transition2) {
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            FragmentTransitionImpl.bfsAddViewChildren(targets, arrayList.get(i3));
        }
        targets.add(view);
        arrayList.add(view);
        addTargets(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            replaceTargets(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public void setEpicenter(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.transition.FragmentTransitionSupport.6
                @Override // androidx.transition.Transition.EpicenterCallback
                public Rect onGetEpicenter(@NonNull Transition transition) {
                    Rect rect2 = rect;
                    if (rect2 != null && !rect2.isEmpty()) {
                        return rect;
                    }
                    return null;
                }
            });
        }
    }
}
