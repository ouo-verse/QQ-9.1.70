package kr3;

import com.tencent.qmethod.monitor.ext.silence.AdHocDecorViewList;
import com.tencent.qmethod.pandoraex.core.o;
import com.tencent.qmethod.pandoraex.monitor.SilentCallMonitor;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0006R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lkr3/d;", "", "", "c", "Ljava/lang/reflect/Field;", "targetField", "", "b", "a", "Z", "isInject", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static boolean isInject;

    /* renamed from: b, reason: collision with root package name */
    public static final d f412911b = new d();

    d() {
    }

    private final void b(Field targetField) {
        try {
            Field accessFlagsField = Field.class.getDeclaredField("accessFlags");
            Intrinsics.checkExpressionValueIsNotNull(accessFlagsField, "accessFlagsField");
            accessFlagsField.setAccessible(true);
            targetField.setAccessible(true);
            accessFlagsField.setInt(targetField, targetField.getModifiers() & (-17));
        } catch (IllegalAccessException e16) {
            o.b("SilenceHook", "makeFieldNonFinal error:", e16);
        } catch (NoSuchFieldException e17) {
            o.b("SilenceHook", "makeFieldNonFinal error:", e17);
        }
    }

    private final boolean c() {
        Field mViewsField;
        Object invoke;
        if (!a.f412907d.d()) {
            o.a("SilenceHook", "can't find class or method");
            return false;
        }
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            mViewsField = cls.getDeclaredField("mViews");
            Intrinsics.checkExpressionValueIsNotNull(mViewsField, "mViewsField");
            b(mViewsField);
            invoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e16) {
            o.b("SilenceHook", "inject view error:", e16);
        }
        if (invoke == null) {
            o.a("SilenceHook", "can't find class");
            return false;
        }
        AdHocDecorViewList adHocDecorViewList = new AdHocDecorViewList();
        Object obj = mViewsField.get(invoke);
        if (obj instanceof List) {
            adHocDecorViewList.addAll((List) obj);
            mViewsField.set(invoke, adHocDecorViewList);
            o.a("SilenceHook", "inject view success, pre=" + ((List) obj).size());
            return true;
        }
        o.a("SilenceHook", "inject view fail, cur=" + obj.getClass().getName());
        return false;
    }

    public final void a() {
        if (isInject) {
            return;
        }
        isInject = true;
        o.a("SilenceHook", "start inject View Hook");
        if (c()) {
            SilentCallMonitor.setHookEnable(true);
        }
    }
}
