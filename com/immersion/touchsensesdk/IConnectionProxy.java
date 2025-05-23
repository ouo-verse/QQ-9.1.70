package com.immersion.touchsensesdk;

import java.net.SocketTimeoutException;

/* loaded from: classes2.dex */
public interface IConnectionProxy {
    IConnection connect(String str, int i3, int i16) throws SocketTimeoutException;
}
