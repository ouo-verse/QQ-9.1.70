package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGetPreviewNavigationRsp extends Serializable {
    IGProGuildNavigationInfo getGuildNavigation();

    ArrayList<IGProGuildNavIconTheme> getIconThemes();

    int getTotal();

    String toString();
}
