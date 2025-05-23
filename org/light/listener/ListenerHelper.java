package org.light.listener;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class ListenerHelper {
    public OnAIDataListener aiDataListener;
    public OnTipsStatusListener tipsListener;

    public abstract void onTipsNeedHide(String str, String str2, int i3);

    public abstract void onTipsNeedShow(String str, String str2, int i3, int i16);
}
