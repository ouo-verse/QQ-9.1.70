package com.tencent.mobileqq.troop.qrcode.api;

import android.os.Bundle;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J&\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/qrcode/api/ITroopQRCodeShareApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/parser/av;", "getJumpParser", "", "troopUin", "troopName", "shareLink", "Landroid/os/Bundle;", "getQZonePublishBizBundle", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes19.dex */
public interface ITroopQRCodeShareApi extends QRouteApi {
    @NotNull
    Class<av> getJumpParser();

    @NotNull
    Bundle getQZonePublishBizBundle(@Nullable String troopUin, @Nullable String troopName, @Nullable String shareLink);
}
