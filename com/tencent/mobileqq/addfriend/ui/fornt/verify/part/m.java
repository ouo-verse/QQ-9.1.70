package com.tencent.mobileqq.addfriend.ui.fornt.verify.part;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.abtest.api.IAddFriendTabApi;
import com.tencent.mobileqq.addfriend.ui.fornt.verify.AddFriendVerifyFragmentForNT;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.ab;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FriendPermissionsSwitch;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\t*\u00015\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001eR\u0018\u0010-\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u0016R\u0018\u0010/\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u0016R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010,R\u0018\u00104\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u0016R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/m;", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/v;", "", "initData", "ba", "ca", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/c;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/c;", "mAddFriendPermissionViewModel", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/b;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/b;", "mAddFriendHeaderViewModel", "Landroid/widget/TextView;", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/TextView;", "mRequestInfoTxt", "Lcom/tencent/mobileqq/widget/FriendPermissionsSwitch;", "T", "Lcom/tencent/mobileqq/widget/FriendPermissionsSwitch;", "mFriendPermissionsSwitch", "Lcom/tencent/mobileqq/widget/FormItemRelativeLayout;", "U", "Lcom/tencent/mobileqq/widget/FormItemRelativeLayout;", "mRlGroup", "V", "mTvGroup", "Lcom/tencent/mobileqq/widget/BounceScrollView;", "W", "Lcom/tencent/mobileqq/widget/BounceScrollView;", "mBounceScrollView", "Landroid/widget/LinearLayout;", "X", "Landroid/widget/LinearLayout;", "groupAndRemarkLayout", "Y", "mRlRemark", "Z", "mRemarkTitleText", "a0", "mGroupTitleText", "", "b0", "mIsShowFriendPermissionComponent", "c0", "mReportText", "com/tencent/mobileqq/addfriend/ui/fornt/verify/part/m$b", "d0", "Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/m$b;", "mAddFriendObserver", "<init>", "()V", "e0", "a", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class m extends v {
    static IPatchRedirector $redirector_;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: Q, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.c mAddFriendPermissionViewModel;

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.b mAddFriendHeaderViewModel;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private TextView mRequestInfoTxt;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private FriendPermissionsSwitch mFriendPermissionsSwitch;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private FormItemRelativeLayout mRlGroup;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private TextView mTvGroup;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private BounceScrollView mBounceScrollView;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private LinearLayout groupAndRemarkLayout;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private FormItemRelativeLayout mRlRemark;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private TextView mRemarkTitleText;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mGroupTitleText;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowFriendPermissionComponent;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mReportText;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAddFriendObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/part/m$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.addfriend.ui.fornt.verify.part.m$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JH\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022.\u0010\b\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u00072\u0006\u0010\t\u001a\u00020\u0006H\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/addfriend/ui/fornt/verify/part/m$b", "Lcom/tencent/mobileqq/addfriend/observer/a;", "", "isSuccess", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "data", "status", "", "j", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends com.tencent.mobileqq.addfriend.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) m.this);
            }
        }

        @Override // com.tencent.mobileqq.addfriend.observer.a
        protected void j(boolean isSuccess, @Nullable HashMap<String, Integer> data, int status) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), data, Integer.valueOf(status));
                return;
            }
            if (!m.this.W9() && data != null && QLog.isColorLevel()) {
                QLog.d("AddFriendPermissionAndShowPart", 2, "onUpdateSetFriendPermission | Qzone Permission is " + status + " set result:" + isSuccess);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23640);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAddFriendObserver = new b();
        }
    }

    private final void ba() {
        this.mRequestInfoTxt = (TextView) getPartRootView().findViewById(R.id.f166786i83);
        this.mRemarkTitleText = (TextView) getPartRootView().findViewById(R.id.f98775o0);
        this.mGroupTitleText = (TextView) getPartRootView().findViewById(R.id.f98485n8);
        this.groupAndRemarkLayout = (LinearLayout) getPartRootView().findViewById(R.id.cxh);
        this.mRlRemark = (FormItemRelativeLayout) getPartRootView().findViewById(R.id.idd);
        this.mRlGroup = (FormItemRelativeLayout) getPartRootView().findViewById(R.id.ici);
        this.mTvGroup = (TextView) getPartRootView().findViewById(R.id.k8i);
        this.mBounceScrollView = (BounceScrollView) getPartRootView().findViewById(R.id.adt);
        this.mReportText = (TextView) getPartRootView().findViewById(R.id.sd8);
        ca();
    }

    private final void ca() {
        FriendPermissionsSwitch friendPermissionsSwitch;
        ViewGroup.LayoutParams layoutParams;
        int i3;
        View findViewById = getPartRootView().findViewById(R.id.f68983hi);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FriendPermissionsSwitch");
        FriendPermissionsSwitch friendPermissionsSwitch2 = (FriendPermissionsSwitch) findViewById;
        this.mFriendPermissionsSwitch = friendPermissionsSwitch2;
        CharSequence charSequence = null;
        if (friendPermissionsSwitch2 != null) {
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.c cVar = this.mAddFriendPermissionViewModel;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendPermissionViewModel");
                cVar = null;
            }
            if (cVar.L1()) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            friendPermissionsSwitch2.setVisibility(i3);
        }
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.c cVar2 = this.mAddFriendPermissionViewModel;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendPermissionViewModel");
            cVar2 = null;
        }
        if (!cVar2.L1()) {
            TextView textView = this.mReportText;
            if (textView != null) {
                layoutParams = textView.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
                return;
            }
            ((RelativeLayout.LayoutParams) layoutParams).topMargin = -DisplayUtil.dip2px(getContext(), 14.0f);
            TextView textView2 = this.mReportText;
            if (textView2 != null) {
                textView2.setLayoutParams(layoutParams);
            }
        }
        if (!this.mIsShowFriendPermissionComponent && (friendPermissionsSwitch = this.mFriendPermissionsSwitch) != null) {
            friendPermissionsSwitch.o();
        }
        if (ab.a() && AddFriendVerifyFragmentForNT.T) {
            com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.b bVar = this.mAddFriendHeaderViewModel;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddFriendHeaderViewModel");
                bVar = null;
            }
            bVar.M1().postValue(getActivity().getString(R.string.b2q));
            FormItemRelativeLayout formItemRelativeLayout = this.mRlGroup;
            if (formItemRelativeLayout != null) {
                formItemRelativeLayout.setFocusable(true);
            }
            FormItemRelativeLayout formItemRelativeLayout2 = this.mRlGroup;
            if (formItemRelativeLayout2 != null) {
                TextView textView3 = this.mTvGroup;
                if (textView3 != null) {
                    charSequence = textView3.getText();
                }
                formItemRelativeLayout2.setContentDescription(String.valueOf(charSequence));
            }
            AccessibilityUtil.n(this.mBounceScrollView, false);
            AccessibilityUtil.n(this.mRlRemark, false);
            AccessibilityUtil.n(this.groupAndRemarkLayout, false);
            AccessibilityUtil.n(this.mTvGroup, false);
            if (Build.VERSION.SDK_INT >= 28) {
                TextView textView4 = this.mRequestInfoTxt;
                if (textView4 != null) {
                    textView4.setAccessibilityHeading(true);
                }
                TextView textView5 = this.mRemarkTitleText;
                if (textView5 != null) {
                    textView5.setAccessibilityHeading(true);
                }
                TextView textView6 = this.mGroupTitleText;
                if (textView6 != null) {
                    textView6.setAccessibilityHeading(true);
                    return;
                }
                return;
            }
            TextView textView7 = this.mRequestInfoTxt;
            if (textView7 != null) {
                textView7.setContentDescription(getActivity().getString(R.string.f170053e3));
            }
            TextView textView8 = this.mRemarkTitleText;
            if (textView8 != null) {
                textView8.setContentDescription(getActivity().getString(R.string.f220846_8));
            }
            TextView textView9 = this.mGroupTitleText;
            if (textView9 != null) {
                textView9.setContentDescription(getActivity().getString(R.string.f1384509l));
            }
        }
    }

    private final void initData() {
        ViewModel viewModel = getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(AddFriendPe\u2026ionViewModel::class.java)");
        com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.c cVar = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.c) viewModel;
        this.mAddFriendPermissionViewModel = cVar;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddFriendPermissionViewModel");
            cVar = null;
        }
        cVar.M1(L9());
        ViewModel viewModel2 = getViewModel(com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(AddFriendHeaderViewModel::class.java)");
        this.mAddFriendHeaderViewModel = (com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel.b) viewModel2;
        this.mIsShowFriendPermissionComponent = ((IAddFriendTabApi) QRoute.api(IAddFriendTabApi.class)).isAddQZonePermissionSwitch(0);
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
        AppInterface z95 = z9();
        if (z95 != null) {
            z95.addObserver(this.mAddFriendObserver);
        }
        initData();
        ba();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        AppInterface z95 = z9();
        if (z95 != null) {
            z95.removeObserver(this.mAddFriendObserver);
        }
    }
}
