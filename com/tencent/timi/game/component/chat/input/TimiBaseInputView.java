package com.tencent.timi.game.component.chat.input;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.widget.util.KeyboardUtils;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView$emojiEditableFactory$2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$AtUser;
import trpc.yes.common.MessageOuterClass$AtUserMsg;
import trpc.yes.common.MessageOuterClass$MsgContent;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001u\b&\u0018\u0000 12\u00020\u00012\u00020\u0002:\u0003\u007f\u0080\u0001B'\b\u0007\u0012\u0006\u0010y\u001a\u00020H\u0012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010z\u0012\b\b\u0002\u0010|\u001a\u00020\u000e\u00a2\u0006\u0004\b}\u0010~J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\tH\u0002J$\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tH\u0004J\b\u0010\u0015\u001a\u00020\u0003H\u0014J\b\u0010\u0016\u001a\u00020\u0003H\u0014J\b\u0010\u0017\u001a\u00020\u000eH\u0014J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000eH\u0004J\u0006\u0010\u001d\u001a\u00020\u000eJ\"\u0010 \u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001f\u001a\u00020\tJ\b\u0010!\u001a\u00020\u0003H\u0014J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u000eH\u0014J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(H\u0014J\n\u0010,\u001a\u0004\u0018\u00010+H&J\n\u0010-\u001a\u0004\u0018\u00010(H&J\b\u0010.\u001a\u00020\u000eH&J\b\u0010/\u001a\u00020\u0003H&J\b\u00100\u001a\u00020\u000eH\u0016J\b\u00101\u001a\u00020\fH\u0014R\u001b\u00107\u001a\u0002028DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R#\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007088\u0006\u00a2\u0006\f\n\u0004\b<\u0010:\u001a\u0004\b=\u0010>R)\u0010F\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0A0@8\u0006\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER \u0010G\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010:R$\u0010N\u001a\u0004\u0018\u00010H8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010U\u001a\u0004\u0018\u00010O8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010[\u001a\u0004\u0018\u00010\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010b\u001a\u0004\u0018\u00010\\8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010cR\"\u0010i\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010c\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\"\u0010l\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010c\u001a\u0004\bj\u0010f\"\u0004\bk\u0010hR \u0010q\u001a\b\u0012\u0004\u0012\u00020$0m8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bc\u0010n\u001a\u0004\bo\u0010pR\u0014\u0010t\u001a\u00020r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010sR\u0014\u0010x\u001a\u00020u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010w\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "Landroid/widget/LinearLayout;", "", "", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", BdhLogUtil.LogTag.Tag_Conn, "content", "", UserInfo.SEX_FEMALE, "", "j", "", "textSize", NodeProps.LINE_HEIGHT, "hintStr", "J", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "E", "U", "G", "state", "setState", BdhLogUtil.LogTag.Tag_Req, "r", "showName", "headUrl", "g", "O", "maxLength", "k", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$b;", "listener", "i", "P", "Landroid/view/View;", "view", "l", "Landroid/widget/EditText;", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "M", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "L", "Landroid/text/Editable$Factory;", "d", "Lkotlin/Lazy;", "t", "()Landroid/text/Editable$Factory;", "emojiEditableFactory", "", "e", "Ljava/util/Map;", "atInfoMap", "f", "D", "()Ljava/util/Map;", "userNameQQUserInfoMapIdMap", "", "Lkotlin/Pair;", tl.h.F, "Ljava/util/List;", "p", "()Ljava/util/List;", "atPosUserNameList", "userNameHeadUrl", "Landroid/content/Context;", "Landroid/content/Context;", "o", "()Landroid/content/Context;", "setActivityContext", "(Landroid/content/Context;)V", "activityContext", "Lxn4/b;", "Lxn4/b;", "u", "()Lxn4/b;", "setExcludeLineSpan", "(Lxn4/b;)V", "excludeLineSpan", "Landroid/widget/LinearLayout;", HippyTKDListViewAdapter.X, "()Landroid/widget/LinearLayout;", "setInputLayout", "(Landroid/widget/LinearLayout;)V", "inputLayout", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "v", "()Landroid/widget/FrameLayout;", "setFuncLayout", "(Landroid/widget/FrameLayout;)V", "funcLayout", "I", "preState", ReportConstant.COSTREPORT_PREFIX, "()I", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(I)V", "currentState", "y", "setKeyboardHeight", "keyboardHeight", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "B", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "stateChangedListenerList", "Lcom/tencent/mobileqq/qqlive/widget/util/KeyboardUtils$b;", "Lcom/tencent/mobileqq/qqlive/widget/util/KeyboardUtils$b;", "layoutListener", "com/tencent/timi/game/component/chat/input/TimiBaseInputView$c", "K", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$c;", "emojiCallback", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class TimiBaseInputView extends LinearLayout {
    private static final int M = fh4.b.b(20);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private xn4.b excludeLineSpan;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private LinearLayout inputLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private FrameLayout funcLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private int preState;

    /* renamed from: G, reason: from kotlin metadata */
    private int currentState;

    /* renamed from: H, reason: from kotlin metadata */
    private int keyboardHeight;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<b> stateChangedListenerList;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final KeyboardUtils.b layoutListener;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final c emojiCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy emojiEditableFactory;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> atInfoMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, CommonOuterClass$QQUserId> userNameQQUserInfoMapIdMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<Integer, String>> atPosUserNameList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> userNameHeadUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context activityContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$b;", "", "", "text", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "timiBaseInputView", "", "a", "b", "", "state", "onStateChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView);

        void b(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView);

        void onStateChanged(int state);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/timi/game/component/chat/input/TimiBaseInputView$c", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements EmoticonCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            if (TimiBaseInputView.this.w() != null) {
                TimiBaseInputView.this.O();
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(@Nullable EmoticonInfo info) {
            return false;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(@Nullable EmoticonInfo info) {
            Object m476constructorimpl;
            EditText editText;
            AppRuntime waitAppRuntime;
            TimiBaseInputView timiBaseInputView = TimiBaseInputView.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                editText = null;
                waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (timiBaseInputView.getActivityContext() == null) {
                return;
            }
            EditText w3 = timiBaseInputView.w();
            if (w3 != null) {
                if (info != null) {
                    info.send(waitAppRuntime, timiBaseInputView.getActivityContext(), w3, null);
                }
                editText = w3;
            }
            m476constructorimpl = Result.m476constructorimpl(editText);
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                com.tencent.timi.game.utils.l.e("TimiInputView", String.valueOf(Result.m479exceptionOrNullimpl(m476constructorimpl)));
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(@Nullable EmoticonInfo info) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/component/chat/input/TimiBaseInputView$e", "Landroid/view/View$OnKeyListener;", "Landroid/view/View;", "v", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements View.OnKeyListener {
        e() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(@Nullable View v3, int keyCode, @NotNull KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getKeyCode() == 67 && event.getAction() == 0) {
                TimiBaseInputView.this.O();
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiBaseInputView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final String C(CommonOuterClass$QQUserId userId) {
        return userId.user_from.get() + "_" + com.tencent.timi.game.utils.b.j(userId);
    }

    private final boolean F(String content) {
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

    private final void H() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.inputLayout = linearLayout;
        linearLayout.setBackgroundColor(Color.parseColor("#0B0820"));
        linearLayout.setOrientation(0);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, E()));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.funcLayout = frameLayout;
        frameLayout.setBackgroundColor(-1);
        addView(frameLayout, new LinearLayout.LayoutParams(-1, fh4.b.b(0)));
        LinearLayout linearLayout2 = this.inputLayout;
        if (linearLayout2 != null) {
            View.inflate(getContext(), z(), linearLayout2);
        }
        M();
        EditText w3 = w();
        if (w3 != null) {
            w3.addTextChangedListener(new d());
        }
        View A = A();
        if (A != null) {
            A.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.input.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TimiBaseInputView.I(TimiBaseInputView.this, view);
                }
            });
        }
        EditText w16 = w();
        if (w16 != null) {
            w16.setOnKeyListener(new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(TimiBaseInputView this$0, View it) {
        Editable editableText;
        String obj;
        String text;
        boolean contains$default;
        boolean contains$default2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.l(it);
        EditText w3 = this$0.w();
        if (w3 != null && (editableText = w3.getEditableText()) != null && (obj = editableText.toString()) != null) {
            int q16 = this$0.q();
            if (q16 == -1) {
                text = com.tencent.mobileqq.qqlive.widget.util.c.b(obj);
            } else {
                text = com.tencent.mobileqq.qqlive.widget.util.c.c(obj, q16);
            }
            if (!this$0.atPosUserNameList.isEmpty()) {
                Intrinsics.checkNotNullExpressionValue(text, "text");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) "@", false, 2, (Object) null);
                if (contains$default) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it5 = this$0.atPosUserNameList.iterator();
                    while (it5.hasNext()) {
                        String str = (String) ((Pair) it5.next()).getSecond();
                        com.tencent.timi.game.utils.l.i("TimiInputView", "send showName= " + str);
                        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) ("@" + str), false, 2, (Object) null);
                        if (contains$default2) {
                            MessageOuterClass$AtUser messageOuterClass$AtUser = new MessageOuterClass$AtUser();
                            messageOuterClass$AtUser.user_id.set(this$0.userNameQQUserInfoMapIdMap.get(str));
                            messageOuterClass$AtUser.nick_name.set(str);
                            messageOuterClass$AtUser.head_url.set(this$0.userNameHeadUrl.get(str));
                            arrayList.add(messageOuterClass$AtUser);
                        }
                    }
                    MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg = new MessageOuterClass$AtUserMsg();
                    messageOuterClass$AtUserMsg.user_list.set(arrayList);
                    messageOuterClass$AtUserMsg.text.set(text);
                    MessageOuterClass$MsgContent messageOuterClass$MsgContent = new MessageOuterClass$MsgContent();
                    messageOuterClass$MsgContent.at_user_msg.set(messageOuterClass$AtUserMsg);
                    Iterator<T> it6 = this$0.stateChangedListenerList.iterator();
                    while (it6.hasNext()) {
                        ((b) it6.next()).a(text, messageOuterClass$MsgContent, this$0);
                    }
                }
            }
            for (b bVar : this$0.stateChangedListenerList) {
                Intrinsics.checkNotNullExpressionValue(text, "text");
                bVar.b(text, this$0);
            }
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    public static /* synthetic */ void K(TimiBaseInputView timiBaseInputView, float f16, int i3, String str, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                f16 = 14.0f;
            }
            if ((i16 & 2) != 0) {
                i3 = M;
            }
            timiBaseInputView.J(f16, i3, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initTimiEditText");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(TimiBaseInputView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.L()) {
            return;
        }
        if (i3 > 0) {
            TimiInputUtil timiInputUtil = TimiInputUtil.f376395a;
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            timiInputUtil.c(context, i3);
            this$0.keyboardHeight = i3;
            this$0.setState(2);
            return;
        }
        if (this$0.currentState == 2) {
            this$0.setState(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(TimiBaseInputView this$0) {
        Object obj;
        InputMethodManager inputMethodManager;
        FrameLayout frameLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.activityContext;
        IBinder iBinder = null;
        if (context != null) {
            obj = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        } else {
            obj = null;
        }
        if (obj instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) obj;
        } else {
            inputMethodManager = null;
        }
        Activity d16 = com.tencent.timi.game.utils.b.d(this$0);
        if (d16 != null && (frameLayout = (FrameLayout) d16.findViewById(R.id.content)) != null) {
            iBinder = frameLayout.getWindowToken();
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(TimiBaseInputView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout frameLayout = this$0.funcLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    public static /* synthetic */ void h(TimiBaseInputView timiBaseInputView, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str, String str2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                str2 = "";
            }
            timiBaseInputView.g(commonOuterClass$QQUserId, str, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addAtUserInfo");
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0007, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r9, "@", 0, false, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int j(String content) {
        int lastIndexOf$default;
        if (F(content) && lastIndexOf$default >= 0 && lastIndexOf$default < content.length() - 1) {
            String substring = content.substring(lastIndexOf$default + 1, content.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            if (this.userNameQQUserInfoMapIdMap.containsKey(substring)) {
                return substring.length() + 2;
            }
        }
        return 1;
    }

    private final void m() {
        Activity d16 = com.tencent.timi.game.utils.b.d(this);
        this.activityContext = d16;
        Window window = null;
        if (!(d16 instanceof Activity)) {
            d16 = null;
        }
        if (d16 != null) {
            window = d16.getWindow();
        }
        if (window == null) {
            return;
        }
        KeyboardUtils.d(this, window, this.layoutListener);
    }

    private final void n() {
        Activity activity;
        Context context = this.activityContext;
        Window window = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            window = activity.getWindow();
        }
        if (window == null) {
            return;
        }
        KeyboardUtils.h(this, window);
    }

    @Nullable
    public abstract View A();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final CopyOnWriteArrayList<b> B() {
        return this.stateChangedListenerList;
    }

    @NotNull
    public final Map<String, CommonOuterClass$QQUserId> D() {
        return this.userNameQQUserInfoMapIdMap;
    }

    protected int E() {
        return -2;
    }

    public void G() {
        setState(1);
    }

    protected final void J(float textSize, int lineHeight, @NotNull String hintStr) {
        Intrinsics.checkNotNullParameter(hintStr, "hintStr");
        EditText w3 = w();
        if (w3 != null) {
            w3.setTextSize(1, textSize);
            SpannableString spannableString = new SpannableString(hintStr);
            spannableString.setSpan(new xn4.b(lineHeight), 0, spannableString.length(), 33);
            w3.setHint(spannableString);
            this.excludeLineSpan = new xn4.b(lineHeight);
        }
    }

    protected boolean L() {
        return false;
    }

    public abstract void M();

    /* JADX INFO: Access modifiers changed from: protected */
    public void O() {
        String str;
        EditText w3 = w();
        if (w3 != null) {
            int selectionStart = w3.getSelectionStart();
            if (w3.getEditableText() != null) {
                str = w3.getEditableText().toString();
            } else {
                str = "";
            }
            String substring = str.substring(0, selectionStart);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            int codePointCount = substring.codePointCount(0, substring.length());
            if (j(substring) == 1) {
                TextUtils.backspace(w3);
                return;
            }
            String substring2 = substring.substring(substring.offsetByCodePoints(0, 0), substring.offsetByCodePoints(0, Math.max(codePointCount - k(substring, Integer.MAX_VALUE), 0)));
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String substring3 = str.substring(selectionStart, str.length());
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String str2 = substring2 + substring3;
            w3.setText(str2);
            w3.setSelection(Math.min(substring2.length(), str2.length()));
        }
    }

    public void P(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.stateChangedListenerList.remove(listener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q(int i3) {
        this.currentState = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void R(int state) {
        this.preState = state;
    }

    public void U() {
        Context context;
        Object obj;
        EditText w3 = w();
        if (w3 == null || (context = this.activityContext) == null) {
            return;
        }
        final InputMethodManager inputMethodManager = null;
        if (context != null) {
            obj = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        } else {
            obj = null;
        }
        if (obj instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) obj;
        }
        w3.setFocusable(true);
        w3.setFocusableInTouchMode(true);
        w3.requestFocus();
        if (inputMethodManager != null) {
            final Handler handler = new Handler();
            inputMethodManager.showSoftInput(w3, 0, new ResultReceiver(handler) { // from class: com.tencent.timi.game.component.chat.input.TimiBaseInputView$showKeyBoard$1$1
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                    if (resultCode == 1 || resultCode == 3) {
                        inputMethodManager.toggleSoftInput(0, 0);
                    }
                }
            });
        }
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(2, 1);
        }
    }

    public final void g(@NotNull CommonOuterClass$QQUserId userId, @Nullable String showName, @NotNull String headUrl) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(headUrl, "headUrl");
        if (showName != null) {
            this.atInfoMap.put(C(userId), showName);
            this.userNameQQUserInfoMapIdMap.put(showName, userId);
            this.userNameHeadUrl.put(showName, headUrl);
        }
    }

    public void i(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.stateChangedListenerList.contains(listener)) {
            this.stateChangedListenerList.add(listener);
        }
    }

    protected int k(@NotNull String content, int maxLength) {
        int i3;
        Intrinsics.checkNotNullParameter(content, "content");
        if (F(content)) {
            i3 = j(content);
        } else {
            i3 = 1;
        }
        String replace = new Regex("@(\\[m\\](\\d+?)\\[\\/m\\])").replace(content, "@");
        int codePointCount = replace.codePointCount(0, replace.length());
        if (replace.codePointCount(0, replace.length()) - i3 > maxLength) {
            String substring = content.substring(content.offsetByCodePoints(0, 0), content.offsetByCodePoints(0, codePointCount - i3));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return i3 + k(substring, maxLength);
        }
        return i3;
    }

    protected void l(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: o, reason: from getter */
    public final Context getActivityContext() {
        return this.activityContext;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n();
        this.activityContext = null;
    }

    @NotNull
    public final List<Pair<Integer, String>> p() {
        return this.atPosUserNameList;
    }

    public int q() {
        return -1;
    }

    /* renamed from: r, reason: from getter */
    public final int getCurrentState() {
        return this.currentState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int s() {
        return this.currentState;
    }

    public void setState(int state) {
        int i3;
        FrameLayout frameLayout;
        this.preState = this.currentState;
        this.currentState = state;
        com.tencent.timi.game.utils.l.b("TimiInputView", "state: " + state);
        if (w() != null && this.currentState != 2 && (frameLayout = this.funcLayout) != null) {
            frameLayout.post(new Runnable() { // from class: com.tencent.timi.game.component.chat.input.l
                @Override // java.lang.Runnable
                public final void run() {
                    TimiBaseInputView.S(TimiBaseInputView.this);
                }
            });
        }
        FrameLayout frameLayout2 = this.funcLayout;
        if (frameLayout2 != null) {
            if (this.currentState == 1) {
                i3 = 0;
            } else {
                i3 = this.keyboardHeight;
            }
            fh4.g.k(frameLayout2, i3);
        }
        if (this.currentState == 1) {
            EditText w3 = w();
            if (w3 != null) {
                w3.clearFocus();
            }
            FrameLayout frameLayout3 = this.funcLayout;
            if (frameLayout3 != null) {
                frameLayout3.post(new Runnable() { // from class: com.tencent.timi.game.component.chat.input.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        TimiBaseInputView.T(TimiBaseInputView.this);
                    }
                });
            }
        }
        Iterator<T> it = this.stateChangedListenerList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onStateChanged(this.currentState);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Editable.Factory t() {
        return (Editable.Factory) this.emojiEditableFactory.getValue();
    }

    @Nullable
    /* renamed from: u, reason: from getter */
    protected final xn4.b getExcludeLineSpan() {
        return this.excludeLineSpan;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: v, reason: from getter */
    public final FrameLayout getFuncLayout() {
        return this.funcLayout;
    }

    @Nullable
    public abstract EditText w();

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: x, reason: from getter */
    public final LinearLayout getInputLayout() {
        return this.inputLayout;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: y, reason: from getter */
    public final int getKeyboardHeight() {
        return this.keyboardHeight;
    }

    public abstract int z();

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiBaseInputView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ TimiBaseInputView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiBaseInputView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TimiBaseInputView$emojiEditableFactory$2.a>() { // from class: com.tencent.timi.game.component.chat.input.TimiBaseInputView$emojiEditableFactory$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/component/chat/input/TimiBaseInputView$emojiEditableFactory$2$a", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes26.dex */
            public static final class a extends Editable.Factory {
                a() {
                }

                @Override // android.text.Editable.Factory
                @NotNull
                public Editable newEditable(@Nullable CharSequence source) {
                    if (source instanceof QQTextBuilder) {
                        return (Editable) source;
                    }
                    return new QQTextBuilder(source, 3, 20);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a();
            }
        });
        this.emojiEditableFactory = lazy;
        this.atInfoMap = new LinkedHashMap();
        this.userNameQQUserInfoMapIdMap = new LinkedHashMap();
        this.atPosUserNameList = new ArrayList();
        this.userNameHeadUrl = new LinkedHashMap();
        this.preState = 1;
        this.currentState = 1;
        TimiInputUtil timiInputUtil = TimiInputUtil.f376395a;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        this.keyboardHeight = timiInputUtil.b(context);
        this.stateChangedListenerList = new CopyOnWriteArrayList<>();
        this.layoutListener = new KeyboardUtils.b() { // from class: com.tencent.timi.game.component.chat.input.k
            @Override // com.tencent.mobileqq.qqlive.widget.util.KeyboardUtils.b
            public final void a(int i16) {
                TimiBaseInputView.N(TimiBaseInputView.this, i16);
            }
        };
        H();
        setOrientation(1);
        this.emojiCallback = new c();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/component/chat/input/TimiBaseInputView$d", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            xn4.b excludeLineSpan = TimiBaseInputView.this.getExcludeLineSpan();
            if (excludeLineSpan != null) {
                if (s16 != null) {
                    s16.removeSpan(excludeLineSpan);
                }
                if (s16 != null) {
                    s16.setSpan(excludeLineSpan, 0, s16.length(), 33);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            String str;
            Editable text;
            boolean contains$default;
            int a16;
            if (s16 != null) {
                str = s16.toString();
            } else {
                str = null;
            }
            EditText w3 = TimiBaseInputView.this.w();
            if (w3 != null && (text = w3.getText()) != null) {
                TimiBaseInputView timiBaseInputView = TimiBaseInputView.this;
                if ((!timiBaseInputView.D().isEmpty()) && !android.text.TextUtils.isEmpty(str)) {
                    Intrinsics.checkNotNull(str);
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "@", false, 2, (Object) null);
                    if (contains$default) {
                        Object[] spans = text.getSpans(0, text.length(), ForegroundColorSpan.class);
                        Intrinsics.checkNotNullExpressionValue(spans, "it.getSpans(0, it.length\u2026undColorSpan::class.java)");
                        for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spans) {
                            text.removeSpan(foregroundColorSpan);
                        }
                        timiBaseInputView.p().clear();
                        List<Pair<Integer, String>> p16 = timiBaseInputView.p();
                        com.tencent.timi.game.component.chat.at.c cVar = com.tencent.timi.game.component.chat.at.c.f376355a;
                        Map<String, CommonOuterClass$QQUserId> D = timiBaseInputView.D();
                        EditText w16 = timiBaseInputView.w();
                        if (w16 != null) {
                            a16 = w16.getCurrentTextColor();
                        } else {
                            a16 = yn4.c.a(com.tencent.mobileqq.R.color.black);
                        }
                        p16.addAll(cVar.c(0, str, D, text, a16, false, null));
                    }
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }
    }
}
