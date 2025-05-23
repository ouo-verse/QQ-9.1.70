package com.tencent.gdtad.kuikly.fragment;

import android.os.Handler;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.kuikly.receiver.GdtBaseKuiklyBroadcastReceiver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtKuiklyFragmentBroadcastReceiver extends GdtBaseKuiklyBroadcastReceiver {

    /* renamed from: c, reason: collision with root package name */
    private final WeakReference<GdtBaseKuiklyFragment> f109291c;

    public GdtKuiklyFragmentBroadcastReceiver(WeakReference<GdtBaseKuiklyFragment> weakReference, Handler handler) {
        super(handler);
        this.f109291c = weakReference;
    }

    private GdtBaseKuiklyFragment m() {
        WeakReference<GdtBaseKuiklyFragment> weakReference = this.f109291c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.tencent.gdtad.kuikly.receiver.GdtBaseKuiklyBroadcastReceiver
    protected GdtAd d() {
        GdtBaseKuiklyFragment m3 = m();
        if (m3 != null) {
            return m3.uh();
        }
        return null;
    }

    @Override // com.tencent.gdtad.kuikly.receiver.GdtBaseKuiklyBroadcastReceiver
    protected String e() {
        return "GdtKuiklyFragmentBroadcastReceiver";
    }

    @Override // com.tencent.gdtad.kuikly.receiver.GdtBaseKuiklyBroadcastReceiver
    protected int f() {
        GdtBaseKuiklyFragment m3 = m();
        if (m3 == null) {
            QLog.e(e(), 1, "[onReceiveClose] error, fragment is null");
            return 1;
        }
        return m3.qh(21);
    }

    @Override // com.tencent.gdtad.kuikly.receiver.GdtBaseKuiklyBroadcastReceiver
    protected int g() {
        GdtBaseKuiklyFragment m3 = m();
        if (m3 == null) {
            QLog.e(e(), 1, "[onReceiveFallback] error, fragment is null");
            return 1;
        }
        return m3.sh(21);
    }
}
