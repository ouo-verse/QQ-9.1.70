package kotlin.jvm;

import com.tencent.ams.adcore.mma.api.Global;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationTarget;

/* compiled from: P */
@Target({ElementType.METHOD})
@SinceKotlin(version = Global.TRACKING_SDKVS_VALUE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lkotlin/jvm/JvmDefault;", "", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(message = "Switch to new -Xjvm-default modes: `all` or `all-compatibility`")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes28.dex */
public @interface JvmDefault {
}
