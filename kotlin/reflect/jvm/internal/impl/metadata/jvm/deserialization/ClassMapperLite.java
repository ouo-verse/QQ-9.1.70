package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.cache.Entry;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class ClassMapperLite {

    @NotNull
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: kotlin, reason: collision with root package name */
    @NotNull
    private static final String f412757kotlin;

    @NotNull
    private static final Map<String, String> map;

    static {
        List listOf;
        String joinToString$default;
        List listOf2;
        List<String> listOf3;
        List<String> listOf4;
        List<String> listOf5;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'});
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(listOf, "", null, null, 0, null, null, 62, null);
        f412757kotlin = joinToString$default;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Boolean", "Z", "Char", BdhLogUtil.LogTag.Tag_Conn, "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", UserInfo.SEX_FEMALE, "Long", "J", "Double", "D"});
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listOf2.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i3 = 0;
            while (true) {
                StringBuilder sb5 = new StringBuilder();
                String str = f412757kotlin;
                sb5.append(str);
                sb5.append('/');
                sb5.append((String) listOf2.get(i3));
                int i16 = i3 + 1;
                linkedHashMap.put(sb5.toString(), listOf2.get(i16));
                linkedHashMap.put(str + '/' + ((String) listOf2.get(i3)) + Entry.DATA_TYPE_Array, '[' + ((String) listOf2.get(i16)));
                if (i3 == progressionLastElement) {
                    break;
                } else {
                    i3 += 2;
                }
            }
        }
        linkedHashMap.put(f412757kotlin + "/Unit", "V");
        map$lambda$0$add(linkedHashMap, "Any", "java/lang/Object");
        map$lambda$0$add(linkedHashMap, "Nothing", "java/lang/Void");
        map$lambda$0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        listOf3 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Entry.DATA_TYPE_STRING, "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"});
        for (String str2 : listOf3) {
            map$lambda$0$add(linkedHashMap, str2, "java/lang/" + str2);
        }
        listOf4 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"});
        for (String str3 : listOf4) {
            map$lambda$0$add(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            map$lambda$0$add(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        map$lambda$0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        map$lambda$0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        map$lambda$0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i17 = 0; i17 < 23; i17++) {
            StringBuilder sb6 = new StringBuilder();
            String str4 = f412757kotlin;
            sb6.append(str4);
            sb6.append("/jvm/functions/Function");
            sb6.append(i17);
            map$lambda$0$add(linkedHashMap, "Function" + i17, sb6.toString());
            map$lambda$0$add(linkedHashMap, "reflect/KFunction" + i17, str4 + "/reflect/KFunction");
        }
        listOf5 = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", Entry.DATA_TYPE_STRING, "Enum"});
        for (String str5 : listOf5) {
            map$lambda$0$add(linkedHashMap, str5 + ".Companion", f412757kotlin + "/jvm/internal/" + str5 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    ClassMapperLite() {
    }

    private static final void map$lambda$0$add(Map<String, String> map2, String str, String str2) {
        map2.put(f412757kotlin + '/' + str, 'L' + str2 + ';');
    }

    @JvmStatic
    @NotNull
    public static final String mapClass(@NotNull String classId) {
        String replace$default;
        Intrinsics.checkNotNullParameter(classId, "classId");
        String str = map.get(classId);
        if (str == null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append('L');
            replace$default = StringsKt__StringsJVMKt.replace$default(classId, '.', '$', false, 4, (Object) null);
            sb5.append(replace$default);
            sb5.append(';');
            return sb5.toString();
        }
        return str;
    }
}
