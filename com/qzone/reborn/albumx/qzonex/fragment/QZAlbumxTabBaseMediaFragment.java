package com.qzone.reborn.albumx.qzonex.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.qzone.reborn.albumx.qzonex.base.QZAlbumxInitBean;
import com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabCeilingItemPart;
import com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabTimeLinePart;
import com.qzone.reborn.albumx.qzonex.part.pictab.q;
import com.qzone.reborn.base.QZoneBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import nc.bp;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0006\u0010\b\u001a\u00020\u0007J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u0007H\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/fragment/QZAlbumxTabBaseMediaFragment;", "Lcom/qzone/reborn/base/QZoneBaseFragment;", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "qh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Lnc/bp;", "ph", "onDestroyView", "Lcom/qzone/reborn/albumx/qzonex/base/QZAlbumxInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/reborn/albumx/qzonex/base/QZAlbumxInitBean;", "getInitBean", "()Lcom/qzone/reborn/albumx/qzonex/base/QZAlbumxInitBean;", "setInitBean", "(Lcom/qzone/reborn/albumx/qzonex/base/QZAlbumxInitBean;)V", "initBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZAlbumxTabBaseMediaFragment extends QZoneBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private QZAlbumxInitBean initBean;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f129335s;
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        qh();
        QZAlbumxInitBean qZAlbumxInitBean = this.initBean;
        if (qZAlbumxInitBean != null) {
            bp ph5 = ph();
            ph5.g2(qZAlbumxInitBean.getUin() + hashCode());
            fj.a.f399444a.c(qZAlbumxInitBean.getUin() + hashCode(), ph5.getRepo());
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ph().getRepo().t();
        fj.a aVar = fj.a.f399444a;
        QZAlbumxInitBean qZAlbumxInitBean = this.initBean;
        String uin = qZAlbumxInitBean != null ? qZAlbumxInitBean.getUin() : null;
        aVar.b(uin + hashCode());
    }

    public abstract bp ph();

    public final void qh() {
        Intent intent;
        if (this.initBean == null) {
            FragmentActivity activity = getActivity();
            Serializable serializableExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getSerializableExtra("key_bundle_common_init_bean");
            this.initBean = serializableExtra instanceof QZAlbumxInitBean ? (QZAlbumxInitBean) serializableExtra : null;
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new QZAlbumTabCeilingItemPart(ph()), new QZAlbumTabTimeLinePart(ph()), new q(ph()));
        return mutableListOf;
    }
}
