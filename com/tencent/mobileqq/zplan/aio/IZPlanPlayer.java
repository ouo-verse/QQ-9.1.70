package com.tencent.mobileqq.zplan.aio;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QRouteFactory(singleton = false)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0004H&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&J(\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\u001c\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u001b\u001a\u00020\u0002H&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/IZPlanPlayer;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "isReady", "", "play", "pause", "resume", "stop", "Landroid/view/View;", "getView", "Landroid/content/Context;", "context", "", "width", "height", "Lcom/tencent/common/app/AppInterface;", "app", "init", "La61/b;", "baseAIOContext", "onSend", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/mobileqq/activity/aio/p;", "sessionInfo", "setJson", "isPlaying", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanPlayer extends QRouteApi {
    @Nullable
    View getView();

    void init(@NotNull Context context, int width, int height, @NotNull AppInterface app);

    boolean isPlaying();

    boolean isReady();

    void onSend(@NotNull AppInterface app, @Nullable a61.b baseAIOContext);

    void pause();

    void play();

    void resume();

    void setJson(@Nullable JSONObject jsonObject, @Nullable p sessionInfo);

    void stop();
}
