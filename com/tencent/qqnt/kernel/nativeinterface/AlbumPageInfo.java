package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class AlbumPageInfo {
    public int albumNum;
    public int photoNum;
    public int videoNum;
    public ArrayList<Integer> masks = new ArrayList<>();
    public ArrayList<ToolBox> tools = new ArrayList<>();

    public int getAlbumNum() {
        return this.albumNum;
    }

    public ArrayList<Integer> getMasks() {
        return this.masks;
    }

    public int getPhotoNum() {
        return this.photoNum;
    }

    public ArrayList<ToolBox> getTools() {
        return this.tools;
    }

    public int getVideoNum() {
        return this.videoNum;
    }
}
