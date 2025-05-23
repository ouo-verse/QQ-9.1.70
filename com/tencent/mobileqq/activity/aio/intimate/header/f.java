package com.tencent.mobileqq.activity.aio.intimate.header;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.component.cache.database.table.photo.LocalPhotoFaceInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelUtils;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.util.w;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import qzone.QZIntimateSpaceRedDotReader$EntranceInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 j2\u00020\u0001:\u0001&B\u001f\u0012\u0006\u0010*\u001a\u00020\u0017\u0012\u0006\u00100\u001a\u00020+\u0012\u0006\u00107\u001a\u00020\n\u00a2\u0006\u0004\bh\u0010iJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0003J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0003J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017H\u0002J\b\u0010\u001a\u001a\u00020\nH\u0002J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u0002J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"J\u0006\u0010%\u001a\u00020\u0002R\u0017\u0010*\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u00100\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u00107\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010-R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010>R\u0016\u0010B\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010AR\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010AR\u0016\u0010F\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010ER\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010ER\u0016\u0010H\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010>R\u0016\u0010I\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010AR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010KR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010KR\u0016\u0010N\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010-R\u0016\u0010O\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010KR\u0016\u0010P\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010KR\u0016\u0010Q\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010AR\u0016\u0010T\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010SR\u0016\u0010U\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010KR\u0016\u0010W\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010AR\u0016\u0010Y\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010KR\u0016\u0010[\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010-R\u0016\u0010]\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010KR\u0016\u0010`\u001a\u00020^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010_R\u0016\u0010b\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010aR\u001c\u0010g\u001a\b\u0012\u0004\u0012\u00020d0c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010f\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/header/f;", "", "", "e", "", "type", "level", "beFriendDay", "realDay", LocalPhotoFaceInfo.SCORE, "", "extendName", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "friendIntimateType", "y", "t", tl.h.F, "k", "i", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "url", "p", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/activity/aio/intimate/header/g;", "model", DomainData.DOMAIN_NAME, "Lqzone/QZIntimateSpaceRedDotReader$EntranceInfo;", "entranceInfo", "r", ReportConstant.COSTREPORT_PREFIX, "", "Landroid/view/ViewGroup;", "g", "o", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/view/View;", "b", "Landroid/view/View;", "f", "()Landroid/view/View;", "mRootView", "c", "Ljava/lang/String;", "getFriendUin", "()Ljava/lang/String;", "setFriendUin", "(Ljava/lang/String;)V", "friendUin", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "mCardView", "mCardRootBgView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mCardIconView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "selfHeadContainer", "friendHeadContainer", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "selfHeadIV", "friendHeadIV", "mCardBgView", "mTextArea", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mFirstLineTextZeroDay", "mSecondLineTextZeroDay", "mFirstLine", "mFirstLineText", "mFirstLineExtend", "mSecondLine", "Lcom/tencent/mobileqq/kandian/base/view/widget/ticker/TickerView;", "Lcom/tencent/mobileqq/kandian/base/view/widget/ticker/TickerView;", "mSecondLineFirstText", "mSecondLineSecondText", "u", "mFirstLabel", "v", "mFirstLabelFirstText", "w", "mFirstLabelBorder", HippyTKDListViewAdapter.X, "mFirstLabelSecondText", "Lcom/tencent/mobileqq/activity/aio/intimate/header/QZoneIntimateSpaceEntranceView;", "Lcom/tencent/mobileqq/activity/aio/intimate/header/QZoneIntimateSpaceEntranceView;", "mQZoneQZoneIntimateSpaceEntrance", "Lcom/tencent/mobileqq/activity/aio/intimate/header/g;", "mModel", "", "Lcom/tencent/mobileqq/activity/aio/intimate/header/o;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "[Lcom/tencent/mobileqq/activity/aio/intimate/header/o;", "mBizCardAdapterList", "<init>", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/String;)V", "B", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f {

    /* renamed from: A, reason: from kotlin metadata */
    @NotNull
    private o[] mBizCardAdapterList;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mRootView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String friendUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RelativeLayout mCardView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mCardRootBgView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView mCardIconView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout selfHeadContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout friendHeadContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QQProAvatarView selfHeadIV;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QQProAvatarView friendHeadIV;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView mCardBgView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout mTextArea;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mFirstLineTextZeroDay;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mSecondLineTextZeroDay;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mFirstLine;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mFirstLineText;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mFirstLineExtend;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout mSecondLine;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TickerView mSecondLineFirstText;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mSecondLineSecondText;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout mFirstLabel;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mFirstLabelFirstText;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mFirstLabelBorder;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView mFirstLabelSecondText;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QZoneIntimateSpaceEntranceView mQZoneQZoneIntimateSpaceEntrance;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private g mModel;

    public f(@NotNull Context context, @NotNull View mRootView, @NotNull String friendUin) {
        RelativeLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mRootView, "mRootView");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        this.context = context;
        this.mRootView = mRootView;
        this.friendUin = friendUin;
        View findViewById = mRootView.findViewById(R.id.xpv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.intimate_header_card)");
        this.mCardView = (RelativeLayout) findViewById;
        View findViewById2 = mRootView.findViewById(R.id.xpx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026mate_header_card_root_bg)");
        this.mCardRootBgView = findViewById2;
        View findViewById3 = mRootView.findViewById(R.id.xq6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.intimate_header_icon)");
        this.mCardIconView = (ImageView) findViewById3;
        View findViewById4 = mRootView.findViewById(R.id.f82914i6);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R\u2026d.self_head_iv_container)");
        this.selfHeadContainer = (LinearLayout) findViewById4;
        View findViewById5 = mRootView.findViewById(R.id.vf5);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R\u2026friend_head_iv_container)");
        this.friendHeadContainer = (LinearLayout) findViewById5;
        View findViewById6 = mRootView.findViewById(R.id.imu);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.self_head_iv)");
        this.selfHeadIV = (QQProAvatarView) findViewById6;
        View findViewById7 = mRootView.findViewById(R.id.cnr);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.friend_head_iv)");
        this.friendHeadIV = (QQProAvatarView) findViewById7;
        View findViewById8 = mRootView.findViewById(R.id.xpw);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R\u2026.intimate_header_card_bg)");
        this.mCardBgView = (ImageView) findViewById8;
        View findViewById9 = mRootView.findViewById(R.id.xqe);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R\u2026ntimate_header_text_area)");
        this.mTextArea = (LinearLayout) findViewById9;
        View findViewById10 = mRootView.findViewById(R.id.f165833xq3);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "mRootView.findViewById(R\u2026e_header_first_line_0day)");
        this.mFirstLineTextZeroDay = (TextView) findViewById10;
        View findViewById11 = mRootView.findViewById(R.id.xq8);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "mRootView.findViewById(R\u2026_header_second_line_0day)");
        this.mSecondLineTextZeroDay = (TextView) findViewById11;
        View findViewById12 = mRootView.findViewById(R.id.f165832xq2);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "mRootView.findViewById(R\u2026timate_header_first_line)");
        this.mFirstLine = findViewById12;
        View findViewById13 = mRootView.findViewById(R.id.xq5);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "mRootView.findViewById(R\u2026e_header_first_line_text)");
        this.mFirstLineText = (TextView) findViewById13;
        View findViewById14 = mRootView.findViewById(R.id.f165834xq4);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "mRootView.findViewById(R\u2026header_first_line_extend)");
        this.mFirstLineExtend = (TextView) findViewById14;
        View findViewById15 = mRootView.findViewById(R.id.xq7);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "mRootView.findViewById(R\u2026imate_header_second_line)");
        this.mSecondLine = (LinearLayout) findViewById15;
        View findViewById16 = mRootView.findViewById(R.id.xq9);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "mRootView.findViewById(R\u2026eader_second_line_bignum)");
        this.mSecondLineFirstText = (TickerView) findViewById16;
        View findViewById17 = mRootView.findViewById(R.id.xq_);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "mRootView.findViewById(R\u2026_header_second_line_text)");
        this.mSecondLineSecondText = (TextView) findViewById17;
        View findViewById18 = mRootView.findViewById(R.id.xpy);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "mRootView.findViewById(R\u2026imate_header_first_label)");
        this.mFirstLabel = (LinearLayout) findViewById18;
        View findViewById19 = mRootView.findViewById(R.id.f165830xq0);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "mRootView.findViewById(R\u2026r_first_label_first_text)");
        this.mFirstLabelFirstText = (TextView) findViewById19;
        View findViewById20 = mRootView.findViewById(R.id.xpz);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "mRootView.findViewById(R\u2026eader_first_label_border)");
        this.mFirstLabelBorder = findViewById20;
        View findViewById21 = mRootView.findViewById(R.id.f165831xq1);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "mRootView.findViewById(R\u2026_first_label_second_text)");
        this.mFirstLabelSecondText = (TextView) findViewById21;
        View findViewById22 = mRootView.findViewById(R.id.xqw);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "mRootView.findViewById(R\u2026ne_space_header_entrance)");
        this.mQZoneQZoneIntimateSpaceEntrance = (QZoneIntimateSpaceEntranceView) findViewById22;
        this.mBizCardAdapterList = new o[]{new o(mRootView)};
        ViewGroup.LayoutParams layoutParams2 = this.mTextArea.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.topMargin = 0;
            layoutParams.addRule(15);
        }
        this.mSecondLineFirstText.setCharacterLists("9876543210");
        this.mSecondLineFirstText.setAnimationDuration(2000L);
        this.selfHeadIV.x(1, m(), null);
        this.friendHeadIV.x(1, this.friendUin, null);
        if (ThemeUtil.isVasDarkTheme() || com.tencent.biz.qui.quicommon.a.b(BaseApplication.getContext().getResources().getColor(R.color.qui_common_bg_bottom_standard))) {
            this.mCardBgView.setAlpha(0.1f);
        }
        if (QQTheme.isVasTheme()) {
            this.mCardRootBgView.setBackgroundResource(R.drawable.juh);
        }
        if (FontSettingManager.getFontLevel() > 17.0f) {
            e();
        }
    }

    private final void e() {
        AudioPanelUtils.c(this.mCardIconView);
        ViewGroup.LayoutParams layoutParams = this.mCardIconView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.rightMargin = this.context.getResources().getDimensionPixelSize(R.dimen.f158715n5);
        this.mCardIconView.setLayoutParams(layoutParams2);
        AudioPanelUtils.c(this.selfHeadContainer);
        AudioPanelUtils.c(this.friendHeadContainer);
        ViewGroup.LayoutParams layoutParams3 = this.friendHeadContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
        layoutParams4.rightMargin = this.context.getResources().getDimensionPixelSize(R.dimen.c_a);
        this.friendHeadContainer.setLayoutParams(layoutParams4);
        ViewGroup.LayoutParams layoutParams5 = this.selfHeadContainer.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) layoutParams5;
        layoutParams6.rightMargin = this.context.getResources().getDimensionPixelSize(R.dimen.f158700mp);
        this.selfHeadContainer.setLayoutParams(layoutParams6);
    }

    private final void h() {
        g gVar = this.mModel;
        g gVar2 = null;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
            gVar = null;
        }
        QLog.i("IntimateHeaderCardHolder", 1, "handleCardClick,type=" + gVar.getType());
        g gVar3 = this.mModel;
        if (gVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
        } else {
            gVar2 = gVar3;
        }
        String f16 = IntimateHeaderCardUtil.f(gVar2.getType(), this.friendUin);
        if (!TextUtils.isEmpty(f16)) {
            this.context.startActivity(new Intent(this.context, (Class<?>) QQBrowserActivity.class).putExtra("url", f16));
        }
    }

    private final void i() {
        AllInOne allInOne = new AllInOne(this.friendUin, 1);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 2);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 23);
        ProfileUtils.openProfileCard(l(), allInOne);
    }

    private final void j() {
        boolean contains$default;
        boolean contains$default2;
        String url;
        String url2;
        String str = this.friendUin;
        g gVar = this.mModel;
        if (gVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
            gVar = null;
        }
        int type = gVar.getType();
        if (com.tencent.mobileqq.activity.aio.intimate.e.e(type)) {
            String url3 = FriendIntimateRelationshipHelper.p();
            if (!TextUtils.isEmpty(url3)) {
                Intrinsics.checkNotNullExpressionValue(url3, "url");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) url3, (CharSequence) "frd_uin=", false, 2, (Object) null);
                if (contains$default) {
                    Intrinsics.checkNotNullExpressionValue(url3, "url");
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url3, (CharSequence) "frd_type=", false, 2, (Object) null);
                    if (contains$default2) {
                        Intrinsics.checkNotNullExpressionValue(url3, "url");
                        url = StringsKt__StringsJVMKt.replace$default(url3, "frd_uin=", "frd_uin=" + str, false, 4, (Object) null);
                        Intrinsics.checkNotNullExpressionValue(url, "url");
                        url2 = StringsKt__StringsJVMKt.replace$default(url, "frd_type=", "frd_type=" + type, false, 4, (Object) null);
                        q(type);
                        Intrinsics.checkNotNullExpressionValue(url2, "url");
                        p(url2);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (type == 0) {
            String url4 = FriendIntimateRelationshipHelper.b(str);
            q(type);
            Intrinsics.checkNotNullExpressionValue(url4, "url");
            p(url4);
        }
    }

    private final void k() {
        AllInOne allInOne = new AllInOne(m(), 0);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 2);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 23);
        ProfileUtils.openProfileCard(l(), allInOne);
    }

    private final Context l() {
        return this.mCardView.getContext();
    }

    private final String m() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return "";
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
        return currentAccountUin;
    }

    private final void p(String url) {
        if (TextUtils.isEmpty(url) || !w.a(1000L)) {
            return;
        }
        Intent intent = new Intent(this.context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        this.context.startActivity(intent);
    }

    private final void q(int friendIntimateType) {
        if (friendIntimateType != 1) {
            if (friendIntimateType != 2) {
                if (friendIntimateType != 3) {
                    if (friendIntimateType != 26) {
                        ReportController.o(null, "dc00898", "", "", "0X800B565", "0X800B565", 4, 0, "", "", "", "");
                        return;
                    } else {
                        ReportController.o(null, "dc00898", "", "", "0X800B565", "0X800B565", 5, 0, "", "", "", "");
                        return;
                    }
                }
                ReportController.o(null, "dc00898", "", "", "0X800B565", "0X800B565", 3, 0, "", "", "", "");
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X800B565", "0X800B565", 2, 0, "", "", "", "");
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800B565", "0X800B565", 1, 0, "", "", "", "");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void t() {
        g gVar = this.mModel;
        if (gVar != null) {
            if (gVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mModel");
                gVar = null;
            }
            if (!IntimateHeaderCardUtil.O(gVar.getType())) {
                g gVar2 = this.mModel;
                if (gVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mModel");
                    gVar2 = null;
                }
                if (gVar2.getType() != 0) {
                    this.mFirstLabel.setClickable(false);
                    this.mFirstLabel.setOnClickListener(null);
                    this.mFirstLabel.setOnTouchListener(null);
                }
            }
        }
        this.mCardView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.header.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.u(f.this, view);
            }
        });
        this.mFirstLabel.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.header.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.v(f.this, view);
            }
        });
        this.selfHeadIV.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.header.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.w(f.this, view);
            }
        });
        this.friendHeadIV.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.aio.intimate.header.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.x(f.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(f this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y(int friendIntimateType, int level) {
        int color;
        String q16 = IntimateHeaderCardUtil.q(friendIntimateType);
        if (q16 == null) {
            IntimateHeaderCardUtil.X(this.mCardBgView, IntimateHeaderCardUtil.b(0), new ColorDrawable(0));
            return;
        }
        try {
            color = Color.parseColor(q16);
        } catch (Exception unused) {
            color = this.context.getResources().getColor(R.color.qui_common_text_primary, null);
        }
        if (!QQTheme.isVasTheme()) {
            this.mFirstLineTextZeroDay.setTextColor(color);
            this.mSecondLineTextZeroDay.setTextColor(color);
            this.mFirstLineText.setTextColor(color);
            this.mFirstLineExtend.setTextColor(color);
            this.mSecondLineFirstText.setTextColor(color);
            this.mSecondLineSecondText.setTextColor(color);
            this.mFirstLabelFirstText.setTextColor(color);
            this.mFirstLabelSecondText.setTextColor(color);
            TextView textView = this.mFirstLineExtend;
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(Color.argb(38, Color.red(color), Color.green(color), Color.blue(color)));
            gradientDrawable.setCornerRadius(ViewUtils.dpToPx(4.0f));
            textView.setBackground(gradientDrawable);
            LinearLayout linearLayout = this.mFirstLabel;
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setColor(Color.argb(38, Color.red(color), Color.green(color), Color.blue(color)));
            gradientDrawable2.setCornerRadius(ViewUtils.dpToPx(4.0f));
            linearLayout.setBackground(gradientDrawable2);
        }
        IntimateHeaderCardUtil.X(this.mCardIconView, IntimateHeaderCardUtil.c(friendIntimateType, level), new ColorDrawable(0));
        IntimateHeaderCardUtil.X(this.mCardBgView, IntimateHeaderCardUtil.b(friendIntimateType), new ColorDrawable(0));
    }

    @SuppressLint({"SetTextI18n"})
    private final void z(int type, int level, int beFriendDay, int realDay, int score, String extendName) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        TextView textView = this.mFirstLineTextZeroDay;
        boolean z16 = true;
        if (realDay <= 1) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        TextView textView2 = this.mSecondLineTextZeroDay;
        if (realDay <= 1) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        textView2.setVisibility(i16);
        View view = this.mFirstLine;
        if (realDay <= 1) {
            i17 = 8;
        } else {
            i17 = 0;
        }
        view.setVisibility(i17);
        LinearLayout linearLayout = this.mSecondLine;
        if (realDay <= 1) {
            i18 = 8;
        } else {
            i18 = 0;
        }
        linearLayout.setVisibility(i18);
        this.mSecondLineTextZeroDay.setText(HardCodeUtil.qqStr(R.string.f161071wq) + IntimateHeaderCardUtil.o(type, level));
        this.mFirstLineText.setText(IntimateHeaderCardUtil.p(type, level));
        TextView textView3 = this.mFirstLineExtend;
        if (extendName.length() != 0) {
            z16 = false;
        }
        if (z16) {
            i19 = 8;
        } else {
            i19 = 0;
        }
        textView3.setVisibility(i19);
        this.mFirstLineExtend.setText(extendName);
        this.mSecondLineFirstText.setText(String.valueOf(beFriendDay), false);
        if (score > 0) {
            this.mFirstLabel.setVisibility(0);
            this.mFirstLabelSecondText.setText(score + "\u5206");
            return;
        }
        this.mFirstLabel.setVisibility(8);
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final View getMRootView() {
        return this.mRootView;
    }

    @NotNull
    public final List<ViewGroup> g() {
        List<ViewGroup> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ViewGroup[]{this.selfHeadIV, this.friendHeadIV, this.mFirstLabel});
        return listOf;
    }

    public final void n(@NotNull g model) {
        g gVar;
        Intrinsics.checkNotNullParameter(model, "model");
        this.mModel = model;
        RelativeLayout relativeLayout = this.mCardView;
        if (model == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
            gVar = null;
        } else {
            gVar = model;
        }
        relativeLayout.setTag(Integer.valueOf(gVar.getType()));
        g gVar2 = this.mModel;
        if (gVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
            gVar2 = null;
        }
        int type = gVar2.getType();
        int level = model.getLevel();
        g gVar3 = this.mModel;
        if (gVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
            gVar3 = null;
        }
        int days = gVar3.getDays();
        g gVar4 = this.mModel;
        if (gVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
            gVar4 = null;
        }
        int realDays = gVar4.getRealDays();
        g gVar5 = this.mModel;
        if (gVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
            gVar5 = null;
        }
        int scores = gVar5.getScores();
        g gVar6 = this.mModel;
        if (gVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
            gVar6 = null;
        }
        z(type, level, days, realDays, scores, gVar6.getExtendName());
        g gVar7 = this.mModel;
        if (gVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
            gVar7 = null;
        }
        int type2 = gVar7.getType();
        g gVar8 = this.mModel;
        if (gVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mModel");
            gVar8 = null;
        }
        y(type2, gVar8.getLevel());
        t();
        o[] oVarArr = this.mBizCardAdapterList;
        ArrayList<o> arrayList = new ArrayList();
        for (o oVar : oVarArr) {
            g gVar9 = this.mModel;
            if (gVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mModel");
                gVar9 = null;
            }
            if (oVar.a(gVar9.getType())) {
                arrayList.add(oVar);
            }
        }
        for (o oVar2 : arrayList) {
            g gVar10 = this.mModel;
            if (gVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mModel");
                gVar10 = null;
            }
            oVar2.b(gVar10);
        }
        this.mQZoneQZoneIntimateSpaceEntrance.setIntimateHeaderType(model.getType());
    }

    public final void o() {
        this.mQZoneQZoneIntimateSpaceEntrance.r0();
    }

    public final void r(@NotNull QZIntimateSpaceRedDotReader$EntranceInfo entranceInfo) {
        Intrinsics.checkNotNullParameter(entranceInfo, "entranceInfo");
        this.mQZoneQZoneIntimateSpaceEntrance.setData(entranceInfo);
    }

    public final void s() {
        RelativeLayout.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = ((RelativeLayout) this.mRootView.findViewById(R.id.xpv)).getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.height = -2;
            layoutParams.bottomMargin = this.mRootView.getResources().getDimensionPixelSize(R.dimen.f158700mp);
        }
        this.mCardIconView.setVisibility(8);
        this.mCardBgView.setVisibility(8);
        this.mCardRootBgView.setVisibility(8);
    }
}
