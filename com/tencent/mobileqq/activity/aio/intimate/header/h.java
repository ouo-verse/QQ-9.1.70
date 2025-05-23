package com.tencent.mobileqq.activity.aio.intimate.header;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\bt\u0018\u0000 ~2\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b|\u0010}J\u0018\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0002H\u0002J\u0012\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007*\u00020\u0006H\u0002J\u001e\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0003*\u00020\u0002H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004R\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\r\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b&\u0010\u0012R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000e\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012R\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u0012R\"\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b.\u0010\u0012R\"\u00103\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u000e\u001a\u0004\b1\u0010\u0010\"\u0004\b2\u0010\u0012R\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010\u000e\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\"\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u000e\u001a\u0004\b9\u0010\u0010\"\u0004\b:\u0010\u0012R\"\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\u000e\u001a\u0004\b=\u0010\u0010\"\u0004\b>\u0010\u0012R.\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\b\u001a\u0010B\"\u0004\bC\u0010DR(\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR.\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010A\u001a\u0004\bN\u0010B\"\u0004\bO\u0010DR.\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010A\u001a\u0004\bR\u0010B\"\u0004\bS\u0010DR.\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010A\u001a\u0004\bV\u0010B\"\u0004\bW\u0010DR.\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010A\u001a\u0004\bZ\u0010B\"\u0004\b[\u0010DR.\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010A\u001a\u0004\b^\u0010B\"\u0004\b_\u0010DR4\u0010d\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010A\u001a\u0004\bb\u0010B\"\u0004\bc\u0010DR.\u0010h\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010A\u001a\u0004\bf\u0010B\"\u0004\bg\u0010DR\"\u0010l\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010\u000e\u001a\u0004\bj\u0010\u0010\"\u0004\bk\u0010\u0012R\"\u0010o\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010\u000e\u001a\u0004\b\"\u0010\u0010\"\u0004\bn\u0010\u0012R\"\u0010s\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010\u000e\u001a\u0004\bq\u0010\u0010\"\u0004\br\u0010\u0012R(\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010G\u001a\u0004\bu\u0010I\"\u0004\bv\u0010KR(\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010G\u001a\u0004\by\u0010I\"\u0004\bz\u0010K\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/h;", "Lcom/tencent/freesia/IConfigData;", "Lorg/json/JSONObject;", "", "", "E", "Lorg/json/JSONArray;", "", BdhLogUtil.LogTag.Tag_Conn, "D", "content", "", UserInfo.SEX_FEMALE, "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setDrawerBgUrl", "(Ljava/lang/String;)V", "drawerBgUrl", "setCardTopBigIconUrl", "cardTopBigIconUrl", "f", "c", "setCardLineBgUrl", "cardLineBgUrl", tl.h.F, "B", "setUnselectedTabIconUrl", "unselectedTabIconUrl", "i", HippyTKDListViewAdapter.X, "setSelectedTabIconUrl", "selectedTabIconUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "setSelectedTabBgUrl", "selectedTabBgUrl", "setGameDrawerBgUrl", "gameDrawerBgUrl", "j", "setGameHeaderCharUrl", "gameHeaderCharUrl", "g", "setGameCardRootBgUrl", "gameCardRootBgUrl", "setGameCardLineBgUrl", "gameCardLineBgUrl", "G", "l", "setGameShareBgUrl", "gameShareBgUrl", "H", "a", "setBindGameJumpUrl", "bindGameJumpUrl", "I", "b", "setBindIntimateJumpUrl", "bindIntimateJumpUrl", "J", "t", "setNewIntimateJumpUrl", "newIntimateJumpUrl", "K", "Ljava/util/Map;", "()Ljava/util/Map;", "setGameDetailUrl", "(Ljava/util/Map;)V", "gameDetailUrl", "L", "Ljava/util/List;", "k", "()Ljava/util/List;", "setGamePartnerType", "(Ljava/util/List;)V", "gamePartnerType", "M", "r", "setHeadCardTextColor", "headCardTextColor", "N", "p", "setHeadCardLabel", "headCardLabel", "P", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setShareTextColor", "shareTextColor", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "setShareSubTextColor", "shareSubTextColor", BdhLogUtil.LogTag.Tag_Req, "y", "setShareBottomLabel", "shareBottomLabel", ExifInterface.LATITUDE_SOUTH, "o", "setHeadCardColor", "headCardColor", "T", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setHeadCardProcessBarColor", "headCardProcessBarColor", "U", "u", "setNoElegantCardIconUrl", "noElegantCardIconUrl", "V", "setGenericCardGroupTitle", "genericCardGroupTitle", "W", "v", "setNovelGroupTitle", "novelGroupTitle", "X", DomainData.DOMAIN_NAME, "setHalfWebViewId", "halfWebViewId", "Y", ReportConstant.COSTREPORT_PREFIX, "setNewIntimateJumpId", "newIntimateJumpId", "<init>", "()V", "Z", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class h implements IConfigData {

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private Map<String, String> gameDetailUrl;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private List<String> gamePartnerType;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private Map<String, String> headCardTextColor;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private Map<String, String> headCardLabel;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private Map<String, String> shareTextColor;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private Map<String, String> shareSubTextColor;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private Map<String, String> shareBottomLabel;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private Map<String, List<String>> headCardColor;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private Map<String, String> headCardProcessBarColor;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private String noElegantCardIconUrl;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private String genericCardGroupTitle;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private String novelGroupTitle;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private List<String> halfWebViewId;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private List<String> newIntimateJumpId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String drawerBgUrl = "https://downv6.qq.com/qqweb/res/mutualmark/aio_rightframe/drawer_bg_{type}_{isNight}.png";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String cardTopBigIconUrl = "https://downv6.qq.com/qqweb/res/mutualmark/aio_rightframe/icon_type_{type}_level_{level}.png";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String cardLineBgUrl = "https://downv6.qq.com/qqweb/res/mutualmark/aio_rightframe/bg_type_{type}.png";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String unselectedTabIconUrl = "https://downv6.qq.com/qqweb/res/mutualmark/aio_rightframe/smallicon_type_{type}_level_{level}.png";

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String selectedTabIconUrl = "https://downv6.qq.com/qqweb/res/mutualmark/aio_rightframe/intimate_icon_selected_{type}.png";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String selectedTabBgUrl = "https://downv6.qq.com/qqweb/res/mutualmark/aio_rightframe/intimate_tab_selected_bg_{type}_{isNight}.png";

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String gameDrawerBgUrl = "https://downv6.qq.com/qqweb/res/mutualmark/aio_rightframe/drawer_bg_{type}_{level}_{isNight}.png";

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String gameHeaderCharUrl = "https://downv6.qq.com/qqweb/res/mutualmark/aio_rightframe/intimate_header_game_character_{type}.png";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String gameCardRootBgUrl = "https://downv6.qq.com/qqweb/res/mutualmark/aio_rightframe/intimate_header_game_card_{type}_{level}_{isNight}.png";

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String gameCardLineBgUrl = "https://downv6.qq.com/qqweb/res/mutualmark/aio_rightframe/game_bg_type_{type}_{isNight}.png";

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String gameShareBgUrl = "https://downv6.qq.com/qqweb/res/mutualmark/aio_rightframe/intimate_share_bg_{type}.png";

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String bindGameJumpUrl = "https://ti.qq.com/hybrid-h5/intimate/partner_invite?touin={touin}&fromuin={fromuin}&mutualmark_id={mutualmark_id}&_wv=67108867&_nav_txtclr=000000&_wvSb=0";

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String bindIntimateJumpUrl = "https://ti.qq.com/hybrid-h5/intimate/launch_v3?_wv=67108867&_wvx=2&_nav_txtclr=000000&_wvSb=0&uin={touin}";

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String newIntimateJumpUrl = "https://ti.qq.com/hybrid-h5/intimate/dialog_invite?_cntclr=00000000&_wv=3&_wwv=1&uin={uin}&id={id}";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/h$a;", "", "", "content", "Lcom/tencent/mobileqq/activity/aio/intimate/header/h;", "a", "HALF_SCREEN_PREFIX", "Ljava/lang/String;", "TAG", "defaultHeight", "height", "urlFromUin", "urlId", "urlMutualMarkId", "urlToUin", "urlUin", "yuanMengHeight", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.aio.intimate.header.h$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final h a(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            h hVar = new h();
            hVar.F(content);
            return hVar;
        }

        Companion() {
        }
    }

    public h() {
        Map<String, String> mutableMapOf;
        List<String> mutableListOf;
        Map<String, String> mutableMapOf2;
        Map<String, String> mutableMapOf3;
        Map<String, String> mutableMapOf4;
        Map<String, String> mutableMapOf5;
        Map<String, String> mutableMapOf6;
        List mutableListOf2;
        List mutableListOf3;
        List mutableListOf4;
        List mutableListOf5;
        List mutableListOf6;
        Map<String, List<String>> mutableMapOf7;
        Map<String, String> mutableMapOf8;
        List<String> mutableListOf7;
        List<String> mutableListOf8;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("71", "https://ti.qq.com/hybrid-h5/intimate/wangzhe_relation?frduin={touin}&mutualmark_id={mutualmark_id}&_wv=3&_wwv=1"));
        this.gameDetailUrl = mutableMapOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("71");
        this.gamePartnerType = mutableListOf;
        mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("1", "#FF6FA3"), TuplesKt.to("2", "#FF9446"), TuplesKt.to("3", "#0099FF"), TuplesKt.to("26", "#7B65FF"), TuplesKt.to("71", "#FFFFFF"), TuplesKt.to("81", "#FF8545"), TuplesKt.to("82", "#A2CC00"));
        this.headCardTextColor = mutableMapOf2;
        mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("1", "\u60c5\u4fa3"), TuplesKt.to("1_1", "\u8d85\u751c\u60c5\u4fa3"), TuplesKt.to("1_2", "\u795e\u4ed9\u7737\u4fa3"), TuplesKt.to("2", "\u95fa\u871c"), TuplesKt.to("2_1", "\u77e5\u97f3\u95fa\u871c"), TuplesKt.to("2_2", "\u6bbf\u5802\u7ea7\u95fa\u871c"), TuplesKt.to("3", "\u57fa\u53cb"), TuplesKt.to("3_1", "\u9ed8\u5951\u57fa\u53cb"), TuplesKt.to("3_2", "\u9aa8\u7070\u7ea7\u57fa\u53cb"), TuplesKt.to("26", "\u6b7b\u515a"), TuplesKt.to("26_1", "\u631a\u4ea4\u6b7b\u515a"), TuplesKt.to("26_2", "\u53f2\u8bd7\u7ea7\u6b7b\u515a"), TuplesKt.to("71", "\u738b\u8005\u4f19\u4f34"), TuplesKt.to("71_1", "\u738b\u8005\u961f\u53cb"), TuplesKt.to("71_2", "\u738b\u8005\u5144\u5f1f"), TuplesKt.to("71_3", "\u738b\u8005\u76df\u53cb"), TuplesKt.to("81", "\u5b66\u4e60\u642d\u5b50"), TuplesKt.to("82", "\u8fd0\u52a8\u642d\u5b50"));
        this.headCardLabel = mutableMapOf3;
        mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("1", "#FF6FA3"), TuplesKt.to("2", "#FF8A2D"), TuplesKt.to("3", "#8173FF"), TuplesKt.to("26", "#2493FF"), TuplesKt.to("71", "#F1BC00"), TuplesKt.to("81", "#FF8545"), TuplesKt.to("82", "#A2CC00"));
        this.shareTextColor = mutableMapOf4;
        mutableMapOf5 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("1", "#FF8AB5"), TuplesKt.to("2", "#FF9F40"), TuplesKt.to("3", "#4DA7FF"));
        this.shareSubTextColor = mutableMapOf5;
        mutableMapOf6 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("71", "QQ\u738b\u8005\u642d\u5b50"), TuplesKt.to("81", "QQ\u5b66\u4e60\u642d\u5b50"), TuplesKt.to("82", "QQ\u8fd0\u52a8\u642d\u5b50"));
        this.shareBottomLabel = mutableMapOf6;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf("#E085F2", "#FFA6CB", "#FFE2D4", "#E085F2", "#FFA6CB", "#F255D8");
        mutableListOf3 = CollectionsKt__CollectionsKt.mutableListOf("#F7818F", "#FACF96", "#FFFACD", "#F7818F", "#FACF96", "#F763A1");
        mutableListOf4 = CollectionsKt__CollectionsKt.mutableListOf("#6680FF", "#90E3FF", "#CCFFE6", "#6680FF", "#90E3FF", "#6759FF");
        mutableListOf5 = CollectionsKt__CollectionsKt.mutableListOf("#E37CF7", "#B8B2FF", "#BBF4FF", "#E37CF7", "#B8B2FF", "#F261DA");
        mutableListOf6 = CollectionsKt__CollectionsKt.mutableListOf("#C69533", "#D1A568", "#FFE3B2", "#E9B3FF", "#B1C5FF", "#F261DA");
        mutableMapOf7 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("1", mutableListOf2), TuplesKt.to("2", mutableListOf3), TuplesKt.to("3", mutableListOf4), TuplesKt.to("26", mutableListOf5), TuplesKt.to("71", mutableListOf6));
        this.headCardColor = mutableMapOf7;
        mutableMapOf8 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("1", "#42D6F2"), TuplesKt.to("2", "#FF92A2"), TuplesKt.to("3", "#F9BC53"), TuplesKt.to("26", "#7498FF"), TuplesKt.to("71", "#E2BC36"));
        this.headCardProcessBarColor = mutableMapOf8;
        this.noElegantCardIconUrl = "https://static-res.qq.com/static-res/aio/right_frame/no_elegant_card_icon.png";
        this.genericCardGroupTitle = "";
        this.novelGroupTitle = "";
        mutableListOf7 = CollectionsKt__CollectionsKt.mutableListOf("81", "82");
        this.halfWebViewId = mutableListOf7;
        mutableListOf8 = CollectionsKt__CollectionsKt.mutableListOf("1", "2", "3", "26");
        this.newIntimateJumpId = mutableListOf8;
    }

    private final List<String> C(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            String optString = jSONArray.optString(i3);
            if (optString == null) {
                optString = "";
            }
            arrayList.add(optString);
        }
        return arrayList;
    }

    private final Map<String, List<String>> D(JSONObject jSONObject) {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            Object next = keys.next();
            if (next == null || (str = next.toString()) == null) {
                str = "";
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            linkedHashMap.put(str, C(optJSONArray));
        }
        return linkedHashMap;
    }

    private final Map<String, String> E(JSONObject jSONObject) {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            Object next = keys.next();
            String str2 = "";
            if (next == null || (str = next.toString()) == null) {
                str = "";
            }
            String optString = jSONObject.optString(str);
            if (optString != null) {
                str2 = optString;
            }
            linkedHashMap.put(str, str2);
        }
        return linkedHashMap;
    }

    @NotNull
    public final Map<String, String> A() {
        return this.shareTextColor;
    }

    @NotNull
    /* renamed from: B, reason: from getter */
    public final String getUnselectedTabIconUrl() {
        return this.unselectedTabIconUrl;
    }

    public final void F(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (TextUtils.isEmpty(content)) {
            if (QLog.isColorLevel()) {
                QLog.i("IntimateHeaderConfigData", 2, "update content is null!");
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(content);
            if (jSONObject.has("drawerBgUrl")) {
                String string = jSONObject.getString("drawerBgUrl");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(\"drawerBgUrl\")");
                this.drawerBgUrl = string;
            }
            if (jSONObject.has("cardTopBigIconUrl")) {
                String string2 = jSONObject.getString("cardTopBigIconUrl");
                Intrinsics.checkNotNullExpressionValue(string2, "jsonObject.getString(\"cardTopBigIconUrl\")");
                this.cardTopBigIconUrl = string2;
            }
            if (jSONObject.has("cardLineBgUrl")) {
                String string3 = jSONObject.getString("cardLineBgUrl");
                Intrinsics.checkNotNullExpressionValue(string3, "jsonObject.getString(\"cardLineBgUrl\")");
                this.cardLineBgUrl = string3;
            }
            if (jSONObject.has("unselectedTabIconUrl")) {
                String string4 = jSONObject.getString("unselectedTabIconUrl");
                Intrinsics.checkNotNullExpressionValue(string4, "jsonObject.getString(\"unselectedTabIconUrl\")");
                this.unselectedTabIconUrl = string4;
            }
            if (jSONObject.has("selectedTabIconUrl")) {
                String string5 = jSONObject.getString("selectedTabIconUrl");
                Intrinsics.checkNotNullExpressionValue(string5, "jsonObject.getString(\"selectedTabIconUrl\")");
                this.selectedTabIconUrl = string5;
            }
            if (jSONObject.has("selectedTabBgUrl")) {
                String string6 = jSONObject.getString("selectedTabBgUrl");
                Intrinsics.checkNotNullExpressionValue(string6, "jsonObject.getString(\"selectedTabBgUrl\")");
                this.selectedTabBgUrl = string6;
            }
            if (jSONObject.has("gameDrawerBgUrl")) {
                String string7 = jSONObject.getString("gameDrawerBgUrl");
                Intrinsics.checkNotNullExpressionValue(string7, "jsonObject.getString(\"gameDrawerBgUrl\")");
                this.gameDrawerBgUrl = string7;
            }
            if (jSONObject.has("gameHeaderCharUrl")) {
                String string8 = jSONObject.getString("gameHeaderCharUrl");
                Intrinsics.checkNotNullExpressionValue(string8, "jsonObject.getString(\"gameHeaderCharUrl\")");
                this.gameHeaderCharUrl = string8;
            }
            if (jSONObject.has("gameCardRootBgUrl")) {
                String string9 = jSONObject.getString("gameCardRootBgUrl");
                Intrinsics.checkNotNullExpressionValue(string9, "jsonObject.getString(\"gameCardRootBgUrl\")");
                this.gameCardRootBgUrl = string9;
            }
            if (jSONObject.has("gameCardLineBgUrl")) {
                String string10 = jSONObject.getString("gameCardLineBgUrl");
                Intrinsics.checkNotNullExpressionValue(string10, "jsonObject.getString(\"gameCardLineBgUrl\")");
                this.gameCardLineBgUrl = string10;
            }
            if (jSONObject.has("gameShareBgUrl")) {
                String string11 = jSONObject.getString("gameShareBgUrl");
                Intrinsics.checkNotNullExpressionValue(string11, "jsonObject.getString(\"gameShareBgUrl\")");
                this.gameShareBgUrl = string11;
            }
            if (jSONObject.has("bindGameJumpUrl")) {
                String string12 = jSONObject.getString("bindGameJumpUrl");
                Intrinsics.checkNotNullExpressionValue(string12, "jsonObject.getString(\"bindGameJumpUrl\")");
                this.bindGameJumpUrl = string12;
            }
            if (jSONObject.has("bindIntimateJumpUrl")) {
                String string13 = jSONObject.getString("bindIntimateJumpUrl");
                Intrinsics.checkNotNullExpressionValue(string13, "jsonObject.getString(\"bindIntimateJumpUrl\")");
                this.bindIntimateJumpUrl = string13;
            }
            if (jSONObject.has("gameDetailUrl")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("gameDetailUrl");
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.getJSONObject(\"gameDetailUrl\")");
                this.gameDetailUrl = E(jSONObject2);
            }
            if (jSONObject.has("gamePartnerType")) {
                JSONArray jSONArray = jSONObject.getJSONArray("gamePartnerType");
                Intrinsics.checkNotNullExpressionValue(jSONArray, "jsonObject.getJSONArray(\"gamePartnerType\")");
                this.gamePartnerType = C(jSONArray);
            }
            if (jSONObject.has("headCardTextColor")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("headCardTextColor");
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonObject.getJSONObject(\"headCardTextColor\")");
                this.headCardTextColor = E(jSONObject3);
            }
            if (jSONObject.has("headCardLabel")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("headCardLabel");
                Intrinsics.checkNotNullExpressionValue(jSONObject4, "jsonObject.getJSONObject(\"headCardLabel\")");
                this.headCardLabel = E(jSONObject4);
            }
            if (jSONObject.has("shareTextColor")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("shareTextColor");
                Intrinsics.checkNotNullExpressionValue(jSONObject5, "jsonObject.getJSONObject(\"shareTextColor\")");
                this.shareTextColor = E(jSONObject5);
            }
            if (jSONObject.has("shareSubTextColor")) {
                JSONObject jSONObject6 = jSONObject.getJSONObject("shareSubTextColor");
                Intrinsics.checkNotNullExpressionValue(jSONObject6, "jsonObject.getJSONObject(\"shareSubTextColor\")");
                this.shareSubTextColor = E(jSONObject6);
            }
            if (jSONObject.has("shareBottomLabel")) {
                JSONObject jSONObject7 = jSONObject.getJSONObject("shareBottomLabel");
                Intrinsics.checkNotNullExpressionValue(jSONObject7, "jsonObject.getJSONObject(\"shareBottomLabel\")");
                this.shareBottomLabel = E(jSONObject7);
            }
            if (jSONObject.has("headCardColor")) {
                JSONObject jSONObject8 = jSONObject.getJSONObject("headCardColor");
                Intrinsics.checkNotNullExpressionValue(jSONObject8, "jsonObject.getJSONObject(\"headCardColor\")");
                this.headCardColor = D(jSONObject8);
            }
            if (jSONObject.has("headCardProcessBarColor")) {
                JSONObject jSONObject9 = jSONObject.getJSONObject("headCardProcessBarColor");
                Intrinsics.checkNotNullExpressionValue(jSONObject9, "jsonObject.getJSONObject\u2026headCardProcessBarColor\")");
                this.headCardProcessBarColor = E(jSONObject9);
            }
            if (jSONObject.has("noElegantCardIconUrl")) {
                String string14 = jSONObject.getString("noElegantCardIconUrl");
                Intrinsics.checkNotNullExpressionValue(string14, "jsonObject.getString(\"noElegantCardIconUrl\")");
                this.noElegantCardIconUrl = string14;
            }
            if (jSONObject.has("genericCardGroupTitle")) {
                String string15 = jSONObject.getString("genericCardGroupTitle");
                Intrinsics.checkNotNullExpressionValue(string15, "jsonObject.getString(\"genericCardGroupTitle\")");
                this.genericCardGroupTitle = string15;
            }
            if (jSONObject.has("novelGroupTitle")) {
                String string16 = jSONObject.getString("novelGroupTitle");
                Intrinsics.checkNotNullExpressionValue(string16, "jsonObject.getString(\"novelGroupTitle\")");
                this.novelGroupTitle = string16;
            }
            if (jSONObject.has("newIntimateJumpUrl")) {
                String optString = jSONObject.optString("newIntimateJumpUrl");
                Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"newIntimateJumpUrl\")");
                this.newIntimateJumpUrl = optString;
            }
            if (jSONObject.has("newIntimateJumpId")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("newIntimateJumpId");
                Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonObject.getJSONArray(\"newIntimateJumpId\")");
                this.newIntimateJumpId = C(jSONArray2);
            }
            if (jSONObject.has("halfWebViewId")) {
                JSONArray jSONArray3 = jSONObject.getJSONArray("halfWebViewId");
                Intrinsics.checkNotNullExpressionValue(jSONArray3, "jsonObject.getJSONArray(\"halfWebViewId\")");
                this.halfWebViewId = C(jSONArray3);
            }
        } catch (Exception e16) {
            QLog.e("IntimateHeaderConfigData", 1, "update exception ", e16);
        }
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getBindGameJumpUrl() {
        return this.bindGameJumpUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getBindIntimateJumpUrl() {
        return this.bindIntimateJumpUrl;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getCardLineBgUrl() {
        return this.cardLineBgUrl;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getCardTopBigIconUrl() {
        return this.cardTopBigIconUrl;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getDrawerBgUrl() {
        return this.drawerBgUrl;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getGameCardLineBgUrl() {
        return this.gameCardLineBgUrl;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getGameCardRootBgUrl() {
        return this.gameCardRootBgUrl;
    }

    @NotNull
    public final Map<String, String> h() {
        return this.gameDetailUrl;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getGameDrawerBgUrl() {
        return this.gameDrawerBgUrl;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getGameHeaderCharUrl() {
        return this.gameHeaderCharUrl;
    }

    @NotNull
    public final List<String> k() {
        return this.gamePartnerType;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getGameShareBgUrl() {
        return this.gameShareBgUrl;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getGenericCardGroupTitle() {
        return this.genericCardGroupTitle;
    }

    @NotNull
    public final List<String> n() {
        return this.halfWebViewId;
    }

    @NotNull
    public final Map<String, List<String>> o() {
        return this.headCardColor;
    }

    @NotNull
    public final Map<String, String> p() {
        return this.headCardLabel;
    }

    @NotNull
    public final Map<String, String> q() {
        return this.headCardProcessBarColor;
    }

    @NotNull
    public final Map<String, String> r() {
        return this.headCardTextColor;
    }

    @NotNull
    public final List<String> s() {
        return this.newIntimateJumpId;
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final String getNewIntimateJumpUrl() {
        return this.newIntimateJumpUrl;
    }

    @NotNull
    /* renamed from: u, reason: from getter */
    public final String getNoElegantCardIconUrl() {
        return this.noElegantCardIconUrl;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final String getNovelGroupTitle() {
        return this.novelGroupTitle;
    }

    @NotNull
    /* renamed from: w, reason: from getter */
    public final String getSelectedTabBgUrl() {
        return this.selectedTabBgUrl;
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final String getSelectedTabIconUrl() {
        return this.selectedTabIconUrl;
    }

    @NotNull
    public final Map<String, String> y() {
        return this.shareBottomLabel;
    }

    @NotNull
    public final Map<String, String> z() {
        return this.shareSubTextColor;
    }
}
