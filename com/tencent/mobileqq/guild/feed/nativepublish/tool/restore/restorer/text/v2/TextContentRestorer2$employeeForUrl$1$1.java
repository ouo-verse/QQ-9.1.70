package com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.restorer.text.v2;

import android.widget.EditText;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class TextContentRestorer2$employeeForUrl$1$1 extends FunctionReferenceImpl implements Function1<RestoreInfo, EditText> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TextContentRestorer2$employeeForUrl$1$1(Object obj) {
        super(1, obj, TextContentRestorer2.class, "fetchEditTextInSomeWay", "fetchEditTextInSomeWay(Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/restore/RestoreInfo;)Landroid/widget/EditText;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    @Nullable
    public final EditText invoke(@NotNull RestoreInfo p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        return ((TextContentRestorer2) this.receiver).c(p06);
    }
}
