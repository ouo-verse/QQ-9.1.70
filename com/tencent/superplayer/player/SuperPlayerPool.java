package com.tencent.superplayer.player;

import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayerPool;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.superplayer.utils.ThreadUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes26.dex */
public class SuperPlayerPool implements ISuperPlayerPool {
    private static final String TAG = "SuperPlayerPool";
    private Map<String, ISuperPlayer> mPoolMap = new ConcurrentHashMap();

    private void printRunningPollInfo(final boolean z16) {
        ThreadUtil.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.superplayer.player.SuperPlayerPool.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    StringBuilder sb5 = new StringBuilder();
                    if (z16) {
                        str = "put";
                    } else {
                        str = "remove";
                    }
                    sb5.append(str);
                    sb5.append(", size");
                    sb5.append(SuperPlayerPool.this.size());
                    sb5.append(", all info:");
                    sb5.append(SuperPlayerSDKMgr.getAllPlayerInfo());
                    LogUtil.e(SuperPlayerPool.TAG, sb5.toString());
                } catch (Exception e16) {
                    LogUtil.e(SuperPlayerPool.TAG, e16.toString());
                }
            }
        });
    }

    @Override // com.tencent.superplayer.api.ISuperPlayerPool
    public ISuperPlayer get(String str) {
        return this.mPoolMap.get(str);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayerPool
    public Map<String, ISuperPlayer> getAllPlayer() {
        return this.mPoolMap;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayerPool
    public void put(ISuperPlayer iSuperPlayer) {
        if (iSuperPlayer == null) {
            return;
        }
        LogUtil.d(TAG, "SuperPlayerPool put player:" + iSuperPlayer.getToken() + ", size:" + size());
        this.mPoolMap.put(iSuperPlayer.getToken(), iSuperPlayer);
        printRunningPollInfo(true);
    }

    @Override // com.tencent.superplayer.api.ISuperPlayerPool
    public boolean remove(ISuperPlayer iSuperPlayer) {
        boolean z16;
        if (iSuperPlayer == null) {
            return false;
        }
        LogUtil.d(TAG, "SuperPlayerPool remove player:" + iSuperPlayer.getToken() + ", size:" + size());
        if (this.mPoolMap.remove(iSuperPlayer.getToken()) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        printRunningPollInfo(false);
        return z16;
    }

    @Override // com.tencent.superplayer.api.ISuperPlayerPool
    public int size() {
        return this.mPoolMap.size();
    }
}
