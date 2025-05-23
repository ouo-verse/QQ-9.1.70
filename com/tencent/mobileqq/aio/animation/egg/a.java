package com.tencent.mobileqq.aio.animation.egg;

import android.text.TextUtils;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u0000 \u00192\u00020\u0001:\u0001\nB%\b\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0002H\u0016R$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0013\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/egg/a;", "", "", "message", "", "src", "", "c", "toString", "<set-?>", "a", "I", "b", "()I", "type", "Ljava/lang/String;", "()Ljava/lang/String;", "keyword", "matchMode", "d", "getSource", "(I)V", "source", "<init>", "(Ljava/lang/String;II)V", "e", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String keyword;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int matchMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int source;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/egg/a$a;", "", "", "type", "", "b", "str", "defVal", "a", "TAG", "Ljava/lang/String;", "TYPE_FACE", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.animation.egg.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        public final int a(@Nullable String str, int defVal) {
            boolean z16;
            Integer intOrNull;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, defVal)).intValue();
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
                if (intOrNull != null) {
                    return intOrNull.intValue();
                }
                return defVal;
            }
            return defVal;
        }

        public final int b(@Nullable String type) {
            boolean equals;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) type)).intValue();
            }
            if (!TextUtils.isEmpty(type)) {
                equals = StringsKt__StringsJVMKt.equals(PreDetect.FACE_DETECT, type, true);
                return equals ? 1 : 0;
            }
            return 0;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29796);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmOverloads
    public a(@NotNull String keyword, int i3, int i16) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, keyword, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.keyword = keyword;
        this.type = i3;
        this.matchMode = i16;
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.keyword;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.type;
    }

    public final boolean c(@NotNull String message, int src) {
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) message, src)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(message, "message");
        if (TextUtils.isEmpty(message) || TextUtils.isEmpty(this.keyword)) {
            return false;
        }
        if (src != 0 && (src & this.source) == 0) {
            return false;
        }
        int i3 = this.type;
        if (i3 == 0) {
            contains$default = this.matchMode == 1 ? Intrinsics.areEqual(message, this.keyword) : StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) this.keyword, false, 2, (Object) null);
        } else {
            if (i3 != 1 || !TextUtils.isDigitsOnly(this.keyword)) {
                return false;
            }
            String faceString = QQSysFaceUtil.getFaceString(QQSysFaceUtil.convertToLocal(Integer.parseInt(this.keyword)));
            Intrinsics.checkNotNullExpressionValue(faceString, "getFaceString(localId)");
            if (this.matchMode != 1) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) faceString, false, 2, (Object) null);
            } else {
                contains$default = Intrinsics.areEqual(message, faceString);
            }
        }
        return contains$default;
    }

    public final void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.source = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.keyword + "," + this.type;
    }
}
