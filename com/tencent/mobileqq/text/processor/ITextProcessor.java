package com.tencent.mobileqq.text.processor;

import android.text.Spanned;

/* loaded from: classes18.dex */
public interface ITextProcessor {
    void doSubSequence(int i3, int i16, StringBuilder sb5, Spanned spanned);

    void doToPlain(int i3, StringBuffer stringBuffer, Spanned spanned);

    void doToString(int i3, StringBuilder sb5, Spanned spanned);
}
