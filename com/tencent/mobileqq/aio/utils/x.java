package com.tencent.mobileqq.aio.utils;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.tencent.mobileqq.aio.input.at.InputAtMsgIntent;
import com.tencent.mobileqq.aio.input.at.a;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nJ(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004J7\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162'\u0010\u001d\u001a#\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b\u0012\u0004\u0012\u00020\u00130\u0018\u00a2\u0006\u0002\b\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/utils/x;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/TextElement;", "textElement", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "o", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "faceElement", "", "emojiSize", DomainData.DOMAIN_NAME, "Landroid/text/Spanned;", "editableText", "", "inputString", "Lcom/tencent/mobileqq/aio/input/d;", "replyData", "", "p", tl.h.F, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "Lkotlin/ExtensionFunctionType;", "cb", "k", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class x {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final x f194179a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65290);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f194179a = new x();
        }
    }

    x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Contact contact) {
        Intrinsics.checkNotNullParameter(contact, "$contact");
        ((IMsgService) QRoute.api(IMsgService.class)).deleteDraft(contact, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.utils.w
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                x.j(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(int i3, String str) {
        QLog.d("DraftUtil", 1, "deleteDrafts result=" + i3 + ", errMsg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Contact contact, final Function1 cb5) {
        Intrinsics.checkNotNullParameter(contact, "$contact");
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        ((IMsgService) QRoute.api(IMsgService.class)).getDraft(contact, new IGetDraftOperateCallback() { // from class: com.tencent.mobileqq.aio.utils.s
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList, long j3) {
                x.m(Function1.this, i3, str, arrayList, j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 cb5, int i3, String str, ArrayList msgElements, long j3) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        if (QLog.isColorLevel()) {
            QLog.d("DraftUtil", 2, "getDrafts result=" + i3 + " errMsg=" + str);
        }
        Intrinsics.checkNotNullExpressionValue(msgElements, "msgElements");
        cb5.invoke(msgElements);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ArrayList kernelElements, Contact contact) {
        Intrinsics.checkNotNullParameter(kernelElements, "$kernelElements");
        Intrinsics.checkNotNullParameter(contact, "$contact");
        if (kernelElements.isEmpty()) {
            ((IMsgService) QRoute.api(IMsgService.class)).deleteDraft(contact, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.utils.t
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    x.r(i3, str);
                }
            });
        } else {
            ((IMsgService) QRoute.api(IMsgService.class)).setDraft(contact, kernelElements, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.utils.u
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    x.s(i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(int i3, String str) {
        QLog.d("DraftUtil", 1, "deleteDraft result=" + i3 + ", errMsg=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(int i3, String str) {
        QLog.d("DraftUtil", 1, "setDraft result=" + i3 + ", errMsg=" + str);
    }

    public final void h(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aioContext);
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        final Contact b16 = o.b(aioContext.g().r().c());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.utils.v
            @Override // java.lang.Runnable
            public final void run() {
                x.i(Contact.this);
            }
        }, 32, null, true);
    }

    public final void k(@NotNull final Contact contact, @NotNull final Function1<? super ArrayList<MsgElement>, Unit> cb5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) contact, (Object) cb5);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.utils.r
            @Override // java.lang.Runnable
            public final void run() {
                x.l(Contact.this, cb5);
            }
        }, 32, null, true);
    }

    @NotNull
    public final CharSequence n(@Nullable FaceElement faceElement, int emojiSize) {
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this, (Object) faceElement, emojiSize);
        }
        if (faceElement != null) {
            Integer num = faceElement.imageType;
            if (num == null) {
                intValue = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num, "it.imageType ?: 0");
                intValue = num.intValue();
            }
            return ((IEmojiSpanService) QRoute.api(IEmojiSpanService.class)).createEmojiSpanText(faceElement.faceType, faceElement.faceIndex, intValue, false, emojiSize);
        }
        return "";
    }

    @NotNull
    public final CharSequence o(@NotNull TextElement textElement, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        a.C7251a c7251a;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this, (Object) textElement, (Object) aioContext);
        }
        Intrinsics.checkNotNullParameter(textElement, "textElement");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i3 = textElement.atType;
        if (i3 != 0) {
            if (i3 == 1 || i3 == 2) {
                com.tencent.mvi.base.route.j e16 = aioContext.e();
                String str = textElement.atNtUid.toString();
                String valueOf = String.valueOf(textElement.atUid);
                String str2 = textElement.content;
                Intrinsics.checkNotNullExpressionValue(str2, "textElement.content");
                String substring = str2.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                com.tencent.mvi.base.route.k k3 = e16.k(new InputAtMsgIntent.CreateAtSpan(str, valueOf, substring, false));
                if (k3 instanceof a.C7251a) {
                    c7251a = (a.C7251a) k3;
                } else {
                    c7251a = null;
                }
                if (c7251a != null) {
                    spannableStringBuilder.append(c7251a.a());
                }
            }
        } else {
            spannableStringBuilder.append((CharSequence) textElement.content);
        }
        return spannableStringBuilder;
    }

    public final void p(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull Spanned editableText, @NotNull String inputString, @Nullable com.tencent.mobileqq.aio.input.d replyData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, aioContext, editableText, inputString, replyData);
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(editableText, "editableText");
        Intrinsics.checkNotNullParameter(inputString, "inputString");
        final ArrayList<MsgElement> l3 = AIOObjectTransform.f194080a.l(com.tencent.mobileqq.aio.msg.data.b.f190166a.j(l.f194165a.a(inputString, editableText), replyData), 2);
        final Contact b16 = o.b(aioContext.g().r().c());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.utils.q
            @Override // java.lang.Runnable
            public final void run() {
                x.q(l3, b16);
            }
        }, 32, null, true);
    }
}
