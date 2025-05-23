package com.tencent.icgame.liveroom.impl.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.icgame.game.component.chat.input.TimiBaseInputView;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/widget/AudienceInputBoxView;", "Lcom/tencent/icgame/liveroom/impl/room/widget/AnchorInputBoxView;", "", "roomId", "", "setRoomId", "e0", "", "b0", "Z", "r0", "()Z", "setForbidExpose", "(Z)V", "forbidExpose", "c0", "J", "curRoomId", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class AudienceInputBoxView extends AnchorInputBoxView {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean forbidExpose;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private long curRoomId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/icgame/liveroom/impl/room/widget/AudienceInputBoxView$a", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView$b;", "", "text", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView;", "timiBaseInputView", "", "b", "a", "", "state", "onStateChanged", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements TimiBaseInputView.b {
        a() {
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void a(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void b(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.icgame.game.component.chat.input.TimiBaseInputView.b
        public void onStateChanged(int state) {
            View sendView;
            View emojiBtn;
            if (AudienceInputBoxView.this.getPreState() == state || AudienceInputBoxView.this.getForbidExpose() || (sendView = AudienceInputBoxView.this.getSendView()) == null || (emojiBtn = AudienceInputBoxView.this.getEmojiBtn()) == null || AudienceInputBoxView.this.curRoomId != l.f116189a.a()) {
                return;
            }
            if (AudienceInputBoxView.this.getPreState() != 1 && state == 1) {
                ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("imp_end", sendView, new LinkedHashMap());
                ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("imp_end", emojiBtn, new LinkedHashMap());
            } else if (AudienceInputBoxView.this.getPreState() == 1 && state != 1) {
                ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("imp", sendView, new LinkedHashMap());
                ((ru0.a) qx0.a.b(ru0.a.class)).reportEvent("imp", emojiBtn, new LinkedHashMap());
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudienceInputBoxView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    @Override // com.tencent.icgame.liveroom.impl.room.widget.AnchorInputBoxView
    public void e0() {
        f(new a());
    }

    /* renamed from: r0, reason: from getter */
    public final boolean getForbidExpose() {
        return this.forbidExpose;
    }

    public final void setForbidExpose(boolean z16) {
        this.forbidExpose = z16;
    }

    public final void setRoomId(long roomId) {
        this.curRoomId = roomId;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudienceInputBoxView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ AudienceInputBoxView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudienceInputBoxView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }
}
