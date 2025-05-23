package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes.dex */
class FocusStrategy {

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface BoundsAdapter<T> {
        void obtainBounds(T t16, Rect rect);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface CollectionAdapter<T, V> {
        V get(T t16, int i3);

        int size(T t16);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1 = new Rect();
        private final Rect mTemp2 = new Rect();

        SequentialComparator(boolean z16, BoundsAdapter<T> boundsAdapter) {
            this.mIsLayoutRtl = z16;
            this.mAdapter = boundsAdapter;
        }

        @Override // java.util.Comparator
        public int compare(T t16, T t17) {
            Rect rect = this.mTemp1;
            Rect rect2 = this.mTemp2;
            this.mAdapter.obtainBounds(t16, rect);
            this.mAdapter.obtainBounds(t17, rect2);
            int i3 = rect.top;
            int i16 = rect2.top;
            if (i3 < i16) {
                return -1;
            }
            if (i3 > i16) {
                return 1;
            }
            int i17 = rect.left;
            int i18 = rect2.left;
            if (i17 < i18) {
                if (!this.mIsLayoutRtl) {
                    return -1;
                }
                return 1;
            }
            if (i17 > i18) {
                if (this.mIsLayoutRtl) {
                    return -1;
                }
                return 1;
            }
            int i19 = rect.bottom;
            int i26 = rect2.bottom;
            if (i19 < i26) {
                return -1;
            }
            if (i19 > i26) {
                return 1;
            }
            int i27 = rect.right;
            int i28 = rect2.right;
            if (i27 < i28) {
                if (!this.mIsLayoutRtl) {
                    return -1;
                }
                return 1;
            }
            if (i27 > i28) {
                if (this.mIsLayoutRtl) {
                    return -1;
                }
                return 1;
            }
            return 0;
        }
    }

    FocusStrategy() {
    }

    private static boolean beamBeats(int i3, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        boolean beamsOverlap = beamsOverlap(i3, rect, rect2);
        if (beamsOverlap(i3, rect, rect3) || !beamsOverlap) {
            return false;
        }
        if (isToDirectionOf(i3, rect, rect3) && i3 != 17 && i3 != 66 && majorAxisDistance(i3, rect, rect2) >= majorAxisDistanceToFarEdge(i3, rect, rect3)) {
            return false;
        }
        return true;
    }

    private static boolean beamsOverlap(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right >= rect.left && rect2.left <= rect.right) {
                return true;
            }
            return false;
        }
        if (rect2.bottom >= rect.top && rect2.top <= rect.bottom) {
            return true;
        }
        return false;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L l3, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t16, @NonNull Rect rect, int i3) {
        Rect rect2 = new Rect(rect);
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        rect2.offset(0, -(rect.height() + 1));
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    rect2.offset(-(rect.width() + 1), 0);
                }
            } else {
                rect2.offset(0, rect.height() + 1);
            }
        } else {
            rect2.offset(rect.width() + 1, 0);
        }
        int size = collectionAdapter.size(l3);
        Rect rect3 = new Rect();
        T t17 = null;
        for (int i16 = 0; i16 < size; i16++) {
            T t18 = collectionAdapter.get(l3, i16);
            if (t18 != t16) {
                boundsAdapter.obtainBounds(t18, rect3);
                if (isBetterCandidate(i3, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t17 = t18;
                }
            }
        }
        return t17;
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L l3, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t16, int i3, boolean z16, boolean z17) {
        int size = collectionAdapter.size(l3);
        ArrayList arrayList = new ArrayList(size);
        for (int i16 = 0; i16 < size; i16++) {
            arrayList.add(collectionAdapter.get(l3, i16));
        }
        Collections.sort(arrayList, new SequentialComparator(z16, boundsAdapter));
        if (i3 != 1) {
            if (i3 == 2) {
                return (T) getNextFocusable(t16, arrayList, z17);
            }
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
        return (T) getPreviousFocusable(t16, arrayList, z17);
    }

    private static <T> T getNextFocusable(T t16, ArrayList<T> arrayList, boolean z16) {
        int lastIndexOf;
        int size = arrayList.size();
        if (t16 == null) {
            lastIndexOf = -1;
        } else {
            lastIndexOf = arrayList.lastIndexOf(t16);
        }
        int i3 = lastIndexOf + 1;
        if (i3 < size) {
            return arrayList.get(i3);
        }
        if (z16 && size > 0) {
            return arrayList.get(0);
        }
        return null;
    }

    private static <T> T getPreviousFocusable(T t16, ArrayList<T> arrayList, boolean z16) {
        int indexOf;
        int size = arrayList.size();
        if (t16 == null) {
            indexOf = size;
        } else {
            indexOf = arrayList.indexOf(t16);
        }
        int i3 = indexOf - 1;
        if (i3 >= 0) {
            return arrayList.get(i3);
        }
        if (z16 && size > 0) {
            return arrayList.get(size - 1);
        }
        return null;
    }

    private static int getWeightedDistanceFor(int i3, int i16) {
        return (i3 * 13 * i3) + (i16 * i16);
    }

    private static boolean isBetterCandidate(int i3, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        if (!isCandidate(rect, rect2, i3)) {
            return false;
        }
        if (!isCandidate(rect, rect3, i3) || beamBeats(i3, rect, rect2, rect3)) {
            return true;
        }
        if (beamBeats(i3, rect, rect3, rect2) || getWeightedDistanceFor(majorAxisDistance(i3, rect, rect2), minorAxisDistance(i3, rect, rect2)) >= getWeightedDistanceFor(majorAxisDistance(i3, rect, rect3), minorAxisDistance(i3, rect, rect3))) {
            return false;
        }
        return true;
    }

    private static boolean isCandidate(@NonNull Rect rect, @NonNull Rect rect2, int i3) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        int i16 = rect.top;
                        int i17 = rect2.top;
                        if ((i16 < i17 || rect.bottom <= i17) && rect.bottom < rect2.bottom) {
                            return true;
                        }
                        return false;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                int i18 = rect.left;
                int i19 = rect2.left;
                if ((i18 < i19 || rect.right <= i19) && rect.right < rect2.right) {
                    return true;
                }
                return false;
            }
            int i26 = rect.bottom;
            int i27 = rect2.bottom;
            if ((i26 > i27 || rect.top >= i27) && rect.top > rect2.top) {
                return true;
            }
            return false;
        }
        int i28 = rect.right;
        int i29 = rect2.right;
        if ((i28 > i29 || rect.left >= i29) && rect.left > rect2.left) {
            return true;
        }
        return false;
    }

    private static boolean isToDirectionOf(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        if (rect.bottom <= rect2.top) {
                            return true;
                        }
                        return false;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                if (rect.right <= rect2.left) {
                    return true;
                }
                return false;
            }
            if (rect.top >= rect2.bottom) {
                return true;
            }
            return false;
        }
        if (rect.left >= rect2.right) {
            return true;
        }
        return false;
    }

    private static int majorAxisDistance(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(0, majorAxisDistanceRaw(i3, rect, rect2));
    }

    private static int majorAxisDistanceRaw(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        int i16;
        int i17;
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        i16 = rect2.top;
                        i17 = rect.bottom;
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    i16 = rect2.left;
                    i17 = rect.right;
                }
            } else {
                i16 = rect.top;
                i17 = rect2.bottom;
            }
        } else {
            i16 = rect.left;
            i17 = rect2.right;
        }
        return i16 - i17;
    }

    private static int majorAxisDistanceToFarEdge(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(i3, rect, rect2));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        int i16;
        int i17;
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 == 130) {
                        i16 = rect2.bottom;
                        i17 = rect.bottom;
                    } else {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                } else {
                    i16 = rect2.right;
                    i17 = rect.right;
                }
            } else {
                i16 = rect.top;
                i17 = rect2.top;
            }
        } else {
            i16 = rect.left;
            i17 = rect2.left;
        }
        return i16 - i17;
    }

    private static int minorAxisDistance(int i3, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i3 != 17) {
            if (i3 != 33) {
                if (i3 != 66) {
                    if (i3 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}
