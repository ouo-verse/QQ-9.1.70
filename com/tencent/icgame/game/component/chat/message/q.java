package com.tencent.icgame.game.component.chat.message;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.icgame.game.component.chat.message.MessageLayout;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \b2\u00020\u0001:\u0001\u0010B\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u001a\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/icgame/game/component/chat/message/q;", "", "", "roomType", "", "d", "", "roomId", "c", "Lcom/tencent/icgame/game/tim/api/message/a;", "msg", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, QQBrowserActivity.KEY_MSG_TYPE, "Landroid/view/View;", "a", "J", "I", "Lcom/tencent/icgame/game/component/chat/message/MessageLayout$b;", "viewProvider", "Lcom/tencent/icgame/game/component/chat/message/MessageLayout$b;", "getViewProvider", "()Lcom/tencent/icgame/game/component/chat/message/MessageLayout$b;", "e", "(Lcom/tencent/icgame/game/component/chat/message/MessageLayout$b;)V", "<init>", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int roomType;

    public q(@Nullable MessageLayout.b bVar) {
        this.roomType = 5;
    }

    @NotNull
    public final View a(@NotNull ViewGroup parent, int msgType) {
        View textMessageItemView;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (msgType != 1) {
            if (msgType != 2) {
                if (msgType != 3) {
                    if (msgType != 8) {
                        if (msgType != 12) {
                            Context context = parent.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
                            textMessageItemView = new TextMessageItemView(context, null, 0, 6, null);
                        } else {
                            Context context2 = parent.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                            textMessageItemView = new ForbiddenSystemMessageItemView(context2, null, 0, 6, null);
                        }
                    } else {
                        Context context3 = parent.getContext();
                        Intrinsics.checkNotNullExpressionValue(context3, "parent.context");
                        textMessageItemView = new SystemMessageItemView(context3, null, 0, 6, null);
                    }
                } else {
                    Context context4 = parent.getContext();
                    Intrinsics.checkNotNullExpressionValue(context4, "parent.context");
                    textMessageItemView = new SendGiftMessageOtherItemView(context4, null, 0, 6, null);
                }
            } else {
                Context context5 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "parent.context");
                textMessageItemView = new SendGiftMessageSelfItemView(context5, null, 0, 6, null);
            }
        } else {
            Context context6 = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context6, "parent.context");
            textMessageItemView = new TextMessageItemView(context6, null, 0, 6, null);
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
    public final int b(@NotNull com.tencent.icgame.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.type() == 49) {
            com.tencent.icgame.game.utils.g.d("ICGameMessageViewProvider", String.valueOf(msg2.a().yolo_room_action_msg.yolo_room_action.action_type.get()));
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
                                            if (eu0.c.f397132a.b(msg2)) {
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
            if (type == xx0.e.d()) {
                return 1;
            }
            if (type == xx0.e.e()) {
                return 9;
            }
            if (type == xx0.e.b() || type == xx0.e.c() || type == xx0.e.a()) {
                return 1;
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

    public /* synthetic */ q(MessageLayout.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }

    public final void e(@Nullable MessageLayout.b bVar) {
    }
}
