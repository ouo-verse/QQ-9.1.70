package com.tencent.mobileqq.qqexpand.entrance;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u0000 \f2\u00020\u0001:\u0001\rJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\"\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH&J\"\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/entrance/IExpandFragmentRouter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "", "launchExpandEditFragment", "", "requestCode", "launchExpandEditFragmentForResult", "launchNewEditFragmentForResult", "Companion", "a", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IExpandFragmentRouter extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f263545a;
    public static final int EXPAND_PAGE_SOURCE_OTHER = 7;
    public static final int EXPAND_PAGE_SOURCE_PUSH = 11;
    public static final int EXPAND_PAGE_SOURCE_QQ_BANNER = 10;
    public static final int EXPAND_PAGE_SOURCE_QQ_CARD = 9;
    public static final int FROM_OPT_EXTEND_FRIEND_SQUAR = 0;
    public static final int FROM_OPT_PLUS_PANEL = 1;

    @NotNull
    public static final String FROM_TYPE = "extend_frient_from";

    @NotNull
    public static final String FROM_TYPE_CHAT = "ExtendFriendLimitChatFromeType";

    @NotNull
    public static final String KEY_EXTEND_FRIEND_INFO = "key_extend_friend_info";

    @NotNull
    public static final String KEY_FIRST_POSITION = "key_first_position";

    @NotNull
    public static final String KEY_FROM_TOP = "key_from_top";

    @NotNull
    public static final String KEY_IS_LIVE_OPEN = "key_is_live_open";

    @NotNull
    public static final String KEY_LIVE_QZONE_INDEX = "key_qzone_live_index";

    @NotNull
    public static final String KEY_NUANSHUOSHUO_QZONE_INDEX = "key_qzone_nuanshuoshuo_index";

    @NotNull
    public static final String KEY_QZONE_INDEX = "key_qzone_index";

    @NotNull
    public static final String KEY_RED_TOUCH = "key_red_touch";

    @NotNull
    public static final String KEY_TAB_CLICKED = "key_tab_clicked";

    @NotNull
    public static final String KEY_TAB_IDS = "key_tab_ids";

    @NotNull
    public static final String KEY_TAB_LABLES = "key_tab_lables";
    public static final int MIN_CLOTHES_ID = 10000;
    public static final int REQ_EDIT_FINISH = 4097;
    public static final int RESP_EDIT_FINISH = 8193;

    @NotNull
    public static final String ROUTE_NAME = "/expand/activity";
    public static final int SOURCE_TYPE_ADD_FRIEND = 1;
    public static final int SOURCE_TYPE_DEFAULT = 0;
    public static final int SOURCE_TYPE_FLUTTER_MATCH = 4;
    public static final int SOURCE_TYPE_LEBA = 2;
    public static final int SOURCE_TYPE_PLUS = 6;
    public static final int SOURCE_TYPE_PROFILE = 5;
    public static final int SOURCE_TYPE_QZONE = 3;

    @NotNull
    public static final String TYPE_URL = "extend_frient_type_url";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/entrance/IExpandFragmentRouter$a;", "", "<init>", "()V", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqexpand.entrance.IExpandFragmentRouter$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f263545a = new Companion();

        Companion() {
        }
    }

    void launchExpandEditFragment(@NotNull Activity activity, @Nullable Intent intent);

    void launchExpandEditFragmentForResult(@NotNull Activity activity, @Nullable Intent intent, int requestCode);

    void launchNewEditFragmentForResult(@NotNull Activity activity, @Nullable Intent intent, int requestCode);
}
