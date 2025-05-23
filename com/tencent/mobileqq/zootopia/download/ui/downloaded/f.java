package com.tencent.mobileqq.zootopia.download.ui.downloaded;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.falco.utils.UIUtil;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.download.ui.downloaded.f;
import com.tencent.mobileqq.zootopia.space.MapOccupiedSpaceManager;
import com.tencent.mobileqq.zootopia.space.MapSpaceInfo;
import com.tencent.mobileqq.zootopia.space.j;
import com.tencent.mobileqq.zootopia.utils.k;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mobileqq.zplan.cloudmod.api.CloudModClickListener;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.mapstatus.MapStatus;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000289B\u0017\u0012\u0006\u0010,\u001a\u00020'\u0012\u0006\u00102\u001a\u00020-\u00a2\u0006\u0004\b5\u00106J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u001b\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019H\u0016J\u0018\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001e\u001a\u00020\u001dJ\u0018\u0010$\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\"H\u0016R\u0017\u0010,\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u00102\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/downloaded/f;", "Lcom/tencent/mobileqq/zootopia/download/ui/a;", "Lcom/tencent/mobileqq/zootopia/download/ui/downloaded/f$b;", "holder", "Lcom/tencent/mobileqq/zootopia/download/ui/d;", "data", "", "C0", "Landroid/widget/TextView;", "txv", "", "occupiedSize", "showOccupySpaceSize", "E0", "B0", "F0", "A0", "", "", "", "I0", "H0", "Lcom/tencent/mobileqq/zootopia/download/ui/downloaded/a;", "itemClickListener", "N0", "", "dataList", "updateList", "mapId", "", "fromDelay", "x0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "M0", "position", "J0", "Landroidx/lifecycle/LifecycleOwner;", "E", "Landroidx/lifecycle/LifecycleOwner;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "owner", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "G", "Lcom/tencent/mobileqq/zootopia/download/ui/downloaded/a;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "H", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f extends com.tencent.mobileqq.zootopia.download.ui.a<b> {

    /* renamed from: E, reason: from kotlin metadata */
    private final LifecycleOwner owner;

    /* renamed from: F */
    private final ZootopiaSource source;

    /* renamed from: G, reason: from kotlin metadata */
    private a itemClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010)\u001a\u00020 \u00a2\u0006\u0004\b*\u0010+R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010(\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b'\u0010\f\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/downloaded/f$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/widget/ImageView;", "iconTypeView", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "p", "()Landroid/widget/TextView;", "typeTextView", "G", "getTitleView", "titleView", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "H", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "l", "()Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "controllerView", "Landroid/widget/Button;", "I", "Landroid/widget/Button;", "getDeleteView", "()Landroid/widget/Button;", "deleteView", "J", "getCoverView", "coverView", "Landroid/view/View;", "K", "Landroid/view/View;", "o", "()Landroid/view/View;", "mask", "L", "getOccupySpaceTxv", "occupySpaceTxv", "itemView", "<init>", "(Landroid/view/View;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        private final ImageView iconTypeView;

        /* renamed from: F */
        private final TextView typeTextView;

        /* renamed from: G, reason: from kotlin metadata */
        private final TextView titleView;

        /* renamed from: H, reason: from kotlin metadata */
        private final ZootopiaDownloadButton controllerView;

        /* renamed from: I, reason: from kotlin metadata */
        private final Button deleteView;

        /* renamed from: J, reason: from kotlin metadata */
        private final ImageView coverView;

        /* renamed from: K, reason: from kotlin metadata */
        private final View mask;

        /* renamed from: L, reason: from kotlin metadata */
        private final TextView occupySpaceTxv;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            com.tencent.mobileqq.zootopia.download.ui.a.INSTANCE.a(itemView);
            View findViewById = itemView.findViewById(R.id.f163420q13);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.icon_type)");
            this.iconTypeView = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.quy);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.type)");
            this.typeTextView = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.qr6);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.title)");
            this.titleView = (TextView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.pmm);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.controller)");
            this.controllerView = (ZootopiaDownloadButton) findViewById4;
            View findViewById5 = itemView.findViewById(R.id.poq);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.delete)");
            this.deleteView = (Button) findViewById5;
            View findViewById6 = itemView.findViewById(R.id.pms);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.cover)");
            this.coverView = (ImageView) findViewById6;
            View findViewById7 = itemView.findViewById(R.id.q7v);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.mask)");
            this.mask = findViewById7;
            View findViewById8 = itemView.findViewById(R.id.q_n);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.occupySpaceTxv)");
            this.occupySpaceTxv = (TextView) findViewById8;
        }

        public final ImageView getCoverView() {
            return this.coverView;
        }

        public final Button getDeleteView() {
            return this.deleteView;
        }

        public final TextView getOccupySpaceTxv() {
            return this.occupySpaceTxv;
        }

        public final TextView getTitleView() {
            return this.titleView;
        }

        /* renamed from: l, reason: from getter */
        public final ZootopiaDownloadButton getControllerView() {
            return this.controllerView;
        }

        /* renamed from: m, reason: from getter */
        public final ImageView getIconTypeView() {
            return this.iconTypeView;
        }

        /* renamed from: o, reason: from getter */
        public final View getMask() {
            return this.mask;
        }

        /* renamed from: p, reason: from getter */
        public final TextView getTypeTextView() {
            return this.typeTextView;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f328248a;

        static {
            int[] iArr = new int[MapStatus.values().length];
            try {
                iArr[MapStatus.MAP_STATUS_OFF_SHELF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_MAINTAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_HIGHER_QQ_VERSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_NEED_UPDATE_QQ.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_APPOINTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MapStatus.MAP_STATUS_ONLY_DOWNLOAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f328248a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/download/ui/downloaded/f$d", "Lcom/tencent/mobileqq/zplan/cloudmod/api/CloudModClickListener;", "Landroid/view/View;", "view", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "type", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends CloudModClickListener {

        /* renamed from: d */
        final /* synthetic */ com.tencent.mobileqq.zootopia.download.ui.d f328249d;

        /* renamed from: e */
        final /* synthetic */ f f328250e;

        /* renamed from: f */
        final /* synthetic */ b f328251f;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public /* synthetic */ class a {

            /* renamed from: a */
            public static final /* synthetic */ int[] f328252a;

            static {
                int[] iArr = new int[ButtonStatus.values().length];
                try {
                    iArr[ButtonStatus.LOADED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ButtonStatus.UPDATE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ButtonStatus.MAINTENANCE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ButtonStatus.UPDATE_SYSTEM.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                f328252a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(com.tencent.mobileqq.zootopia.download.ui.d dVar, f fVar, b bVar, int i3, ZootopiaSource zootopiaSource) {
            super(i3, zootopiaSource, null, 4, null);
            this.f328249d = dVar;
            this.f328250e = fVar;
            this.f328251f = bVar;
        }

        @Override // com.tencent.mobileqq.zplan.cloudmod.api.CloudModClickListener
        public void b(View view, ButtonStatus type) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(type, "type");
            QLog.i("ZootopiaDownloadedAdapter_", 1, "onButtonClick status = " + type + " - " + this.f328249d.getData().getResData().getId());
            this.f328250e.getReportHelper().c("clck", this.f328251f.getControllerView(), this.f328250e.H0(this.f328249d));
            int i3 = a.f328252a[type.ordinal()];
            if (i3 == 1) {
                com.tencent.mobileqq.zootopia.download.ui.downloaded.a aVar = this.f328250e.itemClickListener;
                if (aVar != null) {
                    aVar.e(this.f328249d);
                    return;
                }
                return;
            }
            if (i3 == 2) {
                com.tencent.mobileqq.zootopia.download.ui.downloaded.a aVar2 = this.f328250e.itemClickListener;
                if (aVar2 != null) {
                    aVar2.d(this.f328249d);
                    return;
                }
                return;
            }
            if (i3 != 4) {
                return;
            }
            Context context = this.f328251f.getControllerView().getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            k.e(new k(), activity, null, 2, null);
        }
    }

    public f(LifecycleOwner owner, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(source, "source");
        this.owner = owner;
        this.source = source;
    }

    private final void A0(b holder, com.tencent.mobileqq.zootopia.download.ui.d data) {
        holder.getControllerView().setShowButtonSubText(false);
        holder.getMask().setVisibility(8);
        MapStatus status = data.getStatus();
        switch (status == null ? -1 : c.f328248a[status.ordinal()]) {
            case 1:
                holder.getMask().setVisibility(0);
                holder.getControllerView().setStatus(ButtonStatus.INVALID);
                break;
            case 2:
            case 3:
                holder.getControllerView().setStatus(ButtonStatus.MAINTENANCE);
                break;
            case 4:
                holder.getControllerView().setStatus(ButtonStatus.UPDATE);
                break;
            case 5:
                holder.getControllerView().setStatus(ButtonStatus.UPDATE_SYSTEM);
                break;
            case 6:
                holder.getControllerView().setStatus(ButtonStatus.APPOINTED);
                break;
            case 7:
                holder.getControllerView().setStatus(ButtonStatus.ONLY_DOWNLOAD);
                break;
        }
        holder.getControllerView().setButtonStatusListener(new d(data, this, holder, data.getData().getResData().getId(), this.source));
    }

    private final void B0(b holder, com.tencent.mobileqq.zootopia.download.ui.d data) {
        if (TextUtils.isEmpty(data.getData().getSummaryData().getCover())) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = UIUtil.dp2px(holder.getCoverView().getContext(), 75.0f);
        obtain.mRequestHeight = UIUtil.dp2px(holder.getCoverView().getContext(), 96.0f);
        holder.getCoverView().setImageDrawable(URLDrawable.getDrawable(data.getData().getSummaryData().getCover(), obtain));
    }

    private final void C0(final b holder, com.tencent.mobileqq.zootopia.download.ui.d data) {
        final String id5 = data.getData().getSummaryData().getId();
        MapOccupiedSpaceManager mapOccupiedSpaceManager = MapOccupiedSpaceManager.f329259b;
        LiveData<MapSpaceInfo> A = mapOccupiedSpaceManager.A(id5);
        A.removeObservers(this.owner);
        MapSpaceInfo value = A.getValue();
        holder.getOccupySpaceTxv().setTag(R.id.r0z, id5);
        A.observe(this.owner, new Observer() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloaded.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                f.D0(f.b.this, id5, this, (MapSpaceInfo) obj);
            }
        });
        if (value != null && value.d() != 0) {
            showOccupySpaceSize(holder.getOccupySpaceTxv(), value.d());
        } else {
            holder.getOccupySpaceTxv().setText(BaseApplication.context.getString(R.string.f169777xj4));
            mapOccupiedSpaceManager.B(id5);
        }
    }

    public static final void D0(b holder, String mapId, f this$0, MapSpaceInfo mapSpaceInfo) {
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(mapId, "$mapId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = holder.getOccupySpaceTxv().getTag(R.id.r0z);
        if (!Intrinsics.areEqual(tag, mapId)) {
            QLog.e("ZootopiaDownloadedAdapter_", 1, "excepted mapId:" + mapId + ", mapIdFromTag:" + tag);
            return;
        }
        this$0.showOccupySpaceSize(holder.getOccupySpaceTxv(), mapSpaceInfo.d());
    }

    private final void F0(b holder, com.tencent.mobileqq.zootopia.download.ui.d data) {
        String buttonText;
        if (data.getData().getSummaryData().getButtonText().length() > 5) {
            buttonText = data.getData().getSummaryData().getButtonText().substring(0, 5);
            Intrinsics.checkNotNullExpressionValue(buttonText, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        } else {
            buttonText = data.getData().getSummaryData().getButtonText();
        }
        ZootopiaDownloadButton controllerView = holder.getControllerView();
        ButtonStatus buttonStatus = ButtonStatus.LOADED;
        controllerView.setStatusText(buttonStatus, buttonText);
        holder.getControllerView().setStatus(buttonStatus);
        holder.getTypeTextView().setText(data.getData().getSummaryData().getTypeName());
        if (TextUtils.isEmpty(data.getData().getSummaryData().getTypeIcon())) {
            return;
        }
        holder.getIconTypeView().setImageDrawable(URLDrawable.getDrawable(data.getData().getSummaryData().getTypeIcon(), (URLDrawable.URLDrawableOptions) null));
    }

    public final Map<String, Object> H0(com.tencent.mobileqq.zootopia.download.ui.d data) {
        int i3;
        Map<String, Object> I0 = I0(data);
        if (Intrinsics.areEqual(data.getCom.tencent.mobileqq.app.AppConstants.Key.COLUMN_IS_VALID java.lang.String(), Boolean.TRUE)) {
            i3 = 4;
        } else {
            Integer qqVerTip = data.getQqVerTip();
            if (qqVerTip != null && qqVerTip.intValue() == 1) {
                i3 = 2;
            } else {
                Integer qqVerTip2 = data.getQqVerTip();
                if (qqVerTip2 != null && qqVerTip2.intValue() == 2) {
                    i3 = 3;
                } else {
                    Integer mapVerTip = data.getMapVerTip();
                    i3 = (mapVerTip != null && mapVerTip.intValue() == 1) ? 1 : 0;
                }
            }
        }
        I0.put("zplan_map_update_btnstatus", Integer.valueOf(i3));
        return I0;
    }

    public static final void K0(f this$0, b holder, com.tencent.mobileqq.zootopia.download.ui.d data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(data, "$data");
        this$0.getReportHelper().c("clck", holder.getDeleteView(), new LinkedHashMap());
        a aVar = this$0.itemClickListener;
        if (aVar != null) {
            aVar.b(data);
        }
    }

    public static final void L0(f this$0, b holder, com.tencent.mobileqq.zootopia.download.ui.d data, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(data, "$data");
        id3.d reportHelper = this$0.getReportHelper();
        View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        reportHelper.c("clck", view2, this$0.I0(data));
        if (Intrinsics.areEqual(data.getCom.tencent.mobileqq.app.AppConstants.Key.COLUMN_IS_VALID java.lang.String(), Boolean.FALSE)) {
            QLog.e("ZootopiaDownloadedAdapter_", 1, "click item but status is inValid");
            return;
        }
        a aVar = this$0.itemClickListener;
        if (aVar != null) {
            aVar.c(data);
        }
    }

    private final void showOccupySpaceSize(TextView txv, long occupiedSize) {
        txv.setText(j.f329276a.e(occupiedSize));
    }

    public static final void z0(f this$0, String mapId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mapId, "$mapId");
        this$0.x0(mapId, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: J0 */
    public void onBindViewHolder(final b holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position >= getDataList().size()) {
            return;
        }
        final com.tencent.mobileqq.zootopia.download.ui.d dVar = getDataList().get(position);
        B0(holder, dVar);
        F0(holder, dVar);
        A0(holder, dVar);
        C0(holder, dVar);
        holder.getTitleView().setText(dVar.getData().getSummaryData().getTitle());
        holder.getDeleteView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloaded.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.K0(f.this, holder, dVar, view);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloaded.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.L0(f.this, holder, dVar, view);
            }
        });
        E0(holder, dVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: M0 */
    public b onCreateViewHolder(ViewGroup r36, int viewType) {
        Intrinsics.checkNotNullParameter(r36, "parent");
        View view = LayoutInflater.from(r36.getContext()).inflate(R.layout.d7w, r36, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new b(view);
    }

    public final void N0(a itemClickListener) {
        Intrinsics.checkNotNullParameter(itemClickListener, "itemClickListener");
        this.itemClickListener = itemClickListener;
    }

    @Override // com.tencent.mobileqq.zootopia.download.ui.a
    public void updateList(List<com.tencent.mobileqq.zootopia.download.ui.d> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        super.updateList(dataList);
        QLog.i("ZootopiaDownloadedAdapter_", 1, "updateList - " + dataList.size());
    }

    public final void x0(final String mapId, boolean fromDelay) {
        Unit unit;
        Object obj;
        Intrinsics.checkNotNullParameter(mapId, "mapId");
        QLog.i("ZootopiaDownloadedAdapter_", 1, "autoCleanMapCache - " + mapId + " - " + fromDelay);
        Iterator<T> it = getDataList().iterator();
        while (true) {
            unit = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((com.tencent.mobileqq.zootopia.download.ui.d) obj).getData().getSummaryData().getId(), mapId)) {
                    break;
                }
            }
        }
        com.tencent.mobileqq.zootopia.download.ui.d dVar = (com.tencent.mobileqq.zootopia.download.ui.d) obj;
        if (dVar != null) {
            QLog.i("ZootopiaDownloadedAdapter_", 1, "autoCleanMapCache - onItemAutoCleanCache");
            a aVar = this.itemClickListener;
            if (aVar != null) {
                aVar.a(dVar);
                unit = Unit.INSTANCE;
            }
            if (unit != null) {
                return;
            }
        }
        QLog.e("ZootopiaDownloadedAdapter_", 1, "autoCleanMapCache - not found, try delay");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.ui.downloaded.d
            @Override // java.lang.Runnable
            public final void run() {
                f.z0(f.this, mapId);
            }
        }, 400L);
    }

    private final Map<String, Object> I0(com.tencent.mobileqq.zootopia.download.ui.d data) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_map_id", Integer.valueOf(data.getData().getResData().getId())), new Pair("zplan_module_id", "em_zplan_playground_download_complete_map"));
        return mutableMapOf;
    }

    private final void E0(b holder, com.tencent.mobileqq.zootopia.download.ui.d data) {
        id3.d reportHelper = getReportHelper();
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        id3.d.i(reportHelper, view, "em_zplan_playground_download_complete_map", I0(data), false, false, null, false, false, 240, null);
        id3.d.i(getReportHelper(), holder.getControllerView(), "em_zplan_playground_download_complete_map_enter", H0(data), false, false, null, false, false, 240, null);
        id3.d.i(getReportHelper(), holder.getDeleteView(), "em_zplan_playground_download_complete_map_delete", I0(data), false, false, null, false, false, 240, null);
    }

    public static /* synthetic */ void y0(f fVar, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        fVar.x0(str, z16);
    }
}
