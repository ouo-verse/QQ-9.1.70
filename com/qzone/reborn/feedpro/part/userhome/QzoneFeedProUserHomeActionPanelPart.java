package com.qzone.reborn.feedpro.part.userhome;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.qzone.util.ToastUtil;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.GetMainPageHeadRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.SpecialInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.RemoveSpecialRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.interaction_writer.interaction_writer.SetSpecialRsp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b6\u00107J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0006\u0010\u0010\u001a\u00020\u0004J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006J\u001c\u0010\u001d\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lcom/qzone/reborn/feedpro/part/userhome/QzoneFeedProUserHomeActionPanelPart;", "Lcom/qzone/reborn/feedpro/part/b;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/GetMainPageHeadRsp;", "userInfoData", "", "K9", "", "M9", "R9", "", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "L9", "", "actionId", "contentId", "Lcom/tencent/widget/ActionMenuItem;", "J9", "O9", "success", "status", "Q9", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/widget/ActionSheet;", "d", "Lcom/tencent/widget/ActionSheet;", "moreActionSheet", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "e", "Lcom/qzone/reborn/feedpro/viewmodel/m;", "mUserHomeViewModel", "Lcom/tencent/widget/ActionSheet$WatchDismissActions;", "f", "Lcom/tencent/widget/ActionSheet$WatchDismissActions;", "getMActionSheetDismissListener", "()Lcom/tencent/widget/ActionSheet$WatchDismissActions;", "setMActionSheetDismissListener", "(Lcom/tencent/widget/ActionSheet$WatchDismissActions;)V", "mActionSheetDismissListener", "Lcom/tencent/widget/ActionSheet$OnButtonClickListener;", tl.h.F, "Lcom/tencent/widget/ActionSheet$OnButtonClickListener;", "getOnActionButtonClick", "()Lcom/tencent/widget/ActionSheet$OnButtonClickListener;", "setOnActionButtonClick", "(Lcom/tencent/widget/ActionSheet$OnButtonClickListener;)V", "onActionButtonClick", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProUserHomeActionPanelPart extends com.qzone.reborn.feedpro.part.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ActionSheet moreActionSheet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.m mUserHomeViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ActionSheet.WatchDismissActions mActionSheetDismissListener = new ActionSheet.WatchDismissActions() { // from class: com.qzone.reborn.feedpro.part.userhome.g
        @Override // com.tencent.widget.ActionSheet.WatchDismissActions
        public final void onDismissOperations() {
            QzoneFeedProUserHomeActionPanelPart.N9(QzoneFeedProUserHomeActionPanelPart.this);
        }
    };

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ActionSheet.OnButtonClickListener onActionButtonClick = new a();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/part/userhome/QzoneFeedProUserHomeActionPanelPart$a", "Lcom/tencent/widget/ActionSheet$OnButtonClickListener;", "Landroid/view/View;", "v", "", "which", "", NodeProps.ON_CLICK, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements ActionSheet.OnButtonClickListener {
        a() {
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View v3, int which) {
            Intrinsics.checkNotNullParameter(v3, "v");
            Activity activity = QzoneFeedProUserHomeActionPanelPart.this.getActivity();
            ActionSheet actionSheet = QzoneFeedProUserHomeActionPanelPart.this.moreActionSheet;
            com.qzone.reborn.feedpro.viewmodel.m mVar = null;
            if (actionSheet == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moreActionSheet");
                actionSheet = null;
            }
            ActionSheetHelper.dismissActionSheet(activity, actionSheet);
            ActionSheet actionSheet2 = QzoneFeedProUserHomeActionPanelPart.this.moreActionSheet;
            if (actionSheet2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moreActionSheet");
                actionSheet2 = null;
            }
            ActionMenuItem actionMenuItem = actionSheet2.getActionMenuItem(which);
            if (actionMenuItem == null) {
                return;
            }
            int i3 = actionMenuItem.action;
            if (i3 == 223) {
                ho.j z16 = ho.i.z();
                Activity activity2 = QzoneFeedProUserHomeActionPanelPart.this.getActivity();
                com.qzone.reborn.feedpro.viewmodel.m mVar2 = QzoneFeedProUserHomeActionPanelPart.this.mUserHomeViewModel;
                if (mVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
                } else {
                    mVar = mVar2;
                }
                z16.k(activity2, mVar.getHostUin());
                return;
            }
            if (i3 == 229) {
                ho.j z17 = ho.i.z();
                Activity activity3 = QzoneFeedProUserHomeActionPanelPart.this.getActivity();
                com.qzone.reborn.feedpro.viewmodel.m mVar3 = QzoneFeedProUserHomeActionPanelPart.this.mUserHomeViewModel;
                if (mVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
                } else {
                    mVar = mVar3;
                }
                z17.v(activity3, mVar.getHostUin());
                return;
            }
            if (i3 == 231) {
                QzoneFeedProUserHomeActionPanelPart.this.R9();
            } else if (i3 == 233) {
                vo.c.N(QzoneFeedProUserHomeActionPanelPart.this.getActivity(), false);
            } else {
                if (i3 != 234) {
                    return;
                }
                vo.c.G(QzoneFeedProUserHomeActionPanelPart.this.getActivity());
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/part/userhome/QzoneFeedProUserHomeActionPanelPart$b", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/RemoveSpecialRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements DataCallback<RemoveSpecialRsp> {
        b() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(RemoveSpecialRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i(QzoneFeedProUserHomeActionPanelPart.this.getTAG(), 2, "remove special care success");
            QzoneFeedProUserHomeActionPanelPart.this.Q9(true, false);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            QLog.e(QzoneFeedProUserHomeActionPanelPart.this.getTAG(), 1, "remove special care failed, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
            QzoneFeedProUserHomeActionPanelPart.this.Q9(false, false);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/part/userhome/QzoneFeedProUserHomeActionPanelPart$c", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/interaction_writer/interaction_writer/SetSpecialRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements DataCallback<SetSpecialRsp> {
        c() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(SetSpecialRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.i(QzoneFeedProUserHomeActionPanelPart.this.getTAG(), 2, "set special care success");
            QzoneFeedProUserHomeActionPanelPart.this.Q9(true, true);
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            QLog.e(QzoneFeedProUserHomeActionPanelPart.this.getTAG(), 1, "set special care failed, errorCode: " + errorCode + ", errorMsg: " + errorMsg);
            QzoneFeedProUserHomeActionPanelPart.this.Q9(false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K9(GetMainPageHeadRsp userInfoData) {
        SpecialInfo specialInfo;
        ArrayList arrayList = new ArrayList();
        arrayList.add(J9(229, R.string.f173020gj0));
        if (M9(userInfoData)) {
            boolean z16 = false;
            if (userInfoData != null && (specialInfo = userInfoData.specialInfo) != null && specialInfo.isSpecial) {
                z16 = true;
            }
            arrayList.add(J9(231, z16 ? R.string.goj : R.string.gok));
        }
        arrayList.add(J9(223, R.string.f21929661));
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(getActivity(), arrayList, this.onActionButtonClick);
        Intrinsics.checkNotNullExpressionValue(createActionSheet, "createActionSheet(activi\u2026ray, onActionButtonClick)");
        this.moreActionSheet = createActionSheet;
        ActionSheet actionSheet = null;
        if (createActionSheet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreActionSheet");
            createActionSheet = null;
        }
        createActionSheet.addCancelButton(R.string.cancel);
        ActionSheet actionSheet2 = this.moreActionSheet;
        if (actionSheet2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreActionSheet");
        } else {
            actionSheet = actionSheet2;
        }
        actionSheet.registerWatchDisMissActionListener(this.mActionSheetDismissListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(QzoneFeedProUserHomeActionPanelPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9() {
        SpecialInfo specialInfo;
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
        com.qzone.reborn.feedpro.viewmodel.m mVar2 = null;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        wd.h value = mVar.d2().getValue();
        if (value != null) {
            GetMainPageHeadRsp headRsp = value.getHeadRsp();
            if ((headRsp != null ? headRsp.specialInfo : null) == null) {
                return;
            }
            GetMainPageHeadRsp headRsp2 = value.getHeadRsp();
            boolean z16 = false;
            if (headRsp2 != null && (specialInfo = headRsp2.specialInfo) != null && specialInfo.isSpecial) {
                z16 = true;
            }
            if (z16) {
                com.qzone.reborn.feedpro.viewmodel.m mVar3 = this.mUserHomeViewModel;
                if (mVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
                } else {
                    mVar2 = mVar3;
                }
                mVar2.D2(new b());
                return;
            }
            com.qzone.reborn.feedpro.viewmodel.m mVar4 = this.mUserHomeViewModel;
            if (mVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            } else {
                mVar2 = mVar4;
            }
            mVar2.E2(new c());
        }
    }

    public final ActionMenuItem J9(int actionId, int contentId) {
        return new ActionMenuItem(actionId, ActionSheetHelper.getStringById(getActivity(), contentId), actionId, 0);
    }

    public final void L9() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(J9(229, R.string.f2196466z));
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qzone_master_more_feed_back", true)) {
            arrayList.add(J9(234, R.string.f2196366y));
        }
        ActionSheet createActionSheet = ActionSheetHelper.createActionSheet(getActivity(), arrayList, this.onActionButtonClick);
        Intrinsics.checkNotNullExpressionValue(createActionSheet, "createActionSheet(activi\u2026ray, onActionButtonClick)");
        this.moreActionSheet = createActionSheet;
        ActionSheet actionSheet = null;
        if (createActionSheet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreActionSheet");
            createActionSheet = null;
        }
        createActionSheet.addCancelButton(R.string.cancel);
        ActionSheet actionSheet2 = this.moreActionSheet;
        if (actionSheet2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreActionSheet");
        } else {
            actionSheet = actionSheet2;
        }
        actionSheet.registerWatchDisMissActionListener(this.mActionSheetDismissListener);
    }

    public final void Q9(boolean success, boolean status) {
        String config;
        if (!success) {
            ToastUtil.s(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSettingFail", "\u8bbe\u7f6e\u5931\u8d25"), 4);
            return;
        }
        if (status) {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastSettingYet", "\u8bbe\u7f6e\u6210\u529f");
        } else {
            config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastCancelSpecialCare", "\u5df2\u53d6\u6d88\u7279\u522b\u5173\u5fc3");
        }
        ToastUtil.s(config, 5);
        com.qzone.reborn.feedpro.viewmodel.m mVar = this.mUserHomeViewModel;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        mVar.H2(status);
        com.qzone.reborn.feedpro.viewmodel.m mVar2 = this.mUserHomeViewModel;
        if (mVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar2 = null;
        }
        wd.h value = mVar2.d2().getValue();
        K9(value != null ? value.getHeadRsp() : null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneFeedProUserHomeActionPanelPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        ActionSheet actionSheet;
        super.handleBroadcastMessage(action, args);
        if (!Intrinsics.areEqual("OPEN_FEED_PRO_USER_HOME_ACTION_PANEL", action) || (actionSheet = this.moreActionSheet) == null) {
            return;
        }
        ActionSheet actionSheet2 = null;
        if (actionSheet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreActionSheet");
            actionSheet = null;
        }
        actionSheet.show();
        ActionSheet actionSheet3 = this.moreActionSheet;
        if (actionSheet3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreActionSheet");
        } else {
            actionSheet2 = actionSheet3;
        }
        Window window = actionSheet2.getWindow();
        if (window != null) {
            QUIImmersiveHelper.u(window, true, true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        ViewModel viewModel = getViewModel(com.qzone.reborn.feedpro.viewmodel.m.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QzoneFeedPr\u2026omeViewModel::class.java)");
        com.qzone.reborn.feedpro.viewmodel.m mVar = (com.qzone.reborn.feedpro.viewmodel.m) viewModel;
        this.mUserHomeViewModel = mVar;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
            mVar = null;
        }
        MutableLiveData<wd.h> d26 = mVar.d2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<wd.h, Unit> function1 = new Function1<wd.h, Unit>() { // from class: com.qzone.reborn.feedpro.part.userhome.QzoneFeedProUserHomeActionPanelPart$onPartCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(wd.h hVar) {
                invoke2(hVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(wd.h hVar) {
                com.qzone.reborn.feedpro.viewmodel.m mVar2 = QzoneFeedProUserHomeActionPanelPart.this.mUserHomeViewModel;
                if (mVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserHomeViewModel");
                    mVar2 = null;
                }
                if (!mVar2.m2()) {
                    QzoneFeedProUserHomeActionPanelPart.this.K9(hVar.getHeadRsp());
                } else {
                    QzoneFeedProUserHomeActionPanelPart.this.L9();
                }
            }
        };
        d26.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.feedpro.part.userhome.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QzoneFeedProUserHomeActionPanelPart.P9(Function1.this, obj);
            }
        });
    }

    private final boolean M9(GetMainPageHeadRsp userInfoData) {
        SpecialInfo specialInfo;
        return (userInfoData == null || (specialInfo = userInfoData.specialInfo) == null || !specialInfo.isShow) ? false : true;
    }

    public final void O9() {
    }
}
