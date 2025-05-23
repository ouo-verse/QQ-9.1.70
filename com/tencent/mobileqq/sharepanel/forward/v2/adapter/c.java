package com.tencent.mobileqq.sharepanel.forward.v2.adapter;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.ioc.f;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR0\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/v2/adapter/c;", "", "", "b", "", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "newList", "d", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", ParseCommon.CONTAINER, "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getOnItemClick", "()Lkotlin/jvm/functions/Function1;", "e", "(Lkotlin/jvm/functions/Function1;)V", "onItemClick", "", "c", "Ljava/util/List;", "dataList", "<init>", "(Landroid/widget/LinearLayout;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super SharePanelContactItem, Unit> onItemClick;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<SharePanelContactItem> dataList;

    public c(@NotNull LinearLayout container) {
        Intrinsics.checkNotNullParameter(container, "container");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) container);
        } else {
            this.container = container;
            this.dataList = new ArrayList();
        }
    }

    private final void b() {
        f.k(f.f287347a, this.container, "em_share_object", null, 4, null);
        this.container.removeAllViews();
        int i3 = 0;
        for (Object obj : this.dataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            final SharePanelContactItem sharePanelContactItem = (SharePanelContactItem) obj;
            a aVar = new a(this.container);
            View b16 = aVar.b();
            this.container.addView(b16);
            boolean z16 = true;
            if (i3 == this.dataList.size() - 1) {
                z16 = false;
            }
            aVar.a(sharePanelContactItem, z16);
            f.f287347a.g(b16, "em_share_object", com.tencent.mobileqq.sharepanel.report.a.b(sharePanelContactItem));
            b16.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.sharepanel.forward.v2.adapter.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.c(c.this, sharePanelContactItem, view);
                }
            });
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(c this$0, SharePanelContactItem data, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Function1<? super SharePanelContactItem, Unit> function1 = this$0.onItemClick;
        if (function1 != null) {
            function1.invoke(data);
        }
        f.f287347a.d(view, "em_share_object", com.tencent.mobileqq.sharepanel.report.a.b(data));
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void d(@NotNull List<SharePanelContactItem> newList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) newList);
            return;
        }
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.dataList.clear();
        this.dataList.addAll(newList);
        b();
    }

    public final void e(@Nullable Function1<? super SharePanelContactItem, Unit> function1) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) function1);
        } else {
            this.onItemClick = function1;
        }
    }
}
