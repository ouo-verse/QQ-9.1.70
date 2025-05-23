package com.tencent.mobileqq.nearbypro.utils.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH&J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\tH&J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\tH&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/utils/api/INearbyProJubaoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "doJumpReport", "", "context", "Landroid/content/Context;", "appId", "", "evilUin", "", "contentId", "chatType", "sigToken", "", "evilUinType", "buddyFlag", "isAnonymous", "", "reportFeed", "tinyId", "feedId", "reportFeedComment", "reportUser", "qq_nearby_pro_df_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyProJubaoApi extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class a {
        public static /* synthetic */ void a(INearbyProJubaoApi iNearbyProJubaoApi, Context context, int i3, String str, String str2, String str3, byte[] bArr, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 16) != 0) {
                    str3 = "";
                }
                String str4 = str3;
                if ((i16 & 32) != 0) {
                    bArr = new byte[0];
                }
                iNearbyProJubaoApi.doJumpReport(context, i3, str, str2, str4, bArr);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doJumpReport");
        }
    }

    void doJumpReport(@NotNull Context context, int appId, @NotNull String evilUin, @NotNull String contentId, @NotNull String chatType, @NotNull byte[] sigToken);

    void doJumpReport(@NotNull Context context, @NotNull String appId, @NotNull String evilUin, int evilUinType, @NotNull String buddyFlag, boolean isAnonymous, @NotNull String contentId);

    void reportFeed(@NotNull Context context, @NotNull String tinyId, @NotNull String feedId);

    void reportFeedComment(@NotNull Context context, @NotNull String tinyId, @NotNull String contentId);

    void reportUser(@NotNull Context context, @NotNull String tinyId);
}
