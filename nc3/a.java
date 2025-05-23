package nc3;

import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.qphone.base.util.QLog;
import kc3.GameJudgeParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mc3.InsExeExtParam;
import nc3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\r\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lnc3/a;", "Lnc3/b$a;", "Lxu4/c;", "rsp", "", "e", "", "duration", "c", "a", "b", "Lkc3/a;", "Lkc3/a;", "judgeParams", "<init>", "(Lkc3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends b.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final GameJudgeParams judgeParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"nc3/a$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lxu4/c;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements e<xu4.c> {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(xu4.c result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("DefaultBeatConsumer_", 1, "onStart onResultSuccess\n" + mc3.b.b(result));
            a.this.e(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("DefaultBeatConsumer_", 1, "onStart onResultFailure error:" + error + ", message:" + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"nc3/a$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lxu4/c;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements e<xu4.c> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(xu4.c result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("DefaultBeatConsumer_", 1, "onStop onResultSuccess\n" + mc3.b.b(result));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("DefaultBeatConsumer_", 1, "onStop onResultFailure error:" + error + ", message:" + message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"nc3/a$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lxu4/c;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements e<xu4.c> {
        d() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(xu4.c result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("DefaultBeatConsumer_", 1, "onTick onResultSuccess\n" + mc3.b.b(result));
            a.this.e(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("DefaultBeatConsumer_", 1, "onTick onResultFailure error:" + error + ", message:" + message);
        }
    }

    public a(GameJudgeParams judgeParams) {
        Intrinsics.checkNotNullParameter(judgeParams, "judgeParams");
        this.judgeParams = judgeParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(xu4.c rsp) {
        int i3 = rsp.f448719a;
        if (i3 != 0) {
            QLog.e("DefaultBeatConsumer_", 1, "handleJudgeTimingRsp bad ret:" + i3);
            return;
        }
        xu4.a[] aVarArr = rsp.f448722d;
        Intrinsics.checkNotNullExpressionValue(aVarArr, "rsp.instructions");
        if (aVarArr.length == 0) {
            return;
        }
        oc3.b bVar = oc3.b.f422445a;
        String str = rsp.f448721c;
        if (str == null) {
            str = "";
        }
        InsExeExtParam insExeExtParam = new InsExeExtParam(str);
        GameJudgeParams gameJudgeParams = this.judgeParams;
        xu4.a[] aVarArr2 = rsp.f448722d;
        Intrinsics.checkNotNullExpressionValue(aVarArr2, "rsp.instructions");
        bVar.a(2L, insExeExtParam, gameJudgeParams, aVarArr2);
    }

    @Override // nc3.b.a
    public void a() {
        qc3.a.f428847a.b(11, 0, this.judgeParams, new b());
    }

    @Override // nc3.b.a
    public void b(int duration) {
        qc3.a.f428847a.b(13, duration, this.judgeParams, new c());
    }

    @Override // nc3.b.a
    public void c(int duration) {
        qc3.a.f428847a.b(12, duration, this.judgeParams, new d());
    }
}
