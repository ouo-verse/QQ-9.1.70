package com.qzone.reborn.repair.section;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.base.l;
import com.qzone.reborn.repair.bean.QZoneRepairTaskStateBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PhotoParam;
import ho.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J*\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/qzone/reborn/repair/section/b;", "Lcom/qzone/reborn/base/l;", "Lwn/d;", "data", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "position", "y", "v", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "", "payload", "w", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvTitleText", "f", "tvFileSize", h.F, "Landroid/view/View;", "dividerView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b extends l<wn.d> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvTitleText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvFileSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View dividerView;

    private final void A(wn.d data) {
        int i3 = data.getRsTask().status.get();
        TextView textView = null;
        if (i3 == 0) {
            TextView textView2 = this.tvTitleText;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTitleText");
            } else {
                textView = textView2;
            }
            textView.setText(com.qzone.util.l.a(R.string.f169569wb3));
            return;
        }
        if (i3 == 1 || i3 == 2) {
            TextView textView3 = this.tvTitleText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTitleText");
            } else {
                textView = textView3;
            }
            textView.setText(com.qzone.util.l.a(R.string.f169567wb1));
            return;
        }
        if (i3 != 3) {
            return;
        }
        TextView textView4 = this.tvTitleText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitleText");
        } else {
            textView = textView4;
        }
        textView.setText(com.qzone.util.l.a(R.string.f169568wb2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        QZoneRepairTaskStateBean qZoneRepairTaskStateBean = new QZoneRepairTaskStateBean(null, 1, null);
        String str = ((wn.d) this.mData).getRsTask().album_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "mData.rsTask.album_id.get()");
        qZoneRepairTaskStateBean.setAlbumId(str);
        String str2 = ((wn.d) this.mData).getRsTask().lloc.get();
        Intrinsics.checkNotNullExpressionValue(str2, "mData.rsTask.lloc.get()");
        qZoneRepairTaskStateBean.setLloc(str2);
        String str3 = ((wn.d) this.mData).getRsTask().task_id.get();
        Intrinsics.checkNotNullExpressionValue(str3, "mData.rsTask.task_id.get()");
        qZoneRepairTaskStateBean.setTaskId(str3);
        String str4 = ((wn.d) this.mData).getRsTask().sr_url.get();
        Intrinsics.checkNotNullExpressionValue(str4, "mData.rsTask.sr_url.get()");
        qZoneRepairTaskStateBean.setSrUrl(str4);
        String str5 = ((wn.d) this.mData).getRsTask().src_url.get();
        Intrinsics.checkNotNullExpressionValue(str5, "mData.rsTask.src_url.get()");
        qZoneRepairTaskStateBean.setSrOriginUrl(str5);
        qZoneRepairTaskStateBean.setSrStatus(Integer.valueOf(((wn.d) this.mData).getRsTask().status.get()));
        qZoneRepairTaskStateBean.setNeedDoSRReq(Boolean.valueOf(((wn.d) this.mData).getRsTask().status.get() == 1 && TextUtils.isEmpty(qZoneRepairTaskStateBean.getSrUrl())));
        ArrayList<PhotoInfo> arrayList = new ArrayList<>();
        PhotoInfo photoInfo = new PhotoInfo();
        photoInfo.albumId = qZoneRepairTaskStateBean.getAlbumId();
        photoInfo.lloc = qZoneRepairTaskStateBean.getLloc();
        photoInfo.currentUrl = qZoneRepairTaskStateBean.getSrOriginUrl();
        photoInfo.mCurrentUrlWith = ((wn.d) this.mData).getRsTask().sr_width.get();
        photoInfo.mCurrentUrlHeight = ((wn.d) this.mData).getRsTask().sr_height.get();
        arrayList.add(photoInfo);
        PhotoParam photoParam = new PhotoParam();
        photoParam.albumid = qZoneRepairTaskStateBean.getAlbumId();
        photoParam.ownerUin = LoginData.getInstance().getUin();
        bo.b bVar = (bo.b) i.t(bo.b.class);
        Activity p16 = p();
        wn.c cVar = new wn.c();
        cVar.h(photoParam);
        cVar.n(qZoneRepairTaskStateBean);
        cVar.o(arrayList);
        cVar.m(5);
        Unit unit = Unit.INSTANCE;
        bVar.a(p16, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y(int position) {
        List<wn.d> Q1;
        com.qzone.reborn.repair.viewmodel.i iVar = (com.qzone.reborn.repair.viewmodel.i) t(com.qzone.reborn.repair.viewmodel.i.class);
        int size = (iVar == null || (Q1 = iVar.Q1()) == null) ? 0 : Q1.size();
        if (size == 0) {
            return;
        }
        View view = null;
        if (size - 1 == position) {
            View view2 = this.dividerView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dividerView");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        View view3 = this.dividerView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dividerView");
        } else {
            view = view3;
        }
        view.setVisibility(0);
    }

    private final void z(wn.d data) {
        double d16 = data.getRsTask().sr_size.get() / 1048576;
        TextView textView = this.tvFileSize;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvFileSize");
            textView = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d16)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView.setText(format + "M");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.nkk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.tv_title_text)");
        this.tvTitleText = (TextView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.nit);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.tv_file_size)");
        this.tvFileSize = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.f20468g);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.divider_view)");
        this.dividerView = findViewById3;
        containerView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.repair.section.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.x(b.this, view);
            }
        });
        fo.c.o(containerView, "em_qz_photo", new fo.b().k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nmd};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(wn.d data, int position, List<Object> payload) {
        if (data != null) {
            A(data);
            z(data);
            y(position);
        }
    }
}
