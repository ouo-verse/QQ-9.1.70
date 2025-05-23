package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IStickerRecMvvmCreator extends QRouteApi {
    a createViewBinder(AppInterface appInterface, QBaseActivity qBaseActivity, a61.b bVar, b bVar2);

    b createViewModel(ViewModelStoreOwner viewModelStoreOwner);
}
