package jk;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.l;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.intimate.bean.QZoneIntimateUserBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateActivateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateManageInitBean;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredRelativeLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.state.report.SquareReportConst;
import common.config.service.QZoneConfigHelper;
import ho.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.aw;
import qzone.QZIntimateProfileReader$IntimateSpaceAbs;
import qzone.QZoneBaseMeta$StUser;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0014J*\u0010\u0018\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\fH\u0014J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010,R\u0016\u00105\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010(R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006<"}, d2 = {"Ljk/b;", "Lcom/qzone/reborn/base/l;", "Lqzone/QZIntimateProfileReader$IntimateSpaceAbs;", "Landroid/view/View$OnClickListener;", "", "v", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", HippyTKDListViewAdapter.X, "y", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", "u", "", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateUserBean;", "w", "", "getViewStubLayoutId", "containerView", "onInitView", "data", "", "position", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, NodeProps.ON_CLICK, "", "e", "Ljava/lang/String;", "TAG", "Landroid/widget/RelativeLayout;", "f", "Landroid/widget/RelativeLayout;", "rlItemLayout", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", h.F, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarUser", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "tvNick", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "ivStartIcon", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredRelativeLayout;", "roundLabelLayout", "D", "ivLabelIcon", "E", "tvLabelText", "Lnk/aw;", UserInfo.SEX_FEMALE, "Lnk/aw;", "manageViewModel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends l<QZIntimateProfileReader$IntimateSpaceAbs> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private RoundCorneredRelativeLayout roundLabelLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView ivLabelIcon;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView tvLabelText;

    /* renamed from: F, reason: from kotlin metadata */
    private aw manageViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "QZIntimateManageDraftSpaceSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout rlItemLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarUser;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tvNick;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView ivStartIcon;

    /* JADX WARN: Multi-variable type inference failed */
    private final void A() {
        if (((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).user.isEmpty()) {
            QLog.e(this.TAG, 1, "updateUserData  mData.user.isEmpty");
            return;
        }
        TextView textView = null;
        try {
            QZoneUserAvatarView qZoneUserAvatarView = this.avatarUser;
            if (qZoneUserAvatarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarUser");
                qZoneUserAvatarView = null;
            }
            mk.h hVar = mk.h.f416877a;
            String str = ((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).user.get(0).uid.get();
            aw awVar = this.manageViewModel;
            qZoneUserAvatarView.setUser(hVar.f(str, awVar != null ? awVar.getCommonExt() : null));
        } catch (NumberFormatException e16) {
            QLog.e(this.TAG, 1, "updateUserData  e = " + e16);
        }
        TextView textView2 = this.tvNick;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvNick");
        } else {
            textView = textView2;
        }
        textView.setText(((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).user.get(0).nick.get());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final QZoneIntimateActivateSpaceBean u() {
        QZoneIntimateActivateSpaceBean qZoneIntimateActivateSpaceBean = new QZoneIntimateActivateSpaceBean();
        if (((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).user.isEmpty()) {
            QLog.e(this.TAG, 1, "updateUserData  mData.user.isEmpty");
            return qZoneIntimateActivateSpaceBean;
        }
        qZoneIntimateActivateSpaceBean.setUsers(w());
        qZoneIntimateActivateSpaceBean.setSpaceType(((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).space_type.get());
        return qZoneIntimateActivateSpaceBean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        String str;
        HashMap hashMap = new HashMap();
        RelativeLayout relativeLayout = null;
        if (!((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).user.isEmpty()) {
            mk.h hVar = mk.h.f416877a;
            String str2 = ((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).user.get(0).uid.get();
            aw awVar = this.manageViewModel;
            hashMap.put("touin", Long.valueOf(hVar.f(str2, awVar != null ? awVar.getCommonExt() : null)));
            String str3 = ((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).user.get(0).uid.get();
            Intrinsics.checkNotNullExpressionValue(str3, "mData.user[0].uid.get()");
            hashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, str3);
        }
        hashMap.put("close_friend_space_type", Integer.valueOf(((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).space_type.get()));
        String str4 = ((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).space_id.get();
        Intrinsics.checkNotNullExpressionValue(str4, "mData.space_id.get()");
        hashMap.put("close_friend_space_id", str4);
        if (((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).has_recent_pub.get()) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("update_state", str);
        hashMap.put("card_status", 0);
        RelativeLayout relativeLayout2 = this.rlItemLayout;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rlItemLayout");
        } else {
            relativeLayout = relativeLayout2;
        }
        fo.c.o(relativeLayout, "em_qz_friend_space_card", new fo.b().l(hashMap).i(((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).space_id.get()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<QZoneIntimateUserBean> w() {
        ArrayList arrayList = new ArrayList();
        oj.a aVar = oj.a.f423008a;
        arrayList.add(aVar.g(aVar.d()));
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser = ((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).user.get(0);
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StUser, "mData.user[0]");
        arrayList.add(aVar.g(qZoneBaseMeta$StUser));
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x(View v3) {
        String str;
        if (g.f53821a.h().w()) {
            String valueOf = String.valueOf(((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).space_type.get());
            if (((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).user.size() > 0) {
                mk.h hVar = mk.h.f416877a;
                String str2 = ((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).user.get(0).uid.get();
                aw awVar = this.manageViewModel;
                str = String.valueOf(hVar.f(str2, awVar != null ? awVar.getCommonExt() : null));
            } else {
                str = "";
            }
            i.q(v3.getContext(), QZoneConfigHelper.w0(str, valueOf));
            return;
        }
        StringBuilder sb5 = new StringBuilder(QZoneConfigHelper.v0());
        if (((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).user.size() > 0) {
            sb5.append("&to=");
            mk.h hVar2 = mk.h.f416877a;
            String str3 = ((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).user.get(0).uid.get();
            aw awVar2 = this.manageViewModel;
            sb5.append(hVar2.f(str3, awVar2 != null ? awVar2.getCommonExt() : null));
        }
        sb5.append("&space_type=");
        sb5.append(((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).space_type.get());
        i.q(v3.getContext(), sb5.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y(View v3) {
        QZoneIntimateManageInitBean initBean;
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = new QZoneIntimateMainPageInitBean();
        String str = ((QZIntimateProfileReader$IntimateSpaceAbs) this.mData).space_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "mData.space_id.get()");
        qZoneIntimateMainPageInitBean.setSpaceId(str);
        qZoneIntimateMainPageInitBean.setDraft(true);
        aw awVar = this.manageViewModel;
        if (awVar != null && (initBean = awVar.getInitBean()) != null) {
            qZoneIntimateMainPageInitBean.setFrom(initBean.getFrom());
        }
        qZoneIntimateMainPageInitBean.setActivateSpaceBean(u());
        ck.c o16 = i.o();
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        o16.r(context, qZoneIntimateMainPageInitBean);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.nep) {
            if (!com.qzone.reborn.util.e.b(this.TAG + "HalfScreen", 500L)) {
                if (g.f53821a.b().D1()) {
                    y(v3);
                } else {
                    x(v3);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.nep);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.rl_item_layout)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        this.rlItemLayout = relativeLayout;
        RoundCorneredRelativeLayout roundCorneredRelativeLayout = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rlItemLayout");
            relativeLayout = null;
        }
        relativeLayout.setOnClickListener(this);
        View findViewById2 = containerView.findViewById(R.id.f19094r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewById(R.id.avatar_user)");
        this.avatarUser = (QZoneUserAvatarView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.nje);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewById(R.id.tv_nick)");
        this.tvNick = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.nk7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewById(R.id.tv_start_icon)");
        ImageView imageView = (ImageView) findViewById4;
        this.ivStartIcon = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivStartIcon");
            imageView = null;
        }
        rn.h.a(imageView, "qui_chevron_right", R.color.qui_common_icon_secondary);
        View findViewById5 = containerView.findViewById(R.id.f162937nf2);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026(R.id.round_label_layout)");
        RoundCorneredRelativeLayout roundCorneredRelativeLayout2 = (RoundCorneredRelativeLayout) findViewById5;
        this.roundLabelLayout = roundCorneredRelativeLayout2;
        if (roundCorneredRelativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roundLabelLayout");
        } else {
            roundCorneredRelativeLayout = roundCorneredRelativeLayout2;
        }
        roundCorneredRelativeLayout.setRadius(ef.d.b(8), ef.d.b(8), ef.d.b(8), ef.d.b(8));
        View findViewById6 = containerView.findViewById(R.id.lal);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewById(R.id.iv_label_icon)");
        this.ivLabelIcon = (ImageView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.f162958nj3);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewById(R.id.tv_label_text)");
        this.tvLabelText = (TextView) findViewById7;
        this.manageViewModel = (aw) t(aw.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n4z};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindData(QZIntimateProfileReader$IntimateSpaceAbs data, int position, List<Object> payload) {
        if (data != null) {
            A();
            c cVar = c.f410300a;
            RoundCorneredRelativeLayout roundCorneredRelativeLayout = this.roundLabelLayout;
            ImageView imageView = null;
            if (roundCorneredRelativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roundLabelLayout");
                roundCorneredRelativeLayout = null;
            }
            TextView textView = this.tvLabelText;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvLabelText");
                textView = null;
            }
            ImageView imageView2 = this.ivLabelIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivLabelIcon");
            } else {
                imageView = imageView2;
            }
            cVar.k(data, roundCorneredRelativeLayout, textView, imageView);
            v();
            QLog.d(this.TAG, 1, "onBindData  | space_id = " + data.space_id.get() + " | position = " + position);
        }
    }
}
