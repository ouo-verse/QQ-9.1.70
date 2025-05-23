package com.tencent.luggage.wxa.h5;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.h5.b;
import com.tencent.luggage.wxa.sb.d;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 !2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\rH\u0016J+\u0010\u0005\u001a\u00020\u00042!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00040\u0010H\u0016J\u0010\u0010\u0005\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/luggage/wxa/h5/c;", "Lcom/tencent/luggage/wxa/h5/a;", "Lcom/tencent/luggage/wxa/g6/a;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "", "bizUsername", "appId", "Lcom/tencent/luggage/wxa/h5/b$a;", "l", "Lcom/tencent/luggage/wxa/sb/d;", "itemChanged", "", "check", "on", "Lkotlin/Function1;", "Landroid/content/Intent;", "Lkotlin/ParameterName;", "name", "intent", "callback", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/luggage/wxa/g5/c;", "subscribeMsgSettingData", "Lcom/tencent/luggage/wxa/g6/a;", "b", "Lcom/tencent/luggage/wxa/g5/c;", "c", "Z", "changed", "<init>", "()V", "d", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class c extends a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.g6.a activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public com.tencent.luggage.wxa.g5.c subscribeMsgSettingData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean changed;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b.a f126867b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(b.a aVar) {
            super(1);
            this.f126867b = aVar;
        }

        public final void a(com.tencent.luggage.wxa.g5.c cVar) {
            c.this.subscribeMsgSettingData = cVar;
            c cVar2 = c.this;
            cVar2.a(this.f126867b, cVar2.subscribeMsgSettingData);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((com.tencent.luggage.wxa.g5.c) obj);
            return Unit.INSTANCE;
        }
    }

    @Override // com.tencent.luggage.wxa.h5.a
    public void a(com.tencent.luggage.wxa.g6.a activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.a(activity);
        this.activity = activity;
    }

    @Override // com.tencent.luggage.wxa.h5.b
    public void a(String bizUsername, String appId, b.a l3) {
        Intrinsics.checkNotNullParameter(bizUsername, "bizUsername");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(l3, "l");
        com.tencent.luggage.wxa.g6.a aVar = this.activity;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            aVar = null;
        }
        Intent intent = aVar.getIntent();
        com.tencent.luggage.wxa.g5.c cVar = intent != null ? (com.tencent.luggage.wxa.g5.c) intent.getParcelableExtra("key_biz_data") : null;
        this.subscribeMsgSettingData = cVar;
        if (cVar == null) {
            com.tencent.luggage.wxa.j5.a.f130859a.a(bizUsername, appId, new b(l3));
        } else {
            a(l3, cVar);
        }
    }

    public final void a(b.a l3, com.tencent.luggage.wxa.g5.c subscribeMsgSettingData) {
        if (subscribeMsgSettingData == null) {
            l3.a();
        } else {
            l3.a(subscribeMsgSettingData);
        }
    }

    @Override // com.tencent.luggage.wxa.h5.b
    public void a(d itemChanged, boolean check) {
        Intrinsics.checkNotNullParameter(itemChanged, "itemChanged");
        this.changed = true;
        com.tencent.luggage.wxa.g5.c cVar = this.subscribeMsgSettingData;
        Intrinsics.checkNotNull(cVar);
        for (d dVar : cVar.c()) {
            if (TextUtils.equals(itemChanged.f(), dVar.f())) {
                dVar.a(check ? 1 : 0);
                return;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.h5.b
    public void a(boolean on5) {
        this.changed = true;
        com.tencent.luggage.wxa.g5.c cVar = this.subscribeMsgSettingData;
        if (cVar == null) {
            return;
        }
        cVar.a(on5);
    }

    @Override // com.tencent.luggage.wxa.h5.a
    public void a(Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.changed || this.subscribeMsgSettingData == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("key_biz_data", this.subscribeMsgSettingData);
        callback.invoke(intent);
    }

    @Override // com.tencent.luggage.wxa.h5.b
    public boolean a(d item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.e() == 1;
    }
}
