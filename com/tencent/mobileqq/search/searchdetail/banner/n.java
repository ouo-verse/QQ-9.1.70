package com.tencent.mobileqq.search.searchdetail.banner;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.mobileqq.search.searchdetail.content.base.g;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateTopicHeaderItem;
import com.tencent.mobileqq.search.searchdetail.multimedia.o;
import com.tencent.mobileqq.search.util.TopCropImageView;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import hp2.ak;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003!\"#B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u001a\u0010\u0015\u001a\u00020\n8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/banner/n;", "Lcom/tencent/mobileqq/search/searchdetail/content/base/BaseSearchTemplateSection;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/r;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "y", "data", "", "position", "", "", "payload", "Y", "a0", "D", "I", BdhLogUtil.LogTag.Tag_Conn, "()I", "cardMargin", "Lhp2/ak;", "E", "Lhp2/ak;", "binding", "", "M", "()Z", "overrideBackground", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "c", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class n extends BaseSearchTemplateSection<NetSearchTemplateTopicHeaderItem> {

    /* renamed from: D, reason: from kotlin metadata */
    private final int cardMargin;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ak binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0018\u0010\u0019J4\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JR\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/banner/n$c;", "Landroid/text/style/ReplacementSpan;", "Landroid/graphics/Paint;", "paint", "", "text", "", "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "", "draw", "d", "I", "width", "<init>", "(I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c extends ReplacementSpan {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int width;

        public c(int i3) {
            this.width = i3;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
            Intrinsics.checkNotNullParameter(paint, "paint");
            return this.width;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(NetSearchTemplateTopicHeaderItem data, n this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchJump searchJump = data.getTopicHeader().icon.jumpLink;
        QLog.d(this$0.getTAG(), 4, "jump to :" + searchJump);
        g.a.a(this$0, data.getTopicHeader().getIcon().jumpLink, null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: C, reason: from getter */
    protected int getCardMargin() {
        return this.cardMargin;
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: M */
    protected boolean getOverrideBackground() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0150  */
    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x(@NotNull final NetSearchTemplateTopicHeaderItem data, int position, @Nullable List<Object> payload) {
        ak akVar;
        ConstraintLayout root;
        String str;
        Object obj;
        String str2;
        Map mapOf;
        boolean z16;
        boolean z17;
        Drawable drawable;
        boolean z18;
        Intrinsics.checkNotNullParameter(data, "data");
        String str3 = data.getTopicHeader().background.iconLink;
        String icon = data.getTopicHeader().getIcon().iconLink;
        String iconToken = data.getTopicHeader().icon.iconToken;
        String iconTokenColor = data.getTopicHeader().icon.iconColorToken;
        String str4 = data.getTopicHeader().icon.title.text;
        String str5 = data.getTopicHeader().icon.subTitle.text;
        ak akVar2 = this.binding;
        if (akVar2 != null) {
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = null;
            obtain.mLoadingDrawable = com.tencent.mobileqq.vas.image.h.INSTANCE.a();
            URLDrawable drawable2 = URLDrawable.getDrawable(str3, obtain);
            drawable2.setFadeInImage(true);
            TopCropImageView ivBg = akVar2.f405596b;
            Intrinsics.checkNotNullExpressionValue(ivBg, "ivBg");
            drawable2.setURLDrawableListener(new b(ivBg));
            akVar2.f405596b.setImageDrawable(drawable2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            int dpToPx = ViewUtils.dpToPx(20.0f);
            Paint.FontMetrics fontMetrics = akVar2.f405599e.getPaint().getFontMetrics();
            float f16 = fontMetrics.bottom - fontMetrics.top;
            float f17 = (f16 / 2.0f) - (dpToPx / 2.0f);
            Intrinsics.checkNotNullExpressionValue(iconToken, "iconToken");
            if (iconToken.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.d(getTAG(), 2, "loadTokenImage icon:" + iconToken);
                try {
                    o oVar = o.f284545a;
                    Context context = akVar2.getRoot().getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "root.context");
                    drawable = oVar.e(context, iconToken);
                    try {
                        Intrinsics.checkNotNullExpressionValue(iconTokenColor, "iconTokenColor");
                        Context context2 = akVar2.getRoot().getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "root.context");
                        Integer c16 = oVar.c(iconTokenColor, context2);
                        if (c16 != null) {
                            c16.intValue();
                            if (drawable != null) {
                                drawable.setColorFilter(new PorterDuffColorFilter(c16.intValue(), PorterDuff.Mode.SRC_IN));
                            }
                        }
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e(getTAG(), 1, "loadTokenImage error:" + e);
                        if (drawable != null) {
                        }
                        spannableStringBuilder.append((CharSequence) str4);
                        akVar2.f405599e.setText(spannableStringBuilder);
                        akVar2.f405598d.setText(str5);
                        akVar2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.banner.m
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                n.Z(NetSearchTemplateTopicHeaderItem.this, this, view);
                            }
                        });
                        akVar = this.binding;
                        if (akVar == null) {
                        } else {
                            return;
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    drawable = null;
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(icon, "icon");
                if (icon.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    QLog.d(getTAG(), 2, "loadIconImage icon:" + icon);
                    drawable = URLDrawable.getDrawable(icon, (URLDrawable.URLDrawableOptions) null);
                } else {
                    drawable = null;
                }
            }
            if (drawable != null) {
                drawable.setBounds(new Rect(0, 0, dpToPx, dpToPx));
                OffsetableImageSpan offsetableImageSpan = new OffsetableImageSpan(drawable, 0);
                if (f16 == 0.0f) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18) {
                    offsetableImageSpan.setOffset((-f17) / f16);
                }
                spannableStringBuilder.append(" ", offsetableImageSpan, 33);
                spannableStringBuilder.append(" ", new c(ViewUtils.dpToPx(2.0f)), 33);
            }
            spannableStringBuilder.append((CharSequence) str4);
            akVar2.f405599e.setText(spannableStringBuilder);
            akVar2.f405598d.setText(str5);
            akVar2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.banner.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    n.Z(NetSearchTemplateTopicHeaderItem.this, this, view);
                }
            });
        }
        akVar = this.binding;
        if (akVar == null && (root = akVar.getRoot()) != null) {
            VideoReport.setElementId(root, "em_bas_topic_banner");
            VideoReport.setElementExposePolicy(root, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(root, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(root, ClickPolicy.REPORT_ALL);
            Pair[] pairArr = new Pair[6];
            com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc = getDtReportIoc();
            Object obj2 = "";
            if (dtReportIoc == null || (str = dtReportIoc.getTabName()) == null) {
                str = "";
            }
            pairArr[0] = TuplesKt.to("tab_name", str);
            com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc2 = getDtReportIoc();
            if (dtReportIoc2 == null) {
                obj = "";
            } else {
                obj = Long.valueOf(dtReportIoc2.getTabMask());
            }
            pairArr[1] = TuplesKt.to("tab_mask", obj);
            com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc3 = getDtReportIoc();
            if (dtReportIoc3 == null || (str2 = dtReportIoc3.getKeyword()) == null) {
                str2 = "";
            }
            pairArr[2] = TuplesKt.to("search_query_text", str2);
            pairArr[3] = TuplesKt.to("search_trace_id", data.getCommonInfo().getTraceId());
            com.tencent.mobileqq.search.searchdetail.content.base.c dtReportIoc4 = getDtReportIoc();
            if (dtReportIoc4 != null) {
                obj2 = Integer.valueOf(dtReportIoc4.getQuerySource());
            }
            pairArr[4] = TuplesKt.to("query_source", obj2);
            pairArr[5] = TuplesKt.to("topic_name", str4);
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            VideoReport.setElementParams(root, mapOf);
        }
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public int N(@NotNull NetSearchTemplateTopicHeaderItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection
    public void y(@Nullable View containerView) {
        if (containerView == null) {
            QLog.e("TemplateTopicHeadSection", 1, "onInitView got null item");
        } else {
            this.binding = ak.e(containerView.findViewById(R.id.yfv));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/banner/n$b;", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "Lmqq/util/WeakReference;", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "targetRef", "imageView", "<init>", "(Landroid/widget/ImageView;)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<ImageView> targetRef;

        public b(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            this.targetRef = new WeakReference<>(imageView);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            ImageView imageView = this.targetRef.get();
            if (imageView != null) {
                imageView.requestLayout();
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
        }
    }
}
