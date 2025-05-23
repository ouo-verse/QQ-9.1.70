package com.tencent.ecommerce.biz.register.refactoring.viewmodel;

import androidx.lifecycle.ViewModel;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.config.service.b;
import com.tencent.ecommerce.biz.register.officialAccountFollowedChecker.ECAccountFollowedCheckerViewModel;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import java.util.Calendar;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u000f\u001a\u00020\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/a;", "Landroidx/lifecycle/ViewModel;", "", "L1", "", "timestamp", "", "Q1", "", "idCardNum", "N1", "idString", "O1", MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, "P1", "M1", "<init>", "()V", "i", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends ViewModel {
    public final boolean L1() {
        return (System.currentTimeMillis() / ((long) 1000)) - IECLocalConfig.a.e(ECLocalConfig.f100650f, "ec_captcha_timestamp_sp_key", 0L, null, 4, null) > ((Number) b.f100655b.a(631, "verify_time", 300)).longValue();
    }

    public final void M1() {
        new ECAccountFollowedCheckerViewModel().N1(1, 2);
    }

    public final boolean N1(String idCardNum) {
        IntRange until;
        String slice;
        IntRange until2;
        String slice2;
        IntRange until3;
        String slice3;
        if (idCardNum.length() == 15) {
            return true;
        }
        if (idCardNum.length() != 18) {
            return false;
        }
        try {
            until = RangesKt___RangesKt.until(6, 10);
            slice = StringsKt___StringsKt.slice(idCardNum, until);
            int parseInt = Integer.parseInt(slice);
            until2 = RangesKt___RangesKt.until(10, 12);
            slice2 = StringsKt___StringsKt.slice(idCardNum, until2);
            int parseInt2 = Integer.parseInt(slice2);
            until3 = RangesKt___RangesKt.until(12, 14);
            slice3 = StringsKt___StringsKt.slice(idCardNum, until3);
            int parseInt3 = Integer.parseInt(slice3);
            long currentTimeMillis = System.currentTimeMillis();
            cg0.a.b("ECRegisterUserInfoViewModel", "[isAdult] birthday = " + parseInt + '-' + parseInt2 + '-' + parseInt3 + ", now = " + currentTimeMillis);
            Calendar calendar = Calendar.getInstance();
            calendar.set(parseInt + 18, parseInt2 - 1, parseInt3);
            return calendar.getTimeInMillis() < currentTimeMillis;
        } catch (Exception e16) {
            cg0.a.a("ECRegisterUserInfoViewModel", "isAdult", "[isAdult] error = " + e16);
            return false;
        }
    }

    public final boolean O1(String idString) {
        if (idString.length() == 0) {
            return false;
        }
        return Pattern.compile("(\\d{17}[0-9a-zA-Z])|(\\d{14}[0-9a-zA-Z])").matcher(idString).matches();
    }

    public final void Q1(long timestamp) {
        IECLocalConfig.a.i(ECLocalConfig.f100650f, "ec_captcha_timestamp_sp_key", timestamp, null, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean P1(String phoneNumber) {
        boolean z16;
        boolean isBlank;
        if (phoneNumber != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(phoneNumber);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    return Pattern.compile("^1[3-9][0-9]{9}$").matcher(phoneNumber).matches();
                }
                return false;
            }
        }
        z16 = true;
        if (z16) {
        }
    }
}
