package po3;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.now.pkgame.pkgame.pklib.model.e;
import com.tencent.now.pkgame.pkgame.pklib.state.a;
import com.tencent.now.pkgame.pkgame.scorebar.view.AddScoreBean;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import g55.aa;
import g55.as;
import g55.at;
import g55.au;
import g55.q;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mo3.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 J2\u00020\u0001:\u0001KB\u0013\b\u0017\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\bG\u0010HB\t\b\u0016\u00a2\u0006\u0004\bG\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J \u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010J\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0010J\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00120\u0010J\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00120\u0010J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000bJ(\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000bH\u0017J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0016J\b\u0010(\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020\u0002H\u0016R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0016\u00103\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R$\u0010<\u001a\u0002062\u0006\u00107\u001a\u0002068\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00070=8\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R \u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010?R \u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00120=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010?R \u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00120=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010?\u00a8\u0006L"}, d2 = {"Lpo3/c;", "Lmo3/d;", "", "U1", "e2", "", "scoreBarAnimDone", "Lpo3/a;", "Z1", "i2", "g2", "", "increasedScore", "addScoreRoomId", "currentRoomId", SemanticAttributes.DbSystemValues.H2, "Landroidx/lifecycle/LiveData;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lmo3/a;", "Lcom/tencent/now/pkgame/pkgame/scorebar/view/a;", "W1", "c2", "b2", "anchorId", "d2", "Le55/c;", "positiveInfo", "positiveScore", "negativeInfo", "negativeScore", "j2", "Lcom/tencent/now/pkgame/pkgame/pklib/model/e;", "pkGameModel", "R1", "Lcom/tencent/now/pkgame/pkgame/pklib/state/a;", "currentGameState", "N1", "Ljo3/a;", "pkGameMsg", "P1", "M1", "O1", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/now/pkgame/pkgame/pklib/state/a;", BdhLogUtil.LogTag.Tag_Conn, "Lpo3/a;", "realScoreBean", "D", "fakeScoreBean", "E", "Z", "isScoreBarAnimDone", UserInfo.SEX_FEMALE, "Lcom/tencent/now/pkgame/pkgame/pklib/model/e;", "", "<set-?>", "G", "Ljava/lang/String;", "X1", "()Ljava/lang/String;", "pkId", "Landroidx/lifecycle/MutableLiveData;", "H", "Landroidx/lifecycle/MutableLiveData;", "scoreBeanLiveData", "I", "addScoreLiveData", "J", "showScoreBarAnimLiveData", "K", "showPunishmentCursorLiveData", "<init>", "(Lcom/tencent/now/pkgame/pkgame/pklib/model/e;)V", "()V", "L", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c extends d {

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isScoreBarAnimDone;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private e pkGameModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.now.pkgame.pkgame.pklib.state.a currentGameState = new a.f();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final a realScoreBean = new a();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private a fakeScoreBean = new a();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String pkId = "";

    /* renamed from: H, reason: from kotlin metadata */
    @JvmField
    @NotNull
    protected MutableLiveData<a> scoreBeanLiveData = new MutableLiveData<>();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<mo3.a<AddScoreBean>> addScoreLiveData = new MutableLiveData<>();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<mo3.a<Boolean>> showScoreBarAnimLiveData = new MutableLiveData<>();

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<mo3.a<Boolean>> showPunishmentCursorLiveData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"po3/c$b", "Lko3/c;", "Lg55/q;", "data", "", "a", "", "code", "", "msg", "fail", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements ko3.c<q> {
        b() {
        }

        @Override // ko3.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull q data) {
            Intrinsics.checkNotNullParameter(data, "data");
            at atVar = data.f401379b;
            if (atVar != null) {
                c cVar = c.this;
                cVar.pkId = String.valueOf(atVar.f401325a);
                e55.c cVar2 = atVar.f401327c.f401358a;
                Intrinsics.checkNotNullExpressionValue(cVar2, "it.positiveInfo.basicInfo");
                long j3 = atVar.f401327c.f401359b;
                e55.c cVar3 = atVar.f401328d.f401358a;
                Intrinsics.checkNotNullExpressionValue(cVar3, "it.negativeInfo.basicInfo");
                cVar.j2(cVar2, j3, cVar3, atVar.f401328d.f401359b);
            }
        }

        @Override // ko3.c
        public void fail(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    @VisibleForTesting
    public c(@Nullable e eVar) {
        this.pkGameModel = eVar;
    }

    private final void U1() {
        e eVar = this.pkGameModel;
        if (eVar != null) {
            eVar.f(new b());
        }
    }

    private final a Z1(boolean scoreBarAnimDone) {
        if (scoreBarAnimDone) {
            return this.realScoreBean;
        }
        a aVar = new a();
        this.fakeScoreBean = aVar;
        a aVar2 = this.realScoreBean;
        aVar.leftAnchor = aVar2.leftAnchor;
        aVar.rightAnchor = aVar2.rightAnchor;
        aVar.leftScore = 0L;
        aVar.rightScore = 0L;
        aVar.a();
        return this.fakeScoreBean;
    }

    private final void e2() {
        e eVar = this.pkGameModel;
        if (eVar != null) {
            eVar.s();
        }
        e eVar2 = this.pkGameModel;
        if (eVar2 != null) {
            eVar2.a(new com.tencent.now.pkgame.pkgame.pklib.model.c() { // from class: po3.b
                @Override // com.tencent.now.pkgame.pkgame.pklib.model.c
                public final void a(au auVar) {
                    c.f2(c.this, auVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(c this$0, au auVar) {
        aa aaVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|ScoreBarViewModel", "rev push: " + auVar);
        if (auVar.f401337b == 3) {
            e eVar = this$0.pkGameModel;
            if (eVar != null) {
                eVar.v(true);
            }
            companion.i("PK_Biz|ScoreBarViewModel", "\u6536\u5230\u7ed3\u7b97Push\uff0c\u4e0d\u66f4\u65b0\u79ef\u5206\u6761");
            return;
        }
        e eVar2 = this$0.pkGameModel;
        Intrinsics.checkNotNull(eVar2);
        if (eVar2.f338975k) {
            companion.i("PK_Biz|ScoreBarViewModel", "PK\u5df2\u7ecf\u7ed3\u7b97\uff0c\u4e0d\u66f4\u65b0\u79ef\u5206\u6761");
            return;
        }
        if (auVar.f401337b == 2 && (aaVar = auVar.f401338c) != null) {
            long j3 = aaVar.f401284d;
            long j16 = aaVar.f401281a.f395736b;
            e eVar3 = this$0.pkGameModel;
            Intrinsics.checkNotNull(eVar3);
            this$0.h2(j3, j16, eVar3.o());
        }
        as asVar = auVar.f401339d;
        if (asVar != null) {
            e55.c cVar = asVar.f401314c;
            Intrinsics.checkNotNullExpressionValue(cVar, "it.positiveInfo");
            long j17 = asVar.f401316e;
            e55.c cVar2 = asVar.f401315d;
            Intrinsics.checkNotNullExpressionValue(cVar2, "it.negativeInfo");
            this$0.j2(cVar, j17, cVar2, asVar.f401317f);
        }
    }

    private final void g2() {
        this.realScoreBean.h();
        this.scoreBeanLiveData.setValue(this.realScoreBean);
        this.addScoreLiveData.setValue(new mo3.a<>(new AddScoreBean("none", "none")));
        MutableLiveData<mo3.a<Boolean>> mutableLiveData = this.showScoreBarAnimLiveData;
        Boolean bool = Boolean.FALSE;
        mutableLiveData.setValue(new mo3.a<>(bool));
        this.showPunishmentCursorLiveData.setValue(new mo3.a<>(bool));
        this.isScoreBarAnimDone = false;
    }

    private final void h2(long increasedScore, long addScoreRoomId, long currentRoomId) {
        if (increasedScore <= 0) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("+%s", Arrays.copyOf(new Object[]{Long.valueOf(increasedScore)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        if (addScoreRoomId == currentRoomId) {
            this.addScoreLiveData.setValue(new mo3.a<>(new AddScoreBean(format, "left")));
        } else {
            this.addScoreLiveData.setValue(new mo3.a<>(new AddScoreBean(format, "right")));
        }
    }

    private final void i2() {
        e eVar = this.pkGameModel;
        if (eVar != null) {
            eVar.A();
        }
    }

    @Override // mo3.d
    public void M1() {
        super.M1();
        i2();
        g2();
    }

    @Override // mo3.d
    public void N1(@NotNull com.tencent.now.pkgame.pkgame.pklib.state.a currentGameState) {
        Intrinsics.checkNotNullParameter(currentGameState, "currentGameState");
        super.N1(currentGameState);
        this.currentGameState = currentGameState;
        if (currentGameState instanceof a.e) {
            this.showPunishmentCursorLiveData.setValue(new mo3.a<>(Boolean.TRUE));
        }
    }

    @Override // mo3.d
    public void O1() {
        super.O1();
        i2();
        g2();
    }

    @Override // mo3.d
    public void P1(@NotNull jo3.a pkGameMsg) {
        Intrinsics.checkNotNullParameter(pkGameMsg, "pkGameMsg");
        super.P1(pkGameMsg);
        if (pkGameMsg instanceof jo3.b) {
            this.showScoreBarAnimLiveData.setValue(new mo3.a<>(Boolean.TRUE));
        }
        if (pkGameMsg instanceof jo3.c) {
            this.isScoreBarAnimDone = true;
            this.realScoreBean.a();
            this.scoreBeanLiveData.setValue(this.realScoreBean);
        }
    }

    @Override // mo3.d
    public void R1(@NotNull e pkGameModel) {
        Intrinsics.checkNotNullParameter(pkGameModel, "pkGameModel");
        super.R1(pkGameModel);
        this.pkGameModel = pkGameModel;
        d2(pkGameModel.h());
    }

    @NotNull
    public final LiveData<mo3.a<AddScoreBean>> W1() {
        return this.addScoreLiveData;
    }

    @NotNull
    /* renamed from: X1, reason: from getter */
    public final String getPkId() {
        return this.pkId;
    }

    @NotNull
    public final LiveData<a> a2() {
        return this.scoreBeanLiveData;
    }

    @NotNull
    public final LiveData<mo3.a<Boolean>> b2() {
        return this.showPunishmentCursorLiveData;
    }

    @NotNull
    public final LiveData<mo3.a<Boolean>> c2() {
        return this.showScoreBarAnimLiveData;
    }

    public final void d2(long anchorId) {
        U1();
        e2();
    }

    @VisibleForTesting
    public void j2(@NotNull e55.c positiveInfo, long positiveScore, @NotNull e55.c negativeInfo, long negativeScore) {
        Intrinsics.checkNotNullParameter(positiveInfo, "positiveInfo");
        Intrinsics.checkNotNullParameter(negativeInfo, "negativeInfo");
        a aVar = this.realScoreBean;
        aVar.leftScore = positiveScore;
        aVar.leftAnchor = positiveInfo;
        aVar.rightScore = negativeScore;
        aVar.rightAnchor = negativeInfo;
        aVar.a();
        this.scoreBeanLiveData.setValue(Z1(this.isScoreBarAnimDone));
    }

    public c() {
    }
}
