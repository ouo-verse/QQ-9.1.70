package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class DiffUtil {
    private static final Comparator<Snake> SNAKE_COMPARATOR = new Comparator<Snake>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(Snake snake, Snake snake2) {
            int i3 = snake.f26482x - snake2.f26482x;
            return i3 == 0 ? snake.f26483y - snake2.f26483y : i3;
        }
    };

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class Callback {
        public abstract boolean areContentsTheSame(int i3, int i16);

        public abstract boolean areItemsTheSame(int i3, int i16);

        @Nullable
        public Object getChangePayload(int i3, int i16) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class DiffResult {
        private static final int FLAG_CHANGED = 2;
        private static final int FLAG_IGNORE = 16;
        private static final int FLAG_MASK = 31;
        private static final int FLAG_MOVED_CHANGED = 4;
        private static final int FLAG_MOVED_NOT_CHANGED = 8;
        private static final int FLAG_NOT_CHANGED = 1;
        private static final int FLAG_OFFSET = 5;
        public static final int NO_POSITION = -1;
        private final Callback mCallback;
        private final boolean mDetectMoves;
        private final int[] mNewItemStatuses;
        private final int mNewListSize;
        private final int[] mOldItemStatuses;
        private final int mOldListSize;
        private final List<Snake> mSnakes;

        DiffResult(Callback callback, List<Snake> list, int[] iArr, int[] iArr2, boolean z16) {
            this.mSnakes = list;
            this.mOldItemStatuses = iArr;
            this.mNewItemStatuses = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.mCallback = callback;
            this.mOldListSize = callback.getOldListSize();
            this.mNewListSize = callback.getNewListSize();
            this.mDetectMoves = z16;
            addRootSnake();
            findMatchingItems();
        }

        private void addRootSnake() {
            Snake snake;
            if (this.mSnakes.isEmpty()) {
                snake = null;
            } else {
                snake = this.mSnakes.get(0);
            }
            if (snake == null || snake.f26482x != 0 || snake.f26483y != 0) {
                Snake snake2 = new Snake();
                snake2.f26482x = 0;
                snake2.f26483y = 0;
                snake2.removal = false;
                snake2.size = 0;
                snake2.reverse = false;
                this.mSnakes.add(0, snake2);
            }
        }

        private void dispatchAdditions(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i3, int i16, int i17) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onInserted(i3, i16);
                return;
            }
            for (int i18 = i16 - 1; i18 >= 0; i18--) {
                int i19 = i17 + i18;
                int i26 = this.mNewItemStatuses[i19];
                int i27 = i26 & 31;
                if (i27 != 0) {
                    if (i27 != 4 && i27 != 8) {
                        if (i27 == 16) {
                            list.add(new PostponedUpdate(i19, i3, false));
                        } else {
                            throw new IllegalStateException("unknown flag for pos " + i19 + " " + Long.toBinaryString(i27));
                        }
                    } else {
                        int i28 = i26 >> 5;
                        listUpdateCallback.onMoved(removePostponedUpdate(list, i28, true).currentPos, i3);
                        if (i27 == 4) {
                            listUpdateCallback.onChanged(i3, 1, this.mCallback.getChangePayload(i28, i19));
                        }
                    }
                } else {
                    listUpdateCallback.onInserted(i3, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().currentPos++;
                    }
                }
            }
        }

        private void dispatchRemovals(List<PostponedUpdate> list, ListUpdateCallback listUpdateCallback, int i3, int i16, int i17) {
            if (!this.mDetectMoves) {
                listUpdateCallback.onRemoved(i3, i16);
                return;
            }
            for (int i18 = i16 - 1; i18 >= 0; i18--) {
                int i19 = i17 + i18;
                int i26 = this.mOldItemStatuses[i19];
                int i27 = i26 & 31;
                if (i27 != 0) {
                    if (i27 != 4 && i27 != 8) {
                        if (i27 == 16) {
                            list.add(new PostponedUpdate(i19, i3 + i18, true));
                        } else {
                            throw new IllegalStateException("unknown flag for pos " + i19 + " " + Long.toBinaryString(i27));
                        }
                    } else {
                        int i28 = i26 >> 5;
                        PostponedUpdate removePostponedUpdate = removePostponedUpdate(list, i28, false);
                        listUpdateCallback.onMoved(i3 + i18, removePostponedUpdate.currentPos - 1);
                        if (i27 == 4) {
                            listUpdateCallback.onChanged(removePostponedUpdate.currentPos - 1, 1, this.mCallback.getChangePayload(i19, i28));
                        }
                    }
                } else {
                    listUpdateCallback.onRemoved(i3 + i18, 1);
                    Iterator<PostponedUpdate> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().currentPos--;
                    }
                }
            }
        }

        private void findAddition(int i3, int i16, int i17) {
            if (this.mOldItemStatuses[i3 - 1] != 0) {
                return;
            }
            findMatchingItem(i3, i16, i17, false);
        }

        private boolean findMatchingItem(int i3, int i16, int i17, boolean z16) {
            int i18;
            int i19;
            if (z16) {
                i16--;
                i19 = i3;
                i18 = i16;
            } else {
                i18 = i3 - 1;
                i19 = i18;
            }
            while (i17 >= 0) {
                Snake snake = this.mSnakes.get(i17);
                int i26 = snake.f26482x;
                int i27 = snake.size;
                int i28 = i26 + i27;
                int i29 = snake.f26483y + i27;
                int i36 = 8;
                if (z16) {
                    for (int i37 = i19 - 1; i37 >= i28; i37--) {
                        if (this.mCallback.areItemsTheSame(i37, i18)) {
                            if (!this.mCallback.areContentsTheSame(i37, i18)) {
                                i36 = 4;
                            }
                            this.mNewItemStatuses[i18] = (i37 << 5) | 16;
                            this.mOldItemStatuses[i37] = (i18 << 5) | i36;
                            return true;
                        }
                    }
                } else {
                    for (int i38 = i16 - 1; i38 >= i29; i38--) {
                        if (this.mCallback.areItemsTheSame(i18, i38)) {
                            if (!this.mCallback.areContentsTheSame(i18, i38)) {
                                i36 = 4;
                            }
                            int i39 = i3 - 1;
                            this.mOldItemStatuses[i39] = (i38 << 5) | 16;
                            this.mNewItemStatuses[i38] = (i39 << 5) | i36;
                            return true;
                        }
                    }
                }
                i19 = snake.f26482x;
                i16 = snake.f26483y;
                i17--;
            }
            return false;
        }

        private void findMatchingItems() {
            int i3;
            int i16 = this.mOldListSize;
            int i17 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i18 = snake.f26482x;
                int i19 = snake.size;
                int i26 = i18 + i19;
                int i27 = snake.f26483y + i19;
                if (this.mDetectMoves) {
                    while (i16 > i26) {
                        findAddition(i16, i17, size);
                        i16--;
                    }
                    while (i17 > i27) {
                        findRemoval(i16, i17, size);
                        i17--;
                    }
                }
                for (int i28 = 0; i28 < snake.size; i28++) {
                    int i29 = snake.f26482x + i28;
                    int i36 = snake.f26483y + i28;
                    if (this.mCallback.areContentsTheSame(i29, i36)) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    this.mOldItemStatuses[i29] = (i36 << 5) | i3;
                    this.mNewItemStatuses[i36] = (i29 << 5) | i3;
                }
                i16 = snake.f26482x;
                i17 = snake.f26483y;
            }
        }

        private void findRemoval(int i3, int i16, int i17) {
            if (this.mNewItemStatuses[i16 - 1] != 0) {
                return;
            }
            findMatchingItem(i3, i16, i17, true);
        }

        private static PostponedUpdate removePostponedUpdate(List<PostponedUpdate> list, int i3, boolean z16) {
            int i16;
            int size = list.size() - 1;
            while (size >= 0) {
                PostponedUpdate postponedUpdate = list.get(size);
                if (postponedUpdate.posInOwnerList == i3 && postponedUpdate.removal == z16) {
                    list.remove(size);
                    while (size < list.size()) {
                        PostponedUpdate postponedUpdate2 = list.get(size);
                        int i17 = postponedUpdate2.currentPos;
                        if (z16) {
                            i16 = 1;
                        } else {
                            i16 = -1;
                        }
                        postponedUpdate2.currentPos = i17 + i16;
                        size++;
                    }
                    return postponedUpdate;
                }
                size--;
            }
            return null;
        }

        public int convertNewPositionToOld(@IntRange(from = 0) int i3) {
            if (i3 >= 0 && i3 < this.mNewListSize) {
                int i16 = this.mNewItemStatuses[i3];
                if ((i16 & 31) == 0) {
                    return -1;
                }
                return i16 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i3 + ", new list size = " + this.mNewListSize);
        }

        public int convertOldPositionToNew(@IntRange(from = 0) int i3) {
            if (i3 >= 0 && i3 < this.mOldListSize) {
                int i16 = this.mOldItemStatuses[i3];
                if ((i16 & 31) == 0) {
                    return -1;
                }
                return i16 >> 5;
            }
            throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + i3 + ", old list size = " + this.mOldListSize);
        }

        public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter adapter) {
            dispatchUpdatesTo(new AdapterListUpdateCallback(adapter));
        }

        @VisibleForTesting
        List<Snake> getSnakes() {
            return this.mSnakes;
        }

        public void dispatchUpdatesTo(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            ArrayList arrayList = new ArrayList();
            int i3 = this.mOldListSize;
            int i16 = this.mNewListSize;
            for (int size = this.mSnakes.size() - 1; size >= 0; size--) {
                Snake snake = this.mSnakes.get(size);
                int i17 = snake.size;
                int i18 = snake.f26482x + i17;
                int i19 = snake.f26483y + i17;
                if (i18 < i3) {
                    dispatchRemovals(arrayList, batchingListUpdateCallback, i18, i3 - i18, i18);
                }
                if (i19 < i16) {
                    dispatchAdditions(arrayList, batchingListUpdateCallback, i18, i16 - i19, i19);
                }
                for (int i26 = i17 - 1; i26 >= 0; i26--) {
                    int[] iArr = this.mOldItemStatuses;
                    int i27 = snake.f26482x;
                    if ((iArr[i27 + i26] & 31) == 2) {
                        batchingListUpdateCallback.onChanged(i27 + i26, 1, this.mCallback.getChangePayload(i27 + i26, snake.f26483y + i26));
                    }
                }
                i3 = snake.f26482x;
                i16 = snake.f26483y;
            }
            batchingListUpdateCallback.dispatchLastEvent();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class ItemCallback<T> {
        public abstract boolean areContentsTheSame(@NonNull T t16, @NonNull T t17);

        public abstract boolean areItemsTheSame(@NonNull T t16, @NonNull T t17);

        @Nullable
        public Object getChangePayload(@NonNull T t16, @NonNull T t17) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class PostponedUpdate {
        int currentPos;
        int posInOwnerList;
        boolean removal;

        public PostponedUpdate(int i3, int i16, boolean z16) {
            this.posInOwnerList = i3;
            this.currentPos = i16;
            this.removal = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Range {
        int newListEnd;
        int newListStart;
        int oldListEnd;
        int oldListStart;

        public Range() {
        }

        public Range(int i3, int i16, int i17, int i18) {
            this.oldListStart = i3;
            this.oldListEnd = i16;
            this.newListStart = i17;
            this.newListEnd = i18;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Snake {
        boolean removal;
        boolean reverse;
        int size;

        /* renamed from: x, reason: collision with root package name */
        int f26482x;

        /* renamed from: y, reason: collision with root package name */
        int f26483y;

        Snake() {
        }
    }

    DiffUtil() {
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback) {
        return calculateDiff(callback, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
    
        if (r24[r13 - 1] < r24[r13 + r5]) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b5, code lost:
    
        if (r25[r12 - 1] < r25[r12 + 1]) goto L50;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de A[LOOP:4: B:54:0x00ca->B:58:0x00de, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00e9 A[EDGE_INSN: B:59:0x00e9->B:60:0x00e9 BREAK  A[LOOP:4: B:54:0x00ca->B:58:0x00de], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Snake diffPartial(Callback callback, int i3, int i16, int i17, int i18, int[] iArr, int[] iArr2, int i19) {
        boolean z16;
        int i26;
        int i27;
        boolean z17;
        int i28;
        int i29;
        int i36;
        boolean z18;
        int i37;
        int i38 = i16 - i3;
        int i39 = i18 - i17;
        int i46 = 1;
        if (i38 >= 1 && i39 >= 1) {
            int i47 = i38 - i39;
            int i48 = ((i38 + i39) + 1) / 2;
            int i49 = (i19 - i48) - 1;
            int i56 = i19 + i48 + 1;
            boolean z19 = false;
            Arrays.fill(iArr, i49, i56, 0);
            Arrays.fill(iArr2, i49 + i47, i56 + i47, i38);
            if (i47 % 2 != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i57 = 0;
            while (i57 <= i48) {
                int i58 = -i57;
                int i59 = i58;
                while (i59 <= i57) {
                    if (i59 != i58) {
                        if (i59 != i57) {
                            int i65 = i19 + i59;
                        }
                        i36 = iArr[(i19 + i59) - i46] + i46;
                        z18 = i46;
                        for (i37 = i36 - i59; i36 < i38 && i37 < i39 && callback.areItemsTheSame(i3 + i36, i17 + i37); i37++) {
                            i36++;
                        }
                        int i66 = i19 + i59;
                        iArr[i66] = i36;
                        if (!z16 && i59 >= (i47 - i57) + 1 && i59 <= (i47 + i57) - 1 && i36 >= iArr2[i66]) {
                            Snake snake = new Snake();
                            int i67 = iArr2[i66];
                            snake.f26482x = i67;
                            snake.f26483y = i67 - i59;
                            snake.size = iArr[i66] - i67;
                            snake.removal = z18;
                            snake.reverse = false;
                            return snake;
                        }
                        i59 += 2;
                        z19 = false;
                        i46 = 1;
                    }
                    i36 = iArr[i19 + i59 + i46];
                    z18 = z19;
                    while (i36 < i38) {
                        i36++;
                    }
                    int i662 = i19 + i59;
                    iArr[i662] = i36;
                    if (!z16) {
                    }
                    i59 += 2;
                    z19 = false;
                    i46 = 1;
                }
                boolean z26 = z19;
                int i68 = i58;
                while (i68 <= i57) {
                    int i69 = i68 + i47;
                    if (i69 != i57 + i47) {
                        if (i69 != i58 + i47) {
                            int i75 = i19 + i69;
                            i26 = 1;
                        } else {
                            i26 = 1;
                        }
                        i27 = iArr2[(i19 + i69) + i26] - i26;
                        z17 = i26;
                        i28 = i27 - i69;
                        while (i27 > 0 && i28 > 0) {
                            i29 = i38;
                            if (callback.areItemsTheSame((i3 + i27) - 1, (i17 + i28) - 1)) {
                                break;
                            }
                            i27--;
                            i28--;
                            i38 = i29;
                        }
                        i29 = i38;
                        int i76 = i19 + i69;
                        iArr2[i76] = i27;
                        if (z16 && i69 >= i58 && i69 <= i57 && iArr[i76] >= i27) {
                            Snake snake2 = new Snake();
                            int i77 = iArr2[i76];
                            snake2.f26482x = i77;
                            snake2.f26483y = i77 - i69;
                            snake2.size = iArr[i76] - i77;
                            snake2.removal = z17;
                            snake2.reverse = true;
                            return snake2;
                        }
                        i68 += 2;
                        i38 = i29;
                        z26 = false;
                    } else {
                        i26 = 1;
                    }
                    i27 = iArr2[(i19 + i69) - i26];
                    z17 = z26;
                    i28 = i27 - i69;
                    while (i27 > 0) {
                        i29 = i38;
                        if (callback.areItemsTheSame((i3 + i27) - 1, (i17 + i28) - 1)) {
                        }
                    }
                    i29 = i38;
                    int i762 = i19 + i69;
                    iArr2[i762] = i27;
                    if (z16) {
                    }
                    i68 += 2;
                    i38 = i29;
                    z26 = false;
                }
                i57++;
                i46 = 1;
                i38 = i38;
                z19 = false;
            }
            throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
        }
        return null;
    }

    @NonNull
    public static DiffResult calculateDiff(@NonNull Callback callback, boolean z16) {
        int oldListSize = callback.getOldListSize();
        int newListSize = callback.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, oldListSize, 0, newListSize));
        int abs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int i3 = abs * 2;
        int[] iArr = new int[i3];
        int[] iArr2 = new int[i3];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake diffPartial = diffPartial(callback, range.oldListStart, range.oldListEnd, range.newListStart, range.newListEnd, iArr, iArr2, abs);
            if (diffPartial != null) {
                if (diffPartial.size > 0) {
                    arrayList.add(diffPartial);
                }
                diffPartial.f26482x += range.oldListStart;
                diffPartial.f26483y += range.newListStart;
                Range range2 = arrayList3.isEmpty() ? new Range() : (Range) arrayList3.remove(arrayList3.size() - 1);
                range2.oldListStart = range.oldListStart;
                range2.newListStart = range.newListStart;
                if (diffPartial.reverse) {
                    range2.oldListEnd = diffPartial.f26482x;
                    range2.newListEnd = diffPartial.f26483y;
                } else if (diffPartial.removal) {
                    range2.oldListEnd = diffPartial.f26482x - 1;
                    range2.newListEnd = diffPartial.f26483y;
                } else {
                    range2.oldListEnd = diffPartial.f26482x;
                    range2.newListEnd = diffPartial.f26483y - 1;
                }
                arrayList2.add(range2);
                if (diffPartial.reverse) {
                    if (diffPartial.removal) {
                        int i16 = diffPartial.f26482x;
                        int i17 = diffPartial.size;
                        range.oldListStart = i16 + i17 + 1;
                        range.newListStart = diffPartial.f26483y + i17;
                    } else {
                        int i18 = diffPartial.f26482x;
                        int i19 = diffPartial.size;
                        range.oldListStart = i18 + i19;
                        range.newListStart = diffPartial.f26483y + i19 + 1;
                    }
                } else {
                    int i26 = diffPartial.f26482x;
                    int i27 = diffPartial.size;
                    range.oldListStart = i26 + i27;
                    range.newListStart = diffPartial.f26483y + i27;
                }
                arrayList2.add(range);
            } else {
                arrayList3.add(range);
            }
        }
        Collections.sort(arrayList, SNAKE_COMPARATOR);
        return new DiffResult(callback, arrayList, iArr, iArr2, z16);
    }
}
