package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildNavIconTheme extends Serializable {
    String getIconSelectorColor();

    String getIconSelectorUrl();

    ArrayList<IGProGuildNavIconInfo> getIcons();

    String toString();
}
