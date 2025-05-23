package com.tencent.mobileqq.wink.editor.subtitle;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/k;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/mobileqq/wink/editor/subtitle/k$a;", "Lcom/tencent/mobileqq/wink/editor/subtitle/k$b;", "Lcom/tencent/mobileqq/wink/editor/subtitle/k$c;", "Lcom/tencent/mobileqq/wink/editor/subtitle/k$d;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class k {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/k$a;", "Lcom/tencent/mobileqq/wink/editor/subtitle/k;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", "index", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "origContent", "c", "curContent", "newContent", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.subtitle.k$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class BreakLine extends k {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int index;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String origContent;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String curContent;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String newContent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BreakLine(int i3, @NotNull String origContent, @NotNull String curContent, @NotNull String newContent) {
            super(null);
            Intrinsics.checkNotNullParameter(origContent, "origContent");
            Intrinsics.checkNotNullParameter(curContent, "curContent");
            Intrinsics.checkNotNullParameter(newContent, "newContent");
            this.index = i3;
            this.origContent = origContent;
            this.curContent = curContent;
            this.newContent = newContent;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getCurContent() {
            return this.curContent;
        }

        /* renamed from: b, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getNewContent() {
            return this.newContent;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getOrigContent() {
            return this.origContent;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BreakLine)) {
                return false;
            }
            BreakLine breakLine = (BreakLine) other;
            if (this.index == breakLine.index && Intrinsics.areEqual(this.origContent, breakLine.origContent) && Intrinsics.areEqual(this.curContent, breakLine.curContent) && Intrinsics.areEqual(this.newContent, breakLine.newContent)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.index * 31) + this.origContent.hashCode()) * 31) + this.curContent.hashCode()) * 31) + this.newContent.hashCode();
        }

        @NotNull
        public String toString() {
            return "BreakLine(index=" + this.index + ", origContent=" + this.origContent + ", curContent=" + this.curContent + ", newContent=" + this.newContent + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/k$b;", "Lcom/tencent/mobileqq/wink/editor/subtitle/k;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", "index", "<init>", "(I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.subtitle.k$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class Click extends k {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int index;

        public Click(int i3) {
            super(null);
            this.index = i3;
        }

        /* renamed from: a, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof Click) && this.index == ((Click) other).index) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.index;
        }

        @NotNull
        public String toString() {
            return "Click(index=" + this.index + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/k$c;", "Lcom/tencent/mobileqq/wink/editor/subtitle/k;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", "index", "Ljava/lang/String;", "()Ljava/lang/String;", "content", "<init>", "(ILjava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.subtitle.k$c, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class Edit extends k {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int index;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Edit(int i3, @NotNull String content) {
            super(null);
            Intrinsics.checkNotNullParameter(content, "content");
            this.index = i3;
            this.content = content;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: b, reason: from getter */
        public final int getIndex() {
            return this.index;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Edit)) {
                return false;
            }
            Edit edit = (Edit) other;
            if (this.index == edit.index && Intrinsics.areEqual(this.content, edit.content)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.index * 31) + this.content.hashCode();
        }

        @NotNull
        public String toString() {
            return "Edit(index=" + this.index + ", content=" + this.content + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/k$d;", "Lcom/tencent/mobileqq/wink/editor/subtitle/k;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends k {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final d f322199a = new d();

        d() {
            super(null);
        }
    }

    public /* synthetic */ k(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    k() {
    }
}
