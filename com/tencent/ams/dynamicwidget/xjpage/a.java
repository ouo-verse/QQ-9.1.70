package com.tencent.ams.dynamicwidget.xjpage;

import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.fodder.TemplateManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ams/dynamicwidget/xjpage/a;", "", "", "templateId", "c", "", "a", "Ljava/lang/String;", "scene", "b", "jsBundleId", "()Ljava/lang/String;", "tag", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String scene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String jsBundleId;

    public a(@NotNull String scene, @NotNull String jsBundleId) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        Intrinsics.checkParameterIsNotNull(jsBundleId, "jsBundleId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) scene, (Object) jsBundleId);
        } else {
            this.scene = scene;
            this.jsBundleId = jsBundleId;
        }
    }

    public final boolean a(@Nullable String templateId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) templateId)).booleanValue();
        }
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(b(), "deleteTemplate - templateId: " + templateId);
        if (templateId != null) {
            return TemplateManager.getInstance().deleteTemplate(this.scene, templateId);
        }
        return false;
    }

    @NotNull
    public abstract String b();

    @Nullable
    public final String c(@Nullable String templateId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) templateId);
        }
        if (templateId != null) {
            return DKEngine.getTemplatePath(templateId, this.scene);
        }
        return null;
    }
}
