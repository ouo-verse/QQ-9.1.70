package com.tencent.mobileqq.qqexpand.utils.impl;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqexpand.utils.IExpandForbiddenUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandForbiddenUtilsImpl implements IExpandForbiddenUtils {
    private static ArrayList<String> getRemainingForbidTimeText(Activity activity, long j3) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (j3 > 86400) {
            arrayList.add(String.valueOf(((j3 + 86400) - 1) / 86400));
            arrayList.add(activity.getString(R.string.imp));
        } else if (j3 > 3600) {
            arrayList.add(String.valueOf(((j3 + 3600) - 1) / 3600));
            arrayList.add(activity.getString(R.string.brw));
        } else if (j3 > 60) {
            arrayList.add(String.valueOf(((j3 + 60) - 1) / 60));
            arrayList.add(activity.getString(R.string.f171116ca4));
        } else if (j3 > 0) {
            arrayList.add(String.valueOf(j3));
            arrayList.add(activity.getString(R.string.hax));
        } else {
            arrayList.add(String.valueOf(0));
            arrayList.add(activity.getString(R.string.hax));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqexpand.utils.IExpandForbiddenUtils
    public SpannableStringBuilder getForbidDialogMessage(Activity activity, String str, boolean z16, long j3, boolean z17) {
        if (TextUtils.isEmpty(str)) {
            str = BaseApplication.getContext().getString(R.string.x6t);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (!z16 && z17) {
            spannableStringBuilder.append((CharSequence) "\n");
            SpannableString spannableString = new SpannableString("\u56fe");
            int dip2px = ViewUtils.dip2px(20.0f);
            Drawable drawable = activity.getResources().getDrawable(R.drawable.d3d);
            drawable.setBounds(0, 0, dip2px, dip2px);
            spannableString.setSpan(new ImageSpan(drawable, 1), 0, spannableString.length(), 17);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) " ");
            String string = activity.getString(R.string.f198604n6);
            ArrayList<String> remainingForbidTimeText = getRemainingForbidTimeText(activity, j3);
            String format = String.format(" %s ", remainingForbidTimeText.get(0));
            SpannableString spannableString2 = new SpannableString(string + format + remainingForbidTimeText.get(1));
            spannableString2.setSpan(new AbsoluteSizeSpan(14, true), 0, spannableString2.length(), 17);
            spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#878B99")), 0, spannableString2.length(), 17);
            int length = string.length();
            int length2 = string.length() + format.length();
            spannableString2.setSpan(new AbsoluteSizeSpan(24, true), length, length2, 33);
            spannableString2.setSpan(new StyleSpan(1), length, length2, 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
        }
        return spannableStringBuilder;
    }
}
