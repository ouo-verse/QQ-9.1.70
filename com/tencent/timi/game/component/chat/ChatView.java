package com.tencent.timi.game.component.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.chat.ChatView;
import com.tencent.timi.game.component.chat.TimiBaseInputViewV2;
import com.tencent.timi.game.component.chat.input.ExpandHallInputBoxView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.message.MessageLayout;
import com.tencent.timi.game.component.chat.message.MessageLayoutImpl;
import com.tencent.timi.game.component.chat.message.n;
import com.tencent.timi.game.component.chat.message.p;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nr2.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import ug4.b;
import xg4.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a9\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001?\b&\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002PQB\u0011\b\u0016\u0012\u0006\u0010G\u001a\u00020F\u00a2\u0006\u0004\bH\u0010IB\u001b\b\u0016\u0012\u0006\u0010G\u001a\u00020F\u0012\b\u0010K\u001a\u0004\u0018\u00010J\u00a2\u0006\u0004\bH\u0010LB#\b\u0016\u0012\u0006\u0010G\u001a\u00020F\u0012\b\u0010K\u001a\u0004\u0018\u00010J\u0012\u0006\u0010M\u001a\u00020\u0015\u00a2\u0006\u0004\bH\u0010NJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0018H\u0016J\u0006\u0010\u001b\u001a\u00020\u0004J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020 H&J\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020&R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010,R$\u00104\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020 8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u0010D\u00a8\u0006R"}, d2 = {"Lcom/tencent/timi/game/component/chat/ChatView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/timi/game/component/chat/at/d;", "", "", "p", "Lcom/tencent/timi/game/component/chat/message/n;", "listener", "setMessageListener", "Lcom/tencent/timi/game/component/chat/ConvType;", "type", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "g", "Lcom/tencent/timi/game/component/chat/input/ExpandHallInputBoxView;", "j", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "l", "o", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$b;", "f", "t", "i", "Landroid/widget/EditText;", "H", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", UserInfo.SEX_FEMALE, "", "chatId", "Lcom/tencent/timi/game/tim/api/message/c;", "k", "u", ReportConstant.COSTREPORT_PREFIX, "", "r", "d", "J", "e", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "Lcom/tencent/timi/game/component/chat/ConvType;", "Lcom/tencent/timi/game/component/chat/ChatView$b;", h.F, "Lcom/tencent/timi/game/component/chat/ChatView$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/timi/game/component/chat/ChatView$b;", "setMsgSendStatusListener", "(Lcom/tencent/timi/game/component/chat/ChatView$b;)V", "msgSendStatusListener", "Lcom/tencent/timi/game/tim/api/message/b;", "Lcom/tencent/timi/game/tim/api/message/b;", "msgListener", "Lcom/tencent/timi/game/tim/api/message/d;", "Lcom/tencent/timi/game/tim/api/message/d;", "newMsgListener", "Lnr2/r;", BdhLogUtil.LogTag.Tag_Conn, "Lnr2/r;", "binding", "com/tencent/timi/game/component/chat/ChatView$g", "D", "Lcom/tencent/timi/game/component/chat/ChatView$g;", "mEmoSendListener", DomainData.DOMAIN_NAME, "()J", "sendMsgIntervalTime", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "E", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class ChatView extends LinearLayout implements com.tencent.timi.game.component.chat.at.d {

    /* renamed from: C, reason: from kotlin metadata */
    private r binding;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final g mEmoSendListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long chatId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CommonOuterClass$QQUserId qqUserId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConvType type;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b msgSendStatusListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.timi.game.tim.api.message.b msgListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.timi.game.tim.api.message.d newMsgListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/component/chat/ChatView$b;", "", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", "b", "", "errorCode", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void b(@NotNull com.tencent.timi.game.tim.api.message.a msg2);

        void c(int errorCode, @NotNull com.tencent.timi.game.tim.api.message.a msg2);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/ChatView$c", "Lcom/tencent/timi/game/tim/api/message/d;", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", "c", "", "groupId", "Ltrpc/yes/common/MessageOuterClass$TimMsgBody;", "timMsgBody", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements com.tencent.timi.game.tim.api.message.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomInfo f376331a;

        c(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
            this.f376331a = yoloRoomOuterClass$YoloRoomInfo;
        }

        @Override // com.tencent.timi.game.tim.api.message.d
        public void a(long groupId, @NotNull MessageOuterClass$TimMsgBody timMsgBody) {
            Intrinsics.checkNotNullParameter(timMsgBody, "timMsgBody");
            if (p.a(this.f376331a, timMsgBody)) {
                com.tencent.timi.game.room.impl.util.g gVar = com.tencent.timi.game.room.impl.util.g.f379335a;
                YoloRoomOuterClass$YoloRoomAction yoloRoomOuterClass$YoloRoomAction = timMsgBody.content.yolo_room_action_msg.yolo_room_action.get();
                Intrinsics.checkNotNullExpressionValue(yoloRoomOuterClass$YoloRoomAction, "timMsgBody.content.yolo_\u2026sg.yolo_room_action.get()");
                gVar.i(yoloRoomOuterClass$YoloRoomAction, groupId, this.f376331a.room_id.get());
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.d
        public void c(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0016J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016\u00a8\u0006\u0014"}, d2 = {"com/tencent/timi/game/component/chat/ChatView$d", "Lcom/tencent/timi/game/tim/api/message/b;", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", "e", "d", "b", "", "code", "", "desc", "f", h.F, "c", "msgId", "a", "", "historyMessages", "g", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements com.tencent.timi.game.tim.api.message.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ YoloRoomOuterClass$YoloRoomInfo f376333b;

        d(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo) {
            this.f376333b = yoloRoomOuterClass$YoloRoomInfo;
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void a(@NotNull String msgId) {
            Intrinsics.checkNotNullParameter(msgId, "msgId");
            r rVar = ChatView.this.binding;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                rVar = null;
            }
            rVar.f421113c.O(msgId);
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void b(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            r rVar = ChatView.this.binding;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                rVar = null;
            }
            rVar.f421113c.b0(msg2.id());
            if (msg2.type() == 78) {
                QQToast.makeText(BaseApplication.getContext(), 5, "\u5206\u4eab\u8f66\u961f\u6210\u529f", 0).show();
            }
            th4.p a16 = th4.p.INSTANCE.a();
            if (a16 != null) {
                a16.c(ChatView.this);
            }
            ug4.b bVar = (ug4.b) mm4.b.b(ug4.b.class);
            ConcurrentHashMap<String, String> L = YoloRoomUtil.L(this.f376333b);
            L.put("yes_msg_type", String.valueOf(msg2.type()));
            L.put("yes_emo_type", String.valueOf(msg2.o()));
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(L, "getCommonRoomInfoReportP\u2026}\")\n                    }");
            bVar.reportEvent("ev_yes_msg_send", L);
            b msgSendStatusListener = ChatView.this.getMsgSendStatusListener();
            if (msgSendStatusListener != null) {
                msgSendStatusListener.b(msg2);
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void c(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            r rVar = ChatView.this.binding;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                rVar = null;
            }
            rVar.f421113c.P(msg2);
            th4.p a16 = th4.p.INSTANCE.a();
            if (a16 != null) {
                a16.c(ChatView.this);
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void d(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            r rVar = ChatView.this.binding;
            r rVar2 = null;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                rVar = null;
            }
            MessageLayoutImpl messageLayoutImpl = rVar.f421113c;
            if (messageLayoutImpl != null) {
                messageLayoutImpl.D(msg2.id());
            }
            r rVar3 = ChatView.this.binding;
            if (rVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                rVar2 = rVar3;
            }
            MessageLayoutImpl messageLayoutImpl2 = rVar2.f421113c;
            if (messageLayoutImpl2 != null) {
                messageLayoutImpl2.y(msg2);
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void e(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            r rVar = ChatView.this.binding;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                rVar = null;
            }
            MessageLayoutImpl messageLayoutImpl = rVar.f421113c;
            if (messageLayoutImpl != null) {
                messageLayoutImpl.y(msg2);
            }
            th4.p a16 = th4.p.INSTANCE.a();
            if (a16 != null) {
                a16.c(ChatView.this);
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void f(@NotNull com.tencent.timi.game.tim.api.message.a msg2, int code, @Nullable String desc) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            r rVar = ChatView.this.binding;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                rVar = null;
            }
            rVar.f421113c.b0(msg2.id());
            b msgSendStatusListener = ChatView.this.getMsgSendStatusListener();
            if (msgSendStatusListener != null) {
                msgSendStatusListener.c(code, msg2);
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void g(@NotNull List<? extends com.tencent.timi.game.tim.api.message.a> historyMessages) {
            boolean z16;
            Intrinsics.checkNotNullParameter(historyMessages, "historyMessages");
            YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo = this.f376333b;
            ArrayList arrayList = new ArrayList();
            for (Object obj : historyMessages) {
                com.tencent.timi.game.tim.api.message.a aVar = (com.tencent.timi.game.tim.api.message.a) obj;
                if (aVar.type() == 49 && ((zf4.a.a(aVar) == 101 && yoloRoomOuterClass$YoloRoomInfo.room_type.get() == 5) || zf4.a.a(aVar) == 153)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    arrayList.add(obj);
                }
            }
            r rVar = ChatView.this.binding;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                rVar = null;
            }
            rVar.f421113c.v(arrayList);
            th4.p a16 = th4.p.INSTANCE.a();
            if (a16 != null) {
                a16.g(arrayList.size());
            }
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null) {
                I0.ug();
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void h(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            r rVar = ChatView.this.binding;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                rVar = null;
            }
            MessageLayoutImpl messageLayoutImpl = rVar.f421113c;
            if (messageLayoutImpl != null) {
                messageLayoutImpl.D(msg2.id());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/component/chat/ChatView$e", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$b;", "", "text", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "timiBaseInputView", "", "a", "b", "", "state", "onStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements TimiBaseInputView.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.c f376335b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f376336c;

        e(com.tencent.timi.game.tim.api.message.c cVar, CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
            this.f376335b = cVar;
            this.f376336c = commonOuterClass$QQUserId;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ChatView this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            r rVar = this$0.binding;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                rVar = null;
            }
            rVar.f421113c.R();
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void a(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView) {
            boolean z16;
            com.tencent.timi.game.tim.api.message.a aVar;
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
            if (o.f("tag_suspend_send_msg", ChatView.this.n())) {
                com.tencent.timi.game.ui.widget.f.c("\u8bf4\u8bdd\u592a\u5feb\u4e86\uff0c\u4f11\u606f\u4e00\u4e0b\u5427\u3002");
                return;
            }
            if (text.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                com.tencent.timi.game.tim.api.message.c cVar = this.f376335b;
                r rVar = null;
                if (cVar != null) {
                    aVar = cVar.h(this.f376336c, text, content);
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    r rVar2 = ChatView.this.binding;
                    if (rVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        rVar = rVar2;
                    }
                    EditText inputEditText = rVar.f421112b.getInputEditText();
                    if (inputEditText != null) {
                        inputEditText.setText("");
                    }
                }
            }
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void b(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView) {
            boolean z16;
            com.tencent.timi.game.tim.api.message.a aVar;
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(timiBaseInputView, "timiBaseInputView");
            if (o.f("tag_suspend_send_msg", ChatView.this.n())) {
                com.tencent.timi.game.ui.widget.f.c("\u8bf4\u8bdd\u592a\u5feb\u4e86\uff0c\u4f11\u606f\u4e00\u4e0b\u5427\u3002");
                return;
            }
            if (text.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                com.tencent.timi.game.tim.api.message.c cVar = this.f376335b;
                r rVar = null;
                if (cVar != null) {
                    aVar = cVar.j(this.f376336c, text);
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    r rVar2 = ChatView.this.binding;
                    if (rVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        rVar = rVar2;
                    }
                    EditText inputEditText = rVar.f421112b.getInputEditText();
                    if (inputEditText != null) {
                        inputEditText.setText("");
                    }
                }
            }
        }

        @Override // com.tencent.timi.game.component.chat.input.TimiBaseInputView.b
        public void onStateChanged(int state) {
            r rVar = ChatView.this.binding;
            r rVar2 = null;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                rVar = null;
            }
            rVar.f421112b.U0();
            if (state != 1) {
                r rVar3 = ChatView.this.binding;
                if (rVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    rVar2 = rVar3;
                }
                MessageLayoutImpl messageLayoutImpl = rVar2.f421113c;
                final ChatView chatView = ChatView.this;
                messageLayoutImpl.post(new Runnable() { // from class: com.tencent.timi.game.component.chat.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ChatView.e.d(ChatView.this);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/timi/game/component/chat/ChatView$f", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$c;", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements MessageLayout.c {
        f() {
        }

        @Override // com.tencent.timi.game.component.chat.message.MessageLayout.c
        public void a() {
            r rVar = ChatView.this.binding;
            if (rVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                rVar = null;
            }
            rVar.f421112b.setState(1);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/component/chat/ChatView$g", "Lcom/tencent/timi/game/component/chat/TimiBaseInputViewV2$b;", "Lxg4/k;", "timiEmoInfo", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g implements TimiBaseInputViewV2.b {
        g() {
        }

        @Override // com.tencent.timi.game.component.chat.TimiBaseInputViewV2.b
        public void a(@NotNull k timiEmoInfo) {
            CommonOuterClass$QQUserId commonOuterClass$QQUserId;
            Intrinsics.checkNotNullParameter(timiEmoInfo, "timiEmoInfo");
            l.i("ChatView", "onSend " + timiEmoInfo + " qqUserId:" + ChatView.this.qqUserId);
            if (!(timiEmoInfo.getQqEmoInfo() instanceof SystemAndEmojiEmoticonInfo) && (commonOuterClass$QQUserId = ChatView.this.qqUserId) != null) {
                ChatView chatView = ChatView.this;
                chatView.k(chatView.chatId).d(commonOuterClass$QQUserId, xg4.c.a(timiEmoInfo));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.type = ConvType.C2C;
        this.mEmoSendListener = new g();
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ChatView this$0, CommonOuterClass$QQUserId qqUserId, YoloRoomOuterClass$YoloRoomInfo roomInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(qqUserId, "$qqUserId");
        Intrinsics.checkNotNullParameter(roomInfo, "$roomInfo");
        if (o.f("tag_suspend_send_msg", this$0.n())) {
            com.tencent.timi.game.ui.widget.f.c("\u8bf4\u8bdd\u592a\u5feb\u4e86\uff0c\u4f11\u606f\u4e00\u4e0b\u5427\u3002");
        } else {
            zf4.c cVar = zf4.c.f452468a;
            long j3 = this$0.chatId;
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            cVar.k(qqUserId, j3, context, roomInfo.room_id.get());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long n() {
        return ((fm4.g) mm4.b.b(fm4.g.class)).S2().b() * 1000;
    }

    private final void p() {
        r f16 = r.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        setOrientation(1);
        r rVar = this.binding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        rVar.f421113c.setLayoutClickListener(new f());
    }

    @Override // com.tencent.timi.game.component.chat.at.d
    @Nullable
    public TimiBaseInputView F() {
        r rVar = this.binding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        return rVar.f421112b;
    }

    @Override // com.tencent.timi.game.component.chat.at.d
    @Nullable
    public EditText H() {
        r rVar = this.binding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        return rVar.f421112b.getInputEditText();
    }

    public void f(@NotNull TimiBaseInputView.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        r rVar = this.binding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        rVar.f421112b.i(listener);
    }

    public final void g(@NotNull ConvType type, @NotNull final YoloRoomOuterClass$YoloRoomInfo roomInfo, @NotNull final CommonOuterClass$QQUserId qqUserId) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        this.type = type;
        long j3 = roomInfo.tim_group_id.get();
        this.chatId = j3;
        this.qqUserId = qqUserId;
        l.b("ChatView", "createChat type = [" + type + "], chatId = [" + j3 + "]");
        com.tencent.timi.game.component.chat.at.b.INSTANCE.a().e(String.valueOf(this.chatId), qqUserId);
        com.tencent.timi.game.tim.api.message.c k3 = k(this.chatId);
        k3.k(this.msgListener);
        com.tencent.timi.game.tim.api.message.d dVar = this.newMsgListener;
        if (dVar != null) {
            ((kn4.b) mm4.b.b(kn4.b.class)).q2(dVar);
        }
        this.newMsgListener = new c(roomInfo);
        d dVar2 = new d(roomInfo);
        this.msgListener = dVar2;
        k3.b(dVar2);
        com.tencent.timi.game.tim.api.message.d dVar3 = this.newMsgListener;
        if (dVar3 != null) {
            ((kn4.b) mm4.b.b(kn4.b.class)).r0(dVar3);
        }
        r rVar = this.binding;
        r rVar2 = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        rVar.f421113c.setChatId(this.chatId);
        r rVar3 = this.binding;
        if (rVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar3 = null;
        }
        rVar3.f421113c.setRoomInfo(roomInfo);
        r rVar4 = this.binding;
        if (rVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar4 = null;
        }
        rVar4.f421113c.setQQUserId(qqUserId);
        r rVar5 = this.binding;
        if (rVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar5 = null;
        }
        rVar5.f421113c.setViewProvider(new a(roomInfo));
        r rVar6 = this.binding;
        if (rVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar6 = null;
        }
        rVar6.f421112b.B0(roomInfo.room_id.get());
        r rVar7 = this.binding;
        if (rVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar7 = null;
        }
        rVar7.f421112b.l0(roomInfo.room_data_info.game_id.get());
        r rVar8 = this.binding;
        if (rVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar8 = null;
        }
        URLImageView profileBtn = rVar8.f421112b.getProfileBtn();
        if (profileBtn != null) {
            profileBtn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChatView.h(ChatView.this, qqUserId, roomInfo, view);
                }
            });
        }
        r rVar9 = this.binding;
        if (rVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar9 = null;
        }
        rVar9.f421112b.i(new e(k3, qqUserId));
        r rVar10 = this.binding;
        if (rVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar10 = null;
        }
        rVar10.f421112b.b0(this.mEmoSendListener);
        r rVar11 = this.binding;
        if (rVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar11 = null;
        }
        k3.i(rVar11.f421113c.G());
        th4.p a16 = th4.p.INSTANCE.a();
        if (a16 != null) {
            a16.c(this);
        }
        r rVar12 = this.binding;
        if (rVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar12 = null;
        }
        URLImageView emojiBtn = rVar12.f421112b.getEmojiBtn();
        if (emojiBtn != null) {
            mm4.a b16 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
            ConcurrentHashMap<String, String> L = YoloRoomUtil.L(roomInfo);
            Intrinsics.checkNotNullExpressionValue(L, "getCommonRoomInfoReportParam(roomInfo)");
            b.a.a((ug4.b) b16, emojiBtn, false, null, "em_yes_emoji", L, 6, null);
        }
        r rVar13 = this.binding;
        if (rVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            rVar2 = rVar13;
        }
        URLImageView profileBtn2 = rVar2.f421112b.getProfileBtn();
        if (profileBtn2 != null) {
            mm4.a b17 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b17, "getService(IReportService::class.java)");
            ConcurrentHashMap<String, String> L2 = YoloRoomUtil.L(roomInfo);
            Intrinsics.checkNotNullExpressionValue(L2, "getCommonRoomInfoReportParam(roomInfo)");
            b.a.a((ug4.b) b17, profileBtn2, false, null, "em_yes_myprofile", L2, 6, null);
        }
    }

    public final void i() {
        com.tencent.timi.game.tim.api.message.c k3 = k(this.chatId);
        if (k3 != null) {
            k3.k(this.msgListener);
        }
        com.tencent.timi.game.tim.api.message.d dVar = this.newMsgListener;
        if (dVar != null) {
            ((kn4.b) mm4.b.b(kn4.b.class)).q2(dVar);
        }
        com.tencent.timi.game.component.chat.at.b.INSTANCE.a().b(String.valueOf(this.chatId));
        r rVar = this.binding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        rVar.f421112b.h0(this.mEmoSendListener);
    }

    @NotNull
    public final ExpandHallInputBoxView j() {
        r rVar = this.binding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        ExpandHallInputBoxView expandHallInputBoxView = rVar.f421112b;
        Intrinsics.checkNotNullExpressionValue(expandHallInputBoxView, "binding.inputBoxView");
        return expandHallInputBoxView;
    }

    @NotNull
    public abstract com.tencent.timi.game.tim.api.message.c k(long chatId);

    public final int l() {
        r rVar = this.binding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        return rVar.f421113c.H();
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final b getMsgSendStatusListener() {
        return this.msgSendStatusListener;
    }

    public void o() {
        r rVar = this.binding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        rVar.f421112b.G();
    }

    public final void q(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        r rVar = this.binding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        rVar.f421113c.J(msg2);
    }

    public final boolean r() {
        r rVar = this.binding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        return rVar.f421112b.Q0();
    }

    public final void s() {
        r rVar = this.binding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        rVar.f421112b.R0();
    }

    public final void setMessageListener(@NotNull n listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        r rVar = this.binding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        rVar.f421113c.setMessageListener(listener);
    }

    public final void setMsgSendStatusListener(@Nullable b bVar) {
        this.msgSendStatusListener = bVar;
    }

    public void t(@NotNull TimiBaseInputView.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        r rVar = this.binding;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        rVar.f421112b.P(listener);
    }

    public final void u() {
        r rVar = this.binding;
        r rVar2 = null;
        if (rVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            rVar = null;
        }
        if (rVar.f421113c.K()) {
            r rVar3 = this.binding;
            if (rVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                rVar2 = rVar3;
            }
            rVar2.f421113c.R();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.type = ConvType.C2C;
        this.mEmoSendListener = new g();
        p();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.type = ConvType.C2C;
        this.mEmoSendListener = new g();
        p();
    }
}
