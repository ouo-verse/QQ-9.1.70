package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.timi.game.component.chat.message.MessageLayout;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomForbiddenSpeechAction;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/ForbiddenSystemMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/CenterMessageView;", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "selfUserId", "", "k", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "forbiddenTv", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ForbiddenSystemMessageItemView extends CenterMessageView {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final TextView forbiddenTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/ForbiddenSystemMessageItemView$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomForbiddenSpeechAction f376455a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ForbiddenSystemMessageItemView f376456b;

        a(YoloRoomOuterClass$YoloRoomForbiddenSpeechAction yoloRoomOuterClass$YoloRoomForbiddenSpeechAction, ForbiddenSystemMessageItemView forbiddenSystemMessageItemView) {
            this.f376455a = yoloRoomOuterClass$YoloRoomForbiddenSpeechAction;
            this.f376456b = forbiddenSystemMessageItemView;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo userInfo) {
            String str;
            String str2;
            if (userInfo != null) {
                str = userInfo.i(this.f376455a.user_id.get());
            } else {
                str = null;
            }
            if (this.f376455a.second.get() != 0) {
                str2 = "\u4e3b\u6301\u4eba\u7981\u8a00" + str + yn4.d.e(this.f376455a.second.get());
            } else {
                str2 = "\u4e3b\u6301\u4eba\u89e3\u9664\u4e86\u5bf9" + str + "\u7684\u7981\u8a00";
            }
            this.f376456b.forbiddenTv.setText(str2);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.utils.l.e("ForbiddenSystemMessageItemView", "getUserInfoFromDBOrNet failed: errorCode == " + errorCode + ",errorMessage == " + errorMessage);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ForbiddenSystemMessageItemView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.CenterMessageView
    public void k(@NotNull com.tencent.timi.game.tim.api.message.a msg2, @Nullable CommonOuterClass$QQUserId selfUserId) {
        YoloRoomOuterClass$YoloRoomForbiddenSpeechAction yoloRoomOuterClass$YoloRoomForbiddenSpeechAction;
        YoloRoomOuterClass$YoloRoomForbiddenSpeechAction yoloRoomOuterClass$YoloRoomForbiddenSpeechAction2;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.k(msg2, selfUserId);
        MessageLayout.a iThemeConfig = getIThemeConfig();
        if (iThemeConfig != null) {
            this.forbiddenTv.setTextColor(iThemeConfig.b());
        }
        YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction = msg2.a().yolo_room_action_msg.yolo_room_action;
        if (yoloRoomOuterClass$YoloRoomAction != null && (yoloRoomOuterClass$YoloRoomForbiddenSpeechAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_forbidden_speech_action) != null && (yoloRoomOuterClass$YoloRoomForbiddenSpeechAction2 = yoloRoomOuterClass$YoloRoomForbiddenSpeechAction.get()) != null) {
            bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = yoloRoomOuterClass$YoloRoomForbiddenSpeechAction2.user_id;
            Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "it.user_id");
            dVar.I3(commonOuterClass$QQUserId, new a(yoloRoomOuterClass$YoloRoomForbiddenSpeechAction2, this));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ForbiddenSystemMessageItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ ForbiddenSystemMessageItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ForbiddenSystemMessageItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        setContentView(R.layout.f169116hu1);
        View findViewById = findViewById(R.id.vdg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.forbiddenTv)");
        TextView textView = (TextView) findViewById;
        this.forbiddenTv = textView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, fh4.b.b(19));
        layoutParams.gravity = 1;
        textView.setLayoutParams(layoutParams);
    }
}
