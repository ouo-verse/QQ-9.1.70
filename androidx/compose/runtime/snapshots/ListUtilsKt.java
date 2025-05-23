package androidx.compose.runtime.snapshots;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002\u00a2\u0006\u0002\u0010\t\u001a;\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\u0080\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a;\u0010\u000e\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\u0080\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aV\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2'\u0010\r\u001a#\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0010H\u0080\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a;\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\u0080\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aA\u0010\u0017\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0010H\u0080\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aS\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f0\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001a0\u0007H\u0080\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a}\u0010\u001c\u001a\u0002H\u001d\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u001d*\u00060\u0003j\u0002`\u0004*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\u001e\u001a\u0002H\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002\u00a2\u0006\u0002\u0010$\u001ab\u0010%\u001a\u00020&\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0000\u001aG\u0010'\u001a\b\u0012\u0004\u0012\u0002H(0\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H(0\u0007H\u0080\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aI\u0010)\u001a\b\u0012\u0004\u0012\u0002H(0\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H(0\u0007H\u0080\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a\u001e\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00020+\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006,"}, d2 = {"appendElement", "", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", DTConstants.TAG.ELEMENT, "transform", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastAll", "", "", "predicate", "fastAny", "fastFilterIndexed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "fastForEach", "action", "fastForEachIndexed", "fastGroupBy", "", "K", "keySelector", "fastJoinTo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "buffer", "separator", "prefix", "postfix", "limit", "truncated", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "fastJoinToString", "", "fastMap", BdhLogUtil.LogTag.Tag_Req, "fastMapNotNull", "fastToSet", "", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class ListUtilsKt {
    public static final <T> boolean fastAll(List<? extends T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!predicate.invoke(list.get(i3)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean fastAny(List<? extends T> list, Function1<? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (predicate.invoke(list.get(i3)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final <T> List<T> fastFilterIndexed(List<? extends T> list, Function2<? super Integer, ? super T, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            T t16 = list.get(i3);
            if (predicate.invoke(Integer.valueOf(i3), t16).booleanValue()) {
                arrayList.add(t16);
            }
        }
        return arrayList;
    }

    public static final <T> void fastForEach(List<? extends T> list, Function1<? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            action.invoke(list.get(i3));
        }
    }

    public static final <T> void fastForEachIndexed(List<? extends T> list, Function2<? super Integer, ? super T, Unit> action) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            action.invoke(Integer.valueOf(i3), list.get(i3));
        }
    }

    public static final <T, K> Map<K, List<T>> fastGroupBy(List<? extends T> list, Function1<? super T, ? extends K> keySelector) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(keySelector, "keySelector");
        HashMap hashMap = new HashMap(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            T t16 = list.get(i3);
            K invoke = keySelector.invoke(t16);
            Object obj = hashMap.get(invoke);
            if (obj == null) {
                obj = new ArrayList();
                hashMap.put(invoke, obj);
            }
            ((ArrayList) obj).add(t16);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T, A extends Appendable> A fastJoinTo(List<? extends T> list, A a16, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        a16.append(charSequence2);
        int size = list.size();
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            T t16 = list.get(i17);
            i16++;
            if (i16 > 1) {
                a16.append(charSequence);
            }
            if (i3 >= 0 && i16 > i3) {
                break;
            }
            appendElement(a16, t16, function1);
        }
        if (i3 >= 0 && i16 > i3) {
            a16.append(charSequence4);
        }
        a16.append(charSequence3);
        return a16;
    }

    public static final <T> String fastJoinToString(List<? extends T> list, CharSequence separator, CharSequence prefix, CharSequence postfix, int i3, CharSequence truncated, Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        Intrinsics.checkNotNullParameter(truncated, "truncated");
        String sb5 = ((StringBuilder) fastJoinTo(list, new StringBuilder(), separator, prefix, postfix, i3, truncated, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "fastJoinTo(StringBuilder\u2026form)\n        .toString()");
        return sb5;
    }

    public static final <T, R> List<R> fastMap(List<? extends T> list, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add(transform.invoke(list.get(i3)));
        }
        return arrayList;
    }

    public static final <T, R> List<R> fastMapNotNull(List<? extends T> list, Function1<? super T, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            R invoke = transform.invoke(list.get(i3));
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    public static final <T> Set<T> fastToSet(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        HashSet hashSet = new HashSet(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            hashSet.add(list.get(i3));
        }
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> void appendElement(Appendable appendable, T t16, Function1<? super T, ? extends CharSequence> function1) {
        if (function1 != null) {
            appendable.append(function1.invoke(t16));
            return;
        }
        if (t16 == 0 ? true : t16 instanceof CharSequence) {
            appendable.append((CharSequence) t16);
        } else if (t16 instanceof Character) {
            appendable.append(((Character) t16).charValue());
        } else {
            appendable.append(String.valueOf(t16));
        }
    }

    public static /* synthetic */ String fastJoinToString$default(List list, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i3, CharSequence charSequence4, Function1 function1, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i16 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i16 & 4) == 0 ? charSequence3 : "";
        if ((i16 & 8) != 0) {
            i3 = -1;
        }
        int i17 = i3;
        if ((i16 & 16) != 0) {
            charSequence4 = MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        CharSequence charSequence7 = charSequence4;
        if ((i16 & 32) != 0) {
            function1 = null;
        }
        return fastJoinToString(list, charSequence, charSequence5, charSequence6, i17, charSequence7, function1);
    }
}
