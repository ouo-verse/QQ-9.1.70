package com.tencent.mobileqq.zplan.utils.stack.lifecycle;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yk3.a;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u00012\u00020\u0002J \u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0005H&J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/stack/lifecycle/IUEActivityLifeCycle;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lyk3/a;", "", "activityName", "", "hashCode", "", "ueActivity", "", OperateCustomButton.OPERATE_CREATE, "finish", "destroy", "getActiveSceneCounter", "", "isTopEngineActivity", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IUEActivityLifeCycle extends QRouteApi, a {
    void create(@NotNull String activityName, int hashCode, @NotNull Object ueActivity);

    void destroy(@NotNull String activityName, int hashCode);

    void finish(@NotNull String activityName, int hashCode);

    @Override // yk3.a
    @Nullable
    /* synthetic */ Boolean finishCheck(@NotNull String str);

    int getActiveSceneCounter();

    boolean isTopEngineActivity(@NotNull Activity activity);

    boolean isTopEngineActivity(@NotNull String activityName, int hashCode);
}
