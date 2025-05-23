package com.tencent.guild.aio.input.at.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b extends AtTroopMemberSpan {
    private static String M = "GuildAtTroopMemberSpan";
    private static String N = "\u202e";

    public b(Context context, String str, String str2, int i3, Paint paint, String str3, int i16, int i17, AtRoleInfo atRoleInfo) {
        super(context, str, str2, i3, paint, str3, i16, i17, atRoleInfo);
    }

    public static SpannableString o(Context context, String str, String str2, EditText editText, boolean z16) {
        return r(context, str, str2, str2, editText, z16, 2);
    }

    public static SpannableString p(Context context, String str, String str2, String str3, EditText editText, int i3, boolean z16, int i16) {
        return q(context, str, str2, str3, editText, i3, z16, true, i16, null);
    }

    public static SpannableString q(Context context, String str, String str2, String str3, EditText editText, int i3, boolean z16, boolean z17, int i16, AtRoleInfo atRoleInfo) {
        int i17;
        b bVar;
        String str4;
        if (context == null || TextUtils.isEmpty(str) || editText == null) {
            return null;
        }
        if (editText.getPaint() != null) {
            editText.getPaint().setColor(context.getResources().getColor(s(z16)));
        }
        int width = (editText.getWidth() - editText.getPaddingLeft()) - editText.getPaddingRight();
        if (z16) {
            i17 = 0;
        } else {
            i17 = i3;
        }
        try {
            bVar = new b(context, str, t(str2), width, editText.getPaint(), t(str3), i17, i16, atRoleInfo);
        } catch (OutOfMemoryError unused) {
            bVar = null;
        }
        if (bVar == null) {
            return null;
        }
        String replaceAll = AtTroopMemberSpan.m(bVar.f111086e).replaceAll("[\r\n]", " ");
        if (z17) {
            str4 = replaceAll + " ";
        } else {
            str4 = replaceAll;
        }
        SpannableString spannableString = new SpannableString(str4);
        spannableString.setSpan(bVar, 0, replaceAll.length(), 33);
        return spannableString;
    }

    public static SpannableString r(Context context, String str, String str2, String str3, EditText editText, boolean z16, int i3) {
        return q(context, str, str2, str3, editText, 0, z16, true, i3, null);
    }

    private static int s(boolean z16) {
        if (z16) {
            return R.color.bql;
        }
        return R.color.qui_common_text_link;
    }

    private static String t(String str) {
        if (str.contains(N)) {
            String replaceAll = str.replaceAll(N, "");
            QLog.i(M, 1, "[removeSpecialChar] contains LRM char. after removal: " + replaceAll + ", origin string: " + str);
            return replaceAll;
        }
        return str;
    }

    @Override // com.tencent.guild.aio.input.at.utils.AtTroopMemberSpan
    protected List<AtTroopMemberSpan.b> b(Paint paint) {
        List<AtTroopMemberSpan.b> c16 = AtTroopMemberSpan.c(this.f111089i, this.f111086e, paint, this.L);
        this.f111088h = AtTroopMemberSpan.l(c16, paint, new Rect());
        return c16;
    }
}
