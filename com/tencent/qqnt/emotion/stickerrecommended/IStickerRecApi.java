package com.tencent.qqnt.emotion.stickerrecommended;

import android.content.Context;
import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.NewIntent;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IStickerRecApi extends QRouteApi {
    ProtocolDownloader getStickerRecDownloader();

    NewIntent getStickerRecIntent(Context context, byte[] bArr, String str);
}
