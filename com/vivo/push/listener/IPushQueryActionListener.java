package com.vivo.push.listener;

/* loaded from: classes13.dex */
public interface IPushQueryActionListener extends IPushRequestListener<String, Integer> {
    @Override // com.vivo.push.listener.IPushRequestListener
    /* synthetic */ void onFail(Integer num);

    @Override // com.vivo.push.listener.IPushRequestListener
    /* synthetic */ void onSuccess(String str);
}
