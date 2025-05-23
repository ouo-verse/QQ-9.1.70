package com.tencent.videocut.utils;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", ExifInterface.LATITUDE_SOUTH, "T", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes27.dex */
final class LiveDataExtKt$safeAddSource$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MediatorLiveData f384228d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ LiveData f384229e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Observer f384230f;

    @Override // java.lang.Runnable
    public final void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f384228d.addSource(this.f384229e, this.f384230f);
        }
    }
}
