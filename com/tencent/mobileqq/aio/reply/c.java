package com.tencent.mobileqq.aio.reply;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.u;
import com.tencent.mobileqq.aio.msglist.holder.component.ptt.AIOPttUtil;
import com.tencent.mobileqq.aio.utils.al;
import com.tencent.mobileqq.aio.utils.ar;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.adapter.api.IArkApi;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.kernel.nativeinterface.AIVoiceChatType;
import com.tencent.qqnt.kernel.nativeinterface.FaceBubbleElement;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownElement;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.OtherBusinessInfo;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.PttElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.WalletAio;
import com.tencent.qqnt.kernel.nativeinterface.WalletElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f\u001a\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013\u001a\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u0013\u001a\f\u0010\u0019\u001a\u00020\u0002*\u00020\u0018H\u0002\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", QQPermissionConstants.Permission.AUIDO_GROUP, "", "isInput", "", "nickName", "", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "isReplyMultiForward", "b", PublicAccountMessageUtilImpl.META_NAME, "key", "a", "Lcom/tencent/mobileqq/aio/msg/u$c;", "replyMsgInfo", "", "g", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/ReplyElement;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/PttElement;", "f", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "ReplyUtil")
/* loaded from: classes11.dex */
public final class c {
    @NotNull
    public static final String a(@Nullable String str, @Nullable String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.keys().hasNext()) {
                    QLog.e("getArkReplyText", 1, "getArkMetaValue failed, meta has no keys.");
                    return "";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject((String) jSONObject.keys().next());
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(str2);
                    Intrinsics.checkNotNullExpressionValue(optString, "levelObject.optString(key)");
                    return optString;
                }
            } catch (Throwable th5) {
                QLog.e("getArkReplyText", 1, "getArkMetaValue failed, err = ", th5);
            }
        }
        return "";
    }

    @NotNull
    public static final String b(@NotNull MsgElement element, boolean z16, boolean z17) {
        String str;
        JSONObject jSONObject;
        Map<String, String> arkReplyConfig;
        String str2;
        boolean contains$default;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(element, "element");
        String str3 = "";
        try {
            jSONObject = new JSONObject(element.arkElement.bytesData);
            arkReplyConfig = ((IArkApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IArkApi.class)).getArkReplyConfig(jSONObject);
        } catch (Throwable th5) {
            th = th5;
            str = "";
        }
        if (!arkReplyConfig.isEmpty()) {
            String valueOf = String.valueOf(arkReplyConfig.get("tag"));
            try {
                String valueOf2 = String.valueOf(arkReplyConfig.get("title"));
                if (!z16 || z17) {
                    str3 = valueOf;
                }
                try {
                    return str3 + valueOf2;
                } catch (Throwable th6) {
                    th = th6;
                    String str4 = str3;
                    str3 = valueOf2;
                    str = str4;
                }
            } catch (Throwable th7) {
                th = th7;
                str = valueOf;
            }
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject(PublicAccountMessageUtilImpl.META_NAME);
            if (optJSONObject != null) {
                str2 = optJSONObject.toString();
            } else {
                str2 = null;
            }
            String a16 = a(str2, "tag");
            try {
                str3 = a(str2, "title");
                if (TextUtils.isEmpty(a16)) {
                    str = BaseApplication.context.getString(R.string.f2039051g);
                    Intrinsics.checkNotNullExpressionValue(str, "{\n            MobileQQ.c\u2026ly_default_tag)\n        }");
                } else {
                    str = "[" + a16 + "]";
                }
                try {
                    if (TextUtils.isEmpty(str3)) {
                        String optString = jSONObject.optString("prompt");
                        Intrinsics.checkNotNullExpressionValue(optString, "jsonRoot.optString(\"prompt\")");
                        try {
                            contains$default = StringsKt__StringsKt.contains$default((CharSequence) optString, (CharSequence) "[", false, 2, (Object) null);
                            if (contains$default) {
                                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) optString, (CharSequence) "]", false, 2, (Object) null);
                                if (contains$default2) {
                                    return optString;
                                }
                            }
                            str3 = optString;
                        } catch (Throwable th8) {
                            th = th8;
                            str3 = optString;
                        }
                    }
                    if (TextUtils.isEmpty(str3)) {
                        String string = BaseApplication.context.getString(R.string.f2039151h);
                        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.qq_reply_default_title)");
                        str3 = string;
                    }
                } catch (Throwable th9) {
                    th = th9;
                }
            } catch (Throwable th10) {
                th = th10;
                str = a16;
            }
            return str + str3;
        }
        QLog.e("getArkReplyText", 1, "decode failed, err = ", th);
        return str + str3;
    }

    @Nullable
    public static final ReplyElement c(@NotNull AIOMsgItem msgItem) {
        ReplyElement replyElement;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ArrayList<MsgElement> arrayList = msgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            if (msgElement.elementType == 7 && (replyElement = msgElement.replyElement) != null) {
                return replyElement;
            }
        }
        return null;
    }

    @NotNull
    public static final CharSequence d(@NotNull MsgRecord record, boolean z16, @Nullable String str) {
        List<MsgElement> filterNotNull;
        String str2;
        CharSequence charSequence;
        boolean z17;
        String str3;
        boolean z18;
        int i3;
        int intValue;
        WalletAio walletAio;
        String str4;
        String str5;
        boolean z19;
        String string;
        Intrinsics.checkNotNullParameter(record, "record");
        boolean z26 = true;
        String str6 = "";
        if (record.msgType == 8) {
            if (record.chatType == 2) {
                if (z16) {
                    str6 = BaseApplication.context.getString(R.string.yre);
                    Intrinsics.checkNotNullExpressionValue(str6, "context.getString(R.string.aio_input_multi_prefix)");
                }
                string = str6 + BaseApplication.context.getString(R.string.yr5);
            } else {
                String str7 = record.peerName;
                Intrinsics.checkNotNull(str7);
                if (str7.length() <= 0) {
                    z26 = false;
                }
                if (z26) {
                    string = record.peerName;
                    Intrinsics.checkNotNull(string);
                } else {
                    string = BaseApplication.context.getString(R.string.yox);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.aio_c2c_friend)");
                }
            }
            return string + BaseApplication.context.getString(R.string.ytl);
        }
        ArrayList<MsgElement> arrayList = record.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "record.elements");
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList);
        if (filterNotNull.isEmpty()) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = str + ":";
        }
        if (com.tencent.mobileqq.aio.utils.d.G(record)) {
            for (MsgElement msgElement : filterNotNull) {
                if (msgElement.elementType == 14) {
                    MarkdownElement markdownElement = msgElement.markdownElement;
                    if (markdownElement != null) {
                        str5 = markdownElement.mdSummary;
                    } else {
                        str5 = null;
                    }
                    if (str5 != null && str5.length() != 0) {
                        z19 = false;
                    } else {
                        z19 = true;
                    }
                    if (!z19) {
                        return str2 + msgElement.markdownElement.mdSummary;
                    }
                }
            }
            StringBuilder sb5 = new StringBuilder();
            for (MsgElement msgElement2 : filterNotNull) {
                if (msgElement2.elementType == 14) {
                    MarkdownElement markdownElement2 = msgElement2.markdownElement;
                    if (markdownElement2 != null) {
                        str4 = markdownElement2.content;
                    } else {
                        str4 = null;
                    }
                    if (str4 == null) {
                        str4 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str4, "element.markdownElement?.content ?: \"\"");
                    }
                    sb5.append(str4);
                }
            }
            String it = sb5.toString();
            IMarkdownFeatureCompatApi iMarkdownFeatureCompatApi = (IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class);
            Intrinsics.checkNotNullExpressionValue(it, "it");
            return str2 + iMarkdownFeatureCompatApi.parseExcludeExtData(it, 30).toString();
        }
        QRouteApi api = QRoute.api(IMsgUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMsgUtilApi::class.java)");
        IMsgUtilApi iMsgUtilApi = (IMsgUtilApi) api;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (MsgElement msgElement3 : filterNotNull) {
            int i16 = msgElement3.elementType;
            if (i16 != 27) {
                switch (i16) {
                    case 1:
                        if (MsgExtKt.b0(record)) {
                            charSequence = MsgExtKt.n(record);
                            continue;
                        } else {
                            charSequence = iMsgUtilApi.getElementContent(msgElement3);
                            break;
                        }
                    case 2:
                        PicElement picElement = msgElement3.picElement;
                        if (picElement != null && MsgExtKt.u(picElement)) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            PicElement picElement2 = msgElement3.picElement;
                            if (picElement2 != null) {
                                charSequence = picElement2.summary;
                            } else {
                                charSequence = null;
                            }
                            if (charSequence == null) {
                                charSequence = "";
                            }
                            if (TextUtils.isEmpty(charSequence)) {
                                charSequence = BaseApplication.context.getString(R.string.ypo);
                            }
                        } else {
                            charSequence = BaseApplication.context.getString(R.string.ytm);
                        }
                        Intrinsics.checkNotNullExpressionValue(charSequence, "{\n                if (el\u2026          }\n            }");
                        continue;
                    case 3:
                        String string2 = BaseApplication.context.getString(R.string.ytk);
                        FileElement fileElement = msgElement3.fileElement;
                        if (fileElement != null) {
                            str3 = fileElement.fileName;
                        } else {
                            str3 = null;
                        }
                        charSequence = string2 + str3;
                        continue;
                    case 4:
                        PttElement pttElement = msgElement3.pttElement;
                        if (pttElement != null && f(pttElement)) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            charSequence = BaseApplication.context.getString(R.string.ytx);
                        } else {
                            PttElement pttElement2 = msgElement3.pttElement;
                            if (pttElement2 != null) {
                                i3 = pttElement2.duration;
                            } else {
                                i3 = 0;
                            }
                            charSequence = BaseApplication.context.getString(R.string.ytn) + " " + AIOPttUtil.f191743a.e(i3);
                        }
                        Intrinsics.checkNotNullExpressionValue(charSequence, "{\n                if (el\u2026          }\n            }");
                        continue;
                    case 5:
                        charSequence = BaseApplication.context.getString(R.string.ytp);
                        Intrinsics.checkNotNullExpressionValue(charSequence, "{\n                Mobile\u2026_video_msg)\n            }");
                        continue;
                    case 6:
                        FaceElement faceElement = msgElement3.faceElement;
                        if (faceElement != null) {
                            if (MsgExtKt.N(faceElement)) {
                                charSequence = ar.f194115a.a(faceElement, true);
                            } else {
                                QRouteApi api2 = QRoute.api(IEmojiSpanService.class);
                                Intrinsics.checkNotNullExpressionValue(api2, "api(IEmojiSpanService::class.java)");
                                IEmojiSpanService iEmojiSpanService = (IEmojiSpanService) api2;
                                int i17 = faceElement.faceType;
                                int i18 = faceElement.faceIndex;
                                Integer num = faceElement.imageType;
                                if (num == null) {
                                    intValue = 0;
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(num, "it.imageType ?: 0");
                                    intValue = num.intValue();
                                }
                                charSequence = IEmojiSpanService.a.a(iEmojiSpanService, i17, i18, intValue, false, 0, 24, null);
                            }
                            if (charSequence != null) {
                                break;
                            }
                        }
                        break;
                    default:
                        switch (i16) {
                            case 9:
                                WalletElement walletElement = msgElement3.walletElement;
                                if (walletElement != null && (walletAio = walletElement.receiver) != null) {
                                    charSequence = walletAio.notice;
                                } else {
                                    charSequence = null;
                                }
                                if (charSequence == null) {
                                    charSequence = BaseApplication.context.getString(R.string.yt5);
                                    Intrinsics.checkNotNullExpressionValue(charSequence, "context.getString(R.string.aio_reply_wallet)");
                                    break;
                                } else {
                                    continue;
                                }
                                break;
                            case 10:
                                charSequence = b(msgElement3, al.c(record), z16);
                                str2 = "";
                                continue;
                            case 11:
                                MarketFaceElement marketFaceElement = msgElement3.marketFaceElement;
                                if (marketFaceElement != null) {
                                    charSequence = marketFaceElement.faceName;
                                } else {
                                    charSequence = null;
                                }
                                if (charSequence != null) {
                                    break;
                                }
                                break;
                        }
                }
                charSequence = "";
                spannableStringBuilder.append(charSequence);
            } else {
                FaceBubbleElement faceBubbleElement = msgElement3.faceBubbleElement;
                if (faceBubbleElement != null) {
                    charSequence = faceBubbleElement.content;
                } else {
                    charSequence = null;
                }
                if (charSequence != null) {
                    spannableStringBuilder.append(charSequence);
                }
                charSequence = "";
                spannableStringBuilder.append(charSequence);
            }
        }
        return str2 + ((Object) spannableStringBuilder);
    }

    public static /* synthetic */ CharSequence e(MsgRecord msgRecord, boolean z16, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = null;
        }
        return d(msgRecord, z16, str);
    }

    private static final boolean f(PttElement pttElement) {
        OtherBusinessInfo otherBusinessInfo = pttElement.otherBusinessInfo;
        if (otherBusinessInfo == null || otherBusinessInfo.aiVoiceType != AIVoiceChatType.KAIVOICECHATTYPESOUND.ordinal()) {
            return false;
        }
        return true;
    }

    public static final void g(@NotNull MsgElement element, @NotNull u.c replyMsgInfo) {
        String str;
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(replyMsgInfo, "replyMsgInfo");
        String string = BaseApplication.context.getString(R.string.yto);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.aio_save_struct_msg)");
        try {
            JSONObject jSONObject = new JSONObject(element.arkElement.bytesData);
            string = b(element, false, false);
            str = ((IArkApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IArkApi.class)).getArkReplyIcon(jSONObject);
        } catch (JSONException e16) {
            QLog.e("getArkReplyText", 1, "decode failed, msg = " + e16.getMessage());
            str = "";
        }
        replyMsgInfo.q(string);
        replyMsgInfo.j(str);
    }

    @NotNull
    public static final String h(@NotNull AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().chatType != 2) {
            return "";
        }
        if (!TextUtils.isEmpty(msgItem.getMsgRecord().sendMemberName)) {
            String str = msgItem.getMsgRecord().sendMemberName;
            Intrinsics.checkNotNullExpressionValue(str, "{\n        msgItem.msgRecord.sendMemberName\n    }");
            return str;
        }
        String str2 = msgItem.getMsgRecord().sendNickName;
        Intrinsics.checkNotNullExpressionValue(str2, "{\n        msgItem.msgRecord.sendNickName\n    }");
        return str2;
    }
}
