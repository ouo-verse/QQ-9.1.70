package com.tenpay.idverify.guardian;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.gson.GsonBuilder;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tencent.util.QQToastUtil;
import com.tenpay.idverify.EnumGuardRelation;
import com.tenpay.idverify.EnumIdType;
import com.tenpay.idverify.EnumIdVerifyStateRole;
import com.tenpay.idverify.guardian.GuardianInputFragment;
import com.tenpay.idverify.hint.IdVerifyHintModule;
import com.tenpay.idverify.model.ChildrenRealNameConfig;
import com.tenpay.idverify.model.IdInfoBean;
import com.tenpay.idverify.model.IdVerifyStateBean;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.NetBaseActivity;
import com.tenpay.sdk.helper.RealNameAgePopHelper;
import com.tenpay.stackview.QWalletStackViewContainer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017J\b\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002J\u0016\u0010#\u001a\u00020\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0%H\u0002R\u001f\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/tenpay/idverify/guardian/GuardianInputFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "()V", "inputData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tenpay/idverify/guardian/GuardianInputFragment$GuardianInputData;", "kotlin.jvm.PlatformType", "getInputData", "()Landroidx/lifecycle/MutableLiveData;", "stackViewContainer", "Lcom/tenpay/stackview/QWalletStackViewContainer;", "checkAgeValid", "", "initStackContainer", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "onActivityCreated", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onBackEvent", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", "onSuccess", BrowserPlugin.KEY_REQUEST_URL, "data", "Lorg/json/JSONObject;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "sendGuardianCommit", "showCommitGuardianLayout", "showEnsureChildrenLayout", "nextStep", "Lkotlin/Function0;", "Companion", "GuardianInputData", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class GuardianInputFragment extends NetBaseActivity {

    @NotNull
    public static final String KEY_CHILDREN_INFO_JSON = "KEY_CHILDREN_INFO_JSON";

    @NotNull
    public static final String KEY_EXT_INFO = "KEY_EXT_INFO";

    @NotNull
    public static final String KEY_LIST_ID = "KEY_LIST_ID";

    @NotNull
    private final MutableLiveData<GuardianInputData> inputData = new MutableLiveData<>(new GuardianInputData(null, null, null, 7, null));
    private QWalletStackViewContainer stackViewContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\u0006\u0010\u0018\u001a\u00020\u0014J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/tenpay/idverify/guardian/GuardianInputFragment$GuardianInputData;", "", "name", "", "idCard", "role", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIdCard", "()Ljava/lang/String;", "setIdCard", "(Ljava/lang/String;)V", "getName", "setName", "getRole", "setRole", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", AppConstants.Key.COLUMN_IS_VALID, "toString", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final /* data */ class GuardianInputData {

        @Nullable
        private String idCard;

        @Nullable
        private String name;

        @Nullable
        private String role;

        public GuardianInputData() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ GuardianInputData copy$default(GuardianInputData guardianInputData, String str, String str2, String str3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = guardianInputData.name;
            }
            if ((i3 & 2) != 0) {
                str2 = guardianInputData.idCard;
            }
            if ((i3 & 4) != 0) {
                str3 = guardianInputData.role;
            }
            return guardianInputData.copy(str, str2, str3);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getIdCard() {
            return this.idCard;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getRole() {
            return this.role;
        }

        @NotNull
        public final GuardianInputData copy(@Nullable String name, @Nullable String idCard, @Nullable String role) {
            return new GuardianInputData(name, idCard, role);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuardianInputData)) {
                return false;
            }
            GuardianInputData guardianInputData = (GuardianInputData) other;
            if (Intrinsics.areEqual(this.name, guardianInputData.name) && Intrinsics.areEqual(this.idCard, guardianInputData.idCard) && Intrinsics.areEqual(this.role, guardianInputData.role)) {
                return true;
            }
            return false;
        }

        @Nullable
        public final String getIdCard() {
            return this.idCard;
        }

        @Nullable
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getRole() {
            return this.role;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.name;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.idCard;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.role;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return i17 + i3;
        }

        public final boolean isValid() {
            boolean z16;
            boolean z17;
            boolean z18;
            String str = this.name;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return false;
            }
            String str2 = this.idCard;
            if (str2 != null && str2.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                return false;
            }
            String str3 = this.role;
            if (str3 != null && str3.length() != 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                return false;
            }
            return true;
        }

        public final void setIdCard(@Nullable String str) {
            this.idCard = str;
        }

        public final void setName(@Nullable String str) {
            this.name = str;
        }

        public final void setRole(@Nullable String str) {
            this.role = str;
        }

        @NotNull
        public String toString() {
            return "GuardianInputData(name=" + this.name + ", idCard=" + this.idCard + ", role=" + this.role + ")";
        }

        public GuardianInputData(@Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.name = str;
            this.idCard = str2;
            this.role = str3;
        }

        public /* synthetic */ GuardianInputData(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3);
        }
    }

    private final String checkAgeValid() {
        String idCard;
        GuardianInputData value = this.inputData.getValue();
        if (value != null && (idCard = value.getIdCard()) != null) {
            if (RealNameAgePopHelper.getCidAgeType(idCard) != RealNameAgePopHelper.EnumPopAgeType.ADULT_PASS_18) {
                return getString(R.string.f2186964e, Integer.valueOf(ChildrenRealNameConfig.INSTANCE.get().getMajorityAge()));
            }
            return null;
        }
        return getString(R.string.f21860646);
    }

    private final void initStackContainer(View rootView) {
        View findViewById = rootView.findViewById(R.id.f87774v_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.stack_view_container)");
        QWalletStackViewContainer qWalletStackViewContainer = (QWalletStackViewContainer) findViewById;
        this.stackViewContainer = qWalletStackViewContainer;
        if (qWalletStackViewContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stackViewContainer");
            qWalletStackViewContainer = null;
        }
        qWalletStackViewContainer.init(this);
        showEnsureChildrenLayout(new Function0<Unit>() { // from class: com.tenpay.idverify.guardian.GuardianInputFragment$initStackContainer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuardianInputFragment.this.showCommitGuardianLayout();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(GuardianInputFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void sendGuardianCommit() {
        String str;
        String it;
        String it5;
        String idCard;
        String name;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uin", getCurrentUin());
        GuardianInputData value = this.inputData.getValue();
        if (value != null && (name = value.getName()) != null) {
            linkedHashMap.put("name", name);
        }
        linkedHashMap.put("cre_type", String.valueOf(EnumIdType.MAINLAND_ID_CARD.getValue()));
        GuardianInputData value2 = this.inputData.getValue();
        if (value2 != null && (idCard = value2.getIdCard()) != null) {
            linkedHashMap.put("cre_id", idCard);
        }
        EnumGuardRelation.Companion companion = EnumGuardRelation.INSTANCE;
        GuardianInputData value3 = this.inputData.getValue();
        if (value3 != null) {
            str = value3.getRole();
        } else {
            str = null;
        }
        linkedHashMap.put("guard_relation", String.valueOf(companion.findByDesc(str).getValue()));
        Bundle arguments = getArguments();
        if (arguments != null && (it5 = arguments.getString("KEY_EXT_INFO")) != null) {
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            linkedHashMap.put("ext_info", it5);
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (it = arguments2.getString("KEY_LIST_ID")) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            linkedHashMap.put("list_id", it);
        }
        httpRequest(Cgi.URI_MINORREG_CONFIRM, linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showCommitGuardianLayout() {
        GuardianInputChildVC guardianInputChildVC = new GuardianInputChildVC(this);
        String string = getResources().getString(R.string.f21863649);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026e_guardian_input_title_2)");
        guardianInputChildVC.setPageTitle(string);
        String string2 = getResources().getString(R.string.f21861647);
        Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026me_guardian_input_desc_2)");
        guardianInputChildVC.setPageDesc(string2);
        String string3 = getResources().getString(R.string.f2187764m);
        Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st\u2026g.qwallet_real_name_name)");
        GuardianInputChildVC.setNameItem$default(guardianInputChildVC, string3, null, getResources().getString(R.string.f2186464_), true, false, new Function1<String, Unit>() { // from class: com.tenpay.idverify.guardian.GuardianInputFragment$showCommitGuardianLayout$secondChildVC$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String content) {
                Intrinsics.checkNotNullParameter(content, "content");
                GuardianInputFragment.GuardianInputData value = GuardianInputFragment.this.getInputData().getValue();
                if (value != null) {
                    value.setName(content);
                }
                GuardianInputFragment.this.getInputData().postValue(GuardianInputFragment.this.getInputData().getValue());
            }
        }, 18, null);
        String string4 = getResources().getString(R.string.f2187464j);
        Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st\u2026wallet_real_name_id_type)");
        GuardianInputChildVC.setIdTypeItem$default(guardianInputChildVC, string4, getResources().getString(R.string.f2187664l), null, false, false, null, 52, null);
        String string5 = getResources().getString(R.string.f2187264h);
        Intrinsics.checkNotNullExpressionValue(string5, "resources.getString(R.st\u2026.qwallet_real_name_id_no)");
        GuardianInputChildVC.setIdCardItem$default(guardianInputChildVC, string5, null, getResources().getString(R.string.f2187364i), true, false, new Function1<String, Unit>() { // from class: com.tenpay.idverify.guardian.GuardianInputFragment$showCommitGuardianLayout$secondChildVC$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String content) {
                Intrinsics.checkNotNullParameter(content, "content");
                GuardianInputFragment.GuardianInputData value = GuardianInputFragment.this.getInputData().getValue();
                if (value != null) {
                    value.setIdCard(content);
                }
                GuardianInputFragment.this.getInputData().postValue(GuardianInputFragment.this.getInputData().getValue());
            }
        }, 18, null);
        String string6 = getResources().getString(R.string.f2186764c);
        String string7 = getResources().getString(R.string.f2186864d);
        EnumGuardRelation[] values = EnumGuardRelation.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (EnumGuardRelation enumGuardRelation : values) {
            arrayList.add(enumGuardRelation.getDesc());
        }
        Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.qwall\u2026_real_name_guardian_role)");
        GuardianInputChildVC.setRoleItem$default(guardianInputChildVC, string6, null, string7, true, arrayList, false, new Function1<String, Unit>() { // from class: com.tenpay.idverify.guardian.GuardianInputFragment$showCommitGuardianLayout$secondChildVC$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String content) {
                Intrinsics.checkNotNullParameter(content, "content");
                GuardianInputFragment.GuardianInputData value = GuardianInputFragment.this.getInputData().getValue();
                if (value != null) {
                    value.setRole(content);
                }
                GuardianInputFragment.this.getInputData().postValue(GuardianInputFragment.this.getInputData().getValue());
            }
        }, 34, null);
        final MutableLiveData mutableLiveData = new MutableLiveData(Boolean.FALSE);
        MutableLiveData<GuardianInputData> mutableLiveData2 = this.inputData;
        LifecycleOwner viewLifecycleOwner = guardianInputChildVC.getFragment().getViewLifecycleOwner();
        final Function1<GuardianInputData, Unit> function1 = new Function1<GuardianInputData, Unit>() { // from class: com.tenpay.idverify.guardian.GuardianInputFragment$showCommitGuardianLayout$secondChildVC$1$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuardianInputFragment.GuardianInputData guardianInputData) {
                invoke2(guardianInputData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuardianInputFragment.GuardianInputData guardianInputData) {
                mutableLiveData.postValue(Boolean.valueOf(guardianInputData.isValid()));
            }
        };
        mutableLiveData2.observe(viewLifecycleOwner, new Observer() { // from class: com.tenpay.idverify.guardian.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuardianInputFragment.showCommitGuardianLayout$lambda$6$lambda$4(Function1.this, obj);
            }
        });
        GuardianInputChildVC.setConfirmBtn$default(guardianInputChildVC, false, getResources().getString(R.string.f21855641), mutableLiveData, new View.OnClickListener() { // from class: com.tenpay.idverify.guardian.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuardianInputFragment.showCommitGuardianLayout$lambda$6$lambda$5(GuardianInputFragment.this, view);
            }
        }, 1, null);
        QWalletStackViewContainer qWalletStackViewContainer = this.stackViewContainer;
        if (qWalletStackViewContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stackViewContainer");
            qWalletStackViewContainer = null;
        }
        qWalletStackViewContainer.push(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, guardianInputChildVC.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCommitGuardianLayout$lambda$6$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCommitGuardianLayout$lambda$6$lambda$5(GuardianInputFragment this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String checkAgeValid = this$0.checkAgeValid();
        if (checkAgeValid != null && checkAgeValid.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this$0.sendGuardianCommit();
        } else {
            QQToastUtil.showQQToast(1, checkAgeValid);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void showEnsureChildrenLayout(final Function0<Unit> nextStep) {
        String str;
        Bundle arguments = getArguments();
        QWalletStackViewContainer qWalletStackViewContainer = null;
        if (arguments != null) {
            str = arguments.getString(KEY_CHILDREN_INFO_JSON);
        } else {
            str = null;
        }
        try {
            Object fromJson = new GsonBuilder().create().fromJson(str, (Class<Object>) IdInfoBean.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "GsonBuilder().create().f\u2026, IdInfoBean::class.java)");
            IdInfoBean idInfoBean = (IdInfoBean) fromJson;
            QLog.w(((NetBaseActivity) this).TAG, 1, "parse childrenInfoBean: " + idInfoBean);
            GuardianInputChildVC guardianInputChildVC = new GuardianInputChildVC(this);
            String string = getResources().getString(R.string.f21862648);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026e_guardian_input_title_1)");
            guardianInputChildVC.setPageTitle(string);
            String string2 = getResources().getString(R.string.f2187764m);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.st\u2026g.qwallet_real_name_name)");
            GuardianInputChildVC.setNameItem$default(guardianInputChildVC, string2, idInfoBean.getName(), null, false, false, null, 52, null);
            String string3 = getResources().getString(R.string.f2187464j);
            Intrinsics.checkNotNullExpressionValue(string3, "resources.getString(R.st\u2026wallet_real_name_id_type)");
            GuardianInputChildVC.setIdTypeItem$default(guardianInputChildVC, string3, getResources().getString(EnumIdType.INSTANCE.create(idInfoBean.getCreType()).getDescResId()), null, false, false, null, 52, null);
            String string4 = getResources().getString(R.string.f2187264h);
            Intrinsics.checkNotNullExpressionValue(string4, "resources.getString(R.st\u2026.qwallet_real_name_id_no)");
            GuardianInputChildVC.setIdCardItem$default(guardianInputChildVC, string4, idInfoBean.getCreId(), null, false, false, null, 52, null);
            GuardianInputChildVC.setConfirmBtn$default(guardianInputChildVC, false, getResources().getString(R.string.f2187864n), null, new View.OnClickListener() { // from class: com.tenpay.idverify.guardian.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuardianInputFragment.showEnsureChildrenLayout$lambda$2$lambda$1(Function0.this, view);
                }
            }, 5, null);
            QWalletStackViewContainer qWalletStackViewContainer2 = this.stackViewContainer;
            if (qWalletStackViewContainer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stackViewContainer");
            } else {
                qWalletStackViewContainer = qWalletStackViewContainer2;
            }
            qWalletStackViewContainer.push(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, guardianInputChildVC.getRootView());
        } catch (Exception e16) {
            QLog.w(((NetBaseActivity) this).TAG, 1, "parse childrenInfoBean error:", e16);
            QQToastUtil.showQQToast(R.string.f21856642);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showEnsureChildrenLayout$lambda$2$lambda$1(Function0 nextStep, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(nextStep, "$nextStep");
        nextStep.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final MutableLiveData<GuardianInputData> getInputData() {
        return this.inputData;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getHostActivity().getWindow().setSoftInputMode(32);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        QWalletStackViewContainer qWalletStackViewContainer = this.stackViewContainer;
        if (qWalletStackViewContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stackViewContainer");
            qWalletStackViewContainer = null;
        }
        qWalletStackViewContainer.pop();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fyf, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
        IdVerifyStateBean idVerifyStateBean;
        super.onSuccess(requestUrl, data);
        try {
            idVerifyStateBean = (IdVerifyStateBean) new GsonBuilder().create().fromJson(String.valueOf(data), IdVerifyStateBean.class);
            try {
                idVerifyStateBean.setRole(EnumIdVerifyStateRole.INVITEES.ordinal());
            } catch (Exception e16) {
                e = e16;
                QLog.w(((NetBaseActivity) this).TAG, 1, "gson fail: " + data, e);
                IdVerifyHintModule.startStateBeanHint$default(this, idVerifyStateBean, 0, 4, null);
            }
        } catch (Exception e17) {
            e = e17;
            idVerifyStateBean = null;
        }
        IdVerifyHintModule.startStateBeanHint$default(this, idVerifyStateBean, 0, 4, null);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.idverify.guardian.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuardianInputFragment.onViewCreated$lambda$0(GuardianInputFragment.this, view2);
            }
        });
        initStackContainer(view);
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
