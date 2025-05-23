package com.tencent.aio.helper;

import com.tencent.aio.main.businesshelper.e;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J;\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H&J;\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006H&J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0007H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aio/helper/d;", "", "Lcom/tencent/aio/api/help/a;", "param", "Lcom/tencent/mvi/api/runtime/a;", QAdVrReport.ElementID.AD_POSTER, "Lkotlin/Function1;", "Lcom/tencent/aio/main/businesshelper/e;", "Lkotlin/ParameterName;", "name", "helper", "", "helperCreator", "b", "Lcom/tencent/aio/main/businesshelper/h;", "c", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public interface d {
    void a(@NotNull e helper);

    void b(@NotNull com.tencent.aio.api.help.a param, @NotNull com.tencent.mvi.api.runtime.a poster, @NotNull Function1<? super e, Unit> helperCreator);

    void c(@NotNull com.tencent.aio.api.help.a param, @NotNull com.tencent.mvi.api.runtime.a poster, @NotNull Function1<? super h, Unit> helperCreator);
}
