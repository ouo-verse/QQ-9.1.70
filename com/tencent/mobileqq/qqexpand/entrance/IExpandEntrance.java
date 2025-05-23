package com.tencent.mobileqq.qqexpand.entrance;

import android.app.Activity;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J$\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J6\u0010\u0010\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\rH&J>\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012`\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\rH&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/entrance/IExpandEntrance;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "activityContext", "Lcom/tencent/common/app/AppInterface;", "app", "", "sourceType", "", "enterExpand", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "enterExpandLimitMatch", "", "pageName", WadlProxyConsts.KEY_JUMP_URL, "enterExpandByJumpAction", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "enterExpandPlugin", "Companion", "a", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IExpandEntrance extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f263544a;

    @NotNull
    public static final String EXPAND_PLUGIN_ID = "expand";

    @NotNull
    public static final String PAGE_CHAT_LIST = "qqExpandMessageList";

    @NotNull
    public static final String PAGE_MATCH_HOME = "QQExpandWidget";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqexpand/entrance/IExpandEntrance$a;", "", "<init>", "()V", "qqexpand-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqexpand.entrance.IExpandEntrance$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f263544a = new Companion();

        Companion() {
        }
    }

    void enterExpand(@Nullable Context activityContext, @Nullable AppInterface app, int sourceType);

    void enterExpandByJumpAction(@Nullable Context activity, @Nullable AppInterface app, @NotNull String pageName, int sourceType, @Nullable String jumpUrl);

    void enterExpandLimitMatch(@Nullable Activity activity, @Nullable AppInterface app, int sourceType);

    void enterExpandPlugin(@NotNull Context activityContext, @NotNull HashMap<String, Object> params, @Nullable String jumpUrl);
}
