package com.tencent.qne.model;

import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u001f\b\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u0082\u0001\u0002\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qne/model/b;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "hardware", "", "b", "Ljava/util/List;", "()Ljava/util/List;", IQQGameCommApi.K_ABTEST_MODELS, "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Lcom/tencent/qne/model/d;", "Lcom/tencent/qne/model/e;", "qne_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes22.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String hardware;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> models;

    public /* synthetic */ b(String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, this, str, list, defaultConstructorMarker);
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.hardware;
    }

    @NotNull
    public final List<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.models;
    }

    b(String str, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) list);
        } else {
            this.hardware = str;
            this.models = list;
        }
    }
}
