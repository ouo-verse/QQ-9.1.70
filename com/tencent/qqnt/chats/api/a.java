package com.tencent.qqnt.chats.api;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&J$\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/chats/api/a;", "", "Lmqq/app/AppRuntime;", "appRuntime", "", OperateCustomButton.OPERATE_CREATE, "destroy", "initRecentDecoder", "Lcom/tencent/qqnt/chats/api/a$a;", "listener", "registerDecodeComplete", "unRegisterDecodeComplete", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "memoryCacheHighPriority", "Landroid/graphics/drawable/Drawable;", "getDrawable", "", "chatType", "", "uin", "a", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/api/a$a;", "", "", "remainingTasks", "type", "", "uin", "Landroid/graphics/Bitmap;", "avatar", "", "onDecodeTaskCompleted", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.api.a$a, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    public interface InterfaceC9560a {
        void onDecodeTaskCompleted(int remainingTasks, int type, @Nullable String uin, @Nullable Bitmap avatar);
    }

    void create(@Nullable AppRuntime appRuntime);

    void destroy();

    @Nullable
    Drawable getDrawable(int chatType, @NotNull String uin, boolean memoryCacheHighPriority);

    @Nullable
    Drawable getDrawable(@NotNull g item, boolean memoryCacheHighPriority);

    void initRecentDecoder();

    void registerDecodeComplete(@NotNull InterfaceC9560a listener);

    void unRegisterDecodeComplete(@NotNull InterfaceC9560a listener);
}
