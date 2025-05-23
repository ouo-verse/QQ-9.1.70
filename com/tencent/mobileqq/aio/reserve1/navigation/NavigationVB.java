package com.tencent.mobileqq.aio.reserve1.navigation;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.reserve1.navigation.NavUIState;
import com.tencent.mobileqq.aio.reserve1.navigation.view.AioNavAnimView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIONavigationApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ;2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001<B\u000f\u0012\u0006\u00108\u001a\u00020\u001a\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u001c\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\"R6\u0010.\u001a\"\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020*\u0018\u00010)j\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020*\u0018\u0001`+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/navigation/NavigationVB;", "Lcom/tencent/qqnt/aio/lazy/lazyInit/a;", "Lcom/tencent/mobileqq/aio/reserve1/navigation/d;", "Lcom/tencent/mobileqq/aio/reserve1/navigation/NavUIState;", "", "topMargin", "", "p1", "Lcom/tencent/mobileqq/aio/reserve1/navigation/NavUIState$NavigationState;", "state", "o1", "Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", "type", "", "k1", "Lcom/tencent/mobileqq/aio/reserve1/navigation/NavUIState$UpdateLoading;", ICustomDataEditor.NUMBER_PARAM_1, "", "unreadCount", "", "l1", "i1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/mvi/base/route/MsgIntent;", "initIntent", "Lcom/tencent/qqnt/aio/lazy/lazyInit/b;", "b1", "m1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "e", "Z", "isResChecked", "f", "J", "lastClickTime", h.F, "isShowAfterResLoaded", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "i", "Ljava/util/HashMap;", "currentReportParams", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", "mCurrentType", "Lcom/tencent/mobileqq/aio/reserve1/navigation/view/AioNavAnimView;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "j1", "()Lcom/tencent/mobileqq/aio/reserve1/navigation/view/AioNavAnimView;", "navBar", "initMsgIntent", "<init>", "(Lcom/tencent/mvi/base/route/MsgIntent;)V", "D", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class NavigationVB extends com.tencent.qqnt.aio.lazy.lazyInit.a<d, NavUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy navBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isResChecked;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isShowAfterResLoaded;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private HashMap<String, Object> currentReportParams;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AIONavType mCurrentType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0004\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/navigation/NavigationVB$a;", "", "", "ANNOUNCE", "I", "AT_ALL", "AT_ME", "GIFT_AT_ME", "KEYWORD_NOTIFY", "MY_RED_ENVELOPE", "NEW_FILE", "NEW_HOMEWORK", "NEW_MSG", "NORMAL_RED_ENVELOPE", "SPECIAL_CALL_TYPE", "", "TAG", "Ljava/lang/String;", "TEAM_UP", "UNKNOWN", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve1.navigation.NavigationVB$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes11.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f193307a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64754);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AIONavType.values().length];
            try {
                iArr[AIONavType.AT_ME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AIONavType.ANONYMOUS_AT_ME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AIONavType.REPLY_AT_ME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AIONavType.CONFESS_AT_ME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AIONavType.AT_ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AIONavType.SPECIAL_NOTIFY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AIONavType.UNREAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[AIONavType.NEW_FILE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[AIONavType.ANNOUNCE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[AIONavType.ANNOUNCE_NEED_CONFIRM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[AIONavType.NORMAL_RED_ENVELOPE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[AIONavType.MY_RED_ENVELOPE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[AIONavType.KEYWORD_NOTIFY.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[AIONavType.GIFT_AT_ME.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[AIONavType.HOMEWORK.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[AIONavType.TEAM_UP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            f193307a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/reserve1/navigation/NavigationVB$c", "Lcom/tencent/qqnt/aio/adapter/api/IAIONavigationApi$b;", "Lcom/tencent/qqnt/aio/adapter/api/IAIONavigationApi$a;", "cache", "", "a", "onFailed", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements IAIONavigationApi.b {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NavigationVB.this);
            }
        }

        @Override // com.tencent.qqnt.aio.adapter.api.IAIONavigationApi.b
        public void a(@NotNull IAIONavigationApi.a cache) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) cache);
                return;
            }
            Intrinsics.checkNotNullParameter(cache, "cache");
            QLog.d("NavigationVB", 1, "loadNavRes success");
            NavigationVB.this.j1().S(cache.b(), cache.a(), cache.d(), cache.c());
            if (NavigationVB.this.isShowAfterResLoaded) {
                NavigationVB.this.j1().K();
                NavigationVB.this.isShowAfterResLoaded = false;
            }
        }

        @Override // com.tencent.qqnt.aio.adapter.api.IAIONavigationApi.b
        public void onFailed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.d("NavigationVB", 1, "loadNavRes fail");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64763);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavigationVB(@NotNull MsgIntent initMsgIntent) {
        super(initMsgIntent);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) initMsgIntent);
            return;
        }
        this.mCurrentType = AIONavType.UNKNOWN;
        lazy = LazyKt__LazyJVMKt.lazy(new NavigationVB$navBar$2(this));
        this.navBar = lazy;
    }

    private final void i1() {
        if (this.isResChecked) {
            return;
        }
        this.isResChecked = true;
        if (j1().E()) {
            return;
        }
        ((IAIONavigationApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIONavigationApi.class)).loadNavRes(getMContext(), new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AioNavAnimView j1() {
        return (AioNavAnimView) this.navBar.getValue();
    }

    private final int k1(AIONavType type) {
        switch (b.f193307a[type.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 1;
            case 7:
                return 5;
            case 8:
                return 6;
            case 9:
            case 10:
                return 7;
            case 11:
                return 8;
            case 12:
                return 9;
            case 13:
                return 10;
            case 14:
                return 11;
            case 15:
                return 12;
            case 16:
                return 13;
            default:
                return 4;
        }
    }

    private final String l1(AIONavType type, long unreadCount) {
        if (type == AIONavType.UNREAD) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getMContext().getResources().getString(R.string.f171427ex2);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.resources.getSt\u2026tring.qb_unread_msg_tips)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(unreadCount)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        return com.tencent.mobileqq.aio.reserve1.navigation.c.b(getMContext(), type);
    }

    private final void n1(NavUIState.UpdateLoading state) {
        j1().q(!state.a());
    }

    private final void o1(NavUIState.NavigationState state) {
        int i3;
        HashMap<String, Object> hashMap;
        if (state.a() == null) {
            if (j1().getVisibility() == 0 && (hashMap = this.currentReportParams) != null) {
                com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_small_ears", hashMap);
            }
            j1().setVisibility(8);
            this.currentReportParams = null;
            return;
        }
        i1();
        com.tencent.mobileqq.aio.reserve1.navigation.b a16 = state.a();
        Intrinsics.checkNotNull(a16);
        AIONavType b16 = a16.b();
        String l16 = l1(b16, state.b());
        AIONavCorrelation a17 = com.tencent.mobileqq.aio.reserve1.navigation.c.a(b16);
        if (state.a() != null) {
            HashMap<String, Object> hashMap2 = new HashMap<>();
            this.currentReportParams = hashMap2;
            Intrinsics.checkNotNull(hashMap2);
            hashMap2.put("microeared_type", Integer.valueOf(k1(b16)));
            HashMap<String, Object> hashMap3 = this.currentReportParams;
            Intrinsics.checkNotNull(hashMap3);
            if (a17 == AIONavCorrelation.STRONG) {
                i3 = 3;
            } else {
                i3 = 1;
            }
            hashMap3.put("smallear_pattern", Integer.valueOf(i3));
            HashMap<String, Object> hashMap4 = this.currentReportParams;
            Intrinsics.checkNotNull(hashMap4);
            com.tencent.mobileqq.aio.utils.b.q("em_bas_aio_small_ears", hashMap4);
        }
        if (j1().H()) {
            if (this.mCurrentType == b16 && b16 == AIONavType.UNREAD) {
                j1().I(l16);
            } else {
                j1().M(a17, l16, null);
            }
        } else {
            j1().Y(a17, l16, null);
            if (j1().E()) {
                j1().K();
            } else {
                this.isShowAfterResLoaded = true;
            }
        }
        this.mCurrentType = b16;
    }

    private final void p1(final float topMargin) {
        com.tencent.qqnt.aio.util.d.c(new Function0<Unit>(topMargin) { // from class: com.tencent.mobileqq.aio.reserve1.navigation.NavigationVB$updateTranslationY$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ float $topMargin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$topMargin = topMargin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, NavigationVB.this, Float.valueOf(topMargin));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    NavigationVB.this.j1().J(this.$topMargin);
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.a
    @NotNull
    public com.tencent.qqnt.aio.lazy.lazyInit.b<d, NavUIState> b1(@NotNull MsgIntent initIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.aio.lazy.lazyInit.b) iPatchRedirector.redirect((short) 3, (Object) this, (Object) initIntent);
        }
        Intrinsics.checkNotNullParameter(initIntent, "initIntent");
        return new NavigationVM(initIntent);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull NavUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof NavUIState.NavigationState) {
            o1((NavUIState.NavigationState) state);
        } else if (state instanceof NavUIState.UpdateLoading) {
            n1((NavUIState.UpdateLoading) state);
        } else if (state instanceof NavUIState.UpdateTranslationY) {
            p1(((NavUIState.UpdateTranslationY) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return j1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDestroy();
        j1().r();
        this.isResChecked = false;
        HashMap<String, Object> hashMap = this.currentReportParams;
        if (hashMap != null) {
            Intrinsics.checkNotNull(hashMap);
            com.tencent.mobileqq.aio.utils.b.t("em_bas_aio_small_ears", hashMap);
            this.currentReportParams = null;
        }
    }
}
