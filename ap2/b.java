package ap2;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b%\u0018\u0000 \u00072\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b>\u0010?J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000e\u001a\u0004\b\u0006\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\"\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0007\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR\"\u0010!\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b\"\u0010&R\"\u0010+\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u000e\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R\"\u0010.\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u000e\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b-\u0010\u0011R\"\u00102\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010\u000e\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010#\u001a\u0004\b\u0013\u0010%\"\u0004\b4\u0010&R\"\u00109\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u000e\u001a\u0004\b7\u0010\u000f\"\u0004\b8\u0010\u0011R\"\u0010=\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010#\u001a\u0004\b;\u0010%\"\u0004\b<\u0010&\u00a8\u0006@"}, d2 = {"Lap2/b;", "Lcom/tencent/freesia/IConfigData;", "", "b", "a", "", "d", "I", "e", "()I", "p", "(I)V", "canUseAudioSearch", "", "Ljava/lang/String;", "()Ljava/lang/String;", "o", "(Ljava/lang/String;)V", "audioPanelTips", "f", "j", "v", "searchDelayTimeMills", h.F, "i", "u", "panelCloseTimeoutMillis", "Lap2/g;", "Lap2/g;", "k", "()Lap2/g;", "setThirdAppConfig", "(Lap2/g;)V", "thirdAppConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "c", "()Z", "(Z)V", "aiCardMoreBtnCheckAppInstalled", BdhLogUtil.LogTag.Tag_Conn, "getAiModeTitle", DomainData.DOMAIN_NAME, "aiModeTitle", "D", "t", "loadingText", "E", "getEmptyText", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "emptyText", UserInfo.SEX_FEMALE, "r", "expandAICard", "G", "l", "w", "voiceExpName", "H", "g", ReportConstant.COSTREPORT_PREFIX, "forbiddenAICard", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b implements IConfigData {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: H, reason: from kotlin metadata */
    private boolean forbiddenAICard;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int canUseAudioSearch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int searchDelayTimeMills;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean aiCardMoreBtnCheckAppInstalled;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String audioPanelTips = "\u8bf7\u5f00\u59cb\u8bb2\u8bdd";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int panelCloseTimeoutMillis = 2000;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private g thirdAppConfig = new g();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String aiModeTitle = "AI\u641c\u7d22";

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String loadingText = "\u6b63\u5728\u5206\u6790\u95ee\u9898";

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String emptyText = "\u6682\u65e0\u76f8\u5173\u641c\u7d22\u7ed3\u679c";

    /* renamed from: F, reason: from kotlin metadata */
    private boolean expandAICard = true;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String voiceExpName = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lap2/b$a;", "", "Lap2/b;", "a", "", "DEFAULT_EMPTY_TEXT", "Ljava/lang/String;", "DEFAULT_LOADING_TEXT", "DEFAULT_TITLE", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ap2.b$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a() {
            QRouteApi api = QRoute.api(IUnitedConfigManager.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
            b bVar = (b) ((IUnitedConfigManager) api).loadConfig("qq_search_audio_ai_config");
            if (bVar == null) {
                return new b();
            }
            return bVar;
        }

        Companion() {
        }
    }

    public final boolean a() {
        if (this.canUseAudioSearch == 2) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        if (this.canUseAudioSearch == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getAiCardMoreBtnCheckAppInstalled() {
        return this.aiCardMoreBtnCheckAppInstalled;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getAudioPanelTips() {
        return this.audioPanelTips;
    }

    /* renamed from: e, reason: from getter */
    public final int getCanUseAudioSearch() {
        return this.canUseAudioSearch;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getExpandAICard() {
        return this.expandAICard;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getForbiddenAICard() {
        return this.forbiddenAICard;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getLoadingText() {
        return this.loadingText;
    }

    /* renamed from: i, reason: from getter */
    public final int getPanelCloseTimeoutMillis() {
        return this.panelCloseTimeoutMillis;
    }

    /* renamed from: j, reason: from getter */
    public final int getSearchDelayTimeMills() {
        return this.searchDelayTimeMills;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final g getThirdAppConfig() {
        return this.thirdAppConfig;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getVoiceExpName() {
        return this.voiceExpName;
    }

    public final void m(boolean z16) {
        this.aiCardMoreBtnCheckAppInstalled = z16;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.aiModeTitle = str;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.audioPanelTips = str;
    }

    public final void p(int i3) {
        this.canUseAudioSearch = i3;
    }

    public final void q(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.emptyText = str;
    }

    public final void r(boolean z16) {
        this.expandAICard = z16;
    }

    public final void s(boolean z16) {
        this.forbiddenAICard = z16;
    }

    public final void t(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.loadingText = str;
    }

    public final void u(int i3) {
        this.panelCloseTimeoutMillis = i3;
    }

    public final void v(int i3) {
        this.searchDelayTimeMills = i3;
    }

    public final void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.voiceExpName = str;
    }
}
