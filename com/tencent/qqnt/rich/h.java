package com.tencent.qqnt.rich;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.QZoneShareManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/rich/h;", "", "Lcom/tencent/android/androidbypass/richui/view/j;", "a", "Lcom/tencent/android/androidbypass/richui/view/j;", "b", "()Lcom/tencent/android/androidbypass/richui/view/j;", "viewClickListener", "", "Ljava/lang/String;", "()Ljava/lang/String;", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "<init>", "(Lcom/tencent/android/androidbypass/richui/view/j;Ljava/lang/String;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.android.androidbypass.richui.view.j viewClickListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String defaultText;

    public h() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.defaultText;
    }

    @Nullable
    public final com.tencent.android.androidbypass.richui.view.j b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.android.androidbypass.richui.view.j) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.viewClickListener;
    }

    public h(@Nullable com.tencent.android.androidbypass.richui.view.j jVar, @NotNull String defaultText) {
        Intrinsics.checkNotNullParameter(defaultText, "defaultText");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) jVar, (Object) defaultText);
        } else {
            this.viewClickListener = jVar;
            this.defaultText = defaultText;
        }
    }

    public /* synthetic */ h(com.tencent.android.androidbypass.richui.view.j jVar, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : jVar, (i3 & 2) != 0 ? "\u6682\u4e0d\u652f\u6301\u5c55\u793a\uff0c\u8bf7\u5347\u7ea7QQ\u7248\u672c\u3002" : str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, jVar, str, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
