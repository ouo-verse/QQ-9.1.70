package com.tencent.mobileqq.reminder.db.entity;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76$MsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/reminder/db/entity/a;", "", "Ltencent/im/s2c/msgtype0x210/submsgtype0x76/SubMsgType0x76$MsgBody;", "msg", "", "a", "<init>", "()V", "qqreminder-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f281039a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23890);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f281039a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public String a(@NotNull SubMsgType0x76$MsgBody msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        String stringUtf8 = msg2.bytes_notify_wording.get().toStringUtf8();
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (TextUtils.isEmpty(stringUtf8)) {
            if (msg2.uint32_msg_type.get() == 1) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = mobileQQ.getString(R.string.f170151hf);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.af_geo_push_tips)");
                stringUtf8 = String.format(string, Arrays.copyOf(new Object[]{msg2.msg_geographic_notify.bytes_local_city.get().toStringUtf8()}, 1));
                Intrinsics.checkNotNullExpressionValue(stringUtf8, "format(format, *args)");
            } else if (msg2.uint32_msg_type.get() == 2) {
                stringUtf8 = mobileQQ.getString(R.string.f170149hd);
            } else if (msg2.uint32_msg_type.get() == 3) {
                stringUtf8 = mobileQQ.getString(R.string.f170153hh);
            }
        }
        Intrinsics.checkNotNull(stringUtf8);
        return stringUtf8;
    }
}
