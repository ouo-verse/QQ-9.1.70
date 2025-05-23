package com.tencent.mobileqq.qwallet.setting;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qwallet.activity.QWalletAccountProtectFragment;
import com.qwallet.activity.QWalletServiceManagerActivity;
import com.qwallet.activity.QWalletTitleBarActivity;
import com.qwallet.activity.patternlock.PatternLockSetFragment;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tenpay.fingerpay.FingerPaySettingSwitchFragment;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u00015\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\"\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010 H\u0017R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00104\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/qwallet/setting/QWalletSettingFragment;", "Lcom/qwallet/activity/QWalletTitleBarActivity;", "Landroid/os/Handler$Callback;", "", "Ih", "Landroid/view/View;", "initView", "Gh", "", "newPageTitle", "Eh", "Hh", "Fh", "", "Ch", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "Landroid/os/Message;", "msg", "handleMessage", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroidx/recyclerview/widget/RecyclerView;", "V", "Landroidx/recyclerview/widget/RecyclerView;", "layoutContainer", "Lcom/tencent/mobileqq/qwallet/setting/a;", "W", "Lcom/tencent/mobileqq/qwallet/setting/a;", "settingAdapter", "Landroid/os/Handler;", "X", "Landroid/os/Handler;", "handler", "Lcom/tencent/mobileqq/qwallet/setting/QWalletSettingViewModel;", "Y", "Lkotlin/Lazy;", "Dh", "()Lcom/tencent/mobileqq/qwallet/setting/QWalletSettingViewModel;", "viewModel", "com/tencent/mobileqq/qwallet/setting/QWalletSettingFragment$b", "Z", "Lcom/tencent/mobileqq/qwallet/setting/QWalletSettingFragment$b;", "onItemClickListener", "<init>", "()V", "a0", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletSettingFragment extends QWalletTitleBarActivity implements Handler.Callback {

    /* renamed from: V, reason: from kotlin metadata */
    private RecyclerView layoutContainer;

    /* renamed from: W, reason: from kotlin metadata */
    private a settingAdapter;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Handler handler = new Handler(Looper.getMainLooper(), this);

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final b onItemClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/setting/QWalletSettingFragment$b", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qwallet/setting/g;", "", "settingDataItem", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements Function1<SettingDataItem, Unit> {
        b() {
        }

        public void a(@NotNull SettingDataItem settingDataItem) {
            Intrinsics.checkNotNullParameter(settingDataItem, "settingDataItem");
            int settingType = settingDataItem.getSettingType();
            if (settingType == 2) {
                QWalletSettingFragment.this.Fh(settingDataItem.getName());
                return;
            }
            if (settingType == 5) {
                QWalletSettingFragment.this.Gh();
                return;
            }
            if (settingType == 13) {
                QWalletSettingFragment.this.Eh(settingDataItem.getName());
            } else if (settingType == 15) {
                QWalletSettingFragment.this.Hh(settingDataItem.getName());
            } else {
                k.h(QWalletSettingFragment.this.getContext(), settingDataItem.getUrl());
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingDataItem settingDataItem) {
            a(settingDataItem);
            return Unit.INSTANCE;
        }
    }

    public QWalletSettingFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QWalletSettingViewModel>() { // from class: com.tencent.mobileqq.qwallet.setting.QWalletSettingFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QWalletSettingViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(QWalletSettingFragment.this).get(QWalletSettingViewModel.class);
                QWalletSettingViewModel qWalletSettingViewModel = (QWalletSettingViewModel) viewModel;
                QWalletSettingFragment.this.getLifecycle().addObserver(qWalletSettingViewModel);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026dObserver(this)\n        }");
                return qWalletSettingViewModel;
            }
        });
        this.viewModel = lazy;
        this.onItemClickListener = new b();
    }

    private final boolean Ch() {
        return true;
    }

    private final QWalletSettingViewModel Dh() {
        return (QWalletSettingViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eh(String newPageTitle) {
        Intent intent = new Intent();
        intent.putExtra("title", newPageTitle);
        Ch();
        launchFragmentForResult(intent, QWalletAccountProtectFragment.class, 305);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fh(String newPageTitle) {
        Intent intent = new Intent();
        intent.putExtra("title", newPageTitle);
        launchFragmentForResult(intent, FingerPaySettingSwitchFragment.class, 307);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh() {
        launchFragmentForResult(new Intent(), PatternLockSetFragment.class, 304);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(String newPageTitle) {
        Intent intent = new Intent();
        intent.putExtra("title", newPageTitle);
        launchFragmentForResult(intent, QWalletServiceManagerActivity.class, 306);
    }

    private final void Ih() {
        this.handler.removeMessages(1);
        stopTitleProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(QWalletSettingFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setTitle(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(QWalletSettingFragment this$0, List it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ih();
        a aVar = this$0.settingAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingAdapter");
            aVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        aVar.m0(it);
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.f67653dx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qwalle\u2026setting_layout_container)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.layoutContainer = recyclerView;
        a aVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutContainer");
            recyclerView = null;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        this.settingAdapter = new a(this.onItemClickListener);
        RecyclerView recyclerView2 = this.layoutContainer;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutContainer");
            recyclerView2 = null;
        }
        a aVar2 = this.settingAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingAdapter");
        } else {
            aVar = aVar2;
        }
        recyclerView2.setAdapter(aVar);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what != 1 || isFinishing()) {
            return false;
        }
        QQToast.makeText(getContext(), R.string.f172970g64, 0).show();
        stopTitleProgress();
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        a aVar = null;
        switch (requestCode) {
            case 304:
                boolean isPatternLockOpened = PatternLockUtils.isPatternLockOpened(getActivity(), getCurrentUin());
                a aVar2 = this.settingAdapter;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingAdapter");
                } else {
                    aVar = aVar2;
                }
                aVar.o0(5, isPatternLockOpened);
                return;
            case 305:
                boolean z16 = QWalletUtils.i(getContext()).getBoolean("account_num_protect_switch" + getCurrentUin(), false);
                a aVar3 = this.settingAdapter;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("settingAdapter");
                } else {
                    aVar = aVar3;
                }
                aVar.o0(13, z16);
                return;
            case 306:
                setResult(103, data);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView$lambda$2 = inflater.inflate(R.layout.hiu, container, false);
        Intrinsics.checkNotNullExpressionValue(onCreateView$lambda$2, "onCreateView$lambda$2");
        initView(onCreateView$lambda$2);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView$lambda$2);
        return onCreateView$lambda$2;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.handler.removeCallbacksAndMessages(null);
        if (SoterWrapperApi.isInitialized()) {
            SoterWrapperApi.release();
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QUIImmersiveHelper.s(getActivity(), true, true);
    }

    @Override // com.qwallet.activity.QWalletTitleBarActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dh().R1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qwallet.setting.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletSettingFragment.Jh(QWalletSettingFragment.this, (String) obj);
            }
        });
        Dh().Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.qwallet.setting.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletSettingFragment.Kh(QWalletSettingFragment.this, (List) obj);
            }
        });
        vh(1);
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, 10000L);
    }
}
