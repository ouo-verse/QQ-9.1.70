package com.tencent.mobileqq.search.voicesearch;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/search/voicesearch/VoiceSearchErrorCode;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "FSTRecorderNoFinish", "FSTRecorderNotAuth", "FSTRecorderCancel", "FSTRecorderTimeOut", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public enum VoiceSearchErrorCode {
    FSTRecorderNoFinish(-10000),
    FSTRecorderNotAuth(-10001),
    FSTRecorderCancel(-10003),
    FSTRecorderTimeOut(-10004);

    private final int value;

    VoiceSearchErrorCode(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
