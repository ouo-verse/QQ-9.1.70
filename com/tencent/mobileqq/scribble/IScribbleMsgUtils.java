package com.tencent.mobileqq.scribble;

import android.graphics.Bitmap;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IScribbleMsgUtils extends QRouteApi {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(int i3);

        boolean b(String str);
    }

    boolean ReSendScribbleMsgRecord(AppRuntime appRuntime, MessageForScribble messageForScribble);

    void SendScribbleMsg(AppRuntime appRuntime, String str, int i3, Bitmap bitmap, int i16, a aVar);

    boolean downloadScribble(MessageForScribble messageForScribble);

    String getScribbleCombineFile(MessageForScribble messageForScribble);

    byte[] getScribbleDataByte(MessageForScribble messageForScribble);

    String getScribbleDataFilePath(MessageForScribble messageForScribble);

    int getScribbleDataReadyState(MessageForScribble messageForScribble);

    int splitPureDataFromCombineFile(MessageForScribble messageForScribble);
}
