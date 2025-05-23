package com.qzone.reborn.feedpro.utils;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0010\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/feedpro/utils/ap;", "", "", "pageType", "", "Ljava/lang/Class;", "Lne/a;", "a", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", "", "c", "d", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ap {

    /* renamed from: a, reason: collision with root package name */
    public static final ap f54313a = new ap();

    ap() {
    }

    public final List<Class<? extends ne.a>> a(int pageType) {
        ArrayList arrayList = new ArrayList();
        if (pageType == 1) {
            arrayList.add(com.qzone.reborn.feedpro.section.m.class);
            arrayList.add(com.qzone.reborn.feedpro.section.i.class);
        } else if (pageType != 2) {
            arrayList.add(com.qzone.reborn.feedpro.section.m.class);
            arrayList.add(com.qzone.reborn.feedpro.section.i.class);
        }
        return arrayList;
    }

    public final boolean c(CommonFeed feedData) {
        return true;
    }

    public final boolean d(CommonFeed feedData) {
        return true;
    }

    public final boolean b(int pageType) {
        return pageType != 2 && com.qzone.reborn.configx.g.f53821a.c().y();
    }
}
