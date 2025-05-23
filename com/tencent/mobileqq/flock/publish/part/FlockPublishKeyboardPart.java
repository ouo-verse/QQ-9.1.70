package com.tencent.mobileqq.flock.publish.part;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.flock.publish.part.FlockPublishKeyboardPart;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqemoticon.api.ISysEmoApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.SoftKeyboardStateHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u000e\u0018\u0000 =2\u00020\u0001:\u0002>?B\u0017\u0012\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\nR\u001c\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R#\u0010)\u001a\n $*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u001bR\u001b\u00106\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010&\u001a\u0004\b5\u0010\u0010R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "K9", "", "keyboardHeightInPx", "N9", "P9", "", "isManually", "F9", "J9", "com/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart$b", "G9", "()Lcom/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart$b;", "onInitView", "E9", "enable", "O9", "Lkotlin/Function0;", "Landroid/widget/EditText;", "d", "Lkotlin/jvm/functions/Function0;", "getFocusedEditText", "e", "Landroid/view/View;", "keyboardContainer", "f", "keyboardSwitcherLayout", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "keyboardSwitcherBtn", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "i", "Lkotlin/Lazy;", "I9", "()Landroid/view/ViewGroup;", "emojiKeyboardContainer", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper;", "keyboardHelper", "Landroid/view/inputmethod/InputMethodManager;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/inputmethod/InputMethodManager;", "imm", "D", "emojiKeyboard", "E", "H9", "emojiCallback", "Lcom/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart$KeyboardStatus;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart$KeyboardStatus;", "keyboardStatus", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "G", "a", "KeyboardStatus", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockPublishKeyboardPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private InputMethodManager imm;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View emojiKeyboard;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy emojiCallback;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private KeyboardStatus keyboardStatus;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<EditText> getFocusedEditText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View keyboardContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View keyboardSwitcherLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView keyboardSwitcherBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy emojiKeyboardContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SoftKeyboardStateHelper keyboardHelper;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart$KeyboardStatus;", "", "(Ljava/lang/String;I)V", "CLOSE", "SOFT", "EMOJI", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class KeyboardStatus {
        private static final /* synthetic */ KeyboardStatus[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final KeyboardStatus CLOSE;
        public static final KeyboardStatus EMOJI;
        public static final KeyboardStatus SOFT;

        private static final /* synthetic */ KeyboardStatus[] $values() {
            return new KeyboardStatus[]{CLOSE, SOFT, EMOJI};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48343);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            CLOSE = new KeyboardStatus("CLOSE", 0);
            SOFT = new KeyboardStatus("SOFT", 1);
            EMOJI = new KeyboardStatus("EMOJI", 2);
            $VALUES = $values();
        }

        KeyboardStatus(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static KeyboardStatus valueOf(String str) {
            return (KeyboardStatus) Enum.valueOf(KeyboardStatus.class, str);
        }

        public static KeyboardStatus[] values() {
            return (KeyboardStatus[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.publish.part.FlockPublishKeyboardPart$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart$b", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements EmoticonCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockPublishKeyboardPart.this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            int selectionStart;
            int coerceAtMost;
            int coerceAtLeast;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            EditText editText = (EditText) FlockPublishKeyboardPart.this.getFocusedEditText.invoke();
            if (editText == null || (selectionStart = editText.getSelectionStart()) == 0) {
                return;
            }
            try {
                int offsetBefore = TextUtils.getOffsetBefore(editText.getText(), selectionStart);
                if (selectionStart != offsetBefore) {
                    Editable text = editText.getText();
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(selectionStart, offsetBefore);
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(selectionStart, offsetBefore);
                    text.delete(coerceAtMost, coerceAtLeast);
                }
            } catch (Exception e16) {
                QLog.e("FlockPublishKeyboardPart", 1, "onEmojiDelete", e16);
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
            return true;
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
            EditText editText = (EditText) FlockPublishKeyboardPart.this.getFocusedEditText.invoke();
            if (editText != null) {
                if (info instanceof SystemEmoticonInfo) {
                    int selectionStart = editText.getSelectionStart();
                    int selectionEnd = editText.getSelectionEnd();
                    if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                        return;
                    }
                    editText.getEditableText().replace(selectionStart, selectionEnd, QQSysFaceUtil.getFaceString(((SystemEmoticonInfo) info).code));
                    return;
                }
                if (info instanceof SystemAndEmojiEmoticonInfo) {
                    int selectionStart2 = editText.getSelectionStart();
                    int selectionEnd2 = editText.getSelectionEnd();
                    SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) info;
                    int i3 = systemAndEmojiEmoticonInfo.emotionType;
                    int i16 = systemAndEmojiEmoticonInfo.code;
                    if (selectionStart2 >= 0 && selectionEnd2 >= 0 && selectionEnd2 >= selectionStart2) {
                        if (i3 == 2 && i16 == -1) {
                            return;
                        }
                        editText.getEditableText().replace(selectionStart2, selectionEnd2, ((ISysEmoApi) QRoute.api(ISysEmoApi.class)).getEmoString(i3, i16));
                        editText.requestFocus();
                    }
                    systemAndEmojiEmoticonInfo.addToCommonUsed(MobileQQ.sMobileQQ.peekAppRuntime(), (Parcelable) null);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/flock/publish/part/FlockPublishKeyboardPart$c", "Lcom/tencent/mobileqq/widget/SoftKeyboardStateHelper$SoftKeyboardStateListener;", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockPublishKeyboardPart.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                FlockPublishKeyboardPart.this.F9(false);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FlockPublishKeyboardPart.this.N9(keyboardHeightInPx);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, keyboardHeightInPx);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48348);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlockPublishKeyboardPart(@NotNull Function0<? extends EditText> getFocusedEditText) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(getFocusedEditText, "getFocusedEditText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) getFocusedEditText);
            return;
        }
        this.getFocusedEditText = getFocusedEditText;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ViewGroup>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishKeyboardPart$emojiKeyboardContainer$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishKeyboardPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (ViewGroup) FlockPublishKeyboardPart.this.getPartRootView().findViewById(R.id.f165078ut0) : (ViewGroup) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.emojiKeyboardContainer = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.flock.publish.part.FlockPublishKeyboardPart$emojiCallback$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockPublishKeyboardPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FlockPublishKeyboardPart.b invoke() {
                FlockPublishKeyboardPart.b G9;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (FlockPublishKeyboardPart.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                G9 = FlockPublishKeyboardPart.this.G9();
                return G9;
            }
        });
        this.emojiCallback = lazy2;
        this.keyboardStatus = KeyboardStatus.CLOSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(boolean isManually) {
        KeyboardStatus keyboardStatus = this.keyboardStatus;
        KeyboardStatus keyboardStatus2 = KeyboardStatus.CLOSE;
        if (keyboardStatus == keyboardStatus2) {
            return;
        }
        if (!isManually && keyboardStatus != KeyboardStatus.SOFT) {
            return;
        }
        this.keyboardStatus = keyboardStatus2;
        InputMethodManager inputMethodManager = this.imm;
        View view = null;
        if (inputMethodManager != null) {
            View view2 = this.keyboardContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyboardContainer");
                view2 = null;
            }
            inputMethodManager.hideSoftInputFromWindow(view2.getWindowToken(), 0);
        }
        View view3 = this.keyboardContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyboardContainer");
        } else {
            view = view3;
        }
        view.setVisibility(4);
        View view4 = this.emojiKeyboard;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        ImageView imageView = this.keyboardSwitcherBtn;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.qui_emoji_selector);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b G9() {
        return new b();
    }

    private final b H9() {
        return (b) this.emojiCallback.getValue();
    }

    private final ViewGroup I9() {
        return (ViewGroup) this.emojiKeyboardContainer.getValue();
    }

    private final void J9() {
        int i3;
        SystemAndEmojiUniversalPanel create = new SystemAndEmojiUniversalPanel.Builder(getContext()).setEmoticonCallback(H9()).setShowCommonUsedSystemEmoji(true).create(((IEmoticonMainPanelAppService) QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(MobileQQ.sMobileQQ.peekAppRuntime()));
        View view = this.keyboardSwitcherLayout;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                layoutParams = null;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams != null) {
                i3 = marginLayoutParams.bottomMargin;
            } else {
                i3 = 0;
            }
        } else {
            i3 = -2;
        }
        I9().addView(create, new LinearLayout.LayoutParams(-1, i3));
        this.emojiKeyboard = create;
    }

    private final void K9(View rootView) {
        SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(rootView);
        softKeyboardStateHelper.addSoftKeyboardStateListener(new c());
        this.keyboardHelper = softKeyboardStateHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(FlockPublishKeyboardPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(FlockPublishKeyboardPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F9(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(int keyboardHeightInPx) {
        this.keyboardStatus = KeyboardStatus.SOFT;
        ImageView imageView = this.keyboardSwitcherBtn;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.qui_emoji_selector);
        }
        View view = this.keyboardSwitcherLayout;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.bottomMargin = keyboardHeightInPx;
                view.setLayoutParams(layoutParams2);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            }
        }
        View view2 = this.keyboardContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyboardContainer");
            view2 = null;
        }
        view2.setVisibility(0);
    }

    private final void P9() {
        InputMethodManager inputMethodManager;
        KeyboardStatus keyboardStatus = this.keyboardStatus;
        KeyboardStatus keyboardStatus2 = KeyboardStatus.SOFT;
        if (keyboardStatus == keyboardStatus2) {
            this.keyboardStatus = KeyboardStatus.EMOJI;
            ImageView imageView = this.keyboardSwitcherBtn;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.qui_keyboard_circle);
            }
            if (this.emojiKeyboard == null) {
                J9();
            }
            View view = this.emojiKeyboard;
            if (view != null) {
                view.setVisibility(0);
            }
            InputMethodManager inputMethodManager2 = this.imm;
            if (inputMethodManager2 != null) {
                View view2 = this.keyboardContainer;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("keyboardContainer");
                    view2 = null;
                }
                inputMethodManager2.hideSoftInputFromWindow(view2.getWindowToken(), 0);
                return;
            }
            return;
        }
        if (keyboardStatus == KeyboardStatus.EMOJI) {
            this.keyboardStatus = keyboardStatus2;
            ImageView imageView2 = this.keyboardSwitcherBtn;
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.qui_emoji_selector);
            }
            EditText invoke = this.getFocusedEditText.invoke();
            if (invoke != null && (inputMethodManager = this.imm) != null) {
                inputMethodManager.showSoftInput(invoke, 2);
            }
        }
    }

    public final boolean E9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.keyboardStatus == KeyboardStatus.CLOSE) {
            return false;
        }
        F9(true);
        return true;
    }

    public final void O9(boolean enable) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, enable);
            return;
        }
        View view = this.keyboardSwitcherLayout;
        if (view != null) {
            if (enable) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        InputMethodManager inputMethodManager;
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Activity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(3);
            window.setSoftInputMode(32);
        }
        Object systemService = getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (systemService instanceof InputMethodManager) {
            inputMethodManager = (InputMethodManager) systemService;
        } else {
            inputMethodManager = null;
        }
        this.imm = inputMethodManager;
        View findViewById = rootView.findViewById(R.id.vbn);
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.ybo);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.publish.part.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlockPublishKeyboardPart.L9(FlockPublishKeyboardPart.this, view);
            }
        });
        this.keyboardSwitcherBtn = imageView;
        findViewById.findViewById(R.id.ybn).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.publish.part.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlockPublishKeyboardPart.M9(FlockPublishKeyboardPart.this, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Vi\u2026)\n            }\n        }");
        this.keyboardContainer = findViewById;
        this.keyboardSwitcherLayout = rootView.findViewById(R.id.ybp);
        K9(rootView);
    }
}
