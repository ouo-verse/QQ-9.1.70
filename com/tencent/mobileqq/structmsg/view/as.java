package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.widget.CountdownTextView;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class as extends ap {
    static IPatchRedirector $redirector_;

    /* renamed from: j1, reason: collision with root package name */
    protected long f290611j1;

    /* renamed from: k1, reason: collision with root package name */
    protected int f290612k1;

    /* renamed from: l1, reason: collision with root package name */
    protected int f290613l1;

    /* renamed from: m1, reason: collision with root package name */
    protected long f290614m1;

    /* renamed from: n1, reason: collision with root package name */
    protected long f290615n1;

    /* renamed from: o1, reason: collision with root package name */
    protected boolean f290616o1;

    /* renamed from: p1, reason: collision with root package name */
    private String f290617p1;

    /* renamed from: q1, reason: collision with root package name */
    private String f290618q1;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements CountdownTextView.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountdownTextView f290619a;

        a(CountdownTextView countdownTextView) {
            this.f290619a = countdownTextView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) as.this, (Object) countdownTextView);
            }
        }

        @Override // com.tencent.mobileqq.structmsg.widget.CountdownTextView.b
        public void a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
                return;
            }
            long j16 = j3 / 1000;
            this.f290619a.setText(as.this.P(j16));
            as.this.f290614m1 = j16;
        }

        @Override // com.tencent.mobileqq.structmsg.widget.CountdownTextView.b
        public void onFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            as asVar = as.this;
            asVar.f290614m1 = 0L;
            asVar.f290616o1 = true;
            this.f290619a.setText(asVar.P(0L));
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements CountdownTextView.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountdownTextView f290621a;

        b(CountdownTextView countdownTextView) {
            this.f290621a = countdownTextView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) as.this, (Object) countdownTextView);
            }
        }

        @Override // com.tencent.mobileqq.structmsg.widget.CountdownTextView.b
        public void a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
                return;
            }
            long j16 = j3 / 1000;
            this.f290621a.setText(as.this.P(j16));
            as.this.f290614m1 = j16;
        }

        @Override // com.tencent.mobileqq.structmsg.widget.CountdownTextView.b
        public void onFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            as asVar = as.this;
            asVar.f290614m1 = 0L;
            asVar.f290616o1 = true;
            this.f290621a.setText(asVar.P(0L));
        }
    }

    public as() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f290322e = SemanticAttributes.FaasTriggerValues.TIMER;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpannableStringBuilder P(long j3) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-91585);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f290617p1);
        spannableStringBuilder.append('\n');
        if (j3 > 0) {
            int length = spannableStringBuilder.length();
            String str = String.valueOf(j3) + HardCodeUtil.qqStr(R.string.tw_);
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.append((CharSequence) this.X0);
            spannableStringBuilder.setSpan(foregroundColorSpan, length, str.length() + length, 33);
        } else {
            spannableStringBuilder.append((CharSequence) this.f290618q1);
        }
        return spannableStringBuilder;
    }

    private long Q() {
        if (this.f290616o1) {
            return 0L;
        }
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        long j3 = this.f290611j1;
        int i3 = this.f290612k1;
        long j16 = (j3 + i3) - K0;
        if (j16 < 0) {
            this.f290616o1 = true;
            return 0L;
        }
        if (j16 > 0) {
            if (j16 >= i3) {
                return i3;
            }
        } else {
            this.f290616o1 = true;
        }
        return j16;
    }

    @Override // com.tencent.mobileqq.structmsg.view.ap, com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public View c(Context context, View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, context, view, bundle);
        }
        if (view != null && (view instanceof CountdownTextView)) {
            CountdownTextView countdownTextView = (CountdownTextView) view;
            countdownTextView.a(Q(), new a(countdownTextView));
            countdownTextView.setTag(this);
            return countdownTextView;
        }
        CountdownTextView countdownTextView2 = new CountdownTextView(context);
        countdownTextView2.setId(R.id.k6w);
        countdownTextView2.setTag(this);
        countdownTextView2.setMaxLines(3);
        countdownTextView2.setTextColor(-10987432);
        countdownTextView2.setTextSize(2, 12.0f);
        long Q = Q();
        if (this.X0 != null) {
            countdownTextView2.setText(P(Q));
        }
        countdownTextView2.a(Q, new b(countdownTextView2));
        return countdownTextView2;
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public boolean d(com.tencent.mobileqq.structmsg.j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) jVar)).booleanValue();
        }
        if (jVar == null) {
            return true;
        }
        this.f290611j1 = com.tencent.mobileqq.structmsg.k.e(jVar.a("st"));
        this.f290612k1 = com.tencent.mobileqq.structmsg.k.d(jVar.a("dr"));
        this.f290613l1 = com.tencent.mobileqq.structmsg.k.d(jVar.a("index"));
        this.f290617p1 = com.tencent.mobileqq.service.message.s.c(jVar.a("summary"), false);
        this.f290618q1 = com.tencent.mobileqq.service.message.s.c(jVar.a("st"), false);
        this.X0 = com.tencent.mobileqq.service.message.s.c(com.tencent.mobileqq.structmsg.i.h(jVar), false);
        return true;
    }

    @Override // com.tencent.mobileqq.structmsg.view.ap, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "Timer";
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void i(ObjectInput objectInput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) objectInput);
            return;
        }
        super.i(objectInput);
        this.f290617p1 = com.tencent.mobileqq.service.message.s.c(objectInput.readUTF(), false);
        this.f290618q1 = com.tencent.mobileqq.service.message.s.c(objectInput.readUTF(), false);
        this.f290611j1 = objectInput.readLong();
        this.f290612k1 = objectInput.readInt();
        this.f290613l1 = objectInput.readInt();
        this.f290614m1 = objectInput.readLong();
        this.f290615n1 = objectInput.readLong();
        this.f290616o1 = objectInput.readBoolean();
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void k(XmlSerializer xmlSerializer) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) xmlSerializer);
            return;
        }
        xmlSerializer.startTag(null, SemanticAttributes.FaasTriggerValues.TIMER);
        xmlSerializer.attribute(null, "st", String.valueOf(this.f290611j1));
        xmlSerializer.attribute(null, "dr", String.valueOf(this.f290612k1));
        xmlSerializer.attribute(null, "index", String.valueOf(this.f290613l1));
        if (!TextUtils.isEmpty(this.f290617p1)) {
            xmlSerializer.attribute(null, "summary", this.f290617p1);
        }
        if (!TextUtils.isEmpty(this.f290618q1)) {
            xmlSerializer.attribute(null, "ending", this.f290618q1);
        }
        xmlSerializer.text(this.X0);
        xmlSerializer.endTag(null, SemanticAttributes.FaasTriggerValues.TIMER);
    }

    @Override // com.tencent.mobileqq.structmsg.b, com.tencent.mobileqq.structmsg.AbsStructMsgElement
    public void l(ObjectOutput objectOutput) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) objectOutput);
            return;
        }
        super.l(objectOutput);
        String str = this.f290617p1;
        String str2 = "";
        if (str == null) {
            str = "";
        }
        objectOutput.writeUTF(str);
        String str3 = this.f290618q1;
        if (str3 != null) {
            str2 = str3;
        }
        objectOutput.writeUTF(str2);
        objectOutput.writeLong(this.f290611j1);
        objectOutput.writeInt(this.f290612k1);
        objectOutput.writeInt(this.f290613l1);
        objectOutput.writeLong(this.f290614m1);
        objectOutput.writeLong(this.f290615n1);
        objectOutput.writeBoolean(this.f290616o1);
    }
}
