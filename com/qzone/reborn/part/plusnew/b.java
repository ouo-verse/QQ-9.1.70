package com.qzone.reborn.part.plusnew;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.util.ak;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000201B\u0007\u00a2\u0006\u0004\b.\u0010/J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J0\u0010\u0011\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u0006H\u0002J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\u001a\u0010\u001a\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\b\u0010\u001b\u001a\u00020\u0006H\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u001f\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dR\u001a\u0010$\u001a\u00020\r8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/qzone/reborn/part/plusnew/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/qzone/reborn/part/plusnew/b$b;", "viewHolder", "Lcom/qzone/reborn/part/plusnew/d;", "items", "", "position", "", "n0", "p0", "Landroid/widget/ImageView;", "imageIconView", "", "iconUrl", "width", "height", "j0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "m0", "Lcom/qzone/reborn/part/plusnew/c;", "data", "", "needReport", "r0", "getItemCount", "l0", "Lcom/qzone/reborn/part/plusnew/b$a;", "listener", "q0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/part/plusnew/c;", "plusInfoData", "D", "Lcom/qzone/reborn/part/plusnew/b$a;", "itemClickListener", "E", "Z", "needExpose", "<init>", "()V", "a", "b", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b extends RecyclerView.Adapter<C0488b> {

    /* renamed from: C, reason: from kotlin metadata */
    private c plusInfoData;

    /* renamed from: D, reason: from kotlin metadata */
    private a itemClickListener;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean needExpose;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QzoneNewPlusAdapter";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/part/plusnew/b$a;", "", "", "position", "", QZoneDTLoginReporter.SCHEMA, "Landroid/view/View;", "view", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface a {
        void a(int position, String schema, View view);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010.\u001a\u00020\u001a\u00a2\u0006\u0004\b/\u0010 R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010)\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001c\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R\"\u0010-\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0010\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/part/plusnew/b$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "setMainIcon", "(Landroid/widget/ImageView;)V", "mainIcon", UserInfo.SEX_FEMALE, "r", "setRedIcon", "redIcon", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "l", "()Landroid/widget/TextView;", "setItemName", "(Landroid/widget/TextView;)V", "itemName", "H", "t", "setRedSubTitle", "redSubTitle", "Landroid/view/View;", "I", "Landroid/view/View;", "o", "()Landroid/view/View;", "setNewRedView", "(Landroid/view/View;)V", "newRedView", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setRedDotView", "redDotView", "K", ReportConstant.COSTREPORT_PREFIX, "setRedInfoGroup", "redInfoGroup", "L", "p", "setRedDotText", "redDotText", "itemView", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.part.plusnew.b$b, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public static final class C0488b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private ImageView mainIcon;

        /* renamed from: F, reason: from kotlin metadata */
        private ImageView redIcon;

        /* renamed from: G, reason: from kotlin metadata */
        private TextView itemName;

        /* renamed from: H, reason: from kotlin metadata */
        private TextView redSubTitle;

        /* renamed from: I, reason: from kotlin metadata */
        private View newRedView;

        /* renamed from: J, reason: from kotlin metadata */
        private ImageView redDotView;

        /* renamed from: K, reason: from kotlin metadata */
        private View redInfoGroup;

        /* renamed from: L, reason: from kotlin metadata */
        private TextView redDotText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0488b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(R.id.mgq);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.main_icon)");
            this.mainIcon = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.mgr);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.main_item_name)");
            this.itemName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.ne6);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.red_icon_img)");
            this.redIcon = (ImageView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.ne8);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.red_item_desc)");
            this.redSubTitle = (TextView) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.mgz);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.message_red)");
            this.newRedView = findViewById5;
            View findViewById6 = itemView.findViewById(R.id.ne5);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.red_dot)");
            this.redDotView = (ImageView) findViewById6;
            View findViewById7 = itemView.findViewById(R.id.ne7);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.red_info)");
            this.redInfoGroup = findViewById7;
            View findViewById8 = itemView.findViewById(R.id.njs);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.tv_red)");
            this.redDotText = (TextView) findViewById8;
        }

        /* renamed from: l, reason: from getter */
        public final TextView getItemName() {
            return this.itemName;
        }

        /* renamed from: m, reason: from getter */
        public final ImageView getMainIcon() {
            return this.mainIcon;
        }

        /* renamed from: o, reason: from getter */
        public final View getNewRedView() {
            return this.newRedView;
        }

        /* renamed from: p, reason: from getter */
        public final TextView getRedDotText() {
            return this.redDotText;
        }

        /* renamed from: q, reason: from getter */
        public final ImageView getRedDotView() {
            return this.redDotView;
        }

        /* renamed from: r, reason: from getter */
        public final ImageView getRedIcon() {
            return this.redIcon;
        }

        /* renamed from: s, reason: from getter */
        public final View getRedInfoGroup() {
            return this.redInfoGroup;
        }

        /* renamed from: t, reason: from getter */
        public final TextView getRedSubTitle() {
            return this.redSubTitle;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(QzoneNewPlusItemData it, b this$0, int i3, View view) {
        String jumpUrl;
        String jumpUrl2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QzoneNewPlusRedItemData redPointInfo = it.getRedPointInfo();
        boolean z16 = false;
        if (redPointInfo != null && (jumpUrl2 = redPointInfo.getJumpUrl()) != null) {
            if (jumpUrl2.length() > 0) {
                z16 = true;
            }
        }
        if (z16) {
            QzoneNewPlusRedItemData redPointInfo2 = it.getRedPointInfo();
            Intrinsics.checkNotNull(redPointInfo2);
            jumpUrl = redPointInfo2.getJumpUrl();
        } else {
            jumpUrl = it.getJumpUrl();
        }
        a aVar = this$0.itemClickListener;
        if (aVar != null) {
            Intrinsics.checkNotNullExpressionValue(view, "view");
            aVar.a(i3, jumpUrl, view);
        }
        QzoneNewPlusRedItemData redPointInfo3 = it.getRedPointInfo();
        if (redPointInfo3 != null) {
            long adId = redPointInfo3.getAdId();
            if (adId != 0) {
                QzoneNewPlusRedItemData redPointInfo4 = it.getRedPointInfo();
                ak.d(adId, redPointInfo4 != null ? redPointInfo4.getTriggerInfo() : null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        c cVar = this.plusInfoData;
        if (cVar == null) {
            return 0;
        }
        if ((cVar != null ? cVar.b() : null) == null) {
            return 0;
        }
        c cVar2 = this.plusInfoData;
        ArrayList<QzoneNewPlusItemData> b16 = cVar2 != null ? cVar2.b() : null;
        Intrinsics.checkNotNull(b16);
        return b16.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C0488b viewHolder, int position) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        c cVar = this.plusInfoData;
        ArrayList<QzoneNewPlusItemData> b16 = cVar != null ? cVar.b() : null;
        if (b16 != null) {
            int size = b16.size();
            if (position < 0 || position >= size) {
                QLog.e(this.TAG, 2, "position out of index");
                return;
            }
        }
        QzoneNewPlusItemData qzoneNewPlusItemData = b16 != null ? b16.get(position) : null;
        n0(viewHolder, qzoneNewPlusItemData, position);
        p0(viewHolder, qzoneNewPlusItemData, position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public C0488b onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.cnd, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   \u2026item_view, parent, false)");
        return new C0488b(inflate);
    }

    public final void q0(a listener) {
        this.itemClickListener = listener;
    }

    public final void r0(c data, boolean needReport) {
        c cVar;
        ArrayList<QzoneNewPlusItemData> b16;
        this.plusInfoData = data;
        notifyDataSetChanged();
        this.needExpose = needReport;
        if (!needReport || (cVar = this.plusInfoData) == null || (b16 = cVar.b()) == null) {
            return;
        }
        Iterator<T> it = b16.iterator();
        while (it.hasNext()) {
            QzoneNewPlusRedItemData redPointInfo = ((QzoneNewPlusItemData) it.next()).getRedPointInfo();
            if (redPointInfo != null && redPointInfo.getAdId() != 0) {
                QLog.i(this.TAG, 2, "reportTianShuExposure " + redPointInfo.getAdId());
                ak.e(redPointInfo.getAdId(), redPointInfo.getTriggerInfo());
            }
        }
    }

    private final void n0(C0488b viewHolder, final QzoneNewPlusItemData items, final int position) {
        if (items != null) {
            viewHolder.getItemName().setText(items.getMainItemTitle());
            if (TextUtils.isEmpty(items.getMainPicUrl())) {
                viewHolder.getMainIcon().setVisibility(8);
            } else {
                viewHolder.getMainIcon().setVisibility(0);
                k0(this, viewHolder.getMainIcon(), items.getMainPicUrl(), 0, 0, 12, null);
            }
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.part.plusnew.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.o0(QzoneNewPlusItemData.this, this, position, view);
                }
            });
        }
    }

    private final void p0(C0488b viewHolder, QzoneNewPlusItemData items, int position) {
        if (items != null) {
            if (items.getRedPointInfo() == null) {
                viewHolder.getRedSubTitle().setVisibility(8);
                viewHolder.getRedInfoGroup().setVisibility(8);
                viewHolder.getRedDotView().setVisibility(8);
            }
            QzoneNewPlusRedItemData redPointInfo = items.getRedPointInfo();
            if (redPointInfo != null) {
                if (!TextUtils.isEmpty(redPointInfo.getSubTitle())) {
                    viewHolder.getRedSubTitle().setVisibility(0);
                    viewHolder.getRedSubTitle().setText(redPointInfo.getSubTitle());
                }
                if (TextUtils.isEmpty(redPointInfo.getRedPointImage()) && TextUtils.isEmpty(redPointInfo.getRedPointTitle())) {
                    viewHolder.getRedInfoGroup().setVisibility(8);
                    viewHolder.getRedDotView().setVisibility(8);
                    return;
                }
                if (!TextUtils.isEmpty(redPointInfo.getRedPointImage())) {
                    viewHolder.getRedInfoGroup().setVisibility(0);
                    viewHolder.getRedIcon().setVisibility(0);
                    viewHolder.getNewRedView().setVisibility(8);
                    k0(this, viewHolder.getRedIcon(), redPointInfo.getRedPointImage(), 0, 0, 12, null);
                }
                if (!TextUtils.isEmpty(redPointInfo.getRedPointTitle())) {
                    viewHolder.getRedInfoGroup().setVisibility(0);
                    viewHolder.getRedIcon().setVisibility(8);
                    viewHolder.getNewRedView().setVisibility(0);
                    viewHolder.getRedDotText().setText(redPointInfo.getRedPointTitle());
                }
                if (redPointInfo.getShowRedPoint()) {
                    viewHolder.getRedDotView().setVisibility(0);
                    viewHolder.getRedInfoGroup().setVisibility(0);
                }
            }
        }
    }

    static /* synthetic */ void k0(b bVar, ImageView imageView, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i3 = QzoneNewPlusMenuContainerPart.H.b();
        }
        if ((i17 & 8) != 0) {
            i16 = QzoneNewPlusMenuContainerPart.H.a();
        }
        bVar.j0(imageView, str, i3, i16);
    }

    private final void j0(ImageView imageIconView, String iconUrl, int width, int height) {
        if (iconUrl == null || imageIconView == null) {
            return;
        }
        com.qzone.reborn.util.h.j(imageIconView, iconUrl, width, height, imageIconView.getContext().getDrawable(R.drawable.f163463));
    }

    public static /* synthetic */ void s0(b bVar, c cVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        bVar.r0(cVar, z16);
    }
}
