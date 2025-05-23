package hd1;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "", "b", "", "e", "c", "a", "d", "qq-gamecenter-msg-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {
    @NotNull
    public static final String a(@NotNull MsgRecord msgRecord) {
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        Iterator<MsgElement> it = msgRecord.elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            ArkElement arkElement = next.arkElement;
            boolean z17 = false;
            if (arkElement != null && (str = arkElement.bytesData) != null) {
                if (str.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = true;
                }
            }
            if (z17) {
                try {
                    ArkElement arkElement2 = next.arkElement;
                    Intrinsics.checkNotNull(arkElement2);
                    String prompt = new JSONObject(arkElement2.bytesData).optString("prompt");
                    if (!TextUtils.isEmpty(prompt)) {
                        Intrinsics.checkNotNullExpressionValue(prompt, "prompt");
                        return prompt;
                    }
                    continue;
                } catch (Exception e16) {
                    QLog.e("GameMsgRecordExt", 4, String.valueOf(e16));
                }
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[LOOP:0: B:4:0x0014->B:21:?, LOOP_END, SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String b(@NotNull MsgRecord msgRecord) {
        boolean z16;
        String str;
        boolean z17;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        boolean z18 = true;
        if (e(msgRecord)) {
            Iterator<MsgElement> it = msgRecord.elements.iterator();
            while (it.hasNext()) {
                MsgElement next = it.next();
                TextElement textElement = next.textElement;
                if (textElement != null && (str = textElement.content) != null) {
                    if (str.length() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        z16 = true;
                        if (!z16) {
                            String str2 = next.textElement.content;
                            Intrinsics.checkNotNullExpressionValue(str2, "element.textElement.content");
                            return str2;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            return "";
        }
        if (c(msgRecord)) {
            String a16 = a(msgRecord);
            if (a16.length() <= 0) {
                z18 = false;
            }
            if (z18) {
                return a16;
            }
            return "";
        }
        if (d(msgRecord)) {
            return "\u56fe\u7247";
        }
        return "";
    }

    public static final boolean c(@NotNull MsgRecord msgRecord) {
        ArrayList<MsgElement> elements;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 11 || (elements = msgRecord.elements) == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (((MsgElement) it.next()).elementType != 10) {
                return false;
            }
        }
        return true;
    }

    public static final boolean d(@NotNull MsgRecord msgRecord) {
        ArrayList<MsgElement> arrayList;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 2 || (arrayList = msgRecord.elements) == null || arrayList.size() != 1) {
            return false;
        }
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (((MsgElement) it.next()).elementType == 2) {
                return true;
            }
        }
        return false;
    }

    public static final boolean e(@NotNull MsgRecord msgRecord) {
        ArrayList<MsgElement> elements;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 2 || (elements = msgRecord.elements) == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            int i3 = ((MsgElement) it.next()).elementType;
            if (i3 != 6 && i3 != 1) {
                return false;
            }
        }
        return true;
    }
}
