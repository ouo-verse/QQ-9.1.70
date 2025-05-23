package com.tencent.mobileqq.troop.aivoicechat.aiobar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.toast.QUIStatusToast;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.InputSimpleEventIntent;
import com.tencent.mobileqq.aio.event.ShortcutEventIntent;
import com.tencent.mobileqq.aio.event.c;
import com.tencent.mobileqq.aio.input.AIOInputSendBtn;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatUIState;
import com.tencent.mobileqq.troop.aivoicechat.aiobar.a;
import com.tencent.mobileqq.troop.aivoicechat.aiobar.util.TroopAIVoiceChatImeHelper;
import com.tencent.mobileqq.troop.aivoicechat.aiobar.view.TroopAIVoiceChatItemView;
import com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi;
import com.tencent.mobileqq.troop.aivoicechat.voicelist.TroopAIVoiceChatListBaseFragment;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOPttApi;
import com.tencent.qqnt.aio.api.IAIOPttPlayerListenerApi;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.kernel.nativeinterface.VoiceItem;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 X2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001YB\u0007\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0002J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J \u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\bH\u0002J\n\u0010!\u001a\u0004\u0018\u00010 H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H\u0016J\u001a\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020&0)H\u0016J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0003H\u0016J\b\u0010-\u001a\u00020\u0004H\u0016R\u0016\u0010'\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u00103\u001a\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u00103\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u00103\u001a\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bS\u0010T\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a;", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/TroopAIVoiceChatUIState;", "", "M1", "", "input", "", ICustomDataEditor.STRING_PARAM_1, "", "Lcom/tencent/qqnt/kernel/nativeinterface/VoiceItem;", "voiceList", "selectedVoiceItem", "P1", "voiceItem", "Landroid/view/View$OnClickListener;", "u1", "H1", "memberUid", "memberUin", "nickName", "F1", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/a$a;", "y1", "isGag", "wording", "needShowSoftInput", "L1", "r1", "J1", "I1", "Landroid/view/View;", "C1", "K1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/api/runtime/a;", "context", "handleCreateVM", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", "state", Constants.APK_CERTIFICATE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", "d", "Landroid/content/Context;", "Lwr2/a;", "e", "Lkotlin/Lazy;", "x1", "()Lwr2/a;", "barViewBinding", "", "f", "B1", "()I", "maxWordCount", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/util/TroopAIVoiceChatImeHelper;", tl.h.F, "A1", "()Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/util/TroopAIVoiceChatImeHelper;", "imeHelper", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/view/TroopAIVoiceChatItemView;", "i", "Lcom/tencent/mobileqq/troop/aivoicechat/aiobar/view/TroopAIVoiceChatItemView;", "lastFocusItemView", "Lvr2/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, Constants.BASE_IN_PLUGIN_ID, "()Lvr2/h;", "samplePlayer", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/FastDynamicDrawable;", BdhLogUtil.LogTag.Tag_Conn, "E1", "()Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/FastDynamicDrawable;", "voiceWaveDrawable", "D", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;", "z1", "()Lcom/tencent/mobileqq/aio/input/edit/AIOEditText;", "editText", "<init>", "()V", "E", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopAIVoiceChatVB extends com.tencent.aio.base.mvvm.a<a, TroopAIVoiceChatUIState> {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy voiceWaveDrawable;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy barViewBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy maxWordCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy imeHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TroopAIVoiceChatItemView lastFocusItemView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy samplePlayer;

    public TroopAIVoiceChatVB() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<wr2.a>() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatVB$barViewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final wr2.a invoke() {
                Context context = TroopAIVoiceChatVB.this.context;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context = null;
                }
                return new wr2.a(context);
            }
        });
        this.barViewBinding = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatVB$maxWordCount$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(vr2.a.f443197a.a());
            }
        });
        this.maxWordCount = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TroopAIVoiceChatImeHelper>() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatVB$imeHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TroopAIVoiceChatImeHelper invoke() {
                return new TroopAIVoiceChatImeHelper(TroopAIVoiceChatVB.this.z1());
            }
        });
        this.imeHelper = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<vr2.h>() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatVB$samplePlayer$2
            @Override // kotlin.jvm.functions.Function0
            public final vr2.h invoke() {
                return new vr2.h();
            }
        });
        this.samplePlayer = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<FastDynamicDrawable>() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatVB$voiceWaveDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FastDynamicDrawable invoke() {
                return vr2.b.f443198a.b();
            }
        });
        this.voiceWaveDrawable = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopAIVoiceChatImeHelper A1() {
        return (TroopAIVoiceChatImeHelper) this.imeHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int B1() {
        return ((Number) this.maxWordCount.getValue()).intValue();
    }

    private final View C1() {
        com.tencent.mvi.base.route.j e16;
        View a16;
        com.tencent.mvi.base.route.j e17;
        if (QQTheme.isNowSimpleUI()) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            k k3 = (aVar == null || (e17 = aVar.e()) == null) ? null : e17.k(new InputSimpleEventIntent.OnGetShortCutLayoutViewIntent());
            c.C7243c c7243c = k3 instanceof c.C7243c ? (c.C7243c) k3 : null;
            if (c7243c == null || (a16 = c7243c.a()) == null) {
                return null;
            }
            return a16.findViewById(R.id.fun_btn);
        }
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        k k16 = (aVar2 == null || (e16 = aVar2.e()) == null) ? null : e16.k(new ShortcutEventIntent.OnGetPlusIconViewIntent());
        com.tencent.mobileqq.aio.event.j jVar = k16 instanceof com.tencent.mobileqq.aio.event.j ? (com.tencent.mobileqq.aio.event.j) k16 : null;
        if (jVar != null) {
            return jVar.a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final vr2.h D1() {
        return (vr2.h) this.samplePlayer.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FastDynamicDrawable E1() {
        return (FastDynamicDrawable) this.voiceWaveDrawable.getValue();
    }

    private final void F1(String memberUid, String memberUin, String nickName) {
        if (z1().isEnabled()) {
            CharSequence r16 = com.tencent.qqnt.aio.at.a.r(getMContext(), memberUid, memberUin, nickName, nickName, z1(), 0, false, true);
            if (r16 == null) {
                r16 = "";
            }
            z1().getEditableText().replace(z1().getSelectionStart(), z1().getSelectionEnd(), r16);
            z1().requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean H1(VoiceItem voiceItem) {
        return Intrinsics.areEqual(y1().getSelectedVoiceId(), voiceItem != null ? voiceItem.voiceId : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean I1() {
        a.c cVar = new a.c(false, 1, null);
        sendIntent(cVar);
        return cVar.getNeedShow();
    }

    private final void J1() {
        ((IAIOPttPlayerListenerApi) QRoute.api(IAIOPttPlayerListenerApi.class)).removePttPlayerStartListener(Long.MIN_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K1() {
        View C1 = C1();
        if (!(C1 != null && C1.getVisibility() == 0)) {
            QLog.i("TroopAIVoiceChatVB", 1, "[showGuideBubbleTips] anchorView = " + C1);
            return;
        }
        Context context = this.context;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        com.tencent.mobileqq.widget.tip.a S = QUIDefaultBubbleTip.r(context).S(C1);
        Context context3 = this.context;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
        } else {
            context2 = context3;
        }
        S.o0(context2.getString(R.string.f131103)).k0(0).R(2).m0(5).e0(true).i0(0.0f, 6.0f).s0();
    }

    private final void L1(boolean isGag, String wording, boolean needShowSoftInput) {
        x1().t(isGag, wording);
        if (isGag) {
            TroopAIVoiceChatImeHelper.j(A1(), null, 1, null);
        } else if (needShowSoftInput) {
            A1().h();
            A1().m();
        }
    }

    private final void M1() {
        x1().b();
        z1().addTextChangedListener(new b());
        x1().h().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopAIVoiceChatVB.N1(TroopAIVoiceChatVB.this, view);
            }
        });
        x1().k().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopAIVoiceChatVB.O1(TroopAIVoiceChatVB.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(TroopAIVoiceChatVB this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a.C8670a y16 = this$0.y1();
        ((IBusManager) QRoute.api(IBusManager.class)).sendEvent(new zr2.c(false, String.valueOf(y16.getTroopUin()), 0, 4, null));
        vr2.e.f443201a.b("em_group_float_close_btn", y16.getAiChatType(), y16.getSelectedVoiceId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O1(TroopAIVoiceChatVB this$0, View view) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Editable text = this$0.z1().getText();
        if (text != null) {
            if ((text.length() > 0) && text.length() <= 2) {
                Context context = this$0.context;
                Context context2 = null;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context = null;
                }
                Context context3 = this$0.context;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context2 = context3;
                }
                QQToast.makeText(context, context2.getString(R.string.f131136), 0).show();
                return;
            }
        }
        a.C8670a y16 = this$0.y1();
        String purePlainText = new QQText(this$0.z1().getText(), 16, 16).toPurePlainText();
        Intrinsics.checkNotNullExpressionValue(purePlainText, "purePlainText");
        if (!this$0.s1(purePlainText)) {
            com.tencent.aio.api.runtime.a aVar = this$0.aioContext;
            if (aVar != null && (e16 = aVar.e()) != null) {
                e16.h(new AIOMsgSendEvent.TextSendEvent(String.valueOf(this$0.z1().getText())));
            }
            Editable text2 = this$0.z1().getText();
            if (text2 != null) {
                text2.clear();
                return;
            }
            return;
        }
        ((ITroopAIVoiceChatApi) QRoute.api(ITroopAIVoiceChatApi.class)).sendAiPttMsg(String.valueOf(y16.getTroopUin()), y16.getAiChatType(), y16.getSelectedVoiceId(), String.valueOf(this$0.z1().getText()), new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatVB$updateViewState$3$2
            public final void invoke(int i3, String str) {
                Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }
        });
        QLog.i("TroopAIVoiceChatVB", 1, "[sendAiPttMsg] troopUin = " + y16.getTroopUin() + " aiVoiceType = " + y16.getAiChatType() + " voiceId = " + y16.getSelectedVoiceId() + " text = " + ((Object) this$0.z1().getText()));
        Editable text3 = this$0.z1().getText();
        if (text3 != null) {
            text3.clear();
        }
        vr2.e.f443201a.b("em_group_send_btn", y16.getAiChatType(), y16.getSelectedVoiceId());
    }

    private final void P1(List<VoiceItem> voiceList, VoiceItem selectedVoiceItem) {
        Context context;
        Context context2;
        LinearLayout l3 = x1().l();
        l3.removeAllViews();
        Context context3 = this.context;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        } else {
            context = context3;
        }
        final TroopAIVoiceChatItemView troopAIVoiceChatItemView = new TroopAIVoiceChatItemView(context, null, 0, 6, null);
        troopAIVoiceChatItemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopAIVoiceChatVB.Q1(TroopAIVoiceChatVB.this, troopAIVoiceChatItemView, view);
            }
        });
        troopAIVoiceChatItemView.a();
        l3.addView(troopAIVoiceChatItemView);
        TroopAIVoiceChatItemView.Companion companion = TroopAIVoiceChatItemView.INSTANCE;
        Context context4 = this.context;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context4 = null;
        }
        l3.addView(companion.a(context4));
        for (VoiceItem voiceItem : voiceList) {
            Context context5 = this.context;
            if (context5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            } else {
                context2 = context5;
            }
            TroopAIVoiceChatItemView troopAIVoiceChatItemView2 = new TroopAIVoiceChatItemView(context2, null, 0, 6, null);
            troopAIVoiceChatItemView2.setOnClickListener(u1(voiceItem));
            troopAIVoiceChatItemView2.b(voiceItem, y1().getAiChatType());
            if (Intrinsics.areEqual(voiceItem.getVoiceId(), selectedVoiceItem != null ? selectedVoiceItem.voiceId : null)) {
                troopAIVoiceChatItemView2.e(true);
                this.lastFocusItemView = troopAIVoiceChatItemView2;
            }
            l3.addView(troopAIVoiceChatItemView2);
            TroopAIVoiceChatItemView.Companion companion2 = TroopAIVoiceChatItemView.INSTANCE;
            Context context6 = this.context;
            if (context6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context6 = null;
            }
            l3.addView(companion2.a(context6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(TroopAIVoiceChatVB this$0, TroopAIVoiceChatItemView this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        a.C8670a y16 = this$0.y1();
        Intent intent = new Intent();
        intent.putExtra("troop_uin", y16.getTroopUin());
        intent.putExtra(ITroopAIVoiceChatApi.AI_CHAT_TYPE, y16.getAiChatType());
        QPublicFragmentActivity.start(this_apply.getContext(), intent, TroopAIVoiceChatListBaseFragment.class);
        TroopAIVoiceChatImeHelper.j(this$0.A1(), null, 1, null);
        vr2.e.c(vr2.e.f443201a, "em_group_add_voice", y16.getAiChatType(), null, 4, null);
    }

    private final void r1() {
        ((IAIOPttPlayerListenerApi) QRoute.api(IAIOPttPlayerListenerApi.class)).addPttPlayerStartListener(Long.MIN_VALUE, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatVB$addPttPlayerStartListener$1
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
                TroopAIVoiceChatItemView troopAIVoiceChatItemView;
                vr2.h D1;
                troopAIVoiceChatItemView = TroopAIVoiceChatVB.this.lastFocusItemView;
                if (troopAIVoiceChatItemView != null) {
                    troopAIVoiceChatItemView.e(true);
                }
                D1 = TroopAIVoiceChatVB.this.D1();
                D1.f();
            }
        });
    }

    private final boolean s1(String input) {
        return (input.length() > 0) && new Regex("[\\u4e00-\\u9fa5a-zA-Z0-9]").containsMatchIn(input);
    }

    private final View.OnClickListener u1(final VoiceItem voiceItem) {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopAIVoiceChatVB.v1(TroopAIVoiceChatVB.this, voiceItem, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(final TroopAIVoiceChatVB this$0, VoiceItem voiceItem, View view) {
        VoiceItem voiceItem2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(voiceItem, "$voiceItem");
        this$0.sendIntent(new a.d(voiceItem));
        String str = null;
        final TroopAIVoiceChatItemView troopAIVoiceChatItemView = view instanceof TroopAIVoiceChatItemView ? (TroopAIVoiceChatItemView) view : null;
        if (troopAIVoiceChatItemView == null) {
            return;
        }
        vr2.i iVar = vr2.i.f443207a;
        Context context = this$0.context;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("context");
            context = null;
        }
        if (iVar.a(context)) {
            Context context2 = this$0.context;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                context2 = null;
            }
            Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
            if (activity != null) {
                QUIStatusToast qUIStatusToast = new QUIStatusToast(activity);
                qUIStatusToast.setIcon(R.drawable.qui_voice_mute_icon_white_primary);
                qUIStatusToast.P("\u8bf7\u8c03\u5927\u58f0\u97f3\u540e\u64ad\u653e");
                qUIStatusToast.show();
            }
        }
        VoiceItem voiceItem3 = troopAIVoiceChatItemView.getVoiceItem();
        String str2 = voiceItem3 != null ? voiceItem3.voiceId : null;
        TroopAIVoiceChatItemView troopAIVoiceChatItemView2 = this$0.lastFocusItemView;
        if (troopAIVoiceChatItemView2 != null && (voiceItem2 = troopAIVoiceChatItemView2.getVoiceItem()) != null) {
            str = voiceItem2.voiceId;
        }
        if (Intrinsics.areEqual(str2, str) && this$0.D1().d()) {
            troopAIVoiceChatItemView.e(true);
            this$0.D1().f();
            return;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105491", true)) {
            this$0.D1().e();
        }
        TroopAIVoiceChatItemView troopAIVoiceChatItemView3 = this$0.lastFocusItemView;
        if (troopAIVoiceChatItemView3 != null) {
            troopAIVoiceChatItemView3.e(false);
        }
        troopAIVoiceChatItemView.setSelect(this$0.E1());
        this$0.lastFocusItemView = troopAIVoiceChatItemView;
        vr2.h D1 = this$0.D1();
        String str3 = voiceItem.exampleUrl;
        Intrinsics.checkNotNullExpressionValue(str3, "voiceItem.exampleUrl");
        D1.h(str3, new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatVB$createItemViewClkListener$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                FastDynamicDrawable E1;
                FastDynamicDrawable E12;
                ((IAIOPttApi) QRoute.api(IAIOPttApi.class)).stopAll();
                E1 = TroopAIVoiceChatVB.this.E1();
                E1.restart();
                TroopAIVoiceChatItemView troopAIVoiceChatItemView4 = troopAIVoiceChatItemView;
                E12 = TroopAIVoiceChatVB.this.E1();
                troopAIVoiceChatItemView4.setSelect(E12);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.TroopAIVoiceChatVB$createItemViewClkListener$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                FastDynamicDrawable E1;
                boolean H1;
                E1 = TroopAIVoiceChatVB.this.E1();
                E1.stop();
                TroopAIVoiceChatItemView troopAIVoiceChatItemView4 = troopAIVoiceChatItemView;
                H1 = TroopAIVoiceChatVB.this.H1(troopAIVoiceChatItemView4.getVoiceItem());
                troopAIVoiceChatItemView4.e(H1);
            }
        }, new MediaPlayer.OnCompletionListener() { // from class: com.tencent.mobileqq.troop.aivoicechat.aiobar.f
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer) {
                TroopAIVoiceChatVB.w1(TroopAIVoiceChatVB.this, troopAIVoiceChatItemView, mediaPlayer);
            }
        });
        vr2.e eVar = vr2.e.f443201a;
        int aiChatType = this$0.y1().getAiChatType();
        String str4 = voiceItem.voiceId;
        Intrinsics.checkNotNullExpressionValue(str4, "voiceItem.voiceId");
        eVar.b("em_group_timbre", aiChatType, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(TroopAIVoiceChatVB this$0, TroopAIVoiceChatItemView voiceItemView, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(voiceItemView, "$voiceItemView");
        this$0.E1().stop();
        voiceItemView.e(this$0.H1(voiceItemView.getVoiceItem()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final wr2.a x1() {
        return (wr2.a) this.barViewBinding.getValue();
    }

    private final a.C8670a y1() {
        a.C8670a c8670a = new a.C8670a(0L, 0, null, 7, null);
        sendIntent(c8670a);
        return c8670a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AIOEditText z1() {
        return x1().i();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: G1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(TroopAIVoiceChatUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        QLog.i("TroopAIVoiceChatVB", 1, "[handleUIState] state = " + state);
        if (state instanceof TroopAIVoiceChatUIState.UpdateVoiceListUI) {
            TroopAIVoiceChatUIState.UpdateVoiceListUI updateVoiceListUI = (TroopAIVoiceChatUIState.UpdateVoiceListUI) state;
            P1(updateVoiceListUI.b(), updateVoiceListUI.getSelectedVoiceItem());
            return;
        }
        if (state instanceof TroopAIVoiceChatUIState.InsertAtMemberSpanUIState) {
            TroopAIVoiceChatUIState.InsertAtMemberSpanUIState insertAtMemberSpanUIState = (TroopAIVoiceChatUIState.InsertAtMemberSpanUIState) state;
            F1(insertAtMemberSpanUIState.getUid(), insertAtMemberSpanUIState.getUin(), insertAtMemberSpanUIState.getNickName());
            return;
        }
        if (state instanceof TroopAIVoiceChatUIState.UpdateBottomMarginView) {
            x1().g().setVisibility(((TroopAIVoiceChatUIState.UpdateBottomMarginView) state).getIsShowKeyboard() ? 8 : 0);
            return;
        }
        if (state instanceof TroopAIVoiceChatUIState.StartAIChatExitAnim) {
            x1().a(new TroopAIVoiceChatVB$handleUIState$1(this));
            return;
        }
        if (state instanceof TroopAIVoiceChatUIState.UpdateGagStatus) {
            TroopAIVoiceChatUIState.UpdateGagStatus updateGagStatus = (TroopAIVoiceChatUIState.UpdateGagStatus) state;
            L1(updateGagStatus.getIsGag(), updateGagStatus.getWording(), updateGagStatus.getNeedShowSoftInput());
            return;
        }
        if (state instanceof TroopAIVoiceChatUIState.OnLifeCycleUpdate) {
            if (((TroopAIVoiceChatUIState.OnLifeCycleUpdate) state).getLifeCycleState() == 9) {
                D1().f();
                TroopAIVoiceChatItemView troopAIVoiceChatItemView = this.lastFocusItemView;
                if (troopAIVoiceChatItemView != null) {
                    troopAIVoiceChatItemView.e(H1(troopAIVoiceChatItemView != null ? troopAIVoiceChatItemView.getVoiceItem() : null));
                    return;
                }
                return;
            }
            return;
        }
        if (state instanceof TroopAIVoiceChatUIState.InputBarRequestFocus) {
            z1().requestFocus();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public BaseVM<a, TroopAIVoiceChatUIState, com.tencent.aio.api.runtime.a> createVM() {
        return new j();
    }

    @Override // com.tencent.mvi.mvvm.b
    public View onCreateView(com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        QLog.i("TroopAIVoiceChatVB", 1, "[onCreateView]");
        this.context = createViewParams.a();
        M1();
        return x1().j();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        J1();
        Editable text = z1().getText();
        if (text != null) {
            text.clear();
        }
        D1().e();
        E1().stop();
        A1().l();
    }

    @Override // com.tencent.aio.base.mvvm.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void handleCreateVM(com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.handleCreateVM(context);
        this.aioContext = context;
        r1();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s16) {
            if (s16 != null && s16.length() > TroopAIVoiceChatVB.this.B1()) {
                s16.delete(TroopAIVoiceChatVB.this.B1(), s16.length());
                Context context = TroopAIVoiceChatVB.this.context;
                Context context2 = null;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                    context = null;
                }
                Context context3 = TroopAIVoiceChatVB.this.context;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("context");
                } else {
                    context2 = context3;
                }
                QQToast.makeText(context, context2.getString(R.string.f131125), 0).show();
            }
            AIOInputSendBtn k3 = TroopAIVoiceChatVB.this.x1().k();
            Editable text = TroopAIVoiceChatVB.this.z1().getText();
            k3.setEnabled(!(text == null || text.length() == 0));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence text, int start, int before, int count) {
        }
    }
}
