package com.tencent.av.screenshare;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* compiled from: P */
    /* renamed from: com.tencent.av.screenshare.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0741a extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        private final Context f74291d;

        /* renamed from: e, reason: collision with root package name */
        private final String f74292e;

        public C0741a(Context context, String str) {
            this.f74291d = context;
            this.f74292e = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            Intent intent = new Intent(this.f74291d, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", this.f74292e);
            this.f74291d.startActivity(intent);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f74291d.getResources().getColor(R.color.f157768yz));
            textPaint.setUnderlineText(false);
        }
    }

    public static QQCustomDialog a(Context context, String str, CharSequence charSequence, String str2, String str3, boolean z16, int i3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        ScreenShareQQCustomDialog screenShareQQCustomDialog = new ScreenShareQQCustomDialog(context, R.style.qZoneInputDialog, str2, str3, z16, i3);
        screenShareQQCustomDialog.setContentView(R.layout.f167856jn);
        screenShareQQCustomDialog.setCanceledOnTouchOutside(false);
        screenShareQQCustomDialog.setTitle(str);
        screenShareQQCustomDialog.setMessageWithoutAutoLink(charSequence);
        screenShareQQCustomDialog.q0(Typeface.DEFAULT_BOLD, context.getResources().getColorStateList(R.color.f156990gz));
        screenShareQQCustomDialog.setNegativeButton(str2, onClickListener);
        screenShareQQCustomDialog.setPositiveButton(str3, onClickListener2);
        return screenShareQQCustomDialog;
    }

    public static SpannableStringBuilder b(Context context, String str, String str2, String str3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int indexOf = str.indexOf(str2);
        if (indexOf != -1) {
            spannableStringBuilder.setSpan(new C0741a(context, str3), indexOf, str2.length() + indexOf, 33);
        }
        return spannableStringBuilder;
    }
}
