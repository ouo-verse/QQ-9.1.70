package com.tencent.mobileqq.profilecard.multyple;

import com.tencent.mobileqq.profilecard.collector.IProfileComponentCollector;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public interface IProfileCardMultiConfig {
    boolean enableVasComponent();

    ArrayList<Class<? extends IProfileComponentCollector>> getInjectCollectorClasses();

    IProfileCardVersion getProfileCardVersion();
}
