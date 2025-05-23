package com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQBridgeApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.NBPMoodGroupReportViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.q;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.pager.g;
import com.tencent.kuikly.core.timer.Timer;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPShootViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPShootViewModel.class, "trackAnimations", "getTrackAnimations()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(NBPShootViewModel.class, "serialShootTimesIconArray", "getSerialShootTimesIconArray()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public static final String TAG = "NBPShootViewModel";
    public int animationId;
    public String bottomTipText;
    public String config;
    public String delayCallbackRef;
    public boolean didControlGuideOnHistory;
    public String emojiId;
    public String entranceEmojiIcon;
    public float entranceRotate;
    public aa<v> entranceView;
    public MutableState<Boolean> hasTouchUp;
    public boolean isPressing;
    public MutableState<Boolean> isPressingState;
    public int mid;
    public List<String> numberIcons;
    public final g pageData;
    public float pagerHeight;
    public float pagerWidth;
    public final SnapshotStateList<Integer> pressAnimationCounts;
    public Timer pressAnimationTimer;
    public Timer pressShootTimer;
    public final NBPMoodGroupReportViewModel reporter;
    public aa<v> rootView;
    public int serialShootTimes;
    public final ReadWriteProperty serialShootTimesIconArray$delegate;
    public boolean shakeAnimating;
    public Timer shakeAnimationTimer;
    public String shootBoomAPNG;
    public NBPShootPoint shootCenterPointInPager;
    public String shootEmojiIcon;
    public final float shootEntranceSize;
    public final INBPShootEventListener shootListener;
    public NBPShootPoint shootTouchDownPoint;
    public final MutableState<Boolean> showControlGuideView;
    public final MutableState<Boolean> showTopGuideTip;
    public final String today;
    public String topGuideTipText;
    public final ReadWriteProperty trackAnimations$delegate;
    public String xIconUrl;

    public NBPShootViewModel(INBPShootEventListener iNBPShootEventListener, NBPMoodGroupReportViewModel nBPMoodGroupReportViewModel, g gVar) {
        MutableState<Boolean> mutableStateOf$default;
        MutableState<Boolean> mutableStateOf$default2;
        MutableState<Boolean> mutableStateOf$default3;
        MutableState<Boolean> mutableStateOf$default4;
        this.shootListener = iNBPShootEventListener;
        this.reporter = nBPMoodGroupReportViewModel;
        this.pageData = gVar;
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isPressingState = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.hasTouchUp = mutableStateOf$default2;
        this.trackAnimations$delegate = c.b();
        this.shootEntranceSize = 88.0f;
        this.mid = 1;
        this.emojiId = "";
        this.entranceEmojiIcon = "";
        this.shootEmojiIcon = "";
        this.topGuideTipText = "\u957f\u6309\u53d1\u5c04\u798f\u6c14\uff0c\u62bd\u798f\u5361";
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showTopGuideTip = mutableStateOf$default3;
        this.bottomTipText = "\u53d1\u5c04\u60c5\u7eea";
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.showControlGuideView = mutableStateOf$default4;
        this.shootBoomAPNG = "";
        this.numberIcons = new ArrayList();
        NBPShootPoint nBPShootPoint = NBPShootPoint.zero;
        this.shootTouchDownPoint = nBPShootPoint;
        this.shootCenterPointInPager = nBPShootPoint;
        this.serialShootTimesIconArray$delegate = c.b();
        this.xIconUrl = "";
        this.delayCallbackRef = "";
        this.pressAnimationCounts = SnapshotStateKt.mutableStateListOf();
        this.today = QQBridgeApi.INSTANCE.getCalendarModule().a(APICallTechReporterKt.NBPCurrentTime(), TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
    }

    public final String controlGuideCacheKey() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("nbp_shoot_control_guide_key_");
        m3.append(PageDataExtKt.getUin(com.tencent.kuikly.core.manager.c.f117352a.g().getPageData()));
        return m3.toString();
    }

    public final String getLastDateOfShoot() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("nbp_last_shoot_date_key_");
        com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
        m3.append(PageDataExtKt.getUin(cVar.g().getPageData()));
        return ((CacheModule) cVar.g().acquireModule("HRCacheModule")).getItem(m3.toString());
    }

    public final com.tencent.kuikly.core.reactive.collection.c<String> getSerialShootTimesIconArray() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.serialShootTimesIconArray$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<NBPShootTrackAnimation> getTrackAnimations() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.trackAnimations$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void toSetSerialShootTimes(int i3) {
        this.serialShootTimes = i3;
        if (i3 > 3 && this.isPressing && !this.didControlGuideOnHistory && !this.showControlGuideView.getValue().booleanValue()) {
            this.showControlGuideView.setValue(Boolean.TRUE);
        }
        if (this.numberIcons.size() < 10) {
            return;
        }
        if (this.serialShootTimes >= 2) {
            getSerialShootTimesIconArray().clear();
            String valueOf = String.valueOf(i3);
            for (int i16 = 0; i16 < valueOf.length(); i16++) {
                int parseInt = Integer.parseInt(String.valueOf(valueOf.charAt(i16)));
                if (parseInt < 10) {
                    getSerialShootTimesIconArray().add(this.numberIcons.get(parseInt));
                }
            }
            return;
        }
        getSerialShootTimesIconArray().clear();
    }

    public final void updateShakeState(boolean z16) {
        if (this.shakeAnimating != z16) {
            this.shakeAnimating = z16;
            if (z16) {
                Timer timer = new Timer();
                timer.f(0, 50, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel$updateShakeState$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        List listOf;
                        v b16;
                        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(-1.0f), Float.valueOf(0.0f), Float.valueOf(1.0f)});
                        Random.Companion companion = Random.INSTANCE;
                        final float floatValue = ((Number) listOf.get(companion.nextInt(0, listOf.size()))).floatValue();
                        final float floatValue2 = ((Number) listOf.get(companion.nextInt(0, listOf.size()))).floatValue();
                        aa<v> aaVar = NBPShootViewModel.this.rootView;
                        if (aaVar != null && (b16 = aaVar.b()) != null) {
                            b l3 = b.Companion.l(b.INSTANCE, 0.03f, null, 2, null);
                            final NBPShootViewModel nBPShootViewModel = NBPShootViewModel.this;
                            q.a.a(b16, l3, null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel$updateShakeState$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Attr attr) {
                                    float f16 = floatValue;
                                    NBPShootViewModel nBPShootViewModel2 = nBPShootViewModel;
                                    attr.transform(new y((5.0f / nBPShootViewModel2.pagerWidth) * f16, (5.0f / nBPShootViewModel2.pagerHeight) * floatValue2, 0.0f, 0.0f, 12, null));
                                    return Unit.INSTANCE;
                                }
                            }, 2, null);
                        }
                        return Unit.INSTANCE;
                    }
                });
                this.shakeAnimationTimer = timer;
            } else {
                Timer timer2 = this.shakeAnimationTimer;
                if (timer2 != null) {
                    timer2.e();
                }
                this.shakeAnimationTimer = null;
                TimerKt.d(50, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm.shoot.NBPShootViewModel$updateShakeState$2
                    {
                        super(0);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        v b16;
                        t tVar;
                        aa<v> aaVar = NBPShootViewModel.this.rootView;
                        if (aaVar != null && (b16 = aaVar.b()) != null && (tVar = (t) b16.getViewAttr()) != null) {
                            tVar.transform(new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        }
    }
}
