package com.tencent.mobileqq.transfile.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITransFileController extends IRuntimeService {
    void addHandle(TransProcessorHandler transProcessorHandler);

    @Deprecated
    void addProcessor(String str, IHttpCommunicatorListener iHttpCommunicatorListener);

    boolean containsProcessor(String str, long j3);

    IHttpCommunicatorListener findProcessor(String str);

    IHttpCommunicatorListener findProcessor(String str, long j3);

    TransFileControllerBusHelper getBusHelper();

    ConcurrentHashMap<String, IHttpCommunicatorListener> getProcessMap();

    AtomicBoolean isWorking();

    void removeHandle(TransProcessorHandler transProcessorHandler);

    boolean removeProcessor(String str);

    void removeProcessorByPeerUin(String str, int i3);

    void stop(TransferRequest transferRequest);

    boolean transferAsync(TransferRequest transferRequest);
}
