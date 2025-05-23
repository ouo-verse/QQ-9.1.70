package iq0;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.msglist.text.util.f;
import com.tencent.guild.aio.util.ex.d;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.message.api.IGuildNicknameApi;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.WalletAio;
import com.tencent.qqnt.kernel.nativeinterface.WalletElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;
import vn0.e;
import vn0.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0015\u001a\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a@\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u001a&\u0010\u0018\u001a\u00020\u00172\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u001a\u000e\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0014\u001a\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d\u001a\"\u0010#\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00112\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u001a\u000e\u0010$\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001b\u001a\u0016\u0010'\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u0011\u001a\u001e\u0010)\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u000f\u001a\u0018\u0010,\u001a\u0004\u0018\u00010\u00142\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0007\u001a\u0016\u0010.\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u000f\u001a\u001a\u00100\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u000fH\u0007\u001a\u001a\u00101\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u000fH\u0007\u001a\u001a\u00102\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u000fH\u0007\u001a\u001a\u00103\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u000fH\u0007\u00a8\u00064"}, d2 = {"Landroid/widget/LinearLayout;", "replyLayout", "", "l", "(Landroid/widget/LinearLayout;)Ljava/lang/Long;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "replyMsgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/ReplyElement;", "replyElement", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "supportTypes", "", "isEmoAnim", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElements", "isInput", "", "o", DTConstants.TAG.ELEMENT, "b", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "Lvn0/e;", "binding", "", "a", "senderUid", "guildId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "uid", "guildID", "u", "isSelfRevoked", "v", "type", "msgRecord", "c", "isHost", ReportConstant.COSTREPORT_PREFIX, "isVasTheme", "j", "f", h.F, "d", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "GuildReplyUtil")
/* loaded from: classes6.dex */
public final class a {
    public static final void a(@NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull e binding) {
        List filterNotNull;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(binding, "binding");
        String str = t(msgItem) + MsgSummary.STR_COLON;
        k e16 = k.e(binding.getRoot());
        Intrinsics.checkNotNullExpressionValue(e16, "bind(binding.root)");
        e16.f441969d.setText(str);
        ArrayList arrayList = new ArrayList();
        ArrayList<MsgElement> elements = ((GuildMsgItem) msgItem).getMsgRecord().elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        e16.f441970e.setText(p(arrayList, true, false, 4, null));
    }

    @NotNull
    public static final String b(@NotNull MsgElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        String string = BaseApplication.context.getString(R.string.f139490be);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026uild_aio_save_struct_msg)");
        try {
            String optString = new JSONObject(element.arkElement.bytesData).optString("prompt", string);
            Intrinsics.checkNotNullExpressionValue(optString, "jsonRoot.optString(\"prompt\", content)");
            return optString;
        } catch (JSONException e16) {
            QLog.e("getArkReplyText", 1, "decode failed, msg = " + e16.getMessage());
            return string;
        }
    }

    @Nullable
    public static final MsgElement c(int i3, @NotNull MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList.isEmpty()) {
            return null;
        }
        boolean z16 = false;
        MsgElement msgElement = arrayList.get(0);
        if (msgElement != null && msgElement.elementType == i3) {
            z16 = true;
        }
        if (!z16) {
            return null;
        }
        return msgElement;
    }

    @ColorInt
    public static final int d(@NotNull Context context, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (z16) {
            return GuildUIUtils.f235378a.E(s(context, false), 0.3f);
        }
        return context.getColor(R.color.qui_common_border_standard);
    }

    public static /* synthetic */ int e(Context context, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = UIUtil.f112434a.A();
        }
        return d(context, z16);
    }

    @ColorInt
    public static final int f(@NotNull Context context, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        if (z16) {
            i3 = R.color.skin_chat_buble_link;
        } else {
            i3 = R.color.qui_common_text_link;
        }
        return context.getColor(i3);
    }

    public static /* synthetic */ int g(Context context, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = UIUtil.f112434a.A();
        }
        return f(context, z16);
    }

    @ColorInt
    public static final int h(@NotNull Context context, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (z16) {
            return s(context, true);
        }
        return context.getColor(R.color.qui_common_border_superlight);
    }

    public static /* synthetic */ int i(Context context, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = UIUtil.f112434a.A();
        }
        return h(context, z16);
    }

    @ColorInt
    public static final int j(@NotNull Context context, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        if (z16) {
            i3 = R.color.skin_chat_buble_mine;
        } else {
            i3 = R.color.qui_common_bubble_host_text_primary;
        }
        return context.getColor(i3);
    }

    public static /* synthetic */ int k(Context context, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = UIUtil.f112434a.A();
        }
        return j(context, z16);
    }

    @Nullable
    public static final Long l(@NotNull LinearLayout replyLayout) {
        Intrinsics.checkNotNullParameter(replyLayout, "replyLayout");
        Object tag = replyLayout.getTag(R.id.f73243t1);
        if (replyLayout.getVisibility() == 0 && tag != null && (tag instanceof Long)) {
            return (Long) tag;
        }
        return null;
    }

    @NotNull
    public static final String m(@NotNull String senderUid, @NotNull String guildId, @Nullable MsgRecord msgRecord) {
        Intrinsics.checkNotNullParameter(senderUid, "senderUid");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (msgRecord != null && d.a(msgRecord)) {
            return "";
        }
        return u(senderUid, guildId) + MsgSummary.STR_COLON;
    }

    public static /* synthetic */ String n(String str, String str2, MsgRecord msgRecord, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            msgRecord = null;
        }
        return m(str, str2, msgRecord);
    }

    @NotNull
    public static final CharSequence o(@NotNull List<MsgElement> msgElements, boolean z16, boolean z17) {
        Object obj;
        CharSequence elementContent;
        boolean z18;
        int i3;
        String str;
        String str2;
        WalletAio walletAio;
        boolean z19;
        boolean z26;
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        if (msgElements.isEmpty()) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        QRouteApi api = QRoute.api(IMsgUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMsgUtilApi::class.java)");
        IMsgUtilApi iMsgUtilApi = (IMsgUtilApi) api;
        Iterator<T> it = msgElements.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                MsgElement msgElement = (MsgElement) obj;
                if (msgElement.elementType == 14 && msgElement.markdownElement != null) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                if (z26) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MsgElement msgElement2 = (MsgElement) obj;
        if (msgElement2 != null) {
            String o16 = fq0.a.f400309a.o(msgElement2);
            if (o16.length() > 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                spannableStringBuilder.append((CharSequence) o16);
                return spannableStringBuilder;
            }
        }
        for (MsgElement msgElement3 : msgElements) {
            switch (msgElement3.elementType) {
                case 1:
                    elementContent = iMsgUtilApi.getElementContent(msgElement3);
                    continue;
                case 2:
                    BaseApplication baseApplication = BaseApplication.context;
                    PicElement picElement = msgElement3.picElement;
                    if (picElement != null && MsgExtKt.u(picElement)) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        i3 = R.string.f139100ac;
                    } else {
                        i3 = R.string.f139480bd;
                    }
                    elementContent = baseApplication.getString(i3);
                    continue;
                case 3:
                    String string = BaseApplication.context.getString(R.string.f139470bc);
                    FileElement fileElement = msgElement3.fileElement;
                    if (fileElement != null) {
                        str = fileElement.fileName;
                    } else {
                        str = null;
                    }
                    elementContent = string + str;
                    continue;
                case 5:
                    elementContent = BaseApplication.context.getString(R.string.f139500bf);
                    continue;
                case 6:
                    FaceElement faceElement = msgElement3.faceElement;
                    if (faceElement != null) {
                        com.tencent.guild.aio.msglist.text.util.d dVar = com.tencent.guild.aio.msglist.text.util.d.f111941a;
                        Intrinsics.checkNotNullExpressionValue(faceElement, "element.faceElement");
                        elementContent = com.tencent.guild.aio.msglist.text.util.d.d(dVar, faceElement, 18, z17, false, 8, null);
                        break;
                    }
                    break;
                case 9:
                    String string2 = BaseApplication.context.getString(R.string.f139510bg);
                    WalletElement walletElement = msgElement3.walletElement;
                    if (walletElement != null && (walletAio = walletElement.receiver) != null) {
                        str2 = walletAio.notice;
                    } else {
                        str2 = null;
                    }
                    elementContent = string2 + str2;
                    continue;
                case 10:
                    elementContent = b(msgElement3);
                    continue;
                case 11:
                    MarketFaceElement marketFaceElement = msgElement3.marketFaceElement;
                    if (marketFaceElement != null) {
                        elementContent = marketFaceElement.faceName;
                        continue;
                    } else {
                        elementContent = null;
                        break;
                    }
            }
            elementContent = "";
            spannableStringBuilder.append(elementContent);
        }
        return spannableStringBuilder;
    }

    public static /* synthetic */ CharSequence p(List list, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        return o(list, z16, z17);
    }

    @NotNull
    public static final String q(@NotNull Context context, @NotNull MsgRecord replyMsgRecord, @NotNull ReplyElement replyElement, @NotNull ArrayList<Integer> supportTypes, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(replyMsgRecord, "replyMsgRecord");
        Intrinsics.checkNotNullParameter(replyElement, "replyElement");
        Intrinsics.checkNotNullParameter(supportTypes, "supportTypes");
        if (d.b(replyMsgRecord)) {
            String string = context.getString(R.string.f153001ax);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_reply_source_msg_delete)");
            return string;
        }
        if (d.a(replyMsgRecord)) {
            String string2 = context.getString(R.string.f153011ay);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026_reply_source_msg_revoke)");
            return string2;
        }
        if (MsgExtKt.P(replyMsgRecord)) {
            ArrayList arrayList = new ArrayList();
            ArrayList<MsgElement> arrayList2 = replyMsgRecord.elements;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "replyMsgRecord.elements");
            for (MsgElement msgElement : arrayList2) {
                if (supportTypes.contains(Integer.valueOf(msgElement.elementType))) {
                    arrayList.add(msgElement);
                }
            }
            return o(arrayList, false, z16).toString();
        }
        String str = replyElement.sourceMsgText;
        Intrinsics.checkNotNullExpressionValue(str, "replyElement.sourceMsgText");
        return str;
    }

    public static /* synthetic */ String r(Context context, MsgRecord msgRecord, ReplyElement replyElement, ArrayList arrayList, boolean z16, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z16 = true;
        }
        return q(context, msgRecord, replyElement, arrayList, z16);
    }

    public static final int s(@NotNull Context context, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (z16) {
            return f.f111944a.m(context);
        }
        if (UIUtil.f112434a.A()) {
            return GuildUIUtils.f235378a.E(context.getColor(R.color.skin_chat_buble), 0.5f);
        }
        return context.getColor(R.color.qui_common_bubble_guest_text_secondary);
    }

    @NotNull
    public static final String t(@NotNull com.tencent.aio.data.msglist.a msgItem) {
        String str;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            String str2 = guildMsgItem.getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str2, "msgItem.msgRecord.senderUid");
            String u16 = u(str2, com.tencent.guild.aio.util.ex.f.a(guildMsgItem));
            if (TextUtils.isEmpty(u16)) {
                if (!TextUtils.isEmpty(guildMsgItem.getMsgRecord().sendMemberName)) {
                    str = guildMsgItem.getMsgRecord().sendMemberName;
                    Intrinsics.checkNotNullExpressionValue(str, "{\n            msgItem.ms\u2026.sendMemberName\n        }");
                } else {
                    str = guildMsgItem.getMsgRecord().sendNickName;
                    Intrinsics.checkNotNullExpressionValue(str, "{\n            msgItem.ms\u2026rd.sendNickName\n        }");
                }
                return str;
            }
            return u16;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @NotNull
    public static final String u(@NotNull String uid, @NotNull String guildID) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(guildID, "guildID");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str = iGPSService.getGuildUserDisplayName(guildID, uid);
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public static final String v(@NotNull String uid, @NotNull String guildID, boolean z16) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(guildID, "guildID");
        String u16 = u(uid, guildID);
        QRouteApi api = QRoute.api(IGuildNicknameApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildNicknameApi::class.java)");
        IGuildNicknameApi iGuildNicknameApi = (IGuildNicknameApi) api;
        if (z16) {
            if (FontSettingManager.isFontSizeLarge()) {
                i16 = 8;
            } else {
                i16 = 12;
            }
            if (u16.length() > i16) {
                return iGuildNicknameApi.removeIncompleteEmoji(u16, i16 - 1) + "\u2026";
            }
            return u16;
        }
        if (FontSettingManager.isFontSizeLarge()) {
            i3 = 4;
        } else {
            i3 = 6;
        }
        if (u16.length() > i3) {
            return iGuildNicknameApi.removeIncompleteEmoji(u16, i3 - 1) + "\u2026";
        }
        return u16;
    }
}
