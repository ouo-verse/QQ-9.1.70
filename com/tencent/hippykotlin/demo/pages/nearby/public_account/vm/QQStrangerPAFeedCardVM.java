package com.tencent.hippykotlin.demo.pages.nearby.public_account.vm;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.HomepageSource;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.BDHService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedLikeRepo$strangerFeedLikeRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedLikeRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyFormatUtils;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.public_account.view.QQStrangerPAFeedCardViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import m25.c;
import n35.v;
import n35.w;
import n35.z;
import p35.ac;
import p35.ag;
import p35.n;
import s35.af;
import yo3.Size;

/* loaded from: classes31.dex */
public final class QQStrangerPAFeedCardVM extends QQStrangerPACardVM {
    public final n feedCard;
    public final MutableState<Boolean> isLike;
    public final MutableState<String> likeCount;
    public int likeCountInt;

    public QQStrangerPAFeedCardVM(n nVar, QQStrangerPublicAccountViewModel qQStrangerPublicAccountViewModel) {
        super(qQStrangerPublicAccountViewModel);
        MutableState<Boolean> mutableStateOf$default;
        MutableState<String> mutableStateOf$default2;
        ac acVar;
        ac acVar2;
        this.feedCard = nVar;
        int i3 = 0;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf((nVar == null || (acVar2 = nVar.E) == null || acVar2.f425122h != 1) ? false : true), null, 2, null);
        this.isLike = mutableStateOf$default;
        NearbyFormatUtils nearbyFormatUtils = NearbyFormatUtils.INSTANCE;
        if (nVar != null && (acVar = nVar.E) != null) {
            i3 = acVar.f425120e;
        }
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(nearbyFormatUtils.formatPALikeCount(i3), null, 2, null);
        this.likeCount = mutableStateOf$default2;
        this.likeCountInt = -1;
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(364464798, true, new Function5<a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAFeedCardVM.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(5);
            }

