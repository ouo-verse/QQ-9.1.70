package com.tencent.state.square.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/api/DefaultSquareAvatarUtils;", "Lcom/tencent/state/square/api/ISquareAvatarUtils;", "()V", "clean", "", "getAvatarInfo", "Lorg/json/JSONObject;", "uin", "", "forceUpdate", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultSquareAvatarUtils implements ISquareAvatarUtils {
    @Override // com.tencent.state.square.api.ISquareAvatarUtils
    @Nullable
    public Object getAvatarInfo(long j3, boolean z16, @NotNull Continuation<? super JSONObject> continuation) {
        return new JSONObject("{}");
    }

    @Override // com.tencent.state.square.api.ISquareAvatarUtils
    public void clean() {
    }
}
