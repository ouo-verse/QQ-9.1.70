package com.tencent.hippykotlin.demo.pages.retain.viewModel;

import com.tencent.hippykotlin.demo.pages.retain.RetainPopWindowCardAttr;
import com.tencent.hippykotlin.demo.pages.retain.model.CouponLabelInfo;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.l;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes33.dex */
public interface IRetainPopWindowViewModel {
    Function0<Unit> cancelBtnCallback();

    String cancelBtnText();

    void countDown();

    ArrayList<CouponLabelInfo> couponList();

    void expReport();

    ComposeView<RetainPopWindowCardAttr, l> getPopWindowView();

    boolean shouldShowCountDown();

    Function0<Unit> successBtnCallback();

    String successBtnText();

    String title();

    void updateTimeInfo();
}
