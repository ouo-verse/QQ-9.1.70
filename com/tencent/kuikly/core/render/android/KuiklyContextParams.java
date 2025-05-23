package com.tencent.kuikly.core.render.android;

import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\b\u0086\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000bB;\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u001f\u0010 J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0017\u0010\u000eR%\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\u000b\u0010\u000e\u00a8\u0006!"}, d2 = {"Lcom/tencent/kuikly/core/render/android/g;", "", "", "d", "e", "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "getPageId", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "pageId", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "b", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "()Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "c", VasWebviewConstants.KEY_PAGE_URL, "", "Ljava/util/Map;", "getPageData", "()Ljava/util/Map;", ISchemeApi.KEY_PAGE_DATA, "assetsPath", "<init>", "(Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.kuikly.core.render.android.g, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class KuiklyContextParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String pageId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final KuiklyRenderCoreExecuteMode executeMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String pageUrl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Map<String, Object> pageData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String assetsPath;

    public KuiklyContextParams(@NotNull KuiklyRenderCoreExecuteMode executeMode, @NotNull String pageUrl, @Nullable Map<String, ? extends Object> map, @Nullable String str) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        Intrinsics.checkNotNullParameter(pageUrl, "pageUrl");
        this.executeMode = executeMode;
        this.pageUrl = pageUrl;
        this.pageData = map;
        this.assetsPath = str;
        this.pageId = "";
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getAssetsPath() {
        return this.assetsPath;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final KuiklyRenderCoreExecuteMode getExecuteMode() {
        return this.executeMode;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPageUrl() {
        return this.pageUrl;
    }

    public final boolean d() {
        return Intrinsics.areEqual(this.pageId, "100000000");
    }

    public final boolean e() {
        Map<String, Object> map = this.pageData;
        if (map != null) {
            return map.containsKey("KT_GLOBAL_PAGER_PAGE_DATA_KEY");
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof KuiklyContextParams) {
                KuiklyContextParams kuiklyContextParams = (KuiklyContextParams) other;
                if (!Intrinsics.areEqual(this.executeMode, kuiklyContextParams.executeMode) || !Intrinsics.areEqual(this.pageUrl, kuiklyContextParams.pageUrl) || !Intrinsics.areEqual(this.pageData, kuiklyContextParams.pageData) || !Intrinsics.areEqual(this.assetsPath, kuiklyContextParams.assetsPath)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pageId = str;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode = this.executeMode;
        int i18 = 0;
        if (kuiklyRenderCoreExecuteMode != null) {
            i3 = kuiklyRenderCoreExecuteMode.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str = this.pageUrl;
        if (str != null) {
            i16 = str.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        Map<String, Object> map = this.pageData;
        if (map != null) {
            i17 = map.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str2 = this.assetsPath;
        if (str2 != null) {
            i18 = str2.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        return "KuiklyContextParams(executeMode=" + this.executeMode + ", pageUrl=" + this.pageUrl + ", pageData=" + this.pageData + ", assetsPath=" + this.assetsPath + ")";
    }
}
