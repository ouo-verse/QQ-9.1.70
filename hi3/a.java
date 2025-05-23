package hi3;

import com.tencent.biz.subscribe.comment.o;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lhi3/a;", "Lgi3/a;", "", "emoGroup", "", "emoCode", "V0", "U0", "otherEmoString", "q0", "<init>", "()V", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements gi3.a {
    private final int U0(String emoGroup, int emoCode) {
        int localIdFromEMCode = QQEmojiUtil.getLocalIdFromEMCode(emoGroup);
        return localIdFromEMCode == -1 ? QQEmojiUtil.getEmojiLocalId(emoCode) : localIdFromEMCode;
    }

    private final int V0(String emoGroup, int emoCode) {
        int localIdFromEMCode = QQSysFaceUtil.getLocalIdFromEMCode(emoGroup);
        return localIdFromEMCode == -1 ? QQSysFaceUtil.convertToLocal(emoCode) : localIdFromEMCode;
    }

    @Override // gi3.a
    public String q0(String otherEmoString) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(otherEmoString, "otherEmoString");
        Matcher matcher = o.f96044o.matcher(otherEmoString);
        String str = otherEmoString;
        while (matcher.find()) {
            String emoGroup = matcher.group();
            QLog.i("ZEmoImpl", 2, "decodeOtherEmoCodeToLocal  emoGroup = " + emoGroup + " otherEmoString = " + otherEmoString);
            StringBuilder sb5 = new StringBuilder();
            int length = emoGroup.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = emoGroup.charAt(i3);
                if ('0' <= charAt && charAt < ':') {
                    sb5.append(charAt);
                }
            }
            QLog.i("ZEmoImpl", 2, "decodeOtherEmoCodeToLocal emoGroup = " + emoGroup + " codeSb = " + ((Object) sb5));
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "codeSb.toString()");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(sb6);
            if (intOrNull != null) {
                int intValue = intOrNull.intValue();
                int V0 = V0(emoGroup, intValue);
                if (V0 != -1) {
                    Intrinsics.checkNotNullExpressionValue(emoGroup, "emoGroup");
                    String faceString = QQSysFaceUtil.getFaceString(V0);
                    Intrinsics.checkNotNullExpressionValue(faceString, "getFaceString(localId)");
                    str = StringsKt__StringsJVMKt.replace$default(str, emoGroup, faceString, false, 4, (Object) null);
                } else {
                    int U0 = U0(emoGroup, intValue);
                    if (U0 != -1) {
                        Intrinsics.checkNotNullExpressionValue(emoGroup, "emoGroup");
                        str = StringsKt__StringsJVMKt.replace$default(str, emoGroup, String.valueOf(QQEmojiUtil.getEmojiUnicode(U0)), false, 4, (Object) null);
                    }
                }
            }
        }
        return str;
    }
}
