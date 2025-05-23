package com.tencent.gamecenter.wadl.distribute.api;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.gamecenter.wadl.distribute.data.GameDistributeExtraInfo;
import com.tencent.gamecenter.wadl.distribute.data.GameDistributeInfo;
import com.tencent.gamecenter.wadl.distribute.data.a;
import com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IQQGuildDistributeApi extends QRouteApi {
    IDistributeButton getGuildDistributeView(Context context);

    a updateGuildDistributeView(IDistributeButton iDistributeButton, GameDistributeInfo gameDistributeInfo, @Nullable GameDistributeExtraInfo gameDistributeExtraInfo);
}
