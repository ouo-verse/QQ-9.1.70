package com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.MqqUtil;
import com.tencent.hippykotlin.demo.pages.qq_intimate_space.home_page.view_model.LoveWallHomepageViewModel;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.b;
import e25.ai;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class LoveWallContributionInfoViewModel {
    public final LoveWallHomepageViewModel homepageViewModel;
    public MutableState<ai> leftUserWater;
    public MutableState<ai> rightUserWater;
    public MutableState<Boolean> showRemindBubble;

    public LoveWallContributionInfoViewModel(LoveWallHomepageViewModel loveWallHomepageViewModel) {
        MutableState<ai> mutableStateOf$default;
        MutableState<ai> mutableStateOf$default2;
        MutableState<Boolean> mutableStateOf$default3;
        this.homepageViewModel = loveWallHomepageViewModel;
        long j3 = 0;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new ai(0L, j3, null, 7, null), null, 2, null);
        this.leftUserWater = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new ai(j3, 0L, 0 == true ? 1 : 0, 7, null), null, 2, null);
        this.rightUserWater = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.showRemindBubble = mutableStateOf$default3;
    }

    public final String getCurrentDate() {
        MqqUtil util = Mqq.INSTANCE.getUtil();
        util.getClass();
        return ((b) c.f117352a.g().acquireModule("KRCalendarModule")).a(util.currentTime(), "yyyy.MM.dd");
    }

    public final String wateringBtnClickRecordKey() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(c.f117352a.g().getPageData().n().q("uin", ""));
        sb5.append(util.base64_pad_url);
        return OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb5, this.homepageViewModel.pageData.peerUin, "_last_watering_click_date");
    }
}
