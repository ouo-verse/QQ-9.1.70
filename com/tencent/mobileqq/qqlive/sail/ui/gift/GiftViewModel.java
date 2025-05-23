package com.tencent.mobileqq.qqlive.sail.ui.gift;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.timi.game.gift.impl.timi.TimiGiftEvent;
import com.tencent.timi.game.initer.impl.b;
import com.tencent.timi.game.liveroom.impl.room.quickgift.quicksendgift.FreeGiftSendResultEvent;
import com.tencent.timi.game.liveroom.impl.room.quickgift.quicksendgift.PurchasePackageGiftEvent;
import com.tencent.timi.game.sso.request.QQLiveGetActivityPopConfRequest;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pk4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\u0018\u0000 V2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001WB\u0007\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r0\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0011J\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\bJ\u000e\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0016R\u001c\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001f\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010#R\u001c\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010#R$\u00103\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u0001000!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u0010#R\u001c\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001f\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010+0%8\u0006\u00a2\u0006\f\n\u0004\b8\u0010'\u001a\u0004\b9\u0010)R\"\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010100048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00106R%\u0010?\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000101000%8\u0006\u00a2\u0006\f\n\u0004\b=\u0010'\u001a\u0004\b>\u0010)R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00110!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010#R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00110%8\u0006\u00a2\u0006\f\n\u0004\bB\u0010'\u001a\u0004\bC\u0010)R\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00110!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010#R\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00110%8\u0006\u00a2\u0006\f\n\u0004\bG\u0010'\u001a\u0004\bH\u0010)R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010#R\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0006\u00a2\u0006\f\n\u0004\bL\u0010'\u001a\u0004\bM\u0010)R\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00110!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010#R\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00110%8\u0006\u00a2\u0006\f\n\u0004\bQ\u0010'\u001a\u0004\bR\u0010)\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "giftId", "", "p2", "", "o2", ICustomDataEditor.NUMBER_PARAM_2, "t2", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "event", "onReceiveEvent", "", "show", ICustomDataEditor.STRING_PARAM_2, "Lcom/tencent/mobileqq/qqgift/data/service/d;", "j2", "Lok4/a;", "g2", "enable", "c2", "roomId", "roomType", "d2", "Lok4/b;", "data", "r2", "q2", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_quickGiftData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "k2", "()Landroidx/lifecycle/LiveData;", "quickGiftDataLiveData", "Lc55/d;", BdhLogUtil.LogTag.Tag_Conn, "_quickGiftConfig", "D", "_freeGiftConfig", "", "Lc55/a;", "E", "_giftGuideConfig", "Landroidx/lifecycle/MediatorLiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MediatorLiveData;", "_enableQuickGift", "G", "f2", "enableQuickGift", "H", "_giftGuideConfigLiveData", "I", "i2", "giftGuideConfigLiveData", "J", "_enableGift", "K", "e2", "enableGiftLiveData", "L", "_showGiftPanel", "M", "m2", "showGiftPanelLiveData", "N", "_freeGiftRedDotNum", "P", SemanticAttributes.DbSystemValues.H2, "freeGiftRedDotNumLiveData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "_sendFreeGiftEnd", BdhLogUtil.LogTag.Tag_Req, "l2", "sendFreeGiftEndLiveData", "<init>", "()V", ExifInterface.LATITUDE_SOUTH, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GiftViewModel extends com.tencent.mobileqq.qqlive.sail.base.d implements SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<c55.d> _quickGiftConfig;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<ok4.a> _freeGiftConfig;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<c55.a[]> _giftGuideConfig;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<c55.d> _enableQuickGift;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<c55.d> enableQuickGift;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<c55.a[]> _giftGuideConfigLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LiveData<c55.a[]> giftGuideConfigLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _enableGift;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> enableGiftLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _showGiftPanel;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> showGiftPanelLiveData;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> _freeGiftRedDotNum;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Long> freeGiftRedDotNumLiveData;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _sendFreeGiftEnd;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> sendFreeGiftEndLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.qqgift.data.service.d> _quickGiftData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.qqgift.data.service.d> quickGiftDataLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.gift.GiftViewModel$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel$b", "Lcom/tencent/timi/game/initer/impl/b$a;", "", "giftCount", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements b.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GiftViewModel.this);
            }
        }

        @Override // com.tencent.timi.game.initer.impl.b.a
        public void a(long giftCount) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, giftCount);
            } else {
                GiftViewModel.this._freeGiftRedDotNum.postValue(Long.valueOf(giftCount));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/gift/GiftViewModel$c", "Lpk4/b$j;", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftData", "", "a", "", "errCode", "", "errMsg", "onFail", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements b.j {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GiftViewModel.this);
            }
        }

        @Override // pk4.b.j
        public void a(@Nullable com.tencent.mobileqq.qqgift.data.service.d giftData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) giftData);
            } else if (giftData == null) {
                AegisLogger.INSTANCE.w("Gift|GiftViewModel", "requestQuickGiftData", "failed, invalid giftData");
            } else {
                GiftViewModel.this._quickGiftData.postValue(giftData);
            }
        }

        @Override // pk4.b.j
        public void onFail(int errCode, @Nullable String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) errMsg);
                return;
            }
            AegisLogger.INSTANCE.w("Gift|GiftViewModel", "requestQuickGiftData", "failed, errCode=" + errCode + ", errMsg=" + errMsg);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51997);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GiftViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<com.tencent.mobileqq.qqgift.data.service.d> mutableLiveData = new MutableLiveData<>();
        this._quickGiftData = mutableLiveData;
        this.quickGiftDataLiveData = mutableLiveData;
        MutableLiveData<c55.d> mutableLiveData2 = new MutableLiveData<>();
        this._quickGiftConfig = mutableLiveData2;
        this._freeGiftConfig = new MutableLiveData<>();
        MutableLiveData<c55.a[]> mutableLiveData3 = new MutableLiveData<>();
        this._giftGuideConfig = mutableLiveData3;
        MediatorLiveData<c55.d> mediatorLiveData = new MediatorLiveData<>();
        this._enableQuickGift = mediatorLiveData;
        this.enableQuickGift = mediatorLiveData;
        MediatorLiveData<c55.a[]> mediatorLiveData2 = new MediatorLiveData<>();
        this._giftGuideConfigLiveData = mediatorLiveData2;
        this.giftGuideConfigLiveData = mediatorLiveData2;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._enableGift = mutableLiveData4;
        this.enableGiftLiveData = mutableLiveData4;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this._showGiftPanel = mutableLiveData5;
        this.showGiftPanelLiveData = mutableLiveData5;
        MutableLiveData<Long> mutableLiveData6 = new MutableLiveData<>();
        this._freeGiftRedDotNum = mutableLiveData6;
        this.freeGiftRedDotNumLiveData = mutableLiveData6;
        MutableLiveData<Boolean> mutableLiveData7 = new MutableLiveData<>();
        this._sendFreeGiftEnd = mutableLiveData7;
        this.sendFreeGiftEndLiveData = mutableLiveData7;
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.GiftViewModel.1
            static IPatchRedirector $redirector_;

            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GiftViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!it.booleanValue() || GiftViewModel.this._quickGiftConfig.getValue() == 0) {
                    return;
                }
                GiftViewModel.this._enableQuickGift.setValue(GiftViewModel.this._quickGiftConfig.getValue());
            }
        };
        mediatorLiveData.addSource(mutableLiveData4, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GiftViewModel.P1(Function1.this, obj);
            }
        });
        final Function1<c55.d, Unit> function12 = new Function1<c55.d, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.GiftViewModel.2
            static IPatchRedirector $redirector_;

            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GiftViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c55.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable c55.d dVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dVar);
                } else {
                    if (!Intrinsics.areEqual(GiftViewModel.this._enableGift.getValue(), Boolean.TRUE) || dVar == null) {
                        return;
                    }
                    GiftViewModel.this._enableQuickGift.setValue(GiftViewModel.this._quickGiftConfig.getValue());
                }
            }
        };
        mediatorLiveData.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GiftViewModel.Q1(Function1.this, obj);
            }
        });
        final Function1<c55.a[], Unit> function13 = new Function1<c55.a[], Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.GiftViewModel.3
            static IPatchRedirector $redirector_;

            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GiftViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c55.a[] aVarArr) {
                invoke2(aVarArr);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable c55.a[] aVarArr) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) aVarArr);
                } else {
                    if (!Intrinsics.areEqual(GiftViewModel.this._enableGift.getValue(), Boolean.TRUE) || aVarArr == null) {
                        return;
                    }
                    GiftViewModel.this._giftGuideConfigLiveData.postValue(aVarArr);
                }
            }
        };
        mediatorLiveData2.addSource(mutableLiveData3, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GiftViewModel.R1(Function1.this, obj);
            }
        });
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.GiftViewModel.4
            static IPatchRedirector $redirector_;

            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GiftViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!it.booleanValue() || GiftViewModel.this._giftGuideConfig.getValue() == 0) {
                    return;
                }
                GiftViewModel.this._giftGuideConfigLiveData.postValue(GiftViewModel.this._giftGuideConfig.getValue());
            }
        };
        mediatorLiveData2.addSource(mutableLiveData4, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GiftViewModel.S1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void o2(int giftId) {
        com.tencent.timi.game.initer.impl.b.f377190a.i(QQLiveSDKConfigHelper.getSceneId(), giftId, new b());
    }

    private final void p2(long giftId) {
        pk4.b.u(giftId, new c());
    }

    public final void c2(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, enable);
        } else {
            this._enableGift.postValue(Boolean.valueOf(enable));
        }
    }

    public final void d2(final long roomId, int roomType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(roomId), Integer.valueOf(roomType));
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetActivityPopConfRequest(roomId, roomType), new Function1<QQLiveResponse<c55.c>, Unit>(roomId) { // from class: com.tencent.mobileqq.qqlive.sail.ui.gift.GiftViewModel$fetchQuickGiftConfig$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $roomId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$roomId = roomId;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GiftViewModel.this, Long.valueOf(roomId));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<c55.c> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<c55.c> response) {
                    String l3;
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(response, "response");
                    c55.c rsp = response.getRsp();
                    if (!response.isFailed() && rsp != null) {
                        c55.d dVar = rsp.f30389c;
                        if (((dVar == null || (str = dVar.f30390a) == null) ? null : StringsKt__StringNumberConversionsKt.toLongOrNull(str)) == null) {
                            AegisLogger.INSTANCE.w("Gift|GiftViewModel", "fetchQuickGiftConfig", "invalid giftId");
                            GiftViewModel.this._quickGiftConfig.postValue(null);
                            GiftViewModel.this._giftGuideConfig.postValue(null);
                            return;
                        }
                        com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
                        QQLiveDaTongParams f16 = aVar.f(this.$roomId);
                        f16.d("ev_qqlive_room_experimentid");
                        c55.d dVar2 = rsp.f30389c;
                        String str2 = dVar2 != null ? dVar2.f30390a : null;
                        String str3 = "";
                        if (str2 == null) {
                            str2 = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(str2, "rsp.quickGiftConf?.giftId ?: \"\"");
                        }
                        f16.v(str2);
                        c55.d dVar3 = rsp.f30389c;
                        if (dVar3 != null && (l3 = Long.valueOf(dVar3.f30393d).toString()) != null) {
                            str3 = l3;
                        }
                        f16.h(str3);
                        aVar.i("ev_qqlive_room_experimentid", f16.a());
                        GiftViewModel.this._quickGiftConfig.postValue(rsp.f30389c);
                        GiftViewModel.this._giftGuideConfig.postValue(rsp.f30387a);
                        return;
                    }
                    AegisLogger.INSTANCE.w("Gift|GiftViewModel", "fetchQuickGiftConfig", "response=" + response);
                    GiftViewModel.this._quickGiftConfig.postValue(null);
                    GiftViewModel.this._giftGuideConfig.postValue(null);
                }
            });
        }
    }

    @NotNull
    public final LiveData<Boolean> e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.enableGiftLiveData;
    }

    @NotNull
    public final LiveData<c55.d> f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.enableQuickGift;
    }

    @Nullable
    public final ok4.a g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ok4.a) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this._freeGiftConfig.getValue();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ArrayList) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(FreeGiftSendResultEvent.class);
        arrayList.add(PurchasePackageGiftEvent.class);
        arrayList.add(TimiGiftEvent.class);
        return arrayList;
    }

    @NotNull
    public final LiveData<Long> h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.freeGiftRedDotNumLiveData;
    }

    @NotNull
    public final LiveData<c55.a[]> i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.giftGuideConfigLiveData;
    }

    @Nullable
    public final com.tencent.mobileqq.qqgift.data.service.d j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.mobileqq.qqgift.data.service.d) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this._quickGiftData.getValue();
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.qqgift.data.service.d> k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.quickGiftDataLiveData;
    }

    @NotNull
    public final LiveData<Boolean> l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.sendFreeGiftEndLiveData;
    }

    @NotNull
    public final LiveData<Boolean> m2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.showGiftPanelLiveData;
    }

    public final void n2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            SimpleEventBus.getInstance().registerReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        int giftId;
        int giftId2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) event);
            return;
        }
        if (event instanceof PurchasePackageGiftEvent) {
            ok4.a value = this._freeGiftConfig.getValue();
            if (value != null && (giftId2 = value.getGiftId()) == ((PurchasePackageGiftEvent) event).getGiftId()) {
                o2(giftId2);
                return;
            }
            return;
        }
        if (event instanceof TimiGiftEvent) {
            ok4.a value2 = this._freeGiftConfig.getValue();
            if (value2 != null && (giftId = value2.getGiftId()) == ((TimiGiftEvent) event).getGiftMsg().giftID) {
                o2(giftId);
                return;
            }
            return;
        }
        if (event instanceof FreeGiftSendResultEvent) {
            this._sendFreeGiftEnd.postValue(Boolean.valueOf(((FreeGiftSendResultEvent) event).isPackage()));
            ok4.a value3 = this._freeGiftConfig.getValue();
            if (value3 != null) {
                o2(value3.getGiftId());
            }
        }
    }

    public final void q2(@NotNull ok4.a data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this._freeGiftConfig.postValue(data);
        p2(data.getGiftId());
        o2(data.getGiftId());
    }

    public final void r2(@NotNull ok4.b data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) data);
        } else {
            Intrinsics.checkNotNullParameter(data, "data");
            p2(data.getGiftId());
        }
    }

    public final void s2(boolean show) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, show);
        } else {
            this._showGiftPanel.postValue(Boolean.valueOf(show));
        }
    }

    public final void t2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }
}
