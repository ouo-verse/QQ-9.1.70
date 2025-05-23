package com.tencent.qqnt.emotion.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.aio.api.runtime.a;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IEmosmService extends QRouteApi {
    void addToCustomEmotionForPic(Context context, String str);

    File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws IOException;

    void sendEmoticon(AppRuntime appRuntime, a aVar, Emoticon emoticon, boolean z16);

    void sendEmoticon(AppRuntime appRuntime, a aVar, MarketFaceElement marketFaceElement);

    void sendRecEmoPic(AppInterface appInterface, a aVar, CharSequence charSequence, Intent intent, ArrayList<String> arrayList);
}
