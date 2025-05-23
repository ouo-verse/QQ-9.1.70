package com.tencent.mobileqq.richmedialist.model;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/richmedialist/model/DirectoryItemInfo;", "Lcom/tencent/mobileqq/richmedialist/model/BaseItemInfo;", "()V", WadlProxyConsts.PARAM_FILENAME, "", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "fileTime", "getFileTime", "setFileTime", "iconPath", "getIconPath", "setIconPath", "resId", "", "getResId", "()I", "setResId", "(I)V", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class DirectoryItemInfo extends BaseItemInfo {

    @Nullable
    private String fileName;

    @Nullable
    private String fileTime;

    @Nullable
    private String iconPath;
    private int resId;

    @Nullable
    public final String getFileName() {
        return this.fileName;
    }

    @Nullable
    public final String getFileTime() {
        return this.fileTime;
    }

    @Nullable
    public final String getIconPath() {
        return this.iconPath;
    }

    public final int getResId() {
        return this.resId;
    }

    public final void setFileName(@Nullable String str) {
        this.fileName = str;
    }

    public final void setFileTime(@Nullable String str) {
        this.fileTime = str;
    }

    public final void setIconPath(@Nullable String str) {
        this.iconPath = str;
    }

    public final void setResId(int i3) {
        this.resId = i3;
    }
}
