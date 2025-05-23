package com.qzone.reborn.feedpro.section;

import android.app.Activity;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.feedx.event.QZoneFeedxDetailAnimEvent;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMusic;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserDesc;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.CommonFeedExtKt;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.util.QzoneBitCheckUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ,2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001MB\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J$\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00150\u0014j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0015`\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u001c\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u001d\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010 \u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020\u0004H\u0002J\u0012\u0010!\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\"\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010#\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u0010%\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010$\u001a\u00020\bH\u0002J.\u0010,\u001a\u00020+2\b\b\u0001\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00042\b\b\u0002\u0010(\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020)H\u0002J&\u00101\u001a\u0002002\b\b\u0002\u0010-\u001a\u00020\u00042\b\b\u0003\u0010.\u001a\u00020\u00062\b\b\u0002\u0010/\u001a\u00020\u0006H\u0002J\u0012\u00102\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u00104\u001a\u0004\u0018\u000103H\u0002J\u0010\u00105\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0003H\u0002R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010FR\u0018\u0010J\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006N"}, d2 = {"Lcom/qzone/reborn/feedpro/section/QzoneFeedProHeadSection;", "Lne/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/qzone/reborn/feedx/event/QZoneFeedxDetailAnimEvent;", "", tl.h.F, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "u", "Landroid/view/View;", "containerView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeed;", "feedData", HippyTKDListViewAdapter.X, "w", "y", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "X", "Y", "Z", "view", "elementId", "M", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "T", "V", "isMusic", "N", "defaultIconRes", "iconUrl", "sizeDp", "Landroid/widget/ImageView$ScaleType;", "scaleType", "Landroid/widget/ImageView;", "K", "text", "colorRes", "textSizeDp", "Landroid/widget/TextView;", "I", BdhLogUtil.LogTag.Tag_Req, "Lre/b;", "O", "P", "Landroidx/constraintlayout/widget/ConstraintLayout;", "E", "Landroidx/constraintlayout/widget/ConstraintLayout;", "titleRoot", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "avatar", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "G", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "nickname", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "hintContainer", "Landroid/widget/ImageView;", "moreIcon", "J", "Landroid/view/View;", "topFlag", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProHeadSection extends ne.a implements SimpleEventReceiver<QZoneFeedxDetailAnimEvent> {

    /* renamed from: E, reason: from kotlin metadata */
    private ConstraintLayout titleRoot;

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneUserAvatarView avatar;

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneNickNameView nickname;

    /* renamed from: H, reason: from kotlin metadata */
    private LinearLayout hintContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView moreIcon;

    /* renamed from: J, reason: from kotlin metadata */
    private View topFlag;

    private final TextView I(String text, int colorRes, int textSizeDp) {
        TextView textView = new TextView(getActivity());
        textView.setId(View.generateViewId());
        textView.setText(text);
        textView.setTextSize(1, textSizeDp);
        Activity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        textView.setTextColor(activity.getColor(colorRes));
        textView.setIncludeFontPadding(false);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private final ImageView K(int defaultIconRes, String iconUrl, int sizeDp, ImageView.ScaleType scaleType) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setId(View.generateViewId());
        imageView.setScaleType(scaleType);
        if (TextUtils.isEmpty(iconUrl)) {
            Option targetView = Option.obtain().setUrl(iconUrl).setTargetView(imageView);
            com.qzone.reborn.util.r rVar = com.qzone.reborn.util.r.f59560a;
            com.tencent.mobileqq.qzone.picload.c.a().h(targetView.setRequestWidth(rVar.e(sizeDp)).setRequestHeight(rVar.e(sizeDp)));
        } else {
            imageView.setImageResource(defaultIconRes);
        }
        com.qzone.reborn.util.r rVar2 = com.qzone.reborn.util.r.f59560a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(rVar2.e(sizeDp), rVar2.e(sizeDp));
        layoutParams.gravity = 16;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    private final void M(View view, String elementId) {
        fo.c.o(view, elementId, new fo.b().l(new LinkedHashMap()).i(CommonFeedExtKt.getFeedUniqueKey(getMFeedData())).k(ExposurePolicy.REPORT_NONE).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_ALL));
    }

    private final void N(View view, boolean isMusic) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tag_type", Integer.valueOf(isMusic ? 1 : 0));
        fo.c.o(view, "em_qz_feed_sign", new fo.b().l(linkedHashMap).i(CommonFeedExtKt.getFeedUniqueKey(getMFeedData())).k(ExposurePolicy.REPORT_ALL).j(EndExposurePolicy.REPORT_NONE).g(ClickPolicy.REPORT_NONE));
    }

    private final re.b O() {
        return (re.b) p(re.b.class);
    }

    private final void P(QZoneFeedxDetailAnimEvent event) {
        if (event.getIsAnimPlaying()) {
            QZoneNickNameView qZoneNickNameView = this.nickname;
            if (qZoneNickNameView != null) {
                qZoneNickNameView.setEnableFlash(false);
                return;
            }
            return;
        }
        QZoneNickNameView qZoneNickNameView2 = this.nickname;
        if (qZoneNickNameView2 != null) {
            qZoneNickNameView2.setEnableFlash(true);
        }
    }

    private final boolean Q(CommonFeed feedData) {
        LinearLayout linearLayout = this.hintContainer;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        return T(feedData) || V(feedData);
    }

    private final void R(final CommonFeed feedData) {
        if (com.qzone.reborn.feedx.util.x.f55790a.c(n())) {
            ImageView imageView = this.moreIcon;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.moreIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        if (CommonFeedExtKt.isFakeFeed(feedData)) {
            ImageView imageView3 = this.moreIcon;
            if (imageView3 != null) {
                imageView3.setAlpha(0.3f);
            }
            ImageView imageView4 = this.moreIcon;
            if (imageView4 == null) {
                return;
            }
            imageView4.setEnabled(false);
            return;
        }
        ImageView imageView5 = this.moreIcon;
        if (imageView5 != null) {
            imageView5.setAlpha(1.0f);
        }
        ImageView imageView6 = this.moreIcon;
        if (imageView6 != null) {
            imageView6.setEnabled(true);
        }
        ImageView imageView7 = this.moreIcon;
        if (imageView7 != null) {
            imageView7.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.ae
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QzoneFeedProHeadSection.S(QzoneFeedProHeadSection.this, feedData, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(QzoneFeedProHeadSection this$0, CommonFeed commonFeed, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        re.b O = this$0.O();
        if (O != null) {
            O.W1(commonFeed);
        }
        re.b O2 = this$0.O();
        MutableLiveData<Boolean> O1 = O2 != null ? O2.O1() : null;
        if (O1 != null) {
            O1.setValue(Boolean.TRUE);
        }
        fo.c.b("dt_clck", this$0.moreIcon, "em_qz_feed_more_btn", null);
    }

    private final boolean T(final CommonFeed feedData) {
        CommonCellMusic cellMusic;
        String icon;
        CommonCellMusic cellMusic2;
        String name;
        String str = (feedData == null || (cellMusic2 = feedData.getCellMusic()) == null || (name = cellMusic2.getName()) == null) ? "" : name;
        QLog.i("QzoneFeedProHeadSection", 1, "music name is " + str + ", uf key is " + CommonFeedExtKt.getFeedUniqueKey(feedData));
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ImageView L = L(this, R.drawable.f16155l, (feedData == null || (cellMusic = feedData.getCellMusic()) == null || (icon = cellMusic.getIcon()) == null) ? "" : icon, 0, null, 12, null);
        TextView J = J(this, str, 0, 0, 6, null);
        Activity activity = getActivity();
        if (activity != null) {
            J.setMaxWidth(xd.c.j(activity) - com.qzone.reborn.util.r.f59560a.e(12));
        }
        LinearLayout linearLayout = this.hintContainer;
        if (linearLayout != null) {
            xd.c.b(linearLayout, L, J);
        }
        LinearLayout linearLayout2 = this.hintContainer;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.ag
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QzoneFeedProHeadSection.U(QzoneFeedProHeadSection.this, feedData, view);
                }
            });
        }
        N(this.hintContainer, true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(QzoneFeedProHeadSection this$0, CommonFeed commonFeed, View view) {
        CommonCellMusic cellMusic;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ho.i.s(this$0.getActivity(), (commonFeed == null || (cellMusic = commonFeed.getCellMusic()) == null) ? null : cellMusic.getActionUrl(), true);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tag_type", 1);
        fo.c.b("dt_clck", this$0.hintContainer, "em_qz_feed_sign", new fo.b().l(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(QzoneFeedProHeadSection this$0, CommonFeed commonFeed, TextView view, View view2) {
        CommonCellUserDesc cellUserDesc;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        ho.i.s(this$0.getActivity(), (commonFeed == null || (cellUserDesc = commonFeed.getCellUserDesc()) == null) ? null : cellUserDesc.getActionUrl(), true);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("tag_type", 0);
        fo.c.b("dt_clck", view, "em_qz_feed_sign", new fo.b().l(linkedHashMap));
    }

    private final void X(CommonFeed feedData) {
        CommonCellCommon cellCommon;
        View view = this.topFlag;
        if (view != null) {
            if ((feedData == null || (cellCommon = feedData.getCellCommon()) == null) ? false : QzoneBitCheckUtil.INSTANCE.checkBitEnabled(cellCommon.getFeatureFlag(), 1)) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    private final void Y(CommonFeed feedData) {
        CommonCellUserInfo cellUserInfo;
        CommonUser user;
        String uin;
        QZoneUserAvatarView qZoneUserAvatarView = this.avatar;
        if (qZoneUserAvatarView != null) {
            if (feedData != null && (cellUserInfo = feedData.getCellUserInfo()) != null && (user = cellUserInfo.getUser()) != null && (uin = user.getUin()) != null) {
                qZoneUserAvatarView.setUser(ef.d.k(uin));
                com.qzone.reborn.feedpro.utils.aa.i(com.qzone.reborn.feedpro.utils.aa.f54263a, qZoneUserAvatarView, getActivity(), 0, true, 2, null);
            }
            M(qZoneUserAvatarView, "em_qz_feed_avatar");
        }
    }

    private final void Z(final CommonFeed feedData) {
        CommonCellUserInfo cellUserInfo;
        CommonUser user;
        QZoneNickNameView qZoneNickNameView = this.nickname;
        String str = null;
        Paint paint = qZoneNickNameView != null ? qZoneNickNameView.getPaint() : null;
        if (paint != null) {
            paint.setShader(null);
        }
        QZoneNickNameView qZoneNickNameView2 = this.nickname;
        if (qZoneNickNameView2 != null) {
            if (feedData != null && (cellUserInfo = feedData.getCellUserInfo()) != null && (user = cellUserInfo.getUser()) != null) {
                str = user.getNick();
            }
            if (str == null) {
                str = "";
            }
            qZoneNickNameView2.setText(str);
        }
        QZoneNickNameView qZoneNickNameView3 = this.nickname;
        if (qZoneNickNameView3 != null) {
            qZoneNickNameView3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.ad
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QzoneFeedProHeadSection.a0(CommonFeed.this, this, view);
                }
            });
        }
        if (!Q(feedData)) {
            ConstraintLayout constraintLayout = this.titleRoot;
            if (constraintLayout != null) {
                xd.c.c(constraintLayout, new Function1<ConstraintSet, Unit>() { // from class: com.qzone.reborn.feedpro.section.QzoneFeedProHeadSection$initUserNickname$2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ConstraintSet constraintSet) {
                        invoke2(constraintSet);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ConstraintSet applyConstraintSet) {
                        Intrinsics.checkNotNullParameter(applyConstraintSet, "$this$applyConstraintSet");
                        applyConstraintSet.connect(R.id.ay7, 4, 0, 4);
                    }
                });
                return;
            }
            return;
        }
        ConstraintLayout constraintLayout2 = this.titleRoot;
        if (constraintLayout2 != null) {
            xd.c.c(constraintLayout2, new Function1<ConstraintSet, Unit>() { // from class: com.qzone.reborn.feedpro.section.QzoneFeedProHeadSection$initUserNickname$3
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ConstraintSet constraintSet) {
                    invoke2(constraintSet);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ConstraintSet applyConstraintSet) {
                    Intrinsics.checkNotNullParameter(applyConstraintSet, "$this$applyConstraintSet");
                    applyConstraintSet.connect(R.id.ay7, 4, R.id.ewl, 3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(CommonFeed commonFeed, QzoneFeedProHeadSection this$0, View view) {
        CommonCellUserInfo cellUserInfo;
        CommonUser user;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long k3 = ef.d.k((commonFeed == null || (cellUserInfo = commonFeed.getCellUserInfo()) == null || (user = cellUserInfo.getUser()) == null) ? null : user.getUin());
        if (k3 > 0) {
            ho.i.z().m(this$0.getActivity(), k3);
        }
        fo.c.b("dt_clck", this$0.nickname, "em_qz_feed_nickname", null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZoneFeedxDetailAnimEvent>> getEventClass() {
        ArrayList<Class<QZoneFeedxDetailAnimEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneFeedxDetailAnimEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ne.a
    /* renamed from: h */
    public String getTAG() {
        return "QzoneFeedProHeadSection";
    }

    @Override // ne.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        QZoneNickNameView qZoneNickNameView = this.nickname;
        if (qZoneNickNameView != null) {
            qZoneNickNameView.j();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneFeedxDetailAnimEvent) {
            P((QZoneFeedxDetailAnimEvent) event);
        }
    }

    @Override // ne.a
    protected int q() {
        return R.id.noc;
    }

    @Override // ne.a
    protected boolean u() {
        return false;
    }

    @Override // ne.a
    public void w() {
        super.w();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // ne.a
    protected void x(CommonFeed feedData) {
        if (getActivity() != null) {
            Y(feedData);
            Z(feedData);
            R(feedData);
            X(feedData);
        }
    }

    @Override // ne.a
    public void y() {
        super.y();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // ne.a
    protected void z(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.titleRoot = (ConstraintLayout) containerView.findViewById(R.id.mxf);
        this.avatar = (QZoneUserAvatarView) containerView.findViewById(R.id.f162732ex1);
        QZoneNickNameView qZoneNickNameView = (QZoneNickNameView) containerView.findViewById(R.id.ay7);
        if (qZoneNickNameView != null) {
            Activity activity = getActivity();
            if (activity != null) {
                qZoneNickNameView.setMaxWidth(xd.c.j(activity));
            }
        } else {
            qZoneNickNameView = null;
        }
        this.nickname = qZoneNickNameView;
        if (qZoneNickNameView != null) {
            qZoneNickNameView.setTextBold(true);
        }
        QZoneNickNameView qZoneNickNameView2 = this.nickname;
        if (qZoneNickNameView2 != null) {
            com.qzone.reborn.feedpro.utils.aa.m(com.qzone.reborn.feedpro.utils.aa.f54263a, qZoneNickNameView2, 0.0f, 1, null);
        }
        this.hintContainer = (LinearLayout) containerView.findViewById(R.id.ewl);
        ImageView imageView = (ImageView) containerView.findViewById(R.id.axl);
        this.moreIcon = imageView;
        if (imageView != null) {
            zm.b.b(imageView, com.qzone.reborn.util.r.f59560a.e(4));
        }
        ImageView imageView2 = this.moreIcon;
        if (imageView2 != null) {
            com.qzone.reborn.feedpro.utils.aa.c(com.qzone.reborn.feedpro.utils.aa.f54263a, imageView2, 0.0f, 1, null);
        }
        this.topFlag = containerView.findViewById(R.id.mvy);
    }

    private final boolean V(final CommonFeed feedData) {
        String str;
        CommonCellUserDesc cellUserDesc;
        if (feedData == null || (cellUserDesc = feedData.getCellUserDesc()) == null || (str = cellUserDesc.getDesc()) == null) {
            str = "";
        }
        String str2 = str;
        QLog.i("QzoneFeedProHeadSection", 1, "user desc is " + str2 + ", uf key is " + CommonFeedExtKt.getFeedUniqueKey(feedData));
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        final TextView J = J(this, str2, 0, 0, 6, null);
        Activity activity = getActivity();
        if (activity != null) {
            J.setMaxWidth(xd.c.j(activity));
        }
        J.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.section.af
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QzoneFeedProHeadSection.W(QzoneFeedProHeadSection.this, feedData, J, view);
            }
        });
        LinearLayout linearLayout = this.hintContainer;
        if (linearLayout != null) {
            xd.c.b(linearLayout, J);
        }
        N(this.hintContainer, false);
        return true;
    }

    static /* synthetic */ TextView J(QzoneFeedProHeadSection qzoneFeedProHeadSection, String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            str = "";
        }
        if ((i17 & 2) != 0) {
            i3 = R.color.qui_common_text_secondary;
        }
        if ((i17 & 4) != 0) {
            i16 = 12;
        }
        return qzoneFeedProHeadSection.I(str, i3, i16);
    }

    static /* synthetic */ ImageView L(QzoneFeedProHeadSection qzoneFeedProHeadSection, int i3, String str, int i16, ImageView.ScaleType scaleType, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 12;
        }
        if ((i17 & 8) != 0) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        return qzoneFeedProHeadSection.K(i3, str, i16, scaleType);
    }
}
