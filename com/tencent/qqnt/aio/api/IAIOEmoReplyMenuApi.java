package com.tencent.qqnt.aio.api;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.aio.menu.w;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J,\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH&J\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOEmoReplyMenuApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", ParseCommon.CONTAINER, "Lcom/tencent/qqnt/aio/menu/w;", "onMenuActionListener", "Landroid/view/ViewGroup;", "getDefaultEmoReplyMenuView", "Landroid/view/View;", "anchorView", "getSeparateEmoReplyMenuView", "", "hasEmoReplyMenu", "", "", "getTopBgEmojiIdList", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface IAIOEmoReplyMenuApi extends QRouteApi {
    @Nullable
    ViewGroup getDefaultEmoReplyMenuView(@Nullable Context context, @NotNull AIOMsgItem msgItem, @NotNull Object container, @NotNull w onMenuActionListener);

    @Nullable
    View getSeparateEmoReplyMenuView(@Nullable Context context, @NotNull AIOMsgItem msgItem, @NotNull View anchorView, @NotNull w onMenuActionListener);

    @NotNull
    List<String> getTopBgEmojiIdList();

    boolean hasEmoReplyMenu(@Nullable Context context, @NotNull AIOMsgItem msgItem);
}
