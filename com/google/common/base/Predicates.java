package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class Predicates {
    @GwtCompatible(serializable = true)
    public static <T> k<T> a() {
        return ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    /* loaded from: classes2.dex */
    enum ObjectPredicate implements k<Object> {
        ALWAYS_TRUE { // from class: com.google.common.base.Predicates.ObjectPredicate.1
            @Override // com.google.common.base.Predicates.ObjectPredicate, com.google.common.base.k
            public boolean apply(@NullableDecl Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE { // from class: com.google.common.base.Predicates.ObjectPredicate.2
            @Override // com.google.common.base.Predicates.ObjectPredicate, com.google.common.base.k
            public boolean apply(@NullableDecl Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.3
            @Override // com.google.common.base.Predicates.ObjectPredicate, com.google.common.base.k
            public boolean apply(@NullableDecl Object obj) {
                if (obj == null) {
                    return true;
                }
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.4
            @Override // com.google.common.base.Predicates.ObjectPredicate, com.google.common.base.k
            public boolean apply(@NullableDecl Object obj) {
                if (obj != null) {
                    return true;
                }
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        @Override // com.google.common.base.k
        @CanIgnoreReturnValue
        public abstract /* synthetic */ boolean apply(@NullableDecl Object obj);

        <T> k<T> withNarrowedType() {
            return this;
        }
    }
}
