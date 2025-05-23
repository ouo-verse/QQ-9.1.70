package com.tencent.mobileqq.troop.homework.clockin.time.repo;

import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.pickersheet.a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/time/repo/a;", "Lcom/tencent/mobileqq/troop/homework/clockin/time/repo/d;", "", "c", "Lcom/tencent/mobileqq/troop/homework/common/widget/pickersheet/a$b;", "b", "", "", "selectItems", "", "e", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "format", "", "Ljava/util/List;", "hourList", "d", "minuteList", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimpleDateFormat format;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> hourList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> minuteList;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.format = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR, Locale.CHINA);
        this.hourList = new ArrayList();
        this.minuteList = new ArrayList();
        for (int i3 = 0; i3 < 24; i3++) {
            List<String> list = this.hourList;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            list.add(format);
        }
        for (int i16 = 0; i16 < 60; i16++) {
            List<String> list2 = this.minuteList;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            list2.add(format2);
        }
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.time.repo.d
    @NotNull
    public a.b b() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.hourList);
        arrayList.add(this.minuteList);
        com.tencent.mobileqq.troop.homework.clockin.time.data.a d16 = d();
        int i16 = 0;
        if (d16 != null && d16.d() != 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(d16.d()));
            int i17 = calendar.get(11);
            int i18 = calendar.get(12);
            i16 = i17;
            i3 = i18;
        } else {
            i3 = 0;
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(Integer.valueOf(i16));
        arrayList2.add(Integer.valueOf(i3));
        return new a.b("\u63d0\u9192\u6253\u5361", arrayList, arrayList2);
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.time.repo.d
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.mobileqq.troop.homework.clockin.time.data.a d16 = d();
        if (d16 != null) {
            if (d16.d() == 0) {
                return "\u8bf7\u8bbe\u7f6e";
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date(d16.d()));
            int i3 = calendar.get(11);
            int i16 = calendar.get(12);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            String format2 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            return format + ":" + format2;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.troop.homework.clockin.time.repo.d
    public void e(@NotNull List<Integer> selectItems) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) selectItems);
            return;
        }
        Intrinsics.checkNotNullParameter(selectItems, "selectItems");
        if (selectItems.size() != 2) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d", Arrays.copyOf(new Object[]{selectItems.get(0)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        String format2 = String.format("%02d", Arrays.copyOf(new Object[]{selectItems.get(1)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        String str = format + ":" + format2;
        com.tencent.mobileqq.troop.homework.clockin.time.data.a d16 = d();
        if (d16 != null) {
            Date parse = this.format.parse(str);
            if (parse != null) {
                j3 = parse.getTime();
            } else {
                j3 = 0;
            }
            d16.g(j3);
        }
    }
}
