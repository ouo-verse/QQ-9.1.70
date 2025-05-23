package com.tencent.mobileqq.zplan.widget.impl.button;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.SimpleColorFilter;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zootopia.utils.g;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pv4.j;
import pv4.k;
import pv4.o;
import qv4.ad;
import qv4.ap;
import tj3.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u00012\u00020\u00022\u00020\u0002:\u0001NB\u0011\b\u0016\u0012\u0006\u0010F\u001a\u00020E\u00a2\u0006\u0004\bG\u0010HB\u001b\b\u0016\u0012\u0006\u0010F\u001a\u00020E\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u00a2\u0006\u0004\bG\u0010KB#\b\u0016\u0012\u0006\u0010F\u001a\u00020E\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u0012\u0006\u0010L\u001a\u00020-\u00a2\u0006\u0004\bG\u0010MJ\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\u0014\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\"\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0002J\u001a\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0002J$\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0002J@\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00020 j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0002`!2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0002J6\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00020 j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0002`!2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0002J4\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00020 j\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0002`!2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010%\u001a\u00020$H\u0002J\u001c\u0010'\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010*\u001a\u00020\u00072\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010(H\u0016J\b\u0010,\u001a\u00020+H\u0016J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-H\u0016J\u0018\u00100\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/zplan/widget/impl/button/ZplanCommonButton;", "Landroid/widget/FrameLayout;", "", "Lfl3/a;", "data", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "r", "u", DomainData.DOMAIN_NAME, "", "isCloudMod", "w", "Ls84/a;", "buttonStyle", "Lpv4/o;", "indexButton", "Lpv4/j;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, HippyTKDListViewAdapter.X, "o", "D", "reserveItem", "", TuxUIConstants.POP_BTN_TEXT, "G", "E", "buttonText", "B", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "button", "l", "t", "Lkotlin/Function0;", "buttonClickListener", "setClickHandler", "Landroid/view/View;", "p", "", "dp", "setRadius", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "d", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "viewReporter", "Lcom/tencent/sqshow/zootopia/card/report/a;", "e", "getCardElementReporter", "()Lcom/tencent/sqshow/zootopia/card/report/a;", "cardElementReporter", "Landroid/widget/Button;", "f", "Landroid/widget/Button;", "commonButton", h.F, "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "downloadButton", "i", "Lkotlin/jvm/functions/Function0;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanCommonButton extends FrameLayout implements u74.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewReporter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy cardElementReporter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Button commonButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ZootopiaDownloadButton downloadButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> buttonClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanCommonButton(Context context) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(ZplanCommonButton$viewReporter$2.INSTANCE);
        this.viewReporter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(ZplanCommonButton$cardElementReporter$2.INSTANCE);
        this.cardElementReporter = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void B(fl3.a data, String buttonText) {
        if (data.getIsReportOutSide()) {
            QLog.i("ZPlanCommonButton", 1, "reportDefaultButtonClick - skip internal report");
            return;
        }
        Button button = this.commonButton;
        if (button != null) {
            new HashMap();
            q().e(button, "em_zplan_element", k(data, buttonText));
        }
    }

    private final void C(fl3.a data, String buttonText) {
        if (data.getIsReportOutSide()) {
            QLog.d("ZPlanCommonButton", 1, "reportDefaultButtonImp - skip internal report");
            return;
        }
        Button button = this.commonButton;
        if (button != null) {
            q().g(button, "em_zplan_element", (r16 & 4) != 0 ? null : k(data, buttonText), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(fl3.a data) {
        if (data.getIsReportOutSide()) {
            QLog.d("ZPlanCommonButton", 1, "skip internal report ");
            return;
        }
        ZootopiaDownloadButton zootopiaDownloadButton = this.downloadButton;
        if (zootopiaDownloadButton != null) {
            q().e(zootopiaDownloadButton, "em_zplan_mod_btn", l(data, zootopiaDownloadButton));
        }
    }

    private final void E(fl3.a data) {
        if (data.getIsReportOutSide()) {
            QLog.d("ZPlanCommonButton", 1, "skip internal report ");
            return;
        }
        ZootopiaDownloadButton zootopiaDownloadButton = this.downloadButton;
        if (zootopiaDownloadButton != null) {
            q().g(zootopiaDownloadButton, "em_zplan_mod_btn", (r16 & 4) != 0 ? null : l(data, zootopiaDownloadButton), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    private final void F(fl3.a data, j reserveItem, String buttonText) {
        Button button = this.commonButton;
        if (button != null) {
            q().g(button, "em_zplan_element", (r16 & 4) != 0 ? null : m(data, reserveItem, buttonText), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
    }

    private final void G(fl3.a data, j reserveItem, String btnText) {
        Button button = this.commonButton;
        if (button != null) {
            q().e(button, "em_zplan_mod_btn", m(data, reserveItem, btnText));
        }
    }

    private final HashMap<String, Object> m(fl3.a data, j reserveItem, String buttonText) {
        ZootopiaMapSimpleInfo currMapInfo;
        HashMap<String, Object> k3 = k(data, buttonText);
        ZootopiaDownloadButtonBinder binder = data.getBinder();
        boolean z16 = false;
        k3.put("zplan_map_id", Integer.valueOf((binder == null || (currMapInfo = binder.getCurrMapInfo()) == null) ? 0 : currMapInfo.getMapID()));
        k3.put("zplan_reserver_type", Integer.valueOf(reserveItem != null ? reserveItem.f427618a : 0));
        String str = reserveItem != null ? reserveItem.f427619b : null;
        if (str == null) {
            str = "";
        }
        k3.put("zplan_reserver_id", str);
        if (reserveItem != null && reserveItem.f427620c) {
            z16 = true;
        }
        k3.put("zplan_btn_status", Integer.valueOf(z16 ? 9 : 8));
        return k3;
    }

    private final void n() {
        if (this.commonButton == null) {
            this.commonButton = new Button(getContext());
        }
    }

    private final void o(fl3.a data) {
        if (this.downloadButton == null) {
            try {
                this.downloadButton = data.c().getConstructor(Context.class).newInstance(getContext());
            } catch (Exception e16) {
                QLog.e("ZPlanCommonButton", 1, "new instance fail " + e16);
            }
        }
    }

    private final ZplanViewReportHelper q() {
        return (ZplanViewReportHelper) this.viewReporter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ZplanCommonButton this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p().performClick();
    }

    private final void u(final fl3.a data) {
        String str;
        Drawable background;
        String str2;
        removeAllViews();
        final o indexButton = data.getIndexButton();
        if (indexButton == null) {
            return;
        }
        n();
        s84.a a16 = s84.c.f433498a.a(data.getBarType());
        final Button button = this.commonButton;
        if (button != null) {
            button.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            button.setText(indexButton.f427643a);
            button.setPadding(0, 0, 0, 0);
            if (a16 != null) {
                button.setTextSize(a16.getTextSize());
                if (TextUtils.isEmpty(indexButton.f427649g)) {
                    str2 = "#0179FF";
                } else {
                    str2 = indexButton.f427649g;
                }
                m84.b.g(button, str2);
                button.setTypeface(Typeface.defaultFromStyle(1));
                button.setBackground(AppCompatResources.getDrawable(button.getRootView().getContext(), a16.getLoadingBackgroundID()));
            }
            button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.widget.impl.button.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZplanCommonButton.v(fl3.a.this, button, this, indexButton, view);
                }
            });
        }
        if (TextUtils.isEmpty(indexButton.f427644b)) {
            str = data.getDefBgColorRes();
        } else {
            str = indexButton.f427644b;
        }
        try {
            Button button2 = this.commonButton;
            if (button2 != null && (background = button2.getBackground()) != null) {
                background.mutate();
            }
            int parseColor = Color.parseColor(str);
            Button button3 = this.commonButton;
            Drawable background2 = button3 != null ? button3.getBackground() : null;
            if (background2 != null) {
                background2.setColorFilter(new SimpleColorFilter(parseColor));
            }
        } catch (Exception e16) {
            QLog.e("ZPlanCommonButton", 1, "Illegal parameter " + str + " " + e16);
        }
        C(data, indexButton.f427643a);
        addView(this.commonButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(fl3.a data, Button this_apply, ZplanCommonButton this$0, o indexButton, View view) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(indexButton, "$indexButton");
        String str = data.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_JUMP_URL java.lang.String();
        if (str != null) {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = this_apply.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iSchemeApi.launchScheme(context, str);
            Function0<Unit> function0 = this$0.buttonClickListener;
            if (function0 != null) {
                function0.invoke();
            }
            this$0.B(data, indexButton.f427643a);
        }
    }

    private final void w(final fl3.a data, boolean isCloudMod) {
        byte[] bArr;
        removeAllViews();
        o indexButton = data.getIndexButton();
        if (indexButton == null || (bArr = data.getIndexButton().f427646d) == null) {
            return;
        }
        o(data);
        ap d16 = ap.d(bArr);
        Intrinsics.checkNotNullExpressionValue(d16, "parseFrom(busiBuf)");
        if (d16.f429974a < 0) {
            QLog.e("ZPlanCommonButton", 1, "Illegal parameter " + d16);
            return;
        }
        ZootopiaDownloadButton zootopiaDownloadButton = this.downloadButton;
        if (zootopiaDownloadButton != null) {
            zootopiaDownloadButton.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            zootopiaDownloadButton.setButtonType(data.getBarType());
            zootopiaDownloadButton.setCloudModButtonStyle(s84.b.f433495a.a(data.getCloudModBtnType()));
            ZootopiaDownloadButtonBinder binder = data.getBinder();
            if (binder != null) {
                ZootopiaDownloadButton zootopiaDownloadButton2 = this.downloadButton;
                Intrinsics.checkNotNull(zootopiaDownloadButton2);
                binder.e(zootopiaDownloadButton2, d16, data.getSourceCurrent(), indexButton.f427643a, isCloudMod, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.widget.impl.button.ZplanCommonButton$renderModDownloadButton$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Function0 function0;
                        function0 = ZplanCommonButton.this.buttonClickListener;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        ZplanCommonButton.this.D(data);
                        HashMap<String, Object> h16 = data.h();
                        if (h16 != null) {
                            data.getBinder().l(h16);
                        }
                    }
                });
            }
        }
        E(data);
        addView(this.downloadButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ZplanCommonButton this$0, j jVar, fl3.a data, Button this_apply, View view) {
        String str;
        k it;
        ButtonStatus buttonStatus;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Function0<Unit> function0 = this$0.buttonClickListener;
        if (function0 != null) {
            function0.invoke();
        }
        if (g.h(jVar)) {
            com.tencent.sqshow.zootopia.report.a aVar = com.tencent.sqshow.zootopia.report.a.f372690a;
            String str2 = jVar.f427619b;
            Intrinsics.checkNotNullExpressionValue(str2, "item.id");
            int parseInt = Integer.parseInt(str2);
            if (jVar.f427620c) {
                buttonStatus = ButtonStatus.APPOINTED;
            } else {
                buttonStatus = ButtonStatus.CAN_APPOINTMENT;
            }
            aVar.e(parseInt, buttonStatus, data.getSourceCurrent(), data.h());
        }
        if (jVar.f427620c) {
            k[] kVarArr = jVar.f427623f;
            if (kVarArr != null) {
                int length = kVarArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        it = null;
                        break;
                    }
                    it = kVarArr[i3];
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (g.j(it)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (it != null && !it.f427628d) {
                    ((tj3.a) vb3.a.f441346a.a(tj3.a.class)).E0(jVar);
                }
            }
        } else {
            a.C11293a.b((tj3.a) vb3.a.f441346a.a(tj3.a.class), jVar, true, null, 4, null);
        }
        CharSequence text = this_apply.getText();
        if (text == null || (str = text.toString()) == null) {
            str = "";
        }
        this$0.G(data, jVar, str);
    }

    public View p() {
        ZootopiaDownloadButton zootopiaDownloadButton = this.downloadButton;
        if (Intrinsics.areEqual(zootopiaDownloadButton != null ? zootopiaDownloadButton.getParent() : null, this)) {
            ZootopiaDownloadButton zootopiaDownloadButton2 = this.downloadButton;
            Intrinsics.checkNotNull(zootopiaDownloadButton2);
            return zootopiaDownloadButton2;
        }
        Button button = this.commonButton;
        if (!Intrinsics.areEqual(button != null ? button.getParent() : null, this)) {
            return this;
        }
        Button button2 = this.commonButton;
        Intrinsics.checkNotNull(button2);
        return button2;
    }

    public void setClickHandler(Function0<Unit> buttonClickListener) {
        this.buttonClickListener = buttonClickListener;
    }

    public void z(final fl3.a data, LifecycleOwner lifecycleOwner) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        QLog.i("ZPlanCommonButton", 1, "renderReserveButton");
        removeAllViews();
        final o indexButton = data.getIndexButton();
        if (indexButton == null || (bArr = data.getIndexButton().f427646d) == null) {
            return;
        }
        n();
        final j d16 = j.d(bArr);
        final s84.a c16 = s84.c.f433498a.c();
        if (d16 != null) {
            x(c16, indexButton, d16, data);
            MutableLiveData<ad> r06 = ((tj3.a) vb3.a.f441346a.a(tj3.a.class)).r0();
            final Function1<ad, Unit> function1 = new Function1<ad, Unit>() { // from class: com.tencent.mobileqq.zplan.widget.impl.button.ZplanCommonButton$renderReserveButton$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ad adVar) {
                    invoke2(adVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ad adVar) {
                    j it;
                    j[] jVarArr = adVar.f429902a;
                    if (jVarArr != null) {
                        j jVar = j.this;
                        ZplanCommonButton zplanCommonButton = this;
                        s84.a aVar = c16;
                        o oVar = indexButton;
                        fl3.a aVar2 = data;
                        int length = jVarArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 >= length) {
                                it = null;
                                break;
                            }
                            it = jVarArr[i3];
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            if (g.b(it, jVar)) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (it != null) {
                            QLog.i("ZPlanCommonButton", 1, "renderReserveButton observe");
                            zplanCommonButton.x(aVar, oVar, it, aVar2);
                        }
                    }
                }
            };
            r06.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.widget.impl.button.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZplanCommonButton.A(Function1.this, obj);
                }
            });
        }
        F(data, d16, indexButton.f427643a);
        addView(this.commonButton);
    }

    private final HashMap<String, Object> k(fl3.a data, String buttonText) {
        HashMap<String, Object> hashMapOf;
        Pair[] pairArr = new Pair[1];
        if (buttonText == null) {
            buttonText = "";
        }
        pairArr[0] = TuplesKt.to("zplan_btn_context", buttonText);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        if (data.h() != null) {
            hashMapOf.putAll(data.h());
        }
        return hashMapOf;
    }

    private final HashMap<String, Object> l(fl3.a data, ZootopiaDownloadButton button) {
        HashMap<String, Object> hashMapOf;
        ZootopiaMapSimpleInfo currMapInfo;
        Pair[] pairArr = new Pair[3];
        ZootopiaDownloadButtonBinder binder = data.getBinder();
        pairArr[0] = TuplesKt.to("zplan_map_id", Integer.valueOf((binder == null || (currMapInfo = binder.getCurrMapInfo()) == null) ? 0 : currMapInfo.getMapID()));
        pairArr[1] = TuplesKt.to("zplan_btn_status", Integer.valueOf(ButtonStatus.INSTANCE.b(button.getStatus())));
        pairArr[2] = TuplesKt.to("zplan_btn_context", button.r());
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        if (data.h() != null) {
            hashMapOf.putAll(data.h());
        }
        return hashMapOf;
    }

    private final void r(fl3.a data, LifecycleOwner lifecycleOwner) {
        setVisibility(0);
        o indexButton = data.getIndexButton();
        if (indexButton == null) {
            return;
        }
        int i3 = indexButton.f427645c;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    setVisibility(8);
                } else if (i3 != 3) {
                    if (i3 != 5) {
                        QLog.d("ZPlanCommonButton", 1, "nonsupport type " + i3);
                        setVisibility(8);
                    }
                } else if (lifecycleOwner != null) {
                    z(data, lifecycleOwner);
                }
            }
            w(data, i3 == 5);
        } else {
            u(data);
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.widget.impl.button.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZplanCommonButton.s(ZplanCommonButton.this, view);
            }
        });
    }

    public void t(fl3.a indexButton, LifecycleOwner lifecycleOwner) {
        if ((indexButton != null ? indexButton.getIndexButton() : null) == null) {
            setVisibility(8);
            QLog.e("ZPlanCommonButton", 1, "indexButton is null ");
            return;
        }
        QLog.d("ZPlanCommonButton", 1, "render button " + indexButton);
        r(indexButton, lifecycleOwner);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanCommonButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(ZplanCommonButton$viewReporter$2.INSTANCE);
        this.viewReporter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(ZplanCommonButton$cardElementReporter$2.INSTANCE);
        this.cardElementReporter = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(s84.a buttonStyle, o indexButton, final j item, final fl3.a data) {
        String str;
        Drawable background;
        String string;
        String str2;
        QLog.i("ZPlanCommonButton", 1, "renderReserveBtnInner item.id:" + (item != null ? item.f427619b : null) + " item.type" + (item != null ? Integer.valueOf(item.f427618a) : null));
        final Button button = this.commonButton;
        if (button != null) {
            button.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            button.setPadding(0, 0, 0, 0);
            if (buttonStyle != null) {
                button.setTextSize(buttonStyle.getTextSize());
                button.setTypeface(Typeface.defaultFromStyle(1));
                button.setBackground(AppCompatResources.getDrawable(button.getRootView().getContext(), buttonStyle.getLoadingBackgroundID()));
            }
            if (item != null) {
                if (item.f427620c) {
                    string = button.getContext().getString(R.string.xdl);
                } else {
                    string = button.getContext().getString(R.string.xdk);
                }
                button.setText(string);
                if (item.f427620c) {
                    str2 = "#66000000";
                } else {
                    str2 = "#FFB300";
                }
                m84.b.g(button, str2);
                button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.widget.impl.button.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ZplanCommonButton.y(ZplanCommonButton.this, item, data, button, view);
                    }
                });
            }
        }
        if (TextUtils.isEmpty(indexButton.f427644b)) {
            str = data.getDefBgColorRes();
        } else {
            str = indexButton.f427644b;
        }
        try {
            Button button2 = this.commonButton;
            if (button2 != null && (background = button2.getBackground()) != null) {
                background.mutate();
            }
            int parseColor = Color.parseColor(str);
            Button button3 = this.commonButton;
            Drawable background2 = button3 != null ? button3.getBackground() : null;
            if (background2 == null) {
                return;
            }
            background2.setColorFilter(new SimpleColorFilter(parseColor));
        } catch (Exception e16) {
            QLog.e("ZPlanCommonButton", 1, "Illegal parameter " + str + " " + e16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanCommonButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(ZplanCommonButton$viewReporter$2.INSTANCE);
        this.viewReporter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(ZplanCommonButton$cardElementReporter$2.INSTANCE);
        this.cardElementReporter = lazy2;
    }

    @Override // u74.a
    public void setRadius(int dp5) {
    }
}
