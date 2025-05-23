package jk;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.base.l;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.intimate.bean.QZIntimateSpaceVipInfoBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateActivateSpaceBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateMainPageInitBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateManageInitBean;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.ArrayUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import ij.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import nk.aw;
import qzone.QZIntimateProfileReader$IntimateSpaceAbs;
import qzone.QZIntimateProfileReader$SpaceThemeInfo;
import qzone.QZoneBaseMeta$StUser;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001JB\u0007\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J*\u0010\u001d\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aH\u0014J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00105\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00101R\u0018\u0010;\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u00101R\u0018\u0010<\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00104R\u0018\u0010=\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00104R\u0018\u0010?\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00101R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010E\u00a8\u0006K"}, d2 = {"Ljk/e;", "Lcom/qzone/reborn/base/l;", "Lij/i;", "Landroid/view/View$OnClickListener;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "data", "D", "G", UserInfo.SEX_FEMALE, "H", "B", BdhLogUtil.LogTag.Tag_Conn, "J", "v", "w", "y", "Lcom/qzone/reborn/intimate/bean/init/QZoneIntimateActivateSpaceBean;", HippyTKDListViewAdapter.X, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, NodeProps.ON_CLICK, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "e", "Lij/i;", "manageItemBean", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "f", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "roundCornerContainer", "Landroid/widget/FrameLayout;", h.F, "Landroid/widget/FrameLayout;", "avatarContainer", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "i", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatarUser", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/ImageView;", "avatarDecoration", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "nickname", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "labelLayout", "E", "firstLabel", "secondLabel", "descText", "updateTag", "I", "lockIcon", "Lnk/aw;", "Lnk/aw;", "manageViewModel", "", "K", "Ljava/lang/String;", "preDesc", "<init>", "()V", "L", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends l<i> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView nickname;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout labelLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView firstLabel;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView secondLabel;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView descText;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView updateTag;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView lockIcon;

    /* renamed from: J, reason: from kotlin metadata */
    private aw manageViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private String preDesc = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private i manageItemBean;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout roundCornerContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private FrameLayout avatarContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneUserAvatarView avatarUser;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView avatarDecoration;

    private final void A() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.roundCornerContainer;
        ViewGroup.LayoutParams layoutParams = roundCorneredFrameLayout != null ? roundCorneredFrameLayout.getLayoutParams() : null;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((ViewGroup.LayoutParams) ((FrameLayout.LayoutParams) layoutParams)).height = ImmersiveUtils.dpToPx(182.0f);
            RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.roundCornerContainer;
            if (roundCorneredFrameLayout2 == null) {
                return;
            }
            roundCorneredFrameLayout2.setLayoutParams(layoutParams);
        }
    }

    private final void F(i data) {
        ImageView imageView;
        TextView textView;
        TextView textView2 = this.updateTag;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        if (data == null) {
            return;
        }
        if (data.getSpaceAbsData().has_recent_pub.get() && (textView = this.updateTag) != null) {
            textView.setVisibility(0);
        }
        ImageView imageView2 = this.lockIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        if (mk.d.f416875a.v(data) || data.getSpaceAbsData().display_right.get() == 1 || (imageView = this.lockIcon) == null) {
            return;
        }
        imageView.setVisibility(0);
    }

    private final void H(i data) {
        TextView textView = this.nickname;
        if (textView != null) {
            textView.setText("");
        }
        if (data == null || ArrayUtils.isOutOfArrayIndex(0, data.getSpaceAbsData().user.get())) {
            return;
        }
        try {
            QZoneUserAvatarView qZoneUserAvatarView = this.avatarUser;
            if (qZoneUserAvatarView != null) {
                mk.h hVar = mk.h.f416877a;
                String str = data.getSpaceAbsData().user.get(0).uid.get();
                aw awVar = this.manageViewModel;
                qZoneUserAvatarView.setUser(hVar.f(str, awVar != null ? awVar.getCommonExt() : null));
            }
        } catch (NumberFormatException e16) {
            QLog.e("QZIntimateManageSpaceSection", 1, "updateUserData  e = " + e16);
        }
        TextView textView2 = this.nickname;
        if (textView2 == null) {
            return;
        }
        textView2.setText(data.getSpaceAbsData().user.get(0).nick.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(e this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!loadState.isFinishSuccess()) {
            this$0.v();
        } else {
            this$0.w();
        }
    }

    private final void v() {
        FrameLayout frameLayout = this.avatarContainer;
        if (frameLayout == null || this.avatarDecoration == null) {
            return;
        }
        Intrinsics.checkNotNull(frameLayout);
        if (frameLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            FrameLayout frameLayout2 = this.avatarContainer;
            Intrinsics.checkNotNull(frameLayout2);
            ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = ef.d.b(32);
            layoutParams2.bottomMargin = ef.d.b(16);
            ImageView imageView = this.avatarDecoration;
            Intrinsics.checkNotNull(imageView);
            imageView.setVisibility(8);
        }
    }

    private final void w() {
        FrameLayout frameLayout = this.avatarContainer;
        if (frameLayout == null || this.avatarDecoration == null) {
            return;
        }
        Intrinsics.checkNotNull(frameLayout);
        if (frameLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            FrameLayout frameLayout2 = this.avatarContainer;
            Intrinsics.checkNotNull(frameLayout2);
            ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = ef.d.b(21);
            layoutParams2.bottomMargin = ef.d.b(5);
            ImageView imageView = this.avatarDecoration;
            Intrinsics.checkNotNull(imageView);
            imageView.setVisibility(0);
        }
    }

    private final QZoneIntimateActivateSpaceBean x() {
        String str;
        QZoneIntimateManageInitBean initBean;
        QZIntimateProfileReader$IntimateSpaceAbs spaceAbsData;
        PBRepeatMessageField<QZoneBaseMeta$StUser> pBRepeatMessageField;
        QZoneIntimateActivateSpaceBean qZoneIntimateActivateSpaceBean = new QZoneIntimateActivateSpaceBean();
        i iVar = this.manageItemBean;
        if (!((iVar == null || (spaceAbsData = iVar.getSpaceAbsData()) == null || (pBRepeatMessageField = spaceAbsData.user) == null || pBRepeatMessageField.isEmpty()) ? false : true)) {
            QLog.e("QZIntimateManageSpaceSection", 1, "updateUserData  manageItemBean.user.isEmpty");
            return qZoneIntimateActivateSpaceBean;
        }
        ArrayList arrayList = new ArrayList();
        oj.a aVar = oj.a.f423008a;
        aw awVar = this.manageViewModel;
        if (awVar == null || (initBean = awVar.getInitBean()) == null || (str = initBean.getUid()) == null) {
            str = "";
        }
        arrayList.add(aVar.g(aVar.f(str, "")));
        i iVar2 = this.manageItemBean;
        Intrinsics.checkNotNull(iVar2);
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser = iVar2.getSpaceAbsData().user.get(0);
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StUser, "manageItemBean!!.spaceAbsData.user[0]");
        arrayList.add(aVar.g(qZoneBaseMeta$StUser));
        qZoneIntimateActivateSpaceBean.setUsers(arrayList);
        i iVar3 = this.manageItemBean;
        Intrinsics.checkNotNull(iVar3);
        qZoneIntimateActivateSpaceBean.setSpaceType(iVar3.getSpaceAbsData().space_type.get());
        return qZoneIntimateActivateSpaceBean;
    }

    private final void y() {
        i iVar = this.manageItemBean;
        if (iVar == null) {
            return;
        }
        Intrinsics.checkNotNull(iVar);
        QZIntimateProfileReader$IntimateSpaceAbs spaceAbsData = iVar.getSpaceAbsData();
        HashMap hashMap = new HashMap();
        int i3 = 0;
        if (!spaceAbsData.user.isEmpty()) {
            mk.h hVar = mk.h.f416877a;
            String str = spaceAbsData.user.get(0).uid.get();
            aw awVar = this.manageViewModel;
            hashMap.put("touin", Long.valueOf(hVar.f(str, awVar != null ? awVar.getCommonExt() : null)));
            String str2 = spaceAbsData.user.get(0).uid.get();
            Intrinsics.checkNotNullExpressionValue(str2, "spaceData.user[0].uid.get()");
            hashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, str2);
        }
        hashMap.put("close_friend_space_type", Integer.valueOf(spaceAbsData.space_type.get()));
        String str3 = spaceAbsData.space_id.get();
        Intrinsics.checkNotNullExpressionValue(str3, "spaceData.space_id.get()");
        hashMap.put("close_friend_space_id", str3);
        hashMap.put("update_state", Integer.valueOf(spaceAbsData.has_recent_pub.get() ? 1 : 0));
        if (!mk.d.f416875a.v(this.manageItemBean)) {
            i3 = spaceAbsData.has_checkin_today.get() ? 2 : 1;
        }
        hashMap.put("card_status", Integer.valueOf(i3));
        fo.c.o(this.roundCornerContainer, "em_qz_friend_space_card", new fo.b().l(hashMap).i(spaceAbsData.space_id.get()));
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        i iVar = this.manageItemBean;
        if (iVar != null) {
            c cVar = c.f410300a;
            Intrinsics.checkNotNull(iVar);
            cVar.g(cVar.a(iVar.getSpaceAbsData()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindData(i data, int position, List<Object> payload) {
        this.manageItemBean = data;
        if (data != null) {
            D(data);
            F(this.manageItemBean);
            H(this.manageItemBean);
            B(this.manageItemBean);
            C(this.manageItemBean);
            J(this.manageItemBean);
            y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.f162884n50};
    }

    private final void B(i data) {
        String str;
        String str2;
        if (data == null) {
            return;
        }
        c cVar = c.f410300a;
        String a16 = cVar.a(data.getSpaceAbsData());
        if (!data.getIsNeedUpdateDesc()) {
            String b16 = cVar.b(a16);
            PBStringField pBStringField = data.getSpaceAbsData().title;
            str = pBStringField != null ? pBStringField.get() : null;
            str2 = str != null ? str : "";
            QLog.i("QZIntimateManageSpaceSection", 4, "cacheText is " + b16 + ", latestText is " + str2);
            if (TextUtils.isEmpty(b16)) {
                TextView textView = this.descText;
                if (textView != null) {
                    textView.setText(str2);
                }
                cVar.i(a16, str2);
                return;
            }
            TextView textView2 = this.descText;
            if (textView2 == null) {
                return;
            }
            textView2.setText(b16);
            return;
        }
        PBStringField pBStringField2 = data.getSpaceAbsData().title;
        str = pBStringField2 != null ? pBStringField2.get() : null;
        str2 = str != null ? str : "";
        TextView textView3 = this.descText;
        if (textView3 != null) {
            textView3.setText(str2);
        }
        cVar.i(a16, str2);
        QLog.i("QZIntimateManageSpaceSection", 1, "latestText is " + str2);
    }

    private final void C(i data) {
        if (data == null) {
            return;
        }
        if (mk.d.f416875a.E(data)) {
            ImageView imageView = this.firstLabel;
            if (imageView != null) {
                c.f410300a.l(data.getSpaceAbsData(), imageView, 0);
            }
            ImageView imageView2 = this.secondLabel;
            if (imageView2 != null) {
                c.f410300a.l(data.getSpaceAbsData(), imageView2, 1);
                return;
            }
            return;
        }
        ImageView imageView3 = this.firstLabel;
        if (imageView3 != null) {
            c.f410300a.j(data.getSpaceAbsData(), imageView3);
        }
        ImageView imageView4 = this.secondLabel;
        if (imageView4 != null) {
            c.f410300a.l(data.getSpaceAbsData(), imageView4, 0);
        }
    }

    private final void G(i data) {
        if (data == null) {
            return;
        }
        if (mk.d.f416875a.E(data)) {
            TextView textView = this.updateTag;
            if (textView == null) {
                return;
            }
            textView.setBackground(ContextCompat.getDrawable(p(), R.drawable.f159257));
            return;
        }
        TextView textView2 = this.updateTag;
        if (textView2 == null) {
            return;
        }
        textView2.setBackground(ContextCompat.getDrawable(p(), R.drawable.f162325nz1));
    }

    private final void J(i data) {
        if ((data != null ? data.getVipInfoBean() : null) != null) {
            QZIntimateSpaceVipInfoBean vipInfoBean = data.getVipInfoBean();
            if (!TextUtils.isEmpty(vipInfoBean != null ? vipInfoBean.getManageAvatarUrl() : null)) {
                QZIntimateSpaceVipInfoBean vipInfoBean2 = data.getVipInfoBean();
                com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(vipInfoBean2 != null ? vipInfoBean2.getManageAvatarUrl() : null).setTargetView(this.avatarDecoration).setRequestWidth(ef.d.b(70)).setRegionHeight(ef.d.b(70)).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans), new IPicLoadStateListener() { // from class: jk.d
                    @Override // com.tencent.libra.listener.IPicLoadStateListener
                    public final void onStateChange(LoadState loadState, Option option) {
                        e.K(e.this, loadState, option);
                    }
                });
                return;
            }
        }
        v();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        QZoneIntimateManageInitBean initBean;
        QZoneIntimateManageInitBean initBean2;
        String uid;
        QZIntimateProfileReader$IntimateSpaceAbs spaceAbsData;
        PBStringField pBStringField;
        String str = null;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        boolean z16 = true;
        if ((valueOf == null || valueOf.intValue() != R.id.nev) && (valueOf == null || valueOf.intValue() != R.id.f19094r)) {
            z16 = false;
        }
        if (!z16 || this.manageItemBean == null) {
            return;
        }
        QZoneIntimateMainPageInitBean qZoneIntimateMainPageInitBean = new QZoneIntimateMainPageInitBean();
        i iVar = this.manageItemBean;
        if (iVar != null && (spaceAbsData = iVar.getSpaceAbsData()) != null && (pBStringField = spaceAbsData.space_id) != null) {
            str = pBStringField.get();
        }
        String str2 = "";
        if (str == null) {
            str = "";
        }
        qZoneIntimateMainPageInitBean.setSpaceId(str);
        qZoneIntimateMainPageInitBean.setDraft(mk.d.f416875a.v(this.manageItemBean));
        if (qZoneIntimateMainPageInitBean.getIsDraft()) {
            qZoneIntimateMainPageInitBean.setActivateSpaceBean(x());
        }
        c cVar = c.f410300a;
        i iVar2 = this.manageItemBean;
        Intrinsics.checkNotNull(iVar2);
        QZIntimateProfileReader$IntimateSpaceAbs spaceAbsData2 = iVar2.getSpaceAbsData();
        aw awVar = this.manageViewModel;
        if (awVar != null && (initBean2 = awVar.getInitBean()) != null && (uid = initBean2.getUid()) != null) {
            str2 = uid;
        }
        qZoneIntimateMainPageInitBean.setMember(cVar.e(spaceAbsData2, str2));
        aw awVar2 = this.manageViewModel;
        if (awVar2 != null && (initBean = awVar2.getInitBean()) != null) {
            qZoneIntimateMainPageInitBean.setFrom(initBean.getFrom());
        }
        ck.c o16 = ho.i.o();
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        o16.r(context, qZoneIntimateMainPageInitBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        if (containerView == null) {
            return;
        }
        this.manageViewModel = (aw) t(aw.class);
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) containerView.findViewById(R.id.nev);
        this.roundCornerContainer = roundCorneredFrameLayout;
        if (roundCorneredFrameLayout == null) {
            return;
        }
        if (roundCorneredFrameLayout != null) {
            roundCorneredFrameLayout.setRadius(ef.d.b(8));
        }
        RoundCorneredFrameLayout roundCorneredFrameLayout2 = this.roundCornerContainer;
        if (roundCorneredFrameLayout2 != null) {
            roundCorneredFrameLayout2.setOnClickListener(this);
        }
        this.avatarContainer = (FrameLayout) containerView.findViewById(R.id.f19064o);
        this.avatarDecoration = (ImageView) containerView.findViewById(R.id.f19074p);
        QZoneUserAvatarView qZoneUserAvatarView = (QZoneUserAvatarView) containerView.findViewById(R.id.f19094r);
        this.avatarUser = qZoneUserAvatarView;
        if (qZoneUserAvatarView != null) {
            qZoneUserAvatarView.setOnClickListener(this);
        }
        this.nickname = (TextView) containerView.findViewById(R.id.koa);
        this.labelLayout = (LinearLayout) containerView.findViewById(R.id.f162742kn0);
        this.firstLabel = (ImageView) containerView.findViewById(R.id.lam);
        this.secondLabel = (ImageView) containerView.findViewById(R.id.lan);
        this.descText = (TextView) containerView.findViewById(R.id.nin);
        this.updateTag = (TextView) containerView.findViewById(R.id.njr);
        this.lockIcon = (ImageView) containerView.findViewById(R.id.knw);
        A();
        rn.h.a(this.lockIcon, "qui_lock", R.color.qui_common_icon_secondary);
    }

    private final void D(i data) {
        QZIntimateProfileReader$SpaceThemeInfo qZIntimateProfileReader$SpaceThemeInfo;
        String str;
        List split$default;
        int a16;
        TextView textView;
        if (data == null || (qZIntimateProfileReader$SpaceThemeInfo = data.getSpaceAbsData().space_theme_info.get()) == null) {
            return;
        }
        if (QQTheme.isNowThemeIsNightForQzone()) {
            str = qZIntimateProfileReader$SpaceThemeInfo.card_night_color.get();
        } else {
            str = qZIntimateProfileReader$SpaceThemeInfo.card_daytime_color.get();
        }
        String cardBgColorString = str;
        if (TextUtils.isEmpty(cardBgColorString)) {
            QLog.e("QZIntimateManageSpaceSection", 1, "cardBgColorString is empty");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(cardBgColorString, "cardBgColorString");
        split$default = StringsKt__StringsKt.split$default((CharSequence) cardBgColorString, new String[]{";"}, false, 0, 6, (Object) null);
        String str2 = qZIntimateProfileReader$SpaceThemeInfo.update_lable_color.get();
        ef.a aVar = ef.a.f396213a;
        int a17 = aVar.a((String) split$default.get(0), p().getColor(R.color.qui_common_fill_light_secondary));
        if (split$default.size() == 1) {
            a16 = aVar.a((String) split$default.get(0), p().getColor(R.color.qui_common_fill_light_secondary));
        } else {
            a16 = aVar.a((String) split$default.get(1), p().getColor(R.color.qui_common_fill_light_secondary));
        }
        Drawable c16 = c.f410300a.c(0.5f, 0.0f, 0.5f, ImmersiveUtils.dpToPx(182.0f) * 0.72f, a17, a16, ef.d.b(8), ImmersiveUtils.dpToPx(182.0f));
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.roundCornerContainer;
        if (roundCorneredFrameLayout != null) {
            roundCorneredFrameLayout.setBackground(c16);
        }
        if (!TextUtils.isEmpty(str2) && (textView = this.updateTag) != null) {
            textView.setTextColor(aVar.a(str2, Color.parseColor("#FF80B4")));
        }
        G(data);
    }
}
