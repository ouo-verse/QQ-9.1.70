package com.tencent.mobileqq.qqlive.room.multichat.view.entrance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.multichat.view.entrance.ChooseSeatNoLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes17.dex */
public class ChooseSeatNoPanel extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ChooseSeatNoLayout f271704d;

    /* renamed from: e, reason: collision with root package name */
    private ChooseSeatNoLayout.a f271705e;

    /* renamed from: f, reason: collision with root package name */
    private Button f271706f;

    /* renamed from: h, reason: collision with root package name */
    private int f271707h;

    public ChooseSeatNoPanel(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f271707h = 0;
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(int i3) {
        this.f271707h = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ChooseSeatNoLayout.a aVar = this.f271705e;
        if (aVar != null) {
            aVar.onSelected(this.f271707h);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    void c() {
        View.inflate(getContext(), R.layout.h_8, this);
        this.f271704d = (ChooseSeatNoLayout) findViewById(R.id.twe);
        this.f271706f = (Button) findViewById(R.id.twa);
        this.f271704d.setOnSelectedListener(new ChooseSeatNoLayout.a() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.entrance.b
            @Override // com.tencent.mobileqq.qqlive.room.multichat.view.entrance.ChooseSeatNoLayout.a
            public final void onSelected(int i3) {
                ChooseSeatNoPanel.this.d(i3);
            }
        });
        this.f271706f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.entrance.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChooseSeatNoPanel.this.e(view);
            }
        });
    }

    public void setOnSelectedListener(ChooseSeatNoLayout.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f271705e = aVar;
        }
    }

    public ChooseSeatNoPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f271707h = 0;
            c();
        }
    }

    public ChooseSeatNoPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f271707h = 0;
            c();
        }
    }
}
