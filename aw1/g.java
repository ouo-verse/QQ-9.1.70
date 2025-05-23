package aw1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0014\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0019j\b\u0012\u0004\u0012\u00020\u000b`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Law1/g;", "Landroid/widget/BaseAdapter;", "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", "c", "", "fromProfilePage", "", "g", "", "Law1/m;", "medalList", "setData", "", "getCount", "position", "d", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "e", "Z", "isFromProfilePage", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class g extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<MedalItem> medalList = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isFromProfilePage;

    private final FrameLayout c(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewUtils.dip2px(23.0f), ViewUtils.dip2px(23.0f));
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        frameLayout.addView(imageView, layoutParams);
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final MedalItem medalItem, final ViewGroup viewGroup, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(medalItem, "$medalItem");
        final int f16 = QQGuildUIUtil.f(28.0f);
        v.f(medalItem.getMedalUrl(), f16, f16, new GuildLevelRoleView.a() { // from class: aw1.f
            @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
            public final void a(Bitmap bitmap) {
                g.f(viewGroup, medalItem, f16, bitmap);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ViewGroup viewGroup, MedalItem medalItem, int i3, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(medalItem, "$medalItem");
        QQToast makeText = QQToast.makeText(viewGroup.getContext(), medalItem.getMedalDesc(), 0);
        if (bitmap != null) {
            makeText.setToastIconWithSize(new BitmapDrawable(viewGroup.getContext().getResources(), bitmap), i3, i3);
        }
        makeText.show(QQGuildUIUtil.t());
    }

    @Override // android.widget.Adapter
    @Nullable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public MedalItem getItem(int position) {
        boolean z16 = false;
        if (position >= 0 && position < getCount()) {
            z16 = true;
        }
        if (z16) {
            return this.medalList.get(position);
        }
        return null;
    }

    public final void g(boolean fromProfilePage) {
        this.isFromProfilePage = fromProfilePage;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.medalList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @Nullable
    public View getView(int position, @Nullable View convertView, @Nullable final ViewGroup parent) {
        Context context;
        View view;
        Map mapOf;
        View view2 = null;
        if (parent != null) {
            context = parent.getContext();
        } else {
            context = null;
        }
        if (context == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("getView but context is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildMedalAdapter", 1, (String) it.next(), null);
            }
        } else {
            if (convertView == null) {
                Context context2 = parent.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "parent.context");
                view = c(context2);
            } else {
                view = convertView;
            }
            final MedalItem item = getItem(position);
            if (item != null) {
                String medalUrl = item.getMedalUrl();
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
                View childAt = ((FrameLayout) view).getChildAt(0);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
                u.r(medalUrl, (ImageView) childAt, false, null);
                if (!this.isFromProfilePage) {
                    view.setOnClickListener(new View.OnClickListener() { // from class: aw1.e
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            g.e(MedalItem.this, parent, view3);
                        }
                    });
                    VideoReport.setElementId(view, "em_sgrp_personal_medal");
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_personal_medal_type", item.getMedalDesc()));
                    VideoReport.setElementParams(view, mapOf);
                    VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
                    VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
                    VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
                }
                view2 = view;
            }
        }
        EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
        return view2;
    }

    public final void setData(@NotNull List<MedalItem> medalList) {
        Intrinsics.checkNotNullParameter(medalList, "medalList");
        this.medalList.clear();
        this.medalList.addAll(medalList);
        notifyDataSetChanged();
    }
}
