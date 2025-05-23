package com.tencent.mobileqq.aio.animation.business;

import com.google.gson.Gson;
import com.tencent.mobileqq.aio.animation.data.g;
import com.tencent.mobileqq.aio.config.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bJ\u001c\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rR\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/business/EggsPlayStat;", "", "", "jsonString", "Lcom/tencent/mobileqq/aio/animation/data/g;", "d", "b", "a", "", "targetId", "Lkotlin/Pair;", "", "c", "", "Lcom/tencent/mobileqq/aio/config/a$b;", "limits", "", "e", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "dateFormatter", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class EggsPlayStat {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final EggsPlayStat f187895a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SimpleDateFormat dateFormatter;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29607);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f187895a = new EggsPlayStat();
            dateFormatter = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.getDefault());
        }
    }

    EggsPlayStat() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a() {
        Long l3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            l3 = Long.valueOf(peekAppRuntime.getLongAccountUin());
        } else {
            l3 = null;
        }
        return "EggsPlayStat_" + l3;
    }

    private final String b() {
        String format = dateFormatter.format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "dateFormatter.format(Date())");
        return format;
    }

    private final com.tencent.mobileqq.aio.animation.data.g d(String jsonString) {
        if (jsonString == null) {
            return null;
        }
        try {
            return (com.tencent.mobileqq.aio.animation.data.g) new Gson().fromJson(jsonString, com.tencent.mobileqq.aio.animation.data.g.class);
        } catch (Exception e16) {
            QLog.e("EggsPlayStat", 1, "parse failed, jsonString:" + jsonString + ", exception=" + e16);
            return null;
        }
    }

    @Nullable
    public final Pair<Long, Integer> c(int targetId) {
        boolean z16;
        com.tencent.mobileqq.aio.animation.data.g d16;
        Object obj;
        long j3;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, (Object) this, targetId);
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMo\u2026Q, QMMKVFile.FILE_COMMON)");
        String string = withAccount.getString(a(), "");
        int i3 = 0;
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        Object obj2 = null;
        if (z16 || (d16 = d(string)) == null) {
            return null;
        }
        Iterator<T> it = d16.c().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((g.b) obj).a() == targetId) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        g.b bVar = (g.b) obj;
        if (bVar != null) {
            j3 = bVar.b();
        } else {
            j3 = 0;
        }
        if (Intrinsics.areEqual(d16.a(), b())) {
            Iterator<T> it5 = d16.b().iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                Object next = it5.next();
                if (((g.a) next).b() == targetId) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    obj2 = next;
                    break;
                }
            }
            g.a aVar = (g.a) obj2;
            if (aVar != null) {
                i3 = aVar.a();
            }
        }
        return new Pair<>(Long.valueOf(j3), Integer.valueOf(i3));
    }

    public final void e(int targetId, @NotNull List<a.b> limits) {
        Object obj;
        Object obj2;
        boolean z16;
        boolean z17;
        List split$default;
        Integer intOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, targetId, (Object) limits);
            return;
        }
        Intrinsics.checkNotNullParameter(limits, "limits");
        final HashSet hashSet = new HashSet();
        Iterator<a.b> it = limits.iterator();
        while (it.hasNext()) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) it.next().b(), new String[]{";"}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            Iterator it5 = split$default.iterator();
            while (it5.hasNext()) {
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) it5.next());
                if (intOrNull != null) {
                    arrayList.add(intOrNull);
                }
            }
            hashSet.addAll(arrayList);
        }
        if (!hashSet.contains(Integer.valueOf(targetId))) {
            QLog.i("EggsPlayStat", 1, "updateTsAndCount not contain id:" + targetId);
            return;
        }
        MMKVOptionEntityV2 withAccount = QMMKV.withAccount(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(withAccount, "withAccount(MobileQQ.sMo\u2026Q, QMMKVFile.FILE_COMMON)");
        String string = withAccount.getString(a(), "");
        String b16 = b();
        com.tencent.mobileqq.aio.animation.data.g d16 = d(string);
        if (d16 == null) {
            d16 = new com.tencent.mobileqq.aio.animation.data.g(b16, new ArrayList(), new ArrayList());
        }
        if (!Intrinsics.areEqual(d16.a(), b16)) {
            d16.b().clear();
            d16.d(b16);
        }
        CollectionsKt__MutableCollectionsKt.removeAll((List) d16.c(), (Function1) new Function1<g.b, Boolean>(hashSet) { // from class: com.tencent.mobileqq.aio.animation.business.EggsPlayStat$updateTsAndCount$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ HashSet<Integer> $limitIdSet;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$limitIdSet = hashSet;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) hashSet);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull g.b it6) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it6);
                }
                Intrinsics.checkNotNullParameter(it6, "it");
                return Boolean.valueOf(!this.$limitIdSet.contains(Integer.valueOf(it6.a())));
            }
        });
        Iterator<T> it6 = d16.b().iterator();
        while (true) {
            obj = null;
            if (it6.hasNext()) {
                obj2 = it6.next();
                if (((g.a) obj2).b() == targetId) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        g.a aVar = (g.a) obj2;
        if (aVar != null) {
            aVar.c(aVar.a() + 1);
        } else {
            d16.b().add(new g.a(targetId, 1));
        }
        Iterator<T> it7 = d16.c().iterator();
        while (true) {
            if (!it7.hasNext()) {
                break;
            }
            Object next = it7.next();
            if (((g.b) next).a() == targetId) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        g.b bVar = (g.b) obj;
        if (bVar != null) {
            bVar.c(System.currentTimeMillis());
        } else {
            d16.c().add(new g.b(targetId, System.currentTimeMillis()));
        }
        String json = new Gson().toJson(d16);
        withAccount.putString(a(), json);
        QLog.e("EggsPlayStat", 1, "updateTsAndCount list:" + json);
    }
}
