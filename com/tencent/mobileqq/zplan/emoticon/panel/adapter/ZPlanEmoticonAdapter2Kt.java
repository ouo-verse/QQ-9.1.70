package com.tencent.mobileqq.zplan.emoticon.panel.adapter;

import android.view.View;
import com.google.android.material.tabs.TabLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.aio.panel.page.Page;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.aio.panel.panel.view.AioPanelLayout;
import com.tencent.mobileqq.zplan.emoticon.api.IZPlanEmoticonInfoHelper;
import com.tencent.mobileqq.zplan.utils.z;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import tl.h;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0014\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\"6\u0010\u0010\u001a\u0004\u0018\u00010\n\"\b\b\u0000\u0010\t*\u00020\b*\u00028\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\n8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/panel/view/AioPanelLayout;", "", "tabName", "", "f", "", "index", "e", "Landroid/view/View;", "T", "", "value", "d", "(Landroid/view/View;)Ljava/lang/Object;", h.F, "(Landroid/view/View;Ljava/lang/Object;)V", "observerTag", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonAdapter2Kt {
    private static final void e(AioPanelLayout aioPanelLayout, int i3) {
        TabLayout.g B = aioPanelLayout.getTabLayout().B(i3);
        if (B != null) {
            B.m();
        }
        aioPanelLayout.getViewPager().setCurrentItem(i3, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(AioPanelLayout aioPanelLayout, final String str) {
        StateFlow<Panel> a16;
        Panel value;
        List<Page> b16;
        Integer a17;
        QLog.i(BaseEmotionAdapter.TAG, 1, "openPage, targetPage:" + str);
        int i3 = 0;
        if (str != null && (a16 = aioPanelLayout.a()) != null && (value = a16.getValue()) != null && (b16 = value.b()) != null && (a17 = z.a(b16, new Function1<Page, Boolean>() { // from class: com.tencent.mobileqq.zplan.emoticon.panel.adapter.ZPlanEmoticonAdapter2Kt$openPage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Page it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it.getTabName(), str));
            }
        })) != null) {
            i3 = a17.intValue();
        }
        e(aioPanelLayout, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends View> Object d(T t16) {
        return t16.getTag(R.id.r4a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends View> void h(T t16, Object obj) {
        t16.setTag(R.id.r4a, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(AioPanelLayout aioPanelLayout, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = ((IZPlanEmoticonInfoHelper) QRoute.api(IZPlanEmoticonInfoHelper.class)).getEmoticonNextOpenPage();
        }
        f(aioPanelLayout, str);
    }
}
