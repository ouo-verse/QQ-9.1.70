package com.tencent.mobileqq.widget.listitem;

import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\b\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/ac;", "Landroid/view/View;", "V", "Lcom/tencent/mobileqq/widget/listitem/e;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class ac<V extends View> extends e {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final V view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac(@NotNull V view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @NotNull
    public final V getView() {
        return this.view;
    }
}
