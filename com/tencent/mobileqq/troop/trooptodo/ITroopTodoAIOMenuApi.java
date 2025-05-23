package com.tencent.mobileqq.troop.trooptodo;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/trooptodo/ITroopTodoAIOMenuApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getTroopTodoType", "", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "onTroopTodoClicked", "", "context", "Landroid/content/Context;", "isCancel", "", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopTodoAIOMenuApi extends QRouteApi {
    int getTroopTodoType(@NotNull AIOMsgItem msgItem);

    void onTroopTodoClicked(@NotNull Context context, @NotNull AIOMsgItem msgItem, boolean isCancel);
}
