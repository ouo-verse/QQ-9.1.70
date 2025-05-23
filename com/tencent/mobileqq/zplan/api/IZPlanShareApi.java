package com.tencent.mobileqq.zplan.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import com.tencent.zplan.proxy.api.IZPlanShareProxy;
import java.util.HashMap;
import ji3.e;
import ji3.h;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J,\u0010\r\u001a\u00020\u00062\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bH&J\b\u0010\u000e\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\u0006H&J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH&JB\u0010\u001a\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u00172&\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bH&J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J7\u0010#\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001c\u001a\u0004\u0018\u00010\"H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/IZPlanShareApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", "param", "", "launchForShareMedia", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "map", "setShareExtraParams", "clearShareExtraParams", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "setSource", "clearSource", "key", "value", "setReportExtraInfo", "uin", "Lcom/tencent/zplan/proxy/api/IZPlanShareProxy$ShareData;", "data", "customShareExtraParams", "doShare", "Lji3/h;", "listener", "setPreRecordShareListener", "Lcom/tencent/zplan/meme/Priority;", "priority", "Lcom/tencent/zplan/meme/model/a;", "avatarCharacterInfo", "Lji3/e;", "preRecordSharePics", "(Ljava/lang/String;Lcom/tencent/zplan/meme/Priority;Lcom/tencent/zplan/meme/model/a;Lji3/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanShareApi extends QRouteApi {
    void clearShareExtraParams();

    void clearSource();

    void doShare(@Nullable String uin, @NotNull IZPlanShareProxy.ShareData data, @Nullable HashMap<String, Object> customShareExtraParams);

    void launchForShareMedia(@NotNull Context context, @NotNull ZPlanShareLaunchParam param);

    @Nullable
    Object preRecordSharePics(@NotNull String str, @NotNull Priority priority, @Nullable AvatarCharacterInfo avatarCharacterInfo, @Nullable e eVar, @NotNull Continuation<? super Unit> continuation);

    void setPreRecordShareListener(@Nullable h listener);

    void setReportExtraInfo(@NotNull String key, @NotNull String value);

    void setShareExtraParams(@NotNull HashMap<String, Object> map);

    void setSource(@NotNull ZootopiaSource source);
}
