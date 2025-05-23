package com.tencent.mobileqq.wink.picker;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/InitBean;", "Ljava/io/Serializable;", "attachToWinkHome", "", "nextBtnText", "", "(ZLjava/lang/String;)V", "getAttachToWinkHome", "()Z", "getNextBtnText", "()Ljava/lang/String;", "setNextBtnText", "(Ljava/lang/String;)V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public class InitBean implements Serializable {
    private final boolean attachToWinkHome;

    @NotNull
    private String nextBtnText;

    public InitBean() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    public final boolean getAttachToWinkHome() {
        return this.attachToWinkHome;
    }

    @NotNull
    public final String getNextBtnText() {
        return this.nextBtnText;
    }

    public final void setNextBtnText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nextBtnText = str;
    }

    public InitBean(boolean z16, @NotNull String nextBtnText) {
        Intrinsics.checkNotNullParameter(nextBtnText, "nextBtnText");
        this.attachToWinkHome = z16;
        this.nextBtnText = nextBtnText;
    }

    public /* synthetic */ InitBean(boolean z16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? "\u4e0b\u4e00\u6b65" : str);
    }
}
