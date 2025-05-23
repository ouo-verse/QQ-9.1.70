package com.tencent.state.common.push;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/state/common/push/IPushInterceptor;", "", "onInterceptDispatchMessage", "", "onInterceptPullMessage", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IPushInterceptor {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class DefaultImpls {
        public static boolean onInterceptDispatchMessage(IPushInterceptor iPushInterceptor) {
            return false;
        }

        public static boolean onInterceptPullMessage(IPushInterceptor iPushInterceptor) {
            return false;
        }
    }

    boolean onInterceptDispatchMessage();

    boolean onInterceptPullMessage();
}
