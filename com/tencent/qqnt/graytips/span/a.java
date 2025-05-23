package com.tencent.qqnt.graytips.span;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.action.f;
import com.tencent.qqnt.graytips.c;
import com.tencent.qqnt.graytips.util.d;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes24.dex */
public class a extends ClickableSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<AppRuntime> f356897d;

    /* renamed from: e, reason: collision with root package name */
    private Context f356898e;

    /* renamed from: f, reason: collision with root package name */
    private int f356899f;

    /* renamed from: h, reason: collision with root package name */
    private c f356900h;

    /* renamed from: i, reason: collision with root package name */
    private gv3.a f356901i;

    /* renamed from: m, reason: collision with root package name */
    private long f356902m;

    public a(AppRuntime appRuntime, int i3, Context context, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, Integer.valueOf(i3), context, cVar);
            return;
        }
        this.f356897d = new WeakReference<>(appRuntime);
        this.f356898e = context;
        this.f356899f = i3;
        this.f356900h = cVar;
    }

    private void d(View view, f fVar) {
        int i3;
        String str;
        HashMap hashMap = new HashMap();
        if (fVar instanceof com.tencent.qqnt.graytips.action.a) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        hashMap.put("gray_click_area", Integer.valueOf(i3));
        hashMap.put("small_gray_service_id", Long.valueOf(this.f356902m));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_small_gray", hashMap);
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (!TextUtils.isEmpty(text)) {
                try {
                    c cVar = this.f356900h;
                    str = text.subSequence(cVar.start, cVar.end).toString();
                } catch (Exception unused) {
                    QLog.e("HighlightClickableSpan", 1, "reportGrayTipsClick. fail to get span text");
                }
                d.f356912a.c(view, this.f356902m, str);
            }
        }
        str = "";
        d.f356912a.c(view, this.f356902m, str);
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f356900h.a();
    }

    public c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f356900h;
    }

    public void c(@NonNull gv3.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
        } else {
            this.f356901i = aVar;
        }
    }

    public void e(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, j3);
        } else {
            this.f356902m = j3;
        }
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f356899f = i3;
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        f fVar;
        boolean z16;
        boolean z17;
        boolean z18;
        WeakReference<AppRuntime> weakReference;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        c cVar = this.f356900h;
        AppRuntime appRuntime = null;
        Context context = null;
        if (cVar != null && cVar.actionInfo != null && (weakReference = this.f356897d) != null && this.f356901i != null) {
            AppRuntime appRuntime2 = weakReference.get();
            if (appRuntime2 == null) {
                QLog.d("HighlightClickableSpan", 1, "span click error, weak reference has been gc");
                return;
            }
            com.tencent.qqnt.graytips.b bVar = com.tencent.qqnt.graytips.b.f356812a;
            com.tencent.qqnt.graytips.handler.b a16 = com.tencent.qqnt.graytips.b.a(this.f356900h.actionInfo.getActionType());
            if (a16 != null) {
                com.tencent.aio.api.runtime.a a17 = this.f356901i.a();
                if (a17 != null) {
                    context = a17.c().getContext();
                }
                if (context == null) {
                    context = this.f356898e;
                }
                a16.c(appRuntime2, context, this.f356900h.actionInfo, this.f356901i);
                d(view, this.f356900h.actionInfo);
                return;
            }
            QLog.d("HighlightClickableSpan", 1, "click handler is null. actionType=" + this.f356900h.actionInfo.getActionType());
            return;
        }
        if (cVar != null) {
            fVar = cVar.actionInfo;
        } else {
            fVar = null;
        }
        WeakReference<AppRuntime> weakReference2 = this.f356897d;
        if (weakReference2 != null) {
            appRuntime = weakReference2.get();
        }
        Object[] objArr = new Object[11];
        boolean z19 = false;
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = " span click error, mItem=null:";
        if (this.f356900h == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        objArr[2] = Boolean.valueOf(z16);
        objArr[3] = ", actionInfo=null:";
        if (fVar == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        objArr[4] = Boolean.valueOf(z17);
        objArr[5] = "mAppReference=null:";
        if (this.f356897d == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        objArr[6] = Boolean.valueOf(z18);
        objArr[7] = " mAppReference.get()=null:";
        if (appRuntime == null) {
            z19 = true;
        }
        objArr[8] = Boolean.valueOf(z19);
        objArr[9] = "mAIOAbility: ";
        objArr[10] = this.f356901i;
        QLog.d("HighlightClickableSpan", 1, objArr);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) textPaint);
            return;
        }
        int i3 = this.f356899f;
        if (i3 == -1) {
            textPaint.setColor(textPaint.linkColor);
        } else {
            textPaint.setColor(i3);
        }
        textPaint.setUnderlineText(false);
    }
}
