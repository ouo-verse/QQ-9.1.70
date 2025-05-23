package hp;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.reborn.base.l;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.RecommendLabel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import ef.d;
import fo.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J*\u0010\u0018\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0014J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u000fH\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001e\u00102\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lhp/b;", "Lcom/qzone/reborn/base/l;", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "Landroid/view/View$OnClickListener;", "", "v", HippyTKDListViewAdapter.X, "w", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", BdhLogUtil.LogTag.Tag_Conn, "B", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "view", NodeProps.ON_CLICK, "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "itemView", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "f", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarView", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "nickNameView", "Lcom/tencent/mobileqq/troop/widget/TroopLabelLayout;", "i", "Lcom/tencent/mobileqq/troop/widget/TroopLabelLayout;", "labelLayout", "Lcom/tencent/biz/qui/quibutton/QUIButton;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qui/quibutton/QUIButton;", "addFriendBtn", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Lmqq/util/WeakReference;", "appRef", "Lcom/tencent/mobileqq/app/MayknowRecommendManager;", "D", "Lcom/tencent/mobileqq/app/MayknowRecommendManager;", "recommendManager", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends l<MayKnowRecommend> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private WeakReference<QQAppInterface> appRef;

    /* renamed from: D, reason: from kotlin metadata */
    private MayknowRecommendManager recommendManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup itemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView nickNameView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TroopLabelLayout labelLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QUIButton addFriendBtn;

    /* JADX WARN: Multi-variable type inference failed */
    private final void B() {
        fo.b g16 = new fo.b().i(String.valueOf(((MayKnowRecommend) this.mData).getId())).k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_ALL);
        QUIButton qUIButton = this.addFriendBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addFriendBtn");
            qUIButton = null;
        }
        c.o(qUIButton, "em_qz_add_friend", g16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C() {
        fo.b g16 = new fo.b().i(String.valueOf(((MayKnowRecommend) this.mData).getId())).k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_ALL);
        ViewGroup viewGroup = this.itemView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemView");
            viewGroup = null;
        }
        c.o(viewGroup, "em_qz_personal_information_area", g16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u() {
        QUIButton qUIButton = this.addFriendBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addFriendBtn");
            qUIButton = null;
        }
        qUIButton.setVisibility(((MayKnowRecommend) this.mData).friendStatus == 0 ? 0 : 8);
        B();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
        QZoneUserAvatarView qZoneUserAvatarView2 = null;
        if (qZoneUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qZoneUserAvatarView = null;
        }
        qZoneUserAvatarView.setIsShieldJumpToMainPage(true);
        QZoneUserAvatarView qZoneUserAvatarView3 = this.avatarView;
        if (qZoneUserAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        } else {
            qZoneUserAvatarView2 = qZoneUserAvatarView3;
        }
        qZoneUserAvatarView2.setUser(d.k(((MayKnowRecommend) this.mData).uin));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        TroopLabelLayout troopLabelLayout = null;
        if (bl.b(((MayKnowRecommend) this.mData).msgLabel)) {
            TroopLabelLayout troopLabelLayout2 = this.labelLayout;
            if (troopLabelLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("labelLayout");
            } else {
                troopLabelLayout = troopLabelLayout2;
            }
            troopLabelLayout.setVisibility(8);
            return;
        }
        TroopLabelLayout troopLabelLayout3 = this.labelLayout;
        if (troopLabelLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelLayout");
            troopLabelLayout3 = null;
        }
        troopLabelLayout3.setVisibility(0);
        TroopLabelLayout troopLabelLayout4 = this.labelLayout;
        if (troopLabelLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelLayout");
        } else {
            troopLabelLayout = troopLabelLayout4;
        }
        List<RecommendLabel> convertToRecommendLabel = RecommendLabel.convertToRecommendLabel(((MayKnowRecommend) this.mData).msgLabel);
        T t16 = this.mData;
        troopLabelLayout.i(convertToRecommendLabel, ((MayKnowRecommend) t16).gender, ((MayKnowRecommend) t16).age);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        TextView textView = this.nickNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickNameView");
            textView = null;
        }
        textView.setText(((MayKnowRecommend) this.mData).getDisplayName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z() {
        vo.a.a(d.k(((MayKnowRecommend) this.mData).uin), 88);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindData(MayKnowRecommend data, int position, List<Object> payload) {
        v();
        x();
        w();
        u();
        C();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.n_e) {
            z();
        } else if (valueOf != null && valueOf.intValue() == R.id.n_a) {
            z();
        } else if (valueOf != null && valueOf.intValue() == R.id.n_b) {
            y();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.n_e);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ne_recommend_friend_item)");
        this.itemView = (ViewGroup) findViewById;
        View findViewById2 = containerView.findViewById(R.id.n_a);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026_recommend_friend_avatar)");
        this.avatarView = (QZoneUserAvatarView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.n_h);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026ecommend_friend_nickname)");
        this.nickNameView = (TextView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.n_f);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026e_recommend_friend_label)");
        this.labelLayout = (TroopLabelLayout) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.n_b);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026_recommend_friend_button)");
        QUIButton qUIButton = (QUIButton) findViewById5;
        this.addFriendBtn = qUIButton;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addFriendBtn");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(this);
        QZoneUserAvatarView qZoneUserAvatarView = this.avatarView;
        if (qZoneUserAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qZoneUserAvatarView = null;
        }
        qZoneUserAvatarView.setOnClickListener(this);
        ViewGroup viewGroup = this.itemView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemView");
            viewGroup = null;
        }
        viewGroup.setOnClickListener(this);
        TroopLabelLayout troopLabelLayout = this.labelLayout;
        if (troopLabelLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelLayout");
            troopLabelLayout = null;
        }
        troopLabelLayout.setLabelType(4);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            Manager manager = qQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
            this.recommendManager = manager instanceof MayknowRecommendManager ? (MayknowRecommendManager) manager : null;
            this.appRef = new WeakReference<>(qQAppInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f162985np0};
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        if (!NetworkUtil.isNetworkAvailable(p())) {
            QQToast.makeText(p(), 1, p().getResources().getString(R.string.b3j), 0).show();
            return;
        }
        WeakReference<QQAppInterface> weakReference = this.appRef;
        QQAppInterface qQAppInterface = weakReference != null ? weakReference.get() : null;
        Object manager = qQAppInterface != null ? qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER) : null;
        FriendsManager friendsManager = manager instanceof FriendsManager ? (FriendsManager) manager : null;
        if (friendsManager != null && !friendsManager.c0(((MayKnowRecommend) this.mData).uin)) {
            if (friendsManager.P(((MayKnowRecommend) this.mData).uin)) {
                QLog.e("QZoneRecommendFriendUserInfoSection", 1, "[clickAddFriendBtn] hasSendAddFriendReq");
                return;
            }
            String displayName = ((MayKnowRecommend) this.mData).getDisplayName();
            Intrinsics.checkNotNullExpressionValue(displayName, "mData.getDisplayName()");
            Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(p(), 1, ((MayKnowRecommend) this.mData).uin, (String) null, 3045, 5, displayName, (String) null, (String) null, p().getString(R.string.f170028dd), (String) null, ((MayKnowRecommend) this.mData).getToken());
            Activity p16 = p();
            T t16 = this.mData;
            startAddFriend.putExtra("key_param_age_area", ProfileCardUtil.Z(p16, ((MayKnowRecommend) t16).gender, ((MayKnowRecommend) t16).age, ((MayKnowRecommend) t16).country, ((MayKnowRecommend) t16).province, ((MayKnowRecommend) t16).city));
            startAddFriend.putExtra(AppConstants.Key.KEY_FROM_BABYQ, false);
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(p(), startAddFriend);
            gp.a aVar = (gp.a) q(gp.a.class);
            if (aVar != null) {
                aVar.m8(this.mPosition);
                return;
            }
            return;
        }
        QLog.e("QZoneRecommendFriendUserInfoSection", 1, "[clickAddFriendBtn] isFriend fm is " + friendsManager);
    }
}
