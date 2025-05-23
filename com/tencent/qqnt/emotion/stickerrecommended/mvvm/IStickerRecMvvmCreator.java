package com.tencent.qqnt.emotion.stickerrecommended.mvvm;

import android.content.Context;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IStickerRecMvvmCreator extends QRouteApi {
    a createViewBinder(AppInterface appInterface, Context context, com.tencent.aio.api.runtime.a aVar, b bVar);

    b createViewModel(ViewModelStoreOwner viewModelStoreOwner);
}
