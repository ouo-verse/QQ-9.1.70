package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/B9\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\u001e\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0012\u00a2\u0006\u0004\b-\u0010.J\u001a\u0010\u0007\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R,\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00140%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/bm;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bm$a;", "Landroid/view/ViewGroup;", "p0", "", "p1", "u", "getItemCount", "", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "e", "I", "rightBeautyBtnMode", "Lkotlin/Function3;", "Landroid/view/View;", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", "f", "Lkotlin/jvm/functions/Function3;", "listener", tl.h.F, "getDefaultDrawableId", "()I", "setDefaultDrawableId", "(I)V", "defaultDrawableId", "i", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", "r", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;", "v", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/bj;)V", "selectItem", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "data", "<init>", "(Landroid/content/Context;ILkotlin/jvm/functions/Function3;)V", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class bm extends RecyclerView.Adapter<a> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int rightBeautyBtnMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Function3<View, bj, Integer, Unit> listener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int defaultDrawableId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private bj selectItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<? extends bj> data;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010/\u001a\u00020\u001f\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010#\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010%\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b\u0014\u0010\"R\u0017\u0010(\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"R\u0017\u0010*\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b)\u0010 \u001a\u0004\b\u001a\u0010\"R\u0017\u0010.\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b$\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/bm$a;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Lcom/tencent/aelight/camera/ae/view/AEDownLoadingView;", "view", "", "l", "", "highlightColor", "Landroid/graphics/drawable/Drawable;", "c", "normalColor", "Landroid/content/res/ColorStateList;", "d", "b", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "g", "()Landroid/widget/ImageView;", "iconImage", "Landroid/widget/FrameLayout;", "e", "Landroid/widget/FrameLayout;", tl.h.F, "()Landroid/widget/FrameLayout;", "iconParent", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "k", "()Landroid/widget/TextView;", "titleText", "Landroid/view/View;", "Landroid/view/View;", "j", "()Landroid/view/View;", "subListIndicator", "i", "downloadView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getMaskView", "maskView", BdhLogUtil.LogTag.Tag_Conn, "iconContainer", "D", "Lcom/tencent/aelight/camera/ae/view/AEDownLoadingView;", "()Lcom/tencent/aelight/camera/ae/view/AEDownLoadingView;", "progressView", "itemView", "<init>", "(Landroid/view/View;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: C, reason: from kotlin metadata */
        private final View iconContainer;

        /* renamed from: D, reason: from kotlin metadata */
        private final AEDownLoadingView progressView;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final ImageView iconImage;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final FrameLayout iconParent;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final TextView titleText;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final View subListIndicator;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final View downloadView;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final View maskView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.ruz);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.item_icon)");
            this.iconImage = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.rur);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.icon_parent)");
            FrameLayout frameLayout = (FrameLayout) findViewById2;
            this.iconParent = frameLayout;
            View findViewById3 = itemView.findViewById(R.id.f163762rv4);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.item_name)");
            TextView textView = (TextView) findViewById3;
            this.titleText = textView;
            View findViewById4 = itemView.findViewById(R.id.rv5);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026.item_sub_list_indicator)");
            this.subListIndicator = findViewById4;
            View findViewById5 = itemView.findViewById(R.id.f163747rs4);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.download_view)");
            this.downloadView = findViewById5;
            View findViewById6 = itemView.findViewById(R.id.f163771rx3);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.mask_view)");
            this.maskView = findViewById6;
            View findViewById7 = itemView.findViewById(R.id.ruq);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.icon_container)");
            this.iconContainer = findViewById7;
            View findViewById8 = itemView.findViewById(R.id.rys);
            AEDownLoadingView aEDownLoadingView = (AEDownLoadingView) findViewById8;
            Intrinsics.checkNotNullExpressionValue(aEDownLoadingView, "this");
            l(aEDownLoadingView);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById<AE\u2026gressView(this)\n        }");
            this.progressView = aEDownLoadingView;
            int itemHighlightColor = at.a().getItemHighlightColor();
            int itemNormalColor = at.a().getItemNormalColor();
            frameLayout.setForeground(c(itemHighlightColor));
            textView.setTextColor(d(itemHighlightColor, itemNormalColor));
            findViewById4.setBackgroundDrawable(b(itemHighlightColor, itemNormalColor));
        }

        private final Drawable b(int highlightColor, int normalColor) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            gradientDrawable.setColor(normalColor);
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(highlightColor);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable2);
            stateListDrawable.addState(new int[]{android.R.attr.state_selected}, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable);
            return stateListDrawable;
        }

        private final Drawable c(int highlightColor) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(TypedValue.applyDimension(1, 9.0f, this.itemView.getResources().getDisplayMetrics()));
            gradientDrawable.setStroke((int) TypedValue.applyDimension(1, 2.0f, this.itemView.getResources().getDisplayMetrics()), highlightColor);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable);
            stateListDrawable.addState(new int[]{android.R.attr.state_selected}, gradientDrawable);
            return stateListDrawable;
        }

        private final ColorStateList d(int highlightColor, int normalColor) {
            return new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{normalColor, highlightColor, highlightColor, normalColor});
        }

        private final void l(AEDownLoadingView view) {
            DisplayMetrics displayMetrics = view.getResources().getDisplayMetrics();
            float applyDimension = TypedValue.applyDimension(1, 6.0f, displayMetrics);
            float applyDimension2 = TypedValue.applyDimension(1, 2.0f, displayMetrics);
            float applyDimension3 = TypedValue.applyDimension(1, 16.0f, displayMetrics);
            view.setBgCorner(applyDimension3 / 2.0f);
            view.setMinimumHeight((int) applyDimension3);
            view.setProgressSizeAndMode(applyDimension, applyDimension2, false);
            view.setBgColor(Color.parseColor("#FFFFFF"));
            view.setProgressColor(Color.parseColor("#00CAFC"));
            view.b(false);
        }

        /* renamed from: e, reason: from getter */
        public final View getDownloadView() {
            return this.downloadView;
        }

        /* renamed from: f, reason: from getter */
        public final View getIconContainer() {
            return this.iconContainer;
        }

        /* renamed from: g, reason: from getter */
        public final ImageView getIconImage() {
            return this.iconImage;
        }

        /* renamed from: h, reason: from getter */
        public final FrameLayout getIconParent() {
            return this.iconParent;
        }

        /* renamed from: i, reason: from getter */
        public final AEDownLoadingView getProgressView() {
            return this.progressView;
        }

        /* renamed from: j, reason: from getter */
        public final View getSubListIndicator() {
            return this.subListIndicator;
        }

        /* renamed from: k, reason: from getter */
        public final TextView getTitleText() {
            return this.titleText;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public bm(Context context, int i3, Function3<? super View, ? super bj, ? super Integer, Unit> listener) {
        List<? extends bj> emptyList;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.context = context;
        this.rightBeautyBtnMode = i3;
        this.listener = listener;
        this.defaultDrawableId = R.drawable.ee_;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.data = emptyList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(bj item, bm this$0, a aVar, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (item.getEnable()) {
            Function3<View, bj, Integer, Unit> function3 = this$0.listener;
            View view2 = aVar.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "p0.itemView");
            function3.invoke(view2, item, Integer.valueOf(i3));
            View view3 = aVar.itemView;
            Intrinsics.checkNotNullExpressionValue(view3, "p0.itemView");
            bo.h(view3, item);
        } else {
            String string = this$0.context.getResources().getString(at.a().getUnusableToastTextId());
            Intrinsics.checkNotNullExpressionValue(string, "currentConfig.unusableTo\u2026ing(it)\n                }");
            QQToast.makeText(this$0.context, string, 0).show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final List<bj> q() {
        return this.data;
    }

    /* renamed from: r, reason: from getter */
    public final bj getSelectItem() {
        return this.selectItem;
    }

    public final void setData(List<? extends bj> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.data = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup p06, int p16) {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.doj, p06, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026ect_item_view, p0, false)");
        return new a(inflate);
    }

    public final void v(bj bjVar) {
        this.selectItem = bjVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c4  */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(final a p06, final int p16) {
        boolean z16;
        int i3;
        if (p06 == null) {
            return;
        }
        final bj bjVar = this.data.get(p16);
        String id5 = bjVar.getId();
        bj bjVar2 = this.selectItem;
        boolean areEqual = Intrinsics.areEqual(id5, bjVar2 != null ? bjVar2.getId() : null);
        if (bk.a(bjVar)) {
            bjVar.r(true);
            p06.getIconImage().setImageResource(R.drawable.iza);
        } else if ((bjVar instanceof ar) && ((ar) bjVar).getBeautyConfig().getCom.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME java.lang.String() == BeautyItem.RESET) {
            p06.getIconImage().setImageResource(R.drawable.iyf);
        } else {
            if (bjVar.getIcon().length() > 0) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = ResourcesCompat.getDrawable(this.context.getResources(), this.defaultDrawableId, null);
                Resources resources = this.context.getResources();
                if (bjVar.getIconId() != 0) {
                    i3 = bjVar.getIconId();
                } else {
                    i3 = this.defaultDrawableId;
                }
                obtain.mFailedDrawable = ResourcesCompat.getDrawable(resources, i3, null);
                p06.getIconImage().setImageDrawable(URLDrawable.getDrawable(bjVar.getIcon(), obtain));
            } else if (bjVar.getIconId() != 0) {
                p06.getIconImage().setImageResource(bjVar.getIconId());
            }
            z16 = false;
            int applyDimension = !z16 ? (int) TypedValue.applyDimension(1, 12.0f, this.context.getResources().getDisplayMetrics()) : 0;
            p06.getIconContainer().setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
            p06.getIconImage().setAlpha(1.0f);
            if (bjVar.getEnable()) {
                p06.getIconImage().setAlpha(0.4f);
            } else if (!areEqual) {
                if (bjVar instanceof ar) {
                    p06.getIconImage().setAlpha(1.0f);
                } else if (bk.a(bjVar)) {
                    p06.getIconImage().setAlpha(1.0f);
                } else if (bjVar instanceof bu) {
                    bu buVar = (bu) bjVar;
                    if (buVar.getBeautyConfig().getSubItem() == BeautySecondaryItem.SUB_THIN_FACE_NATURE || buVar.getBeautyConfig().getSubItem() == BeautySecondaryItem.SUB_THIN_FACE_GIRL || buVar.getBeautyConfig().getSubItem() == BeautySecondaryItem.SUB_THIN_FACE_BOY) {
                        p06.getIconImage().setAlpha(1.0f);
                    }
                }
            }
            p06.getIconParent().setEnabled(bjVar.getEnable());
            p06.getTitleText().setText(bjVar.getName());
            p06.getTitleText().setEnabled(bjVar.getEnable());
            p06.getSubListIndicator().setVisibility(!bjVar.getShowAdjust() ? 0 : 4);
            p06.itemView.setSelected(areEqual & bjVar.getEnable());
            p06.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.bl
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    bm.t(bj.this, this, p06, p16, view);
                }
            });
            p06.getDownloadView().setVisibility((bjVar.getUsable() && !bjVar.getCom.tencent.libra.trace.LibraTraceConst.Node.IMAGE_DOWNLOADING java.lang.String() && bjVar.getEnable()) ? 0 : 8);
            p06.getProgressView().setVisibility((bjVar.getUsable() && bjVar.getCom.tencent.libra.trace.LibraTraceConst.Node.IMAGE_DOWNLOADING java.lang.String() && bjVar.getEnable()) ? 0 : 8);
            p06.getProgressView().setProgress(bjVar.getDownloadProgress());
            View view = p06.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "p0.itemView");
            bo.e(view, bjVar, this.rightBeautyBtnMode);
            View view2 = p06.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "p0.itemView");
            bo.i(view2, bjVar);
        }
        z16 = true;
        if (!z16) {
        }
        p06.getIconContainer().setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
        p06.getIconImage().setAlpha(1.0f);
        if (bjVar.getEnable()) {
        }
        p06.getIconParent().setEnabled(bjVar.getEnable());
        p06.getTitleText().setText(bjVar.getName());
        p06.getTitleText().setEnabled(bjVar.getEnable());
        p06.getSubListIndicator().setVisibility(!bjVar.getShowAdjust() ? 0 : 4);
        p06.itemView.setSelected(areEqual & bjVar.getEnable());
        p06.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.bl
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                bm.t(bj.this, this, p06, p16, view3);
            }
        });
        p06.getDownloadView().setVisibility((bjVar.getUsable() && !bjVar.getCom.tencent.libra.trace.LibraTraceConst.Node.IMAGE_DOWNLOADING java.lang.String() && bjVar.getEnable()) ? 0 : 8);
        p06.getProgressView().setVisibility((bjVar.getUsable() && bjVar.getCom.tencent.libra.trace.LibraTraceConst.Node.IMAGE_DOWNLOADING java.lang.String() && bjVar.getEnable()) ? 0 : 8);
        p06.getProgressView().setProgress(bjVar.getDownloadProgress());
        View view3 = p06.itemView;
        Intrinsics.checkNotNullExpressionValue(view3, "p0.itemView");
        bo.e(view3, bjVar, this.rightBeautyBtnMode);
        View view22 = p06.itemView;
        Intrinsics.checkNotNullExpressionValue(view22, "p0.itemView");
        bo.i(view22, bjVar);
    }
}
