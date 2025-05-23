package com.tencent.guild.aio.msglist.graytips.common;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/common/b;", "Lol3/b;", "<init>", "()V", "a", "b", "Lcom/tencent/guild/aio/msglist/graytips/common/b$a;", "Lcom/tencent/guild/aio/msglist/graytips/common/b$b;", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public abstract class b implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/common/b$a;", "Lcom/tencent/guild/aio/msglist/graytips/common/b;", "Lcom/tencent/aio/data/msglist/a;", "d", "Lcom/tencent/aio/data/msglist/a;", "c", "()Lcom/tencent/aio/data/msglist/a;", "msgItem", "Landroid/graphics/drawable/Drawable$Callback;", "e", "Landroid/graphics/drawable/Drawable$Callback;", "b", "()Landroid/graphics/drawable/Drawable$Callback;", "drawableCallback", "Landroid/os/Bundle;", "f", "Landroid/os/Bundle;", "a", "()Landroid/os/Bundle;", "bundle", "<init>", "(Lcom/tencent/aio/data/msglist/a;Landroid/graphics/drawable/Drawable$Callback;Landroid/os/Bundle;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.aio.data.msglist.a msgItem;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable.Callback drawableCallback;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Bundle bundle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull Drawable.Callback drawableCallback, @NotNull Bundle bundle) {
            super(null);
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            Intrinsics.checkNotNullParameter(drawableCallback, "drawableCallback");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            this.msgItem = msgItem;
            this.drawableCallback = drawableCallback;
            this.bundle = bundle;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Bundle getBundle() {
            return this.bundle;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final Drawable.Callback getDrawableCallback() {
            return this.drawableCallback;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final com.tencent.aio.data.msglist.a getMsgItem() {
            return this.msgItem;
        }

        public /* synthetic */ a(com.tencent.aio.data.msglist.a aVar, Drawable.Callback callback, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(aVar, callback, (i3 & 4) != 0 ? new Bundle() : bundle);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/common/b$b;", "Lcom/tencent/guild/aio/msglist/graytips/common/b;", "Landroid/graphics/drawable/Drawable$Callback;", "d", "Landroid/graphics/drawable/Drawable$Callback;", "a", "()Landroid/graphics/drawable/Drawable$Callback;", "drawableCallback", "<init>", "(Landroid/graphics/drawable/Drawable$Callback;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.graytips.common.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1196b extends b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable.Callback drawableCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1196b(@NotNull Drawable.Callback drawableCallback) {
            super(null);
            Intrinsics.checkNotNullParameter(drawableCallback, "drawableCallback");
            this.drawableCallback = drawableCallback;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Drawable.Callback getDrawableCallback() {
            return this.drawableCallback;
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
