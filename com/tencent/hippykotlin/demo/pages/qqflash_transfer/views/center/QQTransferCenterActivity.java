package com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import bp3.a;
import bp3.j;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUIButtonKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QUINavBarKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.da_tong_report.DTReportConstKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.modifer_ext.ModifierExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUi;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$fileSetSimpleStatusListener$1;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.module.QQFlashTransferKuiklyModule;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFTCenterUIConfig;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFlashTransferBaseActivity;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterEmptyCardVM;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.vm.center.QQFTCenterFileSetCardVM;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.flashtransfer.api.impl.FlashTransferHelperApiImpl;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.ntcompose.activity.a;
import com.tencent.ntcompose.activity.b;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ColumnKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.d;
import com.tencent.ntcompose.foundation.layout.l;
import com.tencent.ntcompose.foundation.scheduler.SchedulerKt;
import com.tencent.ntcompose.material.GridLayoutMode;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.SurfaceKt;
import com.tencent.ntcompose.material.TextKt;
import com.tencent.ntcompose.material.ai;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.r;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import ws3.ab;
import ws3.br;
import ws3.bt;
import ws3.bv;
import ws3.cz;
import ws3.dg;
import ws3.dn;
import ws3.dp;
import ws3.dr;
import ws3.ed;
import ws3.ee;
import ws3.eg;
import ws3.eh;
import ws3.eo;
import ws3.es;
import ws3.et;
import ws3.r;
import ws3.u;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQTransferCenterActivity extends QQFlashTransferBaseActivity {
    public final QQTransferCenterViewModel viewModel = new QQTransferCenterViewModel();
    public final String kGuideViewHasShownKey = "kGuideViewHasShownKey";

    @Override // com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.BaseComponentActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onCreate(a aVar) {
        super.onCreate(aVar);
        boolean z16 = true;
        b.c(this, null, ComposableLambdaKt.composableLambdaInstance(862743491, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity$onCreate$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer, Integer num) {
                Composer composer2 = composer;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(862743491, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity.onCreate.<anonymous> (QQTransferCenterActivity.kt:60)");
                    }
                    QQTransferCenterActivity qQTransferCenterActivity = QQTransferCenterActivity.this;
                    qQTransferCenterActivity.body(qQTransferCenterActivity.viewModel, composer2, 72);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), 1, null);
        final QQTransferCenterViewModel qQTransferCenterViewModel = this.viewModel;
        qQTransferCenterViewModel.getClass();
        IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
        String str = qQTransferCenterViewModel.kTag;
        final QQTransferCenterViewModel$fileSetSimpleStatusListener$1 qQTransferCenterViewModel$fileSetSimpleStatusListener$1 = qQTransferCenterViewModel.fileSetSimpleStatusListener;
        a16.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(String.valueOf(qQTransferCenterViewModel$fileSetSimpleStatusListener$1.hashCode()));
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$addFileSetSimpleStatusListener$fileSetSimpleStatusListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                if (objArr != null) {
                    if (!(objArr.length == 0)) {
                        Iterator it = ArrayIteratorKt.iterator(objArr);
                        if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onFileSetStatusUpdate")) {
                            Object next = it.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                            int intValue = ((Integer) next).intValue();
                            ArrayList arrayList2 = new ArrayList();
                            for (int i3 = 0; i3 < intValue; i3++) {
                                Object next2 = it.next();
                                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                                int intValue2 = ((Integer) next2).intValue();
                                Object[] objArr2 = new Object[intValue2];
                                for (int i16 = 0; i16 < intValue2; i16++) {
                                    objArr2[i16] = it.next();
                                }
                                Iterator it5 = ArrayIteratorKt.iterator(objArr2);
                                eo eoVar = new eo(new bt(), 0L, 0L, 0L, 0L, 0, 0, 0, 0, 0L, 0L, false);
                                while (it5.hasNext()) {
                                    Object next3 = it5.next();
                                    if (Intrinsics.areEqual(next3, "fileSetSimpleInfo")) {
                                        Object next4 = it5.next();
                                        Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue3 = ((Integer) next4).intValue();
                                        Object[] objArr3 = new Object[intValue3];
                                        for (int i17 = 0; i17 < intValue3; i17++) {
                                            objArr3[i17] = it5.next();
                                        }
                                        Iterator it6 = ArrayIteratorKt.iterator(objArr3);
                                        bt btVar = new bt();
                                        while (it6.hasNext()) {
                                            Object next5 = it6.next();
                                            if (Intrinsics.areEqual(next5, "fileSetId")) {
                                                Object next6 = it6.next();
                                                Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.String");
                                                btVar.f446204a = (String) next6;
                                            } else if (Intrinsics.areEqual(next5, "name")) {
                                                Object next7 = it6.next();
                                                Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.String");
                                            } else if (Intrinsics.areEqual(next5, "totalFileCount")) {
                                                Object next8 = it6.next();
                                                Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.String");
                                                vs3.a.b((String) next8);
                                            } else if (Intrinsics.areEqual(next5, "totalFileSize")) {
                                                Object next9 = it6.next();
                                                Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.String");
                                                vs3.a.b((String) next9);
                                            } else if (Intrinsics.areEqual(next5, QCircleDaTongConstant.ElementParamValue.PERMISSION)) {
                                                Object next10 = it6.next();
                                                Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.Int");
                                                int intValue4 = ((Integer) next10).intValue();
                                                Object[] objArr4 = new Object[intValue4];
                                                for (int i18 = 0; i18 < intValue4; i18++) {
                                                    objArr4[i18] = it6.next();
                                                }
                                                ee.a(objArr4);
                                            } else if (Intrinsics.areEqual(next5, "cover")) {
                                                Object next11 = it6.next();
                                                Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.Int");
                                                int intValue5 = ((Integer) next11).intValue();
                                                Object[] objArr5 = new Object[intValue5];
                                                for (int i19 = 0; i19 < intValue5; i19++) {
                                                    objArr5[i19] = it6.next();
                                                }
                                                eh.a(objArr5);
                                            } else if (Intrinsics.areEqual(next5, "uploaders")) {
                                                Object next12 = it6.next();
                                                Intrinsics.checkNotNull(next12, "null cannot be cast to non-null type kotlin.Int");
                                                int intValue6 = ((Integer) next12).intValue();
                                                ArrayList arrayList3 = new ArrayList();
                                                int i26 = 0;
                                                while (i26 < intValue6) {
                                                    Object next13 = it6.next();
                                                    Intrinsics.checkNotNull(next13, "null cannot be cast to non-null type kotlin.Int");
                                                    int intValue7 = ((Integer) next13).intValue();
                                                    Object[] objArr6 = new Object[intValue7];
                                                    Iterator it7 = it;
                                                    for (int i27 = 0; i27 < intValue7; i27++) {
                                                        objArr6[i27] = it6.next();
                                                    }
                                                    arrayList3.add(et.a(objArr6));
                                                    i26++;
                                                    it = it7;
                                                }
                                            } else {
                                                Iterator it8 = it;
                                                if (Intrinsics.areEqual(next5, "expireLeftTime")) {
                                                    Object next14 = it6.next();
                                                    Intrinsics.checkNotNull(next14, "null cannot be cast to non-null type kotlin.String");
                                                    vs3.a.a((String) next14);
                                                } else if (Intrinsics.areEqual(next5, "transferType")) {
                                                    Object next15 = it6.next();
                                                    Intrinsics.checkNotNull(next15, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetListTypeKt.FileSetListType }");
                                                    ((Integer) next15).intValue();
                                                } else if (Intrinsics.areEqual(next5, "isLocalCreate")) {
                                                    Object next16 = it6.next();
                                                    Intrinsics.checkNotNull(next16, "null cannot be cast to non-null type kotlin.Int");
                                                    ((Integer) next16).intValue();
                                                } else if (Intrinsics.areEqual(next5, "localCoverPath")) {
                                                    Object next17 = it6.next();
                                                    Intrinsics.checkNotNull(next17, "null cannot be cast to non-null type kotlin.String");
                                                }
                                                it = it8;
                                            }
                                        }
                                        eoVar.f446343a = btVar;
                                    } else {
                                        Iterator it9 = it;
                                        if (Intrinsics.areEqual(next3, "completedFileCount")) {
                                            Object next18 = it5.next();
                                            Intrinsics.checkNotNull(next18, "null cannot be cast to non-null type kotlin.String");
                                            eoVar.f446344b = vs3.a.b((String) next18);
                                        } else if (Intrinsics.areEqual(next3, "failedFileCount")) {
                                            Object next19 = it5.next();
                                            Intrinsics.checkNotNull(next19, "null cannot be cast to non-null type kotlin.String");
                                            vs3.a.b((String) next19);
                                        } else if (Intrinsics.areEqual(next3, "completedFileSize")) {
                                            Object next20 = it5.next();
                                            Intrinsics.checkNotNull(next20, "null cannot be cast to non-null type kotlin.String");
                                            eoVar.f446345c = vs3.a.b((String) next20);
                                        } else if (Intrinsics.areEqual(next3, "totalTaskFileCount")) {
                                            Object next21 = it5.next();
                                            Intrinsics.checkNotNull(next21, "null cannot be cast to non-null type kotlin.String");
                                            eoVar.f446346d = vs3.a.b((String) next21);
                                        } else if (Intrinsics.areEqual(next3, "totalTaskFileSize")) {
                                            Object next22 = it5.next();
                                            Intrinsics.checkNotNull(next22, "null cannot be cast to non-null type kotlin.String");
                                            eoVar.f446347e = vs3.a.b((String) next22);
                                        } else if (Intrinsics.areEqual(next3, "status")) {
                                            Object next23 = it5.next();
                                            Intrinsics.checkNotNull(next23, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetSimpleStatusKt.FileSetSimpleStatus }");
                                            eoVar.f446348f = ((Integer) next23).intValue();
                                        } else if (Intrinsics.areEqual(next3, "fileSetStatus")) {
                                            Object next24 = it5.next();
                                            Intrinsics.checkNotNull(next24, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetStatusKt.FileSetStatus }");
                                            eoVar.f446349g = ((Integer) next24).intValue();
                                        } else if (Intrinsics.areEqual(next3, "uploadStatus")) {
                                            Object next25 = it5.next();
                                            Intrinsics.checkNotNull(next25, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetUploadStatusKt.FileSetUploadStatus }");
                                            eoVar.f446350h = ((Integer) next25).intValue();
                                        } else if (Intrinsics.areEqual(next3, VirtualAppProxy.KEY_DOWNLOAD_STATUS)) {
                                            Object next26 = it5.next();
                                            Intrinsics.checkNotNull(next26, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FileSetDownloadStatusKt.FileSetDownloadStatus }");
                                            eoVar.f446351i = ((Integer) next26).intValue();
                                        } else if (Intrinsics.areEqual(next3, "uploadPauseReason")) {
                                            Object next27 = it5.next();
                                            Intrinsics.checkNotNull(next27, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FlashTransferPauseReasonKt.FlashTransferPauseReason }");
                                            ((Integer) next27).intValue();
                                        } else if (Intrinsics.areEqual(next3, "downloadPauseReason")) {
                                            Object next28 = it5.next();
                                            Intrinsics.checkNotNull(next28, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.FlashTransferPauseReasonKt.FlashTransferPauseReason }");
                                            ((Integer) next28).intValue();
                                        } else if (Intrinsics.areEqual(next3, "speed")) {
                                            Object next29 = it5.next();
                                            Intrinsics.checkNotNull(next29, "null cannot be cast to non-null type kotlin.String");
                                            eoVar.f446352j = vs3.a.b((String) next29);
                                        } else if (Intrinsics.areEqual(next3, "timeRemain")) {
                                            Object next30 = it5.next();
                                            Intrinsics.checkNotNull(next30, "null cannot be cast to non-null type kotlin.String");
                                            eoVar.f446353k = vs3.a.b((String) next30);
                                        } else if (Intrinsics.areEqual(next3, "isLocalCreate")) {
                                            Object next31 = it5.next();
                                            Intrinsics.checkNotNull(next31, "null cannot be cast to non-null type kotlin.Int");
                                            eoVar.f446354l = ((Integer) next31).intValue() == 1;
                                            it = it9;
                                        }
                                        it = it9;
                                    }
                                }
                                arrayList2.add(eoVar);
                            }
                            cz.this.onFileSetStatusUpdate(arrayList2);
                            return Unit.INSTANCE;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a16.syncToNativeMethod(true, "addFileSetSimpleStatusListener", array, function1);
        a16.f344760c.put(qQTransferCenterViewModel$fileSetSimpleStatusListener$1, function1);
        c cVar = c.f117352a;
        qQTransferCenterViewModel.notifyListener = k.b((k) cVar.g().acquireModule("KRNotifyModule"), "kQQFTCenterFileSetStatusDidChangeNotification", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$onCreate$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List<java.lang.String>, java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                List<String> listOf;
                e eVar2 = eVar;
                String p16 = eVar2 != null ? eVar2.p(FlashTransferHelperApiImpl.kFileSetIdKey) : null;
                if (!(p16 == null || p16.length() == 0) && !QQTransferCenterViewModel.this.monitoringArray.contains(p16)) {
                    QQTransferCenterViewModel.this.monitoringArray.add(p16);
                    IKernelFlashTransferService a17 = IKernelFlashTransferService.f344757i.a();
                    String str2 = QQTransferCenterViewModel.this.kTag;
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(p16);
                    a17.a(str2, listOf);
                    KLog.INSTANCE.d(QQTransferCenterViewModel.this.kTag, "kQQFTCenterFileSetStatusDidChangeNotification callback fileSetId:" + p16);
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        qQTransferCenterViewModel.fileSetDeleteSuccessNotifyListener = k.b((k) cVar.g().acquireModule("KRNotifyModule"), FlashTransferHelperApiImpl.kQQFTFileSetDidDeletedNotification, false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$onCreate$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                Object obj = null;
                String p16 = eVar2 != null ? eVar2.p(FlashTransferHelperApiImpl.kFileSetIdKey) : null;
                if (!(p16 == null || p16.length() == 0)) {
                    SnapshotStateList<BaseComposeCardViewModel> snapshotStateList = QQTransferCenterViewModel.this.feedListViewModel.feedCardViewModelList;
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<BaseComposeCardViewModel> it = snapshotStateList.iterator();
                    while (it.hasNext()) {
                        BaseComposeCardViewModel next = it.next();
                        if (next instanceof QQFTCenterFileSetCardVM) {
                            arrayList2.add(next);
                        }
                    }
                    Iterator it5 = arrayList2.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        Object next2 = it5.next();
                        br brVar = ((QQFTCenterFileSetCardVM) next2).fileSet;
                        if (Intrinsics.areEqual(brVar != null ? brVar.f446187a : null, p16)) {
                            obj = next2;
                            break;
                        }
                    }
                    QQFTCenterFileSetCardVM qQFTCenterFileSetCardVM = (QQFTCenterFileSetCardVM) obj;
                    if (qQFTCenterFileSetCardVM != null) {
                        br brVar2 = qQFTCenterFileSetCardVM.fileSet;
                        if (brVar2 != null) {
                            brVar2.f446201o = 7;
                        }
                        qQFTCenterFileSetCardVM.fileSetStatus.setValue(7);
                    }
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
        this.viewModel.showTopEmptyCard = cVar.g().getPageData().n().j("has_send_entrance") == 1;
        this.viewModel.forceShowEmpty.setValue(Boolean.valueOf(cVar.g().getPageData().n().j("force_show_empty") == 1));
        MutableState<Boolean> mutableState = this.viewModel.getFilterCardVM().listGridMode;
        Utils utils = Utils.INSTANCE;
        CacheModule cacheModule = utils.cacheModule("");
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("kQQFTCenterListGridModeKey");
        m3.append(cVar.g().getPageData().n().q("uin", ""));
        Integer num = cacheModule.getInt(m3.toString());
        if (num != null && num.intValue() == 1) {
            z16 = false;
        }
        mutableState.setValue(Boolean.valueOf(z16));
        MutableState<Integer> mutableState2 = this.viewModel.hasShownGuide;
        Integer num2 = utils.cacheModule("").getInt(this.kGuideViewHasShownKey);
        mutableState2.setValue(Integer.valueOf(num2 != null ? num2.intValue() : 0));
        this.viewModel.requestFileSetList(null, null);
        KLog kLog = KLog.INSTANCE;
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onCreate showTopEmptyCard:");
        m16.append(this.viewModel.showTopEmptyCard);
        m16.append(" listGridMode:");
        m16.append(this.viewModel.getFilterCardVM().listGridMode.getValue().booleanValue());
        m16.append(" hasShownGuide:");
        m16.append(this.viewModel.hasShownGuide.getValue().intValue());
        m16.append(" uin:");
        m16.append(cVar.g().getPageData().n().q("uin", ""));
        kLog.d("QQTransferCenterActivity", m16.toString());
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.LinkedHashMap, java.util.Map<ws3.cz, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>>] */
    @Override // com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.QQFlashTransferBaseActivity, com.tencent.ntcompose.activity.ComponentActivity
    public final void onDestroy() {
        super.onDestroy();
        QQTransferCenterViewModel qQTransferCenterViewModel = this.viewModel;
        qQTransferCenterViewModel.stopMonitoring();
        IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
        String str = qQTransferCenterViewModel.kTag;
        a16.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a16.asyncToNativeMethod("removeFileSetSimpleStatusListener", array, (Function1<Object, Unit>) null);
        a16.f344760c.clear();
        String str2 = qQTransferCenterViewModel.notifyListener;
        if (str2 != null) {
            ((k) c.f117352a.g().acquireModule("KRNotifyModule")).e("kQQFTCenterFileSetStatusDidChangeNotification", str2);
        }
        String str3 = qQTransferCenterViewModel.fileSetDeleteSuccessNotifyListener;
        if (str3 != null) {
            ((k) c.f117352a.g().acquireModule("KRNotifyModule")).e(FlashTransferHelperApiImpl.kQQFTFileSetDidDeletedNotification, str3);
        }
        ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).clearImageMemoryCache();
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.closePage$default();
        }
    }

    @Override // com.tencent.ntcompose.activity.ComponentActivity
    public final void onResume() {
        super.onResume();
        ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).setEdgePopWidth(getPageData().m());
    }

    public final void body(final QQTransferCenterViewModel qQTransferCenterViewModel, Composer composer, final int i3) {
        String str;
        Composer startRestartGroup = composer.startRestartGroup(-1056191159);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1056191159, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity.body (QQTransferCenterActivity.kt:99)");
        }
        i d16 = ModifiersKt.d(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), QUIToken.color$default("bg_bottom_light"));
        if (defpackage.k.a(c.f117352a)) {
            str = "0S200MNJT807V3GE";
        } else {
            str = "0M2003OIIM08YV9M";
        }
        ColumnKt.a(ModifierExtKt.pageVR(d16, "pg_bas_flash_center", DTReportConstKt.getDTBaseParams(str)), null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1792101170, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(d dVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1792101170, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity.body.<anonymous> (QQTransferCenterActivity.kt:102)");
                    }
                    QUINavBarKt.QUINavBar(null, null, null, "QQ\u95ea\u4f20", null, null, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity$body$1.1
                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                            QQKuiklyPlatformApi.Companion.closePage$default();
                            return Unit.INSTANCE;
                        }
                    }, null, false, 0.0f, composer3, 806882304, com.tencent.luggage.wxa.yd.a.CTRL_INDEX);
                    if (!QQTransferCenterViewModel.this.forceShowEmpty.getValue().booleanValue()) {
                        composer3.startReplaceableGroup(1878383916);
                        if (QQTransferCenterViewModel.this.hasTransferHistory.getValue().booleanValue()) {
                            composer3.startReplaceableGroup(1878383974);
                            this.historyView(QQTransferCenterViewModel.this, com.tencent.ntcompose.foundation.lazy.b.a(0, 0.0f, composer3, 0, 3), composer3, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(1878384113);
                            QQTransferCenterViewModel qQTransferCenterViewModel2 = QQTransferCenterViewModel.this;
                            qQTransferCenterViewModel2.getFilterCardVM().showFilterContent.setValue(Boolean.FALSE);
                            qQTransferCenterViewModel2.feedListViewModel.feedCardViewModelList.clear();
                            if (qQTransferCenterViewModel2.showTopEmptyCard) {
                                qQTransferCenterViewModel2.feedListViewModel.feedCardViewModelList.add((QQFTCenterEmptyCardVM) qQTransferCenterViewModel2.emptyCardVM$delegate.getValue());
                            }
                            qQTransferCenterViewModel2.feedListViewModel.feedCardViewModelList.add(qQTransferCenterViewModel2.getFilterCardVM());
                            qQTransferCenterViewModel2.feedListViewModel.feedCardViewModelList.add((QQFTCenterEmptyCardVM) qQTransferCenterViewModel2.bottomEmptyCardVM$delegate.getValue());
                            this.historyView(QQTransferCenterViewModel.this, com.tencent.ntcompose.foundation.lazy.b.a(0, 0.0f, composer3, 0, 3), composer3, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST);
                            composer3.endReplaceableGroup();
                        }
                        composer3.endReplaceableGroup();
                    } else {
                        composer3.startReplaceableGroup(1878384317);
                        this.fullScreenEmptyView(composer3, 8);
                        composer3.endReplaceableGroup();
                    }
                    QQFTCenterFilterCardViewKt.QQFTCenterFilterCategoryView(QQTransferCenterViewModel.this.getFilterCardVM(), composer3, 8);
                    if (QQTransferCenterViewModel.this.shouldShowShareView.getValue().booleanValue()) {
                        final QQTransferCenterViewModel qQTransferCenterViewModel3 = QQTransferCenterViewModel.this;
                        QQFTCenterShareViewKt.QQFTCenterShareView(qQTransferCenterViewModel3, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity$body$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Boolean bool) {
                                bool.booleanValue();
                                KLog.INSTANCE.d("QQTransferCenterActivity", "QQFTCenterShareView onDismiss");
                                QQTransferCenterViewModel.this.shouldShowShareView.setValue(Boolean.FALSE);
                                QQTransferCenterViewModel qQTransferCenterViewModel4 = QQTransferCenterViewModel.this;
                                qQTransferCenterViewModel4.paginationInfo = null;
                                qQTransferCenterViewModel4.getFilterCardVM().currentFilterType.setValue(3);
                                ComposeFeedListViewModel.resetFooterRefresh$default(QQTransferCenterViewModel.this.feedListViewModel);
                                QQTransferCenterViewModel qQTransferCenterViewModel5 = QQTransferCenterViewModel.this;
                                QQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1 qQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1 = qQTransferCenterViewModel5.uploadStatusListener;
                                if (qQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1 != null) {
                                    qQTransferCenterViewModel5.uploadStatusListener = null;
                                    IKernelFlashTransferService.f344757i.a().k(qQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1);
                                }
                                QQTransferCenterViewModel qQTransferCenterViewModel6 = QQTransferCenterViewModel.this;
                                qQTransferCenterViewModel6.uploadShareLinkContent.setValue(bp3.b.a(""));
                                qQTransferCenterViewModel6.uploadedSize = 0L;
                                qQTransferCenterViewModel6.uploadedCount = 0L;
                                qQTransferCenterViewModel6.uploadTimeRemain = 0L;
                                qQTransferCenterViewModel6.totalUploadSize = 0L;
                                qQTransferCenterViewModel6.fileSetUploadStatusContent.setValue("\u4e0a\u4f20\u51c6\u5907\u4e2d");
                                qQTransferCenterViewModel6.fileSetUploadProgress.setValue(Float.valueOf(0.0f));
                                qQTransferCenterViewModel6.fileSetUploadStatus.setValue(0);
                                QQTransferCenterViewModel.this.requestFileSetList(null, null);
                                return Unit.INSTANCE;
                            }
                        }, composer3, 8);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity$body$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQTransferCenterActivity.this.body(qQTransferCenterViewModel, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public final void fullScreenEmptyView(Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(64396572);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(64396572, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity.fullScreenEmptyView (QQTransferCenterActivity.kt:147)");
        }
        float f16 = 20;
        SurfaceKt.a(ModifiersKt.d(ComposeLayoutPropUpdaterKt.l(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), f16), QUIToken.color$default("fill_standard_primary")), uo3.c.a(f16), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -114713506, true, new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity$fullScreenEmptyView$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 11) == 2 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-114713506, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity.fullScreenEmptyView.<anonymous> (QQTransferCenterActivity.kt:151)");
                    }
                    i h16 = ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null);
                    Alignment.Horizontal horizontal = Alignment.Horizontal.CenterHorizontally;
                    a.e b16 = com.tencent.ntcompose.foundation.layout.base.a.f339245a.b();
                    final QQTransferCenterActivity qQTransferCenterActivity = QQTransferCenterActivity.this;
                    ColumnKt.a(h16, b16, horizontal, null, ComposableLambdaKt.composableLambda(composer3, -639721131, true, new Function3<d, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity$fullScreenEmptyView$1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(d dVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-639721131, intValue2, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity.fullScreenEmptyView.<anonymous>.<anonymous> (QQTransferCenterActivity.kt:156)");
                                }
                                i.Companion companion = i.INSTANCE;
                                ImageKt.a(null, null, null, null, null, ComposeLayoutPropUpdaterKt.u(companion, 128), null, 0, null, null, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_lmQBWm1KbCq.png", null, null, null, null, null, null, null, null, null, null, composer5, 262144, 6, 0, 2096095);
                                TextKt.a("\u4e0d\u9650\u683c\u5f0f\u3001\u6587\u4ef6\u6700\u5927 10 GB", ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.A(companion), 0.0f, 32, 0.0f, 0.0f, 13, null), null, QUIToken.color$default("text_primary"), Float.valueOf(17), null, bp3.c.INSTANCE.e(), null, null, null, ai.f(ai.INSTANCE.a()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, composer5, 1601606, 0, 0, 134216612);
                                i q16 = ModifiersKt.q(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.v(companion, 264, 48), 0.0f, 20, 0.0f, 0.0f, 13, null), uo3.c.a(10));
                                final QQTransferCenterActivity qQTransferCenterActivity2 = QQTransferCenterActivity.this;
                                QUIButtonKt.QUIButton(q16, null, null, "\u9009\u62e9\u6587\u4ef6", null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity.fullScreenEmptyView.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        KLog.INSTANCE.d("QQTransferCenterActivity", "fullScreenEmptyView onClick \u9009\u62e9\u6587\u4ef6");
                                        final QQTransferCenterViewModel qQTransferCenterViewModel = QQTransferCenterActivity.this.viewModel;
                                        qQTransferCenterViewModel.getClass();
                                        QQFlashTransferKuiklyModule.Companion.getInstance().toNative(true, "showFileSelector", "", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$showNativeFileSelector$1
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Multi-variable type inference failed */
                                            /* JADX WARN: Type inference failed for: r3v13, types: [com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1, ws3.dp] */
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(e eVar) {
                                                final ArrayList arrayList;
                                                List emptyList;
                                                List emptyList2;
                                                List emptyList3;
                                                List emptyList4;
                                                String str;
                                                Object first;
                                                Object first2;
                                                com.tencent.kuikly.core.nvi.serialization.json.b l3;
                                                com.tencent.kuikly.core.nvi.serialization.json.b l16;
                                                List<Object> w3;
                                                int collectionSizeOrDefault;
                                                e eVar2 = eVar;
                                                KLog.INSTANCE.d(QQTransferCenterViewModel.this.kTag, "showFileSelector callback " + eVar2);
                                                if (eVar2 != null) {
                                                    int j3 = eVar2.j("result");
                                                    final String p16 = eVar2.p("msg");
                                                    if (j3 == 0) {
                                                        e m3 = eVar2.m("uploadParam");
                                                        final QQTransferCenterViewModel qQTransferCenterViewModel2 = QQTransferCenterViewModel.this;
                                                        qQTransferCenterViewModel2.getClass();
                                                        String p17 = m3 != null ? m3.p("name") : null;
                                                        if (m3 == null || (l16 = m3.l("uploaders")) == null || (w3 = l16.w()) == null) {
                                                            arrayList = null;
                                                        } else {
                                                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(w3, 10);
                                                            arrayList = new ArrayList(collectionSizeOrDefault);
                                                            for (Object obj : w3) {
                                                                es esVar = new es(null, null, null, null, 15, null);
                                                                Map map = obj instanceof Map ? (Map) obj : null;
                                                                if (map != null) {
                                                                    esVar.f446362b = String.valueOf(map.get("nickName"));
                                                                    esVar.f446361a = String.valueOf(map.get("uin"));
                                                                    esVar.f446363c = String.valueOf(map.get("uid"));
                                                                }
                                                                arrayList.add(esVar);
                                                            }
                                                        }
                                                        List<Object> w16 = (m3 == null || (l3 = m3.l("paths")) == null) ? null : l3.w();
                                                        if (!(arrayList != null && arrayList.isEmpty())) {
                                                            if (!(w16 != null && w16.isEmpty())) {
                                                                String p18 = m3 != null ? m3.p(QQWinkConstants.COVER_PATH) : null;
                                                                emptyList = CollectionsKt__CollectionsKt.emptyList();
                                                                ed edVar = new ed();
                                                                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                                                                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                                                                emptyList4 = CollectionsKt__CollectionsKt.emptyList();
                                                                final r rVar = new r(0, "", emptyList, edVar, "", emptyList2, emptyList3, emptyList4, 0, false);
                                                                rVar.f446388a = 1;
                                                                rVar.f446389b = p17 == null ? "QQ\u95ea\u4f20" : p17;
                                                                Intrinsics.checkNotNull(arrayList);
                                                                rVar.f446390c = arrayList;
                                                                Intrinsics.checkNotNull(w16, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.String> }");
                                                                rVar.f446394g = (ArrayList) w16;
                                                                if (p18 == null) {
                                                                    first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) w16);
                                                                    str = (String) first2;
                                                                } else {
                                                                    str = p18;
                                                                }
                                                                rVar.f446392e = str;
                                                                Utils utils = Utils.INSTANCE;
                                                                Integer num3 = utils.cacheModule("").getInt("kCustomExpireTimeSwitchKey");
                                                                if (num3 != null && num3.intValue() == 1) {
                                                                    Integer num4 = utils.cacheModule("").getInt("kCustomExpireTimeValueKey");
                                                                    rVar.f446396i = UInt.m570constructorimpl(num4 != null ? num4.intValue() : 0);
                                                                }
                                                                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                                                                es esVar2 = (es) first;
                                                                KLog kLog = KLog.INSTANCE;
                                                                String str2 = qQTransferCenterViewModel2.kTag;
                                                                StringBuilder m16 = CacheDiskLru$$ExternalSyntheticOutline0.m("createUploadTask name:", p17, ", uploaders:");
                                                                m16.append(esVar2.f446361a);
                                                                m16.append(TokenParser.SP);
                                                                m16.append(esVar2.f446363c);
                                                                m16.append(TokenParser.SP);
                                                                m16.append(esVar2.f446362b);
                                                                m16.append(", paths:");
                                                                m16.append(w16);
                                                                m16.append(", cover:");
                                                                m16.append(p18);
                                                                m16.append(" expireLeftTime:");
                                                                m16.append((Object) UInt.m615toStringimpl(rVar.f446396i));
                                                                kLog.d(str2, m16.toString());
                                                                if (qQTransferCenterViewModel2.uploadStatusListener == null) {
                                                                    ?? r36 = new dp() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1
                                                                        @Override // ws3.dp
                                                                        public final void onFileSetUploadProgressChanged(final bv bvVar) {
                                                                            String str3 = bvVar.f446213a.f446187a;
                                                                            br brVar = QQTransferCenterViewModel.this.uploadedFileSet;
                                                                            if (Intrinsics.areEqual(str3, brVar != null ? brVar.f446187a : null)) {
                                                                                final QQTransferCenterViewModel qQTransferCenterViewModel3 = QQTransferCenterViewModel.this;
                                                                                SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1$onFileSetUploadProgressChanged$1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(0);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function0
                                                                                    public final Unit invoke() {
                                                                                        QQTransferCenterViewModel qQTransferCenterViewModel4 = QQTransferCenterViewModel.this;
                                                                                        bv bvVar2 = bvVar;
                                                                                        qQTransferCenterViewModel4.uploadedCount = bvVar2.f446214b;
                                                                                        qQTransferCenterViewModel4.totalUploadSize = bvVar2.f446213a.f446190d;
                                                                                        qQTransferCenterViewModel4.uploadedSize = bvVar2.f446216d;
                                                                                        qQTransferCenterViewModel4.uploadTimeRemain = bvVar2.f446218f;
                                                                                        QQTransferCenterViewModel.access$updateFileSetUploadStatusContent(qQTransferCenterViewModel4);
                                                                                        QQTransferCenterViewModel qQTransferCenterViewModel5 = QQTransferCenterViewModel.this;
                                                                                        long j16 = qQTransferCenterViewModel5.totalUploadSize;
                                                                                        qQTransferCenterViewModel5.fileSetUploadProgress.setValue(Float.valueOf(j16 > 0 ? ((float) qQTransferCenterViewModel5.uploadedSize) / ((float) j16) : 0.0f));
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                            }
                                                                        }

                                                                        @Override // ws3.dp
                                                                        public final void onFileSetUploadStatusChanged(final br brVar) {
                                                                            String str3 = brVar.f446187a;
                                                                            br brVar2 = QQTransferCenterViewModel.this.uploadedFileSet;
                                                                            if (Intrinsics.areEqual(str3, brVar2 != null ? brVar2.f446187a : null)) {
                                                                                final QQTransferCenterViewModel qQTransferCenterViewModel3 = QQTransferCenterViewModel.this;
                                                                                SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1$onFileSetUploadStatusChanged$1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(0);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function0
                                                                                    public final Unit invoke() {
                                                                                        QQTransferCenterViewModel.this.fileSetUploadStatus.setValue(Integer.valueOf(brVar.f446202p));
                                                                                        QQTransferCenterViewModel.access$updateFileSetUploadStatusContent(QQTransferCenterViewModel.this);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                            }
                                                                        }

                                                                        @Override // ws3.dp
                                                                        public final void onFileStaticStatusChanged(ab abVar) {
                                                                            SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1$onFileStaticStatusChanged$1
                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                public final /* bridge */ /* synthetic */ Unit invoke() {
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                        }

                                                                        @Override // ws3.dp
                                                                        public final void onFileDidFinishUpload(ab abVar) {
                                                                        }

                                                                        @Override // ws3.dp
                                                                        public final void onFileDidStartUpload(ab abVar) {
                                                                        }

                                                                        @Override // ws3.dp
                                                                        public final void onFileUploadDidCancel(ab abVar) {
                                                                        }

                                                                        @Override // ws3.dp
                                                                        public final void onFileUploadDidError(ab abVar) {
                                                                        }

                                                                        @Override // ws3.dp
                                                                        public final void onFileUploadStatusChanged(ab abVar) {
                                                                        }

                                                                        @Override // ws3.dp
                                                                        public final void onThumbnailGeneratePath() {
                                                                        }

                                                                        @Override // ws3.dp
                                                                        /* renamed from: onFileUploadProgressChanged-ZFynlJw, reason: not valid java name */
                                                                        public final void mo121onFileUploadProgressChangedZFynlJw(ab abVar, long j16, long j17) {
                                                                        }
                                                                    };
                                                                    qQTransferCenterViewModel2.uploadStatusListener = r36;
                                                                    IKernelFlashTransferService.f344757i.a().b(r36);
                                                                }
                                                                IKernelFlashTransferService a16 = IKernelFlashTransferService.f344757i.a();
                                                                final dg dgVar = new dg() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$createUploadTask$2
                                                                    @Override // ws3.dg
                                                                    public final void onCreateFlashTransferUploadTask(final String str3, final int i16, final String str4) {
                                                                        final QQTransferCenterViewModel qQTransferCenterViewModel3 = QQTransferCenterViewModel.this;
                                                                        final r rVar2 = rVar;
                                                                        final List<es> list = arrayList;
                                                                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$createUploadTask$2$onCreateFlashTransferUploadTask$1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(0);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public final Unit invoke() {
                                                                                KLog kLog2 = KLog.INSTANCE;
                                                                                String str5 = QQTransferCenterViewModel.this.kTag;
                                                                                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onCreateFlashTransferUploadTask fileSetId:");
                                                                                m17.append(str3);
                                                                                m17.append(", result:");
                                                                                m17.append(i16);
                                                                                m17.append(", errMsg:");
                                                                                NBPFeedCommentsViewModel$$ExternalSyntheticOutline0.m(m17, str4, kLog2, str5);
                                                                                if (i16 == 0) {
                                                                                    QQTransferCenterViewModel qQTransferCenterViewModel4 = QQTransferCenterViewModel.this;
                                                                                    br brVar = new br();
                                                                                    String str6 = str3;
                                                                                    r rVar3 = rVar2;
                                                                                    List<es> list2 = list;
                                                                                    brVar.f446187a = str6;
                                                                                    brVar.f446188b = rVar3.f446389b;
                                                                                    eg egVar = brVar.f446191e;
                                                                                    StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("file://");
                                                                                    m18.append(rVar3.f446392e);
                                                                                    egVar.f446334c = m18.toString();
                                                                                    brVar.f446192f = list2;
                                                                                    qQTransferCenterViewModel4.uploadedFileSet = brVar;
                                                                                    final QQTransferCenterViewModel qQTransferCenterViewModel5 = QQTransferCenterViewModel.this;
                                                                                    String str7 = str3;
                                                                                    qQTransferCenterViewModel5.getClass();
                                                                                    IKernelFlashTransferService.f344757i.a().e(str7, new dn() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$getShareLinkContent$1
                                                                                        @Override // ws3.dn
                                                                                        /* renamed from: onGetShareLink-32etgaw, reason: not valid java name */
                                                                                        public final void mo122onGetShareLink32etgaw(final String str8, final long j16, final int i17, final String str9) {
                                                                                            final QQTransferCenterViewModel qQTransferCenterViewModel6 = QQTransferCenterViewModel.this;
                                                                                            SchedulerKt.c(new Function0<Unit>(i17, str9, j16, qQTransferCenterViewModel6, str8) { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$getShareLinkContent$1$onGetShareLink$1
                                                                                                public final /* synthetic */ String $errMsg;
                                                                                                public final /* synthetic */ int $result;
                                                                                                public final /* synthetic */ String $shareLink;
                                                                                                public final /* synthetic */ QQTransferCenterViewModel this$0;

                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(0);
                                                                                                    this.this$0 = qQTransferCenterViewModel6;
                                                                                                    this.$shareLink = str8;
                                                                                                }

                                                                                                /* JADX WARN: Code restructure failed: missing block: B:14:0x0042, code lost:
                                                                                                
                                                                                                    if (r0 != null) goto L14;
                                                                                                 */
                                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                                /*
                                                                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                                                                */
                                                                                                public final Unit invoke() {
                                                                                                    String str10;
                                                                                                    String str11;
                                                                                                    List<es> list3;
                                                                                                    Object firstOrNull;
                                                                                                    if (this.$result != 0) {
                                                                                                        ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast(this.$errMsg, QToastMode.Warning);
                                                                                                    } else {
                                                                                                        long serverTimeMillis = Utils.INSTANCE.currentBridgeModule().serverTimeMillis() / 1000;
                                                                                                        br brVar2 = this.this$0.uploadedFileSet;
                                                                                                        String str12 = "";
                                                                                                        if (brVar2 != null && (list3 = brVar2.f446192f) != null) {
                                                                                                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list3);
                                                                                                            es esVar3 = (es) firstOrNull;
                                                                                                            if (esVar3 != null) {
                                                                                                                str10 = esVar3.f446362b;
                                                                                                            }
                                                                                                        }
                                                                                                        str10 = "";
                                                                                                        br brVar3 = this.this$0.uploadedFileSet;
                                                                                                        if (brVar3 != null && (str11 = brVar3.f446188b) != null) {
                                                                                                            str12 = str11;
                                                                                                        }
                                                                                                        String m19 = QUISkinImage$$ExternalSyntheticOutline0.m(str10, "\u901a\u8fc7QQ\u95ea\u4f20\u5206\u4eab\u4e86\u3010", str12, "\u3011\u94fe\u63a5\uff1a");
                                                                                                        final String str13 = this.$shareLink;
                                                                                                        a.C0144a c0144a = new a.C0144a(0, 1, null);
                                                                                                        int e16 = c0144a.e(new j(QUIToken.color$default("text_secondary"), null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32766, null));
                                                                                                        try {
                                                                                                            c0144a.a(m19);
                                                                                                            Unit unit = Unit.INSTANCE;
                                                                                                            c0144a.c(e16);
                                                                                                            e16 = c0144a.e(new j(QUIToken.color$default("text_link"), null, null, null, null, null, null, null, null, null, null, null, null, null, new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$getShareLinkContent$1$onGetShareLink$1$content$1$2
                                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                {
                                                                                                                    super(1);
                                                                                                                }

                                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                                public final Unit invoke(ClickParams clickParams2) {
                                                                                                                    MqqUi.openUrl$default(Mqq.INSTANCE.getUi(), str13);
                                                                                                                    return Unit.INSTANCE;
                                                                                                                }
                                                                                                            }, 16382, null));
                                                                                                            try {
                                                                                                                c0144a.a(str13);
                                                                                                                c0144a.c(e16);
                                                                                                                this.this$0.uploadShareLinkContent.setValue(c0144a.f());
                                                                                                            } finally {
                                                                                                            }
                                                                                                        } finally {
                                                                                                        }
                                                                                                    }
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                        }
                                                                                    });
                                                                                    QQTransferCenterViewModel.this.shouldShowShareView.setValue(Boolean.TRUE);
                                                                                } else {
                                                                                    QQTransferCenterViewModel qQTransferCenterViewModel6 = QQTransferCenterViewModel.this;
                                                                                    QQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1 qQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1 = qQTransferCenterViewModel6.uploadStatusListener;
                                                                                    if (qQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1 != null) {
                                                                                        qQTransferCenterViewModel6.uploadStatusListener = null;
                                                                                        IKernelFlashTransferService.f344757i.a().k(qQTransferCenterViewModel$addFileSetUploadListener$uploadListener$1);
                                                                                    }
                                                                                    ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast(str4, QToastMode.Warning);
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                    }
                                                                };
                                                                a16.getClass();
                                                                ArrayList arrayList2 = new ArrayList();
                                                                arrayList2.add(0);
                                                                Object[] a17 = u.a(rVar);
                                                                arrayList2.add(Integer.valueOf(a17.length));
                                                                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, a17);
                                                                arrayList2.add(String.valueOf(dgVar.hashCode()));
                                                                Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$createFlashTransferUploadTask$kernelCallback$1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(Object obj2) {
                                                                        Object[] objArr = obj2 instanceof Object[] ? (Object[]) obj2 : null;
                                                                        if (objArr != null) {
                                                                            if (!(objArr.length == 0)) {
                                                                                Iterator it = ArrayIteratorKt.iterator(objArr);
                                                                                if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onCreateFlashTransferUploadTask")) {
                                                                                    Object next = it.next();
                                                                                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                                                                                    ((Integer) next).intValue();
                                                                                    Object next2 = it.next();
                                                                                    Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                                                                                    Object next3 = it.next();
                                                                                    Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                                                                    int intValue3 = ((Integer) next3).intValue();
                                                                                    Object next4 = it.next();
                                                                                    Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                                                                                    dg.this.onCreateFlashTransferUploadTask((String) next2, intValue3, (String) next4);
                                                                                }
                                                                            }
                                                                        }
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
                                                                Object[] array = arrayList2.toArray(new Object[0]);
                                                                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                                a16.syncToNativeMethod(true, "createFlashTransferUploadTask", array, function1);
                                                            }
                                                        }
                                                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$createUploadTask$1
                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast(MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR, QToastMode.Warning);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    } else if (j3 != -2) {
                                                        SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQTransferCenterViewModel$showNativeFileSelector$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Unit invoke() {
                                                                ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast(p16, QToastMode.Warning);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    }
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }, false);
                                        return Unit.INSTANCE;
                                    }
                                }, null, null, composer5, 3080, 214);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 25032, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 24584, 12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity$fullScreenEmptyView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQTransferCenterActivity.this.fullScreenEmptyView(composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    public final void historyView(final QQTransferCenterViewModel qQTransferCenterViewModel, final com.tencent.ntcompose.foundation.lazy.a aVar, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(-473738833);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-473738833, i3, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity.historyView (QQTransferCenterActivity.kt:179)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.h(i.INSTANCE, 0.0f, 1, null), null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -538533707, true, new Function3<com.tencent.ntcompose.foundation.layout.b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity$historyView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(com.tencent.ntcompose.foundation.layout.b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-538533707, intValue, -1, "com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity.historyView.<anonymous> (QQTransferCenterActivity.kt:182)");
                    }
                    float f16 = QQTransferCenterViewModel.this.getFilterCardVM().listGridMode.getValue().booleanValue() ? QQFTCenterUIConfig.insetLeft : 0.0f;
                    com.tencent.ntcompose.ui.platform.a aVar2 = (com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d());
                    ComposeFeedListViewModel composeFeedListViewModel = QQTransferCenterViewModel.this.feedListViewModel;
                    i f17 = ComposeLayoutPropUpdaterKt.f(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, aVar2.e()), 0.0f, 1, null);
                    r.a aVar3 = new r.a(2);
                    float e16 = aVar2.e();
                    float d16 = aVar2.d() * 2;
                    l c16 = com.tencent.ntcompose.foundation.layout.k.c(f16, 0.0f, f16, 80.0f, 2, null);
                    float f18 = QQFTCenterUIConfig.columnSpacing;
                    float f19 = QQTransferCenterViewModel.this.getFilterCardVM().listGridMode.getValue().booleanValue() ? QQFTCenterUIConfig.lineSpacing : 0.0f;
                    GridLayoutMode gridLayoutMode = GridLayoutMode.PLAIN;
                    com.tencent.ntcompose.foundation.lazy.a aVar4 = aVar;
                    Boolean bool = Boolean.TRUE;
                    composeFeedListViewModel.buildLazyVerticalGrid(aVar3, f17, e16, aVar4, c16, f18, f19, bool, null, null, bool, null, gridLayoutMode, 10, Float.valueOf(d16), null, null, null, null, null, ComposableSingletons$QQTransferCenterActivityKt.f156lambda1, composer3, ((i3 << 6) & 7168) | 12779584, 3462, 70, 1018624);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3080, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.views.center.QQTransferCenterActivity$historyView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                QQTransferCenterActivity.this.historyView(qQTransferCenterViewModel, aVar, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }
}
