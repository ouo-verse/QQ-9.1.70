package com.tencent.mobileqq.matchfriend.reborn.userinfo;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$BatchGetMiniUserInfoReq;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$BatchGetMiniUserInfoRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/userinfo/QQStrangerUserInfoRequest;", "", "", "Lcom/tencent/mobileqq/matchfriend/bean/c;", "contactList", "Lcom/tencent/relation/common/servlet/b;", "observer", "", "c", "Lcom/tencent/mobileqq/matchfriend/bean/QQStrangerUserInfo;", "b", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/trpcprotocol/kuolie/user_info/user_info/userInfo$MiniInfo;", "miniInfo", "d", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerUserInfoRequest {

    /* renamed from: a, reason: collision with root package name */
    public static final QQStrangerUserInfoRequest f245443a = new QQStrangerUserInfoRequest();

    QQStrangerUserInfoRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(List<com.tencent.mobileqq.matchfriend.bean.c> contactList, com.tencent.relation.common.servlet.b observer) {
        Object first;
        int collectionSizeOrDefault;
        List<String> list;
        String b16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        Object businessHandler = appInterface != null ? appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4) : null;
        com.tencent.relation.common.servlet.a aVar = businessHandler instanceof com.tencent.relation.common.servlet.a ? (com.tencent.relation.common.servlet.a) businessHandler : null;
        if (aVar == null) {
            QLog.e("QQStrangerUserInfoRequest", 1, "[batchReqUserInfoInner] handler null.");
            observer.onUpdate(0, false, "");
            return;
        }
        if (!contactList.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) contactList);
            boolean z16 = ((com.tencent.mobileqq.matchfriend.bean.c) first).c() != 0;
            List<com.tencent.mobileqq.matchfriend.bean.c> list2 = contactList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (com.tencent.mobileqq.matchfriend.bean.c cVar : list2) {
                if (z16) {
                    b16 = String.valueOf(cVar.c());
                } else {
                    b16 = cVar.b();
                }
                arrayList.add(b16);
            }
            userInfo$BatchGetMiniUserInfoReq userinfo_batchgetminiuserinforeq = new userInfo$BatchGetMiniUserInfoReq();
            userinfo_batchgetminiuserinforeq.account_type.set(z16 ? 2 : 0);
            PBRepeatField<String> pBRepeatField = userinfo_batchgetminiuserinforeq.account_ids;
            list = CollectionsKt___CollectionsKt.toList(arrayList);
            pBRepeatField.set(list);
            userinfo_batchgetminiuserinforeq.mini_info_ids.add(12);
            userinfo_batchgetminiuserinforeq.mini_info_ids.add(1);
            userinfo_batchgetminiuserinforeq.mini_info_ids.add(2);
            userinfo_batchgetminiuserinforeq.mini_info_ids.add(15);
            userinfo_batchgetminiuserinforeq.mini_info_ids.add(14);
            userinfo_batchgetminiuserinforeq.mini_info_ids.add(24);
            userinfo_batchgetminiuserinforeq.mini_info_ids.add(25);
            aVar.Z0("QQStranger.UserInfo.SsoBatchGetMiniUserInfo", userinfo_batchgetminiuserinforeq.toByteArray(), observer);
            return;
        }
        QLog.e("QQStrangerUserInfoRequest", 1, "[batchReqUserInfoInner] contactList empty.");
        observer.onUpdate(0, false, "");
    }

    public final Object b(List<com.tencent.mobileqq.matchfriend.bean.c> list, Continuation<? super List<QQStrangerUserInfo>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        List emptyList;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (QLog.isDevelopLevel()) {
            QLog.d("QQStrangerUserInfoRequest", 1, "[batchReqUserInfo] contactList=" + list);
        }
        if (list.isEmpty()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            cancellableContinuationImpl.resume(emptyList, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.userinfo.QQStrangerUserInfoRequest$batchReqUserInfo$2$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }
            });
        } else {
            f245443a.c(list, new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.userinfo.QQStrangerUserInfoRequest$batchReqUserInfo$2$2
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z16, Object obj) {
                    List<QQStrangerUserInfo> emptyList2;
                    List<QQStrangerUserInfo> emptyList3;
                    int collectionSizeOrDefault;
                    if (z16 && (obj instanceof byte[])) {
                        userInfo$BatchGetMiniUserInfoRsp userinfo_batchgetminiuserinforsp = new userInfo$BatchGetMiniUserInfoRsp();
                        try {
                            userinfo_batchgetminiuserinforsp.mergeFrom((byte[]) obj);
                            if (userinfo_batchgetminiuserinforsp.code.get() != 0) {
                                QLog.e("QQStrangerUserInfoRequest", 1, "[batchReqUserInfo] error, ret_code=" + userinfo_batchgetminiuserinforsp.code.get());
                                return;
                            }
                            List<userInfo$MiniInfo> miniInfoList = userinfo_batchgetminiuserinforsp.infos.get();
                            Intrinsics.checkNotNullExpressionValue(miniInfoList, "miniInfoList");
                            List<userInfo$MiniInfo> list2 = miniInfoList;
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                            for (userInfo$MiniInfo it : list2) {
                                QQStrangerUserInfoRequest qQStrangerUserInfoRequest = QQStrangerUserInfoRequest.f245443a;
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                arrayList.add(qQStrangerUserInfoRequest.d(it));
                            }
                            QLog.i("QQStrangerUserInfoRequest", 1, "[batchReqUserInfo] success, listSize=" + arrayList.size());
                            cancellableContinuationImpl.resume(arrayList, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.userinfo.QQStrangerUserInfoRequest$batchReqUserInfo$2$2.3
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it5) {
                                    Intrinsics.checkNotNullParameter(it5, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                    invoke2(th5);
                                    return Unit.INSTANCE;
                                }
                            });
                            return;
                        } catch (InvalidProtocolBufferMicroException e16) {
                            QLog.e("QQStrangerUserInfoRequest", 1, "[batchReqUserInfo] mergeFrom byteArray error.", e16);
                            CancellableContinuation<List<QQStrangerUserInfo>> cancellableContinuation = cancellableContinuationImpl;
                            emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                            cancellableContinuation.resume(emptyList3, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.userinfo.QQStrangerUserInfoRequest$batchReqUserInfo$2$2.2
                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it5) {
                                    Intrinsics.checkNotNullParameter(it5, "it");
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                    invoke2(th5);
                                    return Unit.INSTANCE;
                                }
                            });
                            return;
                        }
                    }
                    QLog.e("QQStrangerUserInfoRequest", 1, "[batchReqUserInfo] failed.");
                    CancellableContinuation<List<QQStrangerUserInfo>> cancellableContinuation2 = cancellableContinuationImpl;
                    emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                    cancellableContinuation2.resume(emptyList2, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.userinfo.QQStrangerUserInfoRequest$batchReqUserInfo$2$2.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable it5) {
                            Intrinsics.checkNotNullParameter(it5, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                            invoke2(th5);
                            return Unit.INSTANCE;
                        }
                    });
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final QQStrangerUserInfo d(userInfo$MiniInfo miniInfo) {
        int i3;
        String str;
        Intrinsics.checkNotNullParameter(miniInfo, "miniInfo");
        if (miniInfo.origin_info.has()) {
            i3 = miniInfo.origin_info.origin_id.get();
            str = miniInfo.origin_info.tag_text.get();
            Intrinsics.checkNotNullExpressionValue(str, "miniInfo.origin_info.tag_text.get()");
        } else {
            i3 = 0;
            str = "";
        }
        QQStrangerUserInfo qQStrangerUserInfo = new QQStrangerUserInfo();
        qQStrangerUserInfo.chatType = 104;
        qQStrangerUserInfo.tinyId = miniInfo.tiny_id.get();
        String str2 = miniInfo.open_id.get();
        Intrinsics.checkNotNullExpressionValue(str2, "miniInfo.open_id.get()");
        qQStrangerUserInfo.openId = str2;
        String str3 = miniInfo.nick.get();
        Intrinsics.checkNotNullExpressionValue(str3, "miniInfo.nick.get()");
        qQStrangerUserInfo.nick = str3;
        qQStrangerUserInfo.gender = miniInfo.gender.get();
        String str4 = miniInfo.avatar.get();
        Intrinsics.checkNotNullExpressionValue(str4, "miniInfo.avatar.get()");
        qQStrangerUserInfo.avatar = str4;
        qQStrangerUserInfo.matchSource = i3;
        qQStrangerUserInfo.matchText = str;
        String str5 = miniInfo.user_status.get();
        Intrinsics.checkNotNullExpressionValue(str5, "miniInfo.user_status.get()");
        qQStrangerUserInfo.onlineStatus = str5;
        qQStrangerUserInfo.userType = miniInfo.user_type.get();
        return qQStrangerUserInfo;
    }
}
