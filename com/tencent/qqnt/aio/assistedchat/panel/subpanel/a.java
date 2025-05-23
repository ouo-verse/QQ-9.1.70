package com.tencent.qqnt.aio.assistedchat.panel.subpanel;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\u0003\u0010\u000bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000e\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/a;", "", "", "a", "I", "b", "()I", "emptyImage", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "emptyTitle", "emptyButton", "d", AdMetricTag.Report.TYPE, "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int emptyImage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String emptyTitle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String emptyButton;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String reportType;

    public a(int i3, @NotNull String emptyTitle, @NotNull String emptyButton, @Nullable String str) {
        Intrinsics.checkNotNullParameter(emptyTitle, "emptyTitle");
        Intrinsics.checkNotNullParameter(emptyButton, "emptyButton");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), emptyTitle, emptyButton, str);
            return;
        }
        this.emptyImage = i3;
        this.emptyTitle = emptyTitle;
        this.emptyButton = emptyButton;
        this.reportType = str;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.emptyButton;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.emptyImage;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.emptyTitle;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.reportType;
    }

    public /* synthetic */ a(int i3, String str, String str2, String str3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) == 0 ? str2 : "", (i16 & 8) != 0 ? null : str3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
