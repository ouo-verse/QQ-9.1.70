package com.tencent.qne.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qne/model/a;", "Lcom/tencent/qne/model/Backend;", "<init>", "()V", "qne_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public final class a extends Backend {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f344348g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14771);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f344348g = new a();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    a() {
        super(PreDownloadConstants.RPORT_KEY_CPU, "NCNN", r3, null, "ncnn", 8, null);
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(DependencyLibrary.NCNN_COMMON);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
