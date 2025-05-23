package com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils;

import com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.model.c;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardElement;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardStyle;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\t*\u0004\u0018\u00010\tH\u0002J\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\f*\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0013\u001a\u00020\t2\u000e\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00102\u0006\u0010\u0012\u001a\u00020\u0007J)\u0010\u0018\u001a\u00020\u00172\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\f2\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0018\u0010\u0019J9\u0010\u001d\u001a\u00020\u00172\u0012\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\f0\f2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010!\u001a\u0004\u0018\u00010\u000b2\u0006\u0010 \u001a\u00020\u001fRO\u0010)\u001a:\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030$0#0\"j\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030$0#`%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "", "fontSize", "", "btnHeight", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "e", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardElement;", "", "f", "(Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardElement;)[[Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/InlineBtnPayload;", "payload", "btnModel", "c", "buttonRows", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "msgItem", "", "g", "([[Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;)V", "selectId", "selectLabel", "selectGroupId", h.F, "([[Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "a", "Ljava/util/HashMap;", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "loadingButton", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f191110a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, WeakReference<InlineBtnView<?, ?>>> loadingButton;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61600);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f191110a = new a();
            loadingButton = new HashMap<>();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String d(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a e(InlineKeyboardButton inlineKeyboardButton, float f16, int i3) {
        String id5 = inlineKeyboardButton.f359191id;
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        a.b bVar = new a.b(d(inlineKeyboardButton.label), d(inlineKeyboardButton.visitedLabel), inlineKeyboardButton.style, f16, i3);
        int i16 = inlineKeyboardButton.type;
        int i17 = inlineKeyboardButton.permissionType;
        List list = inlineKeyboardButton.specifyRoleIds;
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        List list2 = inlineKeyboardButton.specifyTinyids;
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        return new com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a(id5, bVar, new a.C0720a(i16, new c(i17, list, list2), inlineKeyboardButton.clickLimit, d(inlineKeyboardButton.data), inlineKeyboardButton.atBotShowChannelList, d(inlineKeyboardButton.unsupportTips), inlineKeyboardButton.isReply), inlineKeyboardButton, false, false, false, 112, null);
    }

    @Nullable
    public final InlineKeyboardElement a(@NotNull MsgRecord msgRecord) {
        Object obj;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (InlineKeyboardElement) iPatchRedirector.redirect((short) 7, (Object) this, (Object) msgRecord);
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MsgElement) obj).elementType == 17) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MsgElement msgElement = (MsgElement) obj;
        if (msgElement == null) {
            return null;
        }
        return msgElement.inlineKeyboardElement;
    }

    @NotNull
    public final HashMap<String, WeakReference<InlineBtnView<?, ?>>> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return loadingButton;
    }

    @NotNull
    public final String c(@Nullable AIOMsgItem payload, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) payload, (Object) btnModel);
        }
        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
        if (payload == null) {
            return btnModel.c();
        }
        return payload.getMsgRecord().msgId + btnModel.c() + btnModel.f().b();
    }

    @NotNull
    public final com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] f(@NotNull InlineKeyboardElement inlineKeyboardElement) {
        String str;
        float f16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][]) iPatchRedirector.redirect((short) 3, (Object) this, (Object) inlineKeyboardElement);
        }
        Intrinsics.checkNotNullParameter(inlineKeyboardElement, "<this>");
        int size = inlineKeyboardElement.rows.size();
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] aVarArr = new com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[size];
        InlineKeyboardStyle inlineKeyboardStyle = inlineKeyboardElement.keyboardStyle;
        String str2 = null;
        if (inlineKeyboardStyle != null) {
            str = inlineKeyboardStyle.fontSize;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, NtFaceConstant.SMALL)) {
            f16 = 12.0f;
        } else {
            f16 = 14.0f;
        }
        InlineKeyboardStyle inlineKeyboardStyle2 = inlineKeyboardElement.keyboardStyle;
        if (inlineKeyboardStyle2 != null) {
            str2 = inlineKeyboardStyle2.fontSize;
        }
        if (Intrinsics.areEqual(str2, NtFaceConstant.SMALL)) {
            i3 = 24;
        } else {
            i3 = 36;
        }
        for (int i16 = 0; i16 < size; i16++) {
            ArrayList<InlineKeyboardButton> arrayList = inlineKeyboardElement.rows.get(i16).buttons;
            int size2 = arrayList.size();
            com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[] aVarArr2 = new com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[size2];
            for (int i17 = 0; i17 < size2; i17++) {
                InlineKeyboardButton inlineKeyboardButton = arrayList.get(i17);
                Intrinsics.checkNotNullExpressionValue(inlineKeyboardButton, "row[columnIndex]");
                aVarArr2[i17] = e(inlineKeyboardButton, f16, i3);
            }
            aVarArr[i16] = aVarArr2;
        }
        return aVarArr;
    }

    public final void g(@NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] buttonRows, @NotNull MarkdownMsgItem msgItem) {
        InlineKeyboardButton inlineKeyboardButton;
        String str;
        boolean z16;
        boolean z17;
        MarkdownMsgItem.b o26;
        HashSet<String> b16;
        Object obj;
        String str2;
        HashMap<String, String> a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) buttonRows, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(buttonRows, "buttonRows");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        HashMap<String, WeakReference<InlineBtnView<?, ?>>> hashMap = loadingButton;
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar = null;
        for (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[] aVarArr : buttonRows) {
            int length = aVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar2 = aVarArr[i3];
                    if (hashMap.get(f191110a.c(msgItem, aVar2)) != null) {
                        aVar = aVar2;
                        break;
                    }
                    i3++;
                }
            }
        }
        for (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[] aVarArr2 : buttonRows) {
            for (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar3 : aVarArr2) {
                Object e16 = aVar3.e();
                if (e16 instanceof InlineKeyboardButton) {
                    inlineKeyboardButton = (InlineKeyboardButton) e16;
                } else {
                    inlineKeyboardButton = null;
                }
                if (inlineKeyboardButton != null) {
                    str = inlineKeyboardButton.groupId;
                } else {
                    str = null;
                }
                if (str == null) {
                    str = "";
                }
                boolean z18 = true;
                if (str.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    MarkdownMsgItem.b o27 = msgItem.o2();
                    if (o27 != null && (a16 = o27.a()) != null) {
                        str2 = a16.get(str);
                    }
                    str2 = null;
                } else {
                    if (!Intrinsics.areEqual(aVar3.f().b(), aVar3.f().e())) {
                        if (aVar3.f().e().length() > 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17 && (o26 = msgItem.o2()) != null && (b16 = o26.b()) != null) {
                            Iterator<T> it = b16.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    obj = it.next();
                                    if (Intrinsics.areEqual((String) obj, aVar3.c())) {
                                        break;
                                    }
                                } else {
                                    obj = null;
                                    break;
                                }
                            }
                            str2 = (String) obj;
                        }
                    }
                    str2 = null;
                }
                if (str2 == null) {
                    aVar3.i(Intrinsics.areEqual(aVar3, aVar));
                    if (!Intrinsics.areEqual(aVar3, aVar) && aVar != null) {
                        z18 = false;
                    }
                    aVar3.h(z18);
                    aVar3.j(false);
                } else {
                    aVar3.i(false);
                    aVar3.h(false);
                    aVar3.j(Intrinsics.areEqual(aVar3.c(), str2));
                }
            }
        }
    }

    public final void h(@NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] buttonRows, @NotNull String selectId, @NotNull String selectLabel, @NotNull String selectGroupId) {
        InlineKeyboardButton inlineKeyboardButton;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, buttonRows, selectId, selectLabel, selectGroupId);
            return;
        }
        Intrinsics.checkNotNullParameter(buttonRows, "buttonRows");
        Intrinsics.checkNotNullParameter(selectId, "selectId");
        Intrinsics.checkNotNullParameter(selectLabel, "selectLabel");
        Intrinsics.checkNotNullParameter(selectGroupId, "selectGroupId");
        for (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[] aVarArr : buttonRows) {
            for (com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a aVar : aVarArr) {
                Object e16 = aVar.e();
                String str = null;
                if (e16 instanceof InlineKeyboardButton) {
                    inlineKeyboardButton = (InlineKeyboardButton) e16;
                } else {
                    inlineKeyboardButton = null;
                }
                if (inlineKeyboardButton != null) {
                    str = inlineKeyboardButton.groupId;
                }
                if (Intrinsics.areEqual(aVar.c(), selectId) && Intrinsics.areEqual(aVar.f().b(), selectLabel)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (selectGroupId.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        if (!Intrinsics.areEqual(str, selectGroupId)) {
                        }
                    }
                }
                aVar.i(false);
                aVar.h(false);
                aVar.j(z16);
            }
        }
    }
}
