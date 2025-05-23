package com.tencent.mobileqq.qqexpand.utils;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017J\b\u0010\u0003\u001a\u00020\u0002H&JP\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J0\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u000bH&J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H&J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/IExpandReportUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "initReport", "", "event", "", "isSucc", "", "longElapse", "longSize", "", "params", "immediat", "var9", "onUserActionToTunnel", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appInterface", "getManageTestPlanParams", "from", "reportEnterExpandClick", "reportEnterExpandPage", "Companion", "a", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IExpandReportUtils extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f264084a;

    @NotNull
    public static final String ENTRY_EXPAND_FROM_PAGE_ID_ADD_FRIEND = "1";

    @NotNull
    public static final String ENTRY_EXPAND_FROM_PAGE_ID_CHAT_MEET = "5";

    @NotNull
    public static final String ENTRY_EXPAND_FROM_PAGE_ID_CHAT_PROFILE = "6";

    @NotNull
    public static final String ENTRY_EXPAND_FROM_PAGE_ID_LEBA = "2";

    @NotNull
    public static final String ENTRY_EXPAND_FROM_PAGE_ID_OTHER = "7";

    @NotNull
    public static final String ENTRY_EXPAND_FROM_PAGE_ID_QZONE_SHUOSHUO = "4";

    @NotNull
    public static final String ENTRY_EXPAND_FROM_PAGE_ID_QZONE_TAIL = "3";

    @NotNull
    public static final String EXPAND_APP_KEY = "0AND0Y11VZ3PFHQD";

    @NotNull
    public static final String REPORT_KEY_MANAGER_TEST_PLAN = "manage_test_plan";

    @NotNull
    public static final String REPORT_VALUE_MANAGE_TEST_PLAN_AIO_NOT_SAVE = "aio_not_save";

    @NotNull
    public static final String REPORT_VALUE_MANAGE_TEST_PLAN_NEW_NORMAL = "new_normal";

    @NotNull
    public static final String REPORT_VALUE_MANAGE_TEST_PLAN_NEW_USER_SPECIAL_ITEM = "new_user_special_item";

    @NotNull
    public static final String REPORT_VALUE_MANAGE_TEST_PLAN_OLD_MEET = "old_meet";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/utils/IExpandReportUtils$a;", "", "<init>", "()V", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f264084a = new Companion();

        Companion() {
        }
    }

    @Nullable
    String getManageTestPlanParams(@NotNull BaseQQAppInterface appInterface);

    void initReport();

    void onUserActionToTunnel(@NotNull String event, boolean isSucc, long longElapse, long longSize, @Nullable Map<String, String> params, boolean immediat, boolean var9);

    void onUserActionToTunnel(@NotNull String event, boolean isSucc, @Nullable Map<String, String> params);

    void reportEnterExpandClick(@NotNull String from);

    void reportEnterExpandPage(@NotNull String from);
}
