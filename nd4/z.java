package nd4;

import android.support.annotation.NonNull;
import com.tencent.tab.tabmonitor.export.config.TabAggregateType;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    private String f420049a;

    /* renamed from: b, reason: collision with root package name */
    private TabAggregateType f420050b;

    public z(String str, TabAggregateType tabAggregateType) {
        this.f420049a = str;
        this.f420050b = tabAggregateType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public TabAggregateType a() {
        return this.f420050b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public String b() {
        return this.f420049a;
    }
}
