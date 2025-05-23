package org.jf.dexlib2.dexbacked.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nonnull;
import org.jf.dexlib2.dexbacked.DexBackedAnnotation;
import org.jf.dexlib2.dexbacked.DexBackedDexFile;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class AnnotationsDirectory {
    public static final AnnotationsDirectory EMPTY = new AnnotationsDirectory() { // from class: org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.1
        @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory
        @Nonnull
        public Set<? extends DexBackedAnnotation> getClassAnnotations() {
            return ImmutableSet.of();
        }

        @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory
        public int getFieldAnnotationCount() {
            return 0;
        }

        @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory
        @Nonnull
        public AnnotationIterator getFieldAnnotationIterator() {
            return AnnotationIterator.EMPTY;
        }

        @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory
        @Nonnull
        public AnnotationIterator getMethodAnnotationIterator() {
            return AnnotationIterator.EMPTY;
        }

        @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory
        @Nonnull
        public AnnotationIterator getParameterAnnotationIterator() {
            return AnnotationIterator.EMPTY;
        }
    };

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface AnnotationIterator {
        public static final AnnotationIterator EMPTY = new AnnotationIterator() { // from class: org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.AnnotationIterator.1
            @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.AnnotationIterator
            public int seekTo(int i3) {
                return 0;
            }

            @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.AnnotationIterator
            public void reset() {
            }
        };

        void reset();

        int seekTo(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class AnnotationsDirectoryImpl extends AnnotationsDirectory {
        private static final int ANNOTATIONS_START_OFFSET = 16;
        private static final int FIELD_ANNOTATION_SIZE = 8;
        private static final int FIELD_COUNT_OFFSET = 4;
        private static final int METHOD_ANNOTATION_SIZE = 8;
        private static final int METHOD_COUNT_OFFSET = 8;
        private static final int PARAMETER_COUNT_OFFSET = 12;

        @Nonnull
        public final DexBackedDexFile dexFile;
        private final int directoryOffset;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        private class AnnotationIteratorImpl implements AnnotationIterator {
            private int currentIndex = 0;
            private int currentItemIndex;
            private final int size;
            private final int startOffset;

            public AnnotationIteratorImpl(int i3, int i16) {
                this.startOffset = i3;
                this.size = i16;
                this.currentItemIndex = AnnotationsDirectoryImpl.this.dexFile.getDataBuffer().readSmallUint(i3);
            }

            @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.AnnotationIterator
            public void reset() {
                this.currentItemIndex = AnnotationsDirectoryImpl.this.dexFile.getDataBuffer().readSmallUint(this.startOffset);
                this.currentIndex = 0;
            }

            @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.AnnotationIterator
            public int seekTo(int i3) {
                int i16;
                while (true) {
                    i16 = this.currentItemIndex;
                    if (i16 >= i3) {
                        break;
                    }
                    int i17 = this.currentIndex;
                    if (i17 + 1 >= this.size) {
                        break;
                    }
                    this.currentIndex = i17 + 1;
                    this.currentItemIndex = AnnotationsDirectoryImpl.this.dexFile.getDataBuffer().readSmallUint(this.startOffset + (this.currentIndex * 8));
                }
                if (i16 == i3) {
                    return AnnotationsDirectoryImpl.this.dexFile.getDataBuffer().readSmallUint(this.startOffset + (this.currentIndex * 8) + 4);
                }
                return 0;
            }
        }

        public AnnotationsDirectoryImpl(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
            this.dexFile = dexBackedDexFile;
            this.directoryOffset = i3;
        }

        @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory
        @Nonnull
        public Set<? extends DexBackedAnnotation> getClassAnnotations() {
            DexBackedDexFile dexBackedDexFile = this.dexFile;
            return AnnotationsDirectory.getAnnotations(dexBackedDexFile, dexBackedDexFile.getDataBuffer().readSmallUint(this.directoryOffset));
        }

        @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory
        public int getFieldAnnotationCount() {
            return this.dexFile.getDataBuffer().readSmallUint(this.directoryOffset + 4);
        }

        @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory
        @Nonnull
        public AnnotationIterator getFieldAnnotationIterator() {
            int fieldAnnotationCount = getFieldAnnotationCount();
            if (fieldAnnotationCount == 0) {
                return AnnotationIterator.EMPTY;
            }
            return new AnnotationIteratorImpl(this.directoryOffset + 16, fieldAnnotationCount);
        }

        public int getMethodAnnotationCount() {
            return this.dexFile.getDataBuffer().readSmallUint(this.directoryOffset + 8);
        }

        @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory
        @Nonnull
        public AnnotationIterator getMethodAnnotationIterator() {
            int methodAnnotationCount = getMethodAnnotationCount();
            if (methodAnnotationCount == 0) {
                return AnnotationIterator.EMPTY;
            }
            return new AnnotationIteratorImpl(this.directoryOffset + 16 + (getFieldAnnotationCount() * 8), methodAnnotationCount);
        }

        public int getParameterAnnotationCount() {
            return this.dexFile.getDataBuffer().readSmallUint(this.directoryOffset + 12);
        }

        @Override // org.jf.dexlib2.dexbacked.util.AnnotationsDirectory
        @Nonnull
        public AnnotationIterator getParameterAnnotationIterator() {
            int parameterAnnotationCount = getParameterAnnotationCount();
            if (parameterAnnotationCount == 0) {
                return AnnotationIterator.EMPTY;
            }
            return new AnnotationIteratorImpl(this.directoryOffset + 16 + (getFieldAnnotationCount() * 8) + (getMethodAnnotationCount() * 8), parameterAnnotationCount);
        }
    }

    @Nonnull
    public static Set<? extends DexBackedAnnotation> getAnnotations(@Nonnull final DexBackedDexFile dexBackedDexFile, final int i3) {
        if (i3 != 0) {
            final int readSmallUint = dexBackedDexFile.getDataBuffer().readSmallUint(i3);
            return new FixedSizeSet<DexBackedAnnotation>() { // from class: org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.2
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return readSmallUint;
                }

                @Override // org.jf.dexlib2.dexbacked.util.FixedSizeSet
                @Nonnull
                public DexBackedAnnotation readItem(int i16) {
                    return new DexBackedAnnotation(DexBackedDexFile.this, DexBackedDexFile.this.getDataBuffer().readSmallUint(i3 + 4 + (i16 * 4)));
                }
            };
        }
        return ImmutableSet.of();
    }

    @Nonnull
    public static List<Set<? extends DexBackedAnnotation>> getParameterAnnotations(@Nonnull final DexBackedDexFile dexBackedDexFile, final int i3) {
        if (i3 > 0) {
            final int readSmallUint = dexBackedDexFile.getDataBuffer().readSmallUint(i3);
            return new FixedSizeList<Set<? extends DexBackedAnnotation>>() { // from class: org.jf.dexlib2.dexbacked.util.AnnotationsDirectory.3
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return readSmallUint;
                }

                @Override // org.jf.dexlib2.dexbacked.util.FixedSizeList
                @Nonnull
                public Set<? extends DexBackedAnnotation> readItem(int i16) {
                    return AnnotationsDirectory.getAnnotations(DexBackedDexFile.this, DexBackedDexFile.this.getDataBuffer().readSmallUint(i3 + 4 + (i16 * 4)));
                }
            };
        }
        return ImmutableList.of();
    }

    @Nonnull
    public static AnnotationsDirectory newOrEmpty(@Nonnull DexBackedDexFile dexBackedDexFile, int i3) {
        if (i3 == 0) {
            return EMPTY;
        }
        return new AnnotationsDirectoryImpl(dexBackedDexFile, i3);
    }

    @Nonnull
    public abstract Set<? extends DexBackedAnnotation> getClassAnnotations();

    public abstract int getFieldAnnotationCount();

    @Nonnull
    public abstract AnnotationIterator getFieldAnnotationIterator();

    @Nonnull
    public abstract AnnotationIterator getMethodAnnotationIterator();

    @Nonnull
    public abstract AnnotationIterator getParameterAnnotationIterator();
}
