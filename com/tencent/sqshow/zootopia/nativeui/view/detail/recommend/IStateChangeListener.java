package com.tencent.sqshow.zootopia.nativeui.view.detail.recommend;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/IStateChangeListener;", "", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/IStateChangeListener$State;", "oldState", "newState", "", "a", "State", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface IStateChangeListener {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/IStateChangeListener$State;", "", "(Ljava/lang/String;I)V", "FOLD", "EXPAND", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public enum State {
        FOLD,
        EXPAND
    }

    void a(State oldState, State newState);
}
