package com.tencent.sqshow.zootopia.c2c.photograph;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lo2.ah;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003*+,B\u0017\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\u0004\b'\u0010(J \u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\u0012\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010!\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010#\u00a8\u0006-"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/photograph/c;", "Lj84/c;", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "Lcom/tencent/sqshow/zootopia/c2c/photograph/c$c;", "data", "holder", "", "position", "", "y", "Landroid/view/View;", "view", "", "elementId", "w", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getCustomItemViewType", "i", "I", "getType", "()I", "type", "Lcom/tencent/sqshow/zootopia/c2c/photograph/c$b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/c2c/photograph/c$b;", "getClickListener", "()Lcom/tencent/sqshow/zootopia/c2c/photograph/c$b;", BdhLogUtil.LogTag.Tag_Conn, "(Lcom/tencent/sqshow/zootopia/c2c/photograph/c$b;)V", "clickListener", "Lid3/d;", "Lid3/d;", "reportHelper", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;I)V", "D", "a", "b", "c", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c extends j84.c<ZPlanTemplate, C9805c> {

    /* renamed from: C, reason: from kotlin metadata */
    private final id3.d reportHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private b clickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/photograph/c$b;", "", "Landroid/view/View;", "view", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "data", "", "position", "", ah.f415119g0, "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void ah(View view, ZPlanTemplate data, int position);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/c2c/photograph/c$c;", "Lj84/b;", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "Landroid/view/View;", "view", "", "type", "<init>", "(Landroid/view/View;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.c2c.photograph.c$c, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9805c extends j84.b<ZPlanTemplate> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C9805c(View view, int i3) {
            super(view, i3);
            Intrinsics.checkNotNullParameter(view, "view");
            getButton().setVisibility(8);
            getTypeText().setVisibility(8);
            getIcon().setVisibility(0);
            getShimmerBottom().setVisibility(0);
            getTitleText().setVisibility(0);
            getMaskView().setMaskBackground(GameCenterVideoViewController.GRAY_MASK, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, int i3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.type = i3;
        this.reportHelper = new id3.d(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map x(Map params, String str) {
        Intrinsics.checkNotNullParameter(params, "$params");
        return params;
    }

    private final void y(final ZPlanTemplate data, final C9805c holder, final int position) {
        if (TextUtils.isEmpty(data.getCoverUrl())) {
            holder.getImage().setDefaultBackground();
        } else {
            holder.getImage().setApngBackgroundUrl(data.getCoverUrl());
        }
        holder.getMaskView().setVisibility(8);
        holder.getDescribe().setVisibility(8);
        holder.getIcon().setVisibility(data.isVideo() ? 0 : 8);
        holder.getTitleText().setText(data.getDisplayName());
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.c2c.photograph.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.z(c.this, holder, data, position, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(c this$0, C9805c holder, ZPlanTemplate data, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(data, "$data");
        id3.d dVar = this$0.reportHelper;
        RelativeLayout mainContainer = holder.getMainContainer();
        Intrinsics.checkNotNullExpressionValue(mainContainer, "holder.mainContainer");
        dVar.c("clck", mainContainer, new LinkedHashMap());
        b bVar = this$0.clickListener;
        if (bVar != null) {
            View view2 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            bVar.ah(view2, data, i3);
        }
    }

    @Override // j84.c
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public C9805c onCreateCustomViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.d7b, parent, false);
        id3.d dVar = this.reportHelper;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        dVar.j(context, itemView, "pg_zplan_xiaowo_samestyle_popup", new LinkedHashMap());
        return new C9805c(itemView, this.type);
    }

    public final void C(b bVar) {
        this.clickListener = bVar;
    }

    @Override // j84.c
    public int getCustomItemViewType(int position) {
        return 0;
    }

    private final void w(View view, String elementId, ZPlanTemplate data) {
        final Map mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_map_id", Integer.valueOf(data.getId())));
        id3.d.i(this.reportHelper, view, elementId, mutableMapOf, false, false, null, false, false, 224, null);
        VideoReport.setEventDynamicParams(view, new IDynamicParams() { // from class: com.tencent.sqshow.zootopia.c2c.photograph.a
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map x16;
                x16 = c.x(mutableMapOf, str);
                return x16;
            }
        });
    }

    @Override // j84.c
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindCustomViewHolder(C9805c holder, int position) {
        ZPlanTemplate item;
        if (holder == null || (item = getItem(position)) == null) {
            return;
        }
        RelativeLayout mainContainer = holder.getMainContainer();
        Intrinsics.checkNotNullExpressionValue(mainContainer, "holder.mainContainer");
        w(mainContainer, "em_zplan_samstyle_popup_module", item);
        if (item.getId() == -1) {
            holder.getMainContainer().setVisibility(8);
            holder.getShimmer().setVisibility(0);
            return;
        }
        id3.d dVar = this.reportHelper;
        RelativeLayout mainContainer2 = holder.getMainContainer();
        Intrinsics.checkNotNullExpressionValue(mainContainer2, "holder.mainContainer");
        dVar.c("imp", mainContainer2, new LinkedHashMap());
        holder.getMainContainer().setVisibility(0);
        holder.getShimmer().setVisibility(8);
        y(item, holder, position);
    }
}
