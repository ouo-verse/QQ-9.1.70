package com.qzone.common.event;

/* compiled from: P */
/* loaded from: classes39.dex */
public class Observable {
    private EventSource eventSource;

    public Observable(String str) {
        this.eventSource = new EventSource(str, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EventSource getEventSource() {
        return this.eventSource;
    }

    public void notify(int i3, Object... objArr) {
        EventCenter.getInstance().post(this.eventSource, i3, objArr);
    }

    public Observable() {
        this.eventSource = new EventSource(getClass(), this);
    }
}
