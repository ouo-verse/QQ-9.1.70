package com.tencent.qqnt.qbasealbum.filter;

import android.content.Context;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.inject.g;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J$\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/filter/b;", "", "Landroid/content/Context;", "context", "", "infoValidStatus", "", "c", "", "a", "Lkotlin/Function0;", "onStatusValidated", "b", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f361200a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38981);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f361200a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String c(Context context, int infoValidStatus) {
        switch (infoValidStatus) {
            case -6:
                return context.getString(R.string.f17710332);
            case -5:
                return context.getString(R.string.f1770332v);
            case -4:
                long l3 = QAlbumPickerContext.f361201a.e().q().l() / 1000;
                return context.getString(R.string.f1769932r) + l3 + " \u79d2";
            case -3:
                long p16 = QAlbumPickerContext.f361201a.e().q().p() / 1000;
                return context.getString(R.string.f1770032s) + p16 + " \u79d2";
            case -2:
                return context.getString(R.string.f1770232u);
            case -1:
                return context.getString(R.string.f1770132t);
            default:
                return null;
        }
    }

    public final void a(@NotNull Context context, int infoValidStatus) {
        String c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, infoValidStatus);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (!FastClickUtils.isFastDoubleClick("key_show_toast_interval", 2000L) && (c16 = c(context, infoValidStatus)) != null) {
            g.f361234b.showToast(context, c16, 0);
        }
    }

    public final void b(@NotNull Context context, int infoValidStatus, @NotNull Function0<Unit> onStatusValidated) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(infoValidStatus), onStatusValidated);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onStatusValidated, "onStatusValidated");
        if (infoValidStatus == 0) {
            onStatusValidated.invoke();
        } else {
            a(context, infoValidStatus);
        }
    }
}
