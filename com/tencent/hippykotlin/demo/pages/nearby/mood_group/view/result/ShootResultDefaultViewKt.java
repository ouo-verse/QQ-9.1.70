package com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.data.NBPMoodGroupConfig;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultPageState;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.ntcompose.animation.AnimateAsStateKt;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.event.ViewEventPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.BoxKt;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;
import com.tencent.ntcompose.foundation.layout.RowKt;
import com.tencent.ntcompose.foundation.layout.b;
import com.tencent.ntcompose.foundation.layout.base.Alignment;
import com.tencent.ntcompose.foundation.layout.base.a;
import com.tencent.ntcompose.foundation.layout.n;
import com.tencent.ntcompose.material.APNGKt;
import com.tencent.ntcompose.material.ImageKt;
import com.tencent.ntcompose.material.base.ModifiersKt;
import com.tencent.ntcompose.material.c;
import com.tencent.ntcompose.material.h;
import com.tencent.ntcompose.ui.platform.CompositionLocalsKt;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ShootResultDefaultViewKt {
    public static final void RichTextExample(final List<String> list, final String str, Composer composer, final int i3) {
        Composer startRestartGroup = composer.startRestartGroup(1066742086);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1066742086, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.RichTextExample (ShootResultDefaultView.kt:122)");
        }
        BoxKt.a(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 100.0f), 48.0f), 0.0f, 8.0f, 0.0f, 0.0f, 13, null), Alignment.TopStart, null, ComposableLambdaKt.composableLambda(startRestartGroup, 84798924, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$RichTextExample$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(84798924, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.RichTextExample.<anonymous> (ShootResultDefaultView.kt:127)");
                    }
                    i.Companion companion = i.INSTANCE;
                    ImageKt.a(str, null, null, null, null, ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 86.0f), 35.0f), -4.0f, 8.0f, 0.0f, 0.0f, 12, null), c.b(c.INSTANCE.a()), h.INSTANCE.c(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer3, ((i3 >> 3) & 14) | 12845056, 0, 0, 2096926);
                    i s16 = ComposeLayoutPropUpdaterKt.s(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 18.0f), 14.0f), 27.0f, 9.0f, 0.0f, 0.0f, 12, null);
                    a.d c16 = a.f339245a.c();
                    Alignment.Vertical f16 = Alignment.INSTANCE.f();
                    final List<String> list2 = list;
                    RowKt.a(s16, c16, f16, null, null, ComposableLambdaKt.composableLambda(composer3, -1092026898, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$RichTextExample$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1092026898, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.RichTextExample.<anonymous>.<anonymous> (ShootResultDefaultView.kt:143)");
                                }
                                Iterator<String> it = list2.iterator();
                                while (it.hasNext()) {
                                    ImageKt.a(it.next(), null, null, null, null, ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, 9.0f), 13.0f), null, h.INSTANCE.c(), null, null, null, null, null, null, null, null, null, null, null, null, null, composer5, 12845056, 0, 0, 2096990);
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196680, 24);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3128, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$RichTextExample$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Composer composer2, Integer num) {
                num.intValue();
                ShootResultDefaultViewKt.RichTextExample(list, str, composer2, i3 | 1);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f4, code lost:
    
        if ((r2 == null || r2.length() == 0) != false) goto L77;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x007e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ShootResultDefaultView(final NBPShootResultViewModel nBPShootResultViewModel, Composer composer, final int i3) {
        T t16;
        NBPMoodGroupConfig resultConfig$qecommerce_biz_release;
        T t17;
        NBPMoodGroupConfig resultConfig$qecommerce_biz_release2;
        CharSequence charSequence;
        ScopeUpdateScope endRestartGroup;
        NBPMoodGroupConfig.ShootConfig shootConfig;
        List<NBPMoodGroupConfig.ShootEmojiItemConfig> list;
        Iterator<T> it;
        Object obj;
        NBPMoodGroupConfig.ShootEmojiItemConfig shootEmojiItemConfig;
        NBPMoodGroupConfig.ShootConfig shootConfig2;
        List<NBPMoodGroupConfig.ShootEmojiItemConfig> list2;
        Iterator<T> it5;
        Object obj2;
        NBPMoodGroupConfig.ShootEmojiItemConfig shootEmojiItemConfig2;
        NBPMoodGroupConfig.ShootConfig shootConfig3;
        List<NBPMoodGroupConfig.ShootEmojiItemConfig> list3;
        Object obj3;
        Composer startRestartGroup = composer.startRestartGroup(-1381158144);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1381158144, i3, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultView (ShootResultDefaultView.kt:34)");
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        NBPMoodGroupConfig resultConfig$qecommerce_biz_release3 = nBPShootResultViewModel.getResultConfig$qecommerce_biz_release();
        T t18 = 0;
        t18 = 0;
        t18 = 0;
        t18 = 0;
        if (resultConfig$qecommerce_biz_release3 != null && (shootConfig3 = resultConfig$qecommerce_biz_release3.shootConfig) != null && (list3 = shootConfig3.emojis) != null) {
            Iterator<T> it6 = list3.iterator();
            while (true) {
                if (!it6.hasNext()) {
                    obj3 = null;
                    break;
                } else {
                    obj3 = it6.next();
                    if (Intrinsics.areEqual(((NBPMoodGroupConfig.ShootEmojiItemConfig) obj3).emojiId, nBPShootResultViewModel.emojiId)) {
                        break;
                    }
                }
            }
            NBPMoodGroupConfig.ShootEmojiItemConfig shootEmojiItemConfig3 = (NBPMoodGroupConfig.ShootEmojiItemConfig) obj3;
            if (shootEmojiItemConfig3 != null) {
                t16 = shootEmojiItemConfig3.bottomPNG;
                objectRef.element = t16;
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                resultConfig$qecommerce_biz_release = nBPShootResultViewModel.getResultConfig$qecommerce_biz_release();
                if (resultConfig$qecommerce_biz_release != null && (shootConfig2 = resultConfig$qecommerce_biz_release.shootConfig) != null && (list2 = shootConfig2.emojis) != null) {
                    it5 = list2.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            obj2 = null;
                            break;
                        } else {
                            obj2 = it5.next();
                            if (Intrinsics.areEqual(((NBPMoodGroupConfig.ShootEmojiItemConfig) obj2).emojiId, nBPShootResultViewModel.emojiId)) {
                                break;
                            }
                        }
                    }
                    shootEmojiItemConfig2 = (NBPMoodGroupConfig.ShootEmojiItemConfig) obj2;
                    if (shootEmojiItemConfig2 != null) {
                        t17 = shootEmojiItemConfig2.emojiUrl;
                        objectRef2.element = t17;
                        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                        resultConfig$qecommerce_biz_release2 = nBPShootResultViewModel.getResultConfig$qecommerce_biz_release();
                        if (resultConfig$qecommerce_biz_release2 != null && (shootConfig = resultConfig$qecommerce_biz_release2.shootConfig) != null && (list = shootConfig.emojis) != null) {
                            it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    obj = null;
                                    break;
                                } else {
                                    obj = it.next();
                                    if (Intrinsics.areEqual(((NBPMoodGroupConfig.ShootEmojiItemConfig) obj).emojiId, nBPShootResultViewModel.emojiId)) {
                                        break;
                                    }
                                }
                            }
                            shootEmojiItemConfig = (NBPMoodGroupConfig.ShootEmojiItemConfig) obj;
                            if (shootEmojiItemConfig != null) {
                                t18 = shootEmojiItemConfig.captionImageUrl;
                            }
                        }
                        objectRef3.element = t18;
                        charSequence = (CharSequence) objectRef.element;
                        if (!(charSequence != null || charSequence.length() == 0)) {
                            CharSequence charSequence2 = (CharSequence) objectRef2.element;
                            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                                CharSequence charSequence3 = (CharSequence) objectRef3.element;
                            }
                        }
                        objectRef.element = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_GGSjnoIKBwj.png";
                        objectRef2.element = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_fKfRR1Vk26r.png";
                        objectRef3.element = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_2yE6eKA6C27.png";
                        BoxKt.a(ViewEventPropUpdaterKt.q(ModifiersKt.T(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e() + 20.0f), 300.0f), -10.0f, -10.0f, -10.0f, 0.0f, 8, null), 7), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$1
                            {
                                super(1);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
                            
                                if (r4 != 3) goto L16;
                             */
                            /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<k35.n>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<k35.n>, java.util.ArrayList] */
                            /* JADX WARN: Type inference failed for: r15v6, types: [java.util.List<k35.n>, java.util.ArrayList] */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(Object obj4) {
                                int i16;
                                final NBPShootResultViewModel nBPShootResultViewModel2 = NBPShootResultViewModel.this;
                                if (!nBPShootResultViewModel2.isResultViewPopable) {
                                    KLog kLog = KLog.INSTANCE;
                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("is Shooting, pop-ups are not allowed. Pending pop-up size\uff1a");
                                    m3.append(nBPShootResultViewModel2.shootRspList.size());
                                    kLog.i("NBPShootResultPage", m3.toString());
                                } else if (!nBPShootResultViewModel2.shootRspList.isEmpty()) {
                                    k35.n nVar = (k35.n) nBPShootResultViewModel2.shootRspList.remove(0);
                                    int size = nVar.f411571f.size();
                                    if (size != 0) {
                                        if (size != 1 && size != 2) {
                                            i16 = 3;
                                        }
                                        i16 = 2;
                                    } else {
                                        i16 = 1;
                                    }
                                    int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(i16);
                                    if (ordinal == 0) {
                                        nBPShootResultViewModel2.setNeedToBlur(true);
                                        nBPShootResultViewModel2.resultViewState.setValue(NBPShootResultPageState.NULL);
                                        TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel$handleResultPopView$1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPShootResultViewModel.this.resultViewState.setValue(NBPShootResultPageState.SHARE_SUCCESS);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    } else if (ordinal != 1) {
                                        KLog kLog2 = KLog.INSTANCE;
                                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("result rsp user num error. size: ");
                                        m16.append(nVar.f411571f.size());
                                        kLog2.i("NBPShootResultPage", m16.toString());
                                    } else {
                                        String a16 = ((com.tencent.kuikly.core.module.b) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRCalendarModule")).a(APICallTechReporterKt.NBPCurrentTime(), TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
                                        Utils utils = Utils.INSTANCE;
                                        String item = utils.cacheModule("").getItem("lastPopupDate");
                                        String str = a16 + util.base64_pad_url + UserDataManager.INSTANCE.getUserSelfInfo().tid;
                                        Integer num = utils.cacheModule("").getInt("matchPageCount");
                                        nBPShootResultViewModel2.matchViewCount = num != null ? num.intValue() : 0;
                                        if (!Intrinsics.areEqual(item, str)) {
                                            utils.cacheModule("").setItem("lastPopupDate", str);
                                            utils.cacheModule("").setInt("matchPageCount", 0);
                                            nBPShootResultViewModel2.matchViewCount = 0;
                                        }
                                        nBPShootResultViewModel2.matchViewCount++;
                                        DatalineDetailViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("matchViewPopUpCount: "), nBPShootResultViewModel2.matchViewCount, KLog.INSTANCE, "NBPShootResultPage");
                                        utils.cacheModule("").setInt("matchPageCount", Integer.valueOf(nBPShootResultViewModel2.matchViewCount));
                                        nBPShootResultViewModel2.readyToShowThemeMapGuide = nBPShootResultViewModel2.matchViewCount == 2;
                                        nBPShootResultViewModel2.setNeedToBlur(true);
                                        nBPShootResultViewModel2.matchResult = nVar.f411571f;
                                        nBPShootResultViewModel2.resultViewState.setValue(NBPShootResultPageState.NULL);
                                        TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel$handleResultPopView$2
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPShootResultViewModel.this.resultViewState.setValue(NBPShootResultPageState.MATCH_SUCCESS);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    }
                                }
                                final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                                TimerKt.d(1400, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPShootResultViewModel.this.enterAnimPlayed$delegate.setValue(Boolean.FALSE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPShootResultViewModel nBPShootResultViewModel4 = NBPShootResultViewModel.this;
                                TimerKt.d(FSUploadConst.ERR_FILE_NOT_EXIST, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$1.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        MutableState mutableState = NBPShootResultViewModel.this.hasEntranceAnimationFinished$delegate;
                                        Boolean bool = Boolean.FALSE;
                                        mutableState.setValue(bool);
                                        NBPShootResultViewModel.this.showDefaultResult.setValue(bool);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }), Alignment.TopCenter, null, ComposableLambdaKt.composableLambda(startRestartGroup, 276911750, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                                Composer composer3 = composer2;
                                int intValue = num.intValue();
                                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                } else {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(276911750, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultView.<anonymous> (ShootResultDefaultView.kt:61)");
                                    }
                                    State<Float> c16 = AnimateAsStateKt.c(!NBPShootResultViewModel.this.getEnterAnimPlayed() ? 0.0f : 1.0f, com.tencent.ntcompose.animation.b.d(300, 0, com.tencent.ntcompose.animation.i.d(), null, 10, null), null, composer3, 0, 4);
                                    final NBPShootResultViewModel nBPShootResultViewModel2 = NBPShootResultViewModel.this;
                                    EffectsKt.SideEffect(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$2.1
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Multi-variable type inference failed */
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            if (!NBPShootResultViewModel.this.getEnterAnimPlayed() && !((Boolean) NBPShootResultViewModel.this.hasEntranceAnimationFinished$delegate.getValue()).booleanValue()) {
                                                NBPShootResultViewModel.this.enterAnimPlayed$delegate.setValue(Boolean.TRUE);
                                                final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                                                TimerKt.d(300, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt.ShootResultDefaultView.2.1.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Unit invoke() {
                                                        NBPShootResultViewModel.this.hasEntranceAnimationFinished$delegate.setValue(Boolean.TRUE);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }, composer3, 0);
                                    i.Companion companion = i.INSTANCE;
                                    BoxKt.a(ModifiersKt.b(ModifiersKt.L(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 156.0f), 48.0f), 0.0f, ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).i() + 20.0f, 0.0f, 0.0f, 13, null), new com.tencent.kuikly.core.base.h(3439329279L)), 24.0f), 0.0f, 2.0f, 16.0f, new com.tencent.kuikly.core.base.h(335544320L)), c16.getValue().floatValue()), null, null, null, composer3, 8, 14);
                                    composer3.startReplaceableGroup(1616578891);
                                    if (((Boolean) NBPShootResultViewModel.this.hasEntranceAnimationFinished$delegate.getValue()).booleanValue()) {
                                        APNGKt.a(ComposeLayoutPropUpdaterKt.n(ModifiersKt.J(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 190.0f), 70.0f), 1.2f, null, 2, null), 0.0f, ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).i() + 10.0f, 0.0f, 0.0f, 13, null), null, objectRef.element, 1, null, null, null, null, composer3, 3080, 242);
                                    }
                                    composer3.endReplaceableGroup();
                                    i b16 = ModifiersKt.b(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 156.0f), 68.0f), 0.0f, ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).i() + 10.0f, 0.0f, 0.0f, 13, null), com.tencent.kuikly.core.base.h.INSTANCE.j()), c16.getValue().floatValue());
                                    a.d g16 = a.f339245a.g();
                                    Alignment.Vertical f16 = Alignment.INSTANCE.f();
                                    final Ref.ObjectRef<String> objectRef4 = objectRef2;
                                    final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                                    final Ref.ObjectRef<String> objectRef5 = objectRef3;
                                    RowKt.a(b16, g16, f16, null, null, ComposableLambdaKt.composableLambda(composer3, -1213512792, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        @Override // kotlin.jvm.functions.Function3
                                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                            Composer composer5 = composer4;
                                            int intValue2 = num2.intValue();
                                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                                composer5.skipToGroupEnd();
                                            } else {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-1213512792, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultView.<anonymous>.<anonymous> (ShootResultDefaultView.kt:104)");
                                                }
                                                APNGKt.a(ComposeLayoutPropUpdaterKt.u(ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 16.0f, 0.0f, 0.0f, 30.0f, 6, null), 52.0f), null, objectRef4.element, 0, Boolean.TRUE, null, null, null, composer5, 27656, 226);
                                                ShootResultDefaultViewKt.RichTextExample(nBPShootResultViewModel3.specialNumberIconArray, objectRef5.element, composer5, 8);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    }), composer3, 196680, 24);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }), startRestartGroup, 3128, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                            return;
                        }
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(Composer composer2, Integer num) {
                                num.intValue();
                                ShootResultDefaultViewKt.ShootResultDefaultView(NBPShootResultViewModel.this, composer2, i3 | 1);
                                return Unit.INSTANCE;
                            }
                        });
                        return;
                    }
                }
                t17 = 0;
                objectRef2.element = t17;
                final Ref.ObjectRef<String> objectRef32 = new Ref.ObjectRef();
                resultConfig$qecommerce_biz_release2 = nBPShootResultViewModel.getResultConfig$qecommerce_biz_release();
                if (resultConfig$qecommerce_biz_release2 != null) {
                    it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                        }
                    }
                    shootEmojiItemConfig = (NBPMoodGroupConfig.ShootEmojiItemConfig) obj;
                    if (shootEmojiItemConfig != null) {
                    }
                }
                objectRef32.element = t18;
                charSequence = (CharSequence) objectRef.element;
                if (!(charSequence != null || charSequence.length() == 0)) {
                }
                objectRef.element = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_GGSjnoIKBwj.png";
                objectRef2.element = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_fKfRR1Vk26r.png";
                objectRef32.element = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_2yE6eKA6C27.png";
                BoxKt.a(ViewEventPropUpdaterKt.q(ModifiersKt.T(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e() + 20.0f), 300.0f), -10.0f, -10.0f, -10.0f, 0.0f, 8, null), 7), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$1
                    {
                        super(1);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
                    
                        if (r4 != 3) goto L16;
                     */
                    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<k35.n>, java.util.ArrayList] */
                    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<k35.n>, java.util.ArrayList] */
                    /* JADX WARN: Type inference failed for: r15v6, types: [java.util.List<k35.n>, java.util.ArrayList] */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(Object obj4) {
                        int i16;
                        final NBPShootResultViewModel nBPShootResultViewModel2 = NBPShootResultViewModel.this;
                        if (!nBPShootResultViewModel2.isResultViewPopable) {
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("is Shooting, pop-ups are not allowed. Pending pop-up size\uff1a");
                            m3.append(nBPShootResultViewModel2.shootRspList.size());
                            kLog.i("NBPShootResultPage", m3.toString());
                        } else if (!nBPShootResultViewModel2.shootRspList.isEmpty()) {
                            k35.n nVar = (k35.n) nBPShootResultViewModel2.shootRspList.remove(0);
                            int size = nVar.f411571f.size();
                            if (size != 0) {
                                if (size != 1 && size != 2) {
                                    i16 = 3;
                                }
                                i16 = 2;
                            } else {
                                i16 = 1;
                            }
                            int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(i16);
                            if (ordinal == 0) {
                                nBPShootResultViewModel2.setNeedToBlur(true);
                                nBPShootResultViewModel2.resultViewState.setValue(NBPShootResultPageState.NULL);
                                TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel$handleResultPopView$1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPShootResultViewModel.this.resultViewState.setValue(NBPShootResultPageState.SHARE_SUCCESS);
                                        return Unit.INSTANCE;
                                    }
                                });
                            } else if (ordinal != 1) {
                                KLog kLog2 = KLog.INSTANCE;
                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("result rsp user num error. size: ");
                                m16.append(nVar.f411571f.size());
                                kLog2.i("NBPShootResultPage", m16.toString());
                            } else {
                                String a16 = ((com.tencent.kuikly.core.module.b) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRCalendarModule")).a(APICallTechReporterKt.NBPCurrentTime(), TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
                                Utils utils = Utils.INSTANCE;
                                String item = utils.cacheModule("").getItem("lastPopupDate");
                                String str = a16 + util.base64_pad_url + UserDataManager.INSTANCE.getUserSelfInfo().tid;
                                Integer num = utils.cacheModule("").getInt("matchPageCount");
                                nBPShootResultViewModel2.matchViewCount = num != null ? num.intValue() : 0;
                                if (!Intrinsics.areEqual(item, str)) {
                                    utils.cacheModule("").setItem("lastPopupDate", str);
                                    utils.cacheModule("").setInt("matchPageCount", 0);
                                    nBPShootResultViewModel2.matchViewCount = 0;
                                }
                                nBPShootResultViewModel2.matchViewCount++;
                                DatalineDetailViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("matchViewPopUpCount: "), nBPShootResultViewModel2.matchViewCount, KLog.INSTANCE, "NBPShootResultPage");
                                utils.cacheModule("").setInt("matchPageCount", Integer.valueOf(nBPShootResultViewModel2.matchViewCount));
                                nBPShootResultViewModel2.readyToShowThemeMapGuide = nBPShootResultViewModel2.matchViewCount == 2;
                                nBPShootResultViewModel2.setNeedToBlur(true);
                                nBPShootResultViewModel2.matchResult = nVar.f411571f;
                                nBPShootResultViewModel2.resultViewState.setValue(NBPShootResultPageState.NULL);
                                TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel$handleResultPopView$2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPShootResultViewModel.this.resultViewState.setValue(NBPShootResultPageState.MATCH_SUCCESS);
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        }
                        final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                        TimerKt.d(1400, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NBPShootResultViewModel.this.enterAnimPlayed$delegate.setValue(Boolean.FALSE);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPShootResultViewModel nBPShootResultViewModel4 = NBPShootResultViewModel.this;
                        TimerKt.d(FSUploadConst.ERR_FILE_NOT_EXIST, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$1.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                MutableState mutableState = NBPShootResultViewModel.this.hasEntranceAnimationFinished$delegate;
                                Boolean bool = Boolean.FALSE;
                                mutableState.setValue(bool);
                                NBPShootResultViewModel.this.showDefaultResult.setValue(bool);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }), Alignment.TopCenter, null, ComposableLambdaKt.composableLambda(startRestartGroup, 276911750, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function3
                    public final Unit invoke(b bVar, Composer composer2, Integer num) {
                        Composer composer3 = composer2;
                        int intValue = num.intValue();
                        if ((intValue & 81) == 16 && composer3.getSkipping()) {
                            composer3.skipToGroupEnd();
                        } else {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(276911750, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultView.<anonymous> (ShootResultDefaultView.kt:61)");
                            }
                            State<Float> c16 = AnimateAsStateKt.c(!NBPShootResultViewModel.this.getEnterAnimPlayed() ? 0.0f : 1.0f, com.tencent.ntcompose.animation.b.d(300, 0, com.tencent.ntcompose.animation.i.d(), null, 10, null), null, composer3, 0, 4);
                            final NBPShootResultViewModel nBPShootResultViewModel2 = NBPShootResultViewModel.this;
                            EffectsKt.SideEffect(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$2.1
                                {
                                    super(0);
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    if (!NBPShootResultViewModel.this.getEnterAnimPlayed() && !((Boolean) NBPShootResultViewModel.this.hasEntranceAnimationFinished$delegate.getValue()).booleanValue()) {
                                        NBPShootResultViewModel.this.enterAnimPlayed$delegate.setValue(Boolean.TRUE);
                                        final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                                        TimerKt.d(300, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt.ShootResultDefaultView.2.1.1
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Unit invoke() {
                                                NBPShootResultViewModel.this.hasEntranceAnimationFinished$delegate.setValue(Boolean.TRUE);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, composer3, 0);
                            i.Companion companion = i.INSTANCE;
                            BoxKt.a(ModifiersKt.b(ModifiersKt.L(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 156.0f), 48.0f), 0.0f, ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).i() + 20.0f, 0.0f, 0.0f, 13, null), new com.tencent.kuikly.core.base.h(3439329279L)), 24.0f), 0.0f, 2.0f, 16.0f, new com.tencent.kuikly.core.base.h(335544320L)), c16.getValue().floatValue()), null, null, null, composer3, 8, 14);
                            composer3.startReplaceableGroup(1616578891);
                            if (((Boolean) NBPShootResultViewModel.this.hasEntranceAnimationFinished$delegate.getValue()).booleanValue()) {
                                APNGKt.a(ComposeLayoutPropUpdaterKt.n(ModifiersKt.J(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 190.0f), 70.0f), 1.2f, null, 2, null), 0.0f, ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).i() + 10.0f, 0.0f, 0.0f, 13, null), null, objectRef.element, 1, null, null, null, null, composer3, 3080, 242);
                            }
                            composer3.endReplaceableGroup();
                            i b16 = ModifiersKt.b(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 156.0f), 68.0f), 0.0f, ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).i() + 10.0f, 0.0f, 0.0f, 13, null), com.tencent.kuikly.core.base.h.INSTANCE.j()), c16.getValue().floatValue());
                            a.d g16 = a.f339245a.g();
                            Alignment.Vertical f16 = Alignment.INSTANCE.f();
                            final Ref.ObjectRef<String> objectRef4 = objectRef2;
                            final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                            final Ref.ObjectRef<String> objectRef5 = objectRef32;
                            RowKt.a(b16, g16, f16, null, null, ComposableLambdaKt.composableLambda(composer3, -1213512792, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$2.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                                    Composer composer5 = composer4;
                                    int intValue2 = num2.intValue();
                                    if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                        composer5.skipToGroupEnd();
                                    } else {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1213512792, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultView.<anonymous>.<anonymous> (ShootResultDefaultView.kt:104)");
                                        }
                                        APNGKt.a(ComposeLayoutPropUpdaterKt.u(ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 16.0f, 0.0f, 0.0f, 30.0f, 6, null), 52.0f), null, objectRef4.element, 0, Boolean.TRUE, null, null, null, composer5, 27656, 226);
                                        ShootResultDefaultViewKt.RichTextExample(nBPShootResultViewModel3.specialNumberIconArray, objectRef5.element, composer5, 8);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }
                            }), composer3, 196680, 24);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }), startRestartGroup, 3128, 4);
                if (ComposerKt.isTraceInProgress()) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
        }
        t16 = 0;
        objectRef.element = t16;
        final Ref.ObjectRef<String> objectRef22 = new Ref.ObjectRef();
        resultConfig$qecommerce_biz_release = nBPShootResultViewModel.getResultConfig$qecommerce_biz_release();
        if (resultConfig$qecommerce_biz_release != null) {
            it5 = list2.iterator();
            while (true) {
                if (it5.hasNext()) {
                }
            }
            shootEmojiItemConfig2 = (NBPMoodGroupConfig.ShootEmojiItemConfig) obj2;
            if (shootEmojiItemConfig2 != null) {
            }
        }
        t17 = 0;
        objectRef22.element = t17;
        final Ref.ObjectRef<String> objectRef322 = new Ref.ObjectRef();
        resultConfig$qecommerce_biz_release2 = nBPShootResultViewModel.getResultConfig$qecommerce_biz_release();
        if (resultConfig$qecommerce_biz_release2 != null) {
        }
        objectRef322.element = t18;
        charSequence = (CharSequence) objectRef.element;
        if (!(charSequence != null || charSequence.length() == 0)) {
        }
        objectRef.element = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_GGSjnoIKBwj.png";
        objectRef22.element = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_fKfRR1Vk26r.png";
        objectRef322.element = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_2yE6eKA6C27.png";
        BoxKt.a(ViewEventPropUpdaterKt.q(ModifiersKt.T(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(i.INSTANCE, ((com.tencent.ntcompose.ui.platform.a) startRestartGroup.consume(CompositionLocalsKt.d())).e() + 20.0f), 300.0f), -10.0f, -10.0f, -10.0f, 0.0f, 8, null), 7), new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$1
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
            
                if (r4 != 3) goto L16;
             */
            /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List<k35.n>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<k35.n>, java.util.ArrayList] */
            /* JADX WARN: Type inference failed for: r15v6, types: [java.util.List<k35.n>, java.util.ArrayList] */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(Object obj4) {
                int i16;
                final NBPShootResultViewModel nBPShootResultViewModel2 = NBPShootResultViewModel.this;
                if (!nBPShootResultViewModel2.isResultViewPopable) {
                    KLog kLog = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("is Shooting, pop-ups are not allowed. Pending pop-up size\uff1a");
                    m3.append(nBPShootResultViewModel2.shootRspList.size());
                    kLog.i("NBPShootResultPage", m3.toString());
                } else if (!nBPShootResultViewModel2.shootRspList.isEmpty()) {
                    k35.n nVar = (k35.n) nBPShootResultViewModel2.shootRspList.remove(0);
                    int size = nVar.f411571f.size();
                    if (size != 0) {
                        if (size != 1 && size != 2) {
                            i16 = 3;
                        }
                        i16 = 2;
                    } else {
                        i16 = 1;
                    }
                    int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(i16);
                    if (ordinal == 0) {
                        nBPShootResultViewModel2.setNeedToBlur(true);
                        nBPShootResultViewModel2.resultViewState.setValue(NBPShootResultPageState.NULL);
                        TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel$handleResultPopView$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NBPShootResultViewModel.this.resultViewState.setValue(NBPShootResultPageState.SHARE_SUCCESS);
                                return Unit.INSTANCE;
                            }
                        });
                    } else if (ordinal != 1) {
                        KLog kLog2 = KLog.INSTANCE;
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("result rsp user num error. size: ");
                        m16.append(nVar.f411571f.size());
                        kLog2.i("NBPShootResultPage", m16.toString());
                    } else {
                        String a16 = ((com.tencent.kuikly.core.module.b) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRCalendarModule")).a(APICallTechReporterKt.NBPCurrentTime(), TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
                        Utils utils = Utils.INSTANCE;
                        String item = utils.cacheModule("").getItem("lastPopupDate");
                        String str = a16 + util.base64_pad_url + UserDataManager.INSTANCE.getUserSelfInfo().tid;
                        Integer num = utils.cacheModule("").getInt("matchPageCount");
                        nBPShootResultViewModel2.matchViewCount = num != null ? num.intValue() : 0;
                        if (!Intrinsics.areEqual(item, str)) {
                            utils.cacheModule("").setItem("lastPopupDate", str);
                            utils.cacheModule("").setInt("matchPageCount", 0);
                            nBPShootResultViewModel2.matchViewCount = 0;
                        }
                        nBPShootResultViewModel2.matchViewCount++;
                        DatalineDetailViewModel$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("matchViewPopUpCount: "), nBPShootResultViewModel2.matchViewCount, KLog.INSTANCE, "NBPShootResultPage");
                        utils.cacheModule("").setInt("matchPageCount", Integer.valueOf(nBPShootResultViewModel2.matchViewCount));
                        nBPShootResultViewModel2.readyToShowThemeMapGuide = nBPShootResultViewModel2.matchViewCount == 2;
                        nBPShootResultViewModel2.setNeedToBlur(true);
                        nBPShootResultViewModel2.matchResult = nVar.f411571f;
                        nBPShootResultViewModel2.resultViewState.setValue(NBPShootResultPageState.NULL);
                        TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.result.NBPShootResultViewModel$handleResultPopView$2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NBPShootResultViewModel.this.resultViewState.setValue(NBPShootResultPageState.MATCH_SUCCESS);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                }
                final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                TimerKt.d(1400, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        NBPShootResultViewModel.this.enterAnimPlayed$delegate.setValue(Boolean.FALSE);
                        return Unit.INSTANCE;
                    }
                });
                final NBPShootResultViewModel nBPShootResultViewModel4 = NBPShootResultViewModel.this;
                TimerKt.d(FSUploadConst.ERR_FILE_NOT_EXIST, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        MutableState mutableState = NBPShootResultViewModel.this.hasEntranceAnimationFinished$delegate;
                        Boolean bool = Boolean.FALSE;
                        mutableState.setValue(bool);
                        NBPShootResultViewModel.this.showDefaultResult.setValue(bool);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        }), Alignment.TopCenter, null, ComposableLambdaKt.composableLambda(startRestartGroup, 276911750, true, new Function3<b, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(b bVar, Composer composer2, Integer num) {
                Composer composer3 = composer2;
                int intValue = num.intValue();
                if ((intValue & 81) == 16 && composer3.getSkipping()) {
                    composer3.skipToGroupEnd();
                } else {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(276911750, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultView.<anonymous> (ShootResultDefaultView.kt:61)");
                    }
                    State<Float> c16 = AnimateAsStateKt.c(!NBPShootResultViewModel.this.getEnterAnimPlayed() ? 0.0f : 1.0f, com.tencent.ntcompose.animation.b.d(300, 0, com.tencent.ntcompose.animation.i.d(), null, 10, null), null, composer3, 0, 4);
                    final NBPShootResultViewModel nBPShootResultViewModel2 = NBPShootResultViewModel.this;
                    EffectsKt.SideEffect(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$2.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            if (!NBPShootResultViewModel.this.getEnterAnimPlayed() && !((Boolean) NBPShootResultViewModel.this.hasEntranceAnimationFinished$delegate.getValue()).booleanValue()) {
                                NBPShootResultViewModel.this.enterAnimPlayed$delegate.setValue(Boolean.TRUE);
                                final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                                TimerKt.d(300, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt.ShootResultDefaultView.2.1.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPShootResultViewModel.this.hasEntranceAnimationFinished$delegate.setValue(Boolean.TRUE);
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            return Unit.INSTANCE;
                        }
                    }, composer3, 0);
                    i.Companion companion = i.INSTANCE;
                    BoxKt.a(ModifiersKt.b(ModifiersKt.L(ModifiersKt.j(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 156.0f), 48.0f), 0.0f, ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).i() + 20.0f, 0.0f, 0.0f, 13, null), new com.tencent.kuikly.core.base.h(3439329279L)), 24.0f), 0.0f, 2.0f, 16.0f, new com.tencent.kuikly.core.base.h(335544320L)), c16.getValue().floatValue()), null, null, null, composer3, 8, 14);
                    composer3.startReplaceableGroup(1616578891);
                    if (((Boolean) NBPShootResultViewModel.this.hasEntranceAnimationFinished$delegate.getValue()).booleanValue()) {
                        APNGKt.a(ComposeLayoutPropUpdaterKt.n(ModifiersKt.J(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 190.0f), 70.0f), 1.2f, null, 2, null), 0.0f, ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).i() + 10.0f, 0.0f, 0.0f, 13, null), null, objectRef.element, 1, null, null, null, null, composer3, 3080, 242);
                    }
                    composer3.endReplaceableGroup();
                    i b16 = ModifiersKt.b(ModifiersKt.c(ComposeLayoutPropUpdaterKt.n(ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(companion, 156.0f), 68.0f), 0.0f, ((com.tencent.ntcompose.ui.platform.a) composer3.consume(CompositionLocalsKt.d())).i() + 10.0f, 0.0f, 0.0f, 13, null), com.tencent.kuikly.core.base.h.INSTANCE.j()), c16.getValue().floatValue());
                    a.d g16 = a.f339245a.g();
                    Alignment.Vertical f16 = Alignment.INSTANCE.f();
                    final Ref.ObjectRef<String> objectRef4 = objectRef22;
                    final NBPShootResultViewModel nBPShootResultViewModel3 = NBPShootResultViewModel.this;
                    final Ref.ObjectRef<String> objectRef5 = objectRef322;
                    RowKt.a(b16, g16, f16, null, null, ComposableLambdaKt.composableLambda(composer3, -1213512792, true, new Function3<n, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultViewKt$ShootResultDefaultView$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Unit invoke(n nVar, Composer composer4, Integer num2) {
                            Composer composer5 = composer4;
                            int intValue2 = num2.intValue();
                            if ((intValue2 & 81) == 16 && composer5.getSkipping()) {
                                composer5.skipToGroupEnd();
                            } else {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1213512792, intValue2, -1, "com.tencent.hippykotlin.demo.pages.nearby.mood_group.view.result.ShootResultDefaultView.<anonymous>.<anonymous> (ShootResultDefaultView.kt:104)");
                                }
                                APNGKt.a(ComposeLayoutPropUpdaterKt.u(ComposeLayoutPropUpdaterKt.n(i.INSTANCE, 16.0f, 0.0f, 0.0f, 30.0f, 6, null), 52.0f), null, objectRef4.element, 0, Boolean.TRUE, null, null, null, composer5, 27656, 226);
                                ShootResultDefaultViewKt.RichTextExample(nBPShootResultViewModel3.specialNumberIconArray, objectRef5.element, composer5, 8);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }), composer3, 196680, 24);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
                return Unit.INSTANCE;
            }
        }), startRestartGroup, 3128, 4);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
