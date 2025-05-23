package com.tencent.mobileqq.zplan.aio.panel.page;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001 B!\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b(\u0010)R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0014\u001a\u00020\u00108\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u00108\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u00108\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0013R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00038\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001d\u0010\bR\u001c\u0010$\u001a\u00020\u001f8\u0016@\u0016X\u0096\u000f\u00a2\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u000eR\u0014\u0010'\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010\u000e\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/a;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/Page;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/g;", "", "Lcom/tencent/mobileqq/zplan/model/e;", "i", "Ljava/util/List;", "v", "()Ljava/util/List;", "emotionItems", "", "j", "Ljava/lang/String;", "w", "()Ljava/lang/String;", "sequence", "", "l", "I", "()I", "tabIconResInt", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "pageType", DomainData.DOMAIN_NAME, "k", "sortKey", "Lcom/tencent/mobileqq/zplan/aio/panel/item/b;", "o", "c", "items", "", "a", "()Z", "setRedDotHint", "(Z)V", "redDotHint", "tabName", tl.h.F, "reportTabName", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "p", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends Page {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<ZPlanActionInfo> emotionItems;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final String sequence;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ b f331258k;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final int tabIconResInt;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int pageType;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final int sortKey;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final List<com.tencent.mobileqq.zplan.aio.panel.item.b> items;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/page/a$a;", "", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/Panel;", "Lcom/tencent/mobileqq/zplan/aio/panel/page/a;", "a", "", "TAB_NAME", "Ljava/lang/String;", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.aio.panel.page.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(Panel panel) {
            Object obj;
            Intrinsics.checkNotNullParameter(panel, "<this>");
            Iterator<T> it = panel.b().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((Page) obj).getTabName(), "\u8868\u60c5")) {
                    break;
                }
            }
            return (a) obj;
        }

        Companion() {
        }
    }

    public /* synthetic */ a(List list, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i3 & 2) != 0 ? null : str);
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.g
    /* renamed from: a */
    public boolean getRedDotHint() {
        return this.f331258k.getRedDotHint();
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    public List<com.tencent.mobileqq.zplan.aio.panel.item.b> c() {
        return this.items;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    /* renamed from: g, reason: from getter */
    public int getPageType() {
        return this.pageType;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    public String h() {
        return "emote";
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    /* renamed from: k, reason: from getter */
    public int getSortKey() {
        return this.sortKey;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    /* renamed from: l, reason: from getter */
    public int getTabIconResInt() {
        return this.tabIconResInt;
    }

    @Override // com.tencent.mobileqq.zplan.aio.panel.page.Page
    /* renamed from: m */
    public String getTabName() {
        return "\u8868\u60c5";
    }

    public final List<ZPlanActionInfo> v() {
        return this.emotionItems;
    }

    /* renamed from: w, reason: from getter */
    public final String getSequence() {
        return this.sequence;
    }

    public a(List<ZPlanActionInfo> emotionItems, String str) {
        List<com.tencent.mobileqq.zplan.aio.panel.item.b> emptyList;
        Intrinsics.checkNotNullParameter(emotionItems, "emotionItems");
        this.emotionItems = emotionItems;
        this.sequence = str;
        this.f331258k = b.f331263a;
        this.tabIconResInt = R.drawable.i4p;
        this.pageType = 1;
        this.sortKey = 1;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.items = emptyList;
    }
}
