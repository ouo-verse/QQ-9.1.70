package fk;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import ho.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.at;
import nk.z;
import v9.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J*\u0010\u0012\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lfk/c;", "Lv9/e;", "", "H", "e", "Lnk/z;", "J", "Lnk/at;", "K", "", "getLogTag", "Lcom/qzone/reborn/albumx/common/bean/CommonAlbumListBean;", "data", "", "position", "", "", "payload", UserInfo.SEX_FEMALE, "Landroid/view/View;", "view", NodeProps.ON_CLICK, "E", "Ljava/lang/String;", "TAG", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c extends e {

    /* renamed from: E, reason: from kotlin metadata */
    private final String TAG = "QZoneIntimateAlbumListNormalSection";

    private final void H() {
        fo.c.o(B(), "em_qz_created_album", null);
    }

    private final z J() {
        qj.c cVar = (qj.c) q(qj.c.class);
        if (cVar != null) {
            return cVar.J7();
        }
        return null;
    }

    private final at K() {
        return (at) t(at.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void e() {
        String str;
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1;
        UIStateData<QZoneIntimateSpaceBean> value;
        QZoneIntimateSpaceBean data;
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = new QZoneIntimateAlbumDetailInitBean();
        z J = J();
        if (J == null || (str = J.getMSpaceId()) == null) {
            str = "";
        }
        qZoneIntimateAlbumDetailInitBean.setSpaceId(str);
        qZoneIntimateAlbumDetailInitBean.setAlbumId(((CommonAlbumListBean) this.mData).getAlbumInfo().getAlbumId());
        at K = K();
        if (K != null && (U1 = K.U1()) != null && (value = U1.getValue()) != null && (data = value.getData()) != null) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: F */
    public void onBindData(CommonAlbumListBean data, int position, List<Object> payload) {
        super.onBindData(data, position, payload);
        H();
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
        if (view.getId() == R.id.n3j) {
            e();
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
