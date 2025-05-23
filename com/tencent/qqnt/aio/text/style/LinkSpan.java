package com.tencent.qqnt.aio.text.style;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.ClipboardManager;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.webkit.URLUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.utils.cg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.ActionSheet;
import java.util.regex.Matcher;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes23.dex */
public class LinkSpan extends ClickableSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public String f352142d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f352143e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f352144f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f352145d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f352146e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f352147f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ActionSheet f352148h;

        a(Context context, String str, int i3, ActionSheet actionSheet) {
            this.f352145d = context;
            this.f352146e = str;
            this.f352147f = i3;
            this.f352148h = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LinkSpan.this, context, str, Integer.valueOf(i3), actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 != 0) {
                if (i3 == 1) {
                    if (this.f352147f == 2) {
                        this.f352145d.startActivity(Intent.createChooser(new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + this.f352146e)), this.f352145d.getString(R.string.f171101c73)));
                    } else {
                        this.f352145d.startActivity(new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + this.f352146e)));
                    }
                }
            } else {
                ((ClipboardManager) this.f352145d.getSystemService("clipboard")).setText(this.f352146e);
            }
            this.f352148h.dismiss();
        }
    }

    public LinkSpan(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f352143e = true;
        this.f352144f = true;
        this.f352142d = str;
    }

    protected void a(View view, String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) str);
            return;
        }
        int lastIndexOf = str.lastIndexOf("#");
        if (lastIndexOf > 0) {
            str2 = str.substring(lastIndexOf);
        } else {
            str2 = null;
        }
        String guessUrl = URLUtil.guessUrl(str);
        if (str2 != null) {
            guessUrl = guessUrl + str2;
        }
        Intent intent = new Intent();
        intent.putExtra("url", guessUrl);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(view.getContext(), RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putAll(intent.getExtras());
        QRoute.startUri(activityURIRequest, (o) null);
    }

    public void b(Context context, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, context, str, Integer.valueOf(i3));
            return;
        }
        ActionSheet create = ActionSheet.create(context);
        create.addButton(R.string.aet, 1);
        if (i3 == 0 || i3 == 1) {
            create.addButton(R.string.ano, 1);
        }
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new a(context, str, i3, create));
        create.show();
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
            return;
        }
        if (!this.f352143e) {
            if (QLog.isColorLevel()) {
                QLog.i("LinkSpan", 2, "onClick no clickable");
                return;
            }
            return;
        }
        String str = this.f352142d;
        boolean find = cg.f307525d.matcher(str).find();
        if (!find) {
            find = cg.f307524c.matcher(str).find();
        }
        if (find) {
            if (com.tencent.qqnt.aio.text.a.f352139g.matcher(str).find()) {
                b(view.getContext(), str, 2);
                return;
            } else {
                a(view, str);
                return;
            }
        }
        if (com.tencent.qqnt.aio.text.a.f352133a.matcher(str).find()) {
            b(view.getContext(), str, 3);
            return;
        }
        Matcher matcher = com.tencent.qqnt.aio.text.a.f352135c.matcher(str);
        if (matcher.find() && matcher.start() == 0 && matcher.end() == str.length()) {
            b(view.getContext(), str, 0);
        } else if (com.tencent.qqnt.aio.text.a.f352138f.matcher(str).find()) {
            b(view.getContext(), str, 0);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) textPaint);
            return;
        }
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(this.f352144f);
        textPaint.clearShadowLayer();
    }

    public LinkSpan(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        this.f352143e = true;
        this.f352144f = true;
        this.f352142d = str;
    }
}
