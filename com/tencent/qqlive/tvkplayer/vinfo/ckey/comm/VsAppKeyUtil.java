package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VsAppKeyUtil {
    private static VsAppKeyUtil instance = new VsAppKeyUtil();
    List<VsAppKeyBean> mArray = new CopyOnWriteArrayList();

    VsAppKeyUtil() {
    }

    public static VsAppKeyUtil getInstance() {
        synchronized (VsAppKeyUtil.class) {
            if (instance == null) {
                instance = new VsAppKeyUtil();
            }
        }
        return instance;
    }

    public void add(VsAppKeyBean vsAppKeyBean) {
        for (VsAppKeyBean vsAppKeyBean2 : this.mArray) {
            if (vsAppKeyBean2.getPlatform().equals(vsAppKeyBean.getPlatform()) || vsAppKeyBean2.getSdtfrom().equals(vsAppKeyBean.getSdtfrom())) {
                return;
            }
        }
        this.mArray.add(vsAppKeyBean);
    }

    public VsAppKeyBean getAppKey(String str) {
        for (VsAppKeyBean vsAppKeyBean : this.mArray) {
            if (vsAppKeyBean.getPlatform().equals(str)) {
                return vsAppKeyBean;
            }
        }
        return null;
    }

    public int getCount() {
        return this.mArray.size();
    }
}
