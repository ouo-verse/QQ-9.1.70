package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u001b\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0003\u0010\u0018\"\u0004\b\u0019\u0010\u001aR2\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001cj\b\u0012\u0004\u0012\u00020\u0002`\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u000b\u0010\u001f\"\u0004\b \u0010!R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/tianshu/api/impl/c;", "", "", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "redPath", "", "b", "I", "f", "()I", "l", "(I)V", "redType", "c", "d", "j", "redNum", "", "Z", "()Z", h.F, "(Z)V", "faceAnim", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setFaceUinList", "(Ljava/util/ArrayList;)V", "faceUinList", "i", "imageUrl", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "text", "<init>", "()V", "tianshu-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String redPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int redType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int redNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean faceAnim;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> faceUinList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String imageUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String text;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.redPath = "";
        this.faceUinList = new ArrayList<>();
        this.imageUrl = "";
        this.text = "";
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.faceAnim;
    }

    @NotNull
    public final ArrayList<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.faceUinList;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.imageUrl;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.redNum;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.redPath;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.redType;
    }

    @NotNull
    public final String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.text;
    }

    public final void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.faceAnim = z16;
        }
    }

    public final void i(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.imageUrl = str;
        }
    }

    public final void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.redNum = i3;
        }
    }

    public final void k(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.redPath = str;
        }
    }

    public final void l(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.redType = i3;
        }
    }

    public final void m(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.text = str;
        }
    }
}
