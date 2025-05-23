package com.tencent.mobileqq.guild.config;

import androidx.lifecycle.MutableLiveData;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00028\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/config/w;", "Lcom/tencent/freesia/IConfigData;", "T", "Lcom/tencent/mobileqq/guild/config/a;", "Landroidx/lifecycle/MutableLiveData;", "a", "()Landroidx/lifecycle/MutableLiveData;", "liveConfig", "getConfig", "()Lcom/tencent/freesia/IConfigData;", DownloadInfo.spKey_Config, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface w<T extends IConfigData> extends a<T> {
    @NotNull
    MutableLiveData<T> a();

    @NotNull
    T getConfig();
}
