package no3;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.now.pkgame.pkgame.pklib.model.e;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import g55.g;
import g55.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0014R\u0014\u0010\u001a\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR(\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010+\u00a8\u00067"}, d2 = {"Lno3/c;", "Lmo3/d;", "Lcom/tencent/now/pkgame/pkgame/pklib/model/e;", "pkGameModel", "", "anchorId", "", "count", "", "U1", "Landroidx/lifecycle/LiveData;", "Lno3/d;", "W1", "Lg55/s;", "rsp", "X1", "leftScore", "rightScore", ICustomDataEditor.STRING_ARRAY_PARAM_2, "R1", "Z1", "M1", "O1", "onCleared", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lno3/d;", "resultIconBean", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "getShowPkResultLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setShowPkResultLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "showPkResultLiveData", "E", "Lcom/tencent/now/pkgame/pkgame/pklib/model/e;", "Ljava/lang/Runnable;", UserInfo.SEX_FEMALE, "Ljava/lang/Runnable;", "executeRunnable", "", "G", "Z", "hasReset", "H", "showResultRunnable", "<init>", "()V", "I", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c extends mo3.d {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<ResultBean> showPkResultLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private e pkGameModel;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Runnable executeRunnable;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasReset;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Runnable showResultRunnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ResultBean resultIconBean = new ResultBean(0, 0);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"no3/c$b", "Lko3/c;", "Lg55/s;", "data", "", "a", "", "code", "", "msg", "fail", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements ko3.c<s> {
        b() {
        }

        @Override // ko3.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull s data) {
            Intrinsics.checkNotNullParameter(data, "data");
            c.this.X1(data);
        }

        @Override // ko3.c
        public void fail(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            AegisLogger.INSTANCE.e("PK_Biz|PkResultViewModel", "fetchPkResult", "fail, code:" + code + ", msg:" + msg2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"no3/c$c", "Lcom/tencent/now/pkgame/pkgame/pklib/model/b;", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: no3.c$c, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C10855c implements com.tencent.now.pkgame.pkgame.pklib.model.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f420632b;

        C10855c(e eVar) {
            this.f420632b = eVar;
        }

        @Override // com.tencent.now.pkgame.pkgame.pklib.model.b
        public void a() {
            c cVar = c.this;
            e eVar = this.f420632b;
            cVar.U1(eVar, eVar.h(), 3);
        }
    }

    public c() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        this.showPkResultLiveData = new MutableLiveData<>();
        this.showResultRunnable = new Runnable() { // from class: no3.b
            @Override // java.lang.Runnable
            public final void run() {
                c.b2(c.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(e pkGameModel, long anchorId, int count) {
        pkGameModel.g(count, new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showPkResultLiveData.postValue(this$0.resultIconBean);
    }

    @Override // mo3.d
    public void M1() {
        super.M1();
        Z1();
    }

    @Override // mo3.d
    public void O1() {
        super.O1();
        Z1();
    }

    @Override // mo3.d
    @SuppressLint({"CheckResult"})
    public void R1(@NotNull e pkGameModel) {
        Intrinsics.checkNotNullParameter(pkGameModel, "pkGameModel");
        super.R1(pkGameModel);
        this.pkGameModel = pkGameModel;
        this.hasReset = false;
        if (pkGameModel != null) {
            pkGameModel.c(new C10855c(pkGameModel));
        }
    }

    @NotNull
    public final LiveData<ResultBean> W1() {
        return this.showPkResultLiveData;
    }

    public final void X1(@NotNull s rsp) {
        long j3;
        g55.e eVar;
        g55.e eVar2;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        if (this.hasReset) {
            AegisLogger.INSTANCE.i("PK_Biz|PkResultViewModel", "\u5df2\u7ecfreset\uff0c\u4e0d\u5c55\u793a\u6570\u636e\u3002");
            return;
        }
        g gVar = rsp.f401387b;
        long j16 = 0;
        if (gVar != null && (eVar2 = gVar.f401364a) != null) {
            j3 = eVar2.f401359b;
        } else {
            j3 = 0;
        }
        g gVar2 = rsp.f401388c;
        if (gVar2 != null && (eVar = gVar2.f401364a) != null) {
            j16 = eVar.f401359b;
        }
        AegisLogger.INSTANCE.i("PK_Biz|PkResultViewModel", "leftScore: " + j3 + ", rightScore: " + j16);
        a2(j3, j16);
        this.executeRunnable = ThreadManagerV2.executeDelay(this.showResultRunnable, 16, null, true, 0L);
    }

    public final void Z1() {
        Runnable runnable = this.executeRunnable;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        this.showPkResultLiveData = new MutableLiveData<>();
        this.executeRunnable = null;
        this.hasReset = true;
    }

    @NotNull
    public final ResultBean a2(long leftScore, long rightScore) {
        if (leftScore == rightScore) {
            this.resultIconBean.c(3);
            this.resultIconBean.d(3);
        } else if (leftScore > rightScore) {
            this.resultIconBean.c(1);
            this.resultIconBean.d(2);
        } else {
            this.resultIconBean.c(2);
            this.resultIconBean.d(1);
        }
        return this.resultIconBean;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Z1();
    }
}
