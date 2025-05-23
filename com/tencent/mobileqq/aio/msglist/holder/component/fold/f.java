package com.tencent.mobileqq.aio.msglist.holder.component.fold;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/fold/f;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "message", "", "b", QQPermissionConstants.Permission.AUIDO_GROUP, "a", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgRecord", "", "c", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f190870a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60703);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f190870a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final CharSequence a(MsgRecord record) {
        boolean z16;
        String content;
        boolean isBlank;
        ArrayList<MsgElement> arrayList = record.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "record.elements");
        Boolean bool = null;
        int i3 = 0;
        int i16 = 0;
        for (Object obj : arrayList) {
            int i17 = i16 + 1;
            if (i16 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MsgElement msgElement = (MsgElement) obj;
            int i18 = msgElement.elementType;
            if (i18 == 2) {
                i3++;
            } else if (i18 == 1) {
                TextElement textElement = msgElement.textElement;
                if (textElement != null && (content = textElement.content) != null) {
                    Intrinsics.checkNotNullExpressionValue(content, "content");
                    isBlank = StringsKt__StringsJVMKt.isBlank(content);
                    if (!isBlank) {
                        z16 = true;
                        if (!z16) {
                            QLog.d("SafetyMsgUtils", 1, "content " + msgElement.textElement.content);
                            if (i16 == 0) {
                                bool = Boolean.TRUE;
                            } else if (bool == null) {
                                bool = Boolean.FALSE;
                            }
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            i16 = i17;
        }
        StringBuilder sb5 = new StringBuilder();
        if (i3 > 2) {
            sb5.append(HardCodeUtil.qqStr(R.string.ytf));
        } else {
            for (int i19 = 0; i19 < i3; i19++) {
                sb5.append(HardCodeUtil.qqStr(R.string.ytg));
            }
        }
        if (bool == null) {
            return sb5;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.yth);
        if (i3 == 1) {
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                StringBuilder sb6 = new StringBuilder(qqStr);
                sb6.append((CharSequence) sb5);
                Intrinsics.checkNotNullExpressionValue(sb6, "{\n                String\u2026nd(picTips)\n            }");
                return sb6;
            }
            StringBuilder sb7 = new StringBuilder(sb5);
            sb7.append(qqStr);
            Intrinsics.checkNotNullExpressionValue(sb7, "{\n                String\u2026end(txtTip)\n            }");
            return sb7;
        }
        StringBuilder sb8 = new StringBuilder(qqStr);
        sb8.append((CharSequence) sb5);
        Intrinsics.checkNotNullExpressionValue(sb8, "StringBuilder(txtTip).append(picTips)");
        return sb8;
    }

    @JvmStatic
    @NotNull
    public static final CharSequence b(@NotNull MsgRecord message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BaseApplication context = BaseApplication.getContext();
        if (MsgExtKt.y(message)) {
            return f190870a.a(message);
        }
        if (com.tencent.mobileqq.aio.utils.d.u(message)) {
            String string = context.getResources().getString(R.string.yta);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026string.aio_safety_arkapp)");
            return string;
        }
        if (MsgExtKt.Y(message)) {
            String string2 = context.getResources().getString(R.string.yti);
            Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026io_safety_msg_fold_video)");
            return string2;
        }
        if (MsgExtKt.w(message)) {
            if (MsgExtKt.X(message)) {
                String string3 = context.getResources().getString(R.string.ytd);
                Intrinsics.checkNotNullExpressionValue(string3, "context.resources.getStr\u2026ng.aio_safety_file_video)");
                return string3;
            }
            if (MsgExtKt.L(message)) {
                String string4 = context.getResources().getString(R.string.ytc);
                Intrinsics.checkNotNullExpressionValue(string4, "context.resources.getStr\u2026ng.aio_safety_file_image)");
                return string4;
            }
            String string5 = context.getResources().getString(R.string.ytb);
            Intrinsics.checkNotNullExpressionValue(string5, "context.resources.getStr\u2026R.string.aio_safety_file)");
            return string5;
        }
        if (com.tencent.mobileqq.aio.utils.d.I(message)) {
            String string6 = context.getResources().getString(R.string.ytj);
            Intrinsics.checkNotNullExpressionValue(string6, "context.resources.getStr\u2026ring.aio_safety_multimsg)");
            return string6;
        }
        String string7 = context.getResources().getString(R.string.yte);
        Intrinsics.checkNotNullExpressionValue(string7, "context.resources.getStr\u2026.aio_safety_msg_fold_msg)");
        return string7;
    }

    public final boolean c(@NotNull AIOMsgItem msgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msgRecord)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        if (o81.a.c(msgRecord) || !MsgExtKt.w(msgRecord.getMsgRecord()) || MsgExtKt.X(msgRecord.getMsgRecord()) || MsgExtKt.L(msgRecord.getMsgRecord())) {
            return false;
        }
        return true;
    }
}
