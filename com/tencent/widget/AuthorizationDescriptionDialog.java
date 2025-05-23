package com.tencent.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes27.dex */
class AuthorizationDescriptionDialog extends ActionSheet {
    static IPatchRedirector $redirector_ = null;
    private static final String COMPLAINT_URL = "https://support.qq.com/product/";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class TextClick extends ClickableSpan {
        static IPatchRedirector $redirector_;
        private WeakReference<Context> mContext;

        /* synthetic */ TextClick(Context context, a aVar) {
            this(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) aVar);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            Context context = this.mContext.get();
            if (context != null) {
                String str = AuthorizationDescriptionDialog.COMPLAINT_URL + new GdtThirdProcessorProxy().getProductId(context);
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_BROWSER);
                activityURIRequest.extra().putString("url", str);
                QRoute.startUri(activityURIRequest, (o) null);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
            } else {
                textPaint.setUnderlineText(false);
            }
        }

        TextClick(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.mContext = new WeakReference<>(context);
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AuthorizationDescriptionDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AuthorizationDescriptionDialog.this.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AuthorizationDescriptionDialog(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            initView();
        }
    }

    private void initView() {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.c7x, (ViewGroup) null);
        linearLayout.findViewById(R.id.du6).setOnClickListener(new a());
        String string = getContext().getString(R.string.iig);
        TextView textView = (TextView) linearLayout.findViewById(R.id.k6s);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#1B90EE")), string.length() - 3, string.length() - 1, 33);
        spannableString.setSpan(new TextClick(getContext(), null), string.length() - 3, string.length() - 1, 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        addView(linearLayout);
    }
}
