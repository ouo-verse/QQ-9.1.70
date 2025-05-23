package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProBindableGroups extends Serializable {
    int getActiveGroups();

    ArrayList<IGProBindingGroup> getGroups();

    String toString();
}
