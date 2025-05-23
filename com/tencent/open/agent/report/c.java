package com.tencent.open.agent.report;

import com.tencent.open.agent.report.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/open/agent/report/c;", "", "Lcom/tencent/open/agent/report/c$a;", "content", "", "a", "Lcom/tencent/open/agent/report/b$a;", "params", "b", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f340529a = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/open/agent/report/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "appId", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "url", "c", "text", "picUrls", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.open.agent.report.c$a, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class QzoneShareContent {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long appId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String url;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String text;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String picUrls;

        public QzoneShareContent(long j3, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.appId = j3;
            this.url = str;
            this.text = str2;
            this.picUrls = str3;
        }

        /* renamed from: a, reason: from getter */
        public final long getAppId() {
            return this.appId;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getPicUrls() {
            return this.picUrls;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getText() {
            return this.text;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof QzoneShareContent)) {
                return false;
            }
            QzoneShareContent qzoneShareContent = (QzoneShareContent) other;
            if (this.appId == qzoneShareContent.appId && Intrinsics.areEqual(this.url, qzoneShareContent.url) && Intrinsics.areEqual(this.text, qzoneShareContent.text) && Intrinsics.areEqual(this.picUrls, qzoneShareContent.picUrls)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int a16 = androidx.fragment.app.a.a(this.appId) * 31;
            String str = this.url;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (a16 + hashCode) * 31;
            String str2 = this.text;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.picUrls;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            return i17 + i3;
        }

        @NotNull
        public String toString() {
            return "QzoneShareContent(appId=" + this.appId + ", url=" + this.url + ", text=" + this.text + ", picUrls=" + this.picUrls + ")";
        }
    }

    c() {
    }

    @JvmStatic
    public static final void a(@Nullable QzoneShareContent content) {
        if (content == null) {
            return;
        }
        QLog.d("DaTongQzoneShareReporter", 4, "reportQzoneShareStart params: " + content.getAppId() + ", url: " + content.getUrl() + ", text: " + content.getText() + ", picUrl: " + content.getPicUrls());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("appid", String.valueOf(content.getAppId()));
        String url = content.getUrl();
        String str = "";
        if (url == null) {
            url = "";
        }
        linkedHashMap.put("share_link", url);
        String text = content.getText();
        if (text == null) {
            text = "";
        }
        linkedHashMap.put("relation_content", text);
        String picUrls = content.getPicUrls();
        if (picUrls != null) {
            str = picUrls;
        }
        linkedHashMap.put("picture_information", str);
        VideoReport.reportEvent("ev_bas_internet_share_share_space", linkedHashMap);
    }

    @JvmStatic
    public static final void b(@Nullable b.a params) {
        String str;
        String str2;
        String str3;
        String picUrl;
        if (params != null) {
            str = params.b();
        } else {
            str = null;
        }
        QLog.d("DaTongQzoneShareReporter", 4, "reportShareClickQzone params: " + str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (params != null) {
            linkedHashMap.put("appid", String.valueOf(params.getAppId()));
            b.ShareContent shareContent = params.getShareContent();
            String str4 = "";
            if (shareContent == null || (str2 = shareContent.getUrl()) == null) {
                str2 = "";
            }
            linkedHashMap.put("share_link", str2);
            b.ShareContent shareContent2 = params.getShareContent();
            if (shareContent2 == null || (str3 = shareContent2.getText()) == null) {
                str3 = "";
            }
            linkedHashMap.put("relation_content", str3);
            b.ShareContent shareContent3 = params.getShareContent();
            if (shareContent3 != null && (picUrl = shareContent3.getPicUrl()) != null) {
                str4 = picUrl;
            }
            linkedHashMap.put("picture_information", str4);
        } else {
            QLog.e("DaTongQzoneShareReporter", 1, "reportShareClickQzone params is null");
        }
        VideoReport.reportEvent("ev_bas_connect_share_friend_space", linkedHashMap);
    }
}
