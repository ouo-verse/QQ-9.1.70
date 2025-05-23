package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.qzone.reborn.albumx.common.bean.CommonPublishMoodBean;
import com.qzone.reborn.intimate.event.QZoneIntimateCheckInProcessEvent;
import com.qzone.reborn.intimate.event.QZoneIntimateRefreshHeaderEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.HalfScreenWebViewCloseEvent;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.Switch;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import ij.QZIntimateCheckInInfoBean;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import pj.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 C2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0019\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0014J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\"\u0010$\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020\u0006H\u0014J\u001a\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\n\u0010+\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010,\u001a\u00020\u001dH\u0014J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u001dH\u0014J\b\u0010/\u001a\u00020\u0004H\u0014J\u0012\u00100\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030201H\u0016R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/qzone/reborn/intimate/part/o;", "Lcom/qzone/reborn/intimate/part/QZIntimatePunchDialogBasePart;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Eb", "", "filePath", "Lcom/qzone/reborn/albumx/common/bean/f;", "Ab", "Lcom/qzone/reborn/intimate/event/QZoneIntimateCheckInProcessEvent;", "event", "Db", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/model/HalfScreenWebViewCloseEvent;", "Cb", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/os/Bundle;", "outState", "onPartSaveInstanceState", Constants.FILE_INSTANCE_STATE, "onPartCreate", "va", "R9", "Q9", "", "Fa", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lpj/h$b;", "na", "ea", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Ha", "la", "Ga", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "pa", "cb", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/widget/Switch;", "d0", "Lcom/tencent/widget/Switch;", "shareSwitch", "e0", "Z", "isSharePreviewShowing", "f0", "needShowPreviewFromRestore", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "g0", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "shareSwitchListener", "<init>", "()V", "h0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class o extends QZIntimatePunchDialogBasePart implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private Switch shareSwitch;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean isSharePreviewShowing;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean needShowPreviewFromRestore;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final CompoundButton.OnCheckedChangeListener shareSwitchListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.qzone.reborn.intimate.part.m
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            o.Fb(o.this, compoundButton, z16);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/intimate/part/o$b", "Lpj/h$b;", "", "b", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements h.b {
        b() {
        }

        @Override // pj.h.b
        public void a() {
            String str;
            o.this.isSharePreviewShowing = false;
            com.qzone.reborn.a aVar = com.qzone.reborn.a.f52169a;
            if (aVar.d("exp_intimate_space_clock_in_share", "_C")) {
                String spaceId = o.this.V9().getSpaceId();
                QZIntimateCheckInInfoBean checkInBean = o.this.getCheckInBean();
                Integer valueOf = checkInBean != null ? Integer.valueOf(checkInBean.getSpaceType()) : null;
                QZIntimateCheckInInfoBean checkInBean2 = o.this.getCheckInBean();
                Long valueOf2 = checkInBean2 != null ? Long.valueOf(checkInBean2.getFriendUin()) : null;
                if (com.qzone.reborn.a.c(aVar, "exp__space_clock_in_remind2", null, 2, null)) {
                    str = "&show_setting=1";
                } else {
                    str = "";
                }
                ho.i.q(o.this.getContext(), com.tencent.mobileqq.webview.util.f.f314875a.c(0.85f, "https://h5.qzone.qq.com/intimate-space/h5/checkin?_wv=1&_wwv=8193&_bid=5588&_cwv=256&float=1&space_id=" + spaceId + "&space_type=" + valueOf + "&target=" + valueOf2 + str, 0));
                return;
            }
            o.this.broadcastMessage("INTIMATE_CALENDAR_CARD_SHARE_PREVIEW_DISMISS", null);
        }

        @Override // pj.h.b
        public void b() {
            o.this.isSharePreviewShowing = true;
            o.this.broadcastMessage("INTIMATE_CALENDAR_CARD_SHARE_PREVIEW_SHOW", null);
            Dialog punchDialog = o.this.getPunchDialog();
            if (punchDialog != null) {
                punchDialog.dismiss();
            }
        }
    }

    private final CommonPublishMoodBean Ab(String filePath) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(586, 3, 7);
        lpReportInfo_pf00064.reserves3 = UUID.randomUUID().toString();
        lpReportInfo_pf00064.reserves4 = "0";
        lpReportInfo_pf00064.reserves7 = "0";
        lpReportInfo_pf00064.reserves8 = "0";
        lpReportInfo_pf00064.reserves10 = "qimizone_riqian_passive";
        return new CommonPublishMoodBean(filePath, lpReportInfo_pf00064);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bb(o this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.cb();
    }

    private final void Cb(HalfScreenWebViewCloseEvent event) {
        if (event.getBusinessId() != 0) {
            return;
        }
        broadcastMessage("INTIMATE_CALENDAR_CARD_SHARE_PREVIEW_DISMISS", null);
    }

    private final void Db(QZoneIntimateCheckInProcessEvent event) {
        if (getIsCalendarCardDataInvalid()) {
            QLog.e("QZIntimateCalendarCardPart", 1, "calendar data invalid, not show ");
        } else {
            cb();
        }
    }

    private final void Eb() {
        Ua((nk.at) getViewModel(nk.at.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fb(o this$0, CompoundButton compoundButton, boolean z16) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        nk.p ha5 = this$0.ha();
        nk.at mainTabViewModel = this$0.getMainTabViewModel();
        if (mainTabViewModel == null || (str = mainTabViewModel.getMSpaceId()) == null) {
            str = "";
        }
        if (z16) {
            str2 = "true";
        } else {
            str2 = "false";
        }
        ha5.T1("sync_qzone_switch", str, str2);
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public boolean Fa() {
        return false;
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    protected boolean Ga() {
        return V9().getAutoShareQZoneSwitchOpen();
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    protected void Ha(Bitmap bitmap, String filePath) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        if (!V9().getAutoShareQZoneSwitchOpen()) {
            QLog.i("QZIntimateCalendarCardPart", 1, "not allow to auto share qzone");
            return;
        }
        if (TextUtils.isEmpty(filePath)) {
            QLog.e("QZIntimateCalendarCardPart", 1, "file path is empty");
            return;
        }
        Intrinsics.checkNotNull(filePath);
        broadcastMessage("SILENT_PUBLISH_PIC_MOOD", Ab(filePath));
        if (com.qzone.reborn.a.c(com.qzone.reborn.a.f52169a, "exp_qz_qmkj_checkin", null, 2, null) && ha().Z1("sync_friend_switch")) {
            return;
        }
        QQToastUtil.showQQToastInUiThread(5, "\u6253\u5361\u6210\u529f\uff0c\u5df2\u540c\u6b65\u5230QQ\u7a7a\u95f4");
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public void Q9() {
        if (this.needShowPreviewFromRestore) {
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.intimate.part.n
                @Override // java.lang.Runnable
                public final void run() {
                    o.Bb(o.this);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public void cb() {
        if (getIsDialogShown()) {
            QLog.i("QZIntimateCalendarCardPart", 1, "dialog has been shown");
            return;
        }
        QLog.i("QZIntimateCalendarCardPart", 1, "show dialog");
        Sa(true);
        if (getActivity().isDestroyed() || getActivity().isFinishing()) {
            return;
        }
        N9(da());
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    protected String ea() {
        String calendarUrl;
        QZIntimateCheckInInfoBean checkInBean = getCheckInBean();
        return (checkInBean == null || (calendarUrl = checkInBean.getCalendarUrl()) == null) ? "" : calendarUrl;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneIntimateRefreshHeaderEvent.class);
        arrayList.add(QZoneIntimateCheckInProcessEvent.class);
        arrayList.add(HalfScreenWebViewCloseEvent.class);
        return arrayList;
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    protected View la() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ckr, (ViewGroup) null);
        Switch r16 = (Switch) inflate.findViewById(R.id.nfr);
        this.shareSwitch = r16;
        if (r16 != null) {
            r16.setChecked(V9().getAutoShareQZoneSwitchOpen());
        }
        Switch r17 = this.shareSwitch;
        if (r17 != null) {
            r17.setOnCheckedChangeListener(this.shareSwitchListener);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, ef.d.b(56));
        layoutParams.leftMargin = ef.d.b(16);
        layoutParams.rightMargin = ef.d.b(16);
        layoutParams.bottomMargin = ef.d.b(16);
        inflate.setLayoutParams(layoutParams);
        return inflate;
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public h.b na() {
        return new b();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 20231 && resultCode == -1) {
            QQToast.makeText(getContext(), 5, R.string.d7r, 0).show();
        }
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Eb();
        super.onInitView(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        this.needShowPreviewFromRestore = savedInstanceState != null ? savedInstanceState.getBoolean("need_recover_calendar_card_state", false) : false;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        pj.h sharePreviewHelper = getSharePreviewHelper();
        if (sharePreviewHelper != null) {
            sharePreviewHelper.r();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartSaveInstanceState(Activity activity, Bundle outState) {
        super.onPartSaveInstanceState(activity, outState);
        if (!this.isSharePreviewShowing || outState == null) {
            return;
        }
        outState.putBoolean("need_recover_calendar_card_state", true);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        nk.at mainTabViewModel;
        if (event instanceof QZoneIntimateRefreshHeaderEvent) {
            String spaceId = ((QZoneIntimateRefreshHeaderEvent) event).getSpaceId();
            nk.at mainTabViewModel2 = getMainTabViewModel();
            if (!Intrinsics.areEqual(spaceId, mainTabViewModel2 != null ? mainTabViewModel2.getMSpaceId() : null) || (mainTabViewModel = getMainTabViewModel()) == null) {
                return;
            }
            mainTabViewModel.N1();
            return;
        }
        if (event instanceof QZoneIntimateCheckInProcessEvent) {
            QZoneIntimateCheckInProcessEvent qZoneIntimateCheckInProcessEvent = (QZoneIntimateCheckInProcessEvent) event;
            if (qZoneIntimateCheckInProcessEvent.getIsEnd()) {
                Db(qZoneIntimateCheckInProcessEvent);
                return;
            }
            return;
        }
        if (event instanceof HalfScreenWebViewCloseEvent) {
            Cb((HalfScreenWebViewCloseEvent) event);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public void pa(boolean isOpen) {
        V9().r2(isOpen);
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    protected void va() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ef.d.b(296), ef.d.b(com.tencent.luggage.wxa.ig.w.CTRL_INDEX));
        layoutParams.gravity = 17;
        X9().setVisibility(4);
        X9().setClickable(false);
        View partRootView = getPartRootView();
        Intrinsics.checkNotNull(partRootView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) partRootView).addView(X9(), layoutParams);
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public void R9() {
    }
}
