package com.tencent.icgame.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$YoloRoomRotateMsg;
import com.tencent.icgame.trpc.yes.common.YoloRoomOuterClass$YoloRoomRotateMessage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBStringField;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/icgame/game/component/chat/message/SystemMessageItemView;", "Lcom/tencent/icgame/game/component/chat/message/CenterMessageView;", "Lcom/tencent/icgame/game/tim/api/message/a;", "msg", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "selfUserId", "", "i", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "systemTv", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class SystemMessageItemView extends CenterMessageView {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView systemTv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SystemMessageItemView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    @Override // com.tencent.icgame.game.component.chat.message.CenterMessageView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(@NotNull com.tencent.icgame.game.tim.api.message.a msg2, @Nullable CommonOuterClass$QQUserId selfUserId) {
        String str;
        boolean z16;
        boolean isBlank;
        YoloRoomOuterClass$YoloRoomRotateMessage yoloRoomOuterClass$YoloRoomRotateMessage;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.i(msg2, selfUserId);
        e();
        MessageOuterClass$YoloRoomRotateMsg messageOuterClass$YoloRoomRotateMsg = msg2.a().yolo_room_rotate_msg;
        if (messageOuterClass$YoloRoomRotateMsg != null && (yoloRoomOuterClass$YoloRoomRotateMessage = messageOuterClass$YoloRoomRotateMsg.yolo_room_rotate_message) != null && (pBStringField = yoloRoomOuterClass$YoloRoomRotateMessage.message_tpl) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    this.systemTv.setText("");
                    return;
                } else {
                    this.systemTv.setText(str);
                    return;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SystemMessageItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ SystemMessageItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SystemMessageItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        setContentView(R.layout.fc7);
        View findViewById = findViewById(R.id.f915055c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.system_tv)");
        TextView textView = (TextView) findViewById;
        this.systemTv = textView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = com.tencent.icgame.game.utils.a.a(16);
        layoutParams.rightMargin = com.tencent.icgame.game.utils.a.a(16);
        textView.setLayoutParams(layoutParams);
    }
}
