package com.tencent.ecommerce.repo.consumer.resp;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\fR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\f\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/repo/consumer/resp/GameDownLoadInfo;", "", "()V", "androidDownloadUrl", "", "getAndroidDownloadUrl", "()Ljava/lang/String;", "androidPkgSize", "getAndroidPkgSize", "channelId", "getChannelId", "setChannelId", "(Ljava/lang/String;)V", "contentId", "getContentId", "setContentId", "iconUrl", "getIconUrl", "setIconUrl", PushClientConstants.TAG_PKG_NAME, "getPkgName", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "getTaskId", "setTaskId", "taskKey", "getTaskKey", "setTaskKey", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class GameDownLoadInfo {

    @SerializedName("pkg_name")
    private final String pkgName = "";

    @SerializedName("android_download_url")
    private final String androidDownloadUrl = "";

    @SerializedName("android_pkg_size")
    private final String androidPkgSize = "";

    @SerializedName("channel_id")
    private String channelId = "";

    @SerializedName("spark_task_key")
    private String taskKey = "";

    @SerializedName("spark_task_id")
    private String taskId = "";

    @SerializedName("content_id")
    private String contentId = "";
    private String iconUrl = "";

    public final String getAndroidDownloadUrl() {
        return this.androidDownloadUrl;
    }

    public final String getAndroidPkgSize() {
        return this.androidPkgSize;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getPkgName() {
        return this.pkgName;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTaskKey() {
        return this.taskKey;
    }

    public final void setChannelId(String str) {
        this.channelId = str;
    }

    public final void setContentId(String str) {
        this.contentId = str;
    }

    public final void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public final void setTaskId(String str) {
        this.taskId = str;
    }

    public final void setTaskKey(String str) {
        this.taskKey = str;
    }
}
