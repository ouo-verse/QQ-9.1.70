package com.tencent.mobileqq.guild.feed.publish.result;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.feed.publish.result.AbsResult;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.utils.bl;
import cooperation.qzone.util.QZoneImageUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class SelectVideoResult extends AbsResult {

    /* renamed from: b, reason: collision with root package name */
    private final a f223170b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Keep
    /* loaded from: classes13.dex */
    public static class SelectVideoBean {

        @SerializedName("duration")
        public long duration;

        @SerializedName("height")
        public int height;

        @SerializedName(QZoneImageUtils.KEY_IMAGE_ID)
        public String imageId;

        @SerializedName(MiniAppGetGameTaskTicketServlet.KEY_TASKID)
        public String taskId;

        @SerializedName("videoID")
        public String videoId;

        @SerializedName("width")
        public int width;

        public SelectVideoBean(String str, String str2, long j3, String str3, int i3, int i16) {
            this.taskId = str;
            this.videoId = str2;
            this.duration = j3;
            this.imageId = str3;
            this.width = i3;
            this.height = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    private static class a {

        @SerializedName("mainTaskId")
        private String mainTaskId;

        @SerializedName("count")
        private int videoCnt;

        @SerializedName("data")
        public List<SelectVideoBean> videoDataList = new ArrayList();

        public a(String str, int i3) {
            this.mainTaskId = str;
            this.videoCnt = i3;
        }

        public boolean a() {
            for (SelectVideoBean selectVideoBean : this.videoDataList) {
                if (Math.min(selectVideoBean.width, selectVideoBean.height) < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public SelectVideoResult(String str, int i3) {
        this.f223170b = new a(str, i3);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected String a() {
        return this.f223160a.toJson(this.f223170b);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected AbsResult.Type b() {
        return AbsResult.Type.SELECT_VIDEO;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }

    public void d(String str, String str2, long j3, String str3) {
        this.f223170b.videoDataList.add(new SelectVideoBean(str, str2, j3, str3, -1, -1));
    }

    public boolean e() {
        return this.f223170b.a();
    }

    public void f(String str, int i3, int i16) {
        if (bl.b(this.f223170b.videoDataList)) {
            return;
        }
        for (SelectVideoBean selectVideoBean : this.f223170b.videoDataList) {
            if (TextUtils.equals(selectVideoBean.taskId, str)) {
                selectVideoBean.width = Math.max(i3, 0);
                selectVideoBean.height = Math.max(i16, 0);
                return;
            }
        }
    }
}
