package com.tencent.mobileqq.qqlive.room.multichat.view.seat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.multichat.view.seat.MultiAvChatEmptySeatView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class MultiAvChatSeatView extends FrameLayout {
    static IPatchRedirector $redirector_;
    private c C;

    /* renamed from: d, reason: collision with root package name */
    private MultiAvChatEmptySeatView f271829d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f271830e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f271831f;

    /* renamed from: h, reason: collision with root package name */
    private MultiAvChatAudioSeatView f271832h;

    /* renamed from: i, reason: collision with root package name */
    private MultiAvChatUserInfoView f271833i;

    /* renamed from: m, reason: collision with root package name */
    private a f271834m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void a(@NonNull com.tencent.mobileqq.qqlive.room.multichat.store.b bVar, int i3);
    }

    public MultiAvChatSeatView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            i();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void i() {
        View.inflate(getContext(), R.layout.ha5, this);
        this.f271829d = (MultiAvChatEmptySeatView) findViewById(R.id.t0a);
        this.f271830e = (FrameLayout) findViewById(R.id.t0c);
        MultiAvChatAudioSeatView multiAvChatAudioSeatView = (MultiAvChatAudioSeatView) findViewById(R.id.t0b);
        this.f271832h = multiAvChatAudioSeatView;
        multiAvChatAudioSeatView.setVisibility(8);
        MultiAvChatUserInfoView multiAvChatUserInfoView = (MultiAvChatUserInfoView) findViewById(R.id.f115396vx);
        this.f271833i = multiAvChatUserInfoView;
        multiAvChatUserInfoView.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.f81434e6);
        this.f271831f = textView;
        textView.setVisibility(8);
        this.C = new c(this);
        this.f271833i.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.multichat.view.seat.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MultiAvChatSeatView.this.j(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        a aVar = this.f271834m;
        if (aVar != null) {
            aVar.a(this.C.d(), e());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiAvChatAudioSeatView b() {
        return this.f271832h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiAvChatEmptySeatView c() {
        return this.f271829d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView d() {
        return this.f271831f;
    }

    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.C.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiAvChatUserInfoView f() {
        return this.f271833i;
    }

    public FrameLayout g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f271830e;
    }

    public c h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (c) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.C;
    }

    public void setOnClickedEmptySeatListener(@NonNull MultiAvChatEmptySeatView.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
        } else {
            this.f271829d.setOnClickedEmptySeatListener(bVar);
        }
    }

    public void setOnClickedUserInfoItemListener(@NonNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar);
        } else {
            this.f271834m = aVar;
        }
    }

    public void setSeatName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.C.k(str);
        }
    }

    public void setSeatNoRes(com.tencent.mobileqq.qqlive.room.multichat.store.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar);
        } else {
            this.f271829d.setSeatNoRes(cVar);
        }
    }

    public MultiAvChatSeatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            i();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public MultiAvChatSeatView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            i();
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
