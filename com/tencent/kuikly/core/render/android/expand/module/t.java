package com.tencent.kuikly.core.render.android.expand.module;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0007B!\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u0082\u0001\u0002\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/t;", "", "", "a", "Ljava/lang/String;", "opt", "", "b", "I", "field", "c", "value", "<init>", "(Ljava/lang/String;II)V", "Lcom/tencent/kuikly/core/render/android/expand/module/t$b;", "Lcom/tencent/kuikly/core/render/android/expand/module/t$a;", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public final String opt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public final int field;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/t$a;", "Lcom/tencent/kuikly/core/render/android/expand/module/t;", "", "field", "value", "<init>", "(II)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class a extends t {
        public a(int i3, int i16) {
            super("add", i3, i16, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/module/t$b;", "Lcom/tencent/kuikly/core/render/android/expand/module/t;", "", "field", "value", "<init>", "(II)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class b extends t {
        public b(int i3, int i16) {
            super("set", i3, i16, null);
        }
    }

    t(String str, int i3, int i16) {
        this.opt = str;
        this.field = i3;
        this.value = i16;
    }

    public /* synthetic */ t(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i16);
    }
}
