package com.tencent.mobileqq.zplan.web.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \r2\u00020\u0001:\u0001\u000eJ0\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/api/IZPlanWebDataHandler;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "url", "requestStr", "Lcom/tencent/common/app/AppInterface;", "app", "Ljava/lang/Object;", "plugin", "", "doInterceptCmd", "", "initInAsyncThreadIfNeed", "Constant", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanWebDataHandler extends QRouteApi {

    /* renamed from: Constant, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f336015a;

    @NotNull
    public static final String KEY_APOLLO_CLIENT = "thunder_id";

    @NotNull
    public static final String TAG = "apollo_client_ApolloWebDataHandler";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/web/api/IZPlanWebDataHandler$a;", "", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.web.api.IZPlanWebDataHandler$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f336015a = new Companion();

        Companion() {
        }
    }

    boolean doInterceptCmd(@Nullable String url, @Nullable String requestStr, @Nullable AppInterface app, @Nullable Object plugin);

    void initInAsyncThreadIfNeed();
}
