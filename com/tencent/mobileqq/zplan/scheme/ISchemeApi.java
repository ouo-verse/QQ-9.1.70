package com.tencent.mobileqq.zplan.scheme;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.vas.transit.TransitPageInfo;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mk3.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.slf4j.Marker;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 B2\u00020\u0001:\u0001CJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J<\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000eH&J<\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\t2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000eH&J4\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000eH&J\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\u001c\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\"\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\"\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0015H&J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!H&J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010%\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0018\u0010'\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u0015H&J(\u0010+\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tH&J(\u0010/\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\tH&J\u001a\u00100\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\u0010\u00101\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u00102\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0018\u00103\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H&J\u001a\u00104\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J$\u00108\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u00106\u001a\u0002052\b\u00107\u001a\u0004\u0018\u00010\u0017H&J4\u00109\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000eH&J4\u0010:\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000eH&J\u0018\u0010<\u001a\u00020;2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH&J4\u0010=\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u000eH&J\u0018\u0010?\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020>H&J\u0012\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/zplan/scheme/ISchemeApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lmk3/a;", "l", "", "registerSchemeHandleListener", "removeSchemeHandleListener", "Landroid/content/Context;", "context", "", "schemeUrl", "launchScheme", "url", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "handleEnterAvatarScheme", "handleOpenPageScheme", "handleToastScheme", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "viewType", "Landroid/os/Bundle;", "bundle", "buildAvatarScheme", "buildCommunityScheme", "mapId", "buildMapScheme", "pageId", "buildPageScheme", "brandId", "buildMallScheme", "", "clothesId", "buildMailScheme", "buildInventoryScheme", "buildActiveListScheme", "pandoraActivityId", "buildActiveDetailScheme", "templateId", "productId", "eventId", "buildClothDesignScheme", "id", "uin", "from", "buildDressDetailScheme", "buildMakeUpPageScheme", "convertSchemeToJsonForReport", "appendRootSourceToScheme", "appendSourceToScheme", "appendPageDataToScheme", "Lcom/tencent/mobileqq/vas/transit/TransitPageInfo;", "info", "ueData", "buildTransitPageScheme", "handleThirdAuthCallback", "handleZplanThirdScheme", "", "shouldInterceptWebToNative", "handleFaceAdScheme", "Lorg/json/JSONObject;", "buildTryOnSameStyleScheme", "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "parseUrl", "Companion", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface ISchemeApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f335317a;

    @NotNull
    public static final String KEY_ENABLE_NEW_TASK = "newTask";

    @NotNull
    public static final String KEY_EXT_DATA = "extData";

    @NotNull
    public static final String KEY_GUILD_ID = "guildId";

    @NotNull
    public static final String KEY_GUILD_ID_TYPE = "guildIdType";

    @NotNull
    public static final String KEY_IOS_SRC_TYPE = "src_type";

    @NotNull
    public static final String KEY_IOS_VERSION = "version";

    @NotNull
    public static final String KEY_NEED_TRANSIT_WHEN_READY = "needShowTransitionPage";

    @NotNull
    public static final String KEY_PAGE_DATA = "pageData";

    @NotNull
    public static final String KEY_PAGE_ID = "pageID";

    @NotNull
    public static final String KEY_PAGE_ID_LOW_CASE = "pageId";

    @NotNull
    public static final String KEY_REFERER = "referer";

    @NotNull
    public static final String KEY_SCENE_DATA = "sceneData";

    @NotNull
    public static final String KEY_SCENE_TYPE = "sceneType";

    @NotNull
    public static final String KEY_STARTUP_ENTER_NUM = "enterNum";

    @NotNull
    public static final String KEY_SUB_REFERER = "subReferer";

    @NotNull
    public static final String KEY_SUB_SCHEME = "subScheme";

    @NotNull
    public static final String KEY_TINY_AVATAR = "tinyAvatar";

    @NotNull
    public static final String KEY_TINY_NICK = "tinyNick";

    @NotNull
    public static final String KEY_TOAST_MODE = "mode";

    @NotNull
    public static final String KEY_TOAST_MSG = "msg";

    @NotNull
    public static final String KEY_TRANSIT_GROUP_ID = "groupId";

    @NotNull
    public static final String KEY_TRANSIT_TYPE = "transitType";

    @NotNull
    public static final String KEY_TRANSIT_UIN = "uin";

    @NotNull
    public static final String KEY_TRANSIT_UI_STYLE = "uiStyle";

    @NotNull
    public static final String SCHEME_ENTER_AVATAR = "mqqapi://zplan/enterAvatarScene?";

    @NotNull
    public static final String SCHEME_OPEN_HOME_CONNECTED = "mqqapi://zplan/openHomeConnected";

    @NotNull
    public static final String SCHEME_OPEN_PAGE = "mqqapi://zplan/openPage?";

    @NotNull
    public static final String SCHEME_PREFIX_ZPLAN = "mqqapi://zplan/";
    public static final int TOAST_MODE_DEFAULT = 0;
    public static final int TOAST_MODE_ERROR = 2;
    public static final int TOAST_MODE_SUCCESS = 1;

    @NotNull
    public static final String VALUE_IOS_SRC_TYPE = "app";

    @NotNull
    public static final String VALUE_IOS_VERSION = "1.0";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/scheme/ISchemeApi$a;", "", "", "originalString", "b", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.scheme.ISchemeApi$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f335317a = new Companion();

        Companion() {
        }

        @NotNull
        public final String a(@NotNull String originalString) {
            Intrinsics.checkNotNullParameter(originalString, "originalString");
            try {
                originalString = URLDecoder.decode(originalString, "UTF-8");
            } catch (Exception e16) {
                QLog.e("ISchemeApi", 1, "decodeString:" + originalString + ", error: " + e16.getMessage());
            }
            Intrinsics.checkNotNullExpressionValue(originalString, "decoded");
            return originalString;
        }

        @NotNull
        public final String b(@NotNull String originalString) {
            String str;
            UnsupportedEncodingException e16;
            String replace$default;
            Intrinsics.checkNotNullParameter(originalString, "originalString");
            try {
                str = URLEncoder.encode(originalString, "UTF-8");
                Intrinsics.checkNotNullExpressionValue(str, "encode(result, \"UTF-8\")");
                try {
                    replace$default = StringsKt__StringsJVMKt.replace$default(str, Marker.ANY_NON_NULL_MARKER, "%20", false, 4, (Object) null);
                    return replace$default;
                } catch (UnsupportedEncodingException e17) {
                    e16 = e17;
                    QLog.e("ISchemeApi", 1, "encode json string error: " + e16.getMessage());
                    return str;
                }
            } catch (UnsupportedEncodingException e18) {
                str = originalString;
                e16 = e18;
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b {
        public static /* synthetic */ String a(ISchemeApi iSchemeApi, ZootopiaSource zootopiaSource, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    bundle = null;
                }
                return iSchemeApi.buildCommunityScheme(zootopiaSource, bundle);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildCommunityScheme");
        }
    }

    @NotNull
    String appendPageDataToScheme(@NotNull String schemeUrl, @Nullable Bundle bundle);

    @NotNull
    String appendRootSourceToScheme(@NotNull String schemeUrl);

    @NotNull
    String appendSourceToScheme(@NotNull String schemeUrl, @NotNull ZootopiaSource source);

    @NotNull
    String buildActiveDetailScheme(@NotNull ZootopiaSource source, int pandoraActivityId);

    @NotNull
    String buildActiveListScheme(@NotNull ZootopiaSource source);

    @NotNull
    String buildAvatarScheme(@NotNull ZootopiaSource source, int viewType, @Nullable Bundle bundle);

    @NotNull
    String buildClothDesignScheme(@NotNull ZootopiaSource source, @NotNull String templateId, @NotNull String productId, @NotNull String eventId);

    @NotNull
    String buildCommunityScheme(@NotNull ZootopiaSource source, @Nullable Bundle bundle);

    @NotNull
    String buildDressDetailScheme(@NotNull ZootopiaSource source, @NotNull String id5, @NotNull String uin, @NotNull String from);

    @NotNull
    String buildInventoryScheme(@NotNull ZootopiaSource source);

    @NotNull
    String buildMailScheme(@NotNull ZootopiaSource source);

    @NotNull
    String buildMakeUpPageScheme(@NotNull ZootopiaSource source, @Nullable Bundle bundle);

    @NotNull
    String buildMallScheme(@NotNull ZootopiaSource source, int brandId);

    @NotNull
    String buildMallScheme(@NotNull ZootopiaSource source, long clothesId);

    @NotNull
    String buildMapScheme(@NotNull ZootopiaSource source, int mapId, @Nullable Bundle bundle);

    @NotNull
    String buildPageScheme(@NotNull ZootopiaSource source, int pageId, @Nullable Bundle bundle);

    @NotNull
    String buildTransitPageScheme(@Nullable ZootopiaSource source, @NotNull TransitPageInfo info, @Nullable Bundle ueData);

    @NotNull
    String buildTryOnSameStyleScheme(@NotNull ZootopiaSource source, @NotNull JSONObject params);

    @NotNull
    String convertSchemeToJsonForReport(@NotNull String schemeUrl);

    void handleEnterAvatarScheme(@NotNull Context context, @NotNull String url, @NotNull HashMap<String, String> params);

    void handleFaceAdScheme(@NotNull Context context, @NotNull HashMap<String, String> params);

    void handleOpenPageScheme(@NotNull Context context, @NotNull String url, @NotNull HashMap<String, String> params);

    void handleThirdAuthCallback(@NotNull Context context, @NotNull HashMap<String, String> params);

    void handleToastScheme(@NotNull Context context, @NotNull HashMap<String, String> params);

    void handleZplanThirdScheme(@NotNull Context context, @NotNull HashMap<String, String> params);

    void launchScheme(@NotNull Context context, @NotNull String schemeUrl);

    @Nullable
    JumpParserResult parseUrl(@NotNull String schemeUrl);

    void registerSchemeHandleListener(@NotNull a l3);

    void removeSchemeHandleListener(@NotNull a l3);

    boolean shouldInterceptWebToNative(@NotNull Context context, @NotNull String url);
}
