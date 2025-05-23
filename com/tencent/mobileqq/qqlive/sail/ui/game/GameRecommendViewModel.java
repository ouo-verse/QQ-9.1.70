package com.tencent.mobileqq.qqlive.sail.ui.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.distribute.api.IQQGameDistributeApi;
import com.tencent.gamecenter.wadl.distribute.data.ButtonDataBuilder;
import com.tencent.gamecenter.wadl.distribute.data.ButtonUiBuilder;
import com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener;
import com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher;
import com.tencent.gamecenter.wadl.distribute.provider.ITextColorFetcher;
import com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter;
import com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.room.gamedownloader.card.CardMode;
import com.tencent.mobileqq.qqlive.room.gamedownloader.sso.QQLiveGetTaskInfoRequest;
import com.tencent.mobileqq.qqlive.room.gamedownloader.sso.TriggerPromoteRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cr4.j;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 C2\u00020\u0001:\u0001kB\u0007\u00a2\u0006\u0004\bi\u0010jJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nJ\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004J\"\u0010\u001a\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001dJ\u0006\u0010!\u001a\u00020\u001dJ6\u0010)\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u001dJ\u000e\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*J\u0006\u0010-\u001a\u00020\u001dJ\u001a\u00100\u001a\u00020\u00062\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060.R\u001c\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R*\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010A\u001a\u00020\u00102\u0006\u0010<\u001a\u00020\u00108\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R$\u0010\u000b\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER$\u0010\u0012\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bF\u0010C\u001a\u0004\bG\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR$\u0010P\u001a\u00020K2\u0006\u0010<\u001a\u00020K8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0017\u0010V\u001a\u00020Q8\u0006\u00a2\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bT\u0010UR\u0017\u0010[\u001a\u00020W8\u0006\u00a2\u0006\f\n\u0004\b>\u0010X\u001a\u0004\bY\u0010ZR\u0011\u0010]\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b\\\u0010@R\u0011\u0010_\u001a\u00020\u00108F\u00a2\u0006\u0006\u001a\u0004\b^\u0010@R\u0011\u0010b\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b`\u0010aR\u0011\u0010d\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\bc\u0010aR\u0011\u0010f\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\be\u0010aR\u0011\u0010h\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\bg\u0010a\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "Landroid/content/Context;", "context", "", WadlProxyConsts.KEY_JUMP_URL, "", ICustomDataEditor.NUMBER_PARAM_2, "directUrl", "m2", "", "roomId", "r2", "Lcr4/j;", "info", "u2", "", "X1", "anchorUid", "j2", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "url", "Lcom/tencent/biz/ui/TouchWebView;", "t2", "webView", "k2", "o2", "p2", "", "g2", "f2", SemanticAttributes.DbSystemValues.H2, "e2", "Lcr4/b;", "gameInfo", "waitString", "downloadString", "pauseString", "autoClickBtn", "Lcom/tencent/gamecenter/wadl/distribute/widget/IDistributeButton;", "P1", "Lwq4/a;", "taskMsg", "q2", "i2", "Lkotlin/Function1;", "callback", ICustomDataEditor.STRING_PARAM_2, "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_gameInfo", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "b2", "()Landroidx/lifecycle/LiveData;", "setGameInfo", "(Landroidx/lifecycle/LiveData;)V", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "I", "c2", "()I", "reportState", "D", "J", "getRoomId", "()J", "E", "getAnchorUid", UserInfo.SEX_FEMALE, "Lcr4/j;", "taskInfo", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/card/CardMode;", "G", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/card/CardMode;", "T1", "()Lcom/tencent/mobileqq/qqlive/room/gamedownloader/card/CardMode;", "cardMode", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/a;", "H", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/a;", "W1", "()Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/a;", "customDistributeListener", "Lcom/tencent/gamecenter/wadl/distribute/listener/IButtonEventListener;", "Lcom/tencent/gamecenter/wadl/distribute/listener/IButtonEventListener;", "Z1", "()Lcom/tencent/gamecenter/wadl/distribute/listener/IButtonEventListener;", "gameCenterEventListener", "U1", "cardOpenType", "R1", "barOpenType", "S1", "()Ljava/lang/String;", "cardJumpUrl", "Q1", "barJumpUrl", "d2", MiniAppGetGameTaskTicketServlet.KEY_TASKID, ICustomDataEditor.STRING_ARRAY_PARAM_2, VirtualAppProxy.KEY_GAME_ID, "<init>", "()V", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GameRecommendViewModel extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int reportState;

    /* renamed from: D, reason: from kotlin metadata */
    private long roomId;

    /* renamed from: E, reason: from kotlin metadata */
    private long anchorUid;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private j taskInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private CardMode cardMode;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.room.gamedownloader.widget.a customDistributeListener;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final IButtonEventListener gameCenterEventListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<cr4.b> _gameInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LiveData<cr4.b> gameInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel$a;", "", "", "SCALE_HEIGHT_FACTOR", "D", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.game.GameRecommendViewModel$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel$b", "Lcom/tencent/gamecenter/wadl/distribute/provider/TextContentFetcherAdapter;", "", "fetchWaitSubscribeContent", "fetchCanDownloadContent", "fetchPausedContent", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends TextContentFetcherAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f272712a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f272713b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f272714c;

        b(String str, String str2, String str3) {
            this.f272712a = str;
            this.f272713b = str2;
            this.f272714c = str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3);
            }
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
        @NotNull
        public String fetchCanDownloadContent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.f272713b;
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
        @NotNull
        public String fetchPausedContent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f272714c;
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
        @NotNull
        public String fetchWaitSubscribeContent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f272712a;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel$c", "Lcom/tencent/gamecenter/wadl/distribute/provider/ITextColorFetcher;", "", "fetchEnableTextColor", "fetchDisableTextColor", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements ITextColorFetcher {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextColorFetcher
        public int fetchDisableTextColor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return -1;
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextColorFetcher
        public int fetchEnableTextColor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return -1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel$d", "Lcom/tencent/gamecenter/wadl/distribute/provider/IBgAndFgColorFetcher;", "", "fetchEnableBgColor", "fetchDisableBgColor", "fetchProgressFgColor", "fetchProgressBgColor", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements IBgAndFgColorFetcher {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher
        public int fetchDisableBgColor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return Color.parseColor("#C2C2C2");
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher
        public int fetchEnableBgColor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return Color.parseColor("#0099FF");
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher
        public int fetchProgressBgColor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return Color.parseColor("#A30099FF");
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher
        public int fetchProgressFgColor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return Color.parseColor("#0099FF");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel$e", "Lcom/tencent/mobileqq/qqlive/room/gamedownloader/widget/a;", "", "onDownloadStart", "onDownloadFinish", "", "fromQQLive", "c", "b", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class e extends com.tencent.mobileqq.qqlive.room.gamedownloader.widget.a {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameRecommendViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.a, com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                a.j(GameRecommendViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.a, com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
        public void c(boolean fromQQLive) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, fromQQLive);
            } else if (fromQQLive) {
                a.i(GameRecommendViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.a, com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
        public void onDownloadFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                a.h(GameRecommendViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.room.gamedownloader.widget.a, com.tencent.mobileqq.qqlive.room.gamedownloader.widget.QQLiveCustomDistributeController.b
        public void onDownloadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                a.k(GameRecommendViewModel.this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/game/GameRecommendViewModel$f", "Lcom/tencent/gamecenter/wadl/distribute/listener/IButtonEventListener;", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "", "appId", "", "followStatus", "subscribeStatus", "onFollowOrSubscribeStatusChange", "", "progress", "taskStatus", "onDownloadTaskStatusChange", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class f implements IButtonEventListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameRecommendViewModel.this);
            }
        }

        @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
        public void onClick(@NotNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            a.g(GameRecommendViewModel.this, view);
            if (GameRecommendViewModel.this.c2() == 4) {
                a.j(GameRecommendViewModel.this);
            }
        }

        @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
        public void onDownloadTaskStatusChange(@NotNull String appId, float progress, int taskStatus) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, appId, Float.valueOf(progress), Integer.valueOf(taskStatus));
                return;
            }
            Intrinsics.checkNotNullParameter(appId, "appId");
            if (taskStatus == 0) {
                GameRecommendViewModel.this.reportState = 0;
                return;
            }
            if (taskStatus != 2) {
                if (taskStatus == 9) {
                    GameRecommendViewModel.this.reportState = 4;
                    a.i(GameRecommendViewModel.this);
                    return;
                }
                if (taskStatus == 4) {
                    GameRecommendViewModel.this.reportState = 1;
                    return;
                }
                if (taskStatus == 5) {
                    GameRecommendViewModel.this.reportState = 2;
                    return;
                } else if (taskStatus != 6) {
                    GameRecommendViewModel.this.reportState = 0;
                    return;
                } else {
                    GameRecommendViewModel.this.reportState = 3;
                    a.h(GameRecommendViewModel.this);
                    return;
                }
            }
            a.k(GameRecommendViewModel.this);
        }

        @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
        public void onFollowOrSubscribeStatusChange(@NotNull String appId, int followStatus, int subscribeStatus) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, appId, Integer.valueOf(followStatus), Integer.valueOf(subscribeStatus));
                return;
            }
            Intrinsics.checkNotNullParameter(appId, "appId");
            if (subscribeStatus == 0) {
                GameRecommendViewModel.this.reportState = 0;
            } else if (subscribeStatus == 2) {
                GameRecommendViewModel.this.reportState = 1;
                a.l(GameRecommendViewModel.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51933);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GameRecommendViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<cr4.b> mutableLiveData = new MutableLiveData<>();
        this._gameInfo = mutableLiveData;
        this.gameInfo = mutableLiveData;
        this.cardMode = CardMode.SUBSCRIBE_FROM_GAME_CENTER;
        this.customDistributeListener = new e();
        this.gameCenterEventListener = new f();
    }

    private final int X1() {
        if (com.tencent.common.config.pad.b.b(BaseApplication.getContext()) == DeviceType.TABLET) {
            return 3;
        }
        return 1;
    }

    private final void m2(Context context, String directUrl) {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(directUrl);
        if (isBlank) {
            AegisLogger.INSTANCE.i("Audience|GameRecommendViewModel", "openFullScreenScheme", "directUrl schema is null");
            return;
        }
        AegisLogger.INSTANCE.i("Audience|GameRecommendViewModel", "openFullScreenWebView", "directUrl=" + directUrl);
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setPackage(MobileQQ.PACKAGE_NAME);
        intent.setData(Uri.parse(directUrl));
        if (context != null) {
            context.startActivity(intent);
        }
    }

    private final void n2(Context context, String jumpUrl) {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(jumpUrl);
        if (isBlank) {
            return;
        }
        AegisLogger.INSTANCE.i("Audience|GameRecommendViewModel", "openFullScreenWebView", "jumpUrl=" + jumpUrl);
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", jumpUrl);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    private final void r2(long roomId) {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetTaskInfoRequest(roomId, X1()), new Function1<QQLiveResponse<cr4.e>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.game.GameRecommendViewModel$requestGameTask$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GameRecommendViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<cr4.e> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<cr4.e> response) {
                j jVar;
                j jVar2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) response);
                    return;
                }
                Intrinsics.checkNotNullParameter(response, "response");
                cr4.e rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    j jVar3 = rsp.f391731a;
                    if (jVar3 != null) {
                        GameRecommendViewModel.this.u2(jVar3);
                    }
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    jVar = GameRecommendViewModel.this.taskInfo;
                    String str = jVar != null ? jVar.f391770j : null;
                    jVar2 = GameRecommendViewModel.this.taskInfo;
                    Integer valueOf = jVar2 != null ? Integer.valueOf(jVar2.f391761a) : null;
                    companion.i("Audience|GameRecommendViewModel", "requestGameTask", "success, taskId=" + str + ", taskType=" + valueOf + ", cardMode=" + GameRecommendViewModel.this.T1());
                    return;
                }
                AegisLogger.INSTANCE.w("Audience|GameRecommendViewModel", "requestGameTask", "failed, response=" + response);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u2(j info) {
        cr4.b bVar;
        this.taskInfo = info;
        if (info != null) {
            this.cardMode = CardMode.INSTANCE.a(info.f391761a, info.f391762b, info.f391773m);
        }
        MutableLiveData<cr4.b> mutableLiveData = this._gameInfo;
        if (info != null) {
            bVar = info.f391769i;
        } else {
            bVar = null;
        }
        mutableLiveData.postValue(bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final IDistributeButton P1(@NotNull Context context, @NotNull cr4.b gameInfo, @NotNull String waitString, @NotNull String downloadString, @NotNull String pauseString, boolean autoClickBtn) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (IDistributeButton) iPatchRedirector.redirect((short) 24, this, context, gameInfo, waitString, downloadString, pauseString, Boolean.valueOf(autoClickBtn));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gameInfo, "gameInfo");
        Intrinsics.checkNotNullParameter(waitString, "waitString");
        Intrinsics.checkNotNullParameter(downloadString, "downloadString");
        Intrinsics.checkNotNullParameter(pauseString, "pauseString");
        IDistributeButton createButton = ((IQQGameDistributeApi) QRoute.api(IQQGameDistributeApi.class)).createButton(context);
        ButtonDataBuilder versionCode = new ButtonDataBuilder().setAppId(gameInfo.f391712c).setVersionCode(0);
        String str = gameInfo.f391724o;
        Intrinsics.checkNotNullExpressionValue(str, "gameInfo.apkChannel");
        createButton.setDataBuilder(versionCode.setApkChannel(str).setApkUrl(gameInfo.f391722m).setAppName(gameInfo.f391711b).setIconUrl(gameInfo.f391713d).setPkgName(gameInfo.f391725p).setBusinessChannel(4).setSubscribeSource("1").setReportData("{\"ext_module\":\"qqzhibo\",\"ext_sub_module\":\"qqzhibo\"}"));
        createButton.setUiBuilder(new ButtonUiBuilder().setAutoClickBtn(autoClickBtn).setUiStyle(0).setBgCorner(ViewUtils.dpToPx(2.0f)).setTextSize(ViewUtils.dpToPx(14.0f)).setCustomTextContentFetcher(new b(waitString, downloadString, pauseString)).setCustomTextColorFetcher(new c()).setCustomBgAndFgColorFetcher(new d()));
        createButton.update();
        if (createButton instanceof View) {
            view = (View) createButton;
        } else {
            view = null;
        }
        if (view != null) {
            a.a(this, view);
        }
        return createButton;
    }

    @NotNull
    public final String Q1() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        j jVar = this.taskInfo;
        if (jVar != null) {
            str = jVar.f391774n;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final int R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        j jVar = this.taskInfo;
        if (jVar != null) {
            return jVar.f391775o;
        }
        return 1;
    }

    @NotNull
    public final String S1() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        j jVar = this.taskInfo;
        if (jVar != null) {
            str = jVar.f391765e;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final CardMode T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (CardMode) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.cardMode;
    }

    public final int U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        j jVar = this.taskInfo;
        if (jVar != null) {
            return jVar.f391766f;
        }
        return 1;
    }

    @NotNull
    public final com.tencent.mobileqq.qqlive.room.gamedownloader.widget.a W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (com.tencent.mobileqq.qqlive.room.gamedownloader.widget.a) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.customDistributeListener;
    }

    @NotNull
    public final IButtonEventListener Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (IButtonEventListener) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.gameCenterEventListener;
    }

    @NotNull
    public final String a2() {
        String str;
        cr4.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        j jVar = this.taskInfo;
        if (jVar != null && (bVar = jVar.f391769i) != null) {
            str = bVar.f391710a;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final LiveData<cr4.b> b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.gameInfo;
    }

    public final int c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.reportState;
    }

    @NotNull
    public final String d2() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        j jVar = this.taskInfo;
        if (jVar != null) {
            str = jVar.f391770j;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final boolean e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        CardMode cardMode = this.cardMode;
        if (cardMode != CardMode.DOWNLOAD_FROM_QQ_DOWNLOAD_PROXY && cardMode != CardMode.DOWNLOAD_FROM_GAME_CENTER && cardMode != CardMode.DOWNLOAD_FROM_CUSTOM_H5) {
            return false;
        }
        return true;
    }

    public final boolean f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        CardMode cardMode = this.cardMode;
        if (cardMode != CardMode.SUBSCRIBE_FROM_GAME_CENTER && cardMode != CardMode.DOWNLOAD_FROM_GAME_CENTER) {
            return false;
        }
        return true;
    }

    public final boolean g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        CardMode cardMode = this.cardMode;
        if (cardMode != CardMode.SUBSCRIBE_FROM_CUSTOM_H5 && cardMode != CardMode.DOWNLOAD_FROM_CUSTOM_H5) {
            return false;
        }
        return true;
    }

    public final long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.roomId;
    }

    public final boolean h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        if (this.cardMode == CardMode.DOWNLOAD_FROM_QQ_DOWNLOAD_PROXY) {
            return true;
        }
        return false;
    }

    public final boolean i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        j jVar = this.taskInfo;
        if (jVar == null || jVar.f391779s != 1) {
            return false;
        }
        return true;
    }

    public final void j2(long roomId, long anchorUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Long.valueOf(roomId), Long.valueOf(anchorUid));
            return;
        }
        this.roomId = roomId;
        this.anchorUid = anchorUid;
        r2(roomId);
    }

    public final void k2(@Nullable Activity activity, @Nullable TouchWebView webView, @NotNull String url) {
        boolean startsWith;
        boolean startsWith2;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, activity, webView, url);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (activity == null) {
            AegisLogger.INSTANCE.w("Audience|GameRecommendViewModel", "openDetailPage", "invalid params");
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Audience|GameRecommendViewModel", "openDetailPage", "url=" + url);
        startsWith = StringsKt__StringsJVMKt.startsWith(url, "http", true);
        if (!startsWith) {
            startsWith2 = StringsKt__StringsJVMKt.startsWith(url, SchemaUtils.SCHEMA_MQQAPI, true);
            if (startsWith2) {
                m2(activity, url);
                return;
            }
            companion.w("Audience|GameRecommendViewModel", "openDetailPage", "invalid url, " + url);
            return;
        }
        Unit unit = null;
        ViewGroup viewGroup = null;
        if (webView != null) {
            ViewParent parent = webView.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            }
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            com.tencent.timi.game.liveroom.impl.room.livewebdialog.e.m(activity, (int) (ViewUtils.getScreenHeight() * 0.5d), true, null, webView, new com.tencent.timi.game.liveroom.impl.room.livewebdialog.a() { // from class: com.tencent.mobileqq.qqlive.sail.ui.game.b
                @Override // com.tencent.timi.game.liveroom.impl.room.livewebdialog.a
                public final void onDismiss() {
                    GameRecommendViewModel.l2();
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(url);
            if (isBlank) {
                companion.w("Audience|GameRecommendViewModel", "openDetailPage", "invalid url");
            }
            n2(activity, url);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void o2(@NotNull Context context) {
        String str;
        boolean z16;
        boolean isBlank;
        cr4.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        j jVar = this.taskInfo;
        if (jVar != null && (bVar = jVar.f391769i) != null) {
            str = bVar.f391715f;
        } else {
            str = null;
        }
        AegisLogger.INSTANCE.i("Audience|GameRecommendViewModel", "openPermissionPage", "url=" + str);
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return;
                }
                n2(context, str);
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p2(@NotNull Context context) {
        String str;
        boolean z16;
        boolean isBlank;
        cr4.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        j jVar = this.taskInfo;
        if (jVar != null && (bVar = jVar.f391769i) != null) {
            str = bVar.f391716g;
        } else {
            str = null;
        }
        AegisLogger.INSTANCE.i("Audience|GameRecommendViewModel", "openPolicyPage", "url=" + str);
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return;
                }
                n2(context, str);
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final void q2(@NotNull wq4.a taskMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) taskMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(taskMsg, "taskMsg");
        int i3 = taskMsg.f446089b;
        if (i3 != 1) {
            if (i3 == 2) {
                u2(null);
            }
        } else {
            j jVar = taskMsg.f446088a;
            if (jVar != null) {
                u2(jVar);
            } else {
                AegisLogger.INSTANCE.e("Audience|GameRecommendViewModel", "receivePromoteTaskMsg", "info is null");
            }
        }
    }

    public final void s2(@NotNull final Function1<? super Boolean, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        j jVar = this.taskInfo;
        if (jVar == null) {
            callback.invoke(Boolean.TRUE);
            return;
        }
        String str = jVar.f391770j;
        Intrinsics.checkNotNullExpressionValue(str, "localTaskInfo.taskId");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new TriggerPromoteRequest(str, this.roomId, String.valueOf(this.anchorUid)), new Function1<QQLiveResponse<wq4.c>, Unit>(callback) { // from class: com.tencent.mobileqq.qqlive.sail.ui.game.GameRecommendViewModel$triggerPromoteTask$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Function1<Boolean, Unit> $callback;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.$callback = callback;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<wq4.c> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<wq4.c> response) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                    return;
                }
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccess() && response.getRsp() != null) {
                    this.$callback.invoke(Boolean.TRUE);
                    return;
                }
                this.$callback.invoke(Boolean.FALSE);
                AegisLogger.INSTANCE.e("Audience|GameRecommendViewModel", "triggerPromoteTaskIfNeed", "rsp is invalid. response=" + response);
            }
        });
    }

    @Nullable
    public final TouchWebView t2(@NotNull Activity activity, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (TouchWebView) iPatchRedirector.redirect((short) 16, (Object) this, (Object) activity, (Object) url);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(url, Arrays.copyOf(new Object[]{Long.valueOf(this.roomId), Long.valueOf(this.anchorUid), a2(), "0.5", d2()}, 5));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return com.tencent.timi.game.liveroom.impl.room.livewebdialog.e.f(activity, format, true);
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Audience|GameRecommendViewModel", "tryCreateWebView", "error, ", e16);
            return com.tencent.timi.game.liveroom.impl.room.livewebdialog.e.f(activity, url, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2() {
    }
}
