package com.qzone.reborn.albumx.qzonex.section.albumdetail;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxModifyLocationEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import nc.ap;
import nc.y;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/section/albumdetail/r;", "Lu9/d;", "Landroid/view/View$OnClickListener;", "", "T", "W", ExifInterface.LATITUDE_SOUTH, "Landroid/view/View;", "v", NodeProps.ON_CLICK, "<init>", "()V", "L", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class r extends u9.d implements View.OnClickListener {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // u9.d
    public void S() {
        MutableLiveData<CommonAlbumInfo> M1;
        MutableLiveData<CommonAlbumInfo> M12;
        CommonAlbumInfo value;
        CommonAlbumInfo commonAlbumInfo = null;
        l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, getRootView(), null);
        com.qzone.reborn.albumx.common.viewmodel.b Ne = cVar != null ? cVar.Ne() : null;
        y yVar = Ne instanceof y ? (y) Ne : null;
        if (!TextUtils.isEmpty(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getLbs().getLocation())) {
            B().setVisibility(0);
            z().setVisibility(0);
            B().setText(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getLbs().getLocation());
            return;
        }
        com.qzone.reborn.albumx.qzonex.utils.c cVar2 = com.qzone.reborn.albumx.qzonex.utils.c.f53402a;
        if (cVar2.c((yVar == null || (M12 = yVar.M1()) == null || (value = M12.getValue()) == null) ? null : Integer.valueOf(value.getQzAlbumType())) == 3) {
            if (yVar != null && (M1 = yVar.M1()) != null) {
                commonAlbumInfo = M1.getValue();
            }
            if (cVar2.e(commonAlbumInfo)) {
                B().setVisibility(0);
                z().setVisibility(0);
                B().setText(com.qzone.util.l.a(R.string.f134789r));
                fo.c.o(B(), "em_qz_edit_location", new fo.b());
                B().setOnClickListener(this);
                z().setOnClickListener(this);
                return;
            }
        }
        B().setVisibility(8);
        z().setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u9.d
    public void T() {
        if (((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getUploadNumber() <= 0) {
            C().setVisibility(8);
            return;
        }
        C().setVisibility(0);
        C().setText(C().getResources().getString(R.string.spb, Long.valueOf(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getUploadNumber())));
        if (y().getVisibility() == 8 && D().getVisibility() == 8) {
            ViewGroup.LayoutParams layoutParams = C().getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.leftMargin = 0;
            }
            C().setLayoutParams(layoutParams2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u9.d
    public void W() {
        MutableLiveData<CommonAlbumInfo> M1;
        CommonAlbumInfo value;
        l9.c cVar = (l9.c) RFWIocAbilityProvider.g().getIocInterface(l9.c.class, getRootView(), null);
        ViewModel Ne = cVar != null ? cVar.Ne() : null;
        y yVar = Ne instanceof y ? (y) Ne : null;
        boolean z16 = false;
        if (yVar != null && (M1 = yVar.M1()) != null && (value = M1.getValue()) != null && (!value.getIsShareAlbum())) {
            z16 = true;
        }
        if (z16) {
            y().setVisibility(8);
            D().setVisibility(8);
        }
        try {
            y().setUser(Long.parseLong(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getUser().getUin()));
        } catch (NumberFormatException e16) {
            QLog.e("QZAlbumxDetailBatchHeadSection", 1, "updateUserData  e = " + e16);
        }
        D().setText(com.qzone.reborn.albumx.qzonex.utils.j.f53413a.a(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getUser().getUin(), ((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().getUser().getNick()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        List<CommonStMedia> p26;
        List<CommonStMedia> p27;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        boolean z16 = true;
        if ((valueOf == null || valueOf.intValue() != R.id.nj5) && (valueOf == null || valueOf.intValue() != R.id.lcb)) {
            z16 = false;
        }
        if (z16) {
            com.qzone.reborn.albumx.common.viewmodel.e operateViewModel = getOperateViewModel();
            ap apVar = operateViewModel instanceof ap ? (ap) operateViewModel : null;
            if (apVar != null && (p27 = apVar.p2()) != null) {
                p27.clear();
            }
            com.qzone.reborn.albumx.common.viewmodel.e operateViewModel2 = getOperateViewModel();
            ap apVar2 = operateViewModel2 instanceof ap ? (ap) operateViewModel2 : null;
            if (apVar2 != null && (p26 = apVar2.p2()) != null) {
                p26.addAll(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().j());
            }
            SimpleEventBus.getInstance().dispatchEvent(new QZAlbumxModifyLocationEvent(new ArrayList(((CommonGridItemData) this.mData).getBatchBean().getBatchInfo().j())));
            EventCollector.getInstance().onViewClicked(v3);
        }
    }
}
