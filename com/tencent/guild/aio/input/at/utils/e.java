package com.tencent.guild.aio.input.at.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.widget.EditText;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e extends f {
    private String Q;
    private String R;

    protected e(Context context, String str, String str2, int i3, Paint paint, int i16, int i17, Drawable drawable) {
        super(context, str, str2, i3, paint, i16, i17, drawable);
        this.Q = str;
        this.R = str2;
    }

    public static SpannableString t(Context context, String str, String str2, EditText editText, Drawable drawable) {
        e eVar;
        if (context == null || editText == null) {
            return null;
        }
        QLog.i("HashtagGroupSpan", 1, "getWidth=" + editText.getMeasuredWidth() + " getPaddingLeft=" + editText.getPaddingLeft() + " getPaddingRight" + editText.getPaddingRight() + " screenW=" + ScreenUtil.SCREEN_WIDTH);
        if (editText.getPaint() != null) {
            editText.getPaint().setColor(context.getResources().getColor(u(false)));
        }
        try {
            eVar = new e(context, str, str2, (editText.getMeasuredWidth() - editText.getPaddingLeft()) - editText.getPaddingRight(), editText.getPaint(), 0, 1024, drawable);
        } catch (OutOfMemoryError unused) {
            eVar = null;
        }
        if (eVar == null) {
            return null;
        }
        String replaceAll = AtTroopMemberSpan.m(eVar.p()).replaceAll("[\r\n]", " ");
        SpannableString spannableString = new SpannableString(replaceAll + " ");
        spannableString.setSpan(eVar, 0, replaceAll.length(), 33);
        return spannableString;
    }

    private static int u(boolean z16) {
        if (z16) {
            return R.color.bql;
        }
        return R.color.qui_common_text_link;
    }

    public String v() {
        return this.Q;
    }

    public String w() {
        return this.R;
    }
}
