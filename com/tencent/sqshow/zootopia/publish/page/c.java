package com.tencent.sqshow.zootopia.publish.page;

import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.publish.page.ar.ARSameStyleContentPage;
import com.tencent.sqshow.zootopia.publish.page.design.FashionDesignContentPage;
import com.tencent.sqshow.zootopia.publish.page.dress.DressShareContentPage;
import com.tencent.sqshow.zootopia.publish.page.samestyle.SameStyleContentPage;
import com.tencent.sqshow.zootopia.publish.page.samestyle.SameStyleContentPageFrom;
import com.tencent.sqshow.zootopia.publish.tab.SelectPublishContentPageType;
import com.tencent.sqshow.zootopia.publish.tab.SelectPublishContentTitleData;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/page/c;", "", "Lcom/tencent/sqshow/zootopia/publish/tab/SelectPublishContentTitleData;", "data", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/sqshow/zootopia/publish/page/a;", "a", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f372402a = new c();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f372403a;

        static {
            int[] iArr = new int[SelectPublishContentPageType.values().length];
            try {
                iArr[SelectPublishContentPageType.SAME_STYLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SelectPublishContentPageType.AR_SAME_STYLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SelectPublishContentPageType.DRESS_SHARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SelectPublishContentPageType.FASHION_DESIGN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f372403a = iArr;
        }
    }

    c() {
    }

    public final com.tencent.sqshow.zootopia.publish.page.a a(SelectPublishContentTitleData data, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(source, "source");
        int i3 = a.f372403a[data.getId().ordinal()];
        if (i3 == 1) {
            return SameStyleContentPage.INSTANCE.b(SameStyleContentPageFrom.FROM_CONTENT_PUBLISH, source, data.getExtraParams());
        }
        if (i3 == 2) {
            return new ARSameStyleContentPage();
        }
        if (i3 == 3) {
            return new DressShareContentPage();
        }
        if (i3 == 4) {
            return new FashionDesignContentPage();
        }
        throw new NoWhenBranchMatchedException();
    }
}
