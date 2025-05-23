package com.tencent.mobileqq.minigame.api;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.minigame.va.IMiniGameVA;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/IMiniGameVAService;", "Lmqq/app/api/IRuntimeService;", "Lcom/tencent/mobileqq/minigame/va/IMiniGameVA;", "getSpaceLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface IMiniGameVAService extends IRuntimeService, IMiniGameVA {
    @NotNull
    MutableLiveData<Long> getSpaceLiveData();
}
