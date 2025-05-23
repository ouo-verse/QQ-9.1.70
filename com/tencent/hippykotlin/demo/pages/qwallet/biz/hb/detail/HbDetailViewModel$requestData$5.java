package com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import c45.a;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.qwallet.base.http.QWalletGatewayServlet;
import com.tencent.hippykotlin.demo.pages.qwallet.base.log.QWLog;
import com.tencent.hippykotlin.demo.pages.qwallet.base.module.NickNameBean;
import com.tencent.hippykotlin.demo.pages.qwallet.base.module.QWalletHbModule;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbDetailRsp;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbDetailStartupData;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbReceiver;
import com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.data.HbSender;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.h;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kuikly.com.tencent.mobileqq.pb.qwallet.b;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.HbDetailViewModel$requestData$5", f = "HbDetailViewModel.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class HbDetailViewModel$requestData$5 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ Function2<Boolean, Boolean, Unit> $completion;
    public final /* synthetic */ int $offset;
    public final /* synthetic */ Ref.ObjectRef<String> $queryString;
    public int label;
    public final /* synthetic */ HbDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HbDetailViewModel$requestData$5(HbDetailViewModel hbDetailViewModel, Ref.ObjectRef<String> objectRef, int i3, Function2<? super Boolean, ? super Boolean, Unit> function2, Continuation<? super HbDetailViewModel$requestData$5> continuation) {
        super(2, continuation);
        this.this$0 = hbDetailViewModel;
        this.$queryString = objectRef;
        this.$offset = i3;
        this.$completion = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HbDetailViewModel$requestData$5(this.this$0, this.$queryString, this.$offset, this.$completion, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((HbDetailViewModel$requestData$5) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0462  */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39, types: [androidx.compose.runtime.MutableState] */
    /* JADX WARN: Type inference failed for: r3v71 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.Iterable] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        byte[] encodeToByteArray;
        Object sendRequest;
        HbDetailViewModel$requestData$5 hbDetailViewModel$requestData$5;
        Object obj2;
        MutableState mutableStateOf$default;
        HbSender hbSender;
        MutableState mutableStateOf$default2;
        HbReceiver hbReceiver;
        HbReceiver hbReceiver2;
        String str;
        String str2;
        String str3;
        HbReceiver hbReceiver3;
        MutableState mutableStateOf$default3;
        boolean z16;
        HbReceiver hbReceiver4;
        byte[] bArr;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.isLoading.setValue(Boxing.boxBoolean(true));
            encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(this.$queryString.element);
            a aVar = new a(encodeToByteArray);
            MapsKt__MapsKt.emptyMap();
            kuikly.com.tencent.mobileqq.pb.qwallet.a aVar2 = new kuikly.com.tencent.mobileqq.pb.qwallet.a(aVar);
            b.a aVar3 = kuikly.com.tencent.mobileqq.pb.qwallet.b.f413161e;
            QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
            this.label = 1;
            sendRequest = qWalletGatewayServlet.sendRequest("trpc.qqhb.access.MobileHbCgi", "HBDetailCgi", aVar2, aVar3, null, true, false, null, this);
            if (sendRequest == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
            sendRequest = obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PbResponse pbResponse = (PbResponse) sendRequest;
        if (pbResponse.success && (obj2 = pbResponse.rsp) != null) {
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kuikly.com.tencent.mobileqq.pb.qwallet.OriginCgiRsp");
            a aVar4 = ((kuikly.com.tencent.mobileqq.pb.qwallet.b) obj2).f413162d;
            ArrayList<HbReceiver> arrayList = null;
            String decodeToString = (aVar4 == null || (bArr = aVar4.f30291a) == null) ? null : StringsKt__StringsJVMKt.decodeToString(bArr);
            if (decodeToString != null) {
                e eVar = new e(decodeToString);
                String q16 = eVar.q("retcode", "");
                String q17 = eVar.q("retmsg", "");
                e m3 = eVar.m("send_object");
                if (m3 == null) {
                    hbSender = null;
                } else {
                    String p16 = m3.p("send_listid");
                    String p17 = m3.p("send_tinyid");
                    int j3 = m3.j("type");
                    int j16 = m3.j("state");
                    String p18 = m3.p("send_uin");
                    mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(m3.p("send_name"), null, 2, null);
                    hbSender = new HbSender(m3.j("bus_type"), m3.j(WadlProxyConsts.CHANNEL), m3.p("invalid_time"), m3.j("is_owner"), m3.p("lucky_uin"), m3.n("recv_amount"), m3.j("recv_num"), mutableStateOf$default, p17, p18, p16, j16, m3.n("total_amount"), m3.j("total_num"), j3, m3.p("wishing"), m3.p("comment"));
                }
                e m16 = eVar.m("self_object");
                String str4 = AlbumCacheData.CREATE_TIME;
                String str5 = "amount";
                if (m16 == null) {
                    hbReceiver = null;
                } else {
                    int j17 = m16.j("amount");
                    String p19 = m16.p(AlbumCacheData.CREATE_TIME);
                    String p26 = m16.p("create_ts");
                    String p27 = m16.p("recv_list_id");
                    mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(m16.p("recv_name"), null, 2, null);
                    hbReceiver = new HbReceiver(j17, p19, p26, p27, mutableStateOf$default2, m16.p("recv_tinyid"), m16.p("recv_uin"));
                }
                com.tencent.kuikly.core.nvi.serialization.json.b l3 = eVar.l("recv_array");
                if (l3 == null) {
                    str = null;
                    hbReceiver2 = hbReceiver;
                } else {
                    int c16 = l3.c();
                    arrayList = new ArrayList();
                    hbReceiver2 = hbReceiver;
                    if (c16 >= 0) {
                        int i16 = 0;
                        while (true) {
                            Object d16 = l3.d(i16);
                            com.tencent.kuikly.core.nvi.serialization.json.b bVar = l3;
                            e eVar2 = d16 instanceof e ? (e) d16 : null;
                            if (eVar2 != null) {
                                int j18 = eVar2.j(str5);
                                String p28 = eVar2.p(str4);
                                String p29 = eVar2.p("create_ts");
                                String p36 = eVar2.p("recv_list_id");
                                str2 = str4;
                                str3 = str5;
                                str = null;
                                mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(eVar2.p("recv_name"), null, 2, null);
                                hbReceiver3 = new HbReceiver(j18, p28, p29, p36, mutableStateOf$default3, eVar2.p("recv_tinyid"), eVar2.p("recv_uin"));
                            } else {
                                str2 = str4;
                                str3 = str5;
                                str = null;
                                hbReceiver3 = null;
                            }
                            if (hbReceiver3 != null) {
                                arrayList.add(hbReceiver3);
                            }
                            if (i16 == c16) {
                                break;
                            }
                            i16++;
                            str5 = str3;
                            l3 = bVar;
                            str4 = str2;
                        }
                    } else {
                        str = null;
                    }
                }
                HbDetailRsp hbDetailRsp = new HbDetailRsp(q16, q17, hbSender, hbReceiver2, arrayList);
                QWLog qWLog = QWLog.INSTANCE;
                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("sender?.recvNum=");
                m17.append(hbSender != null ? Integer.valueOf(hbSender.recvNum) : str);
                m17.append(", sender?.totalNum=");
                m17.append(hbSender != null ? Integer.valueOf(hbSender.totalNum) : str);
                m17.append(",sender?.luckyUin=");
                m17.append(hbSender != null ? hbSender.luckyUin : str);
                QWLog.INSTANCE.i("HbDetailRsp", m17.toString(), false);
                if (Intrinsics.areEqual(hbSender != null ? Integer.valueOf(hbSender.recvNum) : str, hbSender != null ? Integer.valueOf(hbSender.totalNum) : str) && arrayList != null) {
                    for (HbReceiver hbReceiver5 : arrayList) {
                        String str6 = hbReceiver5.recvUin;
                        HbSender hbSender2 = hbDetailRsp.sender;
                        hbReceiver5.isLuck = Intrinsics.areEqual(str6, hbSender2 != null ? hbSender2.luckyUin : str);
                        QWLog qWLog2 = QWLog.INSTANCE;
                        StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("it.isLuck=");
                        m18.append(hbReceiver5.isLuck);
                        QWLog.INSTANCE.i("HbDetailRsp", m18.toString(), false);
                    }
                }
                hbDetailViewModel$requestData$5 = this;
                HbDetailViewModel hbDetailViewModel = hbDetailViewModel$requestData$5.this$0;
                int i17 = hbDetailViewModel$requestData$5.$offset;
                Function2<Boolean, Boolean, Unit> function2 = hbDetailViewModel$requestData$5.$completion;
                boolean z17 = i17 == 0;
                if (z17) {
                    hbDetailViewModel.hbDetailRsp.setValue(hbDetailRsp);
                }
                MutableState<Boolean> mutableState = hbDetailViewModel.hasGrabbed;
                HbDetailRsp value = hbDetailViewModel.hbDetailRsp.getValue();
                mutableState.setValue(Boolean.valueOf(((value == null || (hbReceiver4 = value.self) == null) ? 0 : hbReceiver4.amount) > 0));
                QWLog qWLog3 = QWLog.INSTANCE;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("HBDetailCgi success: isRefresh=");
                sb5.append(z17);
                sb5.append(", hasGrabbed=");
                sb5.append(hbDetailViewModel.hasGrabbed.getValue().booleanValue());
                sb5.append(", ");
                List<HbReceiver> list = hbDetailRsp.receivers;
                sb5.append(list != null ? Integer.valueOf(list.size()) : str);
                QWLog.INSTANCE.i("HbDetailViewModel", sb5.toString(), false);
                HbSender hbSender3 = hbDetailRsp.sender;
                String str7 = hbSender3 != null ? hbSender3.sendUin : str;
                final ?? r36 = hbSender3 != null ? hbSender3.sendName : str;
                if (str7 == null) {
                    QWLog.w$default("updateNickName fail, uin is null");
                } else {
                    QWalletHbModule qWalletHbModule = (QWalletHbModule) h.a().acquireModule("QWalletHbModule");
                    HbDetailStartupData value2 = hbDetailViewModel.startupData.getValue();
                    if (value2 != null) {
                        String str8 = value2.groupId;
                        final Function1<NickNameBean, Unit> function1 = new Function1<NickNameBean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.HbDetailViewModel$updateNickName$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NickNameBean nickNameBean) {
                                MutableState<String> mutableState2;
                                NickNameBean nickNameBean2 = nickNameBean;
                                String str9 = nickNameBean2 != null ? nickNameBean2.nickName : null;
                                String str10 = true ^ (str9 == null || str9.length() == 0) ? str9 : null;
                                if (str10 != null && (mutableState2 = r36) != null) {
                                    mutableState2.setValue(str10);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        qWalletHbModule.getClass();
                        e eVar3 = new e();
                        if (str8 != null) {
                            eVar3.v("groupId", str8);
                        }
                        eVar3.v("uin", str7);
                        qWalletHbModule.callNativeMethod("getNickName", eVar3, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.base.module.QWalletHbModule$getNickName$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(e eVar4) {
                                e eVar5 = eVar4;
                                function1.invoke(new NickNameBean(eVar5 != null ? eVar5.p("uin") : null, eVar5 != null ? eVar5.p("uid") : null, eVar5 != null ? eVar5.p("nickName") : null));
                                return Unit.INSTANCE;
                            }
                        });
                    }
                }
                List<HbReceiver> list2 = hbDetailRsp.receivers;
                if (list2 == null || list2.isEmpty()) {
                    hbDetailViewModel.hasMoreData.setValue(Boolean.FALSE);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("HBDetailCgi hasMoreData.value = false, list is empty:");
                    List<HbReceiver> list3 = hbDetailRsp.receivers;
                    sb6.append(list3 != null ? Integer.valueOf(list3.size()) : str);
                    QWLog.INSTANCE.i("HbDetailViewModel", sb6.toString(), false);
                } else {
                    hbDetailViewModel.receiverList.addAll(hbDetailRsp.receivers);
                    List<HbReceiver> list4 = hbDetailRsp.receivers;
                    QWalletHbModule qWalletHbModule2 = (QWalletHbModule) h.a().acquireModule("QWalletHbModule");
                    HbDetailStartupData value3 = hbDetailViewModel.startupData.getValue();
                    if (value3 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = list4.iterator();
                        while (it.hasNext()) {
                            String str9 = ((HbReceiver) it.next()).recvUin;
                            if (str9 != null) {
                                arrayList2.add(str9);
                            }
                        }
                        final ArrayList arrayList3 = new ArrayList(list4);
                        String str10 = value3.groupId;
                        final Function1<List<? extends NickNameBean>, Unit> function12 = new Function1<List<? extends NickNameBean>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.biz.hb.detail.HbDetailViewModel$updateNickNameList$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(List<? extends NickNameBean> list5) {
                                Object obj3;
                                ArrayList arrayList4 = new ArrayList();
                                Iterator<T> it5 = list5.iterator();
                                while (true) {
                                    if (!it5.hasNext()) {
                                        break;
                                    }
                                    Object next = it5.next();
                                    String str11 = ((NickNameBean) next).nickName;
                                    if (!(str11 == null || str11.length() == 0)) {
                                        arrayList4.add(next);
                                    }
                                }
                                ArrayList<HbReceiver> arrayList5 = arrayList3;
                                Iterator it6 = arrayList4.iterator();
                                while (it6.hasNext()) {
                                    NickNameBean nickNameBean = (NickNameBean) it6.next();
                                    String str12 = nickNameBean.nickName;
                                    if (!(str12 == null || str12.length() == 0)) {
                                        Iterator<T> it7 = arrayList5.iterator();
                                        while (true) {
                                            if (!it7.hasNext()) {
                                                obj3 = null;
                                                break;
                                            }
                                            obj3 = it7.next();
                                            if (Intrinsics.areEqual(((HbReceiver) obj3).recvUin, nickNameBean.uin)) {
                                                break;
                                            }
                                        }
                                        HbReceiver hbReceiver6 = (HbReceiver) obj3;
                                        MutableState<String> mutableState2 = hbReceiver6 != null ? hbReceiver6.recvName : null;
                                        if (mutableState2 != null) {
                                            mutableState2.setValue(str12);
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        qWalletHbModule2.getClass();
                        e eVar4 = new e();
                        if (str10 != null) {
                            eVar4.v("groupId", str10);
                        }
                        boolean z18 = !arrayList2.isEmpty();
                        ?? r95 = arrayList2;
                        if (!z18) {
                            r95 = str;
                        }
                        if (r95 != 0) {
                            com.tencent.kuikly.core.nvi.serialization.json.b bVar2 = new com.tencent.kuikly.core.nvi.serialization.json.b();
                            Iterator it5 = r95.iterator();
                            while (it5.hasNext()) {
                                bVar2.t((String) it5.next());
                            }
                            eVar4.v(SquareJSConst.Params.PARAMS_UIN_LIST, bVar2);
                        }
                        qWalletHbModule2.callNativeMethod("getNickNameList", eVar4, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.base.module.QWalletHbModule$getNickNameList$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(e eVar5) {
                                List<Object> w3;
                                e eVar6 = eVar5;
                                ArrayList arrayList4 = new ArrayList();
                                com.tencent.kuikly.core.nvi.serialization.json.b l16 = eVar6 != null ? eVar6.l("nickNameList") : null;
                                if (l16 != null && (w3 = l16.w()) != null) {
                                    for (Object obj3 : w3) {
                                        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
                                        e eVar7 = new e((String) obj3);
                                        arrayList4.add(new NickNameBean(eVar7.p("uin"), eVar7.p("uid"), eVar7.p("nickName")));
                                    }
                                }
                                function12.invoke(arrayList4);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                    QWLog qWLog4 = QWLog.INSTANCE;
                    StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("HBDetailCgi hasMoreData.value = ");
                    m19.append(hbDetailViewModel.hasMoreData.getValue().booleanValue());
                    m19.append(", rsp.sender?.recvNum=");
                    HbSender hbSender4 = hbDetailRsp.sender;
                    m19.append(hbSender4 != null ? Integer.valueOf(hbSender4.recvNum) : str);
                    QWLog.INSTANCE.i("HbDetailViewModel", m19.toString(), false);
                    if (function2 != null) {
                        z16 = true;
                        function2.invoke(Boolean.valueOf(!hbDetailViewModel.hasMoreData.getValue().booleanValue()), Boolean.FALSE);
                        if (function2 != null) {
                            function2.invoke(Boolean.valueOf(hbDetailViewModel.hasMoreData.getValue().booleanValue() ^ z16), Boolean.FALSE);
                        }
                    }
                }
                z16 = true;
                if (function2 != null) {
                }
            } else {
                hbDetailViewModel$requestData$5 = this;
            }
        } else {
            hbDetailViewModel$requestData$5 = this;
            Function2<Boolean, Boolean, Unit> function22 = hbDetailViewModel$requestData$5.$completion;
            if (function22 != null) {
                function22.invoke(Boxing.boxBoolean(false), Boxing.boxBoolean(true));
            }
            QWLog qWLog5 = QWLog.INSTANCE;
            StringBuilder m26 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("HBDetailCgi fail: ");
            m26.append(pbResponse.code);
            m26.append(',');
            m26.append(pbResponse.f114187msg);
            QWLog.w$default(m26.toString());
        }
        hbDetailViewModel$requestData$5.this$0.isLoading.setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
