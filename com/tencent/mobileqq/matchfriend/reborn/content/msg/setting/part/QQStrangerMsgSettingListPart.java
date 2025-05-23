package com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingOptionResult;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel.QQStrangerMsgSettingViewModel;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel.a;
import com.tencent.mobileqq.matchfriend.request.MatchFriendRequest;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.v;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$GetOptionsRsp;
import com.tencent.util.QQToastUtil;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import tl.h;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bR\u0010SJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\bH\u0002J,\u0010$\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001a2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\"0!H\u0002J,\u0010%\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001a2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\"0!H\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u001eH\u0016J\u001c\u0010,\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010+\u001a\u0004\u0018\u00010*H\u0016J\u0012\u0010-\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010.\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010/\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016R#\u00106\u001a\n 1*\u0004\u0018\u000100008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R$\u0010<\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R$\u0010>\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000209\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010E\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010DR\u0016\u0010I\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010DR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u00103\u001a\u0004\bL\u0010MR\u001b\u0010Q\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u00103\u001a\u0004\bP\u0010M\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/part/QQStrangerMsgSettingListPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "E9", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a;", "state", "", "M9", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/b;", "result", "N9", "L9", "K9", "Lcom/tencent/trpcprotocol/kuolie/user_config/user_config/UserConfig$GetOptionsRsp;", "rsp", "U9", "R9", "T9", "O9", "", "success", "J9", "", "strResId", "", "getString", "V9", "S9", "Landroid/view/View;", "view", "eid", "", "", "params", "P9", "Q9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartDestroy", "onPartPause", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/QQStrangerMsgSettingViewModel;", "kotlin.jvm.PlatformType", "d", "Lkotlin/Lazy;", "I9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/QQStrangerMsgSettingViewModel;", "viewModel", "Lb82/a;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "e", "Lb82/a;", "newChatMsgNotifyConfig", "f", "hideModeConfig", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", h.F, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "settingAdapter", "i", "Z", "hadSetNewChatMsgNotifyChangedFlag", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "hadSetHideModeChangedFlag", BdhLogUtil.LogTag.Tag_Conn, "firstResumed", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "D", "H9", "()Landroid/widget/CompoundButton$OnCheckedChangeListener;", "newChatMsgNotifyCheckedChangedListener", "E", "G9", "hideModeCheckedChangeListener", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMsgSettingListPart extends Part {

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy newChatMsgNotifyCheckedChangedListener;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy hideModeCheckedChangeListener;

    /* renamed from: e, reason: from kotlin metadata */
    private b82.a<x.b.d, x.c.f> newChatMsgNotifyConfig;

    /* renamed from: f, reason: from kotlin metadata */
    private b82.a<x.b.d, x.c.f> hideModeConfig;

    /* renamed from: h */
    private QUIListItemAdapter settingAdapter;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean hadSetNewChatMsgNotifyChangedFlag;

    /* renamed from: m */
    private boolean hadSetHideModeChangedFlag;

    /* renamed from: d, reason: from kotlin metadata */
    private final Lazy viewModel = LazyKt.lazy(new Function0<QQStrangerMsgSettingViewModel>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.part.QQStrangerMsgSettingListPart$viewModel$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final QQStrangerMsgSettingViewModel invoke() {
            return (QQStrangerMsgSettingViewModel) QQStrangerMsgSettingListPart.this.getViewModel(QQStrangerMsgSettingViewModel.class);
        }
    });

    /* renamed from: C */
    private boolean firstResumed = true;

    public QQStrangerMsgSettingListPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerMsgSettingViewModel>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.part.QQStrangerMsgSettingListPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QQStrangerMsgSettingViewModel invoke() {
                return (QQStrangerMsgSettingViewModel) QQStrangerMsgSettingListPart.this.getViewModel(QQStrangerMsgSettingViewModel.class);
            }
        });
        this.viewModel = lazy;
        this.firstResumed = true;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new QQStrangerMsgSettingListPart$newChatMsgNotifyCheckedChangedListener$2(this));
        this.newChatMsgNotifyCheckedChangedListener = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new QQStrangerMsgSettingListPart$hideModeCheckedChangeListener$2(this));
        this.hideModeCheckedChangeListener = lazy3;
    }

    public static final void F9(QQStrangerMsgSettingListPart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I9().P1();
        VideoReport.setElementId(view, "em_kl_empty_msg");
        VideoReport.reportEvent("clck", view, null);
    }

    private final CompoundButton.OnCheckedChangeListener G9() {
        return (CompoundButton.OnCheckedChangeListener) this.hideModeCheckedChangeListener.getValue();
    }

    private final CompoundButton.OnCheckedChangeListener H9() {
        return (CompoundButton.OnCheckedChangeListener) this.newChatMsgNotifyCheckedChangedListener.getValue();
    }

    public final QQStrangerMsgSettingViewModel I9() {
        return (QQStrangerMsgSettingViewModel) this.viewModel.getValue();
    }

    private final void K9(QQStrangerMsgSettingOptionResult result) {
        if (result.getIsSuccess()) {
            return;
        }
        S9();
    }

    private final void L9(QQStrangerMsgSettingOptionResult result) {
        if (result.getIsSuccess()) {
            return;
        }
        S9();
    }

    public final void M9(com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel.a state) {
        if (state instanceof a.UpdateSettingDataOptionsUIState) {
            N9(((a.UpdateSettingDataOptionsUIState) state).getData());
            return;
        }
        if (state instanceof a.OnSetNewChatMsgNotifyOptionUIState) {
            L9(((a.OnSetNewChatMsgNotifyOptionUIState) state).getData());
        } else if (state instanceof a.OnSetHideModeOptionUIState) {
            K9(((a.OnSetHideModeOptionUIState) state).getData());
        } else if (state instanceof a.OnDeleteAllConversationsUIState) {
            J9(((a.OnDeleteAllConversationsUIState) state).getSuccess());
        }
    }

    private final void N9(QQStrangerMsgSettingOptionResult result) {
        if (!result.getIsFromCache() || result.getIsSuccess()) {
            if (result.getIsSuccess()) {
                UserConfig$GetOptionsRsp data = result.getData();
                if (data != null) {
                    if (!this.hadSetNewChatMsgNotifyChangedFlag) {
                        U9(data);
                    }
                    if (!this.hadSetHideModeChangedFlag) {
                        T9(data);
                    }
                }
            } else {
                S9();
            }
            if (result.getIsFromCache()) {
                return;
            }
            R9();
            O9();
        }
    }

    private final void O9() {
        QUISingleLineListItem itemView;
        Map<String, ? extends Object> mapOf;
        b82.a<x.b.d, x.c.f> aVar = this.hideModeConfig;
        if (aVar == null || (itemView = aVar.getItemView()) == null) {
            return;
        }
        b82.a<x.b.d, x.c.f> aVar2 = this.hideModeConfig;
        Intrinsics.checkNotNull(aVar2);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("after_switch_state", Integer.valueOf(aVar2.O().getIsChecked() ? 1 : 0)));
        Q9(itemView, "em_kl_stealth_mode", mapOf);
    }

    public final void P9(View view, String eid, Map<String, ? extends Object> params) {
        VideoReport.setElementId(view, eid);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, params);
    }

    private final void Q9(View view, String eid, Map<String, ? extends Object> params) {
        VideoReport.setElementId(view, eid);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("imp", view, params);
    }

    private final void R9() {
        QUISingleLineListItem itemView;
        Map<String, ? extends Object> mapOf;
        b82.a<x.b.d, x.c.f> aVar = this.newChatMsgNotifyConfig;
        if (aVar == null || (itemView = aVar.getItemView()) == null) {
            return;
        }
        b82.a<x.b.d, x.c.f> aVar2 = this.newChatMsgNotifyConfig;
        Intrinsics.checkNotNull(aVar2);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("after_switch_state", Integer.valueOf(aVar2.O().getIsChecked() ? 1 : 0)));
        Q9(itemView, "em_kl_new_msg_inform", mapOf);
    }

    private final void S9() {
        if (NetworkUtil.isNetworkAvailable()) {
            return;
        }
        QQToastUtil.showQQToast(0, R.string.f169698x35);
    }

    private final void T9(UserConfig$GetOptionsRsp rsp) {
        boolean z16;
        b82.a<x.b.d, x.c.f> aVar = this.hideModeConfig;
        if (aVar == null || (z16 = rsp.options.privacy_option.is_not_disturb.get()) == aVar.O().getIsChecked()) {
            return;
        }
        QUIListItemAdapter qUIListItemAdapter = null;
        aVar.O().h(null);
        QUIListItemAdapter qUIListItemAdapter2 = this.settingAdapter;
        if (qUIListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingAdapter");
            qUIListItemAdapter2 = null;
        }
        qUIListItemAdapter2.l0(aVar);
        aVar.O().f(z16);
        aVar.O().h(G9());
        QUIListItemAdapter qUIListItemAdapter3 = this.settingAdapter;
        if (qUIListItemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingAdapter");
        } else {
            qUIListItemAdapter = qUIListItemAdapter3;
        }
        qUIListItemAdapter.l0(aVar);
    }

    private final void U9(UserConfig$GetOptionsRsp rsp) {
        boolean z16;
        b82.a<x.b.d, x.c.f> aVar = this.newChatMsgNotifyConfig;
        if (aVar == null || (z16 = rsp.options.message_option.receive_offline_message.get()) == aVar.O().getIsChecked()) {
            return;
        }
        QUIListItemAdapter qUIListItemAdapter = null;
        aVar.O().h(null);
        QUIListItemAdapter qUIListItemAdapter2 = this.settingAdapter;
        if (qUIListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingAdapter");
            qUIListItemAdapter2 = null;
        }
        qUIListItemAdapter2.l0(aVar);
        aVar.O().f(z16);
        aVar.O().h(H9());
        QUIListItemAdapter qUIListItemAdapter3 = this.settingAdapter;
        if (qUIListItemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingAdapter");
        } else {
            qUIListItemAdapter = qUIListItemAdapter3;
        }
        qUIListItemAdapter.l0(aVar);
    }

    private final void V9() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            MatchFriendRequest.W(peekAppRuntime);
        }
    }

    private final String getString(int strResId) {
        String string = getPartRootView().getContext().getString(strResId);
        Intrinsics.checkNotNullExpressionValue(string, "rootView.context.getString(strResId)");
        return string;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View r85) {
        Intrinsics.checkNotNullParameter(r85, "rootView");
        super.onInitView(r85);
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) r85.findViewById(R.id.op9);
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        this.settingAdapter = qUIListItemAdapter;
        Group[] E9 = E9();
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(E9, E9.length));
        qUISettingsRecyclerView.setAdapter(qUIListItemAdapter);
        I9().S1();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity r26, Bundle r36) {
        super.onPartCreate(r26, r36);
        QQStrangerMsgSettingViewModel I9 = I9();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        I9.O1(lifecycleOwner, new a(this));
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity r26) {
        super.onPartDestroy(r26);
        I9().R1(new a(this));
        I9().onDestroy();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity r26) {
        super.onPartPause(r26);
        V9();
        VideoReport.setPageId(getPartRootView(), "pg_kl_msg_list_set");
        VideoReport.setPageReportPolicy(getPartRootView(), PageReportPolicy.REPORT_NONE);
        VideoReport.reportPgOut(getPartRootView());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity r26) {
        super.onPartResume(r26);
        if (!this.firstResumed) {
            I9().T1();
        }
        this.firstResumed = false;
        VideoReport.setPageId(getPartRootView(), "pg_kl_msg_list_set");
        VideoReport.setPageReportPolicy(getPartRootView(), PageReportPolicy.REPORT_NONE);
        VideoReport.reportPgIn(getPartRootView());
    }

    private final Group[] E9() {
        Group[] groupArr = new Group[3];
        String string = getString(R.string.x39);
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[1];
        QUIListItemAdapter qUIListItemAdapter = null;
        b82.a<x.b.d, x.c.f> aVar = new b82.a<>(new x.b.d(getString(R.string.x38)), new x.c.f(false, null));
        this.newChatMsgNotifyConfig = aVar;
        aVar.O().h(H9());
        QUIListItemAdapter qUIListItemAdapter2 = this.settingAdapter;
        if (qUIListItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingAdapter");
            qUIListItemAdapter2 = null;
        }
        qUIListItemAdapter2.l0(aVar);
        Unit unit = Unit.INSTANCE;
        aVarArr[0] = aVar;
        groupArr[0] = new Group("", string, aVarArr);
        String string2 = getString(R.string.f169697x34);
        com.tencent.mobileqq.widget.listitem.a[] aVarArr2 = new com.tencent.mobileqq.widget.listitem.a[1];
        b82.a<x.b.d, x.c.f> aVar2 = new b82.a<>(new x.b.d(getString(R.string.f169696x33)), new x.c.f(false, null));
        this.hideModeConfig = aVar2;
        aVar2.O().h(G9());
        QUIListItemAdapter qUIListItemAdapter3 = this.settingAdapter;
        if (qUIListItemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("settingAdapter");
        } else {
            qUIListItemAdapter = qUIListItemAdapter3;
        }
        qUIListItemAdapter.l0(aVar2);
        aVarArr2[0] = aVar2;
        groupArr[1] = new Group("", string2, aVarArr2);
        Group.Companion companion = Group.INSTANCE;
        v vVar = new v(R.layout.cxo);
        vVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.part.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerMsgSettingListPart.F9(QQStrangerMsgSettingListPart.this, view);
            }
        });
        groupArr[2] = companion.b(vVar);
        return groupArr;
    }

    private final void J9(boolean success) {
        if (success) {
            QQToastUtil.showQQToast(2, R.string.f169695x31);
        }
    }
}
