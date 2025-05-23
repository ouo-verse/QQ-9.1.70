package iu1;

import android.text.TextUtils;
import com.tencent.guild.aio.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.CalendarElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0018\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006 "}, d2 = {"Liu1/b;", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstract;", "abstract", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstractElement;", "msg", "", "selfTinyId", "", "a", ReportConstant.COSTREPORT_PREFIX, "p", "g", "t", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "u", "d", DomainData.DOMAIN_NAME, h.F, "l", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "o", "k", "e", "c", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f408754a = new b();

    b() {
    }

    private final CharSequence a(MsgAbstract r36, MsgAbstractElement msg2, String selfTinyId) {
        int i3 = msg2.elementType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 25) {
                        switch (i3) {
                            case 5:
                                return t(msg2);
                            case 6:
                                return f(msg2);
                            case 7:
                                return q(msg2);
                            case 8:
                                return j(r36, msg2, selfTinyId);
                            case 9:
                                return u(msg2);
                            case 10:
                                return d(msg2);
                            case 11:
                                return n(msg2);
                            case 12:
                                return l(msg2);
                            case 13:
                                return r(msg2);
                            case 14:
                                return m(r36);
                            case 15:
                                return i(msg2);
                            case 16:
                                return o(msg2);
                            case 17:
                                return k(msg2);
                            case 18:
                                return h(r36, selfTinyId);
                            case 19:
                                return e(msg2);
                            default:
                                String str = msg2.content;
                                if (str == null) {
                                    return "";
                                }
                                return str;
                        }
                    }
                    return c(msg2);
                }
                return g(msg2);
            }
            return p(msg2);
        }
        return s(msg2);
    }

    private final String c(MsgAbstractElement msg2) {
        String str = msg2.content;
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String d(MsgAbstractElement msg2) {
        try {
            if (msg2.customContent != null) {
                String promptText = new JSONObject(msg2.customContent).optString("prompt");
                if (TextUtils.isEmpty(promptText)) {
                    promptText = MobileQQ.sMobileQQ.getString(R.string.f170467s2);
                }
                Intrinsics.checkNotNullExpressionValue(promptText, "promptText");
                return promptText;
            }
            return "";
        } catch (JSONException e16) {
            QLog.i("GuildLastMsgDecoder", 1, "decoder failed, msg = " + e16.getMessage());
            return "";
        }
    }

    private final String e(MsgAbstractElement msg2) {
        String str;
        Logger.a d16 = Logger.f235387a.d();
        CalendarElement calendarElement = msg2.calendarElement;
        String str2 = null;
        if (calendarElement != null) {
            str = calendarElement.f359317msg;
        } else {
            str = null;
        }
        d16.i("Calendar", 1, "getCalendarContent:" + str);
        CalendarElement calendarElement2 = msg2.calendarElement;
        if (calendarElement2 != null) {
            str2 = calendarElement2.f359317msg;
        }
        if (str2 == null) {
            String str3 = msg2.content;
            Intrinsics.checkNotNullExpressionValue(str3, "msg.content");
            return str3;
        }
        return str2;
    }

    private final String f(MsgAbstractElement msg2) {
        String obj;
        QLog.i("GuildLastMsgDecoder", 4, "getFaceContent type=" + msg2.elementSubType + " emojiId=" + msg2.index);
        Integer num = msg2.index;
        Intrinsics.checkNotNullExpressionValue(num, "msg.index");
        if (num.intValue() < 0 || msg2.elementSubType == null || msg2.index == null) {
            return "";
        }
        IQQGuildEmojiApi iQQGuildEmojiApi = (IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class);
        Integer num2 = msg2.elementSubType;
        Intrinsics.checkNotNullExpressionValue(num2, "msg.elementSubType");
        int intValue = num2.intValue();
        Integer num3 = msg2.index;
        Intrinsics.checkNotNullExpressionValue(num3, "msg.index");
        CharSequence fetchEmoSpan = iQQGuildEmojiApi.fetchEmoSpan(intValue, num3.intValue());
        if (fetchEmoSpan == null || (obj = fetchEmoSpan.toString()) == null) {
            return "";
        }
        return obj;
    }

    private final String g(MsgAbstractElement msg2) {
        String str = msg2.content;
        if (str == null) {
            str = "";
        }
        return str + msg2.fileName;
    }

    private final String h(MsgAbstract r46, String selfTinyId) {
        Iterator<MsgAbstractElement> it = r46.elements.iterator();
        while (it.hasNext()) {
            MsgAbstractElement next = it.next();
            if (next.elementType == 18 && next.textGiftElement != null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("\u9001");
                sb5.append(next.textGiftElement.giftName);
                sb5.append("\u7ed9");
                if (Intrinsics.areEqual(String.valueOf(next.textGiftElement.receiverUin), selfTinyId)) {
                    sb5.append("\u4f60");
                } else {
                    sb5.append(next.textGiftElement.receiverNick);
                }
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "content.toString()");
                return sb6;
            }
        }
        return "";
    }

    private final String i(MsgAbstractElement msg2) {
        String str = msg2.content;
        if (str == null) {
            return "";
        }
        return str;
    }

    private final CharSequence j(MsgAbstract r85, MsgAbstractElement msg2, String selfTinyId) {
        Integer num = msg2.elementSubType;
        if (num != null && num.intValue() == 1) {
            return a.f408753a.h(r85, msg2, selfTinyId);
        }
        if (num != null && num.intValue() == 3) {
            return a.f408753a.c(r85, msg2, selfTinyId);
        }
        if (num != null && num.intValue() == 7) {
            return a.f408753a.e(r85, msg2, selfTinyId);
        }
        if (num != null && num.intValue() == 6) {
            return a.f408753a.f(r85, msg2, selfTinyId);
        }
        if (num != null && num.intValue() == 12) {
            return a.f408753a.d(r85, msg2, selfTinyId);
        }
        if (num != null && num.intValue() == 2) {
            return a.f408753a.g(r85, msg2, selfTinyId);
        }
        if (num == null || num.intValue() != 13) {
            return "";
        }
        Integer num2 = msg2.localGrayTipType;
        if (num2 != null && num2.intValue() == 2) {
            return l.b(l.f112411a, R.string.f1629521t, null, 2, null).toString();
        }
        if (num2 != null && num2.intValue() == 1) {
            return l.b(l.f112411a, R.string.f1629121p, null, 2, null).toString();
        }
        if (num2 != null && num2.intValue() == 3) {
            return l.b(l.f112411a, R.string.f1629321r, null, 2, null).toString();
        }
        if (num2 != null && num2.intValue() == 4) {
            return l.b(l.f112411a, R.string.f1629421s, null, 2, null).toString();
        }
        if (num2 != null && num2.intValue() == 6) {
            l lVar = l.f112411a;
            CharSequence b16 = l.b(lVar, R.string.f139340b0, null, 2, null);
            CharSequence b17 = l.b(lVar, R.string.f139330az, null, 2, null);
            StringBuilder sb5 = new StringBuilder();
            sb5.append((Object) b16);
            sb5.append((Object) b17);
            return sb5.toString();
        }
        if (num2 != null && num2.intValue() == 7) {
            l lVar2 = l.f112411a;
            CharSequence b18 = l.b(lVar2, R.string.f1505515a, null, 2, null);
            CharSequence b19 = l.b(lVar2, R.string.f1505415_, null, 2, null);
            StringBuilder sb6 = new StringBuilder();
            sb6.append((Object) b18);
            sb6.append((Object) b19);
            return sb6.toString();
        }
        if (num2 != null && num2.intValue() == 8) {
            return l.b(l.f112411a, R.string.f1629021o, null, 2, null);
        }
        if (num2 == null || num2.intValue() != 9) {
            return "";
        }
        return l.b(l.f112411a, R.string.f1629221q, null, 2, null);
    }

    private final String k(MsgAbstractElement msg2) {
        String str = msg2.content;
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String l(MsgAbstractElement msg2) {
        String str = msg2.content;
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String m(MsgAbstract r46) {
        Iterator<MsgAbstractElement> it = r46.elements.iterator();
        while (it.hasNext()) {
            MsgAbstractElement element = it.next();
            if (element.elementType == 14) {
                fq0.a aVar = fq0.a.f400309a;
                Intrinsics.checkNotNullExpressionValue(element, "element");
                return aVar.p(element);
            }
        }
        return "";
    }

    private final String n(MsgAbstractElement msg2) {
        String str = msg2.content;
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String o(MsgAbstractElement msg2) {
        String str = msg2.content;
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String p(MsgAbstractElement msg2) {
        String str = msg2.content;
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String q(MsgAbstractElement msg2) {
        return "";
    }

    private final String r(MsgAbstractElement msg2) {
        String str = msg2.content;
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String s(MsgAbstractElement msg2) {
        String str = msg2.content;
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String t(MsgAbstractElement msg2) {
        String str = msg2.content;
        if (str == null) {
            return "";
        }
        return str;
    }

    private final String u(MsgAbstractElement msg2) {
        String str = msg2.content;
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final CharSequence b(@NotNull MsgAbstract r56, @NotNull String selfTinyId) {
        Object first;
        Intrinsics.checkNotNullParameter(r56, "abstract");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        ArrayList<MsgAbstractElement> arrayList = r56.elements;
        String str = "";
        if (arrayList != null && !arrayList.isEmpty()) {
            if (c.a(r56, r56)) {
                return m(r56);
            }
            if (c.b(r56, r56)) {
                return h(r56, selfTinyId);
            }
            if (r56.elements.size() == 1) {
                ArrayList<MsgAbstractElement> arrayList2 = r56.elements;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "abstract.elements");
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
                Intrinsics.checkNotNullExpressionValue(first, "abstract.elements.first()");
                return a(r56, (MsgAbstractElement) first, selfTinyId);
            }
            Iterator<MsgAbstractElement> it = r56.elements.iterator();
            while (it.hasNext()) {
                MsgAbstractElement element = it.next();
                Intrinsics.checkNotNullExpressionValue(element, "element");
                str = str + ((Object) a(r56, element, selfTinyId));
            }
        }
        return str;
    }
}
