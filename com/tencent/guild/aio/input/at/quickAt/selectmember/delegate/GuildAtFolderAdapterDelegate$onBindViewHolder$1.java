package com.tencent.guild.aio.input.at.quickAt.selectmember.delegate;

import android.widget.TextView;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class GuildAtFolderAdapterDelegate$onBindViewHolder$1 extends FunctionReferenceImpl implements Function1<CharSequence, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildAtFolderAdapterDelegate$onBindViewHolder$1(Object obj) {
        super(1, obj, TextView.class, IECSearchBar.METHOD_SET_TEXT, "setText(Ljava/lang/CharSequence;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
        invoke2(charSequence);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(CharSequence charSequence) {
        ((TextView) this.receiver).setText(charSequence);
    }
}
