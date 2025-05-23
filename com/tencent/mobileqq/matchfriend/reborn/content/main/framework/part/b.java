package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.matchfriend.reborn.login.QQStrangerLoginEndEvent;
import com.tencent.mobileqq.matchfriend.reborn.login.QQStrangerLoginPart;
import com.tencent.mobileqq.matchfriend.reborn.register.event.QQStrangerRegisterSuccessEvent;
import com.tencent.mobileqq.matchfriend.reborn.register.guest.QQStrangerGuestHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120\u0011H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/part/b;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/content/Intent;", "newIntent", "", "x9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onNewIntent", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "", "d", "Z", "needAutoRegister", "", "e", "Ljava/lang/String;", "forwardUri", "<init>", "()V", "f", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needAutoRegister;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String forwardUri = "";

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(Intent newIntent) {
        super.onNewIntent(newIntent);
        com.tencent.mobileqq.matchfriend.reborn.utils.g gVar = com.tencent.mobileqq.matchfriend.reborn.utils.g.f245479a;
        this.forwardUri = gVar.a(newIntent);
        if (QQStrangerLoginPart.INSTANCE.a().get()) {
            x9(newIntent);
        }
        boolean b16 = gVar.b(newIntent);
        this.needAutoRegister = b16;
        QLog.d("QQStrangerJumpDispatcherPart", 1, "onNewIntent: " + b16);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        com.tencent.mobileqq.matchfriend.reborn.utils.g gVar = com.tencent.mobileqq.matchfriend.reborn.utils.g.f245479a;
        this.forwardUri = gVar.a(activity != null ? activity.getIntent() : null);
        SimpleEventBus.getInstance().registerReceiver(this);
        if (QQStrangerLoginPart.INSTANCE.a().get()) {
            x9(activity != null ? activity.getIntent() : null);
        }
        boolean b16 = gVar.b(activity != null ? activity.getIntent() : null);
        this.needAutoRegister = b16;
        QLog.d("QQStrangerJumpDispatcherPart", 1, "onPartCreate: " + b16);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QQStrangerLoginEndEvent.class, QQStrangerRegisterSuccessEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        QLog.d("QQStrangerJumpDispatcherPart", 1, "onReceiveEvent: " + (event != null ? event.getClass().getSimpleName() : null));
        if (event instanceof QQStrangerLoginEndEvent) {
            x9(getActivity().getIntent());
        } else if ((event instanceof QQStrangerRegisterSuccessEvent) && this.needAutoRegister) {
            x9(getActivity().getIntent());
        }
    }

    private final void x9(Intent newIntent) {
        if (newIntent == null) {
            return;
        }
        String str = this.forwardUri;
        if (str.length() == 0) {
            str = com.tencent.mobileqq.matchfriend.reborn.utils.g.f245479a.a(newIntent);
        }
        this.forwardUri = str;
        if (str.length() == 0) {
            return;
        }
        QQStrangerGuestHelper qQStrangerGuestHelper = QQStrangerGuestHelper.f245363a;
        boolean c16 = qQStrangerGuestHelper.c();
        QLog.d("QQStrangerJumpDispatcherPart", 1, "try forward uri: hasRegister=" + c16 + ", forwardUri=" + this.forwardUri);
        if (!c16) {
            QLog.d("QQStrangerJumpDispatcherPart", 1, "stop forward because not registered, willAutoLaunchRegister=" + this.needAutoRegister);
            if (this.needAutoRegister) {
                qQStrangerGuestHelper.b(getContext());
                return;
            }
            return;
        }
        try {
            ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(getContext(), this.forwardUri);
            this.forwardUri = "";
        } catch (Exception e16) {
            QLog.e("QQStrangerJumpDispatcherPart", 1, "Dispatch forward meets exception " + e16 + ".");
        }
    }
}
