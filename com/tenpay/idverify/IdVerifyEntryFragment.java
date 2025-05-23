package com.tenpay.idverify;

import android.content.Intent;
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
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tenpay.idverify.hint.IdVerifyHintModule;
import com.tenpay.idverify.model.IdInfoBean;
import com.tenpay.idverify.model.IdVerifyStateBean;
import com.tenpay.realname.RealNameSource;
import com.tenpay.realname.RealNameSourceReporter;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.IdVerifyActivity;
import com.tenpay.sdk.activity.NetBaseActivity;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.LinkedHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0017J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u001aH\u0002J\u001c\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u001f\u001a\u00020\tH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/tenpay/idverify/IdVerifyEntryFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "()V", "extInfo", "", "idVerifyType", "Lcom/tenpay/idverify/EnumIdVerifyType;", "incomeListId", "onActivityResult", "", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onQueryRealNameCallback", "Lorg/json/JSONObject;", "onSuccess", BrowserPlugin.KEY_REQUEST_URL, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "sendRequest", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdVerifyEntryFragment extends NetBaseActivity {

    @NotNull
    public static final String EXTRA_ID_VERIFY_TYPE = "EXTRA_ID_VERIFY_TYPE";

    @NotNull
    public static final String IN_EXTRA_EXT_INFO = "EXTRA_EXTRA_INFO";

    @NotNull
    public static final String IN_EXTRA_LIST_ID = "EXTRA_LIST_ID";
    private static final int REQUEST_CODE_DIRECTION = 101;
    private static final int REQUEST_CODE_IDVERIFY = 100;
    private static final int REQUEST_CODE_RESULT = 102;

    @Nullable
    private String extInfo;

    @NotNull
    private EnumIdVerifyType idVerifyType = EnumIdVerifyType.IdCard;

    @Nullable
    private String incomeListId;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnumIdVerifyType.values().length];
            try {
                iArr[EnumIdVerifyType.IdCard.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumIdVerifyType.BankCard.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void onQueryRealNameCallback(JSONObject data) {
        RealNameSource realNameSource;
        Bundle extras;
        IdVerifyStateBean idVerifyStateBean = (IdVerifyStateBean) new GsonBuilder().create().fromJson(data.toString(), IdVerifyStateBean.class);
        IdInfoBean idInfoBean = (IdInfoBean) new GsonBuilder().create().fromJson(data.optString("reg_info").toString(), IdInfoBean.class);
        String optString = data.optString("list_id");
        if (idVerifyStateBean.getStateEnum() == EnumIdVerifyState.NONE && idVerifyStateBean.getRoleEnum() == EnumIdVerifyStateRole.INVITER) {
            Intent intent = new Intent();
            Intent intent2 = getIntent();
            if (intent2 != null && (extras = intent2.getExtras()) != null) {
                intent.putExtras(extras);
            }
            launchFragmentForResult(intent, IdVerifyDirectionFragment.class, 101);
            Intent intent3 = getIntent();
            if (intent3 != null) {
                realNameSource = (RealNameSource) intent3.getParcelableExtra(RealNameSource.EXTRA_KEY_SOURCE);
            } else {
                realNameSource = null;
            }
            RealNameSourceReporter.INSTANCE.reportIdVerifyShow(realNameSource);
            return;
        }
        IdVerifyHintModule.startStateBeanHint(this, idVerifyStateBean, idInfoBean, optString, this.extInfo, 102);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(IdVerifyEntryFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void sendRequest() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uin", getCurrentUin());
        String str = this.incomeListId;
        if (str != null) {
            linkedHashMap.put("list_id", str);
        }
        String str2 = this.extInfo;
        if (str2 != null) {
            linkedHashMap.put("ext_info", str2);
        }
        httpRequest(Cgi.URI_MINORREG_QUERY, linkedHashMap);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Bundle extras;
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100:
            case 102:
                setResult(resultCode, data);
                finish();
                return;
            case 101:
                if (resultCode == -1) {
                    int i3 = WhenMappings.$EnumSwitchMapping$0[this.idVerifyType.ordinal()];
                    if (i3 != 1) {
                        if (i3 == 2) {
                            setResult(resultCode, data);
                            finish();
                            return;
                        }
                        return;
                    }
                    Intent intent = new Intent();
                    Intent intent2 = getIntent();
                    if (intent2 != null && (extras = intent2.getExtras()) != null) {
                        intent.putExtras(extras);
                    }
                    launchFragmentForResult(intent, IdVerifyActivity.class, 100);
                    return;
                }
                finish();
                return;
            default:
                QLog.i(((NetBaseActivity) this).TAG, 1, "unknown requestCode " + requestCode);
                return;
        }
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Serializable serializable;
        String str;
        super.onCreate(savedInstanceState);
        showQQPayLoading(0);
        Bundle arguments = getArguments();
        String str2 = null;
        if (arguments != null) {
            serializable = arguments.getSerializable(EXTRA_ID_VERIFY_TYPE);
        } else {
            serializable = null;
        }
        if (serializable instanceof EnumIdVerifyType) {
            this.idVerifyType = (EnumIdVerifyType) serializable;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString(IN_EXTRA_LIST_ID);
        } else {
            str = null;
        }
        this.incomeListId = str;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            str2 = arguments3.getString(IN_EXTRA_EXT_INFO);
        }
        this.extInfo = str2;
        QLog.i(((NetBaseActivity) this).TAG, 1, "idVerifyType=" + this.idVerifyType + ", incomeListId=" + this.incomeListId + ", extInfo=" + str2);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fym, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dismissQQPayLoading();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
        super.onSuccess(requestUrl, data);
        if (requestUrl != null && data != null && Intrinsics.areEqual(requestUrl, Cgi.URI_MINORREG_QUERY)) {
            onQueryRealNameCallback(data);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((TextView) view.findViewById(R.id.ivTitleName)).setText(R.string.f2189064z);
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.idverify.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IdVerifyEntryFragment.onViewCreated$lambda$0(IdVerifyEntryFragment.this, view2);
            }
        });
        sendRequest();
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
