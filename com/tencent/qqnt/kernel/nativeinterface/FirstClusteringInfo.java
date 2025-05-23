package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FirstClusteringInfo {
    public ClusteringType type = ClusteringType.values()[0];
    public String name = "";
    public ArrayList<String> avatarUrl = new ArrayList<>();

    public ArrayList<String> getAvatarUrl() {
        return this.avatarUrl;
    }

    public String getName() {
        return this.name;
    }

    public ClusteringType getType() {
        return this.type;
    }
}
