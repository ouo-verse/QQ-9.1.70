package ne3;

import android.text.TextUtils;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker;
import com.tencent.mobileqq.zplan.authorize.impl.checker.mod.EnterModCheckRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qv4.ai;
import qv4.aj;
import qv4.bs;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lne3/a;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/mod/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "", "b", Const.BUNDLE_KEY_REQUEST, "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "", "j", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends BaseChecker<EnterModCheckRequest, EnterModCheckResult> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"ne3/a$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/aj;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements e<aj> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ EnterModCheckResult f420063e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ EnterModCheckRequest f420064f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> f420065h;

        b(EnterModCheckResult enterModCheckResult, EnterModCheckRequest enterModCheckRequest, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> aVar) {
            this.f420063e = enterModCheckResult;
            this.f420064f = enterModCheckRequest;
            this.f420065h = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x006f, code lost:
        
            if (r7.f429938k == 1) goto L11;
         */
        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResultSuccess(aj result) {
            boolean z16;
            Intrinsics.checkNotNullParameter(result, "result");
            a.this.f("check fail cloudGameStatus=" + result.f429938k + " mapVersion=" + result.f429931d + " toast=" + result.f429930c);
            if (this.f420063e.getEnterParamsAfterCheck() == null) {
                this.f420063e.setEnterParamsAfterCheck(this.f420064f.getEnterParams());
            }
            ZootopiaEnterParams enterParamsAfterCheck = this.f420063e.getEnterParamsAfterCheck();
            Intrinsics.checkNotNull(enterParamsAfterCheck);
            String str = result.f429931d;
            Intrinsics.checkNotNullExpressionValue(str, "result.mapVersion");
            enterParamsAfterCheck.setVersion(str);
            this.f420063e.setCloudServerStatus(result.f429938k);
            if (TextUtils.isEmpty(result.f429930c)) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                a.this.d(this.f420064f, this.f420063e, this.f420065h);
                return;
            }
            if (!TextUtils.isEmpty(result.f429930c)) {
                a aVar = a.this;
                String str2 = result.f429930c;
                Intrinsics.checkNotNullExpressionValue(str2, "result.toast");
                aVar.i(str2);
            }
            this.f420063e.setCloudServerStatus(result.f429938k);
            this.f420063e.setResultCode(23);
            this.f420063e.setProcessInner(false);
            this.f420065h.b(this.f420063e);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            a.this.f("onResultFailure error=" + error + " message=" + message);
            this.f420063e.setResultCode(22);
            this.f420065h.b(this.f420063e);
        }
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    public String b() {
        return "CloudModInfoChecker";
    }

    @Override // com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void a(EnterModCheckRequest request, EnterModCheckResult lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(lastCheckResult, "lastCheckResult");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.a(request, lastCheckResult, callback);
        ai aiVar = new ai();
        aiVar.f429926b = 1;
        bs bsVar = new bs();
        aiVar.f429925a = bsVar;
        bsVar.f430115a = request.getEnterParams().getMapId();
        aiVar.f429925a.f430116b = request.getEnterParams().getVersion();
        Map<String, Object> ueParams = request.getEnterParams().getUeParams();
        Object obj = ueParams != null ? ueParams.get("serverExtraInfo") : null;
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        aiVar.f429927c = str;
        oe3.a.d(oe3.a.f422578a, aiVar, new b(lastCheckResult, request, callback), 0, 4, null);
    }
}
