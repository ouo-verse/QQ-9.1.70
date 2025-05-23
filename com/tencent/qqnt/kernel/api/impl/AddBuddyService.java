package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.AccountInfo;
import com.tencent.qqnt.kernel.nativeinterface.AddBuddyReq;
import com.tencent.qqnt.kernel.nativeinterface.BuddySettingReq;
import com.tencent.qqnt.kernel.nativeinterface.IAddBuddyCallback;
import com.tencent.qqnt.kernel.nativeinterface.IBuddySettingCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetBuddyInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetBuddyTagCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetSmartInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelAddBuddyService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener;
import com.tencent.qqnt.kernel.nativeinterface.IQueryUinSafetyFlagCallback;
import com.tencent.qqnt.kernel.nativeinterface.SmartReq;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001$B\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"J0\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J0\u0010\u0012\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0011H\u0016J0\u0010\u0015\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0014H\u0016J0\u0010\u0019\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u0018H\u0016J0\u0010\u001b\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u001aH\u0016J0\u0010\u001d\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u001cH\u0016\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/AddBuddyService;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBuddyListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelAddBuddyService;", "Lcom/tencent/qqnt/kernel/api/f;", "", "callFrom", "Lcom/tencent/qqnt/kernel/nativeinterface/AccountInfo;", "acc", "", "reqContext", "Lcom/tencent/qqnt/kernel/nativeinterface/IQueryUinSafetyFlagCallback;", "callback", "", "queryUinSafetyFlag", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddySettingReq;", "reqInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IBuddySettingCallback;", "getBuddySetting", "Lcom/tencent/qqnt/kernel/nativeinterface/AddBuddyReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IAddBuddyCallback;", "addBuddy", "Lcom/tencent/qqnt/kernel/nativeinterface/SmartReq;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetSmartInfoCallback;", "getSmartInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetBuddyInfoCallback;", "requestInfoByAccount", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetBuddyTagCallback;", "getAddBuddyRequestTag", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelAddBuddyService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class AddBuddyService extends BaseService<IKernelBuddyListener, IKernelAddBuddyService> implements com.tencent.qqnt.kernel.api.f {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/AddBuddyService$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.AddBuddyService$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38184);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddBuddyService(@Nullable IKernelAddBuddyService iKernelAddBuddyService, @NotNull py content) {
        super("AddOrDelBuddy", content, iKernelAddBuddyService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelAddBuddyService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.f
    public void addBuddy(@Nullable final String callFrom, @Nullable final AddBuddyReq reqInfo, @Nullable final byte[] reqContext, @Nullable final IAddBuddyCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, callFrom, reqInfo, reqContext, callback);
        } else {
            check("addBuddy", new Function0<Unit>(callFrom, reqInfo, reqContext, callback) { // from class: com.tencent.qqnt.kernel.api.impl.AddBuddyService$addBuddy$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $callFrom;
                final /* synthetic */ IAddBuddyCallback $callback;
                final /* synthetic */ byte[] $reqContext;
                final /* synthetic */ AddBuddyReq $reqInfo;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$callFrom = callFrom;
                    this.$reqInfo = reqInfo;
                    this.$reqContext = reqContext;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AddBuddyService.this, callFrom, reqInfo, reqContext, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelAddBuddyService service = AddBuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.addBuddy(this.$callFrom, this.$reqInfo, this.$reqContext, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.f
    public void getAddBuddyRequestTag(@Nullable final String callFrom, @Nullable final AccountInfo acc, @Nullable final byte[] context, @Nullable final IGetBuddyTagCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, callFrom, acc, context, callback);
        } else {
            check("getAddBuddyRequestTag", new Function0<Unit>(callFrom, acc, context, callback) { // from class: com.tencent.qqnt.kernel.api.impl.AddBuddyService$getAddBuddyRequestTag$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AccountInfo $acc;
                final /* synthetic */ String $callFrom;
                final /* synthetic */ IGetBuddyTagCallback $callback;
                final /* synthetic */ byte[] $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$callFrom = callFrom;
                    this.$acc = acc;
                    this.$context = context;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AddBuddyService.this, callFrom, acc, context, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelAddBuddyService service = AddBuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getAddBuddyRequestTag(this.$callFrom, this.$acc, this.$context, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.f
    public void getBuddySetting(@Nullable final String callFrom, @Nullable final BuddySettingReq reqInfo, @Nullable final byte[] reqContext, @Nullable final IBuddySettingCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, callFrom, reqInfo, reqContext, callback);
        } else {
            check("getBuddySetting", new Function0<Unit>(callFrom, reqInfo, reqContext, callback) { // from class: com.tencent.qqnt.kernel.api.impl.AddBuddyService$getBuddySetting$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $callFrom;
                final /* synthetic */ IBuddySettingCallback $callback;
                final /* synthetic */ byte[] $reqContext;
                final /* synthetic */ BuddySettingReq $reqInfo;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$callFrom = callFrom;
                    this.$reqInfo = reqInfo;
                    this.$reqContext = reqContext;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AddBuddyService.this, callFrom, reqInfo, reqContext, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelAddBuddyService service = AddBuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getBuddySetting(this.$callFrom, this.$reqInfo, this.$reqContext, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.f
    public void getSmartInfo(@Nullable final String callFrom, @Nullable final SmartReq reqInfo, @Nullable final byte[] context, @Nullable final IGetSmartInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, callFrom, reqInfo, context, callback);
        } else {
            check("getSmartInfo", new Function0<Unit>(callFrom, reqInfo, context, callback) { // from class: com.tencent.qqnt.kernel.api.impl.AddBuddyService$getSmartInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $callFrom;
                final /* synthetic */ IGetSmartInfoCallback $callback;
                final /* synthetic */ byte[] $context;
                final /* synthetic */ SmartReq $reqInfo;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$callFrom = callFrom;
                    this.$reqInfo = reqInfo;
                    this.$context = context;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AddBuddyService.this, callFrom, reqInfo, context, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelAddBuddyService service = AddBuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getSmartInfo(this.$callFrom, this.$reqInfo, this.$context, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.f
    public void queryUinSafetyFlag(@Nullable final String callFrom, @Nullable final AccountInfo acc, @Nullable final byte[] reqContext, @Nullable final IQueryUinSafetyFlagCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, callFrom, acc, reqContext, callback);
        } else {
            check("queryUinSafetyFlag", new Function0<Unit>(callFrom, acc, reqContext, callback) { // from class: com.tencent.qqnt.kernel.api.impl.AddBuddyService$queryUinSafetyFlag$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AccountInfo $acc;
                final /* synthetic */ String $callFrom;
                final /* synthetic */ IQueryUinSafetyFlagCallback $callback;
                final /* synthetic */ byte[] $reqContext;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$callFrom = callFrom;
                    this.$acc = acc;
                    this.$reqContext = reqContext;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AddBuddyService.this, callFrom, acc, reqContext, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelAddBuddyService service = AddBuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.queryUinSafetyFlag(this.$callFrom, this.$acc, this.$reqContext, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.f
    public void requestInfoByAccount(@Nullable final String callFrom, @Nullable final AccountInfo acc, @Nullable final byte[] context, @Nullable final IGetBuddyInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, callFrom, acc, context, callback);
        } else {
            check("requestInfoByAccount", new Function0<Unit>(callFrom, acc, context, callback) { // from class: com.tencent.qqnt.kernel.api.impl.AddBuddyService$requestInfoByAccount$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AccountInfo $acc;
                final /* synthetic */ String $callFrom;
                final /* synthetic */ IGetBuddyInfoCallback $callback;
                final /* synthetic */ byte[] $context;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$callFrom = callFrom;
                    this.$acc = acc;
                    this.$context = context;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AddBuddyService.this, callFrom, acc, context, callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Unit invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    IKernelAddBuddyService service = AddBuddyService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.requestInfoByAccount(this.$callFrom, this.$acc, this.$context, this.$callback);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
