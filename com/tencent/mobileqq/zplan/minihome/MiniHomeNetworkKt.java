package com.tencent.mobileqq.zplan.minihome;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.mobileqq.zplan.utils.SknNetworkUtilKt;
import com.tencent.mobileqq.zplan.utils.ZPlanRequestReq;
import com.tencent.mobileqq.zplan.utils.at;
import com.tencent.mobileqq.zplan.utils.av;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001a\u001b\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a\u0013\u0010\u001b\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001c\u001a+\u0010!\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"\u001a\u001f\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010\u0019\u001a\u001d\u0010%\u001a\u0004\u0018\u00010#2\u0006\u0010\u001d\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010\u0010\u001a\u001b\u0010'\u001a\u00020&2\u0006\u0010\r\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u0010\u001a)\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u00022\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,\u001a\u001b\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010\u001c\u001a%\u00102\u001a\u0004\u0018\u0001012\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103\"$\u00109\u001a\u0012\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020604j\u0002`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u00108\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006:"}, d2 = {"", "source", "", "Lr55/b;", "f", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "filterExpression", "nextPage", "Lm55/b;", "c", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "friendUin", "Lq55/b;", "a", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "updatedRoomByte", "Lm55/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hash", "", "l", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lwu4/b;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uin", "masterId", "guestId", "", "k", "(JIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lq55/d;", "e", "d", "Lx45/f;", "i", "pageSize", "pageNum", "Lx45/g;", "g", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lx45/h;", tl.h.F, "receiverUin", IZootopiaShareArkService.ARK_TYPE, "Ls55/b;", "j", "(JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/zplan/utils/o;", "Lcom/tencent/mobileqq/zplan/utils/au;", "Lcom/tencent/mobileqq/zplan/utils/av;", "Lcom/tencent/mobileqq/zplan/utils/IZPlanRequest;", "Lcom/tencent/mobileqq/zplan/utils/o;", "getMiniHomeInfoRequester", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeNetworkKt {

    /* renamed from: a, reason: collision with root package name */
    private static final com.tencent.mobileqq.zplan.utils.o<ZPlanRequestReq, av> f334286a = SknNetworkUtilKt.b(SknNetworkUtilKt.h(at.f335791a, 0, 0, 3, null), new com.tencent.mobileqq.zplan.utils.n("requestGetMiniHomeInfo"), 3000);

    /* JADX WARN: Removed duplicated region for block: B:12:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(long j3, Continuation<? super q55.b> continuation) {
        MiniHomeNetworkKt$requestDrawMinihomeGift$1 miniHomeNetworkKt$requestDrawMinihomeGift$1;
        Object coroutine_suspended;
        int i3;
        MessageNano messageNano;
        Object data;
        if (continuation instanceof MiniHomeNetworkKt$requestDrawMinihomeGift$1) {
            miniHomeNetworkKt$requestDrawMinihomeGift$1 = (MiniHomeNetworkKt$requestDrawMinihomeGift$1) continuation;
            int i16 = miniHomeNetworkKt$requestDrawMinihomeGift$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                miniHomeNetworkKt$requestDrawMinihomeGift$1.label = i16 - Integer.MIN_VALUE;
                Object obj = miniHomeNetworkKt$requestDrawMinihomeGift$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = miniHomeNetworkKt$requestDrawMinihomeGift$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.zplan.utils.o h16 = SknNetworkUtilKt.h(at.f335791a, 0L, 0, 3, null);
                    q55.a aVar = new q55.a();
                    q55.b bVar = new q55.b();
                    aVar.f428428a = j3;
                    Unit unit = Unit.INSTANCE;
                    ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.zplan.mini_home_profile_card.Manager.SsoDrawMinihomeGift", SknNetworkUtilKt.i(aVar));
                    miniHomeNetworkKt$requestDrawMinihomeGift$1.L$0 = bVar;
                    miniHomeNetworkKt$requestDrawMinihomeGift$1.label = 1;
                    obj = h16.a(zPlanRequestReq, miniHomeNetworkKt$requestDrawMinihomeGift$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    messageNano = bVar;
                } else if (i3 == 1) {
                    messageNano = (MessageNano) miniHomeNetworkKt$requestDrawMinihomeGift$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                data = ((av) obj).getData();
                if (data != null) {
                    SknNetworkUtilKt.c((byte[]) data, messageNano);
                }
                return messageNano;
            }
        }
        miniHomeNetworkKt$requestDrawMinihomeGift$1 = new MiniHomeNetworkKt$requestDrawMinihomeGift$1(continuation);
        Object obj2 = miniHomeNetworkKt$requestDrawMinihomeGift$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeNetworkKt$requestDrawMinihomeGift$1.label;
        if (i3 != 0) {
        }
        data = ((av) obj2).getData();
        if (data != null) {
        }
        return messageNano;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object b(Continuation<? super wu4.b> continuation) {
        MiniHomeNetworkKt$requestGetActionPanel$1 miniHomeNetworkKt$requestGetActionPanel$1;
        Object coroutine_suspended;
        int i3;
        MessageNano messageNano;
        Object data;
        if (continuation instanceof MiniHomeNetworkKt$requestGetActionPanel$1) {
            miniHomeNetworkKt$requestGetActionPanel$1 = (MiniHomeNetworkKt$requestGetActionPanel$1) continuation;
            int i16 = miniHomeNetworkKt$requestGetActionPanel$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                miniHomeNetworkKt$requestGetActionPanel$1.label = i16 - Integer.MIN_VALUE;
                Object obj = miniHomeNetworkKt$requestGetActionPanel$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = miniHomeNetworkKt$requestGetActionPanel$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.zplan.utils.o h16 = SknNetworkUtilKt.h(at.f335791a, 0L, 0, 3, null);
                    wu4.a aVar = new wu4.a();
                    wu4.b bVar = new wu4.b();
                    aVar.f446549a = AppSetting.f99551k + "." + AppSetting.f99542b;
                    Unit unit = Unit.INSTANCE;
                    ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.mini_home.wowo_conn_action_panel.Provider.SsoGetActionPanel", SknNetworkUtilKt.i(aVar));
                    miniHomeNetworkKt$requestGetActionPanel$1.L$0 = bVar;
                    miniHomeNetworkKt$requestGetActionPanel$1.label = 1;
                    obj = h16.a(zPlanRequestReq, miniHomeNetworkKt$requestGetActionPanel$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    messageNano = bVar;
                } else if (i3 == 1) {
                    messageNano = (MessageNano) miniHomeNetworkKt$requestGetActionPanel$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                data = ((av) obj).getData();
                if (data != null) {
                    SknNetworkUtilKt.c((byte[]) data, messageNano);
                }
                return messageNano;
            }
        }
        miniHomeNetworkKt$requestGetActionPanel$1 = new MiniHomeNetworkKt$requestGetActionPanel$1(continuation);
        Object obj2 = miniHomeNetworkKt$requestGetActionPanel$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeNetworkKt$requestGetActionPanel$1.label;
        if (i3 != 0) {
        }
        data = ((av) obj2).getData();
        if (data != null) {
        }
        return messageNano;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object c(String str, int i3, Continuation<? super m55.b> continuation) {
        MiniHomeNetworkKt$requestGetCandidateList$1 miniHomeNetworkKt$requestGetCandidateList$1;
        Object coroutine_suspended;
        int i16;
        MessageNano messageNano;
        Object data;
        if (continuation instanceof MiniHomeNetworkKt$requestGetCandidateList$1) {
            miniHomeNetworkKt$requestGetCandidateList$1 = (MiniHomeNetworkKt$requestGetCandidateList$1) continuation;
            int i17 = miniHomeNetworkKt$requestGetCandidateList$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                miniHomeNetworkKt$requestGetCandidateList$1.label = i17 - Integer.MIN_VALUE;
                Object obj = miniHomeNetworkKt$requestGetCandidateList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = miniHomeNetworkKt$requestGetCandidateList$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.zplan.utils.o h16 = SknNetworkUtilKt.h(at.f335791a, 0L, 0, 3, null);
                    m55.a aVar = new m55.a();
                    m55.b bVar = new m55.b();
                    aVar.f416279a = "and " + AppSetting.f99551k + "." + AppSetting.f99542b;
                    aVar.f416280b = str;
                    aVar.f416281c = i3;
                    Unit unit = Unit.INSTANCE;
                    ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.zplan.mini_home_edit_page.Editor.SsoGetCandidateList", SknNetworkUtilKt.i(aVar));
                    miniHomeNetworkKt$requestGetCandidateList$1.L$0 = bVar;
                    miniHomeNetworkKt$requestGetCandidateList$1.label = 1;
                    obj = h16.a(zPlanRequestReq, miniHomeNetworkKt$requestGetCandidateList$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    messageNano = bVar;
                } else if (i16 == 1) {
                    messageNano = (MessageNano) miniHomeNetworkKt$requestGetCandidateList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                data = ((av) obj).getData();
                if (data != null) {
                    SknNetworkUtilKt.c((byte[]) data, messageNano);
                }
                m55.b bVar2 = (m55.b) messageNano;
                n55.a[] aVarArr = bVar2.f416282a;
                int i18 = bVar2.f416283b;
                boolean z16 = bVar2.f416284c;
                QLog.i("requestGetCandidateList", 1, "furnitures size: " + aVarArr.length + ", nextIndex: " + i18 + ", isLastPage: " + z16);
                return bVar2;
            }
        }
        miniHomeNetworkKt$requestGetCandidateList$1 = new MiniHomeNetworkKt$requestGetCandidateList$1(continuation);
        Object obj2 = miniHomeNetworkKt$requestGetCandidateList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = miniHomeNetworkKt$requestGetCandidateList$1.label;
        if (i16 != 0) {
        }
        data = ((av) obj2).getData();
        if (data != null) {
        }
        m55.b bVar22 = (m55.b) messageNano;
        n55.a[] aVarArr2 = bVar22.f416282a;
        int i182 = bVar22.f416283b;
        boolean z162 = bVar22.f416284c;
        QLog.i("requestGetCandidateList", 1, "furnitures size: " + aVarArr2.length + ", nextIndex: " + i182 + ", isLastPage: " + z162);
        return bVar22;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008a A[Catch: all -> 0x0092, TryCatch #0 {all -> 0x0092, blocks: (B:11:0x0029, B:12:0x0082, B:14:0x008a, B:15:0x008f, B:22:0x0039), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object d(long j3, Continuation<? super q55.d> continuation) {
        MiniHomeNetworkKt$requestGetMiniHomeInfo$2 miniHomeNetworkKt$requestGetMiniHomeInfo$2;
        Object coroutine_suspended;
        int i3;
        MessageNano messageNano;
        Object data;
        try {
            if (continuation instanceof MiniHomeNetworkKt$requestGetMiniHomeInfo$2) {
                miniHomeNetworkKt$requestGetMiniHomeInfo$2 = (MiniHomeNetworkKt$requestGetMiniHomeInfo$2) continuation;
                int i16 = miniHomeNetworkKt$requestGetMiniHomeInfo$2.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    miniHomeNetworkKt$requestGetMiniHomeInfo$2.label = i16 - Integer.MIN_VALUE;
                    Object obj = miniHomeNetworkKt$requestGetMiniHomeInfo$2.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = miniHomeNetworkKt$requestGetMiniHomeInfo$2.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        com.tencent.mobileqq.zplan.utils.o<ZPlanRequestReq, av> oVar = f334286a;
                        q55.c cVar = new q55.c();
                        q55.d dVar = new q55.d();
                        cVar.f428436b = "and " + AppSetting.f99551k + "." + AppSetting.f99542b;
                        cVar.f428435a = j3;
                        Unit unit = Unit.INSTANCE;
                        ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.zplan.mini_home_profile_card.Manager.SsoGetMinihomeInfo", SknNetworkUtilKt.i(cVar));
                        miniHomeNetworkKt$requestGetMiniHomeInfo$2.L$0 = dVar;
                        miniHomeNetworkKt$requestGetMiniHomeInfo$2.label = 1;
                        obj = oVar.a(zPlanRequestReq, miniHomeNetworkKt$requestGetMiniHomeInfo$2);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        messageNano = dVar;
                    } else if (i3 == 1) {
                        messageNano = (MessageNano) miniHomeNetworkKt$requestGetMiniHomeInfo$2.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    data = ((av) obj).getData();
                    if (data != null) {
                        SknNetworkUtilKt.c((byte[]) data, messageNano);
                    }
                    return (q55.d) messageNano;
                }
            }
            if (i3 != 0) {
            }
            data = ((av) obj).getData();
            if (data != null) {
            }
            return (q55.d) messageNano;
        } catch (Throwable th5) {
            QLog.e("requestGetMiniHomeInfo", 1, String.valueOf(th5));
            return null;
        }
        miniHomeNetworkKt$requestGetMiniHomeInfo$2 = new MiniHomeNetworkKt$requestGetMiniHomeInfo$2(continuation);
        Object obj2 = miniHomeNetworkKt$requestGetMiniHomeInfo$2.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeNetworkKt$requestGetMiniHomeInfo$2.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object f(int i3, Continuation<? super r55.b[]> continuation) {
        MiniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1 miniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1;
        Object coroutine_suspended;
        int i16;
        MessageNano messageNano;
        Object data;
        if (continuation instanceof MiniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1) {
            miniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1 = (MiniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1) continuation;
            int i17 = miniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                miniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1.label = i17 - Integer.MIN_VALUE;
                Object obj = miniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i16 = miniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1.label;
                if (i16 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.zplan.utils.o h16 = SknNetworkUtilKt.h(at.f335791a, 0L, 0, 3, null);
                    o55.a aVar = new o55.a();
                    o55.b bVar = new o55.b();
                    aVar.f422150a = AppSetting.f99551k + "." + AppSetting.f99542b;
                    aVar.f422151b = i3;
                    Unit unit = Unit.INSTANCE;
                    ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.zplan.mini_home_guide_page.Creator.SsoGetMinihomeGuidePageInfo", SknNetworkUtilKt.i(aVar));
                    miniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1.L$0 = bVar;
                    miniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1.label = 1;
                    obj = h16.a(zPlanRequestReq, miniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    messageNano = bVar;
                } else if (i16 == 1) {
                    messageNano = (MessageNano) miniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                data = ((av) obj).getData();
                if (data != null) {
                    SknNetworkUtilKt.c((byte[]) data, messageNano);
                }
                r55.b[] bVarArr = ((o55.b) messageNano).f422152a;
                Intrinsics.checkNotNullExpressionValue(bVarArr, "ZPlanRequest2.retryIfFai\u2026 source\n    }.sampleRooms");
                return bVarArr;
            }
        }
        miniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1 = new MiniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1(continuation);
        Object obj2 = miniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = miniHomeNetworkKt$requestGetMinihomeGuidePageInfo$1.label;
        if (i16 != 0) {
        }
        data = ((av) obj2).getData();
        if (data != null) {
        }
        r55.b[] bVarArr2 = ((o55.b) messageNano).f422152a;
        Intrinsics.checkNotNullExpressionValue(bVarArr2, "ZPlanRequest2.retryIfFai\u2026 source\n    }.sampleRooms");
        return bVarArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0074 A[Catch: all -> 0x0084, TryCatch #0 {all -> 0x0084, blocks: (B:11:0x0029, B:12:0x006c, B:14:0x0074, B:15:0x0079, B:22:0x0039), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object g(long j3, long j16, Continuation<? super x45.g[]> continuation) {
        MiniHomeNetworkKt$requestGetNeighbor$1 miniHomeNetworkKt$requestGetNeighbor$1;
        Object coroutine_suspended;
        int i3;
        MessageNano messageNano;
        Object data;
        try {
            if (continuation instanceof MiniHomeNetworkKt$requestGetNeighbor$1) {
                miniHomeNetworkKt$requestGetNeighbor$1 = (MiniHomeNetworkKt$requestGetNeighbor$1) continuation;
                int i16 = miniHomeNetworkKt$requestGetNeighbor$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    miniHomeNetworkKt$requestGetNeighbor$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = miniHomeNetworkKt$requestGetNeighbor$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = miniHomeNetworkKt$requestGetNeighbor$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        com.tencent.mobileqq.zplan.utils.o h16 = SknNetworkUtilKt.h(at.f335791a, 0L, 0, 3, null);
                        x45.a aVar = new x45.a();
                        x45.b bVar = new x45.b();
                        aVar.f447195a = j3;
                        aVar.f447196b = j16;
                        Unit unit = Unit.INSTANCE;
                        ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.mini_home.wowo_conn_map_svr.MapSvr.SsoGetNeighbors", SknNetworkUtilKt.i(aVar));
                        miniHomeNetworkKt$requestGetNeighbor$1.L$0 = bVar;
                        miniHomeNetworkKt$requestGetNeighbor$1.label = 1;
                        obj = h16.a(zPlanRequestReq, miniHomeNetworkKt$requestGetNeighbor$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        messageNano = bVar;
                    } else if (i3 == 1) {
                        messageNano = (MessageNano) miniHomeNetworkKt$requestGetNeighbor$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    data = ((av) obj).getData();
                    if (data != null) {
                        SknNetworkUtilKt.c((byte[]) data, messageNano);
                    }
                    x45.g[] gVarArr = ((x45.b) messageNano).f447197a;
                    Intrinsics.checkNotNullExpressionValue(gVarArr, "{\n        val rsp = ZPla\u2026   rsp.neighborList\n    }");
                    return gVarArr;
                }
            }
            if (i3 != 0) {
            }
            data = ((av) obj).getData();
            if (data != null) {
            }
            x45.g[] gVarArr2 = ((x45.b) messageNano).f447197a;
            Intrinsics.checkNotNullExpressionValue(gVarArr2, "{\n        val rsp = ZPla\u2026   rsp.neighborList\n    }");
            return gVarArr2;
        } catch (Throwable th5) {
            QLog.e("requestGetNeighbor", 1, th5, new Object[0]);
            x45.g[] b16 = x45.g.b();
            Intrinsics.checkNotNullExpressionValue(b16, "{\n        QLog.e(\"reques\u2026orInfo.emptyArray()\n    }");
            return b16;
        }
        miniHomeNetworkKt$requestGetNeighbor$1 = new MiniHomeNetworkKt$requestGetNeighbor$1(continuation);
        Object obj2 = miniHomeNetworkKt$requestGetNeighbor$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeNetworkKt$requestGetNeighbor$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0070 A[Catch: all -> 0x007a, TryCatch #0 {all -> 0x007a, blocks: (B:11:0x0029, B:12:0x0068, B:14:0x0070, B:15:0x0075, B:22:0x0039), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object h(Continuation<? super x45.h[]> continuation) {
        MiniHomeNetworkKt$requestGetRecommendUsers$1 miniHomeNetworkKt$requestGetRecommendUsers$1;
        Object coroutine_suspended;
        int i3;
        MessageNano messageNano;
        Object data;
        try {
            if (continuation instanceof MiniHomeNetworkKt$requestGetRecommendUsers$1) {
                miniHomeNetworkKt$requestGetRecommendUsers$1 = (MiniHomeNetworkKt$requestGetRecommendUsers$1) continuation;
                int i16 = miniHomeNetworkKt$requestGetRecommendUsers$1.label;
                if ((i16 & Integer.MIN_VALUE) != 0) {
                    miniHomeNetworkKt$requestGetRecommendUsers$1.label = i16 - Integer.MIN_VALUE;
                    Object obj = miniHomeNetworkKt$requestGetRecommendUsers$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = miniHomeNetworkKt$requestGetRecommendUsers$1.label;
                    if (i3 != 0) {
                        ResultKt.throwOnFailure(obj);
                        com.tencent.mobileqq.zplan.utils.o h16 = SknNetworkUtilKt.h(at.f335791a, 0L, 0, 3, null);
                        x45.c cVar = new x45.c();
                        x45.d dVar = new x45.d();
                        Unit unit = Unit.INSTANCE;
                        ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.mini_home.wowo_conn_map_svr.MapSvr.SsoGetRecommendUserInfo", SknNetworkUtilKt.i(cVar));
                        miniHomeNetworkKt$requestGetRecommendUsers$1.L$0 = dVar;
                        miniHomeNetworkKt$requestGetRecommendUsers$1.label = 1;
                        obj = h16.a(zPlanRequestReq, miniHomeNetworkKt$requestGetRecommendUsers$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        messageNano = dVar;
                    } else if (i3 == 1) {
                        messageNano = (MessageNano) miniHomeNetworkKt$requestGetRecommendUsers$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    data = ((av) obj).getData();
                    if (data != null) {
                        SknNetworkUtilKt.c((byte[]) data, messageNano);
                    }
                    return ((x45.d) messageNano).f447201a;
                }
            }
            if (i3 != 0) {
            }
            data = ((av) obj).getData();
            if (data != null) {
            }
            return ((x45.d) messageNano).f447201a;
        } catch (Throwable th5) {
            QLog.e("requestGetRecommendUsers", 1, "requestGetRecommendUsers failed.", th5);
            return null;
        }
        miniHomeNetworkKt$requestGetRecommendUsers$1 = new MiniHomeNetworkKt$requestGetRecommendUsers$1(continuation);
        Object obj2 = miniHomeNetworkKt$requestGetRecommendUsers$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeNetworkKt$requestGetRecommendUsers$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object i(long j3, Continuation<? super x45.f> continuation) {
        MiniHomeNetworkKt$requestInviteToMap$1 miniHomeNetworkKt$requestInviteToMap$1;
        Object coroutine_suspended;
        int i3;
        MessageNano messageNano;
        Object data;
        if (continuation instanceof MiniHomeNetworkKt$requestInviteToMap$1) {
            miniHomeNetworkKt$requestInviteToMap$1 = (MiniHomeNetworkKt$requestInviteToMap$1) continuation;
            int i16 = miniHomeNetworkKt$requestInviteToMap$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                miniHomeNetworkKt$requestInviteToMap$1.label = i16 - Integer.MIN_VALUE;
                Object obj = miniHomeNetworkKt$requestInviteToMap$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = miniHomeNetworkKt$requestInviteToMap$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.zplan.utils.o h16 = SknNetworkUtilKt.h(at.f335791a, 0L, 0, 3, null);
                    x45.e eVar = new x45.e();
                    x45.f fVar = new x45.f();
                    eVar.f447202a = j3;
                    Unit unit = Unit.INSTANCE;
                    ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.mini_home.wowo_conn_map_svr.MapSvr.SsoInviteToMap", SknNetworkUtilKt.i(eVar));
                    miniHomeNetworkKt$requestInviteToMap$1.L$0 = fVar;
                    miniHomeNetworkKt$requestInviteToMap$1.label = 1;
                    obj = h16.a(zPlanRequestReq, miniHomeNetworkKt$requestInviteToMap$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    messageNano = fVar;
                } else if (i3 == 1) {
                    messageNano = (MessageNano) miniHomeNetworkKt$requestInviteToMap$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                data = ((av) obj).getData();
                if (data != null) {
                    SknNetworkUtilKt.c((byte[]) data, messageNano);
                }
                return messageNano;
            }
        }
        miniHomeNetworkKt$requestInviteToMap$1 = new MiniHomeNetworkKt$requestInviteToMap$1(continuation);
        Object obj2 = miniHomeNetworkKt$requestInviteToMap$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeNetworkKt$requestInviteToMap$1.label;
        if (i3 != 0) {
        }
        data = ((av) obj2).getData();
        if (data != null) {
        }
        return messageNano;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073 A[Catch: all -> 0x007b, TryCatch #0 {all -> 0x007b, blocks: (B:11:0x0029, B:12:0x006b, B:14:0x0073, B:15:0x0078, B:22:0x0039), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object j(long j3, int i3, Continuation<? super s55.b> continuation) {
        MiniHomeNetworkKt$requestMiniHomeConnectArkInfo$1 miniHomeNetworkKt$requestMiniHomeConnectArkInfo$1;
        Object coroutine_suspended;
        int i16;
        MessageNano bVar;
        Object data;
        try {
            if (continuation instanceof MiniHomeNetworkKt$requestMiniHomeConnectArkInfo$1) {
                miniHomeNetworkKt$requestMiniHomeConnectArkInfo$1 = (MiniHomeNetworkKt$requestMiniHomeConnectArkInfo$1) continuation;
                int i17 = miniHomeNetworkKt$requestMiniHomeConnectArkInfo$1.label;
                if ((i17 & Integer.MIN_VALUE) != 0) {
                    miniHomeNetworkKt$requestMiniHomeConnectArkInfo$1.label = i17 - Integer.MIN_VALUE;
                    Object obj = miniHomeNetworkKt$requestMiniHomeConnectArkInfo$1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i16 = miniHomeNetworkKt$requestMiniHomeConnectArkInfo$1.label;
                    if (i16 != 0) {
                        ResultKt.throwOnFailure(obj);
                        com.tencent.mobileqq.zplan.utils.o h16 = SknNetworkUtilKt.h(at.f335791a, 0L, 0, 3, null);
                        s55.a aVar = new s55.a();
                        aVar.f433364a = j3;
                        aVar.f433365b = i3;
                        bVar = new s55.b();
                        Unit unit = Unit.INSTANCE;
                        ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.zplan.minihome_ark_svr.Manager.SsoGenSignedArk", SknNetworkUtilKt.i(aVar));
                        miniHomeNetworkKt$requestMiniHomeConnectArkInfo$1.L$0 = bVar;
                        miniHomeNetworkKt$requestMiniHomeConnectArkInfo$1.label = 1;
                        obj = h16.a(zPlanRequestReq, miniHomeNetworkKt$requestMiniHomeConnectArkInfo$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i16 == 1) {
                        bVar = (MessageNano) miniHomeNetworkKt$requestMiniHomeConnectArkInfo$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    data = ((av) obj).getData();
                    if (data != null) {
                        SknNetworkUtilKt.c((byte[]) data, bVar);
                    }
                    return (s55.b) bVar;
                }
            }
            if (i16 != 0) {
            }
            data = ((av) obj).getData();
            if (data != null) {
            }
            return (s55.b) bVar;
        } catch (Throwable th5) {
            QLog.e("requestMiniHomeConnectArkInfo", 1, "requestArkInfo failed.", th5);
            return null;
        }
        miniHomeNetworkKt$requestMiniHomeConnectArkInfo$1 = new MiniHomeNetworkKt$requestMiniHomeConnectArkInfo$1(continuation);
        Object obj2 = miniHomeNetworkKt$requestMiniHomeConnectArkInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i16 = miniHomeNetworkKt$requestMiniHomeConnectArkInfo$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object k(long j3, int i3, int i16, Continuation<? super Unit> continuation) {
        MiniHomeNetworkKt$requestReportPlayActionEvent$1 miniHomeNetworkKt$requestReportPlayActionEvent$1;
        Object coroutine_suspended;
        int i17;
        MessageNano messageNano;
        Object data;
        if (continuation instanceof MiniHomeNetworkKt$requestReportPlayActionEvent$1) {
            miniHomeNetworkKt$requestReportPlayActionEvent$1 = (MiniHomeNetworkKt$requestReportPlayActionEvent$1) continuation;
            int i18 = miniHomeNetworkKt$requestReportPlayActionEvent$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                miniHomeNetworkKt$requestReportPlayActionEvent$1.label = i18 - Integer.MIN_VALUE;
                Object obj = miniHomeNetworkKt$requestReportPlayActionEvent$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i17 = miniHomeNetworkKt$requestReportPlayActionEvent$1.label;
                if (i17 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.zplan.utils.o h16 = SknNetworkUtilKt.h(at.f335791a, 0L, 0, 3, null);
                    wu4.c cVar = new wu4.c();
                    wu4.d dVar = new wu4.d();
                    cVar.f446551a = j3;
                    cVar.f446552b = i3;
                    cVar.f446553c = i16;
                    Unit unit = Unit.INSTANCE;
                    ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.mini_home.wowo_conn_action_panel.Provider.SsoReportPlayActionEvent", SknNetworkUtilKt.i(cVar));
                    miniHomeNetworkKt$requestReportPlayActionEvent$1.L$0 = dVar;
                    miniHomeNetworkKt$requestReportPlayActionEvent$1.label = 1;
                    obj = h16.a(zPlanRequestReq, miniHomeNetworkKt$requestReportPlayActionEvent$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    messageNano = dVar;
                } else if (i17 == 1) {
                    messageNano = (MessageNano) miniHomeNetworkKt$requestReportPlayActionEvent$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                data = ((av) obj).getData();
                if (data != null) {
                    SknNetworkUtilKt.c((byte[]) data, messageNano);
                }
                return Unit.INSTANCE;
            }
        }
        miniHomeNetworkKt$requestReportPlayActionEvent$1 = new MiniHomeNetworkKt$requestReportPlayActionEvent$1(continuation);
        Object obj2 = miniHomeNetworkKt$requestReportPlayActionEvent$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i17 = miniHomeNetworkKt$requestReportPlayActionEvent$1.label;
        if (i17 != 0) {
        }
        data = ((av) obj2).getData();
        if (data != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object l(String str, Continuation<? super Boolean> continuation) {
        MiniHomeNetworkKt$requestSetInitialMiniHome$1 miniHomeNetworkKt$requestSetInitialMiniHome$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof MiniHomeNetworkKt$requestSetInitialMiniHome$1) {
            miniHomeNetworkKt$requestSetInitialMiniHome$1 = (MiniHomeNetworkKt$requestSetInitialMiniHome$1) continuation;
            int i16 = miniHomeNetworkKt$requestSetInitialMiniHome$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                miniHomeNetworkKt$requestSetInitialMiniHome$1.label = i16 - Integer.MIN_VALUE;
                Object obj = miniHomeNetworkKt$requestSetInitialMiniHome$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = miniHomeNetworkKt$requestSetInitialMiniHome$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    MiniHomeNetworkKt$requestSetInitialMiniHome$2 miniHomeNetworkKt$requestSetInitialMiniHome$2 = new MiniHomeNetworkKt$requestSetInitialMiniHome$2(str, null);
                    miniHomeNetworkKt$requestSetInitialMiniHome$1.label = 1;
                    obj = TimeoutKt.withTimeoutOrNull(5000L, miniHomeNetworkKt$requestSetInitialMiniHome$2, miniHomeNetworkKt$requestSetInitialMiniHome$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Boxing.boxBoolean(Intrinsics.areEqual(obj, Boxing.boxBoolean(true)));
            }
        }
        miniHomeNetworkKt$requestSetInitialMiniHome$1 = new MiniHomeNetworkKt$requestSetInitialMiniHome$1(continuation);
        Object obj2 = miniHomeNetworkKt$requestSetInitialMiniHome$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeNetworkKt$requestSetInitialMiniHome$1.label;
        if (i3 != 0) {
        }
        return Boxing.boxBoolean(Intrinsics.areEqual(obj2, Boxing.boxBoolean(true)));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m(byte[] bArr, Continuation<? super m55.d> continuation) {
        MiniHomeNetworkKt$requestUpdateMinihomeReq$1 miniHomeNetworkKt$requestUpdateMinihomeReq$1;
        Object coroutine_suspended;
        int i3;
        MessageNano messageNano;
        Object data;
        if (continuation instanceof MiniHomeNetworkKt$requestUpdateMinihomeReq$1) {
            miniHomeNetworkKt$requestUpdateMinihomeReq$1 = (MiniHomeNetworkKt$requestUpdateMinihomeReq$1) continuation;
            int i16 = miniHomeNetworkKt$requestUpdateMinihomeReq$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                miniHomeNetworkKt$requestUpdateMinihomeReq$1.label = i16 - Integer.MIN_VALUE;
                Object obj = miniHomeNetworkKt$requestUpdateMinihomeReq$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = miniHomeNetworkKt$requestUpdateMinihomeReq$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    com.tencent.mobileqq.zplan.utils.o h16 = SknNetworkUtilKt.h(at.f335791a, 0L, 0, 3, null);
                    m55.c cVar = new m55.c();
                    m55.d dVar = new m55.d();
                    cVar.f416285a = 1;
                    cVar.f416286b = bArr;
                    Unit unit = Unit.INSTANCE;
                    ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.zplan.mini_home_edit_page.Editor.SsoUpdateMinihome", SknNetworkUtilKt.i(cVar));
                    miniHomeNetworkKt$requestUpdateMinihomeReq$1.L$0 = dVar;
                    miniHomeNetworkKt$requestUpdateMinihomeReq$1.label = 1;
                    obj = h16.a(zPlanRequestReq, miniHomeNetworkKt$requestUpdateMinihomeReq$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    messageNano = dVar;
                } else if (i3 == 1) {
                    messageNano = (MessageNano) miniHomeNetworkKt$requestUpdateMinihomeReq$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                data = ((av) obj).getData();
                if (data != null) {
                    SknNetworkUtilKt.c((byte[]) data, messageNano);
                }
                return (m55.d) messageNano;
            }
        }
        miniHomeNetworkKt$requestUpdateMinihomeReq$1 = new MiniHomeNetworkKt$requestUpdateMinihomeReq$1(continuation);
        Object obj2 = miniHomeNetworkKt$requestUpdateMinihomeReq$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = miniHomeNetworkKt$requestUpdateMinihomeReq$1.label;
        if (i3 != 0) {
        }
        data = ((av) obj2).getData();
        if (data != null) {
        }
        return (m55.d) messageNano;
    }

    public static final Object e(String str, Continuation<? super q55.d> continuation) {
        return d(str != null ? Long.parseLong(str) : 0L, continuation);
    }
}
