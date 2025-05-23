package kotlin.reflect.jvm.internal.impl.utils;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SmartList<E> extends AbstractList<E> implements RandomAccess {
    private Object myElem;
    private int mySize;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static class EmptyIterator<T> implements Iterator<T> {
        private static final EmptyIterator INSTANCE = new EmptyIterator();

        EmptyIterator() {
        }

        public static <T> EmptyIterator<T> getInstance() {
            return INSTANCE;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private class SingletonIterator extends SingletonIteratorBase<E> {
        private final int myInitialModCount;

        public SingletonIterator() {
            super();
            this.myInitialModCount = ((AbstractList) SmartList.this).modCount;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        protected void checkCoModification() {
            if (((AbstractList) SmartList.this).modCount == this.myInitialModCount) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) SmartList.this).modCount + "; expected: " + this.myInitialModCount);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.SmartList.SingletonIteratorBase
        protected E getElement() {
            return (E) SmartList.this.myElem;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkCoModification();
            SmartList.this.clear();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    private static abstract class SingletonIteratorBase<T> implements Iterator<T> {
        private boolean myVisited;

        SingletonIteratorBase() {
        }

        protected abstract void checkCoModification();

        protected abstract T getElement();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.myVisited;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (!this.myVisited) {
                this.myVisited = true;
                checkCoModification();
                return getElement();
            }
            throw new NoSuchElementException();
        }
    }

    private static /* synthetic */ void $$$reportNull$$$0(int i3) {
        String str;
        int i16;
        if (i3 != 2 && i3 != 3 && i3 != 5 && i3 != 6 && i3 != 7) {
            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i3 != 2 && i3 != 3 && i3 != 5 && i3 != 6 && i3 != 7) {
            i16 = 3;
        } else {
            i16 = 2;
        }
        Object[] objArr = new Object[i16];
        switch (i3) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = DTParamKey.REPORT_KEY_VISUAL_ELEMENTS;
                break;
        }
        if (i3 != 2 && i3 != 3) {
            if (i3 != 5 && i3 != 6 && i3 != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
            } else {
                objArr[1] = "toArray";
            }
        } else {
            objArr[1] = "iterator";
        }
        switch (i3) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i3 == 2 || i3 == 3 || i3 == 5 || i3 == 6 || i3 == 7) {
            throw new IllegalStateException(format);
        }
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e16) {
        int i3 = this.mySize;
        if (i3 == 0) {
            this.myElem = e16;
        } else if (i3 == 1) {
            this.myElem = new Object[]{this.myElem, e16};
        } else {
            Object[] objArr = (Object[]) this.myElem;
            int length = objArr.length;
            if (i3 >= length) {
                int i16 = ((length * 3) / 2) + 1;
                int i17 = i3 + 1;
                if (i16 < i17) {
                    i16 = i17;
                }
                Object[] objArr2 = new Object[i16];
                this.myElem = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.mySize] = e16;
        }
        this.mySize++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.myElem = null;
        this.mySize = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i3) {
        int i16;
        if (i3 >= 0 && i3 < (i16 = this.mySize)) {
            if (i16 == 1) {
                return (E) this.myElem;
            }
            return (E) ((Object[]) this.myElem)[i3];
        }
        throw new IndexOutOfBoundsException("Index: " + i3 + ", Size: " + this.mySize);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        int i3 = this.mySize;
        if (i3 == 0) {
            EmptyIterator emptyIterator = EmptyIterator.getInstance();
            if (emptyIterator == null) {
                $$$reportNull$$$0(2);
            }
            return emptyIterator;
        }
        if (i3 == 1) {
            return new SingletonIterator();
        }
        Iterator<E> it = super.iterator();
        if (it == null) {
            $$$reportNull$$$0(3);
        }
        return it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i3) {
        int i16;
        E e16;
        if (i3 >= 0 && i3 < (i16 = this.mySize)) {
            if (i16 == 1) {
                e16 = (E) this.myElem;
                this.myElem = null;
            } else {
                Object[] objArr = (Object[]) this.myElem;
                Object obj = objArr[i3];
                if (i16 == 2) {
                    this.myElem = objArr[1 - i3];
                } else {
                    int i17 = (i16 - i3) - 1;
                    if (i17 > 0) {
                        System.arraycopy(objArr, i3 + 1, objArr, i3, i17);
                    }
                    objArr[this.mySize - 1] = null;
                }
                e16 = (E) obj;
            }
            this.mySize--;
            ((AbstractList) this).modCount++;
            return e16;
        }
        throw new IndexOutOfBoundsException("Index: " + i3 + ", Size: " + this.mySize);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i3, E e16) {
        int i16;
        if (i3 >= 0 && i3 < (i16 = this.mySize)) {
            if (i16 == 1) {
                E e17 = (E) this.myElem;
                this.myElem = e16;
                return e17;
            }
            Object[] objArr = (Object[]) this.myElem;
            E e18 = (E) objArr[i3];
            objArr[i3] = e16;
            return e18;
        }
        throw new IndexOutOfBoundsException("Index: " + i3 + ", Size: " + this.mySize);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.mySize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        if (tArr == 0) {
            $$$reportNull$$$0(4);
        }
        int length = tArr.length;
        int i3 = this.mySize;
        if (i3 == 1) {
            if (length != 0) {
                tArr[0] = this.myElem;
            } else {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.myElem;
                return tArr2;
            }
        } else {
            if (length < i3) {
                T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.myElem, i3, tArr.getClass());
                if (tArr3 == null) {
                    $$$reportNull$$$0(6);
                }
                return tArr3;
            }
            if (i3 != 0) {
                System.arraycopy(this.myElem, 0, tArr, 0, i3);
            }
        }
        int i16 = this.mySize;
        if (length > i16) {
            tArr[i16] = 0;
        }
        return tArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i3, E e16) {
        int i16;
        if (i3 >= 0 && i3 <= (i16 = this.mySize)) {
            if (i16 == 0) {
                this.myElem = e16;
            } else if (i16 == 1 && i3 == 0) {
                this.myElem = new Object[]{e16, this.myElem};
            } else {
                Object[] objArr = new Object[i16 + 1];
                if (i16 == 1) {
                    objArr[0] = this.myElem;
                } else {
                    Object[] objArr2 = (Object[]) this.myElem;
                    System.arraycopy(objArr2, 0, objArr, 0, i3);
                    System.arraycopy(objArr2, i3, objArr, i3 + 1, this.mySize - i3);
                }
                objArr[i3] = e16;
                this.myElem = objArr;
            }
            this.mySize++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + i3 + ", Size: " + this.mySize);
    }
}
