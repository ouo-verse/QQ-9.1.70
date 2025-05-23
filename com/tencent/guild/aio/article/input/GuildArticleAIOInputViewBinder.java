package com.tencent.guild.aio.article.input;

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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.article.input.GuildArticleAIOInputUIState;
import com.tencent.guild.aio.component.avatar.GuildAioUserAvatarViewBinder;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.guild.aio.input.realinput.t;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.guild.aio.input.widget.MutliSeletedBottomLine;
import com.tencent.guild.aio.util.GuildDraftUtil;
import com.tencent.guild.api.appsetting.IQQSetting;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.x;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import fo0.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
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
@Metadata(d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 x2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001yB\u0007\u00a2\u0006\u0004\bv\u0010wJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J \u0010\u0016\u001a\u00020\u00052\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0017H\u0002J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\rH\u0002J\b\u0010,\u001a\u00020\tH\u0002J\b\u0010-\u001a\u00020\u0005H\u0002J\u0012\u00100\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020.H\u0002J\b\u00101\u001a\u00020\u0005H\u0002J\u0018\u00104\u001a\u00020\u00052\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\u0017H\u0002J\b\u00105\u001a\u00020\u0005H\u0002J&\u0010;\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u000209\u0012\u0006\b\u0001\u0012\u00020:0\u0001082\u0006\u00107\u001a\u000206H\u0016J\u0016\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010<H\u0016J\u0010\u0010@\u001a\u0002062\u0006\u0010?\u001a\u00020>H\u0016J\b\u0010A\u001a\u00020\u0005H\u0016J\u0016\u0010C\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030B08H\u0016J\u0012\u0010F\u001a\u0004\u0018\u00010\u00102\u0006\u0010E\u001a\u00020DH\u0016J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010G\u001a\u00020\u0003H\u0016J\u000e\u0010I\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\"J\u000e\u0010J\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fJ\b\u0010K\u001a\u00020\u0005H\u0016J\b\u0010L\u001a\u00020\tH\u0016J\b\u0010N\u001a\u00020MH\u0016R\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010^\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010d\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010n\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010kR/\u0010u\u001a\u001d\u0012\u0013\u0012\u00110M\u00a2\u0006\f\bp\u0012\b\bq\u0012\u0004\b\b(r\u0012\u0004\u0012\u00020\u00050o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bs\u0010t\u00a8\u0006z"}, d2 = {"Lcom/tencent/guild/aio/article/input/GuildArticleAIOInputViewBinder;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/guild/aio/article/input/s;", "", "O1", "y1", "u1", "", "A1", "visibility", "c2", "", "emojiCode", "C1", "Landroid/os/Bundle;", "B1", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "Z1", "", "clickable", "i2", "isShowInputBar", "K1", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "N1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "F1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", Constants.BASE_IN_PLUGIN_ID, "clearReply", "w1", "isSelectMode", "J1", "count", "I1", "originHint", ICustomDataEditor.STRING_ARRAY_PARAM_2, "z1", "M1", "", "delay", "d2", "X1", AdMetricTag.EVENT_NAME, "isSoftKey", "Y1", "f2", "Landroid/view/View;", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", "x1", "Lcom/tencent/mvi/api/help/a;", "params", "onCreateView", "bindViewAndData", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "generateVBState", "state", "L1", "E1", "v1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "b", "Landroid/widget/EditText;", "g", "Lgo0/c;", "d", "Lgo0/c;", "mGuildAtCluster", "Lvn0/o;", "e", "Lvn0/o;", "mBinding", "Lvn0/k;", "f", "Lvn0/k;", "guildAioReplyLayout", "Landroid/text/TextWatcher;", tl.h.F, "Landroid/text/TextWatcher;", "mTextWatcher", "i", "Ljava/lang/String;", "mReplyHint", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mFirstAnimPlayed", "Landroid/view/View$OnLayoutChangeListener;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View$OnLayoutChangeListener;", "mEditOnLayoutListener", "Lcom/tencent/guild/aio/input/widget/MutliSeletedBottomLine;", "D", "Lcom/tencent/guild/aio/input/widget/MutliSeletedBottomLine;", "leftDotLine", "E", "rightDotLine", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "editText", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "onSendMsg", "<init>", "()V", "G", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildArticleAIOInputViewBinder extends com.tencent.aio.base.mvvm.a<fo0.e, GuildAioDefaultInputUIState> implements s {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private MutliSeletedBottomLine leftDotLine;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private MutliSeletedBottomLine rightDotLine;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private vn0.o mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private vn0.k guildAioReplyLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextWatcher mTextWatcher;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mFirstAnimPlayed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private go0.c mGuildAtCluster = new go0.c();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mReplyHint = "";

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final View.OnLayoutChangeListener mEditOnLayoutListener = new View.OnLayoutChangeListener() { // from class: com.tencent.guild.aio.article.input.m
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            GuildArticleAIOInputViewBinder.V1(GuildArticleAIOInputViewBinder.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
        }
    };

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Function1<EditText, Unit> onSendMsg = new Function1<EditText, Unit>() { // from class: com.tencent.guild.aio.article.input.GuildArticleAIOInputViewBinder$onSendMsg$1
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
            vn0.o oVar;
            vn0.k kVar;
            vn0.k kVar2;
            Intrinsics.checkNotNullParameter(it, "it");
            List<e.InputSendTextIntent> a16 = com.tencent.guild.aio.util.e.f112380a.a(it);
            oVar = GuildArticleAIOInputViewBinder.this.mBinding;
            vn0.k kVar3 = null;
            if (oVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                oVar = null;
            }
            LinearLayout linearLayout = oVar.f441985b;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
            Long l3 = iq0.a.l(linearLayout);
            if (l3 == null) {
                l3 = 0L;
            }
            long longValue = l3.longValue();
            kVar = GuildArticleAIOInputViewBinder.this.guildAioReplyLayout;
            if (kVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
                kVar = null;
            }
            String obj = kVar.f441969d.getText().toString();
            kVar2 = GuildArticleAIOInputViewBinder.this.guildAioReplyLayout;
            if (kVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            } else {
                kVar3 = kVar2;
            }
            GuildArticleAIOInputViewBinder.this.sendIntent(new e.InputSendMultiTextIntent(a16, new e.ReplyData(longValue, obj, kVar3.f441970e.getText().toString())));
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/article/input/GuildArticleAIOInputViewBinder$b", "Lgo0/f;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements go0.f {
        b() {
        }

        @Override // go0.f
        public void a(@NotNull GuildMsgItem msgItem) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            GuildArticleAIOInputViewBinder.this.E1(msgItem);
        }
    }

    private final int A1() {
        IQQGuildUIUtilApi iQQGuildUIUtilApi = (IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class);
        vn0.o oVar = this.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        return iQQGuildUIUtilApi.getScreenWidthForSplit(true, oVar.getRoot().getContext());
    }

    private final Bundle B1() {
        long j3;
        vn0.o oVar = this.mBinding;
        vn0.o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        Editable editableText = oVar.f441989f.getEditableText();
        vn0.o oVar3 = this.mBinding;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar3 = null;
        }
        String valueOf = String.valueOf(oVar3.f441989f.getText());
        vn0.k kVar = this.guildAioReplyLayout;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar = null;
        }
        String obj = kVar.f441969d.getText().toString();
        vn0.k kVar2 = this.guildAioReplyLayout;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar2 = null;
        }
        String obj2 = kVar2.f441970e.getText().toString();
        vn0.o oVar4 = this.mBinding;
        if (oVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            oVar2 = oVar4;
        }
        LinearLayout linearLayout = oVar2.f441985b;
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

    private final void C1(String emojiCode) {
        vn0.o oVar = this.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = oVar.f441989f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        int selectionStart = guildAIOInputEditText.getSelectionStart();
        int selectionEnd = guildAIOInputEditText.getSelectionEnd();
        if (selectionStart >= 0 && selectionEnd >= 0 && selectionEnd >= selectionStart) {
            guildAIOInputEditText.getEditableText().replace(selectionStart, selectionEnd, emojiCode);
            guildAIOInputEditText.requestFocus();
        }
    }

    private final void D1(GuildMsgItem msgItem) {
        if (com.tencent.guild.api.data.msglist.a.c(msgItem)) {
            go0.i.f402720a.g(msgItem, getMContext(), new b());
        } else {
            E1(msgItem);
        }
    }

    private final void F1(final com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        vn0.o oVar = this.mBinding;
        vn0.o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        oVar.f441985b.setVisibility(0);
        vn0.k kVar = this.guildAioReplyLayout;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar = null;
        }
        kVar.f441968c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.article.input.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildArticleAIOInputViewBinder.G1(GuildArticleAIOInputViewBinder.this, view);
            }
        });
        vn0.k kVar2 = this.guildAioReplyLayout;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar2 = null;
        }
        kVar2.getMContainer().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.article.input.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildArticleAIOInputViewBinder.H1(GuildArticleAIOInputViewBinder.this, msgItem, view);
            }
        });
        v1(msgItem);
        vn0.o oVar3 = this.mBinding;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar3 = null;
        }
        oVar3.f441985b.setTag(R.id.f73243t1, Long.valueOf(guildMsgItem.getMsgRecord().msgId));
        if (!msgItem.isSelf()) {
            GuildMsgItem guildMsgItem2 = (GuildMsgItem) msgItem;
            String str = guildMsgItem2.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
            String str2 = guildMsgItem2.getMsgRecord().guildId;
            Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
            String u16 = iq0.a.u(str, str2);
            com.tencent.guild.aio.util.e eVar = com.tencent.guild.aio.util.e.f112380a;
            vn0.o oVar4 = this.mBinding;
            if (oVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                oVar4 = null;
            }
            Context context = oVar4.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
            vn0.o oVar5 = this.mBinding;
            if (oVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                oVar2 = oVar5;
            }
            GuildAIOInputEditText guildAIOInputEditText = oVar2.f441989f;
            Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
            String str3 = guildMsgItem2.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
            com.tencent.guild.aio.util.e.i(eVar, context, guildAIOInputEditText, str3, u16, 0, 16, null);
        }
        d2(100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(GuildArticleAIOInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        vn0.o oVar = this$0.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        oVar.f441985b.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(GuildArticleAIOInputViewBinder this$0, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        this$0.sendIntent(new e.c((GuildMsgItem) msgItem));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I1(int count) {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        vn0.o oVar = this.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        TextView textView = oVar.f441993j;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = mobileQQ.getString(R.string.f139520bh);
        Intrinsics.checkNotNullExpressionValue(string, "app.getString(R.string.guild_aio_select_msg_count)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(count)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
    }

    private final void J1(boolean isSelectMode, boolean isShowInputBar) {
        vn0.o oVar = null;
        if (isSelectMode) {
            vn0.o oVar2 = this.mBinding;
            if (oVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                oVar2 = null;
            }
            oVar2.f441987d.setVisibility(8);
            vn0.o oVar3 = this.mBinding;
            if (oVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                oVar = oVar3;
            }
            oVar.f441990g.setVisibility(0);
            return;
        }
        if (isShowInputBar) {
            vn0.o oVar4 = this.mBinding;
            if (oVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                oVar4 = null;
            }
            oVar4.f441987d.setVisibility(0);
        }
        vn0.o oVar5 = this.mBinding;
        if (oVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            oVar = oVar5;
        }
        oVar.f441990g.setVisibility(8);
    }

    private final void K1(boolean isShowInputBar) {
        vn0.o oVar = null;
        if (isShowInputBar) {
            vn0.o oVar2 = this.mBinding;
            if (oVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                oVar2 = null;
            }
            oVar2.getRoot().setVisibility(0);
            vn0.o oVar3 = this.mBinding;
            if (oVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                oVar = oVar3;
            }
            oVar.f441987d.setVisibility(0);
            if (!this.mFirstAnimPlayed) {
                this.mFirstAnimPlayed = true;
                f2();
                return;
            }
            return;
        }
        vn0.o oVar4 = this.mBinding;
        if (oVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            oVar = oVar4;
        }
        oVar.f441987d.setVisibility(8);
    }

    private final void M1() {
        Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        vn0.o oVar = this.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        inputMethodManager.hideSoftInputFromWindow(oVar.f441989f.getWindowToken(), 0);
    }

    private final void N1(com.tencent.aio.api.runtime.a aioContext) {
        go0.c cVar = this.mGuildAtCluster;
        vn0.o oVar = this.mBinding;
        vn0.o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = oVar.f441989f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        vn0.o oVar3 = this.mBinding;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar3 = null;
        }
        ConstraintLayout constraintLayout = oVar3.f441987d;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "mBinding.guildAioInputBar");
        vn0.o oVar4 = this.mBinding;
        if (oVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            oVar2 = oVar4;
        }
        Context context = oVar2.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        cVar.h(guildAIOInputEditText, constraintLayout, context, g16, null, aioContext);
    }

    private final void O1() {
        vn0.o oVar = this.mBinding;
        vn0.o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        ConstraintLayout constraintLayout = oVar.f441987d;
        com.tencent.guild.aio.input.realinput.s sVar = com.tencent.guild.aio.input.realinput.s.f111173a;
        constraintLayout.setBackgroundResource(sVar.a());
        vn0.o oVar3 = this.mBinding;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar3 = null;
        }
        oVar3.f441989f.setTextColor(sVar.b(getMContext()));
        vn0.o oVar4 = this.mBinding;
        if (oVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar4 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = oVar4.f441989f;
        QRouteApi api = QRoute.api(IGuildEmojiApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildEmojiApi::class.java)");
        guildAIOInputEditText.setEditableFactory(IGuildEmojiApi.a.a((IGuildEmojiApi) api, 18, 0, 2, null));
        vn0.o oVar5 = this.mBinding;
        if (oVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar5 = null;
        }
        oVar5.f441989f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.article.input.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildArticleAIOInputViewBinder.P1(GuildArticleAIOInputViewBinder.this, view);
            }
        });
        vn0.o oVar6 = this.mBinding;
        if (oVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar6 = null;
        }
        oVar6.f441989f.setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.guild.aio.article.input.e
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                boolean Q1;
                Q1 = GuildArticleAIOInputViewBinder.Q1(GuildArticleAIOInputViewBinder.this, view, i3, keyEvent);
                return Q1;
            }
        });
        vn0.o oVar7 = this.mBinding;
        if (oVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar7 = null;
        }
        oVar7.f441994k.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.article.input.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildArticleAIOInputViewBinder.R1(GuildArticleAIOInputViewBinder.this, view);
            }
        });
        vn0.o oVar8 = this.mBinding;
        if (oVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar8 = null;
        }
        oVar8.f441989f.addOnLayoutChangeListener(this.mEditOnLayoutListener);
        vn0.o oVar9 = this.mBinding;
        if (oVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar9 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText2 = oVar9.f441989f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText2, "mBinding.guildAioInputEdittext");
        c cVar = new c();
        guildAIOInputEditText2.addTextChangedListener(cVar);
        this.mTextWatcher = cVar;
        vn0.o oVar10 = this.mBinding;
        if (oVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar10 = null;
        }
        oVar10.f441991h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.article.input.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildArticleAIOInputViewBinder.S1(GuildArticleAIOInputViewBinder.this, view);
            }
        });
        vn0.o oVar11 = this.mBinding;
        if (oVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar11 = null;
        }
        oVar11.f441992i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.article.input.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildArticleAIOInputViewBinder.T1(GuildArticleAIOInputViewBinder.this, view);
            }
        });
        vn0.o oVar12 = this.mBinding;
        if (oVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar12 = null;
        }
        oVar12.f441993j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.article.input.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildArticleAIOInputViewBinder.U1(GuildArticleAIOInputViewBinder.this, view);
            }
        });
        u1();
        com.tencent.guild.aio.util.g gVar = com.tencent.guild.aio.util.g.f112400a;
        vn0.o oVar13 = this.mBinding;
        if (oVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            oVar2 = oVar13;
        }
        GuildAIOInputEditText guildAIOInputEditText3 = oVar2.f441989f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText3, "mBinding.guildAioInputEdittext");
        gVar.c(guildAIOInputEditText3, new Function0<Unit>() { // from class: com.tencent.guild.aio.article.input.GuildArticleAIOInputViewBinder$initView$8
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
                Function1 function1;
                vn0.o oVar14;
                function1 = GuildArticleAIOInputViewBinder.this.onSendMsg;
                oVar14 = GuildArticleAIOInputViewBinder.this.mBinding;
                if (oVar14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    oVar14 = null;
                }
                GuildAIOInputEditText guildAIOInputEditText4 = oVar14.f441989f;
                Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText4, "mBinding.guildAioInputEdittext");
                function1.invoke(guildAIOInputEditText4);
                GuildArticleAIOInputViewBinder.this.Y1("dt_clck", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(GuildArticleAIOInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new e.b());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q1(GuildArticleAIOInputViewBinder this$0, View view, int i3, KeyEvent keyEvent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 67 && keyEvent.getAction() == 0) {
            vn0.o oVar = this$0.mBinding;
            vn0.o oVar2 = null;
            if (oVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                oVar = null;
            }
            Editable text = oVar.f441989f.getText();
            if (text != null && text.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                vn0.o oVar3 = this$0.mBinding;
                if (oVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    oVar2 = oVar3;
                }
                oVar2.f441985b.setVisibility(8);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(GuildArticleAIOInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<EditText, Unit> function1 = this$0.onSendMsg;
        vn0.o oVar = this$0.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = oVar.f441989f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        function1.invoke(guildAIOInputEditText);
        this$0.Y1("dt_clck", false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(GuildArticleAIOInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.h.f400143d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(GuildArticleAIOInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.j.f400145d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(GuildArticleAIOInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.q.f400159d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V1(final GuildArticleAIOInputViewBinder this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i17 - i3 != i27 - i19) {
            if (this$0.mReplyHint.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                vn0.o oVar = this$0.mBinding;
                if (oVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    oVar = null;
                }
                oVar.f441989f.post(new Runnable() { // from class: com.tencent.guild.aio.article.input.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildArticleAIOInputViewBinder.W1(GuildArticleAIOInputViewBinder.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(GuildArticleAIOInputViewBinder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a2(this$0.mReplyHint);
        vn0.o oVar = this$0.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        oVar.f441989f.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1() {
        vn0.o oVar = this.mBinding;
        vn0.o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        oVar.f441989f.requestFocus();
        Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        vn0.o oVar3 = this.mBinding;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            oVar2 = oVar3;
        }
        inputMethodManager.showSoftInput(oVar2.f441989f, 0);
        if (((IQQSetting) QRoute.api(IQQSetting.class)).isEnterSendMsg()) {
            Y1("dt_imp", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y1(String eventName, boolean isSoftKey) {
        String str;
        String str2;
        boolean z16;
        boolean z17;
        String str3;
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        com.tencent.aio.api.runtime.a aVar2;
        AIOParam g17;
        HashMap hashMap = new HashMap();
        FrameworkVM mUIModel = getMUIModel();
        Map<String, Object> map = null;
        if (mUIModel != null && (aVar2 = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && (g17 = aVar2.g()) != null) {
            str = com.tencent.guild.aio.util.a.g(g17);
        } else {
            str = null;
        }
        FrameworkVM mUIModel2 = getMUIModel();
        if (mUIModel2 != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel2.getMContext()) != null && (g16 = aVar.g()) != null) {
            str2 = com.tencent.guild.aio.util.a.b(g16);
        } else {
            str2 = null;
        }
        hashMap.put("dt_pgid", "pg_sgrp_aio");
        boolean z18 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str4 = "";
        if (z16) {
            str = "";
        }
        hashMap.put("sgrp_channel_id", str);
        if (str2 != null && str2.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            str4 = str2;
        }
        hashMap.put("sgrp_sub_channel_id", str4);
        if (isSoftKey) {
            str3 = "em_text_aio_key_send";
        } else {
            str3 = "em_text_aio_send";
        }
        hashMap.put("eid", str3);
        Map<String, Object> hashMap2 = new HashMap<>();
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo != null) {
            map = pageInfo.pageParams;
        }
        if (map != null) {
            hashMap2 = pageInfo.pageParams;
            Intrinsics.checkNotNullExpressionValue(hashMap2, "pageInfo.pageParams");
        } else {
            if (str2 == null || str2.length() == 0) {
                z18 = true;
            }
            if (!z18) {
                ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildBasePageParams(str2, hashMap2);
            }
        }
        hashMap.put("cur_pg", hashMap2);
        VideoReport.reportEvent(eventName, hashMap);
    }

    private final void Z1(ArrayList<MsgElement> msgElements) {
        this.mGuildAtCluster.l(false);
        GuildDraftUtil guildDraftUtil = GuildDraftUtil.f112365a;
        vn0.o oVar = this.mBinding;
        vn0.o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        LinearLayout linearLayout = oVar.f441985b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.aioReply");
        vn0.o oVar3 = this.mBinding;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar3 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = oVar3.f441989f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        guildDraftUtil.c(msgElements, linearLayout, guildAIOInputEditText);
        this.mGuildAtCluster.l(true);
        vn0.o oVar4 = this.mBinding;
        if (oVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            oVar2 = oVar4;
        }
        oVar2.f441989f.requestFocus();
        this.mGuildAtCluster.k();
    }

    private final void a2(String originHint) {
        String replace$default;
        this.mReplyHint = originHint;
        vn0.o oVar = this.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = oVar.f441989f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        String string = getMContext().getResources().getString(R.string.f139700bz);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.resources.getSt\u2026d_article_aio_input_hint)");
        int z16 = z1();
        replace$default = StringsKt__StringsJVMKt.replace$default(originHint, "\n", " ", false, 4, (Object) null);
        CharSequence ellipsize = TextUtils.ellipsize(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseQQText(string + replace$default, 18), guildAIOInputEditText.getPaint(), z16, TextUtils.TruncateAt.END);
        Intrinsics.checkNotNullExpressionValue(ellipsize, "ellipsize(hint, input.pa\u2026TextUtils.TruncateAt.END)");
        guildAIOInputEditText.setHint(ellipsize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2(int visibility) {
        vn0.o oVar = this.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        oVar.f441994k.setVisibility(visibility);
    }

    private final void d2(long delay) {
        vn0.o oVar = this.mBinding;
        vn0.o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        if (oVar.getRoot().getVisibility() == 0) {
            vn0.o oVar3 = this.mBinding;
            if (oVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                oVar3 = null;
            }
            if (oVar3.f441987d.getVisibility() == 0) {
                if (delay > 0) {
                    vn0.o oVar4 = this.mBinding;
                    if (oVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    } else {
                        oVar2 = oVar4;
                    }
                    oVar2.f441989f.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.article.input.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildArticleAIOInputViewBinder.this.X1();
                        }
                    }, delay);
                    return;
                }
                X1();
            }
        }
    }

    static /* synthetic */ void e2(GuildArticleAIOInputViewBinder guildArticleAIOInputViewBinder, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        guildArticleAIOInputViewBinder.d2(j3);
    }

    private final void f2() {
        vn0.o oVar = this.mBinding;
        vn0.o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        oVar.getRoot().setVisibility(0);
        vn0.o oVar3 = this.mBinding;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar3 = null;
        }
        oVar3.getRoot().setAlpha(0.0f);
        vn0.o oVar4 = this.mBinding;
        if (oVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            oVar2 = oVar4;
        }
        oVar2.getRoot().post(new Runnable() { // from class: com.tencent.guild.aio.article.input.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildArticleAIOInputViewBinder.g2(GuildArticleAIOInputViewBinder.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(final GuildArticleAIOInputViewBinder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        vn0.o oVar = this$0.mBinding;
        vn0.o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        int measuredHeight = oVar.getRoot().getMeasuredHeight();
        vn0.o oVar3 = this$0.mBinding;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar3 = null;
        }
        oVar3.getRoot().setTranslationY(measuredHeight);
        vn0.o oVar4 = this$0.mBinding;
        if (oVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            oVar2 = oVar4;
        }
        oVar2.getRoot().animate().translationYBy(-measuredHeight).alphaBy(1.0f).setDuration(500L).withStartAction(new Runnable() { // from class: com.tencent.guild.aio.article.input.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildArticleAIOInputViewBinder.h2(GuildArticleAIOInputViewBinder.this);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(GuildArticleAIOInputViewBinder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.i.f400144d);
    }

    private final void i2(boolean clickable) {
        vn0.o oVar = this.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        QUIButton qUIButton = oVar.f441994k;
        if (clickable) {
            qUIButton.setClickable(true);
            qUIButton.setAlpha(1.0f);
        } else {
            qUIButton.setClickable(false);
            qUIButton.setAlpha(0.5f);
        }
    }

    private final void u1() {
        vn0.o oVar = this.mBinding;
        vn0.o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        oVar.f441990g.removeView(this.leftDotLine);
        vn0.o oVar3 = this.mBinding;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar3 = null;
        }
        oVar3.f441990g.removeView(this.rightDotLine);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        vn0.o oVar4 = this.mBinding;
        if (oVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar4 = null;
        }
        oVar4.f441993j.measure(makeMeasureSpec, makeMeasureSpec);
        vn0.o oVar5 = this.mBinding;
        if (oVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar5 = null;
        }
        int A1 = ((A1() - oVar5.f441993j.getMeasuredWidth()) - x.c(getMContext(), 16.0f)) / 2;
        if (A1 < 0) {
            A1 = 0;
        }
        this.leftDotLine = new MutliSeletedBottomLine(getMContext(), A1, false);
        this.rightDotLine = new MutliSeletedBottomLine(getMContext(), A1, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(A1, -2);
        layoutParams.addRule(9);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(A1, -2);
        layoutParams2.addRule(11);
        vn0.o oVar6 = this.mBinding;
        if (oVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar6 = null;
        }
        oVar6.f441990g.addView(this.leftDotLine, layoutParams);
        vn0.o oVar7 = this.mBinding;
        if (oVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            oVar2 = oVar7;
        }
        oVar2.f441990g.addView(this.rightDotLine, layoutParams2);
    }

    private final void w1(boolean clearReply) {
        vn0.o oVar = this.mBinding;
        vn0.o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        oVar.f441989f.setText("");
        if (clearReply) {
            vn0.o oVar3 = this.mBinding;
            if (oVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                oVar2 = oVar3;
            }
            oVar2.f441985b.setVisibility(8);
        }
    }

    private final void y1() {
        this.mGuildAtCluster.g();
    }

    private final int z1() {
        vn0.o oVar = this.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        return oVar.f441989f.getMeasuredWidth() - (getMContext().getResources().getDimensionPixelSize(R.dimen.cck) + getMContext().getResources().getDimensionPixelSize(R.dimen.cci));
    }

    public final void E1(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        String str = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
        String str2 = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
        String u16 = iq0.a.u(str, str2);
        com.tencent.guild.aio.util.e eVar = com.tencent.guild.aio.util.e.f112380a;
        vn0.o oVar = this.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        Context context = oVar.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        vn0.o oVar2 = this.mBinding;
        if (oVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar2 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = oVar2.f441989f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        String str3 = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
        com.tencent.guild.aio.util.e.i(eVar, context, guildAIOInputEditText, str3, u16, 0, 16, null);
        e2(this, 0L, 1, null);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: L1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioDefaultInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioDefaultInputUIState.GuideInputHideState) {
            M1();
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuildShowKeyboard) {
            e2(this, 0L, 1, null);
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuideClearEditInput) {
            w1(((GuildAioDefaultInputUIState.GuideClearEditInput) state).getClearReply());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuideReplaceInputEmotion) {
            C1(((GuildAioDefaultInputUIState.GuideReplaceInputEmotion) state).getEmotionCode());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuildMultiSelectModeChanged) {
            GuildAioDefaultInputUIState.GuildMultiSelectModeChanged guildMultiSelectModeChanged = (GuildAioDefaultInputUIState.GuildMultiSelectModeChanged) state;
            J1(guildMultiSelectModeChanged.getMode(), guildMultiSelectModeChanged.getIsShowInputBar());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuildMultiSelectCountChanged) {
            I1(((GuildAioDefaultInputUIState.GuildMultiSelectCountChanged) state).getCount());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuildInputHint) {
            a2(((GuildAioDefaultInputUIState.GuildInputHint) state).getChannelName());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.InitAtCluster) {
            N1(((GuildAioDefaultInputUIState.InitAtCluster) state).getAioContext());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuideInputReplyMsg) {
            F1(((GuildAioDefaultInputUIState.GuideInputReplyMsg) state).getMsg());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuildInputInsertAt) {
            D1(((GuildAioDefaultInputUIState.GuildInputInsertAt) state).getMsg());
            return;
        }
        if (state instanceof GuildArticleAIOInputUIState.ShowInputBar) {
            K1(((GuildArticleAIOInputUIState.ShowInputBar) state).getIsShowInputBar());
        } else if (state instanceof GuildAioDefaultInputUIState.UpdateSendBtnClickable) {
            i2(((GuildAioDefaultInputUIState.UpdateSendBtnClickable) state).getClickable());
        } else if (state instanceof GuildAioDefaultInputUIState.RecoverDraft) {
            Z1(((GuildAioDefaultInputUIState.RecoverDraft) state).a());
        }
    }

    @Override // com.tencent.guild.aio.article.input.s
    public int b() {
        vn0.o oVar = this.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        return oVar.f441988e.getHeight();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        O1();
        sendIntent(e.f.f400141d);
    }

    @Override // com.tencent.guild.aio.article.input.s
    @NotNull
    public EditText g() {
        vn0.o oVar = this.mBinding;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = oVar.f441989f;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        return guildAIOInputEditText;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof t.a) {
            return B1();
        }
        return super.generateVBState(stateCmd);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildAioDefaultInputUIState>> getObserverStates() {
        List<Class<? extends GuildAioDefaultInputUIState>> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{GuildAioDefaultInputUIState.GuideInputHideState.class, GuildAioDefaultInputUIState.GuildShowKeyboard.class, GuildAioDefaultInputUIState.GuideClearEditInput.class, GuildAioDefaultInputUIState.GuideReplaceInputEmotion.class, GuildAioDefaultInputUIState.GuildMultiSelectModeChanged.class, GuildAioDefaultInputUIState.GuildMultiSelectCountChanged.class, GuildAioDefaultInputUIState.GuildInputHint.class, GuildAioDefaultInputUIState.InitAtCluster.class, GuildAioDefaultInputUIState.GuideInputReplyMsg.class, GuildAioDefaultInputUIState.GuildInputInsertAt.class, GuildArticleAIOInputUIState.ShowInputBar.class, GuildAioDefaultInputUIState.UpdateSendBtnClickable.class, GuildAioDefaultInputUIState.RecoverDraft.class});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> listOf;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new GuildAioUserAvatarViewBinder(), new tn0.c()});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        vn0.o g16 = vn0.o.g(LayoutInflater.from(params.a()), params.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, params.parent, false)");
        this.mBinding = g16;
        vn0.o oVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        vn0.k e16 = vn0.k.e(g16.getRoot());
        Intrinsics.checkNotNullExpressionValue(e16, "bind(mBinding.root)");
        this.guildAioReplyLayout = e16;
        vn0.o oVar2 = this.mBinding;
        if (oVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            oVar = oVar2;
        }
        FrameLayout root = oVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        y1();
        this.mReplyHint = "";
        vn0.o oVar = this.mBinding;
        vn0.o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            oVar = null;
        }
        oVar.f441989f.removeOnLayoutChangeListener(this.mEditOnLayoutListener);
        vn0.o oVar3 = this.mBinding;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            oVar2 = oVar3;
        }
        oVar2.f441989f.removeTextChangedListener(this.mTextWatcher);
    }

    public final void v1(@NotNull com.tencent.aio.data.msglist.a msgItem) {
        List filterNotNull;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        String str = iq0.a.t(msgItem) + MsgSummary.STR_COLON;
        vn0.k kVar = this.guildAioReplyLayout;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar = null;
        }
        kVar.f441969d.setText(str);
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

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<fo0.e, GuildAioDefaultInputUIState> getViewModel() {
        return new GuildArticleAIOInputViewModel(this);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            if (s16 == null || TextUtils.isEmpty(s16.toString())) {
                GuildArticleAIOInputViewBinder.this.c2(8);
            } else {
                GuildArticleAIOInputViewBinder.this.c2(0);
                GuildArticleAIOInputViewBinder.this.Y1("dt_imp", false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }
}
