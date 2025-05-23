package com.tencent.mobileqq.richmedialist.model;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR\u001c\u0010$\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR\u001a\u0010'\u001a\u00020(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001a\u0010.\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u001a\u00101\u001a\u000202X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001b\"\u0004\b9\u0010\u001dR\u001a\u0010:\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\f\"\u0004\b<\u0010\u000e\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/richmedialist/model/FileItemInfo;", "Lcom/tencent/mobileqq/richmedialist/model/BaseItemInfo;", "()V", WadlProxyConsts.CREATE_TIME, "", "getCreateTime", "()J", "setCreateTime", "(J)V", "downloadProgress", "", "getDownloadProgress", "()I", "setDownloadProgress", "(I)V", "downloadSpeed", "getDownloadSpeed", "setDownloadSpeed", "downloadState", "Lcom/tencent/mobileqq/richmedialist/model/DownloadState;", "getDownloadState", "()Lcom/tencent/mobileqq/richmedialist/model/DownloadState;", "setDownloadState", "(Lcom/tencent/mobileqq/richmedialist/model/DownloadState;)V", WadlProxyConsts.PARAM_FILENAME, "", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "fileSize", "getFileSize", "setFileSize", "fileTime", "getFileTime", "setFileTime", "iconPath", "getIconPath", "setIconPath", "isChecked", "", "()Z", "setChecked", "(Z)V", ViewStickEventHelper.IS_SHOW, "setShow", "kFileSize", "getKFileSize", "setKFileSize", "kFileType", "Lcom/tencent/mobileqq/richmedialist/model/ItemType;", "getKFileType", "()Lcom/tencent/mobileqq/richmedialist/model/ItemType;", "setKFileType", "(Lcom/tencent/mobileqq/richmedialist/model/ItemType;)V", "localSavePath", "getLocalSavePath", "setLocalSavePath", "resId", "getResId", "setResId", "RichMediaBrowser_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class FileItemInfo extends BaseItemInfo {
    private long createTime;
    private int downloadProgress;
    private long downloadSpeed;

    @Nullable
    private String fileName;

    @Nullable
    private String fileSize;

    @Nullable
    private String fileTime;

    @Nullable
    private String iconPath;
    private boolean isChecked;
    private boolean isShow;
    private long kFileSize;

    @Nullable
    private String localSavePath;
    private int resId;

    @NotNull
    private DownloadState downloadState = DownloadState.INIT;

    @NotNull
    private ItemType kFileType = ItemType.FILE;

    public final long getCreateTime() {
        return this.createTime;
    }

    public final int getDownloadProgress() {
        return this.downloadProgress;
    }

    public final long getDownloadSpeed() {
        return this.downloadSpeed;
    }

    @NotNull
    public final DownloadState getDownloadState() {
        return this.downloadState;
    }

    @Nullable
    public final String getFileName() {
        return this.fileName;
    }

    @Nullable
    public final String getFileSize() {
        return this.fileSize;
    }

    @Nullable
    public final String getFileTime() {
        return this.fileTime;
    }

    @Nullable
    public final String getIconPath() {
        return this.iconPath;
    }

    public final long getKFileSize() {
        return this.kFileSize;
    }

    @NotNull
    public final ItemType getKFileType() {
        return this.kFileType;
    }

    @Nullable
    public final String getLocalSavePath() {
        return this.localSavePath;
    }

    public final int getResId() {
        return this.resId;
    }

    /* renamed from: isChecked, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    /* renamed from: isShow, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    public final void setChecked(boolean z16) {
        this.isChecked = z16;
    }

    public final void setCreateTime(long j3) {
        this.createTime = j3;
    }

    public final void setDownloadProgress(int i3) {
        this.downloadProgress = i3;
    }

    public final void setDownloadSpeed(long j3) {
        this.downloadSpeed = j3;
    }

    public final void setDownloadState(@NotNull DownloadState downloadState) {
        Intrinsics.checkNotNullParameter(downloadState, "<set-?>");
        this.downloadState = downloadState;
    }

    public final void setFileName(@Nullable String str) {
        this.fileName = str;
    }

    public final void setFileSize(@Nullable String str) {
        this.fileSize = str;
    }

    public final void setFileTime(@Nullable String str) {
        this.fileTime = str;
    }

    public final void setIconPath(@Nullable String str) {
        this.iconPath = str;
    }

    public final void setKFileSize(long j3) {
        this.kFileSize = j3;
    }

    public final void setKFileType(@NotNull ItemType itemType) {
        Intrinsics.checkNotNullParameter(itemType, "<set-?>");
        this.kFileType = itemType;
    }

    public final void setLocalSavePath(@Nullable String str) {
        this.localSavePath = str;
    }

    public final void setResId(int i3) {
        this.resId = i3;
    }

    public final void setShow(boolean z16) {
        this.isShow = z16;
    }
}
