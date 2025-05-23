package pe4;

import com.tencent.tbs.logger.c;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    ThreadLocal<SimpleDateFormat> f426059a = new C11011a();

    /* compiled from: P */
    /* renamed from: pe4.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    class C11011a extends ThreadLocal<SimpleDateFormat> {
        C11011a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT, Locale.US);
        }
    }

    @Override // pe4.b
    public boolean a() {
        return true;
    }

    @Override // pe4.b
    public String b(c cVar) {
        long currentTimeMillis;
        if (cVar != null) {
            currentTimeMillis = cVar.f374482a;
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        SimpleDateFormat simpleDateFormat = this.f426059a.get();
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        return simpleDateFormat.format(new Date(currentTimeMillis));
    }
}
