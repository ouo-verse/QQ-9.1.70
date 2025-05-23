package com.tencent.mobileqq.matchfriend.reborn.mark.helper;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.tencent.aio.main.businesshelper.b;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.aio.stranger.api.IStrangerAssistantAdapterApi;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.matchfriend.reborn.couple.api.IQQStrangerInteractiveMarkService;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.IQQCoupleModel;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.NearbyProInteractiveMarkModel;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.matchfriend.reborn.mark.helper.QQStrangerInteractiveMarkHelper$coupleUpdateListener$2;
import com.tencent.mobileqq.matchfriend.reborn.utils.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.trpcprotocol.qqstranger.relation.interactive_marker.InteractiveMarkerPB$InteractiveMarker;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t*\u00011\u0018\u0000 \u00192\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J(\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0012\u0010\u001b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010\u001c\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017H\u0002J\u001a\u0010\u001e\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001d\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\bH\u0016R\u0016\u0010+\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/mark/helper/QQStrangerInteractiveMarkHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "chatType", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/b;", "k", "", "p", ReportConstant.COSTREPORT_PREFIX, "", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "peerTinyId", "", "Lcom/tencent/trpcprotocol/qqstranger/relation/interactive_marker/InteractiveMarkerPB$InteractiveMarker;", "markList", "r", "markId", "count", "level", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "e", h.F, "model", DomainData.DOMAIN_NAME, "o", "immediate", "t", "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "Lcom/tencent/mobileqq/matchfriend/reborn/mark/b;", "Lkotlin/Lazy;", "j", "()Lcom/tencent/mobileqq/matchfriend/reborn/mark/b;", "markBusiness", "com/tencent/mobileqq/matchfriend/reborn/mark/helper/QQStrangerInteractiveMarkHelper$coupleUpdateListener$2$a", "f", "g", "()Lcom/tencent/mobileqq/matchfriend/reborn/mark/helper/QQStrangerInteractiveMarkHelper$coupleUpdateListener$2$a;", "coupleUpdateListener", "<init>", "()V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerInteractiveMarkHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private b helperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy markBusiness;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy coupleUpdateListener;

    public QQStrangerInteractiveMarkHelper() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.matchfriend.reborn.mark.b>() { // from class: com.tencent.mobileqq.matchfriend.reborn.mark.helper.QQStrangerInteractiveMarkHelper$markBusiness$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.matchfriend.reborn.mark.b invoke() {
                return new com.tencent.mobileqq.matchfriend.reborn.mark.b();
            }
        });
        this.markBusiness = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<QQStrangerInteractiveMarkHelper$coupleUpdateListener$2.a>() { // from class: com.tencent.mobileqq.matchfriend.reborn.mark.helper.QQStrangerInteractiveMarkHelper$coupleUpdateListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/mark/helper/QQStrangerInteractiveMarkHelper$coupleUpdateListener$2$a", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/IQQCoupleModel;", "", "coupleList", "", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes33.dex */
            public static final class a implements com.tencent.mobileqq.matchfriend.reborn.couple.a<IQQCoupleModel> {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ QQStrangerInteractiveMarkHelper f245198a;

                a(QQStrangerInteractiveMarkHelper qQStrangerInteractiveMarkHelper) {
                    this.f245198a = qQStrangerInteractiveMarkHelper;
                }

                @Override // com.tencent.mobileqq.matchfriend.reborn.couple.a
                public void a(List<? extends IQQCoupleModel> coupleList) {
                    Intrinsics.checkNotNullParameter(coupleList, "coupleList");
                    IQQCoupleModel iQQCoupleModel = coupleList.isEmpty() ? null : coupleList.get(0);
                    if (iQQCoupleModel instanceof QQStrangerInteractiveMarkModel) {
                        this.f245198a.o((QQStrangerInteractiveMarkModel) iQQCoupleModel);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(QQStrangerInteractiveMarkHelper.this);
            }
        });
        this.coupleUpdateListener = lazy2;
    }

    private final QQStrangerInteractiveMarkModel e(String peerTinyId, int markId, long count, long level) {
        QQStrangerInteractiveMarkModel qQStrangerInteractiveMarkModel;
        b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        int e16 = bVar.a().g().r().c().e();
        if (e16 == 119) {
            qQStrangerInteractiveMarkModel = new NearbyProInteractiveMarkModel();
        } else {
            qQStrangerInteractiveMarkModel = new QQStrangerInteractiveMarkModel();
        }
        qQStrangerInteractiveMarkModel.bizId = c.f245468a.c(e16);
        qQStrangerInteractiveMarkModel.coupleId = peerTinyId;
        qQStrangerInteractiveMarkModel.subtype = String.valueOf(markId);
        qQStrangerInteractiveMarkModel.level = level;
        qQStrangerInteractiveMarkModel.count = count;
        return qQStrangerInteractiveMarkModel;
    }

    private final QQStrangerInteractiveMarkHelper$coupleUpdateListener$2.a g() {
        return (QQStrangerInteractiveMarkHelper$coupleUpdateListener$2.a) this.coupleUpdateListener.getValue();
    }

    private final void h() {
        b bVar = this.helperParam;
        b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        com.tencent.mobileqq.matchfriend.reborn.couple.b<?> k3 = k(bVar.a().g().r().c().e());
        if (k3 != null) {
            b bVar3 = this.helperParam;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            } else {
                bVar2 = bVar3;
            }
            k3.f(bVar2.a().g().r().c().j(), new Function1<List<? extends IQQCoupleModel>, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.mark.helper.QQStrangerInteractiveMarkHelper$getInteractiveMarkLocal$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends IQQCoupleModel> list) {
                    invoke2(list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends IQQCoupleModel> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if (it.isEmpty()) {
                        return;
                    }
                    QQStrangerInteractiveMarkHelper qQStrangerInteractiveMarkHelper = QQStrangerInteractiveMarkHelper.this;
                    IQQCoupleModel iQQCoupleModel = it.get(0);
                    qQStrangerInteractiveMarkHelper.n(iQQCoupleModel instanceof QQStrangerInteractiveMarkModel ? (QQStrangerInteractiveMarkModel) iQQCoupleModel : null);
                }
            });
        }
    }

    private final com.tencent.mobileqq.matchfriend.reborn.mark.b j() {
        return (com.tencent.mobileqq.matchfriend.reborn.mark.b) this.markBusiness.getValue();
    }

    private final com.tencent.mobileqq.matchfriend.reborn.couple.b<?> k(int chatType) {
        IQQStrangerInteractiveMarkService iQQStrangerInteractiveMarkService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iQQStrangerInteractiveMarkService = (IQQStrangerInteractiveMarkService) peekAppRuntime.getRuntimeService(IQQStrangerInteractiveMarkService.class, "all")) == null) {
            return null;
        }
        return iQQStrangerInteractiveMarkService.getCoupleMgr(chatType);
    }

    private final boolean m() {
        b bVar = this.helperParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        int e16 = bVar.a().g().r().c().e();
        return e16 == 104 || e16 == 119;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(QQStrangerInteractiveMarkModel model) {
        QLog.i("QQStrangerInteractiveMarkHelper", 1, "onGetCurrentMarkModel, model=" + model);
        t(model, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(QQStrangerInteractiveMarkModel model) {
        QLog.i("QQStrangerInteractiveMarkHelper", 1, "onMarkModelUpdate, model=" + model);
        t(model, false);
    }

    private final void p() {
        b bVar = this.helperParam;
        b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        int e16 = bVar.a().g().r().c().e();
        com.tencent.mobileqq.matchfriend.reborn.couple.b<?> k3 = k(e16);
        if (k3 != null) {
            b bVar3 = this.helperParam;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            } else {
                bVar2 = bVar3;
            }
            k3.a(bVar2.a().g().r().c().j(), i(e16), g());
        }
    }

    private final void q() {
        long j3;
        b bVar = null;
        try {
            b bVar2 = this.helperParam;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                bVar2 = null;
            }
            j3 = Long.parseLong(bVar2.a().g().r().c().j());
        } catch (Exception unused) {
            j3 = 0;
        }
        long j16 = j3;
        b bVar3 = this.helperParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar3 = null;
        }
        int e16 = bVar3.a().g().r().c().e();
        b bVar4 = this.helperParam;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
        } else {
            bVar = bVar4;
        }
        Lifecycle lifecycle = bVar.a().d().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "helperParam.aioContext.lifecycleOwner.lifecycle");
        BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), Dispatchers.getIO(), null, new QQStrangerInteractiveMarkHelper$reqInteractiveMark$1(e16, j16, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(long peerTinyId, List<InteractiveMarkerPB$InteractiveMarker> markList) {
        com.tencent.mobileqq.matchfriend.reborn.couple.b<?> bVar;
        b bVar2 = this.helperParam;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar2 = null;
        }
        int e16 = bVar2.a().g().r().c().e();
        ArrayList arrayList = new ArrayList();
        ArrayList<InteractiveMarkerPB$InteractiveMarker> arrayList2 = new ArrayList();
        for (Object obj : markList) {
            if (peerTinyId == ((InteractiveMarkerPB$InteractiveMarker) obj).peer_tinyid.get()) {
                arrayList2.add(obj);
            }
        }
        for (InteractiveMarkerPB$InteractiveMarker interactiveMarkerPB$InteractiveMarker : arrayList2) {
            arrayList.add(e(String.valueOf(peerTinyId), interactiveMarkerPB$InteractiveMarker.marker_id.get(), interactiveMarkerPB$InteractiveMarker.count.get(), interactiveMarkerPB$InteractiveMarker.level.get()));
        }
        if (e16 == 104) {
            com.tencent.mobileqq.matchfriend.reborn.couple.b<?> k3 = k(e16);
            bVar = k3 instanceof com.tencent.mobileqq.matchfriend.reborn.couple.b ? k3 : null;
            if (bVar != null) {
                bVar.d(arrayList);
                return;
            }
            return;
        }
        if (e16 != 119) {
            return;
        }
        com.tencent.mobileqq.matchfriend.reborn.couple.b<?> k16 = k(e16);
        bVar = k16 instanceof com.tencent.mobileqq.matchfriend.reborn.couple.b ? k16 : null;
        if (bVar != null) {
            bVar.d(TypeIntrinsics.asMutableList(arrayList));
        }
    }

    private final void s() {
        b bVar = this.helperParam;
        b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            bVar = null;
        }
        int e16 = bVar.a().g().r().c().e();
        com.tencent.mobileqq.matchfriend.reborn.couple.b<?> k3 = k(e16);
        if (k3 != null) {
            b bVar3 = this.helperParam;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            } else {
                bVar2 = bVar3;
            }
            k3.c(bVar2.a().g().r().c().j(), i(e16), g());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350678u1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "QQStrangerInteractiveMarkHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.helperParam = param;
        b bVar = null;
        if (m()) {
            IStrangerAssistantAdapterApi iStrangerAssistantAdapterApi = (IStrangerAssistantAdapterApi) QRoute.api(IStrangerAssistantAdapterApi.class);
            b bVar2 = this.helperParam;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                bVar2 = null;
            }
            if (!iStrangerAssistantAdapterApi.isLittleAssistant(bVar2.a().g().r().c())) {
                j().e(param.a());
                p();
                h();
                q();
                return;
            }
        }
        if (QLog.isDevelopLevel()) {
            b bVar3 = this.helperParam;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
                bVar3 = null;
            }
            int e16 = bVar3.a().g().r().c().e();
            b bVar4 = this.helperParam;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("helperParam");
            } else {
                bVar = bVar4;
            }
            QLog.d("QQStrangerInteractiveMarkHelper", 1, "onCreate. invalid chat type:" + e16 + ", filter office assistant tinyId:" + bVar.a().g().r().c().j());
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        s();
        j().f();
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[0];
    }

    private final void t(QQStrangerInteractiveMarkModel model, boolean immediate) {
        if (model != null) {
            j().i(model, immediate);
        }
    }

    private final String i(int chatType) {
        if (chatType == 119) {
            return "2";
        }
        return "1";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
