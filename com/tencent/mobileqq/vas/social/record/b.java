package com.tencent.mobileqq.vas.social.record;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001c\b&\u0018\u0000 <2\u00020\u0001:\u0001\u000eB#\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010 \u001a\u00020\u0006\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010!\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0000J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0004J\u0006\u0010\u0012\u001a\u00020\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0006H\u0014J\u0006\u0010\u0014\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006H\u0004R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010 \u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\"\u001a\u0004\b\u0018\u0010#\"\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010\u00008\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010.R\"\u00104\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u00100\u001a\u0004\b'\u00101\"\u0004\b2\u00103R\u0016\u00107\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/vas/social/record/b;", "", "", "g", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/vas/social/record/RecordState;", "e", "Lcom/tencent/mobileqq/vas/social/record/g;", "product", "k", "currentState", "l", "step", "a", "", "c", DomainData.DOMAIN_NAME, "f", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "state", "b", "Lcom/tencent/mobileqq/vas/data/b;", "d", "Lcom/tencent/mobileqq/vas/data/b;", "j", "()Lcom/tencent/mobileqq/vas/data/b;", "taskInfo", "Lcom/tencent/mobileqq/vas/social/record/RecordState;", "i", "()Lcom/tencent/mobileqq/vas/social/record/RecordState;", "stepState", "Lcom/tencent/mobileqq/vas/social/record/c;", "Lcom/tencent/mobileqq/vas/social/record/c;", "()Lcom/tencent/mobileqq/vas/social/record/c;", "o", "(Lcom/tencent/mobileqq/vas/social/record/c;)V", "listener", tl.h.F, "Lcom/tencent/mobileqq/vas/social/record/b;", "getNext", "()Lcom/tencent/mobileqq/vas/social/record/b;", "setNext", "(Lcom/tencent/mobileqq/vas/social/record/b;)V", "next", "Z", "isStepDone", "Lcom/tencent/mobileqq/vas/social/record/g;", "()Lcom/tencent/mobileqq/vas/social/record/g;", "setStepProduct", "(Lcom/tencent/mobileqq/vas/social/record/g;)V", "stepProduct", BdhLogUtil.LogTag.Tag_Conn, "J", "startTime", "D", "endTime", "<init>", "(Lcom/tencent/mobileqq/vas/data/b;Lcom/tencent/mobileqq/vas/social/record/RecordState;Lcom/tencent/mobileqq/vas/social/record/c;)V", "E", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class b {

    /* renamed from: C, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: D, reason: from kotlin metadata */
    private long endTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.vas.data.b taskInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final RecordState stepState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private c listener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private b next;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isStepDone;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private RecordStepProduct stepProduct;

    public b(com.tencent.mobileqq.vas.data.b taskInfo, RecordState stepState, c cVar) {
        Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        Intrinsics.checkNotNullParameter(stepState, "stepState");
        this.taskInfo = taskInfo;
        this.stepState = stepState;
        this.listener = cVar;
        this.stepProduct = new RecordStepProduct(null, null, null, null, null, 31, null);
    }

    private final RecordState e() {
        return e.a(this.stepState);
    }

    private final long g() {
        long j3 = this.startTime;
        if (j3 == 0) {
            return 0L;
        }
        long j16 = this.endTime;
        if (j16 == 0) {
            return 0L;
        }
        return (j16 - j3) / 1000000;
    }

    private final void q() {
        RecordCacheManager.f310795a.g(this.taskInfo.getIdentifier(), this.taskInfo.getActionId(), e().name(), this.stepProduct, this.taskInfo.getMode());
    }

    public final void a(b step) {
        Intrinsics.checkNotNullParameter(step, "step");
        this.next = step;
    }

    protected final void b(RecordState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        b bVar = this.next;
        if (bVar != null) {
            bVar.l(state, this.stepProduct);
        }
    }

    public boolean c() {
        return true;
    }

    /* renamed from: d, reason: from getter */
    public final c getListener() {
        return this.listener;
    }

    /* renamed from: f, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h, reason: from getter */
    public final RecordStepProduct getStepProduct() {
        return this.stepProduct;
    }

    /* renamed from: i, reason: from getter */
    public final RecordState getStepState() {
        return this.stepState;
    }

    /* renamed from: j, reason: from getter */
    public final com.tencent.mobileqq.vas.data.b getTaskInfo() {
        return this.taskInfo;
    }

    public abstract void k(RecordStepProduct product);

    public void l(RecordState currentState, RecordStepProduct product) {
        Intrinsics.checkNotNullParameter(currentState, "currentState");
        Intrinsics.checkNotNullParameter(product, "product");
        this.startTime = System.nanoTime();
        this.stepProduct = product;
        if (p(currentState)) {
            QLog.d("RecordStep", 4, "handle " + getClass().getCanonicalName() + " skip");
            b(currentState);
            return;
        }
        QLog.d("RecordStep", 1, "[RECORD] 5. handleStep:" + this + ", info:" + this.taskInfo + ", product:" + product);
        k(product);
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsStepDone() {
        return this.isStepDone;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n() {
        this.endTime = System.nanoTime();
        this.isStepDone = true;
        QLog.d("RecordStep", 2, "handle " + getClass().getCanonicalName() + " done, info:" + this.taskInfo + ", product:" + this.stepProduct);
        if (c()) {
            q();
            b(e());
            c cVar = this.listener;
            if (cVar != null) {
                cVar.a(this.stepState, this.stepProduct, g());
                return;
            }
            return;
        }
        c cVar2 = this.listener;
        if (cVar2 != null) {
            cVar2.onError(-99, this.stepState.name() + ": step done but product invalid");
        }
    }

    public final void o(c cVar) {
        this.listener = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p(RecordState currentState) {
        Intrinsics.checkNotNullParameter(currentState, "currentState");
        return currentState.ordinal() > this.stepState.ordinal();
    }
}
