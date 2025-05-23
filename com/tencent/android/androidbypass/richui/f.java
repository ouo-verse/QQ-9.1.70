package com.tencent.android.androidbypass.richui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0019\u0012\b\u0010!\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u000f\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0014\u0010\u001cR\u0019\u0010!\u001a\u0004\u0018\u00010\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001f\u001a\u0004\b\u001a\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/android/androidbypass/richui/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/json/JSONObject;", "a", "Lorg/json/JSONObject;", "c", "()Lorg/json/JSONObject;", "layoutData", "b", "attrData", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "direction", "d", "Z", "f", "()Z", "isRoot", "Lcom/tencent/android/androidbypass/richui/d;", "e", "Lcom/tencent/android/androidbypass/richui/d;", "()Lcom/tencent/android/androidbypass/richui/d;", "normalOptions", "Lcom/tencent/android/androidbypass/richui/b;", "Lcom/tencent/android/androidbypass/richui/b;", "()Lcom/tencent/android/androidbypass/richui/b;", "processInterface", "<init>", "(Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/Integer;ZLcom/tencent/android/androidbypass/richui/d;Lcom/tencent/android/androidbypass/richui/b;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject layoutData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject attrData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Integer direction;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isRoot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d normalOptions;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final b processInterface;

    public f(@NotNull JSONObject layoutData, @NotNull JSONObject attrData, @Nullable Integer num, boolean z16, @NotNull d normalOptions, @Nullable b bVar) {
        Intrinsics.checkNotNullParameter(layoutData, "layoutData");
        Intrinsics.checkNotNullParameter(attrData, "attrData");
        Intrinsics.checkNotNullParameter(normalOptions, "normalOptions");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, layoutData, attrData, num, Boolean.valueOf(z16), normalOptions, bVar);
            return;
        }
        this.layoutData = layoutData;
        this.attrData = attrData;
        this.direction = num;
        this.isRoot = z16;
        this.normalOptions = normalOptions;
        this.processInterface = bVar;
    }

    @NotNull
    public final JSONObject a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (JSONObject) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.attrData;
    }

    @Nullable
    public final Integer b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Integer) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.direction;
    }

    @NotNull
    public final JSONObject c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (JSONObject) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.layoutData;
    }

    @NotNull
    public final d d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (d) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.normalOptions;
    }

    @Nullable
    public final b e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.processInterface;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof f) {
                f fVar = (f) other;
                if (!Intrinsics.areEqual(this.layoutData, fVar.layoutData) || !Intrinsics.areEqual(this.attrData, fVar.attrData) || !Intrinsics.areEqual(this.direction, fVar.direction) || this.isRoot != fVar.isRoot || !Intrinsics.areEqual(this.normalOptions, fVar.normalOptions) || !Intrinsics.areEqual(this.processInterface, fVar.processInterface)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isRoot;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        JSONObject jSONObject = this.layoutData;
        int i19 = 0;
        if (jSONObject != null) {
            i3 = jSONObject.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = i3 * 31;
        JSONObject jSONObject2 = this.attrData;
        if (jSONObject2 != null) {
            i16 = jSONObject2.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        Integer num = this.direction;
        if (num != null) {
            i17 = num.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        boolean z16 = this.isRoot;
        int i29 = z16;
        if (z16 != 0) {
            i29 = 1;
        }
        int i36 = (i28 + i29) * 31;
        d dVar = this.normalOptions;
        if (dVar != null) {
            i18 = dVar.hashCode();
        } else {
            i18 = 0;
        }
        int i37 = (i36 + i18) * 31;
        b bVar = this.processInterface;
        if (bVar != null) {
            i19 = bVar.hashCode();
        }
        return i37 + i19;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return "RichUIOptions(layoutData=" + this.layoutData + ", attrData=" + this.attrData + ", direction=" + this.direction + ", isRoot=" + this.isRoot + ", normalOptions=" + this.normalOptions + ", processInterface=" + this.processInterface + ")";
    }

    public /* synthetic */ f(JSONObject jSONObject, JSONObject jSONObject2, Integer num, boolean z16, d dVar, b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject, jSONObject2, num, (i3 & 8) != 0 ? false : z16, dVar, bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, this, jSONObject, jSONObject2, num, Boolean.valueOf(z16), dVar, bVar, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
