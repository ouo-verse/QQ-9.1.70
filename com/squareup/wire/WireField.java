package com.squareup.wire;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmName;

/* compiled from: P */
@Target({ElementType.FIELD})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0011BB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005R\u000f\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\rR\u000f\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u000f\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000f\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\rR\u000f\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u000eR\u000f\u0010\t\u001a\u00020\n\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000fR\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"Lcom/squareup/wire/WireField;", "", "tag", "", "keyAdapter", "", "adapter", "label", "Lcom/squareup/wire/WireField$Label;", "redacted", "", "declaredName", "jsonName", "()Ljava/lang/String;", "()Lcom/squareup/wire/WireField$Label;", "()Z", "()I", "Label", "wire-runtime"}, k = 1, mv = {1, 4, 0})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
/* loaded from: classes3.dex */
public @interface WireField {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048G\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00048G\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u00048G\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/squareup/wire/WireField$Label;", "", "(Ljava/lang/String;I)V", "isOneOf", "", "()Z", "isPacked", "isRepeated", "REQUIRED", "OPTIONAL", "REPEATED", "ONE_OF", "PACKED", "OMIT_IDENTITY", "wire-runtime"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public enum Label {
        REQUIRED,
        OPTIONAL,
        REPEATED,
        ONE_OF,
        PACKED,
        OMIT_IDENTITY;

        @JvmName(name = "isOneOf")
        public final boolean isOneOf() {
            if (this == ONE_OF) {
                return true;
            }
            return false;
        }

        @JvmName(name = "isPacked")
        public final boolean isPacked() {
            if (this == PACKED) {
                return true;
            }
            return false;
        }

        @JvmName(name = "isRepeated")
        public final boolean isRepeated() {
            if (this != REPEATED && this != PACKED) {
                return false;
            }
            return true;
        }
    }

    String adapter();

    String declaredName() default "";

    String jsonName() default "";

    String keyAdapter() default "";

    Label label() default Label.OPTIONAL;

    boolean redacted() default false;

    int tag();
}
