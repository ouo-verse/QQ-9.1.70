package com.tencent.mobileqq.zplan.aigc.view;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.aigc.data.AIGCModelRenderTask;
import com.tencent.mobileqq.zplan.aigc.data.TASK_STATUS;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
import com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.aigc.view.SuitPagView;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 (2\u00020\u0001:\u0004\u0007\u0014\n\u0015B\u0019\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u00a2\u0006\u0004\b&\u0010'J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0006\u0010\n\u001a\u00020\bJ>\u0010\u0012\u001a\u00020\b2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0004j\b\u0012\u0004\u0012\u00020\u0013`\u0006R2\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager;", "Landroidx/viewpager/widget/ViewPager;", "", "pageIndex", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "Lkotlin/collections/ArrayList;", "a", "", NodeProps.ON_ATTACHED_TO_WINDOW, "c", "dataList", "Landroid/graphics/Bitmap;", "modelBitmap", "", "needAnimation", "Lzd3/a;", "reporter", "setData", "Landroid/view/View;", "b", "d", "Ljava/util/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "e", "Lzd3/a;", "getDtReporter", "()Lzd3/a;", "setDtReporter", "(Lzd3/a;)V", "dtReporter", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AIGCGridViewPager extends ViewPager {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArrayList<AIGCModelRenderTask> dataList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private zd3.a dtReporter;

    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 A2\u00020\u0001:\u0002\f\u0010B9\u0012\u0006\u0010(\u001a\u00020$\u0012\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c\u0012\u0006\u0010\"\u001a\u00020!\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J$\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\u001e\u0010\u001e\u001a\u00020\u00042\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001cJ0\u0010#\u001a\u00020\u00042\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!R\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b&\u0010'R'\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010+R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$b;", "Landroid/widget/BaseAdapter;", "Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$b$b;", "viewHolder", "", "e", "Landroid/view/View;", "view", "", "position", "f", "d", "a", "Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;", "taskStatus", "c", "b", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "", "getItem", "", "getItemId", "getCount", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "Lkotlin/collections/ArrayList;", "newData", "setData", "Landroid/graphics/Bitmap;", "modelBitmap", "", "needAnimation", h.F, "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "dataList", "Z", "getNeedAnimation", "()Z", "setNeedAnimation", "(Z)V", "Landroid/graphics/Bitmap;", "getModelBitmap", "()Landroid/graphics/Bitmap;", "setModelBitmap", "(Landroid/graphics/Bitmap;)V", "Lzd3/a;", "i", "Lzd3/a;", "getDtReporter", "()Lzd3/a;", "g", "(Lzd3/a;)V", "dtReporter", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;ZLandroid/graphics/Bitmap;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Context context;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final ArrayList<AIGCModelRenderTask> dataList;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean needAnimation;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private Bitmap modelBitmap;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private zd3.a dtReporter;

        public b(Context context, ArrayList<AIGCModelRenderTask> dataList, boolean z16, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            this.context = context;
            this.dataList = dataList;
            this.needAnimation = z16;
            this.modelBitmap = bitmap;
        }

        private final void a(C9138b viewHolder) {
            viewHolder.getPagScanView().setVisibility(8);
            viewHolder.getErroForbiddenImgView().setVisibility(0);
            viewHolder.getModelImgView().setAlpha(0.0f);
            viewHolder.getBackground().setAlpha(1.0f);
        }

        private final void b(C9138b viewHolder, TASK_STATUS taskStatus) {
            viewHolder.l();
            viewHolder.getPagScanView().setVisibility(8);
            viewHolder.getImageView().setVisibility(0);
            if (viewHolder.getLastStatus() == TASK_STATUS.TASK_STATUS_NONE && taskStatus == TASK_STATUS.TASK_STATUS_SCREEN_SHOT_SUCCESS) {
                xd3.a aVar = xd3.a.f447833a;
                ImageView background = viewHolder.getBackground();
                Intrinsics.checkNotNullExpressionValue(background, "viewHolder.background");
                aVar.b(new View[]{background}, 200L, 0.2f, 1.0f, null);
            }
        }

        private final void c(C9138b viewHolder, TASK_STATUS taskStatus) {
            viewHolder.l();
            viewHolder.getBackground().setAlpha(0.2f);
            viewHolder.getModelImgView().setAlpha(0.0f);
            viewHolder.getPagScanView().setVisibility(0);
            if (viewHolder.getLastStatus() != null) {
                TASK_STATUS lastStatus = viewHolder.getLastStatus();
                TASK_STATUS task_status = TASK_STATUS.TASK_STATUS_NONE;
                if (lastStatus == task_status || taskStatus != task_status) {
                    return;
                }
            }
            SuitPagView pagScanView = viewHolder.getPagScanView();
            Intrinsics.checkNotNullExpressionValue(pagScanView, "viewHolder.pagScanView");
            SuitPagView.v(pagScanView, "https://downv6.qq.com/shadow_qqcamera/zshow/scan_loading_bmp.pag", false, 2, null);
        }

        private final void d(C9138b viewHolder) {
            viewHolder.getPagScanView().setVisibility(8);
            viewHolder.getReloadImgView().setVisibility(0);
            viewHolder.getReloadHint().setVisibility(0);
            viewHolder.getModelImgView().setAlpha(0.0f);
            viewHolder.getBackground().setAlpha(0.3f);
        }

        private final void e(C9138b viewHolder) {
            viewHolder.getImageView().setAlpha(0.0f);
            Animator loadAnimator = AnimatorInflater.loadAnimator(this.context, R.animator.f155123c);
            Intrinsics.checkNotNull(loadAnimator, "null cannot be cast to non-null type android.animation.AnimatorSet");
            AnimatorSet animatorSet = (AnimatorSet) loadAnimator;
            animatorSet.setTarget(viewHolder.getImageView());
            animatorSet.start();
        }

        public final void g(zd3.a aVar) {
            this.dtReporter = aVar;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.dataList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int position) {
            AIGCModelRenderTask aIGCModelRenderTask = this.dataList.get(position);
            Intrinsics.checkNotNullExpressionValue(aIGCModelRenderTask, "dataList[position]");
            return aIGCModelRenderTask;
        }

        @Override // android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x0067, code lost:
        
            if (kotlin.jvm.internal.Intrinsics.areEqual(r4.getContentBitMap(), r0.getResultImage()) != false) goto L9;
         */
        @Override // android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getView(int position, View convertView, ViewGroup parent) {
            C9138b c9138b;
            View view;
            AIGCModelRenderTask aIGCModelRenderTask = this.dataList.get(position);
            Intrinsics.checkNotNullExpressionValue(aIGCModelRenderTask, "dataList[position]");
            AIGCModelRenderTask aIGCModelRenderTask2 = aIGCModelRenderTask;
            boolean z16 = false;
            if (convertView == null) {
                View inflate = LayoutInflater.from(this.context).inflate(R.layout.dfz, parent, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026show_item, parent, false)");
                c9138b = new C9138b(inflate);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                obtain.mLoadingDrawable = drawable;
                obtain.mFailedDrawable = drawable;
                c9138b.getBackground().setBackgroundDrawable(URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_item_created_bg2.png", obtain));
                c9138b.q(aIGCModelRenderTask2.getResultImage());
                inflate.setTag(c9138b);
                view = inflate;
            } else {
                Object tag = convertView.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager.CustomGridAdapter.MyViewHolder");
                c9138b = (C9138b) tag;
                view = convertView;
            }
            z16 = true;
            C9138b c9138b2 = c9138b;
            if (aIGCModelRenderTask2.getResultImage() != null && aIGCModelRenderTask2.getStatus() == TASK_STATUS.TASK_STATUS_SCREEN_SHOT_SUCCESS) {
                b(c9138b2, this.dataList.get(position).getStatus());
                c9138b2.getImageView().setImageBitmap(aIGCModelRenderTask2.getResultImage());
                c9138b2.getModelImgView().setImageBitmap(this.modelBitmap);
                if (z16) {
                    e(c9138b2);
                }
            } else {
                c9138b2.getImageView().setVisibility(8);
                Bitmap bitmap = this.modelBitmap;
                if (bitmap != null) {
                    Intrinsics.checkNotNull(bitmap);
                    c9138b2.t(bitmap);
                }
                if (aIGCModelRenderTask2.getStatus() != TASK_STATUS.TASK_STATUS_ERROR_IMG_NETWORK && aIGCModelRenderTask2.getStatus() != TASK_STATUS.TASK_STATUS_ERROR_ENGINE) {
                    if (aIGCModelRenderTask2.getStatus() == TASK_STATUS.TASK_STATUS_ERROR_PROMPT_FORBIDDEN) {
                        a(c9138b2);
                    } else if (aIGCModelRenderTask2.getStatus() == TASK_STATUS.TASK_STATUS_NONE) {
                        c(c9138b2, this.dataList.get(position).getStatus());
                    }
                } else {
                    d(c9138b2);
                }
            }
            if (z16 && !c9138b2.getIsAnimated()) {
                c9138b2.p(true);
                f(view, position);
            }
            TASK_STATUS lastStatus = c9138b2.getLastStatus();
            TASK_STATUS task_status = TASK_STATUS.TASK_STATUS_SCREEN_SHOT_SUCCESS;
            if (lastStatus != task_status && this.dataList.get(position).getStatus() == task_status) {
                AIGCModelRenderTask aIGCModelRenderTask3 = this.dataList.get(position);
                Intrinsics.checkNotNullExpressionValue(aIGCModelRenderTask3, "dataList[position]");
                C9138b.o(c9138b2, position, view, aIGCModelRenderTask3, this.dtReporter, false, 16, null);
            }
            c9138b2.q(this.dataList.get(position).getResultImage());
            c9138b2.r(this.dataList.get(position).getStatus());
            c9138b2.s(this.dataList.get(position).getId());
            return view;
        }

        public final void h(ArrayList<AIGCModelRenderTask> newData, Bitmap modelBitmap, boolean needAnimation) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            setData(newData);
            if (modelBitmap != null) {
                this.modelBitmap = modelBitmap;
            }
            this.needAnimation = needAnimation;
            notifyDataSetChanged();
        }

        public final void setData(ArrayList<AIGCModelRenderTask> newData) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            this.dataList.clear();
            this.dataList.addAll(newData);
        }

        private final void f(View view, int position) {
            view.setAlpha(0.0f);
            Animator loadAnimator = AnimatorInflater.loadAnimator(this.context, R.animator.f155123c);
            Intrinsics.checkNotNull(loadAnimator, "null cannot be cast to non-null type android.animation.AnimatorSet");
            AnimatorSet animatorSet = (AnimatorSet) loadAnimator;
            animatorSet.setStartDelay((position / 2) * 150);
            animatorSet.setTarget(view);
            animatorSet.start();
        }

        @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\bK\u0010LJ2\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fR\u001f\u0010\u0018\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u001e\u001a\n \u0013*\u0004\u0018\u00010\u00190\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010!\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017R\u001f\u0010#\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\"\u0010\u0017R\u001f\u0010%\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R\u001f\u0010'\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017R\u001f\u0010,\u001a\n \u0013*\u0004\u0018\u00010(0(8\u0006\u00a2\u0006\f\n\u0004\b \u0010)\u001a\u0004\b*\u0010+R\"\u00102\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00108\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b\u001a\u00105\"\u0004\b6\u00107R$\u0010>\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010:\u001a\u0004\b$\u0010;\"\u0004\b<\u0010=R0\u0010E\u001a\u0010\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u0001\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010A\u001a\u0004\b3\u0010B\"\u0004\bC\u0010DR\"\u0010J\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010F\u001a\u0004\b&\u0010G\"\u0004\bH\u0010I\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$b$b;", "", "", com.tencent.luggage.wxa.c8.c.G, "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "renderTask", "Lzd3/a;", "reporter", "", "isClick", "", DomainData.DOMAIN_NAME, "l", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "t", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "a", "Landroid/widget/ImageView;", "d", "()Landroid/widget/ImageView;", "imageView", "Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "b", "Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", h.F, "()Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "pagScanView", "c", "g", "modelImgView", "k", "reloadImgView", "e", "erroForbiddenImgView", "f", "background", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "j", "()Landroid/widget/TextView;", "reloadHint", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "p", "(Z)V", OpenHippyInfo.EXTRA_KEY_IS_ANIMATED, "i", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Landroid/graphics/Bitmap;)V", "contentBitMap", "Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;", "Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;", "()Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;", "r", "(Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;)V", "lastStatus", "", "", "Ljava/util/Map;", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "params", "I", "()I", ReportConstant.COSTREPORT_PREFIX, "(I)V", "modelID", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager$b$b, reason: collision with other inner class name */
        /* loaded from: classes35.dex */
        public static final class C9138b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final ImageView imageView;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            private final SuitPagView pagScanView;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            private final ImageView modelImgView;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private final ImageView reloadImgView;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            private final ImageView erroForbiddenImgView;

            /* renamed from: f, reason: collision with root package name and from kotlin metadata */
            private final ImageView background;

            /* renamed from: g, reason: collision with root package name and from kotlin metadata */
            private final TextView reloadHint;

            /* renamed from: h, reason: collision with root package name and from kotlin metadata */
            private boolean isAnimated;

            /* renamed from: i, reason: collision with root package name and from kotlin metadata */
            private Bitmap contentBitMap;

            /* renamed from: j, reason: collision with root package name and from kotlin metadata */
            private TASK_STATUS lastStatus;

            /* renamed from: k, reason: collision with root package name and from kotlin metadata */
            private Map<String, Object> params;

            /* renamed from: l, reason: collision with root package name and from kotlin metadata */
            private int modelID;

            public C9138b(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.imageView = (ImageView) view.findViewById(R.id.q1b);
                this.pagScanView = (SuitPagView) view.findViewById(R.id.q6y);
                this.modelImgView = (ImageView) view.findViewById(R.id.q9h);
                this.reloadImgView = (ImageView) view.findViewById(R.id.qh5);
                this.erroForbiddenImgView = (ImageView) view.findViewById(R.id.pvk);
                this.background = (ImageView) view.findViewById(R.id.pd5);
                this.reloadHint = (TextView) view.findViewById(R.id.qh6);
            }

            /* renamed from: a, reason: from getter */
            public final ImageView getBackground() {
                return this.background;
            }

            /* renamed from: b, reason: from getter */
            public final Bitmap getContentBitMap() {
                return this.contentBitMap;
            }

            /* renamed from: c, reason: from getter */
            public final ImageView getErroForbiddenImgView() {
                return this.erroForbiddenImgView;
            }

            /* renamed from: d, reason: from getter */
            public final ImageView getImageView() {
                return this.imageView;
            }

            /* renamed from: e, reason: from getter */
            public final TASK_STATUS getLastStatus() {
                return this.lastStatus;
            }

            /* renamed from: f, reason: from getter */
            public final int getModelID() {
                return this.modelID;
            }

            /* renamed from: g, reason: from getter */
            public final ImageView getModelImgView() {
                return this.modelImgView;
            }

            /* renamed from: h, reason: from getter */
            public final SuitPagView getPagScanView() {
                return this.pagScanView;
            }

            public final Map<String, Object> i() {
                return this.params;
            }

            /* renamed from: j, reason: from getter */
            public final TextView getReloadHint() {
                return this.reloadHint;
            }

            /* renamed from: k, reason: from getter */
            public final ImageView getReloadImgView() {
                return this.reloadImgView;
            }

            public final void l() {
                this.reloadImgView.setVisibility(8);
                this.reloadHint.setVisibility(8);
                this.erroForbiddenImgView.setVisibility(8);
            }

            /* renamed from: m, reason: from getter */
            public final boolean getIsAnimated() {
                return this.isAnimated;
            }

            public final void n(int pos, View view, AIGCModelRenderTask renderTask, zd3.a reporter, boolean isClick) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(renderTask, "renderTask");
                Map<String, Object> x16 = AIGCHelper.f330685a.x(renderTask);
                x16.put("zplan_clothes_pos", Integer.valueOf(pos));
                this.params = x16;
            }

            public final void p(boolean z16) {
                this.isAnimated = z16;
            }

            public final void q(Bitmap bitmap) {
                this.contentBitMap = bitmap;
            }

            public final void r(TASK_STATUS task_status) {
                this.lastStatus = task_status;
            }

            public final void s(int i3) {
                this.modelID = i3;
            }

            public final void t(Bitmap bitmap) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                this.modelImgView.setVisibility(0);
                this.modelImgView.setAlpha(0.7f);
                this.modelImgView.setImageBitmap(bitmap);
            }

            public static /* synthetic */ void o(C9138b c9138b, int i3, View view, AIGCModelRenderTask aIGCModelRenderTask, zd3.a aVar, boolean z16, int i16, Object obj) {
                if ((i16 & 16) != 0) {
                    z16 = false;
                }
                c9138b.n(i3, view, aIGCModelRenderTask, aVar, z16);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$c;", "", "", "index", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "renderTask", "clickedViewX", "clickedViewY", "width", "height", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface c {
        void a(int index, AIGCModelRenderTask renderTask, int clickedViewX, int clickedViewY, int width, int height);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIGCGridViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.dataList = new ArrayList<>();
    }

    public final ArrayList<View> b() {
        ArrayList<View> arrayList = new ArrayList<>();
        if (getAdapter() != null) {
            PagerAdapter adapter = getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager.MyPagerAdapter");
            int i3 = 0;
            for (Object obj : ((d) adapter).g()) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                GridView gridView = (GridView) obj;
                int childCount = gridView.getChildCount();
                for (int i17 = 0; i17 < childCount; i17++) {
                    arrayList.add(gridView.getChildAt(i17));
                }
                i3 = i16;
            }
        }
        return arrayList;
    }

    public final void c() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setAdapter(new d(this, context, 4, true, null));
    }

    public final ArrayList<AIGCModelRenderTask> getDataList() {
        return this.dataList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setAdapter(new d(this, context, 4, true, null));
    }

    public final void setData(ArrayList<AIGCModelRenderTask> dataList, Bitmap modelBitmap, boolean needAnimation, zd3.a reporter) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        this.dataList.clear();
        this.dataList.addAll(dataList);
        if (getAdapter() != null && modelBitmap != null) {
            PagerAdapter adapter = getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager.MyPagerAdapter");
            ((d) adapter).k(modelBitmap);
        }
        PagerAdapter adapter2 = getAdapter();
        if (adapter2 != null) {
            adapter2.notifyDataSetChanged();
        }
        if (getAdapter() != null) {
            PagerAdapter adapter3 = getAdapter();
            Intrinsics.checkNotNull(adapter3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager.MyPagerAdapter");
            int i3 = 0;
            for (Object obj : ((d) adapter3).g()) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                GridView gridView = (GridView) obj;
                ListAdapter adapter4 = gridView.getAdapter();
                Intrinsics.checkNotNull(adapter4, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager.CustomGridAdapter");
                ((b) adapter4).h(a(i3), modelBitmap, needAnimation);
                if (reporter != null) {
                    ListAdapter adapter5 = gridView.getAdapter();
                    Intrinsics.checkNotNull(adapter5, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager.CustomGridAdapter");
                    ((b) adapter5).g(reporter);
                }
                i3 = i16;
            }
        }
    }

    public final void setDataList(ArrayList<AIGCModelRenderTask> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.dataList = arrayList;
    }

    public final void setDtReporter(zd3.a aVar) {
        this.dtReporter = aVar;
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0013\u0012\b\u0010)\u001a\u0004\u0018\u00010\"\u00a2\u0006\u0004\b9\u0010:J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0017\u0010!\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u00100\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b#\u0010-\"\u0004\b.\u0010/R2\u00108\u001a\u0012\u0012\u0004\u0012\u0002010\u0004j\b\u0012\u0004\u0012\u000201`\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$d;", "Landroidx/viewpager/widget/PagerAdapter;", "", "pageIndex", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "Lkotlin/collections/ArrayList;", "f", "getCount", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "position", "", "instantiateItem", "object", "", "destroyItem", "Landroid/view/View;", "view", "", "isViewFromObject", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "e", "I", "itemsPerPage", "Z", "getNeedAnimation", "()Z", "needAnimation", "Landroid/graphics/Bitmap;", h.F, "Landroid/graphics/Bitmap;", "getModelBitmap", "()Landroid/graphics/Bitmap;", "k", "(Landroid/graphics/Bitmap;)V", "modelBitmap", "Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$c;", "i", "Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$c;", "()Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$c;", "j", "(Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$c;)V", "itemClickCallback", "Landroid/widget/GridView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "g", "()Ljava/util/ArrayList;", "setGrids", "(Ljava/util/ArrayList;)V", "grids", "<init>", "(Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager;Landroid/content/Context;IZLandroid/graphics/Bitmap;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public final class d extends PagerAdapter {
        final /* synthetic */ AIGCGridViewPager C;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Context context;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int itemsPerPage;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean needAnimation;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private Bitmap modelBitmap;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private c itemClickCallback;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private ArrayList<GridView> grids;

        public d(AIGCGridViewPager aIGCGridViewPager, Context context, int i3, boolean z16, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.C = aIGCGridViewPager;
            this.context = context;
            this.itemsPerPage = i3;
            this.needAnimation = z16;
            this.modelBitmap = bitmap;
            this.grids = new ArrayList<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean i(View view, MotionEvent motionEvent) {
            return motionEvent.getAction() == 2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object object) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(object, "object");
            this.grids.clear();
            container.removeView((View) object);
        }

        public final ArrayList<GridView> g() {
            return this.grids;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return (int) Math.ceil(this.C.getDataList().size() / 4.0d);
        }

        /* renamed from: h, reason: from getter */
        public final c getItemClickCallback() {
            return this.itemClickCallback;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int position) {
            Intrinsics.checkNotNullParameter(container, "container");
            GridView gridView = new GridView(this.context);
            gridView.setNumColumns(2);
            gridView.setAdapter((ListAdapter) new b(this.context, f(position), this.needAnimation, this.modelBitmap));
            gridView.setOnTouchListener(new View.OnTouchListener() { // from class: ae3.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean i3;
                    i3 = AIGCGridViewPager.d.i(view, motionEvent);
                    return i3;
                }
            });
            gridView.setOnItemClickListener(new a(position, this, this.C));
            gridView.setVerticalScrollBarEnabled(false);
            gridView.setSelector(R.color.f81668);
            container.addView(gridView);
            gridView.getAdapter();
            this.grids.add(gridView);
            return gridView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(object, "object");
            return Intrinsics.areEqual(view, object);
        }

        public final void j(c cVar) {
            this.itemClickCallback = cVar;
        }

        public final void k(Bitmap bitmap) {
            this.modelBitmap = bitmap;
        }

        @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$d$a", "Landroid/widget/AdapterView$OnItemClickListener;", "Landroid/widget/AdapterView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "view", "", "index", "", "id", "", "onItemClick", "d", "J", "lastTimeClicked", "e", "I", "defaultInterval", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements AdapterView.OnItemClickListener {

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private long lastTimeClicked;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            private final int defaultInterval = 1000;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f330726f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ d f330727h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ AIGCGridViewPager f330728i;

            a(int i3, d dVar, AIGCGridViewPager aIGCGridViewPager) {
                this.f330726f = i3;
                this.f330727h = dVar;
                this.f330728i = aIGCGridViewPager;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int index, long id5) {
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(view, "view");
                if (SystemClock.elapsedRealtime() - this.lastTimeClicked < this.defaultInterval) {
                    return;
                }
                this.lastTimeClicked = SystemClock.elapsedRealtime();
                int i3 = (this.f330726f * this.f330727h.itemsPerPage) + index;
                int[] iArr = new int[2];
                final ImageView imageView = (ImageView) ((ViewGroup) view).findViewById(R.id.q1b);
                if (imageView != null) {
                    imageView.getLocationOnScreen(iArr);
                }
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                if (imageView != null) {
                    imageView.postDelayed(new Runnable() { // from class: ae3.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            AIGCGridViewPager.d.a.b(imageView);
                        }
                    }, 1000L);
                }
                c itemClickCallback = this.f330727h.getItemClickCallback();
                if (itemClickCallback != null) {
                    AIGCModelRenderTask aIGCModelRenderTask = this.f330728i.getDataList().get(i3);
                    Intrinsics.checkNotNullExpressionValue(aIGCModelRenderTask, "dataList[selectedIndex]");
                    itemClickCallback.a(i3, aIGCModelRenderTask, iArr[0], iArr[1], imageView != null ? imageView.getWidth() : 0, imageView != null ? imageView.getHeight() : 0);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(ImageView imageView) {
                if (imageView == null) {
                    return;
                }
                imageView.setVisibility(0);
            }
        }

        private final ArrayList<AIGCModelRenderTask> f(int pageIndex) {
            int i3 = pageIndex * 4;
            return new ArrayList<>(this.C.getDataList().subList(i3, Math.min(i3 + 4, this.C.getDataList().size())));
        }
    }

    private final ArrayList<AIGCModelRenderTask> a(int pageIndex) {
        int i3 = pageIndex * 4;
        return new ArrayList<>(this.dataList.subList(i3, Math.min(i3 + 4, this.dataList.size())));
    }

    public static /* synthetic */ void setData$default(AIGCGridViewPager aIGCGridViewPager, ArrayList arrayList, Bitmap bitmap, boolean z16, zd3.a aVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            aVar = null;
        }
        aIGCGridViewPager.setData(arrayList, bitmap, z16, aVar);
    }
}
