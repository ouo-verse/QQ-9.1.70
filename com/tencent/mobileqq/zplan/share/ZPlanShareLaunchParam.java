package com.tencent.mobileqq.zplan.share;

import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0015\u0018\u0000 42\u00020\u0001:\u00015B\u00b9\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040!\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040!\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\u0016\b\u0002\u00100\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012\u00a2\u0006\u0004\b2\u00103J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\bR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR%\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R0\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017\"\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010&\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040!8\u0006\u00a2\u0006\f\n\u0004\b*\u0010#\u001a\u0004\b+\u0010%R\u0017\u0010,\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R%\u00100\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u0015\u001a\u0004\b1\u0010\u0017\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", "Ljava/io/Serializable;", "", "isARKType", "", "shareType", "I", "getShareType", "()I", "", "uin", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "contentType", "getContentType", "contentPath", "getContentPath", "", "", "bizExtraParams", "Ljava/util/Map;", "getBizExtraParams", "()Ljava/util/Map;", "shareExtraParams", "getShareExtraParams", "setShareExtraParams", "(Ljava/util/Map;)V", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "", "contentPlatform", "[Ljava/lang/Integer;", "getContentPlatform", "()[Ljava/lang/Integer;", "uinType", "Ljava/lang/Integer;", "getUinType", "()Ljava/lang/Integer;", "operationItems", "getOperationItems", "needMask", "Z", "getNeedMask", "()Z", "reportExtraParams", "getReportExtraParams", "<init>", "(ILjava/lang/String;ILjava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;[Ljava/lang/Integer;Ljava/lang/Integer;[Ljava/lang/Integer;ZLjava/util/Map;)V", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ZPlanShareLaunchParam implements Serializable {
    public static final int CONTENT_PLATFORM_GUILD = 5;
    public static final int CONTENT_PLATFORM_LITTLE_WORD = 4;
    public static final int CONTENT_PLATFORM_QQ = 0;
    public static final int CONTENT_PLATFORM_QZONE = 1;
    public static final int CONTENT_PLATFORM_WECHAT = 2;
    public static final int CONTENT_PLATFORM_WECHAT_FRIEND = 3;
    public static final int CONTENT_TYPE_ARK_WITH_IMG = 2;
    public static final int CONTENT_TYPE_ARK_WITH_VIDEO = 3;
    public static final int CONTENT_TYPE_IMG = 0;
    public static final int CONTENT_TYPE_STRUCT_MSG = 4;
    public static final int CONTENT_TYPE_UNKNOWN = -1;
    public static final int CONTENT_TYPE_VIDEO = 1;

    @NotNull
    public static final String KEY_BIZ_SAMESTYLE_ID = "samestyle_id";

    @NotNull
    public static final String KEY_BIZ_SMALL_HOME_EXT = "small_home_ext";

    @NotNull
    public static final String KEY_BIZ_SMALL_HOME_SCENE = "small_home_scene";

    @NotNull
    public static final String KEY_BIZ_TEMPLATE_TAB = "template_tab";
    public static final int OPERATION_COPY_LINK = 2;
    public static final int OPERATION_SAVE = 1;

    @NotNull
    public static final String REQ_SHARE_TYPE_LUCKY_DOG = "1";

    @NotNull
    public static final String REQ_SHARE_TYPE_SHOT = "0";
    public static final int SHARE_TYPE_DRESS = 2;
    public static final int SHARE_TYPE_MEETING_URL = 8;
    public static final int SHARE_TYPE_QQ_ARK = 6;
    public static final int SHARE_TYPE_SAME_STYLE_VIDEO = 0;
    public static final int SHARE_TYPE_SMALL_HOME = 1;
    public static final int SHARE_TYPE_SMALL_HOME_SHOT = 4;
    public static final int SHARE_TYPE_SQUARE = 3;
    public static final int SHARE_TYPE_SQUARE_MAIN_PAGE = 7;
    public static final int SHARE_TYPE_SQUARE_POSTER = 5;
    public static final int SHARE_TYPE_UNKNOWN = -1;
    public static final int SHARE_TYPE_WINK_TEMPLATE = 1000;

    @Nullable
    private final Map<String, Object> bizExtraParams;

    @NotNull
    private final String contentPath;

    @NotNull
    private final Integer[] contentPlatform;
    private final int contentType;
    private final boolean needMask;

    @NotNull
    private final Integer[] operationItems;

    @Nullable
    private final Map<String, Object> reportExtraParams;

    @Nullable
    private Map<String, ? extends Object> shareExtraParams;
    private final int shareType;

    @NotNull
    private final ZootopiaSource source;

    @Nullable
    private final String uin;

    @Nullable
    private final Integer uinType;

    public ZPlanShareLaunchParam() {
        this(0, null, 0, null, null, null, null, null, null, null, false, null, 4095, null);
    }

    @Nullable
    public final Map<String, Object> getBizExtraParams() {
        return this.bizExtraParams;
    }

    @NotNull
    public final String getContentPath() {
        return this.contentPath;
    }

    @NotNull
    public final Integer[] getContentPlatform() {
        return this.contentPlatform;
    }

    public final int getContentType() {
        return this.contentType;
    }

    public final boolean getNeedMask() {
        return this.needMask;
    }

    @NotNull
    public final Integer[] getOperationItems() {
        return this.operationItems;
    }

    @Nullable
    public final Map<String, Object> getReportExtraParams() {
        return this.reportExtraParams;
    }

    @Nullable
    public final Map<String, Object> getShareExtraParams() {
        return this.shareExtraParams;
    }

    public final int getShareType() {
        return this.shareType;
    }

    @NotNull
    public final ZootopiaSource getSource() {
        return this.source;
    }

    @Nullable
    public final String getUin() {
        return this.uin;
    }

    @Nullable
    public final Integer getUinType() {
        return this.uinType;
    }

    public final boolean isARKType() {
        int i3 = this.contentType;
        if (i3 != 2 && i3 != 3) {
            return false;
        }
        return true;
    }

    public final void setShareExtraParams(@Nullable Map<String, ? extends Object> map) {
        this.shareExtraParams = map;
    }

    public ZPlanShareLaunchParam(int i3, @Nullable String str, int i16, @NotNull String contentPath, @Nullable Map<String, ? extends Object> map, @Nullable Map<String, ? extends Object> map2, @NotNull ZootopiaSource source, @NotNull Integer[] contentPlatform, @Nullable Integer num, @NotNull Integer[] operationItems, boolean z16, @Nullable Map<String, ? extends Object> map3) {
        Intrinsics.checkNotNullParameter(contentPath, "contentPath");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(contentPlatform, "contentPlatform");
        Intrinsics.checkNotNullParameter(operationItems, "operationItems");
        this.shareType = i3;
        this.uin = str;
        this.contentType = i16;
        this.contentPath = contentPath;
        this.bizExtraParams = map;
        this.shareExtraParams = map2;
        this.source = source;
        this.contentPlatform = contentPlatform;
        this.uinType = num;
        this.operationItems = operationItems;
        this.needMask = z16;
        this.reportExtraParams = map3;
    }

    public /* synthetic */ ZPlanShareLaunchParam(int i3, String str, int i16, String str2, Map map, Map map2, ZootopiaSource zootopiaSource, Integer[] numArr, Integer num, Integer[] numArr2, boolean z16, Map map3, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? -1 : i3, (i17 & 2) != 0 ? null : str, (i17 & 4) != 0 ? -1 : i16, (i17 & 8) != 0 ? "" : str2, (i17 & 16) != 0 ? null : map, (i17 & 32) != 0 ? null : map2, (i17 & 64) != 0 ? ZootopiaSource.INSTANCE.a(Source.UnSet) : zootopiaSource, (i17 & 128) != 0 ? new Integer[]{0, 1, 4} : numArr, (i17 & 256) != 0 ? -1 : num, (i17 & 512) != 0 ? new Integer[]{1} : numArr2, (i17 & 1024) == 0 ? z16 : true, (i17 & 2048) == 0 ? map3 : null);
    }
}