            /* JADX WARN: Code restructure failed: missing block: B:13:0x005d, code lost:
            
                r1 = kotlin.text.StringsKt__StringsJVMKt.decodeToString(r1);
             */
            @Override // kotlin.jvm.functions.Function5
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(a aVar, BaseComposeCardViewModel baseComposeCardViewModel, Integer num, Composer composer, Integer num2) {
                String str;
                String str2;
                af afVar;
                af afVar2;
                c45.a aVar2;
                String decodeToString;
                num.intValue();
                Composer composer2 = composer;
                int intValue = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(364464798, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAFeedCardVM.<anonymous> (QQStrangerPAFeedCardVM.kt:80)");
                }
                Size size = new Size(QQStrangerPAFeedCardVM.this.getFeedCardWidth(), QQStrangerPAFeedCardVM.this.getFeedCardWidth() / 0.75f);
                Object access$getCoverUrl = QQStrangerPAFeedCardVM.access$getCoverUrl(QQStrangerPAFeedCardVM.this);
                Object obj = access$getCoverUrl == null ? "" : access$getCoverUrl;
                n nVar2 = QQStrangerPAFeedCardVM.this.feedCard;
                String str3 = (nVar2 == null || (aVar2 = nVar2.f425197i) == null || (r1 = aVar2.f30291a) == null || decodeToString == null) ? "" : decodeToString;
                final QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM = QQStrangerPAFeedCardVM.this;
                n nVar3 = qQStrangerPAFeedCardVM.feedCard;
                if (nVar3 == null || (afVar2 = nVar3.f425194e) == null || (str = afVar2.f433209f) == null) {
                    str = "";
                }
                if (nVar3 == null || (afVar = nVar3.f425194e) == null || (str2 = afVar.E) == null) {
                    str2 = "";
                }
                QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM2 = this;
                composer2.startReplaceableGroup(1157296644);
                boolean changed = composer2.changed(qQStrangerPAFeedCardVM);
                Object rememberedValue = composer2.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0<Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAFeedCardVM$1$1$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return QQStrangerPAFeedCardVM.this.isLike.getValue();
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue);
                }
                composer2.endReplaceableGroup();
                Function0 function0 = (Function0) rememberedValue;
                final QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM3 = QQStrangerPAFeedCardVM.this;
                composer2.startReplaceableGroup(1157296644);
                boolean changed2 = composer2.changed(qQStrangerPAFeedCardVM3);
                Object rememberedValue2 = composer2.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAFeedCardVM$1$2$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return QQStrangerPAFeedCardVM.this.likeCount.getValue();
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                composer2.endReplaceableGroup();
                Function0 function02 = (Function0) rememberedValue2;
                final QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM4 = QQStrangerPAFeedCardVM.this;
                composer2.startReplaceableGroup(1157296644);
                boolean changed3 = composer2.changed(qQStrangerPAFeedCardVM4);
                Object rememberedValue3 = composer2.rememberedValue();
                if (changed3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAFeedCardVM$1$3$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            final QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM5 = QQStrangerPAFeedCardVM.this;
                            qQStrangerPAFeedCardVM5.getClass();
                            qQStrangerPAFeedCardVM5.callbackIsNotVisitor(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAFeedCardVM$onFeedCardClick$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    byte[] bArr;
                                    String str4;
                                    c45.a aVar3;
                                    String str5;
                                    QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM6 = QQStrangerPAFeedCardVM.this;
                                    n nVar4 = qQStrangerPAFeedCardVM6.feedCard;
                                    String str6 = "";
                                    String str7 = (nVar4 == null || (str5 = nVar4.f425193d) == null) ? "" : str5;
                                    UserDataManager userDataManager = UserDataManager.INSTANCE;
                                    c cVar = qQStrangerPAFeedCardVM6.mainVM.repo.cardListCommonExt;
                                    if (cVar == null || (aVar3 = cVar.f416055e) == null || (bArr = aVar3.f30291a) == null) {
                                        bArr = new byte[0];
                                    }
                                    userDataManager.setSig(bArr);
                                    Object access$getCoverUrl2 = QQStrangerPAFeedCardVM.access$getCoverUrl(QQStrangerPAFeedCardVM.this);
                                    if (access$getCoverUrl2 instanceof v) {
                                        String urlFromCache = BDHService.INSTANCE.getUrlFromCache((v) access$getCoverUrl2);
                                        if (urlFromCache != null) {
                                            str4 = urlFromCache;
                                            NBPJumpUtil.jumpArticleFeedDetailPage$default(QQStrangerPAFeedCardVM.access$getPosterId(QQStrangerPAFeedCardVM.this), str7, QQStrangerPAFeedCardVM.this.mainVM.getUserSelfInfo(), 16, QQStrangerPAFeedCardVM.this.feedCard, str4, null, 64);
                                            return Unit.INSTANCE;
                                        }
                                    } else if (access$getCoverUrl2 instanceof String) {
                                        str6 = (String) access$getCoverUrl2;
                                    }
                                    str4 = str6;
                                    NBPJumpUtil.jumpArticleFeedDetailPage$default(QQStrangerPAFeedCardVM.access$getPosterId(QQStrangerPAFeedCardVM.this), str7, QQStrangerPAFeedCardVM.this.mainVM.getUserSelfInfo(), 16, QQStrangerPAFeedCardVM.this.feedCard, str4, null, 64);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue3);
                }
                composer2.endReplaceableGroup();
                Function0 function03 = (Function0) rememberedValue3;
                final QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM5 = QQStrangerPAFeedCardVM.this;
                composer2.startReplaceableGroup(1157296644);
                boolean changed4 = composer2.changed(qQStrangerPAFeedCardVM5);
                Object rememberedValue4 = composer2.rememberedValue();
                if (changed4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAFeedCardVM$1$4$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            final QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM6 = QQStrangerPAFeedCardVM.this;
                            qQStrangerPAFeedCardVM6.getClass();
                            qQStrangerPAFeedCardVM6.callbackIsNotVisitor(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAFeedCardVM$onAvatarClick$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    NBPJumpUtil.jumpPersonaPage$default(QQStrangerPAFeedCardVM.this.mainVM.getAppId(), QQStrangerPAFeedCardVM.access$getPosterId(QQStrangerPAFeedCardVM.this), Intrinsics.areEqual(QQStrangerPAFeedCardVM.this.mainVM.getUserSelfInfo().accountId, QQStrangerPAFeedCardVM.access$getPosterId(QQStrangerPAFeedCardVM.this)), false, HomepageSource.QQSTRANGER_PUBLIC_ACCOUNT, null, 40);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue4);
                }
                composer2.endReplaceableGroup();
                Function0 function04 = (Function0) rememberedValue4;
                final QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM6 = QQStrangerPAFeedCardVM.this;
                composer2.startReplaceableGroup(1157296644);
                boolean changed5 = composer2.changed(qQStrangerPAFeedCardVM6);
                Object rememberedValue5 = composer2.rememberedValue();
                if (changed5 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAFeedCardVM$1$5$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            final QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM7 = QQStrangerPAFeedCardVM.this;
                            qQStrangerPAFeedCardVM7.getClass();
                            qQStrangerPAFeedCardVM7.callbackIsNotVisitor(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAFeedCardVM$onLikeIconClick$1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
                                /* JADX WARN: Removed duplicated region for block: B:34:0x0032  */
                                /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
                                @Override // kotlin.jvm.functions.Function0
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Unit invoke() {
                                    ac acVar3;
                                    String str4;
                                    ac acVar4;
                                    int i16;
                                    ac acVar5;
                                    ac acVar6;
                                    boolean z16 = !QQStrangerPAFeedCardVM.this.isLike.getValue().booleanValue();
                                    int i17 = 0;
                                    if (z16) {
                                        QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM8 = QQStrangerPAFeedCardVM.this;
                                        int i18 = qQStrangerPAFeedCardVM8.likeCountInt;
                                        if (i18 < 0) {
                                            n nVar4 = qQStrangerPAFeedCardVM8.feedCard;
                                            if (nVar4 != null && (acVar5 = nVar4.E) != null) {
                                                i18 = acVar5.f425120e;
                                            } else {
                                                i16 = 0;
                                                n nVar5 = qQStrangerPAFeedCardVM8.feedCard;
                                                acVar6 = nVar5 == null ? nVar5.E : null;
                                                if (acVar6 != null) {
                                                    acVar6.f425120e = i16;
                                                }
                                                qQStrangerPAFeedCardVM8.likeCount.setValue(NearbyFormatUtils.INSTANCE.formatPALikeCount(i16));
                                            }
                                        }
                                        i16 = i18 + 1;
                                        n nVar52 = qQStrangerPAFeedCardVM8.feedCard;
                                        if (nVar52 == null) {
                                        }
                                        if (acVar6 != null) {
                                        }
                                        qQStrangerPAFeedCardVM8.likeCount.setValue(NearbyFormatUtils.INSTANCE.formatPALikeCount(i16));
                                    } else {
                                        n nVar6 = QQStrangerPAFeedCardVM.this.feedCard;
                                        int max = Math.max(0, Math.max((nVar6 == null || (acVar3 = nVar6.E) == null) ? 0 : acVar3.f425120e - 1, r4.likeCountInt - 1));
                                        QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM9 = QQStrangerPAFeedCardVM.this;
                                        n nVar7 = qQStrangerPAFeedCardVM9.feedCard;
                                        ac acVar7 = nVar7 != null ? nVar7.E : null;
                                        if (acVar7 != null) {
                                            acVar7.f425120e = max;
                                        }
                                        qQStrangerPAFeedCardVM9.likeCount.setValue(NearbyFormatUtils.INSTANCE.formatPALikeCount(max));
                                    }
                                    QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM10 = QQStrangerPAFeedCardVM.this;
                                    n nVar8 = qQStrangerPAFeedCardVM10.feedCard;
                                    ac acVar8 = nVar8 != null ? nVar8.E : null;
                                    if (acVar8 != null) {
                                        acVar8.f425122h = z16 ? 1 : 0;
                                    }
                                    qQStrangerPAFeedCardVM10.isLike.setValue(Boolean.valueOf(z16));
                                    int appId = QQStrangerPAFeedCardVM.this.mainVM.getAppId();
                                    QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM11 = QQStrangerPAFeedCardVM.this;
                                    n nVar9 = qQStrangerPAFeedCardVM11.feedCard;
                                    if (nVar9 != null && (acVar4 = nVar9.E) != null) {
                                        i17 = acVar4.f425120e;
                                    }
                                    int i19 = i17;
                                    String str5 = (nVar9 == null || (str4 = nVar9.f425193d) == null) ? "" : str4;
                                    String str6 = qQStrangerPAFeedCardVM11.mainVM.getUserSelfInfo().accountId;
                                    CommonProxyService.INSTANCE.request(new StrangerFeedLikeRequest(appId, str5, z16 ? 1 : 0, str6 != null ? str6 : ""), new StrangerFeedLikeRepo$strangerFeedLikeRequest$1(null, z16, i19, str5, "QQStrangerPAFeedCardVM"));
                                    k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
                                    e eVar = new e();
                                    eVar.t("count", i19);
                                    eVar.v("feedId", str5);
                                    eVar.t("isLike", z16 ? 1 : 0);
                                    eVar.v("extInfo", "QQStrangerPAFeedCardVM");
                                    Unit unit = Unit.INSTANCE;
                                    k.d(kVar, "NearbyFeedLikeStatusChangedEvent", eVar, false, 4, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue5);
                }
                composer2.endReplaceableGroup();
                QQStrangerPAFeedCardViewKt.QQStrangerPAFeedCardView(qQStrangerPAFeedCardVM2, null, size, obj, str3, str2, str, function0, function02, function03, function04, (Function0) rememberedValue5, composer2, 4096, 0, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
        registerFeedLikeStatusChangeEvent();
    }

    public static final Object access$getCoverUrl(QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM) {
        List<ag> list;
        Object firstOrNull;
        List<ag> list2;
        Object firstOrNull2;
        w wVar;
        List<z> list3;
        Object firstOrNull3;
        Object firstOrNull4;
        List<ag> list4;
        Object firstOrNull5;
        String str;
        boolean z16 = false;
        if (qQStrangerPAFeedCardVM.mainVM.getAppId() == 2) {
            n nVar = qQStrangerPAFeedCardVM.feedCard;
            if (nVar != null && (list4 = nVar.f425198m) != null) {
                firstOrNull5 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list4);
                ag agVar = (ag) firstOrNull5;
                if (agVar != null && (str = agVar.f425140e) != null) {
                    if (str.length() > 0) {
                        z16 = true;
                    }
                }
            }
            if (z16) {
                firstOrNull4 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) qQStrangerPAFeedCardVM.feedCard.f425198m);
                ag agVar2 = (ag) firstOrNull4;
                if (agVar2 != null) {
                    return agVar2.f425140e;
                }
            } else {
                n nVar2 = qQStrangerPAFeedCardVM.feedCard;
                if (nVar2 != null && (list2 = nVar2.f425198m) != null) {
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                    ag agVar3 = (ag) firstOrNull2;
                    if (agVar3 != null && (wVar = agVar3.f425139d) != null && (list3 = wVar.f418273d) != null) {
                        firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list3);
                        z zVar = (z) firstOrNull3;
                        if (zVar != null) {
                            return zVar.f418280d;
                        }
                    }
                }
            }
        } else {
            n nVar3 = qQStrangerPAFeedCardVM.feedCard;
            if (nVar3 != null && (list = nVar3.f425198m) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                ag agVar4 = (ag) firstOrNull;
                if (agVar4 != null) {
                    return agVar4.f425140e;
                }
            }
        }
        return null;
    }

    public static final String access$getPosterId(QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM) {
        af afVar;
        af afVar2;
        Object obj = null;
        if (qQStrangerPAFeedCardVM.mainVM.getAppId() == 2) {
            n nVar = qQStrangerPAFeedCardVM.feedCard;
            if (nVar != null && (afVar2 = nVar.f425194e) != null) {
                obj = Long.valueOf(afVar2.f433207e);
            }
        } else {
            n nVar2 = qQStrangerPAFeedCardVM.feedCard;
            if (nVar2 != null && (afVar = nVar2.f425194e) != null) {
                obj = afVar.f433205d;
            }
        }
        return String.valueOf(obj);
    }

    public final float getFeedCardWidth() {
        float f16 = 2;
        return ((GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(com.tencent.kuikly.core.manager.c.f117352a) - (f16 * 6.0f)) - 6.0f) / f16;
    }

    public final void registerFeedLikeStatusChangeEvent() {
        k.b((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "NearbyFeedLikeStatusChangedEvent", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.public_account.vm.QQStrangerPAFeedCardVM$registerFeedLikeStatusChangeEvent$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                if (eVar2 != null) {
                    n nVar = QQStrangerPAFeedCardVM.this.feedCard;
                    if (Intrinsics.areEqual(nVar != null ? nVar.f425193d : null, eVar2.p("feedId"))) {
                        AdelieAudioRecordFrequencyView$endRecording$1$$ExternalSyntheticOutline0.m("registerLikeEvent received like status changed notify with data: ", eVar2, KLog.INSTANCE, "QQStrangerPAFeedCardVM");
                        QQStrangerPAFeedCardVM.this.likeCountInt = eVar2.k("count", 0);
                        QQStrangerPAFeedCardVM qQStrangerPAFeedCardVM = QQStrangerPAFeedCardVM.this;
                        qQStrangerPAFeedCardVM.likeCount.setValue(NearbyFormatUtils.INSTANCE.formatPALikeCount(qQStrangerPAFeedCardVM.likeCountInt));
                        QQStrangerPAFeedCardVM.this.isLike.setValue(Boolean.valueOf(eVar2.k("isLike", 0) == 1));
                    }
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
    }
}
