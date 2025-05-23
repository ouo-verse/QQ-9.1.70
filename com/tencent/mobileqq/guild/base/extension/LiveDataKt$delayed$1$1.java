package com.tencent.mobileqq.guild.base.extension;

import androidx.lifecycle.MutableLiveData;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", TencentLocation.RUN_MODE}, k = 3, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes12.dex */
public final class LiveDataKt$delayed$1$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableLiveData<Object> f214729d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Object f214730e;

    @Override // java.lang.Runnable
    public final void run() {
        this.f214729d.postValue(this.f214730e);
    }
}
