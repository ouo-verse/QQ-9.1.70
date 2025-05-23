package com.tencent.mobileqq.qqlive.widget.input;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.tg.rewardAD.RewardDialogContentViewHolder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.EmojiConstants;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout;
import com.tencent.mobileqq.qqlive.widget.util.KeyboardUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$AtUser;
import trpc.yes.common.MessageOuterClass$AtUserMsg;
import trpc.yes.common.MessageOuterClass$MsgContent;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0003\u000e\u0011,\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0006\u008e\u0001\u008f\u0001\u0090\u0001B#\b\u0007\u0012\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001\u0012\f\b\u0002\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008a\u0001\u00a2\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001fH\u0002J\n\u0010#\u001a\u0004\u0018\u00010\"H\u0002J\u0014\u0010%\u001a\u00020\u0002*\u00020\"2\u0006\u0010$\u001a\u00020\u0007H\u0002J%\u0010(\u001a\u00020\"2\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010'\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b(\u0010)J\b\u0010+\u001a\u00020*H\u0002J\u000f\u0010-\u001a\u00020,H\u0002\u00a2\u0006\u0004\b-\u0010.J\u0006\u0010/\u001a\u00020\u0007J\u0010\u00100\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0007H\u0004J\b\u00101\u001a\u00020\u0007H\u0014J\u0010\u00103\u001a\u00020\u00022\u0006\u00102\u001a\u00020\"H\u0014J\b\u00104\u001a\u00020\u0007H\u0014J\u000e\u00107\u001a\u00020\u00022\u0006\u00106\u001a\u000205J\u000e\u00108\u001a\u00020\u00022\u0006\u00106\u001a\u000205J\u0006\u00109\u001a\u00020\nJ\u0006\u0010:\u001a\u00020\u0002J\u0006\u0010;\u001a\u00020\u001dJ\u0006\u0010<\u001a\u00020\u001dJ\b\u0010=\u001a\u00020\u0002H\u0014J\b\u0010>\u001a\u00020\u0002H\u0014J\u000e\u0010@\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0007J\b\u0010A\u001a\u00020\u0002H\u0016J*\u0010E\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001f2\b\u0010B\u001a\u0004\u0018\u00010\n2\u0006\u0010C\u001a\u00020\n2\b\b\u0002\u0010D\u001a\u00020\nR\u0014\u0010G\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010\u0016R\u0014\u0010&\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010\u0016R\u0018\u0010L\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR$\u0010T\u001a\u0004\u0018\u00010M8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010[\u001a\u0004\u0018\u00010\"8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010^\u001a\u0004\u0018\u00010\"8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010V\u001a\u0004\b\\\u0010X\"\u0004\b]\u0010ZR \u0010a\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010`R \u0010c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010`R \u0010d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010`R&\u0010h\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0f0e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010gR \u0010i\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010`R$\u0010p\u001a\u0004\u0018\u00010j8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u0002050q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010rR\u0014\u0010v\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u001b\u0010y\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010w\u001a\u0004\bx\u0010.R\u0018\u0010|\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010{R\u0016\u0010~\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010}R\u0016\u0010\u007f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R(\u0010\u0083\u0001\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u00078\u0006@BX\u0086\u000e\u00a2\u0006\u000e\n\u0004\b\u0003\u0010\u0016\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0016\u0010\u0084\u0001\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0007\u001a\u0005\bb\u0010\u0082\u0001R\u0017\u0010\u0087\u0001\u001a\u00020\u001d8DX\u0084\u0004\u00a2\u0006\b\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout;", "Landroid/widget/LinearLayout;", "", "P", "O", "", "source", "", "remainingCount", "G", "", "toastContent", "Z", "B", "com/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$f", "K", "()Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$f;", "com/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$e", UserInfo.SEX_FEMALE, "()Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$e;", "Landroid/view/View$OnClickListener;", "y", "I", "N", "T", "content", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "maxLength", "r", "", "M", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "L", "Landroid/view/View;", "w", "height", "V", "backgroundColor", "rowCount", DomainData.DOMAIN_NAME, "(Ljava/lang/Integer;I)Landroid/view/View;", "Lcom/tencent/mobileqq/qqlive/widget/util/KeyboardUtils$b;", "o", "com/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$d;", "v", "W", "E", "view", ReportConstant.COSTREPORT_PREFIX, "u", "Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$c;", "listener", "k", "U", "t", "l", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "state", "setState", "Y", "showName", "showUserName", "headUrl", "j", "d", RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, "e", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "funcLayout", "Landroid/widget/EditText;", tl.h.F, "Landroid/widget/EditText;", BdhLogUtil.LogTag.Tag_Conn, "()Landroid/widget/EditText;", "setInputText", "(Landroid/widget/EditText;)V", "inputText", "i", "Landroid/view/View;", "H", "()Landroid/view/View;", "setSendBtn", "(Landroid/view/View;)V", "sendBtn", HippyTKDListViewAdapter.X, "setEmojiBtn", "emojiBtn", "", "Ljava/util/Map;", "atInfoMap", "D", "userIdToShowNameMap", "userNameQQUserInfoMapIdMap", "", "Lkotlin/Pair;", "Ljava/util/List;", "atPosUserNameList", "userNameHeadUrl", "Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$b;", "Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$b;", "getSendMessageCallback", "()Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$b;", "X", "(Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$b;)V", "sendMessageCallback", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "stateChangedListenerList", "J", "Lcom/tencent/mobileqq/qqlive/widget/util/KeyboardUtils$b;", "layoutListener", "Lkotlin/Lazy;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "emojiCallback", "Lcom/tencent/mobileqq/widget/QQToast;", "Lcom/tencent/mobileqq/widget/QQToast;", "qqToast", "Ljava/lang/String;", "lastToastContent", "preState", "<set-?>", "getCurrentState", "()I", "currentState", "keyboardHeight", ExifInterface.LATITUDE_SOUTH, "()Z", MiniChatConstants.MINI_APP_LANDSCAPE, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "b", "c", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class LiveInputLayout extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int R;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> atInfoMap;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> userIdToShowNameMap;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Map<String, CommonOuterClass$QQUserId> userNameQQUserInfoMapIdMap;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<Integer, String>> atPosUserNameList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> userNameHeadUrl;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private b sendMessageCallback;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<c> stateChangedListenerList;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final KeyboardUtils.b layoutListener;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy emojiCallback;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private QQToast qqToast;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String lastToastContent;

    /* renamed from: N, reason: from kotlin metadata */
    private int preState;

    /* renamed from: P, reason: from kotlin metadata */
    private int currentState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int screenOrientation;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int backgroundColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout funcLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private EditText inputText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View sendBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View emojiBtn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$a;", "", "", "CONTENT_MAX_LENGTH", "I", "HORIZONTAL_EMOJI_ROW_COUNT", "", "MOTION_REGEX", "Ljava/lang/String;", "STATE_FUNC", "STATE_KEYBOARD", "STATE_NORMAL", "TAG", "VERTICAL_EMOJI_ROW_COUNT", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$b;", "", "", "text", "", "b", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", "a", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface b {
        void a(@NotNull String text, @NotNull MessageOuterClass$MsgContent content);

        void b(@NotNull String text);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$c;", "", "", "state", "", "onStateChanged", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public interface c {
        void onStateChanged(int state);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$d", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements EmoticonCallback {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveInputLayout.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                LiveInputLayout.this.T();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(@Nullable EmoticonInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) info);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(@Nullable EmoticonInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) info)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, oldInfo, newInfo, d16);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(@Nullable EmoticonInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
                return;
            }
            try {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                EditText C = LiveInputLayout.this.C();
                if (C != null) {
                    LiveInputLayout liveInputLayout = LiveInputLayout.this;
                    if (info != null) {
                        info.send(peekAppRuntime, liveInputLayout.getContext(), C, null);
                    }
                }
            } catch (Exception e16) {
                AegisLogger.INSTANCE.e("Input|LiveInputLayout", "send emoji error", "", e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$e", "Landroid/view/View$OnKeyListener;", "Landroid/view/View;", "v", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class e implements View.OnKeyListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveInputLayout.this);
            }
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(@Nullable View v3, int keyCode, @NotNull KeyEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, v3, Integer.valueOf(keyCode), event)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getKeyCode() == 67 && event.getAction() == 0) {
                LiveInputLayout.this.T();
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$f", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class f implements TextWatcher {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LiveInputLayout.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) s16);
                return;
            }
            View H = LiveInputLayout.this.H();
            if (H != null) {
                boolean z17 = false;
                if (s16 != null) {
                    if (s16.length() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                    }
                }
                H.setEnabled(z17);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, s16, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
        
            if (r1 == true) goto L25;
         */
        @Override // android.text.TextWatcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            String str;
            Editable text;
            int i3;
            boolean contains$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, s16, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
                return;
            }
            if (s16 != null) {
                str = s16.toString();
            } else {
                str = null;
            }
            EditText C = LiveInputLayout.this.C();
            if (C != null && (text = C.getText()) != null) {
                LiveInputLayout liveInputLayout = LiveInputLayout.this;
                if ((!liveInputLayout.userNameQQUserInfoMapIdMap.isEmpty()) && !TextUtils.isEmpty(str)) {
                    if (str != null) {
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "@", false, 2, (Object) null);
                    }
                    z16 = false;
                    if (z16) {
                        Object[] spans = text.getSpans(0, text.length(), ForegroundColorSpan.class);
                        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(0, length, Fore\u2026undColorSpan::class.java)");
                        for (Object obj : spans) {
                            text.removeSpan((ForegroundColorSpan) obj);
                        }
                        liveInputLayout.atPosUserNameList.clear();
                        List list = liveInputLayout.atPosUserNameList;
                        com.tencent.mobileqq.qqlive.widget.input.b bVar = com.tencent.mobileqq.qqlive.widget.input.b.f273995a;
                        Map<String, CommonOuterClass$QQUserId> map = liveInputLayout.userNameQQUserInfoMapIdMap;
                        EditText C2 = liveInputLayout.C();
                        if (C2 != null) {
                            i3 = C2.getCurrentTextColor();
                        } else {
                            i3 = -16777216;
                        }
                        list.addAll(bVar.c(0, str, map, text, i3, false, null));
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$g", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class g extends Editable.Factory {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.text.Editable.Factory
        @NotNull
        public Editable newEditable(@Nullable CharSequence source) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Editable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) source);
            }
            if (source instanceof QQTextBuilder) {
                return (Editable) source;
            }
            return new QQTextBuilder(source, 3, 20);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqlive/widget/input/LiveInputLayout$h", "Landroid/text/InputFilter;", "", "source", "", "start", "end", "Landroid/text/Spanned;", "dest", "dstart", "dend", "filter", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class h implements InputFilter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f273988d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LiveInputLayout f273989e;

        h(int i3, LiveInputLayout liveInputLayout) {
            this.f273988d = i3;
            this.f273989e = liveInputLayout;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) liveInputLayout);
            }
        }

        @Override // android.text.InputFilter
        @Nullable
        public CharSequence filter(@Nullable CharSequence source, int start, int end, @Nullable Spanned dest, int dstart, int dend) {
            int i3;
            boolean contains$default;
            String replace$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CharSequence) iPatchRedirector.redirect((short) 2, this, source, Integer.valueOf(start), Integer.valueOf(end), dest, Integer.valueOf(dstart), Integer.valueOf(dend));
            }
            if (source == null) {
                return null;
            }
            int length = source.length();
            int i16 = this.f273988d;
            if (dest != null) {
                i3 = dest.length();
            } else {
                i3 = 0;
            }
            int i17 = i16 - i3;
            if (length <= i17) {
                contains$default = StringsKt__StringsKt.contains$default(source, (CharSequence) "\n", false, 2, (Object) null);
                if (contains$default) {
                    replace$default = StringsKt__StringsJVMKt.replace$default(source.toString(), "\n", "", false, 4, (Object) null);
                    return replace$default;
                }
                return null;
            }
            LiveInputLayout liveInputLayout = this.f273989e;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = liveInputLayout.getContext().getString(R.string.f199754q_);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026e_input_count_limit_tips)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.f273988d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            liveInputLayout.Z(format);
            return this.f273989e.G(source, i17);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35631);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            INSTANCE = new Companion(null);
            R = EmojiConstants.COLUMNNUM_SYSTEM_AND_EMOJI;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveInputLayout(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) {
            return;
        }
        iPatchRedirector.redirect((short) 29, (Object) this, (Object) context);
    }

    private final d A() {
        return (d) this.emojiCallback.getValue();
    }

    private final int B() {
        if (this.screenOrientation == 1) {
            return R;
        }
        return 12;
    }

    private final int D() {
        return TimiInputUtil.f273991a.c(S());
    }

    private final e F() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CharSequence G(CharSequence source, int remainingCount) {
        if (remainingCount == 0) {
            return "";
        }
        int i3 = remainingCount - 1;
        if (com.tencent.mobileqq.qqlive.widget.util.c.d(source.subSequence(i3, remainingCount).toString())) {
            return source.subSequence(0, i3);
        }
        return source.subSequence(0, remainingCount);
    }

    private final View.OnClickListener I() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.widget.input.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveInputLayout.J(LiveInputLayout.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(LiveInputLayout this$0, View it) {
        Editable text;
        String obj;
        String text2;
        boolean contains$default;
        String text3;
        String str;
        boolean contains$default2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.s(it);
        EditText editText = this$0.inputText;
        if (editText != null && (text = editText.getText()) != null && (obj = text.toString()) != null) {
            int u16 = this$0.u();
            if (u16 == -1) {
                text2 = com.tencent.mobileqq.qqlive.widget.util.c.b(obj);
            } else {
                text2 = com.tencent.mobileqq.qqlive.widget.util.c.c(obj, u16);
            }
            if (!this$0.atPosUserNameList.isEmpty()) {
                Intrinsics.checkNotNullExpressionValue(text2, "text");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) text2, (CharSequence) "@", false, 2, (Object) null);
                if (contains$default) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it5 = this$0.atPosUserNameList.iterator();
                    loop0: while (true) {
                        text3 = text2;
                        while (it5.hasNext()) {
                            str = (String) ((Pair) it5.next()).getSecond();
                            Intrinsics.checkNotNullExpressionValue(text3, "text");
                            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) text3, (CharSequence) ('@' + str), false, 2, (Object) null);
                            if (contains$default2) {
                                break;
                            }
                        }
                        MessageOuterClass$AtUser messageOuterClass$AtUser = new MessageOuterClass$AtUser();
                        CommonOuterClass$QQUserId commonOuterClass$QQUserId = this$0.userNameQQUserInfoMapIdMap.get(str);
                        Map<String, String> map = this$0.userIdToShowNameMap;
                        Intrinsics.checkNotNull(commonOuterClass$QQUserId);
                        String str2 = map.get(this$0.L(commonOuterClass$QQUserId));
                        messageOuterClass$AtUser.user_id.set(this$0.userNameQQUserInfoMapIdMap.get(str));
                        messageOuterClass$AtUser.nick_name.set(str2);
                        messageOuterClass$AtUser.head_url.set(this$0.userNameHeadUrl.get(str));
                        arrayList.add(messageOuterClass$AtUser);
                        text2 = StringsKt__StringsJVMKt.replace$default(text3, '@' + str, '@' + str2, false, 4, (Object) null);
                    }
                    MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg = new MessageOuterClass$AtUserMsg();
                    messageOuterClass$AtUserMsg.user_list.set(arrayList);
                    messageOuterClass$AtUserMsg.text.set(text3);
                    MessageOuterClass$MsgContent messageOuterClass$MsgContent = new MessageOuterClass$MsgContent();
                    messageOuterClass$MsgContent.at_user_msg.set(messageOuterClass$AtUserMsg);
                    b bVar = this$0.sendMessageCallback;
                    if (bVar != null) {
                        Intrinsics.checkNotNullExpressionValue(text3, "text");
                        bVar.a(text3, messageOuterClass$MsgContent);
                    }
                }
            }
            b bVar2 = this$0.sendMessageCallback;
            if (bVar2 != null) {
                Intrinsics.checkNotNullExpressionValue(text2, "text");
                bVar2.b(text2);
            }
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final f K() {
        return new f();
    }

    private final String L(CommonOuterClass$QQUserId userId) {
        return userId.user_from.get() + util.base64_pad_url + wi2.a.a(userId);
    }

    private final boolean M(String content) {
        boolean endsWith$default;
        boolean contains$default;
        if (!this.userNameQQUserInfoMapIdMap.isEmpty()) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(content, " ", false, 2, null);
            if (endsWith$default) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) content, (CharSequence) "@", false, 2, (Object) null);
                if (contains$default) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void N() {
        IBinder windowToken;
        Object obj;
        View w3 = w();
        if (w3 != null && (windowToken = w3.getWindowToken()) != null) {
            Context context = getContext();
            InputMethodManager inputMethodManager = null;
            if (context != null) {
                obj = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            } else {
                obj = null;
            }
            if (obj instanceof InputMethodManager) {
                inputMethodManager = (InputMethodManager) obj;
            }
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
            }
        }
    }

    private final void O() {
        EditText editText = (EditText) findViewById(R.id.dmu);
        editText.addTextChangedListener(K());
        editText.setOnKeyListener(F());
        editText.setEditableFactory(new g());
        this.inputText = editText;
        W(v());
    }

    private final void P() {
        setOrientation(1);
        if (this.screenOrientation == 1) {
            EditText editText = this.inputText;
            if (editText != null) {
                editText.setSingleLine(false);
            }
            EditText editText2 = this.inputText;
            if (editText2 != null) {
                editText2.setImeOptions(1);
            }
        } else {
            EditText editText3 = this.inputText;
            if (editText3 != null) {
                editText3.setSingleLine(true);
            }
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(this.backgroundColor);
        linearLayout.setOrientation(0);
        View.inflate(linearLayout.getContext(), E(), linearLayout);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.funcLayout = frameLayout;
        frameLayout.setBackgroundColor(this.backgroundColor);
        addView(frameLayout, new LinearLayout.LayoutParams(-1, wi2.c.b(0)));
        O();
        View findViewById = findViewById(R.id.bva);
        this.emojiBtn = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(y());
        }
        View findViewById2 = findViewById(R.id.send_btn);
        this.sendBtn = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(I());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T() {
        String str;
        EditText editText = this.inputText;
        if (editText != null) {
            int selectionStart = editText.getSelectionStart();
            if (editText.getEditableText() != null) {
                str = editText.getEditableText().toString();
            } else {
                str = "";
            }
            String substring = str.substring(0, selectionStart);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            int codePointCount = substring.codePointCount(0, substring.length());
            if (q(substring) == 1) {
                com.tencent.mobileqq.text.TextUtils.backspace(editText);
                return;
            }
            String substring2 = substring.substring(substring.offsetByCodePoints(0, 0), substring.offsetByCodePoints(0, Math.max(codePointCount - r(substring, Integer.MAX_VALUE), 0)));
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String substring3 = str.substring(selectionStart, str.length());
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String str2 = substring2 + substring3;
            editText.setText(str2);
            editText.setSelection(Math.min(substring2.length(), str2.length()));
        }
    }

    private final void V(View view, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("Input|LiveInputLayout", 1, "keyboardHeight: " + i3);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i3;
        }
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(String toastContent) {
        if (this.qqToast == null) {
            QQToast qQToast = new QQToast(getContext());
            qQToast.setToastIcon(QQToast.getIconRes(0));
            qQToast.setType(0);
            qQToast.setDuration(0);
            this.qqToast = qQToast;
        }
        QQToast qQToast2 = this.qqToast;
        if (qQToast2 != null) {
            if (!qQToast2.isShowing() || !Intrinsics.areEqual(toastContent, this.lastToastContent)) {
                this.lastToastContent = toastContent;
                qQToast2.setToastMsg(toastContent);
                qQToast2.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final d m() {
        return new d();
    }

    private final View n(@ColorInt Integer backgroundColor, int rowCount) {
        SystemAndEmojiUniversalPanel.Builder builder = new SystemAndEmojiUniversalPanel.Builder(getContext());
        builder.setEmoticonCallback(A());
        builder.setFilterSysFaceBeyond255Enable(true);
        builder.setShowDescribeInPreview(true);
        if (rowCount != -1) {
            builder.setRowCount(rowCount);
        }
        EditText editText = this.inputText;
        if (editText != null) {
            builder.setShowDeleteButton(editText);
        }
        SystemAndEmojiUniversalPanel create = builder.create(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(MobileQQ.sMobileQQ.peekAppRuntime()));
        if (backgroundColor != null) {
            create.setBackgroundColor(backgroundColor.intValue());
        }
        Intrinsics.checkNotNullExpressionValue(create, "Builder(context)\n       \u2026r(it) }\n                }");
        return create;
    }

    private final KeyboardUtils.b o() {
        return new KeyboardUtils.b() { // from class: com.tencent.mobileqq.qqlive.widget.input.c
            @Override // com.tencent.mobileqq.qqlive.widget.util.KeyboardUtils.b
            public final void a(int i3) {
                LiveInputLayout.p(LiveInputLayout.this, i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(LiveInputLayout this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 > 0) {
            TimiInputUtil.f273991a.e(i3, this$0.S());
            this$0.setState(2);
        } else if (this$0.currentState == 2) {
            this$0.setState(1);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0007, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r9, "@", 0, false, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int q(String content) {
        int lastIndexOf$default;
        if (M(content) && lastIndexOf$default >= 0 && lastIndexOf$default < content.length() - 1) {
            String substring = content.substring(lastIndexOf$default + 1, content.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            if (this.userNameQQUserInfoMapIdMap.containsKey(substring)) {
                return substring.length() + 2;
            }
        }
        return 1;
    }

    private final int r(String content, int maxLength) {
        int i3;
        if (M(content)) {
            i3 = q(content);
        } else {
            i3 = 1;
        }
        String replace = new Regex("@(\\[m\\](\\d+?)\\[\\/m\\])").replace(content, "@");
        int codePointCount = replace.codePointCount(0, replace.length());
        if (replace.codePointCount(0, replace.length()) - i3 > maxLength) {
            String substring = content.substring(content.offsetByCodePoints(0, 0), content.offsetByCodePoints(0, codePointCount - i3));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return i3 + r(substring, maxLength);
        }
        return i3;
    }

    private final View w() {
        ViewGroup viewGroup;
        FrameLayout frameLayout;
        View rootView = getRootView();
        if (rootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) rootView;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null || (frameLayout = (FrameLayout) viewGroup.findViewById(android.R.id.content)) == null) {
            return null;
        }
        return frameLayout.getChildAt(0);
    }

    private final View.OnClickListener y() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.widget.input.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveInputLayout.z(LiveInputLayout.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(LiveInputLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.currentState == 3) {
            this$0.Y();
        } else {
            this$0.setState(3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final EditText C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EditText) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.inputText;
    }

    protected int E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return R.layout.h_t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final View H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.sendBtn;
    }

    public final boolean Q() {
        Editable editableText;
        String obj;
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        EditText editText = this.inputText;
        if (editText == null || (editableText = editText.getEditableText()) == null || (obj = editableText.toString()) == null) {
            return false;
        }
        String emotionText = com.tencent.mobileqq.qqlive.widget.util.c.b(obj);
        if (!(!this.atPosUserNameList.isEmpty())) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(emotionText, "emotionText");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) emotionText, (CharSequence) "@", false, 2, (Object) null);
        if (!contains$default) {
            return false;
        }
        return true;
    }

    public final boolean R() {
        Editable editableText;
        String obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        EditText editText = this.inputText;
        if (editText != null && (editableText = editText.getEditableText()) != null && (obj = editableText.toString()) != null) {
            return com.tencent.mobileqq.qqlive.widget.util.c.d(obj);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean S() {
        Resources resources;
        Configuration configuration;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        Context context = getContext();
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) {
            return false;
        }
        return true;
    }

    public final void U(@NotNull c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.stateChangedListenerList.remove(listener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void W(int maxLength) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, maxLength);
            return;
        }
        EditText editText = this.inputText;
        if (editText != null) {
            editText.setFilters(new h[]{new h(maxLength, this)});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void X(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
        } else {
            this.sendMessageCallback = bVar;
        }
    }

    public void Y() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        EditText editText = this.inputText;
        if (editText != null) {
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            Context context = getContext();
            final InputMethodManager inputMethodManager = null;
            if (context != null) {
                obj = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            } else {
                obj = null;
            }
            if (obj instanceof InputMethodManager) {
                inputMethodManager = (InputMethodManager) obj;
            }
            if (inputMethodManager != null) {
                final Handler handler = new Handler();
                inputMethodManager.showSoftInput(editText, 0, new ResultReceiver(inputMethodManager, handler) { // from class: com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout$showKeyBoard$1$1$1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ InputMethodManager f273990d;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(handler);
                        this.f273990d = inputMethodManager;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) inputMethodManager, (Object) handler);
                        }
                    }

                    @Override // android.os.ResultReceiver
                    protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, resultCode, (Object) resultData);
                        } else if (resultCode == 1 || resultCode == 3) {
                            this.f273990d.toggleSoftInput(0, 0);
                        }
                    }
                });
                inputMethodManager.toggleSoftInput(2, 1);
            }
        }
    }

    public final void j(@NotNull CommonOuterClass$QQUserId userId, @Nullable String showName, @NotNull String showUserName, @NotNull String headUrl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, userId, showName, showUserName, headUrl);
            return;
        }
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(showUserName, "showUserName");
        Intrinsics.checkNotNullParameter(headUrl, "headUrl");
        this.atInfoMap.put(L(userId), showUserName);
        Map<String, String> map = this.userIdToShowNameMap;
        String L = L(userId);
        if (showName == null) {
            showName = "";
        }
        map.put(L, showName);
        this.userNameQQUserInfoMapIdMap.put(showUserName, userId);
        this.userNameHeadUrl.put(showUserName, headUrl);
    }

    public final void k(@NotNull c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.stateChangedListenerList.contains(listener)) {
            this.stateChangedListenerList.add(listener);
        }
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        EditText editText = this.inputText;
        if (editText != null) {
            editText.setText("");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        Activity activity;
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (window = activity.getWindow()) != null) {
            KeyboardUtils.d(this, window, this.layoutListener);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        Activity activity;
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (window = activity.getWindow()) != null) {
            KeyboardUtils.h(this, window);
        }
    }

    protected void s(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public final void setState(int state) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, state);
            return;
        }
        int i3 = this.currentState;
        boolean z16 = true;
        if (i3 == state) {
            FrameLayout frameLayout = this.funcLayout;
            if (frameLayout == null || frameLayout.getHeight() != D()) {
                z16 = false;
            }
            if (!z16 && (view = this.funcLayout) != null) {
                V(view, D());
                return;
            }
            return;
        }
        this.preState = i3;
        this.currentState = state;
        if (state != 1) {
            if (state != 2) {
                if (state == 3) {
                    N();
                    FrameLayout frameLayout2 = this.funcLayout;
                    if (frameLayout2 != null) {
                        V(frameLayout2, D());
                        frameLayout2.removeAllViews();
                        frameLayout2.addView(n(Integer.valueOf(this.backgroundColor), B()), new FrameLayout.LayoutParams(-1, -1));
                    }
                    View view2 = this.emojiBtn;
                    if (view2 != null) {
                        view2.setBackgroundResource(R.drawable.nnu);
                    }
                    setVisibility(0);
                }
            } else {
                View view3 = this.funcLayout;
                if (view3 != null) {
                    V(view3, D());
                }
                View view4 = this.emojiBtn;
                if (view4 != null) {
                    view4.setBackgroundResource(R.drawable.nnt);
                }
                setVisibility(0);
            }
        } else {
            N();
            EditText editText = this.inputText;
            if (editText != null) {
                editText.clearFocus();
            }
            View view5 = this.funcLayout;
            if (view5 != null) {
                V(view5, 0);
            }
            FrameLayout frameLayout3 = this.funcLayout;
            if (frameLayout3 != null) {
                frameLayout3.removeAllViews();
            }
            View view6 = this.emojiBtn;
            if (view6 != null) {
                view6.setBackgroundResource(R.drawable.nnt);
            }
            setVisibility(8);
        }
        Iterator<T> it = this.stateChangedListenerList.iterator();
        while (it.hasNext()) {
            ((c) it.next()).onStateChanged(this.currentState);
        }
    }

    @NotNull
    public final String t() {
        Editable editableText;
        String obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        EditText editText = this.inputText;
        if (editText == null || (editableText = editText.getEditableText()) == null || (obj = editableText.toString()) == null) {
            return "";
        }
        return obj;
    }

    protected int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return -1;
    }

    public final int v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return ht3.a.b("qqlive_max_default_character_number", 30);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final View x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.emojiBtn;
    }

    public /* synthetic */ LiveInputLayout(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveInputLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.atInfoMap = new LinkedHashMap();
        this.userIdToShowNameMap = new LinkedHashMap();
        this.userNameQQUserInfoMapIdMap = new LinkedHashMap();
        this.atPosUserNameList = new ArrayList();
        this.userNameHeadUrl = new LinkedHashMap();
        this.stateChangedListenerList = new CopyOnWriteArrayList<>();
        this.layoutListener = o();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.mobileqq.qqlive.widget.input.LiveInputLayout$emojiCallback$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LiveInputLayout.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveInputLayout.d invoke() {
                LiveInputLayout.d m3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (LiveInputLayout.d) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                m3 = LiveInputLayout.this.m();
                return m3;
            }
        });
        this.emojiCallback = lazy;
        this.lastToastContent = "";
        this.preState = 1;
        this.currentState = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.qqlive.widget.b.f273615o2);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026tyleable.LiveInputLayout)");
        this.screenOrientation = obtainStyledAttributes.getInt(com.tencent.mobileqq.qqlive.widget.b.f273631q2, 1);
        this.backgroundColor = obtainStyledAttributes.getInt(com.tencent.mobileqq.qqlive.widget.b.f273623p2, -16777216);
        obtainStyledAttributes.recycle();
        P();
    }
}
