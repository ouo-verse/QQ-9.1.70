package com.tencent.guild.api.image;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import jr0.GuildImageOptions;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/guild/api/image/IGuildImageApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljr0/a;", "option", "", "load", "getLocalPath", "deleteCache", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildImageApi extends QRouteApi {
    void deleteCache();

    void getLocalPath(@NotNull GuildImageOptions option);

    @Deprecated(message = "\u76f4\u63a5\u4f7f\u7528GuildPicLoader\u5427\uff0c\u5df2\u7ecf\u505a\u8fc7\u6865\u63a5\u4e86\uff0c\u6ca1\u5fc5\u8981\u8fc7\u5ea6\u5305\u88c5")
    void load(@NotNull GuildImageOptions option);
}
