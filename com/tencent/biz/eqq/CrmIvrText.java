package com.tencent.biz.eqq;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.n;
import com.tencent.mobileqq.text.style.LinkSpan;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CrmIvrText extends QQText {

    /* renamed from: d, reason: collision with root package name */
    String f78482d;

    /* renamed from: e, reason: collision with root package name */
    String f78483e;

    /* renamed from: f, reason: collision with root package name */
    QQAppInterface f78484f;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends LinkSpan {
        public a(String str) {
            super(str);
        }

        @Override // com.tencent.mobileqq.text.style.LinkSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            if (CrmUtils.f78488a.matcher(this.f292710d).find()) {
                CrmIvrText crmIvrText = CrmIvrText.this;
                CrmIvrText.a(view, crmIvrText.f78482d, crmIvrText.f78483e, crmIvrText.f78484f);
            } else {
                super.onClick(view);
            }
        }
    }

    public CrmIvrText(CharSequence charSequence, int i3, int i16, MessageRecord messageRecord, String str, String str2, QQAppInterface qQAppInterface) {
        super(charSequence, i3, i16, messageRecord);
        this.f78482d = str;
        this.f78483e = str2;
        this.f78484f = qQAppInterface;
    }

    static void a(final View view, final String str, String str2, final QQAppInterface qQAppInterface) {
        view.post(new Runnable() { // from class: com.tencent.biz.eqq.CrmIvrText.1
            @Override // java.lang.Runnable
            public void run() {
                QQAppInterface qQAppInterface2 = QQAppInterface.this;
                Context context = view.getContext();
                String str3 = str;
                CrmUtils.E(qQAppInterface2, context, str3, CrmUtils.j(QQAppInterface.this, str3));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.text.QQText
    public void parseLinkSpan() {
        super.parseLinkSpan();
        Matcher matcher = Pattern.compile(n.f292699h + "|QQ\u8bed\u97f3").matcher(this.mText);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            addSpan(new a(this.mText.substring(start, end)), start, end, 33);
        }
    }
}
