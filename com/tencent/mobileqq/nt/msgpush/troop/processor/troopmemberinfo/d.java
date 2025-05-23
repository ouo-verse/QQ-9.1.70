package com.tencent.mobileqq.nt.msgpush.troop.processor.troopmemberinfo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nt.msgpush.factory.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITmMsgIconService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.bus.event.y;
import java.util.Arrays;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.nt_im_msg_general_flags_body$MsgIcon;
import tencent.im.msg.nt_im_msg_general_flags_body$ResvAttr;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopmemberinfo/d;", "Lcom/tencent/mobileqq/nt/msgpush/factory/f;", "Ltencent/im/msg/nt_im_msg_general_flags_body$MsgIcon;", "oldMsgIcon", "newMsgIcon", "", "e", "Lcom/tencent/mobileqq/troop/api/ITmMsgIconService;", "d", "Lcom/tencent/mobileqq/nt/msgpush/factory/a;", "convertResultData", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class d implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/nt/msgpush/troop/processor/troopmemberinfo/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nt.msgpush.troop.processor.troopmemberinfo.d$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/nt/msgpush/troop/processor/troopmemberinfo/d$b", "Lcom/tencent/mobileqq/troop/api/ITmMsgIconService$a;", "Ltencent/im/msg/nt_im_msg_general_flags_body$MsgIcon;", "memberMsgIcon", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class b implements ITmMsgIconService.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ nt_im_msg_general_flags_body$MsgIcon f254460b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.nt.msgpush.troop.processor.a f254461c;

        b(nt_im_msg_general_flags_body$MsgIcon nt_im_msg_general_flags_body_msgicon, com.tencent.mobileqq.nt.msgpush.troop.processor.a aVar) {
            this.f254460b = nt_im_msg_general_flags_body_msgicon;
            this.f254461c = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, nt_im_msg_general_flags_body_msgicon, aVar);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.ITmMsgIconService.a
        public void a(@Nullable nt_im_msg_general_flags_body$MsgIcon memberMsgIcon) {
            Set mutableSetOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) memberMsgIcon);
                return;
            }
            if (d.this.e(memberMsgIcon, this.f254460b)) {
                String e16 = this.f254461c.e();
                mutableSetOf = SetsKt__SetsKt.mutableSetOf(this.f254461c.h());
                ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new y(e16, mutableSetOf));
                ITmMsgIconService d16 = d.this.d();
                if (d16 != null) {
                    d16.setMemberIconData(this.f254461c.h(), this.f254460b);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59497);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ITmMsgIconService d() {
        AppRuntime appRuntime;
        AppInterface appInterface;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime instanceof AppInterface) {
            appInterface = (AppInterface) appRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return null;
        }
        return (ITmMsgIconService) appInterface.getRuntimeService(ITmMsgIconService.class, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(nt_im_msg_general_flags_body$MsgIcon oldMsgIcon, nt_im_msg_general_flags_body$MsgIcon newMsgIcon) {
        if (oldMsgIcon == null && newMsgIcon == null) {
            return false;
        }
        if (oldMsgIcon == null || newMsgIcon == null) {
            return true;
        }
        return !Arrays.equals(oldMsgIcon.toByteArray(), newMsgIcon.toByteArray());
    }

    @Override // com.tencent.mobileqq.nt.msgpush.factory.f
    public void a(@NotNull com.tencent.mobileqq.nt.msgpush.factory.a convertResultData) {
        nt_im_msg_general_flags_body$ResvAttr g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) convertResultData);
            return;
        }
        Intrinsics.checkNotNullParameter(convertResultData, "convertResultData");
        com.tencent.mobileqq.nt.msgpush.troop.processor.a b16 = convertResultData.b();
        if (b16 == null || (g16 = b16.g()) == null) {
            return;
        }
        if (g16.has() && g16.msg_icons.has()) {
            try {
                nt_im_msg_general_flags_body$MsgIcon nt_im_msg_general_flags_body_msgicon = g16.msg_icons.get();
                ITmMsgIconService d16 = d();
                if (d16 != null) {
                    d16.cacheMemberIconData(b16.h(), nt_im_msg_general_flags_body_msgicon);
                }
                ITmMsgIconService d17 = d();
                if (d17 != null) {
                    d17.getMemberIconData(b16.h(), new b(nt_im_msg_general_flags_body_msgicon, b16));
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.i("TroopMemberMsgIconProcessor", 1, "[process] exception = " + e16);
                return;
            }
        }
        QLog.i("TroopMemberMsgIconProcessor", 2, " [process] msgIcon is null");
    }
}
