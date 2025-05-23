package com.tencent.mobileqq.aio.reserve1.navigation;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u001a\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002\u001a\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r\"#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"#\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00150\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006!"}, d2 = {"Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavType;", "type", "", "b", "Lcom/tencent/mobileqq/aio/reserve1/navigation/AIONavCorrelation;", "a", "navType", "compareNavType", "", "c", "d", "", "kernelType", "e", "", "Ljava/util/Map;", "getNavTypeMap", "()Ljava/util/Map;", "navTypeMap", "Lcom/tencent/mobileqq/aio/reserve1/navigation/a;", "Lcom/tencent/mobileqq/aio/reserve1/navigation/a;", "getDefaultConfig", "()Lcom/tencent/mobileqq/aio/reserve1/navigation/a;", "defaultConfig", "getNavConfigMap", "navConfigMap", "", "Ljava/util/List;", "getNotNeedFlushNavType", "()Ljava/util/List;", "notNeedFlushNavType", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, AIONavType> f193320a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final a f193321b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<AIONavType, a> f193322c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final List<AIONavType> f193323d;

    static {
        Map<Integer, AIONavType> mapOf;
        Map<AIONavType, a> mapOf2;
        List<AIONavType> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49739);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        AIONavType aIONavType = AIONavType.UNKNOWN;
        AIONavType aIONavType2 = AIONavType.UNREAD;
        AIONavType aIONavType3 = AIONavType.AT_ME;
        AIONavType aIONavType4 = AIONavType.ANONYMOUS_AT_ME;
        AIONavType aIONavType5 = AIONavType.REPLY_AT_ME;
        AIONavType aIONavType6 = AIONavType.MY_RED_ENVELOPE;
        AIONavType aIONavType7 = AIONavType.AT_ONE_RED_ENVELOPE;
        AIONavType aIONavType8 = AIONavType.GIFT_AT_ME;
        AIONavType aIONavType9 = AIONavType.AT_ALL;
        AIONavType aIONavType10 = AIONavType.NEW_FILE;
        AIONavType aIONavType11 = AIONavType.NORMAL_RED_ENVELOPE;
        AIONavType aIONavType12 = AIONavType.HOMEWORK;
        AIONavType aIONavType13 = AIONavType.ANNOUNCE;
        AIONavType aIONavType14 = AIONavType.ANNOUNCE_NEED_CONFIRM;
        AIONavType aIONavType15 = AIONavType.KEYWORD_NOTIFY;
        AIONavType aIONavType16 = AIONavType.SPECIAL_NOTIFY;
        AIONavType aIONavType17 = AIONavType.TEAM_UP;
        mapOf = MapsKt__MapsKt.mapOf(new Pair(0, aIONavType), new Pair(2007, aIONavType2), new Pair(1000, aIONavType3), new Pair(1001, aIONavType4), new Pair(1002, aIONavType5), new Pair(1004, aIONavType6), new Pair(1003, aIONavType7), new Pair(1005, aIONavType8), new Pair(2000, aIONavType9), new Pair(2001, aIONavType10), new Pair(1007, aIONavType11), new Pair(2003, aIONavType12), new Pair(2004, aIONavType13), new Pair(2005, aIONavType14), new Pair(2006, aIONavType15), new Pair(1006, aIONavType16), new Pair(20003, aIONavType17));
        f193320a = mapOf;
        f193321b = new a(0, 0, null, 6, null);
        AIONavCorrelation aIONavCorrelation = AIONavCorrelation.STRONG;
        mapOf2 = MapsKt__MapsKt.mapOf(new Pair(aIONavType, new a(0, 0, null, 6, null)), new Pair(aIONavType3, new a(26, R.string.f179853_h, aIONavCorrelation)), new Pair(aIONavType4, new a(26, R.string.f179853_h, null, 4, null)), new Pair(aIONavType5, new a(24, R.string.f181133cy, aIONavCorrelation)), new Pair(AIONavType.CONFESS_AT_ME, new a(12, R.string.f198034lm, null, 4, null)), new Pair(aIONavType6, new a(19, R.string.f225176kx, aIONavCorrelation)), new Pair(aIONavType7, new a(19, R.string.f225186ky, aIONavCorrelation)), new Pair(aIONavType8, new a(19, R.string.f181073cs, aIONavCorrelation)), new Pair(aIONavType9, new a(15, R.string.eim, aIONavCorrelation)), new Pair(aIONavType10, new a(3, R.string.f180923cd, null, 4, null)), new Pair(aIONavType11, new a(19, R.string.f225106kq, null, 4, null)), new Pair(aIONavType12, new a(5, R.string.f180493b8, null, 4, null)), new Pair(aIONavType13, new a(32, R.string.f180993ck, null, 4, null)), new Pair(aIONavType14, new a(32, R.string.f181023cn, aIONavCorrelation)), new Pair(aIONavType15, new a(18, R.string.f2060557_, aIONavCorrelation)), new Pair(aIONavType16, new a(19, R.string.f2068359d, aIONavCorrelation)), new Pair(aIONavType17, new a(6, R.string.f2062557t, null, 4, null)));
        f193322c = mapOf2;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(aIONavType2);
        f193323d = listOf;
    }

    @NotNull
    public static final AIONavCorrelation a(@NotNull AIONavType type) {
        AIONavCorrelation a16;
        Intrinsics.checkNotNullParameter(type, "type");
        a aVar = f193322c.get(type);
        if (aVar == null || (a16 = aVar.a()) == null) {
            return AIONavCorrelation.WEAK;
        }
        return a16;
    }

    @NotNull
    public static final String b(@NotNull Context context, @NotNull AIONavType type) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        a aVar = f193322c.get(type);
        if (aVar != null) {
            i3 = aVar.c();
        } else {
            i3 = -1;
        }
        if (i3 < 0) {
            return "";
        }
        String string = context.getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId)");
        return string;
    }

    public static final boolean c(@NotNull AIONavType navType, @NotNull AIONavType compareNavType) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(navType, "navType");
        Intrinsics.checkNotNullParameter(compareNavType, "compareNavType");
        Map<AIONavType, a> map = f193322c;
        a aVar = map.get(navType);
        if (aVar != null) {
            i3 = aVar.b();
        } else {
            i3 = 0;
        }
        a aVar2 = map.get(compareNavType);
        if (aVar2 != null) {
            i16 = aVar2.b();
        } else {
            i16 = 0;
        }
        if (i3 <= i16) {
            return false;
        }
        return true;
    }

    public static final boolean d(@NotNull AIONavType navType) {
        Intrinsics.checkNotNullParameter(navType, "navType");
        return !f193323d.contains(navType);
    }

    @NotNull
    public static final AIONavType e(int i3) {
        AIONavType aIONavType = f193320a.get(Integer.valueOf(i3));
        if (aIONavType == null) {
            return AIONavType.UNKNOWN;
        }
        return aIONavType;
    }
}
