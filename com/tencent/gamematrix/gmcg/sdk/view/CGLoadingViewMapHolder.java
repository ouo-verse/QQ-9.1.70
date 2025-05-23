package com.tencent.gamematrix.gmcg.sdk.view;

import com.tencent.gamematrix.gmcg.base.utils.CGFileUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGLoadingViewMapHolder {
    public static final int IMAGE_LOADING_VIEW = 1;
    public static final int VIDEO_LOADING_VIEW = 2;
    private Set<String> mRefGameIds = new LinkedHashSet();
    public String pLoadingPictureColor;
    public String pPath;
    public long pSize;
    public String pUrl;
    public int type;

    CGLoadingViewMapHolder(String str, String str2) {
        this.pUrl = str;
        this.pPath = str2;
        this.pSize = CGFileUtil.getFileSize(str2);
    }

    public static CGLoadingViewMapHolder createLoadingImageViewHolder(String str, String str2) {
        CGLoadingViewMapHolder cGLoadingViewMapHolder = new CGLoadingViewMapHolder(str, str2);
        cGLoadingViewMapHolder.pSize = CGFileUtil.getFileSize(str2);
        cGLoadingViewMapHolder.type = 1;
        return cGLoadingViewMapHolder;
    }

    public static CGLoadingViewMapHolder createLoadingVideoViewHolder(String str, String str2) {
        CGLoadingViewMapHolder cGLoadingViewMapHolder = new CGLoadingViewMapHolder(str, str2);
        cGLoadingViewMapHolder.pSize = CGFileUtil.getFileSize(str2);
        cGLoadingViewMapHolder.type = 2;
        return cGLoadingViewMapHolder;
    }

    public void addRefGameId(String str) {
        this.mRefGameIds.add(str);
    }

    public void clearCached() {
        this.pUrl = null;
        this.pPath = null;
        this.pSize = 0L;
    }

    public boolean hasCached(String str) {
        if (isValid() && this.pUrl.equals(str)) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        if (!CGStringUtil.notEmpty(this.pUrl) || !CGStringUtil.notEmpty(this.pPath)) {
            return false;
        }
        File file = new File(this.pPath);
        if (!file.exists() || !file.isFile() || file.length() != this.pSize) {
            return false;
        }
        return true;
    }

    public int removeRefGameId(String str) {
        this.mRefGameIds.remove(str);
        if (this.mRefGameIds.size() == 0) {
            CGFileUtil.deleteFile(this.pPath);
        }
        return this.mRefGameIds.size();
    }

    public String toString() {
        return "CGLoadingViewMapHolder{pUrl='" + this.pUrl + "', pPath='" + this.pPath + "', pSize=" + this.pSize + ", type=" + this.type + ", pLoadingPictureColor=" + this.pLoadingPictureColor + '}';
    }

    CGLoadingViewMapHolder(String str) {
        this.pUrl = str;
    }
}
