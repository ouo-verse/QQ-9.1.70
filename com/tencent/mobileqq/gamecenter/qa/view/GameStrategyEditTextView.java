package com.tencent.mobileqq.gamecenter.qa.view;

import android.annotation.SuppressLint;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ParagraphStyle;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.EditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.qa.editor.span.AlignmentSpan;
import com.tencent.mobileqq.gamecenter.qa.editor.util.Paragraph;
import com.tencent.mobileqq.gamecenter.qa.editor.util.RTLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes12.dex */
public class GameStrategyEditTextView extends EditText implements SpanWatcher {
    private ActionMode C;
    private ActionMode.Callback D;
    private ActionMode.Callback E;
    private TextWatcher F;
    private float G;
    private float H;
    private boolean I;
    private GameStrategyImageSpan J;
    private ClickableSpan K;
    private w L;
    private int M;
    private int N;
    private String P;
    private String Q;
    private Spannable R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private int f212864a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f212865b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f212866c0;

    /* renamed from: d, reason: collision with root package name */
    private List<TextWatcher> f212867d;

    /* renamed from: d0, reason: collision with root package name */
    private RTLayout f212868d0;

    /* renamed from: e, reason: collision with root package name */
    private boolean f212869e;

    /* renamed from: e0, reason: collision with root package name */
    private int f212870e0;

    /* renamed from: f, reason: collision with root package name */
    private wd1.a f212871f;

    /* renamed from: f0, reason: collision with root package name */
    private int f212872f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f212873g0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f212874h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f212875h0;

    /* renamed from: i, reason: collision with root package name */
    private d f212876i;

    /* renamed from: i0, reason: collision with root package name */
    private e f212877i0;

    /* renamed from: j0, reason: collision with root package name */
    private ac f212878j0;

    /* renamed from: k0, reason: collision with root package name */
    private Pattern f212879k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f212880l0;

