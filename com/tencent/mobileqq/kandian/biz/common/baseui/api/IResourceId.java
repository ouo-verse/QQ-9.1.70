package com.tencent.mobileqq.kandian.biz.common.baseui.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u0000 \b2\u00020\u0001:\u0001\tJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/IResourceId;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "getCommonMaskView", "", "name", "getId", "getLayoutId", "Id", "a", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IResourceId extends QRouteApi {

    /* renamed from: Id, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f239303a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/common/baseui/api/IResourceId$a;", "", "<init>", "()V", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.common.baseui.api.IResourceId$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f239303a = new Companion();

        Companion() {
        }
    }

    int getCommonMaskView();

    int getId(@NotNull String name);

    int getLayoutId(@NotNull String name);
}
