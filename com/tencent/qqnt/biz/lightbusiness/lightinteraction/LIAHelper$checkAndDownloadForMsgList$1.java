package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAHelper$checkAndDownloadForMsgList$1;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.LIAActionItem;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0000H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;", "it", "", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class LIAHelper$checkAndDownloadForMsgList$1 extends Lambda implements Function1<Map<Integer, ? extends List<? extends com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>>, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Contact $contact;
    final /* synthetic */ LIAActionItem $item;
    final /* synthetic */ d $listener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.biz.lightbusiness.lightinteraction.LIAHelper$checkAndDownloadForMsgList$1$2, reason: invalid class name */
    /* loaded from: classes23.dex */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        static IPatchRedirector $redirector_;
        final /* synthetic */ Contact $contact;
        final /* synthetic */ LIAActionItem $item;
        final /* synthetic */ d $listener;
        final /* synthetic */ com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b $res;
        final /* synthetic */ String $uid;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, LIAActionItem lIAActionItem, Contact contact, com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b bVar, d dVar) {
            super(1);
            this.$uid = str;
            this.$item = lIAActionItem;
            this.$contact = contact;
            this.$res = bVar;
            this.$listener = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, lIAActionItem, contact, bVar, dVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(d listener) {
            Intrinsics.checkNotNullParameter(listener, "$listener");
            listener.onFail();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            QLog.d("LIAHelper", 1, "[handlePreloadRes] uid=" + this.$uid + ", type=" + this.$item.getType() + " success=" + z16);
            if (z16) {
                this.$item.l(com.tencent.qqnt.biz.lightbusiness.lightinteraction.replace.c.f353167a.a(new com.tencent.qqnt.biz.lightbusiness.lightinteraction.replace.d(this.$contact), this.$res.a()));
                LIAHelper lIAHelper = LIAHelper.f353124a;
                String uid = this.$uid;
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                lIAHelper.m(uid, this.$res, this.$listener);
                return;
            }
            LIAHelper lIAHelper2 = LIAHelper.f353124a;
            final d dVar = this.$listener;
            lIAHelper2.h(new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.m
                @Override // java.lang.Runnable
                public final void run() {
                    LIAHelper$checkAndDownloadForMsgList$1.AnonymousClass2.b(d.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LIAHelper$checkAndDownloadForMsgList$1(LIAActionItem lIAActionItem, Contact contact, d dVar) {
        super(1);
        this.$item = lIAActionItem;
        this.$contact = contact;
        this.$listener = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, lIAActionItem, contact, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(d listener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        listener.onFail();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Map<Integer, ? extends List<? extends com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> map) {
        invoke2((Map<Integer, ? extends List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>>) map);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Map<Integer, ? extends List<com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b>> it) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            return;
        }
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b j3 = LIAConfigManager.INSTANCE.a().j(this.$item.getType(), this.$item.c());
        if (j3 == null) {
            LIAHelper lIAHelper = LIAHelper.f353124a;
            final d dVar = this.$listener;
            lIAHelper.h(new Runnable() { // from class: com.tencent.qqnt.biz.lightbusiness.lightinteraction.l
                @Override // java.lang.Runnable
                public final void run() {
                    LIAHelper$checkAndDownloadForMsgList$1.b(d.this);
                }
            });
        } else {
            String uid = this.$contact.peerUid;
            LIAInjectUtil lIAInjectUtil = LIAInjectUtil.f353125a;
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            LIAActionItem lIAActionItem = this.$item;
            lIAInjectUtil.i(uid, lIAActionItem, j3, new AnonymousClass2(uid, lIAActionItem, this.$contact, j3, this.$listener));
        }
    }
}
