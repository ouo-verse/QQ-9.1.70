package com.tencent.thumbplayer.api.connection;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import com.tencent.thumbplayer.connection.TPPlayerConnection;
import com.tencent.thumbplayer.connection.TPPlayerConnectionNode;

/* loaded from: classes26.dex */
public class TPPlayerConnectionFactory {
    public static ITPPlayerConnection createConnection(@NonNull ITPPlayerConnectionNode iTPPlayerConnectionNode, @NonNull ITPPlayerConnectionNode iTPPlayerConnectionNode2) throws TPLoadLibraryException, UnsupportedOperationException {
        TPPlayerConnectionNode tPPlayerConnectionNode = (TPPlayerConnectionNode) iTPPlayerConnectionNode;
        tPPlayerConnectionNode.setClockSyncType(0);
        TPPlayerConnectionNode tPPlayerConnectionNode2 = (TPPlayerConnectionNode) iTPPlayerConnectionNode2;
        tPPlayerConnectionNode2.setClockSyncType(1);
        return new TPPlayerConnection(tPPlayerConnectionNode, tPPlayerConnectionNode2);
    }

    public static ITPPlayerConnectionNode createConnectionNode(@NonNull ITPPlayer iTPPlayer) {
        return new TPPlayerConnectionNode(iTPPlayer);
    }
}
