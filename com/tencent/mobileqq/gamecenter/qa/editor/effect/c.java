package com.tencent.mobileqq.gamecenter.qa.editor.effect;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zd1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \r*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0004:\u0001\u000eB\t\b\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0002H\u0014R$\u0010\n\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/c;", "Lzd1/e;", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/gamecenter/qa/editor/effect/e;", "value", tl.h.F, "Ljava/lang/Class;", "b", "Ljava/lang/Class;", "mSpanClazz", "<init>", "()V", "c", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class c<C extends zd1.e<Boolean>> extends e<Boolean, C> {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Class<? extends zd1.e<Boolean>> mSpanClazz;

    /* JADX INFO: Access modifiers changed from: protected */
    public c() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(parameterizedType);
        Type type = parameterizedType.getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<out com.tencent.mobileqq.gamecenter.qa.editor.span.RTSpan<kotlin.Boolean>?>");
        this.mSpanClazz = (Class) type;
    }

    @Override // com.tencent.mobileqq.gamecenter.qa.editor.effect.e
    public /* bridge */ /* synthetic */ zd1.e<Boolean> g(Boolean bool) {
        return h(bool.booleanValue());
    }

    @Nullable
    protected zd1.e<Boolean> h(boolean value) {
        if (!value) {
            return null;
        }
        try {
            return this.mSpanClazz.newInstance();
        } catch (IllegalAccessException e16) {
            QLog.d("BooleanEffect", 1, "newSpan, IllegalAccessException=", e16);
            return null;
        } catch (InstantiationException e17) {
            QLog.d("BooleanEffect", 1, "newSpan, InstantiationException=", e17);
            return null;
        }
    }
}
