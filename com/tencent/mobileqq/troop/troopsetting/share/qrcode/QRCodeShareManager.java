package com.tencent.mobileqq.troop.troopsetting.share.qrcode;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.sharepanel.j;
import com.tencent.mobileqq.sharepanel.m;
import com.tencent.mobileqq.sharepanel.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR0\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/qrcode/QRCodeShareManager;", "", "", "type", "Lcom/tencent/mobileqq/troop/troopsetting/share/a;", "c", "shareAction", "", "b", "Lcom/tencent/mobileqq/troop/troopsetting/share/b;", "shareContext", "d", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "shareActions", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class QRCodeShareManager {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, com.tencent.mobileqq.troop.troopsetting.share.a> shareActions;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/qrcode/QRCodeShareManager$a;", "", "Lcom/tencent/mobileqq/troop/troopsetting/share/qrcode/QRCodeShareManager;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.share.qrcode.QRCodeShareManager$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final QRCodeShareManager a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QRCodeShareManager) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            QRCodeShareManager qRCodeShareManager = new QRCodeShareManager();
            qRCodeShareManager.b(new QRWeChatShareAction());
            qRCodeShareManager.b(new QRFriendShareAction());
            qRCodeShareManager.b(new QRSpecificFriendShareAction());
            qRCodeShareManager.b(new QRQZoneShareAction());
            qRCodeShareManager.b(new a());
            qRCodeShareManager.b(new e());
            return qRCodeShareManager;
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/share/qrcode/QRCodeShareManager$b", "Lcom/tencent/mobileqq/sharepanel/j;", "", "channelId", "", "a", "actionId", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements j {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.troopsetting.share.b f301460a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QRCodeShareManager f301461b;

        b(com.tencent.mobileqq.troop.troopsetting.share.b bVar, QRCodeShareManager qRCodeShareManager) {
            this.f301460a = bVar;
            this.f301461b = qRCodeShareManager;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) qRCodeShareManager);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(@NotNull String channelId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) channelId);
                return;
            }
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.f301460a.i(channelId);
            com.tencent.mobileqq.troop.troopsetting.share.a c16 = this.f301461b.c(channelId);
            if (c16 != null) {
                c16.a(this.f301460a);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(@NotNull String actionId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) actionId);
                return;
            }
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            this.f301460a.i(actionId);
            com.tencent.mobileqq.troop.troopsetting.share.a c16 = this.f301461b.c(actionId);
            if (c16 != null) {
                c16.a(this.f301460a);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/share/qrcode/QRCodeShareManager$c", "Lcom/tencent/mobileqq/sharepanel/a;", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "targetList", "", "l", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c extends com.tencent.mobileqq.sharepanel.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.troop.troopsetting.share.b f301463b;

        c(com.tencent.mobileqq.troop.troopsetting.share.b bVar) {
            this.f301463b = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QRCodeShareManager.this, (Object) bVar);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.a, com.tencent.mobileqq.sharepanel.d
        public boolean l(@NotNull List<? extends ResultRecord> targetList) {
            Unit unit;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) targetList)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(targetList, "targetList");
            com.tencent.mobileqq.troop.troopsetting.share.a c16 = QRCodeShareManager.this.c("qqfriend");
            if (c16 != null) {
                c16.a(this.f301463b);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                return super.l(targetList);
            }
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60982);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QRCodeShareManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.shareActions = new LinkedHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.troop.troopsetting.share.a c(String type) {
        return this.shareActions.get(type);
    }

    public final void b(@NotNull com.tencent.mobileqq.troop.troopsetting.share.a shareAction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) shareAction);
            return;
        }
        Intrinsics.checkNotNullParameter(shareAction, "shareAction");
        Iterator<T> it = shareAction.d().iterator();
        while (it.hasNext()) {
            this.shareActions.put((String) it.next(), shareAction);
        }
    }

    public final void d(@NotNull final com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) shareContext);
            return;
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (shareContext.e() == null) {
            return;
        }
        ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel(shareContext.b(), "group_qrcode").q0(shareContext.e()).k0(new n(this) { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.QRCodeShareManager$showSharePanel$1
            static IPatchRedirector $redirector_;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ QRCodeShareManager f301465b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f301465b = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.troop.troopsetting.share.b.this, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.sharepanel.n
            public void a(@NotNull ArrayList<ResultRecord> targetList, @NotNull final m callback) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) targetList, (Object) callback);
                    return;
                }
                Intrinsics.checkNotNullParameter(targetList, "targetList");
                Intrinsics.checkNotNullParameter(callback, "callback");
                com.tencent.mobileqq.troop.troopsetting.share.b.this.j(new Function1<Intent, Unit>() { // from class: com.tencent.mobileqq.troop.troopsetting.share.qrcode.QRCodeShareManager$showSharePanel$1$prepareForwardData$1
                    static IPatchRedirector $redirector_;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) m.this);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                        invoke2(intent);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Intent intent) {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, (Object) intent);
                        } else if (intent != null) {
                            m.this.a(intent);
                        } else {
                            m.this.onFail();
                        }
                    }
                });
                com.tencent.mobileqq.troop.troopsetting.share.a c16 = this.f301465b.c("QRSpecificFriendShareAction");
                if (c16 != null) {
                    c16.a(com.tencent.mobileqq.troop.troopsetting.share.b.this);
                }
            }
        }).t0(new b(shareContext, this)).p0(new c(shareContext)).show();
    }
}
