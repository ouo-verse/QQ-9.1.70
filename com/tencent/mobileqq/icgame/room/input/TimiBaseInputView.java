package com.tencent.mobileqq.icgame.room.input;

import android.R;
import android.app.Activity;
import android.content.Context;
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
import android.view.ViewGroup;
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
import com.tencent.icgame.game.component.chat.input.TimiInputUtil;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUser;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUserMsg;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.room.input.TimiBaseInputView$emojiEditableFactory$2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001c\b&\u0018\u0000 \u00132\u00020\u00012\u00020\u0002:\u0002stB'\b\u0007\u0012\u0006\u0010m\u001a\u00020G\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010n\u0012\b\b\u0002\u0010p\u001a\u00020\u0010\u00a2\u0006\u0004\bq\u0010rJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0014\u0010\u0013\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u000eJ\b\u0010\u0016\u001a\u00020\u0003H\u0014J\b\u0010\u0017\u001a\u00020\u0003H\u0014J%\u0010\u001a\u001a\u00020\u00072\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u0010H\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u000e\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0010J\u0006\u0010\u001f\u001a\u00020\u0010J*\u0010#\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000bJ\b\u0010$\u001a\u00020\u0003H\u0014J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0010H\u0014J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0007H\u0014J\n\u0010-\u001a\u0004\u0018\u00010,H&J\n\u0010.\u001a\u0004\u0018\u00010\u0007H&J\b\u0010/\u001a\u00020\u0010H&J\b\u00100\u001a\u00020\u0003H&J\b\u00101\u001a\u00020\u0010H\u0016R\u001b\u00107\u001a\u0002028DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R \u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010:R#\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t088\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010:\u001a\u0004\b=\u0010>R)\u0010E\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0A0@8\u0006\u00a2\u0006\f\n\u0004\b&\u0010B\u001a\u0004\bC\u0010DR \u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010:R\u0018\u0010I\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010KR$\u0010R\u001a\u0004\u0018\u00010J8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010K\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u00100R\"\u0010Y\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u00100\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0016\u0010[\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u00100R\u001a\u0010^\u001a\b\u0012\u0004\u0012\u00020'0\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010]R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010e\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010dR$\u0010g\u001a\u0004\u0018\u00010f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010l\u00a8\u0006u"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/input/TimiBaseInputView;", "Landroid/widget/LinearLayout;", "", "", "D", "k", "l", "Landroid/view/View;", "r", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "content", "", BdhLogUtil.LogTag.Tag_Conn, "", tl.h.F, "height", "L", "p", "G", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "backgroundColor", "rowCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Integer;I)Landroid/view/View;", "O", "state", "setState", "y", "showName", "showUserName", "headUrl", "f", "K", "maxLength", "i", "Lcom/tencent/mobileqq/icgame/room/input/TimiBaseInputView$b;", "listener", "g", "view", "j", "Landroid/widget/EditText;", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/text/Editable$Factory;", "d", "Lkotlin/Lazy;", "t", "()Landroid/text/Editable$Factory;", "emojiEditableFactory", "", "e", "Ljava/util/Map;", "atInfoMap", "userIdToShowNameMap", "B", "()Ljava/util/Map;", "userNameQQUserInfoMapIdMap", "", "Lkotlin/Pair;", "Ljava/util/List;", "o", "()Ljava/util/List;", "atPosUserNameList", "userNameHeadUrl", "Landroid/content/Context;", "Landroid/content/Context;", "activityContext", "Landroid/widget/FrameLayout;", "Landroid/widget/FrameLayout;", "inputLayout", "E", "v", "()Landroid/widget/FrameLayout;", "setFuncLayout", "(Landroid/widget/FrameLayout;)V", "funcLayout", UserInfo.SEX_FEMALE, "preState", ReportConstant.COSTREPORT_PREFIX, "()I", "setCurrentState", "(I)V", "currentState", "H", "keyboardHeight", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "stateChangedListenerList", "Lcom/tencent/icgame/game/component/chat/input/KeyboardUtils$b;", "J", "Lcom/tencent/icgame/game/component/chat/input/KeyboardUtils$b;", "layoutListener", "com/tencent/mobileqq/icgame/room/input/TimiBaseInputView$c", "Lcom/tencent/mobileqq/icgame/room/input/TimiBaseInputView$c;", "emojiCallback", "Lcom/tencent/mobileqq/icgame/room/input/g;", "excludeLineSpan", "Lcom/tencent/mobileqq/icgame/room/input/g;", "u", "()Lcom/tencent/mobileqq/icgame/room/input/g;", "setExcludeLineSpan", "(Lcom/tencent/mobileqq/icgame/room/input/g;)V", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class TimiBaseInputView extends LinearLayout {
    private static final int M = uu0.a.b(20);

    /* renamed from: C */
    @Nullable
    private Context activityContext;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private FrameLayout inputLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private FrameLayout funcLayout;

    /* renamed from: F */
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

    /* renamed from: d, reason: from kotlin metadata */
    @NotNull
    private final Lazy emojiEditableFactory;

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> atInfoMap;

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private final Map<String, String> userIdToShowNameMap;

    /* renamed from: h */
    @NotNull
    private final Map<String, CommonOuterClass$QQUserId> userNameQQUserInfoMapIdMap;

    /* renamed from: i, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<Integer, String>> atPosUserNameList;

    /* renamed from: m */
    @NotNull
    private final Map<String, String> userNameHeadUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/input/TimiBaseInputView$b;", "", "", "text", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$MsgContent;", "content", "Lcom/tencent/mobileqq/icgame/room/input/TimiBaseInputView;", "timiBaseInputView", "", "b", "a", "", "state", "onStateChanged", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface b {
        void a(@NotNull String text, @NotNull TimiBaseInputView timiBaseInputView);

        void b(@NotNull String text, @NotNull MessageOuterClass$MsgContent content, @NotNull TimiBaseInputView timiBaseInputView);

        void onStateChanged(int state);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/icgame/room/input/TimiBaseInputView$c", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements EmoticonCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            if (TimiBaseInputView.this.getEditText() != null) {
                TimiBaseInputView.this.K();
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(@Nullable EmoticonInfo emoticonInfo) {
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
            if (timiBaseInputView.activityContext == null) {
                return;
            }
            EditText editText = timiBaseInputView.getEditText();
            if (editText == null) {
                editText = null;
            } else if (info != null) {
                info.send(peekAppRuntime, timiBaseInputView.activityContext, editText, null);
            }
            m476constructorimpl = Result.m476constructorimpl(editText);
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                QLog.e("ICGameInputView", 1, String.valueOf(Result.m479exceptionOrNullimpl(m476constructorimpl)));
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/icgame/room/input/TimiBaseInputView$e", "Landroid/view/View$OnKeyListener;", "Landroid/view/View;", "v", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class e implements View.OnKeyListener {
        e() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(@Nullable View v3, int keyCode, @NotNull KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getKeyCode() == 67 && event.getAction() == 0) {
                TimiBaseInputView.this.K();
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

    private final String A(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
        return commonOuterClass$QQUserId.user_from.get() + "_" + com.tencent.icgame.game.utils.a.g(commonOuterClass$QQUserId);
    }

    private final boolean C(String str) {
        boolean endsWith$default;
        boolean contains$default;
        if (!this.userNameQQUserInfoMapIdMap.isEmpty()) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str, " ", false, 2, null);
            if (endsWith$default) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "@", false, 2, (Object) null);
                if (contains$default) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void D() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.inputLayout = frameLayout;
        addView(frameLayout, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.funcLayout = frameLayout2;
        frameLayout2.setBackgroundColor(-1);
        addView(frameLayout2, new LinearLayout.LayoutParams(-1, uu0.a.b(0)));
        FrameLayout frameLayout3 = this.inputLayout;
        if (frameLayout3 != null) {
            View.inflate(getContext(), x(), frameLayout3);
        }
        I();
        EditText editText = getEditText();
        if (editText != null) {
            editText.addTextChangedListener(new d());
        }
        View sendView = getSendView();
        if (sendView != null) {
            sendView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.icgame.room.input.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TimiBaseInputView.E(TimiBaseInputView.this, view);
                }
            });
        }
        EditText editText2 = getEditText();
        if (editText2 != null) {
            editText2.setOnKeyListener(new e());
        }
    }

    public static final void E(TimiBaseInputView this$0, View it) {
        Editable editableText;
        String obj;
        String text;
        boolean contains$default;
        String text2;
        String str;
        boolean contains$default2;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.j(it);
        EditText editText = this$0.getEditText();
        if (editText != null && (editableText = editText.getEditableText()) != null && (obj = editableText.toString()) != null) {
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
                    loop0: while (true) {
                        text2 = text;
                        while (it5.hasNext()) {
                            str = (String) ((Pair) it5.next()).getSecond();
                            Intrinsics.checkNotNullExpressionValue(text2, "text");
                            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) text2, (CharSequence) ("@" + str), false, 2, (Object) null);
                            if (contains$default2) {
                                break;
                            }
                        }
                        MessageOuterClass$AtUser messageOuterClass$AtUser = new MessageOuterClass$AtUser();
                        CommonOuterClass$QQUserId commonOuterClass$QQUserId = this$0.userNameQQUserInfoMapIdMap.get(str);
                        Map<String, String> map = this$0.userIdToShowNameMap;
                        Intrinsics.checkNotNull(commonOuterClass$QQUserId);
                        String str2 = map.get(this$0.A(commonOuterClass$QQUserId));
                        messageOuterClass$AtUser.user_id.set(this$0.userNameQQUserInfoMapIdMap.get(str));
                        messageOuterClass$AtUser.nick_name.set(str2);
                        messageOuterClass$AtUser.head_url.set(this$0.userNameHeadUrl.get(str));
                        arrayList.add(messageOuterClass$AtUser);
                        text = StringsKt__StringsJVMKt.replace$default(text2, "@" + str, "@" + str2, false, 4, (Object) null);
                    }
                    MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg = new MessageOuterClass$AtUserMsg();
                    messageOuterClass$AtUserMsg.user_list.set(arrayList);
                    messageOuterClass$AtUserMsg.text.set(text2);
                    MessageOuterClass$MsgContent messageOuterClass$MsgContent = new MessageOuterClass$MsgContent();
                    messageOuterClass$MsgContent.at_user_msg.set(messageOuterClass$AtUserMsg);
                    for (b bVar : this$0.stateChangedListenerList) {
                        Intrinsics.checkNotNullExpressionValue(text2, "text");
                        bVar.b(text2, messageOuterClass$MsgContent, this$0);
                    }
                }
            }
            for (b bVar2 : this$0.stateChangedListenerList) {
                Intrinsics.checkNotNullExpressionValue(text, "text");
                bVar2.a(text, this$0);
            }
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    public static final void J(TimiBaseInputView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
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

    private final void L(View view, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ICGameInputView", 1, "keyboardHeight: " + i3);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i3;
        }
        view.setLayoutParams(layoutParams);
    }

    public static final void M(TimiBaseInputView this$0) {
        Object obj;
        InputMethodManager inputMethodManager;
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
        View r16 = this$0.r();
        if (r16 != null) {
            iBinder = r16.getWindowToken();
        }
        if (iBinder != null && inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        }
    }

    public static final void N(TimiBaseInputView this$0) {
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
    private final int h(String str) {
        int lastIndexOf$default;
        if (C(str) && lastIndexOf$default >= 0 && lastIndexOf$default < str.length() - 1) {
            String substring = str.substring(lastIndexOf$default + 1, str.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            if (this.userNameQQUserInfoMapIdMap.containsKey(substring)) {
                return substring.length() + 2;
            }
        }
        return 1;
    }

    private final void k() {
        Context context;
        Activity activity;
        View r16 = r();
        Window window = null;
        if (r16 != null) {
            context = r16.getContext();
        } else {
            context = null;
        }
        this.activityContext = context;
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

    private final View r() {
        ViewGroup viewGroup;
        FrameLayout frameLayout;
        View rootView = getRootView();
        if (rootView instanceof ViewGroup) {
            viewGroup = (ViewGroup) rootView;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null || (frameLayout = (FrameLayout) viewGroup.findViewById(R.id.content)) == null) {
            return null;
        }
        return frameLayout.getChildAt(0);
    }

    @NotNull
    public final Map<String, CommonOuterClass$QQUserId> B() {
        return this.userNameQQUserInfoMapIdMap;
    }

    public final boolean G() {
        Editable editableText;
        String obj;
        boolean contains$default;
        EditText editText = getEditText();
        if (editText == null || (editableText = editText.getEditableText()) == null || (obj = editableText.toString()) == null) {
            return false;
        }
        String emotionText = eu0.a.b(obj);
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

    public abstract void I();

    protected void K() {
        String str;
        EditText editText = getEditText();
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
            if (h(substring) == 1) {
                TextUtils.backspace(editText);
                return;
            }
            String substring2 = substring.substring(substring.offsetByCodePoints(0, 0), substring.offsetByCodePoints(0, Math.max(codePointCount - i(substring, Integer.MAX_VALUE), 0)));
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String substring3 = str.substring(selectionStart, str.length());
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String str2 = substring2 + substring3;
            editText.setText(str2);
            editText.setSelection(Math.min(substring2.length(), str2.length()));
        }
    }

    public void O() {
        Context context;
        Object obj;
        EditText editText = getEditText();
        if (editText == null || (context = this.activityContext) == null) {
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
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, 0, new ResultReceiver(new Handler()) { // from class: com.tencent.mobileqq.icgame.room.input.TimiBaseInputView$showKeyBoard$1$1
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

    public final void f(@NotNull CommonOuterClass$QQUserId userId, @Nullable String showName, @NotNull String showUserName, @NotNull String headUrl) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(showUserName, "showUserName");
        Intrinsics.checkNotNullParameter(headUrl, "headUrl");
        this.atInfoMap.put(A(userId), showUserName);
        Map<String, String> map = this.userIdToShowNameMap;
        String A = A(userId);
        Intrinsics.checkNotNull(showName);
        map.put(A, showName);
        this.userNameQQUserInfoMapIdMap.put(showUserName, userId);
        this.userNameHeadUrl.put(showUserName, headUrl);
    }

    public void g(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.stateChangedListenerList.contains(listener)) {
            this.stateChangedListenerList.add(listener);
        }
    }

    protected int i(@NotNull String content, int maxLength) {
        int i3;
        Intrinsics.checkNotNullParameter(content, "content");
        if (C(content)) {
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

    @NotNull
    protected final View m(@ColorInt @Nullable Integer num, int i3) {
        SystemAndEmojiUniversalPanel.Builder builder = new SystemAndEmojiUniversalPanel.Builder(getContext());
        builder.setEmoticonCallback(this.emojiCallback);
        builder.setFilterSysFaceBeyond255Enable(true);
        builder.setShowDescribeInPreview(true);
        builder.setIgnoreUIToken(true);
        if (i3 != -1) {
            builder.setRowCount(i3);
        }
        EditText editText = getEditText();
        if (editText != null) {
            builder.setShowDeleteButton(editText);
        }
        SystemAndEmojiUniversalPanel create = builder.create(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(MobileQQ.sMobileQQ.peekAppRuntime()));
        if (num != null) {
            create.setBackgroundColor(num.intValue());
        }
        Intrinsics.checkNotNullExpressionValue(create, "Builder(context).apply {\u2026oundColor(it) }\n        }");
        return create;
    }

    @NotNull
    public final List<Pair<Integer, String>> o() {
        return this.atPosUserNameList;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        k();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
        this.activityContext = null;
    }

    @NotNull
    public final String p() {
        Editable editableText;
        String obj;
        EditText editText = getEditText();
        if (editText == null || (editableText = editText.getEditableText()) == null || (obj = editableText.toString()) == null) {
            return "";
        }
        return obj;
    }

    public int q() {
        return -1;
    }

    /* renamed from: s, reason: from getter */
    public final int getCurrentState() {
        return this.currentState;
    }

    public final void setState(int state) {
        int i3;
        FrameLayout frameLayout;
        this.preState = this.currentState;
        this.currentState = state;
        if (getEditText() != null && this.currentState != 2 && (frameLayout = this.funcLayout) != null) {
            frameLayout.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.input.j
                @Override // java.lang.Runnable
                public final void run() {
                    TimiBaseInputView.M(TimiBaseInputView.this);
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
            L(frameLayout2, i3);
        }
        if (this.currentState == 1) {
            EditText editText = getEditText();
            if (editText != null) {
                editText.clearFocus();
            }
            FrameLayout frameLayout3 = this.funcLayout;
            if (frameLayout3 != null) {
                frameLayout3.post(new Runnable() { // from class: com.tencent.mobileqq.icgame.room.input.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        TimiBaseInputView.N(TimiBaseInputView.this);
                    }
                });
            }
        }
        Iterator<T> it = this.stateChangedListenerList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).onStateChanged(this.currentState);
        }
    }

    @NotNull
    public final Editable.Factory t() {
        return (Editable.Factory) this.emojiEditableFactory.getValue();
    }

    @Nullable
    protected final g u() {
        return null;
    }

    @Nullable
    /* renamed from: v, reason: from getter */
    public final FrameLayout getFuncLayout() {
        return this.funcLayout;
    }

    @Nullable
    /* renamed from: w */
    public abstract EditText getEditText();

    public abstract int x();

    /* renamed from: y, reason: from getter */
    public final int getPreState() {
        return this.preState;
    }

    @Nullable
    /* renamed from: z */
    public abstract View getSendView();

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
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TimiBaseInputView$emojiEditableFactory$2.a>() { // from class: com.tencent.mobileqq.icgame.room.input.TimiBaseInputView$emojiEditableFactory$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/icgame/room/input/TimiBaseInputView$emojiEditableFactory$2$a", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes15.dex */
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
        this.userIdToShowNameMap = new LinkedHashMap();
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
        this.layoutListener = new KeyboardUtils.b() { // from class: com.tencent.mobileqq.icgame.room.input.l
            @Override // com.tencent.icgame.game.component.chat.input.KeyboardUtils.b
            public final void a(int i16) {
                TimiBaseInputView.J(TimiBaseInputView.this, i16);
            }
        };
        D();
        setOrientation(1);
        this.emojiCallback = new c();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/icgame/room/input/TimiBaseInputView$d", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable r16) {
            TimiBaseInputView.this.u();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence r95, int start, int before, int count) {
            String str;
            Editable text;
            boolean contains$default;
            int a16;
            if (r95 != null) {
                str = r95.toString();
            } else {
                str = null;
            }
            EditText editText = TimiBaseInputView.this.getEditText();
            if (editText != null && (text = editText.getText()) != null) {
                TimiBaseInputView timiBaseInputView = TimiBaseInputView.this;
                if ((!timiBaseInputView.B().isEmpty()) && !android.text.TextUtils.isEmpty(str)) {
                    Intrinsics.checkNotNull(str);
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "@", false, 2, (Object) null);
                    if (contains$default) {
                        Object[] spans = text.getSpans(0, text.length(), ForegroundColorSpan.class);
                        Intrinsics.checkNotNullExpressionValue(spans, "it.getSpans(0, it.length\u2026undColorSpan::class.java)");
                        for (ForegroundColorSpan foregroundColorSpan : (ForegroundColorSpan[]) spans) {
                            text.removeSpan(foregroundColorSpan);
                            text.removeSpan(foregroundColorSpan);
                        }
                        timiBaseInputView.o().clear();
                        List<Pair<Integer, String>> o16 = timiBaseInputView.o();
                        f fVar = f.f237645a;
                        Map<String, CommonOuterClass$QQUserId> B = timiBaseInputView.B();
                        EditText editText2 = timiBaseInputView.getEditText();
                        if (editText2 != null) {
                            a16 = editText2.getCurrentTextColor();
                        } else {
                            a16 = cy0.b.a(com.tencent.mobileqq.R.color.black);
                        }
                        o16.addAll(fVar.c(0, str, B, text, a16, false, null));
                    }
                }
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence r16, int start, int count, int after) {
        }
    }
}
