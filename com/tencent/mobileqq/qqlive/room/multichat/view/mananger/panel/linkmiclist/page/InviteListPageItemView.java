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
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.RoundImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;

/* loaded from: classes17.dex */
public class InviteListPageItemView extends FrameLayout implements ThreadCenter.HandlerKeyable {
    static IPatchRedirector $redirector_;
    private b C;
    private Runnable D;

    /* renamed from: d, reason: collision with root package name */
    private View f271780d;

    /* renamed from: e, reason: collision with root package name */
    private RoundImageView f271781e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f271782f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f271783h;

    /* renamed from: i, reason: collision with root package name */
    private Button f271784i;

    /* renamed from: m, reason: collision with root package name */
    private qn3.a f271785m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) InviteListPageItemView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (InviteListPageItemView.this.C != null) {
                    if (InviteListPageItemView.this.C.b() > 0 && System.currentTimeMillis() - InviteListPageItemView.this.C.b() < 2000) {
                        QQToastUtil.showQQToast(-1, "\u9080\u8bf7\u8fc7\u4e8e\u9891\u7e41\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                    } else {
                        InviteListPageItemView.this.C.a();
                    }
                }
                InviteListPageItemView.this.f271784i.setTextColor(2063597567);
                InviteListPageItemView.this.f271784i.setText("\u5df2\u9080\u8bf7");
                InviteListPageItemView.b(InviteListPageItemView.this);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes17.dex */
    public interface b {
        void a();

        long b();
    }

    public InviteListPageItemView(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            this.D = new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page.InviteListPageItemView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InviteListPageItemView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (InviteListPageItemView.this.f271785m != null) {
                        InviteListPageItemView.this.f271785m.f429102e = false;
                        InviteListPageItemView inviteListPageItemView = InviteListPageItemView.this;
                        inviteListPageItemView.e(inviteListPageItemView.f271785m);
                    }
                }
            };
            f();
        }
    }

    static /* bridge */ /* synthetic */ qi2.a b(InviteListPageItemView inviteListPageItemView) {
        inviteListPageItemView.getClass();
        return null;
    }

    private void f() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fme, (ViewGroup) this, true);
        this.f271780d = inflate;
        this.f271781e = (RoundImageView) inflate.findViewById(R.id.t0o);
        this.f271782f = (TextView) this.f271780d.findViewById(R.id.sng);
        this.f271783h = (TextView) this.f271780d.findViewById(R.id.ven);
        Button button = (Button) this.f271780d.findViewById(R.id.f83034ih);
        this.f271784i = button;
        button.setOnClickListener(new a());
    }

    public void e(qn3.a aVar) {
        int i3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        this.f271785m = aVar;
        if (aVar != null) {
            this.f271782f.setText(aVar.f429100c);
            this.f271781e.setImageDrawable(URLDrawable.getDrawable(aVar.f429101d));
            Button button = this.f271784i;
            if (button != null) {
                if (aVar.f429102e) {
                    i3 = 2063597567;
                } else {
                    i3 = -1;
                }
                button.setTextColor(i3);
                Button button2 = this.f271784i;
                if (aVar.f429102e) {
                    str = "\u5df2\u9080\u8bf7";
                } else {
                    str = "\u53d1\u51fa\u9080\u8bf7";
                }
                button2.setText(str);
            }
        }
        ThreadCenter.clear(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onDetachedFromWindow();
            ThreadCenter.clear(this);
        }
    }

    public void setCallBack(qi2.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    public void setUiCallback(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        } else {
            this.C = bVar;
        }
    }

    public InviteListPageItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.D = new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page.InviteListPageItemView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InviteListPageItemView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (InviteListPageItemView.this.f271785m != null) {
                        InviteListPageItemView.this.f271785m.f429102e = false;
                        InviteListPageItemView inviteListPageItemView = InviteListPageItemView.this;
                        inviteListPageItemView.e(inviteListPageItemView.f271785m);
                    }
                }
            };
            f();
        }
    }

    public InviteListPageItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.D = new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.mananger.panel.linkmiclist.page.InviteListPageItemView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InviteListPageItemView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (InviteListPageItemView.this.f271785m != null) {
                        InviteListPageItemView.this.f271785m.f429102e = false;
                        InviteListPageItemView inviteListPageItemView = InviteListPageItemView.this;
                        inviteListPageItemView.e(inviteListPageItemView.f271785m);
                    }
                }
            };
            f();
        }
    }
}
