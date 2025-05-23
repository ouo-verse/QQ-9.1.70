package com.tencent.mobileqq.nearbypro.api;

import android.content.Context;
import ca2.PublicAccountConfig;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&J\u0014\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&J\u0014\u0010\n\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&J\u0014\u0010\f\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&J\u0014\u0010\r\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&J(\u0010\u0010\u001a\u00020\t2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000eH&J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u001c\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/api/IStrangerPublicAccountUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "Lcom/tencent/mobileqq/nearbypro/api/data/AppID;", "appId", "Lca2/c;", "loadConfig", "", "shouldShowFollowModal", "", "markShowFollowModal", "shouldShowFollowBar", "markCloseFollowBar", "isFollowed", "Lkotlin/Function1;", "cb", "follow", "", "uin", "isPAUin", "Landroid/content/Context;", "context", "jumpToPublicAccountPage", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IStrangerPublicAccountUtil extends QRouteApi {
    void follow(int appId, @NotNull Function1<? super Boolean, Unit> cb5);

    boolean isFollowed(int appId);

    boolean isPAUin(@Nullable String uin);

    void jumpToPublicAccountPage(@Nullable Context context, @Nullable String uin);

    @Nullable
    PublicAccountConfig loadConfig(int appId);

    void markCloseFollowBar(int appId);

    void markShowFollowModal(int appId);

    boolean shouldShowFollowBar(int appId);

    boolean shouldShowFollowModal(int appId);
}
