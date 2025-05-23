package com.tencent.mobileqq.zplan.card.impl.view.grid;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.grid.ZPlanGridWithBigCard;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.sqshow.zootopia.card.report.a;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.widget.media.ZPlanMediaView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import l84.b;
import m84.ViewAdjustObject;
import org.json.JSONObject;
import pu4.g;
import pv4.p;
import pv4.q;
import pv4.s;
import pv4.u;
import tl.h;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 B2\u00020\u0001:\u0003CDEB/\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010?\u001a\u00020\u0016\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\n\u0010\u0005\u001a\u00060\u0004R\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J \u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016R\u0014\u0010\u001c\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010 \u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0014\u0010\"\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0014\u0010$\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0014\u0010&\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001bR\u0014\u0010(\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u001bR\u0014\u0010*\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010\u001bR\u0014\u0010,\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\u001bR\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R.\u00105\u001a\u001a\u0012\b\u0012\u00060\u0004R\u00020\u00000\bj\f\u0012\b\u0012\u00060\u0004R\u00020\u0000`\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/grid/ZPlanGridWithBigCard;", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "", "G", "Lcom/tencent/mobileqq/zplan/card/impl/view/grid/ZPlanGridWithBigCard$c;", "gridItemViewHolder", "Lcom/tencent/mobileqq/zplan/card/impl/view/grid/ZPlanGridWithBigCard$b;", "gridItemLayoutParams", "Ljava/util/ArrayList;", "Lm84/a;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "viewParent", "Landroid/view/View;", ReportConstant.COSTREPORT_PREFIX, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", "", "position", "totalCount", "f", BdhLogUtil.LogTag.Tag_Req, "I", "bigItemWidth", ExifInterface.LATITUDE_SOUTH, "bigItemHeight", "T", "bigMediaWidth", "U", "bigMediaHeight", "V", "bigCircleSize", "W", "smallItemWidth", "a0", "smallItemHeight", "b0", "smallMediaWidth", "c0", "smallMediaHeight", "Landroid/graphics/drawable/Drawable;", "d0", "Landroid/graphics/drawable/Drawable;", "iconDefaultDrawable", "e0", "transparentDefaultDrawable", "f0", "Ljava/util/ArrayList;", "itemViewHolderList", "g0", "Landroid/view/View;", "realContentView", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "itemViewType", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;I)V", "h0", "a", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanGridWithBigCard extends ZootopiaBaseCard {

    /* renamed from: R, reason: from kotlin metadata */
    private final int bigItemWidth;

    /* renamed from: S, reason: from kotlin metadata */
    private final int bigItemHeight;

    /* renamed from: T, reason: from kotlin metadata */
    private final int bigMediaWidth;

    /* renamed from: U, reason: from kotlin metadata */
    private final int bigMediaHeight;

    /* renamed from: V, reason: from kotlin metadata */
    private final int bigCircleSize;

    /* renamed from: W, reason: from kotlin metadata */
    private final int smallItemWidth;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final int smallItemHeight;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final int smallMediaWidth;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final int smallMediaHeight;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private Drawable iconDefaultDrawable;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private Drawable transparentDefaultDrawable;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private ArrayList<c> itemViewHolderList;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private View realContentView;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\bD\u0010EJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ2\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fJ2\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fR\u0017\u0010\u0010\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u0003\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00100\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010(\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R$\u00104\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010(\u001a\u0004\b2\u0010*\"\u0004\b3\u0010,R$\u0010;\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b6\u00108\"\u0004\b9\u0010:R$\u0010=\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b1\u0010*\"\u0004\b<\u0010,R\u0017\u0010A\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b2\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010C\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010>\u001a\u0004\bB\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/grid/ZPlanGridWithBigCard$c;", "", "", "isBigItem", "", DomainData.DOMAIN_NAME, "k", "", "itemPos", "Lpv4/s;", "itemData", "parentCardPos", "Lcom/tencent/sqshow/zootopia/data/c;", "parentCardData", "l", "Landroid/view/View;", "itemView", "b", "c", "a", "Landroid/view/View;", "e", "()Landroid/view/View;", "Lcom/tencent/sqshow/zootopia/card/report/a;", "Lcom/tencent/sqshow/zootopia/card/report/a;", "getReportHelper", "()Lcom/tencent/sqshow/zootopia/card/report/a;", "reportHelper", "Z", "()Z", "setBigItem", "(Z)V", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setCircleView", "(Landroid/widget/ImageView;)V", "circleView", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "f", "()Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;", "setMediaView", "(Lcom/tencent/sqshow/zootopia/widget/media/ZPlanMediaView;)V", "mediaView", "i", "setTopLeftTagImg", "topLeftTagImg", "g", "j", "setTopRightTagImg", "topRightTagImg", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "()Landroid/widget/TextView;", "setTagDescTxt", "(Landroid/widget/TextView;)V", "tagDescTxt", "setTagDescIcon", "tagDescIcon", "I", "getDefaultTitleColor", "()I", "defaultTitleColor", "getDefaultDescColor", "defaultDescColor", "<init>", "(Lcom/tencent/mobileqq/zplan/card/impl/view/grid/ZPlanGridWithBigCard;Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final View itemView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final a reportHelper;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private boolean isBigItem;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private ImageView circleView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private ZPlanMediaView mediaView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private ZPlanMediaView topLeftTagImg;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private ZPlanMediaView topRightTagImg;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private TextView tagDescTxt;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private ZPlanMediaView tagDescIcon;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private final int defaultTitleColor;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private final int defaultDescColor;

        /* renamed from: l, reason: collision with root package name */
        final /* synthetic */ ZPlanGridWithBigCard f332241l;

        public c(ZPlanGridWithBigCard zPlanGridWithBigCard, View itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.f332241l = zPlanGridWithBigCard;
            this.itemView = itemView;
            this.reportHelper = new a();
            this.defaultTitleColor = Color.parseColor("#302F2F");
            this.defaultDescColor = Color.parseColor("#302F2F");
        }

        /* renamed from: d, reason: from getter */
        public final ImageView getCircleView() {
            return this.circleView;
        }

        /* renamed from: e, reason: from getter */
        public final View getItemView() {
            return this.itemView;
        }

        /* renamed from: f, reason: from getter */
        public final ZPlanMediaView getMediaView() {
            return this.mediaView;
        }

        /* renamed from: g, reason: from getter */
        public final ZPlanMediaView getTagDescIcon() {
            return this.tagDescIcon;
        }

        /* renamed from: h, reason: from getter */
        public final TextView getTagDescTxt() {
            return this.tagDescTxt;
        }

        /* renamed from: i, reason: from getter */
        public final ZPlanMediaView getTopLeftTagImg() {
            return this.topLeftTagImg;
        }

        /* renamed from: j, reason: from getter */
        public final ZPlanMediaView getTopRightTagImg() {
            return this.topRightTagImg;
        }

        public final void k() {
            this.circleView = (ImageView) this.itemView.findViewById(R.id.q38);
            this.mediaView = (ZPlanMediaView) this.itemView.findViewById(R.id.q3b);
            this.topLeftTagImg = (ZPlanMediaView) this.itemView.findViewById(R.id.q3k);
            this.topRightTagImg = (ZPlanMediaView) this.itemView.findViewById(R.id.q3l);
            this.tagDescTxt = (TextView) this.itemView.findViewById(R.id.q3m);
            this.tagDescIcon = (ZPlanMediaView) this.itemView.findViewById(R.id.q3n);
            ZPlanMediaView zPlanMediaView = this.mediaView;
            if (zPlanMediaView != null) {
                zPlanMediaView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            ZPlanMediaView zPlanMediaView2 = this.topLeftTagImg;
            if (zPlanMediaView2 != null) {
                zPlanMediaView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            ZPlanMediaView zPlanMediaView3 = this.topRightTagImg;
            if (zPlanMediaView3 != null) {
                zPlanMediaView3.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            ZPlanMediaView zPlanMediaView4 = this.tagDescIcon;
            if (zPlanMediaView4 != null) {
                zPlanMediaView4.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            ZPlanMediaView zPlanMediaView5 = this.mediaView;
            if (zPlanMediaView5 != null) {
                zPlanMediaView5.setDefaultDrawable(this.isBigItem ? this.f332241l.transparentDefaultDrawable : this.f332241l.iconDefaultDrawable);
            }
            ZPlanMediaView zPlanMediaView6 = this.topLeftTagImg;
            if (zPlanMediaView6 != null) {
                zPlanMediaView6.setDefaultDrawable(this.f332241l.transparentDefaultDrawable);
            }
            ZPlanMediaView zPlanMediaView7 = this.topRightTagImg;
            if (zPlanMediaView7 != null) {
                zPlanMediaView7.setDefaultDrawable(this.f332241l.transparentDefaultDrawable);
            }
        }

        public final void l(final int itemPos, final s itemData, final int parentCardPos, final ZootopiaCardData parentCardData) {
            u uVar;
            Intrinsics.checkNotNullParameter(parentCardData, "parentCardData");
            if (itemData != null) {
                ZPlanMediaView zPlanMediaView = this.mediaView;
                if (zPlanMediaView != null) {
                    g gVar = itemData.f427681b;
                    Intrinsics.checkNotNullExpressionValue(gVar, "itemData.material");
                    zPlanMediaView.e(gVar);
                }
                ZPlanMediaView zPlanMediaView2 = this.topLeftTagImg;
                if (zPlanMediaView2 != null) {
                    zPlanMediaView2.setVisibility(8);
                }
                ZPlanMediaView zPlanMediaView3 = this.topRightTagImg;
                if (zPlanMediaView3 != null) {
                    zPlanMediaView3.setVisibility(8);
                }
                p[] pVarArr = itemData.f427685f;
                if (pVarArr != null) {
                    for (p pVar : pVarArr) {
                        if (pVar.f427651a != null) {
                            int i3 = pVar.f427652b;
                            if (i3 == 0) {
                                ZPlanMediaView zPlanMediaView4 = this.topLeftTagImg;
                                if (zPlanMediaView4 != null) {
                                    zPlanMediaView4.setVisibility(0);
                                }
                                ZPlanMediaView zPlanMediaView5 = this.topLeftTagImg;
                                if (zPlanMediaView5 != null) {
                                    g gVar2 = pVar.f427651a;
                                    Intrinsics.checkNotNullExpressionValue(gVar2, "label.material");
                                    zPlanMediaView5.e(gVar2);
                                }
                            } else if (i3 == 1) {
                                ZPlanMediaView zPlanMediaView6 = this.topRightTagImg;
                                if (zPlanMediaView6 != null) {
                                    zPlanMediaView6.setVisibility(0);
                                }
                                ZPlanMediaView zPlanMediaView7 = this.topRightTagImg;
                                if (zPlanMediaView7 != null) {
                                    g gVar3 = pVar.f427651a;
                                    Intrinsics.checkNotNullExpressionValue(gVar3, "label.material");
                                    zPlanMediaView7.e(gVar3);
                                }
                            }
                        }
                    }
                }
                if (this.tagDescTxt != null && this.tagDescIcon != null) {
                    q qVar = itemData.f427687h;
                    if (TextUtils.isEmpty((qVar == null || (uVar = qVar.f427655c) == null) ? null : uVar.f427702a)) {
                        TextView textView = this.tagDescTxt;
                        if (textView != null) {
                            textView.setVisibility(8);
                        }
                        ZPlanMediaView zPlanMediaView8 = this.tagDescIcon;
                        if (zPlanMediaView8 != null) {
                            zPlanMediaView8.setVisibility(8);
                        }
                    } else {
                        TextView textView2 = this.tagDescTxt;
                        if (textView2 != null) {
                            textView2.setVisibility(0);
                        }
                        TextView textView3 = this.tagDescTxt;
                        if (textView3 != null) {
                            q qVar2 = itemData.f427687h;
                            b.a(textView3, qVar2 != null ? qVar2.f427655c : null, this.defaultDescColor);
                        }
                        q qVar3 = itemData.f427687h;
                        if ((qVar3 != null ? qVar3.f427653a : null) != null) {
                            ZPlanMediaView zPlanMediaView9 = this.tagDescIcon;
                            if (zPlanMediaView9 != null) {
                                g gVar4 = qVar3 != null ? qVar3.f427653a : null;
                                Intrinsics.checkNotNull(gVar4);
                                zPlanMediaView9.e(gVar4);
                            }
                            ZPlanMediaView zPlanMediaView10 = this.tagDescIcon;
                            if (zPlanMediaView10 != null) {
                                zPlanMediaView10.setVisibility(0);
                            }
                        } else {
                            ZPlanMediaView zPlanMediaView11 = this.tagDescIcon;
                            if (zPlanMediaView11 != null) {
                                zPlanMediaView11.setVisibility(8);
                            }
                        }
                    }
                }
                b(this.itemView, itemPos, itemData, parentCardPos, parentCardData);
                View view = this.itemView;
                final ZPlanGridWithBigCard zPlanGridWithBigCard = this.f332241l;
                aa.f(view, new View.OnClickListener() { // from class: tf3.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ZPlanGridWithBigCard.c.m(ZPlanGridWithBigCard.c.this, itemPos, itemData, parentCardPos, parentCardData, zPlanGridWithBigCard, view2);
                    }
                }, 1000L, "ZPlanGridWithBigCard");
            }
        }

        public final void n(boolean isBigItem) {
            this.isBigItem = isBigItem;
        }

        public final void c(View itemView, int itemPos, s itemData, int parentCardPos, ZootopiaCardData parentCardData) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            if (itemData == null || parentCardData == null) {
                return;
            }
            this.reportHelper.a(itemView, parentCardPos, itemPos, a.Companion.g(a.INSTANCE, itemData.f427681b, null, 2, null), parentCardData, itemData, (r20 & 64) != 0 ? new HashMap() : null, (r20 & 128) != 0 ? "em_zplan_element" : null);
        }

        public final void b(View itemView, int itemPos, s itemData, int parentCardPos, ZootopiaCardData parentCardData) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            if (itemData == null || parentCardData == null) {
                return;
            }
            this.reportHelper.c(itemView, parentCardPos, itemPos, a.Companion.g(a.INSTANCE, itemData.f427681b, null, 2, null), parentCardData, itemData, (r24 & 64) != 0 ? new HashMap() : null, (r24 & 128) != 0 ? "em_zplan_element" : null, (r24 & 256) != 0 ? null : null, (r24 & 512) != 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(c this$0, int i3, s sVar, int i16, ZootopiaCardData parentCardData, ZPlanGridWithBigCard this$1, View view) {
            JSONObject c16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(parentCardData, "$parentCardData");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            this$0.c(this$0.itemView, i3, sVar, i16, parentCardData);
            VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
            String str = pageInfo != null ? pageInfo.pageId : null;
            if (str == null) {
                str = "pg_zplan_paradise";
            }
            String str2 = str;
            a.Companion companion = a.INSTANCE;
            c16 = companion.c(i16, i3, a.Companion.g(companion, sVar.f427681b, null, 2, null), parentCardData, sVar, (r17 & 32) != 0 ? "pg_zplan_paradise" : str2, (r17 & 64) != 0 ? "em_zplan_element" : null);
            String str3 = sVar.f427682c;
            ZootopiaBaseCard.w(this$1, str3 != null ? CommonExKt.c(str3, "ReportData", c16) : null, false, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanGridWithBigCard(Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, int i3) {
        super(context, owner, mapResViewModel, sourceCurrent, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.bigItemWidth = getResources().getDimensionPixelSize(R.dimen.f11775o);
        this.bigItemHeight = getResources().getDimensionPixelSize(R.dimen.f11745l);
        this.bigMediaWidth = getResources().getDimensionPixelSize(R.dimen.f11765n);
        this.bigMediaHeight = getResources().getDimensionPixelSize(R.dimen.f11755m);
        this.bigCircleSize = getResources().getDimensionPixelSize(R.dimen.f11735k);
        this.smallItemWidth = getResources().getDimensionPixelSize(R.dimen.f11815s);
        this.smallItemHeight = getResources().getDimensionPixelSize(R.dimen.f11785p);
        this.smallMediaWidth = getResources().getDimensionPixelSize(R.dimen.f11805r);
        this.smallMediaHeight = getResources().getDimensionPixelSize(R.dimen.f11795q);
        this.iconDefaultDrawable = com.tencent.sqshow.zootopia.utils.q.b(R.drawable.h_m);
        this.itemViewHolderList = new ArrayList<>();
    }

    private final ArrayList<ViewAdjustObject> F(c gridItemViewHolder, GridItemLayoutParams gridItemLayoutParams) {
        ArrayList<ViewAdjustObject> arrayList = new ArrayList<>();
        arrayList.add(new ViewAdjustObject(gridItemViewHolder.getItemView(), gridItemLayoutParams.getScale(), gridItemLayoutParams.getItemWidth(), gridItemLayoutParams.getItemHeight(), new Rect(gridItemLayoutParams.getMarginLeft(), 0, 0, 0), false));
        arrayList.add(new ViewAdjustObject(gridItemViewHolder.getMediaView(), gridItemLayoutParams.getScale(), gridItemLayoutParams.getMediaWidth(), gridItemLayoutParams.getMediaHeight(), null, false, 48, null));
        arrayList.add(new ViewAdjustObject(gridItemViewHolder.getCircleView(), gridItemLayoutParams.getScale(), gridItemLayoutParams.getCircleSize(), gridItemLayoutParams.getCircleSize(), null, false, 48, null));
        arrayList.add(new ViewAdjustObject(gridItemViewHolder.getTopLeftTagImg(), gridItemLayoutParams.getScale(), gridItemLayoutParams.getTopLeftWidth(), gridItemLayoutParams.getTopLeftHeight(), new Rect(gridItemLayoutParams.getTopLeftMarginLeft(), gridItemLayoutParams.getTopLeftMarginTop(), 0, 0), true));
        arrayList.add(new ViewAdjustObject(gridItemViewHolder.getTopRightTagImg(), gridItemLayoutParams.getScale(), gridItemLayoutParams.getTopRightWidth(), gridItemLayoutParams.getTopRightHeight(), new Rect(0, gridItemLayoutParams.getTopRightMarginTop(), gridItemLayoutParams.getTopRightMarginRight(), 0), true));
        return arrayList;
    }

    @Override // l84.a
    public void f(ZootopiaCardData dataInfo, int position, int totalCount) {
        Intrinsics.checkNotNullParameter(dataInfo, "dataInfo");
        G();
        Iterator<c> it = this.itemViewHolderList.iterator();
        while (it.hasNext()) {
            it.next().getItemView().setVisibility(8);
        }
        int size = this.itemViewHolderList.size();
        List<s> c16 = dataInfo.c();
        int min = Math.min(size, c16 != null ? c16.size() : 0);
        for (int i3 = 0; i3 < min; i3++) {
            this.itemViewHolderList.get(i3).getItemView().setVisibility(0);
            c cVar = this.itemViewHolderList.get(i3);
            List<s> c17 = dataInfo.c();
            cVar.l(i3, c17 != null ? c17.get(i3) : null, position, dataInfo);
        }
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public View s(Context context, ViewGroup viewParent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewParent, "viewParent");
        View view = LayoutInflater.from(context).inflate(R.layout.dat, viewParent, true);
        View findViewById = view.findViewById(R.id.pxt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.grid_content)");
        this.realContentView = findViewById;
        ArrayList<c> arrayList = this.itemViewHolderList;
        View findViewById2 = view.findViewById(R.id.pxu);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.grid_item_1_big)");
        c cVar = new c(this, findViewById2);
        cVar.n(true);
        arrayList.add(cVar);
        ArrayList<c> arrayList2 = this.itemViewHolderList;
        View findViewById3 = view.findViewById(R.id.pxv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.grid_item_2_small)");
        arrayList2.add(new c(this, findViewById3));
        ArrayList<c> arrayList3 = this.itemViewHolderList;
        View findViewById4 = view.findViewById(R.id.pxw);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.grid_item_3_small)");
        arrayList3.add(new c(this, findViewById4));
        ArrayList<c> arrayList4 = this.itemViewHolderList;
        View findViewById5 = view.findViewById(R.id.pxx);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.grid_item_4_small)");
        arrayList4.add(new c(this, findViewById5));
        ArrayList<c> arrayList5 = this.itemViewHolderList;
        View findViewById6 = view.findViewById(R.id.pxy);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.grid_item_5_small)");
        arrayList5.add(new c(this, findViewById6));
        Iterator<c> it = this.itemViewHolderList.iterator();
        while (it.hasNext()) {
            it.next().k();
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    @Override // com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard
    public String z() {
        return "ZPlanGridWithBigCard";
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b6\b\u0082\b\u0018\u00002\u00020\u0001B\u007f\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0004\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010(\u001a\u00020\u0004\u0012\u0006\u0010,\u001a\u00020\u0004\u0012\u0006\u00100\u001a\u00020\u0004\u0012\u0006\u00102\u001a\u00020\u0004\u0012\u0006\u00104\u001a\u00020\u0004\u0012\u0006\u00108\u001a\u00020\u0004\u0012\u0006\u0010:\u001a\u00020\u0004\u0012\u0006\u0010<\u001a\u00020\u0004\u00a2\u0006\u0004\b=\u0010>J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\n\u0010\u0014\"\u0004\b!\u0010\u0016R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016R\"\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0012\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0012\u001a\u0004\b.\u0010\u0014\"\u0004\b/\u0010\u0016R\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0012\u001a\u0004\b-\u0010\u0014\"\u0004\b1\u0010\u0016R\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0012\u001a\u0004\b)\u0010\u0014\"\u0004\b3\u0010\u0016R\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u0012\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u0010\u0016R\"\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u0012\u001a\u0004\b5\u0010\u0014\"\u0004\b9\u0010\u0016R\"\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b;\u0010\u0016\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/grid/ZPlanGridWithBigCard$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "g", "()F", "setScale", "(F)V", "scale", "b", "I", "c", "()I", "setItemWidth", "(I)V", "itemWidth", "setItemHeight", "itemHeight", "d", "f", "setMediaWidth", "mediaWidth", "e", "setMediaHeight", "mediaHeight", "setCircleSize", "circleSize", "k", "setTopLeftWidth", "topLeftWidth", h.F, "setTopLeftHeight", "topLeftHeight", "i", "o", "setTopRightWidth", "topRightWidth", "j", "l", "setTopRightHeight", "topRightHeight", "setTopLeftMarginTop", "topLeftMarginTop", "setTopLeftMarginLeft", "topLeftMarginLeft", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "setTopRightMarginTop", "topRightMarginTop", "setTopRightMarginRight", "topRightMarginRight", "p", NodeProps.MARGIN_LEFT, "<init>", "(FIIIIIIIIIIIIII)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.card.impl.view.grid.ZPlanGridWithBigCard$b, reason: from toString */
    /* loaded from: classes35.dex */
    public static final /* data */ class GridItemLayoutParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private float scale;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int itemWidth;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int itemHeight;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int mediaWidth;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int mediaHeight;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private int circleSize;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private int topLeftWidth;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private int topLeftHeight;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private int topRightWidth;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        private int topRightHeight;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
        private int topLeftMarginTop;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
        private int topLeftMarginLeft;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
        private int topRightMarginTop;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
        private int topRightMarginRight;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
        private int marginLeft;

        public GridItemLayoutParams(float f16, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36, int i37, int i38, int i39, int i46) {
            this.scale = f16;
            this.itemWidth = i3;
            this.itemHeight = i16;
            this.mediaWidth = i17;
            this.mediaHeight = i18;
            this.circleSize = i19;
            this.topLeftWidth = i26;
            this.topLeftHeight = i27;
            this.topRightWidth = i28;
            this.topRightHeight = i29;
            this.topLeftMarginTop = i36;
            this.topLeftMarginLeft = i37;
            this.topRightMarginTop = i38;
            this.topRightMarginRight = i39;
            this.marginLeft = i46;
        }

        /* renamed from: a, reason: from getter */
        public final int getCircleSize() {
            return this.circleSize;
        }

        /* renamed from: b, reason: from getter */
        public final int getItemHeight() {
            return this.itemHeight;
        }

        /* renamed from: c, reason: from getter */
        public final int getItemWidth() {
            return this.itemWidth;
        }

        /* renamed from: d, reason: from getter */
        public final int getMarginLeft() {
            return this.marginLeft;
        }

        /* renamed from: e, reason: from getter */
        public final int getMediaHeight() {
            return this.mediaHeight;
        }

        /* renamed from: f, reason: from getter */
        public final int getMediaWidth() {
            return this.mediaWidth;
        }

        /* renamed from: g, reason: from getter */
        public final float getScale() {
            return this.scale;
        }

        /* renamed from: h, reason: from getter */
        public final int getTopLeftHeight() {
            return this.topLeftHeight;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((Float.floatToIntBits(this.scale) * 31) + this.itemWidth) * 31) + this.itemHeight) * 31) + this.mediaWidth) * 31) + this.mediaHeight) * 31) + this.circleSize) * 31) + this.topLeftWidth) * 31) + this.topLeftHeight) * 31) + this.topRightWidth) * 31) + this.topRightHeight) * 31) + this.topLeftMarginTop) * 31) + this.topLeftMarginLeft) * 31) + this.topRightMarginTop) * 31) + this.topRightMarginRight) * 31) + this.marginLeft;
        }

        /* renamed from: i, reason: from getter */
        public final int getTopLeftMarginLeft() {
            return this.topLeftMarginLeft;
        }

        /* renamed from: j, reason: from getter */
        public final int getTopLeftMarginTop() {
            return this.topLeftMarginTop;
        }

        /* renamed from: k, reason: from getter */
        public final int getTopLeftWidth() {
            return this.topLeftWidth;
        }

        /* renamed from: l, reason: from getter */
        public final int getTopRightHeight() {
            return this.topRightHeight;
        }

        /* renamed from: m, reason: from getter */
        public final int getTopRightMarginRight() {
            return this.topRightMarginRight;
        }

        /* renamed from: n, reason: from getter */
        public final int getTopRightMarginTop() {
            return this.topRightMarginTop;
        }

        /* renamed from: o, reason: from getter */
        public final int getTopRightWidth() {
            return this.topRightWidth;
        }

        public final void p(int i3) {
            this.marginLeft = i3;
        }

        public String toString() {
            return "GridItemLayoutParams(scale=" + this.scale + ", itemWidth=" + this.itemWidth + ", itemHeight=" + this.itemHeight + ", mediaWidth=" + this.mediaWidth + ", mediaHeight=" + this.mediaHeight + ", circleSize=" + this.circleSize + ", topLeftWidth=" + this.topLeftWidth + ", topLeftHeight=" + this.topLeftHeight + ", topRightWidth=" + this.topRightWidth + ", topRightHeight=" + this.topRightHeight + ", topLeftMarginTop=" + this.topLeftMarginTop + ", topLeftMarginLeft=" + this.topLeftMarginLeft + ", topRightMarginTop=" + this.topRightMarginTop + ", topRightMarginRight=" + this.topRightMarginRight + ", marginLeft=" + this.marginLeft + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GridItemLayoutParams)) {
                return false;
            }
            GridItemLayoutParams gridItemLayoutParams = (GridItemLayoutParams) other;
            return Float.compare(this.scale, gridItemLayoutParams.scale) == 0 && this.itemWidth == gridItemLayoutParams.itemWidth && this.itemHeight == gridItemLayoutParams.itemHeight && this.mediaWidth == gridItemLayoutParams.mediaWidth && this.mediaHeight == gridItemLayoutParams.mediaHeight && this.circleSize == gridItemLayoutParams.circleSize && this.topLeftWidth == gridItemLayoutParams.topLeftWidth && this.topLeftHeight == gridItemLayoutParams.topLeftHeight && this.topRightWidth == gridItemLayoutParams.topRightWidth && this.topRightHeight == gridItemLayoutParams.topRightHeight && this.topLeftMarginTop == gridItemLayoutParams.topLeftMarginTop && this.topLeftMarginLeft == gridItemLayoutParams.topLeftMarginLeft && this.topRightMarginTop == gridItemLayoutParams.topRightMarginTop && this.topRightMarginRight == gridItemLayoutParams.topRightMarginRight && this.marginLeft == gridItemLayoutParams.marginLeft;
        }
    }

    private final void G() {
        int screenWidth = (ba.getScreenWidth(getContext()) - getResources().getDimensionPixelSize(R.dimen.f11835u)) - getResources().getDimensionPixelSize(R.dimen.f11845v);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f11825t);
        int i3 = screenWidth / 2;
        int i16 = ((screenWidth - i3) - (dimensionPixelSize * 2)) / 2;
        int i17 = i3 + dimensionPixelSize;
        float f16 = i3 / this.bigItemWidth;
        float f17 = i16 / this.smallItemWidth;
        ArrayList<ViewAdjustObject> arrayList = new ArrayList();
        View view = this.realContentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("realContentView");
            view = null;
        }
        arrayList.add(new ViewAdjustObject(view, f16, -1, this.bigItemHeight, null, false, 48, null));
        c cVar = this.itemViewHolderList.get(0);
        Intrinsics.checkNotNullExpressionValue(cVar, "itemViewHolderList[0]");
        arrayList.addAll(F(cVar, new GridItemLayoutParams(f16, this.bigItemWidth, this.bigItemHeight, this.bigMediaWidth, this.bigMediaHeight, this.bigCircleSize, i.b(16), i.b(16), i.b(38), i.a(29.5f), i.b(5), i.b(5), i.a(5.5f), i.a(2.5f), 0)));
        arrayList.add(new ViewAdjustObject(this.itemViewHolderList.get(0).getTagDescIcon(), f16, i.b(11), i.b(11), new Rect(0, 0, i.b(5), 0), true));
        TextView tagDescTxt = this.itemViewHolderList.get(0).getTagDescTxt();
        if (tagDescTxt != null) {
            m84.b.e(tagDescTxt, f16, 9, null, false, 12, null);
        }
        GridItemLayoutParams gridItemLayoutParams = new GridItemLayoutParams(f17, this.smallItemWidth, this.smallItemHeight, this.smallMediaWidth, this.smallMediaHeight, this.bigCircleSize, i.b(16), i.b(16), i.b(32), i.b(25), i.b(5), i.b(5), i.a(5.5f), i.b(2), i17);
        c cVar2 = this.itemViewHolderList.get(1);
        Intrinsics.checkNotNullExpressionValue(cVar2, "itemViewHolderList[1]");
        arrayList.addAll(F(cVar2, gridItemLayoutParams));
        c cVar3 = this.itemViewHolderList.get(3);
        Intrinsics.checkNotNullExpressionValue(cVar3, "itemViewHolderList[3]");
        arrayList.addAll(F(cVar3, gridItemLayoutParams));
        gridItemLayoutParams.p(0);
        c cVar4 = this.itemViewHolderList.get(2);
        Intrinsics.checkNotNullExpressionValue(cVar4, "itemViewHolderList[2]");
        arrayList.addAll(F(cVar4, gridItemLayoutParams));
        c cVar5 = this.itemViewHolderList.get(4);
        Intrinsics.checkNotNullExpressionValue(cVar5, "itemViewHolderList[4]");
        arrayList.addAll(F(cVar5, gridItemLayoutParams));
        for (ViewAdjustObject viewAdjustObject : arrayList) {
            View view2 = viewAdjustObject.getView();
            if (view2 != null) {
                m84.b.a(view2, viewAdjustObject);
            }
        }
    }
}
