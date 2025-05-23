package com.tencent.icgame.game.component.chat.input;

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
import androidx.annotation.ColorInt;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.game.component.chat.input.KeyboardUtils;
import com.tencent.icgame.game.component.chat.input.TimiBaseInputView$emojiEditableFactory$2;
import com.tencent.icgame.game.utils.g;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUser;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUserMsg;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0001l\b&\u0018\u0000 |2\u00020\u00012\u00020\u0002:\u0002}~B'\b\u0007\u0012\u0006\u0010v\u001a\u00020D\u0012\n\b\u0002\u0010x\u001a\u0004\u0018\u00010w\u0012\b\b\u0002\u0010y\u001a\u00020\u000e\u00a2\u0006\u0004\bz\u0010{J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\tH\u0002J\u0006\u0010\u0010\u001a\u00020\u0003J\b\u0010\u0011\u001a\u00020\u0003H\u0014J\b\u0010\u0012\u001a\u00020\u0003H\u0014J\b\u0010\u0013\u001a\u00020\u000eH\u0014J%\u0010\u0017\u001a\u00020\u00162\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u000eH\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u000eJ\"\u0010 \u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u001f\u001a\u00020\tJ\b\u0010!\u001a\u00020\u0003H\u0014J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u000eH\u0014J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0016H\u0014J\n\u0010+\u001a\u0004\u0018\u00010*H&J\n\u0010,\u001a\u0004\u0018\u00010\u0016H&J\b\u0010-\u001a\u00020\u000eH&J\b\u0010.\u001a\u00020\u0003H&J\b\u0010/\u001a\u00020\u000eH\u0016J\b\u00100\u001a\u00020\fH\u0014R\u001b\u00106\u001a\u0002018DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u00108R#\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007078\u0006\u00a2\u0006\f\n\u0004\b&\u00108\u001a\u0004\b:\u0010;R)\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0>0=8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010?\u001a\u0004\b@\u0010AR \u0010C\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u00108R$\u0010J\u001a\u0004\u0018\u00010D8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010P\u001a\u0004\u0018\u00010\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010W\u001a\u0004\u0018\u00010Q8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u00100R\"\u0010^\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bY\u00100\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010b\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b_\u00100\u001a\u0004\b`\u0010[\"\u0004\ba\u0010]R \u0010h\u001a\b\u0012\u0004\u0012\u00020$0c8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\u0014\u0010k\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010jR\u0014\u0010n\u001a\u00020l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010mR$\u0010p\u001a\u0004\u0018\u00010o8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010u\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView;", "Landroid/widget/LinearLayout;", "", "", "E", "k", "l", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "content", "", "D", "", h.F, "g", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, BdhLogUtil.LogTag.Tag_Conn, "backgroundColor", "rowCount", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Integer;I)Landroid/view/View;", "P", "state", "setState", "y", "r", "showName", "headUrl", "e", "L", "maxLength", "i", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView$b;", "listener", "f", "M", "view", "j", "Landroid/widget/EditText;", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "I", "Landroid/text/Editable$Factory;", "d", "Lkotlin/Lazy;", "t", "()Landroid/text/Editable$Factory;", "emojiEditableFactory", "", "Ljava/util/Map;", "atInfoMap", "B", "()Ljava/util/Map;", "userNameQQUserInfoMapIdMap", "", "Lkotlin/Pair;", "Ljava/util/List;", "p", "()Ljava/util/List;", "atPosUserNameList", "userNameHeadUrl", "Landroid/content/Context;", "Landroid/content/Context;", "o", "()Landroid/content/Context;", "setActivityContext", "(Landroid/content/Context;)V", "activityContext", "Landroid/widget/LinearLayout;", "getInputLayout", "()Landroid/widget/LinearLayout;", "setInputLayout", "(Landroid/widget/LinearLayout;)V", "inputLayout", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "v", "()Landroid/widget/FrameLayout;", "setFuncLayout", "(Landroid/widget/FrameLayout;)V", "funcLayout", "preState", UserInfo.SEX_FEMALE, ReportConstant.COSTREPORT_PREFIX, "()I", "setCurrentState", "(I)V", "currentState", "G", "getKeyboardHeight", "setKeyboardHeight", "keyboardHeight", "Ljava/util/concurrent/CopyOnWriteArrayList;", "H", "Ljava/util/concurrent/CopyOnWriteArrayList;", "getStateChangedListenerList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "stateChangedListenerList", "Lcom/tencent/icgame/game/component/chat/input/KeyboardUtils$b;", "Lcom/tencent/icgame/game/component/chat/input/KeyboardUtils$b;", "layoutListener", "com/tencent/icgame/game/component/chat/input/TimiBaseInputView$c", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView$c;", "emojiCallback", "Lby0/b;", "excludeLineSpan", "Lby0/b;", "u", "()Lby0/b;", "setExcludeLineSpan", "(Lby0/b;)V", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class TimiBaseInputView extends LinearLayout {
    private static final int L = uu0.a.b(20);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LinearLayout inputLayout;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private FrameLayout funcLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private int preState;

    /* renamed from: F, reason: from kotlin metadata */
    private int currentState;

    /* renamed from: G, reason: from kotlin metadata */
    private int keyboardHeight;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<b> stateChangedListenerList;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final KeyboardUtils.b layoutListener;

    /* renamed from: J, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView$b;", "", "", "text", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/icgame/game/component/chat/input/TimiBaseInputView;", "timiBaseInputView", "", "b", "a", "", "state", "onStateChanged", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface b {
        void a(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView);

        void b(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView);

        void onStateChanged(int state);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/icgame/game/component/chat/input/TimiBaseInputView$c", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class c implements EmoticonCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            if (TimiBaseInputView.this.w() != null) {
                TimiBaseInputView.this.L();
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
            AppRuntime peekAppRuntime;
            TimiBaseInputView timiBaseInputView = TimiBaseInputView.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            if (timiBaseInputView.getActivityContext() == null) {
                return;
            }
            EditText w3 = timiBaseInputView.w();
            if (w3 == null) {
                w3 = null;
            } else if (info != null) {
                info.send(peekAppRuntime, timiBaseInputView.getActivityContext(), w3, null);
            }
            m476constructorimpl = Result.m476constructorimpl(w3);
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                g.d("ICGameInputView", String.valueOf(Result.m479exceptionOrNullimpl(m476constructorimpl)));
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/icgame/game/component/chat/input/TimiBaseInputView$e", "Landroid/view/View$OnKeyListener;", "Landroid/view/View;", "v", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class e implements View.OnKeyListener {
        e() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(@Nullable View v3, int keyCode, @NotNull KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getKeyCode() == 67 && event.getAction() == 0) {
                TimiBaseInputView.this.L();
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

    private final String A(CommonOuterClass$QQUserId userId) {
        return userId.user_from.get() + "_" + com.tencent.icgame.game.utils.a.g(userId);
    }

    private final boolean D(String content) {
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

    private final void E() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.inputLayout = linearLayout;
        linearLayout.setBackgroundColor(Color.parseColor("#0B0820"));
        linearLayout.setOrientation(0);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, C()));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.funcLayout = frameLayout;
        frameLayout.setBackgroundColor(-1);
        addView(frameLayout, new LinearLayout.LayoutParams(-1, uu0.a.b(0)));
        LinearLayout linearLayout2 = this.inputLayout;
        if (linearLayout2 != null) {
            View.inflate(getContext(), x(), linearLayout2);
        }
        J();
        EditText w3 = w();
        if (w3 != null) {
            w3.addTextChangedListener(new d());
        }
        View z16 = z();
        if (z16 != null) {
            z16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.game.component.chat.input.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TimiBaseInputView.G(TimiBaseInputView.this, view);
                }
            });
        }
        EditText w16 = w();
        if (w16 != null) {
            w16.setOnKeyListener(new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(TimiBaseInputView this$0, View it) {
        Editable editableText;
        String obj;
        String text;
        boolean contains$default;
        boolean contains$default2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.j(it);
        EditText w3 = this$0.w();
        if (w3 != null && (editableText = w3.getEditableText()) != null && (obj = editableText.toString()) != null) {
            int q16 = this$0.q();
            if (q16 == -1) {
                text = eu0.a.b(obj);
            } else {
                text = eu0.a.c(obj, q16);
            }
            if (!this$0.atPosUserNameList.isEmpty()) {
                Intrinsics.checkNotNullExpressionValue(text, "text");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) text, (CharSequence) "@", false, 2, (Object) null);
                if (contains$default) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it5 = this$0.atPosUserNameList.iterator();
                    while (it5.hasNext()) {
                        String str = (String) ((Pair) it5.next()).getSecond();
                        g.h("ICGameInputView", "send showName= " + str);
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
                        ((b) it6.next()).b(text, messageOuterClass$MsgContent, this$0);
                    }
                }
            }
            for (b bVar : this$0.stateChangedListenerList) {
                Intrinsics.checkNotNullExpressionValue(text, "text");
                bVar.a(text, this$0);
            }
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(TimiBaseInputView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.I()) {
            return;
        }
        if (i3 > 0) {
            TimiInputUtil timiInputUtil = TimiInputUtil.f114909a;
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
    public static final void N(TimiBaseInputView this$0) {
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
        Activity c16 = com.tencent.icgame.game.utils.a.c(this$0);
        if (c16 != null && (frameLayout = (FrameLayout) c16.findViewById(R.id.content)) != null) {
            iBinder = frameLayout.getWindowToken();
        }
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(TimiBaseInputView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout frameLayout = this$0.funcLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0007, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.lastIndexOf$default((java.lang.CharSequence) r9, "@", 0, false, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int h(String content) {
        int lastIndexOf$default;
        if (D(content) && lastIndexOf$default >= 0 && lastIndexOf$default < content.length() - 1) {
            String substring = content.substring(lastIndexOf$default + 1, content.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            if (this.userNameQQUserInfoMapIdMap.containsKey(substring)) {
                return substring.length() + 2;
            }
        }
        return 1;
    }

    private final void k() {
        Activity c16 = com.tencent.icgame.game.utils.a.c(this);
        this.activityContext = c16;
        Window window = null;
        if (!(c16 instanceof Activity)) {
            c16 = null;
        }
        if (c16 != null) {
            window = c16.getWindow();
        }
        if (window == null) {
            return;
        }
        KeyboardUtils.c(this, window, this.layoutListener);
    }

    private final void l() {
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
        KeyboardUtils.g(this, window);
    }

    public static /* synthetic */ View n(TimiBaseInputView timiBaseInputView, Integer num, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                num = null;
            }
            if ((i16 & 2) != 0) {
                i3 = -1;
            }
            return timiBaseInputView.m(num, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: genEmojiPanel");
    }

    @NotNull
    public final Map<String, CommonOuterClass$QQUserId> B() {
        return this.userNameQQUserInfoMapIdMap;
    }

    protected int C() {
        return -2;
    }

    protected boolean I() {
        return false;
    }

    public abstract void J();

    protected void L() {
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
            if (h(substring) == 1) {
                TextUtils.backspace(w3);
                return;
            }
            String substring2 = substring.substring(substring.offsetByCodePoints(0, 0), substring.offsetByCodePoints(0, Math.max(codePointCount - i(substring, Integer.MAX_VALUE), 0)));
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String substring3 = str.substring(selectionStart, str.length());
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String str2 = substring2 + substring3;
            w3.setText(str2);
            w3.setSelection(Math.min(substring2.length(), str2.length()));
        }
    }

    public void M(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.stateChangedListenerList.remove(listener);
    }

    public void P() {
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
            inputMethodManager.showSoftInput(w3, 0, new ResultReceiver(handler) { // from class: com.tencent.icgame.game.component.chat.input.TimiBaseInputView$showKeyBoard$1$1
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

    public final void e(@NotNull CommonOuterClass$QQUserId userId, @Nullable String showName, @NotNull String headUrl) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(headUrl, "headUrl");
        if (showName != null) {
            this.atInfoMap.put(A(userId), showName);
            this.userNameQQUserInfoMapIdMap.put(showName, userId);
            this.userNameHeadUrl.put(showName, headUrl);
        }
    }

    public void f(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.stateChangedListenerList.contains(listener)) {
            this.stateChangedListenerList.add(listener);
        }
    }

    public final void g() {
        EditText w3 = w();
        if (w3 != null) {
            w3.setText("");
        }
    }

    protected int i(@NotNull String content, int maxLength) {
        int i3;
        Intrinsics.checkNotNullParameter(content, "content");
        if (D(content)) {
            i3 = h(content);
        } else {
            i3 = 1;
        }
        String replace = new Regex("@(\\[m\\](\\d+?)\\[\\/m\\])").replace(content, "@");
        int codePointCount = replace.codePointCount(0, replace.length());
        if (replace.codePointCount(0, replace.length()) - i3 > maxLength) {
            String substring = content.substring(content.offsetByCodePoints(0, 0), content.offsetByCodePoints(0, codePointCount - i3));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return i3 + i(substring, maxLength);
        }
        return i3;
    }

    protected void j(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View m(@ColorInt @Nullable Integer backgroundColor, int rowCount) {
        SystemAndEmojiUniversalPanel.Builder builder = new SystemAndEmojiUniversalPanel.Builder(getContext());
        builder.setEmoticonCallback(this.emojiCallback);
        builder.setFilterSysFaceBeyond255Enable(true);
        builder.setShowDescribeInPreview(true);
        if (rowCount != -1) {
            builder.setRowCount(rowCount);
        }
        EditText w3 = w();
        if (w3 != null) {
            builder.setShowDeleteButton(w3);
        }
        SystemAndEmojiUniversalPanel create = builder.create(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(MobileQQ.sMobileQQ.peekAppRuntime()));
        if (backgroundColor != null) {
            create.setBackgroundColor(backgroundColor.intValue());
        }
        Intrinsics.checkNotNullExpressionValue(create, "Builder(context).apply {\u2026oundColor(it) }\n        }");
        return create;
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    protected final Context getActivityContext() {
        return this.activityContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
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
        g.a("ICGameInputView", "state: " + state);
        if (w() != null && this.currentState != 2 && (frameLayout = this.funcLayout) != null) {
            frameLayout.post(new Runnable() { // from class: com.tencent.icgame.game.component.chat.input.b
                @Override // java.lang.Runnable
                public final void run() {
                    TimiBaseInputView.N(TimiBaseInputView.this);
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
            uu0.b.h(frameLayout2, i3);
        }
        if (this.currentState == 1) {
            EditText w3 = w();
            if (w3 != null) {
                w3.clearFocus();
            }
            FrameLayout frameLayout3 = this.funcLayout;
            if (frameLayout3 != null) {
                frameLayout3.post(new Runnable() { // from class: com.tencent.icgame.game.component.chat.input.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        TimiBaseInputView.O(TimiBaseInputView.this);
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
    protected final by0.b u() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: v, reason: from getter */
    public final FrameLayout getFuncLayout() {
        return this.funcLayout;
    }

    @Nullable
    public abstract EditText w();

    public abstract int x();

    /* renamed from: y, reason: from getter */
    public final int getPreState() {
        return this.preState;
    }

    @Nullable
    public abstract View z();

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
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TimiBaseInputView$emojiEditableFactory$2.a>() { // from class: com.tencent.icgame.game.component.chat.input.TimiBaseInputView$emojiEditableFactory$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/icgame/game/component/chat/input/TimiBaseInputView$emojiEditableFactory$2$a", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes7.dex */
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
        TimiInputUtil timiInputUtil = TimiInputUtil.f114909a;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        this.keyboardHeight = timiInputUtil.b(context);
        this.stateChangedListenerList = new CopyOnWriteArrayList<>();
        this.layoutListener = new KeyboardUtils.b() { // from class: com.tencent.icgame.game.component.chat.input.a
            @Override // com.tencent.icgame.game.component.chat.input.KeyboardUtils.b
            public final void a(int i16) {
                TimiBaseInputView.K(TimiBaseInputView.this, i16);
            }
        };
        E();
        setOrientation(1);
        this.emojiCallback = new c();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/icgame/game/component/chat/input/TimiBaseInputView$d", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            TimiBaseInputView.this.u();
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
                if ((!timiBaseInputView.B().isEmpty()) && !android.text.TextUtils.isEmpty(str)) {
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
                        du0.c cVar = du0.c.f394859a;
                        Map<String, CommonOuterClass$QQUserId> B = timiBaseInputView.B();
                        EditText w16 = timiBaseInputView.w();
                        if (w16 != null) {
                            a16 = w16.getCurrentTextColor();
                        } else {
                            a16 = cy0.b.a(com.tencent.mobileqq.R.color.black);
                        }
                        p16.addAll(cVar.c(0, str, B, text, a16, false, null));
                    }
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }
    }
}
