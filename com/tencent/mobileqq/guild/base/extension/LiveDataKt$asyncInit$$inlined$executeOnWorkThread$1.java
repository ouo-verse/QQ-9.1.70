package com.tencent.mobileqq.guild.base.extension;

import androidx.lifecycle.MutableLiveData;
import com.tencent.map.geolocation.TencentLocation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002\u00a8\u0006\u0003"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE, "com/tencent/mobileqq/guild/util/ThreadUtils$executeOnWorkThread$1"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes12.dex */
public final class LiveDataKt$asyncInit$$inlined$executeOnWorkThread$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableLiveData f214727d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Function0 f214728e;

    @Override // java.lang.Runnable
    public final void run() {
        this.f214727d.postValue(this.f214728e.invoke());
    }
}
