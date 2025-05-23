package com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard;

import android.content.Context;
import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.model.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqnt.kernel.nativeinterface.InlineKetBoardModal;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ6\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J@\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0002H\u0002J&\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002JN\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u000e\u0010\u0018\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/inlinekeyboard/AIOInlineKeyboardPermissionChecker;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/InlineBtnPayload;", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "Lkotlin/Function0;", "", "onPermissionGranted", "onPermissionDenied", h.F, "context", "", "hasPermission", "e", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKetBoardModal;", "modal", "onConfirm", "j", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/c;", "btnPermissionRequired", "payload", "g", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOInlineKeyboardPermissionChecker implements com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.a<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> {
    static IPatchRedirector $redirector_;

    public AIOInlineKeyboardPermissionChecker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b context, com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, boolean hasPermission, Function0<Unit> onPermissionGranted, Function0<Unit> onPermissionDenied) {
        InlineKeyboardButton inlineKeyboardButton;
        InlineKetBoardModal inlineKetBoardModal;
        String str;
        boolean z16;
        if (hasPermission) {
            Object e16 = btnModel.e();
            if (e16 instanceof InlineKeyboardButton) {
                inlineKeyboardButton = (InlineKeyboardButton) e16;
            } else {
                inlineKeyboardButton = null;
            }
            boolean z17 = false;
            if (inlineKeyboardButton != null && (inlineKetBoardModal = inlineKeyboardButton.modal) != null && (str = inlineKetBoardModal.content) != null) {
                if (str.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = true;
                }
            }
            if (z17) {
                InlineKetBoardModal inlineKetBoardModal2 = inlineKeyboardButton.modal;
                Intrinsics.checkNotNullExpressionValue(inlineKetBoardModal2, "btn.modal");
                j(context, inlineKetBoardModal2, onPermissionGranted);
                return;
            }
            onPermissionGranted.invoke();
            return;
        }
        i(context);
        if (onPermissionDenied != null) {
            onPermissionDenied.invoke();
        }
    }

    static /* synthetic */ void f(AIOInlineKeyboardPermissionChecker aIOInlineKeyboardPermissionChecker, com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b bVar, com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar, boolean z16, Function0 function0, Function0 function02, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            function02 = null;
        }
        aIOInlineKeyboardPermissionChecker.e(bVar, aVar, z16, function0, function02);
    }

    private final void h(com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b ctx, com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, Function0<Unit> onPermissionGranted, Function0<Unit> onPermissionDenied) {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        Long longOrNull;
        com.tencent.aio.api.runtime.a a16 = ctx.a();
        if (a16 != null && (g16 = a16.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            if (c16.e() == 2) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(c16.j());
                if (longOrNull != null) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new AIOInlineKeyboardPermissionChecker$evaluateAdminPermission$1(this, ctx, btnModel, longOrNull.longValue(), onPermissionGranted, onPermissionDenied, null), 3, null);
                    return;
                }
                return;
            }
            f(this, ctx, btnModel, true, onPermissionGranted, null, 16, null);
        }
    }

    private final void i(com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b context) {
        Fragment c16;
        Context context2;
        com.tencent.aio.api.runtime.a a16 = context.a();
        if (a16 != null && (c16 = a16.c()) != null && (context2 = c16.getContext()) != null) {
            QQToast.makeText(context2, 0, R.string.ysc, 0).show();
        }
    }

    private final void j(com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b ctx, InlineKetBoardModal modal, final Function0<Unit> onConfirm) {
        Fragment c16;
        Context context;
        boolean z16;
        String str;
        String str2;
        com.tencent.aio.api.runtime.a a16 = ctx.a();
        if (a16 != null && (c16 = a16.c()) != null && (context = c16.getContext()) != null) {
            String str3 = modal.confirmText;
            boolean z17 = false;
            if (str3 != null && str3.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                str = context.getString(R.string.a8j);
            } else {
                str = modal.confirmText;
            }
            String str4 = modal.cancelText;
            if (str4 == null || str4.length() == 0) {
                z17 = true;
            }
            if (z17) {
                str2 = context.getString(R.string.cancel);
            } else {
                str2 = modal.cancelText;
            }
            DialogUtil.createCustomDialog(context, 230).setMessage(modal.content).setPositiveButton(str, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AIOInlineKeyboardPermissionChecker.k(Function0.this, dialogInterface, i3);
                }
            }).setNegativeButton(str2, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.inlinekeyboard.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    AIOInlineKeyboardPermissionChecker.l(dialogInterface, i3);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function0 onConfirm, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(onConfirm, "$onConfirm");
        onConfirm.invoke();
    }

    @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b ctx, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @NotNull c btnPermissionRequired, @Nullable AIOMsgItem payload, @NotNull Function0<Unit> onPermissionGranted, @Nullable Function0<Unit> onPermissionDenied) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, ctx, btnModel, btnPermissionRequired, payload, onPermissionGranted, onPermissionDenied);
            return;
        }
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        Intrinsics.checkNotNullParameter(btnPermissionRequired, "btnPermissionRequired");
        Intrinsics.checkNotNullParameter(onPermissionGranted, "onPermissionGranted");
        int b16 = btnPermissionRequired.b();
        if (b16 != 0) {
            if (b16 != 1) {
                f(this, ctx, btnModel, true, onPermissionGranted, null, 16, null);
                return;
            } else {
                h(ctx, btnModel, onPermissionGranted, onPermissionDenied);
                return;
            }
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        e(ctx, btnModel, btnPermissionRequired.c().contains(str), onPermissionGranted, onPermissionDenied);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DialogInterface dialogInterface, int i3) {
    }
}
