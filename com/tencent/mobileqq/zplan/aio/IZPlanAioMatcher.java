package com.tencent.mobileqq.zplan.aio;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u0000 \u00072\u00020\u0001:\u0002\b\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/IZPlanAioMatcher;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "aioType", "", "isSupported", "type", "Constant", "a", "b", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanAioMatcher extends QRouteApi {
    public static final int AIO_TYPE_ALL = 0;
    public static final int AIO_TYPE_C2C = 1;
    public static final int AIO_TYPE_GROUP = 2;

    /* renamed from: Constant, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f330901a;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/IZPlanAioMatcher$a;", "", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/IZPlanAioMatcher$b;", "", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aio.IZPlanAioMatcher$b, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f330901a = new Companion();

        Companion() {
        }
    }

    boolean isSupported(int aioType);

    boolean isSupported(int aioType, int type);
}
