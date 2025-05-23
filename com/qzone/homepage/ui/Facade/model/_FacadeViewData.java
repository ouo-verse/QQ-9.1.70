package com.qzone.homepage.ui.Facade.model;

import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class _FacadeViewData implements SmartParcelable {

    @NeedParcel
    protected ArrayList<ConfigArea> mConfigRect;

    @NeedParcel
    protected DownloadableInfo mCustomFileInfo;

    @NeedParcel
    protected ProfileRectArea mProfileRect;

    public _FacadeViewData(ArrayList<ConfigArea> arrayList, DownloadableInfo downloadableInfo, ProfileRectArea profileRectArea) {
        this();
        this.mConfigRect = arrayList;
        this.mCustomFileInfo = downloadableInfo;
        this.mProfileRect = profileRectArea;
    }

    public ArrayList<ConfigArea> getConfigRect() {
        return this.mConfigRect;
    }

    public DownloadableInfo getCustomFileInfo() {
        return this.mCustomFileInfo;
    }

    public ProfileRectArea getProfileRect() {
        return this.mProfileRect;
    }

    public _FacadeViewData() {
    }
}
