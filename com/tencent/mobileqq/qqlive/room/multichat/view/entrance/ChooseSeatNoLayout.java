package com.tencent.mobileqq.qqlive.room.multichat.view.entrance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class ChooseSeatNoLayout extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private List<ChooseSeatItemView> f271702d;

    /* renamed from: e, reason: collision with root package name */
    private a f271703e;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void onSelected(int i3);
    }

    public ChooseSeatNoLayout(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f271702d = new ArrayList();
            c();
        }
    }

    private void b(int i3) {
        boolean z16;
        for (int i16 = 0; i16 < this.f271702d.size(); i16++) {
            if (this.f271702d.get(i16).b() == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f271702d.get(i16).a(z16);
        }
    }

    private void c() {
        View.inflate(getContext(), R.layout.h_7, this);
        this.f271702d.add((ChooseSeatItemView) findViewById(R.id.f81444e7));
        this.f271702d.add((ChooseSeatItemView) findViewById(R.id.f81454e8));
        this.f271702d.add((ChooseSeatItemView) findViewById(R.id.f81464e9));
        this.f271702d.add((ChooseSeatItemView) findViewById(R.id.f81474e_));
        this.f271702d.add((ChooseSeatItemView) findViewById(R.id.f81484ea));
        this.f271702d.add((ChooseSeatItemView) findViewById(R.id.f81494eb));
        this.f271702d.add((ChooseSeatItemView) findViewById(R.id.f81504ec));
        this.f271702d.add((ChooseSeatItemView) findViewById(R.id.f81514ed));
        this.f271702d.add((ChooseSeatItemView) findViewById(R.id.f81524ee));
        for (int i3 = 0; i3 < this.f271702d.size(); i3++) {
            final ChooseSeatItemView chooseSeatItemView = this.f271702d.get(i3);
            chooseSeatItemView.setSeatNo(i3);
            chooseSeatItemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.entrance.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ChooseSeatNoLayout.this.d(chooseSeatItemView, view);
                }
            });
        }
        setBackgroundColor(-16449505);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(ChooseSeatItemView chooseSeatItemView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        b(chooseSeatItemView.b());
        a aVar = this.f271703e;
        if (aVar != null) {
            aVar.onSelected(chooseSeatItemView.b());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setOnSelectedListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f271703e = aVar;
        }
    }

    public ChooseSeatNoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f271702d = new ArrayList();
            c();
        }
    }

    public ChooseSeatNoLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f271702d = new ArrayList();
            c();
        }
    }
}
