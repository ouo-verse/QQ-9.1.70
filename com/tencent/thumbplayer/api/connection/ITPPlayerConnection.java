package com.tencent.thumbplayer.api.connection;

/* loaded from: classes26.dex */
public interface ITPPlayerConnection {
    void activateConnection() throws UnsupportedOperationException;

    void deactivateConnection() throws UnsupportedOperationException;

    ITPPlayerConnectionNode getMasterNode();

    ITPPlayerConnectionNode getSubNode();

    void release();
}
