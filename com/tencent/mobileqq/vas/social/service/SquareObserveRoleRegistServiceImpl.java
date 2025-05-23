package com.tencent.mobileqq.vas.social.service;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.role.logic.CreateRoleEvent;
import com.tencent.state.square.api.ISquareObserveRoleRegistService;
import com.tencent.state.utils.EventBusUtilsKt;
import com.tencent.state.utils.IEventHandler;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\tj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n`\u000bH\u0016R@\u0010\u0012\u001a.\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\n\u0012\u0004\u0012\u00020\u000e0\rj\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\n\u0012\u0004\u0012\u00020\u000e`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/social/service/SquareObserveRoleRegistServiceImpl;", "Lcom/tencent/state/square/api/ISquareObserveRoleRegistService;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "destroy", "start", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Ljava/util/HashMap;", "Lcom/tencent/state/utils/IEventHandler;", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "eventMap", "<init>", "()V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SquareObserveRoleRegistServiceImpl implements ISquareObserveRoleRegistService, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> eventMap;

    public SquareObserveRoleRegistServiceImpl() {
        HashMap<Class<? extends SimpleBaseEvent>, IEventHandler> hashMap = new HashMap<>();
        EventBusUtilsKt.register(hashMap, CreateRoleEvent.class, SquareObserveRoleRegistServiceImpl$eventMap$1$1.INSTANCE);
        this.eventMap = hashMap;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.addAll(this.eventMap.keySet());
        return arrayList;
    }

    @Override // com.tencent.state.square.api.ISquareObserveRoleRegistService
    public void destroy() {
        QLog.i("SquareObserveRoleRegistServiceImpl", 1, "destroy");
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.state.square.api.ISquareObserveRoleRegistService
    public void start() {
        QLog.i("SquareObserveRoleRegistServiceImpl", 1, "start");
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        IEventHandler iEventHandler;
        if (event == null || (iEventHandler = this.eventMap.get(event.getClass())) == null) {
            return;
        }
        iEventHandler.handleEvent(event);
    }
}
