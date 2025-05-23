package com.qzone.reborn.qzmoment.comment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.reborn.qzmoment.comment.QZMBaseInputPopupWindow;
import com.qzone.reborn.qzmoment.comment.QZMCommentEditText;
import com.qzone.reborn.qzmoment.comment.g;
import com.qzone.util.ToastUtil;
import com.qzone.util.l;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.common.app.AppInterface;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.impl.CommonPanelInteractionListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.text.rich.bean.RichTextPreloadConfig;
import com.tencent.richframework.text.rich.parser.Patterns;
import com.tencent.richframework.text.rich.parser.RichTextClickableImageSpanParser;
import com.tencent.richframework.text.rich.parser.RichTextEmojiParser;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import uq3.k;

/* loaded from: classes37.dex */
public class QZMCommentInputPopupWindow extends QZMBaseInputPopupWindow {
    private static final String Z = l.a(R.string.f133686s);
    private View Q;
    private IEmoticonMainPanel R;
    private ImageButton S;
    private ImageButton T;
    private TextView U;
    private LinearLayout V;
    private LinearLayout W;
    private TextView X;
    private boolean Y;

    /* loaded from: classes37.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZMCommentInputPopupWindow.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class d implements EmoticonCallback {
        d() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            if (QZMCommentInputPopupWindow.this.G.getSelectionStart() == 0) {
                return;
            }
            try {
                Editable text = QZMCommentInputPopupWindow.this.G.getText();
                int selectionStart = QZMCommentInputPopupWindow.this.G.getSelectionStart();
                int offsetBefore = TextUtils.getOffsetBefore(QZMCommentInputPopupWindow.this.G.getText(), selectionStart);
                if (selectionStart != offsetBefore) {
                    text.delete(Math.min(selectionStart, offsetBefore), Math.max(selectionStart, offsetBefore));
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(EmoticonInfo emoticonInfo) {
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(EmoticonInfo emoticonInfo) {
            if (emoticonInfo instanceof SystemEmoticonInfo) {
                int selectionStart = QZMCommentInputPopupWindow.this.G.getSelectionStart();
                int selectionEnd = QZMCommentInputPopupWindow.this.G.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                    return;
                }
                QZMCommentInputPopupWindow.this.G.getEditableText().replace(selectionStart, selectionEnd, com.qzone.reborn.qzmoment.comment.b.d(((SystemEmoticonInfo) emoticonInfo).code));
                return;
            }
            if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
                int selectionStart2 = QZMCommentInputPopupWindow.this.G.getSelectionStart();
                int selectionEnd2 = QZMCommentInputPopupWindow.this.G.getSelectionEnd();
                int i3 = systemAndEmojiEmoticonInfo.emotionType;
                int i16 = systemAndEmojiEmoticonInfo.code;
                if (selectionStart2 >= 0 && selectionEnd2 >= 0 && selectionEnd2 >= selectionStart2) {
                    if (i3 == 2 && i16 == -1) {
                        return;
                    }
                    String b16 = com.qzone.reborn.qzmoment.comment.b.b(i3, i16);
                    if (b16 != null && QZMCommentInputPopupWindow.this.G.getEditableText() != null) {
                        QZMCommentInputPopupWindow.this.G.getEditableText().replace(selectionStart2, selectionEnd2, b16);
                    }
                    QZMCommentInputPopupWindow.this.G.requestFocus();
                }
                com.qzone.reborn.qzmoment.comment.b.a(systemAndEmojiEmoticonInfo);
            }
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(EmoticonInfo emoticonInfo) {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class e implements ICommonPanelInteractionView {
        e() {
        }

        @Override // com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView
        public EditText getAIOInput() {
            return QZMCommentInputPopupWindow.this.G;
        }

        @Override // com.tencent.mobileqq.emoticonview.api.ICommonPanelInteractionView
        public IEmoticonMainPanel getIEmoticonMainPanel() {
            return QZMCommentInputPopupWindow.this.R;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class f implements g.b {
        f() {
        }

        @Override // com.qzone.reborn.qzmoment.comment.g.b
        public void onSoftKeyboardClosed() {
            QZMCommentInputPopupWindow.this.O0();
        }

        @Override // com.qzone.reborn.qzmoment.comment.g.b
        public void onSoftKeyboardOpened(int i3) {
            QZMCommentInputPopupWindow.this.y0(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f58855d;

        g(View view) {
            this.f58855d = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f58855d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int measuredHeight = this.f58855d.getMeasuredHeight();
            QLog.d("QZMCommentInputPopupWindow", 1, "onGlobalLayout input box height: ", Integer.valueOf(measuredHeight), " | key board height: ", Integer.valueOf(QZMCommentInputPopupWindow.this.N));
            QZMCommentInputPopupWindow qZMCommentInputPopupWindow = QZMCommentInputPopupWindow.this;
            qZMCommentInputPopupWindow.M0(qZMCommentInputPopupWindow.N, measuredHeight);
        }
    }

    public QZMCommentInputPopupWindow(Context context) {
        super(context);
        this.R = null;
    }

    private AppRuntime A0() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(boolean z16) {
        View view = this.Q;
        if (view != null) {
            view.setVisibility(8);
        }
        i0(this.F);
        if (z16) {
            f0(this.G, 0);
        }
        R0();
    }

    private void D0() {
        this.T = (ImageButton) this.E.findViewById(R.id.f19535y);
        this.S = (ImageButton) this.E.findViewById(R.id.f195661);
        this.U = (TextView) this.E.findViewById(R.id.nkt);
        this.V = (LinearLayout) this.E.findViewById(R.id.f162989np4);
        this.X = (TextView) this.E.findViewById(R.id.nku);
        E0();
        N0();
        this.G.setPadding(cx.a(20.0f), cx.a(16.0f), cx.a(10.0f), cx.a(16.0f));
    }

    private void F0() {
        I0();
        this.G.addTextChangedListener(new a());
    }

    private void H0() {
        com.qzone.reborn.qzmoment.comment.g gVar = new com.qzone.reborn.qzmoment.comment.g(this.E);
        this.D = gVar;
        gVar.a(new f());
    }

    private void I0() {
        this.G.setOnEditorActionListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List J0(boolean z16, boolean z17) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EmotionPanelInfo(7, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
        return arrayList;
    }

    private void K0() {
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.qzmoment.comment.QZMCommentInputPopupWindow.7
            @Override // java.lang.Runnable
            public void run() {
                View view = QZMCommentInputPopupWindow.this.E;
                if (view != null) {
                    view.setVisibility(0);
                }
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        this.V.setVisibility(8);
        int w06 = w0(this.G.getText().toString());
        int u36 = uq3.c.u3();
        if (w06 >= u36 - 10) {
            this.V.setVisibility(0);
            this.U.setText(w06 + "");
            if (w06 > u36) {
                this.U.setTextColor(getContext().getResources().getColor(R.color.f157727cb3));
            } else {
                this.U.setTextColor(getContext().getResources().getColor(R.color.f157728cb4));
            }
            this.X.setText("/" + u36);
        }
    }

    private void N0() {
        View view = this.Q;
        if (view != null && view.getLayoutParams() != null) {
            this.Q.getLayoutParams().height = this.N;
            this.Q.invalidate();
            QLog.d("QZMCommentInputPopupWindow", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.N);
        }
        P0();
    }

    private void P0() {
        View view = this.E;
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.f19816p);
        findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new g(findViewById));
    }

    private void R0() {
        ImageButton imageButton = this.S;
        if (imageButton != null) {
            imageButton.setVisibility(8);
        }
        ImageButton imageButton2 = this.T;
        if (imageButton2 != null) {
            imageButton2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        if (this.P) {
            Z(this.F);
        }
        this.Y = true;
        View view = this.Q;
        if (view != null) {
            view.setVisibility(0);
        }
        W(this.G);
        T0();
    }

    private void T0() {
        ImageButton imageButton = this.S;
        if (imageButton != null) {
            imageButton.setVisibility(0);
        }
        ImageButton imageButton2 = this.T;
        if (imageButton2 != null) {
            imageButton2.setVisibility(8);
        }
    }

    private void u0(EmoticonCallback emoticonCallback) {
        if (z0() == null) {
            QLog.e("QZMCommentInputPopupWindow", 1, "app interface is null");
            return;
        }
        IEmoticonMainPanelService.PanelBuilder newBuilder = ((IEmoticonMainPanelService) z0().getRuntimeService(IEmoticonMainPanelService.class, "")).newBuilder(getContext(), 1008);
        if (com.qzone.reborn.qzmoment.comment.c.f58857a.a()) {
            newBuilder.setDefaultPanelType(4);
        } else {
            newBuilder.setDefaultPanelType(k.b().e("sp_key_emoji_last_selected_emoji_tab", 7));
        }
        this.R = newBuilder.setCallBack(emoticonCallback).setDisableMoreEmotionButton(true).setStyleChange(true).keepLottieMerged(true).setHideAllSettingTabs(true).setEmoticonListProvider(new EmoticonListProvider() { // from class: com.qzone.reborn.qzmoment.comment.e
            @Override // com.tencent.mobileqq.emoticonview.EmoticonListProvider
            public final List getEmotionPanelInfo(boolean z16, boolean z17) {
                List J0;
                J0 = QZMCommentInputPopupWindow.J0(z16, z17);
                return J0;
            }
        }).setPanelInteractionListener(new CommonPanelInteractionListener(new e())).create();
    }

    private int w0(CharSequence charSequence) {
        int i3 = 0;
        int i16 = 0;
        while (Patterns.PATTERN_EMO.matcher(charSequence).find()) {
            i16 += (r0.end() - r0.start()) - 2;
        }
        Matcher matcher = RichTextClickableImageSpanParser.CLICKABLE_IMAGE_SPAN_TAG_GROUP_PATTERN.matcher(charSequence);
        while (matcher.find()) {
            i3 += matcher.end() - matcher.start();
        }
        return (charSequence.length() - i16) - i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(int i3) {
        QLog.d("QZMCommentInputPopupWindow", 1, "onSoftKeyboardOpened");
        C0(false);
        if (this.N != i3) {
            this.N = i3;
            N0();
            k.b().m("sp_key_soft_keyboard_height", i3);
        }
        a0();
        this.P = true;
    }

    private AppInterface z0() {
        if (A0() instanceof AppInterface) {
            return (AppInterface) A0();
        }
        return null;
    }

    protected void E0() {
        AbstractGifImage.resumeAll();
        d dVar = new d();
        this.W = (LinearLayout) this.E.findViewById(R.id.mgm);
        if (MobileQQ.sProcessId == 1) {
            u0(dVar);
        }
        IEmoticonMainPanel iEmoticonMainPanel = this.R;
        if (iEmoticonMainPanel == null) {
            WeakReference<Context> weakReference = this.C;
            if (weakReference != null && weakReference.get() != null) {
                this.Q = com.qzone.reborn.qzmoment.comment.b.c(this.C.get(), dVar);
            }
        } else {
            this.Q = iEmoticonMainPanel.getView();
        }
        this.Q.setVisibility(0);
        WeakReference<Context> weakReference2 = this.C;
        if (weakReference2 != null && weakReference2.get() != null) {
            this.Q.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }
        IEmoticonMainPanel iEmoticonMainPanel2 = this.R;
        if (iEmoticonMainPanel2 != null) {
            iEmoticonMainPanel2.hideAllTabs();
        }
        this.W.addView(this.Q, new LinearLayout.LayoutParams(-1, -1));
    }

    @Override // com.qzone.reborn.qzmoment.comment.QZMBaseInputPopupWindow
    protected int R() {
        return R.layout.f1279825;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.qzmoment.comment.QZMBaseInputPopupWindow
    public void X() {
        super.X();
        this.T.setOnClickListener(this);
        this.S.setOnClickListener(this);
        F0();
    }

    @Override // com.qzone.reborn.qzmoment.comment.QZMBaseInputPopupWindow
    protected void initView() {
        QZMCommentEditText qZMCommentEditText = (QZMCommentEditText) this.E.findViewById(R.id.ngq);
        this.G = qZMCommentEditText;
        qZMCommentEditText.setOnInputBackListener(new QZMCommentEditText.b() { // from class: com.qzone.reborn.qzmoment.comment.QZMCommentInputPopupWindow.1
            @Override // com.qzone.reborn.qzmoment.comment.QZMCommentEditText.b
            public void a(View view) {
                if (QZMCommentInputPopupWindow.this.isShowing() && (QZMCommentInputPopupWindow.this.C.get() instanceof Activity)) {
                    ((Activity) QZMCommentInputPopupWindow.this.C.get()).runOnUiThread(new Runnable() { // from class: com.qzone.reborn.qzmoment.comment.QZMCommentInputPopupWindow.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QZMCommentInputPopupWindow.this.dismiss();
                        }
                    });
                }
            }
        });
        this.G.setEditableFactory(com.tencent.mobileqq.qzone.api.text.a.f279313d);
        this.H = (Button) this.E.findViewById(R.id.f196065);
        View findViewById = this.E.findViewById(R.id.f192052);
        this.F = findViewById;
        findViewById.setOnClickListener(new c());
        this.E.setVisibility(4);
        D0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QLog.d("QZMCommentInputPopupWindow", 1, "onClick:" + view.getId());
        int id5 = view.getId();
        if (id5 == R.id.f19535y) {
            QLog.d("QZMCommentInputPopupWindow", 1, "btn_emotion");
            S0();
        } else if (id5 == R.id.ngq) {
            QLog.d("QZMCommentInputPopupWindow", 1, "text_input");
            C0(true);
        } else if (id5 == R.id.f196065) {
            if (x0()) {
                ToastUtil.s(Z, 4);
            } else {
                QZMBaseInputPopupWindow.b bVar = this.I;
                if (bVar != null) {
                    bVar.a();
                }
            }
        } else if (id5 == R.id.f195661) {
            QLog.d("QZMCommentInputPopupWindow", 1, "btn_keyboard");
            C0(true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.qzmoment.comment.QZMBaseInputPopupWindow, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        T0();
    }

    protected boolean x0() {
        int u36 = uq3.c.u3();
        return this.G.getText().length() >= u36 && w0(this.G.getText()) > u36;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        QLog.d("QZMCommentInputPopupWindow", 1, "onSoftKeyboardClosed");
        if (this.Y) {
            this.Y = false;
            View view = this.Q;
            if (view != null) {
                view.setVisibility(0);
            }
        }
        this.P = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private int f58847d = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f58848e = 0;

        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable == null) {
                return;
            }
            QZMCommentInputPopupWindow.this.G.removeTextChangedListener(this);
            if (QZMCommentInputPopupWindow.this.x0()) {
                int i3 = this.f58847d;
                QZMCommentInputPopupWindow.this.e0(editable.delete(i3, this.f58848e + i3));
                QZMCommentInputPopupWindow.this.G.addTextChangedListener(this);
                ToastUtil.s(QZMCommentInputPopupWindow.Z, 4);
                return;
            }
            String obj = editable.toString();
            int i16 = this.f58847d;
            QZMCommentInputPopupWindow.this.B0(editable, obj.substring(i16, this.f58848e + i16));
            QZMCommentInputPopupWindow.this.L0();
            this.f58847d = 0;
            this.f58848e = 0;
            QZMCommentInputPopupWindow.this.G.addTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            if (charSequence == null) {
                return;
            }
            this.f58847d = i3;
            this.f58848e = i17;
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(Editable editable, String str) {
        int indexOf = str.indexOf(47);
        if (indexOf < 0 || indexOf >= str.length() - 1 || !Patterns.PATTERN_EMO.matcher(str).find()) {
            return;
        }
        RichTextEmojiParser.asyncParseSmiley(new RichTextPreloadConfig.TextImageSpanConfig().setIconSize(22).setVerticalAlignment(0), editable, null);
    }

    public void Q0(boolean z16) {
        if (z16) {
            T0();
        }
        try {
            show();
            K0();
            H0();
            if (z16) {
                S().post(new Runnable() { // from class: com.qzone.reborn.qzmoment.comment.QZMCommentInputPopupWindow.5
                    @Override // java.lang.Runnable
                    public void run() {
                        QZMCommentInputPopupWindow.this.a0();
                        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.qzone.reborn.qzmoment.comment.QZMCommentInputPopupWindow.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QZMCommentInputPopupWindow.this.S0();
                            }
                        }, 200L);
                    }
                });
            } else {
                S().post(new Runnable() { // from class: com.qzone.reborn.qzmoment.comment.QZMCommentInputPopupWindow.6
                    @Override // java.lang.Runnable
                    public void run() {
                        QZMCommentInputPopupWindow.this.C0(true);
                        QZMCommentInputPopupWindow.this.G.requestFocus();
                    }
                });
            }
        } catch (Exception e16) {
            QLog.e("QZMCommentInputPopupWindow", 2, "[show] show error: ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements TextView.OnEditorActionListener {
        b() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            boolean z16;
            if (i3 == 4 || i3 == 6) {
                if (QZMCommentInputPopupWindow.this.x0()) {
                    ToastUtil.s(QZMCommentInputPopupWindow.Z, 4);
                } else {
                    QZMBaseInputPopupWindow.b bVar = QZMCommentInputPopupWindow.this.I;
                    if (bVar != null) {
                        bVar.a();
                    }
                }
                z16 = true;
            } else {
                z16 = false;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(int i3, int i16) {
    }
}
