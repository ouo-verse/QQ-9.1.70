package com.tencent.zplan.proxy.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/zplan/proxy/api/IZPlanShareProxy;", "", "", "uin", "Lcom/tencent/zplan/proxy/api/IZPlanShareProxy$ShareData;", "data", "", "a", "b", "ShareData", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface IZPlanShareProxy {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/zplan/proxy/api/IZPlanShareProxy$ShareData;", "Ljava/io/Serializable;", "sameStyleId", "", "contentType", "path", "", "templateTab", "(IILjava/lang/String;I)V", "getContentType", "()I", "getPath", "()Ljava/lang/String;", "getSameStyleId", "getTemplateTab", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "zplan_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final /* data */ class ShareData implements Serializable {
        private final int contentType;

        @NotNull
        private final String path;
        private final int sameStyleId;
        private final int templateTab;

        public ShareData(int i3, int i16, @NotNull String path, int i17) {
            Intrinsics.checkNotNullParameter(path, "path");
            this.sameStyleId = i3;
            this.contentType = i16;
            this.path = path;
            this.templateTab = i17;
        }

        public static /* synthetic */ ShareData copy$default(ShareData shareData, int i3, int i16, String str, int i17, int i18, Object obj) {
            if ((i18 & 1) != 0) {
                i3 = shareData.sameStyleId;
            }
            if ((i18 & 2) != 0) {
                i16 = shareData.contentType;
            }
            if ((i18 & 4) != 0) {
                str = shareData.path;
            }
            if ((i18 & 8) != 0) {
                i17 = shareData.templateTab;
            }
            return shareData.copy(i3, i16, str, i17);
        }

        /* renamed from: component1, reason: from getter */
        public final int getSameStyleId() {
            return this.sameStyleId;
        }

        /* renamed from: component2, reason: from getter */
        public final int getContentType() {
            return this.contentType;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getPath() {
            return this.path;
        }

        /* renamed from: component4, reason: from getter */
        public final int getTemplateTab() {
            return this.templateTab;
        }

        @NotNull
        public final ShareData copy(int sameStyleId, int contentType, @NotNull String path, int templateTab) {
            Intrinsics.checkNotNullParameter(path, "path");
            return new ShareData(sameStyleId, contentType, path, templateTab);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof ShareData) {
                    ShareData shareData = (ShareData) other;
                    if (this.sameStyleId != shareData.sameStyleId || this.contentType != shareData.contentType || !Intrinsics.areEqual(this.path, shareData.path) || this.templateTab != shareData.templateTab) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public final int getContentType() {
            return this.contentType;
        }

        @NotNull
        public final String getPath() {
            return this.path;
        }

        public final int getSameStyleId() {
            return this.sameStyleId;
        }

        public final int getTemplateTab() {
            return this.templateTab;
        }

        public int hashCode() {
            int i3;
            int i16 = ((this.sameStyleId * 31) + this.contentType) * 31;
            String str = this.path;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            return ((i16 + i3) * 31) + this.templateTab;
        }

        @NotNull
        public String toString() {
            return "ShareData(sameStyleId=" + this.sameStyleId + ", contentType=" + this.contentType + ", path=" + this.path + ", templateTab=" + this.templateTab + ")";
        }
    }

    void a(@Nullable String uin, @NotNull ShareData data);

    void b(@NotNull ShareData data);
}
