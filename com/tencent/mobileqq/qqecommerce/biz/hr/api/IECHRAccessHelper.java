package com.tencent.mobileqq.qqecommerce.biz.hr.api;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J8\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0004H&J0\u0010\u000f\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0011\u001a\u00020\u000eH&J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/IECHRAccessHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "webUrl", "", "isViolaUrlFromWeb", "isKanDianWebHost", "Landroid/content/Context;", "context", "title", "jsUrl", "Landroid/os/Bundle;", "bundle", "useTransParentfragment", "", "startViolaPage", "getviolaurlfromweb", "ensureNVViewMVPEnvironment", "", "dp", "", "dip2px", "Companion", "a", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IECHRAccessHelper extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f262576a;

    @NotNull
    public static final String DEBUG_KEY_HAS_OP_NATIVE_VIOLA_VIDEO_FEEDS_SWITCH = "test_has_op_native_viola_video_feeds_switch";

    @NotNull
    public static final String DEBUG_KEY_NATIVE_VIOLA_VIDEO_FEEDS_SWITCH = "test_native_viola_video_feeds_switch";

    @NotNull
    public static final String DEBUG_KEY_OPEN_VIDEO_FEEDS_DEBUG_PREFIX = "DEBUG_KEY_OPEN_VIDEO_FEEDS_DEBUG_PREFIX";

    @NotNull
    public static final String DEBUG_KEY_TEST_OPEN_OLD_STYLE_VIOLA_VIOLA_FEEDS_SWITCH = "test_open_old_style_video_feeds";

    @NotNull
    public static final String DEBUG_KEY_TEST_OP_OPEN_OLD_STYLE_VIOLA_VIOLA_FEEDS_SWITCH = "test_op_open_old_style_video_feeds";

    @NotNull
    public static final String DEBUG_KEY_VIDEO_FEEDS_DEBUG_PREFIX = "DEBUG_KEY_VIDEO_FEEDS_DEBUG_PREFIX";

    @NotNull
    public static final String DEBUG_KEY_VIOLA_JS_CACHE = "test_viola_js_cache";

    @NotNull
    public static final String FROM_COLOR_NOTE = "from_color_note";

    @NotNull
    public static final String INIT_DATA_PAGE_COLOR_BALL_DATA = "colorBallData";

    @NotNull
    public static final String INIT_DATA_PAGE_PARAM = "param";

    @NotNull
    public static final String INIT_DATA_PAGE_URL = "url";

    @NotNull
    public static final String USE_TRANS_PARENT_FRAGMENT = "useTransParentFragment";

    @NotNull
    public static final String VIOLA_PIC_DETAIL = "https://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/IECHRAccessHelper$a;", "", "<init>", "()V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.hr.api.IECHRAccessHelper$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f262576a = new Companion();

        Companion() {
        }
    }

    int dip2px(float dp5);

    void ensureNVViewMVPEnvironment();

    @Nullable
    String getviolaurlfromweb(@Nullable String webUrl);

    boolean isKanDianWebHost(@Nullable String webUrl);

    boolean isViolaUrlFromWeb(@Nullable String webUrl);

    void startViolaPage(@Nullable Context context, @Nullable String title, @Nullable String jsUrl, @Nullable Bundle bundle);

    void startViolaPage(@Nullable Context context, @Nullable String title, @Nullable String jsUrl, @Nullable Bundle bundle, boolean useTransParentfragment);
}
