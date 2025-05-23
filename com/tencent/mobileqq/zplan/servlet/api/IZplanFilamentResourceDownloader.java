package com.tencent.mobileqq.zplan.servlet.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&JH\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u00072\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0007H&J\b\u0010\t\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/servlet/api/IZplanFilamentResourceDownloader;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getAvatarInfo", "", "uin", "getAvatarResource", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "avatarMap", "getTemplateConfig", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZplanFilamentResourceDownloader extends QRouteApi {
    @NotNull
    String getAvatarInfo(@NotNull String uin);

    @NotNull
    HashMap<String, String> getAvatarResource(@NotNull HashMap<String, String> avatarMap);

    @NotNull
    String getTemplateConfig();
}
