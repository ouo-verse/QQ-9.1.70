package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.config.AddFriendOpenSdkConfigParser;
import com.tencent.mobileqq.addfriend.handler.NTAddFriendHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.ay;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0097\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001J\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001QB\u0007\u00a2\u0006\u0004\bN\u0010OJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J*\u0010\u0016\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J*\u0010\u0018\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0018\u0010\"\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020 J\u0012\u0010#\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00106R\u0018\u0010C\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010:R\u0018\u0010E\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010:R\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendGroupAndRemarkPart;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/v;", "Landroid/text/TextWatcher;", "Landroid/view/View$OnClickListener;", "", "ia", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "la", "ma", LocaleUtils.L_JAPANESE, "na", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartCreate", "onPartResume", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "", "msg", "", "isTroop", "pa", "onPartDestroy", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/d;", "mAddFriendRemarkViewModel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/a;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/a;", "mAddFriendGroupViewModel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/g;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/g;", "mAddFriendVerifyMsgViewModel", "Landroid/widget/LinearLayout;", "T", "Landroid/widget/LinearLayout;", "groupAndRemarkLayout", "Lcom/tencent/mobileqq/widget/FormItemRelativeLayout;", "U", "Lcom/tencent/mobileqq/widget/FormItemRelativeLayout;", "mRlRemark", "Landroid/widget/TextView;", "V", "Landroid/widget/TextView;", "mRemarkTitleText", "Lcom/tencent/mobileqq/widget/ClearableEditText;", "W", "Lcom/tencent/mobileqq/widget/ClearableEditText;", "mEtRemark", "X", "mRlGroup", "Y", "mGroupTitleText", "Z", "mTvGroup", "Landroid/widget/EditText;", "a0", "Landroid/widget/EditText;", "mRequestInfoEt", "com/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendGroupAndRemarkPart$b", "b0", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendGroupAndRemarkPart$b;", "mAddFriendObserver", "<init>", "()V", "c0", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AddFriendGroupAndRemarkPart extends v implements TextWatcher, View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d mAddFriendRemarkViewModel;

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a mAddFriendGroupViewModel;

    /* renamed from: S, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g mAddFriendVerifyMsgViewModel;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private LinearLayout groupAndRemarkLayout;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private FormItemRelativeLayout mRlRemark;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private TextView mRemarkTitleText;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private ClearableEditText mEtRemark;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private FormItemRelativeLayout mRlGroup;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private TextView mGroupTitleText;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private TextView mTvGroup;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText mRequestInfoEt;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAddFriendObserver;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendGroupAndRemarkPart$a;", "", "", "REQUEST_CODE_GROUP", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendGroupAndRemarkPart$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/addfriend/ui/fornt/verify/part/AddFriendGroupAndRemarkPart$b", "Lcom/tencent/mobileqq/addfriend/observer/a;", "", "isSuccess", "", "uin", "remark", "", "groupId", "", "e", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends com.tencent.mobileqq.addfriend.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendGroupAndRemarkPart.this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x008d, code lost:
        
            if (r6.x9(r6.L9()) == false) goto L26;
         */
        @Override // com.tencent.mobileqq.addfriend.observer.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void e(boolean isSuccess, @Nullable String uin, @NotNull String remark, int groupId) {
            FormItemRelativeLayout formItemRelativeLayout;
            Editable editable;
            Editable text;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), uin, remark, Integer.valueOf(groupId));
                return;
            }
            Intrinsics.checkNotNullParameter(remark, "remark");
            if (TextUtils.equals(AddFriendGroupAndRemarkPart.this.D9(), uin) && !AddFriendGroupAndRemarkPart.this.W9()) {
                String strangerRemark = ay.b(AddFriendGroupAndRemarkPart.this.D9());
                if (!TextUtils.isEmpty(strangerRemark)) {
                    Intrinsics.checkNotNullExpressionValue(strangerRemark, "strangerRemark");
                    remark = strangerRemark;
                }
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a aVar = null;
                if (!isSuccess) {
                    com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a aVar2 = AddFriendGroupAndRemarkPart.this.mAddFriendGroupViewModel;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAddFriendGroupViewModel");
                        aVar2 = null;
                    }
                    aVar2.N1(0);
                } else {
                    if (!((IAddFriendApi) QRoute.api(IAddFriendApi.class)).shouldUseLocalRemark(AddFriendGroupAndRemarkPart.this.L9()) && AddFriendGroupAndRemarkPart.this.Q9() == null) {
                        if (TextUtils.isEmpty(remark)) {
                            AddFriendGroupAndRemarkPart addFriendGroupAndRemarkPart = AddFriendGroupAndRemarkPart.this;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("AddFriendGroupAndRemarkPart", 2, "onGetAutoInfo remark = " + remark);
                        }
                        ClearableEditText clearableEditText = AddFriendGroupAndRemarkPart.this.mEtRemark;
                        if (clearableEditText != null) {
                            clearableEditText.setText(remark);
                        }
                        try {
                            ClearableEditText clearableEditText2 = AddFriendGroupAndRemarkPart.this.mEtRemark;
                            if (clearableEditText2 != null && (text = clearableEditText2.getText()) != null) {
                                int length = text.length();
                                ClearableEditText clearableEditText3 = AddFriendGroupAndRemarkPart.this.mEtRemark;
                                if (clearableEditText3 != null) {
                                    clearableEditText3.setSelection(length);
                                }
                            }
                        } catch (IndexOutOfBoundsException unused) {
                            if (QLog.isColorLevel()) {
                                QLog.d("AddFriendGroupAndRemarkPart", 2, "onGetAutoInfo | IndexOutOfBoundsException");
                            }
                        }
                        if (AppSetting.f99565y && (formItemRelativeLayout = AddFriendGroupAndRemarkPart.this.mRlRemark) != null) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(AddFriendGroupAndRemarkPart.this.getString(R.string.bws));
                            ClearableEditText clearableEditText4 = AddFriendGroupAndRemarkPart.this.mEtRemark;
                            if (clearableEditText4 != null) {
                                editable = clearableEditText4.getText();
                            } else {
                                editable = null;
                            }
                            sb5.append((Object) editable);
                            formItemRelativeLayout.setContentDescription(sb5.toString());
                        }
                    }
                    com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a aVar3 = AddFriendGroupAndRemarkPart.this.mAddFriendGroupViewModel;
                    if (aVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAddFriendGroupViewModel");
                        aVar3 = null;
                    }
                    aVar3.N1(groupId);
                }
                TextView textView = AddFriendGroupAndRemarkPart.this.mTvGroup;
                if (textView != null) {
                    IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
                    AppInterface z95 = AddFriendGroupAndRemarkPart.this.z9();
                    com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a aVar4 = AddFriendGroupAndRemarkPart.this.mAddFriendGroupViewModel;
                    if (aVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAddFriendGroupViewModel");
                    } else {
                        aVar = aVar4;
                    }
                    textView.setText(iAddFriendApi.getGroupName(z95, aVar.M1()));
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22672);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AddFriendGroupAndRemarkPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAddFriendObserver = new b();
        }
    }

    private final void ia() {
        AppInterface z95 = z9();
        if (z95 == null) {
            return;
        }
        z95.addObserver(this.mAddFriendObserver);
    }

    private final void ja() {
        LinearLayout linearLayout;
        Integer P9 = P9();
        if (P9 != null && P9.intValue() == 3 && M9() != 101 && !K9() && !J9() && !I9() && !AddFriendOpenSdkConfigParser.INSTANCE.c(L9()) && (linearLayout = this.groupAndRemarkLayout) != null) {
            linearLayout.setVisibility(8);
        }
        na();
    }

    private final void la(Bundle savedInstanceState) {
        NTAddFriendHandler B9;
        ViewModel viewModel = getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(AddFriendRemarkViewModel::class.java)");
        this.mAddFriendRemarkViewModel = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d) viewModel;
        ViewModel viewModel2 = getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(AddFriendGroupViewModel::class.java)");
        this.mAddFriendGroupViewModel = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a) viewModel2;
        ViewModel viewModel3 = getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "getViewModel(AddFriendVe\u2026MsgViewModel::class.java)");
        this.mAddFriendVerifyMsgViewModel = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g) viewModel3;
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar = this.mAddFriendRemarkViewModel;
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a aVar = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendRemarkViewModel");
            dVar = null;
        }
        dVar.Q1(getIntent(), L9(), M9(), Q9());
        if (x9(L9())) {
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar2 = this.mAddFriendRemarkViewModel;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendRemarkViewModel");
                dVar2 = null;
            }
            Intent intent = getIntent();
            String D9 = D9();
            if (D9 == null) {
                D9 = "";
            }
            dVar2.P1(intent, D9);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("remark = ");
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar3 = this.mAddFriendRemarkViewModel;
            if (dVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendRemarkViewModel");
                dVar3 = null;
            }
            sb5.append(dVar3.L1());
            sb5.append(" +  source id= ");
            sb5.append(L9());
            sb5.append(", mTargetGroupId  + ");
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a aVar2 = this.mAddFriendGroupViewModel;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendGroupViewModel");
            } else {
                aVar = aVar2;
            }
            sb5.append(aVar.M1());
            QLog.i("AddFriendGroupAndRemarkPart", 2, sb5.toString());
        }
        if (savedInstanceState == null && NetworkUtil.isNetSupport(getActivity()) && com.tencent.mobileqq.addfriend.utils.a.o(L9(), D9()) && (B9 = B9()) != null) {
            B9.N2(A9(), D9(), L9(), M9());
        }
    }

    private final void ma() {
        ClearableEditText clearableEditText;
        this.mRequestInfoEt = (EditText) getPartRootView().findViewById(R.id.f166785i82);
        this.mRemarkTitleText = (TextView) getPartRootView().findViewById(R.id.f98775o0);
        this.mGroupTitleText = (TextView) getPartRootView().findViewById(R.id.f98485n8);
        this.groupAndRemarkLayout = (LinearLayout) getPartRootView().findViewById(R.id.cxh);
        FormItemRelativeLayout formItemRelativeLayout = (FormItemRelativeLayout) getPartRootView().findViewById(R.id.idd);
        this.mRlRemark = formItemRelativeLayout;
        if (formItemRelativeLayout != null) {
            formItemRelativeLayout.setBackgroundDrawable(getActivity().getDrawable(R.drawable.j38));
        }
        this.mEtRemark = (ClearableEditText) getPartRootView().findViewById(R.id.bz4);
        FormItemRelativeLayout formItemRelativeLayout2 = (FormItemRelativeLayout) getPartRootView().findViewById(R.id.ici);
        this.mRlGroup = formItemRelativeLayout2;
        if (formItemRelativeLayout2 != null) {
            formItemRelativeLayout2.setBackgroundDrawable(getActivity().getDrawable(R.drawable.j38));
        }
        this.mTvGroup = (TextView) getPartRootView().findViewById(R.id.k8i);
        ClearableEditText clearableEditText2 = this.mEtRemark;
        if (clearableEditText2 != null) {
            clearableEditText2.addTextChangedListener(this);
        }
        FormItemRelativeLayout formItemRelativeLayout3 = this.mRlGroup;
        if (formItemRelativeLayout3 != null) {
            formItemRelativeLayout3.setOnClickListener(this);
        }
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar = this.mAddFriendRemarkViewModel;
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a aVar = null;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendRemarkViewModel");
            dVar = null;
        }
        String M1 = dVar.M1();
        if (!TextUtils.isEmpty(M1)) {
            ClearableEditText clearableEditText3 = this.mEtRemark;
            if (clearableEditText3 != null) {
                clearableEditText3.setText(M1);
            }
            ClearableEditText clearableEditText4 = this.mEtRemark;
            if (clearableEditText4 != null) {
                clearableEditText4.setSelection(M1.length());
            }
        } else {
            String b16 = ay.b(D9());
            if (!TextUtils.isEmpty(b16)) {
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar2 = this.mAddFriendRemarkViewModel;
                if (dVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddFriendRemarkViewModel");
                    dVar2 = null;
                }
                dVar2.R1(b16);
            }
            ClearableEditText clearableEditText5 = this.mEtRemark;
            if (clearableEditText5 != null) {
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar3 = this.mAddFriendRemarkViewModel;
                if (dVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddFriendRemarkViewModel");
                    dVar3 = null;
                }
                clearableEditText5.setText(dVar3.L1());
            }
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar4 = this.mAddFriendRemarkViewModel;
            if (dVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendRemarkViewModel");
                dVar4 = null;
            }
            if (!TextUtils.isEmpty(dVar4.L1()) && (clearableEditText = this.mEtRemark) != null) {
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.d dVar5 = this.mAddFriendRemarkViewModel;
                if (dVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddFriendRemarkViewModel");
                    dVar5 = null;
                }
                clearableEditText.setSelection(dVar5.L1().length());
            }
        }
        TextView textView = this.mTvGroup;
        if (textView != null) {
            AppInterface z95 = z9();
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a aVar2 = this.mAddFriendGroupViewModel;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendGroupViewModel");
                aVar2 = null;
            }
            textView.setText(com.tencent.mobileqq.addfriend.utils.a.i(z95, aVar2.M1()));
        }
        FormItemRelativeLayout formItemRelativeLayout4 = this.mRlGroup;
        if (formItemRelativeLayout4 != null) {
            AppInterface z96 = z9();
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a aVar3 = this.mAddFriendGroupViewModel;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendGroupViewModel");
            } else {
                aVar = aVar3;
            }
            formItemRelativeLayout4.setContentDescription(com.tencent.mobileqq.addfriend.utils.a.i(z96, aVar.M1()));
        }
        if (Utils.G(D9())) {
            FormItemRelativeLayout formItemRelativeLayout5 = this.mRlRemark;
            if (formItemRelativeLayout5 != null) {
                formItemRelativeLayout5.setVisibility(8);
            }
            TextView textView2 = this.mRemarkTitleText;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        } else {
            FormItemRelativeLayout formItemRelativeLayout6 = this.mRlRemark;
            if (formItemRelativeLayout6 != null) {
                formItemRelativeLayout6.setVisibility(0);
            }
            TextView textView3 = this.mRemarkTitleText;
            if (textView3 != null) {
                textView3.setText(getActivity().getString(R.string.ykk));
            }
        }
        TextView textView4 = this.mGroupTitleText;
        if (textView4 != null) {
            textView4.setText(getActivity().getString(R.string.ykj));
        }
    }

    private final void na() {
        LifecycleOwner lifecycleOwner;
        IPartHost partHost = getPartHost();
        if (partHost != null && (lifecycleOwner = partHost.getLifecycleOwner()) != null) {
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a aVar = this.mAddFriendGroupViewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendGroupViewModel");
                aVar = null;
            }
            MutableLiveData<Integer> L1 = aVar.L1();
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.AddFriendGroupAndRemarkPart$observeGroupSelected$1$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFriendGroupAndRemarkPart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer selectedGroupId) {
                    FormItemRelativeLayout formItemRelativeLayout;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) selectedGroupId);
                        return;
                    }
                    AppInterface z95 = AddFriendGroupAndRemarkPart.this.z9();
                    com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a aVar2 = AddFriendGroupAndRemarkPart.this.mAddFriendGroupViewModel;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAddFriendGroupViewModel");
                        aVar2 = null;
                    }
                    Intrinsics.checkNotNullExpressionValue(selectedGroupId, "selectedGroupId");
                    aVar2.N1(selectedGroupId.intValue());
                    TextView textView = AddFriendGroupAndRemarkPart.this.mTvGroup;
                    if (textView != null) {
                        textView.setText(((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getGroupName(z95, selectedGroupId.intValue()));
                    }
                    formItemRelativeLayout = AddFriendGroupAndRemarkPart.this.mRlGroup;
                    if (formItemRelativeLayout != null) {
                        formItemRelativeLayout.setContentDescription(HardCodeUtil.qqStr(R.string.j4e) + ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).getGroupName(z95, selectedGroupId.intValue()));
                    }
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Add Friend verify select group id ");
                        sb5.append(selectedGroupId);
                        sb5.append(", text:");
                        TextView textView2 = AddFriendGroupAndRemarkPart.this.mTvGroup;
                        sb5.append((Object) (textView2 != null ? textView2.getText() : null));
                        QLog.i("AddFriendGroupAndRemarkPart", 2, sb5.toString());
                    }
                }
            };
            L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AddFriendGroupAndRemarkPart.oa(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable s16) {
        Editable editable;
        FormItemRelativeLayout formItemRelativeLayout;
        int i3;
        ClearableEditText clearableEditText;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) s16);
            return;
        }
        ClearableEditText clearableEditText2 = this.mEtRemark;
        Editable editable2 = null;
        if (clearableEditText2 != null) {
            editable = clearableEditText2.getText();
        } else {
            editable = null;
        }
        String valueOf = String.valueOf(editable);
        if (com.tencent.mobileqq.addfriend.utils.a.e(valueOf) > 32) {
            ClearableEditText clearableEditText3 = this.mEtRemark;
            if (clearableEditText3 != null) {
                i3 = clearableEditText3.getSelectionStart();
            } else {
                i3 = 0;
            }
            String j3 = com.tencent.mobileqq.addfriend.utils.a.j(valueOf);
            Intrinsics.checkNotNullExpressionValue(j3, "getRemark(remark)");
            ClearableEditText clearableEditText4 = this.mEtRemark;
            if (clearableEditText4 != null) {
                clearableEditText4.setText(j3);
            }
            if (i3 >= j3.length() && (clearableEditText = this.mEtRemark) != null) {
                clearableEditText.setSelection(j3.length());
            }
        }
        if (AppSetting.f99565y && (formItemRelativeLayout = this.mRlRemark) != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(getActivity().getString(R.string.bws));
            ClearableEditText clearableEditText5 = this.mEtRemark;
            if (clearableEditText5 != null) {
                editable2 = clearableEditText5.getText();
            }
            sb5.append((Object) editable2);
            formItemRelativeLayout.setContentDescription(sb5.toString());
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (v3.getId() == R.id.ici && !W9()) {
                IAddFriendTempApi iAddFriendTempApi = (IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class);
                Activity activity = getActivity();
                Fragment hostFragment = getHostFragment();
                String D9 = D9();
                com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.a aVar = this.mAddFriendGroupViewModel;
                Editable editable = null;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAddFriendGroupViewModel");
                    aVar = null;
                }
                iAddFriendTempApi.jumpToMoveGroup(activity, hostFragment, D9, aVar.M1(), 1002);
                EditText editText = this.mRequestInfoEt;
                if (editText != null) {
                    if (editText != null) {
                        editable = editText.getText();
                    }
                    pa(String.valueOf(editable), false);
                }
                ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X80077B2", "0X80077B2", 0, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.addfriend.ui.fornt.verify.part.v, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        ia();
        la(savedInstanceState);
        ma();
        ja();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        AppInterface z95 = z9();
        if (z95 != null) {
            z95.removeObserver(this.mAddFriendObserver);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
        }
    }

    public final void pa(@Nullable String msg2, boolean isTroop) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, msg2, Boolean.valueOf(isTroop));
            return;
        }
        if (getActivity() != null && MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            if (Q9() == null && L9() != 3016 && L9() != 3103) {
                if (!K9() && !J9() && !I9() && !H9()) {
                    com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.g gVar = this.mAddFriendVerifyMsgViewModel;
                    if (gVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAddFriendVerifyMsgViewModel");
                        gVar = null;
                    }
                    Activity activity = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    gVar.O1(activity, msg2, isTroop);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AddFriendGroupAndRemarkPart", 2, "saveVerifyMsg return from wzry");
            }
        }
    }
}
