package com.tencent.qqnt.chats.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.chats.api.a;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/chats/api/IAvatarGetterService;", "Lmqq/app/api/IRuntimeService;", "Lcom/tencent/qqnt/chats/api/a;", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface IAvatarGetterService extends IRuntimeService, a {
    @Override // com.tencent.qqnt.chats.api.a
    /* synthetic */ void create(@Nullable AppRuntime appRuntime);

    @Override // com.tencent.qqnt.chats.api.a
    /* synthetic */ void destroy();

    @Override // com.tencent.qqnt.chats.api.a
    @Nullable
    /* synthetic */ Drawable getDrawable(int i3, @NotNull String str, boolean z16);

    @Override // com.tencent.qqnt.chats.api.a
    @Nullable
    /* synthetic */ Drawable getDrawable(@NotNull g gVar, boolean z16);

    @Override // com.tencent.qqnt.chats.api.a
    /* synthetic */ void initRecentDecoder();

    @Override // com.tencent.qqnt.chats.api.a
    /* synthetic */ void registerDecodeComplete(@NotNull a.InterfaceC9560a interfaceC9560a);

    @Override // com.tencent.qqnt.chats.api.a
    /* synthetic */ void unRegisterDecodeComplete(@NotNull a.InterfaceC9560a interfaceC9560a);
}
