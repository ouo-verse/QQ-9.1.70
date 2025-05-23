package com.tencent.zplan.meme.recorder;

import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.c;
import com.tencent.zplan.meme.model.MemeResult;
import com.tencent.zplan.meme.recorder.MemeRecordQueue;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import lx4.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/zplan/meme/recorder/MemeRecordQueue$checkResources$listener$1", "Lcom/tencent/zplan/meme/c;", "", "errorCode", "", "onResult", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class MemeRecordQueue$checkResources$listener$1 implements c {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MemeRecordQueue f385948a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MemeAction f385949b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MemeRecordQueue.c f385950c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f385951d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MemeRecordQueue$checkResources$listener$1(MemeRecordQueue memeRecordQueue, MemeAction memeAction, MemeRecordQueue.c cVar, String str) {
        this.f385948a = memeRecordQueue;
        this.f385949b = memeAction;
        this.f385950c = cVar;
        this.f385951d = str;
    }

    @Override // com.tencent.zplan.meme.c
    public void onResult(final int errorCode) {
        Meme.f385754h.B(new Function0<Unit>() { // from class: com.tencent.zplan.meme.recorder.MemeRecordQueue$checkResources$listener$1$onResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:38:0x0163, code lost:
            
                if (r0 < 2) goto L34;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2() {
                String str;
                Map map;
                Map map2;
                MemeRecordQueue.b unused;
                Meme meme = Meme.f385754h;
                boolean continueOnResourceDownloadFailed = meme.k().getContinueOnResourceDownloadFailed();
                boolean z16 = true;
                boolean z17 = errorCode == 0;
                if (z17) {
                    str = errorCode + " \u2705";
                } else {
                    str = errorCode + " \u274c";
                }
                MemeRecordQueue$checkResources$listener$1.this.f385949b.getStatistic().C(meme.i());
                long o16 = MemeRecordQueue$checkResources$listener$1.this.f385949b.getStatistic().o();
                d a16 = LogUtil.f385285b.a();
                if (a16 != null) {
                    d.a.c(a16, MemeRecordQueue$checkResources$listener$1.this.f385948a.TAG, 1, "checkResource download onResult, " + MemeRecordQueue$checkResources$listener$1.this.f385949b.getDesc() + ", errorCode:" + str + ", costTime:" + o16 + ", continueOnFailed:" + continueOnResourceDownloadFailed + ", tryCount:" + MemeRecordQueue$checkResources$listener$1.this.f385950c.getDoCheckResourceCount(), null, 8, null);
                }
                if (z17 || continueOnResourceDownloadFailed) {
                    MemeRecordQueue$checkResources$listener$1.this.f385948a.org.aspectj.lang.JoinPoint.SYNCHRONIZATION_LOCK java.lang.String.lock();
                    try {
                        map = MemeRecordQueue$checkResources$listener$1.this.f385948a.waitingResourceDownload;
                        MemeRecordQueue.c cVar = (MemeRecordQueue.c) map.remove(MemeRecordQueue$checkResources$listener$1.this.f385951d);
                        if (cVar != null) {
                            if (!z17) {
                                int doCheckResourceCount = MemeRecordQueue$checkResources$listener$1.this.f385950c.getDoCheckResourceCount();
                                unused = MemeRecordQueue.f385925p;
                            }
                            z16 = false;
                            cVar.t(z16);
                            MemeRecordQueue$checkResources$listener$1.this.f385948a.J(cVar);
                            return;
                        }
                        return;
                    } finally {
                    }
                }
                ReentrantLock reentrantLock = MemeRecordQueue$checkResources$listener$1.this.f385948a.org.aspectj.lang.JoinPoint.SYNCHRONIZATION_LOCK java.lang.String;
                reentrantLock.lock();
                try {
                    map2 = MemeRecordQueue$checkResources$listener$1.this.f385948a.waitingResourceDownload;
                    map2.remove(MemeRecordQueue$checkResources$listener$1.this.f385951d);
                    List list = (List) MemeRecordQueue$checkResources$listener$1.this.f385948a.recorderKeyListenerMap.remove(MemeRecordQueue$checkResources$listener$1.this.f385951d);
                    reentrantLock.unlock();
                    MemeRecordQueue$checkResources$listener$1.this.f385949b.getStatistic().t(errorCode);
                    MemeRecordQueue$checkResources$listener$1 memeRecordQueue$checkResources$listener$1 = MemeRecordQueue$checkResources$listener$1.this;
                    MemeResult memeResult = new MemeResult(memeRecordQueue$checkResources$listener$1.f385949b, memeRecordQueue$checkResources$listener$1.f385951d, null);
                    MemeRecordQueue$checkResources$listener$1.this.f385950c.p(false, memeResult);
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((com.tencent.zplan.meme.a) it.next()).l9(false, memeResult);
                        }
                    }
                } finally {
                }
            }
        });
    }
}
