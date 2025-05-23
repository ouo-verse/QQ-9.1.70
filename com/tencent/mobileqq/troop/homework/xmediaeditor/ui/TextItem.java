package com.tencent.mobileqq.troop.homework.xmediaeditor.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.f;
import com.tencent.mobileqq.troop.homework.xmediaeditor.ui.b;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TextItem extends com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a<e, f> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private LayoutInflater f297458f;

    /* renamed from: h, reason: collision with root package name */
    private Context f297459h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements View.OnKeyListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f297465d;

        a(e eVar) {
            this.f297465d = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TextItem.this, (Object) eVar);
            }
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            if (keyEvent.getAction() != 0 || i3 != 67 || this.f297465d.f297476f.getSelectionStart() != 0) {
                return false;
            }
            TextItem.this.f297479e.f(this.f297465d);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b implements TextView.OnEditorActionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f297467d;

        b(e eVar) {
            this.f297467d = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TextItem.this, (Object) eVar);
            }
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
            } else {
                if (i3 == 4 || i3 == 6 || (keyEvent != null && 66 == keyEvent.getKeyCode() && keyEvent.getAction() == 0)) {
                    String obj = this.f297467d.f297476f.getEditableText().toString();
                    int selectionStart = this.f297467d.f297476f.getSelectionStart();
                    String n3 = TextItem.this.n(obj.substring(0, selectionStart));
                    if (!TextUtils.isEmpty(n3)) {
                        this.f297467d.f297476f.getEditableText().replace(selectionStart, selectionStart, "\n" + n3);
                        this.f297467d.f297476f.setSelection(selectionStart + n3.length() + 1);
                    }
                }
                z16 = false;
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c implements View.OnFocusChangeListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f297469d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f297470e;

        c(f fVar, e eVar) {
            this.f297469d = fVar;
            this.f297470e = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TextItem.this, fVar, eVar);
            }
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Boolean.valueOf(z16));
                return;
            }
            QLog.i("xmediaEditor", 1, "mData.position:" + this.f297469d.f297409a + ", text:" + this.f297469d.f297413d + ",onFocusChange:" + z16);
            if (z16) {
                this.f297470e.f297476f.setCursorVisible(true);
                TextItem.this.f297479e.a(this.f297470e);
                this.f297469d.f297415f = true;
            } else {
                this.f297470e.f297476f.setCursorVisible(false);
                TextItem.this.f297479e.d(this.f297470e);
            }
            this.f297470e.f297476f.setFocusable(z16);
            this.f297470e.f297476f.setFocusableInTouchMode(z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f297472d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f297473e;

        d(e eVar, f fVar) {
            this.f297472d = eVar;
            this.f297473e = fVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TextItem.this, eVar, fVar);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            if (TextItem.this.f297478d.y() != 0) {
                int y16 = TextItem.this.f297478d.y();
                int p16 = TextItem.this.f297478d.p();
                int i18 = y16 - p16;
                int i19 = i17 - i16;
                if (i19 > i18) {
                    QQToast.makeText(TextItem.this.f297459h, "\u6700\u591a\u53ef\u4ee5\u8f93\u5165500\u4e2a\u5b57", 1).show();
                    int i26 = i18 + i16;
                    this.f297472d.f297476f.removeTextChangedListener(this);
                    int i27 = i3 + i26;
                    String str = charSequence.subSequence(0, i27).toString() + charSequence.subSequence(i3 + i17, charSequence.length()).toString();
                    this.f297472d.f297476f.setText(str);
                    this.f297472d.f297476f.addTextChangedListener(this);
                    this.f297472d.f297476f.setSelection(i27);
                    TextItem.this.f297479e.c(p16, i26 + p16);
                    f fVar = this.f297473e;
                    fVar.f297414e = i27;
                    fVar.g(str);
                } else {
                    TextItem.this.f297479e.c(p16, p16 + i19);
                    f fVar2 = this.f297473e;
                    fVar2.f297414e = i3 + i19;
                    fVar2.g(charSequence.toString());
                }
            } else {
                int p17 = TextItem.this.f297478d.p();
                TextItem.this.f297479e.c(p17, (p17 + i17) - i16);
                f fVar3 = this.f297473e;
                fVar3.f297414e = i3 + i17;
                fVar3.g(charSequence.toString());
            }
            QLog.i("xmediaEditor", 1, "onTextChanged, mData.position:" + this.f297473e.f297409a + ", text:" + this.f297473e.f297413d + ",Listener:" + toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class e extends b.a<f> {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        public TextView f297475e;

        /* renamed from: f, reason: collision with root package name */
        public EditText f297476f;

        /* renamed from: h, reason: collision with root package name */
        public TextWatcher f297477h;

        public e(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            } else {
                this.f297475e = (TextView) view.findViewById(R.id.jjl);
                this.f297476f = (EditText) view.findViewById(R.id.btq);
            }
        }
    }

    public TextItem(XMediaEditor xMediaEditor, Context context) {
        super(xMediaEditor);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) xMediaEditor, (Object) context);
        } else {
            this.f297459h = context;
            this.f297458f = LayoutInflater.from(context);
        }
    }

    public String n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        String[] split = (str + "a").split("\n");
        if (split.length > 0) {
            String str2 = split[split.length - 1];
            if (Pattern.compile("^[1-9]\\d*[\u3001,\uff0c.)\uff09]\\d+").matcher(str2).find()) {
                return "";
            }
            Matcher matcher = Pattern.compile("^[1-9]\\d*[\u3001,\uff0c.)\uff09]").matcher(str2);
            if (matcher.find()) {
                String group = matcher.group();
                String substring = group.substring(0, group.length() - 1);
                return (Integer.parseInt(substring) + 1) + group.substring(group.length() - 1);
            }
        }
        return "";
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void a(e eVar, f fVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, eVar, fVar, Integer.valueOf(i3));
            return;
        }
        QLog.i("xmediaEditor", 1, "Text onBindViewHolder. vh hash=" + eVar.hashCode() + ", mData.position:" + fVar.f297409a + ", text:" + fVar.f297413d);
        if (eVar.f297477h != null) {
            QLog.i("xmediaEditor", 1, "removeTextChangedListener, mData.position:" + fVar.f297409a + ", text:" + fVar.f297413d + ",Listener:" + eVar.f297477h.toString());
            eVar.f297476f.removeTextChangedListener(eVar.f297477h);
            eVar.f297477h = null;
        }
        if (i3 != 0) {
            eVar.f297476f.setVisibility(8);
            eVar.f297475e.setText(fVar.f297413d);
            if (TextUtils.isEmpty(fVar.f297413d)) {
                eVar.itemView.setVisibility(8);
                eVar.f297475e.setVisibility(8);
                return;
            } else {
                eVar.f297475e.setVisibility(0);
                eVar.itemView.setVisibility(0);
                return;
            }
        }
        eVar.f297476f.setVisibility(0);
        eVar.f297475e.setVisibility(8);
        eVar.f297476f.setText(fVar.f297413d);
        QLog.i("xmediaEditor", 1, "mData.position:" + fVar.f297409a + ", text:" + fVar.f297413d);
        eVar.f297476f.setOnFocusChangeListener(null);
        eVar.f297476f.setOnKeyListener(new a(eVar));
        eVar.f297476f.setOnEditorActionListener(new b(eVar));
        eVar.f297476f.setOnFocusChangeListener(new c(fVar, eVar));
        eVar.f297477h = new d(eVar, fVar);
        QLog.i("xmediaEditor", 1, "addTextChangedListener, mData.position:" + fVar.f297409a + ", text:" + fVar.f297413d + ",Listener:" + eVar.f297477h.toString());
        eVar.f297476f.addTextChangedListener(eVar.f297477h);
        if (fVar.f297415f) {
            eVar.f297476f.setFocusable(true);
            eVar.f297476f.setFocusableInTouchMode(true);
            ThreadManager.getUIHandler().post(new Runnable(eVar, fVar) { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ e f297463d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ f f297464e;

                {
                    this.f297463d = eVar;
                    this.f297464e = fVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TextItem.this, eVar, fVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    this.f297463d.f297476f.requestFocus();
                    this.f297463d.f297476f.findFocus();
                    this.f297463d.f297476f.setSelection(this.f297464e.f297414e);
                }
            });
        } else {
            eVar.f297476f.clearFocus();
            eVar.f297476f.setFocusable(false);
            eVar.f297476f.setFocusableInTouchMode(false);
        }
        if (this.f297478d.A()) {
            if (((f) eVar.f297481d).f297409a == 1 && this.f297478d.getAdapter().getItemCount() == 2) {
                eVar.f297476f.setHint(this.f297478d.s());
                return;
            } else {
                eVar.f297476f.setHint("");
                return;
            }
        }
        if (((f) eVar.f297481d).f297409a == 0 && this.f297478d.getAdapter().getItemCount() == 1) {
            eVar.f297476f.setHint(this.f297478d.s());
        } else {
            eVar.f297476f.setHint("");
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public e b(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup);
        }
        e eVar = new e(this.f297458f.inflate(R.layout.b3m, viewGroup, false));
        QLog.i("xmediaEditor", 1, "onCreateViewHolder. vh hash=" + eVar.hashCode());
        eVar.f297476f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TextItem.this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else if (!view.hasFocus()) {
                    view.setFocusable(true);
                    view.setFocusableInTouchMode(true);
                    ThreadManager.getUIHandler().post(new Runnable(view) { // from class: com.tencent.mobileqq.troop.homework.xmediaeditor.ui.TextItem.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ View f297461d;

                        {
                            this.f297461d = view;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) view);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                this.f297461d.requestFocus();
                                this.f297461d.findFocus();
                            }
                        }
                    });
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        if (this.f297478d.w() != 0) {
            eVar.itemView.setPadding(this.f297478d.w(), 0, this.f297478d.w(), 0);
        }
        return eVar;
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void e(View view, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) eVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void h(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar);
        } else {
            super.h(eVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.xmediaeditor.ui.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void i(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) eVar);
            return;
        }
        super.i(eVar);
        f fVar = (f) eVar.f297481d;
        TextWatcher textWatcher = eVar.f297477h;
        if (textWatcher != null) {
            eVar.f297476f.removeTextChangedListener(textWatcher);
            QLog.i("xmediaEditor", 2, "onViewRecycled, position:" + ((f) eVar.f297481d).f297409a + ", text:" + fVar.f297413d + ",Listener:" + eVar.f297477h.toString());
            eVar.f297477h = null;
        }
        eVar.f297476f.setOnFocusChangeListener(null);
        if (!fVar.f297416g) {
            fVar.f297414e = eVar.f297476f.getSelectionStart();
        } else {
            fVar.f297416g = true;
        }
        eVar.f297476f.clearFocus();
        eVar.f297476f.setFocusable(false);
        eVar.f297476f.setFocusableInTouchMode(false);
    }
}
