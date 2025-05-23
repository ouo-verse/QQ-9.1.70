package com.qzone.reborn.qzmoment.publish.part;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qzone.util.l;
import com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.subscribe.comment.q;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemEmoticonInfo;
import com.tencent.mobileqq.qqemoticon.api.ISysEmoApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkpublish.util.FSToastUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneEmotionUtils;

/* loaded from: classes37.dex */
public class QZMPublishInputPart extends an.a implements View.OnClickListener, q.a {
    private LinearLayout C;
    private InputMethodManager D;
    private QQToast E;
    private pn.b F;
    private q G;
    private LinearLayout H;
    private boolean I = false;
    private boolean J = false;
    private int K;

    /* renamed from: d, reason: collision with root package name */
    private int f59004d;

    /* renamed from: e, reason: collision with root package name */
    private ExtendEditText f59005e;

    /* renamed from: f, reason: collision with root package name */
    private View f59006f;

    /* renamed from: h, reason: collision with root package name */
    private View f59007h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f59008i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f59009m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements EmoticonCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
            if (QZMPublishInputPart.this.f59005e.getSelectionStart() == 0) {
                return;
            }
            try {
                Editable text = QZMPublishInputPart.this.f59005e.getText();
                int selectionStart = QZMPublishInputPart.this.f59005e.getSelectionStart();
                int offsetBefore = TextUtils.getOffsetBefore(QZMPublishInputPart.this.f59005e.getText(), selectionStart);
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
            ExtendEditText extendEditText = QZMPublishInputPart.this.f59005e;
            if (emoticonInfo instanceof SystemEmoticonInfo) {
                int selectionStart = extendEditText.getSelectionStart();
                int selectionEnd = extendEditText.getSelectionEnd();
                if (selectionStart < 0 || selectionEnd < 0 || selectionEnd < selectionStart) {
                    return;
                }
                extendEditText.getEditableText().replace(selectionStart, selectionEnd, QQSysFaceUtil.getFaceString(((SystemEmoticonInfo) emoticonInfo).code));
                return;
            }
            if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
                SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
                int selectionStart2 = extendEditText.getSelectionStart();
                int selectionEnd2 = extendEditText.getSelectionEnd();
                int i3 = systemAndEmojiEmoticonInfo.emotionType;
                int i16 = systemAndEmojiEmoticonInfo.code;
                if (selectionStart2 >= 0 && selectionEnd2 >= 0 && selectionEnd2 >= selectionStart2) {
                    if (i3 == 2 && i16 == -1) {
                        return;
                    }
                    extendEditText.getEditableText().replace(selectionStart2, selectionEnd2, ((ISysEmoApi) QRoute.api(ISysEmoApi.class)).getEmoString(i3, i16));
                    extendEditText.requestFocus();
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
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RelativeLayout f59012d;

        c(RelativeLayout relativeLayout) {
            this.f59012d = relativeLayout;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            this.f59012d.getWindowVisibleDisplayFrame(rect);
            int height = rect.height();
            if (height - QZMPublishInputPart.this.K > 150 && !QZMPublishInputPart.this.J) {
                QZMPublishInputPart.this.f59007h.setVisibility(8);
            }
            QZMPublishInputPart.this.K = height;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QZMPublishInputPart.this.f59006f != null) {
                if (!QZMPublishInputPart.this.I) {
                    QZMPublishInputPart.this.da();
                } else {
                    QZMPublishInputPart.this.showKeyboard();
                    QZMPublishInputPart.this.R9();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void O9() {
        ExtendEditText extendEditText = this.f59005e;
        if (extendEditText == null) {
            return;
        }
        extendEditText.addTextChangedListener(new a());
    }

    private void Z9(View view) {
        q qVar = new q(view);
        this.G = qVar;
        qVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void aa(int i3) {
        QQToast qQToast = this.E;
        if (qQToast == null || !qQToast.isShowing()) {
            QQToast makeText = QQToast.makeText(RFWApplication.getApplication(), FSToastUtil.ICON_DEFAULT, "\u8d85\u51fa\u5b57\u6570\u9650\u5236", 0);
            this.E = makeText;
            makeText.show();
        }
    }

    private void ba() {
        View view = this.f59006f;
        if (view == null || view.getLayoutParams() == null) {
            return;
        }
        if (this.f59004d > 0) {
            this.f59006f.getLayoutParams().height = this.f59004d;
        } else {
            this.f59006f.getLayoutParams().height = ViewUtils.dip2px(250.0f);
        }
        this.f59006f.invalidate();
        QLog.d("QZMPublishInputPart", 1, "mEmojiPanel onGetKeyBoardHeight() :" + this.f59004d);
    }

    public String P9() {
        ExtendEditText extendEditText = this.f59005e;
        if (extendEditText == null) {
            return "";
        }
        return QzoneEmotionUtils.splash2Emo(ea(extendEditText.getText()).replaceAll(l.a(R.string.f172111ng0), l.a(R.string.f172113ng2)).replaceAll(l.a(R.string.nfz), "/MM").replaceAll(l.a(R.string.f2192465w), "/chigua")).trim();
    }

    public void Q9() {
        S9();
        R9();
        View view = this.f59007h;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    protected boolean R9() {
        View view = this.f59006f;
        if (view == null || !this.I) {
            return false;
        }
        this.I = false;
        view.setVisibility(8);
        this.f59008i.setImageDrawable(getContext().getDrawable(R.drawable.qvideo_skin_icon_general_emoji_primary));
        return true;
    }

    protected boolean T9(boolean z16) {
        ExtendEditText extendEditText;
        InputMethodManager inputMethodManager = this.D;
        if (inputMethodManager == null || (extendEditText = this.f59005e) == null || !inputMethodManager.hideSoftInputFromWindow(extendEditText.getWindowToken(), 0)) {
            return false;
        }
        if (!z16) {
            return true;
        }
        this.f59005e.clearFocus();
        return true;
    }

    protected void V9(boolean z16) {
        if (this.f59005e == null) {
            return;
        }
        T9(z16);
        R9();
    }

    protected void X9() {
        this.f59006f = com.qzone.reborn.qzmoment.comment.b.c(getContext(), new b());
    }

    protected final void Y9(View view) {
        ba();
        RelativeLayout relativeLayout = (RelativeLayout) view;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        LinearLayout linearLayout = new LinearLayout(getActivity());
        this.C = linearLayout;
        linearLayout.setOrientation(1);
        this.f59007h = LayoutInflater.from(getActivity()).inflate(R.layout.f1283939, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.f59007h.setVisibility(4);
        this.C.addView(this.f59007h, layoutParams2);
        if (this.f59006f != null) {
            this.C.addView(this.f59006f, new LinearLayout.LayoutParams(-1, -2));
            this.f59006f.setVisibility(8);
        }
        relativeLayout.addView(this.C, layoutParams);
        this.f59008i = (ImageView) view.findViewById(R.id.nfv);
        this.f59009m = (ImageView) view.findViewById(R.id.nfu);
        ca();
        Z9(view);
        Rect rect = new Rect();
        relativeLayout.getWindowVisibleDisplayFrame(rect);
        this.K = rect.height();
        relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new c(relativeLayout));
    }

    protected void ca() {
        ImageView imageView = this.f59008i;
        if (imageView == null) {
            return;
        }
        imageView.setOnClickListener(new d());
        this.f59009m.setOnClickListener(this);
    }

    protected void da() {
        if (this.f59006f == null || this.J) {
            return;
        }
        S9();
        LinearLayout linearLayout = this.C;
        if (linearLayout != null) {
            ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).bottomMargin = 0;
        }
        this.f59005e.requestFocus();
        this.J = true;
        this.f59006f.postDelayed(new Runnable() { // from class: com.qzone.reborn.qzmoment.publish.part.QZMPublishInputPart.5
            @Override // java.lang.Runnable
            public void run() {
                if (QZMPublishInputPart.this.f59006f == null || QZMPublishInputPart.this.f59008i == null) {
                    return;
                }
                QZMPublishInputPart.this.f59006f.setVisibility(0);
                QZMPublishInputPart.this.f59008i.setImageDrawable(QZMPublishInputPart.this.getContext().getDrawable(R.drawable.qvideo_skin_icon_general_keyboard_primary));
                QZMPublishInputPart.this.I = true;
                QZMPublishInputPart.this.J = false;
            }
        }, 100L);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (TextUtils.equals(str, "hide_keyboard_and_emo")) {
            Q9();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.nfu) {
            U9();
            this.f59007h.setVisibility(8);
        } else if (view.getId() == R.id.mhw || view.getId() == R.id.ml5) {
            R9();
            showKeyboard();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        W9(view);
        X9();
        Y9(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        this.D = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        this.F = (pn.b) getViewModel(pn.b.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        q qVar = this.G;
        if (qVar != null) {
            qVar.e(this);
        }
    }

    public void showKeyboard() {
        ExtendEditText extendEditText;
        InputMethodManager inputMethodManager = this.D;
        if (inputMethodManager == null || (extendEditText = this.f59005e) == null) {
            return;
        }
        inputMethodManager.showSoftInput(extendEditText, 2);
    }

    public boolean S9() {
        return T9(false);
    }

    protected void U9() {
        V9(true);
    }

    @Override // com.tencent.biz.subscribe.comment.q.a
    public void onSoftKeyboardClosed() {
        QLog.d("QZMPublishInputPart", 1, "onSoftKeyboardClosed");
    }

    @Override // com.tencent.biz.subscribe.comment.q.a
    public void onSoftKeyboardOpened(int i3) {
        QLog.d("QZMPublishInputPart", 1, "onSoftKeyboardOpened");
        if (this.f59004d != i3) {
            this.f59004d = i3;
            ba();
        }
        LinearLayout linearLayout = this.C;
        if (linearLayout != null) {
            ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).bottomMargin = this.f59004d;
            this.f59007h.requestLayout();
            this.f59007h.setVisibility(0);
        }
    }

    private String ea(Editable editable) {
        if (editable != null) {
            if (editable instanceof com.tencent.mobileqq.qzone.api.text.a) {
                return ((com.tencent.mobileqq.qzone.api.text.a) editable).toPlainText();
            }
            return editable.toString();
        }
        return "";
    }

    private void W9(View view) {
        ExtendEditText extendEditText = (ExtendEditText) view.findViewById(R.id.ml5);
        this.f59005e = extendEditText;
        extendEditText.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.mhw);
        this.H = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f59005e.setLimitListener(new ExtendEditText.f() { // from class: com.qzone.reborn.qzmoment.publish.part.a
            @Override // com.tencent.biz.qqcircle.publish.view.edittext.ExtendEditText.f
            public final void a(int i3) {
                QZMPublishInputPart.this.aa(i3);
            }
        });
        this.f59005e.setEditableFactory(com.tencent.mobileqq.qzone.api.text.a.f279313d);
        O9();
        fo.c.o(this.f59005e, "em_bas_body_area", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String str;
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("afterTextChanged s:");
                if (editable != null) {
                    str = editable.toString();
                } else {
                    str = "";
                }
                sb5.append(str);
                QLog.d("QZMPublishInputPart", 1, sb5.toString());
            }
            if (editable != null) {
                QZMPublishInputPart.this.F.S1(QZMPublishInputPart.this.P9());
            } else {
                QZMPublishInputPart.this.F.S1(null);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
