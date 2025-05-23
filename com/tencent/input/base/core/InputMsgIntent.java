package com.tencent.input.base.core;

import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/input/base/core/InputMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "input-base_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes7.dex */
public interface InputMsgIntent extends MsgIntent {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class a {
        public static boolean a(@NotNull InputMsgIntent inputMsgIntent) {
            Intrinsics.checkNotNullParameter(inputMsgIntent, "this");
            return MsgIntent.a.a(inputMsgIntent);
        }
    }
}
