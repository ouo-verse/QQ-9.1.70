package com.tencent.robot.aio.story;

import android.graphics.drawable.Drawable;
import hn2.q;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/aio/story/a;", "Lol3/b;", "<init>", "()V", "a", "b", "c", "Lcom/tencent/robot/aio/story/a$a;", "Lcom/tencent/robot/aio/story/a$b;", "Lcom/tencent/robot/aio/story/a$c;", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class a implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/aio/story/a$a;", "Lcom/tencent/robot/aio/story/a;", "Lhn2/q;", "d", "Lhn2/q;", "a", "()Lhn2/q;", "binding", "<init>", "(Lhn2/q;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.aio.story.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C9770a extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final q binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9770a(@NotNull q binding) {
            super(null);
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final q getBinding() {
            return this.binding;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\n\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/robot/aio/story/a$b;", "Lcom/tencent/robot/aio/story/a;", "Landroid/graphics/drawable/Drawable;", "d", "Landroid/graphics/drawable/Drawable;", "a", "()Landroid/graphics/drawable/Drawable;", "b", "(Landroid/graphics/drawable/Drawable;)V", "drawable", "<init>", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Drawable drawable;

        public b() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final Drawable getDrawable() {
            return this.drawable;
        }

        public final void b(@Nullable Drawable drawable) {
            this.drawable = drawable;
        }

        public b(@Nullable Drawable drawable) {
            super(null);
            this.drawable = drawable;
        }

        public /* synthetic */ b(Drawable drawable, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : drawable);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/robot/aio/story/a$c;", "Lcom/tencent/robot/aio/story/a;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends a {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final c f367387d = new c();

        c() {
            super(null);
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
