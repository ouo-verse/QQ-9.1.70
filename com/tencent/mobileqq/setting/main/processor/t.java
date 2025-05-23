package com.tencent.mobileqq.setting.main.processor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.setting.main.config.SearchItemConfig;
import com.tencent.mobileqq.setting.search.FunctionSearchActivity;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/setting/main/processor/t;", "Lcom/tencent/mobileqq/setting/processor/c;", "Lcom/tencent/mobileqq/setting/main/config/SearchItemConfig;", HippyTKDListViewAdapter.X, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class t extends com.tencent.mobileqq.setting.processor.c {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Context context) {
        super(context, 13);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(t this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.setting.processor.f i3 = this$0.i();
        iq2.c.d(i3 != null ? i3.b() : null, null);
        Activity e16 = this$0.e();
        if (e16 != null) {
            e16.startActivity(new Intent(e16, (Class<?>) FunctionSearchActivity.class));
            e16.overridePendingTransition(0, R.anim.f155053hw);
        }
        com.tencent.mobileqq.setting.utils.o oVar = com.tencent.mobileqq.setting.utils.o.f286768a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.setting.utils.o.g(oVar, it, "em_bas_search_box", null, 4, null);
        QLog.d("SearchItemConfig", 1, "search bar on click!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.f286768a.l(it, "em_bas_search_box", null, false);
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public SearchItemConfig q() {
        SearchItemConfig searchItemConfig = new SearchItemConfig();
        searchItemConfig.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.main.processor.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.y(t.this, view);
            }
        });
        searchItemConfig.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.main.processor.s
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                t.z(view);
            }
        });
        return searchItemConfig;
    }
}
