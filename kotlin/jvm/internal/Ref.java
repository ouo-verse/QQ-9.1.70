package kotlin.jvm.internal;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class Ref {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class BooleanRef implements Serializable {
        public boolean element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ByteRef implements Serializable {
        public byte element;

        public String toString() {
            return String.valueOf((int) this.element);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class CharRef implements Serializable {
        public char element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class DoubleRef implements Serializable {
        public double element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class FloatRef implements Serializable {
        public float element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class IntRef implements Serializable {
        public int element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class LongRef implements Serializable {
        public long element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ObjectRef<T> implements Serializable {
        public T element;

        public String toString() {
            return String.valueOf(this.element);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class ShortRef implements Serializable {
        public short element;

        public String toString() {
            return String.valueOf((int) this.element);
        }
    }

    Ref() {
    }
}
