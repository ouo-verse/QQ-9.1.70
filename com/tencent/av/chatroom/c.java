package com.tencent.av.chatroom;

import android.text.TextUtils;
import com.tencent.av.n;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSBottomDynamicGuideEvent;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.luggage.wxa.gf.d0;
import com.tencent.luggage.wxa.nf.i;
import com.tencent.luggage.wxa.rf.f;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.luggage.wxa.rf.h;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.view.FilterEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f73531a = {"/\u5de6\u4eb2\u4eb2", "/\u53f3\u4eb2\u4eb2", "/\u5618", "/\u6d41\u6cea", "/\u6253call", "/\u53d8\u5f62", "/\u4ed4\u7ec6\u5206\u6790", "/\u83dc\u6c6a", "/\u5d07\u62dc", "/\u6bd4\u5fc3", "/\u5e86\u795d", "/\u5403\u7cd6", "/\u60ca\u5413", "/\u82b1\u6735\u8138", "/\u6211\u60f3\u5f00\u4e86", "/\u8214\u5c4f", "/\u6253\u62db\u547c", "/\u9178Q", "/\u6211\u65b9\u4e86", "/\u5927\u6028\u79cd", "/\u7ea2\u5305\u591a\u591a", "/\u4f60\u771f\u68d2\u68d2", "/\u6233\u4e00\u6233", "/\u592a\u9633", "/\u6708\u4eae", "/\u6572\u6572", "/\u575a\u5f3a", "/\u8d34\u8d34", "/\u7565\u7565\u7565", "/\u7bee\u7403", "/\u751f\u6c14", "/\u86cb\u7cd5", "/\u97ad\u70ae", "/\u70df\u82b1", "/\u7eed\u6807\u8bc6", "/\u5212\u9f99\u821f", "/\u9f99\u5e74\u5feb\u4e50", "/\u6c42\u653e\u8fc7", "/\u5077\u611f", "/\u73a9\u706b", "/\u706b\u8f66", "/\u8111\u9614\u75bc", "/\u6ca7\u6851", "/\u6342\u8138", "/\u8fa3\u773c\u775b", "/\u54e6\u54df", "/\u5934\u79c3", "/\u95ee\u53f7\u8138", "/\u6697\u4e2d\u89c2\u5bdf", "/emm", "/\u5403\u74dc", "/\u5475\u5475\u54d2", "/\u6c6a\u6c6a", "/\u55b5\u55b5", "/\u725b\u6c14\u51b2\u5929", "/\u65e0\u773c\u7b11", "/\u656c\u793c", "/\u72c2\u7b11", "/\u9762\u65e0\u8868\u60c5", "/\u6478\u9c7c", "/\u6478\u9526\u9ca4", "/\u9b54\u9b3c\u7b11", "/\u54e6", "/\u7741\u773c", "/\u671f\u5f85", "/\u62dc\u8c22", "/\u5143\u5b9d", "/\u725b\u554a", "/\u80d6\u4e09\u65a4", "/\u5acc\u5f03", "/\u4e3e\u724c\u724c", "/\u8c79\u5bcc", "/\u62dc\u6258", "/\u8036", "/666", "/\u5c0a\u561f\u5047\u561f", "/\u54a6", "/\u88c2\u5f00", "/\u864e\u864e\u751f\u5a01", "/\u5927\u5c55\u5b8f\u5154", "/\u53f3\u62dc\u5e74", "/\u5de6\u62dc\u5e74", "/\u62ff\u5230\u7ea2\u5305", "/\u6211\u9178\u4e86", "/\u6536\u5230"};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f73532b = {36, 36, 11, 9, 311, 312, 314, 317, 318, 319, 320, 324, 325, 337, 338, 339, 341, com.tencent.mm.plugin.appbrand.jsapi.coverview.a.CTRL_INDEX, d0.CTRL_INDEX, com.tencent.luggage.wxa.fe.a.CTRL_INDEX, 345, 346, 173, 75, 68, 351, 349, ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID, com.tencent.luggage.wxa.v1.b.CTRL_INDEX, 92, 326, 59, 109, 333, 424, 415, QFSBottomDynamicGuideEvent.DYNAMIC_GUIDE_BUTTON_TYPE, 425, 427, PlayUI.UIType.BIG_CARD_SHAPED_PIC, 419, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 277, 307, 306, FilterEnum.MIC_PTU_TRANS_KONGCHENG, FilterEnum.MIC_PTU_BAIXI, 283, 284, 285, 293, 286, 287, FilterEnum.MIC_PTU_ZIRAN, 294, 297, 298, 299, 300, 323, 332, 336, h.CTRL_INDEX, 355, 356, f.CTRL_INDEX, g.CTRL_INDEX, 357, 334, i.CTRL_INDEX, 303, 302, 295, 273, 428};

    /* renamed from: c, reason: collision with root package name */
    public static int f73533c = 0;

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.indexOf("/") == -1) {
            return str;
        }
        int i3 = 0;
        int i16 = 0;
        while (true) {
            try {
                String[] strArr = EmotcationConstants.SYS_EMOTICON_SYMBOL;
                if (i16 >= strArr.length) {
                    break;
                }
                String str2 = (char) 20 + strArr[i16];
                if (str.indexOf(str2) != -1) {
                    str = str.replace(str2, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i16));
                }
                i16++;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("ChatRoomUtil", 2, "convertMsg exception", e16);
                }
            }
        }
        int i17 = 0;
        while (true) {
            String[] strArr2 = EmotcationConstants.SYS_EMOTICON_SYMBOL;
            if (i17 >= strArr2.length) {
                break;
            }
            String str3 = strArr2[i17];
            if (str.indexOf(str3) != -1) {
                str = str.replace(str3, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i17));
            }
            i17++;
        }
        int i18 = 0;
        while (true) {
            String[] strArr3 = f73531a;
            if (i18 >= strArr3.length) {
                break;
            }
            String str4 = (char) 20 + strArr3[i18];
            if (str.indexOf(str4) != -1) {
                int i19 = f73532b[i18];
                str = str.replace(str4, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i19));
                QLog.d("avemoji", 1, "replase 0x14 mapIndex=" + i19 + " symbol=" + str4);
            }
            i18++;
        }
        while (true) {
            String[] strArr4 = f73531a;
            if (i3 >= strArr4.length) {
                break;
            }
            String str5 = strArr4[i3];
            if (str.indexOf(str5) != -1) {
                int i26 = f73532b[i3];
                str = str.replace(str5, com.tencent.mobileqq.text.TextUtils.getSysEmotcationString(i26));
                QLog.d("avemoji", 1, "replase mapIndex=" + i26 + " symbol=" + str5);
            }
            i3++;
        }
        return str;
    }

    public static String b(QQTextBuilder qQTextBuilder) {
        String d16;
        if (qQTextBuilder == null) {
            return null;
        }
        int length = qQTextBuilder.length();
        char[] cArr = new char[length];
        int i3 = 0;
        qQTextBuilder.getChars(0, length, cArr, 0);
        StringBuilder sb5 = new StringBuilder();
        EmoticonSpan[] emoticonSpanArr = (EmoticonSpan[]) qQTextBuilder.getSpans(0, length, EmoticonSpan.class);
        if (emoticonSpanArr != null && emoticonSpanArr.length > 0) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(cArr);
            ArrayList arrayList = new ArrayList(emoticonSpanArr.length);
            for (EmoticonSpan emoticonSpan : emoticonSpanArr) {
                if (emoticonSpan != null) {
                    arrayList.add(d.a(emoticonSpan, qQTextBuilder.getSpanStart(emoticonSpan), qQTextBuilder.getSpanEnd(emoticonSpan)));
                }
            }
            Collections.sort(arrayList, d.f73537h);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                d dVar = (d) it.next();
                EmoticonSpan emoticonSpan2 = dVar.f73538a;
                int i16 = dVar.f73539b;
                int i17 = dVar.f73540c;
                int i18 = emoticonSpan2.emojiType;
                if (i18 != 1) {
                    if (i18 != 2) {
                        d16 = sb6.substring(i16, i17);
                    } else {
                        d16 = (char) 20 + emoticonSpan2.getDescription();
                    }
                } else {
                    d16 = d(emoticonSpan2.index & Integer.MAX_VALUE);
                }
                if (i3 < i16) {
                    sb5.append(sb6.substring(i3, i16));
                }
                sb5.append(d16);
                i3 = i17;
            }
            if (i3 < sb6.length()) {
                sb5.append(sb6.substring(i3));
            }
            d.c(arrayList);
        } else {
            sb5.append(cArr);
        }
        return sb5.toString();
    }

    public static QQText c(String str, int i3) {
        return new QQText(a(str), 3, i3);
    }

    public static String d(int i3) {
        if (i3 >= 0) {
            String[] strArr = EmotcationConstants.SYS_EMOTICON_SYMBOL;
            if (i3 < strArr.length) {
                return (char) 20 + strArr[i3];
            }
        }
        return "";
    }

    public static void e(String str) {
        int i3 = n.e().f().f73035i;
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomUtil", 2, String.format("doReport, tag[%s], fromType[%s]", str, Integer.valueOf(i3)));
        }
        ReportController.o(null, "dc00898", "", "", str, str, i3, 0, "", "", "", "");
    }
}
