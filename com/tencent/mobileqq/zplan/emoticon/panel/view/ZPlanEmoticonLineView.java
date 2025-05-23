package com.tencent.mobileqq.zplan.emoticon.panel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.message.ZPlanSessionInfo;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lh3.ZPlanEmotionItemInfo;
import tl.h;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BW\u0012\u0006\u00106\u001a\u000205\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000107\u0012\b\b\u0002\u00109\u001a\u00020\u0002\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010<\u001a\u00020\u0002\u0012\u0006\u0010=\u001a\u00020\u0002\u0012\u0006\u0010?\u001a\u00020>\u0012\b\u0010A\u001a\u0004\u0018\u00010@\u0012\u0006\u0010C\u001a\u00020B\u00a2\u0006\u0004\bD\u0010EB;\b\u0016\u0012\u0006\u0010;\u001a\u00020:\u0012\u0006\u0010<\u001a\u00020\u0002\u0012\u0006\u0010=\u001a\u00020\u0002\u0012\u0006\u0010?\u001a\u00020>\u0012\b\u0010A\u001a\u0004\u0018\u00010@\u0012\u0006\u0010C\u001a\u00020B\u00a2\u0006\u0004\bD\u0010FJ\u001a\u0010\u0006\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J$\u0010\u0013\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0015R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\t0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020'0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010%R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u0014\u00103\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u00102\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanEmoticonLineView;", "Landroid/widget/LinearLayout;", "", "resId", "", "name", "a", "Lcom/tencent/mobileqq/zplan/model/e;", "data", "Lcom/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanEmoticonItemView;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "", "Llh3/a;", "dataList", "Landroid/view/View$OnClickListener;", "onEditClickListener", "onStoreClickListener", "b", "d", "I", "screenWidth", "e", "linePadding", "f", "itemWidth", h.F, "iconContentWidth", "i", "itemHeight", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "storeEntranceTopMargin", BdhLogUtil.LogTag.Tag_Conn, "storeEntranceBottomMargin", "", "D", "Ljava/util/List;", VideoTemplateParser.ITEM_LIST, "Landroid/view/View;", "E", "entranceList", "", UserInfo.SEX_FEMALE, "Z", "isNightTheme", "", "G", "ICON_WIDTH", "H", "Landroid/widget/LinearLayout;", "storeEntrance", "editEntrance", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Landroid/view/ViewGroup;", "aioRoot", "panelWidth", "columns", "Lcom/tencent/mobileqq/zplan/message/c;", "sessionInfo", "Lmh3/b;", "zPlanEmotionReportManager", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "callback", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroid/view/ViewGroup;IILcom/tencent/mobileqq/zplan/message/c;Lmh3/b;Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;)V", "(Landroid/view/ViewGroup;IILcom/tencent/mobileqq/zplan/message/c;Lmh3/b;Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonLineView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final int storeEntranceBottomMargin;

    /* renamed from: D, reason: from kotlin metadata */
    private final List<ZPlanEmoticonItemView> itemList;

    /* renamed from: E, reason: from kotlin metadata */
    private final List<View> entranceList;

    /* renamed from: F, reason: from kotlin metadata */
    private final boolean isNightTheme;

    /* renamed from: G, reason: from kotlin metadata */
    private final float ICON_WIDTH;

    /* renamed from: H, reason: from kotlin metadata */
    private final LinearLayout storeEntrance;

    /* renamed from: I, reason: from kotlin metadata */
    private final LinearLayout editEntrance;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int screenWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int linePadding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int itemWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int iconContentWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int itemHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int storeEntranceTopMargin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonLineView(Context context, AttributeSet attributeSet, int i3, ViewGroup aioRoot, int i16, int i17, ZPlanSessionInfo sessionInfo, mh3.b bVar, EmoticonCallback callback) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioRoot, "aioRoot");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        int b16 = x.f(context).b();
        this.screenWidth = b16;
        this.itemWidth = b16 / i17;
        this.iconContentWidth = ViewUtils.dip2px(54.0f);
        int dip2px = ViewUtils.dip2px(85.0f);
        this.itemHeight = dip2px;
        this.storeEntranceTopMargin = ViewUtils.dip2px(10.0f);
        this.storeEntranceBottomMargin = ViewUtils.dip2px(27.0f);
        this.itemList = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.entranceList = arrayList;
        this.isNightTheme = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        this.ICON_WIDTH = 54.0f;
        String string = context.getString(R.string.xjb);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ion_panel_store_entrance)");
        LinearLayout a16 = a(R.drawable.i3j, string);
        this.storeEntrance = a16;
        String string2 = context.getString(R.string.xj9);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026tion_panel_edit_entrance)");
        LinearLayout a17 = a(R.drawable.i3i, string2);
        this.editEntrance = a17;
        setOrientation(0);
        setPadding(LayoutAttrsKt.getDp(this.linePadding), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setPadding(getPaddingLeft(), getPaddingTop(), LayoutAttrsKt.getDp(this.linePadding), getPaddingBottom());
        this.itemWidth = i16 > 0 ? i16 / i17 : this.itemWidth;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.itemWidth, dip2px);
        if (((IZootopiaApi) QRoute.api(IZootopiaApi.class)).enableZPlanAIOMakeGifEntrance()) {
            addView(a17, layoutParams);
            arrayList.add(a17);
        }
        addView(a16, layoutParams);
        arrayList.add(a16);
        for (int i18 = 0; i18 < i17; i18++) {
            ZPlanEmoticonItemView zPlanEmoticonItemView = new ZPlanEmoticonItemView(context, aioRoot, this.ICON_WIDTH, sessionInfo, bVar, callback);
            this.itemList.add(zPlanEmoticonItemView);
            addView(zPlanEmoticonItemView, layoutParams);
        }
    }

    private final LinearLayout a(int resId, String name) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(resId);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        TextView textView = new TextView(getContext());
        textView.setMaxLines(1);
        textView.setTextSize(2, 12.0f);
        textView.setText(name);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        int dip2px = ViewUtils.dip2px(this.ICON_WIDTH);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dip2px, dip2px);
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = ViewUtils.dip2px(6.0f);
        if (this.isNightTheme) {
            textView.setTextColor(q.a(R.color.f8737r));
        } else {
            textView.setTextColor(q.a(R.color.f8717p));
        }
        linearLayout.addView(textView, layoutParams2);
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    private final void c(ZPlanActionInfo data, ZPlanEmoticonItemView item) {
        item.setData(data);
    }

    public final void b(List<ZPlanEmotionItemInfo> dataList, View.OnClickListener onEditClickListener, View.OnClickListener onStoreClickListener) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        Intrinsics.checkNotNullParameter(onEditClickListener, "onEditClickListener");
        Intrinsics.checkNotNullParameter(onStoreClickListener, "onStoreClickListener");
        if (dataList.isEmpty()) {
            removeAllViews();
            this.itemList.clear();
            return;
        }
        int size = dataList.size();
        int size2 = this.itemList.size();
        int size3 = this.entranceList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (i3 < size) {
                int type = dataList.get(i3).getType();
                if (type == 0) {
                    this.itemList.get(i3).setVisibility(0);
                    if (i3 < size3) {
                        this.entranceList.get(i3).setVisibility(8);
                    }
                    ZPlanActionInfo zPlanActionInfo = dataList.get(i3).getZPlanActionInfo();
                    if (zPlanActionInfo != null) {
                        c(zPlanActionInfo, this.itemList.get(i3));
                    }
                } else if (type == 1) {
                    this.itemList.get(i3).setVisibility(8);
                    this.storeEntrance.setVisibility(0);
                    this.storeEntrance.setOnClickListener(onStoreClickListener);
                } else if (type == 2) {
                    this.itemList.get(i3).setVisibility(8);
                    this.editEntrance.setVisibility(0);
                    this.editEntrance.setOnClickListener(onEditClickListener);
                }
            } else {
                this.itemList.get(i3).setVisibility(8);
                if (i3 < size3) {
                    this.entranceList.get(i3).setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ZPlanEmoticonLineView(ViewGroup aioRoot, int i3, int i16, ZPlanSessionInfo sessionInfo, mh3.b bVar, EmoticonCallback callback) {
        this(r2, null, 0, aioRoot, i3, i16, sessionInfo, bVar, callback);
        Intrinsics.checkNotNullParameter(aioRoot, "aioRoot");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Context context = aioRoot.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "aioRoot.context");
    }
}
