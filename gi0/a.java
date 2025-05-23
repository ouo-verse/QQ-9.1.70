package gi0;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lgi0/a;", "", "", "originAddress", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f402075a = new a();

    a() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0029, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(String originAddress) {
        String replace$default;
        List split$default;
        List split$default2;
        CharSequence trim;
        CharSequence trim2;
        CharSequence trim3;
        CharSequence trim4;
        CharSequence trim5;
        replace$default = StringsKt__StringsJVMKt.replace$default(originAddress, ",", "\n", false, 4, (Object) null);
        split$default = StringsKt__StringsKt.split$default((CharSequence) replace$default, new String[]{"\n"}, false, 0, 6, (Object) null);
        Iterator it = split$default.iterator();
        String str = "";
        String str2 = "";
        String str3 = str2;
        String str4 = str3;
        while (true) {
            if (it.hasNext()) {
                split$default2 = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{":"}, false, 0, 6, (Object) null);
                if (split$default2.size() == 2) {
                    String str5 = (String) split$default2.get(0);
                    if (str5 != null) {
                        trim = StringsKt__StringsKt.trim((CharSequence) str5);
                        String obj = trim.toString();
                        switch (obj.hashCode()) {
                            case 26039849:
                                if (obj.equals("\u6536\u8d27\u4eba")) {
                                    String str6 = (String) split$default2.get(1);
                                    if (str6 != null) {
                                        trim2 = StringsKt__StringsKt.trim((CharSequence) str6);
                                        str = trim2.toString();
                                        break;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                } else {
                                    continue;
                                }
                            case 771458290:
                                if (obj.equals("\u6240\u5728\u5730\u533a")) {
                                    String str7 = (String) split$default2.get(1);
                                    if (str7 != null) {
                                        trim3 = StringsKt__StringsKt.trim((CharSequence) str7);
                                        str3 = trim3.toString();
                                        break;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                } else {
                                    continue;
                                }
                            case 775723385:
                                if (obj.equals("\u624b\u673a\u53f7\u7801")) {
                                    String str8 = (String) split$default2.get(1);
                                    if (str8 != null) {
                                        trim4 = StringsKt__StringsKt.trim((CharSequence) str8);
                                        str2 = trim4.toString();
                                        break;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                } else {
                                    continue;
                                }
                            case 1098837424:
                                if (obj.equals("\u8be6\u7ec6\u5730\u5740")) {
                                    String str9 = (String) split$default2.get(1);
                                    if (str9 != null) {
                                        trim5 = StringsKt__StringsKt.trim((CharSequence) str9);
                                        str4 = trim5.toString();
                                        break;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                } else {
                                    continue;
                                }
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
            } else {
                if (!(str.length() > 0)) {
                    return originAddress;
                }
                if (!(str2.length() > 0)) {
                    return originAddress;
                }
                if (!(str3.length() > 0)) {
                    return originAddress;
                }
                if (!(str4.length() > 0)) {
                    return originAddress;
                }
                return str + TokenParser.SP + str2 + TokenParser.SP + str3 + TokenParser.SP + str4;
            }
        }
    }
}
