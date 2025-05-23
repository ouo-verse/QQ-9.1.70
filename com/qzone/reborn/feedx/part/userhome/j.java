package com.qzone.reborn.feedx.part.userhome;

import android.app.Activity;
import android.os.Bundle;
import com.qzone.common.account.LoginData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profilecard.bussiness.qzone.QZoneUrgeUpdateFeedServlet;
import com.tencent.mobileqq.profilecard.bussiness.qzone.QZoneUrgeUpdateRspResultEvent;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import x6.QZoneUrgePublishInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0003H\u0002J\u001c\u0010\u0010\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0018\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u001c\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a0\u0019j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a`\u001bH\u0016R\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/qzone/reborn/feedx/part/userhome/j;", "Lcom/qzone/reborn/feedx/part/g;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/profilecard/bussiness/qzone/QZoneUrgeUpdateRspResultEvent;", "", "uin", "", "toast", "", "E9", "event", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartPause", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "action", "", "args", "handleBroadcastMessage", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "d", "Ljava/lang/String;", "mToast", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class j extends com.qzone.reborn.feedx.part.g implements SimpleEventReceiver<QZoneUrgeUpdateRspResultEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String mToast = "";

    private final void D9(QZoneUrgeUpdateRspResultEvent event) {
        if (event.isSuccess()) {
            com.qzone.reborn.util.o.f59556a.d(this.mToast, 2);
        } else if (event.getRetCode() != -10006 && event.getRetCode() != -10007) {
            com.qzone.reborn.util.o.f59556a.b(HardCodeUtil.qqStr(R.string.f22006684));
        } else {
            com.qzone.reborn.util.o.f59556a.d(HardCodeUtil.qqStr(R.string.f22007685), 0);
        }
    }

    private final void E9(long uin, String toast) {
        ArrayList arrayListOf;
        if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
            com.qzone.reborn.util.o.f59556a.b(HardCodeUtil.qqStr(R.string.f22006684));
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if (toast == null) {
            toast = "";
        }
        this.mToast = toast;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(uin));
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), QZoneUrgeUpdateFeedServlet.class);
        com.tencent.mobileqq.qzonestatus.d.b(newIntent, com.tencent.mobileqq.qzonestatus.d.a(7, LoginData.getInstance().getUin(), arrayListOf, 0L, ""));
        peekAppRuntime.startServlet(newIntent);
        QLog.d("QZoneUrgePublishPart", 1, "handleOnClickUrgeUpdate   | urgedUinList = " + arrayListOf);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZoneUrgeUpdateRspResultEvent>> getEventClass() {
        ArrayList<Class<QZoneUrgeUpdateRspResultEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneUrgeUpdateRspResultEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (Intrinsics.areEqual(action, "URGE_PUBLISH") && (args instanceof x6.a)) {
            x6.a aVar = (x6.a) args;
            long j3 = aVar.uin;
            QZoneUrgePublishInfo qZoneUrgePublishInfo = aVar.urgePublishInfo;
            E9(j3, qZoneUrgePublishInfo != null ? qZoneUrgePublishInfo.getButtonClickToast() : null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneUrgeUpdateRspResultEvent) {
            D9((QZoneUrgeUpdateRspResultEvent) event);
        }
    }
}
