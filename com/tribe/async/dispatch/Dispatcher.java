package com.tribe.async.dispatch;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface Dispatcher {
    public static final String DEFAULT_GROUP_NAME = "default_group";
    public static final String ROOT_GROUP_NAME = "root_group";

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface Command extends Dispatchable {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface Dispatchable {
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface Event extends Dispatchable {
    }

    void cancelDispatch(@Nullable String str, Dispatchable dispatchable);

    void dispatch(Dispatchable dispatchable);

    void dispatch(@Nullable String str, Dispatchable dispatchable);

    void dispatchDelayed(Dispatchable dispatchable, int i3);

    void dispatchDelayed(@Nullable String str, Dispatchable dispatchable, int i3);

    @NonNull
    Looper getDefaultLooper();

    void registerSubscriber(Subscriber subscriber);

    void registerSubscriber(@Nullable String str, Subscriber subscriber);

    void registerWeakSubscriber(Subscriber subscriber);

    void registerWeakSubscriber(@Nullable String str, Subscriber subscriber);

    void unRegisterSubscriber(Subscriber subscriber);
}
