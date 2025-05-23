package com.tencent.mobileqq.search.business.contact;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.model.v;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.ae;
import com.tencent.qqnt.kernel.nativeinterface.IGetSearchBudlyCoreCallback;
import com.tencent.qqnt.kernel.nativeinterface.SearchCoreBuddyItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\"\u0010\u0012\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/h;", "Lon2/b;", "Lcom/tencent/mobileqq/search/model/v;", "", "keyword", "Lon2/d;", "listener", "", "f", "init", "Lpn2/a;", "searchRequest", "", "a", "cancel", "pause", "resume", "destroy", "c", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "d", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h implements on2.b<v> {
    public h(@NotNull AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
    }

    private final void f(final String keyword, final on2.d<v> listener) {
        ae b16 = com.tencent.mobileqq.search.util.n.b();
        if (b16 != null) {
            b16.searchCoreBuddy(new IGetSearchBudlyCoreCallback() { // from class: com.tencent.mobileqq.search.business.contact.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetSearchBudlyCoreCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    h.g(keyword, listener, this, i3, str, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(final String keyword, final on2.d dVar, final h this$0, final int i3, String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(keyword, "$keyword");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QQSearch.Local.ContactSpecialCareSearchNewEngine", 1, "querySpecialCareContact keyword=" + keyword + " result=" + i3 + ", errMsg=" + str + " specialCare.size:" + arrayList.size());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.search.business.contact.g
            @Override // java.lang.Runnable
            public final void run() {
                h.h(i3, dVar, keyword, arrayList, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, on2.d dVar, String keyword, ArrayList items, h this$0) {
        List emptyList;
        Intrinsics.checkNotNullParameter(keyword, "$keyword");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.mobileqq.search.util.n.d(i3)) {
            if (dVar != null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                pn2.b bVar = new pn2.b(keyword, 6);
                bVar.f426499b = new Bundle();
                Unit unit = Unit.INSTANCE;
                dVar.onFinish(emptyList, bVar);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        Intrinsics.checkNotNullExpressionValue(items, "items");
        Iterator it = items.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            SearchCoreBuddyItem it5 = (SearchCoreBuddyItem) it.next();
            Intrinsics.checkNotNullExpressionValue(it5, "it");
            AppInterface app = this$0.e();
            Intrinsics.checkNotNullExpressionValue(app, "app");
            arrayList.add(new wn2.o(it5, keyword, app, 0, j3));
            j3++;
        }
        if (dVar != null) {
            pn2.b bVar2 = new pn2.b(keyword, 1);
            bVar2.f426499b = new Bundle();
            Unit unit2 = Unit.INSTANCE;
            dVar.onFinish(arrayList, bVar2);
        }
    }

    @Override // on2.b
    @NotNull
    public List<v> a(@Nullable pn2.a searchRequest) {
        List<v> emptyList;
        Logger.f235387a.d().w("QQSearch.Local.ContactSpecialCareSearchNewEngine", 1, "unsupport search here");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @Override // on2.b
    public void c(@Nullable pn2.a searchRequest, @Nullable on2.d<v> listener) {
        String str;
        if (searchRequest != null) {
            str = searchRequest.f426495a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        f(str, listener);
    }

    public /* synthetic */ AppInterface e() {
        return on2.a.a(this);
    }

    @Override // on2.b
    public void cancel() {
    }

    @Override // on2.b
    public void destroy() {
    }

    @Override // on2.b
    public void init() {
    }

    @Override // on2.b
    public void pause() {
    }

    @Override // on2.b
    public void resume() {
    }
}
