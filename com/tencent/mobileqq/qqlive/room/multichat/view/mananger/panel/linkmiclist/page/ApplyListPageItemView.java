package com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.multichat.report.IMultiAvChatReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes17.dex */
public class ApplyListPageItemView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private ViewGroup C;
    private Button D;
    private Button E;
    private qn3.a F;
    private c G;

    /* renamed from: d, reason: collision with root package name */
    private View f271761d;

    /* renamed from: e, reason: collision with root package name */
    private RoundImageView f271762e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f271763f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f271764h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f271765i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f271766m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ApplyListPageItemView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ApplyListPageItemView.a(ApplyListPageItemView.this);
                if (ApplyListPageItemView.this.G != null) {
                    ApplyListPageItemView.this.G.a(ApplyListPageItemView.this.F);
                }
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportCustomEvent(IMultiAvChatReporter.EVENT_ANCHOR_ACCEPT, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateAnchorAcceptEventParam(ApplyListPageItemView.this.F.f429099b));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ApplyListPageItemView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ApplyListPageItemView.a(ApplyListPageItemView.this);
                if (ApplyListPageItemView.this.G != null) {
                    ApplyListPageItemView.this.G.a(ApplyListPageItemView.this.F);
                }
                ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).reportCustomEvent(IMultiAvChatReporter.EVENT_ANCHOR_REJECT, ((IMultiAvChatReporter) QRoute.api(IMultiAvChatReporter.class)).generateAnchorRejectEventParam(ApplyListPageItemView.this.F.f429099b));
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes17.dex */
    public interface c {
        void a(qn3.a aVar);
    }

    public ApplyListPageItemView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            e();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    static /* bridge */ /* synthetic */ qi2.a a(ApplyListPageItemView applyListPageItemView) {
        applyListPageItemView.getClass();
        return null;
    }

    private void e() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fma, (ViewGroup) this, true);
        this.f271761d = inflate;
        this.f271762e = (RoundImageView) inflate.findViewById(R.id.t0o);
        this.f271763f = (TextView) this.f271761d.findViewById(R.id.sng);
        this.f271764h = (TextView) this.f271761d.findViewById(R.id.ven);
        this.f271765i = (TextView) this.f271761d.findViewById(R.id.f1205579v);
        this.f271766m = (TextView) this.f271761d.findViewById(R.id.f97215js);
        this.C = (ViewGroup) this.f271761d.findViewById(R.id.t9r);
        Button button = (Button) this.f271761d.findViewById(R.id.s6o);
        this.D = button;
        button.setOnClickListener(new a());
        Button button2 = (Button) this.f271761d.findViewById(R.id.f72423qt);
        this.E = button2;
        button2.setOnClickListener(new b());
    }

    public void d(qn3.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        if (aVar != null) {
            this.f271763f.setText(aVar.f429100c);
            long max = Math.max(aVar.f429104g - (System.currentTimeMillis() / 1000), 0L);
            this.f271765i.setText("" + max);
            this.f271766m.setText("\u5206\u949f\u524d");
            this.f271762e.setImageDrawable(URLDrawable.getDrawable(aVar.f429101d));
        }
        this.F = aVar;
    }

    public void setCallBack(qi2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        }
    }

    public void setUiCallBack(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) cVar);
        } else {
            this.G = cVar;
        }
    }

    public ApplyListPageItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            e();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public ApplyListPageItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            e();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
