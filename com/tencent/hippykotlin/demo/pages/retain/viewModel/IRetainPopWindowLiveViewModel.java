package com.tencent.hippykotlin.demo.pages.retain.viewModel;

import com.tencent.hippykotlin.demo.pages.retain.model.ActiveLabelInfo;
import java.util.ArrayList;

/* loaded from: classes33.dex */
public interface IRetainPopWindowLiveViewModel extends IRetainPopWindowViewModel {
    long getCountDownSecond();

    ArrayList<String> getCountDownStrArray();

    ArrayList<ActiveLabelInfo> liveActiveList();

    String livePrice();

    String oriPrice();
}
