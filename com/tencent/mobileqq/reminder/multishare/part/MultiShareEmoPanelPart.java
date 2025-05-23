package com.tencent.mobileqq.reminder.multishare.part;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonPanel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqemoticon.api.ISystemAndEmojiPanelService;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.inputview.QUIMultiLineInputView;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 72\u00020\u00012\u00020\u0002:\u000289B\u0007\u00a2\u0006\u0004\b5\u00106J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/reminder/multishare/part/MultiShareEmoPanelPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/reminder/multishare/util/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "D9", "view", "F9", "A9", "", "getLogTag", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "onPartResume", "onPartStop", "onPartDestroy", "", "keyboardHeight", "M", "onKeyboardHide", "d", "Landroid/view/View;", "mPanelRoot", "e", "mEmoBtn", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "mEmoPanelContainer", "Lcom/tencent/mobileqq/emoticonview/IEmoticonPanel;", h.F, "Lcom/tencent/mobileqq/emoticonview/IEmoticonPanel;", "mEmoPanel", "Lcom/tencent/mobileqq/widget/inputview/QUIMultiLineInputView;", "i", "Lcom/tencent/mobileqq/widget/inputview/QUIMultiLineInputView;", "mEditText", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mIsKeyboard", "Lcom/tencent/mobileqq/reminder/multishare/util/b;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/reminder/multishare/util/b;", "mKeyboardHelper", "D", "I", "mKeyboardHeight", "<init>", "()V", "E", "a", "b", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class MultiShareEmoPanelPart extends Part implements com.tencent.mobileqq.reminder.multishare.util.a {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mKeyboardHelper;

    /* renamed from: D, reason: from kotlin metadata */
    private int mKeyboardHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mPanelRoot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mEmoBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup mEmoPanelContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IEmoticonPanel mEmoPanel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIMultiLineInputView mEditText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsKeyboard;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/reminder/multishare/part/MultiShareEmoPanelPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.reminder.multishare.part.MultiShareEmoPanelPart$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/reminder/multishare/part/MultiShareEmoPanelPart$b;", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "Landroid/widget/EditText;", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "editText", "<init>", "(Landroid/widget/EditText;)V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements EmoticonCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final EditText editText;

        public b(@Nullable EditText editText) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) editText);
            } else {
                this.editText = editText;
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            EditText editText = this.editText;
            if (editText != null) {
                TextUtils.backspace(editText);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(@Nullable EmoticonInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) info);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(@Nullable EmoticonInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) info)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, oldInfo, newInfo, d16);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(@Nullable EmoticonInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) info);
                return;
            }
            EditText editText = this.editText;
            if (editText != null) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (info != null) {
                    info.send(peekAppRuntime, editText.getContext(), editText, null);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30647);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MultiShareEmoPanelPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsKeyboard = true;
        lazy = LazyKt__LazyJVMKt.lazy(MultiShareEmoPanelPart$mKeyboardHelper$2.INSTANCE);
        this.mKeyboardHelper = lazy;
    }

    private final void A9() {
        DialogFragment dialogFragment;
        Dialog dialog;
        final Window window;
        final WindowManager.LayoutParams attributes;
        final View peekDecorView;
        if (Build.VERSION.SDK_INT <= 29 && com.tencent.mobileqq.reminder.config.b.f281031a.b("notify_card_adapt_emo_panel", true)) {
            Object partHost = getPartHost();
            if (partHost instanceof DialogFragment) {
                dialogFragment = (DialogFragment) partHost;
            } else {
                dialogFragment = null;
            }
            if (dialogFragment != null && (dialog = dialogFragment.getDialog()) != null && (window = dialog.getWindow()) != null && (attributes = window.getAttributes()) != null && (peekDecorView = window.peekDecorView()) != null && attributes.width == -1) {
                peekDecorView.post(new Runnable() { // from class: com.tencent.mobileqq.reminder.multishare.part.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        MultiShareEmoPanelPart.B9(peekDecorView, window, attributes);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(View decorView, Window window, WindowManager.LayoutParams windowAttr) {
        Intrinsics.checkNotNullParameter(decorView, "$decorView");
        Intrinsics.checkNotNullParameter(window, "$window");
        Intrinsics.checkNotNullParameter(windowAttr, "$windowAttr");
        if (decorView.getWidth() <= 0) {
            return;
        }
        QLog.d("MultiShareEmoPanelPart", 1, "adaptWindowForSystemLowerThanQ width: " + decorView.getWidth());
        window.setLayout(decorView.getWidth(), windowAttr.height);
    }

    private final com.tencent.mobileqq.reminder.multishare.util.b C9() {
        return (com.tencent.mobileqq.reminder.multishare.util.b) this.mKeyboardHelper.getValue();
    }

    private final void D9(View rootView) {
        ViewParent viewParent;
        View view;
        View view2 = null;
        if (this.mPanelRoot == null) {
            this.mPanelRoot = LayoutInflater.from(rootView.getContext()).inflate(R.layout.fp_, (ViewGroup) null, false);
        }
        View view3 = this.mPanelRoot;
        if (view3 != null) {
            viewParent = view3.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent != null && (view = this.mPanelRoot) != null) {
            ab.c(view);
        }
        View view4 = this.mPanelRoot;
        if (view4 != null) {
            view4.setVisibility(8);
        }
        View view5 = this.mPanelRoot;
        if (view5 != null) {
            view2 = view5.findViewById(R.id.trq);
        }
        this.mEmoBtn = view2;
        if (view2 != null) {
            view2.setSelected(this.mIsKeyboard);
        }
        View view6 = this.mEmoBtn;
        if (view6 != null) {
            view6.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.reminder.multishare.part.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    MultiShareEmoPanelPart.E9(MultiShareEmoPanelPart.this, view7);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(MultiShareEmoPanelPart this$0, View it) {
        EditText h16;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = !this$0.mIsKeyboard;
        this$0.mIsKeyboard = z16;
        it.setSelected(z16);
        if (this$0.mIsKeyboard) {
            QUIMultiLineInputView qUIMultiLineInputView = this$0.mEditText;
            if (qUIMultiLineInputView != null && (h16 = qUIMultiLineInputView.h()) != null) {
                InputMethodUtil.show(h16);
            }
            ViewGroup viewGroup = this$0.mEmoPanelContainer;
            if (viewGroup != null) {
                viewGroup.setVisibility(4);
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.F9(it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void F9(View view) {
        ISystemAndEmojiPanelService iSystemAndEmojiPanelService;
        ISystemAndEmojiPanelService.a aVar;
        EditText editText;
        IEmoticonPanel iEmoticonPanel;
        ViewGroup viewGroup;
        ISystemAndEmojiPanelService.a a16;
        ISystemAndEmojiPanelService.a c16;
        ISystemAndEmojiPanelService.a a17;
        if (this.mEmoPanel == null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            View view2 = null;
            if (peekAppRuntime != null) {
                iSystemAndEmojiPanelService = (ISystemAndEmojiPanelService) peekAppRuntime.getRuntimeService(ISystemAndEmojiPanelService.class, "all");
            } else {
                iSystemAndEmojiPanelService = null;
            }
            if (iSystemAndEmojiPanelService != null) {
                aVar = iSystemAndEmojiPanelService.newBuilder();
            } else {
                aVar = null;
            }
            QUIMultiLineInputView qUIMultiLineInputView = this.mEditText;
            if (qUIMultiLineInputView != null) {
                editText = qUIMultiLineInputView.h();
            } else {
                editText = null;
            }
            if (aVar != null && (a16 = aVar.a(editText)) != null && (c16 = a16.c(new b(editText))) != null && (a17 = c16.a(editText)) != null) {
                iEmoticonPanel = a17.create();
            } else {
                iEmoticonPanel = null;
            }
            this.mEmoPanel = iEmoticonPanel;
            if (iEmoticonPanel != null) {
                view2 = iEmoticonPanel.getView();
            }
            if (view2 != null && (viewGroup = this.mEmoPanelContainer) != null) {
                int i3 = this.mKeyboardHeight;
                if (i3 <= 0) {
                    i3 = ViewUtils.dpToPx(280.0f);
                }
                viewGroup.addView(view2, -1, i3);
            }
        }
        ViewGroup viewGroup2 = this.mEmoPanelContainer;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        InputMethodUtil.hide(view);
    }

    @Override // com.tencent.mobileqq.reminder.multishare.util.a
    public void M(int keyboardHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, keyboardHeight);
            return;
        }
        this.mIsKeyboard = true;
        View view = this.mEmoBtn;
        if (view != null) {
            view.setSelected(true);
        }
        View view2 = this.mPanelRoot;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ViewGroup viewGroup = this.mEmoPanelContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "MultiShareEmoPanelPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        if (rootView == null) {
            return;
        }
        this.mEditText = (QUIMultiLineInputView) rootView.findViewById(R.id.zix);
        this.mEmoPanelContainer = (ViewGroup) rootView.findViewById(R.id.zir);
        D9(rootView);
        View findViewById = rootView.findViewById(R.id.f166348zj1);
        if (findViewById instanceof ViewGroup) {
            viewGroup = (ViewGroup) findViewById;
        } else {
            viewGroup = null;
        }
        View view = this.mPanelRoot;
        if (view != null && viewGroup != null) {
            viewGroup.addView(view, -1, -2);
        }
        C9().b(this);
    }

    @Override // com.tencent.mobileqq.reminder.multishare.util.a
    public void onKeyboardHide() {
        ViewGroup.LayoutParams layoutParams;
        int i3;
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.mIsKeyboard) {
            View view2 = this.mPanelRoot;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            ViewGroup viewGroup = this.mEmoPanelContainer;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mKeyboardHeight > 0) {
            IEmoticonPanel iEmoticonPanel = this.mEmoPanel;
            View view3 = null;
            if (iEmoticonPanel != null && (view = iEmoticonPanel.getView()) != null) {
                layoutParams = view.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null && (i3 = this.mKeyboardHeight) != layoutParams.height) {
                layoutParams.height = i3;
                IEmoticonPanel iEmoticonPanel2 = this.mEmoPanel;
                if (iEmoticonPanel2 != null) {
                    view3 = iEmoticonPanel2.getView();
                }
                if (view3 != null) {
                    view3.setLayoutParams(layoutParams);
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        IEmoticonPanel iEmoticonPanel = this.mEmoPanel;
        if (iEmoticonPanel != null) {
            iEmoticonPanel.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            super.onPartResume(activity);
            A9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartStart(activity);
        if (getPartHost() != null) {
            com.tencent.mobileqq.reminder.multishare.util.b C9 = C9();
            IPartHost partHost = getPartHost();
            Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
            C9.a(partHost);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
        } else {
            super.onPartStop(activity);
            C9().c();
        }
    }
}
