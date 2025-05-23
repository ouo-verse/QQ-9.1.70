package nd4;

import android.support.annotation.NonNull;
import com.tencent.tab.tabmonitor.export.config.TabAggregateType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private String f420001a;

    /* renamed from: b, reason: collision with root package name */
    private TabAggregateType f420002b;

    /* renamed from: c, reason: collision with root package name */
    private float f420003c;

    /* renamed from: d, reason: collision with root package name */
    private int f420004d;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private String f420005a;

        /* renamed from: b, reason: collision with root package name */
        private TabAggregateType f420006b;

        /* renamed from: c, reason: collision with root package name */
        private float f420007c;

        /* renamed from: d, reason: collision with root package name */
        private int f420008d;

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public a e(@NonNull TabAggregateType tabAggregateType) {
            this.f420006b = tabAggregateType;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public j f() {
            return new j(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public a g(@NonNull int i3) {
            this.f420008d = i3;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public a h(@NonNull String str) {
            this.f420005a = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public a i(@NonNull float f16) {
            this.f420007c = f16;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @NonNull
        public j j(@NonNull j jVar, @NonNull float f16, @NonNull int i3) {
            h(jVar.c()).e(jVar.a()).i(f16).g(i3);
            return new j(this);
        }
    }

    public j(a aVar) {
        this.f420001a = aVar.f420005a;
        this.f420003c = aVar.f420007c;
        this.f420004d = aVar.f420008d;
        this.f420002b = aVar.f420006b;
    }

    public TabAggregateType a() {
        return this.f420002b;
    }

    public int b() {
        return this.f420004d;
    }

    public String c() {
        return this.f420001a;
    }

    public float d() {
        return this.f420003c;
    }

    public String toString() {
        return "TabAggregatePolicyItem{mPolicyName='" + this.f420001a + "', mAggregateType=" + this.f420002b + ", mPolicyValue=" + this.f420003c + ", mPolicyCount=" + this.f420004d + '}';
    }
}
