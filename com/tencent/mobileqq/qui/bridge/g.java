package com.tencent.mobileqq.qui.bridge;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.QQUIAppSetting;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qui/bridge/g;", "Ltd0/g;", "Landroid/view/View;", "view", "", "profileId", "", "c", "token", "", "b", "a", "", "Ljava/util/Set;", "tokenWhiteList", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g implements td0.g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<String> tokenWhiteList;

    public g() {
        Set<String> mutableSetOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            mutableSetOf = SetsKt__SetsKt.mutableSetOf("qui_common_bg_bottom_standard.xml", "qui_common_bg_bottom_light.xml", "qui_common_fill_light_primary.xml", "qui_common_fill_light_secondary.xml");
            this.tokenWhiteList = mutableSetOf;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // td0.g
    @Nullable
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "qui_common_icon_primary.xml";
    }

    @Override // td0.g
    public boolean b(@Nullable String token) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) token)).booleanValue();
        }
        if (QQUIAppSetting.isGrayVersion() || QQUIAppSetting.isPublicVersion() || token == null || !this.tokenWhiteList.contains(token)) {
            return false;
        }
        return true;
    }

    @Override // td0.g
    public void c(@Nullable View view, @Nullable String profileId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) profileId);
        }
    }
}
