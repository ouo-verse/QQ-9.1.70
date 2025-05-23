package g43;

import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 \u00172\u00020\u0001:\u0001\nB9\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lg43/c;", "Lcom/tencent/freesia/IConfigData;", "", "d", "Z", "e", "()Z", "isRedirectAIO", "", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "mainPageUrl", "f", "c", "mainPageUrlSearch", h.F, "mainPageUrlSearchPA", "i", "b", "mainPageUrlContact", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c implements IConfigData {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isRedirectAIO;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mainPageUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mainPageUrlSearch;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mainPageUrlSearchPA;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mainPageUrlContact;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lg43/c$a;", "", "", "content", "Lg43/c;", "a", "CONFIG_ID", "Ljava/lang/String;", "IS_REDIRECT_AIO_TO_MAIN_PAGE", "MAIN_PAGE_JUMP_URL", "MAIN_PAGE_JUMP_URL_CONTACT", "MAIN_PAGE_JUMP_URL_DEFAULT", "MAIN_PAGE_JUMP_URL_SEARCH", "MAIN_PAGE_JUMP_URL_SEARCH_PA", "TAG", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: g43.c$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final c a(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            if (QLog.isColorLevel()) {
                QLog.d("HealthJumpConfigData", 2, "parse from:" + content + " ");
            }
            try {
                JSONObject jSONObject = new JSONObject(content);
                boolean areEqual = Intrinsics.areEqual(jSONObject.optString("is_redirect_aio_to_main_page"), "1");
                String mainPageUrl = jSONObject.optString("main_page_jump_url", "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1");
                String mainPageUrlSearch = jSONObject.optString("main_page_jump_url_search", "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1");
                String mainPageUrlSearchPA = jSONObject.optString("main_page_jump_url_search_pa", "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1");
                String mainPageUrlContact = jSONObject.optString("main_page_jump_url_contact", "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1");
                Intrinsics.checkNotNullExpressionValue(mainPageUrl, "mainPageUrl");
                Intrinsics.checkNotNullExpressionValue(mainPageUrlSearch, "mainPageUrlSearch");
                Intrinsics.checkNotNullExpressionValue(mainPageUrlSearchPA, "mainPageUrlSearchPA");
                Intrinsics.checkNotNullExpressionValue(mainPageUrlContact, "mainPageUrlContact");
                return new c(areEqual, mainPageUrl, mainPageUrlSearch, mainPageUrlSearchPA, mainPageUrlContact);
            } catch (JSONException e16) {
                QLog.e("HealthJumpConfigData", 1, "error parse weather manage content:" + content, e16);
                return new c(false, null, null, null, null, 31, null);
            }
        }

        Companion() {
        }
    }

    public c() {
        this(false, null, null, null, null, 31, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getMainPageUrl() {
        return this.mainPageUrl;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getMainPageUrlContact() {
        return this.mainPageUrlContact;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getMainPageUrlSearch() {
        return this.mainPageUrlSearch;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getMainPageUrlSearchPA() {
        return this.mainPageUrlSearchPA;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsRedirectAIO() {
        return this.isRedirectAIO;
    }

    public c(boolean z16, @NotNull String mainPageUrl, @NotNull String mainPageUrlSearch, @NotNull String mainPageUrlSearchPA, @NotNull String mainPageUrlContact) {
        Intrinsics.checkNotNullParameter(mainPageUrl, "mainPageUrl");
        Intrinsics.checkNotNullParameter(mainPageUrlSearch, "mainPageUrlSearch");
        Intrinsics.checkNotNullParameter(mainPageUrlSearchPA, "mainPageUrlSearchPA");
        Intrinsics.checkNotNullParameter(mainPageUrlContact, "mainPageUrlContact");
        this.isRedirectAIO = z16;
        this.mainPageUrl = mainPageUrl;
        this.mainPageUrlSearch = mainPageUrlSearch;
        this.mainPageUrlSearchPA = mainPageUrlSearchPA;
        this.mainPageUrlContact = mainPageUrlContact;
    }

    public /* synthetic */ c(boolean z16, String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1" : str, (i3 & 4) != 0 ? "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1" : str2, (i3 & 8) != 0 ? "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1" : str3, (i3 & 16) == 0 ? str4 : "https://yundong.qq.com/v2/homepage/index?_wv=553648128&h5costreport=1");
    }
}
