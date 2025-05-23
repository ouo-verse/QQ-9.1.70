package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.card.video.QPlusTrafficHomeVideoView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeVideoViewModel implements IQPlusTrafficCardHomeViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomeVideoViewModel.class, "uiState", "getUiState()Lcom/tencent/hippykotlin/demo/pages/qplus_traffic/define/QPlusTrafficUIState;", 0)};
    public QPlusTrafficUIState feedState;
    public QPlusTrafficUIState initFeedState;
    public final String initSelectFeedId;
    public final Lazy listViewModel$delegate;
    public QPlusTrafficUIState liveState;
    public final boolean showBottom;
    public final boolean showTitle;
    public final ReadWriteProperty uiState$delegate;
    public String uin;

    public QPlusTrafficHomeVideoViewModel(String str, String str2, boolean z16, boolean z17) {
        Lazy lazy;
        this.uin = str;
        this.initSelectFeedId = str2;
        this.showTitle = z16;
        this.showBottom = z17;
        QPlusTrafficUIState qPlusTrafficUIState = QPlusTrafficUIState.LOADING;
        this.uiState$delegate = c.a(qPlusTrafficUIState);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QPlusTrafficHomeVideoListViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoViewModel$listViewModel$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final QPlusTrafficHomeVideoListViewModel invoke() {
                QPlusTrafficHomeVideoViewModel qPlusTrafficHomeVideoViewModel = QPlusTrafficHomeVideoViewModel.this;
                return new QPlusTrafficHomeVideoListViewModel(qPlusTrafficHomeVideoViewModel.uin, qPlusTrafficHomeVideoViewModel.initSelectFeedId);
            }
        });
        this.listViewModel$delegate = lazy;
        this.feedState = qPlusTrafficUIState;
        this.liveState = qPlusTrafficUIState;
        this.initFeedState = str2.length() == 0 ? QPlusTrafficUIState.COMPLETED : qPlusTrafficUIState;
    }

    public final void checkAllDataReady(QPlusTrafficUIState qPlusTrafficUIState, QPlusTrafficUIState qPlusTrafficUIState2, QPlusTrafficUIState qPlusTrafficUIState3) {
        QPlusTrafficUIState qPlusTrafficUIState4;
        QPlusTrafficUIState qPlusTrafficUIState5;
        QPlusTrafficUIState qPlusTrafficUIState6 = QPlusTrafficUIState.COMPLETED;
        if (qPlusTrafficUIState == qPlusTrafficUIState6 && qPlusTrafficUIState2 != (qPlusTrafficUIState5 = QPlusTrafficUIState.LOADING) && qPlusTrafficUIState3 != qPlusTrafficUIState5) {
            setUiState(qPlusTrafficUIState6);
        } else if (qPlusTrafficUIState2 == qPlusTrafficUIState6 && qPlusTrafficUIState != (qPlusTrafficUIState4 = QPlusTrafficUIState.LOADING) && qPlusTrafficUIState3 != qPlusTrafficUIState4) {
            setUiState(qPlusTrafficUIState6);
        } else {
            QPlusTrafficUIState qPlusTrafficUIState7 = QPlusTrafficUIState.FAILURE;
            if (qPlusTrafficUIState == qPlusTrafficUIState7 && qPlusTrafficUIState2 == qPlusTrafficUIState7 && qPlusTrafficUIState3 != QPlusTrafficUIState.LOADING) {
                setUiState(qPlusTrafficUIState7);
            }
        }
        this.feedState = qPlusTrafficUIState;
        this.liveState = qPlusTrafficUIState2;
        this.initFeedState = qPlusTrafficUIState3;
        KLog.INSTANCE.i("QPlus_Home", "check video data state, feed:" + qPlusTrafficUIState + " live:" + qPlusTrafficUIState2 + " initFeed:" + qPlusTrafficUIState3);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel
    public final QPlusTrafficHomeCardView getCardView() {
        return new QPlusTrafficHomeVideoView();
    }

    public final QPlusTrafficHomeVideoListViewModel getListViewModel() {
        return (QPlusTrafficHomeVideoListViewModel) this.listViewModel$delegate.getValue();
    }

    public final void setUiState(QPlusTrafficUIState qPlusTrafficUIState) {
        this.uiState$delegate.setValue(this, $$delegatedProperties[0], qPlusTrafficUIState);
    }
}
