package com.tencent.mobileqq.search.searchdetail.multimedia;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.util.QSearchDetailUtilKt;
import com.tencent.mobileqq.vas.theme.api.QUIUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import com.tencent.qqnt.kernel.nativeinterface.SearchRichText;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\fB\u0013\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u00a2\u0006\u0004\b*\u0010+J\u000e\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J!\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012R(\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/multimedia/q;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "", "c", "", "text", "pattern", "", "", "d", "", "a", "tokenName", "Landroid/content/Context;", "context", "b", "(Ljava/lang/String;Landroid/content/Context;)Ljava/lang/Integer;", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchText;", "", "jumpCallback", "Landroid/text/SpannableString;", "g", "", "Ljava/util/List;", "getHighlightTexts", "()Ljava/util/List;", "setHighlightTexts", "(Ljava/util/List;)V", "highlightTexts", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "content", "getKeyword", "f", "keyword", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchRichText;", "serverData", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/SearchRichText;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<SearchText> highlightTexts;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String content;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String keyword;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((SearchText) t17).text.length()), Integer.valueOf(((SearchText) t16).text.length()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/search/searchdetail/multimedia/q$c", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<SearchText, Unit> f284551d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SearchText f284552e;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super SearchText, Unit> function1, SearchText searchText) {
            this.f284551d = function1;
            this.f284552e = searchText;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            this.f284551d.invoke(this.f284552e);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setUnderlineText(false);
        }
    }

    public q(@Nullable SearchRichText searchRichText) {
        ArrayList<SearchText> arrayList;
        if (searchRichText != null) {
            arrayList = searchRichText.highlightTextList;
        } else {
            arrayList = null;
        }
        this.highlightTexts = arrayList == null ? new ArrayList<>() : arrayList;
        this.content = "";
        this.keyword = "";
    }

    private final int[] a(String pattern) {
        int[] iArr = new int[pattern.length()];
        int i3 = 1;
        int i16 = 0;
        while (i3 < pattern.length()) {
            if (pattern.charAt(i3) == pattern.charAt(i16)) {
                i16++;
                iArr[i3] = i16;
            } else if (i16 != 0) {
                i16 = iArr[i16 - 1];
            } else {
                iArr[i3] = 0;
            }
            i3++;
        }
        return iArr;
    }

    private final Integer b(String tokenName, Context context) {
        String str;
        Map<String, String> currentTokenMap = QUIUtil.getCurrentTokenMap();
        if (currentTokenMap == null || (str = currentTokenMap.get(tokenName)) == null) {
            return null;
        }
        try {
            return Integer.valueOf(Color.parseColor(str));
        } catch (Exception unused) {
            return null;
        }
    }

    private final boolean c(SearchJump searchJump) {
        return QSearchDetailUtilKt.i(searchJump);
    }

    private final List<Integer> d(String text, String pattern) {
        ArrayList arrayList = new ArrayList();
        int[] a16 = a(pattern);
        int i3 = 0;
        int i16 = 0;
        while (i3 < text.length()) {
            if (pattern.charAt(i16) == text.charAt(i3)) {
                i3++;
                i16++;
            }
            if (i16 == pattern.length()) {
                arrayList.add(Integer.valueOf(i3 - i16));
                i16 = a16[i16 - 1];
            } else if (i3 < text.length() && pattern.charAt(i16) != text.charAt(i3)) {
                if (i16 != 0) {
                    i16 = a16[i16 - 1];
                } else {
                    i3++;
                }
            }
        }
        return arrayList;
    }

    public final void e(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyword = str;
    }

    @NotNull
    public final SpannableString g(@NotNull Context context, @NotNull Function1<? super SearchText, Unit> jumpCallback) {
        boolean z16;
        List sortedWith;
        String replace$default;
        int color;
        boolean z17;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(jumpCallback, "jumpCallback");
        String str = this.content;
        boolean z18 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(this.content);
        ArrayList<SearchText> arrayList = new ArrayList();
        String lowerCase = this.content.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        List<SearchText> list = this.highlightTexts;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : list) {
            String str2 = ((SearchText) obj).text;
            if (str2 != null && str2.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                arrayList2.add(obj);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new b());
        arrayList.addAll(sortedWith);
        replace$default = StringsKt__StringsJVMKt.replace$default(this.keyword, "#", "", false, 4, (Object) null);
        if (replace$default.length() > 0) {
            z18 = true;
        }
        if (z18) {
            String lowerCase2 = replace$default.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
            Iterator<T> it = d(lowerCase, lowerCase2).iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                spannableString.setSpan(new ForegroundColorSpan(context.getColor(R.color.qui_common_brand_standard)), intValue, replace$default.length() + intValue, 33);
            }
        }
        HashMap hashMap = new HashMap();
        for (SearchText searchText : arrayList) {
            String str3 = searchText.text;
            SearchJump searchJump = searchText.jumpLink;
            Intrinsics.checkNotNullExpressionValue(str3, "highlightText.text");
            String lowerCase3 = str3.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase()");
            Iterator<T> it5 = d(lowerCase, lowerCase3).iterator();
            while (it5.hasNext()) {
                int intValue2 = ((Number) it5.next()).intValue();
                Integer num = (Integer) hashMap.get(searchText.color);
                if (num == null) {
                    String str4 = searchText.color;
                    Intrinsics.checkNotNullExpressionValue(str4, "highlightText.color");
                    num = b(str4, context);
                    String str5 = searchText.color;
                    Intrinsics.checkNotNullExpressionValue(str5, "highlightText.color");
                    hashMap.put(str5, num);
                }
                if (num == null) {
                    if (searchJump != null) {
                        color = context.getColor(R.color.qui_common_brand_standard);
                    } else {
                        color = context.getColor(R.color.qui_common_brand_standard);
                    }
                    num = Integer.valueOf(color);
                }
                spannableString.setSpan(new ForegroundColorSpan(num.intValue()), intValue2, str3.length() + intValue2, 33);
                if (c(searchJump)) {
                    spannableString.setSpan(new c(jumpCallback, searchText), intValue2, str3.length() + intValue2, 33);
                }
            }
        }
        return spannableString;
    }
}
