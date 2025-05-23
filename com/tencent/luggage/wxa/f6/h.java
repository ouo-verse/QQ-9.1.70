package com.tencent.luggage.wxa.f6;

import android.content.Context;
import android.content.Intent;
import android.widget.FrameLayout;
import com.tencent.luggage.ui.WxaPreviewImageUI;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.cp.v;
import com.tencent.luggage.wxa.g6.o;
import com.tencent.luggage.wxa.g6.p;
import com.tencent.luggage.wxa.g6.t;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0015J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/luggage/wxa/f6/h;", "Lcom/tencent/luggage/wxa/g6/o;", "", "g", "", "b", "i", "finish", "Lcom/tencent/luggage/wxa/g6/t;", "controller", "<init>", "(Lcom/tencent/luggage/wxa/g6/t;)V", "a", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class h extends o {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Class<WxaPreviewImageUI> ACTIVITY_CLASS = WxaPreviewImageUI.class;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends Lambda implements Function1 {
        public b() {
            super(1);
        }

        public final void a(d it) {
            Intrinsics.checkNotNullParameter(it, "it");
            h.this.setResult(-1);
            h.this.finish();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((d) obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull t controller) {
        super(controller);
        Intrinsics.checkNotNullParameter(controller, "controller");
    }

    @Override // com.tencent.luggage.wxa.g6.o, com.tencent.luggage.wxa.g6.r
    public void b() {
        ArrayList<String> arrayList;
        int i3;
        super.b();
        Intent intent = getIntent();
        if (intent != null) {
            arrayList = intent.getStringArrayListExtra("KEY_URLS");
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        Intent intent2 = getIntent();
        if (intent2 != null) {
            i3 = intent2.getIntExtra("KEY_CURRENT_INDEX", 0);
        } else {
            i3 = 0;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        ((FrameLayout) findViewById(R.id.squ)).addView(new d(context, (String[]) array, i3, new b()), -1, -1);
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void finish() {
        overridePendingTransition(0, 0);
        super.finish();
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public int g() {
        return R.layout.dxx;
    }

    @Override // com.tencent.luggage.wxa.g6.r
    public void i() {
        setResult(-1);
        finish();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.f6.h$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, ArrayList urls, int i3, LuggageActivityHelper.d callback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(urls, "urls");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (urls.isEmpty()) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) h.class);
            intent.putStringArrayListExtra("KEY_URLS", urls);
            intent.putExtra("KEY_CURRENT_INDEX", i3);
            p.f126564o.a(context).a(context, intent, callback);
        }

        public final v a() {
            v vVar = new v(com.tencent.luggage.wxa.db.a.f124168a + "wxacache/");
            vVar.w();
            return vVar;
        }
    }
}
