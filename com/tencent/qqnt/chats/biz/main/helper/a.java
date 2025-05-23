package com.tencent.qqnt.chats.biz.main.helper;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAConfigManager;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAInjectUtil;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAScene;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.b;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.LIAActionItem;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.LIAAnimView;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/biz/main/helper/a;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/LIAActionItem;", "actionItem", "", "b", "Lcom/tencent/qqnt/chats/core/uievent/a$u;", "uiEvent", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "lightInterActionView", "c", "<init>", "()V", "chats_view_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f354330a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/chats/biz/main/helper/a$a", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b$a;", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b;", "anim", "", "a", "b", "chats_view_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.main.helper.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9567a implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ a.u f354331a;

        C9567a(a.u uVar) {
            this.f354331a = uVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) uVar);
            }
        }

        @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.b.a
        public void a(@NotNull b anim) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) anim);
            } else {
                Intrinsics.checkNotNullParameter(anim, "anim");
            }
        }

        @Override // com.tencent.qqnt.biz.lightbusiness.lightinteraction.b.a
        public void b(@NotNull b anim) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) anim);
                return;
            }
            Intrinsics.checkNotNullParameter(anim, "anim");
            anim.setOnAnimActionListener(null);
            anim.b(null);
            anim.a(null);
            a.f354330a.b(this.f354331a.d(), this.f354331a.a());
            QLog.d("ChatsLIAAnimHelper", 1, "[handleShowLightInterActionAnim] end to send msg");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39998);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f354330a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(g item, LIAActionItem actionItem) {
        String str;
        String str2;
        String str3;
        if (QLog.isDevelopLevel()) {
            QLog.d("ChatsLIAAnimHelper", 1, "after lia anim, to send msg. name=" + item.w().e());
        }
        LIAActionItem.b f16 = actionItem.f();
        String str4 = null;
        if (f16 != null) {
            str = f16.a();
        } else {
            str = null;
        }
        if (str != null) {
            LIAActionItem.b f17 = actionItem.f();
            if (f17 != null) {
                str2 = f17.a();
            } else {
                str2 = null;
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str3 = peekAppRuntime.getCurrentUid();
            } else {
                str3 = null;
            }
            if (Intrinsics.areEqual(str2, str3)) {
                com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b e16 = LIAConfigManager.INSTANCE.a().e(actionItem.getType(), actionItem.c());
                if (e16 == null) {
                    QLog.d("ChatsLIAAnimHelper", 1, "after lia anim, get res failed");
                    return;
                } else {
                    LIAInjectUtil.f353125a.h(null, LIAScene.MsgList, new LIAInjectUtil.a(actionItem, e16, null, new Contact(item.n(), item.k(), ex3.a.f(item.s())), false, 20, null));
                    return;
                }
            }
        }
        LIAActionItem.b f18 = actionItem.f();
        if (f18 != null) {
            str4 = f18.a();
        }
        QLog.d("ChatsLIAAnimHelper", 1, "after lia anim, send fail, because changed account, sendUid=" + str4);
    }

    public final void c(@NotNull a.u uiEvent, @Nullable LIAAnimView lightInterActionView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uiEvent, (Object) lightInterActionView);
            return;
        }
        Intrinsics.checkNotNullParameter(uiEvent, "uiEvent");
        if (lightInterActionView != null) {
            if (lightInterActionView.r()) {
                lightInterActionView.v();
            }
            lightInterActionView.setOnAnimActionListener(new C9567a(uiEvent));
            lightInterActionView.a(uiEvent.c());
            lightInterActionView.b(uiEvent.b());
            lightInterActionView.t();
        }
    }
}
