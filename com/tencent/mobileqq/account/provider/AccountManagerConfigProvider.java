package com.tencent.mobileqq.account.provider;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.account.processors.AccountListProcessor;
import com.tencent.mobileqq.account.processors.SubAccountBannerProcessor;
import com.tencent.mobileqq.account.processors.SubAccountProcessor;
import com.tencent.mobileqq.account.viewmodel.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.setting.processor.SettingConfigProvider;
import com.tencent.mobileqq.setting.processor.b;
import com.tencent.mobileqq.setting.processor.c;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.widget.listitem.Group;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u00a2\u0006\u0004\bB\u0010CJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010!R\u001b\u0010&\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010%R\u001b\u0010)\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010%R\u001b\u0010,\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010\u001a\u001a\u0004\b+\u0010%R\u001b\u0010/\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010\u001a\u001a\u0004\b.\u0010%R\u001b\u00102\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010\u001a\u001a\u0004\b1\u0010%R\u001b\u00105\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010\u001a\u001a\u0004\b4\u0010%R\u001b\u00108\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010\u001a\u001a\u0004\b7\u0010%R\u001b\u0010;\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010\u001a\u001a\u0004\b:\u0010%R\u001b\u0010>\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010\u001a\u001a\u0004\b=\u0010%R\u001b\u0010A\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010\u001a\u001a\u0004\b@\u0010%\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/account/provider/AccountManagerConfigProvider;", "Lcom/tencent/mobileqq/setting/processor/SettingConfigProvider;", "", "Lcom/tencent/mobileqq/setting/processor/b;", "L", "", "Lcom/tencent/mobileqq/setting/processor/c;", "G", "Landroid/content/Context;", "context", "f", "", "isEdit", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "e", "Landroid/content/Context;", "Lcom/tencent/mobileqq/account/viewmodel/a;", "Lcom/tencent/mobileqq/account/viewmodel/a;", "vm", "Landroidx/lifecycle/LifecycleOwner;", "g", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/mobileqq/setting/api/ISettingApi;", h.F, "Lkotlin/Lazy;", "H", "()Lcom/tencent/mobileqq/setting/api/ISettingApi;", "settingApi", "Lcom/tencent/mobileqq/qqsec/api/ISafeBlockApi;", "i", UserInfo.SEX_FEMALE, "()Lcom/tencent/mobileqq/qqsec/api/ISafeBlockApi;", "safeBlockApi", "j", "I", "()Lcom/tencent/mobileqq/setting/processor/c;", "subAccountBannerProcessor", "k", HippyTKDListViewAdapter.X, "accountListProcessor", "l", "J", "subAccountProcessor", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "E", "qIDProcessor", DomainData.DOMAIN_NAME, "D", "phoneNumItemProcessor", "o", "K", "thirdAccountBindProcessor", "p", "y", "accountPwdProcessor", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "B", "loginDeviceProcessor", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "gesturePwdProcessor", ReportConstant.COSTREPORT_PREFIX, BdhLogUtil.LogTag.Tag_Conn, "moreSecuritySettingProcessor", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/account/viewmodel/a;Landroidx/lifecycle/LifecycleOwner;)V", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class AccountManagerConfigProvider extends SettingConfigProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a vm;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner owner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy settingApi;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy safeBlockApi;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy subAccountBannerProcessor;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy accountListProcessor;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy subAccountProcessor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qIDProcessor;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy phoneNumItemProcessor;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy thirdAccountBindProcessor;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy accountPwdProcessor;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loginDeviceProcessor;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy gesturePwdProcessor;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy moreSecuritySettingProcessor;

    public AccountManagerConfigProvider(@NotNull Context context, @NotNull a vm5, @NotNull LifecycleOwner owner) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(owner, "owner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, vm5, owner);
            return;
        }
        this.context = context;
        this.vm = vm5;
        this.owner = owner;
        lazy = LazyKt__LazyJVMKt.lazy(AccountManagerConfigProvider$settingApi$2.INSTANCE);
        this.settingApi = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AccountManagerConfigProvider$safeBlockApi$2.INSTANCE);
        this.safeBlockApi = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<SubAccountBannerProcessor>() { // from class: com.tencent.mobileqq.account.provider.AccountManagerConfigProvider$subAccountBannerProcessor$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountManagerConfigProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SubAccountBannerProcessor invoke() {
                Context context2;
                a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (SubAccountBannerProcessor) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AccountManagerConfigProvider.this.context;
                aVar = AccountManagerConfigProvider.this.vm;
                return new SubAccountBannerProcessor(context2, aVar);
            }
        });
        this.subAccountBannerProcessor = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<AccountListProcessor>() { // from class: com.tencent.mobileqq.account.provider.AccountManagerConfigProvider$accountListProcessor$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountManagerConfigProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AccountListProcessor invoke() {
                Context context2;
                a aVar;
                LifecycleOwner lifecycleOwner;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (AccountListProcessor) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AccountManagerConfigProvider.this.context;
                aVar = AccountManagerConfigProvider.this.vm;
                lifecycleOwner = AccountManagerConfigProvider.this.owner;
                return new AccountListProcessor(context2, aVar, lifecycleOwner);
            }
        });
        this.accountListProcessor = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<SubAccountProcessor>() { // from class: com.tencent.mobileqq.account.provider.AccountManagerConfigProvider$subAccountProcessor$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountManagerConfigProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SubAccountProcessor invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (SubAccountProcessor) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AccountManagerConfigProvider.this.context;
                return new SubAccountProcessor(context2);
            }
        });
        this.subAccountProcessor = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.account.provider.AccountManagerConfigProvider$qIDProcessor$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountManagerConfigProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                ISettingApi H;
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                H = AccountManagerConfigProvider.this.H();
                context2 = AccountManagerConfigProvider.this.context;
                return H.getQIDProcessor(context2);
            }
        });
        this.qIDProcessor = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.account.provider.AccountManagerConfigProvider$phoneNumItemProcessor$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountManagerConfigProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                ISettingApi H;
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                H = AccountManagerConfigProvider.this.H();
                context2 = AccountManagerConfigProvider.this.context;
                return H.getPhoneNumItemProcessor(context2);
            }
        });
        this.phoneNumItemProcessor = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.account.provider.AccountManagerConfigProvider$thirdAccountBindProcessor$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountManagerConfigProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                ISafeBlockApi F;
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                F = AccountManagerConfigProvider.this.F();
                context2 = AccountManagerConfigProvider.this.context;
                return F.getThirdAccountBindProcessor(context2);
            }
        });
        this.thirdAccountBindProcessor = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.account.provider.AccountManagerConfigProvider$accountPwdProcessor$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountManagerConfigProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                ISafeBlockApi F;
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                F = AccountManagerConfigProvider.this.F();
                context2 = AccountManagerConfigProvider.this.context;
                return F.getAccountPwdProcessor(context2);
            }
        });
        this.accountPwdProcessor = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.account.provider.AccountManagerConfigProvider$loginDeviceProcessor$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountManagerConfigProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                ISafeBlockApi F;
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                F = AccountManagerConfigProvider.this.F();
                context2 = AccountManagerConfigProvider.this.context;
                return F.getLoginDeviceProcessor(context2);
            }
        });
        this.loginDeviceProcessor = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.account.provider.AccountManagerConfigProvider$gesturePwdProcessor$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountManagerConfigProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                ISafeBlockApi F;
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                F = AccountManagerConfigProvider.this.F();
                context2 = AccountManagerConfigProvider.this.context;
                return F.getGesturePwdProcessor(context2);
            }
        });
        this.gesturePwdProcessor = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.account.provider.AccountManagerConfigProvider$moreSecuritySettingProcessor$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountManagerConfigProvider.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                ISettingApi H;
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (c) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                H = AccountManagerConfigProvider.this.H();
                context2 = AccountManagerConfigProvider.this.context;
                return H.getMoreSecuritySettingProcessor(context2);
            }
        });
        this.moreSecuritySettingProcessor = lazy12;
    }

    private final c B() {
        Object value = this.loginDeviceProcessor.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loginDeviceProcessor>(...)");
        return (c) value;
    }

    private final c C() {
        return (c) this.moreSecuritySettingProcessor.getValue();
    }

    private final c D() {
        return (c) this.phoneNumItemProcessor.getValue();
    }

    private final c E() {
        return (c) this.qIDProcessor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISafeBlockApi F() {
        return (ISafeBlockApi) this.safeBlockApi.getValue();
    }

    private final List<c> G() {
        List<c> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(J());
        if (QVipQidProcessor.get().isEnableQid()) {
            mutableListOf.add(E());
        }
        mutableListOf.add(D());
        mutableListOf.add(K());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ISettingApi H() {
        return (ISettingApi) this.settingApi.getValue();
    }

    private final c I() {
        return (c) this.subAccountBannerProcessor.getValue();
    }

    private final c J() {
        return (c) this.subAccountProcessor.getValue();
    }

    private final c K() {
        Object value = this.thirdAccountBindProcessor.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-thirdAccountBindProcessor>(...)");
        return (c) value;
    }

    private final List<b> L() {
        List mutableListOf;
        List mutableListOf2;
        List mutableListOf3;
        List<b> mutableListOf4;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(I());
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(x());
        mutableListOf3 = CollectionsKt__CollectionsKt.mutableListOf(y(), B(), z(), C());
        mutableListOf4 = CollectionsKt__CollectionsKt.mutableListOf(new b(mutableListOf, null, null, 6, null), new b(mutableListOf2, "\u8d26\u53f7\u7ba1\u7406", null, 4, null), new b(G(), "\u8d26\u53f7\u5173\u8054", null, 4, null), new b(mutableListOf3, "\u5b89\u5168\u7ba1\u7406", null, 4, null));
        return mutableListOf4;
    }

    private final c x() {
        return (c) this.accountListProcessor.getValue();
    }

    private final c y() {
        Object value = this.accountPwdProcessor.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-accountPwdProcessor>(...)");
        return (c) value;
    }

    private final c z() {
        Object value = this.gesturePwdProcessor.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gesturePwdProcessor>(...)");
        return (c) value;
    }

    public final void A(boolean isEdit) {
        CharSequence c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, isEdit);
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<b> k3 = k();
        if (k3 != null) {
            for (b bVar : k3) {
                ArrayList arrayList2 = new ArrayList();
                for (c cVar : bVar.b()) {
                    com.tencent.mobileqq.widget.listitem.a<?> q16 = cVar.q();
                    if (cVar.j() != 0 && isEdit) {
                        q16.p(false);
                    }
                    cVar.s(q16);
                    arrayList2.add(q16);
                }
                if (isEdit) {
                    c16 = "";
                } else {
                    c16 = bVar.c();
                }
                if (!arrayList2.isEmpty()) {
                    CharSequence a16 = bVar.a();
                    Object[] array = arrayList2.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
                    arrayList.add(new Group(c16, a16, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
                }
            }
        }
        LiveData j3 = j();
        Object[] array2 = arrayList.toArray(new Group[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        j3.postValue(array2);
    }

    @Override // com.tencent.mobileqq.setting.processor.SettingConfigProvider
    @NotNull
    public List<b> f(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return L();
    }
}
