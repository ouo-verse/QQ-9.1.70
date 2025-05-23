package com.tencent.mobileqq.matchfriend.reborn.couple.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerReloadEvent;
import com.tencent.mobileqq.matchfriend.reborn.couple.QQCoupleManagerProvider;
import com.tencent.mobileqq.matchfriend.reborn.couple.api.IQQStrangerInteractiveMarkService;
import com.tencent.mobileqq.matchfriend.reborn.couple.b;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.IQQCoupleModel;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.NearbyProInteractiveMarkModel;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.matchfriend.reborn.mark.InteractiveMarkRequest;
import com.tencent.mobileqq.matchfriend.reborn.utils.c;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qcoroutine.framework.impl.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqstranger.relation.interactive_marker.InteractiveMarkerPB$InteractiveMarker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J3\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J0\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0014\"\b\b\u0000\u0010\u0011*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0002J(\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0004j\b\u0012\u0004\u0012\u00020\u000b`\u0006H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u001a\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/couple/api/impl/QQStrangerInteractiveMarkServiceImpl;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/api/IQQStrangerInteractiveMarkService;", "", "chatType", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "needReqTinyIds", "", "batchGetInteractiveMarkInner", "(ILjava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "peerUid", "", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "getInteractiveMarksSync", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/IQQCoupleModel;", "T", "Ljava/lang/Class;", "clz", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/b;", "getCoupleMgr", "tinyIdList", "batchGetInteractiveMark", "peerTinyId", "", "canShownInOftenChatTab", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "Companion", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerInteractiveMarkServiceImpl implements IQQStrangerInteractiveMarkService {
    private static final int GET_INTERACTIVE_MARK_PAGE_SIZE = 50;
    public static final String TAG = "QQStrangerInteractiveMarkServiceImpl";

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object batchGetInteractiveMarkInner(int i3, ArrayList<Long> arrayList, Continuation<? super Unit> continuation) {
        QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1 qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1;
        Object coroutine_suspended;
        int i16;
        QQStrangerInteractiveMarkServiceImpl qQStrangerInteractiveMarkServiceImpl;
        LinkedHashMap linkedHashMap;
        if (continuation instanceof QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1) {
            qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1 = (QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1) continuation;
            int i17 = qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1.label = i17 - Integer.MIN_VALUE;
                Object obj = qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    InteractiveMarkRequest interactiveMarkRequest = InteractiveMarkRequest.f245170a;
                    int b16 = c.f245468a.b(i3);
                    qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1.L$0 = this;
                    qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1.I$0 = i3;
                    qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1.label = 1;
                    obj = interactiveMarkRequest.b(b16, arrayList, qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    qQStrangerInteractiveMarkServiceImpl = this;
                } else {
                    if (i16 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i3 = qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1.I$0;
                    qQStrangerInteractiveMarkServiceImpl = (QQStrangerInteractiveMarkServiceImpl) qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                linkedHashMap = new LinkedHashMap();
                ArrayList arrayList2 = new ArrayList();
                for (InteractiveMarkerPB$InteractiveMarker interactiveMarkerPB$InteractiveMarker : (List) obj) {
                    int i18 = interactiveMarkerPB$InteractiveMarker.marker_id.get();
                    long j3 = interactiveMarkerPB$InteractiveMarker.count.get();
                    long j16 = interactiveMarkerPB$InteractiveMarker.level.get();
                    String valueOf = String.valueOf(interactiveMarkerPB$InteractiveMarker.peer_tinyid.get());
                    if (j16 > 0) {
                        arrayList2.add(valueOf);
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.i(TAG, 1, "getInteractiveMarkFromSever, peerTinyId=" + valueOf + ", markId=" + i18 + ", count =" + j3 + ", level=" + j16);
                    }
                    if (linkedHashMap.get(valueOf) == null) {
                        linkedHashMap.put(valueOf, new ArrayList());
                    }
                    List list = (List) linkedHashMap.get(valueOf);
                    if (list != null) {
                        QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel = new QQStrangerInteractiveMarkModel();
                        qQStrangerInteractiveMarkModel.bizId = c.f245468a.c(i3);
                        qQStrangerInteractiveMarkModel.coupleId = valueOf;
                        qQStrangerInteractiveMarkModel.subtype = String.valueOf(i18);
                        qQStrangerInteractiveMarkModel.level = j16;
                        qQStrangerInteractiveMarkModel.count = j3;
                        Boxing.boxBoolean(list.add(qQStrangerInteractiveMarkModel));
                    }
                }
                QLog.i(TAG, 1, "[batchGetInteractiveMarkInner] getInteractiveMarkFromSever markCouples size=" + linkedHashMap.size());
                if (!linkedHashMap.isEmpty()) {
                    return Unit.INSTANCE;
                }
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (i3 == 104) {
                        b<? extends QQStrangerInteractiveMarkModel> coupleMgr = qQStrangerInteractiveMarkServiceImpl.getCoupleMgr(i3);
                        if (!(coupleMgr instanceof b)) {
                            coupleMgr = null;
                        }
                        if (coupleMgr != null) {
                            coupleMgr.d((List) entry.getValue());
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    QLog.i(TAG, 1, "[batchGetInteractiveMarkInner] hasMarkTinyIdList size=" + arrayList2.size());
                    SimpleEventBus.getInstance().dispatchEvent(QQStrangerReloadEvent.INSTANCE);
                }
                return Unit.INSTANCE;
            }
        }
        qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1 = new QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1(this, continuation);
        Object obj2 = qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMarkInner$1.label;
        if (i16 != 0) {
        }
        linkedHashMap = new LinkedHashMap();
        ArrayList arrayList22 = new ArrayList();
        while (r15.hasNext()) {
        }
        QLog.i(TAG, 1, "[batchGetInteractiveMarkInner] getInteractiveMarkFromSever markCouples size=" + linkedHashMap.size());
        if (!linkedHashMap.isEmpty()) {
        }
    }

    private final <T extends IQQCoupleModel> b<T> getCoupleMgr(int chatType, Class<T> clz) {
        return QQCoupleManagerProvider.f245049a.b(c.f245468a.c(chatType), clz);
    }

    private final List<QQStrangerInteractiveMarkModel> getInteractiveMarksSync(int chatType, String peerUid) {
        List<QQStrangerInteractiveMarkModel> emptyList;
        List e16;
        b<? extends QQStrangerInteractiveMarkModel> coupleMgr = getCoupleMgr(chatType);
        if (coupleMgr != null && (e16 = coupleMgr.e(peerUid)) != null) {
            return e16;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.couple.api.IQQStrangerInteractiveMarkService
    public void batchGetInteractiveMark(int chatType, ArrayList<String> tinyIdList) {
        Long longOrNull;
        Intrinsics.checkNotNullParameter(tinyIdList, "tinyIdList");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : tinyIdList) {
            if (getInteractiveMarksSync(chatType, (String) obj).isEmpty()) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) it.next());
            if (longOrNull != null) {
                arrayList.add(Long.valueOf(longOrNull.longValue()));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        QLog.i(TAG, 1, "[batchGetInteractiveMark] needReqTinyIds size: " + arrayList.size());
        CoroutineScope f16 = a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "batchGetInteractiveMark", null, null, null, new QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3(arrayList, this, chatType, null), 14, null);
        }
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.couple.api.IQQStrangerInteractiveMarkService
    public boolean canShownInOftenChatTab(int chatType, String peerTinyId) {
        Intrinsics.checkNotNullParameter(peerTinyId, "peerTinyId");
        Iterator<QQStrangerInteractiveMarkModel> it = getInteractiveMarksSync(chatType, peerTinyId).iterator();
        while (it.hasNext()) {
            if (it.next().level > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QQCoupleManagerProvider.f245049a.d();
    }

    @Override // com.tencent.mobileqq.matchfriend.reborn.couple.api.IQQStrangerInteractiveMarkService
    public b<? extends QQStrangerInteractiveMarkModel> getCoupleMgr(int chatType) {
        Class cls;
        if (chatType != 104) {
            cls = chatType != 119 ? null : NearbyProInteractiveMarkModel.class;
        } else {
            cls = QQStrangerInteractiveMarkModel.class;
        }
        if (cls == null) {
            return null;
        }
        return getCoupleMgr(chatType, cls);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.i(TAG, 1, "onCreate.");
    }
}
