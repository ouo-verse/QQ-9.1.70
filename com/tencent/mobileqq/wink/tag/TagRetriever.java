package com.tencent.mobileqq.wink.tag;

import android.content.Intent;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.model.b;
import com.tencent.mobileqq.wink.preprocess.m;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0006\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\b\u001a\u00020\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\u0010\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\tJ\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\u0011\u001a\u00020\u0003J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007J \u0010\u0016\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/tag/TagRetriever;", "", "", "", "tag", "", "b", "Landroid/content/Intent;", "intent", "", "e", "i", "", h.F, "f", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "g", "input", "d", "c", "j", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TagRetriever {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TagRetriever f326413a = new TagRetriever();

    TagRetriever() {
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void b(List<String> list, String str) {
        boolean z16;
        List<String> split$default;
        boolean isBlank;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"#"}, false, 0, 6, (Object) null);
                    a(list, split$default);
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
    
        r6 = kotlin.collections.CollectionsKt___CollectionsKt.distinct(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@NotNull List<String> list, @Nullable List<String> list2) {
        List distinct;
        CharSequence trim;
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list2 != null && distinct != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = distinct.iterator();
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                trim = StringsKt__StringsKt.trim((CharSequence) next);
                if (trim.toString().length() <= 0) {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (!list.contains((String) obj)) {
                    arrayList2.add(obj);
                }
            }
            list.addAll(arrayList2);
        }
    }

    @NotNull
    public final List<String> c(@NotNull String input) {
        Sequence map;
        List<String> list;
        Intrinsics.checkNotNullParameter(input, "input");
        map = SequencesKt___SequencesKt.map(Regex.findAll$default(new Regex("[a-zA-Z0-9\\u4e00-\\u9fa5\uff0c]+"), input, 0, 2, null), new Function1<MatchResult, String>() { // from class: com.tencent.mobileqq.wink.tag.TagRetriever$extractTags$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(@NotNull MatchResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getValue();
            }
        });
        list = SequencesKt___SequencesKt.toList(map);
        return list;
    }

    @NotNull
    public final String d(@NotNull String input) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(input, "input");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(c(input), ",", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    @NotNull
    public final List<String> e(@NotNull Intent intent) {
        HashMap hashMap;
        List<String> list;
        HashMap hashMap2;
        List<String> list2;
        List<String> list3;
        boolean isBlank;
        ArrayList arrayListOf;
        int collectionSizeOrDefault;
        List split$default;
        String str;
        Intrinsics.checkNotNullParameter(intent, "intent");
        ArrayList arrayList = new ArrayList();
        b(arrayList, intent.getStringExtra("QQWinkDataKeys-tag_name"));
        b(arrayList, intent.getStringExtra(QQWinkConstants.CAPTURE_MATERIAL_TOPIC));
        Serializable serializableExtra = intent.getSerializableExtra("key_attrs");
        List<String> list4 = null;
        if (serializableExtra instanceof HashMap) {
            hashMap = (HashMap) serializableExtra;
        } else {
            hashMap = null;
        }
        if (hashMap != null && (str = (String) hashMap.get("tag")) != null) {
            list = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"#"}, false, 0, 6, (Object) null);
        } else {
            list = null;
        }
        a(arrayList, list);
        Serializable serializableExtra2 = intent.getSerializableExtra(WinkHostConstants.QAlbumConstants.selectedMediaInfoHashMap());
        if (serializableExtra2 instanceof HashMap) {
            hashMap2 = (HashMap) serializableExtra2;
        } else {
            hashMap2 = null;
        }
        if (hashMap2 != null) {
            ArrayList<String> arrayList2 = new ArrayList();
            Iterator it = hashMap2.entrySet().iterator();
            while (it.hasNext()) {
                ArrayList<String> arrayList3 = ((LocalMediaInfo) ((Map.Entry) it.next()).getValue()).mHashTagList;
                Intrinsics.checkNotNullExpressionValue(arrayList3, "it.value.mHashTagList");
                CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList3);
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
            for (String it5 : arrayList2) {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                split$default = StringsKt__StringsKt.split$default((CharSequence) it5, new String[]{"#"}, false, 0, 6, (Object) null);
                arrayList4.add(split$default);
            }
            list2 = CollectionsKt__IterablesKt.flatten(arrayList4);
        } else {
            list2 = null;
        }
        a(arrayList, list2);
        String stringExtra = intent.getStringExtra(QQWinkConstants.PUBLISH_MUSIC_TAG);
        if (stringExtra != null) {
            list3 = StringsKt__StringsKt.split$default((CharSequence) stringExtra, new String[]{"#"}, false, 0, 6, (Object) null);
        } else {
            list3 = null;
        }
        a(arrayList, list3);
        String f16 = m.f();
        if (f16 != null) {
            list4 = StringsKt__StringsKt.split$default((CharSequence) f16, new String[]{"#"}, false, 0, 6, (Object) null);
        }
        a(arrayList, list4);
        b(arrayList, i(intent));
        Pair<String, Boolean> b16 = b.f324006a.b();
        if (b16 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(b16.getFirst());
            if ((!isBlank) && b16.getSecond().booleanValue()) {
                QLog.d("TagRetriever", 1, "addChallengeTopic... " + ((Object) b16.getFirst()));
                TagRetriever tagRetriever = f326413a;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(b16.getFirst());
                tagRetriever.a(arrayList, arrayListOf);
            }
        }
        return arrayList;
    }

    @NotNull
    public final String f(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return g(e(intent));
    }

    @NotNull
    public final String g(@NotNull List<String> tags) {
        String joinToString$default;
        Intrinsics.checkNotNullParameter(tags, "tags");
        if (!tags.isEmpty()) {
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(tags, " #", "#", " ", 0, null, null, 56, null);
            return joinToString$default;
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long h(@Nullable Intent intent) {
        Serializable serializable;
        Long longOrNull;
        HashMap hashMap = null;
        if (intent != null) {
            serializable = intent.getSerializableExtra("key_attrs");
        } else {
            serializable = null;
        }
        if (serializable instanceof HashMap) {
            hashMap = (HashMap) serializable;
        }
        if (hashMap != null && (r3 = (String) hashMap.get(QCircleScheme.AttrQQPublish.CHALLENGE_NUMS)) != null && longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    @Nullable
    public final String i(@Nullable Intent intent) {
        Serializable serializable;
        HashMap hashMap;
        String str;
        if (intent != null) {
            serializable = intent.getSerializableExtra("key_attrs");
        } else {
            serializable = null;
        }
        if (serializable instanceof HashMap) {
            hashMap = (HashMap) serializable;
        } else {
            hashMap = null;
        }
        if (hashMap != null && (str = (String) hashMap.get(QCircleScheme.AttrQQPublish.CHALLENGE_TAG)) != null) {
            return str;
        }
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("QQWinkDataKeys-challenge_tag_name");
    }

    @NotNull
    public final String j(@NotNull Intent intent) {
        String replaceFirst$default;
        Intrinsics.checkNotNullParameter(intent, "intent");
        replaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(f(intent), "#", "", false, 4, (Object) null);
        return replaceFirst$default;
    }
}
