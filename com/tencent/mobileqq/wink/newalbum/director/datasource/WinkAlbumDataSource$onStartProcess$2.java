package com.tencent.mobileqq.wink.newalbum.director.datasource;

import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.director.datasource.WinkAlbumDataSource$onStartProcess$2", f = "WinkAlbumDataSource.kt", i = {}, l = {94, 100, 104, 110, 117}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkAlbumDataSource$onStartProcess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Channel<s53.a> $memoryAlbumChannel;
    final /* synthetic */ Channel<WinkNewMemoryAlbumResult> $newAlbumChannel;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkAlbumDataSource$onStartProcess$2(Channel<s53.a> channel, Channel<WinkNewMemoryAlbumResult> channel2, Continuation<? super WinkAlbumDataSource$onStartProcess$2> continuation) {
        super(2, continuation);
        this.$memoryAlbumChannel = channel;
        this.$newAlbumChannel = channel2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkAlbumDataSource$onStartProcess$2(this.$memoryAlbumChannel, this.$newAlbumChannel, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0052, code lost:
    
        r14 = r0;
        r0 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0148  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00d1 -> B:25:0x0052). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        WinkAlbumDataSource$onStartProcess$2 winkAlbumDataSource$onStartProcess$2;
        Object obj2;
        Object obj3;
        WinkAlbumDataSource$onStartProcess$2 winkAlbumDataSource$onStartProcess$22;
        s53.a aVar;
        Object D;
        Job job;
        boolean z16;
        boolean z17;
        Job job2;
        Object A;
        Object E;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        Object obj4 = ((ChannelResult) obj).getHolder();
                        Object obj5 = coroutine_suspended;
                        WinkAlbumDataSource$onStartProcess$2 winkAlbumDataSource$onStartProcess$23 = this;
                        WinkNewMemoryAlbumResult winkNewMemoryAlbumResult = (WinkNewMemoryAlbumResult) ChannelResult.m2013getOrNullimpl(obj4);
                        if (winkNewMemoryAlbumResult != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d(WinkAlbumDataSource.TAG, 1, "newAlbumChannel received, albumName:" + winkNewMemoryAlbumResult.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
                            }
                            WinkAlbumDataSource winkAlbumDataSource = WinkAlbumDataSource.f324204a;
                            winkAlbumDataSource$onStartProcess$23.L$0 = winkNewMemoryAlbumResult;
                            winkAlbumDataSource$onStartProcess$23.label = 4;
                            E = winkAlbumDataSource.E(winkNewMemoryAlbumResult, winkAlbumDataSource$onStartProcess$23);
                            if (E == obj5) {
                                return obj5;
                            }
                        }
                        winkAlbumDataSource$onStartProcess$2 = winkAlbumDataSource$onStartProcess$23;
                        coroutine_suspended = obj5;
                        job = WinkAlbumDataSource.consumerJob;
                        z16 = false;
                        if (job == null && job.isActive()) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17 || (winkAlbumDataSource$onStartProcess$2.$memoryAlbumChannel.isClosedForReceive() && winkAlbumDataSource$onStartProcess$2.$newAlbumChannel.isClosedForReceive())) {
                            job2 = WinkAlbumDataSource.consumerJob;
                            if (job2 != null && job2.isActive()) {
                                z16 = true;
                            }
                            QLog.d(WinkAlbumDataSource.TAG, 1, "onStartProcess, end, isActive:" + z16);
                            if (z16) {
                                WinkAlbumDataSource winkAlbumDataSource2 = WinkAlbumDataSource.f324204a;
                                winkAlbumDataSource$onStartProcess$2.L$0 = null;
                                winkAlbumDataSource$onStartProcess$2.label = 5;
                                A = winkAlbumDataSource2.A(winkAlbumDataSource$onStartProcess$2);
                                if (A == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                        if (!winkAlbumDataSource$onStartProcess$2.$memoryAlbumChannel.isClosedForReceive()) {
                            Channel<s53.a> channel = winkAlbumDataSource$onStartProcess$2.$memoryAlbumChannel;
                            winkAlbumDataSource$onStartProcess$2.L$0 = null;
                            winkAlbumDataSource$onStartProcess$2.label = 1;
                            Object mo2001receiveCatchingJP2dKIU = channel.mo2001receiveCatchingJP2dKIU(winkAlbumDataSource$onStartProcess$2);
                            if (mo2001receiveCatchingJP2dKIU == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Object obj6 = coroutine_suspended;
                            winkAlbumDataSource$onStartProcess$22 = winkAlbumDataSource$onStartProcess$2;
                            obj2 = mo2001receiveCatchingJP2dKIU;
                            obj3 = obj6;
                            aVar = (s53.a) ChannelResult.m2013getOrNullimpl(obj2);
                            if (aVar != null) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(WinkAlbumDataSource.TAG, 1, "memoryAlbumChannel received, storyName:" + aVar.d().getStoryName());
                                }
                                WinkAlbumDataSource winkAlbumDataSource3 = WinkAlbumDataSource.f324204a;
                                winkAlbumDataSource$onStartProcess$22.L$0 = aVar;
                                winkAlbumDataSource$onStartProcess$22.label = 2;
                                D = winkAlbumDataSource3.D(aVar, winkAlbumDataSource$onStartProcess$22);
                                if (D == obj3) {
                                    return obj3;
                                }
                            }
                            winkAlbumDataSource$onStartProcess$2 = winkAlbumDataSource$onStartProcess$22;
                            coroutine_suspended = obj3;
                        }
                        if (!winkAlbumDataSource$onStartProcess$2.$newAlbumChannel.isClosedForReceive()) {
                            Channel<WinkNewMemoryAlbumResult> channel2 = winkAlbumDataSource$onStartProcess$2.$newAlbumChannel;
                            winkAlbumDataSource$onStartProcess$2.L$0 = null;
                            winkAlbumDataSource$onStartProcess$2.label = 3;
                            Object mo2001receiveCatchingJP2dKIU2 = channel2.mo2001receiveCatchingJP2dKIU(winkAlbumDataSource$onStartProcess$2);
                            if (mo2001receiveCatchingJP2dKIU2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Object obj7 = coroutine_suspended;
                            winkAlbumDataSource$onStartProcess$23 = winkAlbumDataSource$onStartProcess$2;
                            obj4 = mo2001receiveCatchingJP2dKIU2;
                            obj5 = obj7;
                            WinkNewMemoryAlbumResult winkNewMemoryAlbumResult2 = (WinkNewMemoryAlbumResult) ChannelResult.m2013getOrNullimpl(obj4);
                            if (winkNewMemoryAlbumResult2 != null) {
                            }
                            winkAlbumDataSource$onStartProcess$2 = winkAlbumDataSource$onStartProcess$23;
                            coroutine_suspended = obj5;
                        }
                        job = WinkAlbumDataSource.consumerJob;
                        z16 = false;
                        if (job == null) {
                        }
                        z17 = false;
                        if (z17) {
                        }
                        job2 = WinkAlbumDataSource.consumerJob;
                        if (job2 != null) {
                            z16 = true;
                        }
                        QLog.d(WinkAlbumDataSource.TAG, 1, "onStartProcess, end, isActive:" + z16);
                        if (z16) {
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    winkAlbumDataSource$onStartProcess$2 = this;
                    if (!winkAlbumDataSource$onStartProcess$2.$newAlbumChannel.isClosedForReceive()) {
                    }
                    job = WinkAlbumDataSource.consumerJob;
                    z16 = false;
                    if (job == null) {
                    }
                    z17 = false;
                    if (z17) {
                    }
                    job2 = WinkAlbumDataSource.consumerJob;
                    if (job2 != null) {
                    }
                    QLog.d(WinkAlbumDataSource.TAG, 1, "onStartProcess, end, isActive:" + z16);
                    if (z16) {
                    }
                    return Unit.INSTANCE;
                }
            } else {
                ResultKt.throwOnFailure(obj);
                obj2 = ((ChannelResult) obj).getHolder();
                obj3 = coroutine_suspended;
                winkAlbumDataSource$onStartProcess$22 = this;
                aVar = (s53.a) ChannelResult.m2013getOrNullimpl(obj2);
                if (aVar != null) {
                }
                winkAlbumDataSource$onStartProcess$2 = winkAlbumDataSource$onStartProcess$22;
                coroutine_suspended = obj3;
                if (!winkAlbumDataSource$onStartProcess$2.$newAlbumChannel.isClosedForReceive()) {
                }
                job = WinkAlbumDataSource.consumerJob;
                z16 = false;
                if (job == null) {
                }
                z17 = false;
                if (z17) {
                }
                job2 = WinkAlbumDataSource.consumerJob;
                if (job2 != null) {
                }
                QLog.d(WinkAlbumDataSource.TAG, 1, "onStartProcess, end, isActive:" + z16);
                if (z16) {
                }
                return Unit.INSTANCE;
            }
        }
        ResultKt.throwOnFailure(obj);
        winkAlbumDataSource$onStartProcess$2 = this;
        job = WinkAlbumDataSource.consumerJob;
        z16 = false;
        if (job == null) {
        }
        z17 = false;
        if (z17) {
        }
        job2 = WinkAlbumDataSource.consumerJob;
        if (job2 != null) {
        }
        QLog.d(WinkAlbumDataSource.TAG, 1, "onStartProcess, end, isActive:" + z16);
        if (z16) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkAlbumDataSource$onStartProcess$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
