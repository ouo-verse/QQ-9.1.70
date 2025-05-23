package com.tencent.guild.aio.input.realinput;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
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
import com.tencent.aio.base.route.msg.InputMsg$ShowKeyboardMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.component.avatar.GuildTextAioUserAvatarViewBinder;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.guild.aio.input.realinput.t;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.guild.aio.input.widget.MutliSeletedBottomLine;
import com.tencent.guild.aio.util.GuildDraftUtil;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.appsetting.IQQSetting;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.emoji.ISouGouEmoProxyApi;
import com.tencent.guild.api.input.GuildAioInputMsgIntent;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.service.QzoneBaseService;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.InputMethodUtil;
import fo0.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kr0.a;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ee\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0092\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002\u0093\u0001B\t\u00a2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u001c\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010 \u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u000fH\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0018\u0010&\u001a\u00020\t2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000fH\u0002J\u0010\u0010(\u001a\u00020\t2\u0006\u0010$\u001a\u00020'H\u0002J\u0018\u0010+\u001a\u00020\t2\u0006\u0010$\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000fH\u0002J\u0010\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020,H\u0002J$\u00101\u001a\u00020\t2\u0006\u0010-\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u00102\u001a\u00020\t2\u0006\u0010-\u001a\u00020,H\u0002J\u000e\u00104\u001a\u0004\u0018\u000103*\u00020,H\u0002J0\u00108\u001a\u00020\t2\u0006\u00105\u001a\u0002032\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\fH\u0002J(\u0010>\u001a\u00020\t2\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020:09j\b\u0012\u0004\u0012\u00020:`;2\u0006\u0010=\u001a\u00020\u000fH\u0002J\u0018\u0010A\u001a\u00020\t2\u0006\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u00020\u000fH\u0002J\u0018\u0010D\u001a\u00020\t2\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u000fH\u0002J\b\u0010E\u001a\u00020\fH\u0002J\u0010\u0010G\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u000fH\u0002J \u0010K\u001a\u00020\t2\u0006\u0010H\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\u000f2\u0006\u0010J\u001a\u00020\u000fH\u0002J\u0010\u0010M\u001a\u00020\t2\u0006\u0010L\u001a\u00020\fH\u0002J\u0016\u0010P\u001a\u00020\t2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00050NH\u0002J\b\u0010Q\u001a\u00020\tH\u0002J\u0012\u0010T\u001a\u00020\t2\b\b\u0002\u0010S\u001a\u00020RH\u0002J\b\u0010U\u001a\u00020\tH\u0002J\u0010\u0010W\u001a\u00020\t2\u0006\u0010V\u001a\u00020\u000fH\u0002J\b\u0010X\u001a\u00020\tH\u0002J&\u0010^\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\\\u0012\u0006\b\u0001\u0012\u00020]0\u00010[2\u0006\u0010Z\u001a\u00020YH\u0016J\u0014\u0010`\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030_H\u0016J\u0010\u0010c\u001a\u00020Y2\u0006\u0010b\u001a\u00020aH\u0016J\b\u0010d\u001a\u00020\tH\u0016J\u0016\u0010f\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030e0[H\u0016J\u0012\u0010i\u001a\u0004\u0018\u00010\u00072\u0006\u0010h\u001a\u00020gH\u0016J\u000e\u0010j\u001a\u00020\t2\u0006\u0010$\u001a\u00020'J\u0010\u0010l\u001a\u00020\t2\u0006\u0010k\u001a\u00020\u0003H\u0016J\b\u0010m\u001a\u00020\tH\u0016J\b\u0010n\u001a\u00020\fH\u0016J\b\u0010o\u001a\u000203H\u0016R\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010{\u001a\u00020x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010zR\u0018\u0010\u007f\u001a\u0004\u0018\u00010|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u0019\u0010\u0082\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0085\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008c\u0001\u00a8\u0006\u0094\u0001"}, d2 = {"Lcom/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewBinder;", "Lcom/tencent/aio/base/mvvm/a;", "Lfo0/e;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Lcom/tencent/guild/aio/input/realinput/u;", "", "action", "Landroid/os/Bundle;", "data", "", "g2", "O1", "", "selectMediaSize", "d2", "", "clickable", "r2", ICustomDataEditor.STRING_PARAM_1, "z1", "A1", "w1", "m2", "l2", "Lcom/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewBinder$Companion$InputMode;", "mode", "q2", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText;", "guildAioInputEdittext", ICustomDataEditor.STRING_ARRAY_PARAM_2, AdMetricTag.EVENT_NAME, "isSoftKey", "e2", "emojiCode", "B1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "isInsertAt", "F1", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "C1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "watcherSpecialSymbol", "E1", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "N1", "atTinyId", "atUserName", "p2", "j2", "Landroid/widget/EditText;", "x1", "editText", "nickname", "atType", "V1", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "checkHandleSpecialSymbol", "f2", "permissions", "needHide", "Z1", "channelName", "showRobotHint", SemanticAttributes.DbSystemValues.H2, "y1", "clearReply", "u1", "isSelectMode", "isJubao", "isShowInputBar", "J1", "count", "I1", "Lcom/tencent/aio/msgservice/j;", "resp", "K1", "M1", "", "delay", ICustomDataEditor.NUMBER_PARAM_2, "c2", ViewStickEventHelper.IS_SHOW, "i2", "Y1", "Landroid/view/View;", "hostView", "", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", "v1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "bindViewAndData", "Ljava/lang/Class;", "getObserverStates", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "generateVBState", Constants.BASE_IN_PLUGIN_ID, "state", "L1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "b", "g", "Lvn0/e;", "d", "Lvn0/e;", "mBinding", "Lvn0/k;", "e", "Lvn0/k;", "guildAioReplyLayout", "Lgo0/c;", "f", "Lgo0/c;", "mGuildAtCluster", "Landroid/text/TextWatcher;", tl.h.F, "Landroid/text/TextWatcher;", "mTextWatcher", "i", "Ljava/lang/String;", "mChannelName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mIsShowRobotHint", "Landroid/view/View$OnLayoutChangeListener;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View$OnLayoutChangeListener;", "mEditOnLayoutListener", "Lcom/tencent/guild/aio/input/widget/MutliSeletedBottomLine;", "D", "Lcom/tencent/guild/aio/input/widget/MutliSeletedBottomLine;", "leftDotLine", "E", "rightDotLine", "<init>", "()V", UserInfo.SEX_FEMALE, "Companion", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioDefaultInputViewBinder extends com.tencent.aio.base.mvvm.a<fo0.e, GuildAioDefaultInputUIState> implements u {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private MutliSeletedBottomLine leftDotLine;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private MutliSeletedBottomLine rightDotLine;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private vn0.e mBinding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private vn0.k guildAioReplyLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextWatcher mTextWatcher;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsShowRobotHint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private go0.c mGuildAtCluster = new go0.c();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mChannelName = "";

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final View.OnLayoutChangeListener mEditOnLayoutListener = new View.OnLayoutChangeListener() { // from class: com.tencent.guild.aio.input.realinput.b
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            GuildAioDefaultInputViewBinder.W1(GuildAioDefaultInputViewBinder.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
        }
    };

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f111130a;

        static {
            int[] iArr = new int[Companion.InputMode.values().length];
            try {
                iArr[Companion.InputMode.PLUS_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.InputMode.SEND_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f111130a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewBinder$b", "Lgo0/f;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements go0.f {
        b() {
        }

        @Override // go0.f
        public void a(@NotNull GuildMsgItem msgItem) {
            Intrinsics.checkNotNullParameter(msgItem, "msgItem");
            GuildAioDefaultInputViewBinder.this.D1(msgItem);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewBinder$c", "Lqp0/a;", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements qp0.a {
        c() {
        }

        @Override // qp0.a
        public void a() {
            GuildAioDefaultInputViewBinder.this.Y1();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/input/realinput/GuildAioDefaultInputViewBinder$e", "Lcom/tencent/guild/aio/input/widget/GuildAIOInputEditText$d;", "", "action", "Landroid/os/Bundle;", "data", "", "onPrivateIMECommand", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e implements GuildAIOInputEditText.d {
        e() {
        }

        @Override // com.tencent.guild.aio.input.widget.GuildAIOInputEditText.d
        public boolean onPrivateIMECommand(@Nullable String action, @Nullable Bundle data) {
            if (InputMethodUtil.checkSogouInputDefault(GuildAioDefaultInputViewBinder.this.getMContext())) {
                GuildAioDefaultInputViewBinder.this.g2(action, data);
                GuildAioDefaultInputViewBinder.this.sendIntent(new e.IMECommandIntent(action, data));
                return true;
            }
            return true;
        }
    }

    private final Bundle A1() {
        long j3;
        vn0.e eVar = this.mBinding;
        vn0.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        Editable editableText = eVar.f441937g.getEditableText();
        vn0.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        String valueOf = String.valueOf(eVar3.f441937g.getText());
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
        vn0.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar4;
        }
        LinearLayout linearLayout = eVar2.f441932b;
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

    private final void B1(String emojiCode) {
        vn0.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar.f441937g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        int selectionStart = guildAIOInputEditText.getSelectionStart();
        int selectionEnd = guildAIOInputEditText.getSelectionEnd();
        if (selectionStart >= 0 && selectionEnd >= 0 && selectionEnd >= selectionStart) {
            guildAIOInputEditText.getEditableText().replace(selectionStart, selectionEnd, emojiCode);
            guildAIOInputEditText.requestFocus();
        }
    }

    private final void C1(GuildMsgItem msgItem) {
        if (com.tencent.guild.api.data.msglist.a.c(msgItem)) {
            go0.i.f402720a.g(msgItem, getMContext(), new b());
        } else {
            D1(msgItem);
        }
    }

    private final void E1(MsgRecord msgItem, boolean watcherSpecialSymbol) {
        int i3;
        ArrayList<MsgElement> arrayList = msgItem.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.elements");
        f2(arrayList, watcherSpecialSymbol);
        vn0.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        Editable text = eVar.f441937g.getText();
        if (text != null) {
            i3 = text.length();
        } else {
            i3 = 0;
        }
        vn0.e eVar2 = this.mBinding;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar2 = null;
        }
        eVar2.f441937g.setSelection(i3);
        o2(this, 0L, 1, null);
    }

    private final void F1(final com.tencent.aio.data.msglist.a msgItem, boolean isInsertAt) {
        vn0.e eVar = this.mBinding;
        vn0.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        if (eVar.f441935e.getVisibility() != 0) {
            return;
        }
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        vn0.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        eVar3.f441932b.setVisibility(0);
        vn0.k kVar = this.guildAioReplyLayout;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildAioReplyLayout");
            kVar = null;
        }
        kVar.f441968c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.input.realinput.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildAioDefaultInputViewBinder.G1(GuildAioDefaultInputViewBinder.this, view);
            }
        });
        vn0.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar4 = null;
        }
        eVar4.f441932b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.input.realinput.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildAioDefaultInputViewBinder.H1(GuildAioDefaultInputViewBinder.this, msgItem, view);
            }
        });
        vn0.e eVar5 = this.mBinding;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar5 = null;
        }
        iq0.a.a(msgItem, eVar5);
        vn0.e eVar6 = this.mBinding;
        if (eVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar6 = null;
        }
        eVar6.f441932b.setTag(R.id.f73243t1, Long.valueOf(guildMsgItem.getMsgRecord().msgId));
        IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
        String str = guildMsgItem.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.channelId");
        String str2 = guildMsgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
        boolean isSelfGuest = iGuildChannelApi.isSelfGuest(str, str2);
        if (isInsertAt && !isSelfGuest) {
            String str3 = guildMsgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
            String str4 = guildMsgItem.getMsgRecord().guildId;
            Intrinsics.checkNotNullExpressionValue(str4, "msgItem.msgRecord.guildId");
            String u16 = iq0.a.u(str3, str4);
            com.tencent.guild.aio.util.e eVar7 = com.tencent.guild.aio.util.e.f112380a;
            vn0.e eVar8 = this.mBinding;
            if (eVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar8 = null;
            }
            Context context = eVar8.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
            vn0.e eVar9 = this.mBinding;
            if (eVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                eVar2 = eVar9;
            }
            GuildAIOInputEditText guildAIOInputEditText = eVar2.f441937g;
            Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
            String str5 = guildMsgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str5, "msgItem.msgRecord.senderUid");
            com.tencent.guild.aio.util.e.i(eVar7, context, guildAIOInputEditText, str5, u16, 0, 16, null);
        }
        n2(100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(GuildAioDefaultInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        vn0.e eVar = this$0.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f441932b.setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(GuildAioDefaultInputViewBinder this$0, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        this$0.sendIntent(new e.c((GuildMsgItem) msgItem));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I1(int count) {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        vn0.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        TextView textView = eVar.f441946p;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = mobileQQ.getString(R.string.f139520bh);
        Intrinsics.checkNotNullExpressionValue(string, "app.getString(R.string.guild_aio_select_msg_count)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(count)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format);
    }

    private final void J1(boolean isSelectMode, boolean isJubao, boolean isShowInputBar) {
        QLog.i("GuildAioDefaultInputViewBinder", 1, "handleMultiSelectModeChanged isSelectMode=" + isSelectMode + " isJubao=" + isJubao + " isShowInputBar=" + isShowInputBar);
        vn0.e eVar = null;
        if (isSelectMode) {
            vn0.e eVar2 = this.mBinding;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar2 = null;
            }
            eVar2.f441935e.setVisibility(8);
            vn0.e eVar3 = this.mBinding;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar3 = null;
            }
            eVar3.f441938h.setVisibility(0);
        } else {
            if (isShowInputBar) {
                vn0.e eVar4 = this.mBinding;
                if (eVar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    eVar4 = null;
                }
                eVar4.f441935e.setVisibility(0);
            }
            vn0.e eVar5 = this.mBinding;
            if (eVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar5 = null;
            }
            eVar5.f441938h.setVisibility(8);
        }
        if (isJubao) {
            vn0.e eVar6 = this.mBinding;
            if (eVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar6 = null;
            }
            eVar6.f441935e.setVisibility(8);
            vn0.e eVar7 = this.mBinding;
            if (eVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                eVar = eVar7;
            }
            eVar.f441938h.setVisibility(8);
        }
    }

    private final void K1(com.tencent.aio.msgservice.j<String> resp) {
        String string;
        boolean z16;
        if (resp.c() == 0) {
            return;
        }
        int c16 = resp.c();
        if (c16 != 100100 && c16 != 100308) {
            switch (c16) {
                case BusinessInfoCheckUpdateItem.UIAPPID_PUBLIC_ACCOUNT /* 104000 */:
                case BusinessInfoCheckUpdateItem.UIAPPID_PUBLIC_ACCOUNT_MESSAGE_POP /* 104001 */:
                    string = getMContext().getString(R.string.f158341pc);
                    Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(com.t\u2026sitor_no_permission_tips)");
                    break;
                case 104002:
                    string = getMContext().getString(R.string.f158291p8);
                    Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(com.t\u2026visitor_interactive_tips)");
                    break;
                case 104003:
                    string = getMContext().getString(R.string.f158271p6);
                    Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(com.t\u2026_visitor_freq_limit_tips)");
                    break;
                default:
                    String b16 = resp.b();
                    if (b16 != null && b16.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        string = getMContext().getString(R.string.f139240aq);
                        Intrinsics.checkNotNullExpressionValue(string, "{\n                    mC\u2026s_fail)\n                }");
                        break;
                    } else {
                        string = resp.b();
                        Intrinsics.checkNotNull(string);
                        break;
                    }
                    break;
            }
        } else {
            string = getMContext().getString(R.string.f156871ld);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(com.t\u2026d_slow_mode_exceed_limit)");
        }
        if (!TextUtils.isEmpty(string)) {
            QQToast.makeText(BaseApplication.getContext(), 1, string, 1).show();
        }
    }

    private final void M1() {
        vn0.e eVar = this.mBinding;
        vn0.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f441937g.clearFocus();
        Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        vn0.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar3;
        }
        inputMethodManager.hideSoftInputFromWindow(eVar2.f441937g.getWindowToken(), 0);
    }

    private final void N1(com.tencent.aio.api.runtime.a aioContext) {
        go0.c cVar = this.mGuildAtCluster;
        vn0.e eVar = this.mBinding;
        vn0.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar.f441937g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        vn0.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        ConstraintLayout constraintLayout = eVar3.f441935e;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "mBinding.guildAioInputBar");
        vn0.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar4;
        }
        Context context = eVar2.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        cVar.h(guildAIOInputEditText, constraintLayout, context, g16, new c(), aioContext);
    }

    private final void O1() {
        l2();
        vn0.e eVar = this.mBinding;
        vn0.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        ConstraintLayout constraintLayout = eVar.f441935e;
        s sVar = s.f111173a;
        constraintLayout.setBackgroundResource(sVar.a());
        vn0.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        eVar3.f441935e.setPadding(0, 0, 0, 0);
        vn0.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar4 = null;
        }
        eVar4.f441937g.setTextColor(sVar.b(getMContext()));
        vn0.e eVar5 = this.mBinding;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar5 = null;
        }
        eVar5.f441937g.getInputExtras(true).putInt(InputMethodUtil.FLAG_SOGOU_EXPRESSION, 1);
        vn0.e eVar6 = this.mBinding;
        if (eVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar6 = null;
        }
        eVar6.f441937g.getInputExtras(true).putInt(InputMethodUtil.SOGOU_EXPRESSION_WEBP, 1);
        vn0.e eVar7 = this.mBinding;
        if (eVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar7 = null;
        }
        eVar7.f441937g.getInputExtras(true).putInt(InputMethodUtil.SUPPORT_SOGOU_EXPRESSION, 1);
        vn0.e eVar8 = this.mBinding;
        if (eVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar8 = null;
        }
        eVar8.f441937g.setOnPrivateIMECommandListener(new e());
        vn0.e eVar9 = this.mBinding;
        if (eVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar9 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar9.f441937g;
        QRouteApi api = QRoute.api(IGuildEmojiApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildEmojiApi::class.java)");
        guildAIOInputEditText.setEditableFactory(IGuildEmojiApi.a.a((IGuildEmojiApi) api, 18, 0, 2, null));
        vn0.e eVar10 = this.mBinding;
        if (eVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar10 = null;
        }
        eVar10.f441937g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.input.realinput.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildAioDefaultInputViewBinder.P1(GuildAioDefaultInputViewBinder.this, view);
            }
        });
        vn0.e eVar11 = this.mBinding;
        if (eVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar11 = null;
        }
        eVar11.f441937g.setOnKeyListener(new View.OnKeyListener() { // from class: com.tencent.guild.aio.input.realinput.d
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i3, KeyEvent keyEvent) {
                boolean Q1;
                Q1 = GuildAioDefaultInputViewBinder.Q1(GuildAioDefaultInputViewBinder.this, view, i3, keyEvent);
                return Q1;
            }
        });
        vn0.e eVar12 = this.mBinding;
        if (eVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar12 = null;
        }
        eVar12.f441947q.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.input.realinput.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildAioDefaultInputViewBinder.R1(GuildAioDefaultInputViewBinder.this, view);
            }
        });
        vn0.e eVar13 = this.mBinding;
        if (eVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar13 = null;
        }
        eVar13.f441937g.addOnLayoutChangeListener(this.mEditOnLayoutListener);
        vn0.e eVar14 = this.mBinding;
        if (eVar14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar14 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText2 = eVar14.f441937g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText2, "mBinding.guildAioInputEdittext");
        d dVar = new d();
        guildAIOInputEditText2.addTextChangedListener(dVar);
        this.mTextWatcher = dVar;
        sendIntent(e.i.f400144d);
        vn0.e eVar15 = this.mBinding;
        if (eVar15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar15 = null;
        }
        eVar15.f441944n.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.input.realinput.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildAioDefaultInputViewBinder.S1(GuildAioDefaultInputViewBinder.this, view);
            }
        });
        vn0.e eVar16 = this.mBinding;
        if (eVar16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar16 = null;
        }
        eVar16.f441945o.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.input.realinput.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildAioDefaultInputViewBinder.T1(GuildAioDefaultInputViewBinder.this, view);
            }
        });
        s1();
        vn0.e eVar17 = this.mBinding;
        if (eVar17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar17 = null;
        }
        eVar17.f441946p.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.input.realinput.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildAioDefaultInputViewBinder.U1(GuildAioDefaultInputViewBinder.this, view);
            }
        });
        com.tencent.guild.aio.util.g gVar = com.tencent.guild.aio.util.g.f112400a;
        vn0.e eVar18 = this.mBinding;
        if (eVar18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar18;
        }
        GuildAIOInputEditText guildAIOInputEditText3 = eVar2.f441937g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText3, "mBinding.guildAioInputEdittext");
        gVar.c(guildAIOInputEditText3, new Function0<Unit>() { // from class: com.tencent.guild.aio.input.realinput.GuildAioDefaultInputViewBinder$initView$9
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
                vn0.e eVar19;
                GuildAioDefaultInputViewBinder guildAioDefaultInputViewBinder = GuildAioDefaultInputViewBinder.this;
                eVar19 = guildAioDefaultInputViewBinder.mBinding;
                if (eVar19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    eVar19 = null;
                }
                GuildAIOInputEditText guildAIOInputEditText4 = eVar19.f441937g;
                Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText4, "mBinding.guildAioInputEdittext");
                guildAioDefaultInputViewBinder.a2(guildAIOInputEditText4);
                GuildAioDefaultInputViewBinder.this.e2("dt_clck", true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(GuildAioDefaultInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(new e.b());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q1(GuildAioDefaultInputViewBinder this$0, View view, int i3, KeyEvent keyEvent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 67 && keyEvent.getAction() == 0) {
            vn0.e eVar = this$0.mBinding;
            vn0.e eVar2 = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar = null;
            }
            Editable text = eVar.f441937g.getText();
            if (text != null && text.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                vn0.e eVar3 = this$0.mBinding;
                if (eVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    eVar2 = eVar3;
                }
                eVar2.f441932b.setVisibility(8);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(GuildAioDefaultInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        vn0.e eVar = this$0.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar.f441937g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        this$0.a2(guildAIOInputEditText);
        this$0.e2("dt_clck", false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(GuildAioDefaultInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.h.f400143d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(GuildAioDefaultInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.j.f400145d);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(GuildAioDefaultInputViewBinder this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendIntent(e.q.f400159d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void V1(EditText editText, com.tencent.aio.api.runtime.a aioContext, String atTinyId, String nickname, int atType) {
        editText.getEditableText().clear();
        SpannableString p16 = com.tencent.guild.aio.input.at.utils.b.p(aioContext.c().requireContext(), atTinyId, nickname, nickname, editText, 0, false, atType);
        if (p16 == null) {
            return;
        }
        editText.getEditableText().insert(editText.getSelectionStart(), p16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(final GuildAioDefaultInputViewBinder this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i17 - i3 != i27 - i19) {
            if (this$0.mChannelName.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                vn0.e eVar = this$0.mBinding;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    eVar = null;
                }
                eVar.f441937g.post(new Runnable() { // from class: com.tencent.guild.aio.input.realinput.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildAioDefaultInputViewBinder.X1(GuildAioDefaultInputViewBinder.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(GuildAioDefaultInputViewBinder this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h2(this$0.mChannelName, this$0.mIsShowRobotHint);
        vn0.e eVar = this$0.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f441937g.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y1() {
        sendIntent(e.a.f400136d);
    }

    private final void Z1(int permissions, boolean needHide) {
        String str;
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        FrameworkVM mUIModel = getMUIModel();
        vn0.e eVar = null;
        if (mUIModel != null && (aVar = (com.tencent.aio.api.runtime.a) mUIModel.getMContext()) != null && (g16 = aVar.g()) != null) {
            str = com.tencent.guild.aio.util.a.g(g16);
        } else {
            str = null;
        }
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        boolean d16 = companion.d(permissions, str);
        boolean r16 = companion.r(permissions);
        QLog.i("GuildAioDefaultInputViewBinder", 1, "onPermissionChange inInputMode=" + d16 + " needHide=" + needHide + " isGuest=" + r16);
        this.mGuildAtCluster.l(r16 ^ true);
        if (d16 && !needHide && !r16) {
            vn0.e eVar2 = this.mBinding;
            if (eVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar2 = null;
            }
            eVar2.f441935e.setVisibility(0);
        } else {
            vn0.e eVar3 = this.mBinding;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar3 = null;
            }
            eVar3.f441935e.setVisibility(8);
            M1();
        }
        if (!d16) {
            vn0.e eVar4 = this.mBinding;
            if (eVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                eVar = eVar4;
            }
            eVar.f441932b.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2(GuildAIOInputEditText guildAioInputEdittext) {
        if (((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("GuildAioDefaultInputViewBinder")) {
            return;
        }
        List<e.InputSendTextIntent> a16 = com.tencent.guild.aio.util.e.f112380a.a(guildAioInputEdittext);
        QLog.i("GuildAioDefaultInputViewBinder", 1, "onSendMsg. listSize: " + a16.size());
        vn0.e eVar = this.mBinding;
        e.ReplyData replyData = null;
        vn0.k kVar = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        LinearLayout linearLayout = eVar.f441932b;
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
        sendIntent(new e.InputSendMultiTextIntent(a16, replyData));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2() {
        vn0.e eVar = this.mBinding;
        vn0.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f441937g.requestFocus();
        Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        vn0.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar3;
        }
        inputMethodManager.showSoftInput(eVar2.f441937g, 0);
        if (((IQQSetting) QRoute.api(IQQSetting.class)).isEnterSendMsg()) {
            e2("dt_imp", true);
        }
    }

    private final void d2(int selectMediaSize) {
        boolean z16;
        vn0.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        Editable text = eVar.f441937g.getText();
        if (text != null && !StringsKt.isBlank(text)) {
            z16 = false;
        } else {
            z16 = true;
        }
        QLog.i("GuildAioDefaultInputViewBinder", 1, "refreshSendBtn selectMediaSize=" + selectMediaSize + " isEmpty=" + z16);
        if (z16 && selectMediaSize == 0) {
            l2();
        } else {
            m2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2(String eventName, boolean isSoftKey) {
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

    private final void f2(ArrayList<MsgElement> msgElements, boolean checkHandleSpecialSymbol) {
        this.mGuildAtCluster.l(false);
        GuildDraftUtil guildDraftUtil = GuildDraftUtil.f112365a;
        vn0.e eVar = this.mBinding;
        vn0.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        guildDraftUtil.b(msgElements, eVar);
        this.mGuildAtCluster.l(checkHandleSpecialSymbol);
        this.mGuildAtCluster.k();
        vn0.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar3;
        }
        eVar2.f441937g.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2(String action, Bundle data) {
        String str;
        InputMethodManager inputMethodManager;
        if (Intrinsics.areEqual(InputMethodUtil.ACTION_SOGOU_APP_ID, action)) {
            vn0.e eVar = null;
            if (data != null) {
                str = data.getString(InputMethodUtil.KEY_SOGOU_APP_ID);
            } else {
                str = null;
            }
            String openId = ((ISouGouEmoProxyApi) QRoute.api(ISouGouEmoProxyApi.class)).getOpenId(getMContext(), str);
            Object systemService = getMContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (systemService instanceof InputMethodManager) {
                inputMethodManager = (InputMethodManager) systemService;
            } else {
                inputMethodManager = null;
            }
            Bundle bundle = new Bundle();
            bundle.putString(InputMethodUtil.KEY_SOGOU_OPEN_ID, openId);
            if (inputMethodManager != null) {
                vn0.e eVar2 = this.mBinding;
                if (eVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    eVar = eVar2;
                }
                inputMethodManager.sendAppPrivateCommand(eVar.f441937g, InputMethodUtil.ACTION_SOGOU_OPEN_ID, bundle);
            }
        }
    }

    private final void h2(String channelName, boolean showRobotHint) {
        this.mChannelName = channelName;
        this.mIsShowRobotHint = showRobotHint;
        vn0.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar.f441937g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        int y16 = y1();
        if (this.mIsShowRobotHint) {
            String string = getMContext().getResources().getString(R.string.f146750v1);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.resources.getSt\u2026_input_hint_wakeup_robot)");
            guildAIOInputEditText.setHint(TextUtils.ellipsize(string, guildAIOInputEditText.getPaint(), y16, TextUtils.TruncateAt.END));
        } else {
            String string2 = getMContext().getResources().getString(R.string.f139210an);
            Intrinsics.checkNotNullExpressionValue(string2, "mContext.resources.getSt\u2026ing.guild_aio_input_hint)");
            guildAIOInputEditText.setHint(UIUtil.q(UIUtil.f112434a, guildAIOInputEditText, y16, string2, channelName, null, 16, null));
        }
    }

    private final void i2(boolean isShow) {
        this.mGuildAtCluster.m(isShow);
        o2(this, 0L, 1, null);
    }

    private final void j2(final com.tencent.aio.api.runtime.a aioContext) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.guild.aio.input.realinput.j
            @Override // java.lang.Runnable
            public final void run() {
                GuildAioDefaultInputViewBinder.k2(com.tencent.aio.api.runtime.a.this);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "$aioContext");
        aioContext.e().h(new InputMsg$ShowKeyboardMsg());
    }

    private final void l2() {
        vn0.e eVar = this.mBinding;
        vn0.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f441939i.setVisibility(0);
        vn0.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar3;
        }
        eVar2.f441947q.setVisibility(8);
        q2(Companion.InputMode.PLUS_MODE);
    }

    private final void m2() {
        vn0.e eVar = this.mBinding;
        vn0.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f441947q.setVisibility(0);
        vn0.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar3;
        }
        eVar2.f441939i.setVisibility(8);
        q2(Companion.InputMode.SEND_MODE);
        e2("dt_imp", false);
    }

    private final void n2(long delay) {
        vn0.e eVar = this.mBinding;
        vn0.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        if (eVar.getRoot().getVisibility() == 0) {
            vn0.e eVar3 = this.mBinding;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                eVar3 = null;
            }
            if (eVar3.f441935e.getVisibility() == 0) {
                if (delay > 0) {
                    vn0.e eVar4 = this.mBinding;
                    if (eVar4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    } else {
                        eVar2 = eVar4;
                    }
                    eVar2.f441937g.postDelayed(new Runnable() { // from class: com.tencent.guild.aio.input.realinput.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildAioDefaultInputViewBinder.this.c2();
                        }
                    }, delay);
                    return;
                }
                c2();
                return;
            }
        }
        QLog.d("GuildAioDefaultInputViewBinder", 2, "realShowSoftInput input is invisible");
    }

    static /* synthetic */ void o2(GuildAioDefaultInputViewBinder guildAioDefaultInputViewBinder, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        guildAioDefaultInputViewBinder.n2(j3);
    }

    private final void p2(com.tencent.aio.api.runtime.a aioContext, String atTinyId, String atUserName) {
        Bundle l3;
        Bundle l16;
        AIOParam g16 = aioContext.g();
        if (g16 != null && (l16 = g16.l()) != null) {
            l16.putString("atTinyid", null);
        }
        EditText x16 = x1(aioContext);
        if (x16 == null) {
            return;
        }
        if (atTinyId != null && atUserName != null) {
            V1(x16, aioContext, atTinyId, atUserName, 2);
            j2(aioContext);
            m2();
            return;
        }
        AIOParam g17 = aioContext.g();
        boolean z16 = false;
        if (g17 != null && (l3 = g17.l()) != null && l3.getBoolean("showKeyboard")) {
            z16 = true;
        }
        if (z16) {
            j2(aioContext);
        }
    }

    private final void q2(Companion.InputMode mode) {
        int i3 = a.f111130a[mode.ordinal()];
        vn0.e eVar = null;
        if (i3 != 1) {
            if (i3 == 2) {
                vn0.e eVar2 = this.mBinding;
                if (eVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    eVar = eVar2;
                }
                GuildAIOInputEditText guildAIOInputEditText = eVar.f441937g;
                Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
                ViewExtKt.e(guildAIOInputEditText, 0);
                return;
            }
            return;
        }
        int dimensionPixelSize = getMContext().getResources().getDimensionPixelSize(R.dimen.cck) - getMContext().getResources().getDimensionPixelSize(R.dimen.ccb);
        int dimensionPixelSize2 = getMContext().getResources().getDimensionPixelSize(R.dimen.cci) - getMContext().getResources().getDimensionPixelSize(R.dimen.ccf);
        vn0.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar = eVar3;
        }
        GuildAIOInputEditText guildAIOInputEditText2 = eVar.f441937g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText2, "mBinding.guildAioInputEdittext");
        ViewExtKt.e(guildAIOInputEditText2, dimensionPixelSize + dimensionPixelSize2);
    }

    private final void r2(boolean clickable) {
        vn0.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        QUIButton qUIButton = eVar.f441947q;
        if (clickable) {
            qUIButton.setClickable(true);
            qUIButton.setAlpha(1.0f);
        } else {
            qUIButton.setClickable(false);
            qUIButton.setAlpha(0.5f);
        }
    }

    private final void s1() {
        vn0.e eVar = this.mBinding;
        vn0.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f441938h.removeView(this.leftDotLine);
        vn0.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        eVar3.f441938h.removeView(this.rightDotLine);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        vn0.e eVar4 = this.mBinding;
        if (eVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar4 = null;
        }
        eVar4.f441946p.measure(makeMeasureSpec, makeMeasureSpec);
        vn0.e eVar5 = this.mBinding;
        if (eVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar5 = null;
        }
        int z16 = ((z1() - eVar5.f441946p.getMeasuredWidth()) - x.c(getMContext(), 16.0f)) / 2;
        if (z16 < 0) {
            z16 = 0;
        }
        this.leftDotLine = new MutliSeletedBottomLine(getMContext(), z16, false);
        this.rightDotLine = new MutliSeletedBottomLine(getMContext(), z16, true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(z16, -2);
        layoutParams.addRule(9);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(z16, -2);
        layoutParams2.addRule(11);
        vn0.e eVar6 = this.mBinding;
        if (eVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar6 = null;
        }
        eVar6.f441938h.addView(this.leftDotLine, layoutParams);
        vn0.e eVar7 = this.mBinding;
        if (eVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar7;
        }
        eVar2.f441938h.addView(this.rightDotLine, layoutParams2);
    }

    private final void u1(boolean clearReply) {
        vn0.e eVar = this.mBinding;
        vn0.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f441937g.setText("");
        if (clearReply) {
            vn0.e eVar3 = this.mBinding;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                eVar2 = eVar3;
            }
            eVar2.f441932b.setVisibility(8);
        }
        sendIntent(e.o.f400155d);
    }

    private final void w1() {
        this.mGuildAtCluster.g();
    }

    private final EditText x1(com.tencent.aio.api.runtime.a aVar) {
        a.C10677a c10677a;
        com.tencent.mvi.base.route.k k3 = aVar.e().k(new GuildAioInputMsgIntent.GetInputEditTextEventR());
        if (k3 instanceof a.C10677a) {
            c10677a = (a.C10677a) k3;
        } else {
            c10677a = null;
        }
        if (c10677a == null) {
            return null;
        }
        return c10677a.getInput();
    }

    private final int y1() {
        vn0.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        return eVar.f441937g.getMeasuredWidth() - (getMContext().getResources().getDimensionPixelSize(R.dimen.cck) - getMContext().getResources().getDimensionPixelSize(R.dimen.ccb));
    }

    private final int z1() {
        IQQGuildUIUtilApi iQQGuildUIUtilApi = (IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class);
        vn0.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        return iQQGuildUIUtilApi.getScreenWidthForSplit(true, eVar.getRoot().getContext());
    }

    public final void D1(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        String str = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
        String str2 = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.guildId");
        String u16 = iq0.a.u(str, str2);
        com.tencent.guild.aio.util.e eVar = com.tencent.guild.aio.util.e.f112380a;
        vn0.e eVar2 = this.mBinding;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar2 = null;
        }
        Context context = eVar2.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mBinding.root.context");
        vn0.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar3 = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar3.f441937g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        String str3 = msgItem.getMsgRecord().senderUid;
        Intrinsics.checkNotNullExpressionValue(str3, "msgItem.msgRecord.senderUid");
        com.tencent.guild.aio.util.e.i(eVar, context, guildAIOInputEditText, str3, u16, 0, 16, null);
        o2(this, 0L, 1, null);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: L1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull GuildAioDefaultInputUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildAioDefaultInputUIState.GuildInputHint) {
            GuildAioDefaultInputUIState.GuildInputHint guildInputHint = (GuildAioDefaultInputUIState.GuildInputHint) state;
            h2(guildInputHint.getChannelName(), guildInputHint.getShowRobotHint());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuideInputHideState) {
            M1();
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuildInputDismissPanel) {
            this.mGuildAtCluster.n();
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.NotifyAtClusterAioOpened) {
            this.mGuildAtCluster.j();
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuildShowKeyboard) {
            o2(this, 0L, 1, null);
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuideClearEditInput) {
            u1(((GuildAioDefaultInputUIState.GuideClearEditInput) state).getClearReply());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuideReplaceInputEmotion) {
            B1(((GuildAioDefaultInputUIState.GuideReplaceInputEmotion) state).getEmotionCode());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuideInputReplyMsg) {
            GuildAioDefaultInputUIState.GuideInputReplyMsg guideInputReplyMsg = (GuildAioDefaultInputUIState.GuideInputReplyMsg) state;
            F1(guideInputReplyMsg.getMsg(), guideInputReplyMsg.getIsInsertAt());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuildInputInsertAt) {
            C1(((GuildAioDefaultInputUIState.GuildInputInsertAt) state).getMsg());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuideInputRecallMsg) {
            GuildAioDefaultInputUIState.GuideInputRecallMsg guideInputRecallMsg = (GuildAioDefaultInputUIState.GuideInputRecallMsg) state;
            E1(guideInputRecallMsg.getMsg(), guideInputRecallMsg.getProcessSpecialSymbol());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuildMultiSelectModeChanged) {
            GuildAioDefaultInputUIState.GuildMultiSelectModeChanged guildMultiSelectModeChanged = (GuildAioDefaultInputUIState.GuildMultiSelectModeChanged) state;
            J1(guildMultiSelectModeChanged.getMode(), guildMultiSelectModeChanged.getIsJubao(), guildMultiSelectModeChanged.getIsShowInputBar());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuildMultiSelectCountChanged) {
            I1(((GuildAioDefaultInputUIState.GuildMultiSelectCountChanged) state).getCount());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuildConfigurationChanged) {
            s1();
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuildSendResp) {
            K1(((GuildAioDefaultInputUIState.GuildSendResp) state).a());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.GuildHandlerPermissionsChange) {
            GuildAioDefaultInputUIState.GuildHandlerPermissionsChange guildHandlerPermissionsChange = (GuildAioDefaultInputUIState.GuildHandlerPermissionsChange) state;
            Z1(guildHandlerPermissionsChange.getPermissions(), guildHandlerPermissionsChange.getNeedHide());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.RecoverDraft) {
            GuildAioDefaultInputUIState.RecoverDraft recoverDraft = (GuildAioDefaultInputUIState.RecoverDraft) state;
            f2(recoverDraft.a(), recoverDraft.getProcessSpecialSymbol());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.RefreshSendBtn) {
            d2(((GuildAioDefaultInputUIState.RefreshSendBtn) state).getSelectedMediaCount());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.InitAtCluster) {
            N1(((GuildAioDefaultInputUIState.InitAtCluster) state).getAioContext());
            return;
        }
        if (state instanceof GuildAioDefaultInputUIState.UpdateAtInfo) {
            GuildAioDefaultInputUIState.UpdateAtInfo updateAtInfo = (GuildAioDefaultInputUIState.UpdateAtInfo) state;
            p2(updateAtInfo.getAioContext(), updateAtInfo.getAtTinyId(), updateAtInfo.getAtUserName());
        } else if (state instanceof GuildAioDefaultInputUIState.UpdateSendBtnClickable) {
            r2(((GuildAioDefaultInputUIState.UpdateSendBtnClickable) state).getClickable());
        } else if (state instanceof GuildAioDefaultInputUIState.GuildAtStateEvent.ShowHashtagPanel) {
            i2(((GuildAioDefaultInputUIState.GuildAtStateEvent.ShowHashtagPanel) state).getCom.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper.IS_SHOW java.lang.String());
        }
    }

    @Override // com.tencent.guild.aio.input.realinput.u
    public int b() {
        vn0.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        return eVar.f441936f.getHeight();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        super.bindViewAndData();
        O1();
        sendIntent(e.f.f400141d);
        sendIntent(e.m.f400153d);
        sendIntent(e.g.f400142d);
    }

    @Override // com.tencent.guild.aio.input.realinput.u
    @NotNull
    public EditText g() {
        vn0.e eVar = this.mBinding;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        GuildAIOInputEditText guildAIOInputEditText = eVar.f441937g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "mBinding.guildAioInputEdittext");
        return guildAIOInputEditText;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof t.a) {
            return A1();
        }
        return super.generateVBState(stateCmd);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildAioDefaultInputUIState>> getObserverStates() {
        return CollectionsKt.listOf((Object[]) new Class[]{GuildAioDefaultInputUIState.GuildInputHint.class, GuildAioDefaultInputUIState.GuideInputHideState.class, GuildAioDefaultInputUIState.GuildInputDismissPanel.class, GuildAioDefaultInputUIState.NotifyAtClusterAioOpened.class, GuildAioDefaultInputUIState.GuildShowKeyboard.class, GuildAioDefaultInputUIState.GuideClearEditInput.class, GuildAioDefaultInputUIState.GuideReplaceInputEmotion.class, GuildAioDefaultInputUIState.GuideInputReplyMsg.class, GuildAioDefaultInputUIState.GuildInputInsertAt.class, GuildAioDefaultInputUIState.GuideInputRecallMsg.class, GuildAioDefaultInputUIState.GuildMultiSelectModeChanged.class, GuildAioDefaultInputUIState.GuildMultiSelectCountChanged.class, GuildAioDefaultInputUIState.GuildConfigurationChanged.class, GuildAioDefaultInputUIState.GuildFreqLimitInfo.class, GuildAioDefaultInputUIState.GuildSendResp.class, GuildAioDefaultInputUIState.GuildHandlerPermissionsChange.class, GuildAioDefaultInputUIState.RecoverDraft.class, GuildAioDefaultInputUIState.InitAtCluster.class, GuildAioDefaultInputUIState.UpdateAtInfo.class, GuildAioDefaultInputUIState.RefreshSendBtn.class, GuildAioDefaultInputUIState.UpdateSendBtnClickable.class, GuildAioDefaultInputUIState.GuildAtStateEvent.ShowHashtagPanel.class});
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState>> initializeChildVB(@NotNull View hostView) {
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        return CollectionsKt.listOf((Object[]) new com.tencent.aio.base.mvvm.a[]{new GuildTextAioUserAvatarViewBinder(), new tn0.c(), new com.tencent.guild.aio.component.album.c(), new un0.c()});
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        vn0.e g16 = vn0.e.g(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, createViewParams.parent, false)");
        this.mBinding = g16;
        vn0.e eVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        vn0.k e16 = vn0.k.e(g16.getRoot());
        Intrinsics.checkNotNullExpressionValue(e16, "bind(mBinding.root)");
        this.guildAioReplyLayout = e16;
        vn0.e eVar2 = this.mBinding;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar = eVar2;
        }
        FrameLayout root = eVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        return root;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        w1();
        this.mChannelName = "";
        vn0.e eVar = this.mBinding;
        vn0.e eVar2 = null;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            eVar = null;
        }
        eVar.f441937g.removeTextChangedListener(this.mTextWatcher);
        vn0.e eVar3 = this.mBinding;
        if (eVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            eVar2 = eVar3;
        }
        eVar2.f441937g.removeOnLayoutChangeListener(this.mEditOnLayoutListener);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: v1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<fo0.e, GuildAioDefaultInputUIState> createVM() {
        return new GuildAioDefaultInputViewModel(this);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            GuildAioDefaultInputViewBinder.this.sendIntent(e.o.f400155d);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }
}
