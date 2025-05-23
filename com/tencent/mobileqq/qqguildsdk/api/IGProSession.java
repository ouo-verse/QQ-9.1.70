package com.tencent.mobileqq.qqguildsdk.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uh2.a;
import uh2.c;
import uh2.h;

@Service(needUin = false, process = {"all"})
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J,\u0010\u0007\u001a\u00020\u00062\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u0017\u001a\u00020\u0006H&J\b\u0010\u0019\u001a\u00020\u0018H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/IGProSession;", "Lmqq/app/api/IRuntimeService;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "sessionMap", "", "initBusinessModule", "start", "stop", "", "isDestroy", "isInit", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGuildService;", "getGuildService", "Luh2/c;", "getGProGuildMsgService", "Lcom/tencent/qqnt/kernel/api/o;", "getFeedService", "Luh2/a;", "getGProDirectSessionService", "Luh2/h;", "getGuildFileTransferService", "notifyGProSdkStart", "Ljava/util/concurrent/CountDownLatch;", "getGProSdkStartCountDownLatch", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface IGProSession extends IRuntimeService {
    @Nullable
    o getFeedService();

    @Nullable
    a getGProDirectSessionService();

    @Nullable
    c getGProGuildMsgService();

    @NotNull
    /* renamed from: getGProSdkStartCountDownLatch */
    CountDownLatch getGproStartCountDownLatch();

    @Nullable
    h getGuildFileTransferService();

    @Nullable
    IKernelGuildService getGuildService();

    void initBusinessModule(@NotNull HashMap<String, String> sessionMap);

    /* renamed from: isDestroy */
    boolean getIsDestroy();

    boolean isInit();

    void notifyGProSdkStart();

    void start();

    void stop();
}
