package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class CreateFlashTransferParam {
    public int expireLeftTime;
    public boolean isNeedDelExif;
    public BusiScene scene = BusiScene.values()[0];
    public String name = "";
    public ArrayList<Uploader> uploaders = new ArrayList<>();
    public Permission permission = new Permission();
    public String coverPath = "";
    public ArrayList<CoverOriginalInfo> coverOriginalInfos = new ArrayList<>();
    public ArrayList<String> paths = new ArrayList<>();
    public ArrayList<String> excludePaths = new ArrayList<>();

    public ArrayList<CoverOriginalInfo> getCoverOriginalInfos() {
        return this.coverOriginalInfos;
    }

    public String getCoverPath() {
        return this.coverPath;
    }

    public ArrayList<String> getExcludePaths() {
        return this.excludePaths;
    }

    public int getExpireLeftTime() {
        return this.expireLeftTime;
    }

    public boolean getIsNeedDelExif() {
        return this.isNeedDelExif;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<String> getPaths() {
        return this.paths;
    }

    public Permission getPermission() {
        return this.permission;
    }

    public BusiScene getScene() {
        return this.scene;
    }

    public ArrayList<Uploader> getUploaders() {
        return this.uploaders;
    }
}
