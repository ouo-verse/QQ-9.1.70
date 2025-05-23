package com.tencent.aegiskmm.bean;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/aegiskmm/bean/PageLoadStrategy;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "CacheFetchLatest", "NetworkFetchLatest", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public enum PageLoadStrategy {
    CacheFetchLatest("0"),
    NetworkFetchLatest("1");

    private final String value;

    PageLoadStrategy(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
