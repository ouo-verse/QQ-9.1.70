package com.tencent.mobileqq.account.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.qui.quisecnavbar.e;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.account.provider.AccountManagerConfigProvider;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.IAccountBindingApi;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.widget.SettingOverScrollRecyclerView;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\u0014\u0010 \u001a\u00020\u00052\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016J\u001c\u0010\"\u001a\u00020\u00052\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010!\u001a\u00020\fH\u0016J\b\u0010#\u001a\u00020\fH\u0016R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00105\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010&\u001a\u0004\b3\u00104R\u001b\u00108\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u0010&\u001a\u0004\b7\u00104R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/account/fragment/AccountManagerFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/setting/processor/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initViews", "Ah", "", "offset", "Fh", "wh", "", "isEdit", "Eh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onAccountChanged", "onAccountChangeFailed", "onPostThemeChanged", "onResume", "onBackEvent", "overrideOnLogout", "Lcom/tencent/mobileqq/widget/listitem/a;", DownloadInfo.spKey_Config, "vb", "isVisible", "na", "needImmersive", "Lcom/tencent/mobileqq/account/viewmodel/a;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", OcrConfig.CHINESE, "()Lcom/tencent/mobileqq/account/viewmodel/a;", "vm", "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView;", "D", "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "E", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", UserInfo.SEX_FEMALE, "yh", "()I", "topPadding", "G", "xh", "maxAlphaOffset", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "H", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "quiSecNavBar", "Lcom/tencent/mobileqq/account/provider/AccountManagerConfigProvider;", "I", "Lcom/tencent/mobileqq/account/provider/AccountManagerConfigProvider;", "configProvider", "<init>", "()V", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class AccountManagerFragment extends QPublicBaseFragment implements com.tencent.mobileqq.setting.processor.a {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private SettingOverScrollRecyclerView recyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private QUIListItemAdapter adapter;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy topPadding;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy maxAlphaOffset;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private QUISecNavBar quiSecNavBar;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private AccountManagerConfigProvider configProvider;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/account/fragment/AccountManagerFragment$a", "Lcom/tencent/mobileqq/setting/widget/SettingOverScrollRecyclerView$d;", "", "offsetY", "", "onVerticalScroll", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes9.dex */
    public static final class a implements SettingOverScrollRecyclerView.d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountManagerFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.setting.widget.SettingOverScrollRecyclerView.d
        public void onVerticalScroll(int offsetY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AccountManagerFragment.this.Fh(offsetY);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, offsetY);
            }
        }
    }

    public AccountManagerFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.account.viewmodel.a>() { // from class: com.tencent.mobileqq.account.fragment.AccountManagerFragment$vm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountManagerFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final com.tencent.mobileqq.account.viewmodel.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.account.viewmodel.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    return (com.tencent.mobileqq.account.viewmodel.a) h.b(AccountManagerFragment.this, new com.tencent.mobileqq.account.viewmodel.b(peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null)).get(com.tencent.mobileqq.account.viewmodel.a.class);
                }
            });
            this.vm = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.account.fragment.AccountManagerFragment$topPadding$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountManagerFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    Context requireContext = AccountManagerFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    return Integer.valueOf(e.b(requireContext));
                }
            });
            this.topPadding = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.account.fragment.AccountManagerFragment$maxAlphaOffset$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AccountManagerFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final Integer invoke() {
                    int yh5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Integer) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    yh5 = AccountManagerFragment.this.yh();
                    return Integer.valueOf(yh5 / 2);
                }
            });
            this.maxAlphaOffset = lazy3;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void Ah() {
        MutableLiveData<Group[]> j3;
        AccountManagerConfigProvider accountManagerConfigProvider = this.configProvider;
        if (accountManagerConfigProvider != null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            accountManagerConfigProvider.l(requireContext, this);
        }
        AccountManagerConfigProvider accountManagerConfigProvider2 = this.configProvider;
        if (accountManagerConfigProvider2 != null && (j3 = accountManagerConfigProvider2.j()) != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<Group[], Unit> function1 = new Function1<Group[], Unit>() { // from class: com.tencent.mobileqq.account.fragment.AccountManagerFragment$initConfigs$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountManagerFragment.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Group[] groupArr) {
                    invoke2(groupArr);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
                
                    r0 = r3.this$0.adapter;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2(Group[] groupArr) {
                    QUIListItemAdapter qUIListItemAdapter;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) groupArr);
                    } else {
                        if (groupArr == null || qUIListItemAdapter == null) {
                            return;
                        }
                        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
                    }
                }
            };
            j3.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.account.fragment.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AccountManagerFragment.Bh(Function1.this, obj);
                }
            });
        }
        AccountManagerConfigProvider accountManagerConfigProvider3 = this.configProvider;
        if (accountManagerConfigProvider3 != null) {
            accountManagerConfigProvider3.q(this);
        }
        AccountManagerConfigProvider accountManagerConfigProvider4 = this.configProvider;
        if (accountManagerConfigProvider4 != null) {
            accountManagerConfigProvider4.A(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Eh(boolean isEdit) {
        if (isEdit) {
            QUISecNavBar qUISecNavBar = this.quiSecNavBar;
            if (qUISecNavBar != null) {
                qUISecNavBar.setBaseViewVisible(BaseAction.ACTION_LEFT_BUTTON, false);
                return;
            }
            return;
        }
        QUISecNavBar qUISecNavBar2 = this.quiSecNavBar;
        if (qUISecNavBar2 != null) {
            qUISecNavBar2.setBaseViewVisible(BaseAction.ACTION_LEFT_BUTTON, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh(int offset) {
        float f16;
        if (offset <= 0) {
            f16 = 0.0f;
        } else if (offset < xh()) {
            f16 = (offset * 1.0f) / xh();
        } else {
            f16 = 1.0f;
        }
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (qUISecNavBar != null) {
            qUISecNavBar.setTitleBlurAlpha(f16);
        }
    }

    private final void initViews(View rootView) {
        String str;
        FragmentActivity activity = getActivity();
        String str2 = null;
        if (activity != null) {
            str = activity.getString(R.string.f196784i9);
        } else {
            str = null;
        }
        QUISecNavBar qUISecNavBar = (QUISecNavBar) rootView.findViewById(R.id.zm9);
        qUISecNavBar.S(this);
        qUISecNavBar.setCenterText(str);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            str2 = activity2.getString(R.string.f170869aw3);
        }
        qUISecNavBar.setRightText(str2);
        qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.account.fragment.AccountManagerFragment$initViews$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountManagerFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                invoke2(view, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view, @NotNull BaseAction baseAction) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
                    return;
                }
                Intrinsics.checkNotNullParameter(baseAction, "baseAction");
                if (baseAction == BaseAction.ACTION_RIGHT_TEXT) {
                    AccountManagerFragment.this.wh();
                } else if (baseAction == BaseAction.ACTION_LEFT_BUTTON) {
                    AccountManagerFragment.this.onBackEvent();
                }
            }
        });
        this.quiSecNavBar = qUISecNavBar;
        ReportController.y(MobileQQ.sMobileQQ.peekAppRuntime(), "0X800B7D2");
        this.recyclerView = (SettingOverScrollRecyclerView) rootView.findViewById(R.id.i4m);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, true, 3, null);
        this.adapter = qUIListItemAdapter;
        SettingOverScrollRecyclerView settingOverScrollRecyclerView = this.recyclerView;
        if (settingOverScrollRecyclerView != null) {
            settingOverScrollRecyclerView.setClipToPadding(false);
            settingOverScrollRecyclerView.setHasTopSpace(false);
            settingOverScrollRecyclerView.setPadding(0, yh(), 0, 0);
            QUISecNavBar qUISecNavBar2 = this.quiSecNavBar;
            if (qUISecNavBar2 != null) {
                QUISecNavBar.setBlur$default(qUISecNavBar2, true, settingOverScrollRecyclerView, 0, 4, null);
            }
            settingOverScrollRecyclerView.setOnVerticalScrollListener(new a());
            settingOverScrollRecyclerView.setAdapter(qUIListItemAdapter);
        }
        MutableLiveData<Boolean> Q1 = zh().Q1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final AccountManagerFragment$initViews$3 accountManagerFragment$initViews$3 = AccountManagerFragment$initViews$3.INSTANCE;
        Q1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.account.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountManagerFragment.Ch(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> N1 = zh().N1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.account.fragment.AccountManagerFragment$initViews$4
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AccountManagerFragment.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    AccountManagerFragment.this.wh();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
                }
            }
        };
        N1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.account.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AccountManagerFragment.Dh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wh() {
        boolean z16 = !Intrinsics.areEqual(zh().R1().getValue(), Boolean.TRUE);
        zh().R1().postValue(Boolean.valueOf(z16));
        if (z16) {
            SettingOverScrollRecyclerView settingOverScrollRecyclerView = this.recyclerView;
            if (settingOverScrollRecyclerView != null) {
                settingOverScrollRecyclerView.scrollTo(0, 0);
            }
            QUISecNavBar qUISecNavBar = this.quiSecNavBar;
            if (qUISecNavBar != null) {
                qUISecNavBar.setRightText("\u5b8c\u6210");
            }
        } else {
            QUISecNavBar qUISecNavBar2 = this.quiSecNavBar;
            if (qUISecNavBar2 != null) {
                qUISecNavBar2.setRightText(BaseApplication.getContext().getString(R.string.f170869aw3));
            }
        }
        AccountManagerConfigProvider accountManagerConfigProvider = this.configProvider;
        if (accountManagerConfigProvider != null) {
            accountManagerConfigProvider.A(z16);
        }
        Eh(z16);
        if (z16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            ReportController.o(peekAppRuntime, "CliOper", "", "", "Setting_tab", "Clk_acc_edit", 0, 0, "", "", "", "");
            ReportController.y(peekAppRuntime, "0X800B836");
        }
    }

    private final int xh() {
        return ((Number) this.maxAlphaOffset.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int yh() {
        return ((Number) this.topPadding.getValue()).intValue();
    }

    private final com.tencent.mobileqq.account.viewmodel.a zh() {
        return (com.tencent.mobileqq.account.viewmodel.a) this.vm.getValue();
    }

    @Override // com.tencent.mobileqq.setting.processor.a
    public void na(@NotNull com.tencent.mobileqq.widget.listitem.a<?> config, boolean isVisible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, config, Boolean.valueOf(isVisible));
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        if (qUIListItemAdapter != null) {
            qUIListItemAdapter.m0(config, isVisible);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public void onAccountChangeFailed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onAccountChangeFailed();
        AccountManagerConfigProvider accountManagerConfigProvider = this.configProvider;
        if (accountManagerConfigProvider != null) {
            accountManagerConfigProvider.m();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onAccountChanged();
        AccountManagerConfigProvider accountManagerConfigProvider = this.configProvider;
        if (accountManagerConfigProvider != null) {
            accountManagerConfigProvider.n();
        }
        zh().S1();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (zh().O1()) {
            wh();
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            return false;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            rootView = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            rootView = inflater.inflate(R.layout.h7v, container, false);
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            initViews(rootView);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            com.tencent.mobileqq.account.viewmodel.a vm5 = zh();
            Intrinsics.checkNotNullExpressionValue(vm5, "vm");
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            this.configProvider = new AccountManagerConfigProvider(requireContext, vm5, viewLifecycleOwner);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onPostThemeChanged();
            zh().P1().setValue(Boolean.TRUE);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onResume();
            ((IAccountBindingApi) QRoute.api(IAccountBindingApi.class)).bindWechatIfNeed(getQBaseActivity(), false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Ah();
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_bas_account_security_settings");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean overrideOnLogout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.setting.processor.a
    public void vb(@NotNull com.tencent.mobileqq.widget.listitem.a<?> config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) config);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        if (qUIListItemAdapter != null) {
            qUIListItemAdapter.l0(config);
        }
    }
}
