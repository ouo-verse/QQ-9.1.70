package kotlin.jvm.internal;

import com.tencent.thumbplayer.api.common.TPErrorType;
import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: P */
@SinceKotlin(version = "1.4")
/* loaded from: classes28.dex */
public class AdaptedFunctionReference implements FunctionBase, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int i3, Class cls, String str, String str2, int i16) {
        this(i3, CallableReference.NO_RECEIVER, cls, str, str2, i16);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        if (this.isTopLevel == adaptedFunctionReference.isTopLevel && this.arity == adaptedFunctionReference.arity && this.flags == adaptedFunctionReference.flags && Intrinsics.areEqual(this.receiver, adaptedFunctionReference.receiver) && Intrinsics.areEqual(this.owner, adaptedFunctionReference.owner) && this.name.equals(adaptedFunctionReference.name) && this.signature.equals(adaptedFunctionReference.signature)) {
            return true;
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            return Reflection.getOrCreateKotlinPackage(cls);
        }
        return Reflection.getOrCreateKotlinClass(cls);
    }

    public int hashCode() {
        int i3;
        int i16;
        Object obj = this.receiver;
        int i17 = 0;
        if (obj != null) {
            i3 = obj.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = i3 * 31;
        Class cls = this.owner;
        if (cls != null) {
            i17 = cls.hashCode();
        }
        int hashCode = (((((i18 + i17) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31;
        if (this.isTopLevel) {
            i16 = TPErrorType.TP_ERROR_TYPE_SELF_DEV_PLAYER_DECODER_SUBTITLE_STREAM;
        } else {
            i16 = 1237;
        }
        return ((((hashCode + i16) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        return Reflection.renderLambdaToString(this);
    }

    public AdaptedFunctionReference(int i3, Object obj, Class cls, String str, String str2, int i16) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = (i16 & 1) == 1;
        this.arity = i3;
        this.flags = i16 >> 1;
    }
}
