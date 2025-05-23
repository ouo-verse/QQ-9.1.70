package com.tencent.sqshow.zootopia.brand.list.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.brand.list.view.ZplanBrandItemView;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.ae;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import id3.d;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;
import pu4.b;
import pu4.c;
import pu4.g;
import t74.m;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b5\u00106J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\u000e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH\u0002J&\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015J\u0018\u0010\u0019\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\fR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001aR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0018\u0010*\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010$R\u0018\u0010.\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010$R\u0018\u00100\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010)R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/sqshow/zootopia/brand/list/view/ZplanBrandItemView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "iMediaView", "Lpu4/g;", WadlProxyConsts.KEY_MATERIAL, "", "f", "Lcom/tencent/image/URLImageView;", "imgView", "", "iconUrl", "", "coinType", "g", "Lpu4/b;", "dataInfo", "realItemPosition", "", "", "d", "Landroid/content/Context;", "context", "Landroid/view/View;", "e", "b", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "bigImage", "brandIconImg", "tagImg", "Landroid/widget/ImageView;", h.F, "Landroid/widget/ImageView;", "favIcon", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "name", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "priceTxt", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/image/URLImageView;", "priceIcon", "D", "priceMiddleTxt", "E", "price1Txt", UserInfo.SEX_FEMALE, "price1Icon", "Lid3/d;", "G", "Lid3/d;", "dtReporter", "<init>", "(Landroid/content/Context;)V", "H", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanBrandItemView extends FrameLayout {
    private static ColorDrawable I = new ColorDrawable(1224736767);

    /* renamed from: C, reason: from kotlin metadata */
    private URLImageView priceIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView priceMiddleTxt;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView price1Txt;

    /* renamed from: F, reason: from kotlin metadata */
    private URLImageView price1Icon;

    /* renamed from: G, reason: from kotlin metadata */
    private final d dtReporter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ZPlanMediaView bigImage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZPlanMediaView brandIconImg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ZPlanMediaView tagImg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView favIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView name;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView priceTxt;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanBrandItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dtReporter = new d(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ZplanBrandItemView this$0, b bVar, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dtReporter.c("clck", this$0, new LinkedHashMap());
        if (!TextUtils.isEmpty(bVar.f427409h)) {
            QLog.i("ZplanBrandItemView", 1, "click - " + bVar.f427402a + " - " + bVar.f427404c + " - " + bVar.f427409h);
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String str = bVar.f427409h;
            Intrinsics.checkNotNullExpressionValue(str, "dataInfo.jumpUrl");
            iSchemeApi.launchScheme(context, str);
            return;
        }
        QQToast.makeText(this$0.getContext(), "\u8df3\u8f6c\u53c2\u6570\u4e3a\u7a7a", 0).show();
        QLog.e("ZplanBrandItemView", 1, "click launchScheme but url is empty");
    }

    private final Map<String, Object> d(b dataInfo, int realItemPosition) {
        HashMap hashMap = new HashMap();
        if (dataInfo != null) {
            hashMap.put("zplan_item_id", Long.valueOf(dataInfo.f427402a));
            hashMap.put("zplan_elem_pos", Integer.valueOf(realItemPosition));
        }
        return hashMap;
    }

    public final void b(final b dataInfo, int realItemPosition) {
        TextView textView;
        setTag(Integer.valueOf(realItemPosition));
        if (dataInfo != null) {
            f(this.bigImage, dataInfo.f427405d);
            f(this.brandIconImg, dataInfo.f427406e);
            f(this.tagImg, dataInfo.f427411j);
            TextView textView2 = this.name;
            if (textView2 != null) {
                textView2.setText(dataInfo.f427404c);
            }
            ImageView imageView = this.favIcon;
            if (imageView != null) {
                imageView.setImageResource(dataInfo.f427408g == 1 ? R.drawable.ibn : R.drawable.ibm);
            }
            if (dataInfo.f427410i != null) {
                TextView textView3 = this.priceTxt;
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                URLImageView uRLImageView = this.priceIcon;
                if (uRLImageView != null) {
                    uRLImageView.setVisibility(0);
                }
                int i3 = dataInfo.f427410i.f427418a;
                int i16 = i3 != 0 ? 0 : 4;
                TextView textView4 = this.priceMiddleTxt;
                if (textView4 != null) {
                    textView4.setVisibility(i16);
                }
                TextView textView5 = this.price1Txt;
                if (textView5 != null) {
                    textView5.setVisibility(i16);
                }
                URLImageView uRLImageView2 = this.price1Icon;
                if (uRLImageView2 != null) {
                    uRLImageView2.setVisibility(i16);
                }
                if (i3 == 0) {
                    TextView textView6 = this.priceTxt;
                    if (textView6 != null) {
                        int i17 = dataInfo.f427410i.f427420c;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(i17);
                        textView6.setText(sb5.toString());
                    }
                    URLImageView uRLImageView3 = this.priceIcon;
                    c cVar = dataInfo.f427410i;
                    g(uRLImageView3, cVar.f427421d, cVar.f427419b);
                } else {
                    TextView textView7 = this.price1Txt;
                    if (textView7 != null) {
                        textView7.setVisibility(0);
                    }
                    URLImageView uRLImageView4 = this.price1Icon;
                    if (uRLImageView4 != null) {
                        uRLImageView4.setVisibility(0);
                    }
                    TextView textView8 = this.price1Txt;
                    if (textView8 != null) {
                        int i18 = dataInfo.f427410i.f427420c;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(i18);
                        textView8.setText(sb6.toString());
                    }
                    URLImageView uRLImageView5 = this.price1Icon;
                    c cVar2 = dataInfo.f427410i;
                    g(uRLImageView5, cVar2.f427421d, cVar2.f427419b);
                    TextView textView9 = this.priceTxt;
                    if (textView9 != null) {
                        int i19 = dataInfo.f427410i.f427423f;
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(i19);
                        textView9.setText(sb7.toString());
                    }
                    URLImageView uRLImageView6 = this.priceIcon;
                    c cVar3 = dataInfo.f427410i;
                    g(uRLImageView6, cVar3.f427424g, cVar3.f427422e);
                    if (i3 == 1) {
                        TextView textView10 = this.priceMiddleTxt;
                        if (textView10 != null) {
                            textView10.setText("");
                        }
                        TextView textView11 = this.price1Txt;
                        if (textView11 != null) {
                            textView11.setVisibility(8);
                        }
                        URLImageView uRLImageView7 = this.price1Icon;
                        if (uRLImageView7 != null) {
                            uRLImageView7.setVisibility(8);
                        }
                    } else if (i3 == 2 && (textView = this.priceMiddleTxt) != null) {
                        textView.setText(Marker.ANY_NON_NULL_MARKER);
                    }
                }
            } else {
                TextView textView12 = this.priceTxt;
                if (textView12 != null) {
                    textView12.setVisibility(4);
                }
                URLImageView uRLImageView8 = this.priceIcon;
                if (uRLImageView8 != null) {
                    uRLImageView8.setVisibility(4);
                }
                TextView textView13 = this.priceMiddleTxt;
                if (textView13 != null) {
                    textView13.setVisibility(4);
                }
                TextView textView14 = this.price1Txt;
                if (textView14 != null) {
                    textView14.setVisibility(4);
                }
                URLImageView uRLImageView9 = this.price1Icon;
                if (uRLImageView9 != null) {
                    uRLImageView9.setVisibility(4);
                }
            }
            d.i(this.dtReporter, this, "em_zplan_bestsale_item", d(dataInfo, realItemPosition), false, true, null, false, false, 224, null);
            aa.f(this, new View.OnClickListener() { // from class: i84.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZplanBrandItemView.c(ZplanBrandItemView.this, dataInfo, view);
                }
            }, 500L, "ZplanBrandItemView");
            return;
        }
        setOnClickListener(null);
    }

    public final View e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View view = LayoutInflater.from(context).inflate(R.layout.d77, (ViewGroup) this, true);
        View findViewById = view.findViewById(R.id.qnu);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView");
        this.bigImage = (ZPlanMediaView) findViewById;
        View findViewById2 = view.findViewById(R.id.qnq);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView");
        this.brandIconImg = (ZPlanMediaView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f163538qo1);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView");
        this.tagImg = (ZPlanMediaView) findViewById3;
        this.favIcon = (ImageView) view.findViewById(R.id.qnr);
        this.name = (TextView) view.findViewById(R.id.qnv);
        this.priceTxt = (TextView) view.findViewById(R.id.f163537qo0);
        this.priceIcon = (URLImageView) view.findViewById(R.id.qny);
        this.priceMiddleTxt = (TextView) view.findViewById(R.id.qnz);
        this.price1Txt = (TextView) view.findViewById(R.id.qnx);
        this.price1Icon = (URLImageView) view.findViewById(R.id.qnw);
        TextView textView = this.priceTxt;
        if (textView != null) {
            m mVar = m.f435564a;
            AssetManager assets = context.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
            textView.setTypeface(mVar.d(assets));
        }
        TextView textView2 = this.price1Txt;
        if (textView2 != null) {
            m mVar2 = m.f435564a;
            AssetManager assets2 = context.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
            textView2.setTypeface(mVar2.d(assets2));
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    private final void g(URLImageView imgView, String iconUrl, int coinType) {
        if (imgView == null || TextUtils.isEmpty(iconUrl)) {
            return;
        }
        ae.INSTANCE.a(imgView, iconUrl, I, coinType == 0 ? R.drawable.ibl : R.drawable.ibk);
    }

    private final void f(ZPlanMediaView iMediaView, g material) {
        if (iMediaView != null) {
            if (material != null) {
                iMediaView.setVisibility(0);
                iMediaView.e(material);
            } else {
                iMediaView.setVisibility(4);
            }
        }
    }
}
