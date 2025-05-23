package com.tencent.av.ui.chatroom;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.av.ui.chatroom.VideoChatRoomListView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements EmoticonCallback, Handler.Callback, ViewTreeObserver.OnGlobalLayoutListener {
    private static final int L = 2131245456;
    private static final int M = 2131245457;
    private static final String N = BaseApplication.getContext().getString(R.string.f1780035h);
    private static final String P = BaseApplication.getContext().getString(R.string.f1780235j);
    private g G;

    /* renamed from: d, reason: collision with root package name */
    private final Activity f75498d;

    /* renamed from: e, reason: collision with root package name */
    private final InputMethodManager f75499e;

    /* renamed from: f, reason: collision with root package name */
    private EditText f75500f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f75501h;

    /* renamed from: i, reason: collision with root package name */
    private ViewGroup f75502i;

    /* renamed from: m, reason: collision with root package name */
    private int f75503m = 0;
    private int C = 0;
    private int D = 0;
    private final Rect E = new Rect();
    private final Point F = new Point();
    private final WeakReferenceHandler H = new WeakReferenceHandler(Looper.getMainLooper(), this);
    public boolean I = false;
    private int J = -1;
    private int K = -1;

    /* compiled from: P */
    /* renamed from: com.tencent.av.ui.chatroom.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class ViewOnClickListenerC0758a implements View.OnClickListener {
        ViewOnClickListenerC0758a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            a.this.v();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class c implements View.OnKeyListener {
        c() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                if (i3 == 23 || i3 == 66) {
                    a.this.t();
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class d extends AccessibilityDelegateCompat {
        d() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            String emoticonToTextForTalkBack = TextUtils.emoticonToTextForTalkBack(((EditText) view).getText().toString());
            accessibilityNodeInfoCompat.setText(emoticonToTextForTalkBack);
            accessibilityNodeInfoCompat.setContentDescription(emoticonToTextForTalkBack);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (a.this.f75502i == null || !a.this.f75502i.isShown()) {
                a.this.u();
            } else {
                a.this.v();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class f implements VideoChatRoomListView.a {
        f() {
        }

        @Override // com.tencent.av.ui.chatroom.VideoChatRoomListView.a
        public boolean b(MotionEvent motionEvent, boolean z16) {
            if (z16) {
                if (a.this.r()) {
                    a.this.o();
                    return false;
                }
                if (a.this.p()) {
                    a.this.n();
                    return false;
                }
                if (a.this.G != null) {
                    a.this.G.e(motionEvent);
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface g {
        void a(int i3, int i16, int i17, long j3);

        void b(int i3, int i16, int i17, long j3);

        void c(int i3, long j3);

        void d(String str);

        void e(MotionEvent motionEvent);
    }

    a(Activity activity) {
        this.f75498d = activity;
        this.f75499e = (InputMethodManager) activity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        activity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
        int i3 = Build.VERSION.SDK_INT;
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomUtil", 2, "EmotionInputDetector, ARMode2[" + this.I + "], sdk[" + i3 + "]");
        }
    }

    private void s() {
        long d16 = com.tencent.av.utils.e.d();
        this.f75501h.setImageResource(M);
        this.f75501h.setContentDescription(P);
        this.f75502i.setVisibility(0);
        x(4, d16);
        w(d16, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        String obj;
        Editable text = this.f75500f.getText();
        QQTextBuilder qQTextBuilder = null;
        if (text instanceof QQTextBuilder) {
            qQTextBuilder = (QQTextBuilder) text;
            obj = null;
        } else {
            obj = text.toString();
            if (TextUtils.hasSysEmotion(obj)) {
                qQTextBuilder = new QQTextBuilder(obj, 3, 16);
            }
        }
        if (qQTextBuilder != null) {
            obj = com.tencent.av.chatroom.c.b(qQTextBuilder);
        }
        this.f75500f.setText("");
        if (this.G != null && !android.text.TextUtils.isEmpty(obj)) {
            this.G.d(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        long d16 = com.tencent.av.utils.e.d();
        if (this.H.hasMessages(2)) {
            if (QLog.isColorLevel()) {
                QLog.i("ChatRoomUtil", 2, "showEmotionLayout, is to show. seq[" + d16 + "]");
                return;
            }
            return;
        }
        if (p()) {
            if (QLog.isColorLevel()) {
                QLog.i("ChatRoomUtil", 2, "showEmotionLayout, is showing. seq[" + d16 + "]");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomUtil", 2, "showEmotionLayout, isSoftKeyboardShown[" + r() + "], seq[" + d16 + "]");
        }
        this.f75501h.setImageResource(M);
        if (r()) {
            x(5, d16);
            o();
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.arg1 = 0;
            obtain.arg2 = 0;
            this.H.sendMessageDelayed(obtain, 100L);
            return;
        }
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomUtil", 2, String.format("showSoftKeyboard, seq[%s], emotion[%s], soft[%s]", Long.valueOf(d16), Boolean.valueOf(p()), Boolean.valueOf(r())));
        }
        if (r()) {
            return;
        }
        this.f75500f.setFocusable(true);
        this.f75500f.setFocusableInTouchMode(true);
        this.f75500f.requestFocus();
        InputMethodManager inputMethodManager = this.f75499e;
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(this.f75500f, 1);
        }
        if (!android.text.TextUtils.isEmpty(this.f75500f.getText())) {
            EditText editText = this.f75500f;
            editText.setSelection(editText.getText().length());
        }
        if (p()) {
            x(6, d16);
            n();
        } else {
            x(1, d16);
        }
    }

    private void w(long j3, int i3) {
        int i16 = this.C;
        if (i16 != i3) {
            this.C = i3;
        }
        g gVar = this.G;
        if (gVar != null && i16 != i3) {
            gVar.a(i16, i3, this.D, j3);
        }
    }

    private void x(int i3, long j3) {
        if (this.D != i3) {
            if (QLog.isColorLevel()) {
                QLog.i("ChatRoomUtil", 2, String.format("updateInputPanelState, [%s --> %s], seq[%s], soft[%s]", Integer.valueOf(this.D), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(this.f75503m)));
            }
            this.D = i3;
            g gVar = this.G;
            if (gVar != null) {
                gVar.c(i3, j3);
            }
        }
    }

    private void y() {
        int i3;
        int i16;
        View decorView = this.f75498d.getWindow().getDecorView();
        View rootView = decorView.getRootView();
        rootView.getWindowVisibleDisplayFrame(this.E);
        int height = rootView.getRootView().getHeight();
        int height2 = height - this.E.height();
        if (height2 > height / 4) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        if (height2 > 0) {
            int i17 = this.J;
            if (i17 == -1) {
                this.J = height2;
            } else if (i17 > height2) {
                this.J = height2;
            }
            int i18 = this.K;
            if (i18 == -1) {
                this.K = height2;
            } else if (i18 < height2) {
                this.K = height2;
            }
            if (this.J == this.K && (i16 = this.E.top) > 0) {
                this.J = i16;
            }
        }
        if (i3 != this.f75503m) {
            long d16 = com.tencent.av.utils.e.d();
            if (i3 == 1) {
                this.f75498d.getWindowManager().getDefaultDisplay().getSize(this.F);
                com.tencent.av.chatroom.c.f73533c = Math.max(this.F.y - this.E.bottom, this.K - this.J);
            }
            if (QLog.isColorLevel()) {
                QLog.i("ChatRoomUtil", 2, String.format("updateSoftKeyboardState, seq[%s], [%s --> %s], inputPanelState[%s], height[%s], KeyBoardHeight[%s], ARMode2[%s], decorView[%s, %s, %s, %s], s[%s, %s], temp[%s, %s, %s, %s], diff[%s, %s]", Long.valueOf(d16), Integer.valueOf(this.f75503m), Integer.valueOf(i3), Integer.valueOf(this.D), Integer.valueOf(height2), Integer.valueOf(com.tencent.av.chatroom.c.f73533c), Boolean.valueOf(this.I), Integer.valueOf(decorView.getLeft()), Integer.valueOf(decorView.getTop()), Integer.valueOf(decorView.getRight()), Integer.valueOf(decorView.getBottom()), Integer.valueOf(this.F.x), Integer.valueOf(this.F.y), Integer.valueOf(this.E.left), Integer.valueOf(this.E.top), Integer.valueOf(this.E.right), Integer.valueOf(this.E.bottom), Integer.valueOf(this.J), Integer.valueOf(this.K)));
            }
            int i19 = this.f75503m;
            this.f75503m = i3;
            if (i3 == 1) {
                this.H.removeMessages(2);
                x(2, d16);
                if (p()) {
                    n();
                }
            } else if (this.D == 5) {
                this.H.removeMessages(2);
                s();
            } else if (p()) {
                x(4, d16);
            } else {
                x(7, d16);
            }
            g gVar = this.G;
            if (gVar != null) {
                gVar.b(i19, i3, this.D, d16);
            }
        }
    }

    public static a z(Activity activity) {
        return new a(activity);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void delete() {
        TextUtils.backspace(this.f75500f);
    }

    public a f(g gVar) {
        this.G = gVar;
        return this;
    }

    public a g(EditText editText) {
        this.f75500f = editText;
        editText.setFocusable(true);
        this.f75500f.setFocusableInTouchMode(true);
        this.f75500f.requestFocus();
        this.f75500f.setEditableFactory(QQTextBuilder.getCustomSizeEditableFactory(16));
        this.f75500f.setOnClickListener(new ViewOnClickListenerC0758a());
        this.f75500f.addTextChangedListener(new b());
        this.f75500f.setOnKeyListener(new c());
        ViewCompat.setAccessibilityDelegate(this.f75500f, new d());
        return this;
    }

    public a h(ImageView imageView) {
        this.f75501h = imageView;
        imageView.setImageResource(L);
        this.f75501h.setContentDescription(N);
        this.f75501h.setOnClickListener(new e());
        return this;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 2) {
            if (r() && message.arg1 == 0) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                obtain.arg1 = message.arg1 + 1;
                this.H.sendMessageDelayed(obtain, 100L);
            } else {
                s();
            }
        }
        return true;
    }

    public a i(ViewGroup viewGroup) {
        this.f75502i = viewGroup;
        return this;
    }

    public a j(VideoChatRoomListView videoChatRoomListView) {
        videoChatRoomListView.setOnDispatchTouchEventResponseListener(new f());
        return this;
    }

    public a k() {
        this.f75498d.getWindow().setSoftInputMode(19);
        return this;
    }

    public void l() {
        this.f75500f.clearFocus();
    }

    public int m() {
        return this.D;
    }

    public void n() {
        long d16 = com.tencent.av.utils.e.d();
        if (p()) {
            this.f75501h.setImageResource(L);
            this.f75501h.setContentDescription(N);
            this.f75502i.setVisibility(8);
            if (this.D != 6 && !r()) {
                x(7, d16);
            }
            w(d16, 2);
        }
    }

    public void o() {
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomUtil", 2, "hideSoftKeyboard, soft[" + r() + "], seq[" + d16 + "]");
        }
        if (r()) {
            this.f75500f.clearFocus();
            this.f75499e.hideSoftInputFromWindow(this.f75500f.getWindowToken(), 0);
            if (this.D != 5) {
                x(3, d16);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        y();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public boolean onLongClick(EmoticonInfo emoticonInfo) {
        return false;
    }

    public boolean p() {
        ViewGroup viewGroup = this.f75502i;
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public boolean q() {
        boolean p16 = p();
        if (!p16) {
            return r();
        }
        return p16;
    }

    public boolean r() {
        if (this.f75503m == 0) {
            y();
        }
        if (this.f75503m == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send(EmoticonInfo emoticonInfo) {
        if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
            ((SystemAndEmojiEmoticonInfo) emoticonInfo).send(null, this.f75498d, this.f75500f, null);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void send() {
        t();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void emoticonMall() {
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void setting() {
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onHidePopup(EmoticonInfo emoticonInfo) {
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
    public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
    }
}
