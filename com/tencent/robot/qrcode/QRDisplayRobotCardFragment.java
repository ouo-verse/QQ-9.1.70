package com.tencent.robot.qrcode;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.robot.data.RobotInfo;
import com.tencent.robot.qrcode.part.QRDisplayRobotPart;
import com.tencent.robot.qrcode.part.QRDisplayRobotSharePart;
import com.tencent.robot.qrcode.part.d;
import com.tencent.robot.qrcode.part.r;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v44.c;
import w44.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\"\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u0016\u0010\u001d\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R&\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00120\"j\b\u0012\u0004\u0012\u00020\u0012`#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/robot/qrcode/QRDisplayRobotCardFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initData", "setStatusBarImmersive", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "onPostThemeChanged", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lw44/a;", "D", "Lw44/a;", "viewModel", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "mParts", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class QRDisplayRobotCardFragment extends QPublicBaseFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private a viewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Part> mParts = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/robot/qrcode/QRDisplayRobotCardFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/robot/data/RobotInfo;", "qrCodeInfo", "", "from", "", "a", "", "ROBOT_JUMP_FROM", "Ljava/lang/String;", "SHARE_RESULT_TO_QZONE", "I", "STATUS_BAR_HEIGHT", "TAG", "TROOP_ROBOT_INFO", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.qrcode.QRDisplayRobotCardFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull RobotInfo qrCodeInfo, int from) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(qrCodeInfo, "qrCodeInfo");
            Intent intent = new Intent();
            intent.putExtra("troop_robot_info", qrCodeInfo);
            intent.putExtra("robot_jump_from", from);
            QPublicFragmentActivity.start(context, intent, QRDisplayRobotCardFragment.class);
        }

        Companion() {
        }
    }

    private final void initData() {
        a aVar;
        RobotInfo robotInfo;
        Bundle arguments = getArguments();
        RobotInfo robotInfo2 = null;
        if (arguments != null) {
            a aVar2 = this.viewModel;
            if (aVar2 != null) {
                Serializable serializable = arguments.getSerializable("troop_robot_info");
                if (serializable instanceof RobotInfo) {
                    robotInfo = (RobotInfo) serializable;
                } else {
                    robotInfo = null;
                }
                aVar2.R1(robotInfo);
            }
            String it = arguments.getString("robot_jump_from");
            if (it != null && (aVar = this.viewModel) != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                aVar.Q1(it);
            }
        }
        a aVar3 = this.viewModel;
        if (aVar3 != null) {
            robotInfo2 = aVar3.getRobotInfo();
        }
        QLog.i("robot.qr.QRDisplayRobotCardFragment", 1, "robotInfo = " + robotInfo2);
    }

    private final void setStatusBarImmersive() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && ImmersiveUtils.isSupporImmersive() == 1) {
            View view = null;
            if (SystemBarActivityModule.getSystemBarComp(qBaseActivity) == null) {
                SystemBarActivityModule.setImmersiveStatus(qBaseActivity, 0);
            } else {
                SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDrawable(null);
                SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarColor(0);
                SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusColor(0);
                SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDarkMode(QQTheme.isNowThemeIsNight());
            }
            View view2 = this.rootView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view2 = null;
            }
            ((RelativeLayout) view2.findViewById(R.id.f7735445)).setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg);
            View view3 = this.rootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            } else {
                view = view3;
            }
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.f98745nx);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.setMargins(0, ViewUtils.dpToPx(44.0f), 0, 0);
                relativeLayout.setLayoutParams(layoutParams);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        this.mParts.clear();
        this.mParts.add(new r());
        this.mParts.add(new QRDisplayRobotPart());
        this.mParts.add(new d());
        this.mParts.add(new QRDisplayRobotSharePart());
        return this.mParts;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (getQBaseActivity() != null && requestCode == 1) {
            c.f440966a.g(2, R.string.f222216cx);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        MutableLiveData<Boolean> P1;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        a aVar = this.viewModel;
        if (aVar != null && (P1 = aVar.P1()) != null) {
            P1.postValue(Boolean.TRUE);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        a aVar = (a) getViewModel(a.class);
        this.viewModel = aVar;
        if (aVar != null) {
            aVar.init();
        }
        View inflate = inflater.inflate(R.layout.hoz, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026agment, container, false)");
        this.rootView = inflate;
        setStatusBarImmersive();
        initData();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            VideoReport.addToDetectionWhitelist(activity);
        }
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a aVar = this.viewModel;
        if (aVar != null) {
            aVar.S1();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        MutableLiveData<Boolean> O1;
        super.onPostThemeChanged();
        setStatusBarImmersive();
        a aVar = this.viewModel;
        if (aVar != null && (O1 = aVar.O1()) != null) {
            O1.postValue(Boolean.TRUE);
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDarkMode(QQTheme.isNowThemeIsNight());
        }
    }
}
