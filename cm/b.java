package cm;

import android.view.View;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.h;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import qshadow.QZoneAutoTexting$TextInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e\u001fB\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcm/b;", "Lcom/qzone/reborn/base/h;", "Lqshadow/QZoneAutoTexting$TextInfo;", "Landroid/view/View;", "view", "data", "", "p0", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "position", "", "", "payloads", "onBindViewHolder", "Lcm/b$c;", "listener", "q0", "E", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, UserInfo.SEX_FEMALE, "Lcm/b$c;", "clickListener", "<init>", "(Landroid/view/View;)V", "G", "b", "c", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b extends h<QZoneAutoTexting$TextInfo> {

    /* renamed from: E, reason: from kotlin metadata */
    private final View rootView;

    /* renamed from: F, reason: from kotlin metadata */
    private c clickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"cm/b$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lqshadow/QZoneAutoTexting$TextInfo;", "oldItem", "newItem", "", "b", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a extends DiffUtil.ItemCallback<QZoneAutoTexting$TextInfo> {
        a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(QZoneAutoTexting$TextInfo oldItem, QZoneAutoTexting$TextInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(QZoneAutoTexting$TextInfo oldItem, QZoneAutoTexting$TextInfo newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcm/b$c;", "", "Lqshadow/QZoneAutoTexting$TextInfo;", "data", "", "F5", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public interface c {
        void F5(QZoneAutoTexting$TextInfo data);
    }

    public b(View view) {
        super(new a(), new AdapterDelegatesManager(new d()));
        this.rootView = view;
        setHasStableIds(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(b this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c cVar = this$0.clickListener;
        if (cVar != null) {
            QZoneAutoTexting$TextInfo qZoneAutoTexting$TextInfo = this$0.getItems().get(i3);
            Intrinsics.checkNotNullExpressionValue(qZoneAutoTexting$TextInfo, "items[position]");
            cVar.F5(qZoneAutoTexting$TextInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position, List<Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.onBindViewHolder(holder, position, payloads);
        holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: cm.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.o0(b.this, position, view);
            }
        });
        View view = holder.itemView;
        QZoneAutoTexting$TextInfo qZoneAutoTexting$TextInfo = getItems().get(position);
        Intrinsics.checkNotNullExpressionValue(qZoneAutoTexting$TextInfo, "items[position]");
        p0(view, qZoneAutoTexting$TextInfo);
    }

    public final void q0(c listener) {
        this.clickListener = listener;
    }

    private final void p0(View view, QZoneAutoTexting$TextInfo data) {
        Map<String, Object> mutableMapOf;
        if (Intrinsics.areEqual(view != null ? view.getTag() : null, data.f429485id.get())) {
            QLog.i("QZonePublishPicToTextAdapter", 1, "[reportItemView] same id:" + data.f429485id.get());
            return;
        }
        if (view != null) {
            view.setTag(data.f429485id.get());
        }
        fo.c.l(view, this.rootView);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("text_id", data.f429485id.get()));
        fo.c.o(view, "em_qz_pic_generate_text_item", new fo.b().l(mutableMapOf).j(EndExposurePolicy.REPORT_NONE).i(data.f429485id.get()));
    }
}
