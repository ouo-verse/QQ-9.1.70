package com.tencent.aio.stranger.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/stranger/api/IStrangerAIOAdapterApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/aio/input/adorn/a;", "getInputBarAdornApi", "", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "getExtSectionBarAdapters", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "getExtSectionBarProcessors", "getNearbyProExtProcessors", "getNearbyProExtAdapters", "aio_stranger_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IStrangerAIOAdapterApi extends QRouteApi {
    @NotNull
    List<b> getExtSectionBarAdapters();

    @NotNull
    List<BottomSectionBarBaseProcessor> getExtSectionBarProcessors();

    @NotNull
    com.tencent.mobileqq.aio.input.adorn.a<?> getInputBarAdornApi();

    @NotNull
    List<b> getNearbyProExtAdapters();

    @NotNull
    List<BottomSectionBarBaseProcessor> getNearbyProExtProcessors();
}
