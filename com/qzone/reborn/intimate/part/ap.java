package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.intimate.event.QZoneIntimateCheckInProcessEvent;
import com.qzone.reborn.intimate.event.QZoneIntimateRefreshHeaderEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.QzoneIPCModule;
import ij.QZIntimateCheckInInfoBean;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import pj.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0014J\"\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u001c\u0010\u001f\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!H\u0016R\u0016\u0010&\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/intimate/part/ap;", "Lcom/qzone/reborn/intimate/part/QZIntimatePunchDialogBasePart;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Fb", "Lcom/qzone/reborn/intimate/event/QZoneIntimateCheckInProcessEvent;", "event", "Db", "Cb", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "R9", "", "Fa", "Lpj/h$b;", "na", "Q9", "sa", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "d0", "Z", "isPunchAnimStart", "e0", "isPunchAnimEnd", "<init>", "()V", "f0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ap extends QZIntimatePunchDialogBasePart implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isPunchAnimStart;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean isPunchAnimEnd;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ab(ap this$0, DialogInterface dialogInterface, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        String spaceId = this$0.V9().getSpaceId();
        QZIntimateCheckInInfoBean checkInBean = this$0.getCheckInBean();
        Integer valueOf = checkInBean != null ? Integer.valueOf(checkInBean.getSpaceType()) : null;
        QZIntimateCheckInInfoBean checkInBean2 = this$0.getCheckInBean();
        Long valueOf2 = checkInBean2 != null ? Long.valueOf(checkInBean2.getFriendUin()) : null;
        if (com.qzone.reborn.a.c(com.qzone.reborn.a.f52169a, "exp__space_clock_in_remind2", null, 2, null)) {
            str = "&show_setting=1";
        } else {
            str = "";
        }
        ho.i.q(this$0.getContext(), com.tencent.mobileqq.webview.util.f.f314875a.b(0.85f, "https://h5.qzone.qq.com/intimate-space/h5/checkin?_wv=1&_wwv=8193&_bid=5588&_cwv=256&float=1&space_id=" + spaceId + "&space_type=" + valueOf + "&target=" + valueOf2 + str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bb(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eb(ap this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isPunchAnimEnd) {
            return;
        }
        QLog.i("QZIntimatePunchDialogPart", 1, "have not received finish event, show dialog");
        this$0.cb();
    }

    private final void Fb() {
        Ua((nk.at) getViewModel(nk.at.class));
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public boolean Fa() {
        return com.qzone.reborn.configx.g.f53821a.b().p0();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneIntimateRefreshHeaderEvent.class);
        arrayList.add(QZoneIntimateCheckInProcessEvent.class);
        return arrayList;
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
        Fb();
        super.onInitView(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
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
                Cb(qZoneIntimateCheckInProcessEvent);
            } else {
                Db(qZoneIntimateCheckInProcessEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public void sa() {
        super.sa();
        if (com.qzone.reborn.util.i.b().d("history_calendar_card_hint", false)) {
            QLog.i("QZIntimatePunchDialogPart", 1, "has show dialog hint before");
            return;
        }
        QLog.i("QZIntimatePunchDialogPart", 1, "show dialog hint");
        com.qzone.reborn.util.i.b().l("history_calendar_card_hint", true);
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 230, (String) null, com.qzone.util.l.a(R.string.w9n), com.qzone.util.l.a(R.string.f134418r), com.qzone.util.l.a(R.string.v8r), new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.intimate.part.an
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ap.Ab(ap.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.qzone.reborn.intimate.part.ao
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ap.Bb(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026 _ -> dialog.dismiss() })");
        createCustomDialog.show();
    }

    private final void Cb(QZoneIntimateCheckInProcessEvent event) {
        this.isPunchAnimEnd = true;
        QLog.i("QZIntimatePunchDialogPart", 1, "punch anim end");
        if (!getIsCalendarDataReady()) {
            QLog.e("QZIntimatePunchDialogPart", 1, "data is not ready");
        } else {
            cb();
        }
    }

    private final void Db(QZoneIntimateCheckInProcessEvent event) {
        this.isPunchAnimStart = true;
        QLog.i("QZIntimatePunchDialogPart", 1, "punch anim start");
        RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.intimate.part.am
            @Override // java.lang.Runnable
            public final void run() {
                ap.Eb(ap.this);
            }
        }, 2000L);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/qzone/reborn/intimate/part/ap$b", "Lpj/h$b;", "", "b", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements h.b {
        b() {
        }

        @Override // pj.h.b
        public void b() {
            Dialog punchDialog = ap.this.getPunchDialog();
            if (punchDialog != null) {
                punchDialog.dismiss();
            }
        }

        @Override // pj.h.b
        public void a() {
        }
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public void Q9() {
    }

    @Override // com.qzone.reborn.intimate.part.QZIntimatePunchDialogBasePart
    public void R9() {
    }
}
