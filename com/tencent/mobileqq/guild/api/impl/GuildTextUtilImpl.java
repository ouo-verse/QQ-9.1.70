package com.tencent.mobileqq.guild.api.impl;

import android.text.Editable;
import com.tencent.mobileqq.guild.api.IGuildTextUtil;
import com.tencent.mobileqq.guild.util.cb;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildTextUtilImpl implements IGuildTextUtil {
    @Override // com.tencent.mobileqq.guild.api.IGuildTextUtil
    public int countText(CharSequence charSequence) {
        return cb.b(charSequence).a();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTextUtil
    public float countTextF(CharSequence charSequence) {
        return cb.b(charSequence).b();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildTextUtil
    public CharSequence filterTailSpace(Editable editable) {
        Matcher matcher = Pattern.compile("[\\n ]+$").matcher(editable);
        if (matcher.find()) {
            return editable.subSequence(0, matcher.start());
        }
        return editable;
    }
}
