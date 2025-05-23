package com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.GrayTipsMsgItem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.graytips.action.p;
import com.tencent.qqnt.graytips.action.s;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.RevokeElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000bH\u0002J8\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u001e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/g;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "revokeElement", "", "c", "", "length", "d", "", "hasCustomWording", "canEdit", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "isSelf", "a", "", "uid", "start", "end", "Landroid/text/SpannableStringBuilder;", "member", "needActionInfo", "b", "g", "Lcom/tencent/mobileqq/aio/msg/GrayTipsMsgItem;", "Landroid/content/Context;", "context", "f", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f190901a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60874);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f190901a = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a(RevokeElement revokeElement, MsgRecord msgRecord, boolean isSelf) {
        if (!isSelf || !revokeElement.isSelfOperate || !msgRecord.editable || !Intrinsics.areEqual(msgRecord.senderUid, revokeElement.operatorUid) || !g(msgRecord)) {
            return false;
        }
        return true;
    }

    private final SpannableStringBuilder b(AIOMsgItem msgItem, String uid, int start, int end, SpannableStringBuilder member, boolean needActionInfo) {
        com.tencent.qqnt.graytips.action.f sVar;
        int i3;
        GrayTipsMsgItem grayTipsMsgItem;
        GrayTipsMsgItem grayTipsMsgItem2;
        if (needActionInfo) {
            sVar = new p(uid, "", null, 4, null);
        } else {
            sVar = new s(uid, "", null, 4, null);
        }
        if (needActionInfo) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        com.tencent.qqnt.graytips.c cVar = new com.tencent.qqnt.graytips.c(start, end, i3, sVar);
        com.tencent.qqnt.graytips.span.a aVar = new com.tencent.qqnt.graytips.span.a(MobileQQ.sMobileQQ.peekAppRuntime(), cVar.b(), BaseApplication.context, cVar);
        boolean z16 = msgItem instanceof GrayTipsMsgItem;
        ArrayList arrayList = null;
        if (z16) {
            grayTipsMsgItem = (GrayTipsMsgItem) msgItem;
        } else {
            grayTipsMsgItem = null;
        }
        if (grayTipsMsgItem != null) {
            aVar.e(grayTipsMsgItem.m2());
        }
        member.setSpan(aVar, 0, member.length(), 33);
        if (z16) {
            grayTipsMsgItem2 = (GrayTipsMsgItem) msgItem;
        } else {
            grayTipsMsgItem2 = null;
        }
        if (grayTipsMsgItem2 != null) {
            GrayTipsMsgItem grayTipsMsgItem3 = (GrayTipsMsgItem) msgItem;
            if (grayTipsMsgItem3.j2() == null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(aVar);
                grayTipsMsgItem3.x2(arrayList2);
            } else {
                List<ClickableSpan> j26 = grayTipsMsgItem3.j2();
                if (j26 instanceof ArrayList) {
                    arrayList = (ArrayList) j26;
                }
                if (arrayList != null) {
                    arrayList.add(aVar);
                }
            }
        }
        return member;
    }

    private final CharSequence c(AIOMsgItem msgItem, RevokeElement revokeElement) {
        String str = "";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        int i3 = (int) revokeElement.operatorRole;
        BaseApplication baseApplication = BaseApplication.context;
        boolean z16 = false;
        if (revokeElement.isSelfOperate) {
            if (i3 != 0 && i3 != 1 && i3 != 2) {
                CharSequence h16 = com.tencent.mobileqq.aio.utils.d.h(msgItem);
                if (h16.length() == 0) {
                    z16 = true;
                }
                if (z16) {
                    h16 = com.tencent.qqnt.graytips.util.f.b(revokeElement);
                    Intrinsics.checkNotNullExpressionValue(h16, "getShowNick(revokeElement)");
                }
                String str2 = revokeElement.operatorUid;
                Intrinsics.checkNotNullExpressionValue(str2, "revokeElement.operatorUid");
                spannableStringBuilder.append((CharSequence) b(msgItem, str2, 0, h16.length(), new SpannableStringBuilder(h16), true));
                return spannableStringBuilder;
            }
            spannableStringBuilder.append((CharSequence) baseApplication.getString(R.string.f172112pk));
            return spannableStringBuilder;
        }
        if (msgItem.getMsgRecord().chatType != 3 && msgItem.getMsgRecord().chatType != 1 && msgItem.getMsgRecord().chatType != 100) {
            if (msgItem.getMsgRecord().chatType == 2) {
                String b16 = com.tencent.qqnt.graytips.util.f.b(revokeElement);
                if (b16 == null) {
                    b16 = "";
                }
                spannableStringBuilder.append((CharSequence) b16);
                if (i3 != 1) {
                    if (i3 == 2) {
                        str = baseApplication.getString(R.string.ems);
                    }
                } else {
                    str = baseApplication.getString(R.string.eml);
                }
                Intrinsics.checkNotNullExpressionValue(str, "when (operatorRole) {\n  \u2026          }\n            }");
                spannableStringBuilder.insert(0, (CharSequence) str);
                String str3 = revokeElement.operatorUid;
                Intrinsics.checkNotNullExpressionValue(str3, "revokeElement.operatorUid");
                SpannableStringBuilder append = new SpannableStringBuilder(str).append((CharSequence) b(msgItem, str3, str.length(), spannableStringBuilder.length(), new SpannableStringBuilder(b16), true));
                Intrinsics.checkNotNullExpressionValue(append, "SpannableStringBuilder(prefix).append(memberSpan)");
                return append;
            }
            return spannableStringBuilder;
        }
        spannableStringBuilder.append((CharSequence) baseApplication.getString(R.string.f172092pi));
        return spannableStringBuilder;
    }

    private final CharSequence d(AIOMsgItem msgItem, RevokeElement revokeElement, int length) {
        int i3 = (int) revokeElement.operatorRole;
        if ((i3 != 1 && i3 != 2) || !revokeElement.isSelfOperate) {
            return "";
        }
        String string = BaseApplication.context.getString(R.string.f171782oo);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ssage_revoke_member_name)");
        CharSequence h16 = com.tencent.mobileqq.aio.utils.d.h(msgItem);
        SpannableStringBuilder append = new SpannableStringBuilder(string).append(h16);
        String str = revokeElement.origMsgSenderUid;
        Intrinsics.checkNotNullExpressionValue(str, "revokeElement.origMsgSenderUid");
        SpannableStringBuilder append2 = new SpannableStringBuilder(string).append((CharSequence) b(msgItem, str, string.length() + length, append.length() + length, new SpannableStringBuilder(h16), true));
        Intrinsics.checkNotNullExpressionValue(append2, "SpannableStringBuilder(prefix).append(memberSpan)");
        return append2;
    }

    private final CharSequence e(RevokeElement revokeElement, boolean hasCustomWording, boolean canEdit) {
        String trimEnd;
        String string = BaseApplication.context.getString(R.string.f171802oq);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.nt_message_revoke_tips)");
        int i3 = (int) revokeElement.operatorRole;
        if (i3 != 1 && i3 != 2) {
            if (hasCustomWording) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                string = String.format("%s\uff0c%s", Arrays.copyOf(new Object[]{string, revokeElement.wording}, 2));
                Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
            } else if (canEdit) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                string = String.format("%s ", Arrays.copyOf(new Object[]{string}, 1));
                Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
            }
            trimEnd = StringsKt__StringsKt.trimEnd(string, '\t');
            return trimEnd;
        }
        if (revokeElement.isSelfOperate) {
            return BaseApplication.context.getString(R.string.f171792op) + string;
        }
        String string2 = BaseApplication.context.getString(R.string.f171772on);
        Intrinsics.checkNotNullExpressionValue(string2, "{\n                BaseAp\u2026evoke_tips)\n            }");
        return string2;
    }

    private final boolean g(MsgRecord msgRecord) {
        if (msgRecord.msgTime + 120 > NetConnInfoCenter.getServerTimeMillis() / 1000) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a5  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SpannableStringBuilder f(@NotNull GrayTipsMsgItem msgItem, @NotNull RevokeElement revokeElement, @NotNull Context context) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpannableStringBuilder) iPatchRedirector.redirect((short) 2, this, msgItem, revokeElement, context);
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(revokeElement, "revokeElement");
        Intrinsics.checkNotNullParameter(context, "context");
        boolean a16 = a(revokeElement, msgItem.getMsgRecord(), TextUtils.equals(MobileQQ.sMobileQQ.waitAppRuntime().getCurrentUid(), msgItem.getMsgRecord().senderUid));
        String str = revokeElement.wording;
        if (str != null) {
            if (str.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                CharSequence c16 = c(msgItem, revokeElement);
                String string = context.getString(R.string.f172122pl);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.nt_revoke_tips_text)");
                CharSequence d16 = d(msgItem, revokeElement, new SpannableStringBuilder(c16).append((CharSequence) string).length());
                CharSequence e16 = e(revokeElement, z16, a16);
                if (!a16) {
                    msgItem.A2(true);
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    e16 = String.format("%s%s", Arrays.copyOf(new Object[]{e16, context.getString(R.string.f172082ph)}, 2));
                    Intrinsics.checkNotNullExpressionValue(e16, "format(format, *args)");
                } else {
                    msgItem.A2(false);
                }
                SpannableStringBuilder append = new SpannableStringBuilder(c16).append((CharSequence) string).append(d16).append(e16);
                Intrinsics.checkNotNullExpressionValue(append, "SpannableStringBuilder(n\u2026pend(nickOf).append(tail)");
                return append;
            }
        }
        z16 = false;
        CharSequence c162 = c(msgItem, revokeElement);
        String string2 = context.getString(R.string.f172122pl);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.nt_revoke_tips_text)");
        CharSequence d162 = d(msgItem, revokeElement, new SpannableStringBuilder(c162).append((CharSequence) string2).length());
        CharSequence e162 = e(revokeElement, z16, a16);
        if (!a16) {
        }
        SpannableStringBuilder append2 = new SpannableStringBuilder(c162).append((CharSequence) string2).append(d162).append(e162);
        Intrinsics.checkNotNullExpressionValue(append2, "SpannableStringBuilder(n\u2026pend(nickOf).append(tail)");
        return append2;
    }
}
