package com.tencent.mobileqq.sharepanel.multiSelect.util;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.nt.adapter.session.c;
import com.tencent.nt.adapter.session.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsgForwardNtUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/util/JumpUtil;", "", "Landroid/content/Context;", "context", "", "uin", "", "uinType", "name", "", "a", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class JumpUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final JumpUtil f287479a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39767);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f287479a = new JumpUtil();
        }
    }

    JumpUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull final Context context, @NotNull String uin, int uinType, @NotNull final String name) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, uin, Integer.valueOf(uinType), name);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(name, "name");
        c.j(uin, uinType, new Function2<Boolean, e, Unit>(context, name) { // from class: com.tencent.mobileqq.sharepanel.multiSelect.util.JumpUtil$openMiniAIO$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;
            final /* synthetic */ String $name;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$context = context;
                this.$name = name;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) context, (Object) name);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, e eVar) {
                invoke(bool.booleanValue(), eVar);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable e eVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), eVar);
                    return;
                }
                if (z16 && eVar != null) {
                    ((IMsgForwardNtUtil) QRoute.api(IMsgForwardNtUtil.class)).startForwardMiniAIO(this.$context, eVar.a(), eVar.b(), this.$name, true);
                    return;
                }
                QLog.e("JumpUtil", 1, "openMiniAIO failed. success=" + z16 + ", sessionWithUid=" + eVar);
            }
        });
    }
}
