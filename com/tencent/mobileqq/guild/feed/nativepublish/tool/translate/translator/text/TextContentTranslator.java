package com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.text;

import android.text.Editable;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.specialchar.TopicHashtagTool;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;
import vm1.f;
import vm1.g;
import vm1.i;
import vm1.j;
import wm1.AtInfo;
import wm1.EmojiInfo;
import wm1.GroupInfo;
import wm1.NewlineInfo;
import wm1.QuoteChannelInfo;
import wm1.TextInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u00019B\u0007\u00a2\u0006\u0004\bV\u0010WJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J(\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u0016\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0013j\b\u0012\u0004\u0012\u00020\u0011`\u0014H\u0002J\u0092\u0001\u0010#\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00172\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0013j\b\u0012\u0004\u0012\u00020\u0011`\u00142\u0006\u0010\u001a\u001a\u00020\u00112E\b\u0002\u0010\"\u001a?\u0012\u0004\u0012\u00028\u0000\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001b\u00a2\u0006\u0002\b!H\u0002\u00a2\u0006\u0004\b#\u0010$J(\u0010&\u001a\u00020\u00052\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0013j\b\u0012\u0004\u0012\u00020\u0011`\u00142\u0006\u0010%\u001a\u00020\u0011H\u0002J(\u0010'\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0013j\b\u0012\u0004\u0012\u00020\u0011`\u0014H\u0002J(\u0010(\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0013j\b\u0012\u0004\u0012\u00020\u0011`\u0014H\u0002J(\u0010)\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0013j\b\u0012\u0004\u0012\u00020\u0011`\u0014H\u0002J(\u0010*\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0013j\b\u0012\u0004\u0012\u00020\u0011`\u0014H\u0002J\u0018\u0010,\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011H\u0002J\u0010\u0010/\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011H\u0002J2\u00103\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u0010\t\u001a\u00020\b2\f\u00101\u001a\b\u0012\u0004\u0012\u0002000\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J.\u00105\u001a\u00020\u00052\f\u00104\u001a\b\u0012\u0004\u0012\u0002020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u00107\u001a\u00020\u00052\u0006\u00106\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0016\u00108\u001a\u00020 2\f\u00101\u001a\b\u0012\u0004\u0012\u0002000\u0010H\u0002J\u0018\u00109\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020:0\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010;R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020=0\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020A0\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020E0\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR \u0010M\u001a\f\u0012\b\u0012\u00060Ij\u0002`J0\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020N0\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010OR0\u0010U\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020R0Qj\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020R`S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010T\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/text/TextContentTranslator;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/tool/translate/translator/e;", "", "Lorg/json/JSONObject;", "publishJson", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "t", "Landroid/text/Editable;", "editable", "Lorg/json/JSONArray;", "contentJSONArray", "patternJSONArray", "Lnm1/b;", "translateInfo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "", "o", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "bucketList", "k", "T", "", "spans", "wordType", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "spanStart", "spanEnd", "", "Lkotlin/ExtensionFunctionType;", "spanFilter", "l", "(Landroid/text/Editable;[Ljava/lang/Object;Ljava/util/ArrayList;ILkotlin/jvm/functions/Function3;)V", "index", DomainData.DOMAIN_NAME, "j", h.F, "i", "g", "endFlag", "w", "wordSpace", "u", HippyTKDListViewAdapter.X, "Lfm1/i;", "mediaList", "Lwm1/i;", "v", "aWordInfoList", "B", "patternDataJSONArray", "y", "f", "a", "Lcom/tencent/guild/aio/input/at/utils/b;", "[Lcom/tencent/guild/aio/input/at/utils/b;", "atSpanList", "Lcom/tencent/guild/aio/input/at/utils/e;", "b", "[Lcom/tencent/guild/aio/input/at/utils/e;", "groupSpanList", "Lcom/tencent/guild/aio/input/at/utils/d;", "c", "[Lcom/tencent/guild/aio/input/at/utils/d;", "hashtagSpanList", "Lcom/tencent/mobileqq/text/style/EmoticonSpan;", "d", "[Lcom/tencent/mobileqq/text/style/EmoticonSpan;", "emoticonSpanList", "Lyn1/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/topic/panel/EditorTopicSpan;", "e", "[Lyn1/b;", "topicSpans", "Lsk1/b;", "[Lsk1/b;", "urlSpans", "Ljava/util/HashMap;", "Lvm1/d;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "wordParserMap", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TextContentTranslator implements e {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.guild.aio.input.at.utils.d[] hashtagSpanList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private EmoticonSpan[] emoticonSpanList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, vm1.d> wordParserMap;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.guild.aio.input.at.utils.b[] atSpanList = new com.tencent.guild.aio.input.at.utils.b[0];

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.guild.aio.input.at.utils.e[] groupSpanList = new com.tencent.guild.aio.input.at.utils.e[0];

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private yn1.b[] topicSpans = new yn1.b[0];

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private sk1.b[] urlSpans = new sk1.b[0];

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class b<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Editable f222296d;

        public b(Editable editable) {
            this.f222296d = editable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(this.f222296d.getSpanStart((yn1.b) t16)), Integer.valueOf(this.f222296d.getSpanStart((yn1.b) t17)));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class c<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Editable f222297d;

        public c(Editable editable) {
            this.f222297d = editable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(this.f222297d.getSpanStart((sk1.b) t16)), Integer.valueOf(this.f222297d.getSpanStart((sk1.b) t17)));
            return compareValues;
        }
    }

    public TextContentTranslator() {
        HashMap<Integer, vm1.d> hashMap = new HashMap<>();
        hashMap.put(1, new vm1.h());
        hashMap.put(2, new vm1.e());
        hashMap.put(3, new vm1.b());
        hashMap.put(4, new g());
        hashMap.put(5, new vm1.a());
        hashMap.put(6, new f());
        hashMap.put(7, new j());
        hashMap.put(8, new i());
        hashMap.put(9, new vm1.c());
        this.wordParserMap = hashMap;
    }

    private final void A(Editable editable, JSONArray contentJSONArray, JSONArray patternJSONArray, nm1.b translateInfo) {
        B(v(editable, translateInfo.c(), o(editable)), contentJSONArray, patternJSONArray, translateInfo);
    }

    private final void B(List<? extends wm1.i> aWordInfoList, JSONArray contentJSONArray, JSONArray patternJSONArray, nm1.b translateInfo) {
        JSONArray jSONArray = new JSONArray();
        for (wm1.i iVar : aWordInfoList) {
            vm1.d dVar = this.wordParserMap.get(Integer.valueOf(iVar.getType()));
            if (dVar != null) {
                JSONObject b16 = dVar.b(iVar, translateInfo);
                if (b16 != null) {
                    contentJSONArray.mo162put(b16);
                }
                JSONObject a16 = dVar.a(iVar, translateInfo);
                if (a16 != null) {
                    jSONArray.mo162put(a16);
                }
            }
        }
        y(jSONArray, patternJSONArray);
    }

    private final boolean f(List<? extends fm1.i> mediaList) {
        Object firstOrNull;
        boolean z16;
        if (mediaList.size() == 1) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) mediaList);
            fm1.i iVar = (fm1.i) firstOrNull;
            if (iVar != null && fm1.d.c(iVar)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final void g(Editable editable, ArrayList<Integer> bucketList) {
        k(editable, bucketList);
        h(editable, bucketList);
        j(editable, bucketList);
        i(editable, bucketList);
    }

    private final void h(Editable editable, ArrayList<Integer> bucketList) {
        int length = this.atSpanList.length;
        for (int i3 = 0; i3 < length; i3++) {
            int spanStart = editable.getSpanStart(this.atSpanList[i3]);
            int spanEnd = editable.getSpanEnd(this.atSpanList[i3]) - 1;
            for (int i16 = spanStart; i16 < spanEnd; i16++) {
                bucketList.set(i16, 5);
            }
            bucketList.set(spanEnd, Integer.valueOf(w(Integer.MIN_VALUE, 5)));
            if (spanStart > 0) {
                int i17 = spanStart - 1;
                Integer num = bucketList.get(i17);
                Intrinsics.checkNotNullExpressionValue(num, "bucketList[startPosition - 1]");
                int u16 = u(num.intValue());
                Integer num2 = bucketList.get(i17);
                Intrinsics.checkNotNullExpressionValue(num2, "bucketList[startPosition - 1]");
                if (x(num2.intValue()) == 1 && u16 == 0) {
                    bucketList.set(i17, Integer.valueOf(w(Integer.MIN_VALUE, 1)));
                }
            }
        }
    }

    private final void i(Editable editable, ArrayList<Integer> bucketList) {
        EmoticonSpan[] emoticonSpanArr = this.emoticonSpanList;
        if (emoticonSpanArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonSpanList");
            emoticonSpanArr = null;
        }
        int length = emoticonSpanArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            EmoticonSpan[] emoticonSpanArr2 = this.emoticonSpanList;
            if (emoticonSpanArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("emoticonSpanList");
                emoticonSpanArr2 = null;
            }
            EmoticonSpan emoticonSpan = emoticonSpanArr2[i3];
            int spanStart = editable.getSpanStart(emoticonSpan);
            int spanEnd = editable.getSpanEnd(emoticonSpan);
            if (emoticonSpan.emojiType == 1) {
                int i16 = spanEnd - 1;
                for (int i17 = spanStart; i17 < i16; i17++) {
                    bucketList.set(i17, 4);
                }
                bucketList.set(i16, Integer.valueOf(w(Integer.MIN_VALUE, 4)));
            } else {
                int i18 = spanEnd - 1;
                for (int i19 = spanStart; i19 < i18; i19++) {
                    bucketList.set(i19, 3);
                }
                bucketList.set(i18, Integer.valueOf(w(Integer.MIN_VALUE, 3)));
            }
            if (spanStart > 0) {
                int i26 = spanStart - 1;
                Integer num = bucketList.get(i26);
                Intrinsics.checkNotNullExpressionValue(num, "bucketList[startPosition - 1]");
                int u16 = u(num.intValue());
                Integer num2 = bucketList.get(i26);
                Intrinsics.checkNotNullExpressionValue(num2, "bucketList[startPosition - 1]");
                if (x(num2.intValue()) == 1 && u16 == 0) {
                    bucketList.set(i26, Integer.valueOf(w(Integer.MIN_VALUE, 1)));
                }
            }
        }
    }

    private final void j(Editable editable, ArrayList<Integer> bucketList) {
        com.tencent.guild.aio.input.at.utils.d[] dVarArr = this.hashtagSpanList;
        if (dVarArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hashtagSpanList");
            dVarArr = null;
        }
        int length = dVarArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            com.tencent.guild.aio.input.at.utils.d[] dVarArr2 = this.hashtagSpanList;
            if (dVarArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hashtagSpanList");
                dVarArr2 = null;
            }
            int spanStart = editable.getSpanStart(dVarArr2[i3]);
            com.tencent.guild.aio.input.at.utils.d[] dVarArr3 = this.hashtagSpanList;
            if (dVarArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hashtagSpanList");
                dVarArr3 = null;
            }
            int spanEnd = editable.getSpanEnd(dVarArr3[i3]) - 1;
            for (int i16 = spanStart; i16 < spanEnd; i16++) {
                bucketList.set(i16, 6);
            }
            bucketList.set(spanEnd, Integer.valueOf(w(Integer.MIN_VALUE, 6)));
            if (spanStart > 0) {
                int i17 = spanStart - 1;
                Integer num = bucketList.get(i17);
                Intrinsics.checkNotNullExpressionValue(num, "bucketList[startPosition - 1]");
                int u16 = u(num.intValue());
                Integer num2 = bucketList.get(i17);
                Intrinsics.checkNotNullExpressionValue(num2, "bucketList[startPosition - 1]");
                if (x(num2.intValue()) == 1 && u16 == 0) {
                    bucketList.set(i17, Integer.valueOf(w(Integer.MIN_VALUE, 1)));
                }
            }
        }
    }

    private final void k(Editable editable, ArrayList<Integer> bucketList) {
        int length = editable.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (editable.charAt(i3) == '\n') {
                bucketList.set(i3, Integer.valueOf(w(Integer.MIN_VALUE, 2)));
                if (i3 > 0) {
                    int i16 = i3 - 1;
                    Integer num = bucketList.get(i16);
                    Intrinsics.checkNotNullExpressionValue(num, "bucketList[index - 1]");
                    int u16 = u(num.intValue());
                    Integer num2 = bucketList.get(i16);
                    Intrinsics.checkNotNullExpressionValue(num2, "bucketList[index - 1]");
                    if (x(num2.intValue()) == 1 && u16 == 0) {
                        bucketList.set(i16, Integer.valueOf(w(Integer.MIN_VALUE, 1)));
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0024, code lost:
    
        if (r13.invoke(r3, java.lang.Integer.valueOf(r4), java.lang.Integer.valueOf(r5)).booleanValue() == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <T> void l(Editable editable, T[] spans, ArrayList<Integer> bucketList, int wordType, Function3<? super T, ? super Integer, ? super Integer, Boolean> spanFilter) {
        boolean z16;
        int length = spans.length;
        for (int i3 = 0; i3 < length; i3++) {
            T t16 = spans[i3];
            int spanStart = editable.getSpanStart(t16);
            int spanEnd = editable.getSpanEnd(t16);
            if (spanFilter != null) {
                z16 = true;
            }
            z16 = false;
            if (!z16) {
                int i16 = spanEnd - 1;
                for (int i17 = spanStart; i17 < i16; i17++) {
                    bucketList.set(i17, Integer.valueOf(wordType));
                }
                bucketList.set(i16, Integer.valueOf(w(Integer.MIN_VALUE, wordType)));
                n(bucketList, spanStart);
            }
        }
    }

    static /* synthetic */ void m(TextContentTranslator textContentTranslator, Editable editable, Object[] objArr, ArrayList arrayList, int i3, Function3 function3, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            function3 = null;
        }
        textContentTranslator.l(editable, objArr, arrayList, i3, function3);
    }

    private final void n(ArrayList<Integer> bucketList, int index) {
        if (index <= 0) {
            return;
        }
        int i3 = index - 1;
        Integer num = bucketList.get(i3);
        Intrinsics.checkNotNullExpressionValue(num, "bucketList[index - 1]");
        int intValue = num.intValue();
        if (x(intValue) == 1 && u(intValue) == 0) {
            bucketList.set(i3, Integer.valueOf(w(Integer.MIN_VALUE, 1)));
        }
    }

    private final List<Integer> o(final Editable editable) {
        boolean z16;
        List sortedWith;
        List sortedWith2;
        boolean z17;
        boolean z18;
        ArrayList<Integer> arrayList = new ArrayList<>(Collections.nCopies(editable.length(), Integer.valueOf(w(0, 1))));
        if (editable.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && editable.length() <= arrayList.size()) {
            arrayList.set(editable.length() - 1, Integer.valueOf(w(Integer.MIN_VALUE, 1)));
        }
        Object[] spans = editable.getSpans(0, editable.length(), com.tencent.guild.aio.input.at.utils.b.class);
        Intrinsics.checkNotNullExpressionValue(spans, "editable.getSpans(0, edi\u2026opMemberSpan::class.java)");
        com.tencent.guild.aio.input.at.utils.b[] bVarArr = (com.tencent.guild.aio.input.at.utils.b[]) spans;
        this.atSpanList = bVarArr;
        final Function2<com.tencent.guild.aio.input.at.utils.b, com.tencent.guild.aio.input.at.utils.b, Integer> function2 = new Function2<com.tencent.guild.aio.input.at.utils.b, com.tencent.guild.aio.input.at.utils.b, Integer>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.text.TextContentTranslator$genBucketList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Integer invoke(com.tencent.guild.aio.input.at.utils.b bVar, com.tencent.guild.aio.input.at.utils.b bVar2) {
                return Integer.valueOf(editable.getSpanStart(bVar) - editable.getSpanStart(bVar2));
            }
        };
        Arrays.sort(bVarArr, new Comparator() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.text.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int q16;
                q16 = TextContentTranslator.q(Function2.this, obj, obj2);
                return q16;
            }
        });
        Object[] spans2 = editable.getSpans(0, editable.length(), com.tencent.guild.aio.input.at.utils.d.class);
        Intrinsics.checkNotNullExpressionValue(spans2, "editable.getSpans(0,edit\u2026gChannelSpan::class.java)");
        com.tencent.guild.aio.input.at.utils.d[] dVarArr = (com.tencent.guild.aio.input.at.utils.d[]) spans2;
        this.hashtagSpanList = dVarArr;
        EmoticonSpan[] emoticonSpanArr = null;
        if (dVarArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hashtagSpanList");
            dVarArr = null;
        }
        final Function2<com.tencent.guild.aio.input.at.utils.d, com.tencent.guild.aio.input.at.utils.d, Integer> function22 = new Function2<com.tencent.guild.aio.input.at.utils.d, com.tencent.guild.aio.input.at.utils.d, Integer>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.text.TextContentTranslator$genBucketList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Integer invoke(com.tencent.guild.aio.input.at.utils.d dVar, com.tencent.guild.aio.input.at.utils.d dVar2) {
                return Integer.valueOf(editable.getSpanStart(dVar) - editable.getSpanStart(dVar2));
            }
        };
        Arrays.sort(dVarArr, new Comparator() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.text.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int r16;
                r16 = TextContentTranslator.r(Function2.this, obj, obj2);
                return r16;
            }
        });
        Object[] spans3 = editable.getSpans(0, editable.length(), EmoticonSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans3, "editable.getSpans(0, edi\u2026EmoticonSpan::class.java)");
        EmoticonSpan[] emoticonSpanArr2 = (EmoticonSpan[]) spans3;
        this.emoticonSpanList = emoticonSpanArr2;
        if (emoticonSpanArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("emoticonSpanList");
        } else {
            emoticonSpanArr = emoticonSpanArr2;
        }
        final Function2<EmoticonSpan, EmoticonSpan, Integer> function23 = new Function2<EmoticonSpan, EmoticonSpan, Integer>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.text.TextContentTranslator$genBucketList$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Integer invoke(EmoticonSpan emoticonSpan, EmoticonSpan emoticonSpan2) {
                return Integer.valueOf(editable.getSpanStart(emoticonSpan) - editable.getSpanStart(emoticonSpan2));
            }
        };
        Arrays.sort(emoticonSpanArr, new Comparator() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.text.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int s16;
                s16 = TextContentTranslator.s(Function2.this, obj, obj2);
                return s16;
            }
        });
        Object[] spans4 = editable.getSpans(0, editable.length(), yn1.b.class);
        Intrinsics.checkNotNullExpressionValue(spans4, "editable.getSpans(0, edi\u2026torTopicSpan::class.java)");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : spans4) {
            if (((yn1.b) obj) != TopicHashtagTool.INSTANCE.g()) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            yn1.b bVar = (yn1.b) obj2;
            Object[] spans5 = editable.getSpans(editable.getSpanStart(bVar), editable.getSpanEnd(bVar), yn1.a.class);
            Intrinsics.checkNotNullExpressionValue(spans5, "editable.getSpans(editab\u2026uildJumpSpan::class.java)");
            if (spans5.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                arrayList3.add(obj2);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList3, new b(editable));
        Object[] array = sortedWith.toArray(new yn1.b[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.topicSpans = (yn1.b[]) array;
        Object[] spans6 = editable.getSpans(0, editable.length(), com.tencent.guild.aio.input.at.utils.e.class);
        Intrinsics.checkNotNullExpressionValue(spans6, "editable.getSpans(0, edi\u2026tagGroupSpan::class.java)");
        com.tencent.guild.aio.input.at.utils.e[] eVarArr = (com.tencent.guild.aio.input.at.utils.e[]) spans6;
        this.groupSpanList = eVarArr;
        final Function2<com.tencent.guild.aio.input.at.utils.e, com.tencent.guild.aio.input.at.utils.e, Integer> function24 = new Function2<com.tencent.guild.aio.input.at.utils.e, com.tencent.guild.aio.input.at.utils.e, Integer>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.text.TextContentTranslator$genBucketList$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Integer invoke(com.tencent.guild.aio.input.at.utils.e eVar, com.tencent.guild.aio.input.at.utils.e eVar2) {
                return Integer.valueOf(editable.getSpanStart(eVar) - editable.getSpanStart(eVar2));
            }
        };
        Arrays.sort(eVarArr, new Comparator() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.text.d
            @Override // java.util.Comparator
            public final int compare(Object obj3, Object obj4) {
                int p16;
                p16 = TextContentTranslator.p(Function2.this, obj3, obj4);
                return p16;
            }
        });
        Object[] spans7 = editable.getSpans(0, editable.length(), sk1.b.class);
        Intrinsics.checkNotNullExpressionValue(spans7, "editable.getSpans(0, edi\u2026th, LinkSpan::class.java)");
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : spans7) {
            if (((sk1.b) obj3).getIsRich()) {
                arrayList4.add(obj3);
            }
        }
        sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(arrayList4, new c(editable));
        Object[] array2 = sortedWith2.toArray(new sk1.b[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.urlSpans = (sk1.b[]) array2;
        g(editable, arrayList);
        l(editable, this.topicSpans, arrayList, 8, new Function3<yn1.b, Integer, Integer, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.text.TextContentTranslator$genBucketList$10
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Boolean invoke(yn1.b bVar2, Integer num, Integer num2) {
                return invoke(bVar2, num.intValue(), num2.intValue());
            }

            @NotNull
            public final Boolean invoke(@NotNull yn1.b flagBucketListBySpans, int i3, int i16) {
                int coerceAtMost;
                Intrinsics.checkNotNullParameter(flagBucketListBySpans, "$this$flagBucketListBySpans");
                boolean z19 = true;
                if (i16 - i3 > 1) {
                    Editable editable2 = editable;
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(i16, editable2.length());
                    flagBucketListBySpans.c(editable2.subSequence(i3, coerceAtMost).toString());
                    z19 = false;
                }
                return Boolean.valueOf(z19);
            }
        });
        m(this, editable, this.groupSpanList, arrayList, 9, null, 16, null);
        m(this, editable, this.urlSpans, arrayList, 7, null, 16, null);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int r(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", UUID.randomUUID().toString());
        jSONObject.put("type", "blockParagraph");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(Node.CHILDREN_ATTR, new JSONArray());
        jSONObject2.put("text", "");
        jSONObject2.put("type", 1);
        jSONArray.mo162put(jSONObject2);
        Unit unit = Unit.INSTANCE;
        jSONObject.put("data", jSONArray);
        return jSONObject;
    }

    private final int u(int wordSpace) {
        return wordSpace & Integer.MIN_VALUE;
    }

    private final List<wm1.i> v(Editable editable, List<? extends fm1.i> mediaList, List<Integer> bucketList) {
        EmoticonSpan[] emoticonSpanArr;
        int u16;
        EmoticonSpan[] emoticonSpanArr2;
        com.tencent.guild.aio.input.at.utils.d[] dVarArr;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int i16 = -1;
        int i17 = -1;
        int i18 = -1;
        int i19 = -1;
        int i26 = -1;
        int i27 = -1;
        while (true) {
            int i28 = i3;
            do {
                emoticonSpanArr = null;
                dVarArr = null;
                emoticonSpanArr2 = null;
                if (i3 < bucketList.size()) {
                    u16 = u(bucketList.get(i3).intValue());
                    i3++;
                } else {
                    if (f(mediaList)) {
                        arrayList.add(new wm1.f(7, null));
                    }
                    return arrayList;
                }
            } while (u16 != Integer.MIN_VALUE);
            switch (x(bucketList.get(i28).intValue())) {
                case 1:
                    arrayList.add(new TextInfo(1, editable.subSequence(i28, i3)));
                    break;
                case 2:
                    arrayList.add(new NewlineInfo(2, editable.subSequence(i28, i3)));
                    break;
                case 3:
                    EmoticonSpan[] emoticonSpanArr3 = this.emoticonSpanList;
                    if (emoticonSpanArr3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("emoticonSpanList");
                    } else {
                        emoticonSpanArr = emoticonSpanArr3;
                    }
                    i26++;
                    arrayList.add(new EmojiInfo(3, emoticonSpanArr[i26], editable.subSequence(i28, i3)));
                    break;
                case 4:
                    EmoticonSpan[] emoticonSpanArr4 = this.emoticonSpanList;
                    if (emoticonSpanArr4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("emoticonSpanList");
                    } else {
                        emoticonSpanArr2 = emoticonSpanArr4;
                    }
                    i26++;
                    arrayList.add(new wm1.g(4, emoticonSpanArr2[i26]));
                    break;
                case 5:
                    i16++;
                    arrayList.add(new AtInfo(5, this.atSpanList[i16]));
                    break;
                case 6:
                    com.tencent.guild.aio.input.at.utils.d[] dVarArr2 = this.hashtagSpanList;
                    if (dVarArr2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("hashtagSpanList");
                    } else {
                        dVarArr = dVarArr2;
                    }
                    i27++;
                    arrayList.add(new QuoteChannelInfo(6, dVarArr[i27]));
                    break;
                case 7:
                    i17++;
                    arrayList.add(new wm1.f(7, this.urlSpans[i17]));
                    break;
                case 8:
                    i18++;
                    arrayList.add(new wm1.f(8, this.topicSpans[i18]));
                    break;
                case 9:
                    i19++;
                    arrayList.add(new GroupInfo(9, this.groupSpanList[i19]));
                    break;
            }
        }
    }

    private final int w(int endFlag, int wordType) {
        return (endFlag & Integer.MIN_VALUE) | (wordType & Integer.MAX_VALUE);
    }

    private final int x(int wordSpace) {
        return wordSpace & Integer.MAX_VALUE;
    }

    private final void y(JSONArray patternDataJSONArray, JSONArray patternJSONArray) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", 11);
        patternDataJSONArray.mo162put(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("id", UUID.randomUUID().toString());
        jSONObject2.put("type", "blockParagraph");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("textAlignment", 0);
        Unit unit = Unit.INSTANCE;
        jSONObject2.put("props", jSONObject3);
        jSONObject2.put("data", patternDataJSONArray);
        patternJSONArray.mo162put(jSONObject2);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void z(JSONObject publishJson) {
        boolean z16;
        boolean z17;
        com.tencent.guild.aio.input.at.utils.b[] bVarArr = this.atSpanList;
        if (bVarArr != null) {
            if (bVarArr.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                z16 = false;
                if (z16) {
                    int i3 = 0;
                    int i16 = 0;
                    int i17 = 0;
                    for (com.tencent.guild.aio.input.at.utils.b bVar : bVarArr) {
                        int g16 = bVar.g();
                        if (g16 != 1) {
                            if (g16 != 8) {
                                if (g16 == 64) {
                                    i16++;
                                }
                            } else {
                                i17++;
                            }
                        } else {
                            i3++;
                        }
                    }
                    publishJson.put("atNums", ax.n(i3, i16, i17));
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.tool.translate.translator.e
    public void a(@NotNull JSONObject publishJson, @NotNull nm1.b translateInfo) {
        Intrinsics.checkNotNullParameter(publishJson, "publishJson");
        Intrinsics.checkNotNullParameter(translateInfo, "translateInfo");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("contents", jSONArray);
        Unit unit = Unit.INSTANCE;
        publishJson.put("contents", jSONObject);
        JSONArray jSONArray2 = new JSONArray();
        jSONArray2.mo162put(t());
        publishJson.put("patterns", jSONArray2);
        A(translateInfo.getEditable(), jSONArray, jSONArray2, translateInfo);
        z(publishJson);
    }
}
