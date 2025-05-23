package com.tencent.mobileqq.matchfriend.reborn.content.msg.top.repository;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.api.IQQStrangerUserInfoMgr;
import com.tencent.mobileqq.matchfriend.bean.QQStrangerUserInfo;
import com.tencent.mobileqq.matchfriend.reborn.utils.d;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.servlet.a;
import com.tencent.relation.common.servlet.b;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$CardInfo;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$GetMsgBoxBannerReq;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$GetMsgBoxBannerRsp;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$ReportUserReq;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$ReportUserRsp;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000bJ#\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/repository/QQStrangerMsgTopRepository;", "", "", "Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$CardInfo;", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cardInfoList", "", h.F, "", "e", "Lkotlinx/coroutines/flow/Flow;", "g", "", "openId", "trace", "f", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMsgTopRepository {

    /* renamed from: b, reason: collision with root package name */
    private static final List<String> f244834b;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://downv6.qq.com/extendfriend/kl_hobby_card_1.png", "https://downv6.qq.com/extendfriend/kl_hobby_card_2.png", "https://downv6.qq.com/extendfriend/kl_hobby_card_3.png", "https://downv6.qq.com/extendfriend/kl_hobby_card_4.png"});
        f244834b = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object d(Continuation<? super List<Prompt$CardInfo>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("QQStrangerMsgTopRepository", 1, "[getCardListFromServer] network is not available");
            cancellableContinuationImpl.resume(null, null);
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            Object businessHandler = appInterface != null ? appInterface.getBusinessHandler(a.f364759y4) : null;
            a aVar = businessHandler instanceof a ? (a) businessHandler : null;
            int e16 = e();
            QLog.d("QQStrangerMsgTopRepository", 1, "[getCardListFromServer] request gender:" + e16);
            if (aVar != null) {
                Prompt$GetMsgBoxBannerReq prompt$GetMsgBoxBannerReq = new Prompt$GetMsgBoxBannerReq();
                prompt$GetMsgBoxBannerReq.gender.set(e16);
                Unit unit = Unit.INSTANCE;
                aVar.Z0("QQStranger.prompt.SsoGetMsgBoxBanner", prompt$GetMsgBoxBannerReq.toByteArray(), new b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.repository.QQStrangerMsgTopRepository$getCardListFromServer$2$2
                    @Override // com.tencent.mobileqq.app.BusinessObserver
                    public final void onUpdate(int i3, boolean z16, Object obj) {
                        if (z16 && (obj instanceof byte[])) {
                            Prompt$GetMsgBoxBannerRsp prompt$GetMsgBoxBannerRsp = new Prompt$GetMsgBoxBannerRsp();
                            try {
                                prompt$GetMsgBoxBannerRsp.mergeFrom((byte[]) obj);
                            } catch (Exception e17) {
                                QLog.e("QQStrangerMsgTopRepository", 1, "[getCardListFromServer] mergeFrom error ", e17);
                            }
                            QLog.d("QQStrangerMsgTopRepository", 1, "[getCardListFromServer] response: ret_code=" + prompt$GetMsgBoxBannerRsp.ret_code.get() + " err_msg=" + prompt$GetMsgBoxBannerRsp.err_msg.get() + " cardSize=" + prompt$GetMsgBoxBannerRsp.card_infos.get().size());
                            cancellableContinuationImpl.resume(prompt$GetMsgBoxBannerRsp.card_infos.get(), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.repository.QQStrangerMsgTopRepository$getCardListFromServer$2$2.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                    invoke2(th5);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    QLog.d("QQStrangerMsgTopRepository", 1, "[getCardListFromServer] resume exception: ", it);
                                }
                            });
                            return;
                        }
                        QLog.e("QQStrangerMsgTopRepository", 1, "[getCardListFromServer] response: isSuccess=" + z16 + " data=" + obj);
                        cancellableContinuationImpl.resume(null, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.repository.QQStrangerMsgTopRepository$getCardListFromServer$2$2.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.d("QQStrangerMsgTopRepository", 1, "[getCardListFromServer] resume exception: ", it);
                            }
                        });
                    }
                });
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int e() {
        QQStrangerUserInfo selfUserInfo;
        Object a16 = d.f245469a.a("loginUserInfoKey");
        userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
        if (userinfo_miniinfo != null) {
            return userinfo_miniinfo.gender.get();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null || (selfUserInfo = ((IQQStrangerUserInfoMgr) appInterface.getRuntimeService(IQQStrangerUserInfoMgr.class, "all")).getSelfUserInfo()) == null) {
            return 0;
        }
        return selfUserInfo.gender;
    }

    public final Object f(String str, String str2, Continuation<? super Integer> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("QQStrangerMsgTopRepository", 1, "[reportUser] network is not available");
            cancellableContinuationImpl.resume(Boxing.boxInt(-1), null);
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            Object businessHandler = appInterface != null ? appInterface.getBusinessHandler(a.f364759y4) : null;
            a aVar = businessHandler instanceof a ? (a) businessHandler : null;
            QLog.d("QQStrangerMsgTopRepository", 1, "[reportUser] request");
            if (aVar != null) {
                Prompt$ReportUserReq prompt$ReportUserReq = new Prompt$ReportUserReq();
                prompt$ReportUserReq.openId.set(str);
                prompt$ReportUserReq.recm_trace.set(str2);
                Unit unit = Unit.INSTANCE;
                aVar.Z0("QQStranger.prompt.SsoReportUser", prompt$ReportUserReq.toByteArray(), new b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.repository.QQStrangerMsgTopRepository$reportUser$2$2
                    @Override // com.tencent.mobileqq.app.BusinessObserver
                    public final void onUpdate(int i3, boolean z16, Object obj) {
                        if (z16 && (obj instanceof byte[])) {
                            Prompt$ReportUserRsp prompt$ReportUserRsp = new Prompt$ReportUserRsp();
                            try {
                                prompt$ReportUserRsp.mergeFrom((byte[]) obj);
                            } catch (Exception e16) {
                                QLog.e("QQStrangerMsgTopRepository", 1, "[reportUser] mergeFrom error ", e16);
                            }
                            QLog.d("QQStrangerMsgTopRepository", 1, "[reportUser] response: ret_code=" + prompt$ReportUserRsp.ret_code.get() + " err_msg=" + prompt$ReportUserRsp.err_msg.get());
                            cancellableContinuationImpl.resume(Integer.valueOf(prompt$ReportUserRsp.ret_code.get()), new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.repository.QQStrangerMsgTopRepository$reportUser$2$2.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                    invoke2(th5);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    QLog.d("QQStrangerMsgTopRepository", 1, "[getCardListFromServer] resume exception: ", it);
                                }
                            });
                            return;
                        }
                        QLog.e("QQStrangerMsgTopRepository", 1, "[reportUser] response: isSuccess=" + z16 + " data=" + obj);
                        cancellableContinuationImpl.resume(-2, new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.repository.QQStrangerMsgTopRepository$reportUser$2$2.2
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                                invoke2(th5);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Throwable it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                QLog.d("QQStrangerMsgTopRepository", 1, "[reportUser] resume exception: ", it);
                            }
                        });
                    }
                });
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Flow<List<Prompt$CardInfo>> g() {
        return FlowKt.flow(new QQStrangerMsgTopRepository$requestCardList$1(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(List<Prompt$CardInfo> cardInfoList) {
        if (cardInfoList == null) {
            return;
        }
        int i3 = 0;
        for (Prompt$CardInfo prompt$CardInfo : cardInfoList) {
            int i16 = prompt$CardInfo.card_type.get();
            if (i16 == 2) {
                prompt$CardInfo.background.set("https://downv6.qq.com/extendfriend/kl_hobby_card_cloud.png");
            } else if (i16 == 3) {
                PBStringField pBStringField = prompt$CardInfo.background;
                List<String> list = f244834b;
                pBStringField.set(list.get(i3 % list.size()));
                i3++;
            }
        }
    }
}
