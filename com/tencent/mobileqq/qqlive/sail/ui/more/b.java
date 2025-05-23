package com.tencent.mobileqq.qqlive.sail.ui.more;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.ui.more.bottom.BottomButtonView;
import com.tencent.mobileqq.qqlive.sail.ui.more.bottom.FreeGiftCountDownInfo;
import com.tencent.mobileqq.qqlive.sail.ui.more.d;
import com.tencent.mobileqq.qqlive.sail.util.SingleLiveEvent;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0002J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019J \u0010 \u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000e\u001a\u00020\b2\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dJ\u0016\u0010\"\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006J\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010$\u001a\u00020\u0004H\u0014R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001d\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\b0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\b0)8\u0006\u00a2\u0006\f\n\u0004\b3\u0010+\u001a\u0004\b4\u0010-R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\b0/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00101R\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020\b0)8\u0006\u00a2\u0006\f\n\u0004\b8\u0010+\u001a\u0004\b9\u0010-R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010'R\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020)8\u0006\u00a2\u0006\f\n\u0004\b=\u0010+\u001a\u0004\b>\u0010-R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010'R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00020)8\u0006\u00a2\u0006\f\n\u0004\bB\u0010+\u001a\u0004\bC\u0010-R&\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110E0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010'R)\u0010J\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110E0)8\u0006\u00a2\u0006\f\n\u0004\bH\u0010+\u001a\u0004\bI\u0010-R\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/b;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "Lar4/a;", "bubbleTip", "", "j2", "", "giftId", "", "W1", "c2", "", "expand", "e2", "buttonId", SemanticAttributes.DbSystemValues.H2, "f2", "", com.tencent.luggage.wxa.c8.c.G, "buttonSum", "g2", "data", "O1", "curBubble", "P1", "Luq4/c;", "dynamicConfigRsp", "Luq4/e;", "U1", "", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/bottom/BottomButtonView;", "buttonList", "d2", "countDownValue", "i2", "R1", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_landBottomExpandLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "X1", "()Landroidx/lifecycle/LiveData;", "landBottomExpandLiveData", "Lcom/tencent/mobileqq/qqlive/sail/util/SingleLiveEvent;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/sail/util/SingleLiveEvent;", "_portraitButtonClickLiveData", "D", ICustomDataEditor.STRING_ARRAY_PARAM_2, "portraitButtonClickLiveData", "E", "_landscapeButtonClickLiveData", UserInfo.SEX_FEMALE, "Z1", "landscapeButtonClickLiveData", "G", "_guideBubbleTipLiveData", "H", "T1", "guideBubbleTipLiveData", "I", "_funcBubbleTipLiveData", "J", "S1", "funcBubbleTipLiveData", "Lkotlin/Pair;", "K", "_quickGiftBtnPositionLiveData", "L", "b2", "quickGiftBtnPositionLiveData", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/d;", "M", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/d;", "bubbleTipManager", "Ljava/lang/Runnable;", "N", "Ljava/lang/Runnable;", "dispatchNextRunnable", "<init>", "()V", "P", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final SingleLiveEvent<String> _portraitButtonClickLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> portraitButtonClickLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final SingleLiveEvent<String> _landscapeButtonClickLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> landscapeButtonClickLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ar4.a> _guideBubbleTipLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<ar4.a> guideBubbleTipLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ar4.a> _funcBubbleTipLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<ar4.a> funcBubbleTipLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Pair<Integer, Integer>> _quickGiftBtnPositionLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Pair<Integer, Integer>> quickGiftBtnPositionLiveData;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private d bubbleTipManager;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Runnable dispatchNextRunnable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _landBottomExpandLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> landBottomExpandLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/more/b$a;", "", "", "KEY_FREE_GIFT_COUNT_DOWN_INFO", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.more.b$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/more/b$b", "Lcom/tencent/mobileqq/qqlive/sail/ui/more/d$a;", "Lar4/a;", "data", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.more.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8396b implements d.a {
        static IPatchRedirector $redirector_;

        C8396b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.sail.ui.more.d.a
        public void a(@NotNull ar4.a data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            b.this.j2(data);
            ThreadManagerV2.getUIHandlerV2().postDelayed(b.this.dispatchNextRunnable, (data.f26816g + data.f26815f) * 1000);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52441);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._landBottomExpandLiveData = mutableLiveData;
        this.landBottomExpandLiveData = mutableLiveData;
        SingleLiveEvent<String> singleLiveEvent = new SingleLiveEvent<>();
        this._portraitButtonClickLiveData = singleLiveEvent;
        this.portraitButtonClickLiveData = singleLiveEvent;
        SingleLiveEvent<String> singleLiveEvent2 = new SingleLiveEvent<>();
        this._landscapeButtonClickLiveData = singleLiveEvent2;
        this.landscapeButtonClickLiveData = singleLiveEvent2;
        MutableLiveData<ar4.a> mutableLiveData2 = new MutableLiveData<>();
        this._guideBubbleTipLiveData = mutableLiveData2;
        this.guideBubbleTipLiveData = mutableLiveData2;
        MutableLiveData<ar4.a> mutableLiveData3 = new MutableLiveData<>();
        this._funcBubbleTipLiveData = mutableLiveData3;
        this.funcBubbleTipLiveData = mutableLiveData3;
        MutableLiveData<Pair<Integer, Integer>> mutableLiveData4 = new MutableLiveData<>();
        this._quickGiftBtnPositionLiveData = mutableLiveData4;
        this.quickGiftBtnPositionLiveData = mutableLiveData4;
        this.bubbleTipManager = new d(new C8396b());
        this.dispatchNextRunnable = new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.more.a
            @Override // java.lang.Runnable
            public final void run() {
                b.Q1(b.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bubbleTipManager.b();
    }

    private final String W1(long giftId) {
        return "key_free_gift_count_down_value_" + giftId;
    }

    private final long c2() {
        return com.tencent.mobileqq.qqlive.sail.c.f272176a.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j2(ar4.a bubbleTip) {
        if (bubbleTip.f26814e != null) {
            this._funcBubbleTipLiveData.postValue(bubbleTip);
        } else {
            this._guideBubbleTipLiveData.postValue(bubbleTip);
        }
    }

    public final void O1(@NotNull ar4.a data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) data);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            this.bubbleTipManager.a(data);
        }
    }

    public final void P1(@NotNull ar4.a curBubble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) curBubble);
            return;
        }
        Intrinsics.checkNotNullParameter(curBubble, "curBubble");
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.dispatchNextRunnable);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.dispatchNextRunnable, curBubble.f26815f * 1000);
    }

    public final long R1(long giftId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this, giftId)).longValue();
        }
        FreeGiftCountDownInfo freeGiftCountDownInfo = (FreeGiftCountDownInfo) ct3.a.i(W1(giftId), FreeGiftCountDownInfo.class, c2());
        if (freeGiftCountDownInfo == null || giftId == 0 || giftId != freeGiftCountDownInfo.c()) {
            return 0L;
        }
        return freeGiftCountDownInfo.a() - ((System.currentTimeMillis() - freeGiftCountDownInfo.b()) / 1000);
    }

    @NotNull
    public final LiveData<ar4.a> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.funcBubbleTipLiveData;
    }

    @NotNull
    public final LiveData<ar4.a> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.guideBubbleTipLiveData;
    }

    @Nullable
    public final uq4.e U1(@NotNull String buttonId, @Nullable uq4.c dynamicConfigRsp) {
        uq4.e[] eVarArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (uq4.e) iPatchRedirector.redirect((short) 14, (Object) this, (Object) buttonId, (Object) dynamicConfigRsp);
        }
        Intrinsics.checkNotNullParameter(buttonId, "buttonId");
        if (dynamicConfigRsp != null && (eVarArr = dynamicConfigRsp.f439829d) != null) {
            for (uq4.e eVar : eVarArr) {
                if (Intrinsics.areEqual(eVar.f439836a, buttonId)) {
                    return eVar;
                }
            }
            return null;
        }
        return null;
    }

    @NotNull
    public final LiveData<Boolean> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.landBottomExpandLiveData;
    }

    @NotNull
    public final LiveData<String> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.landscapeButtonClickLiveData;
    }

    @NotNull
    public final LiveData<String> a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.portraitButtonClickLiveData;
    }

    @NotNull
    public final LiveData<Pair<Integer, Integer>> b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.quickGiftBtnPositionLiveData;
    }

    @Nullable
    public final BottomButtonView d2(@NotNull String buttonId, @NotNull List<BottomButtonView> buttonList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (BottomButtonView) iPatchRedirector.redirect((short) 15, (Object) this, (Object) buttonId, (Object) buttonList);
        }
        Intrinsics.checkNotNullParameter(buttonId, "buttonId");
        Intrinsics.checkNotNullParameter(buttonList, "buttonList");
        for (BottomButtonView bottomButtonView : buttonList) {
            if (bottomButtonView != null && Intrinsics.areEqual(bottomButtonView.m(), buttonId)) {
                return bottomButtonView;
            }
        }
        return null;
    }

    public final void e2(boolean expand2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, expand2);
        } else {
            this._landBottomExpandLiveData.postValue(Boolean.valueOf(expand2));
        }
    }

    public final void f2(@Nullable String buttonId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) buttonId);
        } else if (buttonId != null) {
            this._landscapeButtonClickLiveData.postValue(buttonId);
        }
    }

    public final void g2(int pos, int buttonSum) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(pos), Integer.valueOf(buttonSum));
        } else {
            this._quickGiftBtnPositionLiveData.postValue(new Pair<>(Integer.valueOf(pos), Integer.valueOf(buttonSum)));
        }
    }

    public final void h2(@Nullable String buttonId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) buttonId);
        } else if (buttonId != null) {
            this._portraitButtonClickLiveData.postValue(buttonId);
        }
    }

    public final void i2(long giftId, long countDownValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Long.valueOf(giftId), Long.valueOf(countDownValue));
        } else {
            if (giftId == 0) {
                return;
            }
            ct3.a.r(W1(giftId), c2(), new FreeGiftCountDownInfo(giftId, countDownValue, System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.onCleared();
        this.bubbleTipManager.c();
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.dispatchNextRunnable);
    }
}
