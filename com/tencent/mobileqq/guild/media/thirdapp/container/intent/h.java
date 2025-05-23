package com.tencent.mobileqq.guild.media.thirdapp.container.intent;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/h;", "Lol3/b;", "<init>", "()V", "a", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/h$a;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class h implements ol3.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/h$a;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/h;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "a", "()I", "size", "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.intent.h$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class NotifyMiniViewSize extends h {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int size;

        public NotifyMiniViewSize() {
            this(0, 1, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getSize() {
            return this.size;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof NotifyMiniViewSize) && this.size == ((NotifyMiniViewSize) other).size) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.size;
        }

        @NotNull
        public String toString() {
            return "NotifyMiniViewSize(size=" + this.size + ")";
        }

        public NotifyMiniViewSize(int i3) {
            super(null);
            this.size = i3;
        }

        public /* synthetic */ NotifyMiniViewSize(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3);
        }
    }

    public /* synthetic */ h(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    h() {
    }
}
