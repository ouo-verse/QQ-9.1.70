package bp3;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u0000  2\u00020\u0001:\u0001\bBs\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000f\u0010\b\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\b\b\u0010\tR\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001f\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\rR\u001f\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\rR\u001f\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\r\u00a8\u0006!"}, d2 = {"Lbp3/e;", "", "other", "", "equals", "", "hashCode", "", "a", "()V", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnDone", "()Lkotlin/jvm/functions/Function0;", "onDone", "b", "getOnGo", "onGo", "c", "getOnNext", "onNext", "d", "getOnPrevious", "onPrevious", "e", "getOnSearch", "onSearch", "f", "getOnSend", "onSend", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "g", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class e {

    /* renamed from: h, reason: collision with root package name */
    private static final e f28885h = new e(null, null, null, null, null, null, 63, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> onDone;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> onGo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> onNext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> onPrevious;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> onSearch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> onSend;

    public e() {
        this(null, null, null, null, null, null, 63, null);
    }

    public final void a() {
        Function0<Unit> function0 = this.onGo;
        if (function0 != null) {
            function0.invoke();
        }
        Function0<Unit> function02 = this.onSearch;
        if (function02 != null) {
            function02.invoke();
        }
        Function0<Unit> function03 = this.onSend;
        if (function03 != null) {
            function03.invoke();
        }
        Function0<Unit> function04 = this.onNext;
        if (function04 != null) {
            function04.invoke();
        }
        Function0<Unit> function05 = this.onDone;
        if (function05 != null) {
            function05.invoke();
        }
        Function0<Unit> function06 = this.onPrevious;
        if (function06 != null) {
            function06.invoke();
        }
    }

    public int hashCode() {
        Function0<Unit> function0 = this.onDone;
        int hashCode = (function0 != null ? function0.hashCode() : 0) * 31;
        Function0<Unit> function02 = this.onGo;
        int hashCode2 = (hashCode + (function02 != null ? function02.hashCode() : 0)) * 31;
        Function0<Unit> function03 = this.onNext;
        int hashCode3 = (hashCode2 + (function03 != null ? function03.hashCode() : 0)) * 31;
        Function0<Unit> function04 = this.onPrevious;
        int hashCode4 = (hashCode3 + (function04 != null ? function04.hashCode() : 0)) * 31;
        Function0<Unit> function05 = this.onSearch;
        int hashCode5 = (hashCode4 + (function05 != null ? function05.hashCode() : 0)) * 31;
        Function0<Unit> function06 = this.onSend;
        return hashCode5 + (function06 != null ? function06.hashCode() : 0);
    }

    public e(Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function0<Unit> function05, Function0<Unit> function06) {
        this.onDone = function0;
        this.onGo = function02;
        this.onNext = function03;
        this.onPrevious = function04;
        this.onSearch = function05;
        this.onSend = function06;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof e)) {
            return false;
        }
        e eVar = (e) other;
        return Intrinsics.areEqual(this.onDone, eVar.onDone) && Intrinsics.areEqual(this.onGo, eVar.onGo) && Intrinsics.areEqual(this.onNext, eVar.onNext) && Intrinsics.areEqual(this.onPrevious, eVar.onPrevious) && Intrinsics.areEqual(this.onSearch, eVar.onSearch) && Intrinsics.areEqual(this.onSend, eVar.onSend);
    }

    public /* synthetic */ e(Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function0 function05, Function0 function06, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : function0, (i3 & 2) != 0 ? null : function02, (i3 & 4) != 0 ? null : function03, (i3 & 8) != 0 ? null : function04, (i3 & 16) != 0 ? null : function05, (i3 & 32) != 0 ? null : function06);
    }
}
