package com.tencent.mobileqq.activity.notifyservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.chats.api.INotifyServiceSettingApi;
import com.tencent.qqnt.kernel.nativeinterface.GetServiceAssistantSwitchRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetServiceAssistantSwitchCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001KB\u0007\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u001d\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J&\u0010$\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0014J\b\u0010%\u001a\u00020\fH\u0014J\u001a\u0010'\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010&\u001a\u00020\tH\u0016R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0018\u0010;\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00105R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR$\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/activity/notifyservice/NotifyServiceItemListSettingFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "", "Jh", "Dh", "Lcom/tencent/qqnt/kernel/nativeinterface/GetServiceAssistantSwitchRsp;", "rsp", "Ch", "", "isSwitch", "Mh", "", "result", "", "errMsg", "Bh", "Gh", "switchVal", "Kh", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", OcrConfig.CHINESE, "yh", "wh", "Nh", "Landroid/widget/CompoundButton;", "buttonView", "Lh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "getContentLayoutId", "isChecked", "onCheckedChanged", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "mSettingRecyclerView", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "D", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "mSettingAdapter", "", "E", "Ljava/lang/Long;", "mUin", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "mUid", "G", "mUinName", "H", "Ljava/lang/Integer;", "mUinType", "I", "mAddFriendSourceId", "Landroid/view/View;", "J", "Landroid/view/View;", "mSettingSwitchView", "K", "Z", "isFirstImpl", "L", "Lcom/tencent/mobileqq/widget/listitem/x;", "mSwitchConfig", "<init>", "()V", "M", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class NotifyServiceItemListSettingFragment extends QIphoneTitleBarFragment implements CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QUISettingsRecyclerView mSettingRecyclerView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QUIListItemAdapter mSettingAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Long mUin;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String mUid;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String mUinName;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Integer mUinType;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private String mAddFriendSourceId;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private View mSettingSwitchView;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isFirstImpl;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private x<x.b.d, x.c.f> mSwitchConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/activity/notifyservice/NotifyServiceItemListSettingFragment$a;", "", "", "KEY_NOTIFY_SERVICE_SWITCH", "Ljava/lang/String;", "", "MSG_TYPE", "I", "SWITCH_OFF", "SWITCH_OFF_DIRECTION", "SWITCH_ON", "SWITCH_ON_DIRECTION", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.notifyservice.NotifyServiceItemListSettingFragment$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51732);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NotifyServiceItemListSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isFirstImpl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(NotifyServiceItemListSettingFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        view.setContentDescription(this$0.getResources().getString(R.string.f171632o_));
    }

    private final void Bh(int result, String errMsg) {
        QLog.e("NotifyServiceItemListSettingFragment", 1, "[handlerRspFail] result:" + result + " | errMsg:" + errMsg);
    }

    private final void Ch(GetServiceAssistantSwitchRsp rsp) {
        boolean z16;
        int i3 = rsp.msgTypeSwitch;
        if (i3 == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        Mh(z16);
        Kh(i3);
    }

    private final void Dh() {
        QLog.d("NotifyServiceItemListSettingFragment", 1, "[initSettingSwitchData] request get switch start.");
        ((INotifyServiceSettingApi) QRoute.api(INotifyServiceSettingApi.class)).requestGetSwitch(3, null, null, new IGetServiceAssistantSwitchCallback() { // from class: com.tencent.mobileqq.activity.notifyservice.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetServiceAssistantSwitchCallback
            public final void onResult(int i3, String str, GetServiceAssistantSwitchRsp getServiceAssistantSwitchRsp) {
                NotifyServiceItemListSettingFragment.Eh(NotifyServiceItemListSettingFragment.this, i3, str, getServiceAssistantSwitchRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(final NotifyServiceItemListSettingFragment this$0, final int i3, final String str, final GetServiceAssistantSwitchRsp getServiceAssistantSwitchRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.notifyservice.i
            @Override // java.lang.Runnable
            public final void run() {
                NotifyServiceItemListSettingFragment.Fh(i3, str, this$0, getServiceAssistantSwitchRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(int i3, String errMsg, NotifyServiceItemListSettingFragment this$0, GetServiceAssistantSwitchRsp rsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("NotifyServiceItemListSettingFragment", 1, "[initSettingSwitchData] request get switch end, result:" + i3 + " | errMsg:" + errMsg);
        if (i3 == 0) {
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            this$0.Ch(rsp);
        } else {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            this$0.Bh(i3, errMsg);
        }
    }

    private final void Gh() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        boolean z16 = true;
        if (from.decodeInt("key_notify_service_switch", 1) != 3) {
            z16 = false;
        }
        Mh(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(final NotifyServiceItemListSettingFragment this$0, final int i3, final CompoundButton compoundButton, final int i16, final String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("NotifyServiceItemListSettingFragment", 1, "[onCheckedChanged] result=" + i16 + " | errMsg=" + str + ".");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.notifyservice.g
            @Override // java.lang.Runnable
            public final void run() {
                NotifyServiceItemListSettingFragment.Ih(i16, this$0, i3, compoundButton, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(int i3, NotifyServiceItemListSettingFragment this$0, int i16, CompoundButton compoundButton, String errMsg) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            if (i16 == 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            this$0.Mh(z16);
            this$0.Lh(compoundButton);
            this$0.Kh(i16);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.Nh(errMsg);
    }

    private final void Jh() {
        Long l3;
        String str;
        String str2;
        Integer num;
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        Intent intent5;
        FragmentActivity activity = getActivity();
        String str3 = null;
        if (activity != null && (intent5 = activity.getIntent()) != null) {
            l3 = Long.valueOf(intent5.getLongExtra("uin", 0L));
        } else {
            l3 = null;
        }
        this.mUin = l3;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent4 = activity2.getIntent()) != null) {
            str = intent4.getStringExtra(AppConstants.Key.UID);
        } else {
            str = null;
        }
        this.mUid = str;
        FragmentActivity activity3 = getActivity();
        if (activity3 != null && (intent3 = activity3.getIntent()) != null) {
            str2 = intent3.getStringExtra("uinname");
        } else {
            str2 = null;
        }
        this.mUinName = str2;
        FragmentActivity activity4 = getActivity();
        if (activity4 != null && (intent2 = activity4.getIntent()) != null) {
            num = Integer.valueOf(intent2.getIntExtra("uintype", 0));
        } else {
            num = null;
        }
        this.mUinType = num;
        FragmentActivity activity5 = getActivity();
        if (activity5 != null && (intent = activity5.getIntent()) != null) {
            str3 = intent.getStringExtra(AppConstants.Key.ADD_FRIEND_SOURCE_ID);
        }
        this.mAddFriendSourceId = str3;
    }

    private final void Kh(int switchVal) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        from.encodeInt("key_notify_service_switch", switchVal);
    }

    private final void Lh(CompoundButton buttonView) {
        if (buttonView == null) {
            return;
        }
        int i3 = !buttonView.isChecked() ? 1 : 0;
        HashMap hashMap = new HashMap();
        hashMap.put("switching_direction", Integer.valueOf(i3));
        hashMap.putAll(c.a("pg_bas_service_notification_settings"));
        VideoReport.reportEvent("dt_clck", buttonView, hashMap);
    }

    private final void Mh(boolean isSwitch) {
        x.c.f fVar;
        QUIListItemAdapter qUIListItemAdapter;
        if (this.isFirstImpl && this.mSettingSwitchView != null) {
            this.isFirstImpl = false;
            int i3 = !isSwitch ? 1 : 0;
            HashMap hashMap = new HashMap();
            hashMap.put("switching_direction", Integer.valueOf(i3));
            VideoReport.setElementParams(this.mSettingSwitchView, hashMap);
            VideoReport.setElementExposePolicy(this.mSettingSwitchView, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(this.mSettingSwitchView, ClickPolicy.REPORT_NONE);
            VideoReport.setElementId(this.mSettingSwitchView, "em_bas_message_notification_main_switch");
        }
        x<x.b.d, x.c.f> xVar = this.mSwitchConfig;
        if (xVar != null) {
            fVar = xVar.O();
        } else {
            fVar = null;
        }
        if (fVar != null) {
            fVar.f(isSwitch);
        }
        x<x.b.d, x.c.f> xVar2 = this.mSwitchConfig;
        if (xVar2 != null && (qUIListItemAdapter = this.mSettingAdapter) != null) {
            qUIListItemAdapter.l0(xVar2);
        }
    }

    private final void Nh(final String errMsg) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.notifyservice.h
            @Override // java.lang.Runnable
            public final void run() {
                NotifyServiceItemListSettingFragment.Oh(errMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "$errMsg");
        QQToast.makeText(BaseApplication.getContext(), 1, errMsg, 0).show();
    }

    private final x.c.f wh() {
        x.c.f fVar = new x.c.f(false, this);
        fVar.b(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.activity.notifyservice.j
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                NotifyServiceItemListSettingFragment.xh(NotifyServiceItemListSettingFragment.this, view);
            }
        });
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xh(NotifyServiceItemListSettingFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.mSettingSwitchView = it;
    }

    private final x.b.d yh() {
        String string = getResources().getString(R.string.f171632o_);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026tify_service_msg_disturb)");
        return new x.b.d(string);
    }

    private final x<x.b.d, x.c.f> zh() {
        x<x.b.d, x.c.f> xVar = new x<>(yh(), wh());
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.activity.notifyservice.f
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                NotifyServiceItemListSettingFragment.Ah(NotifyServiceItemListSettingFragment.this, view);
            }
        });
        return xVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        QUISettingsRecyclerView qUISettingsRecyclerView;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
            return;
        }
        this.mSettingAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        String str2 = null;
        if (view != null) {
            qUISettingsRecyclerView = (QUISettingsRecyclerView) view.findViewById(R.id.zuz);
        } else {
            qUISettingsRecyclerView = null;
        }
        this.mSettingRecyclerView = qUISettingsRecyclerView;
        if (qUISettingsRecyclerView != null) {
            qUISettingsRecyclerView.setAdapter(this.mSettingAdapter);
        }
        this.mSwitchConfig = zh();
        QUIListItemAdapter qUIListItemAdapter = this.mSettingAdapter;
        if (qUIListItemAdapter != null) {
            String string = getResources().getString(R.string.f171572o4);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026otify_server_some_prompt)");
            x<x.b.d, x.c.f> xVar = this.mSwitchConfig;
            Intrinsics.checkNotNull(xVar);
            qUIListItemAdapter.t0(new Group("", string, xVar));
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            str = activity.getString(R.string.f171622o9);
        } else {
            str = null;
        }
        setTitle(str);
        TextView textView = this.leftView;
        if (textView != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                str2 = activity2.getString(R.string.f170549u3);
            }
            textView.setContentDescription(str2);
        }
        this.rightViewImg.setVisibility(8);
        Jh();
        Gh();
        Dh();
        VideoReport.setPageParams(((QIphoneTitleBarFragment) this).mContentView, c.b());
        VideoReport.setPageReportPolicy(((QIphoneTitleBarFragment) this).mContentView, PageReportPolicy.REPORT_ALL);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(((QIphoneTitleBarFragment) this).mContentView, "pg_bas_service_notification_settings");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.fpd;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(@Nullable final CompoundButton buttonView, boolean isChecked) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, isChecked);
        IPatchRedirector iPatchRedirector = $redirector_;
        final int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, buttonView, Boolean.valueOf(isChecked));
        } else {
            QLog.d("NotifyServiceItemListSettingFragment", 1, "[onCheckedChanged] isChecked: " + isChecked);
            if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                String string = getResources().getString(R.string.b3j);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.\u2026.string.failedconnection)");
                Nh(string);
                if (buttonView != null) {
                    buttonView.setOnCheckedChangeListener(null);
                }
                if (buttonView != null) {
                    buttonView.setChecked(!buttonView.isChecked());
                }
                if (buttonView != null) {
                    buttonView.setOnCheckedChangeListener(this);
                }
            } else {
                if (isChecked) {
                    i3 = 3;
                }
                ((INotifyServiceSettingApi) QRoute.api(INotifyServiceSettingApi.class)).requestSetSwitch(i3, 3, null, null, new HashMap<>(), new IOperateCallback() { // from class: com.tencent.mobileqq.activity.notifyservice.d
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i16, String str) {
                        NotifyServiceItemListSettingFragment.Hh(NotifyServiceItemListSettingFragment.this, i3, buttonView, i16, str);
                    }
                });
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, isChecked);
    }
}
