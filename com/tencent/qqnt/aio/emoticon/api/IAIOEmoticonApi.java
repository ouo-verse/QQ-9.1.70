package com.tencent.qqnt.aio.emoticon.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/aio/emoticon/api/IAIOEmoticonApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getEmoticonDataStore", "", "onAIOEmotionFragmentDestroy", "", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOEmoticonApi extends QRouteApi {
    @Nullable
    List<?> getEmoticonDataStore();

    void onAIOEmotionFragmentDestroy();
}
