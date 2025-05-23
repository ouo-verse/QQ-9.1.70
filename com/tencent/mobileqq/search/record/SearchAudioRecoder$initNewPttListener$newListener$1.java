package com.tencent.mobileqq.search.record;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.ptt.d;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016R\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/search/record/SearchAudioRecoder$initNewPttListener$newListener$1", "Ltd2/a;", "", "recorderSessionId", "", "errorCode", "content", "", "g", "text", "b", "a", "d", "c", "Ljava/lang/String;", "sessionId", "curSttResult", "", "Z", "alreadyFinish", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchAudioRecoder$initNewPttListener$newListener$1 implements td2.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String sessionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String curSttResult = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile boolean alreadyFinish;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ SearchAudioRecoder f283709d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SearchAudioRecoder$initNewPttListener$newListener$1(String str, SearchAudioRecoder searchAudioRecoder) {
        this.f283709d = searchAudioRecoder;
        this.sessionId = str;
    }

    private final void g(final String recorderSessionId, final int errorCode, final String content) {
        ConcurrentHashMap concurrentHashMap;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("QQSearch.NetDetail.AI.SearchAudioRecoder", 2, "notifyFinish sessionId=" + this.sessionId + ", alreadyFinish=" + this.alreadyFinish + " errorCode=" + errorCode + " content=" + content);
        }
        if (!this.alreadyFinish) {
            final SearchAudioRecoder searchAudioRecoder = this.f283709d;
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.record.SearchAudioRecoder$initNewPttListener$newListener$1$notifyFinish$2
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

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    a callback = SearchAudioRecoder.this.getCallback();
                    if (callback != null) {
                        callback.e(recorderSessionId, errorCode, content);
                    }
                }
            });
            this.alreadyFinish = true;
        }
        concurrentHashMap = this.f283709d.audioPttListenerMap;
        concurrentHashMap.remove(recorderSessionId);
    }

    @Override // td2.a
    public void a(int errorCode) {
        ConcurrentHashMap concurrentHashMap;
        concurrentHashMap = this.f283709d.audioPttListenerMap;
        if (!concurrentHashMap.containsKey(this.sessionId)) {
            Logger.f235387a.d().w("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "sttQueryError current session already finish " + this.sessionId);
            return;
        }
        g(this.sessionId, errorCode, "");
    }

    @Override // td2.a
    public void b(@Nullable final String text) {
        ConcurrentHashMap concurrentHashMap;
        String str;
        concurrentHashMap = this.f283709d.audioPttListenerMap;
        if (!concurrentHashMap.containsKey(this.sessionId)) {
            Logger.f235387a.d().w("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "updateText current session already finish " + this.sessionId);
            return;
        }
        if (text == null) {
            str = "";
        } else {
            str = text;
        }
        this.curSttResult = str;
        final SearchAudioRecoder searchAudioRecoder = this.f283709d;
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.record.SearchAudioRecoder$initNewPttListener$newListener$1$updateText$2
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                a callback = SearchAudioRecoder.this.getCallback();
                if (callback != null) {
                    String str2 = this.sessionId;
                    String str3 = text;
                    if (str3 == null) {
                        str3 = "";
                    }
                    callback.c(str2, str3);
                }
            }
        });
    }

    @Override // td2.a
    public void c() {
        ConcurrentHashMap concurrentHashMap;
        concurrentHashMap = this.f283709d.audioPttListenerMap;
        if (!concurrentHashMap.containsKey(this.sessionId)) {
            Logger.f235387a.d().w("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "sttQueryFinished current session already finish " + this.sessionId);
            return;
        }
        g(this.sessionId, 0, this.curSttResult);
    }

    @Override // td2.a
    public void d() {
        ConcurrentHashMap concurrentHashMap;
        d dVar;
        concurrentHashMap = this.f283709d.audioPttListenerMap;
        if (concurrentHashMap.containsKey(this.sessionId)) {
            dVar = this.f283709d.audioRecorder;
            if (dVar != null) {
                final SearchAudioRecoder searchAudioRecoder = this.f283709d;
                if (!dVar.isRecording()) {
                    C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.record.SearchAudioRecoder$initNewPttListener$newListener$1$sttQueryFinishWithNoVadSeg$2$1
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

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            a callback = SearchAudioRecoder.this.getCallback();
                            if (callback != null) {
                                callback.b(this.sessionId);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            return;
        }
        Logger.f235387a.d().w("QQSearch.NetDetail.AI.SearchAudioRecoder", 1, "sttQueryFinishWithNoVadSeg current session already finish " + this.sessionId);
    }
}
