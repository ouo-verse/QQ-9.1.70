package com.tencent.state.square.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J#\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/state/square/api/ISquareAvatarUtils;", "", "clean", "", "getAvatarInfo", "Lorg/json/JSONObject;", "uin", "", "forceUpdate", "", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquareAvatarUtils {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getAvatarInfo$default(ISquareAvatarUtils iSquareAvatarUtils, long j3, boolean z16, Continuation continuation, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return iSquareAvatarUtils.getAvatarInfo(j3, z16, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAvatarInfo");
        }
    }

    void clean();

    @Nullable
    Object getAvatarInfo(long j3, boolean z16, @NotNull Continuation<? super JSONObject> continuation);
}
