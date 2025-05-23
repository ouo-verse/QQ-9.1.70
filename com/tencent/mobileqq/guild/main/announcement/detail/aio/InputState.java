package com.tencent.mobileqq.guild.main.announcement.detail.aio;

import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/InputState;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "()V", "AnnouncementCanceled", "BottomUiState", "Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/InputState$AnnouncementCanceled;", "Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/InputState$BottomUiState;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public abstract class InputState implements InputUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/InputState$AnnouncementCanceled;", "Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/InputState;", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class AnnouncementCanceled extends InputState {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final AnnouncementCanceled f227086d = new AnnouncementCanceled();

        AnnouncementCanceled() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/InputState$BottomUiState;", "Lcom/tencent/mobileqq/guild/main/announcement/detail/aio/InputState;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", "canRemove", "<init>", "(Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class BottomUiState extends InputState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean canRemove;

        public BottomUiState(boolean z16) {
            super(null);
            this.canRemove = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getCanRemove() {
            return this.canRemove;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof BottomUiState) && this.canRemove == ((BottomUiState) other).canRemove) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.canRemove;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "BottomUiState(canRemove=" + this.canRemove + ")";
        }
    }

    public /* synthetic */ InputState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    InputState() {
    }
}
