package com.tencent.qqnt.compress.pic.config;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/compress/pic/config/a;", "", "", "b", UserInfo.SEX_FEMALE, "DENSITY", "", "c", "I", "AIO_THUMB_PX_MAX", "d", "AIO_THUMB_PX_MIN", "<init>", "()V", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f355725a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final float DENSITY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int AIO_THUMB_PX_MAX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static final int AIO_THUMB_PX_MIN;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39385);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f355725a = new a();
        float f16 = BaseApplication.context.getResources().getDisplayMetrics().density;
        DENSITY = f16;
        AIO_THUMB_PX_MAX = (int) (135 * f16);
        AIO_THUMB_PX_MIN = (int) (45 * f16);
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
