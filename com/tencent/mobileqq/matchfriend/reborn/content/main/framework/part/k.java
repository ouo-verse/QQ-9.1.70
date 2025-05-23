package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.matchfriend.reborn.kuikly.QQStrangerKuiklyEvent;
import com.tencent.mobileqq.matchfriend.reborn.login.QQStrangerLoginEndEvent;
import com.tencent.mobileqq.matchfriend.reborn.register.event.QQStrangerRegisterSuccessEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \"2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\u001c\u0010\u0015\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00190\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/k;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "E9", "C9", "D9", "", AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "data", "B9", "", "isNotifyNextElement", "z9", "x9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "onPartDestroy", "Ll82/h;", "d", "Ll82/h;", "publicAccountFollowGuideElement", "<init>", "()V", "e", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class k extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private l82.h publicAccountFollowGuideElement;

    private final void B9(String eventName, JSONObject data) {
        if (Intrinsics.areEqual(eventName, "NEARBY_CLOSE_PUBLIC_ACCOUNT_GUIDE_EVENT")) {
            QLog.d("QQStrangerPublicAccountPart", 1, "handleKuiklyEvent " + eventName + " " + data);
            Integer a16 = data != null ? com.tencent.mobileqq.matchfriend.reborn.config.a.a(data, "app_id") : null;
            if (a16 != null && a16.intValue() == 1) {
                A9(this, false, 1, null);
            }
        }
    }

    private final void E9() {
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        l82.h hVar = new l82.h(activity);
        m82.a.f416439a.b().addElement(hVar);
        x9();
        this.publicAccountFollowGuideElement = hVar;
    }

    private final void x9() {
        l82.h hVar = this.publicAccountFollowGuideElement;
        if (hVar != null) {
            m82.a.f416439a.b().notifyGroupActivate(hVar, RFWOrderElementManager.OrderMode.WAIT_MODE, 1200L);
        }
    }

    private final void z9(boolean isNotifyNextElement) {
        l82.h hVar = this.publicAccountFollowGuideElement;
        if (hVar != null) {
            m82.a.f416439a.b().inactivateElement(hVar, isNotifyNextElement);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        z9(false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QQStrangerLoginEndEvent) {
            C9();
            return;
        }
        if (event instanceof QQStrangerRegisterSuccessEvent) {
            D9();
        } else if (event instanceof QQStrangerKuiklyEvent) {
            QQStrangerKuiklyEvent qQStrangerKuiklyEvent = (QQStrangerKuiklyEvent) event;
            B9(qQStrangerKuiklyEvent.getEventName(), qQStrangerKuiklyEvent.getData());
        }
    }

    private final void C9() {
        QLog.d("QQStrangerPublicAccountPart", 1, "handleLoginEndEvent");
        E9();
    }

    private final void D9() {
        QLog.d("QQStrangerPublicAccountPart", 1, "handleRegisterSuccessEvent");
        x9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerLoginEndEvent.class, QQStrangerRegisterSuccessEvent.class, QQStrangerKuiklyEvent.class);
        return arrayListOf;
    }

    static /* synthetic */ void A9(k kVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        kVar.z9(z16);
    }
}
