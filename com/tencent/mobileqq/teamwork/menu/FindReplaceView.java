package com.tencent.mobileqq.teamwork.menu;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.nativepreview.wrapper.model.DocSearchState;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class FindReplaceView extends FrameLayout {
    private TextView C;
    private TextView D;
    private b E;
    private DocSearchState F;

    /* renamed from: d, reason: collision with root package name */
    private EditText f292170d;

    /* renamed from: e, reason: collision with root package name */
    private EditText f292171e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f292172f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f292173h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f292174i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f292175m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface b {
        void a(DocSearchState docSearchState);

        boolean b(DocSearchState docSearchState, boolean z16);

        boolean c(DocSearchState docSearchState, long j3);

        DocSearchState getCurrentState();
    }

    public FindReplaceView(Context context) {
        this(context, null);
    }

    private void i() {
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.e6d, this);
        this.f292170d = (EditText) findViewById(R.id.v6c);
        this.f292171e = (EditText) findViewById(R.id.f73063sj);
        this.f292172f = (TextView) findViewById(R.id.v6b);
        this.f292173h = (TextView) findViewById(R.id.aou);
        this.f292174i = (TextView) findViewById(R.id.f27480gc);
        this.f292175m = (TextView) findViewById(R.id.f8w);
        this.C = (TextView) findViewById(R.id.f73043sh);
        this.D = (TextView) findViewById(R.id.f73023sf);
        this.f292170d.addTextChangedListener(new a());
        this.f292174i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.ao
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FindReplaceView.this.j(view);
            }
        });
        this.f292175m.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.ap
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FindReplaceView.this.k(view);
            }
        });
        this.C.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.aq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FindReplaceView.this.l(view);
            }
        });
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.ar
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FindReplaceView.this.m(view);
            }
        });
        this.f292173h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.teamwork.menu.as
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FindReplaceView.this.n(view);
            }
        });
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        q(-1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        q(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        s(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        s(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        p();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o() {
        DocSearchState currentState = this.E.getCurrentState();
        this.F = currentState;
        v(currentState);
    }

    private void p() {
        b bVar = this.E;
        if (bVar == null) {
            return;
        }
        bVar.a(this.F);
        this.F = new DocSearchState();
        t();
        ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(getWindowToken(), 0);
    }

    private void q(int i3) {
        b bVar = this.E;
        if (bVar != null && bVar.c(this.F, i3)) {
            DocSearchState currentState = this.E.getCurrentState();
            this.F = currentState;
            v(currentState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        int i3;
        if (this.E == null) {
            return;
        }
        TextView textView = this.f292172f;
        if (TextUtils.isEmpty(str)) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        textView.setVisibility(i3);
        this.F.setPattern(str);
        if (this.E.c(this.F, 0L)) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.teamwork.menu.at
                @Override // java.lang.Runnable
                public final void run() {
                    FindReplaceView.this.o();
                }
            }, 500L);
        }
    }

    private void s(boolean z16) {
        if (this.E == null) {
            return;
        }
        this.F.setReplacement(this.f292171e.getText().toString());
        if (this.E.b(this.F, z16)) {
            DocSearchState currentState = this.E.getCurrentState();
            this.F = currentState;
            v(currentState);
        }
    }

    private void t() {
        this.f292170d.setText("");
        this.f292171e.setText("");
        this.f292172f.setText("0");
        this.f292174i.setEnabled(false);
        this.f292175m.setEnabled(false);
        this.C.setEnabled(false);
        this.D.setEnabled(false);
        this.f292172f.setVisibility(4);
        if (!this.F.getReplace()) {
            this.f292171e.setVisibility(8);
            this.C.setVisibility(4);
            this.D.setVisibility(4);
        } else {
            this.f292171e.setVisibility(0);
            this.C.setVisibility(0);
            this.D.setVisibility(0);
        }
    }

    private void v(DocSearchState docSearchState) {
        if (docSearchState.getCount() > 0) {
            this.f292172f.setText((docSearchState.getIndex() + 1) + "/" + docSearchState.getCount());
            this.f292174i.setEnabled(true);
            this.f292175m.setEnabled(true);
            this.C.setEnabled(true);
            this.D.setEnabled(true);
            return;
        }
        this.f292172f.setText("0");
        this.f292174i.setEnabled(false);
        this.f292175m.setEnabled(false);
        this.C.setEnabled(false);
        this.D.setEnabled(false);
    }

    public void setSearchHandler(b bVar) {
        this.E = bVar;
    }

    public void setSearchOptions(DocSearchState docSearchState) {
        if (docSearchState == null) {
            return;
        }
        this.F.setFindType(docSearchState.getFindType());
        this.F.setCaseSensitive(docSearchState.getCaseSensitive());
        this.F.setHighlight(docSearchState.getHighlight());
        this.F.setReplace(docSearchState.getReplace());
        t();
    }

    public void u() {
        this.f292170d.requestFocus();
        ((InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(this.f292170d, 0);
    }

    public FindReplaceView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FindReplaceView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public FindReplaceView(Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.F = new DocSearchState();
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            FindReplaceView findReplaceView = FindReplaceView.this;
            findReplaceView.r(findReplaceView.f292170d.getText().toString());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
