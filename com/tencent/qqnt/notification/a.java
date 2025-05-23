package com.tencent.qqnt.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.notification.inject.ICheckProcessor;
import com.tencent.qqnt.notification.inject.a;
import com.tencent.qqnt.notification.inject.b;
import com.tencent.qqnt.notification.inject.c;
import com.tencent.qqnt.notification.inject.d;
import com.tencent.qqnt.notification.inject.f;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0002\u0003\tBE\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\u0006\u0010 \u001a\u00020\u001c\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b%\u0010&B\u0011\b\u0012\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b%\u0010)R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\t\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0017\u0010 \u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0013\u0010\u001fR\u0019\u0010$\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\"\u001a\u0004\b\u001d\u0010#\u00a8\u0006+"}, d2 = {"Lcom/tencent/qqnt/notification/a;", "", "Lcom/tencent/qqnt/notification/inject/b;", "a", "Lcom/tencent/qqnt/notification/inject/b;", "c", "()Lcom/tencent/qqnt/notification/inject/b;", "intentProcessor", "Lcom/tencent/qqnt/notification/inject/a;", "b", "Lcom/tencent/qqnt/notification/inject/a;", "()Lcom/tencent/qqnt/notification/inject/a;", "avatarProcessor", "Lcom/tencent/qqnt/notification/inject/f;", "Lcom/tencent/qqnt/notification/inject/f;", "g", "()Lcom/tencent/qqnt/notification/inject/f;", "settingProcessor", "Lcom/tencent/qqnt/notification/inject/ICheckProcessor;", "d", "Lcom/tencent/qqnt/notification/inject/ICheckProcessor;", "()Lcom/tencent/qqnt/notification/inject/ICheckProcessor;", "checkProcessor", "Lcom/tencent/qqnt/notification/inject/d;", "e", "Lcom/tencent/qqnt/notification/inject/d;", "()Lcom/tencent/qqnt/notification/inject/d;", "notifyProcessor", "Lcom/tencent/qqnt/notification/inject/c;", "f", "Lcom/tencent/qqnt/notification/inject/c;", "()Lcom/tencent/qqnt/notification/inject/c;", "msgBriefProcessor", "Lcom/tencent/qqnt/notification/inject/e;", "Lcom/tencent/qqnt/notification/inject/e;", "()Lcom/tencent/qqnt/notification/inject/e;", "notifyTrackerProcessor", "<init>", "(Lcom/tencent/qqnt/notification/inject/b;Lcom/tencent/qqnt/notification/inject/a;Lcom/tencent/qqnt/notification/inject/f;Lcom/tencent/qqnt/notification/inject/ICheckProcessor;Lcom/tencent/qqnt/notification/inject/d;Lcom/tencent/qqnt/notification/inject/c;Lcom/tencent/qqnt/notification/inject/e;)V", "Lcom/tencent/qqnt/notification/a$a;", "builder", "(Lcom/tencent/qqnt/notification/a$a;)V", h.F, "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.notification.inject.b intentProcessor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.notification.inject.a avatarProcessor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.notification.inject.f settingProcessor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICheckProcessor checkProcessor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.notification.inject.d notifyProcessor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.notification.inject.c msgBriefProcessor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.notification.inject.e notifyTrackerProcessor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0019\u001a\u00020\u0018R$\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R$\u0010\t\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001c\u0010%\u001a\u0004\b!\u0010&R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00118\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b)\u0010+\u001a\u0004\b'\u0010,R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u00148\u0000@BX\u0080\u000e\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b-\u0010/\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/notification/a$a;", "", "Lcom/tencent/qqnt/notification/inject/b;", "intentProcessor", "k", "Lcom/tencent/qqnt/notification/inject/a;", "avatarProcessor", "i", "Lcom/tencent/qqnt/notification/inject/f;", "settingProcessor", "o", "Lcom/tencent/qqnt/notification/inject/d;", "notifyProcessor", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/notification/inject/ICheckProcessor;", "checkProcessor", "j", "Lcom/tencent/qqnt/notification/inject/c;", "msgBriefProcessor", "l", "Lcom/tencent/qqnt/notification/inject/e;", "notifyTrackerProcessor", "", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/notification/a;", "a", "<set-?>", "Lcom/tencent/qqnt/notification/inject/b;", "d", "()Lcom/tencent/qqnt/notification/inject/b;", "b", "Lcom/tencent/qqnt/notification/inject/a;", "()Lcom/tencent/qqnt/notification/inject/a;", "c", "Lcom/tencent/qqnt/notification/inject/f;", h.F, "()Lcom/tencent/qqnt/notification/inject/f;", "Lcom/tencent/qqnt/notification/inject/ICheckProcessor;", "()Lcom/tencent/qqnt/notification/inject/ICheckProcessor;", "e", "Lcom/tencent/qqnt/notification/inject/d;", "f", "()Lcom/tencent/qqnt/notification/inject/d;", "Lcom/tencent/qqnt/notification/inject/c;", "()Lcom/tencent/qqnt/notification/inject/c;", "g", "Lcom/tencent/qqnt/notification/inject/e;", "()Lcom/tencent/qqnt/notification/inject/e;", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public static final class C9661a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.qqnt.notification.inject.b intentProcessor;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.qqnt.notification.inject.a avatarProcessor;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.qqnt.notification.inject.f settingProcessor;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ICheckProcessor checkProcessor;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.qqnt.notification.inject.d notifyProcessor;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private com.tencent.qqnt.notification.inject.c msgBriefProcessor;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.qqnt.notification.inject.e notifyTrackerProcessor;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/notification/a$a$a", "Lcom/tencent/qqnt/notification/inject/a;", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.notification.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes24.dex */
        public static final class C9662a implements com.tencent.qqnt.notification.inject.a {
            static IPatchRedirector $redirector_;

            C9662a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.notification.inject.a
            @Nullable
            public Bitmap f(@NotNull RecentContactInfo recentContactInfo, boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Bitmap) iPatchRedirector.redirect((short) 2, this, recentContactInfo, Boolean.valueOf(z16));
                }
                return a.C9663a.a(this, recentContactInfo, z16);
            }

            @Override // com.tencent.qqnt.notification.inject.a
            @Nullable
            public Bitmap i(@NotNull RecentContactInfo recentContactInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) recentContactInfo);
                }
                return a.C9663a.b(this, recentContactInfo);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/notification/a$a$b", "Lcom/tencent/qqnt/notification/inject/ICheckProcessor;", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.notification.a$a$b */
        /* loaded from: classes24.dex */
        public static final class b implements ICheckProcessor {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
            public boolean a(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo recentContactInfo, @Nullable com.tencent.qqnt.notification.trace.a aVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, this, appRuntime, recentContactInfo, aVar)).booleanValue();
                }
                return ICheckProcessor.DefaultImpls.a(this, appRuntime, recentContactInfo, aVar);
            }

            @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
            public void b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                    iPatchRedirector.redirect((short) 8, (Object) this);
                } else {
                    ICheckProcessor.DefaultImpls.j(this);
                }
            }

            @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
            public boolean c(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo recentContactInfo, boolean z16, @Nullable com.tencent.qqnt.notification.trace.a aVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 10, this, appRuntime, recentContactInfo, Boolean.valueOf(z16), aVar)).booleanValue();
                }
                return ICheckProcessor.DefaultImpls.f(this, appRuntime, recentContactInfo, z16, aVar);
            }

            @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
            public boolean d(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo recentContactInfo, boolean z16, @Nullable com.tencent.qqnt.notification.trace.a aVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 7, this, appRuntime, recentContactInfo, Boolean.valueOf(z16), aVar)).booleanValue();
                }
                return ICheckProcessor.DefaultImpls.g(this, appRuntime, recentContactInfo, z16, aVar);
            }

            @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
            public void e(@NotNull AppRuntime appRuntime, boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                    iPatchRedirector.redirect((short) 9, this, appRuntime, Boolean.valueOf(z16));
                } else {
                    ICheckProcessor.DefaultImpls.k(this, appRuntime, z16);
                }
            }

            @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
            public boolean f(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo recentContactInfo, @Nullable com.tencent.qqnt.notification.trace.a aVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, recentContactInfo, aVar)).booleanValue();
                }
                return ICheckProcessor.DefaultImpls.c(this, appRuntime, recentContactInfo, aVar);
            }

            @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
            public void g(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo recentContactInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime, (Object) recentContactInfo);
                } else {
                    ICheckProcessor.DefaultImpls.i(this, appRuntime, recentContactInfo);
                }
            }

            @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
            public boolean h(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo recentContactInfo, @Nullable com.tencent.qqnt.notification.trace.a aVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 5, this, appRuntime, recentContactInfo, aVar)).booleanValue();
                }
                return ICheckProcessor.DefaultImpls.b(this, appRuntime, recentContactInfo, aVar);
            }

            @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
            public void i(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo recentContactInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime, (Object) recentContactInfo);
                } else {
                    ICheckProcessor.DefaultImpls.h(this, appRuntime, recentContactInfo);
                }
            }

            @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
            public boolean isAppForeground() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
                }
                return ICheckProcessor.DefaultImpls.d(this);
            }

            @Override // com.tencent.qqnt.notification.inject.ICheckProcessor
            public boolean isRobotUin(@NotNull String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).booleanValue();
                }
                return ICheckProcessor.DefaultImpls.e(this, str);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/notification/a$a$c", "Lcom/tencent/qqnt/notification/inject/b;", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.notification.a$a$c */
        /* loaded from: classes24.dex */
        public static final class c implements com.tencent.qqnt.notification.inject.b {
            static IPatchRedirector $redirector_;

            c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.notification.inject.b
            @NotNull
            public Intent d(@Nullable Context context) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Intent) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
                }
                return b.a.c(this, context);
            }

            @Override // com.tencent.qqnt.notification.inject.b
            @Nullable
            public Intent e(@Nullable RecentContactInfo recentContactInfo, @Nullable Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (Intent) iPatchRedirector.redirect((short) 5, (Object) this, (Object) recentContactInfo, (Object) intent);
                }
                return b.a.e(this, recentContactInfo, intent);
            }

            @Override // com.tencent.qqnt.notification.inject.b
            @NotNull
            public Intent k(@NotNull Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Intent) iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
                }
                return b.a.d(this, intent);
            }

            @Override // com.tencent.qqnt.notification.inject.b
            public boolean l(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
                }
                return b.a.a(this, i3);
            }

            @Override // com.tencent.qqnt.notification.inject.b
            @NotNull
            public Intent m(@NotNull Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (Intent) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
                }
                return b.a.b(this, intent);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/notification/a$a$d", "Lcom/tencent/qqnt/notification/inject/c;", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.notification.a$a$d */
        /* loaded from: classes24.dex */
        public static final class d implements com.tencent.qqnt.notification.inject.c {
            static IPatchRedirector $redirector_;

            d() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.notification.inject.c
            @NotNull
            public String j(@NotNull AppRuntime appRuntime, @NotNull RecentContactInfo recentContactInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime, (Object) recentContactInfo);
                }
                return c.a.b(this, appRuntime, recentContactInfo);
            }

            @Override // com.tencent.qqnt.notification.inject.c
            @NotNull
            public String n(@NotNull String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                }
                return c.a.a(this, str);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/notification/a$a$e", "Lcom/tencent/qqnt/notification/inject/d;", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.notification.a$a$e */
        /* loaded from: classes24.dex */
        public static final class e implements com.tencent.qqnt.notification.inject.d {
            static IPatchRedirector $redirector_;

            e() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.notification.inject.d
            public void a(@NotNull RecentContactInfo recentContactInfo, @NotNull Intent intent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) recentContactInfo, (Object) intent);
                } else {
                    d.a.b(this, recentContactInfo, intent);
                }
            }

            @Override // com.tencent.qqnt.notification.inject.d
            public void b(@NotNull Notification notification, int i3, boolean z16, @Nullable Integer num) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, notification, Integer.valueOf(i3), Boolean.valueOf(z16), num);
                } else {
                    d.a.a(this, notification, i3, z16, num);
                }
            }

            @Override // com.tencent.qqnt.notification.inject.d
            public void c(@NotNull RecentContactInfo recentContactInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) recentContactInfo);
                } else {
                    d.a.c(this, recentContactInfo);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/qqnt/notification/a$a$f", "Lcom/tencent/qqnt/notification/inject/f;", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.notification.a$a$f */
        /* loaded from: classes24.dex */
        public static final class f implements com.tencent.qqnt.notification.inject.f {
            static IPatchRedirector $redirector_;

            f() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.qqnt.notification.inject.f
            @NotNull
            public String a(@Nullable String str, @Nullable RecentContactInfo recentContactInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) recentContactInfo);
                }
                return f.a.b(this, str, recentContactInfo);
            }

            @Override // com.tencent.qqnt.notification.inject.f
            public boolean b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
                }
                return f.a.a(this);
            }

            @Override // com.tencent.qqnt.notification.inject.f
            @Nullable
            public Bitmap c(@Nullable Bitmap bitmap, @Nullable RecentContactInfo recentContactInfo) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap, (Object) recentContactInfo);
                }
                return f.a.c(this, bitmap, recentContactInfo);
            }

            @Override // com.tencent.qqnt.notification.inject.f
            public boolean g(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
                }
                return f.a.e(this, i3);
            }

            @Override // com.tencent.qqnt.notification.inject.f
            public boolean h() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                return f.a.d(this);
            }
        }

        public C9661a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.intentProcessor = new c();
            this.avatarProcessor = new C9662a();
            this.settingProcessor = new f();
            this.checkProcessor = new b();
            this.notifyProcessor = new e();
            this.msgBriefProcessor = new d();
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (a) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return new a(this, null);
        }

        @NotNull
        public final com.tencent.qqnt.notification.inject.a b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (com.tencent.qqnt.notification.inject.a) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.avatarProcessor;
        }

        @NotNull
        public final ICheckProcessor c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ICheckProcessor) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.checkProcessor;
        }

        @NotNull
        public final com.tencent.qqnt.notification.inject.b d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.qqnt.notification.inject.b) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.intentProcessor;
        }

        @NotNull
        public final com.tencent.qqnt.notification.inject.c e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (com.tencent.qqnt.notification.inject.c) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.msgBriefProcessor;
        }

        @NotNull
        public final com.tencent.qqnt.notification.inject.d f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (com.tencent.qqnt.notification.inject.d) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.notifyProcessor;
        }

        @Nullable
        public final com.tencent.qqnt.notification.inject.e g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (com.tencent.qqnt.notification.inject.e) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.notifyTrackerProcessor;
        }

        @NotNull
        public final com.tencent.qqnt.notification.inject.f h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (com.tencent.qqnt.notification.inject.f) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.settingProcessor;
        }

        @NotNull
        public final C9661a i(@NotNull com.tencent.qqnt.notification.inject.a avatarProcessor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (C9661a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) avatarProcessor);
            }
            Intrinsics.checkNotNullParameter(avatarProcessor, "avatarProcessor");
            this.avatarProcessor = avatarProcessor;
            return this;
        }

        @NotNull
        public final C9661a j(@NotNull ICheckProcessor checkProcessor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (C9661a) iPatchRedirector.redirect((short) 13, (Object) this, (Object) checkProcessor);
            }
            Intrinsics.checkNotNullParameter(checkProcessor, "checkProcessor");
            this.checkProcessor = checkProcessor;
            return this;
        }

        @NotNull
        public final C9661a k(@NotNull com.tencent.qqnt.notification.inject.b intentProcessor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (C9661a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) intentProcessor);
            }
            Intrinsics.checkNotNullParameter(intentProcessor, "intentProcessor");
            this.intentProcessor = intentProcessor;
            return this;
        }

        @NotNull
        public final C9661a l(@NotNull com.tencent.qqnt.notification.inject.c msgBriefProcessor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (C9661a) iPatchRedirector.redirect((short) 14, (Object) this, (Object) msgBriefProcessor);
            }
            Intrinsics.checkNotNullParameter(msgBriefProcessor, "msgBriefProcessor");
            this.msgBriefProcessor = msgBriefProcessor;
            return this;
        }

        @NotNull
        public final C9661a m(@NotNull com.tencent.qqnt.notification.inject.d notifyProcessor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (C9661a) iPatchRedirector.redirect((short) 12, (Object) this, (Object) notifyProcessor);
            }
            Intrinsics.checkNotNullParameter(notifyProcessor, "notifyProcessor");
            this.notifyProcessor = notifyProcessor;
            return this;
        }

        public final void n(@NotNull com.tencent.qqnt.notification.inject.e notifyTrackerProcessor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) notifyTrackerProcessor);
            } else {
                Intrinsics.checkNotNullParameter(notifyTrackerProcessor, "notifyTrackerProcessor");
                this.notifyTrackerProcessor = notifyTrackerProcessor;
            }
        }

        @NotNull
        public final C9661a o(@NotNull com.tencent.qqnt.notification.inject.f settingProcessor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (C9661a) iPatchRedirector.redirect((short) 11, (Object) this, (Object) settingProcessor);
            }
            Intrinsics.checkNotNullParameter(settingProcessor, "settingProcessor");
            this.settingProcessor = settingProcessor;
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/notification/a$b;", "", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.notification.a$b, reason: from kotlin metadata */
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

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41430);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ a(C9661a c9661a, DefaultConstructorMarker defaultConstructorMarker) {
        this(c9661a);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) c9661a, (Object) defaultConstructorMarker);
    }

    @NotNull
    public final com.tencent.qqnt.notification.inject.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.notification.inject.a) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.avatarProcessor;
    }

    @NotNull
    public final ICheckProcessor b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ICheckProcessor) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.checkProcessor;
    }

    @NotNull
    public final com.tencent.qqnt.notification.inject.b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.notification.inject.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.intentProcessor;
    }

    @NotNull
    public final com.tencent.qqnt.notification.inject.c d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.notification.inject.c) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.msgBriefProcessor;
    }

    @NotNull
    public final com.tencent.qqnt.notification.inject.d e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.qqnt.notification.inject.d) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.notifyProcessor;
    }

    @Nullable
    public final com.tencent.qqnt.notification.inject.e f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.qqnt.notification.inject.e) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.notifyTrackerProcessor;
    }

    @NotNull
    public final com.tencent.qqnt.notification.inject.f g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qqnt.notification.inject.f) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.settingProcessor;
    }

    a(com.tencent.qqnt.notification.inject.b bVar, com.tencent.qqnt.notification.inject.a aVar, com.tencent.qqnt.notification.inject.f fVar, ICheckProcessor iCheckProcessor, com.tencent.qqnt.notification.inject.d dVar, com.tencent.qqnt.notification.inject.c cVar, com.tencent.qqnt.notification.inject.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bVar, aVar, fVar, iCheckProcessor, dVar, cVar, eVar);
            return;
        }
        this.intentProcessor = bVar;
        this.avatarProcessor = aVar;
        this.settingProcessor = fVar;
        this.checkProcessor = iCheckProcessor;
        this.notifyProcessor = dVar;
        this.msgBriefProcessor = cVar;
        this.notifyTrackerProcessor = eVar;
    }

    a(C9661a c9661a) {
        this(c9661a.d(), c9661a.b(), c9661a.h(), c9661a.c(), c9661a.f(), c9661a.e(), c9661a.g());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this, (Object) c9661a);
    }
}
