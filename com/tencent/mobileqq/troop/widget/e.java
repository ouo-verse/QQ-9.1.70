package com.tencent.mobileqq.troop.widget;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.honor.widget.TroopHonorView;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010;\u001a\u00020\f\u0012\u0006\u0010<\u001a\u00020(\u00a2\u0006\u0004\b=\u0010>R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000eR\u0016\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0004R\u0018\u0010#\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u000eR\u0016\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\u0004R\u0016\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u0004R\u0016\u0010+\u001a\u00020(8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u0004R\u0018\u00103\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u000eR\u0016\u00107\u001a\u0002048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u0002088\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u001a\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/troop/widget/e;", "Lcom/tencent/mobileqq/adapter/k;", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "feedback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "divider", "Lcom/tencent/mobileqq/troop/widget/TroopMemberListSlideItem;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/widget/TroopMemberListSlideItem;", "troopMember", "Landroid/view/View;", "D", "Landroid/view/View;", "slideLeftContent", "E", "delIcon", UserInfo.SEX_FEMALE, "delIconInner", "Lcom/tencent/mobileqq/troop/widget/troopmemberlevel/TroopMemberNewLevelView;", "G", "Lcom/tencent/mobileqq/troop/widget/troopmemberlevel/TroopMemberNewLevelView;", "troopMemberNewLevelView", "H", "troopMemberNewLevelView2", "I", "tvName", "J", "identity", "K", "mRobotMsk", "L", "kickoutBtn", "M", "rightSpace", "N", "mUniqueTitle", "P", "mRightArrow", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "isFromSearchList", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "selectedIcon", ExifInterface.LATITUDE_SOUTH, "remark", "T", "addFrdLayout", "Lcom/tencent/mobileqq/troop/honor/widget/TroopHonorView;", "U", "Lcom/tencent/mobileqq/troop/honor/widget/TroopHonorView;", "honorView", "", "V", "position", "convertView", "showRemark", "<init>", "(Landroid/view/View;Z)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e extends com.tencent.mobileqq.adapter.k {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public TroopMemberListSlideItem troopMember;

    /* renamed from: D, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public View slideLeftContent;

    /* renamed from: E, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public View delIcon;

    /* renamed from: F, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public View delIconInner;

    /* renamed from: G, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public TroopMemberNewLevelView troopMemberNewLevelView;

    /* renamed from: H, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public TroopMemberNewLevelView troopMemberNewLevelView2;

    /* renamed from: I, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public TextView tvName;

    /* renamed from: J, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public TextView identity;

    /* renamed from: K, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public View mRobotMsk;

    /* renamed from: L, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public TextView kickoutBtn;

    /* renamed from: M, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public View rightSpace;

    /* renamed from: N, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public TextView mUniqueTitle;

    /* renamed from: P, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public TextView mRightArrow;

    /* renamed from: Q, reason: from kotlin metadata */
    @JvmField
    public boolean isFromSearchList;

    /* renamed from: R, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public ImageView selectedIcon;

    /* renamed from: S, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public TextView remark;

    /* renamed from: T, reason: from kotlin metadata */
    @JvmField
    @Nullable
    public View addFrdLayout;

    /* renamed from: U, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public TroopHonorView honorView;

    /* renamed from: V, reason: from kotlin metadata */
    @JvmField
    public int position;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public TextView feedback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public TextView divider;

    public e(@NotNull View convertView, boolean z16) {
        Intrinsics.checkNotNullParameter(convertView, "convertView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, convertView, Boolean.valueOf(z16));
            return;
        }
        View findViewById = convertView.findViewById(R.id.f167044k81);
        Intrinsics.checkNotNullExpressionValue(findViewById, "convertView.findViewById(R.id.tv_feedback)");
        this.feedback = (TextView) findViewById;
        View findViewById2 = convertView.findViewById(R.id.k8u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "convertView.findViewById(R.id.tv_index)");
        this.divider = (TextView) findViewById2;
        View findViewById3 = convertView.findViewById(R.id.jzt);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "convertView.findViewById(R.id.troop_member)");
        this.troopMember = (TroopMemberListSlideItem) findViewById3;
        View findViewById4 = convertView.findViewById(R.id.ixj);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "convertView.findViewById(R.id.slide_left_content)");
        this.slideLeftContent = findViewById4;
        View findViewById5 = convertView.findViewById(R.id.bf9);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "convertView.findViewById(R.id.del_icon)");
        this.delIcon = findViewById5;
        View findViewById6 = convertView.findViewById(R.id.bf_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "convertView.findViewById(R.id.del_icon_inner)");
        this.delIconInner = findViewById6;
        this.f187213h = (QQProAvatarView) convertView.findViewById(R.id.dvo);
        this.troopMemberNewLevelView = (TroopMemberNewLevelView) convertView.findViewById(R.id.f102615yd);
        this.troopMemberNewLevelView2 = (TroopMemberNewLevelView) convertView.findViewById(R.id.f102625ye);
        View findViewById7 = convertView.findViewById(R.id.tv_name);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "convertView.findViewById(R.id.tv_name)");
        this.tvName = (TextView) findViewById7;
        this.mRobotMsk = convertView.findViewById(R.id.kab);
        View findViewById8 = convertView.findViewById(R.id.k5_);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "convertView.findViewById(R.id.tv_admin)");
        this.identity = (TextView) findViewById8;
        View findViewById9 = convertView.findViewById(R.id.f164668ai4);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "convertView.findViewById(R.id.btn_kickout)");
        this.kickoutBtn = (TextView) findViewById9;
        this.rightSpace = convertView.findViewById(R.id.ial);
        View findViewById10 = convertView.findViewById(R.id.kii);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "convertView.findViewById(R.id.unique_title)");
        this.mUniqueTitle = (TextView) findViewById10;
        View findViewById11 = convertView.findViewById(R.id.f164472yw);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "convertView.findViewById(R.id.arrow)");
        this.mRightArrow = (TextView) findViewById11;
        View findViewById12 = convertView.findViewById(R.id.ax9);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "convertView.findViewById(R.id.check_selected)");
        this.selectedIcon = (ImageView) findViewById12;
        this.addFrdLayout = convertView.findViewById(R.id.f164020h7);
        View findViewById13 = convertView.findViewById(R.id.mbo);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "convertView.findViewById(R.id.troop_honor_view)");
        this.honorView = (TroopHonorView) findViewById13;
        if (z16) {
            this.remark = (TextView) convertView.findViewById(R.id.i6s);
        }
        this.isFromSearchList = false;
    }
}