    /* renamed from: m, reason: collision with root package name */
    private ActionMode f212881m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements ActionMode.Callback {
        a() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            QLog.i("GameStrategyEditTextView", 2, "onActionItemClicked, item:" + menuItem.toString());
            if (menuItem.getItemId() == 100000) {
                GameStrategyEditTextView.this.f212874h = true;
                actionMode.invalidate();
                return true;
            }
            if (GameStrategyEditTextView.b0(menuItem)) {
                if (GameStrategyEditTextView.this.f212876i != null) {
                    GameStrategyEditTextView.this.f212876i.a(menuItem);
                }
                actionMode.hide(0L);
                actionMode.finish();
                return true;
            }
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            GameStrategyEditTextView.this.f212874h = false;
            if (GameStrategyEditTextView.this.f212880l0) {
                if (GameStrategyEditTextView.this.U()) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("BIU");
                    spannableStringBuilder.setSpan(new StyleSpan(1), 0, 1, 17);
                    spannableStringBuilder.setSpan(new StyleSpan(2), 1, 2, 17);
                    spannableStringBuilder.setSpan(new UnderlineSpan(), 2, 3, 17);
                    menu.add(0, 100000, 9, spannableStringBuilder).setShowAsAction(2);
                }
                menu.add(0, 100001, 0, "\u7c97\u4f53");
                menu.add(0, 100002, 0, "\u659c\u4f53");
                menu.add(0, 100003, 0, "\u4e0b\u5212\u7ebf");
            }
            GameStrategyEditTextView.this.f212881m = actionMode;
            if (GameStrategyEditTextView.this.J != null) {
                Selection.setSelection(GameStrategyEditTextView.this.getEditableText(), GameStrategyEditTextView.this.getEditableText().getSpanStart(GameStrategyEditTextView.this.J), GameStrategyEditTextView.this.getEditableText().getSpanEnd(GameStrategyEditTextView.this.J));
            }
            if (GameStrategyEditTextView.this.L != null) {
                Selection.setSelection(GameStrategyEditTextView.this.getEditableText(), GameStrategyEditTextView.this.getEditableText().getSpanStart(GameStrategyEditTextView.this.L), GameStrategyEditTextView.this.getEditableText().getSpanEnd(GameStrategyEditTextView.this.L));
            }
            if (GameStrategyEditTextView.this.K != null) {
                Selection.setSelection(GameStrategyEditTextView.this.getEditableText(), GameStrategyEditTextView.this.getEditableText().getSpanStart(GameStrategyEditTextView.this.K), GameStrategyEditTextView.this.getEditableText().getSpanEnd(GameStrategyEditTextView.this.K));
            }
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            QLog.i("GameStrategyEditTextView", 2, "onDestroyActionMode, mode:" + actionMode.toString());
            GameStrategyEditTextView.this.f212874h = false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            QLog.d("GameStrategyEditTextView", 2, "onPrepareActionMode, item:", menu.toString());
            for (int i3 = 0; i3 < menu.size(); i3++) {
                MenuItem item = menu.getItem(i3);
                if (item.getItemId() != 16908320 && item.getItemId() != 16908321 && item.getItemId() != 16908319 && item.getItemId() != 16908322 && item.getItemId() != 100000) {
                    item.setVisible(false);
                }
                if (GameStrategyEditTextView.this.f212874h) {
                    if (GameStrategyEditTextView.b0(item)) {
                        item.setVisible(true);
                    }
                    if (item.getItemId() == 100000 || GameStrategyEditTextView.c0(item)) {
                        item.setVisible(false);
                    }
                } else {
                    if (GameStrategyEditTextView.b0(item)) {
                        item.setVisible(false);
                    }
                    if (item.getItemId() == 100000 || GameStrategyEditTextView.c0(item)) {
                        item.setVisible(true);
                    }
                }
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface d {
        void a(MenuItem menuItem);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface e {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface f {
        ab a(ab abVar);

        w b(w wVar);
    }

    public GameStrategyEditTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f212867d = new ArrayList();
        this.f212869e = false;
        this.D = new a();
        this.E = new b();
        this.F = new c();
        this.f212870e0 = -1;
        this.f212872f0 = -1;
        this.f212879k0 = Pattern.compile("\\{\\{video:.*\\}\\}");
        this.f212880l0 = false;
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        Editable text = getText();
        if (text.getSpans(0, text.length(), getClass()) != null) {
            text.setSpan(this, 0, text.length(), 18);
        }
    }

    private GameStrategyImageSpan P(float f16, float f17) {
        Layout layout = getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((int) ((f17 - getTotalPaddingTop()) + getScrollY())), (f16 - getTotalPaddingLeft()) + getScrollX());
        GameStrategyImageSpan[] gameStrategyImageSpanArr = (GameStrategyImageSpan[]) getEditableText().getSpans(offsetForHorizontal, offsetForHorizontal, GameStrategyImageSpan.class);
        if (gameStrategyImageSpanArr.length > 0) {
            return gameStrategyImageSpanArr[0];
        }
        return null;
    }

    private RTLayout T() {
        synchronized (this) {
            if (this.f212868d0 == null || this.f212865b0) {
                this.f212868d0 = new RTLayout(getText());
                this.f212865b0 = false;
            }
        }
        return this.f212868d0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean U() {
        Editable editableText = getEditableText();
        int selectionStart = getSelectionStart();
        int selectionEnd = getSelectionEnd();
        if (selectionStart >= 0 && selectionEnd >= 0 && selectionEnd >= selectionStart) {
            try {
                if (TextUtils.isEmpty(editableText.toString().substring(selectionStart, selectionEnd).replaceAll("\\{\\{pic:.*\\}\\}", "").replaceAll("\\{\\{video:.*\\}\\}", "").replaceAll("\\{\\{link:.*\\}\\}", "").trim())) {
                    QLog.i("GameStrategyEditTextView", 1, "[hasText] only has pic and video link tag");
                    return false;
                }
            } catch (Exception e16) {
                QLog.e("GameStrategyEditTextView", 1, e16, new Object[0]);
            }
        }
        return true;
    }

    private void Y() {
        setCustomSelectionActionModeCallback(this.D);
        setCustomInsertionActionModeCallback(this.E);
        addTextChangedListener(this.F);
        L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b0(MenuItem menuItem) {
        if (menuItem == null) {
            return false;
        }
        if (menuItem.getItemId() != 100001 && menuItem.getItemId() != 100002 && menuItem.getItemId() != 100003) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c0(MenuItem menuItem) {
        if (menuItem == null) {
            return false;
        }
        if (menuItem.getItemId() != 16908320 && menuItem.getItemId() != 16908321 && menuItem.getItemId() != 16908322 && menuItem.getItemId() != 16908319) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g0(boolean z16) {
        if (!this.U) {
            this.T = z16;
        }
    }

    private int h0() {
        CharSequence text = ClipboardMonitor.getText((ClipboardManager) getContext().getSystemService("clipboard"));
        int i3 = 0;
        if (text != null) {
            while (this.f212879k0.matcher(text.toString()).find()) {
                i3++;
            }
        }
        while (this.f212879k0.matcher(getText().toString()).find()) {
            i3++;
        }
        return i3;
    }

    public void K() {
        Iterator<TextWatcher> it = this.f212867d.iterator();
        while (it.hasNext()) {
            super.addTextChangedListener(it.next());
        }
    }

    public <V, C extends zd1.e<V>> void M(com.tencent.mobileqq.gamecenter.qa.editor.effect.g<V, C> gVar, V v3) {
        if (!this.f212869e) {
            gVar.a(this, v3);
        }
    }

    public Spannable N() {
        Editable text = super.getText();
        if (text != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text.toString());
            for (Object obj : text.getSpans(0, text.length(), Object.class)) {
                if ((obj instanceof CharacterStyle) || (obj instanceof ParagraphStyle)) {
                    int spanStart = text.getSpanStart(obj);
                    int spanEnd = text.getSpanEnd(obj);
                    int spanFlags = text.getSpanFlags(obj);
                    if (spanStart < 0) {
                        spanStart = 0;
                    }
                    if (spanEnd > text.length()) {
                        spanEnd = text.length();
                    }
                    spannableStringBuilder.setSpan(obj, spanStart, spanEnd, spanFlags);
                }
            }
            return spannableStringBuilder;
        }
        return new SpannableStringBuilder();
    }

    public void O(boolean z16) {
        this.f212880l0 = z16;
    }

    public float Q() {
        return this.H;
    }

    public ArrayList<Paragraph> R() {
        return T().getParagraphs();
    }

    public com.tencent.mobileqq.gamecenter.qa.editor.util.Selection S() {
        RTLayout T = T();
        com.tencent.mobileqq.gamecenter.qa.editor.util.Selection selection = new com.tencent.mobileqq.gamecenter.qa.editor.util.Selection(this);
        int lineForOffset = T.getLineForOffset(selection.getMStart());
        boolean isEmpty = selection.isEmpty();
        int mEnd = selection.getMEnd();
        if (!isEmpty) {
            mEnd--;
        }
        return new com.tencent.mobileqq.gamecenter.qa.editor.util.Selection(T.getLineStart(lineForOffset), T.getLineEnd(T.getLineForOffset(mEnd)));
    }

    public void V() {
        ActionMode actionMode = this.f212881m;
        if (actionMode != null) {
            actionMode.hide(-1L);
            this.f212881m.finish();
            if (QLog.isColorLevel()) {
                QLog.i("GameStrategyEditTextView", 2, "hideActionMode");
            }
        }
    }

    public void W(float f16, float f17, boolean z16) {
        if (getEditableText() != null) {
            GameStrategyImageSpan P = P(f16, f17);
            for (GameStrategyImageSpan gameStrategyImageSpan : (GameStrategyImageSpan[]) getEditableText().getSpans(0, getText().length(), GameStrategyImageSpan.class)) {
                if (z16 || P != gameStrategyImageSpan) {
                    gameStrategyImageSpan.B();
                }
            }
        }
    }

    public synchronized void X() {
        this.S = true;
    }

    public void Z(Spannable spannable, Spannable spannable2, int i3, int i16, int i17, int i18) {
        wd1.a aVar = this.f212871f;
        if (aVar != null) {
            aVar.c(this, spannable, spannable2, i3, i16, i17, i18);
        }
    }

    public boolean a0() {
        return this.f212873g0;
    }

    @Override // android.widget.TextView
    public void addTextChangedListener(TextWatcher textWatcher) {
        super.addTextChangedListener(textWatcher);
        this.f212867d.add(textWatcher);
    }

    public void d0(wd1.a aVar) {
        this.f212871f = aVar;
    }

    public synchronized void e0() {
        this.S = false;
    }

    public void f0() {
        Iterator<TextWatcher> it = this.f212867d.iterator();
        while (it.hasNext()) {
            super.removeTextChangedListener(it.next());
        }
    }

    @Override // android.widget.TextView
    protected void onSelectionChanged(int i3, int i16) {
        super.onSelectionChanged(i3, i16);
        com.tencent.mobileqq.gamecenter.qa.view.b.c(this, i3, i16);
        if (this.f212870e0 != i3 || this.f212872f0 != i16) {
            this.f212870e0 = i3;
            this.f212872f0 = i16;
            if (!this.T) {
                this.U = true;
                com.tencent.mobileqq.gamecenter.qa.editor.effect.h.b(this, new com.tencent.mobileqq.gamecenter.qa.editor.effect.g[0]);
                this.U = false;
                g0(true);
            }
            wd1.a aVar = this.f212871f;
            if (aVar != null) {
                this.f212869e = true;
                aVar.a(this, i3, i16);
                this.f212869e = false;
            }
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanAdded(Spannable spannable, Object obj, int i3, int i16) {
        boolean z16 = true;
        QLog.d("GameStrategyEditTextView", 2, "onSpanAdded text:", spannable, "span:", obj, " start:", Integer.valueOf(i3), " end:", Integer.valueOf(i16));
        this.f212866c0 = true;
        if (obj instanceof zd1.b) {
            this.V = true;
            if ((!this.f212873g0 && spannable.length() <= 0) || (!this.f212873g0 && spannable.length() <= i3)) {
                f0();
                append("\u200b");
                K();
            }
        } else if (obj instanceof zd1.c) {
            this.W = true;
            if ((!this.f212873g0 && spannable.length() <= 0) || (!this.f212873g0 && spannable.length() <= i3)) {
                f0();
                append("\u200b");
                K();
            }
        } else if (obj instanceof AlignmentSpan) {
            AlignmentSpan alignmentSpan = (AlignmentSpan) obj;
            if (alignmentSpan.getAlignment() == Layout.Alignment.ALIGN_CENTER || alignmentSpan.getAlignment() == Layout.Alignment.ALIGN_OPPOSITE) {
                if (this.f212864a0 <= spannable.length()) {
                    z16 = false;
                }
                if (!z16 && i3 == i16) {
                    f0();
                    append("\u200b");
                    K();
                }
            }
        }
        if ((obj instanceof zd1.e) && (obj instanceof ParagraphStyle)) {
            g0(false);
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanChanged(Spannable spannable, Object obj, int i3, int i16, int i17, int i18) {
        this.f212866c0 = true;
        if ((obj instanceof zd1.e) && (obj instanceof ParagraphStyle)) {
            g0(false);
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanRemoved(Spannable spannable, Object obj, int i3, int i16) {
        QLog.d("GameStrategyEditTextView", 2, "onSpanRemoved text:", spannable, "span:", obj, " start:", Integer.valueOf(i3), " end:", Integer.valueOf(i16));
        this.f212866c0 = true;
        if (obj instanceof zd1.b) {
            this.V = false;
        } else if (obj instanceof zd1.c) {
            this.W = false;
        }
        if ((obj instanceof zd1.e) && (obj instanceof ParagraphStyle)) {
            g0(false);
        }
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        QLog.d("GameStrategyEditTextView", 2, "onTextChanged text:", charSequence, "start:", Integer.valueOf(i3), " lengthBefore:", Integer.valueOf(i16), " lengthAfter:", Integer.valueOf(i17));
        super.onTextChanged(charSequence, i3, i16, i17);
        this.f212865b0 = true;
        ac acVar = this.f212878j0;
        if (acVar != null) {
            acVar.f(this);
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i3) {
        ac acVar;
        if (i3 == 16908322) {
            if (h0() > 1) {
                QQToast.makeText(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(R.string.f13679054), 0).show();
                ActionMode actionMode = this.C;
                if (actionMode != null) {
                    actionMode.hide(-1L);
                    this.C.finish();
                }
                return true;
            }
            ac acVar2 = this.f212878j0;
            if (acVar2 != null) {
                acVar2.e(this);
            }
        } else if (i3 == 16908321) {
            ac acVar3 = this.f212878j0;
            if (acVar3 != null) {
                acVar3.c(this);
            }
        } else if (i3 == 16908320 && (acVar = this.f212878j0) != null) {
            acVar.d(this);
        }
        return super.onTextContextMenuItem(i3);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        char c16;
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        int totalPaddingLeft = x16 - getTotalPaddingLeft();
        int totalPaddingTop = y16 - getTotalPaddingTop();
        int scrollX = totalPaddingLeft + getScrollX();
        int scrollY = totalPaddingTop + getScrollY();
        Layout layout = getLayout();
        int lineForVertical = layout.getLineForVertical(scrollY);
        int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, scrollX);
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int lineTop = layout.getLineTop(lineForVertical);
        int lineBottom = layout.getLineBottom(lineForVertical);
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) getEditableText().getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
        GameStrategyImageSpan[] gameStrategyImageSpanArr = (GameStrategyImageSpan[]) getEditableText().getSpans(offsetForHorizontal, offsetForHorizontal, GameStrategyImageSpan.class);
        w[] wVarArr = (w[]) getEditableText().getSpans(offsetForHorizontal, offsetForHorizontal, w.class);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                if (motionEvent.getX() - this.G <= ViewConfiguration.get(getContext()).getScaledTouchSlop() && motionEvent.getY() - this.H <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) {
                    if (this.I) {
                        QLog.i("GameStrategyEditTextView", 2, "[onTouchEvent] mPerformLongClick");
                        if (gameStrategyImageSpanArr.length != 0) {
                            c16 = 0;
                            this.J = gameStrategyImageSpanArr[0];
                        } else {
                            c16 = 0;
                        }
                        if (clickableSpanArr.length != 0) {
                            ClickableSpan clickableSpan = clickableSpanArr[c16];
                            if (clickableSpan instanceof ab) {
                                this.K = clickableSpan;
                            }
                        }
                        if (wVarArr.length != 0) {
                            this.L = wVarArr[c16];
                        }
                        return super.onTouchEvent(motionEvent);
                    }
                    QLog.i("GameStrategyEditTextView", 2, "[onTouchEvent] x:" + scrollX + ",y:" + scrollY + ",line:" + lineForVertical + ",off:" + offsetForHorizontal + ",lineTop:" + lineTop + ",lineBottom:" + lineBottom);
                    if (wVarArr.length != 0) {
                        wVarArr[0].q(this, rawX, rawY, lineTop, lineBottom, offsetForHorizontal);
                    } else {
                        if (clickableSpanArr.length != 0) {
                            clickableSpanArr[0].onClick(this);
                            ClickableSpan clickableSpan2 = clickableSpanArr[0];
                            if (clickableSpan2 instanceof ab) {
                                ((ab) clickableSpan2).x(this, rawX, rawY, lineTop, lineBottom, offsetForHorizontal);
                            }
                        }
                        if (gameStrategyImageSpanArr.length != 0) {
                            GameStrategyImageSpan gameStrategyImageSpan = gameStrategyImageSpanArr[0];
                            gameStrategyImageSpan.x(this, scrollX, scrollY);
                            for (GameStrategyImageSpan gameStrategyImageSpan2 : (GameStrategyImageSpan[]) getEditableText().getSpans(0, getText().length(), GameStrategyImageSpan.class)) {
                                if (gameStrategyImageSpan != gameStrategyImageSpan2) {
                                    gameStrategyImageSpan2.B();
                                }
                            }
                        } else {
                            for (GameStrategyImageSpan gameStrategyImageSpan3 : (GameStrategyImageSpan[]) getEditableText().getSpans(0, getText().length(), GameStrategyImageSpan.class)) {
                                gameStrategyImageSpan3.B();
                            }
                        }
                    }
                } else {
                    return super.onTouchEvent(motionEvent);
                }
            }
        } else {
            this.G = motionEvent.getX();
            this.H = motionEvent.getY();
            this.I = false;
            this.J = null;
            this.L = null;
            this.K = null;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        this.I = true;
        W(0.0f, 0.0f, true);
        return super.performLongClick();
    }

    @Override // android.widget.TextView
    public void removeTextChangedListener(TextWatcher textWatcher) {
        super.removeTextChangedListener(textWatcher);
        this.f212867d.remove(textWatcher);
    }

    public void setBackDelete(boolean z16) {
        this.f212873g0 = z16;
    }

    public void setMenuClickListener(d dVar) {
        this.f212876i = dVar;
    }

    public void setNewLineKeyDown() {
        this.f212875h0 = true;
    }

    public void setOnNewLineEnterListener(e eVar) {
        this.f212877i0 = eVar;
    }

    public void setSpanCreator(f fVar) {
        this.f212878j0 = new ac(fVar);
    }

    public GameStrategyEditTextView(Context context) {
        super(context);
        this.f212867d = new ArrayList();
        this.f212869e = false;
        this.D = new a();
        this.E = new b();
        this.F = new c();
        this.f212870e0 = -1;
        this.f212872f0 = -1;
        this.f212879k0 = Pattern.compile("\\{\\{video:.*\\}\\}");
        this.f212880l0 = false;
        Y();
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b implements ActionMode.Callback {
        b() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            GameStrategyEditTextView.this.C = actionMode;
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements TextWatcher {
        c() {
        }

        @Override // android.text.TextWatcher
        public synchronized void afterTextChanged(Editable editable) {
            boolean z16;
            boolean z17;
            String str;
            QLog.d("GameStrategyEditTextView", 2, "afterTextChanged s:", editable, "mPreviousTextLength:", Integer.valueOf(GameStrategyEditTextView.this.f212864a0));
            GameStrategyEditTextView gameStrategyEditTextView = GameStrategyEditTextView.this;
            if (gameStrategyEditTextView.f212864a0 > editable.length()) {
                z16 = true;
            } else {
                z16 = false;
            }
            gameStrategyEditTextView.f212873g0 = z16;
            if (GameStrategyEditTextView.this.V || GameStrategyEditTextView.this.W) {
                if (GameStrategyEditTextView.this.f212864a0 >= editable.length()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17 && editable.toString().endsWith("\n")) {
                    GameStrategyEditTextView.this.append("\u200b");
                }
            }
            String obj = editable.toString();
            if (GameStrategyEditTextView.this.Q != null) {
                str = GameStrategyEditTextView.this.Q;
            } else {
                str = "";
            }
            if (GameStrategyEditTextView.this.f212871f != null && !GameStrategyEditTextView.this.S && !str.equals(obj)) {
                Spannable N = GameStrategyEditTextView.this.N();
                wd1.a aVar = GameStrategyEditTextView.this.f212871f;
                GameStrategyEditTextView gameStrategyEditTextView2 = GameStrategyEditTextView.this;
                aVar.c(gameStrategyEditTextView2, gameStrategyEditTextView2.R, N, GameStrategyEditTextView.this.M, GameStrategyEditTextView.this.N, GameStrategyEditTextView.this.getSelectionStart(), GameStrategyEditTextView.this.getSelectionEnd());
                GameStrategyEditTextView.this.Q = obj;
            }
            GameStrategyEditTextView.this.f212865b0 = true;
            GameStrategyEditTextView.this.f212866c0 = true;
            GameStrategyEditTextView.this.g0(false);
            GameStrategyEditTextView.this.L();
            if (GameStrategyEditTextView.this.f212875h0) {
                GameStrategyEditTextView.this.f212875h0 = false;
                GameStrategyEditTextView.this.f0();
                if (GameStrategyEditTextView.this.f212877i0 != null) {
                    GameStrategyEditTextView.this.f212877i0.a();
                }
                GameStrategyEditTextView.this.K();
            }
        }

        @Override // android.text.TextWatcher
        public synchronized void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            String str;
            if (GameStrategyEditTextView.this.P != null) {
                str = GameStrategyEditTextView.this.P;
            } else {
                str = "";
            }
            if (!GameStrategyEditTextView.this.S && !charSequence.toString().equals(str)) {
                GameStrategyEditTextView gameStrategyEditTextView = GameStrategyEditTextView.this;
                gameStrategyEditTextView.M = gameStrategyEditTextView.getSelectionStart();
                GameStrategyEditTextView gameStrategyEditTextView2 = GameStrategyEditTextView.this;
                gameStrategyEditTextView2.N = gameStrategyEditTextView2.getSelectionEnd();
                GameStrategyEditTextView.this.P = charSequence.toString();
                GameStrategyEditTextView gameStrategyEditTextView3 = GameStrategyEditTextView.this;
                gameStrategyEditTextView3.Q = gameStrategyEditTextView3.P;
                GameStrategyEditTextView gameStrategyEditTextView4 = GameStrategyEditTextView.this;
                gameStrategyEditTextView4.R = gameStrategyEditTextView4.N();
            }
            GameStrategyEditTextView.this.f212865b0 = true;
            GameStrategyEditTextView.this.f212864a0 = charSequence.length();
            QLog.d("GameStrategyEditTextView", 2, "beforeTextChanged s:", charSequence, "start:", Integer.valueOf(i17), " end:", Integer.valueOf(i17), " mPreviousTextLength:", Integer.valueOf(GameStrategyEditTextView.this.f212864a0));
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
