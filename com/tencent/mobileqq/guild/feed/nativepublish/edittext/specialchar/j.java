package com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar;

import android.text.Editable;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001c\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u00a8\u0006\u0006"}, d2 = {"Landroid/text/Editable;", "", "start", "end", "", "b", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(Editable editable, int i3, int i16) {
        if (i16 > editable.length()) {
            i16 = editable.length();
        }
        if (i3 > i16) {
            i3 = i16;
        }
        return editable.subSequence(i3, i16).toString();
    }
}
