package com.tencent.mobileqq.matchfriend.reborn.content.main.matching.surprise;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.surprise_match.surprise_match.SurpriseMatchPB$RecommendRsp;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJO\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0006\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0004J\u001c\u0010\u0015\u001a\u00020\u000b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0014\u001a\u00020\u0004R\u001f\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/matching/surprise/QQStrangerSurpriseMatchingVM;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "cmd", "req", "Ljava/lang/Class;", "rspClass", "O1", "(Ljava/lang/String;Lcom/tencent/mobileqq/pb/MessageMicro;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "P1", "", "type", "cookies", "N1", "", "", "tinyIds", "content", "Q1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/trpcprotocol/kuolie/surprise_match/surprise_match/SurpriseMatchPB$RecommendRsp;", "i", "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "recommendLiveData", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSurpriseMatchingVM extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<SurpriseMatchPB$RecommendRsp> recommendLiveData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tH\n\u00a2\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "T", "Lcom/tencent/mobileqq/pb/MessageMicro;", "<anonymous parameter 0>", "", "isSuccess", "", "data", "", "kotlin.jvm.PlatformType", "onUpdate"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class b implements com.tencent.relation.common.servlet.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Class<T> f244516d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f244517e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<T> f244518f;

        /* JADX WARN: Multi-variable type inference failed */
        b(Class<T> cls, String str, CancellableContinuation<? super T> cancellableContinuation) {
            this.f244516d = cls;
            this.f244517e = str;
            this.f244518f = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public final void onUpdate(int i3, boolean z16, Object obj) {
            MessageMicro messageMicro;
            if (z16 && (obj instanceof byte[])) {
                try {
                    messageMicro = (MessageMicro) this.f244516d.newInstance();
                    messageMicro.mergeFrom((byte[]) obj);
                } catch (Exception e16) {
                    QLog.e("QQStrangerSurpriseMatchingVM", 1, "[" + this.f244517e + "] merge from exception ", e16);
                    messageMicro = null;
                }
                this.f244518f.resume(messageMicro, null);
                return;
            }
            QLog.e("QQStrangerSurpriseMatchingVM", 1, "[" + this.f244517e + "] isSuccess=" + z16 + " data=" + obj);
            this.f244518f.resume(null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends MessageMicro<T>> Object O1(String str, MessageMicro<? extends MessageMicro<?>> messageMicro, Class<T> cls, Continuation<? super T> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d("QQStrangerSurpriseMatchingVM", 1, "[" + str + "] network is not available");
            cancellableContinuationImpl.resume(null, null);
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            Object businessHandler = appInterface != null ? appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4) : null;
            com.tencent.relation.common.servlet.a aVar = businessHandler instanceof com.tencent.relation.common.servlet.a ? (com.tencent.relation.common.servlet.a) businessHandler : null;
            if (aVar != null) {
                aVar.Z0(str, messageMicro.toByteArray(), new b(cls, str, cancellableContinuationImpl));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final MutableLiveData<SurpriseMatchPB$RecommendRsp> M1() {
        return this.recommendLiveData;
    }

    public final void N1(int type, String cookies) {
        Intrinsics.checkNotNullParameter(cookies, "cookies");
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSurpriseMatchingVM", Boolean.FALSE, null, null, new QQStrangerSurpriseMatchingVM$reportAction$1(type, this, cookies, null), 12, null);
    }

    public final void P1() {
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSurpriseMatchingVM", Boolean.FALSE, null, null, new QQStrangerSurpriseMatchingVM$requestRecommend$1(this, null), 12, null);
    }

    public final void Q1(List<Long> tinyIds, String content) {
        Intrinsics.checkNotNullParameter(tinyIds, "tinyIds");
        Intrinsics.checkNotNullParameter(content, "content");
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerSurpriseMatchingVM", Boolean.FALSE, null, null, new QQStrangerSurpriseMatchingVM$sendTextMsg$1(tinyIds, content, null), 12, null);
    }
}
