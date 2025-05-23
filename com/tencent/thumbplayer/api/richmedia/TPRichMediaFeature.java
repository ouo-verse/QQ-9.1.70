package com.tencent.thumbplayer.api.richmedia;

import java.util.ArrayList;

/* loaded from: classes26.dex */
public class TPRichMediaFeature {
    private String mFeatureType;
    private ArrayList<String> mBindings = new ArrayList<>();
    private boolean mIsSelected = false;

    public ArrayList<String> getBindingList() {
        return this.mBindings;
    }

    public String getFeatureType() {
        return this.mFeatureType;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }
}
