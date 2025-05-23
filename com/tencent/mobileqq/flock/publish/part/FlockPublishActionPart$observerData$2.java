package com.tencent.mobileqq.flock.publish.part;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Pair;", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
final class FlockPublishActionPart$observerData$2 extends Lambda implements Function1<Pair<? extends Boolean, ? extends String>, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ FlockPublishActionPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlockPublishActionPart$observerData$2(FlockPublishActionPart flockPublishActionPart) {
        super(1);
        this.this$0 = flockPublishActionPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) flockPublishActionPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FlockPublishActionPart this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.getActivity().finish();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Boolean, ? extends String> pair) {
        invoke2((Pair<Boolean, String>) pair);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<Boolean, String> pair) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pair);
            return;
        }
        if (pair.getFirst().booleanValue()) {
            return;
        }
        Context context = this.this$0.getContext();
        String second = pair.getSecond();
        final FlockPublishActionPart flockPublishActionPart = this.this$0;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, second, (String) null, "\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.flock.publish.part.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                FlockPublishActionPart$observerData$2.b(FlockPublishActionPart.this, dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(conte\u2026}, null\n                )");
        createCustomDialog.setCancelable(false);
        createCustomDialog.setCanceledOnTouchOutside(false);
        createCustomDialog.show();
    }
}
