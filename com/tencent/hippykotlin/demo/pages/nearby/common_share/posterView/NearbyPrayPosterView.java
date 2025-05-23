package com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.extension.FloatExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.layout.ColumnView;
import com.tencent.kuikly.core.views.layout.RowView;
import com.tencent.kuikly.core.views.layout.a;
import com.tencent.kuikly.core.views.layout.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k25.d;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class NearbyPrayPosterView extends ComposeView<NearbyPrayPosterViewAttr, NearbyPrayPosterViewEvent> {
    public static final Companion Companion = new Companion();

    /* loaded from: classes31.dex */
    public static final class Companion {
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
        /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0007. Please report as an issue. */
        public final String getMonthAbbreviation(String str) {
            int hashCode = str.hashCode();
            switch (hashCode) {
                case 49:
                    if (str.equals("1")) {
                        return "JAN";
                    }
                    throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str));
                case 50:
                    if (str.equals("2")) {
                        return "FEB";
                    }
                    throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str));
                case 51:
                    if (str.equals("3")) {
                        return "MAR";
                    }
                    throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str));
                case 52:
                    if (str.equals("4")) {
                        return "APR";
                    }
                    throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str));
                case 53:
                    if (str.equals("5")) {
                        return "MAY";
                    }
                    throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str));
                case 54:
                    if (str.equals("6")) {
                        return "JUN";
                    }
                    throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str));
                case 55:
                    if (str.equals("7")) {
                        return "JUL";
                    }
                    throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str));
                case 56:
                    if (str.equals("8")) {
                        return "AUG";
                    }
                    throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str));
                case 57:
                    if (str.equals("9")) {
                        return "SEPT";
                    }
                    throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str));
                default:
                    switch (hashCode) {
                        case 1567:
                            if (str.equals("10")) {
                                return "OCT";
                            }
                            throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str));
                        case 1568:
                            if (str.equals("11")) {
                                return "NOV";
                            }
                            throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str));
                        case 1569:
                            if (str.equals("12")) {
                                return "DEC";
                            }
                            throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str));
                        default:
                            throw new IllegalArgumentException(AgreementConsentViewKt$$ExternalSyntheticOutline0.m("Invalid month number: ", str));
                    }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyPrayPosterViewAttr access$getAttr(NearbyPrayPosterView nearbyPrayPosterView) {
        return (NearbyPrayPosterViewAttr) nearbyPrayPosterView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final Ref.IntRef intRef = new Ref.IntRef();
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(592.0f);
                        mVar2.mo141height(784.0f);
                        mVar2.mo113backgroundColor(h.INSTANCE.m());
                        mVar2.borderRadius(8.0f);
                        return Unit.INSTANCE;
                    }
                });
                final NearbyPrayPosterView nearbyPrayPosterView = NearbyPrayPosterView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.absolutePositionAllZero();
                                tVar2.mo153width(592.0f);
                                tVar2.mo141height(784.0f);
                                tVar2.mo113backgroundColor(h.INSTANCE.m());
                                tVar2.borderRadius(8.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyPrayPosterView nearbyPrayPosterView2 = NearbyPrayPosterView.this;
                        a.b(vVar2, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ColumnView columnView) {
                                ColumnView columnView2 = columnView;
                                final NearbyPrayPosterView nearbyPrayPosterView3 = NearbyPrayPosterView.this;
                                w.a(columnView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.size(592.0f, 576.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyPrayPosterView nearbyPrayPosterView4 = NearbyPrayPosterView.this;
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NearbyPrayPosterView nearbyPrayPosterView5 = NearbyPrayPosterView.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        String str;
                                                        af afVar2 = afVar;
                                                        afVar2.positionAbsolute();
                                                        afVar2.m150top(-2.0f);
                                                        afVar2.m138bottom(0.0f);
                                                        afVar2.m142left(-2.0f);
                                                        afVar2.m149right(-2.0f);
                                                        d dVar = NearbyPrayPosterView.access$getAttr(NearbyPrayPosterView.this).luckyCard;
                                                        if (dVar == null || (str = dVar.f411450d) == null) {
                                                            str = "";
                                                        }
                                                        b.a.b(afVar2, str, false, 2, null);
                                                        afVar2.p();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyPrayPosterView nearbyPrayPosterView5 = NearbyPrayPosterView.this;
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NearbyPrayPosterView nearbyPrayPosterView6 = NearbyPrayPosterView.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        Map<String, String> map;
                                                        af afVar2 = afVar;
                                                        afVar2.positionAbsolute();
                                                        afVar2.m150top(-2.0f);
                                                        afVar2.m142left(-2.0f);
                                                        afVar2.m149right(-2.0f);
                                                        afVar2.mo141height(200.0f);
                                                        d dVar = NearbyPrayPosterView.access$getAttr(NearbyPrayPosterView.this).luckyCard;
                                                        if (Intrinsics.areEqual((dVar == null || (map = dVar.f411454i) == null) ? null : map.get("modle"), "rose")) {
                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_-mBNPi_rnFw.png", false, 2, null);
                                                        } else {
                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_9_L_0__W5VI.png", false, 2, null);
                                                        }
                                                        afVar2.p();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyPrayPosterView nearbyPrayPosterView6 = NearbyPrayPosterView.this;
                                        c.b(vVar4, new Function1<RowView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.4
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:13:0x008c, code lost:
                                            
                                                r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r2, new java.lang.String[]{" "}, false, 0, 6, (java.lang.Object) null);
                                             */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List] */
                                            /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List] */
                                            /* JADX WARN: Type inference failed for: r2v8, types: [java.util.ArrayList] */
                                            @Override // kotlin.jvm.functions.Function1
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(RowView rowView) {
                                                final h b16;
                                                long j3;
                                                long j16;
                                                final ?? emptyList;
                                                List split$default;
                                                int collectionSizeOrDefault;
                                                String replace$default;
                                                Map<String, String> map;
                                                RowView rowView2 = rowView;
                                                rowView2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(m mVar) {
                                                        c.a.a(mVar, 0.0f, 40.0f, 0.0f, 40.0f, 5, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                d dVar = NearbyPrayPosterView.access$getAttr(NearbyPrayPosterView.this).luckyCard;
                                                if (Intrinsics.areEqual((dVar == null || (map = dVar.f411454i) == null) ? null : map.get("modle"), "rose")) {
                                                    b16 = h.INSTANCE.m();
                                                } else {
                                                    b16 = h.INSTANCE.b();
                                                }
                                                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                com.tencent.kuikly.core.module.b bVar = (com.tencent.kuikly.core.module.b) cVar.g().acquireModule("KRCalendarModule");
                                                j3 = ((NearbyPrayPosterViewAttr) NearbyPrayPosterView.this.getAttr()).timeStamp;
                                                final String a16 = bVar.a(j3, "dd");
                                                com.tencent.kuikly.core.module.b bVar2 = (com.tencent.kuikly.core.module.b) cVar.g().acquireModule("KRCalendarModule");
                                                j16 = ((NearbyPrayPosterViewAttr) NearbyPrayPosterView.this.getAttr()).timeStamp;
                                                final String a17 = bVar2.a(j16, "M");
                                                cg.a(rowView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.4.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final String str = a16;
                                                        final h hVar = b16;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.4.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(str);
                                                                ceVar2.fontWeight300();
                                                                ceVar2.lineHeight(161.6f);
                                                                ceVar2.color(hVar);
                                                                ce.fontSize$default(ceVar2, 96.0f, null, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(rowView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.4.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final String str = a17;
                                                        final h hVar = b16;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.4.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(NearbyPrayPosterView.Companion.getMonthAbbreviation(str));
                                                                ceVar2.fontWeight300();
                                                                ceVar2.color(hVar);
                                                                ce.fontSize$default(ceVar2, 36.0f, null, 2, null);
                                                                ceVar2.lineHeight(161.6f);
                                                                c.a.a(ceVar2, 20.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(rowView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.4.4
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.4.4.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                tVar.m140flex(1.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                d dVar2 = NearbyPrayPosterView.access$getAttr(NearbyPrayPosterView.this).luckyCard;
                                                if (dVar2 == null || (r2 = dVar2.f411452f) == null || split$default == null) {
                                                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                                                } else {
                                                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(split$default, 10);
                                                    emptyList = new ArrayList(collectionSizeOrDefault);
                                                    Iterator it = split$default.iterator();
                                                    while (it.hasNext()) {
                                                        replace$default = StringsKt__StringsJVMKt.replace$default((String) it.next(), ":", "  ", false, 4, (Object) null);
                                                        emptyList.add(replace$default);
                                                    }
                                                }
                                                a.b(rowView2, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.4.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ColumnView columnView3) {
                                                        ColumnView columnView4 = columnView3;
                                                        columnView4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.4.5.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(m mVar) {
                                                                c.a.a(mVar, 38.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        for (final String str : emptyList) {
                                                            final h hVar = b16;
                                                            cg.a(columnView4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.4.5.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TextView textView) {
                                                                    final String str2 = str;
                                                                    final h hVar2 = hVar;
                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.1.4.5.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ce ceVar) {
                                                                            ce ceVar2 = ceVar;
                                                                            ceVar2.m140flex(1.0f);
                                                                            ceVar2.text(str2);
                                                                            ceVar2.fontWeight300();
                                                                            ceVar2.color(hVar2);
                                                                            ce.fontSize$default(ceVar2, 36.0f, null, 2, null);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyPrayPosterView nearbyPrayPosterView4 = NearbyPrayPosterView.this;
                                a.b(columnView2, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ColumnView columnView3) {
                                        ColumnView columnView4 = columnView3;
                                        columnView4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(m mVar) {
                                                m mVar2 = mVar;
                                                mVar2.m140flex(1.0f);
                                                mVar2.mo141height(208.0f);
                                                c.a.a(mVar2, 0.0f, 36.0f, 0.0f, 36.0f, 5, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyPrayPosterView nearbyPrayPosterView5 = NearbyPrayPosterView.this;
                                        w.a(columnView4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.m140flex(1.0f);
                                                        tVar2.alignItemsFlexStart();
                                                        tVar2.justifyContentCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyPrayPosterView nearbyPrayPosterView6 = NearbyPrayPosterView.this;
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NearbyPrayPosterView nearbyPrayPosterView7 = NearbyPrayPosterView.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                String str;
                                                                ce ceVar2 = ceVar;
                                                                d dVar = NearbyPrayPosterView.access$getAttr(NearbyPrayPosterView.this).luckyCard;
                                                                if (dVar == null || (str = dVar.f411451e) == null) {
                                                                    str = "";
                                                                }
                                                                ceVar2.text(str);
                                                                ceVar2.fontWeight400();
                                                                ceVar2.lines(2);
                                                                ceVar2.color(h.INSTANCE.b());
                                                                ce.fontSize$default(ceVar2, 28.0f, null, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyPrayPosterView nearbyPrayPosterView6 = NearbyPrayPosterView.this;
                                        com.tencent.kuikly.core.views.layout.c.b(columnView4, new Function1<RowView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(RowView rowView) {
                                                RowView rowView2 = rowView;
                                                rowView2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(m mVar) {
                                                        c.a.a(mVar, 0.0f, 0.0f, 22.0f, 0.0f, 11, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyPrayPosterView nearbyPrayPosterView7 = NearbyPrayPosterView.this;
                                                a.b(rowView2, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
                                                    
                                                        if (r0 == null) goto L14;
                                                     */
                                                    @Override // kotlin.jvm.functions.Function1
                                                    /*
                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                    */
                                                    public final Unit invoke(ColumnView columnView5) {
                                                        final String str;
                                                        ColumnView columnView6 = columnView5;
                                                        columnView6.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(m mVar) {
                                                                mVar.mo141height(100.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        d dVar = NearbyPrayPosterView.access$getAttr(NearbyPrayPosterView.this).luckyCard;
                                                        if (dVar != null && (str = dVar.C) != null) {
                                                            if (!(str.length() > 0)) {
                                                                str = null;
                                                            }
                                                        }
                                                        str = UserDataManager.INSTANCE.getUserSelfInfo().locationName;
                                                        com.tencent.kuikly.core.views.layout.c.b(columnView6, new Function1<RowView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(RowView rowView3) {
                                                                RowView rowView4 = rowView3;
                                                                w.a(rowView4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.2.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar3) {
                                                                        v vVar4 = vVar3;
                                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.2.2.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.size(23.2f);
                                                                                tVar2.allCenter();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.2.2.1.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.2.2.1.2.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(af afVar) {
                                                                                        af afVar2 = afVar;
                                                                                        afVar2.size(20.0f, 20.0f);
                                                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_-6TIy3Eyhhl.png", false, 2, null);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final String str2 = str;
                                                                cg.a(rowView4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.2.2.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final String str3 = str2;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.2.2.2.1
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.text(str3);
                                                                                ceVar2.fontWeight400();
                                                                                c.a.a(ceVar2, 0.0f, 2.0f, 0.0f, 0.0f, 13, null);
                                                                                ceVar2.color(4287664276L);
                                                                                ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                                                                ceVar2.lines(1);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        w.a(columnView6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.2.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar3) {
                                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.2.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        tVar.m140flex(1.0f);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ah.a(columnView6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.2.4
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.2.4.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        af afVar2 = afVar;
                                                                        afVar2.size(182.0f, 28.0f);
                                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_oUqPss2BvsC.png", false, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(rowView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                tVar.m140flex(1.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                a.b(rowView2, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.4
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ColumnView columnView5) {
                                                        ColumnView columnView6 = columnView5;
                                                        columnView6.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.4.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(m mVar) {
                                                                mVar.alignItemsCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        ah.a(columnView6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.4.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.4.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        af afVar2 = afVar;
                                                                        afVar2.size(70.0f);
                                                                        afVar2.mo139boxShadow(new g(0.0f, FloatExtKt.getTo375(3.0f), FloatExtKt.getTo375(3.0f), new h(0L, 0.18f)));
                                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_El7GVB0pT6O.png", false, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(columnView6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.4.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.2.2.2.3.4.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        c.a.a(ceVar2, 10.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                        ceVar2.text("\u626b\u7801\u53bb\u9644\u8fd1");
                                                                        ceVar2.fontWeight500();
                                                                        ceVar2.color(h.INSTANCE.b());
                                                                        ceVar2.lineHeight(20.0f);
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyPrayPosterView nearbyPrayPosterView2 = NearbyPrayPosterView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final Ref.IntRef intRef2 = Ref.IntRef.this;
                        vVar2.ref(vVar2, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<v> aaVar) {
                                Ref.IntRef.this.element = aaVar.getNativeRef();
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.absolutePositionAllZero();
                                tVar2.mo153width(592.0f);
                                tVar2.mo141height(784.0f);
                                tVar2.mo113backgroundColor(h.INSTANCE.m());
                                tVar2.borderRadius(8.0f);
                                tVar2.transform(new y(2.0f, 0.0f, 0.0f, 0.0f, 12, null));
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.3
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(u uVar) {
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyPrayPosterView nearbyPrayPosterView3 = nearbyPrayPosterView2;
                        a.b(vVar2, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ColumnView columnView) {
                                ColumnView columnView2 = columnView;
                                final NearbyPrayPosterView nearbyPrayPosterView4 = NearbyPrayPosterView.this;
                                w.a(columnView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.size(592.0f, 576.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyPrayPosterView nearbyPrayPosterView5 = NearbyPrayPosterView.this;
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NearbyPrayPosterView nearbyPrayPosterView6 = NearbyPrayPosterView.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        String str;
                                                        af afVar2 = afVar;
                                                        afVar2.positionAbsolute();
                                                        afVar2.m150top(-2.0f);
                                                        afVar2.m138bottom(0.0f);
                                                        afVar2.m142left(-2.0f);
                                                        afVar2.m149right(-2.0f);
                                                        d dVar = NearbyPrayPosterView.access$getAttr(NearbyPrayPosterView.this).luckyCard;
                                                        if (dVar == null || (str = dVar.f411450d) == null) {
                                                            str = "";
                                                        }
                                                        b.a.b(afVar2, str, false, 2, null);
                                                        afVar2.p();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyPrayPosterView nearbyPrayPosterView6 = NearbyPrayPosterView.this;
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NearbyPrayPosterView nearbyPrayPosterView7 = NearbyPrayPosterView.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        Map<String, String> map;
                                                        af afVar2 = afVar;
                                                        afVar2.positionAbsolute();
                                                        afVar2.m150top(-2.0f);
                                                        afVar2.m142left(-2.0f);
                                                        afVar2.m149right(-2.0f);
                                                        afVar2.mo141height(200.0f);
                                                        d dVar = NearbyPrayPosterView.access$getAttr(NearbyPrayPosterView.this).luckyCard;
                                                        if (Intrinsics.areEqual((dVar == null || (map = dVar.f411454i) == null) ? null : map.get("modle"), "rose")) {
                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_-mBNPi_rnFw.png", false, 2, null);
                                                        } else {
                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_9_L_0__W5VI.png", false, 2, null);
                                                        }
                                                        afVar2.p();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyPrayPosterView nearbyPrayPosterView7 = NearbyPrayPosterView.this;
                                        com.tencent.kuikly.core.views.layout.c.b(vVar4, new Function1<RowView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.4
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Code restructure failed: missing block: B:13:0x008c, code lost:
                                            
                                                r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r2, new java.lang.String[]{" "}, false, 0, 6, (java.lang.Object) null);
                                             */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            /* JADX WARN: Type inference failed for: r2v5, types: [java.util.List] */
                                            /* JADX WARN: Type inference failed for: r2v6, types: [java.util.List] */
                                            /* JADX WARN: Type inference failed for: r2v8, types: [java.util.ArrayList] */
                                            @Override // kotlin.jvm.functions.Function1
                                            /*
                                                Code decompiled incorrectly, please refer to instructions dump.
                                            */
                                            public final Unit invoke(RowView rowView) {
                                                final h b16;
                                                long j3;
                                                long j16;
                                                final ?? emptyList;
                                                List split$default;
                                                int collectionSizeOrDefault;
                                                String replace$default;
                                                Map<String, String> map;
                                                RowView rowView2 = rowView;
                                                rowView2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(m mVar) {
                                                        c.a.a(mVar, 0.0f, 40.0f, 0.0f, 40.0f, 5, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                d dVar = NearbyPrayPosterView.access$getAttr(NearbyPrayPosterView.this).luckyCard;
                                                if (Intrinsics.areEqual((dVar == null || (map = dVar.f411454i) == null) ? null : map.get("modle"), "rose")) {
                                                    b16 = h.INSTANCE.m();
                                                } else {
                                                    b16 = h.INSTANCE.b();
                                                }
                                                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                                com.tencent.kuikly.core.module.b bVar = (com.tencent.kuikly.core.module.b) cVar.g().acquireModule("KRCalendarModule");
                                                j3 = ((NearbyPrayPosterViewAttr) NearbyPrayPosterView.this.getAttr()).timeStamp;
                                                final String a16 = bVar.a(j3, "dd");
                                                com.tencent.kuikly.core.module.b bVar2 = (com.tencent.kuikly.core.module.b) cVar.g().acquireModule("KRCalendarModule");
                                                j16 = ((NearbyPrayPosterViewAttr) NearbyPrayPosterView.this.getAttr()).timeStamp;
                                                final String a17 = bVar2.a(j16, "M");
                                                cg.a(rowView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.4.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final String str = a16;
                                                        final h hVar = b16;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.4.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(str);
                                                                ceVar2.fontWeight300();
                                                                ceVar2.lineHeight(161.6f);
                                                                ceVar2.color(hVar);
                                                                ce.fontSize$default(ceVar2, 96.0f, null, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(rowView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.4.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final String str = a17;
                                                        final h hVar = b16;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.4.3.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.text(NearbyPrayPosterView.Companion.getMonthAbbreviation(str));
                                                                ceVar2.fontWeight300();
                                                                ceVar2.color(hVar);
                                                                ce.fontSize$default(ceVar2, 36.0f, null, 2, null);
                                                                ceVar2.lineHeight(161.6f);
                                                                c.a.a(ceVar2, 20.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(rowView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.4.4
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar5) {
                                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.4.4.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                tVar.m140flex(1.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                d dVar2 = NearbyPrayPosterView.access$getAttr(NearbyPrayPosterView.this).luckyCard;
                                                if (dVar2 == null || (r2 = dVar2.f411452f) == null || split$default == null) {
                                                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                                                } else {
                                                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(split$default, 10);
                                                    emptyList = new ArrayList(collectionSizeOrDefault);
                                                    Iterator it = split$default.iterator();
                                                    while (it.hasNext()) {
                                                        replace$default = StringsKt__StringsJVMKt.replace$default((String) it.next(), ":", "  ", false, 4, (Object) null);
                                                        emptyList.add(replace$default);
                                                    }
                                                }
                                                a.b(rowView2, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.4.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ColumnView columnView3) {
                                                        ColumnView columnView4 = columnView3;
                                                        columnView4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.4.5.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(m mVar) {
                                                                c.a.a(mVar, 30.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        for (final String str : emptyList) {
                                                            final h hVar = b16;
                                                            cg.a(columnView4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.4.5.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TextView textView) {
                                                                    final String str2 = str;
                                                                    final h hVar2 = hVar;
                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.1.4.5.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ce ceVar) {
                                                                            ce ceVar2 = ceVar;
                                                                            ceVar2.m140flex(1.0f);
                                                                            ceVar2.text(str2);
                                                                            ceVar2.fontWeight300();
                                                                            ceVar2.color(hVar2);
                                                                            ce.fontSize$default(ceVar2, 36.0f, null, 2, null);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyPrayPosterView nearbyPrayPosterView5 = NearbyPrayPosterView.this;
                                a.b(columnView2, new Function1<ColumnView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ColumnView columnView3) {
                                        ColumnView columnView4 = columnView3;
                                        columnView4.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(m mVar) {
                                                m mVar2 = mVar;
                                                mVar2.m140flex(1.0f);
                                                mVar2.mo141height(208.0f);
                                                c.a.a(mVar2, 0.0f, 36.0f, 0.0f, 36.0f, 5, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyPrayPosterView nearbyPrayPosterView6 = NearbyPrayPosterView.this;
                                        w.a(columnView4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                v vVar4 = vVar3;
                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.m140flex(1.0f);
                                                        tVar2.alignItemsFlexStart();
                                                        tVar2.justifyContentCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyPrayPosterView nearbyPrayPosterView7 = NearbyPrayPosterView.this;
                                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.2.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NearbyPrayPosterView nearbyPrayPosterView8 = NearbyPrayPosterView.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.2.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                String str;
                                                                ce ceVar2 = ceVar;
                                                                d dVar = NearbyPrayPosterView.access$getAttr(NearbyPrayPosterView.this).luckyCard;
                                                                if (dVar == null || (str = dVar.f411451e) == null) {
                                                                    str = "";
                                                                }
                                                                ceVar2.text(str);
                                                                ceVar2.fontWeight400();
                                                                ceVar2.lines(2);
                                                                ceVar2.color(h.INSTANCE.b());
                                                                ce.fontSize$default(ceVar2, 28.0f, null, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        com.tencent.kuikly.core.views.layout.c.b(columnView4, new Function1<RowView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.2.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(RowView rowView) {
                                                rowView.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyPrayPosterView.body.1.3.4.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(m mVar) {
                                                        m mVar2 = mVar;
                                                        mVar2.m140flex(1.0f);
                                                        c.a.a(mVar2, 0.0f, 0.0f, 18.0f, 0.0f, 11, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NearbyPrayPosterViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyPrayPosterViewEvent();
    }
}
