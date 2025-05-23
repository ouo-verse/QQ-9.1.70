package com.tencent.mobileqq.matchfriend.reborn.titlebar;

import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/titlebar/QQStrangerTitleUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "()V", "centerView", "Landroid/view/View;", "getCenterView", "()Landroid/view/View;", "setCenterView", "(Landroid/view/View;)V", "tabId", "", "getTabId", "()I", "setTabId", "(I)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQStrangerTitleUpdateEvent extends SimpleBaseEvent {
    private View centerView;
    private int tabId = 1;

    public final View getCenterView() {
        return this.centerView;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final void setCenterView(View view) {
        this.centerView = view;
    }

    public final void setTabId(int i3) {
        this.tabId = i3;
    }
}
