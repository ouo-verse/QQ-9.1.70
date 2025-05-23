package com.tencent.hippykotlin.demo.pages.retain.viewModel;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.retain.RetainPopWindowCardAttr;
import com.tencent.hippykotlin.demo.pages.retain.RetainPopWindowInfo;
import com.tencent.hippykotlin.demo.pages.retain.model.Button;
import com.tencent.hippykotlin.demo.pages.retain.model.CouponLabelInfo;
import com.tencent.hippykotlin.demo.pages.retain.model.Labelheader;
import com.tencent.hippykotlin.demo.pages.retain.view.RetainPopWindowCouponView;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes33.dex */
public final class RetainPopWindowCouponViewModel implements IRetainPopWindowViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(RetainPopWindowCouponViewModel.class, "countDownSecond", "getCountDownSecond()J", 0)};
    public static final Companion Companion = new Companion();
    public final ReadWriteProperty countDownSecond$delegate = c.a(0L);
    public ArrayList<String> countDownStrArray = new ArrayList<>();
    public final RetainPopWindowInfo info;
    public final e reportJson;

    /* loaded from: classes33.dex */
    public static final class Companion {
    }

    public RetainPopWindowCouponViewModel(RetainPopWindowInfo retainPopWindowInfo, e eVar) {
        this.info = retainPopWindowInfo;
        this.reportJson = eVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel
    public final Function0<Unit> cancelBtnCallback() {
        return new RetainPopWindowCouponViewModel$cancelBtnCallback$1(this);
    }

    @Override // com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel
    public final String cancelBtnText() {
        String str;
        Button button = this.info.rsp.button;
        return (button == null || (str = button.leftText) == null) ? "\u653e\u5f03" : str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel
    public final void countDown() {
        TimerKt.g(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.viewModel.RetainPopWindowCouponViewModel$countDown$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                if (RetainPopWindowCouponViewModel.this.getCountDownSecond() >= -1) {
                    RetainPopWindowCouponViewModel.this.updateTimeInfo();
                    RetainPopWindowCouponViewModel.this.countDown();
                }
                return Unit.INSTANCE;
            }
        }, 500);
    }

    public final long countdownRemainTime() {
        Labelheader labelheader = this.info.rsp.header;
        return (labelheader != null ? labelheader.countdownTime : 0L) - (Utils.INSTANCE.currentBridgeModule().currentTimeStamp() / 1000);
    }

    public final CouponLabelInfo couponInfo() {
        Object first;
        if (!(!couponList().isEmpty())) {
            return null;
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) couponList());
        return (CouponLabelInfo) first;
    }

    @Override // com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel
    public final ArrayList<CouponLabelInfo> couponList() {
        ArrayList<CouponLabelInfo> arrayList = this.info.rsp.couponLables;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    @Override // com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel
    public final void expReport() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("pop_type", "1");
        e eVar = this.reportJson;
        String str = (String) linkedHashMap.get("pop_type");
        if (str == null) {
            str = "";
        }
        eVar.v("pop_type", str);
        Utils utils = Utils.INSTANCE;
        utils.currentBridgeModule().reportDT("qstore_prd_quit_pop_exp", eVar);
        utils.logToNative("[ProductDetailReporter] reportRecommendClk, event cod = qstore_prd_detail_pg_recommend_ck, data = " + eVar);
    }

    public final long getCountDownSecond() {
        return ((Number) this.countDownSecond$delegate.getValue(this, $$delegatedProperties[0])).longValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel
    public final ComposeView<RetainPopWindowCardAttr, l> getPopWindowView() {
        return new RetainPopWindowCouponView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel
    public final boolean shouldShowCountDown() {
        return countdownRemainTime() >= 0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel
    public final Function0<Unit> successBtnCallback() {
        return new RetainPopWindowCouponViewModel$successBtnCallback$1(this);
    }

    @Override // com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel
    public final String successBtnText() {
        String str;
        Button button = this.info.rsp.button;
        return (button == null || (str = button.rightText) == null) ? "\u8d2d\u4e70" : str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel
    public final String title() {
        String str;
        Labelheader labelheader = this.info.rsp.header;
        return (labelheader == null || (str = labelheader.topText) == null) ? "" : str;
    }

    @Override // com.tencent.hippykotlin.demo.pages.retain.viewModel.IRetainPopWindowViewModel
    public final void updateTimeInfo() {
        String padStart;
        String padStart2;
        String padStart3;
        String padStart4;
        this.countDownSecond$delegate.setValue(this, $$delegatedProperties[0], Long.valueOf(countdownRemainTime()));
        long countDownSecond = getCountDownSecond();
        this.countDownStrArray.clear();
        ArrayList<String> arrayList = this.countDownStrArray;
        long j3 = 60;
        long j16 = countDownSecond / j3;
        long j17 = j16 / j3;
        long j18 = 24;
        padStart = StringsKt__StringsKt.padStart(String.valueOf(j17 / j18), 2, '0');
        padStart2 = StringsKt__StringsKt.padStart(String.valueOf(j17 % j18), 2, '0');
        padStart3 = StringsKt__StringsKt.padStart(String.valueOf(j16 % j3), 2, '0');
        padStart4 = StringsKt__StringsKt.padStart(String.valueOf(countDownSecond % j3), 2, '0');
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, new String[]{padStart, padStart2, padStart3, padStart4});
        if (getCountDownSecond() < 0) {
            Utils utils = Utils.INSTANCE;
            k.d(utils.notifyModule(BridgeManager.f117344a.u()), "confirmBtnPressed", new e(), false, 4, null);
            BridgeModule.closePage$default(utils.currentBridgeModule(), null, null, 3);
        }
    }
}
