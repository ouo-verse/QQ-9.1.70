package com.google.android.exoplayer2.text.cea;

import android.support.annotation.NonNull;
import android.text.Layout;
import com.google.android.exoplayer2.text.Cue;

/* compiled from: P */
/* loaded from: classes2.dex */
final class Cea708Cue extends Cue implements Comparable<Cea708Cue> {
    public static final int PRIORITY_UNSET = -1;
    public final int priority;

    public Cea708Cue(CharSequence charSequence, Layout.Alignment alignment, float f16, int i3, int i16, float f17, int i17, float f18, boolean z16, int i18, int i19) {
        super(charSequence, alignment, f16, i3, i16, f17, i17, f18, z16, i18);
        this.priority = i19;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull Cea708Cue cea708Cue) {
        int i3 = cea708Cue.priority;
        int i16 = this.priority;
        if (i3 < i16) {
            return -1;
        }
        return i3 > i16 ? 1 : 0;
    }
}
