package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.chat.event.GreetingNewUserEvent;
import com.tencent.timi.game.component.chat.message.GreetingMessageItemView;
import com.tencent.timi.game.component.chat.message.MessageLayout;
import com.tencent.timi.game.room.impl.YoloRoomCommonConfManager;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomEnterAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B'\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010,\u001a\u00020\u0004\u00a2\u0006\u0004\b-\u0010.J8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u001a\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0014\u0010'\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&\u00a8\u00061"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/GreetingMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/CenterMessageView;", "", "roomId", "", "roomType", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "senderUid", "receiverUid", "", "content", com.heytap.mcssdk.a.a.f36093c, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "userId", "", DomainData.DOMAIN_NAME, "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "selfUserId", "k", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "arrowIv", "Landroid/widget/LinearLayout;", "L", "Landroid/widget/LinearLayout;", "containerLl", "Landroid/widget/TextView;", "M", "Landroid/widget/TextView;", "enterDescTv", "N", "greetingTv", "P", "nickTv", "o", "()J", "sendMsgIntervalTime", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class GreetingMessageItemView extends CenterMessageView {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private ImageView arrowIv;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private LinearLayout containerLl;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private TextView enterDescTv;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private TextView greetingTv;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private TextView nickTv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GreetingMessageItemView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final Map<String, String> n(CommonOuterClass$QQUserId userId) {
        ConcurrentHashMap<String, String> L = YoloRoomUtil.L(getRoomInfo());
        L.put("yes_to_uid", String.valueOf(userId.uid.get()));
        L.put("yes_to_yes_uid", nn4.a.a(userId.yes_uid.get()));
        Intrinsics.checkNotNullExpressionValue(L, "reportParams.apply {\n   \u2026.ulongString())\n        }");
        return L;
    }

    private final long o() {
        return ((fm4.g) mm4.b.b(fm4.g.class)).S2().b() * 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(GreetingMessageItemView this$0, long j3, int i3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, YoloRoomOuterClass$YoloRoomEnterAction it, String greetingWords, com.tencent.timi.game.tim.api.message.a msg2, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(greetingWords, "$greetingWords");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        CommonOuterClass$QQUserId commonOuterClass$QQUserId2 = it.user_id.get();
        Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId2, "it.user_id.get()");
        this$0.q(j3, i3, commonOuterClass$QQUserId, commonOuterClass$QQUserId2, greetingWords, msg2.id());
        msg2.n(-1);
        this$0.k(msg2, commonOuterClass$QQUserId);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q(long roomId, int roomType, CommonOuterClass$QQUserId senderUid, CommonOuterClass$QQUserId receiverUid, String content, String messageID) {
        if (com.tencent.timi.game.utils.o.f("tag_suspend_send_msg", o())) {
            com.tencent.timi.game.ui.widget.f.c("\u8bf4\u8bdd\u592a\u5feb\u4e86\uff0c\u4f11\u606f\u4e00\u4e0b\u5427\u3002");
        } else {
            zf4.c.f452468a.n(roomId, senderUid, receiverUid, content);
            SimpleEventBus.getInstance().dispatchEvent(new GreetingNewUserEvent(messageID, roomId));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.CenterMessageView
    public void k(@NotNull final com.tencent.timi.game.tim.api.message.a msg2, @Nullable final CommonOuterClass$QQUserId selfUserId) {
        final YoloRoomOuterClass$YoloRoomEnterAction yoloRoomOuterClass$YoloRoomEnterAction;
        YoloRoomOuterClass$YoloRoomInfo roomInfo;
        PBUInt64Field pBUInt64Field;
        PBInt32Field pBInt32Field;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.k(msg2, selfUserId);
        this.nickTv.setText("");
        YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction = msg2.a().yolo_room_action_msg.yolo_room_action;
        if (yoloRoomOuterClass$YoloRoomAction != null && (yoloRoomOuterClass$YoloRoomEnterAction = yoloRoomOuterClass$YoloRoomAction.yolo_room_enter_action) != null) {
            this.greetingTv.setOnClickListener(null);
            MessageLayout.a iThemeConfig = getIThemeConfig();
            if (iThemeConfig != null) {
                if (msg2.m() != -1) {
                    this.greetingTv.setTextColor(iThemeConfig.a());
                    this.arrowIv.setColorFilter(iThemeConfig.a());
                } else {
                    this.greetingTv.setTextColor(iThemeConfig.c());
                    this.arrowIv.setColorFilter(iThemeConfig.c());
                }
                this.enterDescTv.setTextColor(iThemeConfig.c());
                this.nickTv.setTextColor(iThemeConfig.a());
            }
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = yoloRoomOuterClass$YoloRoomEnterAction.user_id;
            if (selfUserId != null && (roomInfo = getRoomInfo()) != null && (pBUInt64Field = roomInfo.room_id) != null) {
                final long j3 = pBUInt64Field.get();
                YoloRoomOuterClass$YoloRoomInfo roomInfo2 = getRoomInfo();
                if (roomInfo2 != null && (pBInt32Field = roomInfo2.room_type) != null) {
                    final int i3 = pBInt32Field.get();
                    final String c16 = YoloRoomCommonConfManager.f379027a.c();
                    if (msg2.m() != -1) {
                        this.greetingTv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.l
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                GreetingMessageItemView.p(GreetingMessageItemView.this, j3, i3, selfUserId, yoloRoomOuterClass$YoloRoomEnterAction, c16, msg2, view);
                            }
                        });
                    }
                    ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
                    TextView textView = this.nickTv;
                    String id5 = msg2.id();
                    CommonOuterClass$QQUserId commonOuterClass$QQUserId2 = yoloRoomOuterClass$YoloRoomEnterAction.user_id;
                    Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId2, "it.user_id");
                    bVar.a(textView, false, id5, "em_yes_chat_nickname", n(commonOuterClass$QQUserId2));
                    ug4.b bVar2 = (ug4.b) mm4.b.b(ug4.b.class);
                    TextView textView2 = this.greetingTv;
                    String id6 = msg2.id();
                    CommonOuterClass$QQUserId commonOuterClass$QQUserId3 = yoloRoomOuterClass$YoloRoomEnterAction.user_id;
                    Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId3, "it.user_id");
                    bVar2.a(textView2, false, id6, "em_yes_chat_welcome", n(commonOuterClass$QQUserId3));
                    bo4.d dVar = (bo4.d) mm4.b.b(bo4.d.class);
                    CommonOuterClass$QQUserId commonOuterClass$QQUserId4 = yoloRoomOuterClass$YoloRoomEnterAction.user_id.get();
                    Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId4, "it.user_id.get()");
                    dVar.I3(commonOuterClass$QQUserId4, new b(commonOuterClass$QQUserId, yoloRoomOuterClass$YoloRoomEnterAction, this));
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GreetingMessageItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ GreetingMessageItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GreetingMessageItemView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        setContentView(R.layout.hu7);
        View findViewById = findViewById(R.id.svq);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.arrowIv)");
        this.arrowIv = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.u66);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.containerLl)");
        this.containerLl = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.uvn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.enterDescTv)");
        this.enterDescTv = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.vsr);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.greetingTv)");
        this.greetingTv = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.zqw);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.nickTv)");
        this.nickTv = (TextView) findViewById5;
        LinearLayout linearLayout = this.containerLl;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, fh4.b.b(19));
        layoutParams.gravity = 1;
        linearLayout.setLayoutParams(layoutParams);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/GreetingMessageItemView$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "result", "", "c", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<IUserInfo> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f376457a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomEnterAction f376458b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GreetingMessageItemView f376459c;

        b(CommonOuterClass$QQUserId commonOuterClass$QQUserId, YoloRoomOuterClass$YoloRoomEnterAction yoloRoomOuterClass$YoloRoomEnterAction, GreetingMessageItemView greetingMessageItemView) {
            this.f376457a = commonOuterClass$QQUserId;
            this.f376458b = yoloRoomOuterClass$YoloRoomEnterAction;
            this.f376459c = greetingMessageItemView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(GreetingMessageItemView this$0, YoloRoomOuterClass$YoloRoomEnterAction it, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            n iMessageListener = this$0.getIMessageListener();
            if (iMessageListener != null) {
                CommonOuterClass$QQUserId commonOuterClass$QQUserId = it.user_id.get();
                Intrinsics.checkNotNullExpressionValue(commonOuterClass$QQUserId, "it.user_id.get()");
                iMessageListener.a(commonOuterClass$QQUserId);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable IUserInfo result) {
            boolean z16;
            if (result != null) {
                z16 = result.e(this.f376457a);
            } else {
                z16 = false;
            }
            if (result != null && z16) {
                String nick = result.i(this.f376458b.user_id.get());
                if (nick.length() > 8) {
                    Intrinsics.checkNotNullExpressionValue(nick, "nick");
                    String substring = nick.substring(0, 8);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    nick = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                this.f376459c.nickTv.setText(nick);
                TextView textView = this.f376459c.nickTv;
                final GreetingMessageItemView greetingMessageItemView = this.f376459c;
                final YoloRoomOuterClass$YoloRoomEnterAction yoloRoomOuterClass$YoloRoomEnterAction = this.f376458b;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GreetingMessageItemView.b.d(GreetingMessageItemView.this, yoloRoomOuterClass$YoloRoomEnterAction, view);
                    }
                });
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
        }
    }
}
