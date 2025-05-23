package com.tencent.qqnt.kernel.api.impl;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IEmoticonService;
import com.tencent.qqnt.kernel.api.IYellowFaceForManagerService;
import com.tencent.qqnt.kernel.api.impl.KernelSetterImpl;
import com.tencent.qqnt.kernel.nativeinterface.IKernelYellowFaceForManagerService;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTCommAbilitySession;
import com.tencent.qqnt.kernel.nativeinterface.InitCommAbilitySessionConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0002*\u00020\u0004H\u0002J-\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/EmoticonServiceImpl;", "Lcom/tencent/qqnt/kernel/api/IEmoticonService;", "", "initService", "Lmqq/app/AppRuntime;", "startSession", "T", "", "method", "Lkotlin/Function0;", WidgetCacheConstellationData.WORK, "check", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/api/IYellowFaceForManagerService;", "getYellowFaceForManagerService", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTCommAbilitySession;", "getCommAbilitySession", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/qqnt/kernel/api/impl/py;", "serviceContent", "Lcom/tencent/qqnt/kernel/api/impl/py;", "commAbilitySession", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTCommAbilitySession;", "yellowFaceService", "Lcom/tencent/qqnt/kernel/api/IYellowFaceForManagerService;", "<init>", "()V", "Companion", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class EmoticonServiceImpl implements IEmoticonService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String SUB_TAG_Wrapper = "Wrapper";

    @NotNull
    private static final String SYS_PATH_SUFFIX = "/databases";

    @NotNull
    private static final String TAG = "EmoticonService";

    @NotNull
    private static String currentUin;

    @Nullable
    private static String emoticonPath;

    @Nullable
    private IQQNTCommAbilitySession commAbilitySession;
    private py serviceContent;

    @Nullable
    private IYellowFaceForManagerService yellowFaceService;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0003\u001a\u00020\u0002*\u0004\u0018\u00010\u0002H\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0005\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/EmoticonServiceImpl$a;", "", "", "b", "SUB_TAG_Wrapper", "Ljava/lang/String;", "SYS_PATH_SUFFIX", "TAG", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.EmoticonServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(String str) {
            if (str == null) {
                return "";
            }
            return str;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46364);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
            currentUin = "";
        }
    }

    public EmoticonServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final <T> T check(String method, final Function0<? extends T> work) {
        py pyVar = this.serviceContent;
        if (pyVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
            pyVar = null;
        }
        return (T) pyVar.e().a(SUB_TAG_Wrapper, method, new Function0<T>(work) { // from class: com.tencent.qqnt.kernel.api.impl.EmoticonServiceImpl$check$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function0<T> $work;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.$work = work;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) work);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (T) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.$work.invoke();
            }
        });
    }

    private final synchronized void initService() {
        IQQNTCommAbilitySession iQQNTCommAbilitySession;
        if (this.yellowFaceService == null && (iQQNTCommAbilitySession = this.commAbilitySession) != null) {
            IKernelYellowFaceForManagerService yellowFaceForManagerService = iQQNTCommAbilitySession.getYellowFaceForManagerService();
            py pyVar = this.serviceContent;
            if (pyVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                pyVar = null;
            }
            this.yellowFaceService = new YellowFaceForManagerServiceImpl(yellowFaceForManagerService, pyVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void startSession(AppRuntime appRuntime) {
        String valueOf;
        IQQNTCommAbilitySession d16;
        int lastIndexOf$default;
        boolean z16;
        if (this.commAbilitySession == null) {
            String currentUin2 = appRuntime.getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin2, "this.currentUin");
            currentUin = currentUin2;
            if (KernelServiceImpl.INSTANCE.g()) {
                String currentUid = appRuntime.getCurrentUid();
                if (currentUid != null && currentUid.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    valueOf = INSTANCE.b(appRuntime.getCurrentUid());
                    if (emoticonPath == null) {
                        String it = appRuntime.getApp().getFilesDir().getPath();
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) it, "/", 0, false, 6, (Object) null);
                        String substring = it.substring(0, lastIndexOf$default);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        emoticonPath = substring + SYS_PATH_SUFFIX;
                    }
                    d16 = com.tencent.qqnt.kernel.nativeinterface.ch.d();
                    this.commAbilitySession = d16;
                    if (d16 != null) {
                        d16.init(new InitCommAbilitySessionConfig(appRuntime.getLongAccountUin(), valueOf, emoticonPath));
                    }
                    QLog.i(TAG, 2, "Emoticon Session create -> longAccountUin:" + LogUtil.wrapLogUin(String.valueOf(appRuntime.getLongAccountUin())) + ";curUid:" + valueOf);
                }
            }
            valueOf = String.valueOf(appRuntime.getLongAccountUin());
            if (emoticonPath == null) {
            }
            d16 = com.tencent.qqnt.kernel.nativeinterface.ch.d();
            this.commAbilitySession = d16;
            if (d16 != null) {
            }
            QLog.i(TAG, 2, "Emoticon Session create -> longAccountUin:" + LogUtil.wrapLogUin(String.valueOf(appRuntime.getLongAccountUin())) + ";curUid:" + valueOf);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.IEmoticonService
    @Nullable
    public IQQNTCommAbilitySession getCommAbilitySession() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IQQNTCommAbilitySession) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.commAbilitySession;
    }

    @Override // com.tencent.qqnt.kernel.api.IEmoticonService
    @Nullable
    public IYellowFaceForManagerService getYellowFaceForManagerService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IYellowFaceForManagerService) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.yellowFaceService == null) {
            initService();
        }
        return this.yellowFaceService;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@Nullable AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appRuntime);
            return;
        }
        KernelSetterImpl.Companion companion = KernelSetterImpl.INSTANCE;
        py pyVar = new py(appRuntime);
        this.serviceContent = pyVar;
        AppRuntime c16 = pyVar.c();
        if (c16 != null) {
            startSession(c16);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.commAbilitySession != null) {
            py pyVar = this.serviceContent;
            py pyVar2 = null;
            if (pyVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
                pyVar = null;
            }
            pyVar.h(null);
            IQQNTCommAbilitySession iQQNTCommAbilitySession = this.commAbilitySession;
            if (iQQNTCommAbilitySession != null) {
                iQQNTCommAbilitySession.destroy();
            }
            this.commAbilitySession = null;
            py pyVar3 = this.serviceContent;
            if (pyVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("serviceContent");
            } else {
                pyVar2 = pyVar3;
            }
            pyVar2.g();
            QLog.i(TAG, 2, "Emoticon Session destroy");
        }
    }
}
