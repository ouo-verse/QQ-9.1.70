package com.tencent.guild.aio.msglist.graytips.special.revoke;

import com.tencent.mvi.base.mvi.MviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/revoke/GuildRevokeGrayTipsUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "SetRevokeText", "Lcom/tencent/guild/aio/msglist/graytips/special/revoke/GuildRevokeGrayTipsUIState$SetRevokeText;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildRevokeGrayTipsUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/special/revoke/GuildRevokeGrayTipsUIState$SetRevokeText;", "Lcom/tencent/guild/aio/msglist/graytips/special/revoke/GuildRevokeGrayTipsUIState;", "", "d", "Ljava/lang/CharSequence;", "b", "()Ljava/lang/CharSequence;", "nickBy", "e", "c", "nickOf", "f", "textTail", "", h.F, "Z", "a", "()Z", "canEdit", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class SetRevokeText extends GuildRevokeGrayTipsUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence nickBy;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence nickOf;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence textTail;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final boolean canEdit;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetRevokeText(@NotNull CharSequence nickBy, @NotNull CharSequence nickOf, @NotNull CharSequence textTail, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(nickBy, "nickBy");
            Intrinsics.checkNotNullParameter(nickOf, "nickOf");
            Intrinsics.checkNotNullParameter(textTail, "textTail");
            this.nickBy = nickBy;
            this.nickOf = nickOf;
            this.textTail = textTail;
            this.canEdit = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getCanEdit() {
            return this.canEdit;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final CharSequence getNickBy() {
            return this.nickBy;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final CharSequence getNickOf() {
            return this.nickOf;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final CharSequence getTextTail() {
            return this.textTail;
        }
    }

    public /* synthetic */ GuildRevokeGrayTipsUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    GuildRevokeGrayTipsUIState() {
    }
}
