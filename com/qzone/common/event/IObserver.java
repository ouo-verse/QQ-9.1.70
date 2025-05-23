package com.qzone.common.event;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface IObserver {

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface async extends IObserver {
        void onEventAsync(Event event);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface background extends IObserver {
        void onEventBackgroundThread(Event event);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface main extends IObserver {
        void onEventUIThread(Event event);
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface post extends IObserver {
        void onEventPostThread(Event event);
    }
}
