package com.tencent.mobileqq.guild.feed.publish.result;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.feed.publish.result.AbsResult;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;

/* loaded from: classes13.dex */
public class UploadProgressResult extends AbsResult {

    /* renamed from: b, reason: collision with root package name */
    private final UploadProgressData f223174b;

    @Keep
    /* loaded from: classes13.dex */
    public static class UploadProgressData {

        @SerializedName("code")
        public int code;

        @SerializedName("errorCode")
        public int errorCode;

        @SerializedName("errorMsg")
        public String errorMsg;

        @SerializedName("progress")
        public int progress;

        @SerializedName(MiniAppGetGameTaskTicketServlet.KEY_TASKID)
        public String taskId;

        @SerializedName("type")
        public int type;

        public UploadProgressData(String str, int i3, int i16, int i17, int i18, String str2) {
            this.taskId = str;
            this.type = i3;
            this.code = i16;
            this.progress = i17;
            this.errorCode = i18;
            this.errorMsg = str2;
        }
    }

    public UploadProgressResult(String str, int i3, int i16, int i17, int i18, String str2) {
        this.f223174b = new UploadProgressData(str, i3, i16, i17, i18, str2);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected String a() {
        return this.f223160a.toJson(this.f223174b);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected AbsResult.Type b() {
        return AbsResult.Type.UPLOAD_PROGRESS;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }
}
