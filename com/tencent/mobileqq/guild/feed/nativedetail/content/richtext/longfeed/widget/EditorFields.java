package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\r\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u000e\u0010\fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0011\u0010\fR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u0018\u0010\u001bR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0019\u001a\u0004\b\u0014\u0010\u001bR\u0019\u0010 \u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/reflect/Field;", "a", "Ljava/lang/reflect/Field;", "()Ljava/lang/reflect/Field;", "editor", "b", "e", "selectionController", "c", "g", "startHandle", "d", "endHandle", "handleDrawable", "Ljava/lang/reflect/Method;", "f", "Ljava/lang/reflect/Method;", tl.h.F, "()Ljava/lang/reflect/Method;", "updateCursorPositionMethod", "showHandlerMethod", "hideHandlerMethod", "i", "updateMagnifierMethod", "<init>", "(Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Field;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class EditorFields {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Field editor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Field selectionController;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Field startHandle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Field endHandle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Field handleDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Method updateCursorPositionMethod;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Method showHandlerMethod;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Method hideHandlerMethod;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Method updateMagnifierMethod;

    public EditorFields(@Nullable Field field, @Nullable Field field2, @Nullable Field field3, @Nullable Field field4, @Nullable Field field5, @Nullable Method method, @Nullable Method method2, @Nullable Method method3, @Nullable Method method4) {
        this.editor = field;
        this.selectionController = field2;
        this.startHandle = field3;
        this.endHandle = field4;
        this.handleDrawable = field5;
        this.updateCursorPositionMethod = method;
        this.showHandlerMethod = method2;
        this.hideHandlerMethod = method3;
        this.updateMagnifierMethod = method4;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Field getEditor() {
        return this.editor;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Field getEndHandle() {
        return this.endHandle;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Field getHandleDrawable() {
        return this.handleDrawable;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Method getHideHandlerMethod() {
        return this.hideHandlerMethod;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final Field getSelectionController() {
        return this.selectionController;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EditorFields)) {
            return false;
        }
        EditorFields editorFields = (EditorFields) other;
        if (Intrinsics.areEqual(this.editor, editorFields.editor) && Intrinsics.areEqual(this.selectionController, editorFields.selectionController) && Intrinsics.areEqual(this.startHandle, editorFields.startHandle) && Intrinsics.areEqual(this.endHandle, editorFields.endHandle) && Intrinsics.areEqual(this.handleDrawable, editorFields.handleDrawable) && Intrinsics.areEqual(this.updateCursorPositionMethod, editorFields.updateCursorPositionMethod) && Intrinsics.areEqual(this.showHandlerMethod, editorFields.showHandlerMethod) && Intrinsics.areEqual(this.hideHandlerMethod, editorFields.hideHandlerMethod) && Intrinsics.areEqual(this.updateMagnifierMethod, editorFields.updateMagnifierMethod)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final Method getShowHandlerMethod() {
        return this.showHandlerMethod;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final Field getStartHandle() {
        return this.startHandle;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final Method getUpdateCursorPositionMethod() {
        return this.updateCursorPositionMethod;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        Field field = this.editor;
        int i3 = 0;
        if (field == null) {
            hashCode = 0;
        } else {
            hashCode = field.hashCode();
        }
        int i16 = hashCode * 31;
        Field field2 = this.selectionController;
        if (field2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = field2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Field field3 = this.startHandle;
        if (field3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = field3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Field field4 = this.endHandle;
        if (field4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = field4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        Field field5 = this.handleDrawable;
        if (field5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = field5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        Method method = this.updateCursorPositionMethod;
        if (method == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = method.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        Method method2 = this.showHandlerMethod;
        if (method2 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = method2.hashCode();
        }
        int i28 = (i27 + hashCode7) * 31;
        Method method3 = this.hideHandlerMethod;
        if (method3 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = method3.hashCode();
        }
        int i29 = (i28 + hashCode8) * 31;
        Method method4 = this.updateMagnifierMethod;
        if (method4 != null) {
            i3 = method4.hashCode();
        }
        return i29 + i3;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final Method getUpdateMagnifierMethod() {
        return this.updateMagnifierMethod;
    }

    @NotNull
    public String toString() {
        return "EditorFields(editor=" + this.editor + ", selectionController=" + this.selectionController + ", startHandle=" + this.startHandle + ", endHandle=" + this.endHandle + ", handleDrawable=" + this.handleDrawable + ", updateCursorPositionMethod=" + this.updateCursorPositionMethod + ", showHandlerMethod=" + this.showHandlerMethod + ", hideHandlerMethod=" + this.hideHandlerMethod + ", updateMagnifierMethod=" + this.updateMagnifierMethod + ")";
    }
}
