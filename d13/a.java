package d13;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.RelativeSizeSpan;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.vas.font.IFontManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LRULinkedHashMap;
import com.tencent.util.Pair;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002JJ\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2.\u0010\u0012\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f0\u000ej\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f`\u0011H\u0002JJ\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\fH\u0002JZ\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\n2\u0018\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u001e\u0010!\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n\u00a8\u0006%"}, d2 = {"Ld13/a;", "", "", "text", "", "f", "", "originText", h.F, "msg", "", "seed", "Landroid/text/SpannableString;", "b", "Ljava/util/ArrayList;", "Lcom/tencent/util/Pair;", "", "Lkotlin/collections/ArrayList;", "chnIndex", "c", "", "fontSizeChange1", "fontSizeChange2", "oneWord", "result", "e", "magicFontCount1", "magicFontCount2", "groupSize", "", "d", "uid", "msgId", "g", "<init>", "()V", "a", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final LRULinkedHashMap<Long, SpannableString> f392652b = new LRULinkedHashMap<>(50);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final a f392653c = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\t\u00a8\u0006\r"}, d2 = {"Ld13/a$a;", "", "Ld13/a;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Ld13/a;", "a", "()Ld13/a;", "", "HANDLER_THREAD_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: d13.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final a a() {
            return a.f392653c;
        }

        Companion() {
        }
    }

    private final SpannableString b(CharSequence msg2, long seed) {
        ArrayList arrayList = new ArrayList();
        String h16 = h(msg2.toString());
        if (TextUtils.isEmpty(h16)) {
            if (QLog.isColorLevel()) {
                QLog.d("MagicFontBuilder", 2, "generateMagicFont msg is empty");
            }
            return null;
        }
        System.currentTimeMillis();
        Intrinsics.checkNotNull(h16);
        int length = h16.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (h16.charAt(i3) != ' ') {
                arrayList.add(String.valueOf(h16.charAt(i3)));
            }
        }
        System.currentTimeMillis();
        ArrayList<Pair<Integer, Integer>> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            while (i16 < h16.length() && h16.charAt(i16) == ' ') {
                i16++;
            }
            Object obj = arrayList.get(i17);
            Intrinsics.checkNotNullExpressionValue(obj, "words[i]");
            String str = (String) obj;
            int i18 = 0;
            while (i18 < str.length() && str.charAt(i18) >= '\u4e00' && str.charAt(i18) <= '\u9fbb') {
                i18++;
            }
            if (i18 == str.length()) {
                arrayList2.add(new Pair<>(Integer.valueOf(i16), Integer.valueOf(str.length() + i16)));
            }
            i16 += str.length();
        }
        if (arrayList2.size() < 1) {
            return null;
        }
        return c(msg2, seed, arrayList2);
    }

    private final SpannableString c(CharSequence msg2, long seed, ArrayList<Pair<Integer, Integer>> chnIndex) {
        boolean z16;
        float f16;
        int i3;
        float f17;
        float f18;
        boolean z17;
        int i16;
        boolean z18 = false;
        if (FontSettingManager.getFontLevel() == 18.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            f16 = 1.3f;
        } else {
            f16 = 1.5f;
        }
        int size = (int) ((chnIndex.size() * 0.3f) + 0.5d);
        int size2 = (int) ((chnIndex.size() * 0.3f) + 0.5d);
        IFontManager.Companion companion = IFontManager.INSTANCE;
        if (companion.a().get()) {
            float e16 = companion.e();
            float f19 = companion.f();
            if (FontSettingManager.getFontLevel() == 18.0f) {
                z18 = true;
            }
            if (z18) {
                e16 = companion.c();
                f19 = companion.d();
            }
            z17 = companion.g();
            int size3 = (int) ((chnIndex.size() * companion.h()) + 0.5d);
            size2 = (int) ((chnIndex.size() * companion.i()) + 0.5d);
            i3 = companion.b();
            f17 = e16;
            i16 = size3;
            f18 = f19;
        } else {
            i3 = 4;
            f17 = f16;
            f18 = 0.7f;
            z17 = true;
            i16 = size;
        }
        int i17 = size2;
        int i18 = i3;
        SpannableString spannableString = new SpannableString(msg2);
        if (chnIndex.size() == 1) {
            if (e(seed, chnIndex, f17, f18, z17, spannableString)) {
                return null;
            }
        } else {
            d(seed, chnIndex, f17, f18, i16, i17, i18, spannableString);
        }
        return spannableString;
    }

    private final void d(long seed, ArrayList<Pair<Integer, Integer>> chnIndex, float fontSizeChange1, float fontSizeChange2, int magicFontCount1, int magicFontCount2, int groupSize, SpannableString result) {
        boolean z16;
        float f16;
        boolean z17;
        boolean z18;
        int size = chnIndex.size();
        long j3 = seed;
        int i3 = magicFontCount1;
        int i16 = magicFontCount2;
        boolean z19 = false;
        int i17 = 0;
        for (int i18 = 0; i18 < size; i18++) {
            if (groupSize > 0 && i18 % groupSize == groupSize - 1 && !z19) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (j3 % (chnIndex.size() - i18) < i3 + i16 || z16) {
                if ((i3 <= 0 && i16 > 0) || ((i16 > 0 || i3 <= 0) && i17 % 2 == 1)) {
                    f16 = fontSizeChange2;
                } else {
                    f16 = fontSizeChange1;
                }
                if (f16 == fontSizeChange1) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    i3--;
                }
                if (f16 == fontSizeChange2) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    i16--;
                }
                RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f16);
                Integer num = chnIndex.get(i18).first;
                Intrinsics.checkNotNullExpressionValue(num, "chnIndex[i].first");
                int intValue = num.intValue();
                Integer num2 = chnIndex.get(i18).second;
                Intrinsics.checkNotNullExpressionValue(num2, "chnIndex[i].second");
                result.setSpan(relativeSizeSpan, intValue, num2.intValue(), 33);
                i17++;
                z19 = true;
            }
            if (groupSize > 0 && i18 % groupSize == groupSize - 1) {
                z19 = false;
            }
            j3 = (((j3 * 25214903917L) + 11) & 281474976710655L) >> 16;
        }
    }

    private final boolean e(long seed, ArrayList<Pair<Integer, Integer>> chnIndex, float fontSizeChange1, float fontSizeChange2, boolean oneWord, SpannableString result) {
        int i3;
        float f16;
        if (QLog.isColorLevel()) {
            QLog.d("MagicFontBuilder", 2, "generateMagicFont oneWord");
        }
        int i16 = 1;
        if (oneWord) {
            int intValue = chnIndex.get(0).second.intValue();
            Integer num = chnIndex.get(0).first;
            Intrinsics.checkNotNullExpressionValue(num, "chnIndex[0].first");
            if (intValue - num.intValue() > 1) {
                int intValue2 = chnIndex.get(0).second.intValue();
                Integer num2 = chnIndex.get(0).first;
                Intrinsics.checkNotNullExpressionValue(num2, "chnIndex[0].first");
                if (intValue2 - num2.intValue() == 2) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                int intValue3 = chnIndex.get(0).second.intValue();
                Integer num3 = chnIndex.get(0).first;
                Intrinsics.checkNotNullExpressionValue(num3, "chnIndex[0].first");
                int intValue4 = intValue3 - num3.intValue();
                long j3 = seed;
                int i17 = 0;
                int i18 = 0;
                while (i17 < intValue4) {
                    int intValue5 = chnIndex.get(0).second.intValue();
                    Intrinsics.checkNotNullExpressionValue(chnIndex.get(0).first, "chnIndex[0].first");
                    if (j3 % ((intValue5 - r13.intValue()) - i17) < i3) {
                        if (i18 % 2 == i16) {
                            f16 = fontSizeChange2;
                        } else {
                            f16 = fontSizeChange1;
                        }
                        result.setSpan(new RelativeSizeSpan(f16), chnIndex.get(0).first.intValue() + i17, chnIndex.get(0).first.intValue() + i17 + i16, 33);
                        i3--;
                        i18++;
                        if (QLog.isColorLevel()) {
                            QLog.d("MagicFontBuilder", 2, "generateMagicFont oneWord change index = " + chnIndex.get(0).first + i17 + " changeSize = " + f16);
                        }
                    }
                    j3 = (((j3 * 25214903917L) + 11) & 281474976710655L) >> 16;
                    i17++;
                    i16 = 1;
                }
                return false;
            }
        }
        if (QLog.isColorLevel()) {
            int intValue6 = chnIndex.get(0).second.intValue();
            Integer num4 = chnIndex.get(0).first;
            Intrinsics.checkNotNullExpressionValue(num4, "chnIndex[0].first");
            QLog.d("MagicFontBuilder", 2, "generateMagicFont oneWord switch = " + oneWord + " length = " + (intValue6 - num4.intValue()));
            return true;
        }
        return true;
    }

    private final boolean f(CharSequence text) {
        int checkRadix;
        boolean z16;
        for (int i3 = 0; i3 < text.length(); i3++) {
            String unicodeStr = Integer.toHexString(text.charAt(i3));
            Intrinsics.checkNotNullExpressionValue(unicodeStr, "unicodeStr");
            checkRadix = CharsKt__CharJVMKt.checkRadix(16);
            int parseInt = Integer.parseInt(unicodeStr, checkRadix);
            if (19968 <= parseInt && parseInt < 40892) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    private final String h(String originText) {
        if (TextUtils.isEmpty(originText)) {
            return null;
        }
        int length = originText.length();
        String str = "";
        int i3 = 0;
        while (i3 < length) {
            if (originText.codePointAt(i3) == 20) {
                if (i3 < length - 1) {
                    int i16 = i3 + 1;
                    if (originText.charAt(i16) < '\u00ff') {
                        str = str + "  ";
                        i3 = i16;
                    } else {
                        str = str + "     ";
                        i3 += 4;
                    }
                }
            } else {
                str = str + originText.charAt(i3);
            }
            i3++;
        }
        return str;
    }

    @NotNull
    public final CharSequence g(@NotNull CharSequence msg2, long uid, long msgId) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (f(msg2)) {
            LRULinkedHashMap<Long, SpannableString> lRULinkedHashMap = f392652b;
            synchronized (lRULinkedHashMap) {
                if (lRULinkedHashMap.containsKey(Long.valueOf(msgId))) {
                    SpannableString spannableString = lRULinkedHashMap.get(Long.valueOf(msgId));
                    if (spannableString != null) {
                        return spannableString;
                    }
                } else {
                    SpannableString b16 = b(msg2, uid);
                    if (b16 != null) {
                        lRULinkedHashMap.put(Long.valueOf(msgId), b16);
                        return b16;
                    }
                }
            }
        }
        return msg2;
    }
}
