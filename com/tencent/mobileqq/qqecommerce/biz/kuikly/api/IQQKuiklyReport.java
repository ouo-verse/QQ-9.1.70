package com.tencent.mobileqq.qqecommerce.biz.kuikly.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyReport;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "getReportClassName", "Companion", "a", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQKuiklyReport extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f262807a;

    @NotNull
    public static final String KEY_SCENE = "scene";
    public static final int SCENE_DEFAULT = 0;
    public static final int SCENE_SPLIT_MODE = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyReport$a;", "", "<init>", "()V", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyReport$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f262807a = new Companion();

        Companion() {
        }
    }

    @NotNull
    String getReportClassName();
}
