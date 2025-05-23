package com.tencent.mobileqq.matchfriend.reborn.content.signal.utils;

import android.graphics.Color;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$PartnerAdjective;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalMeta;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import com.tencent.trpcprotocol.qqstranger.common.tag.TagPB$Tag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010\u000b\u001a\u00020\n*\u00020\u00072\u0006\u0010\t\u001a\u00020\b\u001a\n\u0010\f\u001a\u00020\n*\u00020\u0007\u001a\n\u0010\u000e\u001a\u00020\r*\u00020\u0007\u001a\n\u0010\u000f\u001a\u00020\r*\u00020\u0007\u001a\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010\u001a\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0010*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a\u0014\u0010\u0015\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a\f\u0010\u0016\u001a\u00020\u0010*\u00020\u0000H\u0002\u001a\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\nH\u0002\u001a\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0012*\b\u0012\u0004\u0012\u00020\u00190\u0012H\u0002\u001a\u0010\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0019H\u0002\u001a\n\u0010\u001d\u001a\u00020\u0010*\u00020\u0000\u001a\n\u0010\u001f\u001a\u00020\u0010*\u00020\u001e\u001a\n\u0010!\u001a\u00020\u0010*\u00020 \u001a\n\u0010\"\u001a\u00020\u0010*\u00020\u0007\u001a\b\u0010#\u001a\u00020\nH\u0002\u001a\b\u0010$\u001a\u00020\rH\u0002\u001a\b\u0010%\u001a\u00020\rH\u0002\"\u0015\u0010(\u001a\u00020\b*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b&\u0010'\"\u0015\u0010\t\u001a\u00020\b*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b)\u0010'\u00a8\u0006*"}, d2 = {"Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "B", ReportConstant.COSTREPORT_PREFIX, "u", "Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalConfig;", "", "partnerAdjId", "", "c", "d", "", "e", "l", "", "otherConstellation", "", "o", DomainData.DOMAIN_NAME, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "maxTagCount", "i", "Lcom/tencent/trpcprotocol/qqstranger/common/tag/TagPB$Tag;", "v", "tag", "r", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalMeta;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$PartnerAdjective;", HippyTKDListViewAdapter.X, "y", "f", "g", h.F, "k", "(Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;)J", "partnerId", "j", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ModelExtKt {
    public static final String A(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo) {
        Intrinsics.checkNotNullParameter(signalPlazaSvrPB$SignalInfo, "<this>");
        String str = signalPlazaSvrPB$SignalInfo.open_id.get();
        SignalPB$SignalMeta signal_meta = signalPlazaSvrPB$SignalInfo.signal_meta;
        Intrinsics.checkNotNullExpressionValue(signal_meta, "signal_meta");
        return "{open_id: " + str + ", signal_meta: " + z(signal_meta);
    }

    public static final boolean B(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo) {
        Intrinsics.checkNotNullParameter(signalPlazaSvrPB$SignalInfo, "<this>");
        QLog.i("ModelExt", 2, "willExpireAtSoon ttl: " + signalPlazaSvrPB$SignalInfo.signal_meta.ttl.get());
        return signalPlazaSvrPB$SignalInfo.signal_meta.ttl.get() <= 28800;
    }

    public static final int c(SignalPB$SignalConfig signalPB$SignalConfig, long j3) {
        Intrinsics.checkNotNullParameter(signalPB$SignalConfig, "<this>");
        List<SignalPB$PartnerAdjective> list = signalPB$SignalConfig.partner_adjs.get();
        Intrinsics.checkNotNullExpressionValue(list, "partner_adjs.get()");
        int i3 = 0;
        for (Object obj : list) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (((SignalPB$PartnerAdjective) obj).partner_adj_id.get() == j3) {
                return i3;
            }
            i3 = i16;
        }
        return -1;
    }

    public static final int d(SignalPB$SignalConfig signalPB$SignalConfig) {
        Object m476constructorimpl;
        int parseColor;
        Intrinsics.checkNotNullParameter(signalPB$SignalConfig, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (QQTheme.isNowThemeIsNight()) {
                parseColor = Color.parseColor(signalPB$SignalConfig.button_bg_color_night.get());
            } else {
                parseColor = Color.parseColor(signalPB$SignalConfig.button_bg_color.get());
            }
            m476constructorimpl = Result.m476constructorimpl(Integer.valueOf(parseColor));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("ModelExt", 2, m479exceptionOrNullimpl, new Object[0]);
            m476constructorimpl = Integer.valueOf(f());
        }
        return ((Number) m476constructorimpl).intValue();
    }

    public static final int[] e(SignalPB$SignalConfig signalPB$SignalConfig) {
        Object m476constructorimpl;
        int collectionSizeOrDefault;
        int[] intArray;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(signalPB$SignalConfig, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (QQTheme.isNowThemeIsNight()) {
                List<String> list = signalPB$SignalConfig.card_bg_colors_night.get();
                Intrinsics.checkNotNullExpressionValue(list, "card_bg_colors_night.get()");
                List<String> list2 = list;
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(Color.parseColor((String) it.next())));
                }
                intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
            } else {
                List<String> list3 = signalPB$SignalConfig.card_bg_colors.get();
                Intrinsics.checkNotNullExpressionValue(list3, "card_bg_colors.get()");
                List<String> list4 = list3;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it5 = list4.iterator();
                while (it5.hasNext()) {
                    arrayList2.add(Integer.valueOf(Color.parseColor((String) it5.next())));
                }
                intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList2);
            }
            m476constructorimpl = Result.m476constructorimpl(intArray);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("ModelExt", 2, m479exceptionOrNullimpl, new Object[0]);
            m476constructorimpl = g();
        }
        return (int[]) m476constructorimpl;
    }

    private static final int f() {
        return Color.parseColor("#DDD7FF");
    }

    private static final List<String> i(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo, int i3) {
        ArrayList arrayList = new ArrayList();
        List<TagPB$Tag> list = signalPlazaSvrPB$SignalInfo.my_ark_tags.get();
        Intrinsics.checkNotNullExpressionValue(list, "my_ark_tags.get()");
        int i16 = 0;
        for (TagPB$Tag tagPB$Tag : v(list)) {
            if (i16 >= i3) {
                break;
            }
            String str = tagPB$Tag.tag_name.get();
            if (!(str == null || str.length() == 0)) {
                arrayList.add(str);
                i16++;
            }
        }
        return arrayList;
    }

    public static final long j(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo) {
        Intrinsics.checkNotNullParameter(signalPlazaSvrPB$SignalInfo, "<this>");
        return signalPlazaSvrPB$SignalInfo.signal_meta.partner_adj.partner_adj_id.get();
    }

    public static final long k(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo) {
        Intrinsics.checkNotNullParameter(signalPlazaSvrPB$SignalInfo, "<this>");
        return signalPlazaSvrPB$SignalInfo.signal_meta.partner_id.get();
    }

    public static final int[] l(SignalPB$SignalConfig signalPB$SignalConfig) {
        Object m476constructorimpl;
        int collectionSizeOrDefault;
        int[] intArray;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(signalPB$SignalConfig, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (QQTheme.isNowThemeIsNight()) {
                List<String> list = signalPB$SignalConfig.publisher_signal_bg_colors_night.get();
                Intrinsics.checkNotNullExpressionValue(list, "publisher_signal_bg_colors_night.get()");
                List<String> list2 = list;
                collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(Color.parseColor((String) it.next())));
                }
                intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList);
            } else {
                List<String> list3 = signalPB$SignalConfig.publisher_signal_bg_colors.get();
                Intrinsics.checkNotNullExpressionValue(list3, "publisher_signal_bg_colors.get()");
                List<String> list4 = list3;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it5 = list4.iterator();
                while (it5.hasNext()) {
                    arrayList2.add(Integer.valueOf(Color.parseColor((String) it5.next())));
                }
                intArray = CollectionsKt___CollectionsKt.toIntArray(arrayList2);
            }
            m476constructorimpl = Result.m476constructorimpl(intArray);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            QLog.e("ModelExt", 2, m479exceptionOrNullimpl, new Object[0]);
            m476constructorimpl = h();
        }
        return (int[]) m476constructorimpl;
    }

    private static final String m(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo) {
        String str = signalPlazaSvrPB$SignalInfo.constellation.get();
        Intrinsics.checkNotNullExpressionValue(str, "constellation.get()");
        return str;
    }

    private static final String n(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo, String str) {
        if (t(signalPlazaSvrPB$SignalInfo, str)) {
            return m(signalPlazaSvrPB$SignalInfo);
        }
        if (signalPlazaSvrPB$SignalInfo.same_tags.isEmpty()) {
            return null;
        }
        List<TagPB$Tag> list = signalPlazaSvrPB$SignalInfo.same_tags.get();
        Intrinsics.checkNotNullExpressionValue(list, "same_tags.get()");
        return v(list).get(0).tag_name.get();
    }

    public static final List<String> o(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo, String otherConstellation) {
        int i3;
        Intrinsics.checkNotNullParameter(signalPlazaSvrPB$SignalInfo, "<this>");
        Intrinsics.checkNotNullParameter(otherConstellation, "otherConstellation");
        ArrayList arrayList = new ArrayList();
        String n3 = n(signalPlazaSvrPB$SignalInfo, otherConstellation);
        boolean z16 = true;
        if (n3 == null || n3.length() == 0) {
            i3 = 0;
        } else {
            arrayList.add(n3);
            i3 = 1;
        }
        List<String> i16 = i(signalPlazaSvrPB$SignalInfo, 2 - i3);
        arrayList.addAll(i16);
        if (i3 + i16.size() == 0) {
            String str = signalPlazaSvrPB$SignalInfo.constellation.get();
            if (str != null && str.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static final boolean p(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo) {
        Intrinsics.checkNotNullParameter(signalPlazaSvrPB$SignalInfo, "<this>");
        return (System.currentTimeMillis() / ((long) 1000)) - signalPlazaSvrPB$SignalInfo.signal_meta.created_at.get() < 86400;
    }

    public static final boolean q(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo) {
        Intrinsics.checkNotNullParameter(signalPlazaSvrPB$SignalInfo, "<this>");
        return (System.currentTimeMillis() / ((long) 1000)) - signalPlazaSvrPB$SignalInfo.signal_meta.created_at.get() < 172800;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(TagPB$Tag tagPB$Tag) {
        int i3 = tagPB$Tag.tag_id.get();
        return 10001 <= i3 && i3 < 11111;
    }

    public static final boolean s(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo) {
        boolean contains$default;
        boolean contains$default2;
        Intrinsics.checkNotNullParameter(signalPlazaSvrPB$SignalInfo, "<this>");
        String it = signalPlazaSvrPB$SignalInfo.user_status.get();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) it, (CharSequence) "\u5728\u7ebf", false, 2, (Object) null);
        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) it, (CharSequence) "\u5f53\u524d\u5728\u7ebf", false, 2, (Object) null);
        return contains$default2 | contains$default;
    }

    private static final boolean t(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo, String str) {
        return (str.length() > 0) && Intrinsics.areEqual(signalPlazaSvrPB$SignalInfo.constellation.get(), str);
    }

    public static final boolean u(SignalPlazaSvrPB$SignalInfo signalPlazaSvrPB$SignalInfo) {
        Intrinsics.checkNotNullParameter(signalPlazaSvrPB$SignalInfo, "<this>");
        return Intrinsics.areEqual(signalPlazaSvrPB$SignalInfo.open_id.get(), ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
    }

    private static final List<TagPB$Tag> v(List<TagPB$Tag> list) {
        List<TagPB$Tag> sortedWith;
        final ModelExtKt$sortTag$1 modelExtKt$sortTag$1 = new Function2<TagPB$Tag, TagPB$Tag, Integer>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.utils.ModelExtKt$sortTag$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(TagPB$Tag a16, TagPB$Tag b16) {
                boolean r16;
                boolean r17;
                int i3;
                Intrinsics.checkNotNullExpressionValue(a16, "a");
                r16 = ModelExtKt.r(a16);
                Intrinsics.checkNotNullExpressionValue(b16, "b");
                r17 = ModelExtKt.r(b16);
                if (r16 && r17) {
                    i3 = b16.tag_id.get() - a16.tag_id.get();
                } else {
                    i3 = r16 ? -1 : r17 ? 1 : 0;
                }
                return Integer.valueOf(i3);
            }
        };
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.utils.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int w3;
                w3 = ModelExtKt.w(Function2.this, obj, obj2);
                return w3;
            }
        });
        return sortedWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int w(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    public static final String x(SignalPB$PartnerAdjective signalPB$PartnerAdjective) {
        Intrinsics.checkNotNullParameter(signalPB$PartnerAdjective, "<this>");
        return "{partner_adj_id: " + signalPB$PartnerAdjective.partner_adj_id.get() + ", partner_adj_name: " + signalPB$PartnerAdjective.partner_adj_name.get() + "}";
    }

    public static final String y(SignalPB$SignalConfig signalPB$SignalConfig) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(signalPB$SignalConfig, "<this>");
        long j3 = signalPB$SignalConfig.partner_id.get();
        String str = signalPB$SignalConfig.partner_name.get();
        List<SignalPB$PartnerAdjective> list = signalPB$SignalConfig.partner_adjs.get();
        Intrinsics.checkNotNullExpressionValue(list, "partner_adjs.get()");
        List<SignalPB$PartnerAdjective> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (SignalPB$PartnerAdjective it : list2) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(x(it));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String arrays = Arrays.toString(array);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        String str2 = signalPB$SignalConfig.icon.get();
        String str3 = signalPB$SignalConfig.button_bg_color.get();
        List<String> list3 = signalPB$SignalConfig.card_bg_colors.get();
        Intrinsics.checkNotNullExpressionValue(list3, "card_bg_colors.get()");
        Object[] array2 = list3.toArray(new String[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String arrays2 = Arrays.toString(array2);
        Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
        List<String> list4 = signalPB$SignalConfig.publisher_signal_bg_colors.get();
        Intrinsics.checkNotNullExpressionValue(list4, "publisher_signal_bg_colors.get()");
        Object[] array3 = list4.toArray(new String[0]);
        Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String arrays3 = Arrays.toString(array3);
        Intrinsics.checkNotNullExpressionValue(arrays3, "toString(this)");
        return "{partner_id: " + j3 + ", partner_name: " + str + ", partner_adjs: " + arrays + ", icon: " + str2 + ", button_bg_color: " + str3 + ", card_bg_colors: " + arrays2 + ", publisher_signal_bg_colors: " + arrays3 + ", }";
    }

    public static final String z(SignalPB$SignalMeta signalPB$SignalMeta) {
        Intrinsics.checkNotNullParameter(signalPB$SignalMeta, "<this>");
        long j3 = signalPB$SignalMeta.partner_id.get();
        String str = signalPB$SignalMeta.partner_name.get();
        SignalPB$PartnerAdjective partner_adj = signalPB$SignalMeta.partner_adj;
        Intrinsics.checkNotNullExpressionValue(partner_adj, "partner_adj");
        String x16 = x(partner_adj);
        long j16 = signalPB$SignalMeta.created_at.get();
        long j17 = signalPB$SignalMeta.ttl.get();
        SignalPB$SignalConfig config = signalPB$SignalMeta.config;
        Intrinsics.checkNotNullExpressionValue(config, "config");
        return "{partner_id: " + j3 + "}, partner_name: " + str + ", partner_adj: " + x16 + ", create_at: " + j16 + ", ttl: " + j17 + ", config: " + y(config) + ", ";
    }

    private static final int[] g() {
        return new int[]{Color.parseColor("#9B8DF3"), Color.parseColor("#DDD7FF")};
    }

    private static final int[] h() {
        return new int[]{Color.parseColor("#DDD7FF"), Color.parseColor("#FFFFFF")};
    }
}
