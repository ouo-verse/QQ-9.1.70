package com.tencent.thumbplayer.connection;

import com.tencent.thumbplayer.api.connection.ITPPlayerConnection;
import com.tencent.thumbplayer.api.connection.ITPPlayerConnectionNode;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.common.TPNativeRetCode;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.core.utils.TPFieldCalledByNative;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;

/* loaded from: classes26.dex */
public class TPPlayerConnection implements ITPPlayerConnection {
    private static final int INVALID_CONNECTION_ID = -1;
    private static final String TAG = "TPPlayerConnection";
    private int mConnectionId;
    private TPPlayerConnectionNode mMasterNode;

    @TPFieldCalledByNative
    private long mNativePlayerConnectionContext;
    private TPPlayerConnectionNode mSubNode;

    public TPPlayerConnection(TPPlayerConnectionNode tPPlayerConnectionNode, TPPlayerConnectionNode tPPlayerConnectionNode2) throws TPLoadLibraryException, UnsupportedOperationException {
        this.mMasterNode = tPPlayerConnectionNode;
        this.mSubNode = tPPlayerConnectionNode2;
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            if (tPPlayerConnectionNode.getPlayer().getPlayerCoreType() == 2 && tPPlayerConnectionNode2.getPlayer().getPlayerCoreType() == 2) {
                try {
                    int native_createConnection = native_createConnection(tPPlayerConnectionNode, tPPlayerConnectionNode2);
                    this.mConnectionId = native_createConnection;
                    if (native_createConnection != -1) {
                        return;
                    }
                    TPLogUtil.e(TAG, "failed to create connection , native create failed");
                    throw new UnsupportedOperationException();
                } catch (UnsatisfiedLinkError unused) {
                    TPLogUtil.e(TAG, "failed to create connection , native init failed");
                    throw new UnsupportedOperationException();
                }
            }
            TPLogUtil.e(TAG, "failed to create connection , player in node must be self dev player");
            throw new UnsupportedOperationException();
        }
        TPLogUtil.e(TAG, "failed to create connection , library not successfully loaded");
        throw new TPLoadLibraryException();
    }

    private native int native_activateConnection(int i3);

    private native int native_createConnection(TPPlayerConnectionNode tPPlayerConnectionNode, TPPlayerConnectionNode tPPlayerConnectionNode2);

    private native int native_deactivateConnection(int i3);

    private native void native_releaseConnection(int i3);

    @Override // com.tencent.thumbplayer.api.connection.ITPPlayerConnection
    public void activateConnection() throws UnsupportedOperationException {
        int i3;
        try {
            i3 = native_activateConnection(this.mConnectionId);
        } catch (UnsatisfiedLinkError unused) {
            TPLogUtil.e(TAG, "failed to activate connection , native active failed");
            i3 = TPNativeRetCode.NOT_IMPL;
        }
        if (i3 == 0) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.tencent.thumbplayer.api.connection.ITPPlayerConnection
    public void deactivateConnection() throws UnsupportedOperationException {
        int i3;
        try {
            i3 = native_deactivateConnection(this.mConnectionId);
        } catch (UnsatisfiedLinkError unused) {
            TPLogUtil.e(TAG, "failed to deactivate connection , native deactivate failed");
            i3 = TPNativeRetCode.NOT_IMPL;
        }
        if (i3 == 0) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override // com.tencent.thumbplayer.api.connection.ITPPlayerConnection
    public ITPPlayerConnectionNode getMasterNode() {
        return this.mMasterNode;
    }

    @Override // com.tencent.thumbplayer.api.connection.ITPPlayerConnection
    public ITPPlayerConnectionNode getSubNode() {
        return this.mSubNode;
    }

    @Override // com.tencent.thumbplayer.api.connection.ITPPlayerConnection
    public void release() {
        try {
            native_releaseConnection(this.mConnectionId);
        } catch (UnsatisfiedLinkError unused) {
            TPLogUtil.e(TAG, "failed to deactivate connection , native deactivate failed");
        }
    }
}
