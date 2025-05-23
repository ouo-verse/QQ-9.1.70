package iu1;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.guild.data.GuildCommonGrayTipsParseParams;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.guild.message.api.IGuildCommonGrayTipsApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002J\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002J\u001e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002J\u001e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002J\u001e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002J\u001e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0002\u00a8\u0006\u0019"}, d2 = {"Liu1/a;", "", "", "channelId", "b", "a", "", "j", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstract;", "msgAbstract", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstractElement;", "msg", "i", "abstract", "selfTinyId", h.F, "", "c", "e", "f", "msgAbstractElement", "d", "g", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f408753a = new a();

    a() {
    }

    private final String a(String channelId) {
        if (j(channelId)) {
            return l.b(l.f112411a, R.string.f141670ha, null, 2, null).toString();
        }
        return l.b(l.f112411a, R.string.f1650427g, null, 2, null).toString();
    }

    private final String b(String channelId) {
        if (j(channelId)) {
            return l.b(l.f112411a, R.string.f141680hb, null, 2, null).toString();
        }
        return l.b(l.f112411a, R.string.f1650527h, null, 2, null).toString();
    }

    private final String i(MsgAbstract msgAbstract, MsgAbstractElement msg2) {
        Integer num;
        if (msg2.elementType == 8 && (num = msg2.elementSubType) != null && num.intValue() == 6) {
            Long l3 = msg2.tinyId;
            if (l3 != null) {
                l3.longValue();
                return String.valueOf(msg2.tinyId);
            }
            return "";
        }
        String str = msgAbstract.senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgAbstract.senderUid");
        return str;
    }

    private final boolean j(String channelId) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProChannelInfo channelInfo;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Integer num = null;
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
        if (iGPSService != null && (channelInfo = iGPSService.getChannelInfo(channelId)) != null) {
            num = Integer.valueOf(channelInfo.getType());
        }
        if ((num == null || num.intValue() != 5) && (num == null || num.intValue() != 2)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final CharSequence c(@NotNull MsgAbstract r56, @NotNull MsgAbstractElement msg2, @NotNull String selfTinyId) {
        String str;
        Intrinsics.checkNotNullParameter(r56, "abstract");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        if (Intrinsics.areEqual(selfTinyId, r56.senderUid)) {
            str = l.b(l.f112411a, R.string.yg6, null, 2, null).toString();
        } else {
            Long l3 = msg2.tinyId;
            if (l3 != null) {
                l3.longValue();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String obj = l.b(l.f112411a, R.string.yg7, null, 2, null).toString();
                String valueOf = String.valueOf(msg2.tinyId);
                String str2 = r56.peer.guildId;
                Intrinsics.checkNotNullExpressionValue(str2, "abstract.peer.guildId");
                str = String.format(obj, Arrays.copyOf(new Object[]{iq0.a.u(valueOf, str2) + " "}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            } else {
                str = "";
            }
        }
        QLog.i("AbstractMsgDecoderHelper", 1, "msg.emojiType=" + msg2.emojiType + " msg.emojiId=" + msg2.emojiId);
        if (msg2.emojiId != null && msg2.emojiType != null) {
            IQQGuildEmojiApi iQQGuildEmojiApi = (IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class);
            Integer num = msg2.emojiType;
            Intrinsics.checkNotNullExpressionValue(num, "msg.emojiType");
            int intValue = num.intValue();
            Integer num2 = msg2.emojiId;
            Intrinsics.checkNotNullExpressionValue(num2, "msg.emojiId");
            return ((Object) str) + MsgSummary.STR_COLON + ((Object) iQQGuildEmojiApi.createEmojiFaceSpan(intValue, num2.intValue()));
        }
        return str;
    }

    @NotNull
    public final String d(@NotNull MsgAbstract msgAbstract, @NotNull MsgAbstractElement msgAbstractElement, @NotNull String selfTinyId) {
        boolean z16;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(msgAbstract, "msgAbstract");
        Intrinsics.checkNotNullParameter(msgAbstractElement, "msgAbstractElement");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        try {
            Contact contact = msgAbstract.peer;
            String str = contact.guildId;
            String str2 = contact.peerUid;
            String str3 = msgAbstract.senderUid;
            long j3 = msgAbstract.abstractTime;
            Long l3 = msgAbstractElement.grayTiPElement.xmlElement.seqId;
            Intrinsics.checkNotNullExpressionValue(l3, "msgAbstractElement.grayTiPElement.xmlElement.seqId");
            String commonGray = ((IGuildCommonGrayTipsApi) QRoute.api(IGuildCommonGrayTipsApi.class)).getGuildCommonGrayTipsSummary(new GuildCommonGrayTipsParseParams(str, str2, str3, Long.valueOf(j3 + l3.longValue()), msgAbstractElement.grayTiPElement.xmlElement, new Bundle()));
            Intrinsics.checkNotNullExpressionValue(commonGray, "commonGray");
            if (commonGray.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Intrinsics.checkNotNullExpressionValue(commonGray, "commonGray");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) commonGray, (CharSequence) "icon", false, 2, (Object) null);
                if (contains$default) {
                    Intrinsics.checkNotNullExpressionValue(commonGray, "commonGray");
                    commonGray = StringsKt__StringsJVMKt.replace$default(commonGray, "icon", "", false, 4, (Object) null);
                }
            }
            Intrinsics.checkNotNullExpressionValue(commonGray, "commonGray");
            return commonGray;
        } catch (Exception e16) {
            QLog.e("AbstractMsgDecoderHelper", 1, "getGrayMsgCommonGrayTips exception! " + e16.getMessage());
            return "";
        }
    }

    @NotNull
    public final String e(@NotNull MsgAbstract r46, @NotNull MsgAbstractElement msg2, @NotNull String selfTinyId) {
        String str;
        Intrinsics.checkNotNullParameter(r46, "abstract");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        Long l3 = msg2.tinyId;
        if (l3 != null) {
            str = String.valueOf(l3);
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(selfTinyId, str)) {
            String str2 = r46.peer.peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "abstract.peer.peerUid");
            return b(str2);
        }
        Long l16 = msg2.tinyId;
        if (l16 != null) {
            l16.longValue();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            a aVar = f408753a;
            String str3 = r46.peer.peerUid;
            Intrinsics.checkNotNullExpressionValue(str3, "abstract.peer.peerUid");
            String a16 = aVar.a(str3);
            String valueOf = String.valueOf(msg2.tinyId);
            String str4 = r46.peer.guildId;
            Intrinsics.checkNotNullExpressionValue(str4, "abstract.peer.guildId");
            String format = String.format(a16, Arrays.copyOf(new Object[]{" " + iq0.a.u(valueOf, str4)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        return "";
    }

    @NotNull
    public final String f(@NotNull MsgAbstract r46, @NotNull MsgAbstractElement msg2, @NotNull String selfTinyId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(r46, "abstract");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        if (r46.peer.chatType == 16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (msg2.content.length() > 1) {
                String str = msg2.content;
                Intrinsics.checkNotNullExpressionValue(str, "msg.content");
                String substring = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                return substring;
            }
            String str2 = msg2.content;
            Intrinsics.checkNotNullExpressionValue(str2, "{\n                msg.content\n            }");
            return str2;
        }
        if (Intrinsics.areEqual(selfTinyId, i(r46, msg2))) {
            CharSequence b16 = l.b(l.f112411a, R.string.f1506815n, null, 2, null);
            return ((Object) b16) + msg2.content;
        }
        String str3 = r46.sendMemberName;
        if (str3 != null) {
            return str3 + " " + msg2.content;
        }
        return "";
    }

    @NotNull
    public final String g(@NotNull MsgAbstract r46, @NotNull MsgAbstractElement msg2, @NotNull String selfTinyId) {
        Intrinsics.checkNotNullParameter(r46, "abstract");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        String str = r46.sendMemberName;
        if (TextUtils.isEmpty(str)) {
            str = r46.sendNickName;
        }
        if (TextUtils.isEmpty(str)) {
            str = l.b(l.f112411a, R.string.f143010kx, null, 2, null).toString();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(l.b(l.f112411a, R.string.f15198196, null, 2, null).toString(), Arrays.copyOf(new Object[]{" " + str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String h(@NotNull MsgAbstract r112, @NotNull MsgAbstractElement msg2, @NotNull String selfTinyId) {
        Intrinsics.checkNotNullParameter(r112, "abstract");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        if (Intrinsics.areEqual(selfTinyId, r112.senderUid)) {
            if (Intrinsics.areEqual(r112.senderUid, msg2.operatorTinyId)) {
                return l.b(l.f112411a, R.string.f153221bi, null, 2, null).toString();
            }
            String str = r112.peer.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "abstract.peer.guildId");
            String str2 = r112.peer.peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "abstract.peer.peerUid");
            if (yp0.a.d(str, str2)) {
                String str3 = msg2.operatorTinyId;
                Intrinsics.checkNotNullExpressionValue(str3, "msg.operatorTinyId");
                String str4 = r112.peer.guildId;
                Intrinsics.checkNotNullExpressionValue(str4, "abstract.peer.guildId");
                return iq0.a.u(str3, str4) + " " + ((Object) l.b(l.f112411a, R.string.f153211bh, null, 2, null));
            }
            return l.b(l.f112411a, R.string.f153161bc, null, 2, null).toString();
        }
        if (Intrinsics.areEqual(selfTinyId, msg2.operatorTinyId)) {
            if (r112.sendMemberName != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(l.b(l.f112411a, R.string.f153241bk, null, 2, null).toString(), Arrays.copyOf(new Object[]{r112.sendMemberName}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            }
        } else if (Intrinsics.areEqual(r112.senderUid, msg2.operatorTinyId)) {
            String str5 = r112.sendMemberName;
            if (str5 != null) {
                CharSequence b16 = l.b(l.f112411a, R.string.f153251bl, null, 2, null);
                StringBuilder sb5 = new StringBuilder();
                sb5.append((Object) (str5 + " "));
                sb5.append((Object) b16);
                return sb5.toString();
            }
        } else if (r112.sendMemberName != null) {
            String str6 = r112.peer.guildId;
            Intrinsics.checkNotNullExpressionValue(str6, "abstract.peer.guildId");
            String str7 = r112.peer.peerUid;
            Intrinsics.checkNotNullExpressionValue(str7, "abstract.peer.peerUid");
            if (yp0.a.d(str6, str7)) {
                String str8 = msg2.operatorTinyId;
                Intrinsics.checkNotNullExpressionValue(str8, "msg.operatorTinyId");
                String str9 = r112.peer.guildId;
                Intrinsics.checkNotNullExpressionValue(str9, "abstract.peer.guildId");
                String u16 = iq0.a.u(str8, str9);
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format(l.b(l.f112411a, R.string.f153261bm, null, 2, null).toString(), Arrays.copyOf(new Object[]{r112.sendMemberName}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                return u16 + " " + format2;
            }
            return l.b(l.f112411a, R.string.f153171bd, null, 2, null).toString();
        }
        return "";
    }
}
