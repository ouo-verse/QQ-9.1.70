package com.tencent.qqnt.emotion.stickerrecommended.config;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/emotion/stickerrecommended/config/f;", "", "", "toString", "query", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "", "Lcom/tencent/qqnt/emotion/stickerrecommended/config/e;", "emojis", "Ljava/util/List;", "a", "()Ljava/util/List;", "setEmojis", "(Ljava/util/List;)V", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class f {
    static IPatchRedirector $redirector_;

    @SerializedName("emojis")
    @NotNull
    private List<e> emojis;

    @SerializedName("query")
    @NotNull
    private String query;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.query = "";
            this.emojis = new ArrayList();
        }
    }

    @NotNull
    public final List<e> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.emojis;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.query;
    }

    @NotNull
    public String toString() {
        int checkRadix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String simpleName = f.class.getSimpleName();
        int hashCode = hashCode();
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(hashCode, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        String str = this.query;
        Object[] array = this.emojis.toArray(new e[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String arrays = Arrays.toString(array);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        return simpleName + "@" + num + "{query: " + str + ", emojis: " + arrays + "}";
    }
}
