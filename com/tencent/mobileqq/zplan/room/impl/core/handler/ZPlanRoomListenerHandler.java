package com.tencent.mobileqq.zplan.room.impl.core.handler;

import android.os.Bundle;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloudDef;
import com.tencent.trtc.TRTCCloudListener;
import gk3.c;
import iv4.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0006*\u0001\u001b\u0018\u0000 \u00062\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001c\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\u0004R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/core/handler/ZPlanRoomListenerHandler;", "", "Lkotlin/Function1;", "Lgk3/c;", "", "action", "f", "listener", "g", "d", "", "a", "Ljava/lang/String;", "roomId", "Ljava/util/concurrent/CopyOnWriteArrayList;", "b", "Ljava/util/concurrent/CopyOnWriteArrayList;", "commonListenerList", "c", "Lgk3/c;", "e", "()Lgk3/c;", "proxyCommonListener", "", "", "Ljava/util/Map;", "lastAudioMemberMicLevelMap", "com/tencent/mobileqq/zplan/room/impl/core/handler/ZPlanRoomListenerHandler$b", "Lcom/tencent/mobileqq/zplan/room/impl/core/handler/ZPlanRoomListenerHandler$b;", "trtcListener", "<init>", "(Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRoomListenerHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<c> commonListenerList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final c proxyCommonListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Integer> lastAudioMemberMicLevelMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final b trtcListener;

    public ZPlanRoomListenerHandler(String roomId) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        this.roomId = roomId;
        this.commonListenerList = new CopyOnWriteArrayList<>();
        this.proxyCommonListener = new c() { // from class: com.tencent.mobileqq.zplan.room.impl.core.handler.ZPlanRoomListenerHandler$proxyCommonListener$1
            @Override // gk3.c
            public void a(final List<k> speakerInfoList) {
                Intrinsics.checkNotNullParameter(speakerInfoList, "speakerInfoList");
                ZPlanRoomListenerHandler.this.f(new Function1<c, Unit>() { // from class: com.tencent.mobileqq.zplan.room.impl.core.handler.ZPlanRoomListenerHandler$proxyCommonListener$1$onSpeakingPosUserListChanged$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                        invoke2(cVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(c it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.a(speakerInfoList);
                    }
                });
            }

            @Override // gk3.c
            public void b(final Map<String, Integer> memberMicLevelMap) {
                Intrinsics.checkNotNullParameter(memberMicLevelMap, "memberMicLevelMap");
                ZPlanRoomListenerHandler.this.f(new Function1<c, Unit>() { // from class: com.tencent.mobileqq.zplan.room.impl.core.handler.ZPlanRoomListenerHandler$proxyCommonListener$1$onAudioMemberMicLevelChanged$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                        invoke2(cVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(c it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.b(memberMicLevelMap);
                    }
                });
            }

            @Override // gk3.c
            public void c(final String roomId2) {
                Intrinsics.checkNotNullParameter(roomId2, "roomId");
                ZPlanRoomListenerHandler.this.f(new Function1<c, Unit>() { // from class: com.tencent.mobileqq.zplan.room.impl.core.handler.ZPlanRoomListenerHandler$proxyCommonListener$1$onExitRoom$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                        invoke2(cVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(c it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.c(roomId2);
                    }
                });
            }
        };
        this.lastAudioMemberMicLevelMap = new LinkedHashMap();
        b bVar = new b();
        this.trtcListener = bVar;
        QLog.i("ZPlanRoom_ListenerHandler", 1, "initListener - " + this);
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).s(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final Function1<? super c, Unit> action) {
        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.room.impl.core.handler.ZPlanRoomListenerHandler$notifyAllExtraListeners$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CopyOnWriteArrayList copyOnWriteArrayList;
                ArrayList arrayList = new ArrayList();
                copyOnWriteArrayList = ZPlanRoomListenerHandler.this.commonListenerList;
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add((c) it.next());
                }
                Function1<c, Unit> function1 = action;
                Iterator it5 = arrayList.iterator();
                while (it5.hasNext()) {
                    function1.invoke((c) it5.next());
                }
                arrayList.clear();
            }
        });
    }

    public final void d() {
        QLog.i("ZPlanRoom_ListenerHandler", 1, "clearAll - " + this);
        ((gk3.b) vb3.a.f441346a.a(gk3.b.class)).m0(this.trtcListener);
        this.commonListenerList.clear();
    }

    /* renamed from: e, reason: from getter */
    public final c getProxyCommonListener() {
        return this.proxyCommonListener;
    }

    public final void g(c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        QLog.i("ZPlanRoom_ListenerHandler", 1, "registerCommonListener - " + listener);
        if (this.commonListenerList.contains(listener)) {
            return;
        }
        this.commonListenerList.add(listener);
    }

    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\t\u001a\u00020\b2\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u000e\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0016J$\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016\u00a8\u0006\u0019"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/core/handler/ZPlanRoomListenerHandler$b", "Lcom/tencent/trtc/TRTCCloudListener;", "Ljava/util/ArrayList;", "Lcom/tencent/trtc/TRTCCloudDef$TRTCVolumeInfo;", "Lkotlin/collections/ArrayList;", "userVolumes", "", "totalVolume", "", "onUserVoiceVolume", "", "userId", "", "available", "onUserAudioAvailable", "errCode", "errMsg", "Landroid/os/Bundle;", "extraInfo", "onError", "", "result", "onEnterRoom", "reason", "onExitRoom", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends TRTCCloudListener {
        b() {
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onError(int errCode, String errMsg, Bundle extraInfo) {
            QLog.e("ZPlanRoom_ListenerHandler", 1, "trtcListener#onError, errCode= " + errCode + ", errMsg= " + errMsg + ", extraInfo= " + extraInfo);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onExitRoom(int reason) {
            QLog.e("ZPlanRoom_ListenerHandler", 1, "trtcListener#onExitRoom, reason= " + reason);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserAudioAvailable(String userId, boolean available) {
            QLog.i("ZPlanRoom_ListenerHandler", 1, "trtcListener#onUserAudioAvailable, userId= " + userId + ", available= " + available);
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> userVolumes, int totalVolume) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            boolean z16 = false;
            if (userVolumes != null) {
                ZPlanRoomListenerHandler zPlanRoomListenerHandler = ZPlanRoomListenerHandler.this;
                for (TRTCCloudDef.TRTCVolumeInfo tRTCVolumeInfo : userVolumes) {
                    if (tRTCVolumeInfo.volume > 0) {
                        String str = tRTCVolumeInfo.userId;
                        Intrinsics.checkNotNullExpressionValue(str, "it.userId");
                        linkedHashMap.put(str, Integer.valueOf(tRTCVolumeInfo.volume));
                        int i3 = tRTCVolumeInfo.volume;
                        Integer num = (Integer) zPlanRoomListenerHandler.lastAudioMemberMicLevelMap.get(tRTCVolumeInfo.userId);
                        if (num == null || i3 != num.intValue()) {
                            z16 = true;
                        }
                    }
                }
            }
            if (linkedHashMap.size() == ZPlanRoomListenerHandler.this.lastAudioMemberMicLevelMap.size() ? z16 : true) {
                ZPlanRoomListenerHandler.this.lastAudioMemberMicLevelMap.clear();
                ZPlanRoomListenerHandler.this.lastAudioMemberMicLevelMap.putAll(linkedHashMap);
                ZPlanRoomListenerHandler.this.getProxyCommonListener().b(linkedHashMap);
            }
        }

        @Override // com.tencent.trtc.TRTCCloudListener
        public void onEnterRoom(long result) {
            if (result > 0) {
                QLog.i("ZPlanRoom_ListenerHandler", 1, "trtcListener#onEnterRoom success, costTime= " + result + "ms");
                return;
            }
            QLog.e("ZPlanRoom_ListenerHandler", 1, "trtcListener#onEnterRoom error, result= " + result);
        }
    }
}
