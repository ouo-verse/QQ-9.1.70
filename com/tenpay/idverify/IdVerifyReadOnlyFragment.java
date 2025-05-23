package com.tenpay.idverify;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.gson.GsonBuilder;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.form.QWalletBaseIdFormVC;
import com.tenpay.idverify.EnumIdType;
import com.tenpay.idverify.EnumIdVerifySex;
import com.tenpay.idverify.model.IdInfoBean;
import com.tenpay.sdk.activity.ActivateTenpayAccount;
import com.tenpay.sdk.activity.NetBaseActivity;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\"\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017J&\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001d\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/tenpay/idverify/IdVerifyReadOnlyFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "()V", "baseIdFormVC", "Lcom/tenpay/form/QWalletBaseIdFormVC;", "idInfoBean", "Lcom/tenpay/idverify/model/IdInfoBean;", "listID", "", "initArguments", "", "initInfoVC", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "onActivityResult", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "showErrorDialog", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdVerifyReadOnlyFragment extends NetBaseActivity {

    @NotNull
    public static final String KEY_ID_INFO_BEAN_JSON = "KEY_ID_INFO_BEAN_JSON";

    @NotNull
    public static final String KEY_LIST_ID = "KEY_LIST_ID";
    private static final int REQUEST_CODE_ACTIVATE_ACCOUNT = 100;

    @Nullable
    private QWalletBaseIdFormVC baseIdFormVC;

    @Nullable
    private IdInfoBean idInfoBean;

    @Nullable
    private String listID;

    private final void initArguments() {
        String str;
        boolean z16;
        String string;
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString(KEY_ID_INFO_BEAN_JSON)) != null) {
            this.idInfoBean = (IdInfoBean) new GsonBuilder().create().fromJson(string, IdInfoBean.class);
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("KEY_LIST_ID");
        } else {
            str = null;
        }
        this.listID = str;
        if (this.idInfoBean != null) {
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return;
            }
        }
        showErrorDialog();
    }

    private final void initInfoVC(View rootView) {
        String str;
        Integer num;
        int i3;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        QWalletBaseIdFormVC qWalletBaseIdFormVC = new QWalletBaseIdFormVC(this, rootView);
        QWalletBaseIdFormVC.setTitle$default(qWalletBaseIdFormVC, getString(R.string.e9k), null, 2, null);
        IdInfoBean idInfoBean = this.idInfoBean;
        if (idInfoBean != null) {
            str = idInfoBean.getName();
        } else {
            str = null;
        }
        QWalletBaseIdFormVC.setNameData$default(qWalletBaseIdFormVC, str, null, false, false, null, 22, null);
        EnumIdVerifySex.Companion companion = EnumIdVerifySex.INSTANCE;
        IdInfoBean idInfoBean2 = this.idInfoBean;
        if (idInfoBean2 != null) {
            num = Integer.valueOf(idInfoBean2.getSex());
        } else {
            num = null;
        }
        QWalletBaseIdFormVC.setSexData$default(qWalletBaseIdFormVC, companion.findByValue(num).getDesc(), null, false, false, null, 22, null);
        Resources resources = getResources();
        EnumIdType.Companion companion2 = EnumIdType.INSTANCE;
        IdInfoBean idInfoBean3 = this.idInfoBean;
        if (idInfoBean3 != null) {
            i3 = idInfoBean3.getCreType();
        } else {
            i3 = 0;
        }
        QWalletBaseIdFormVC.setIdTypeData$default(qWalletBaseIdFormVC, resources.getString(companion2.create(i3).getDescResId()), null, false, 6, null);
        IdInfoBean idInfoBean4 = this.idInfoBean;
        if (idInfoBean4 != null) {
            str2 = idInfoBean4.getCreId();
        } else {
            str2 = null;
        }
        QWalletBaseIdFormVC.setIdData$default(qWalletBaseIdFormVC, str2, null, false, false, null, 22, null);
        IdInfoBean idInfoBean5 = this.idInfoBean;
        if (idInfoBean5 != null) {
            str3 = idInfoBean5.getCreBeginDate();
        } else {
            str3 = null;
        }
        QWalletBaseIdFormVC.setDate$default(qWalletBaseIdFormVC, true, str3, false, false, null, 20, null);
        IdInfoBean idInfoBean6 = this.idInfoBean;
        if (idInfoBean6 != null) {
            str4 = idInfoBean6.getCreEndDate();
        } else {
            str4 = null;
        }
        QWalletBaseIdFormVC.setDate$default(qWalletBaseIdFormVC, false, str4, false, false, null, 20, null);
        IdInfoBean idInfoBean7 = this.idInfoBean;
        if (idInfoBean7 != null) {
            str5 = idInfoBean7.getOccupation();
        } else {
            str5 = null;
        }
        QWalletBaseIdFormVC.setProfessionDate$default(qWalletBaseIdFormVC, str5, false, false, null, 10, null);
        IdInfoBean idInfoBean8 = this.idInfoBean;
        if (idInfoBean8 != null) {
            str6 = idInfoBean8.getAddress();
        } else {
            str6 = null;
        }
        QWalletBaseIdFormVC.setAddressData$default(qWalletBaseIdFormVC, str6, false, false, null, 10, null);
        QWalletBaseIdFormVC.setConfirmBtnDate$default(qWalletBaseIdFormVC, false, new Function1<View, Unit>() { // from class: com.tenpay.idverify.IdVerifyReadOnlyFragment$initInfoVC$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                String str7;
                HashMap hashMapOf;
                Intrinsics.checkNotNullParameter(it, "it");
                Intent intent = new Intent();
                IdVerifyReadOnlyFragment idVerifyReadOnlyFragment = IdVerifyReadOnlyFragment.this;
                Bundle bundle = new Bundle();
                Pair[] pairArr = new Pair[2];
                str7 = idVerifyReadOnlyFragment.listID;
                if (str7 == null) {
                    str7 = "";
                }
                pairArr[0] = TuplesKt.to("list_id", str7);
                pairArr[1] = TuplesKt.to("uin", idVerifyReadOnlyFragment.getCurrentUin());
                hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
                bundle.putSerializable(ActivateTenpayAccount.PARAM_ACTIVATE_MAP, hashMapOf);
                intent.putExtra(ActivateTenpayAccount.PARAM_ACTIVATE_ACCOUNT_BUNDLE, bundle);
                intent.putExtra("from", ActivateTenpayAccount.EnumFrom.CHILDREN_AUTH.ordinal());
                IdVerifyReadOnlyFragment.this.launchFragmentForResult(intent, ActivateTenpayAccount.class, 100);
            }
        }, 1, null);
        this.baseIdFormVC = qWalletBaseIdFormVC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(IdVerifyReadOnlyFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void showErrorDialog() {
        QQCustomDialog createCustomDialogUrlWithoutAutoLink = DialogUtil.createCustomDialogUrlWithoutAutoLink(getActivity(), 230, R.layout.f167856jn, getResources().getString(R.string.f21856642), (CharSequence) null, (String) null, getResources().getString(R.string.f21855641), new DialogInterface.OnClickListener() { // from class: com.tenpay.idverify.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                IdVerifyReadOnlyFragment.showErrorDialog$lambda$2(IdVerifyReadOnlyFragment.this, dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        createCustomDialogUrlWithoutAutoLink.setCancelable(false);
        createCustomDialogUrlWithoutAutoLink.setCanceledOnTouchOutside(false);
        createCustomDialogUrlWithoutAutoLink.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showErrorDialog$lambda$2(IdVerifyReadOnlyFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.exitCurrentProcess();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == -1) {
            setResult(-1);
            finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.hi8, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.idverify.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IdVerifyReadOnlyFragment.onViewCreated$lambda$0(IdVerifyReadOnlyFragment.this, view2);
            }
        });
        initArguments();
        initInfoVC(view);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
