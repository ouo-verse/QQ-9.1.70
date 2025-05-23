package com.tencent.mobileqq.qqlive.room.message;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.widget.chat.message.j;
import com.tencent.mobileqq.qqlive.widget.chat.message.o;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager;
import com.tencent.timi.game.liveroom.impl.room.message.i;
import com.tencent.timi.game.liveroom.impl.util.QQLiveActionSheetHelper;
import kk4.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import nr4.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001\u001a\u0018\u0000 \u000e2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/message/a;", "Lcom/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager;", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/o;", "message", "", "anchorId", "", "S0", "", "R0", "", "f0", "Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;", "msg", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "data", "K", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", UserInfo.SEX_FEMALE, "O", "register", "unregister", "Landroid/text/style/ClickableSpan;", "H", "L", "com/tencent/mobileqq/qqlive/room/message/a$b", "P", "Lcom/tencent/mobileqq/qqlive/room/message/a$b;", "anchorWishListener", "<init>", "()V", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends ChatMessageLayoutManager {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final b anchorWishListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/message/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.message.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/qqlive/room/message/a$b", "", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/room/message/a$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "textPaint", "updateDrawState", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ o f271650d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f271651e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f271652f;

        c(o oVar, a aVar, long j3) {
            this.f271650d = oVar;
            this.f271651e = aVar;
            this.f271652f = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, oVar, aVar, Long.valueOf(j3));
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) widget);
                return;
            }
            Intrinsics.checkNotNullParameter(widget, "widget");
            if (this.f271650d.b().f273763a != 0) {
                if (com.tencent.timi.game.liveroom.impl.room.manager.e.INSTANCE.a().g(this.f271651e.getRoomId(), this.f271650d.b().f273763a, this.f271652f)) {
                    long j3 = this.f271650d.b().f273763a;
                    com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
                    if (j3 != cVar.G()) {
                        QQLiveActionSheetHelper.INSTANCE.d(this.f271651e.b0(), Long.valueOf(this.f271650d.b().f273763a), this.f271650d.b().f273764b, Long.valueOf(cVar.G()), this.f271650d.b().f273766d);
                        return;
                    }
                }
                this.f271651e.S0(this.f271650d, this.f271652f);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
            } else {
                Intrinsics.checkNotNullParameter(textPaint, "textPaint");
                textPaint.setUnderlineText(false);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/room/message/a$d", "Lkotlin/Function1;", "Lnr4/f;", "Lkotlin/ParameterName;", "name", "msg", "", "Lcom/tencent/timi/game/liveroom/impl/room/fans/FansGroupReceiver;", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements Function1<f, Unit> {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        public void a(@Nullable f msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            if (msg2 != null) {
                a aVar = a.this;
                if (aVar.getRoomId() == msg2.f421231e) {
                    String str = msg2.f421232f;
                    Intrinsics.checkNotNullExpressionValue(str, "it.content");
                    aVar.s(new j(str, 0, 0, null, null, 30, null));
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(f fVar) {
            a(fVar);
            return Unit.INSTANCE;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30043);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.anchorWishListener = new b();
        }
    }

    private final boolean R0() {
        return com.tencent.mobileqq.qqlive.sail.c.K(com.tencent.mobileqq.qqlive.sail.c.f272176a, getRoomId(), 0, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(o message, long anchorId) {
        if (message != null && message.b() != null) {
            Context context = QBaseActivity.sTopActivity;
            if (context == null) {
                context = Foreground.getTopActivity();
            }
            Context context2 = context;
            if (context2 == null) {
                return;
            }
            LiveUserInfo liveUserInfo = new LiveUserInfo();
            liveUserInfo.uid = message.b().f273763a;
            a.Companion.j(kk4.a.INSTANCE, context2, anchorId, liveUserInfo, 0, false, 16, null);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void F(@NotNull FollowPushMessage msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        AegisLogger.INSTANCE.d(f0(), "onFollowReceive " + msg2.nick);
        if (msg2.type == 1) {
            s(new com.tencent.mobileqq.qqlive.widget.chat.message.c(msg2));
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, vi2.c
    @Nullable
    public ClickableSpan H(@NotNull o message, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ClickableSpan) iPatchRedirector.redirect((short) 9, this, message, Long.valueOf(anchorId));
        }
        Intrinsics.checkNotNullParameter(message, "message");
        return new c(message, this, anchorId);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void K(@Nullable byte[] data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) data);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, vi2.c
    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            if (!R0()) {
                return;
            }
            com.tencent.mobileqq.qqlive.room.wishlist.b.d(getRoomId(), com.tencent.mobileqq.qqlive.sail.c.l(com.tencent.mobileqq.qqlive.sail.c.f272176a, getRoomId(), 0, 2, null));
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void O(@Nullable byte[] data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) data);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, xj4.b
    public void Q(@NotNull AnnouncePushMessage msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            s(msg2);
        }
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager
    @NotNull
    public String f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "Chat_Message|QQLiveChatMessageLayoutManager";
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, vi2.a
    public void register() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        QLog.d(f0(), 4, "register");
        getMsgPushMgr().a(getRoomId(), this, getIsInAnchorState());
        i.f378067a.a(getNewLocalMsgReceiver());
        SimpleEventBus.getInstance().registerReceiver(e0());
        TGLiveFollowManager.f377684a.u(getFollowStateListener());
        hj4.a.d(getFansGroupPushMgr(), getRoomId(), new d(), null, 4, null);
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager, vi2.a
    public void unregister() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        QLog.d(f0(), 4, "unregister");
        getMsgPushMgr().unregister();
        i.f378067a.c(getNewLocalMsgReceiver());
        SimpleEventBus.getInstance().unRegisterReceiver(e0());
        TGLiveFollowManager.f377684a.w(getFollowStateListener());
        getFansGroupPushMgr().e();
    }
}
