package com.tencent.mobileqq.troop.file.search.vm;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.troop.data.s;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0004\u0005\u0006\u0007\b\tB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0006\n\u000b\f\r\u000e\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/a;", "Lcom/tencent/qqnt/base/mvi/a;", "<init>", "()V", "a", "b", "c", "d", "e", "f", "Lcom/tencent/mobileqq/troop/file/search/vm/a$a;", "Lcom/tencent/mobileqq/troop/file/search/vm/a$b;", "Lcom/tencent/mobileqq/troop/file/search/vm/a$c;", "Lcom/tencent/mobileqq/troop/file/search/vm/a$d;", "Lcom/tencent/mobileqq/troop/file/search/vm/a$e;", "Lcom/tencent/mobileqq/troop/file/search/vm/a$f;", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class a implements com.tencent.qqnt.base.mvi.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/a$a;", "Lcom/tencent/mobileqq/troop/file/search/vm/a;", "", "a", "I", "b", "()I", "msg", "", "Ljava/lang/Object;", "()Ljava/lang/Object;", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "<init>", "(ILjava/lang/Object;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.file.search.vm.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C8686a extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int msg;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final Object any;

        /* renamed from: a, reason: from getter */
        public final Object getAny() {
            return this.any;
        }

        /* renamed from: b, reason: from getter */
        public final int getMsg() {
            return this.msg;
        }

        public C8686a(int i3, Object obj) {
            super(null);
            this.msg = i3;
            this.any = obj;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/a$b;", "Lcom/tencent/mobileqq/troop/file/search/vm/a;", "", "a", "Z", "()Z", "loadOver", "<init>", "(Z)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean loadOver;

        /* renamed from: a, reason: from getter */
        public final boolean getLoadOver() {
            return this.loadOver;
        }

        public b(boolean z16) {
            super(null);
            this.loadOver = z16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/a$c;", "Lcom/tencent/mobileqq/troop/file/search/vm/a;", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "msg", "", "b", "I", "()I", "type", "<init>", "(Ljava/lang/String;I)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String msg;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int type;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String msg2, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.msg = msg2;
            this.type = i3;
        }

        /* renamed from: a, reason: from getter */
        public final String getMsg() {
            return this.msg;
        }

        /* renamed from: b, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public /* synthetic */ c(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i16 & 2) != 0 ? 1 : i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/a$d;", "Lcom/tencent/mobileqq/troop/file/search/vm/a;", "", "a", "I", "()I", "busId", "<init>", "(I)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int busId;

        /* renamed from: a, reason: from getter */
        public final int getBusId() {
            return this.busId;
        }

        public d(int i3) {
            super(null);
            this.busId = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/a$e;", "Lcom/tencent/mobileqq/troop/file/search/vm/a;", "Lcom/tencent/mobileqq/troop/data/s;", "a", "Lcom/tencent/mobileqq/troop/data/s;", "()Lcom/tencent/mobileqq/troop/data/s;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "(Lcom/tencent/mobileqq/troop/data/s;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final s item;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(s item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        /* renamed from: a, reason: from getter */
        public final s getItem() {
            return this.item;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/troop/file/search/vm/a$f;", "Lcom/tencent/mobileqq/troop/file/search/vm/a;", "", "a", "I", "()I", "visibility", "<init>", "(I)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int visibility;

        /* renamed from: a, reason: from getter */
        public final int getVisibility() {
            return this.visibility;
        }

        public f(int i3) {
            super(null);
            this.visibility = i3;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
