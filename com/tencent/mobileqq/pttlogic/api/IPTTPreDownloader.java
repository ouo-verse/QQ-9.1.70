package com.tencent.mobileqq.pttlogic.api;

import android.os.Handler;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.transfile.TransferRequest;
import mqq.app.api.IRuntimeService;

@Service(process = {"all"})
/* loaded from: classes16.dex */
public interface IPTTPreDownloader extends IRuntimeService, Handler.Callback {
    public static final int CONSUME_ERROR = 3;
    public static final int CONSUME_PLAY = 2;
    public static final int CONSUME_VIEW = 1;

    /* loaded from: classes16.dex */
    public interface a {
        boolean a(MessageForPtt messageForPtt);

        boolean b(MessageForPtt messageForPtt, int i3);

        boolean c(MessageForPtt messageForPtt);

        void onDestroy();
    }

    void onAddrProviderReady(boolean z16, boolean z17);

    void onDownloadFinish(boolean z16, int i3, TransferRequest.PttDownExtraInfo pttDownExtraInfo, MessageForPtt messageForPtt);

    boolean onPlayPTT(MessageForPtt messageForPtt);

    boolean onReceivedPTTMsg(MessageForPtt messageForPtt);

    boolean onViewPTT(MessageForPtt messageForPtt);
}
