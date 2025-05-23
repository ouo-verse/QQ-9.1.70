package com.tencent.mobileqq.guild.feed.publish.result;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.feed.publish.result.AbsResult;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import cooperation.qzone.util.QZoneImageUtils;
import java.util.List;

/* loaded from: classes13.dex */
public class SelectPhotoResult extends AbsResult {

    /* renamed from: b, reason: collision with root package name */
    private a f223169b;

    @Keep
    /* loaded from: classes13.dex */
    public static class SelectPhotoBean {

        @SerializedName("height")
        public int height;

        @SerializedName(QZoneImageUtils.KEY_IMAGE_ID)
        public String imageId;

        @SerializedName(MiniAppGetGameTaskTicketServlet.KEY_TASKID)
        public String taskId;

        @SerializedName("width")
        public int width;

        public SelectPhotoBean(String str, String str2, int i3, int i16) {
            this.taskId = str;
            this.imageId = str2;
            this.width = i3;
            this.height = i16;
        }
    }

    /* loaded from: classes13.dex */
    private static class a {

        @SerializedName("data")
        public List<SelectPhotoBean> data;

        @SerializedName("count")
        private int imageCnt;

        @SerializedName("mainTaskId")
        private String mainTaskId;

        public a(List<SelectPhotoBean> list, String str) {
            int i3;
            this.data = list;
            this.mainTaskId = str;
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            this.imageCnt = i3;
        }
    }

    public SelectPhotoResult(List<SelectPhotoBean> list, String str) {
        this.f223169b = new a(list, str);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected String a() {
        return this.f223160a.toJson(this.f223169b);
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    protected AbsResult.Type b() {
        return AbsResult.Type.SELECT_PHOTO;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }
}
