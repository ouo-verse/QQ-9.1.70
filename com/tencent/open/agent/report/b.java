package com.tencent.open.agent.report;

import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0003\f\u000b\u0005J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/open/agent/report/b;", "", "Lcom/tencent/open/agent/report/b$a;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "c", "Landroid/view/View;", "view", "i", "d", "g", "b", "a", "e", h.F, "", "positive", "f", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public interface b {

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0005\u001a\u00020\u0003R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/open/agent/report/b$a;", "", "", "", "f", "b", "", "a", "J", "()J", "appId", "Lcom/tencent/open/agent/report/b$b;", "Lcom/tencent/open/agent/report/b$b;", "c", "()Lcom/tencent/open/agent/report/b$b;", "e", "(Lcom/tencent/open/agent/report/b$b;)V", "shareContent", "", "Lcom/tencent/open/agent/report/b$c;", "Ljava/util/List;", "d", "()Ljava/util/List;", "shareTargetList", "", "Z", "isMultiSelect", "()Z", "setMultiSelect", "(Z)V", "<init>", "(J)V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long appId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ShareContent shareContent;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<ShareTarget> shareTargetList = new ArrayList();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isMultiSelect;

        public a(long j3) {
            this.appId = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getAppId() {
            return this.appId;
        }

        @NotNull
        public final String b() {
            return "ReportParams[" + this.appId + "] shareContent: " + this.shareContent + ", multiSelect: " + this.isMultiSelect + ", targetList: " + this.shareTargetList;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final ShareContent getShareContent() {
            return this.shareContent;
        }

        @NotNull
        public final List<ShareTarget> d() {
            return this.shareTargetList;
        }

        public final void e(@Nullable ShareContent shareContent) {
            this.shareContent = shareContent;
        }

        @NotNull
        public final Map<String, String> f() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("appid", String.valueOf(this.appId));
            ShareContent shareContent = this.shareContent;
            if (shareContent != null) {
                String url = shareContent.getUrl();
                String str = "";
                if (url == null) {
                    url = "";
                }
                linkedHashMap.put("share_link", url);
                String text = shareContent.getText();
                if (text == null) {
                    text = "";
                }
                linkedHashMap.put("relation_content", text);
                String picUrl = shareContent.getPicUrl();
                if (picUrl != null) {
                    str = picUrl;
                }
                linkedHashMap.put("picture_information", str);
            }
            return linkedHashMap;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/open/agent/report/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getShareType", "()I", "shareType", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "url", "text", "d", "picUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.open.agent.report.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class ShareContent {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int shareType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String url;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String text;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String picUrl;

        public ShareContent(int i3, @Nullable String str, @Nullable String str2, @Nullable String str3) {
            this.shareType = i3;
            this.url = str;
            this.text = str2;
            this.picUrl = str3;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getPicUrl() {
            return this.picUrl;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getText() {
            return this.text;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShareContent)) {
                return false;
            }
            ShareContent shareContent = (ShareContent) other;
            if (this.shareType == shareContent.shareType && Intrinsics.areEqual(this.url, shareContent.url) && Intrinsics.areEqual(this.text, shareContent.text) && Intrinsics.areEqual(this.picUrl, shareContent.picUrl)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int i3 = this.shareType * 31;
            String str = this.url;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str2 = this.text;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i18 = (i17 + hashCode2) * 31;
            String str3 = this.picUrl;
            if (str3 != null) {
                i16 = str3.hashCode();
            }
            return i18 + i16;
        }

        @NotNull
        public String toString() {
            return "ShareContent(shareType=" + this.shareType + ", url=" + this.url + ", text=" + this.text + ", picUrl=" + this.picUrl + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/open/agent/report/b$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "type", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "uin", "<init>", "(ILjava/lang/String;)V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.open.agent.report.b$c, reason: from toString */
    /* loaded from: classes22.dex */
    public static final /* data */ class ShareTarget {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String uin;

        public ShareTarget(int i3, @NotNull String uin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            this.type = i3;
            this.uin = uin;
        }

        /* renamed from: a, reason: from getter */
        public final int getType() {
            return this.type;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShareTarget)) {
                return false;
            }
            ShareTarget shareTarget = (ShareTarget) other;
            if (this.type == shareTarget.type && Intrinsics.areEqual(this.uin, shareTarget.uin)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.type * 31) + this.uin.hashCode();
        }

        @NotNull
        public String toString() {
            return "ShareTarget(type=" + this.type + ", uin=" + this.uin + ")";
        }
    }

    void a(@Nullable a reportParams);

    void b(@Nullable View view, @Nullable a reportParams);

    void c(@Nullable a reportParams);

    void d(@Nullable a reportParams);

    void e(@Nullable a reportParams);

    void f(boolean positive, @Nullable a reportParams);

    void g(@Nullable a reportParams);

    void h(@Nullable View view, @Nullable a reportParams);

    void i(@Nullable View view, @Nullable a reportParams);
}
