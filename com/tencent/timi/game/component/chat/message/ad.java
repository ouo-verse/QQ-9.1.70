package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.component.chat.message.MessageLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$TimiEmoMsg;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00052\u00020\u0001:\u0001\u0010B\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u001a\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002R$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/ad;", "", "", "roomType", "", "d", "", "roomId", "c", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QQBrowserActivity.KEY_MSG_TYPE, "Landroid/view/View;", "a", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$b;", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$b;", "getViewProvider", "()Lcom/tencent/timi/game/component/chat/message/MessageLayout$b;", "e", "(Lcom/tencent/timi/game/component/chat/message/MessageLayout$b;)V", "viewProvider", "J", "I", "<init>", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ad {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MessageLayout.b viewProvider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int roomType;

    public ad(@Nullable MessageLayout.b bVar) {
        this.viewProvider = bVar;
        this.roomType = 5;
    }

    @NotNull
    public final View a(@NotNull ViewGroup parent, int msgType) {
        View textMessageItemView;
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (msgType) {
            case 1:
                Context context = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                textMessageItemView = new TextMessageItemView(context, null, 0, 6, null);
                break;
            case 2:
                Context context2 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                textMessageItemView = new SendGiftMessageSelfItemView(context2, null, 0, 6, null);
                break;
            case 3:
                Context context3 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
                textMessageItemView = new SendGiftMessageOtherItemView(context3, null, 0, 6, null);
                break;
            case 4:
            default:
                Context context4 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "parent.context");
                textMessageItemView = new TextMessageItemView(context4, null, 0, 6, null);
                break;
            case 5:
                Context context5 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "parent.context");
                textMessageItemView = new CommonTeamMessageItemView(context5, null, 0, 6, null);
                break;
            case 6:
                Context context6 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context6, "parent.context");
                textMessageItemView = new SmobaCapInfoItemView(context6, null, 0, 6, null);
                break;
            case 7:
                Context context7 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context7, "parent.context");
                textMessageItemView = new ProfileMessageItemView(context7);
                break;
            case 8:
                Context context8 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context8, "parent.context");
                textMessageItemView = new SystemMessageItemView(context8, null, 0, 6, null);
                break;
            case 9:
                Context context9 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context9, "parent.context");
                textMessageItemView = new SmobaLoadSelectItemView(context9, null, 0, 6, null);
                break;
            case 10:
                Context context10 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context10, "parent.context");
                textMessageItemView = new TeamActionMessageItemView(context10, null, 0, 6, null);
                break;
            case 11:
                Context context11 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context11, "parent.context");
                textMessageItemView = new GreetingMessageItemView(context11, null, 0, 6, null);
                break;
            case 12:
                Context context12 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context12, "parent.context");
                textMessageItemView = new ForbiddenSystemMessageItemView(context12, null, 0, 6, null);
                break;
            case 13:
            case 14:
            case 15:
                Context context13 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context13, "parent.context");
                textMessageItemView = new ShareArkMessageItemView(context13, null, 0, 6, null);
                break;
            case 16:
                Context context14 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context14, "parent.context");
                textMessageItemView = new EmoMessageItemView(context14, null, 0, 6, null);
                break;
        }
        textMessageItemView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        return textMessageItemView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x007e, code lost:
    
        if (r0 != 252) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ab, code lost:
    
        if (r9.a().yolo_room_action_msg.yolo_room_action.yolo_room_battle_result_action.game_id.get() == 101) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.type() == 49) {
            com.tencent.timi.game.utils.l.e("MessageViewProvider", String.valueOf(msg2.a().yolo_room_action_msg.yolo_room_action.action_type.get()));
        }
        int type = msg2.type();
        if (type == 70 || type == 1) {
            return 1;
        }
        if (type == 79) {
            return 7;
        }
        if (type == 78) {
            return 5;
        }
        if (type == 49) {
            int i3 = msg2.a().yolo_room_action_msg.yolo_room_action.action_type.get();
            if (i3 != 19) {
                if (i3 != 29) {
                    if (i3 != 108) {
                        if (i3 != 111) {
                            if (i3 != 151) {
                                if (i3 == 153) {
                                    return 1;
                                }
                                if (i3 != 101) {
                                    if (i3 != 102 && i3 != 251) {
                                    }
                                } else {
                                    int i16 = this.roomType;
                                    if (i16 != 1) {
                                        if (i16 == 5) {
                                            if (zf4.c.f452468a.h(msg2)) {
                                                return 1;
                                            }
                                            return 11;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    return 12;
                }
            }
            return 10;
        }
        if (type == 48) {
            return 3;
        }
        if (type == 63) {
            if (msg2.a().yolo_room_rotate_msg.yolo_room_rotate_message.message_type.get() == 1) {
                return 8;
            }
        } else {
            if (type == 84) {
                int i17 = msg2.a().share_ark_msg.card_type.get();
                if (i17 != 1) {
                    if (i17 != 2) {
                        return 15;
                    }
                    return 13;
                }
                return 14;
            }
            if (type == 89) {
                MessageOuterClass$TimiEmoMsg messageOuterClass$TimiEmoMsg = msg2.a().timi_emo_msg;
                Intrinsics.checkNotNullExpressionValue(messageOuterClass$TimiEmoMsg, "msg.content().timi_emo_msg");
                if (xg4.l.b(messageOuterClass$TimiEmoMsg)) {
                    return 16;
                }
            } else {
                if (type == pn4.e.d()) {
                    return 1;
                }
                if (type == pn4.e.e()) {
                    return 9;
                }
                if (type == pn4.e.b() || type == pn4.e.c() || type == pn4.e.a()) {
                    return 1;
                }
            }
        }
        return 4;
    }

    public final void c(long roomId) {
        this.roomId = roomId;
    }

    public final void d(int roomType) {
        this.roomType = roomType;
    }

    public final void e(@Nullable MessageLayout.b bVar) {
        this.viewProvider = bVar;
    }

    public /* synthetic */ ad(MessageLayout.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }
}
