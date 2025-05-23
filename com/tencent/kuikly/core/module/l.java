package com.tencent.kuikly.core.module;

import com.tencent.kuikly.core.module.ICalendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0003\u0005B!\b\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u0082\u0001\u0002\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/kuikly/core/module/l;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "opt", "Lcom/tencent/kuikly/core/module/ICalendar$Field;", "Lcom/tencent/kuikly/core/module/ICalendar$Field;", "()Lcom/tencent/kuikly/core/module/ICalendar$Field;", "field", "", "c", "I", "()I", "value", "<init>", "(Ljava/lang/String;Lcom/tencent/kuikly/core/module/ICalendar$Field;I)V", "Lcom/tencent/kuikly/core/module/l$a;", "Lcom/tencent/kuikly/core/module/l$b;", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
abstract class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String opt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ICalendar.Field field;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/module/l$a;", "Lcom/tencent/kuikly/core/module/l;", "Lcom/tencent/kuikly/core/module/ICalendar$Field;", "field", "", "value", "<init>", "(Lcom/tencent/kuikly/core/module/ICalendar$Field;I)V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a extends l {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ICalendar.Field field, int i3) {
            super("add", field, i3, null);
            Intrinsics.checkNotNullParameter(field, "field");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/module/l$b;", "Lcom/tencent/kuikly/core/module/l;", "Lcom/tencent/kuikly/core/module/ICalendar$Field;", "field", "", "value", "<init>", "(Lcom/tencent/kuikly/core/module/ICalendar$Field;I)V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends l {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ICalendar.Field field, int i3) {
            super("set", field, i3, null);
            Intrinsics.checkNotNullParameter(field, "field");
        }
    }

    public /* synthetic */ l(String str, ICalendar.Field field, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, field, i3);
    }

    /* renamed from: a, reason: from getter */
    public final ICalendar.Field getField() {
        return this.field;
    }

    /* renamed from: b, reason: from getter */
    public final String getOpt() {
        return this.opt;
    }

    /* renamed from: c, reason: from getter */
    public final int getValue() {
        return this.value;
    }

    l(String str, ICalendar.Field field, int i3) {
        this.opt = str;
        this.field = field;
        this.value = i3;
    }
}
