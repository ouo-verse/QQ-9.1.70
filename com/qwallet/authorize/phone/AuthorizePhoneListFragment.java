package com.qwallet.authorize.phone;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.authorize.AuthorizePhoneData;
import com.qwallet.authorize.verify.AuthorizeVerifyPhoneFragment;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;
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

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J&\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0014J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/qwallet/authorize/phone/AuthorizePhoneListFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "Landroid/view/View;", "view", "", "initView", "initData", "initHandle", "Lcom/qwallet/authorize/AuthorizePhoneData;", "authorizePhoneData", "Ah", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackEvent", "isStatusBarImmersive", "isStatusBarDarkText", "isAllowLandscape", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "backBtn", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "phoneListView", "E", "addOtherPhoneText", "Lcom/qwallet/authorize/phone/d;", UserInfo.SEX_FEMALE, "Lcom/qwallet/authorize/phone/d;", "adapter", "Lcom/qwallet/authorize/phone/j;", "G", "Lkotlin/Lazy;", "vh", "()Lcom/qwallet/authorize/phone/j;", "viewModel", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class AuthorizePhoneListFragment extends QWalletBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView backBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView phoneListView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView addOtherPhoneText;

    /* renamed from: F, reason: from kotlin metadata */
    private d adapter;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public AuthorizePhoneListFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<j>() { // from class: com.qwallet.authorize.phone.AuthorizePhoneListFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final j invoke() {
                ViewModel viewModel = new ViewModelProvider(AuthorizePhoneListFragment.this).get(j.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026istViewModel::class.java)");
                return (j) viewModel;
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ah(AuthorizePhoneData authorizePhoneData) {
        if (authorizePhoneData.getSource() != 1) {
            vh().d2(true);
        }
        vh().W1(authorizePhoneData);
    }

    private final void initData() {
        MutableLiveData<List<AuthorizePhoneData>> R1 = vh().R1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends AuthorizePhoneData>, Unit> function1 = new Function1<List<? extends AuthorizePhoneData>, Unit>() { // from class: com.qwallet.authorize.phone.AuthorizePhoneListFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends AuthorizePhoneData> list) {
                invoke2((List<AuthorizePhoneData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<AuthorizePhoneData> list) {
                d dVar;
                if (list != null) {
                    dVar = AuthorizePhoneListFragment.this.adapter;
                    if (dVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        dVar = null;
                    }
                    dVar.submitList(list);
                }
            }
        };
        R1.observe(viewLifecycleOwner, new Observer() { // from class: com.qwallet.authorize.phone.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AuthorizePhoneListFragment.wh(Function1.this, obj);
            }
        });
        vh().Z1();
    }

    private final void initHandle() {
        TextView textView = this.backBtn;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.authorize.phone.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorizePhoneListFragment.xh(AuthorizePhoneListFragment.this, view);
            }
        });
        final ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.qwallet.authorize.phone.f
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                AuthorizePhoneListFragment.yh(AuthorizePhoneListFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul\u2026lt = $result\")\n        })");
        TextView textView3 = this.addOtherPhoneText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addOtherPhoneText");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qwallet.authorize.phone.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthorizePhoneListFragment.zh(AuthorizePhoneListFragment.this, registerForActivityResult, view);
            }
        });
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.sz8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.authorize_phone_list_back)");
        this.backBtn = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.sz9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.a\u2026_phone_list_recycle_view)");
        this.phoneListView = (RecyclerView) findViewById2;
        View findViewById3 = view.findViewById(R.id.syv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.authorize_add_other_phone)");
        this.addOtherPhoneText = (TextView) findViewById3;
        this.adapter = new d(new AuthorizePhoneListFragment$initView$1(this));
        RecyclerView recyclerView = this.phoneListView;
        d dVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneListView");
            recyclerView = null;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        d dVar2 = this.adapter;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            dVar = dVar2;
        }
        recyclerView.setAdapter(dVar);
    }

    private final j vh() {
        return (j) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(AuthorizePhoneListFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(AuthorizePhoneListFragment this$0, ActivityResult activityResult) {
        AuthorizePhoneData authorizePhoneData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            boolean z16 = false;
            if (data != null) {
                z16 = data.getBooleanExtra("extra_key_update_phone_list", false);
            }
            if (z16) {
                this$0.vh().Z1();
                this$0.vh().d2(true);
            }
            Intent data2 = activityResult.getData();
            if (data2 != null) {
                authorizePhoneData = (AuthorizePhoneData) data2.getParcelableExtra("extra_key_snap_phone_data");
            } else {
                authorizePhoneData = null;
            }
            if (authorizePhoneData != null) {
                this$0.vh().c2(authorizePhoneData);
            }
        }
        com.tencent.xaction.log.b.a(QPublicBaseFragment.TAG, 1, "result = " + activityResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(AuthorizePhoneListFragment this$0, ActivityResultLauncher launcher, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(launcher, "$launcher");
        d dVar = this$0.adapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            dVar = null;
        }
        if (dVar.getItemCount() >= this$0.vh().getAuthorizeMaxPhoneSize()) {
            QQToast.makeText(this$0.getActivity(), 1, "\u6700\u591a\u6dfb\u52a0" + this$0.vh().getAuthorizeMaxPhoneSize() + "\u4e2a\u624b\u673a\u53f7", 0).show();
        } else {
            Intent intent = new Intent(this$0.requireActivity(), (Class<?>) QPublicFragmentActivity.class);
            intent.putExtra("public_fragment_class", AuthorizeVerifyPhoneFragment.class.getName());
            intent.putExtra("extra_key_authorize_appid", this$0.vh().getAppId());
            intent.putExtra("extra_key_authorize_openid", this$0.vh().getOpenId());
            intent.putExtra("extra_key_authorize_access_token", this$0.vh().getCom.huawei.hms.support.feature.result.CommonConstant.KEY_ACCESS_TOKEN java.lang.String());
            intent.putExtra("KEY_VERIFY_MODE", AuthorizeVerifyPhoneFragment.EnumVerifyMode.ADD);
            launcher.launch(intent);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean isAllowLandscape() {
        return true;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarDarkText() {
        return !QQTheme.isColorDark(requireActivity().getWindow().getDecorView().getResources().getColor(R.color.qui_common_bg_middle_light));
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("extra_key_snap_phone_data", vh().getSnapPhoneData());
            intent.putExtra("extra_key_update_phone_list", vh().getUpdatePhoneList());
            Unit unit = Unit.INSTANCE;
            activity.setResult(-1, intent);
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hhy, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        initHandle();
    }
}
