package com.qwallet.authorize.dialog;

import android.widget.TextView;
import com.qwallet.authorize.AuthorizePhoneData;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "phoneList", "", "Lcom/qwallet/authorize/AuthorizePhoneData;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthorizeDialogFragment$initData$2 extends Lambda implements Function1<List<? extends AuthorizePhoneData>, Unit> {
    final /* synthetic */ AuthorizeDialogFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthorizeDialogFragment$initData$2(AuthorizeDialogFragment authorizeDialogFragment) {
        super(1);
        this.this$0 = authorizeDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AuthorizeDialogFragment this$0) {
        k kVar;
        k kVar2;
        k kVar3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        kVar = this$0.adapter;
        k kVar4 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            kVar = null;
        }
        kVar.p0(0);
        kVar2 = this$0.adapter;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            kVar2 = null;
        }
        kVar2.notifyDataSetChanged();
        kVar3 = this$0.adapter;
        if (kVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            kVar4 = kVar3;
        }
        kVar4.j0();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends AuthorizePhoneData> list) {
        invoke2((List<AuthorizePhoneData>) list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<AuthorizePhoneData> list) {
        TextView textView;
        boolean z16;
        k kVar;
        TextView textView2 = null;
        if (list != null) {
            kVar = this.this$0.adapter;
            if (kVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                kVar = null;
            }
            final AuthorizeDialogFragment authorizeDialogFragment = this.this$0;
            kVar.submitList(list, new Runnable() { // from class: com.qwallet.authorize.dialog.i
                @Override // java.lang.Runnable
                public final void run() {
                    AuthorizeDialogFragment$initData$2.b(AuthorizeDialogFragment.this);
                }
            });
        }
        AuthorizeDialogFragment authorizeDialogFragment2 = this.this$0;
        boolean z17 = false;
        if (list != null) {
            List<AuthorizePhoneData> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AuthorizePhoneData authorizePhoneData = (AuthorizePhoneData) it.next();
                    if (authorizePhoneData.getSource() == 0 || authorizePhoneData.getSource() == 1) {
                        z17 = true;
                        break;
                    }
                }
            }
        }
        authorizeDialogFragment2.hasPhoneCanDelete = z17;
        textView = this.this$0.useOtherPhoneBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("useOtherPhoneBtn");
        } else {
            textView2 = textView;
        }
        z16 = this.this$0.hasPhoneCanDelete;
        textView2.setText(z16 ? "\u7ba1\u7406\u624b\u673a\u53f7\u7801" : "\u6dfb\u52a0\u624b\u673a\u53f7\u7801");
    }
}
