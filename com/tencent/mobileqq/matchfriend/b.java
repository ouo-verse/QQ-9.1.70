package com.tencent.mobileqq.matchfriend;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends QQText {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private String f244046d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a extends ClickableSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final String f244047d;

        /* renamed from: e, reason: collision with root package name */
        private final String f244048e;

        public a(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
            } else {
                this.f244047d = str;
                this.f244048e = str2;
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
                return;
            }
            QLog.d("MatchFriendQQText", 1, "MatchFriendLinkSpan onClick:" + this.f244047d);
            Context context = view.getContext();
            if (context != null && !TextUtils.isEmpty(this.f244047d)) {
                if (!this.f244047d.startsWith("http") && !this.f244047d.startsWith("https")) {
                    ax c16 = bi.c((BaseQQAppInterface) BaseApplicationImpl.getApplication().getRuntime(), context, this.f244047d);
                    if (c16 != null) {
                        c16.b();
                    }
                } else {
                    Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", this.f244047d);
                    context.startActivity(intent);
                }
                ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).matchFriendOfficialMessageReport(context, "dt_clck", this.f244048e);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) textPaint);
            } else {
                textPaint.setColor(textPaint.linkColor);
                textPaint.clearShadowLayer();
            }
        }
    }

    public b(CharSequence charSequence, int i3, int i16, Object obj) {
        super(charSequence, i3, i16, obj);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), obj);
            return;
        }
        this.f244046d = "0";
        if (obj instanceof MessageRecord) {
            this.f244046d = ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getMatchFriendOfficialMessageSourceType((MessageRecord) obj);
        }
        a();
    }

    private void a() {
        try {
            for (Pair<String, String> pair : ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).parseMatchFriendQQText(this.mText)) {
                String parseMatchFriendUrl = ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).parseMatchFriendUrl((String) pair.first);
                int indexOf = this.mText.indexOf((String) pair.first);
                if (indexOf >= 0) {
                    this.mText = this.mText.replace((CharSequence) pair.first, (CharSequence) pair.second);
                    addSpan(new a(parseMatchFriendUrl, this.f244046d), indexOf, ((String) pair.second).length() + indexOf, 33);
                }
            }
        } catch (Exception e16) {
            QLog.e("MatchFriendQQText", 1, "MatchFriendQQText init error", e16);
        }
    }
}
