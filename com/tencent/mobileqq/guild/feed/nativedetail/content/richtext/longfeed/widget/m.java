package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.widget;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JC\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00042\u001a\u0010\n\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00020\t\"\u0006\u0012\u0002\b\u00030\u0002H\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\n\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J9\u0010\u0014\u001a\u00020\u00132\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u0012\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\t\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/m;", "", "Ljava/lang/Class;", "cls", "", "fieldName", "Ljava/lang/reflect/Field;", "b", "methodName", "", PushClientConstants.TAG_PARAM_TYPES, "Ljava/lang/reflect/Method;", "c", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/richtext/longfeed/widget/a;", "a", "method", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "args", "", "d", "(Ljava/lang/reflect/Method;Ljava/lang/Object;[Ljava/lang/Object;)V", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final m f221619a = new m();

    m() {
    }

    private final Field b(Class<?> cls, String fieldName) {
        try {
            Field declaredField = cls.getDeclaredField(fieldName);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Exception e16) {
            QLog.e("SelectableTextUtils", 1, "getEditorField exception: " + e16.getMessage() + ", " + fieldName);
            return null;
        }
    }

    private final Method c(Class<?> cls, String methodName, Class<?>... paramTypes) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod(methodName, (Class[]) Arrays.copyOf(paramTypes, paramTypes.length));
            if (declaredMethod == null) {
                return null;
            }
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e16) {
            QLog.e("SelectableTextUtils", 1, "getMethod exception: " + e16.getMessage() + ", method: " + methodName);
            return null;
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi", "BlockedPrivateApi"})
    @Nullable
    public final EditorFields a() {
        Field field;
        Field field2;
        Field field3;
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Class<? super Object> cls4;
        Class<?> type;
        Class<?> type2;
        Class<? super Object> superclass;
        try {
            Class<?> editorCls = Class.forName("android.widget.Editor");
            Intrinsics.checkNotNullExpressionValue(editorCls, "editorCls");
            Field b16 = b(editorCls, "mSelectionModifierCursorController");
            if (b16 != null) {
                m mVar = f221619a;
                Class<?> type3 = b16.getType();
                Intrinsics.checkNotNullExpressionValue(type3, "it.type");
                field = mVar.b(type3, "mStartHandle");
            } else {
                field = null;
            }
            if (b16 != null) {
                m mVar2 = f221619a;
                Class<?> type4 = b16.getType();
                Intrinsics.checkNotNullExpressionValue(type4, "it.type");
                field2 = mVar2.b(type4, "mEndHandle");
            } else {
                field2 = null;
            }
            if (field != null && (type2 = field.getType()) != null && (superclass = type2.getSuperclass()) != null) {
                field3 = f221619a.b(superclass, "mDrawable");
            } else {
                field3 = null;
            }
            Field b17 = b(TextView.class, "mEditor");
            if (field2 != null) {
                cls = field2.getType();
            } else {
                cls = null;
            }
            Method c16 = c(cls, "positionAndAdjustForCrossingHandles", Integer.TYPE, Boolean.TYPE);
            if (b16 != null) {
                cls2 = b16.getType();
            } else {
                cls2 = null;
            }
            Method c17 = c(cls2, "show", new Class[0]);
            if (b16 != null) {
                cls3 = b16.getType();
            } else {
                cls3 = null;
            }
            Method c18 = c(cls3, "hide", new Class[0]);
            if (field2 != null && (type = field2.getType()) != null) {
                cls4 = type.getSuperclass();
            } else {
                cls4 = null;
            }
            return new EditorFields(b17, b16, field, field2, field3, c16, c17, c18, c(cls4, "updateMagnifier", MotionEvent.class));
        } catch (Exception e16) {
            QLog.e("SelectableTextUtils", 1, "getEditorFields exception: " + e16.getMessage());
            return null;
        }
    }

    public final void d(@Nullable Method method, @Nullable Object instance, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        if (method != null) {
            try {
                method.invoke(instance, Arrays.copyOf(args, args.length));
            } catch (Exception e16) {
                QLog.e("GestureTextView", 1, "invokeMethod exception: " + e16.getMessage());
            }
        }
    }
}
