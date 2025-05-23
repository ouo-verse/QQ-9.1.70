package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.page_model;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.SchemeParamExtensionKt;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarForYiFanShangViewModel;
import com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.pendant.bottomArea.shop.BlindBoxProductDetailBottomBarViewModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class BlindBoxProductDetailBottomBarFactory {
    public static final BlindBoxProductDetailBottomBarFactory INSTANCE = new BlindBoxProductDetailBottomBarFactory();

    /* loaded from: classes31.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BoxType$EnumUnboxingSharedUtility.values(2).length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0171, code lost:
    
        if ((!r10) != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final IBlindBoxProductDetailBottomBarViewModel create(e eVar, e eVar2) {
        boolean isBlank;
        boolean isBlank2;
        boolean z16 = true;
        if (WhenMappings.$EnumSwitchMapping$0[BoxType$EnumUnboxingSharedUtility.ordinal(SchemeParamExtensionKt.blindBoxType(eVar2))] == 1) {
            return new BlindBoxProductDetailBottomBarForYiFanShangViewModel(eVar2);
        }
        BlindBoxProductDetailBottomBarViewModel blindBoxProductDetailBottomBarViewModel = new BlindBoxProductDetailBottomBarViewModel(eVar.p("spu_id"), eVar2.q("mystery_box_id", ""));
        boolean z17 = eVar2.k("assist_button_is_active", 0) == 1;
        ReadWriteProperty readWriteProperty = blindBoxProductDetailBottomBarViewModel.assistButtonEnable$delegate;
        KProperty<?>[] kPropertyArr = BlindBoxProductDetailBottomBarViewModel.$$delegatedProperties;
        readWriteProperty.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[0], Boolean.valueOf(z17));
        blindBoxProductDetailBottomBarViewModel.assistButtonText$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[1], eVar2.q("assist_button_text", ""));
        blindBoxProductDetailBottomBarViewModel.assistButtonJumpUrl$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[2], eVar2.q("assist_button_jump_url", ""));
        blindBoxProductDetailBottomBarViewModel.firstLotteryButtonType$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[3], Integer.valueOf(eVar2.k("first_lottery_button_type", 0)));
        blindBoxProductDetailBottomBarViewModel.firstLotteryButtonEnable$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[4], Boolean.valueOf(eVar2.k("first_lottery_button_is_active", 0) == 1));
        blindBoxProductDetailBottomBarViewModel.firstLotteryButtonText$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[5], eVar2.q("first_lottery_button_text", ""));
        blindBoxProductDetailBottomBarViewModel.firstLotteryButtonPrice$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[6], eVar2.q("first_lottery_button_price", ""));
        blindBoxProductDetailBottomBarViewModel.firstLotteryButtonJumpUrl$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[7], eVar2.q("first_lottery_button_jump_url", ""));
        blindBoxProductDetailBottomBarViewModel.secondLotteryButtonType$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[8], Integer.valueOf(eVar2.k("second_lottery_button_type", 0)));
        blindBoxProductDetailBottomBarViewModel.secondLotteryButtonEnable$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[9], Boolean.valueOf(eVar2.k("second_lottery_button_is_active", 0) == 1));
        blindBoxProductDetailBottomBarViewModel.secondLotteryButtonText$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[10], eVar2.q("second_lottery_button_text", ""));
        blindBoxProductDetailBottomBarViewModel.secondLotteryButtonPrice$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[11], eVar2.q("second_lottery_button_price", ""));
        blindBoxProductDetailBottomBarViewModel.secondLotteryButtonJumpUrl$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[12], eVar2.q("second_lottery_button_jump_url", ""));
        blindBoxProductDetailBottomBarViewModel.containsTwoLotteryButton$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[13], Boolean.valueOf(eVar2.k("contains_two_lottery_button", 0) == 1));
        blindBoxProductDetailBottomBarViewModel.blindBoxTitle$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[16], eVar2.q("mystery_box_title", ""));
        blindBoxProductDetailBottomBarViewModel.blindBoxCoverUrl$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[15], eVar2.q("mystery_box_cover", ""));
        isBlank = StringsKt__StringsJVMKt.isBlank((String) blindBoxProductDetailBottomBarViewModel.blindBoxTitle$delegate.getValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[16]));
        if (!isBlank) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank((String) blindBoxProductDetailBottomBarViewModel.blindBoxCoverUrl$delegate.getValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[15]));
        }
        z16 = false;
        blindBoxProductDetailBottomBarViewModel.showBlindBoxInfo$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[14], Boolean.valueOf(z16));
        blindBoxProductDetailBottomBarViewModel.tryPlayButtonJumUrl$delegate.setValue(blindBoxProductDetailBottomBarViewModel, kPropertyArr[17], eVar2.q("try_play_jump_url", ""));
        return blindBoxProductDetailBottomBarViewModel;
    }
}
