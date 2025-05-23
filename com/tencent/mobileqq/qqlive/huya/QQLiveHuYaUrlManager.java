package com.tencent.mobileqq.qqlive.huya;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0006R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYaUrlManager;", "", "", "roomId", "Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYaUrlManager$HuYaUrlInfo;", "urlInfo", "", "c", "", "level", "b", "a", "", "Ljava/util/Map;", "streamCache", "<init>", "()V", "HuYaUrlInfo", "qq-live-huya_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveHuYaUrlManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QQLiveHuYaUrlManager f271340a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Long, HuYaUrlInfo> streamCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqlive/huya/QQLiveHuYaUrlManager$HuYaUrlInfo;", "Ljava/io/Serializable;", "originUrl", "", "urlWithToken", "level", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getLevel", "()I", "getOriginUrl", "()Ljava/lang/String;", "getUrlWithToken", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "qq-live-huya_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final /* data */ class HuYaUrlInfo implements Serializable {
        static IPatchRedirector $redirector_;
        private final int level;

        @NotNull
        private final String originUrl;

        @NotNull
        private final String urlWithToken;

        public HuYaUrlInfo(@NotNull String originUrl, @NotNull String urlWithToken, int i3) {
            Intrinsics.checkNotNullParameter(originUrl, "originUrl");
            Intrinsics.checkNotNullParameter(urlWithToken, "urlWithToken");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, originUrl, urlWithToken, Integer.valueOf(i3));
                return;
            }
            this.originUrl = originUrl;
            this.urlWithToken = urlWithToken;
            this.level = i3;
        }

        public static /* synthetic */ HuYaUrlInfo copy$default(HuYaUrlInfo huYaUrlInfo, String str, String str2, int i3, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                str = huYaUrlInfo.originUrl;
            }
            if ((i16 & 2) != 0) {
                str2 = huYaUrlInfo.urlWithToken;
            }
            if ((i16 & 4) != 0) {
                i3 = huYaUrlInfo.level;
            }
            return huYaUrlInfo.copy(str, str2, i3);
        }

        @NotNull
        public final String component1() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.originUrl;
        }

        @NotNull
        public final String component2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.urlWithToken;
        }

        public final int component3() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.level;
        }

        @NotNull
        public final HuYaUrlInfo copy(@NotNull String originUrl, @NotNull String urlWithToken, int level) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (HuYaUrlInfo) iPatchRedirector.redirect((short) 8, this, originUrl, urlWithToken, Integer.valueOf(level));
            }
            Intrinsics.checkNotNullParameter(originUrl, "originUrl");
            Intrinsics.checkNotNullParameter(urlWithToken, "urlWithToken");
            return new HuYaUrlInfo(originUrl, urlWithToken, level);
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof HuYaUrlInfo)) {
                return false;
            }
            HuYaUrlInfo huYaUrlInfo = (HuYaUrlInfo) other;
            if (Intrinsics.areEqual(this.originUrl, huYaUrlInfo.originUrl) && Intrinsics.areEqual(this.urlWithToken, huYaUrlInfo.urlWithToken) && this.level == huYaUrlInfo.level) {
                return true;
            }
            return false;
        }

        public final int getLevel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.level;
        }

        @NotNull
        public final String getOriginUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.originUrl;
        }

        @NotNull
        public final String getUrlWithToken() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.urlWithToken;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return (((this.originUrl.hashCode() * 31) + this.urlWithToken.hashCode()) * 31) + this.level;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "HuYaUrlInfo(originUrl=" + this.originUrl + ", urlWithToken=" + this.urlWithToken + ", level=" + this.level + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34336);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f271340a = new QQLiveHuYaUrlManager();
            streamCache = new LinkedHashMap();
        }
    }

    QQLiveHuYaUrlManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            streamCache.clear();
        }
    }

    @Nullable
    public final HuYaUrlInfo b(long roomId, int level) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HuYaUrlInfo) iPatchRedirector.redirect((short) 3, this, Long.valueOf(roomId), Integer.valueOf(level));
        }
        HuYaUrlInfo huYaUrlInfo = streamCache.get(Long.valueOf(roomId));
        if (huYaUrlInfo == null || huYaUrlInfo.getLevel() != level) {
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        return huYaUrlInfo;
    }

    public final void c(long roomId, @NotNull HuYaUrlInfo urlInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(roomId), urlInfo);
        } else {
            Intrinsics.checkNotNullParameter(urlInfo, "urlInfo");
            streamCache.put(Long.valueOf(roomId), urlInfo);
        }
    }
}
