package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor;

import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class EditTextInputActor$textWatcher$2 extends FunctionReferenceImpl implements Function0<TextWatcher> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EditTextInputActor$textWatcher$2(Object obj) {
        super(0, obj, EditTextInputActor.class, "createTextWatcher", "createTextWatcher()Landroid/text/TextWatcher;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final TextWatcher invoke() {
        TextWatcher k3;
        k3 = ((EditTextInputActor) this.receiver).k();
        return k3;
    }
}
