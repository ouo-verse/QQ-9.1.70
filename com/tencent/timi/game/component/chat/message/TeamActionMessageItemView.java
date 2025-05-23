package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0014R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/TeamActionMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/CenterMessageView;", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", "o", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "suffix", "p", "nick", DomainData.DOMAIN_NAME, "selfUserId", "k", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "actionTv", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class TeamActionMessageItemView extends CenterMessageView {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final TextView actionTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/TeamActionMessageItemView$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "from", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IResultListener<IUserInfo> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f376560b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f376561c;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/TeamActionMessageItemView$a$a", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "to", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.timi.game.component.chat.message.TeamActionMessageItemView$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C9924a implements IResultListener<IUserInfo> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ TeamActionMessageItemView f376562a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ CommonOuterClass$QQUserId f376563b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f376564c;

            C9924a(TeamActionMessageItemView teamActionMessageItemView, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str) {
                this.f376562a = teamActionMessageItemView;
                this.f376563b = commonOuterClass$QQUserId;
                this.f376564c = str;
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(@Nullable IUserInfo to5) {
                String str;
                int parseColor;
                TeamActionMessageItemView teamActionMessageItemView = this.f376562a;
                if (to5 != null) {
                    str = to5.i(this.f376563b);
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "--";
                }
                String n3 = teamActionMessageItemView.n(str);
                TextView textView = this.f376562a.actionTv;
                SpannableString spannableString = new SpannableString("\u961f\u957f " + this.f376564c + " \u5df2\u79bb\u5f00\u961f\u4f0d\uff0c\u5df2\u8f6c\u79fb\u7ed9 " + n3);
                MessageLayout.a iThemeConfig = this.f376562a.getIThemeConfig();
                if (iThemeConfig != null) {
                    parseColor = iThemeConfig.a();
                } else {
                    parseColor = Color.parseColor("#4D94FF");
                }
                spannableString.setSpan(new ForegroundColorSpan(parseColor), spannableString.length() - n3.length(), spannableString.length(), 18);
                textView.setText(spannableString);
            }

            @Override // com.tencent.timi.game.utils.IResultListener
            public void onError(int errorCode, @Nullable String errorMessage) {
                this.f376562a.actionTv.setText(this.f376564c + " \u5df2\u79bb\u5f00\u961f\u4f0d\uff0c\u5df2\u8f6c\u79fb\u7ed9 --");
            }
        }

        a(CommonOuterClass$QQUserId commonOuterClass$QQUserId, CommonOuterClass$QQUserId commonOuterClass$QQUserId2) {
            this.f376560b = commonOuterClass$QQUserId;
            this.f376561c = commonOuterClass$QQUserId2;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo from) {
            String str;
            TeamActionMessageItemView teamActionMessageItemView = TeamActionMessageItemView.this;
            if (from != null) {
                str = from.i(this.f376560b);
            } else {
                str = null;
            }
            if (str == null) {
                str = "--";
            }
            String n3 = teamActionMessageItemView.n(str);
            bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
            CommonOuterClass$QQUserId toUserId = this.f376561c;
            Intrinsics.checkNotNullExpressionValue(toUserId, "toUserId");
            dVar.I3(toUserId, new C9924a(TeamActionMessageItemView.this, this.f376561c, n3));
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            TeamActionMessageItemView.this.actionTv.setText("\u961f\u957f -- \u5df2\u79bb\u5f00\u961f\u4f0d\uff0c\u5df2\u8f6c\u79fb\u7ed9 --");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/TeamActionMessageItemView$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<IUserInfo> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f376566b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f376567c;

        b(CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str) {
            this.f376566b = commonOuterClass$QQUserId;
            this.f376567c = str;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo result) {
            String str;
            TeamActionMessageItemView teamActionMessageItemView = TeamActionMessageItemView.this;
            if (result != null) {
                str = result.i(this.f376566b);
            } else {
                str = null;
            }
            if (str == null) {
                str = "--";
            }
            String n3 = teamActionMessageItemView.n(str);
            TeamActionMessageItemView.this.actionTv.setText(n3 + " " + this.f376567c);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            TeamActionMessageItemView.this.actionTv.setText("-- " + this.f376567c);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamActionMessageItemView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n(String nick) {
        if (nick.length() > 8) {
            String substring = nick.substring(0, 6);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        return nick;
    }

    private final void o(com.tencent.timi.game.tim.api.message.a msg2) {
        CommonOuterClass$QQUserId fromUserId;
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction = msg2.a().yolo_room_action_msg.yolo_room_action;
        MessageLayout.a iThemeConfig = getIThemeConfig();
        if (iThemeConfig != null) {
            this.actionTv.setTextColor(iThemeConfig.b());
        }
        int i3 = yoloRoomOuterClass$YoloRoomAction.action_type.get();
        if (i3 != 19) {
            if (i3 != 108) {
                if (i3 != 151 && i3 != 251) {
                    if (i3 != 101) {
                        if (i3 != 102) {
                            this.actionTv.setText(msg2.g());
                            return;
                        }
                        CommonOuterClass$QQUserId commonOuterClass$QQUserId2 = yoloRoomOuterClass$YoloRoomAction.yolo_room_leave_action.user_id;
                        Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId2, "action.yolo_room_leave_action.user_id");
                        p(commonOuterClass$QQUserId2, "\u79bb\u5f00\u4e86\u8f66\u961f");
                        return;
                    }
                    CommonOuterClass$QQUserId commonOuterClass$QQUserId3 = yoloRoomOuterClass$YoloRoomAction.yolo_room_enter_action.user_id;
                    Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId3, "action.yolo_room_enter_action.user_id");
                    p(commonOuterClass$QQUserId3, "\u52a0\u5165\u4e86\u8f66\u961f");
                    return;
                }
                if (yoloRoomOuterClass$YoloRoomAction.action_type.get() == 251) {
                    fromUserId = yoloRoomOuterClass$YoloRoomAction.yolo_smoba_room_owner_change_action.from_user_id;
                } else {
                    fromUserId = yoloRoomOuterClass$YoloRoomAction.yolo_game_room_owner_change_action.from_user_id;
                }
                if (yoloRoomOuterClass$YoloRoomAction.action_type.get() == 251) {
                    commonOuterClass$QQUserId = yoloRoomOuterClass$YoloRoomAction.yolo_smoba_room_owner_change_action.to_user_id;
                } else {
                    commonOuterClass$QQUserId = yoloRoomOuterClass$YoloRoomAction.yolo_game_room_owner_change_action.to_user_id;
                }
                bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
                Intrinsics.checkNotNullExpressionValue(fromUserId, "fromUserId");
                dVar.I3(fromUserId, new a(fromUserId, commonOuterClass$QQUserId));
                return;
            }
            this.actionTv.setText(yoloRoomOuterClass$YoloRoomAction.yolo_room_update_game_route_info_action.status_change_text.get());
            return;
        }
        CommonOuterClass$QQUserId commonOuterClass$QQUserId4 = yoloRoomOuterClass$YoloRoomAction.yolo_room_kick_out_room_action.user_id;
        Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId4, "action.yolo_room_kick_out_room_action.user_id");
        p(commonOuterClass$QQUserId4, "\u79bb\u5f00\u4e86\u8f66\u961f");
    }

    private final void p(CommonOuterClass$QQUserId userId, String suffix) {
        ((bo4.d) mm4.b.b(bo4.d.class)).I3(userId, new b(userId, suffix));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.CenterMessageView
    public void k(@NotNull com.tencent.timi.game.tim.api.message.a msg2, @Nullable CommonOuterClass$QQUserId selfUserId) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.k(msg2, selfUserId);
        o(msg2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamActionMessageItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ TeamActionMessageItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TeamActionMessageItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        setContentView(R.layout.hwj);
        View findViewById = findViewById(R.id.f163911s90);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.actionTv)");
        this.actionTv = (TextView) findViewById;
    }
}
