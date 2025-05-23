package com.tencent.mobileqq.icgame.room.input;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import com.tencent.mobileqq.icgame.room.input.TimiBaseInputView;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru0.a;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/input/AudienceInputBoxView;", "Lcom/tencent/mobileqq/icgame/room/input/AnchorInputBoxView;", "", "t0", "", "roomId", "", "setRoomId", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", "r0", "a0", "b0", "Z", "getForbidExpose", "()Z", "setForbidExpose", "(Z)V", "forbidExpose", "c0", "J", "curRoomId", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class AudienceInputBoxView extends AnchorInputBoxView {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean forbidExpose;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private long curRoomId;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudienceInputBoxView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map s0(AudienceInputBoxView this$0, String str) {
        Object obj;
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Pair[] pairArr = new Pair[5];
        String str2 = "1";
        if (this$0.G()) {
            obj = "1";
        } else {
            obj = "0";
        }
        pairArr[0] = TuplesKt.to("icgame_is_at", obj);
        if (!this$0.t0()) {
            str2 = "0";
        }
        pairArr[1] = TuplesKt.to("icgame_is_with_sticker", str2);
        pairArr[2] = TuplesKt.to("icgame_text_content", this$0.p());
        pairArr[3] = TuplesKt.to("zengzhi_moduleid", "em_icgame_inputbar");
        pairArr[4] = TuplesKt.to("icgame_message_coming", "0");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final boolean t0() {
        Editable editableText;
        String obj;
        EditText editText = getEditText();
        if (editText != null && (editableText = editText.getEditableText()) != null && (obj = editableText.toString()) != null) {
            return eu0.a.d(obj);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.icgame.room.input.AnchorInputBoxView
    public void a0() {
        g(new a());
    }

    public void r0(long roomId, @Nullable LiveRoomExtraInfo extraInfo) {
        Map mutableMapOf;
        ConcurrentHashMap<String, String> f16 = xw0.b.f448881a.f(roomId, extraInfo);
        ru0.a aVar = (ru0.a) qx0.a.b(ru0.a.class);
        Intrinsics.checkNotNull(f16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        aVar.b(this, "pg_icgame_audience", f16);
        View sendView = getSendView();
        if (sendView != null) {
            mm4.a b16 = qx0.a.b(ru0.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            a.C11162a.b((ru0.a) b16, sendView, false, "send", "em_icgame_send_message", null, 18, null);
            VideoReport.setEventDynamicParams(sendView, new IDynamicParams() { // from class: com.tencent.mobileqq.icgame.room.input.e
                @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
                public final Map getDynamicParams(String str) {
                    Map s06;
                    s06 = AudienceInputBoxView.s0(AudienceInputBoxView.this, str);
                    return s06;
                }
            });
        }
        View emojiBtn = getEmojiBtn();
        if (emojiBtn != null) {
            mm4.a b17 = qx0.a.b(ru0.a.class);
            Intrinsics.checkNotNullExpressionValue(b17, "getService(ILiveReportService::class.java)");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zengzhi_moduleid", "em_icgame_inputbar"));
            a.C11162a.a((ru0.a) b17, emojiBtn, false, null, "em_icgame_emoji_entrance", mutableMapOf, 6, null);
        }
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/icgame/room/input/AudienceInputBoxView$a", "Lcom/tencent/mobileqq/icgame/room/input/TimiBaseInputView$b;", "", "text", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/mobileqq/icgame/room/input/TimiBaseInputView;", "timiBaseInputView", "", "b", "a", "", "state", "onStateChanged", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements TimiBaseInputView.b {
        a() {
        }

        @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView.b
        public void a(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView.b
        public void b(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
        }

        @Override // com.tencent.mobileqq.icgame.room.input.TimiBaseInputView.b
        public void onStateChanged(int state) {
        }
    }
}
