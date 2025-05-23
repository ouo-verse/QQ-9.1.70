package fk;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import ho.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.at;
import nk.z;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lfk/b;", "Lv9/b;", "", "e", "Lnk/z;", "y", "Lnk/at;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "getLogTag", "Landroid/view/View;", "view", NodeProps.ON_CLICK, "f", "Ljava/lang/String;", "TAG", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends v9.b {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneIntimateAlbumListNameSection";

    /* JADX WARN: Multi-variable type inference failed */
    private final void e() {
        String str;
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1;
        UIStateData<QZoneIntimateSpaceBean> value;
        QZoneIntimateSpaceBean data;
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = new QZoneIntimateAlbumDetailInitBean();
        z y16 = y();
        if (y16 == null || (str = y16.getMSpaceId()) == null) {
            str = "";
        }
        qZoneIntimateAlbumDetailInitBean.setSpaceId(str);
        qZoneIntimateAlbumDetailInitBean.setAlbumId(((CommonAlbumListBean) this.mData).getAlbumInfo().getAlbumId());
        at z16 = z();
        if (z16 != null && (U1 = z16.U1()) != null && (value = U1.getValue()) != null && (data = value.getData()) != null) {
            qZoneIntimateAlbumDetailInitBean.setSpaceType(data.getSpaceType());
            String memberUid = data.getMemberUid(((CommonAlbumListBean) this.mData).getAlbumInfo().getOwner());
            if (memberUid != null) {
                qZoneIntimateAlbumDetailInitBean.setMemberUid(memberUid);
            }
        }
        ck.c o16 = i.o();
        Activity activity = p();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        o16.j(activity, qZoneIntimateAlbumDetailInitBean);
    }

    private final z y() {
        qj.c cVar = (qj.c) q(qj.c.class);
        if (cVar != null) {
            return cVar.J7();
        }
        return null;
    }

    private final at z() {
        return (at) t(at.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: getLogTag, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.n3s) {
            e();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
