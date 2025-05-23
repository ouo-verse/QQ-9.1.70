package com.tencent.mobileqq.matchfriend.aio.utils;

import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.QQText;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/utils/InteractiveContentEmotionCodec;", "", "", "content", "", "emojiSize", "Lcom/tencent/mobileqq/text/QQText;", "b", "Lkotlin/Pair;", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class InteractiveContentEmotionCodec {

    /* renamed from: a, reason: collision with root package name */
    public static final InteractiveContentEmotionCodec f243983a = new InteractiveContentEmotionCodec();

    InteractiveContentEmotionCodec() {
    }

    public final Pair<Integer, String> a(String content) {
        List<String> groupValues;
        Object orNull;
        Intrinsics.checkNotNullParameter(content, "content");
        Regex regex = new Regex("\\{(\\d+)\\}");
        Integer num = null;
        MatchResult find$default = Regex.find$default(regex, content, 0, 2, null);
        if (find$default != null && (groupValues = find$default.getGroupValues()) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(groupValues, 1);
            String str = (String) orNull;
            if (str != null) {
                num = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
            }
        }
        return new Pair<>(num, regex.replace(content, ""));
    }

    public final QQText b(String content, int emojiSize) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new QQText(new Regex("\\{(\\d+)\\}").replace(content, new Function1<MatchResult, CharSequence>() { // from class: com.tencent.mobileqq.matchfriend.aio.utils.InteractiveContentEmotionCodec$toQQText$convertContent$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult matchResult) {
                Object orNull;
                Intrinsics.checkNotNullParameter(matchResult, "matchResult");
                orNull = CollectionsKt___CollectionsKt.getOrNull(matchResult.getGroupValues(), 1);
                String str = (String) orNull;
                Integer intOrNull = str != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(str) : null;
                Integer valueOf = intOrNull != null ? Integer.valueOf(QQSysFaceUtil.convertToLocal(intOrNull.intValue())) : null;
                String faceString = valueOf != null ? QQSysFaceUtil.getFaceString(valueOf.intValue()) : null;
                return faceString == null ? "" : faceString;
            }
        }), 3, emojiSize);
    }
}
