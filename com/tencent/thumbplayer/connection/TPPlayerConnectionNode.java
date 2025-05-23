package com.tencent.thumbplayer.connection;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.connection.ITPPlayerConnectionNode;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import com.tencent.thumbplayer.common.TPBasicTypeParseUtil;
import com.tencent.thumbplayer.common.TPInnerPropertyID;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPPlayerConnectionNode implements ITPPlayerConnectionNode {
    public static final int CLOCK_SYNC_TYPE_OBTAIN = 1;
    public static final int CLOCK_SYNC_TYPE_PROVIDE = 0;
    private int mClockSyncType = 1;
    private Map<Integer, Long> mConfigMap = new HashMap();
    private ITPPlayer mPlayer;

    public TPPlayerConnectionNode(@NonNull ITPPlayer iTPPlayer) throws UnsupportedOperationException {
        this.mPlayer = iTPPlayer;
    }

    public int getClockSyncType() {
        return this.mClockSyncType;
    }

    @Override // com.tencent.thumbplayer.api.connection.ITPPlayerConnectionNode
    public long getConfig(int i3) {
        if (this.mConfigMap.get(Integer.valueOf(i3)) != null) {
            return this.mConfigMap.get(Integer.valueOf(i3)).longValue();
        }
        return 0L;
    }

    @Override // com.tencent.thumbplayer.api.connection.ITPPlayerConnectionNode
    @NonNull
    public ITPPlayer getPlayer() {
        return this.mPlayer;
    }

    public long getPlayerMemAddress() {
        return TPBasicTypeParseUtil.optLong(this.mPlayer.getProperty(TPInnerPropertyID.TP_PROPERTY_ID_LONG_PLAYER_MEM_ADDRESS), 0L);
    }

    public void setClockSyncType(int i3) {
        this.mClockSyncType = i3;
    }

    @Override // com.tencent.thumbplayer.api.connection.ITPPlayerConnectionNode
    public void setConfig(int i3, long j3) {
        this.mConfigMap.put(Integer.valueOf(i3), Long.valueOf(j3));
    }
}
