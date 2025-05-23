package com.tencent.gamematrix.gmcg.webrtc.gamepad;

import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CloudGameDevice {
    public Set<Integer> m_deviceIds = new HashSet();
    public int m_type = 0;
    public int m_id = 0;
    public int m_vendorId = 0;
    public int m_productId = 0;

    public boolean appendDeviceId(int i3) {
        Set<Integer> set = this.m_deviceIds;
        if (set != null) {
            set.add(Integer.valueOf(i3));
            return true;
        }
        return true;
    }

    public int getDeviceIdSize() {
        Set<Integer> set = this.m_deviceIds;
        if (set != null) {
            return set.size();
        }
        return 0;
    }

    public boolean isContainDeviceId(int i3) {
        Set<Integer> set = this.m_deviceIds;
        if (set != null) {
            return set.contains(Integer.valueOf(i3));
        }
        return false;
    }

    public void removeDeviceId(int i3) {
        Set<Integer> set = this.m_deviceIds;
        if (set != null && set.size() > 0) {
            this.m_deviceIds.remove(Integer.valueOf(i3));
        }
    }
}
