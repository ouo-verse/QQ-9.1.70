package com.qzone.reborn.feedpro.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.qzone.reborn.feedpro.utils.aa;
import com.qzone.reborn.util.r;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.subscribe.widget.ShadowCardView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.tip.AnchorRelativePopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J0\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010#\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010&\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R6\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00050'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050'8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00104\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u001b\u001a\u0004\b1\u0010\u001d\"\u0004\b2\u00103R$\u0010<\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R.\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006F"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/b;", "Lcom/tencent/mobileqq/widget/tip/AnchorRelativePopupWindow;", "", ReportConstant.COSTREPORT_PREFIX, "l", "Lcom/qzone/reborn/feedpro/widget/MenuItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "itemView", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "anchor", "", "vertPos", "horizPos", "transX", "transY", "i", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "c", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "d", "I", "getPADDING_HORIZONTAL", "()I", "PADDING_HORIZONTAL", "e", "getPADDING_VERTICAL", "PADDING_VERTICAL", "", "value", "f", "Ljava/util/List;", "r", "()Ljava/util/List;", "t", "(Ljava/util/List;)V", "menuItems", "g", "getCardViewContainer", "setCardViewContainer", "(Landroid/view/View;)V", "cardViewContainer", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "getItemsContainer", "()Landroid/widget/LinearLayout;", "setItemsContainer", "(Landroid/widget/LinearLayout;)V", "itemsContainer", "", "Ljava/util/Map;", "getItemViews", "()Ljava/util/Map;", "setItemViews", "(Ljava/util/Map;)V", "itemViews", "<init>", "(Landroid/content/Context;Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b extends AnchorRelativePopupWindow {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final View rootView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int PADDING_HORIZONTAL;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int PADDING_VERTICAL;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private List<MenuItem> menuItems;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private View cardViewContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout itemsContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, View> itemViews;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, View rootView) {
        super(context);
        List<MenuItem> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.context = context;
        this.rootView = rootView;
        r rVar = r.f59560a;
        this.PADDING_HORIZONTAL = rVar.e(20);
        this.PADDING_VERTICAL = rVar.e(16);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.menuItems = emptyList;
        this.itemViews = new LinkedHashMap();
        s();
        setWidth(-2);
        setHeight(-2);
        setTouchable(true);
        setFocusable(true);
        setOutsideTouchable(true);
        setClippingEnabled(false);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    private final void l() {
        Object obj;
        int lastIndex;
        LinearLayout linearLayout;
        LinearLayout linearLayout2 = this.itemsContainer;
        if (linearLayout2 != null) {
            linearLayout2.removeAllViews();
        }
        if (this.menuItems.isEmpty()) {
            return;
        }
        this.itemViews.clear();
        Iterator<T> it = this.menuItems.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                int length = ((MenuItem) next).getText().length();
                do {
                    Object next2 = it.next();
                    int length2 = ((MenuItem) next2).getText().length();
                    if (length < length2) {
                        next = next2;
                        length = length2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        MenuItem menuItem = (MenuItem) obj;
        int i3 = 0;
        for (Object obj2 : this.menuItems) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MenuItem menuItem2 = (MenuItem) obj2;
            View n3 = n(menuItem2);
            if (menuItem != null && !Intrinsics.areEqual(menuItem2, menuItem)) {
                n3.getLayoutParams().width = -1;
            }
            LinearLayout linearLayout3 = this.itemsContainer;
            if (linearLayout3 != null) {
                linearLayout3.addView(n3);
            }
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.menuItems);
            if (i3 != lastIndex && (linearLayout = this.itemsContainer) != null) {
                linearLayout.addView(m());
            }
            this.itemViews.put(Integer.valueOf(menuItem2.getIEntranceId()), n3);
            q(menuItem2, n3);
            i3 = i16;
        }
    }

    private final View m() {
        View view = new View(this.context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        int i3 = this.PADDING_HORIZONTAL;
        layoutParams.setMargins(i3, 0, i3, 0);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(ResourcesCompat.getColor(view.getContext().getResources(), R.color.qui_common_border_standard, null));
        return view;
    }

    private final View n(final MenuItem item) {
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        int i3 = this.PADDING_HORIZONTAL;
        int i16 = this.PADDING_VERTICAL;
        linearLayout.setPadding(i3, i16, i3, i16);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        ImageView imageView = new ImageView(linearLayout.getContext());
        r rVar = r.f59560a;
        imageView.setLayoutParams(new LinearLayout.LayoutParams(rVar.e(20), rVar.e(20)));
        imageView.setImageResource(item.getIconResId());
        aa aaVar = aa.f54263a;
        aa.c(aaVar, imageView, 0.0f, 1, null);
        linearLayout.addView(imageView);
        TextView textView = new TextView(linearLayout.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(rVar.e(2));
        textView.setLayoutParams(layoutParams);
        textView.setText(item.getText());
        textView.setTextColor(ResourcesCompat.getColor(textView.getResources(), R.color.qui_common_text_primary, null));
        aa.e(aaVar, textView, 0.0f, 1, null);
        textView.setTextSize(16.0f);
        textView.setIncludeFontPadding(false);
        linearLayout.addView(textView);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.widget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.o(MenuItem.this, this, view);
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(MenuItem item, b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        item.c().invoke();
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p() {
        for (Map.Entry<Integer, View> entry : this.itemViews.entrySet()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("channellist_alert", 0);
            linkedHashMap.put("column_type", entry.getKey());
            linkedHashMap.put("is_friend_profile_picture", 0);
            fo.b bVar = new fo.b();
            bVar.l(linkedHashMap);
            bVar.i("entrance_id=" + entry.getKey());
            fo.c.l(entry.getValue(), this.rootView);
            fo.c.b("dt_imp", entry.getValue(), "em_qz_space_entry_column", bVar);
        }
    }

    private final void q(MenuItem item, View itemView) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("channellist_alert", 0);
        linkedHashMap.put("column_type", Integer.valueOf(item.getIEntranceId()));
        linkedHashMap.put("is_friend_profile_picture", 0);
        fo.b bVar = new fo.b();
        bVar.l(linkedHashMap);
        bVar.i("entrance_id=" + item.getIEntranceId());
        fo.c.l(itemView, this.rootView);
        fo.c.o(itemView, "em_qz_space_entry_column", bVar);
    }

    private final void s() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.f1301681, (ViewGroup) null);
        View findViewById = inflate != null ? inflate.findViewById(R.id.mx6) : null;
        this.cardViewContainer = findViewById;
        ShadowCardView shadowCardView = findViewById instanceof ShadowCardView ? (ShadowCardView) findViewById : null;
        if (shadowCardView != null) {
            shadowCardView.setShadowCardColor(ResourcesCompat.getColor(shadowCardView.getResources(), R.color.qui_common_fill_light_primary, null));
        }
        View view = this.cardViewContainer;
        this.itemsContainer = view != null ? (LinearLayout) view.findViewById(R.id.mx7) : null;
        setContentView(inflate);
    }

    @Override // com.tencent.mobileqq.widget.tip.AnchorRelativePopupWindow
    public void i(View anchor, int vertPos, int horizPos, int transX, int transY) {
        int i3;
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        View view = this.cardViewContainer;
        if (view == null) {
            super.i(anchor, vertPos, horizPos, transX, transY);
            return;
        }
        if (horizPos != 3) {
            i3 = horizPos != 4 ? 0 : view.getPaddingRight();
        } else {
            i3 = -view.getPaddingLeft();
        }
        super.i(anchor, vertPos, horizPos, transX + i3, transY + (vertPos == 2 ? -view.getPaddingTop() : 0));
        p();
    }

    public final List<MenuItem> r() {
        return this.menuItems;
    }

    public final void t(List<MenuItem> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.menuItems = value;
        l();
    }
}
