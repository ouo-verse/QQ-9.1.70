package com.tencent.mobileqq.qqlive.sail.ui.admin;

import android.app.Activity;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sail.base.c;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.mobileqq.qqlive.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.trpcprotocol.qlive.livechatcheck.RoomAdminPush$PushMsg_PersonalMessage;
import com.tencent.trpcprotocol.qlive.livechatcheck.RoomAdminPush$PushMsg_SetAdmin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lk4.c;
import lk4.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/admin/a;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "Lfp4/c;", "msgInfo", "", LocaleUtils.L_JAPANESE, "la", "ia", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "U9", "V9", "onPush", "<init>", "()V", "e", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends c implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/admin/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.admin.a$a, reason: collision with other inner class name and from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/admin/a$b", "Llk4/c$a;", "", "isForbidden", "", "onResult", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements c.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // lk4.c.a
        public void onResult(boolean isForbidden) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isForbidden);
            } else if (isForbidden) {
                a.this.la();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51402);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void ia(fp4.c msgInfo) {
        try {
            RoomAdminPush$PushMsg_SetAdmin mergeFrom = new RoomAdminPush$PushMsg_SetAdmin().mergeFrom(msgInfo.f400285c);
            String stringUtf8 = mergeFrom.f381593msg.get().toStringUtf8();
            AegisLogger.INSTANCE.i("Audience||QQLiveAdminPart", "handleAdminAppoint", "msg=" + stringUtf8 + ", set=" + mergeFrom.set_admin.get());
            lk4.c cVar = lk4.c.f414972a;
            cVar.o(getActivity(), stringUtf8);
            cVar.l(false, C9(), M9(), H9(), null);
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Audience||QQLiveAdminPart", "handleAdminAppoint", "error, ", e16);
        }
    }

    private final void ja(fp4.c msgInfo) {
        boolean z16;
        Long l3;
        PBUInt64Field pBUInt64Field;
        PBUInt64Field pBUInt64Field2;
        try {
            RoomAdminPush$PushMsg_PersonalMessage mergeFrom = new RoomAdminPush$PushMsg_PersonalMessage().mergeFrom(msgInfo.f400285c);
            if (mergeFrom != null && (pBUInt64Field2 = mergeFrom.uid) != null && pBUInt64Field2.get() == M9()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                if (mergeFrom != null && (pBUInt64Field = mergeFrom.uid) != null) {
                    l3 = Long.valueOf(pBUInt64Field.get());
                } else {
                    l3 = null;
                }
                companion.i("Audience||QQLiveAdminPart", "", "uid=" + l3 + ", self=" + M9());
                return;
            }
            String stringUtf8 = mergeFrom.f381592msg.get().toStringUtf8();
            AegisLogger.INSTANCE.i("Audience||QQLiveAdminPart", "handleAdminOperate", "msg=" + stringUtf8 + ", type=" + mergeFrom.msg_type.get());
            lk4.c.f414972a.h(M9(), C9(), H9(), new b());
            e.e(stringUtf8, false);
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Audience||QQLiveAdminPart", "handleAdminOperate", "error, ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la() {
        LiveLoginInfo u16 = com.tencent.mobileqq.qqlive.sail.c.f272176a.u();
        if (u16 != null) {
            long H9 = H9();
            String string = getContext().getString(R.string.f223686gw);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.room_admin_forbid)");
            LiveLocalMsg liveLocalMsg = new LiveLocalMsg(H9, string, u16);
            liveLocalMsg.setSendMsgAlienation(true);
            SimpleEventBus.getInstance().dispatchEvent(liveLocalMsg);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.U9();
        f F9 = F9();
        if (F9 != null) {
            F9.p(253, this);
            F9.p(128, this);
            lk4.c cVar = lk4.c.f414972a;
            cVar.l(false, C9(), M9(), F9.getRoomId(), null);
            cVar.h(M9(), C9(), F9.getRoomId(), null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.V9();
        f F9 = F9();
        if (F9 != null) {
            F9.e(this);
        }
        lk4.c.f414972a.g();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        f F9 = F9();
        if (F9 != null) {
            F9.e(this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        int i3 = msgInfo.f400284b;
        if (i3 != 128) {
            if (i3 == 253) {
                ia(msgInfo);
                return;
            }
            return;
        }
        ja(msgInfo);
    }
}
