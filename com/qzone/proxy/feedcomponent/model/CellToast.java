package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_toast;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellToast implements SmartParcelable {

    @NeedParcel
    public String cover = "";

    @NeedParcel
    public String title = "";

    @NeedParcel
    public String content = "";

    @NeedParcel
    public ArrayList<Integer> channels = null;

    @NeedParcel
    public String scenes = "";

    public String toString() {
        return "cover:" + this.cover + ",title:" + this.title + ",content:" + this.content + ",channels:" + this.channels + ",scenes:" + this.scenes;
    }

    public static CellToast create(l lVar) {
        if (lVar == null || lVar.B0 == null) {
            return null;
        }
        CellToast cellToast = new CellToast();
        cell_toast cell_toastVar = lVar.B0;
        cellToast.cover = cell_toastVar.cover;
        cellToast.title = cell_toastVar.title;
        cellToast.content = cell_toastVar.content;
        cellToast.channels = cell_toastVar.channels;
        cellToast.scenes = cell_toastVar.scenes;
        return cellToast;
    }
}
