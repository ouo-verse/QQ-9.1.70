package com.tencent.mobileqq.troop.file.upload.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.troop.file.upload.vm.TroopFileUploadVM;
import com.tencent.mobileqq.troop.file.widget.TroopFileListView;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import ms2.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\"\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R#\u0010\u001f\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010#R\u001c\u0010(\u001a\n \u001a*\u0004\u0018\u00010%0%8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troop/file/upload/fragment/TroopFileUploadFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", "view", "", "initUI", "wh", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "isWrapContent", "onResume", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onDestroyView", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/troop/file/upload/vm/TroopFileUploadVM;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "vh", "()Lcom/tencent/mobileqq/troop/file/upload/vm/TroopFileUploadVM;", "viewModel", "Lcom/tencent/mobileqq/troop/utils/TroopFileError$d;", "D", "th", "()Lcom/tencent/mobileqq/troop/utils/TroopFileError$d;", "errorHandlerObserver", "Lcom/tencent/mobileqq/app/QQAppInterface;", "sh", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "uh", "()J", "troopUinL", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopFileUploadFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy errorHandlerObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/troop/file/upload/fragment/TroopFileUploadFragment$a", "Lms2/a;", "", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements ms2.a {
        a() {
        }

        @Override // ms2.a
        public void a() {
            TroopFileUploadFragment.this.vh().X1();
        }
    }

    public TroopFileUploadFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopFileUploadVM>() { // from class: com.tencent.mobileqq.troop.file.upload.fragment.TroopFileUploadFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopFileUploadVM invoke() {
                TroopFileUploadVM troopFileUploadVM = (TroopFileUploadVM) TroopFileUploadFragment.this.getViewModel(TroopFileUploadVM.class);
                Bundle requireArguments = TroopFileUploadFragment.this.requireArguments();
                Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
                troopFileUploadVM.init(requireArguments);
                return troopFileUploadVM;
            }
        });
        this.viewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TroopFileError.d>() { // from class: com.tencent.mobileqq.troop.file.upload.fragment.TroopFileUploadFragment$errorHandlerObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopFileError.d invoke() {
                QQAppInterface sh5;
                Context context = TroopFileUploadFragment.this.getContext();
                long T1 = TroopFileUploadFragment.this.vh().T1();
                sh5 = TroopFileUploadFragment.this.sh();
                return new TroopFileError.d(context, T1, sh5);
            }
        });
        this.errorHandlerObserver = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQAppInterface sh() {
        return TroopUtils.f();
    }

    private final TroopFileError.d th() {
        return (TroopFileError.d) this.errorHandlerObserver.getValue();
    }

    private final long uh() {
        return vh().T1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopFileUploadVM vh() {
        return (TroopFileUploadVM) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.a2x;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 4) {
            if (data != null && data.getExtras() != null) {
                Bundle extras = data.getExtras();
                Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(getActivity()), new int[]{2});
                m3.putExtras(new Bundle(extras));
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.startActivity(m3);
                }
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.setResult(4, data);
            }
            FragmentActivity activity3 = getActivity();
            if (activity3 != null) {
                activity3.finish();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.setRequestedOrientation(1);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.setRequestedOrientation(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        TroopFileError.f(sh(), th());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (sh().containObserver(th(), false)) {
            return;
        }
        TroopFileError.a(sh(), th());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        wh(view);
    }

    private final void initUI(View view) {
        setTitle(getString(R.string.ewb));
        this.rightViewText.setText(R.string.ewa);
        this.rightViewText.setVisibility(8);
        View findViewById = view.findViewById(R.id.k2_);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.troop.file.widget.TroopFileListView");
        TroopFileListView troopFileListView = (TroopFileListView) findViewById;
        troopFileListView.setStackFromBottom(false);
        troopFileListView.setTranscriptMode(0);
        b bVar = new b(uh(), sh(), getActivity(), troopFileListView, new a());
        troopFileListView.setAdapter((ListAdapter) bVar);
        vh().Z1(bVar);
    }

    private final void wh(View view) {
        final View findViewById = view.findViewById(R.id.kjh);
        LiveData<Boolean> W1 = vh().W1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.file.upload.fragment.TroopFileUploadFragment$initObserver$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                View view2 = findViewById;
                view2.setVisibility(0);
                if (((View) au.a(bool, view2)) == null) {
                    view2.setVisibility(8);
                }
            }
        };
        W1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.troop.file.upload.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TroopFileUploadFragment.xh(Function1.this, obj);
            }
        });
    }
}
