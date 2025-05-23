package com.tencent.guildlive.aio.input;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.input.realinput.t;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.guild.aio.util.GuildDraftUtil;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guildlive.aio.input.GuildLiveAioInputUIState;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tmassistantbase.util.GlobalUtil;
import fo0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00da\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 s2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001tB\u0013\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010T\u00a2\u0006\u0004\bq\u0010rJ&\u0010\t\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0007\u0012\u0006\b\u0001\u0012\u00020\b0\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0016\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00150\u0006H\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0013H\u0002J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020 H\u0002J\u0010\u0010$\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\"H\u0002J\u0016\u0010'\u001a\u00020\u000f2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\"0%H\u0002J\u0018\u0010+\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u001cH\u0002J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u001cH\u0002J\u0010\u0010/\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020.H\u0002J\u0018\u00102\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020(2\u0006\u00101\u001a\u000200H\u0002J\u0010\u00105\u001a\u00020\u000f2\u0006\u00104\u001a\u000203H\u0002J\u0010\u00106\u001a\u00020\u000f2\u0006\u00104\u001a\u000203H\u0002J\u001e\u0010:\u001a\u00020\u000f2\f\u00109\u001a\b\u0012\u0004\u0012\u000208072\u0006\u00104\u001a\u000203H\u0002J\u0010\u0010<\u001a\u00020\u000f2\u0006\u0010;\u001a\u00020\u001cH\u0002J\u0010\u0010>\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020=H\u0002J\u0010\u0010?\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020.H\u0002J\u0010\u0010B\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020@H\u0002J\b\u0010C\u001a\u00020\u000fH\u0002J\u0012\u0010F\u001a\u00020\u000f2\b\b\u0002\u0010E\u001a\u00020DH\u0002J\b\u0010G\u001a\u00020\u000fH\u0002J\u0010\u0010I\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\"H\u0002J\u0010\u0010K\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020@H\u0002J\u0010\u0010M\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020LH\u0002J\u0010\u0010O\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020NH\u0002J\b\u0010P\u001a\u00020\u001cH\u0002J\b\u0010Q\u001a\u00020\u000fH\u0002J\b\u0010R\u001a\u00020\u000fH\u0002J\b\u0010S\u001a\u00020\u000fH\u0002R\u0016\u0010W\u001a\u0004\u0018\u00010T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Z\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010`R\u0016\u0010f\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010`R/\u0010p\u001a\u001d\u0012\u0013\u0012\u00110j\u00a2\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020\u000f0i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010o\u00a8\u0006u"}, d2 = {"Lcom/tencent/guildlive/aio/input/GuildLiveAioInputViewBinder;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/e;", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState;", "Landroid/view/View;", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", "p1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "", "bindViewAndData", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "Landroid/os/Bundle;", "generateVBState", "Ljava/lang/Class;", "getObserverStates", "state", "B1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "H1", Constants.APK_CERTIFICATE, "", GlobalUtil.DEF_STRING, "Y1", "r1", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$LiveInputToast;", "V1", "", "emojiCode", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/aio/msgservice/j;", "resp", "A1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "isInsertAt", "v1", "show", "X1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "L1", "Lz12/e;", "binding", "m1", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "F1", "o1", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "P1", "enable", "Z1", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$ReeditMsg;", "z1", "y1", "", "permissions", "N1", "E1", "", "delay", "S1", "O1", "msg", "C1", "videoScreenState", Constants.BASE_IN_PLUGIN_ID, "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildInputHint;", "Q1", "Lcom/tencent/guildlive/aio/input/GuildLiveAioInputUIState$GuildInputPanelChange;", "u1", "M1", "W1", ICustomDataEditor.NUMBER_PARAM_1, "q1", "Lts0/a;", "d", "Lts0/a;", "liveAIOListener", "e", "Lz12/e;", "mBinding", "Lgo0/c;", "f", "Lgo0/c;", "mGuildAtCluster", tl.h.F, "Z", "isPanelOrKeyBoardShow", "i", "isKeyBoardVisibleInSmallWindow", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "mInputHintText", BdhLogUtil.LogTag.Tag_Conn, "mIsVideoFullScreen", "Lkotlin/Function1;", "Landroid/widget/EditText;", "Lkotlin/ParameterName;", "name", "editText", "D", "Lkotlin/jvm/functions/Function1;", "onSendMsg", "<init>", "(Lts0/a;)V", "E", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveAioInputViewBinder extends com.tencent.aio.base.mvvm.a<fo0.e, GuildLiveAioInputUIState> {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsVideoFullScreen;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final ts0.a liveAIOListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private z12.e mBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isPanelOrKeyBoardShow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isKeyBoardVisibleInSmallWindow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private go0.c mGuildAtCluster = new go0.c();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mInputHintText = "";

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function1<EditText, Unit> onSendMsg = new Function1<EditText, Unit>() { // from class: com.tencent.guildlive.aio.input.GuildLiveAioInputViewBinder$onSendMsg$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EditText editText) {
            invoke2(editText);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull EditText it) {
            z12.e eVar;
            z12.e eVar2;
            z12.e eVar3;
            Intrinsics.checkNotNullParameter(it, "it");
            List<e.InputSendTextIntent> a16 = com.tencent.guild.aio.util.e.f112380a.a(it);
            GuildLiveAioInputViewBinder guildLiveAioInputViewBinder = GuildLiveAioInputViewBinder.this;
            eVar = guildLiveAioInputViewBinder.mBinding;
            e.ReplyData replyData = null;
            z12.e eVar4 = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar = null;
            }
            LinearLayout linearLayout = eVar.f451742b;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
            Long l3 = iq0.a.l(linearLayout);
            if (l3 != null) {
                GuildLiveAioInputViewBinder guildLiveAioInputViewBinder2 = GuildLiveAioInputViewBinder.this;
                long longValue = l3.longValue();
                eVar2 = guildLiveAioInputViewBinder2.mBinding;
                if (eVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    eVar2 = null;
                }
                String obj = eVar2.f451757q.getText().toString();
                eVar3 = guildLiveAioInputViewBinder2.mBinding;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    eVar4 = eVar3;
                }
                replyData = new e.ReplyData(longValue, obj, eVar4.f451758r.getText().toString());
            }
            guildLiveAioInputViewBinder.sendIntent(new e.InputSendMultiTextIntent(a16, replyData));
        }
    };

    public GuildLiveAioInputViewBinder(@Nullable ts0.a aVar) {
        this.liveAIOListener = aVar;
    }

    private final void A1(com.tencent.aio.msgservice.j<String> resp) {
        int i3;
        String b16;
        if (resp.c() == 0) {
            return;
        }
        int c16 = resp.c();
        boolean z16 = false;
        if (c16 != 100308) {
            switch (c16) {
                case BusinessInfoCheckUpdateItem.UIAPPID_PUBLIC_ACCOUNT /* 104000 */:
                case BusinessInfoCheckUpdateItem.UIAPPID_PUBLIC_ACCOUNT_MESSAGE_POP /* 104001 */:
                    i3 = R.string.f158341pc;
                    break;
                case 104002:
                    i3 = R.string.f158291p8;
                    break;
                case 104003:
                    i3 = R.string.f158271p6;
                    break;
                default:
                    i3 = 0;
                    break;
            }
        } else {
            i3 = R.string.f156871ld;
        }
        if (i3 != 0) {
            b16 = getMContext().getString(i3);
            Intrinsics.checkNotNullExpressionValue(b16, "{\n            mContext.g\u2026ing(errorMsgId)\n        }");
        } else {
            String b17 = resp.b();
            if (b17 == null || b17.length() == 0) {
                z16 = true;
            }
            if (z16) {
                b16 = getMContext().getString(R.string.f139240aq);
                Intrinsics.checkNotNullExpressionValue(b16, "{\n            mContext.g\u2026nd_status_fail)\n        }");
            } else {
                b16 = resp.b();
                Intrinsics.checkNotNull(b16);
            }
        }
        if (!TextUtils.isEmpty(b16)) {
            QQToast.makeText(getMContext(), 1, b16, 1).show();
        }
    }

    private final void C1(String msg2) {
        z12.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f451746f.setText(msg2);
    }

    private final void D1(int videoScreenState) {
        boolean z16;
        if (videoScreenState != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mIsVideoFullScreen = z16;
        W1();
    }

    private final void E1() {
        Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        z12.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        inputMethodManager.hideSoftInputFromWindow(eVar.f451746f.getWindowToken(), 0);
    }

    private final void F1(AIOParam aioParam) {
        go0.c cVar = this.mGuildAtCluster;
        z12.e eVar = this.mBinding;
        z12.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar.f451746f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        z12.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        LinearLayout linearLayout = eVar3.f451745e;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.guildAioInputBar");
        z12.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar4;
        }
        Context context = eVar2.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        go0.c.i(cVar, guildAIOInputEditText, linearLayout, context, aioParam, null, null, 48, null);
        o1(aioParam);
    }

    private final void G1() {
        z12.e eVar = this.mBinding;
        z12.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        yr0.a.q(eVar.f451746f, "em_aio_input_box", null, 4, null);
        HashMap hashMap = new HashMap();
        hashMap.put("aio_message_type", 1);
        z12.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        yr0.a.p(eVar3.f451748h, "em_aio_send", hashMap);
        z12.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar4;
        }
        yr0.a.n("imp", eVar2.f451748h, hashMap);
    }

    private final void H1() {
        z12.e eVar = this.mBinding;
        z12.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar.f451746f;
        QRouteApi api = QRoute.api(IGuildEmojiApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildEmojiApi::class.java)");
        guildAIOInputEditText.setEditableFactory(IGuildEmojiApi.a.a((IGuildEmojiApi) api, 16, 0, 2, null));
        z12.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        eVar3.f451746f.setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.guildlive.aio.input.g
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                boolean I1;
                I1 = GuildLiveAioInputViewBinder.I1(GuildLiveAioInputViewBinder.this, view, i3, keyEvent);
                return I1;
            }
        });
        z12.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar4 = null;
        }
        eVar4.f451748h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.input.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLiveAioInputViewBinder.J1(GuildLiveAioInputViewBinder.this, view);
            }
        });
        z12.e eVar5 = this.mBinding;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar5 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText2 = eVar5.f451746f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText2, "mBinding.guildAioInputEdittext");
        guildAIOInputEditText2.addTextChangedListener(new b());
        z12.e eVar6 = this.mBinding;
        if (eVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar6 = null;
        }
        eVar6.f451746f.setFocusableInTouchMode(true);
        sendIntent(e.i.f400144d);
        com.tencent.guild.aio.util.g gVar = com.tencent.guild.aio.util.g.f112400a;
        z12.e eVar7 = this.mBinding;
        if (eVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar7 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText3 = eVar7.f451746f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText3, "mBinding.guildAioInputEdittext");
        gVar.c(guildAIOInputEditText3, new Function0<Unit>() { // from class: com.tencent.guildlive.aio.input.GuildLiveAioInputViewBinder$initView$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                z12.e eVar8;
                eVar8 = GuildLiveAioInputViewBinder.this.mBinding;
                if (eVar8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    eVar8 = null;
                }
                eVar8.f451748h.performClick();
            }
        });
        z12.e eVar8 = this.mBinding;
        if (eVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar8;
        }
        ViewCompat.setOnApplyWindowInsetsListener(eVar2.f451746f, new OnApplyWindowInsetsListener() { // from class: com.tencent.guildlive.aio.input.i
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat K1;
                K1 = GuildLiveAioInputViewBinder.K1(GuildLiveAioInputViewBinder.this, view, windowInsetsCompat);
                return K1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean I1(GuildLiveAioInputViewBinder this$0, View view, int i3, KeyEvent keyEvent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 67 && keyEvent.getAction() == 0) {
            z12.e eVar = this$0.mBinding;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar = null;
            }
            Editable text = eVar.f451746f.getText();
            if (text != null && text.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                this$0.X1(false);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J1(GuildLiveAioInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<EditText, Unit> function1 = this$0.onSendMsg;
        z12.e eVar = this$0.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar.f451746f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        function1.invoke(guildAIOInputEditText);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat K1(GuildLiveAioInputViewBinder this$0, View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isKeyBoardVisibleInSmallWindow = windowInsetsCompat.isVisible(WindowInsetsCompat.Type.ime());
        this$0.W1();
        return windowInsetsCompat;
    }

    private final void L1(GuildMsgItem msgItem) {
        String str = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
        String str2 = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
        String u16 = iq0.a.u(str, str2);
        com.tencent.guild.aio.util.e eVar = com.tencent.guild.aio.util.e.f112380a;
        z12.e eVar2 = this.mBinding;
        z12.e eVar3 = null;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar2 = null;
        }
        Context context = eVar2.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        z12.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar3 = eVar4;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar3.f451746f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        String str3 = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
        com.tencent.guild.aio.util.e.i(eVar, context, guildAIOInputEditText, str3, u16, 0, 16, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean M1() {
        boolean z16;
        boolean isBlank;
        if (this.isPanelOrKeyBoardShow || this.isKeyBoardVisibleInSmallWindow) {
            return true;
        }
        z12.e eVar = this.mBinding;
        z12.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        Editable text = eVar.f451746f.getText();
        if (text != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(text);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    return true;
                }
                z12.e eVar3 = this.mBinding;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    eVar2 = eVar3;
                }
                if (eVar2.f451742b.getVisibility() == 0) {
                    return true;
                }
                return false;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    private final void N1(int permissions) {
        String str;
        boolean z16;
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        FrameworkVM mUIModel = getMUIModel();
        z12.e eVar = null;
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && (g16 = aVar.g()) != null) {
            str = com.tencent.guild.aio.util.a.g(g16);
        } else {
            str = null;
        }
        if (companion.f(permissions, str) && !yr0.a.f()) {
            z16 = true;
        } else {
            z16 = false;
        }
        z12.e eVar2 = this.mBinding;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar2 = null;
        }
        yr0.a.s(eVar2.getRoot(), z16);
        if (z16) {
            z12.e eVar3 = this.mBinding;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar3 = null;
            }
            yr0.a.o("imp", eVar3.f451746f, null, 4, null);
            return;
        }
        z12.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar = eVar4;
        }
        yr0.a.s(eVar.f451742b, false);
    }

    private final void O1() {
        z12.e eVar = this.mBinding;
        z12.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f451746f.requestFocus();
        Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        z12.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar3;
        }
        inputMethodManager.showSoftInput(eVar2.f451746f, 0);
    }

    private final void P1(ArrayList<MsgElement> msgElements, AIOParam aioParam) {
        AppInterface appInterface;
        boolean z16;
        boolean isBlank;
        z12.e eVar = this.mBinding;
        IRuntimeService iRuntimeService = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar.f451746f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        int i3 = 0;
        Z1(false);
        GuildDraftUtil guildDraftUtil = GuildDraftUtil.f112365a;
        z12.e eVar2 = this.mBinding;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar2 = null;
        }
        LinearLayout linearLayout = eVar2.f451742b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
        guildDraftUtil.c(msgElements, linearLayout, guildAIOInputEditText);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        boolean z17 = true;
        if (iGPSService != null) {
            z16 = iGPSService.isGuest(com.tencent.guild.aio.util.a.g(aioParam));
        } else {
            z16 = true;
        }
        Z1(!z16);
        Editable text = guildAIOInputEditText.getText();
        if (text != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(text);
            if (!isBlank) {
                z17 = false;
            }
        }
        if (!z17) {
            Editable text2 = guildAIOInputEditText.getText();
            if (text2 != null) {
                i3 = text2.length();
            }
            guildAIOInputEditText.setSelection(i3);
            W1();
        }
    }

    private final void Q1(final GuildLiveAioInputUIState.GuildInputHint state) {
        z12.e eVar = this.mBinding;
        z12.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar.f451746f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        String string = getMContext().getResources().getString(R.string.f139210an);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.resources.getSt\u2026ing.guild_aio_input_hint)");
        z12.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        int measuredWidth = eVar3.f451746f.getMeasuredWidth();
        if (measuredWidth <= 0) {
            z12.e eVar4 = this.mBinding;
            if (eVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                eVar2 = eVar4;
            }
            eVar2.f451746f.post(new Runnable() { // from class: com.tencent.guildlive.aio.input.j
                @Override // java.lang.Runnable
                public final void run() {
                    GuildLiveAioInputViewBinder.R1(GuildLiveAioInputViewBinder.this, state);
                }
            });
        }
        this.mInputHintText = UIUtil.q(UIUtil.f112434a, guildAIOInputEditText, measuredWidth, string, state.getChannelName(), null, 16, null);
        W1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(GuildLiveAioInputViewBinder this$0, GuildLiveAioInputUIState.GuildInputHint state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        this$0.Q1(state);
    }

    private final void S1(long delay) {
        z12.e eVar = this.mBinding;
        z12.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        if (eVar.getRoot().getVisibility() == 0) {
            z12.e eVar3 = this.mBinding;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar3 = null;
            }
            if (eVar3.f451745e.getVisibility() == 0) {
                if (delay > 0) {
                    z12.e eVar4 = this.mBinding;
                    if (eVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    } else {
                        eVar2 = eVar4;
                    }
                    eVar2.f451746f.postDelayed(new Runnable() { // from class: com.tencent.guildlive.aio.input.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildLiveAioInputViewBinder.U1(GuildLiveAioInputViewBinder.this);
                        }
                    }, delay);
                    return;
                }
                O1();
            }
        }
    }

    static /* synthetic */ void T1(GuildLiveAioInputViewBinder guildLiveAioInputViewBinder, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        guildLiveAioInputViewBinder.S1(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(GuildLiveAioInputViewBinder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O1();
    }

    private final void V1(GuildLiveAioInputUIState.LiveInputToast state) {
        if (state.getMsg() instanceof Integer) {
            QQToast.makeText(getMContext(), state.getIconType(), ((Number) state.getMsg()).intValue(), 0).show();
        } else if (state.getMsg() instanceof CharSequence) {
            QQToast.makeText(getMContext(), state.getIconType(), (CharSequence) state.getMsg(), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W1() {
        boolean z16 = false;
        z12.e eVar = null;
        if (M1()) {
            z12.e eVar2 = this.mBinding;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar2 = null;
            }
            eVar2.f451755o.setVisibility(8);
            z12.e eVar3 = this.mBinding;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar3 = null;
            }
            if (eVar3.f451751k.getVisibility() != 0) {
                z12.e eVar4 = this.mBinding;
                if (eVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    eVar4 = null;
                }
                eVar4.f451751k.setVisibility(0);
                z12.e eVar5 = this.mBinding;
                if (eVar5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    eVar5 = null;
                }
                yr0.a.o("imp", eVar5.f451748h, null, 4, null);
            }
            z12.e eVar6 = this.mBinding;
            if (eVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar6 = null;
            }
            eVar6.f451749i.setBackgroundResource(0);
            z12.e eVar7 = this.mBinding;
            if (eVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar7 = null;
            }
            eVar7.f451746f.setHint(this.mInputHintText);
            z12.e eVar8 = this.mBinding;
            if (eVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar8 = null;
            }
            eVar8.f451750j.setBackgroundColor(getMContext().getResources().getColor(R.color.f157151br2));
        } else {
            z12.e eVar9 = this.mBinding;
            if (eVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar9 = null;
            }
            eVar9.f451755o.setVisibility(0);
            z12.e eVar10 = this.mBinding;
            if (eVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar10 = null;
            }
            eVar10.f451751k.setVisibility(8);
            z12.e eVar11 = this.mBinding;
            if (eVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar11 = null;
            }
            eVar11.f451746f.setHint(getMContext().getResources().getString(R.string.f147540x6));
            z12.e eVar12 = this.mBinding;
            if (eVar12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar12 = null;
            }
            eVar12.f451749i.setBackgroundResource(R.drawable.guild_live_input_bar_no_content_bg);
            z12.e eVar13 = this.mBinding;
            if (eVar13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar13 = null;
            }
            eVar13.f451750j.setBackgroundColor(getMContext().getResources().getColor(R.color.aju));
        }
        z12.e eVar14 = this.mBinding;
        if (eVar14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar = eVar14;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar.f451746f;
        if (this.isPanelOrKeyBoardShow || this.isKeyBoardVisibleInSmallWindow) {
            z16 = true;
        }
        guildAIOInputEditText.setCursorVisible(z16);
    }

    private final void X1(boolean show) {
        z12.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        yr0.a.s(eVar.f451742b, show);
        W1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y1(boolean empty) {
        z12.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        yr0.a.s(eVar.f451748h, !empty);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(boolean enable) {
        this.mGuildAtCluster.l(enable);
    }

    private final void m1(com.tencent.aio.data.msglist.a msgItem, z12.e binding) {
        List filterNotNull;
        binding.f451757q.setText(iq0.a.t(msgItem) + MsgSummary.STR_COLON);
        binding.f451758r.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        ArrayList<MsgElement> elements = ((GuildMsgItem) msgItem).getMsgRecord().elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        binding.f451758r.setText(iq0.a.p(arrayList, true, false, 4, null));
    }

    private final void n1() {
        z12.e eVar = this.mBinding;
        z12.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f451746f.setText("");
        z12.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar3;
        }
        eVar2.f451742b.setVisibility(8);
    }

    private final void o1(AIOParam aioParam) {
        int a16 = fo0.h.a(com.tencent.guild.aio.util.a.g(aioParam), com.tencent.guild.aio.util.a.b(aioParam));
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        if (((Unit) com.tencent.guild.aio.util.ex.g.b(Boolean.valueOf(!companion.f(a16, com.tencent.guild.aio.util.a.g(aioParam))), new Function0<Unit>() { // from class: com.tencent.guildlive.aio.input.GuildLiveAioInputViewBinder$configAtWatcher$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildLiveAioInputViewBinder.this.Z1(false);
            }
        })) == null) {
            Z1(!companion.r(a16));
        }
    }

    private final void q1() {
        this.mGuildAtCluster.g();
    }

    private final Bundle r1() {
        long j3;
        z12.e eVar = this.mBinding;
        z12.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        Editable editableText = eVar.f451746f.getEditableText();
        z12.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        String valueOf = String.valueOf(eVar3.f451746f.getText());
        z12.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar4 = null;
        }
        String obj = eVar4.f451757q.getText().toString();
        z12.e eVar5 = this.mBinding;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar5 = null;
        }
        String obj2 = eVar5.f451758r.getText().toString();
        z12.e eVar6 = this.mBinding;
        if (eVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar6;
        }
        LinearLayout linearLayout = eVar2.f451742b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
        Long l3 = iq0.a.l(linearLayout);
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = QzoneBaseService.ERROR_CODE_CLIENT_PARAMS_ERROR;
        }
        Bundle bundle = new Bundle();
        bundle.putString("guild_draft_input_text", valueOf);
        bundle.putCharSequence("guild_draft_input_editable_text", editableText);
        bundle.putLong("guild_draft_input_reply_msg_id", j3);
        bundle.putString("guild_draft_input_reply_nick", obj);
        bundle.putString("guild_draft_input_reply_content", obj2);
        return bundle;
    }

    private final void s1(String emojiCode) {
        z12.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar.f451746f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        int selectionStart = guildAIOInputEditText.getSelectionStart();
        int selectionEnd = guildAIOInputEditText.getSelectionEnd();
        if (selectionStart >= 0 && selectionEnd >= 0 && selectionEnd >= selectionStart) {
            guildAIOInputEditText.getEditableText().replace(selectionStart, selectionEnd, emojiCode);
            guildAIOInputEditText.requestFocus();
        }
    }

    private final void u1(GuildLiveAioInputUIState.GuildInputPanelChange state) {
        boolean z16;
        if (!state.getPanelShow() && !state.getKeyboardShow()) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.isPanelOrKeyBoardShow = z16;
        ts0.a aVar = this.liveAIOListener;
        if (aVar != null) {
            aVar.V5(true ^ state.getPanelShow(), state.getKeyboardShow());
        }
        W1();
    }

    private final void v1(final com.tencent.aio.data.msglist.a msgItem, boolean isInsertAt) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        X1(true);
        z12.e eVar = this.mBinding;
        z12.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f451756p.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.input.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLiveAioInputViewBinder.w1(GuildLiveAioInputViewBinder.this, view);
            }
        });
        z12.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        m1(msgItem, eVar3);
        z12.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar4 = null;
        }
        eVar4.f451742b.setTag(R.id.f73243t1, Long.valueOf(guildMsgItem.getMsgRecord().msgId));
        z12.e eVar5 = this.mBinding;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar5;
        }
        eVar2.f451742b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.input.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLiveAioInputViewBinder.x1(GuildLiveAioInputViewBinder.this, msgItem, view);
            }
        });
        if (isInsertAt) {
            L1(guildMsgItem);
        }
        S1(300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(GuildLiveAioInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X1(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(GuildLiveAioInputViewBinder this$0, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        this$0.sendIntent(new e.c((GuildMsgItem) msgItem));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y1(GuildMsgItem msgItem) {
        L1(msgItem);
        T1(this, 0L, 1, null);
    }

    private final void z1(GuildLiveAioInputUIState.ReeditMsg state) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        boolean z16;
        z12.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar.f451746f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        int i3 = 0;
        Z1(false);
        GuildDraftUtil guildDraftUtil = GuildDraftUtil.f112365a;
        ArrayList<MsgElement> arrayList = state.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "state.msgRecord.elements");
        z12.e eVar2 = this.mBinding;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar2 = null;
        }
        LinearLayout linearLayout = eVar2.f451742b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
        guildDraftUtil.c(arrayList, linearLayout, guildAIOInputEditText);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            z16 = iGPSService.isGuest(state.getMsgRecord().guildId);
        } else {
            z16 = true;
        }
        Z1(!z16);
        guildAIOInputEditText.requestFocus();
        Editable text = guildAIOInputEditText.getText();
        if (text != null) {
            i3 = text.length();
        }
        guildAIOInputEditText.setSelection(i3);
        T1(this, 0L, 1, null);
        sendIntent(new e.ReeditRecallMsg(state.getMsgRecord()));
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: B1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildLiveAioInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildLiveAioInputUIState.GuildClearEditInput) {
            n1();
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.GuildReplaceInputEmotion) {
            s1(((GuildLiveAioInputUIState.GuildReplaceInputEmotion) state).getEmotionCode());
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.GuildInputReplyMsg) {
            GuildLiveAioInputUIState.GuildInputReplyMsg guildInputReplyMsg = (GuildLiveAioInputUIState.GuildInputReplyMsg) state;
            v1(guildInputReplyMsg.getMsg(), guildInputReplyMsg.getIsInsertAt());
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.GuildInputPanelChange) {
            u1((GuildLiveAioInputUIState.GuildInputPanelChange) state);
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.GuildInputHint) {
            Q1((GuildLiveAioInputUIState.GuildInputHint) state);
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.VideoScreenChange) {
            D1(((GuildLiveAioInputUIState.VideoScreenChange) state).getVideoScreenState());
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.GuildSendResp) {
            A1(((GuildLiveAioInputUIState.GuildSendResp) state).a());
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.UpdateInputText) {
            C1(((GuildLiveAioInputUIState.UpdateInputText) state).getMsg());
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.GuideHideKeyboard) {
            E1();
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.GuildShowKeyboard) {
            T1(this, 0L, 1, null);
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.GuildHandlerPermissionsChange) {
            N1(((GuildLiveAioInputUIState.GuildHandlerPermissionsChange) state).getPermissions());
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.GuildLiveLongClickAvatar) {
            y1(((GuildLiveAioInputUIState.GuildLiveLongClickAvatar) state).getMsgItem());
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.ReeditMsg) {
            z1((GuildLiveAioInputUIState.ReeditMsg) state);
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.RecoverDraft) {
            GuildLiveAioInputUIState.RecoverDraft recoverDraft = (GuildLiveAioInputUIState.RecoverDraft) state;
            P1(recoverDraft.b(), recoverDraft.getAioParam());
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.InitAtCluster) {
            F1(((GuildLiveAioInputUIState.InitAtCluster) state).getAioParam());
            return;
        }
        if (state instanceof GuildLiveAioInputUIState.LiveInputToast) {
            V1((GuildLiveAioInputUIState.LiveInputToast) state);
        } else if (state instanceof GuildLiveAioInputUIState.SendSuccessUIState) {
            W1();
        } else if (state instanceof GuildLiveAioInputUIState.UpdateTextWatcherUIState) {
            o1(((GuildLiveAioInputUIState.UpdateTextWatcherUIState) state).getAioParam());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        H1();
        G1();
        sendIntent(e.m.f400153d);
        sendIntent(e.f.f400141d);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof t.a) {
            E1();
            return r1();
        }
        return super.generateVBState(stateCmd);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildLiveAioInputUIState>> getObserverStates() {
        List<Class<? extends GuildLiveAioInputUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildLiveAioInputUIState.GuildMultiSelectState.class, GuildLiveAioInputUIState.GuildHandlerPermissionsChange.class, GuildLiveAioInputUIState.UpdateInputText.class, GuildLiveAioInputUIState.GuildInputHint.class, GuildLiveAioInputUIState.InitAtCluster.class, GuildLiveAioInputUIState.RecoverDraft.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new es0.a(), new fs0.b(), new hs0.b(this.liveAIOListener), new is0.c(), new gs0.b(this.liveAIOListener)});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        z12.e g16 = z12.e.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, createViewParams.parent, false)");
        this.mBinding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        LinearLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        q1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: p1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<fo0.e, GuildLiveAioInputUIState> createVM() {
        return new GuildLiveAioInputViewModel();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            boolean z16;
            boolean isBlank;
            GuildLiveAioInputViewBinder guildLiveAioInputViewBinder = GuildLiveAioInputViewBinder.this;
            if (s16 != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(s16);
                if (!isBlank) {
                    z16 = false;
                    guildLiveAioInputViewBinder.Y1(z16);
                    GuildLiveAioInputViewBinder.this.W1();
                }
            }
            z16 = true;
            guildLiveAioInputViewBinder.Y1(z16);
            GuildLiveAioInputViewBinder.this.W1();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }
}
