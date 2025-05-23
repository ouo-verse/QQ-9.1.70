package com.tencent.qqnt.aio.msg.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.aio.nick.e;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/msg/api/IAIOMsgItemExtApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/aio/nick/e;", "getMemberLevelDrawable", "Landroid/graphics/drawable/Drawable;", "getVipIconDrawable", "getVipIconExtDrawable", "getVipGameDrawable", "", "getMutualMaskDrawableList", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface IAIOMsgItemExtApi extends QRouteApi {
    @Nullable
    e getMemberLevelDrawable(@NotNull AIOMsgItem msgItem);

    @Nullable
    List<Drawable> getMutualMaskDrawableList(@NotNull AIOMsgItem msgItem);

    @Nullable
    Drawable getVipGameDrawable(@NotNull AIOMsgItem msgItem);

    @Nullable
    Drawable getVipIconDrawable(@NotNull AIOMsgItem msgItem);

    @Nullable
    Drawable getVipIconExtDrawable(@NotNull AIOMsgItem msgItem);
}
