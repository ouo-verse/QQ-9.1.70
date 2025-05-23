package com.tencent.mobileqq.qqlive.room.anchorcenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/anchorcenter/QQLiveAnchorCenterFragment;", "Lcom/tencent/mobileqq/qqlive/base/QQLiveBaseFragment;", "", "initData", "initDtReport", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "onResume", "D", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/qqlive/room/anchorcenter/QQLiveAnchorCenterViewModel;", "E", "Lcom/tencent/mobileqq/qqlive/room/anchorcenter/QQLiveAnchorCenterViewModel;", "prepareViewModel", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "sdk", "<init>", "()V", "G", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveAnchorCenterFragment extends QQLiveBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private QQLiveAnchorCenterViewModel prepareViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private IQQLiveSDK sdk;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J,\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/anchorcenter/QQLiveAnchorCenterFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "traceId", "roomId", "", "a", "PAGE_ID", "Ljava/lang/String;", "PARAM_MESSAGE_RED_POINT", "PARAM_RED_POINT_TASKID", "PARAM_USER_ROOMID", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.anchorcenter.QQLiveAnchorCenterFragment$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@Nullable Context context, @Nullable Intent intent, @Nullable String traceId, @NotNull String roomId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, intent, traceId, roomId);
                return;
            }
            Intrinsics.checkNotNullParameter(roomId, "roomId");
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("moduleId", "qq_live");
            intent.putExtra(QQLiveReportConstants.INTENT_TRACE_ID, traceId);
            intent.putExtra("user_roomid", roomId);
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivityForTool.class, QQLiveAnchorCenterFragment.class);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24067);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveAnchorCenterFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void initData() {
        MutableLiveData<String> mutableLiveData;
        MutableLiveData<String> mutableLiveData2;
        MutableLiveData<String> mutableLiveData3;
        IQQLiveModuleLogin loginModule;
        LiveUserInfo userInfo;
        String str;
        String str2;
        IQQLiveModuleLogin loginModule2;
        LiveUserInfo userInfo2;
        Object obj = null;
        this.sdk = com.tencent.mobileqq.qqlive.base.sdk.a.c(null);
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel = (QQLiveAnchorCenterViewModel) new ViewModelProvider(this, QQLiveAnchorCenterViewModel.INSTANCE.a()).get(QQLiveAnchorCenterViewModel.class);
        this.prepareViewModel = qQLiveAnchorCenterViewModel;
        if (qQLiveAnchorCenterViewModel != null) {
            mutableLiveData = qQLiveAnchorCenterViewModel.P1();
        } else {
            mutableLiveData = null;
        }
        String str3 = "";
        if (mutableLiveData != null) {
            IQQLiveSDK iQQLiveSDK = this.C;
            if (iQQLiveSDK == null || (loginModule2 = iQQLiveSDK.getLoginModule()) == null || (userInfo2 = loginModule2.getUserInfo()) == null || (str2 = userInfo2.headUrl) == null) {
                str2 = "";
            }
            mutableLiveData.setValue(str2);
        }
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel2 = this.prepareViewModel;
        if (qQLiveAnchorCenterViewModel2 != null) {
            mutableLiveData2 = qQLiveAnchorCenterViewModel2.Q1();
        } else {
            mutableLiveData2 = null;
        }
        if (mutableLiveData2 != null) {
            IQQLiveSDK iQQLiveSDK2 = this.C;
            if (iQQLiveSDK2 != null && (loginModule = iQQLiveSDK2.getLoginModule()) != null && (userInfo = loginModule.getUserInfo()) != null && (str = userInfo.nick) != null) {
                str3 = str;
            }
            mutableLiveData2.setValue(str3);
        }
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel3 = this.prepareViewModel;
        if (qQLiveAnchorCenterViewModel3 != null) {
            mutableLiveData3 = qQLiveAnchorCenterViewModel3.T1();
        } else {
            mutableLiveData3 = null;
        }
        if (mutableLiveData3 != null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                obj = arguments.get("user_roomid");
            }
            mutableLiveData3.setValue(String.valueOf(obj));
        }
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel4 = this.prepareViewModel;
        if (qQLiveAnchorCenterViewModel4 != null) {
            qQLiveAnchorCenterViewModel4.R1(102);
        }
    }

    private final void initDtReport() {
        Object obj;
        String str;
        IQQLiveModuleLogin loginModule;
        LoginInfo loginInfo;
        HashMap hashMap = new HashMap();
        Bundle arguments = getArguments();
        if (arguments != null) {
            obj = arguments.get("user_roomid");
        } else {
            obj = null;
        }
        hashMap.put("qqlive_room_id", String.valueOf(obj));
        IQQLiveSDK iQQLiveSDK = this.C;
        if (iQQLiveSDK == null || (loginModule = iQQLiveSDK.getLoginModule()) == null || (loginInfo = loginModule.getLoginInfo()) == null || (str = Long.valueOf(loginInfo.uid).toString()) == null) {
            str = "";
        }
        hashMap.put("qqlive_user_id", str);
        hashMap.put("qqlive_anchor_id", str);
        nf4.d liveReportUtil = ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil();
        View view = this.rootView;
        Intrinsics.checkNotNull(view);
        liveReportUtil.i(this, view, "pg_qqlive_anchorcenter", hashMap);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e());
        arrayList.add(new i());
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            setStatusBarImmersive();
            View inflate = inflater.inflate(R.layout.h98, container, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            this.rootView = (ViewGroup) inflate;
            initData();
            initDtReport();
            view = this.rootView;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        QQLiveAnchorCenterViewModel qQLiveAnchorCenterViewModel = this.prepareViewModel;
        if (qQLiveAnchorCenterViewModel != null) {
            qQLiveAnchorCenterViewModel.R1(102);
        }
    }
}
