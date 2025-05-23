package com.tencent.mobileqq.gamecenter.qa.aio.input;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.component.avatar.GuildTextAioUserAvatarViewBinder;
import com.tencent.guild.aio.input.realinput.s;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.guild.aio.input.widget.MutliSeletedBottomLine;
import com.tencent.guild.aio.util.GuildDraftUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.gamecenter.qa.aio.input.GameQAAioInputUIState;
import com.tencent.mobileqq.gamecenter.qa.aio.input.p;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyChannelEntry;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import fo0.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001b\u0018\u0000 s2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001tB\u0007\u00a2\u0006\u0004\bq\u0010rJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0015\u001a\u00020\u00042\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J \u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001aH\u0002J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020!2\u0006\u0010%\u001a\u00020$H\u0002J\u0012\u0010)\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\u0019\u0010,\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\u001aH\u0002\u00a2\u0006\u0004\b,\u0010-J\u0010\u00101\u001a\u0002002\u0006\u0010/\u001a\u00020.H\u0002J&\u00107\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u000205\u0012\u0006\b\u0001\u0012\u0002060\u0001042\u0006\u00103\u001a\u000202H\u0016J\u0010\u0010:\u001a\u0002022\u0006\u00109\u001a\u000208H\u0016J\u0014\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030;H\u0016J\b\u0010=\u001a\u00020\u0004H\u0016J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0003H\u0016J\u0016\u0010A\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030@04H\u0016J\u000e\u0010B\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0016J\u0012\u0010D\u001a\u0004\u0018\u0001002\u0006\u0010/\u001a\u00020CH\u0016J\b\u0010E\u001a\u00020\u0004H\u0016R\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010N\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010h\u001a\u00020f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010gR/\u0010p\u001a\u001d\u0012\u0013\u0012\u00110j\u00a2\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020\u00040i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010o\u00a8\u0006u"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewBinder;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/e;", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputUIState;", "", "I1", "O1", "H1", "R1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "V1", "", "permissions", "P1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgItem", "y1", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "S1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "w1", Constants.APK_CERTIFICATE, "r1", "", "isSelectMode", "isJubao", "isShowInputBar", "E1", "count", Constants.BASE_IN_PLUGIN_ID, "Lcom/tencent/aio/data/msglist/a;", "isInsertAt", "z1", "Ltd1/a;", "binding", ICustomDataEditor.STRING_PARAM_1, "", "delay", "Y1", "Q1", "isShowKeyboard", "C1", "(Ljava/lang/Boolean;)V", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/p$a;", "stateCmd", "Landroid/os/Bundle;", "v1", "Landroid/view/View;", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/mvi/api/help/a;", "params", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "u1", "bindViewAndData", "state", "F1", "Ljava/lang/Class;", "getObserverStates", "x1", "Lcom/tencent/mvi/api/ability/d;", "generateVBState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "d", UserInfo.SEX_FEMALE, "mOriginalInputTextSize", "e", "mHintTextSize", "f", "I", "mInputWidth", tl.h.F, "Ltd1/a;", "mBinding", "Lgo0/c;", "i", "Lgo0/c;", "mGuildAtCluster", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewModel;", "mUIMode", "Lvd1/b;", BdhLogUtil.LogTag.Tag_Conn, "Lvd1/b;", "mSessionInfo", "Lvn0/k;", "D", "Lvn0/k;", "guildAioReplyLayout", "com/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewBinder$c", "E", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewBinder$c;", "mTextWatcher", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "mLayoutListener", "Lkotlin/Function1;", "Landroid/widget/EditText;", "Lkotlin/ParameterName;", "name", "editText", "G", "Lkotlin/jvm/functions/Function1;", "onSendMsg", "<init>", "()V", "H", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameQAAioInputViewBinder extends com.tencent.aio.base.mvvm.a<fo0.e, GameQAAioInputUIState> {

    /* renamed from: C, reason: from kotlin metadata */
    private vd1.b mSessionInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private vn0.k guildAioReplyLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float mOriginalInputTextSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float mHintTextSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mInputWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private td1.a mBinding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GameQAAioInputViewModel mUIMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private go0.c mGuildAtCluster = new go0.c();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private c mTextWatcher = new c();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private View.OnLayoutChangeListener mLayoutListener = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.j
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            GameQAAioInputViewBinder.N1(GameQAAioInputViewBinder.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
        }
    };

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Function1<EditText, Unit> onSendMsg = new Function1<EditText, Unit>() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.GameQAAioInputViewBinder$onSendMsg$1
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
            vn0.k kVar;
            vn0.k kVar2;
            Intrinsics.checkNotNullParameter(it, "it");
            List<e.InputSendTextIntent> a16 = com.tencent.guild.aio.util.e.f112380a.a(it);
            GameQAAioInputViewBinder gameQAAioInputViewBinder = GameQAAioInputViewBinder.this;
            td1.a aVar = gameQAAioInputViewBinder.mBinding;
            e.ReplyData replyData = null;
            vn0.k kVar3 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar = null;
            }
            LinearLayout linearLayout = aVar.f435863b;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
            Long l3 = iq0.a.l(linearLayout);
            if (l3 != null) {
                GameQAAioInputViewBinder gameQAAioInputViewBinder2 = GameQAAioInputViewBinder.this;
                long longValue = l3.longValue();
                kVar = gameQAAioInputViewBinder2.guildAioReplyLayout;
                if (kVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
                    kVar = null;
                }
                String obj = kVar.f441969d.getText().toString();
                kVar2 = gameQAAioInputViewBinder2.guildAioReplyLayout;
                if (kVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
                } else {
                    kVar3 = kVar2;
                }
                replyData = new e.ReplyData(longValue, obj, kVar3.f441970e.getText().toString());
            }
            gameQAAioInputViewBinder.sendIntent(new e.InputSendMultiTextIntent(a16, replyData));
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewBinder$b", "Lgo0/f;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements go0.f {
        b() {
        }

        @Override // go0.f
        public void a(@NotNull GuildMsgItem msgItem) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            GameQAAioInputViewBinder.this.x1(msgItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(GameQAAioInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        td1.a aVar = this$0.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        aVar.f435863b.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B1(GameQAAioInputViewBinder this$0, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        this$0.sendIntent(new e.c((GuildMsgItem) msgItem));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void C1(Boolean isShowKeyboard) {
        QLog.i("GameQAAioInputViewBinder", 1, "handleKeyboardStatusChange isShowKeyboard=" + isShowKeyboard);
        td1.a aVar = null;
        if (!Intrinsics.areEqual(isShowKeyboard, Boolean.TRUE)) {
            td1.a aVar2 = this.mBinding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar2 = null;
            }
            if (TextUtils.isEmpty(String.valueOf(aVar2.f435865d.getText()))) {
                td1.a aVar3 = this.mBinding;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    aVar3 = null;
                }
                aVar3.f435873l.setVisibility(0);
                td1.a aVar4 = this.mBinding;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    aVar = aVar4;
                }
                aVar.f435871j.setVisibility(8);
                return;
            }
        }
        td1.a aVar5 = this.mBinding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar5 = null;
        }
        aVar5.f435873l.setVisibility(8);
        td1.a aVar6 = this.mBinding;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar = aVar6;
        }
        aVar.f435871j.setVisibility(0);
    }

    private final void D1(int count) {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        td1.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        TextView textView = aVar.f435870i;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = mobileQQ.getString(R.string.f139520bh);
        Intrinsics.checkNotNullExpressionValue(string, "app.getString(R.string.guild_aio_select_msg_count)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(count)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
    }

    private final void E1(boolean isSelectMode, boolean isJubao, boolean isShowInputBar) {
        QLog.i("GameQAAioInputViewBinder", 1, "handleMultiSelectModeChanged isSelectMode=" + isSelectMode + " isJubao=" + isJubao + " isShowInputBar=" + isShowInputBar);
        td1.a aVar = null;
        if (isSelectMode) {
            td1.a aVar2 = this.mBinding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar2 = null;
            }
            aVar2.f435864c.setVisibility(8);
            td1.a aVar3 = this.mBinding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar3 = null;
            }
            aVar3.f435866e.setVisibility(0);
        } else {
            if (isShowInputBar) {
                td1.a aVar4 = this.mBinding;
                if (aVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    aVar4 = null;
                }
                aVar4.f435864c.setVisibility(0);
            }
            td1.a aVar5 = this.mBinding;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar5 = null;
            }
            aVar5.f435866e.setVisibility(8);
        }
        if (isJubao) {
            td1.a aVar6 = this.mBinding;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar6 = null;
            }
            aVar6.f435864c.setVisibility(8);
            td1.a aVar7 = this.mBinding;
            if (aVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                aVar = aVar7;
            }
            aVar.f435866e.setVisibility(8);
        }
    }

    private final void G1() {
        Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        td1.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        inputMethodManager.hideSoftInputFromWindow(aVar.f435865d.getWindowToken(), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H1() {
        go0.c cVar = this.mGuildAtCluster;
        td1.a aVar = this.mBinding;
        GameQAAioInputViewModel gameQAAioInputViewModel = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = aVar.f435865d;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        td1.a aVar2 = this.mBinding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar2 = null;
        }
        ConstraintLayout constraintLayout = aVar2.f435864c;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "mBinding.guildAioInputBar");
        td1.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar3 = null;
        }
        Context context = aVar3.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        GameQAAioInputViewModel gameQAAioInputViewModel2 = this.mUIMode;
        if (gameQAAioInputViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIMode");
            gameQAAioInputViewModel2 = null;
        }
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) gameQAAioInputViewModel2.getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mUIMode.mContext.aioParam");
        GameQAAioInputViewModel gameQAAioInputViewModel3 = this.mUIMode;
        if (gameQAAioInputViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIMode");
        } else {
            gameQAAioInputViewModel = gameQAAioInputViewModel3;
        }
        cVar.h(guildAIOInputEditText, constraintLayout, context, g16, null, (com.tencent.aio.api.runtime.a) gameQAAioInputViewModel.getMContext());
    }

    private final void I1() {
        td1.a aVar = this.mBinding;
        td1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        ConstraintLayout constraintLayout = aVar.f435864c;
        s sVar = s.f111173a;
        constraintLayout.setBackgroundResource(sVar.a());
        td1.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar3 = null;
        }
        aVar3.f435864c.setPadding(0, 0, 0, 0);
        td1.a aVar4 = this.mBinding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar4 = null;
        }
        aVar4.f435865d.setTextColor(sVar.b(getMContext()));
        td1.a aVar5 = this.mBinding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar5 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = aVar5.f435865d;
        QRouteApi api = QRoute.api(IGuildEmojiApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildEmojiApi::class.java)");
        guildAIOInputEditText.setEditableFactory(IGuildEmojiApi.a.a((IGuildEmojiApi) api, 18, 0, 2, null));
        guildAIOInputEditText.setHintTextColor(getMContext().getResources().getColor(R.color.guild_aio_input_hint));
        guildAIOInputEditText.setHint(new SpannableStringBuilder(getMContext().getResources().getString(R.string.f199534po)));
        this.mInputWidth = 0;
        td1.a aVar6 = this.mBinding;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar6 = null;
        }
        aVar6.f435865d.addOnLayoutChangeListener(this.mLayoutListener);
        td1.a aVar7 = this.mBinding;
        if (aVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar7 = null;
        }
        aVar7.f435865d.addTextChangedListener(this.mTextWatcher);
        td1.a aVar8 = this.mBinding;
        if (aVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar8 = null;
        }
        aVar8.f435871j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameQAAioInputViewBinder.J1(GameQAAioInputViewBinder.this, view);
            }
        });
        td1.a aVar9 = this.mBinding;
        if (aVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar9 = null;
        }
        aVar9.f435873l.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameQAAioInputViewBinder.K1(GameQAAioInputViewBinder.this, view);
            }
        });
        com.tencent.guild.aio.util.g gVar = com.tencent.guild.aio.util.g.f112400a;
        td1.a aVar10 = this.mBinding;
        if (aVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar10 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText2 = aVar10.f435865d;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText2, "mBinding.guildAioInputEdittext");
        gVar.c(guildAIOInputEditText2, new Function0<Unit>() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.GameQAAioInputViewBinder$initView$4
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
                td1.a aVar11 = GameQAAioInputViewBinder.this.mBinding;
                if (aVar11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    aVar11 = null;
                }
                aVar11.f435871j.performClick();
            }
        });
        td1.a aVar11 = this.mBinding;
        if (aVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar11 = null;
        }
        aVar11.f435868g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameQAAioInputViewBinder.L1(GameQAAioInputViewBinder.this, view);
            }
        });
        td1.a aVar12 = this.mBinding;
        if (aVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar12;
        }
        aVar2.f435869h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameQAAioInputViewBinder.M1(GameQAAioInputViewBinder.this, view);
            }
        });
        r1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J1(GameQAAioInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<EditText, Unit> function1 = this$0.onSendMsg;
        td1.a aVar = this$0.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = aVar.f435865d;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        function1.invoke(guildAIOInputEditText);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(GameQAAioInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.O1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L1(GameQAAioInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.h.f400143d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(GameQAAioInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.j.f400145d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(GameQAAioInputViewBinder this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        String str;
        boolean equals$default;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i29 = i17 - i3;
        if (this$0.mInputWidth != i29) {
            this$0.mInputWidth = i29;
            td1.a aVar = this$0.mBinding;
            td1.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar = null;
            }
            aVar.f435865d.setTextSize(0, this$0.mOriginalInputTextSize);
            int i36 = this$0.mInputWidth;
            td1.a aVar3 = this$0.mBinding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar3 = null;
            }
            int paddingLeft = i36 - aVar3.f435865d.getPaddingLeft();
            td1.a aVar4 = this$0.mBinding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar4 = null;
            }
            int paddingRight = paddingLeft - aVar4.f435865d.getPaddingRight();
            td1.a aVar5 = this$0.mBinding;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar5 = null;
            }
            float measureText = aVar5.f435865d.getPaint().measureText(this$0.getMContext().getResources().getString(R.string.f199534po));
            float f16 = paddingRight;
            if (measureText > f16) {
                this$0.mHintTextSize = (this$0.mOriginalInputTextSize * f16) / measureText;
                td1.a aVar6 = this$0.mBinding;
                if (aVar6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    aVar6 = null;
                }
                Editable text = aVar6.f435865d.getText();
                if (text != null) {
                    str = text.toString();
                } else {
                    str = null;
                }
                equals$default = StringsKt__StringsJVMKt.equals$default(str, "", false, 2, null);
                if (equals$default) {
                    td1.a aVar7 = this$0.mBinding;
                    if (aVar7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    } else {
                        aVar2 = aVar7;
                    }
                    aVar2.f435865d.setTextSize(0, this$0.mHintTextSize);
                }
            }
        }
    }

    private final void O1() {
        GameStrategyChannelEntry gameStrategyChannelEntry = new GameStrategyChannelEntry();
        vd1.b bVar = this.mSessionInfo;
        vd1.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            bVar = null;
        }
        gameStrategyChannelEntry.guildId = bVar.f441456a;
        vd1.b bVar3 = this.mSessionInfo;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            bVar3 = null;
        }
        gameStrategyChannelEntry.channelId = bVar3.f441457b;
        IQQGameStrategyApi iQQGameStrategyApi = (IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class);
        Context mContext = getMContext();
        Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        QBaseActivity qBaseActivity = (QBaseActivity) mContext;
        vd1.b bVar4 = this.mSessionInfo;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
            bVar4 = null;
        }
        iQQGameStrategyApi.openGameStrategyQuestionDialog(qBaseActivity, bVar4.f441458c, gameStrategyChannelEntry);
        IQQGameStrategyApi iQQGameStrategyApi2 = (IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class);
        Context mContext2 = getMContext();
        Intrinsics.checkNotNull(mContext2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
        QBaseActivity qBaseActivity2 = (QBaseActivity) mContext2;
        vd1.b bVar5 = this.mSessionInfo;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSessionInfo");
        } else {
            bVar2 = bVar5;
        }
        iQQGameStrategyApi2.reportAskBtnClick(qBaseActivity2, bVar2.f441458c, gameStrategyChannelEntry);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void P1(int permissions) {
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        GameQAAioInputViewModel gameQAAioInputViewModel = this.mUIMode;
        td1.a aVar = null;
        if (gameQAAioInputViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIMode");
            gameQAAioInputViewModel = null;
        }
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) gameQAAioInputViewModel.getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mUIMode.mContext.aioParam");
        boolean d16 = companion.d(permissions, com.tencent.guild.aio.util.a.g(g16));
        QLog.i("GameQAAioInputViewBinder", 1, "onPermissionChange inInputMode=" + d16);
        if (d16) {
            td1.a aVar2 = this.mBinding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                aVar = aVar2;
            }
            aVar.f435864c.setVisibility(0);
            return;
        }
        td1.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar = aVar3;
        }
        aVar.f435864c.setVisibility(8);
        G1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1() {
        td1.a aVar = this.mBinding;
        td1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        aVar.f435865d.requestFocus();
        Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        td1.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar3;
        }
        inputMethodManager.showSoftInput(aVar2.f435865d, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void R1() {
        GameQAAioInputViewModel gameQAAioInputViewModel = this.mUIMode;
        if (gameQAAioInputViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIMode");
            gameQAAioInputViewModel = null;
        }
        AIOParam it = ((com.tencent.aio.api.runtime.a) gameQAAioInputViewModel.getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        ((IMsgService) QRoute.api(IMsgService.class)).getDraft(new Contact(com.tencent.guild.aio.util.a.e(it), it.r().c().j(), com.tencent.guild.aio.util.a.g(it)), new IGetDraftOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.k
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList, long j3) {
                GameQAAioInputViewBinder.T1(GameQAAioInputViewBinder.this, i3, str, arrayList, j3);
            }
        });
    }

    private final void S1(ArrayList<MsgElement> msgElements) {
        this.mGuildAtCluster.l(false);
        GuildDraftUtil guildDraftUtil = GuildDraftUtil.f112365a;
        td1.a aVar = this.mBinding;
        td1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        LinearLayout linearLayout = aVar.f435863b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
        td1.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar3 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = aVar3.f435865d;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        guildDraftUtil.c(msgElements, linearLayout, guildAIOInputEditText);
        this.mGuildAtCluster.l(true);
        td1.a aVar4 = this.mBinding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar4;
        }
        aVar2.f435865d.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(final GameQAAioInputViewBinder this$0, int i3, String str, ArrayList msgElements, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GameQAAioInputViewBinder", 1, "getDraft, result:" + i3 + ", errMsg:" + str + ", msgElements:" + msgElements);
        this$0.mGuildAtCluster.l(false);
        GuildDraftUtil guildDraftUtil = GuildDraftUtil.f112365a;
        Intrinsics.checkNotNullExpressionValue(msgElements, "msgElements");
        td1.a aVar = this$0.mBinding;
        td1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        LinearLayout linearLayout = aVar.f435863b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
        td1.a aVar3 = this$0.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar3 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = aVar3.f435865d;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        guildDraftUtil.c(msgElements, linearLayout, guildAIOInputEditText);
        this$0.mGuildAtCluster.l(true);
        td1.a aVar4 = this$0.mBinding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar4;
        }
        aVar2.f435865d.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.f
            @Override // java.lang.Runnable
            public final void run() {
                GameQAAioInputViewBinder.U1(GameQAAioInputViewBinder.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(GameQAAioInputViewBinder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void V1() {
        GameQAAioInputViewModel gameQAAioInputViewModel = this.mUIMode;
        e.ReplyData replyData = null;
        vn0.k kVar = null;
        if (gameQAAioInputViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUIMode");
            gameQAAioInputViewModel = null;
        }
        AIOParam it = ((com.tencent.aio.api.runtime.a) gameQAAioInputViewModel.getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Contact contact = new Contact(com.tencent.guild.aio.util.a.e(it), it.r().c().j(), com.tencent.guild.aio.util.a.g(it));
        com.tencent.guild.api.msg.service.l lVar = com.tencent.guild.api.msg.service.l.f112634a;
        lp0.a aVar = lp0.a.f415333a;
        com.tencent.guild.aio.util.e eVar = com.tencent.guild.aio.util.e.f112380a;
        td1.a aVar2 = this.mBinding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar2 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = aVar2.f435865d;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        List<e.InputSendTextIntent> a16 = eVar.a(guildAIOInputEditText);
        td1.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar3 = null;
        }
        LinearLayout linearLayout = aVar3.f435863b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
        Long l3 = iq0.a.l(linearLayout);
        if (l3 != null) {
            long longValue = l3.longValue();
            vn0.k kVar2 = this.guildAioReplyLayout;
            if (kVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
                kVar2 = null;
            }
            String obj = kVar2.f441969d.getText().toString();
            vn0.k kVar3 = this.guildAioReplyLayout;
            if (kVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            } else {
                kVar = kVar3;
            }
            replyData = new e.ReplyData(longValue, obj, kVar.f441970e.getText().toString());
        }
        ArrayList<MsgElement> a17 = lVar.a(aVar.e(new e.InputSendMultiTextIntent(a16, replyData)));
        if (a17.isEmpty()) {
            ((IMsgService) QRoute.api(IMsgService.class)).deleteDraft(contact, new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.l
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    GameQAAioInputViewBinder.W1(i3, str);
                }
            });
        } else {
            ((IMsgService) QRoute.api(IMsgService.class)).setDraft(contact, a17, new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.m
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    GameQAAioInputViewBinder.X1(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(int i3, String str) {
        QLog.i("GameQAAioInputViewBinder", 1, "deleteDraft, result:" + i3 + ", errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(int i3, String str) {
        QLog.i("GameQAAioInputViewBinder", 1, "saveDraft, result:" + i3 + ", errMsg:" + str);
    }

    private final void Y1(long delay) {
        td1.a aVar = this.mBinding;
        td1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        if (aVar.getRoot().getVisibility() != 0) {
            return;
        }
        if (delay > 0) {
            td1.a aVar3 = this.mBinding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                aVar2 = aVar3;
            }
            aVar2.f435865d.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.n
                @Override // java.lang.Runnable
                public final void run() {
                    GameQAAioInputViewBinder.this.Q1();
                }
            }, delay);
            return;
        }
        Q1();
    }

    static /* synthetic */ void Z1(GameQAAioInputViewBinder gameQAAioInputViewBinder, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        gameQAAioInputViewBinder.Y1(j3);
    }

    private final void a2() {
        td1.a aVar = this.mBinding;
        td1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        if (!TextUtils.isEmpty(String.valueOf(aVar.f435865d.getText()))) {
            td1.a aVar3 = this.mBinding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar3 = null;
            }
            aVar3.f435873l.setVisibility(8);
            td1.a aVar4 = this.mBinding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                aVar2 = aVar4;
            }
            aVar2.f435871j.setVisibility(0);
            return;
        }
        td1.a aVar5 = this.mBinding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar5 = null;
        }
        aVar5.f435873l.setVisibility(0);
        td1.a aVar6 = this.mBinding;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar6;
        }
        aVar2.f435871j.setVisibility(8);
    }

    private final void r1() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        td1.a aVar = this.mBinding;
        td1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        aVar.f435870i.measure(makeMeasureSpec, makeMeasureSpec);
        td1.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar3 = null;
        }
        int measuredWidth = ((getMContext().getResources().getDisplayMetrics().widthPixels - aVar3.f435870i.getMeasuredWidth()) - ViewUtils.dpToPx(16.0f)) / 2;
        if (measuredWidth < 0) {
            measuredWidth = 0;
        }
        MutliSeletedBottomLine mutliSeletedBottomLine = new MutliSeletedBottomLine(getMContext(), measuredWidth, false);
        MutliSeletedBottomLine mutliSeletedBottomLine2 = new MutliSeletedBottomLine(getMContext(), measuredWidth, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(measuredWidth, -2);
        layoutParams.addRule(9);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(measuredWidth, -2);
        layoutParams2.addRule(11);
        td1.a aVar4 = this.mBinding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar4 = null;
        }
        aVar4.f435866e.addView(mutliSeletedBottomLine, layoutParams);
        td1.a aVar5 = this.mBinding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar5;
        }
        aVar2.f435866e.addView(mutliSeletedBottomLine2, layoutParams2);
    }

    private final void s1(com.tencent.aio.data.msglist.a msgItem, td1.a binding) {
        List filterNotNull;
        String str = iq0.a.t(msgItem) + MsgSummary.STR_COLON;
        vn0.k kVar = this.guildAioReplyLayout;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar = null;
        }
        kVar.f441969d.setText(str);
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        ArrayList arrayList = new ArrayList();
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
        vn0.k kVar2 = this.guildAioReplyLayout;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar2 = null;
        }
        kVar2.f441970e.setText(iq0.a.p(arrayList, true, false, 4, null));
    }

    private final Bundle v1(p.a stateCmd) {
        td1.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        stateCmd.b(aVar.f435865d);
        return new Bundle();
    }

    private final void w1(GuildMsgItem msgItem) {
        if (com.tencent.guild.api.data.msglist.a.c(msgItem)) {
            go0.i.f402720a.g(msgItem, getMContext(), new b());
        } else {
            x1(msgItem);
        }
    }

    private final void y1(MsgRecord msgItem) {
        int i3;
        ArrayList<MsgElement> arrayList = msgItem.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.elements");
        S1(arrayList);
        td1.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        Editable text = aVar.f435865d.getText();
        if (text != null) {
            i3 = text.length();
        } else {
            i3 = 0;
        }
        td1.a aVar2 = this.mBinding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar2 = null;
        }
        aVar2.f435865d.setSelection(i3);
        Z1(this, 0L, 1, null);
    }

    private final void z1(final com.tencent.aio.data.msglist.a msgItem, boolean isInsertAt) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        td1.a aVar = this.mBinding;
        td1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        aVar.f435863b.setVisibility(0);
        vn0.k kVar = this.guildAioReplyLayout;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar = null;
        }
        kVar.f441968c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameQAAioInputViewBinder.A1(GameQAAioInputViewBinder.this, view);
            }
        });
        vn0.k kVar2 = this.guildAioReplyLayout;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar2 = null;
        }
        kVar2.getMContainer().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.aio.input.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameQAAioInputViewBinder.B1(GameQAAioInputViewBinder.this, msgItem, view);
            }
        });
        td1.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar3 = null;
        }
        s1(msgItem, aVar3);
        td1.a aVar4 = this.mBinding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar4 = null;
        }
        aVar4.f435863b.setTag(R.id.f73243t1, Long.valueOf(guildMsgItem.getMsgRecord().msgId));
        if (isInsertAt) {
            String str = guildMsgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
            String str2 = guildMsgItem.getMsgRecord().guildId;
            Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
            String u16 = iq0.a.u(str, str2);
            com.tencent.guild.aio.util.e eVar = com.tencent.guild.aio.util.e.f112380a;
            td1.a aVar5 = this.mBinding;
            if (aVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar5 = null;
            }
            Context context = aVar5.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
            td1.a aVar6 = this.mBinding;
            if (aVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                aVar2 = aVar6;
            }
            GuildAIOInputEditText guildAIOInputEditText = aVar2.f435865d;
            Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
            String str3 = guildMsgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
            com.tencent.guild.aio.util.e.i(eVar, context, guildAIOInputEditText, str3, u16, 0, 16, null);
        }
        Y1(100L);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: F1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GameQAAioInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GameQAAioInputUIState.KeyboardStatusChange) {
            C1(((GameQAAioInputUIState.KeyboardStatusChange) state).getShow());
            return;
        }
        if (state instanceof GameQAAioInputUIState.SessionInfoChange) {
            this.mSessionInfo = ((GameQAAioInputUIState.SessionInfoChange) state).getGameSessionInfo();
            return;
        }
        if (state instanceof GameQAAioInputUIState.GuideClearEditInput) {
            td1.a aVar = this.mBinding;
            td1.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar = null;
            }
            Editable text = aVar.f435865d.getText();
            if (text != null) {
                text.clear();
            }
            td1.a aVar3 = this.mBinding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                aVar2 = aVar3;
            }
            aVar2.f435863b.setVisibility(8);
            return;
        }
        if (state instanceof GameQAAioInputUIState.GuideInputReplyMsg) {
            GameQAAioInputUIState.GuideInputReplyMsg guideInputReplyMsg = (GameQAAioInputUIState.GuideInputReplyMsg) state;
            z1(guideInputReplyMsg.getMsg(), guideInputReplyMsg.getIsInsertAt());
            return;
        }
        if (state instanceof GameQAAioInputUIState.GuildMultiSelectModeChanged) {
            GameQAAioInputUIState.GuildMultiSelectModeChanged guildMultiSelectModeChanged = (GameQAAioInputUIState.GuildMultiSelectModeChanged) state;
            E1(guildMultiSelectModeChanged.getMode(), guildMultiSelectModeChanged.getIsJubao(), guildMultiSelectModeChanged.getIsShowInputBar());
            return;
        }
        if (state instanceof GameQAAioInputUIState.GuildMultiSelectCountChanged) {
            D1(((GameQAAioInputUIState.GuildMultiSelectCountChanged) state).getCount());
            return;
        }
        if (state instanceof GameQAAioInputUIState.AioFoldStart) {
            G1();
            return;
        }
        if (state instanceof GameQAAioInputUIState.GuildInputInsertAt) {
            w1(((GameQAAioInputUIState.GuildInputInsertAt) state).getMsg());
        } else if (state instanceof GameQAAioInputUIState.GuideInputRecallMsg) {
            y1(((GameQAAioInputUIState.GuideInputRecallMsg) state).getMsg());
        } else if (state instanceof GameQAAioInputUIState.GuildHandlePermissionsChange) {
            P1(((GameQAAioInputUIState.GuildHandlePermissionsChange) state).getPermissions());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        I1();
        H1();
        R1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof p.a) {
            return v1((p.a) stateCmd);
        }
        return new Bundle();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GameQAAioInputUIState>> getObserverStates() {
        List<Class<? extends GameQAAioInputUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GameQAAioInputUIState.KeyboardStatusChange.class, GameQAAioInputUIState.SessionInfoChange.class, GameQAAioInputUIState.GuideClearEditInput.class, GameQAAioInputUIState.GuideInputReplyMsg.class, GameQAAioInputUIState.GuildMultiSelectModeChanged.class, GameQAAioInputUIState.AioFoldStart.class, GameQAAioInputUIState.GuildInputInsertAt.class, GameQAAioInputUIState.GuideInputRecallMsg.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new GuildTextAioUserAvatarViewBinder());
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        td1.a g16 = td1.a.g(LayoutInflater.from(params.a()), params.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            Lay\u2026          false\n        )");
        this.mBinding = g16;
        td1.a aVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        vn0.k e16 = vn0.k.e(g16.getRoot());
        Intrinsics.checkNotNullExpressionValue(e16, "bind(mBinding.root)");
        this.guildAioReplyLayout = e16;
        td1.a aVar2 = this.mBinding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar2 = null;
        }
        this.mOriginalInputTextSize = aVar2.f435865d.getTextSize();
        td1.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar = aVar3;
        }
        FrameLayout root = aVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        td1.a aVar = this.mBinding;
        td1.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        aVar.f435865d.removeOnLayoutChangeListener(this.mLayoutListener);
        td1.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar3;
        }
        aVar2.f435865d.removeTextChangedListener(this.mTextWatcher);
        this.mGuildAtCluster.g();
        V1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: u1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<fo0.e, GameQAAioInputUIState> createVM() {
        GameQAAioInputViewModel gameQAAioInputViewModel = new GameQAAioInputViewModel();
        this.mUIMode = gameQAAioInputViewModel;
        return gameQAAioInputViewModel;
    }

    public final void x1(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        String str = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
        String str2 = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
        String u16 = iq0.a.u(str, str2);
        com.tencent.guild.aio.util.e eVar = com.tencent.guild.aio.util.e.f112380a;
        td1.a aVar = this.mBinding;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        Context context = aVar.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        td1.a aVar2 = this.mBinding;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar2 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = aVar2.f435865d;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        String str3 = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
        com.tencent.guild.aio.util.e.i(eVar, context, guildAIOInputEditText, str3, u16, 0, 16, null);
        Z1(this, 0L, 1, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/aio/input/GameQAAioInputViewBinder$c", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "editable", "afterTextChanged", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            String str;
            boolean equals$default;
            td1.a aVar = null;
            if (editable != null) {
                str = editable.toString();
            } else {
                str = null;
            }
            equals$default = StringsKt__StringsJVMKt.equals$default(str, "", false, 2, null);
            if (!equals$default) {
                td1.a aVar2 = GameQAAioInputViewBinder.this.mBinding;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    aVar = aVar2;
                }
                aVar.f435865d.setTextSize(0, GameQAAioInputViewBinder.this.mOriginalInputTextSize);
                return;
            }
            if (GameQAAioInputViewBinder.this.mHintTextSize > 0.0f) {
                td1.a aVar3 = GameQAAioInputViewBinder.this.mBinding;
                if (aVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    aVar = aVar3;
                }
                aVar.f435865d.setTextSize(0, GameQAAioInputViewBinder.this.mHintTextSize);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
        }
    }
}
