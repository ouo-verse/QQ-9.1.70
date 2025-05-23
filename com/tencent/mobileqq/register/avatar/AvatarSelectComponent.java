package com.tencent.mobileqq.register.avatar;

import android.app.Activity;
import android.app.Dialog;
import android.net.Uri;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.register.avatar.AvatarSelectComponent;
import com.tencent.mobileqq.register.bean.ZPlanAvatarInfo;
import com.tencent.mobileqq.relation.api.IProfileCardUtil;
import com.tencent.mobileqq.servlet.RegisterZPlanAvatarHandler;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.util.cb;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LoadingUtil;
import java.lang.ref.SoftReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0002\u0012\u0018B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J4\u0010\r\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u001c\u0010\u0003\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00040\u000bH\u0002J4\u0010\u000e\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u001c\u0010\u0003\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00040\u000bH\u0002J$\u0010\u000f\u001a\u00020\u00042\u001c\u0010\u0003\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00040\u000bJ\u0006\u0010\u0010\u001a\u00020\u0004R\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/register/avatar/AvatarSelectComponent;", "", "Lcom/tencent/mobileqq/register/avatar/AvatarSelectComponent$a;", "callback", "", "d", "k", "f", "", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "avatarList", "Lkotlin/Function2;", "Landroid/net/Uri;", tl.h.F, "j", "i", "g", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "e", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "b", "Z", "hasFetched", "Lcom/tencent/mobileqq/register/avatar/h;", "c", "Lcom/tencent/mobileqq/register/avatar/h;", "avatarSelectorDialog", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "loadingDialog", "<init>", "(Landroid/app/Activity;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AvatarSelectComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasFetched;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h avatarSelectorDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u0010\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005RU\u0010\u000f\u001a@\u0012<\u0012:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007 \u000b*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n0\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/register/avatar/AvatarSelectComponent$a;", "", "", "Lcom/tencent/mobileqq/register/bean/ZPlanAvatarInfo;", "avatarList", "", "isUpdate", "", "a", "Ljava/lang/ref/SoftReference;", "Lkotlin/Function2;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/SoftReference;", "getCallbackRef", "()Ljava/lang/ref/SoftReference;", "callbackRef", "callback", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final SoftReference<Function2<List<ZPlanAvatarInfo>, Boolean, Unit>> callbackRef;

        public a(@NotNull Function2<? super List<ZPlanAvatarInfo>, ? super Boolean, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) callback);
            } else {
                this.callbackRef = new SoftReference<>(callback);
            }
        }

        public final void a(@NotNull List<ZPlanAvatarInfo> avatarList, boolean isUpdate) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, avatarList, Boolean.valueOf(isUpdate));
                return;
            }
            Intrinsics.checkNotNullParameter(avatarList, "avatarList");
            Function2<List<ZPlanAvatarInfo>, Boolean, Unit> function2 = this.callbackRef.get();
            if (function2 == null) {
                QLog.e("AvatarSelectComponent", 1, "callback is null");
            } else {
                function2.invoke(avatarList, Boolean.valueOf(isUpdate));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/register/avatar/AvatarSelectComponent$b;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.register.avatar.AvatarSelectComponent$b, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26526);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AvatarSelectComponent(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        } else {
            this.activity = activity;
        }
    }

    private final void d(final a callback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        BusinessHandler businessHandler = ((AppInterface) peekAppRuntime).getBusinessHandler(RegisterZPlanAvatarHandler.class.getName());
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.servlet.RegisterZPlanAvatarHandler");
        ((RegisterZPlanAvatarHandler) businessHandler).G2(new Function1<List<? extends ZPlanAvatarInfo>, Unit>() { // from class: com.tencent.mobileqq.register.avatar.AvatarSelectComponent$fetchAvatarList$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AvatarSelectComponent.a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZPlanAvatarInfo> list) {
                invoke2((List<ZPlanAvatarInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull List<ZPlanAvatarInfo> it) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                com.tencent.mobileqq.register.util.c cVar = com.tencent.mobileqq.register.util.c.f280585a;
                if (!Intrinsics.areEqual(it, cVar.a())) {
                    z16 = true;
                    if (!it.isEmpty()) {
                        QLog.i("AvatarSelectComponent", 1, "fetchAvatarList update data");
                        cVar.g(it);
                        AvatarSelectComponent.a.this.a(it, z16);
                    }
                }
                z16 = false;
                AvatarSelectComponent.a.this.a(it, z16);
            }
        });
        this.hasFetched = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        Dialog dialog;
        if (!this.activity.isFinishing() && !this.activity.isDestroyed()) {
            try {
                Dialog dialog2 = this.loadingDialog;
                boolean z16 = false;
                if (dialog2 != null && dialog2.isShowing()) {
                    z16 = true;
                }
                if (z16 && (dialog = this.loadingDialog) != null) {
                    dialog.dismiss();
                }
            } catch (Exception e16) {
                QLog.e("AvatarSelectComponent", 1, "hideLoading error:" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(List<ZPlanAvatarInfo> avatarList, Function2<? super ZPlanAvatarInfo, ? super Uri, Unit> callback) {
        if (!this.activity.isFinishing() && !this.activity.isDestroyed()) {
            h hVar = this.avatarSelectorDialog;
            boolean z16 = false;
            if (hVar != null && hVar.isShowing()) {
                z16 = true;
            }
            if (z16) {
                QLog.e("AvatarSelectComponent", 1, "safeShowDialog isShowing");
                return;
            }
            try {
                j(avatarList, callback);
            } catch (Exception e16) {
                QLog.e("AvatarSelectComponent", 1, "safeShowDialog error:" + e16);
            }
        }
    }

    private final void j(List<ZPlanAvatarInfo> avatarList, final Function2<? super ZPlanAvatarInfo, ? super Uri, Unit> callback) {
        h hVar = this.avatarSelectorDialog;
        if (hVar != null) {
            if (hVar != null) {
                hVar.show();
            }
        } else {
            h hVar2 = new h(this.activity, avatarList, new b(callback) { // from class: com.tencent.mobileqq.register.avatar.AvatarSelectComponent$showDialog$1
                static IPatchRedirector $redirector_;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ Function2<ZPlanAvatarInfo, Uri, Unit> f280336b;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    this.f280336b = callback;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AvatarSelectComponent.this, (Object) callback);
                    }
                }

                @Override // com.tencent.mobileqq.register.avatar.b
                public void a() {
                    h hVar3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.d("AvatarSelectComponent", 2, "onClickSelectFromCamera ");
                    com.tencent.mobileqq.register.util.c cVar = com.tencent.mobileqq.register.util.c.f280585a;
                    Activity e16 = AvatarSelectComponent.this.e();
                    final AvatarSelectComponent avatarSelectComponent = AvatarSelectComponent.this;
                    final Function2<ZPlanAvatarInfo, Uri, Unit> function2 = this.f280336b;
                    cVar.h(e16, QQPermissionConstants.Business.SCENE.AVATAR_CAMERA, QQPermissionConstants.Permission.CAMERA, new Function0<Unit>(function2) { // from class: com.tencent.mobileqq.register.avatar.AvatarSelectComponent$showDialog$1$onClickSelectFromCamera$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Function2<ZPlanAvatarInfo, Uri, Unit> $callback;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                            this.$callback = function2;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarSelectComponent.this, (Object) function2);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                this.$callback.invoke(null, ((IProfileCardUtil) QRoute.api(IProfileCardUtil.class)).takePhoto(AvatarSelectComponent.this.e()));
                            }
                        }
                    });
                    cb.f306645a.i("0X800C329");
                    hVar3 = AvatarSelectComponent.this.avatarSelectorDialog;
                    if (hVar3 != null) {
                        hVar3.R();
                    }
                }

                @Override // com.tencent.mobileqq.register.avatar.b
                public void b() {
                    h hVar3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                        return;
                    }
                    QLog.d("AvatarSelectComponent", 2, "onClickSelectFromAlbum ");
                    hVar3 = AvatarSelectComponent.this.avatarSelectorDialog;
                    if (hVar3 != null) {
                        hVar3.R();
                    }
                    com.tencent.mobileqq.register.util.c cVar = com.tencent.mobileqq.register.util.c.f280585a;
                    Activity e16 = AvatarSelectComponent.this.e();
                    final AvatarSelectComponent avatarSelectComponent = AvatarSelectComponent.this;
                    cVar.h(e16, QQPermissionConstants.Business.SCENE.AVATAR_PTOTO, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE, new Function0<Unit>() { // from class: com.tencent.mobileqq.register.avatar.AvatarSelectComponent$showDialog$1$onClickSelectFromAlbum$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarSelectComponent.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                ((IProfileCardUtil) QRoute.api(IProfileCardUtil.class)).selectPhotoFromAlum(AvatarSelectComponent.this.e());
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                    cb.f306645a.i("0X800C328");
                }

                @Override // com.tencent.mobileqq.register.avatar.b
                public void c(@NotNull ZPlanAvatarInfo avatarInfo) {
                    h hVar3;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) avatarInfo);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
                    QLog.d("AvatarSelectComponent", 2, "onClickZPlanAvatar ");
                    hVar3 = AvatarSelectComponent.this.avatarSelectorDialog;
                    if (hVar3 != null) {
                        hVar3.R();
                    }
                    this.f280336b.invoke(avatarInfo, null);
                    String j3 = avatarInfo.j();
                    if (j3 == null) {
                        j3 = "";
                    }
                    String c16 = o.c();
                    Intrinsics.checkNotNullExpressionValue(c16, "getQimei36()");
                    cb.e("0X800C59B", j3, c16);
                }
            });
            this.avatarSelectorDialog = hVar2;
            hVar2.show();
        }
    }

    private final void k() {
        Dialog dialog;
        if (this.activity.isFinishing() && this.activity.isDestroyed()) {
            return;
        }
        try {
            if (this.loadingDialog == null) {
                this.loadingDialog = LoadingUtil.showLoadingDialog(this.activity, HardCodeUtil.qqStr(R.string.k2e), true);
            }
            Dialog dialog2 = this.loadingDialog;
            boolean z16 = false;
            if (dialog2 != null && dialog2.isShowing()) {
                z16 = true;
            }
            if (!z16 && (dialog = this.loadingDialog) != null) {
                dialog.show();
            }
        } catch (Exception e16) {
            QLog.e("AvatarSelectComponent", 1, "showLoading error:" + e16);
        }
    }

    @NotNull
    public final Activity e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Activity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.activity;
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        h hVar = this.avatarSelectorDialog;
        if (hVar != null) {
            hVar.onConfigurationChanged();
        }
    }

    public final void i(@NotNull final Function2<? super ZPlanAvatarInfo, ? super Uri, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        List<ZPlanAvatarInfo> a16 = com.tencent.mobileqq.register.util.c.f280585a.a();
        if (!a16.isEmpty()) {
            h(a16, callback);
            if (this.hasFetched) {
                return;
            }
            d(new a(new AvatarSelectComponent$selectAvatar$1(this)));
            return;
        }
        k();
        d(new a(new Function2<List<? extends ZPlanAvatarInfo>, Boolean, Unit>(callback) { // from class: com.tencent.mobileqq.register.avatar.AvatarSelectComponent$selectAvatar$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function2<ZPlanAvatarInfo, Uri, Unit> $callback;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AvatarSelectComponent.this, (Object) callback);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZPlanAvatarInfo> list, Boolean bool) {
                invoke((List<ZPlanAvatarInfo>) list, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull List<ZPlanAvatarInfo> avatarInfoList, boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, avatarInfoList, Boolean.valueOf(z16));
                    return;
                }
                Intrinsics.checkNotNullParameter(avatarInfoList, "avatarInfoList");
                AvatarSelectComponent.this.f();
                AvatarSelectComponent.this.h(avatarInfoList, this.$callback);
            }
        }));
    }
}
