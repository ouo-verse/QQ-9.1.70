package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonEntry;", "", "()V", "key", "", "getKey", "()Ljava/lang/String;", VasCommonJsbProxy.JSON_KEY_SET_KEY, "(Ljava/lang/String;)V", "numberKey", "", "getNumberKey", "()I", "setNumberKey", "(I)V", "numberKey2", "", "getNumberKey2", "()J", "setNumberKey2", "(J)V", "value", HippyTextInputController.COMMAND_getValue, HippyTextInputController.COMMAND_setValue, "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonEntry {
    public static final int $stable = 8;
    private String key;
    private int numberKey;
    private long numberKey2;
    private String value;

    public final String getKey() {
        return this.key;
    }

    public final int getNumberKey() {
        return this.numberKey;
    }

    public final long getNumberKey2() {
        return this.numberKey2;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final void setNumberKey(int i3) {
        this.numberKey = i3;
    }

    public final void setNumberKey2(long j3) {
        this.numberKey2 = j3;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
