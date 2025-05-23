package com.tencent.qqnt.notification.struct;

import android.content.Intent;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.qqnt.global.settings.api.IGlobalSettingsApi;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.notification.NotificationFacade;
import com.tencent.qqnt.notification.logic.INotifyCountService;
import cooperation.qzone.QZoneHelper;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0014B)\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0016\u0010\n\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/notification/struct/NotificationElementBuilder;", "", "Landroid/content/Intent;", "Lcom/tencent/qqnt/notification/struct/BaseUinTypeProcessor;", "processor", "", "b", "Lcom/tencent/qqnt/notification/struct/d;", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqnt/global/settings/notification/a;", "notificationExtInfo", "e", "Lcom/tencent/qqnt/notification/struct/a;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "msgRecord", "d", "c", "()Lcom/tencent/qqnt/notification/struct/d;", "Lmqq/app/AppRuntime;", "a", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "", "Z", "forRevoke", "Lcom/tencent/qqnt/global/settings/notification/a;", "<init>", "(Lmqq/app/AppRuntime;Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;ZLcom/tencent/qqnt/global/settings/notification/a;)V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NotificationElementBuilder {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f359879f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AppRuntime appRuntime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecentContactInfo msgRecord;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean forRevoke;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.global.settings.notification.a notificationExtInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/notification/struct/NotificationElementBuilder$a;", "", "", "showRevokeNotification", "Z", "a", "()Z", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.struct.NotificationElementBuilder$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return NotificationElementBuilder.f359879f;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45565);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f359879f = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("notification_show_revoke_notification_9055", true);
        }
    }

    public NotificationElementBuilder(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo msgRecord, boolean z16, @Nullable com.tencent.qqnt.global.settings.notification.a aVar) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, msgRecord, Boolean.valueOf(z16), aVar);
            return;
        }
        this.appRuntime = appRuntime;
        this.msgRecord = msgRecord;
        this.forRevoke = z16;
        this.notificationExtInfo = aVar;
    }

    private final void b(Intent intent, BaseUinTypeProcessor baseUinTypeProcessor) {
        intent.putExtra("key_msg_id", this.msgRecord.msgId);
        intent.putExtra("key_msg_seq", this.msgRecord.getMsgSeq());
        intent.putExtra(QZoneHelper.Constants.KEY_MSG_TIME, this.msgRecord.msgTime);
        intent.putExtra("key_notification_time", System.currentTimeMillis());
        intent.putExtra("key_processor_type", baseUinTypeProcessor.getClass().getSimpleName());
    }

    private final void d(RecentContactInfo msgRecord, d element) {
        String str;
        IRuntimeService runtimeService = this.appRuntime.getRuntimeService(INotifyCountService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        int countBySession = ((INotifyCountService) runtimeService).getCountBySession(msgRecord.peerUin, msgRecord.chatType);
        if (countBySession <= 1) {
            return;
        }
        String m3 = element.m();
        if (countBySession > 100) {
            str = this.appRuntime.getApp().getString(R.string.ckz);
        } else {
            str = countBySession + this.appRuntime.getApp().getString(R.string.cip);
        }
        Intrinsics.checkNotNullExpressionValue(str, "if (count > 100) appRunt\u2026tString(R.string.new_msg)");
        element.z(m3 + "(" + str + ")");
    }

    private final void e(d element, com.tencent.qqnt.global.settings.notification.a notificationExtInfo) {
        if (!((IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class)).isGlobalShowPreview()) {
            return;
        }
        IGlobalSettingsApi iGlobalSettingsApi = (IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class);
        RecentContactInfo recentContactInfo = this.msgRecord;
        if (!iGlobalSettingsApi.isSessionShowPreview(recentContactInfo.peerUin, recentContactInfo.chatType, notificationExtInfo)) {
            element.z(NotificationFacade.INSTANCE.a().a(element.m(), this.msgRecord));
        }
        IGlobalSettingsApi iGlobalSettingsApi2 = (IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class);
        RecentContactInfo recentContactInfo2 = this.msgRecord;
        if (!iGlobalSettingsApi2.isSessionShowPreview(recentContactInfo2.peerUin, recentContactInfo2.chatType, notificationExtInfo)) {
            element.r(NotificationFacade.INSTANCE.a().c(element.e(), this.msgRecord));
        }
    }

    private final void f(d element, a processor) {
        int totalCount;
        if (!((IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class)).isGlobalShowPreview()) {
            return;
        }
        IRuntimeService runtimeService = this.appRuntime.getRuntimeService(INotifyCountService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        INotifyCountService iNotifyCountService = (INotifyCountService) runtimeService;
        if (INotifyCountService.a.a(iNotifyCountService, false, 1, null) <= 1 || (totalCount = iNotifyCountService.getTotalCount(true)) == 0 || !processor.t()) {
            return;
        }
        final int newConversationSizeWithoutPublicAccount = iNotifyCountService.getNewConversationSizeWithoutPublicAccount(true);
        if (newConversationSizeWithoutPublicAccount <= 1) {
            com.tencent.qqnt.notification.util.a.f359909a.b("Notification.Builder", new Function0<String>(newConversationSizeWithoutPublicAccount) { // from class: com.tencent.qqnt.notification.struct.NotificationElementBuilder$postBuildBusinessFoldedElement$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $conversationSizeNotSeparate;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$conversationSizeNotSeparate = newConversationSizeWithoutPublicAccount;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, newConversationSizeWithoutPublicAccount);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "conversationSizeNotSeparate<=1, conversationSizeNotSeparate:" + this.$conversationSizeNotSeparate;
                }
            });
            return;
        }
        NotificationFacade.Companion companion = NotificationFacade.INSTANCE;
        Intent d16 = companion.a().d(this.appRuntime.getApp());
        d16.addFlags(335544320);
        companion.a().k(d16);
        element.s(d16);
        String string = this.appRuntime.getApp().getString(R.string.notification_title);
        Intrinsics.checkNotNullExpressionValue(string, "appRuntime.app.getString\u2026tring.notification_title)");
        element.z(string);
        StringBuilder sb5 = new StringBuilder();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string2 = this.appRuntime.getApp().getString(R.string.ckw);
        Intrinsics.checkNotNullExpressionValue(string2, "appRuntime.app.getString\u2026string.notification_have)");
        String format = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(newConversationSizeWithoutPublicAccount)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        sb5.append(format);
        if (totalCount > 1000) {
            sb5.append(this.appRuntime.getApp().getString(R.string.ckx));
        } else {
            sb5.append(totalCount);
            sb5.append(this.appRuntime.getApp().getString(R.string.cip));
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        element.q(sb6);
        element.r(companion.a().c(element.e(), this.msgRecord));
    }

    @Nullable
    public final d c() {
        boolean z16;
        final int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        final boolean isGlobalShowPreview = ((IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class)).isGlobalShowPreview();
        IGlobalSettingsApi iGlobalSettingsApi = (IGlobalSettingsApi) QRoute.api(IGlobalSettingsApi.class);
        RecentContactInfo recentContactInfo = this.msgRecord;
        final boolean isSessionShowPreview = iGlobalSettingsApi.isSessionShowPreview(recentContactInfo.peerUin, recentContactInfo.chatType, this.notificationExtInfo);
        final d dVar = new d();
        BaseUinTypeProcessor b16 = ProcessorFactory.INSTANCE.a().b(this.appRuntime, this.msgRecord);
        if (b16 == null) {
            return null;
        }
        dVar.p(this.msgRecord.chatType);
        if (isGlobalShowPreview && isSessionShowPreview) {
            z16 = true;
        } else {
            z16 = false;
        }
        dVar.w(z16);
        if (isGlobalShowPreview) {
            dVar.n(b16.f());
            dVar.q(b16.h(dVar.a(), this.notificationExtInfo));
            dVar.z(b16.r());
            dVar.z(NotificationFacade.INSTANCE.a().n(dVar.m()));
            d(this.msgRecord, dVar);
            if (!this.forRevoke) {
                dVar.y(b16.q(dVar.m(), dVar.d()));
            }
            dVar.r(b16.j());
            i3 = b16.a();
            Intent k3 = b16.k();
            if (k3 != null) {
                k3.putExtra("KEY_NOTIFY_ID_FROM_PROCESSOR", i3);
                k3.putExtra(QQNotificationManager.PARAM_NOTIFYID, i3);
                b(k3, b16);
            } else {
                k3 = null;
            }
            dVar.s(k3);
        } else {
            dVar.q(b16.i());
            dVar.z(b16.s());
            dVar.z(NotificationFacade.INSTANCE.a().n(dVar.m()));
            if (!this.forRevoke) {
                dVar.y(b16.q(dVar.m(), dVar.d()));
            }
            dVar.s(b16.l());
            i3 = -113;
        }
        if (this.forRevoke && f359879f) {
            String string = MobileQQ.sMobileQQ.getResources().getString(R.string.f221346ak);
            Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.resources.getS\u2026revoke_tips_text_summary)");
            dVar.n(b16.h(string, this.notificationExtInfo));
            dVar.q(dVar.a());
        }
        dVar.x(b16.p());
        dVar.o(b16.g());
        dVar.t(b16.m());
        try {
            Intent f16 = dVar.f();
            Intrinsics.checkNotNull(f16);
            dVar.u(b16.n(i3, f16));
            try {
                if (dVar.j()) {
                    dVar.v(b16.o(i3));
                } else {
                    com.tencent.qqnt.notification.util.a.f359909a.b("Notification.Builder", new Function0<String>(isSessionShowPreview, isGlobalShowPreview) { // from class: com.tencent.qqnt.notification.struct.NotificationElementBuilder$build$3
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ boolean $showPreviewGlobal;
                        final /* synthetic */ boolean $showPreviewSession;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$showPreviewSession = isSessionShowPreview;
                            this.$showPreviewGlobal = isGlobalShowPreview;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, Boolean.valueOf(isSessionShowPreview), Boolean.valueOf(isGlobalShowPreview));
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            return "no need to create reply pending intent, preview=" + this.$showPreviewSession + "-" + this.$showPreviewGlobal;
                        }
                    });
                }
            } catch (Exception e16) {
                com.tencent.qqnt.notification.util.a.f359909a.b("Notification.Builder", new Function0<String>(e16) { // from class: com.tencent.qqnt.notification.struct.NotificationElementBuilder$build$4
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Exception $e;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$e = e16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) e16);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        return "failed to create reply pending intent, exc=" + this.$e;
                    }
                });
            }
            if (b.class.isAssignableFrom(b16.getClass())) {
                e(dVar, this.notificationExtInfo);
            }
            if (a.class.isAssignableFrom(b16.getClass())) {
                f(dVar, (a) b16);
            }
            com.tencent.qqnt.notification.util.a.f359909a.b("Notification.Builder", new Function0<String>(i3) { // from class: com.tencent.qqnt.notification.struct.NotificationElementBuilder$build$5
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $notifyId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$notifyId = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) d.this, i3);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "notificationElement build: " + d.this + ", notifyId: " + this.$notifyId;
                }
            });
            return dVar;
        } catch (NullPointerException unused) {
            com.tencent.qqnt.notification.util.a.f359909a.b("Notification.Builder", new Function0<String>() { // from class: com.tencent.qqnt.notification.struct.NotificationElementBuilder$build$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) d.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "failed to create pending intent, intent=" + d.this.f();
                }
            });
            return null;
        }
    }
}
