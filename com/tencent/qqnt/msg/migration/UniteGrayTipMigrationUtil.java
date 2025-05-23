package com.tencent.qqnt.msg.migration;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.GrayTipsMessageConstants$HighlightItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.RevokeElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.XmlElement;
import com.tencent.xweb.FileReaderHelper;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b?\u0010@J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J6\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u001d\u001a\u00020\fH\u0002J*\u0010 \u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u001d\u001a\u00020\fH\u0002J0\u0010#\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00102\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010$\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0018\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0002J\u0010\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020)R\u0017\u0010.\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u00100\u001a\u0004\b1\u00102R\u001b\u00105\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u00100\u001a\u0004\b4\u00102R\u001b\u00107\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u00100\u001a\u0004\b6\u00102R\u001b\u0010:\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u00100\u001a\u0004\b8\u00109R$\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\f0;j\b\u0012\u0004\u0012\u00020\f`<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/qqnt/msg/migration/UniteGrayTipMigrationUtil;", "", "Lcom/tencent/mobileqq/graytip/MessageForUniteGrayTip;", "mr", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/text/MatchResult;", "matchResult", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "", "e", "Lcom/tencent/mobileqq/graytip/g;", "tipParam", "", "o", "Lcom/tencent/mobileqq/data/GrayTipsMessageConstants$HighlightItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "f", "Lcom/tencent/mobileqq/structmsg/e;", "serializer", FileReaderHelper.TXT_EXT, "", "b", "uin", "nick", "jp", "color", "c", "url", "d", "src", QCircleSchemeAttr.Polymerize.ALT, "a", "r", "busiId", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "", "k", "Lcom/tencent/mobileqq/data/MessageRecord;", DomainData.DOMAIN_NAME, "I", "getRED_COLOR", "()I", "RED_COLOR", "Lkotlin/text/Regex;", "Lkotlin/Lazy;", "j", "()Lkotlin/text/Regex;", "xxxRevokeRegex", "g", "mgrOrOwnerRevokeRegex", tl.h.F, "mgrOrOwnerRevokeRegex2", "i", "()Ljava/lang/String;", "reEditStr", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "roamXmlIds", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class UniteGrayTipMigrationUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final UniteGrayTipMigrationUtil f359680a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int RED_COLOR;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy xxxRevokeRegex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mgrOrOwnerRevokeRegex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mgrOrOwnerRevokeRegex2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy reEditStr;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<Integer> roamXmlIds;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        ArrayList<Integer> arrayListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64105);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f359680a = new UniteGrayTipMigrationUtil();
        RED_COLOR = Color.parseColor("#FFFF596A");
        lazy = LazyKt__LazyJVMKt.lazy(UniteGrayTipMigrationUtil$xxxRevokeRegex$2.INSTANCE);
        xxxRevokeRegex = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(UniteGrayTipMigrationUtil$mgrOrOwnerRevokeRegex$2.INSTANCE);
        mgrOrOwnerRevokeRegex = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(UniteGrayTipMigrationUtil$mgrOrOwnerRevokeRegex2$2.INSTANCE);
        mgrOrOwnerRevokeRegex2 = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(UniteGrayTipMigrationUtil$reEditStr$2.INSTANCE);
        reEditStr = lazy4;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(10179, 10180);
        roamXmlIds = arrayListOf;
    }

    UniteGrayTipMigrationUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a(com.tencent.mobileqq.structmsg.e serializer, String src, String alt, String jp5) {
        serializer.startTag(null, "img");
        serializer.attribute(null, "src", src);
        if (!TextUtils.isEmpty(alt)) {
            serializer.attribute(null, QCircleSchemeAttr.Polymerize.ALT, alt);
        }
        if (!TextUtils.isEmpty(jp5)) {
            serializer.attribute(null, "jp", jp5);
        }
        serializer.endTag(null, "img");
    }

    private final void b(com.tencent.mobileqq.structmsg.e serializer, String txt) {
        serializer.startTag(null, "nor");
        serializer.attribute(null, FileReaderHelper.TXT_EXT, txt);
        serializer.endTag(null, "nor");
    }

    private final void c(com.tencent.mobileqq.structmsg.e serializer, String uin, String nick, String jp5, int color) {
        serializer.startTag(null, "qq");
        serializer.attribute(null, "uin", uin);
        serializer.attribute(null, "nm", nick);
        if (!TextUtils.isEmpty(jp5)) {
            serializer.attribute(null, "jp", jp5);
        } else {
            serializer.attribute(null, "jp", uin);
        }
        r(serializer, color);
        serializer.endTag(null, "qq");
    }

    private final void d(com.tencent.mobileqq.structmsg.e serializer, String url, String txt, int color) {
        serializer.startTag(null, "url");
        serializer.attribute(null, "jp", url);
        serializer.attribute(null, FileReaderHelper.TXT_EXT, txt);
        r(serializer, color);
        serializer.endTag(null, "url");
    }

    private final int e(MessageForUniteGrayTip mr5) {
        int i3 = mr5.msgtype;
        if (i3 == -5040) {
            return 7;
        }
        switch (i3) {
            case MessageRecord.MSG_TYPE_UNITE_TAB_HISTORI_INVI /* -5023 */:
                return 2;
            case MessageRecord.MSG_TYPE_UNITE_TAB_DB_INVI /* -5022 */:
                return 0;
            case MessageRecord.MSG_TYPE_UNITE_GRAY_HISTORY_INVI /* -5021 */:
                return 3;
            case MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI /* -5020 */:
                return 6;
            default:
                return 7;
        }
    }

    private final String f(GrayTipsMessageConstants$HighlightItem item) {
        int i3 = item.actionType;
        if (i3 != 1) {
            if (i3 != 3) {
                return null;
            }
            return item.mMsgActionData;
        }
        return item.mMsgActionData;
    }

    private final Regex g() {
        return (Regex) mgrOrOwnerRevokeRegex.getValue();
    }

    private final Regex h() {
        return (Regex) mgrOrOwnerRevokeRegex2.getValue();
    }

    private final String i() {
        return (String) reEditStr.getValue();
    }

    private final Regex j() {
        return (Regex) xxxRevokeRegex.getValue();
    }

    private final boolean k(int busiId, int busiType) {
        if (busiId == 1061 && busiType == 12) {
            return true;
        }
        return false;
    }

    private final RevokeElement l(MessageForUniteGrayTip mr5, MatchResult matchResult) {
        String str;
        String str2;
        boolean z16;
        String str3;
        String str4;
        if (matchResult.getGroupValues().size() != 3) {
            return null;
        }
        String str5 = matchResult.getGroupValues().get(1);
        String str6 = matchResult.getGroupValues().get(2);
        if (TextUtils.isEmpty(str5)) {
            return null;
        }
        String str7 = mr5.senderuin;
        long j3 = 1;
        if (Intrinsics.areEqual(str5, BaseApplicationImpl.getApplication().getString(R.string.jyv))) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str4 = peekAppRuntime.getCurrentAccountUin();
            } else {
                str4 = null;
            }
            if (str4 == null) {
                return null;
            }
            ArrayList<GrayTipsMessageConstants$HighlightItem> e16 = mr5.tipParam.e();
            if (e16 != null && (!e16.isEmpty()) && e16.get(0).actionType == 28 && e16.get(0).uin > 0) {
                str7 = String.valueOf(e16.get(0).uin);
                mr5.senderuin = str7;
            }
            String strType = mr5.getExtInfoFromExtStr("revoke_op_type");
            if (!TextUtils.isEmpty(strType)) {
                Intrinsics.checkNotNullExpressionValue(strType, "strType");
                str3 = str4;
                z16 = true;
                str2 = str7;
                j3 = Util.toLongOrDefault(strType, 1L);
            } else {
                str3 = str4;
                z16 = true;
                str2 = str7;
            }
        } else {
            if (Intrinsics.areEqual(str5, BaseApplicationImpl.getApplication().getString(R.string.euv))) {
                j3 = 2;
            }
            ArrayList<GrayTipsMessageConstants$HighlightItem> e17 = mr5.tipParam.e();
            if (e17 != null && (!e17.isEmpty()) && e17.get(0).actionType == 5 && e17.get(0).start < 4 && e17.get(0).uin > 0) {
                str = String.valueOf(e17.get(0).uin);
            } else {
                str = "";
            }
            str2 = str7;
            z16 = false;
            str3 = str;
        }
        return new RevokeElement(0L, j3, str3, str6, "", "", str2, "", "", "", z16, "");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final MsgRecord m(MessageForUniteGrayTip mr5) {
        RevokeElement revokeElement;
        RevokeElement l3;
        ArrayList<MsgElement> arrayListOf;
        com.tencent.mobileqq.graytip.g gVar = mr5.tipParam;
        if (TextUtils.isEmpty(gVar.f213683f) || (mr5.time * 1000) - System.currentTimeMillis() < 604800000) {
            return null;
        }
        Regex j3 = j();
        String str = gVar.f213683f;
        Intrinsics.checkNotNullExpressionValue(str, "tipParam.wording");
        MatchResult find$default = Regex.find$default(j3, str, 0, 2, null);
        if (find$default != null) {
            l3 = q(mr5, find$default);
        } else {
            Regex g16 = g();
            String str2 = gVar.f213683f;
            Intrinsics.checkNotNullExpressionValue(str2, "tipParam.wording");
            MatchResult find$default2 = Regex.find$default(g16, str2, 0, 2, null);
            if (find$default2 == null) {
                Regex h16 = h();
                String str3 = gVar.f213683f;
                Intrinsics.checkNotNullExpressionValue(str3, "tipParam.wording");
                find$default2 = Regex.find$default(h16, str3, 0, 2, null);
            }
            if (find$default2 != null) {
                l3 = l(mr5, find$default2);
            } else {
                revokeElement = null;
                if (revokeElement != null) {
                    return null;
                }
                MsgElement msgElement = new MsgElement();
                msgElement.elementType = 8;
                msgElement.grayTipElement = new GrayTipElement(1, revokeElement, null, null, null, null, null, null, null, null, null, null, null, null, null);
                r rVar = r.f359707a;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(msgElement);
                return rVar.e(arrayListOf, mr5);
            }
        }
        revokeElement = l3;
        if (revokeElement != null) {
        }
    }

    private final String o(com.tencent.mobileqq.graytip.g tipParam) {
        if (TextUtils.isEmpty(tipParam.f213683f)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        com.tencent.mobileqq.structmsg.e eVar = new com.tencent.mobileqq.structmsg.e();
        eVar.setOutput(byteArrayOutputStream, "UTF-8");
        eVar.startTag(null, "gtip");
        eVar.attribute(null, "align", "center");
        if (tipParam.e() != null && tipParam.e().size() > 0) {
            String content = tipParam.f213683f;
            ArrayList<GrayTipsMessageConstants$HighlightItem> e16 = tipParam.e();
            Intrinsics.checkNotNullExpressionValue(e16, "tipParam.highlightItems");
            int i3 = 0;
            for (GrayTipsMessageConstants$HighlightItem it : e16) {
                if (it.start > i3) {
                    UniteGrayTipMigrationUtil uniteGrayTipMigrationUtil = f359680a;
                    Intrinsics.checkNotNullExpressionValue(content, "content");
                    String substring = content.substring(i3, it.start);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    uniteGrayTipMigrationUtil.b(eVar, substring);
                }
                Intrinsics.checkNotNullExpressionValue(content, "content");
                String substring2 = content.substring(it.start, it.end);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                UniteGrayTipMigrationUtil uniteGrayTipMigrationUtil2 = f359680a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                String f16 = uniteGrayTipMigrationUtil2.f(it);
                long j3 = it.uin;
                if (j3 > 0) {
                    uniteGrayTipMigrationUtil2.c(eVar, String.valueOf(j3), substring2, f16, it.textColor);
                } else if (!TextUtils.isEmpty(it.icon)) {
                    String str = it.icon;
                    Intrinsics.checkNotNullExpressionValue(str, "it.icon");
                    uniteGrayTipMigrationUtil2.a(eVar, str, it.iconAlt, f16);
                } else if (!TextUtils.isEmpty(f16)) {
                    Intrinsics.checkNotNull(f16);
                    uniteGrayTipMigrationUtil2.d(eVar, f16, substring2, it.textColor);
                } else {
                    uniteGrayTipMigrationUtil2.b(eVar, substring2);
                }
                i3 = it.end;
            }
            if (content.length() > i3) {
                Intrinsics.checkNotNullExpressionValue(content, "content");
                String substring3 = content.substring(i3);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                b(eVar, substring3);
            }
        } else {
            String str2 = tipParam.f213683f;
            if (str2 == null) {
                str2 = "";
            }
            b(eVar, str2);
        }
        eVar.endTag(null, "gtip");
        eVar.flush();
        return byteArrayOutputStream.toString("UTF-8");
    }

    private final MsgRecord p(MessageForUniteGrayTip mr5) {
        Integer intOrNull;
        int i3;
        Integer intOrNull2;
        int i16;
        int i17;
        ArrayList<MsgElement> arrayListOf;
        int e16 = e(mr5);
        if (e16 == 0) {
            return null;
        }
        try {
            String extInfoFromExtStr = mr5.getExtInfoFromExtStr(MessageForUniteGrayTip.KEY_UINT64_BUSI_TYPE);
            Intrinsics.checkNotNullExpressionValue(extInfoFromExtStr, "mr.getExtInfoFromExtStr(\u2026traInfoKey.BUSINESS_TYPE)");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(extInfoFromExtStr);
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
            } else {
                i3 = 0;
            }
            String extInfoFromExtStr2 = mr5.getExtInfoFromExtStr(MessageForUniteGrayTip.KEY_UINT64_BUSI_ID);
            Intrinsics.checkNotNullExpressionValue(extInfoFromExtStr2, "mr.getExtInfoFromExtStr(\u2026ExtraInfoKey.BUSINESS_ID)");
            intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull(extInfoFromExtStr2);
            if (intOrNull2 != null) {
                i16 = intOrNull2.intValue();
            } else {
                i16 = 0;
            }
        } catch (Exception e17) {
            QLog.d("UniteGrayTipMigrationUtil", 2, "parse xml error", e17);
        }
        if ((roamXmlIds.contains(Integer.valueOf(i16)) || k(i16, i3)) && (mr5.time * 1000) - System.currentTimeMillis() < 604800000) {
            return null;
        }
        String extInfoFromExtStr3 = mr5.getExtInfoFromExtStr(MessageForUniteGrayTip.KEY_UINT64_TEMPL_ID);
        Intrinsics.checkNotNullExpressionValue(extInfoFromExtStr3, "mr.getExtInfoFromExtStr(\u2026nts.ExtraInfoKey.TEMP_ID)");
        long longOrDefault = Util.toLongOrDefault(extInfoFromExtStr3, 0L);
        String extInfoFromExtStr4 = mr5.getExtInfoFromExtStr(MessageForUniteGrayTip.KEY_BYTES_CONTENT);
        String extInfoFromExtStr5 = mr5.getExtInfoFromExtStr(MessageForUniteGrayTip.KEY_UINT64_TIPS_SEQ_ID);
        Intrinsics.checkNotNullExpressionValue(extInfoFromExtStr5, "mr.getExtInfoFromExtStr(\u2026ExtraInfoKey.TIPS_SEQ_ID)");
        long longOrDefault2 = Util.toLongOrDefault(extInfoFromExtStr5, 0L);
        if (mr5.istroop == 0) {
            i17 = 1;
        } else {
            i17 = 0;
        }
        if (TextUtils.isEmpty(extInfoFromExtStr4)) {
            com.tencent.mobileqq.graytip.g gVar = mr5.tipParam;
            Intrinsics.checkNotNullExpressionValue(gVar, "mr.tipParam");
            extInfoFromExtStr4 = o(gVar);
        }
        String str = extInfoFromExtStr4;
        if (!TextUtils.isEmpty(str)) {
            XmlElement xmlElement = new XmlElement(i3, i16, i17, -1, e16, str, Long.valueOf(longOrDefault), Long.valueOf(longOrDefault2), new HashMap(), new byte[0], new HashMap());
            MsgElement msgElement = new MsgElement();
            msgElement.elementType = 8;
            msgElement.grayTipElement = new GrayTipElement(12, null, null, null, null, null, null, null, xmlElement, null, null, null, null, null, null);
            r rVar = r.f359707a;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(msgElement);
            return rVar.e(arrayListOf, mr5);
        }
        return null;
    }

    private final RevokeElement q(MessageForUniteGrayTip mr5, MatchResult matchResult) {
        String str;
        boolean endsWith$default;
        if (matchResult.getGroupValues().size() < 3) {
            return null;
        }
        String str2 = matchResult.getGroupValues().get(1);
        String str3 = matchResult.getGroupValues().get(2);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str3.length() > i().length()) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str3, i(), false, 2, null);
            if (endsWith$default) {
                int length = str3.length() - i().length();
                if (length == 0) {
                    str3 = "";
                } else {
                    str3 = str3.substring(0, length);
                    Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                }
            }
        }
        String str4 = str3;
        if (Intrinsics.areEqual(str2, BaseApplicationImpl.getApplication().getString(R.string.jyw))) {
            String str5 = mr5.senderuin;
            return new RevokeElement(0L, 0L, str5, "", "", "", str5, "", "", "", true, str4);
        }
        if (Intrinsics.areEqual(str2, BaseApplicationImpl.getApplication().getString(R.string.jyn))) {
            String str6 = mr5.senderuin;
            return new RevokeElement(0L, 0L, str6, "", "", "", str6, "", "", "", false, str4);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        String str7 = mr5.senderuin;
        return new RevokeElement(0L, 0L, str7, str2, "", "", str7, "", "", "", str7.equals(str), str4);
    }

    private final void r(com.tencent.mobileqq.structmsg.e serializer, int color) {
        String str;
        if (color != 0) {
            if (color == RED_COLOR) {
                str = "2";
            } else {
                str = "3";
            }
            serializer.attribute(null, "col", str);
        }
    }

    @Nullable
    public final MsgRecord n(@NotNull MessageRecord mr5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MsgRecord) iPatchRedirector.redirect((short) 3, (Object) this, (Object) mr5);
        }
        Intrinsics.checkNotNullParameter(mr5, "mr");
        if (!(mr5 instanceof MessageForUniteGrayTip) || ((MessageForUniteGrayTip) mr5).tipParam == null) {
            return null;
        }
        try {
        } catch (Exception e16) {
            QLog.d("UniteGrayTipMigrationUtil", 1, "parseUniteGrayTip error", e16);
        }
        if (((MessageForUniteGrayTip) mr5).tipParam.f213685h == 1) {
            return m((MessageForUniteGrayTip) mr5);
        }
        if (((MessageForUniteGrayTip) mr5).tipParam.f213685h == 655397) {
            return p((MessageForUniteGrayTip) mr5);
        }
        return null;
    }
}
