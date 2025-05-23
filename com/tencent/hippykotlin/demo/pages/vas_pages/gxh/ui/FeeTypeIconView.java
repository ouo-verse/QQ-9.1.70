package com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.vas_base.extensions.p002float.ImplKt;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.FeeType;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.models.DressItem;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class FeeTypeIconView extends ComposeView<FeeTypeIconViewAttr, FeeTypeIconViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FeeTypeIconViewAttr access$getAttr(FeeTypeIconView feeTypeIconView) {
        return (FeeTypeIconViewAttr) feeTypeIconView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.FeeTypeIconView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final FeeTypeIconView feeTypeIconView = FeeTypeIconView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.FeeTypeIconView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final FeeTypeIconView feeTypeIconView2 = FeeTypeIconView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.FeeTypeIconView.body.1.1.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(FeeTypeIconView.this.getIconImage().length() > 0);
                            }
                        };
                        final FeeTypeIconView feeTypeIconView3 = FeeTypeIconView.this;
                        ConditionViewKt.c(vVar, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.FeeTypeIconView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final FeeTypeIconView feeTypeIconView4 = FeeTypeIconView.this;
                                ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.FeeTypeIconView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final FeeTypeIconView feeTypeIconView5 = FeeTypeIconView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.gxh.ui.FeeTypeIconView.body.1.1.2.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                if (FeeTypeIconView.access$getAttr(FeeTypeIconView.this).getViewScale$qecommerce_biz_release() > 0.0f) {
                                                    afVar2.size(FeeTypeIconView.access$getAttr(FeeTypeIconView.this).getViewScale$qecommerce_biz_release() * ImplKt.getW(FeeTypeIconView.this.getIconWidth()), FeeTypeIconView.access$getAttr(FeeTypeIconView.this).getViewScale$qecommerce_biz_release() * ImplKt.getW(18.0f));
                                                } else {
                                                    afVar2.size(ImplKt.getW(FeeTypeIconView.this.getIconWidth()), ImplKt.getW(18.0f));
                                                }
                                                b.a.b(afVar2, FeeTypeIconView.this.getIconImage(), false, 2, null);
                                                afVar2.o();
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
        return new FeeTypeIconViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new FeeTypeIconViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getIconImage() {
        List listOf;
        Object orNull;
        boolean contains$default;
        FeeType feeType = ((FeeTypeIconViewAttr) getAttr()).getItem$qecommerce_biz_release().getFeeType();
        c cVar = c.f117352a;
        boolean z16 = false;
        if (cVar.g().getPageData().n().g("isIosInCheck", false)) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).getQua(), (CharSequence) "_RDM_", false, 2, (Object) null);
            if (!contains$default) {
                z16 = true;
            }
        }
        if (z16 && (feeType != FeeType.SVIP || feeType != FeeType.VIP)) {
            return "";
        }
        DressItem item$qecommerce_biz_release = ((FeeTypeIconViewAttr) getAttr()).getItem$qecommerce_biz_release();
        ReadWriteProperty readWriteProperty = item$qecommerce_biz_release.isBlindBox$delegate;
        KProperty<?>[] kPropertyArr = DressItem.$$delegatedProperties;
        if (((Boolean) readWriteProperty.getValue(item$qecommerce_biz_release, kPropertyArr[9])).booleanValue()) {
            return "https://tianquan.gtimg.cn/shoal/qqgxh/blind-box.png";
        }
        if (feeType == FeeType.LEVEL || feeType == FeeType.LEVEL_ITEM) {
            DressItem item$qecommerce_biz_release2 = ((FeeTypeIconViewAttr) getAttr()).getItem$qecommerce_biz_release();
            if (((Number) item$qecommerce_biz_release2.svipLevel$delegate.getValue(item$qecommerce_biz_release2, kPropertyArr[10])).intValue() != 0) {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"https://tianquan.gtimg.cn/shoal/qqgxh/SVIP1.png", "https://tianquan.gtimg.cn/shoal/qqgxh/SVIP2.png", "https://tianquan.gtimg.cn/shoal/qqgxh/SVIP3.png", "https://tianquan.gtimg.cn/shoal/qqgxh/SVIP4.png", "https://tianquan.gtimg.cn/shoal/qqgxh/SVIP5.png", "https://tianquan.gtimg.cn/shoal/qqgxh/SVIP6.png", "https://tianquan.gtimg.cn/shoal/qqgxh/SVIP7.png", "https://tianquan.gtimg.cn/shoal/qqgxh/SVIP8.png", "https://tianquan.gtimg.cn/shoal/qqgxh/SVIP9.png"});
                DressItem item$qecommerce_biz_release3 = ((FeeTypeIconViewAttr) getAttr()).getItem$qecommerce_biz_release();
                orNull = CollectionsKt___CollectionsKt.getOrNull(listOf, ((Number) item$qecommerce_biz_release3.svipLevel$delegate.getValue(item$qecommerce_biz_release3, kPropertyArr[10])).intValue() - 1);
                String str = (String) orNull;
                return str == null ? "" : str;
            }
        }
        switch (feeType.ordinal()) {
            case 1:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/free.png";
            case 2:
            case 6:
            case 7:
            case 12:
            case 13:
            case 14:
            default:
                return "";
            case 3:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/vip-free.png";
            case 4:
            case 25:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/svip-free.png";
            case 5:
            case 20:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/act.png";
            case 8:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/zs.png";
            case 9:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/big-vip.png";
            case 10:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/star.png";
            case 11:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/xf-svip.png";
            case 15:
            case 16:
            case 17:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/game.png";
            case 18:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/vip-year.png";
            case 19:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/svip-year.png";
            case 21:
            case 22:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/limited.png";
            case 23:
            case 24:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/lover.png";
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 39:
            case 40:
            case 41:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/king-card.png";
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
                return "https://tianquan.gtimg.cn/shoal/qqgxh/treasure-card.png";
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:11:0x011f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00de A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x00f8 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013c A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final float getIconWidth() {
        String iconImage = getIconImage();
        switch (iconImage.hashCode()) {
            case -1749408342:
                return !iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/vip-year.png") ? 0.0f : 40.0f;
            case -1747909543:
                if (iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/vip-free.png")) {
                    return 52.0f;
                }
                break;
            case -1640886637:
                if (iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/limited.png")) {
                    return 32.0f;
                }
                break;
            case -1468270631:
                if (iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/svip-year.png")) {
                    return 50.0f;
                }
                break;
            case -1466771832:
                if (iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/svip-free.png")) {
                    return 59.0f;
                }
                break;
            case -1328613401:
                if (iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/treasure-card.png")) {
                    return 42.0f;
                }
                break;
            case -1319578464:
                if (iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/SVIP1.png")) {
                    return 63.0f;
                }
                break;
            case -1318654943:
                if (iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/SVIP2.png")) {
                    return 65.0f;
                }
                break;
            case -1317731422:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/SVIP3.png")) {
                }
                break;
            case -1316807901:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/SVIP4.png")) {
                }
                break;
            case -1315884380:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/SVIP5.png")) {
                }
                break;
            case -1314960859:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/SVIP6.png")) {
                }
                break;
            case -1314037338:
                if (iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/SVIP7.png")) {
                    return 64.0f;
                }
                break;
            case -1313113817:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/SVIP8.png")) {
                }
                break;
            case -1312190296:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/SVIP9.png")) {
                }
                break;
            case -1165830513:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/star.png")) {
                }
                break;
            case -991480647:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/lover.png")) {
                }
                break;
            case -135199605:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/act.png")) {
                }
                break;
            case 44125231:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/game.png")) {
                }
                break;
            case 274942377:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/free.png")) {
                }
                break;
            case 430271564:
                if (iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/blind-box.png")) {
                    return 46.0f;
                }
                break;
            case 721883074:
                if (iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/xf-svip.png")) {
                    return 54.0f;
                }
                break;
            case 1693953142:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/zs.png")) {
                }
                break;
            case 1814751177:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/big-vip.png")) {
                }
                break;
            case 2106274559:
                if (!iconImage.equals("https://tianquan.gtimg.cn/shoal/qqgxh/king-card.png")) {
                }
                break;
        }
    }
}
