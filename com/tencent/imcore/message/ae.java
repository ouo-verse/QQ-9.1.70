package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.imcore.message.NtMsgFilterParser;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0006\u001a\u00020\u00052\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0007J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0007J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/imcore/message/ae;", "", "", "Lcom/tencent/mobileqq/data/MessageRecord;", "msg", "", "c", "mr", "b", "", "type", "", "uin", "a", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class ae {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ae f116475a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34087);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f116475a = new ae();
        }
    }

    ae() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x004f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean a(int type, @Nullable String uin) {
        NtMsgFilterParser.b bVar;
        long j3;
        if ((uin != null && (Intrinsics.areEqual(uin, AppConstants.REMINDER_UIN) || Intrinsics.areEqual(uin, AppConstants.DATALINE_NEW_VERSION_UIN))) || (bVar = (NtMsgFilterParser.b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100689")) == null) {
            return false;
        }
        List<Integer> a16 = bVar.a();
        if (type == 0 && a16.contains(0)) {
            if (uin == null) {
                return false;
            }
            if (!TextUtils.isEmpty(uin)) {
                j3 = Long.parseLong(uin);
                if (j3 > 10000) {
                    return false;
                }
                return true;
            }
            j3 = 0;
            if (j3 > 10000) {
            }
        } else {
            return a16.contains(Integer.valueOf(type));
        }
    }

    @JvmStatic
    public static final boolean b(@Nullable MessageRecord mr5) {
        if (mr5 == null) {
            return false;
        }
        return a(mr5.istroop, mr5.frienduin);
    }

    @JvmStatic
    public static final boolean c(@Nullable List<? extends MessageRecord> msg2) {
        if (msg2 == null || msg2.isEmpty()) {
            return false;
        }
        return b(msg2.get(0));
    }
}
