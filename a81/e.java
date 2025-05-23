package a81;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.collection.LruCache;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ark.ark;
import com.tencent.ark.data.ArkAppConfig;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.aio.helper.t;
import com.tencent.mobileqq.aio.msg.ArkMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAppContainer;
import com.tencent.mobileqq.ark.config.ArkMsgReplyConfigMgr;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IArkApi;
import com.tencent.util.Pair;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0002\u0013\u0017B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005J&\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fR \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"La81/e;", "", "", "appName", ark.APP_SPECIFIC_BIZSRC, "", "o", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Integer;", QQCustomArkDialogUtil.APP_VIEW, DomainData.DOMAIN_NAME, "", "messageId", "height", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "p", "", "a", "Ljava/util/Map;", "arkAppHeightMap", "Lb81/b;", "b", "Lb81/b;", "heightHandlerManager", "<init>", "()V", "c", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f25690d;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final List<Pair<String, String>> f25692f;

    /* renamed from: g, reason: collision with root package name */
    private static final int f25693g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final List<Pair<String, String>> f25694h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f25695i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final List<String> f25696j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static LruCache<Long, Integer> f25697k;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f25698l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    private static volatile e f25699m;

    /* renamed from: n, reason: collision with root package name */
    private static float f25700n;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Integer> arkAppHeightMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b81.b heightHandlerManager;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static int f25691e = 900;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b`\u0010aJ(\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0002J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0004H\u0002J'\u0010\u0010\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0012H\u0007J\u0006\u0010\u0016\u001a\u00020\u0012J\u0010\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J4\u0010 \u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\nH\u0007J>\u0010$\u001a\u00020\u001f2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nJ\u000e\u0010'\u001a\u00020\u00192\u0006\u0010&\u001a\u00020%J\u001a\u0010+\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010*\u001a\u0004\u0018\u00010\u0017J,\u0010.\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010*\u001a\u0004\u0018\u00010\u00172\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010&\u001a\u00020%J\u0018\u0010/\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010&\u001a\u00020%J\u0010\u00100\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010\u0017J\u0018\u00101\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010&\u001a\u00020%J\u0006\u00102\u001a\u00020\u000bJ\u0006\u00103\u001a\u00020\u000bR\"\u00104\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001d\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00060@8\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR.\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0013\u0010N\u001a\u0004\u0018\u00010K8F\u00a2\u0006\u0006\u001a\u0004\bL\u0010MR\u0011\u0010P\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\bO\u0010=R\u0014\u0010Q\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010S\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010;R\u0014\u0010T\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010;R6\u0010X\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n W*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n W*\u0004\u0018\u00010\u00060\u00060V0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010BR6\u0010Y\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n W*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n W*\u0004\u0018\u00010\u00060\u00060V0U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010BR\u0014\u0010Z\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bZ\u0010RR\u0016\u0010[\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010]\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u00105R\u0018\u0010^\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_\u00a8\u0006b"}, d2 = {"La81/e$a;", "", "K", "V", "Landroidx/collection/LruCache;", "lruCache", "", "t", "jsonString", "", "", "", "v", "appName", "viewName", NodeProps.MAX_WIDTH, "f", "(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/Integer;", "", "dp", "scale", "a", "e", "Lcom/tencent/ark/data/ArkAppConfig;", "arkConfig", "", "l", "width", "height", "maxWidthPx", "maxHeightPx", "La81/e$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, NodeProps.MIN_WIDTH, NodeProps.MIN_HEIGHT, NodeProps.MAX_HEIGHT, "r", "Lcom/tencent/mobileqq/aio/msg/ArkMsgItem;", "arkMsgItem", "w", "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "arkAppConfig", "o", "Lcom/tencent/aio/api/runtime/a;", "aioContext", DomainData.DOMAIN_NAME, "p", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", ReportConstant.COSTREPORT_PREFIX, "isLocalDebug", "Z", "j", "()Z", "setLocalDebug", "(Z)V", "MAX_VIEW_HEIGHT_IN_AIO", "I", h.F, "()I", "setMAX_VIEW_HEIGHT_IN_AIO", "(I)V", "", "SUPPORT_FAV_APP_NAMES", "Ljava/util/List;", "i", "()Ljava/util/List;", "arkMessageCacheHeight", "Landroidx/collection/LruCache;", "d", "()Landroidx/collection/LruCache;", "setArkMessageCacheHeight", "(Landroidx/collection/LruCache;)V", "La81/e;", "g", "()La81/e;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "c", "aioMaxHeight", "ARK_MESSAGE_HEIGHT_CACHE", "Ljava/lang/String;", "HARD_CODE_SCALED_WIDTH", "HARD_CODE_WIDTH", "", "Lcom/tencent/util/Pair;", "kotlin.jvm.PlatformType", "HARD_CODE_WIDTH_AND_SCALE_APP_VIEW_LIST", "HARD_CODE_WIDTH_APP_VIEW_LIST", "TAG", "density", UserInfo.SEX_FEMALE, "isCacheUpdateNeeded", "mInstance", "La81/e;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: a81.e$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ int b(Companion companion, float f16, float f17, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                f17 = companion.e();
            }
            return companion.a(f16, f17);
        }

        private final <K, V> String t(LruCache<K, V> lruCache) {
            JSONArray jSONArray = new JSONArray();
            Map<K, V> snapshot = lruCache.snapshot();
            Intrinsics.checkNotNullExpressionValue(snapshot, "snapshot");
            for (Map.Entry<K, V> entry : snapshot.entrySet()) {
                K key = entry.getKey();
                V value = entry.getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", String.valueOf(key));
                jSONObject.put("value", String.valueOf(value));
                jSONArray.mo162put(jSONObject);
            }
            String jSONArray2 = jSONArray.toString();
            Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString()");
            return jSONArray2;
        }

        private final void v(String jsonString, LruCache<Long, Integer> lruCache) {
            JSONArray jSONArray = new JSONArray(jsonString);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    String string = jSONObject.getString("key");
                    Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"key\")");
                    long parseLong = Long.parseLong(string);
                    String string2 = jSONObject.getString("value");
                    Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(\"value\")");
                    lruCache.put(Long.valueOf(parseLong), Integer.valueOf(Integer.parseInt(string2)));
                } catch (Exception e16) {
                    QLog.e("ArkApp.ArkHelper", 1, "got exception(" + e16 + ") for parse index " + i3);
                }
            }
        }

        @JvmOverloads
        public final int a(float dp5, float scale) {
            boolean z16;
            if (dp5 == 0.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return 0;
            }
            return (int) ((dp5 * scale) + 0.5f);
        }

        public final int c() {
            return b(this, h(), 0.0f, 2, null);
        }

        @NotNull
        public final LruCache<Long, Integer> d() {
            return e.f25697k;
        }

        public final float e() {
            boolean z16;
            if (e.f25700n == -1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
                Intrinsics.checkNotNullExpressionValue(displayMetrics, "getContext().getResources().getDisplayMetrics()");
                e.f25700n = displayMetrics.density;
                if (e.f25700n <= 0.0f) {
                    e.f25700n = 1.0f;
                }
            }
            return e.f25700n;
        }

        @Nullable
        public final Integer f(@NotNull String appName, @NotNull String viewName, int maxWidth) {
            Intrinsics.checkNotNullParameter(appName, "appName");
            Intrinsics.checkNotNullParameter(viewName, "viewName");
            Pair pair = new Pair(appName, viewName);
            boolean z16 = false;
            if (e.f25692f.contains(pair)) {
                if (1 <= maxWidth && maxWidth < e.f25693g) {
                    z16 = true;
                }
                if (z16) {
                    return Integer.valueOf(maxWidth);
                }
                return Integer.valueOf(e.f25693g);
            }
            if (e.f25694h.contains(pair)) {
                if (1 <= maxWidth && maxWidth < e.f25693g) {
                    z16 = true;
                }
                if (z16) {
                    return Integer.valueOf((int) (maxWidth / 0.96f));
                }
                return Integer.valueOf(e.f25695i);
            }
            return null;
        }

        @Nullable
        public final e g() {
            if (e.f25699m == null) {
                synchronized (e.class) {
                    if (e.f25699m == null) {
                        e.f25699m = new e(null);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return e.f25699m;
        }

        public final int h() {
            return e.f25691e;
        }

        @NotNull
        public final List<String> i() {
            return e.f25696j;
        }

        public final boolean j() {
            return e.f25690d;
        }

        public final boolean k(@Nullable ArkAppConfig arkAppConfig) {
            Integer num;
            Integer num2;
            if (arkAppConfig == null || !TextUtils.equals("normal", arkAppConfig.type) || (num = arkAppConfig.hintWidth) == null) {
                return false;
            }
            if ((num != null && num.intValue() == 0) || (num2 = arkAppConfig.hintHeight) == null) {
                return false;
            }
            if (num2 != null && num2.intValue() == 0) {
                return false;
            }
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0049 A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean l(@Nullable ArkAppConfig arkConfig) {
            boolean z16;
            boolean z17;
            boolean z18;
            if (arkConfig != null && (Intrinsics.areEqual("normal", arkConfig.type) || Intrinsics.areEqual("multiple", arkConfig.type))) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Intrinsics.checkNotNull(arkConfig);
                Integer num = arkConfig.width;
                if (num != null && (num == null || num.intValue() != 0)) {
                    z17 = true;
                    if (z16) {
                        Intrinsics.checkNotNull(arkConfig);
                        Integer num2 = arkConfig.height;
                        if (num2 != null && (num2 == null || num2.intValue() != 0)) {
                            z18 = true;
                            if (!z18 && z17) {
                                return true;
                            }
                            return false;
                        }
                    }
                    z18 = false;
                    if (!z18) {
                    }
                    return false;
                }
            }
            z17 = false;
            if (z16) {
            }
            z18 = false;
            if (!z18) {
            }
            return false;
        }

        public final boolean m(@Nullable com.tencent.qqnt.msg.data.a arkMsgModel, @NotNull ArkMsgItem arkMsgItem) {
            List listOf;
            Intrinsics.checkNotNullParameter(arkMsgItem, "arkMsgItem");
            if (arkMsgModel == null || arkMsgItem.getMsgRecord().chatType != 2) {
                return false;
            }
            if (arkMsgItem.getMsgRecord().sendStatus == 2 || arkMsgItem.getMsgRecord().sendStatus == 1) {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"com.tencent.tuwen.lua", "com.tencent.contact.lua", "com.tencent.music.lua", "com.tencent.miniapp.lua", "com.tencent.multimsg", "com.tencent.map", "com.tencent.gameinvite.lua", "com.tencent.video.lua", "com.tencent.picture.lua", "com.tencent.activity.lua", "com.tencent.structmsg", "com.tencent.mannounce", "com.tencent.miniapp", "com.tencent.tdoc.qqpush", "com.tencent.miniapp_01", "com.tencent.groupphoto", "com.tencent.gamecenter.gameshare", ArkMsgReplyConfigMgr.ARK_REPLY_FROM_TYPE_CARD_ARK_APP, "com.tencent.qzone.albumShare", "com.tencent.gamecenter.gameshare_sgame", "com.tencent.gamecenter.sgamebattle", "com.tencent.qq.checkin", "com.tencent.qzone.albumInvite", "com.tencent.troopsharecard", "com.tencent.creategroupmsg", "com.tencent.qqlover.inviteark", "com.tencent.qun.invite", "com.tencent.qq.signin", "com.tencent.qbox.simpleshare", "com.tencent.template.qqfavorite.share"});
                String d16 = arkMsgModel.d();
                if (d16 == null) {
                    return false;
                }
                return listOf.contains(d16);
            }
            return false;
        }

        public final boolean n(@Nullable com.tencent.qqnt.msg.data.a arkMsgModel, @Nullable ArkAppConfig arkAppConfig, @Nullable com.tencent.aio.api.runtime.a aioContext, @NotNull ArkMsgItem arkMsgItem) {
            ArkAppContainer arkAppContainer;
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(arkMsgItem, "arkMsgItem");
            if (arkMsgModel == null || arkAppConfig == null || aioContext == null) {
                return true;
            }
            t b16 = t.INSTANCE.b(aioContext);
            if (b16 != null) {
                arkAppContainer = b16.o(arkMsgItem.getMsgId());
            } else {
                arkAppContainer = null;
            }
            if (arkAppContainer != null) {
                if (arkAppContainer.getErrorInfo().retCode == -5) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    return false;
                }
            }
            Integer num = arkAppConfig.forward;
            if (num != null && num != null && num.intValue() == 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            boolean canForward = ArkAppConfigMgr.getInstance().canForward(arkMsgModel.d(), arkMsgModel.f(), arkMsgModel.e());
            if (z16 && canForward) {
                return true;
            }
            return false;
        }

        public final boolean o(@Nullable com.tencent.qqnt.msg.data.a arkMsgModel, @Nullable ArkAppConfig arkAppConfig) {
            Integer num;
            if (arkMsgModel == null || arkAppConfig == null || !TextUtils.equals(ArkMsgReplyConfigMgr.ARK_REPLY_FROM_TYPE_CARD_ARK_APP, arkMsgModel.d()) || (num = arkAppConfig.menuMode) == null || num == null || num.intValue() != 1) {
                return true;
            }
            return false;
        }

        public final boolean p(@Nullable com.tencent.qqnt.msg.data.a arkMsgModel, @NotNull ArkMsgItem arkMsgItem) {
            boolean z16;
            Intrinsics.checkNotNullParameter(arkMsgItem, "arkMsgItem");
            if (arkMsgModel == null) {
                return false;
            }
            String d16 = arkMsgModel.d();
            String str = "";
            if (d16 == null) {
                d16 = "";
            }
            String e16 = arkMsgModel.e();
            if (e16 == null) {
                e16 = "";
            }
            String f16 = arkMsgModel.f();
            if (f16 != null) {
                str = f16;
            }
            if (!((IArkApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IArkApi.class)).isSupportReply(d16, e16, str)) {
                return false;
            }
            int i3 = arkMsgItem.getMsgRecord().chatType;
            if (i3 != 1 && i3 != 2) {
                if (i3 != 3) {
                    if (str.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        return false;
                    }
                    return true;
                }
                return !arkMsgItem.isSelf();
            }
            if (arkMsgItem.getMsgRecord().sendStatus != 2) {
                return false;
            }
            return true;
        }

        @JvmOverloads
        @NotNull
        public final b q(float scale, int width, int height, int maxWidthPx, int maxHeightPx) {
            return r(scale, width, height, 30, 30, (int) (maxWidthPx / scale), (int) (maxHeightPx / scale));
        }

        @NotNull
        public final b r(float scale, int width, int height, int minWidth, int minHeight, int maxWidth, int maxHeight) {
            if (minWidth > 0 && width < minWidth) {
                width = minWidth;
            }
            if (minHeight > 0 && height < minHeight) {
                height = minHeight;
            }
            if (maxWidth <= 0 || width <= maxWidth) {
                maxWidth = width;
            }
            if (maxHeight <= 0 || height <= maxHeight) {
                maxHeight = height;
            }
            return new b(a(maxWidth, scale), a(maxHeight, scale));
        }

        public final void s() {
            if (d().size() > 0) {
                return;
            }
            String preferredHeightJson = QMMKV.from(BaseApplication.context, "common_mmkv_configurations").decodeString("ark_message_height_cache", "");
            if (TextUtils.isEmpty(preferredHeightJson)) {
                return;
            }
            try {
                Intrinsics.checkNotNullExpressionValue(preferredHeightJson, "preferredHeightJson");
                v(preferredHeightJson, d());
            } catch (JSONException e16) {
                QLog.e("ArkApp.ArkHelper", 1, "parse json error = " + e16);
            }
        }

        public final void u() {
            if (d().size() != 0 && e.f25698l) {
                QMMKV.from(BaseApplication.context, "common_mmkv_configurations").encodeString("ark_message_height_cache", t(d()));
            }
        }

        public final boolean w(@NotNull ArkMsgItem arkMsgItem) {
            String str;
            boolean z16;
            Intrinsics.checkNotNullParameter(arkMsgItem, "arkMsgItem");
            com.tencent.qqnt.msg.data.a t26 = arkMsgItem.t2();
            String str2 = null;
            if (t26 != null) {
                str = t26.d();
            } else {
                str = null;
            }
            if (t26 != null) {
                str2 = t26.f();
            }
            if (str2 != null && str2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return ArkAppConfigMgr.getInstance().canCollect(str, str2);
            }
            if (str == null || !i().contains(str)) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"La81/e$b;", "", "", "a", "I", "b", "()I", "setWidth", "(I)V", "width", "setHeight", "height", "<init>", "(II)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int width;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int height;

        public b(int i3, int i16) {
            this.width = i3;
            this.height = i16;
        }

        /* renamed from: a, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: b, reason: from getter */
        public final int getWidth() {
            return this.width;
        }
    }

    static {
        List<Pair<String, String>> listOf;
        List<Pair<String, String>> listOf2;
        List<String> mutableListOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("com.tencent.multimsg", "contact"), new Pair("com.tencent.miniapp_01", "view_8C8E89B49BE609866298ADDFF2DBABA4"), new Pair("com.tencent.map", ArkMsgReplyConfigMgr.ARK_REPLY_FROM_TYPE_MAP_STRING)});
        f25692f = listOf;
        f25693g = ViewUtils.dip2px(263.0f);
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair("com.tencent.structmsg", "news"), new Pair("com.tencent.tuwen.lua", "news"), new Pair("com.tencent.miniapp.lua", "miniapp"), new Pair("com.tencent.contact.lua", "contact"), new Pair("com.tencent.troopsharecard", "contact")});
        f25694h = listOf2;
        f25695i = ViewUtils.dip2px(274.0f);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("com.tencent.map", "com.tencent.structmsg", "com.tencent.miniapp_01", ArkMsgReplyConfigMgr.ARK_REPLY_FROM_TYPE_CARD_ARK_APP);
        f25696j = mutableListOf;
        f25697k = new LruCache<>(1000);
        f25700n = -1.0f;
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final String n(String appName, String appView) {
        if (!TextUtils.isEmpty(appName) && !TextUtils.isEmpty(appView)) {
            return appName + "_" + appView;
        }
        return "";
    }

    private final Integer o(String appName, String bizSrc) {
        if (((IArkApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IArkApi.class)).getArkExtendInfo(appName, bizSrc).get("height") != null) {
            return Integer.valueOf((int) (Integer.parseInt(r3) * com.tencent.qqnt.aio.utils.h.b()));
        }
        return null;
    }

    public final int p(long messageId, @NotNull String appName, @NotNull String appView, @NotNull com.tencent.qqnt.msg.data.a arkMsgModel) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(appView, "appView");
        Intrinsics.checkNotNullParameter(arkMsgModel, "arkMsgModel");
        String f16 = arkMsgModel.f();
        if (f16 == null) {
            f16 = "";
        }
        Integer num = f25697k.get(Long.valueOf(messageId));
        if (num != null) {
            if (QLog.isColorLevel()) {
                QLog.i("ArkApp.ArkHelper", 1, appName + " used arkMessageCacheHeight messageId = " + messageId + ", height = " + num);
            }
            return num.intValue();
        }
        Integer valueOf = Integer.valueOf(this.heightHandlerManager.a(arkMsgModel));
        if (valueOf.intValue() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("ArkApp.ArkHelper", 1, appName + " use heightHandlerManager messageId = " + messageId + ", height = " + valueOf);
            }
            return valueOf.intValue();
        }
        Integer num2 = this.arkAppHeightMap.get(n(appName, appView));
        if (num2 == null) {
            num2 = o(appName, f16);
            QLog.d("ArkApp.ArkHelper", 1, "use defaultSize arkHeight = " + num2);
        }
        if (num2 != null) {
            return num2.intValue();
        }
        return -1;
    }

    public final void q(long messageId, @NotNull String appName, @NotNull String appView, int height) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(appView, "appView");
        if (height <= 0) {
            return;
        }
        String n3 = n(appName, appView);
        if (!this.arkAppHeightMap.containsKey(n3)) {
            this.arkAppHeightMap.put(n3, Integer.valueOf(height));
        }
        Integer num = f25697k.get(Long.valueOf(messageId));
        if (num != null && num.intValue() == height) {
            f25698l = true;
        }
        f25697k.put(Long.valueOf(messageId), Integer.valueOf(height));
    }

    e() {
        this.arkAppHeightMap = new HashMap();
        this.heightHandlerManager = new b81.b();
    }
}
