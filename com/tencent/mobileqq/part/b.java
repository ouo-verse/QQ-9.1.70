package com.tencent.mobileqq.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.richframework.part.TagData;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 32\u00020\u0001:\u0001\tB!\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010.\u001a\u00020,\u0012\u0006\u00100\u001a\u00020\u001c\u00a2\u0006\u0004\b:\u0010;J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J?\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0011*\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0018\u0010!\u001a\u00020\b2\u0010\u0010 \u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0018\u00010\u001eJ\u0006\u0010\"\u001a\u00020\bJ\u0006\u0010#\u001a\u00020\bJ\u0006\u0010$\u001a\u00020\bJ\u0006\u0010%\u001a\u00020\bJ\u0006\u0010&\u001a\u00020\bJ\u0006\u0010'\u001a\u00020\bJ\u0006\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020\bR\u0016\u0010+\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010*R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010-R\u0014\u00100\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010/R\"\u00107\u001a\u0002018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/part/b;", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "Lcom/tencent/mobileqq/part/c;", "l", "Landroid/view/View;", "contentView", "Landroid/view/ViewGroup;", "parentView", "", "a", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "Landroid/app/Activity;", "getHostActivity", "Landroid/content/Context;", "getHostContext", "Landroidx/lifecycle/ViewModel;", "T", "Landroidx/lifecycle/ViewModelStoreOwner;", "storeOwner", "", "keyPrefix", "Ljava/lang/Class;", "viewModelClass", "getViewModel", "(Landroidx/lifecycle/ViewModelStoreOwner;Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "", "getViewTagData", "Landroidx/lifecycle/LifecycleOwner;", "getHostLifecycleOwner", "", "Lcom/tencent/mobileqq/part/a;", "partList", "b", "k", "j", "d", "i", "g", "f", h.F, "e", "Landroid/view/View;", "mContentView", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "mActivity", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", DomainData.DOMAIN_NAME, "(Z)V", "isInit", "Lcom/tencent/mobileqq/part/c;", "mPartManager", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/app/QBaseActivity;Landroidx/lifecycle/LifecycleOwner;)V", "drawer-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b implements IPartHost {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final View mContentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity mActivity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner owner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isInit;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mPartManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/part/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "drawer-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.part.b$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42568);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@Nullable View view, @NotNull QBaseActivity mActivity, @NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(mActivity, "mActivity");
        Intrinsics.checkNotNullParameter(owner, "owner");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, view, mActivity, owner);
            return;
        }
        this.mContentView = view;
        this.mActivity = mActivity;
        this.owner = owner;
    }

    private final void a(View contentView, ViewGroup parentView) {
        c cVar = this.mPartManager;
        if (cVar != null) {
            cVar.setParentView(parentView);
        }
        c cVar2 = this.mPartManager;
        if (cVar2 != null) {
            cVar2.setRootView(contentView);
        }
        c cVar3 = this.mPartManager;
        if (cVar3 != null) {
            cVar3.onPartCreate(this.mActivity, null);
        }
    }

    private final c l() {
        if (this.mPartManager == null) {
            this.mPartManager = new c(this, this.mContentView);
        }
        return this.mPartManager;
    }

    public final void b(@Nullable List<? extends a> partList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) partList);
            return;
        }
        if (partList == null) {
            return;
        }
        if (!partList.isEmpty()) {
            c l3 = l();
            this.mPartManager = l3;
            if (l3 != null) {
                l3.registerPart(partList);
            }
        }
        View view = this.mContentView;
        if (view == null) {
            return;
        }
        a(view, (ViewGroup) view.getParent());
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        get_viewModelStore().clear();
        c cVar = this.mPartManager;
        if (cVar != null) {
            cVar.onPartDestroy(this.mActivity);
        }
        this.mPartManager = null;
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        c cVar = this.mPartManager;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        c cVar = this.mPartManager;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        c cVar = this.mPartManager;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost, com.qzone.publish.ui.controller.a
    @NotNull
    public Activity getHostActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Activity) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mActivity;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public Context getHostContext() {
        Context context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Context) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        View view = this.mContentView;
        if (view != null) {
            context = view.getContext();
        } else {
            context = null;
        }
        if (context == null) {
            return this.mActivity;
        }
        return context;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public LifecycleOwner getHostLifecycleOwner() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LifecycleOwner) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.owner;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    /* renamed from: getViewModelStore */
    public ViewModelStore get_viewModelStore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ViewModelStore) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ViewModelStore viewModelStore = this.mActivity.get_viewModelStore();
        Intrinsics.checkNotNullExpressionValue(viewModelStore, "mActivity.viewModelStore");
        return viewModelStore;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public Object getViewTagData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return iPatchRedirector.redirect((short) 8, (Object) this);
        }
        View view = this.mContentView;
        if (view != null) {
            return view.getTag(TagData.TAG_DATA_ID);
        }
        return null;
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        c cVar = this.mPartManager;
        if (cVar != null) {
            cVar.d();
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        c cVar = this.mPartManager;
        if (cVar != null) {
            cVar.e();
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        c cVar = this.mPartManager;
        if (cVar != null) {
            cVar.onPartPause(this.mActivity);
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        c cVar = this.mPartManager;
        if (cVar != null) {
            cVar.onPartResume(this.mActivity);
        }
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.isInit;
    }

    public final void n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.isInit = z16;
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public <T extends ViewModel> T getViewModel(@Nullable ViewModelStoreOwner storeOwner, @Nullable String keyPrefix, @NotNull Class<T> viewModelClass) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, this, storeOwner, keyPrefix, viewModelClass);
        }
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        return (T) com.tencent.mobileqq.mvvm.h.b(this.mActivity, QQSettingMeViewModel.f312690m0).get(viewModelClass);
    }
}
