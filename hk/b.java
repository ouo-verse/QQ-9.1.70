package hk;

import android.app.Activity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import ck.c;
import com.qzone.reborn.base.l;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.intimate.bean.QZoneAlbumInfoBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ho.i;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StUser;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J*\u0010\u0016\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\rH\u0016R\u0014\u0010\u001b\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lhk/b;", "Lcom/qzone/reborn/base/l;", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "Landroid/view/View$OnClickListener;", "", "u", "v", HippyTKDListViewAdapter.X, "w", "", "getLogTag", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "y", "view", NodeProps.ON_CLICK, "e", "Ljava/lang/String;", "TAG", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "mItemView", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", h.F, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mAlbumAvatarView", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "mAlbumNameView", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends l<QZoneAlbumInfoBean> implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZoneAlbumIntimateTabHeaderSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mItemView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView mAlbumAvatarView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView mAlbumNameView;

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        PBRepeatMessageField<QZoneBaseMeta$StUser> pBRepeatMessageField = ((QZoneAlbumInfoBean) this.mData).getAlbumInfo().users;
        QZoneUserAvatarView qZoneUserAvatarView = null;
        List<QZoneBaseMeta$StUser> list = pBRepeatMessageField != null ? pBRepeatMessageField.get() : null;
        if (bl.b(list)) {
            return;
        }
        mk.h hVar = mk.h.f416877a;
        long f16 = hVar.f(hVar.d(list, ((QZoneAlbumInfoBean) this.mData).getOwnerUin(), ((QZoneAlbumInfoBean) this.mData).getCommonExt()), ((QZoneAlbumInfoBean) this.mData).getCommonExt());
        if (f16 > 0) {
            QZoneUserAvatarView qZoneUserAvatarView2 = this.mAlbumAvatarView;
            if (qZoneUserAvatarView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAlbumAvatarView");
            } else {
                qZoneUserAvatarView = qZoneUserAvatarView2;
            }
            qZoneUserAvatarView.setUser(f16);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        TextView textView = this.mAlbumNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumNameView");
            textView = null;
        }
        PBStringField pBStringField = ((QZoneAlbumInfoBean) this.mData).getAlbumInfo().desc;
        textView.setText(pBStringField != null ? pBStringField.get() : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = new QZoneIntimateMainPageInitBean();
        String str = ((QZoneAlbumInfoBean) this.mData).getAlbumInfo().space_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "mData.albumInfo.space_id.get()");
        qZoneIntimateMainPageInitBean.setSpaceId(str);
        qZoneIntimateMainPageInitBean.setFrom("8");
        qZoneIntimateMainPageInitBean.setTabId(1);
        c o16 = i.o();
        Activity activity = p();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        o16.r(activity, qZoneIntimateMainPageInitBean);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        HashMap hashMap = new HashMap();
        hashMap.put("close_friend_space_type", Integer.valueOf(((QZoneAlbumInfoBean) this.mData).getAlbumInfo().space_type.get()));
        String str = ((QZoneAlbumInfoBean) this.mData).getAlbumInfo().space_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "mData.albumInfo.space_id.get()");
        hashMap.put("close_friend_space_id", str);
        fo.b i3 = new fo.b().l(hashMap).i(((QZoneAlbumInfoBean) this.mData).getAlbumInfo().space_id.get());
        LinearLayout linearLayout = this.mItemView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
            linearLayout = null;
        }
        fo.c.o(linearLayout, "em_qz_chum_spatial_information", i3);
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
        if (view.getId() == R.id.n3l) {
            w();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n3l);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ate_album_header_content)");
        this.mItemView = (LinearLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.n5i);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026imate_space_album_avatar)");
        this.mAlbumAvatarView = (QZoneUserAvatarView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.n5j);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026ntimate_space_album_name)");
        this.mAlbumNameView = (TextView) findViewById3;
        LinearLayout linearLayout = this.mItemView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mItemView");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.nlx};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(QZoneAlbumInfoBean data, int position, List<Object> payload) {
        if (data != null) {
            u();
            v();
            x();
        }
    }
}
