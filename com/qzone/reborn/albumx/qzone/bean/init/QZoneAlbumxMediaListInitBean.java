package com.qzone.reborn.albumx.qzone.bean.init;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b\u00a8\u0006\u001c"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxMediaListInitBean;", "Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxInitBean;", "()V", "classifyId", "", "getClassifyId", "()Ljava/lang/String;", "setClassifyId", "(Ljava/lang/String;)V", "mediaCount", "", "getMediaCount", "()I", "setMediaCount", "(I)V", "mediaDisplayName", "getMediaDisplayName", "setMediaDisplayName", "selectArg", "getSelectArg", "setSelectArg", "subClassifyId", "getSubClassifyId", "setSubClassifyId", "templateId", "getTemplateId", "setTemplateId", "toString", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZoneAlbumxMediaListInitBean extends QZoneAlbumxInitBean {
    private int mediaCount;
    private String classifyId = "";
    private String subClassifyId = "";
    private String selectArg = "";
    private String templateId = "";
    private String mediaDisplayName = "";

    public final String getClassifyId() {
        return this.classifyId;
    }

    public final int getMediaCount() {
        return this.mediaCount;
    }

    public final String getMediaDisplayName() {
        return this.mediaDisplayName;
    }

    public final String getSelectArg() {
        return this.selectArg;
    }

    public final String getSubClassifyId() {
        return this.subClassifyId;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final void setClassifyId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.classifyId = str;
    }

    public final void setMediaCount(int i3) {
        this.mediaCount = i3;
    }

    public final void setMediaDisplayName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mediaDisplayName = str;
    }

    public final void setSelectArg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectArg = str;
    }

    public final void setSubClassifyId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subClassifyId = str;
    }

    public final void setTemplateId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.templateId = str;
    }

    public String toString() {
        return "QZoneAlbumxMediaListInitBean(classifyId=" + this.classifyId + ", subClassifyId=" + this.subClassifyId + ", selectArg=" + this.selectArg + ", mediaCount=" + this.mediaCount + ", mediaDisplayName=" + this.mediaDisplayName + ", templateId=" + this.templateId + ")";
    }
}
