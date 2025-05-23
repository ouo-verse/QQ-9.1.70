package com.tencent.mobileqq.guild;

import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\f\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/IGuildExtApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getGuildContactFragment", "Lcom/tencent/mobileqq/app/QBaseFragment;", "getParserClass", "Ljava/lang/Class;", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildExtApi extends QRouteApi {
    @NotNull
    QBaseFragment getGuildContactFragment();

    @NotNull
    Class<?> getParserClass();
}
