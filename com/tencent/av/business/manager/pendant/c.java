package com.tencent.av.business.manager.pendant;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class c {
    public int cid = -1;
    public boolean isDownloading = false;

    public abstract String getDesc();

    public abstract String getIconUrl();

    public abstract String getId();

    public abstract String getMd5();

    public abstract int getPlatform();

    public abstract String getResUrl();

    public abstract String getVersion();

    public abstract boolean isUsable();

    public abstract void setUsable(boolean z16);
}
