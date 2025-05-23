package com.tencent.timi.game.component.chat;

import android.graphics.Color;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.timi.game.component.chat.message.MessageLayout;
import fm4.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigRoomChat;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigRoomChatMsg;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/timi/game/component/chat/a;", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$b;", "", "colorStr", "", "default", "d", "Lcom/tencent/timi/game/tim/api/message/a;", "iMsg", "Ltrpc/yes/common/YesGameInfoOuterClass$GameConfigRoomChat;", DownloadInfo.spKey_Config, "Ltrpc/yes/common/YesGameInfoOuterClass$GameConfigRoomChatMsg;", "e", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;", "a", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "getRoomInfo", "()Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "b", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;", "getImConfig", "()Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;", "setImConfig", "(Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;)V", "imConfig", "<init>", "(Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a implements MessageLayout.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final YoloRoomOuterClass$YoloRoomInfo roomInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MessageLayout.a imConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"com/tencent/timi/game/component/chat/a$a", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$a;", "", "c", "b", "a", "Lcom/tencent/timi/game/tim/api/message/a;", "iMsg", "d", "f", "e", h.F, "g", "I", "getDefaultTextColor", "()I", "defaultTextColor", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.component.chat.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9922a implements MessageLayout.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int defaultTextColor = Color.parseColor("#93939D");

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ YesGameInfoOuterClass$GameConfigRoomChat f376344c;

        C9922a(YesGameInfoOuterClass$GameConfigRoomChat yesGameInfoOuterClass$GameConfigRoomChat) {
            this.f376344c = yesGameInfoOuterClass$GameConfigRoomChat;
        }

        @Override // com.tencent.timi.game.component.chat.message.MessageLayout.a
        public int a() {
            return a.this.d(this.f376344c.text_stress_hue.get(), this.defaultTextColor);
        }

        @Override // com.tencent.timi.game.component.chat.message.MessageLayout.a
        public int b() {
            return a.this.d(this.f376344c.text_weak_hue.get(), this.defaultTextColor);
        }

        @Override // com.tencent.timi.game.component.chat.message.MessageLayout.a
        public int c() {
            return a.this.d(this.f376344c.text_normal_hue.get(), this.defaultTextColor);
        }

        @Override // com.tencent.timi.game.component.chat.message.MessageLayout.a
        public int d(@NotNull com.tencent.timi.game.tim.api.message.a iMsg) {
            String str;
            Intrinsics.checkNotNullParameter(iMsg, "iMsg");
            a aVar = a.this;
            YesGameInfoOuterClass$GameConfigRoomChat chatConfig = this.f376344c;
            Intrinsics.checkNotNullExpressionValue(chatConfig, "chatConfig");
            String str2 = aVar.e(iMsg, chatConfig).bubble_hue.get();
            if (iMsg.b()) {
                str = "#FD942F";
            } else {
                str = "#FFFFFF";
            }
            return aVar.d(str2, Color.parseColor(str));
        }

        @Override // com.tencent.timi.game.component.chat.message.MessageLayout.a
        public int e(@NotNull com.tencent.timi.game.tim.api.message.a iMsg) {
            int i3;
            Intrinsics.checkNotNullParameter(iMsg, "iMsg");
            a aVar = a.this;
            YesGameInfoOuterClass$GameConfigRoomChat chatConfig = this.f376344c;
            Intrinsics.checkNotNullExpressionValue(chatConfig, "chatConfig");
            String str = aVar.e(iMsg, chatConfig).at_text_hue.get();
            if (iMsg.b()) {
                i3 = R.color.f158017al3;
            } else {
                i3 = R.color.f157985cu1;
            }
            return aVar.d(str, yn4.c.a(i3));
        }

        @Override // com.tencent.timi.game.component.chat.message.MessageLayout.a
        public int f(@NotNull com.tencent.timi.game.tim.api.message.a iMsg) {
            Intrinsics.checkNotNullParameter(iMsg, "iMsg");
            a aVar = a.this;
            YesGameInfoOuterClass$GameConfigRoomChat chatConfig = this.f376344c;
            Intrinsics.checkNotNullExpressionValue(chatConfig, "chatConfig");
            return aVar.d(aVar.e(iMsg, chatConfig).bubble_text_hue.get(), Color.parseColor("#6B6F7C"));
        }

        @Override // com.tencent.timi.game.component.chat.message.MessageLayout.a
        public int g(@NotNull com.tencent.timi.game.tim.api.message.a iMsg) {
            Intrinsics.checkNotNullParameter(iMsg, "iMsg");
            a aVar = a.this;
            YesGameInfoOuterClass$GameConfigRoomChat chatConfig = this.f376344c;
            Intrinsics.checkNotNullExpressionValue(chatConfig, "chatConfig");
            return aVar.d(aVar.e(iMsg, chatConfig).role_nick_text_hue.get(), Color.parseColor("#6B6F7C"));
        }

        @Override // com.tencent.timi.game.component.chat.message.MessageLayout.a
        public int h(@NotNull com.tencent.timi.game.tim.api.message.a iMsg) {
            Intrinsics.checkNotNullParameter(iMsg, "iMsg");
            a aVar = a.this;
            YesGameInfoOuterClass$GameConfigRoomChat chatConfig = this.f376344c;
            Intrinsics.checkNotNullExpressionValue(chatConfig, "chatConfig");
            return aVar.d(aVar.e(iMsg, chatConfig).nick_text_hue.get(), Color.parseColor("#6B6F7C"));
        }
    }

    public a(@NotNull YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        this.roomInfo = roomInfo;
        YesGameInfoOuterClass$GameConfigInfo l16 = ((ag4.h) mm4.b.b(ag4.h.class)).l1(((g) mm4.b.b(g.class)).t2(roomInfo));
        Intrinsics.checkNotNullExpressionValue(l16, "getService(IGameConfigSe\u2026getGameConfigInfo(gameId)");
        this.imConfig = new C9922a(l16.room_info.chat_info.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x000e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int d(String colorStr, int r36) {
        boolean z16;
        boolean isBlank;
        if (colorStr != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(colorStr);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return r36;
                }
                try {
                    return Color.parseColor(colorStr);
                } catch (Exception unused) {
                    return r36;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final YesGameInfoOuterClass$GameConfigRoomChatMsg e(com.tencent.timi.game.tim.api.message.a iMsg, YesGameInfoOuterClass$GameConfigRoomChat config) {
        if (iMsg.b()) {
            YesGameInfoOuterClass$GameConfigRoomChatMsg yesGameInfoOuterClass$GameConfigRoomChatMsg = config.send_msg.get();
            Intrinsics.checkNotNullExpressionValue(yesGameInfoOuterClass$GameConfigRoomChatMsg, "config.send_msg.get()");
            return yesGameInfoOuterClass$GameConfigRoomChatMsg;
        }
        YesGameInfoOuterClass$GameConfigRoomChatMsg yesGameInfoOuterClass$GameConfigRoomChatMsg2 = config.recv_msg.get();
        Intrinsics.checkNotNullExpressionValue(yesGameInfoOuterClass$GameConfigRoomChatMsg2, "config.recv_msg.get()");
        return yesGameInfoOuterClass$GameConfigRoomChatMsg2;
    }

    @Override // com.tencent.timi.game.component.chat.message.MessageLayout.b
    @Nullable
    /* renamed from: a, reason: from getter */
    public MessageLayout.a getImConfig() {
        return this.imConfig;
    }
}
