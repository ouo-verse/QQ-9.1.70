package com.tencent.guild.aio.msglist.graytips.common;

import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/common/GuildCommonGrayTipsUIState;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "()V", "SetGrayTipsText", "Lcom/tencent/guild/aio/msglist/graytips/common/GuildCommonGrayTipsUIState$SetGrayTipsText;", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public abstract class GuildCommonGrayTipsUIState implements MviUIState {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/common/GuildCommonGrayTipsUIState$SetGrayTipsText;", "Lcom/tencent/guild/aio/msglist/graytips/common/GuildCommonGrayTipsUIState;", "", "d", "Ljava/lang/CharSequence;", "a", "()Ljava/lang/CharSequence;", "text", "", "e", "Z", "b", "()Z", "isRebuild", "<init>", "(Ljava/lang/CharSequence;Z)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class SetGrayTipsText extends GuildCommonGrayTipsUIState {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CharSequence text;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isRebuild;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SetGrayTipsText(@NotNull CharSequence text, boolean z16) {
            super(null);
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.isRebuild = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final CharSequence getText() {
            return this.text;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsRebuild() {
            return this.isRebuild;
        }
    }

    public /* synthetic */ GuildCommonGrayTipsUIState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    GuildCommonGrayTipsUIState() {
    }
}
