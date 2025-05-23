package com.tencent.mobileqq.wink.picker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/QCircleInitBean;", "Lcom/tencent/mobileqq/wink/picker/InitBean;", "attachToWinkHome", "", "showVideoTemplateButton", "nextBtnText", "", "(ZZLjava/lang/String;)V", "getShowVideoTemplateButton", "()Z", "setShowVideoTemplateButton", "(Z)V", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public class QCircleInitBean extends InitBean {
    private boolean showVideoTemplateButton;

    public QCircleInitBean() {
        this(false, false, null, 7, null);
    }

    public final boolean getShowVideoTemplateButton() {
        return this.showVideoTemplateButton;
    }

    public final void setShowVideoTemplateButton(boolean z16) {
        this.showVideoTemplateButton = z16;
    }

    public /* synthetic */ QCircleInitBean(boolean z16, boolean z17, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? true : z17, (i3 & 4) != 0 ? "\u4e0b\u4e00\u6b65" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QCircleInitBean(boolean z16, boolean z17, @NotNull String nextBtnText) {
        super(z16, nextBtnText);
        Intrinsics.checkNotNullParameter(nextBtnText, "nextBtnText");
        this.showVideoTemplateButton = z17;
    }
}
