package com.tencent.mobileqq.kandian.biz.config.api;

import com.tencent.mobileqq.config.l;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y52.a;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00072\u00020\u0001:\u0001\bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0016\u0010\u0006\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/config/api/IReadInJoySearchJumpUrlConfProcessor;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ly52/a;", "getConfig", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/config/l;", "getProcessClazz", "Companion", "a", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IReadInJoySearchJumpUrlConfProcessor extends QRouteApi {
    public static final int CONFIG_ID = 292;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f239328a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/config/api/IReadInJoySearchJumpUrlConfProcessor$a;", "", "<init>", "()V", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.config.api.IReadInJoySearchJumpUrlConfProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f239328a = new Companion();

        Companion() {
        }
    }

    @Nullable
    a getConfig();

    @NotNull
    Class<? extends l<?>> getProcessClazz();
}
