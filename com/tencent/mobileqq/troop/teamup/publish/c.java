package com.tencent.mobileqq.troop.teamup.publish;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\u001a\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\b2\u0006\u0010\n\u001a\u00020\u0000\u001a\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0000H\u0002\"(\u0010\u0016\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000f8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\"(\u0010\u0019\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000f8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015\"(\u0010\u001c\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000f8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015\"(\u0010\u001f\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000f8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015\u00a8\u0006 "}, d2 = {"Ljava/util/Calendar;", QQPermissionConstants.Permission.CALENDAR_GROUP, "", "", "d", "Landroid/content/Context;", "context", "title", "Landroidx/lifecycle/MutableLiveData;", "data", RemoteHandleConst.PARAM_DEFAULT_VALUE, "", "k", "date1", "date2", "", "c", "value", "getMillisecond", "(Ljava/util/Calendar;)I", h.F, "(Ljava/util/Calendar;I)V", "millisecond", "getSecond", "j", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "f", "i", "minute", "e", "g", "hourOfDay", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/teamup/publish/c$a", "Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$a;", "", "onDismiss", "", "", "selectItems", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements a.InterfaceC8733a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Calendar f299114a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f299115b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ MutableLiveData<Calendar> f299116c;

        a(Calendar calendar, Context context, MutableLiveData<Calendar> mutableLiveData) {
            this.f299114a = calendar;
            this.f299115b = context;
            this.f299116c = mutableLiveData;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, calendar, context, mutableLiveData);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a.InterfaceC8733a
        public void a(@NotNull List<Integer> selectItems) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) selectItems);
                return;
            }
            Intrinsics.checkNotNullParameter(selectItems, "selectItems");
            Object clone = this.f299114a.clone();
            Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
            Calendar calendar = (Calendar) clone;
            calendar.add(6, selectItems.get(0).intValue());
            c.g(calendar, selectItems.get(1).intValue());
            c.i(calendar, selectItems.get(2).intValue());
            if (calendar.compareTo(Calendar.getInstance()) <= 0) {
                QQToastUtil.showQQToast(1, this.f299115b.getString(R.string.f236317e1));
            } else {
                this.f299116c.postValue(calendar);
            }
        }

        @Override // com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a.InterfaceC8733a
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    private static final int c(Calendar calendar, Calendar calendar2) {
        g(calendar, 0);
        i(calendar, 0);
        j(calendar, 0);
        h(calendar, 0);
        g(calendar2, 0);
        i(calendar2, 0);
        j(calendar2, 0);
        h(calendar2, 0);
        return (int) ((calendar2.getTimeInMillis() - calendar.getTimeInMillis()) / 86400000);
    }

    private static final List<String> d(Calendar calendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M\u6708d\u65e5 E", Locale.getDefault());
        ArrayList arrayList = new ArrayList();
        Object clone = calendar.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        Calendar calendar2 = (Calendar) clone;
        for (int i3 = 0; i3 < 180; i3++) {
            String format = simpleDateFormat.format(calendar2.getTime());
            Intrinsics.checkNotNullExpressionValue(format, "formatter.format(currentDate.time)");
            arrayList.add(format);
            calendar2.add(6, 1);
        }
        return arrayList;
    }

    private static final int e(Calendar calendar) {
        return calendar.get(11);
    }

    private static final int f(Calendar calendar) {
        return calendar.get(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Calendar calendar, int i3) {
        calendar.set(11, i3);
    }

    private static final void h(Calendar calendar, int i3) {
        calendar.set(14, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Calendar calendar, int i3) {
        calendar.set(12, i3);
    }

    private static final void j(Calendar calendar, int i3) {
        calendar.set(13, i3);
    }

    public static final void k(@NotNull Context context, @Nullable String str, @NotNull MutableLiveData<Calendar> data, @NotNull Calendar defaultValue) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        List listOf;
        List listOf2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Calendar value = data.getValue();
        if (value != null) {
            defaultValue = value;
        }
        j(defaultValue, 0);
        h(defaultValue, 0);
        Calendar today = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(today, "showCalendarSelector$lambda$1");
        g(today, 0);
        i(today, 0);
        j(today, 0);
        h(today, 0);
        Intrinsics.checkNotNullExpressionValue(today, "today");
        List[] listArr = new List[3];
        listArr[0] = d(today);
        IntRange intRange = new IntRange(0, 23);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(((IntIterator) it).nextInt() + "\u70b9");
        }
        listArr[1] = arrayList;
        IntRange intRange2 = new IntRange(0, 59);
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<Integer> it5 = intRange2.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((IntIterator) it5).nextInt() + "\u5206");
        }
        listArr[2] = arrayList2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) listArr);
        Object clone = defaultValue.clone();
        Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(c(today, (Calendar) clone)), Integer.valueOf(e(defaultValue)), Integer.valueOf(f(defaultValue))});
        new com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a(context, new a.b(str, listOf, listOf2), new a(today, context, data)).m();
    }
}
