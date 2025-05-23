package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.ICheckAIAuthCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetNetResultTabsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetNetSugWordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetSearchAppendingInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetSearchBoxSugWordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.ISearchCallback;
import com.tencent.qqnt.kernel.nativeinterface.IUnifySearchCallback;
import com.tencent.qqnt.kernel.nativeinterface.IUnifySearchDiscoveryCallback;
import com.tencent.qqnt.kernel.nativeinterface.IWxSearchReportCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchAppendingInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.SearchNetResultTabsReq;
import com.tencent.qqnt.kernel.nativeinterface.SearchNetSugWordsReq;
import com.tencent.qqnt.kernel.nativeinterface.SearchReqBody;
import com.tencent.qqnt.kernel.nativeinterface.UfsCheckAIAuthReq;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisReqBody;
import com.tencent.qqnt.kernel.nativeinterface.UfsGetSugWordsReq;
import com.tencent.qqnt.kernel.nativeinterface.UfsReqBody;
import com.tencent.qqnt.kernel.nativeinterface.UfsWxaSearchReportReq;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001(B\u0017\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u0011\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0014\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0015\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0018\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u001b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010\u001e\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001dH\u0016J\u001c\u0010!\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0006\u001a\u0004\u0018\u00010 H\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/qb;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelUnifySearchService;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReqBody;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/ISearchCallback;", "result", "", "search", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchNetResultTabsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetNetResultTabsCallback;", "getNetResultTabs", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchNetSugWordsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetNetSugWordsCallback;", "getNetSugWords", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsReqBody;", "Lcom/tencent/qqnt/kernel/nativeinterface/IUnifySearchCallback;", "unifySearch", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisReqBody;", "Lcom/tencent/qqnt/kernel/nativeinterface/IUnifySearchDiscoveryCallback;", "unifySearchDiscovery", "unifySearchDiscoveryInCache", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsGetSugWordsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetSearchBoxSugWordsCallback;", "getSearchBoxSugWords", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchAppendingInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetSearchAppendingInfoCallback;", "getSearchAppendingInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsCheckAIAuthReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckAIAuthCallback;", "checkAIAuth", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsWxaSearchReportReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IWxSearchReportCallback;", "wxSearchReport", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelUnifySearchService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class qb extends BaseService<IKernelUnifySearchService, IKernelUnifySearchService> implements IKernelUnifySearchService {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/qb$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.qb$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54341);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qb(@NotNull IKernelUnifySearchService service, @NotNull py content) {
        super("UnifySearchService", content, service);
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) service, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
    public void checkAIAuth(@Nullable UfsCheckAIAuthReq req, @Nullable ICheckAIAuthCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) req, (Object) result);
            return;
        }
        IKernelUnifySearchService service = getService();
        if (service != null) {
            service.checkAIAuth(req, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
    public void getNetResultTabs(@Nullable SearchNetResultTabsReq req, @Nullable IGetNetResultTabsCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) req, (Object) result);
            return;
        }
        IKernelUnifySearchService service = getService();
        if (service != null) {
            service.getNetResultTabs(req, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
    public void getNetSugWords(@Nullable SearchNetSugWordsReq req, @Nullable IGetNetSugWordsCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) req, (Object) result);
            return;
        }
        IKernelUnifySearchService service = getService();
        if (service != null) {
            service.getNetSugWords(req, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
    public void getSearchAppendingInfo(@Nullable SearchAppendingInfoReq req, @Nullable IGetSearchAppendingInfoCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) req, (Object) result);
            return;
        }
        IKernelUnifySearchService service = getService();
        if (service != null) {
            service.getSearchAppendingInfo(req, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
    public void getSearchBoxSugWords(@Nullable UfsGetSugWordsReq req, @Nullable IGetSearchBoxSugWordsCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) req, (Object) result);
            return;
        }
        IKernelUnifySearchService service = getService();
        if (service != null) {
            service.getSearchBoxSugWords(req, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
    public void search(@Nullable SearchReqBody req, @Nullable ISearchCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) req, (Object) result);
            return;
        }
        IKernelUnifySearchService service = getService();
        if (service != null) {
            service.search(req, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
    public void unifySearch(@Nullable UfsReqBody req, @Nullable IUnifySearchCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) req, (Object) result);
            return;
        }
        IKernelUnifySearchService service = getService();
        if (service != null) {
            service.unifySearch(req, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
    public void unifySearchDiscovery(@Nullable UfsDisReqBody req, @Nullable IUnifySearchDiscoveryCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) req, (Object) result);
            return;
        }
        IKernelUnifySearchService service = getService();
        if (service != null) {
            service.unifySearchDiscovery(req, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
    public void unifySearchDiscoveryInCache(@Nullable UfsDisReqBody req, @Nullable IUnifySearchDiscoveryCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) req, (Object) result);
            return;
        }
        IKernelUnifySearchService service = getService();
        if (service != null) {
            service.unifySearchDiscoveryInCache(req, result);
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService
    public void wxSearchReport(@Nullable UfsWxaSearchReportReq req, @Nullable IWxSearchReportCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) req, (Object) result);
            return;
        }
        IKernelUnifySearchService service = getService();
        if (service != null) {
            service.wxSearchReport(req, result);
        }
    }
}
