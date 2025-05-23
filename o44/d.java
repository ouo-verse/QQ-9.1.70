package o44;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.kernel.nativeinterface.CreatorIdentity;
import com.tencent.qqnt.kernel.nativeinterface.RobotLabel;
import com.tencent.qqnt.kernel.nativeinterface.RobtoCreateInfo;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.robot.profile.data.RobotProfileAvatarHeaderData;
import com.tencent.robot.profile.data.g;
import com.tencent.robot.profile.section.avatar.RobotAvatarLayerFragment;
import com.tencent.widget.FoldableTextView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import n44.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u000e2\u00020\u0001:\u0001CB\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J*\u0010%\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010!\u001a\u00020 2\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0014R\u0018\u0010(\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u0016\u00104\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010.R\u0016\u00107\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010?\u00a8\u0006D"}, d2 = {"Lo44/d;", "Ln44/f;", "Landroid/text/SpannableString;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "J", "", "uin", "Landroid/widget/ImageView;", "targetView", "Lcom/tencent/mobileqq/proavatar/e;", DownloadInfo.spKey_Config, "B", "H", "name", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/kernel/nativeinterface/RobtoCreateInfo;", "robotCreateInfo", "u", "Landroid/text/style/ClickableSpan;", "y", "Lcom/tencent/robot/profile/data/f;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "t", "G", "Landroid/view/View;", "containerView", "onInitView", "Lcom/tencent/robot/profile/data/g;", "item2", "", "position", "", "", "payload", "D", "e", "Lcom/tencent/robot/profile/data/f;", "itemData", "f", "Landroid/widget/ImageView;", "avatarIv", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "tagQQ", "i", "tagCreator", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "medalTag", "robotProfileName", "Lcom/tencent/widget/FoldableTextView;", "Lcom/tencent/widget/FoldableTextView;", "robotProfileDescription", "Landroid/view/ViewGroup;", "E", "Landroid/view/ViewGroup;", "categoryContainer", UserInfo.SEX_FEMALE, "Landroid/view/View;", "divideLine", "I", "iconAlign", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends f {
    private static final int I = ViewUtils.dip2px(200.0f);
    private static final int J = ViewUtils.dip2px(180.0f);
    private static final int K = ViewUtils.dip2px(138.0f);
    private static final int L = ViewUtils.dip2px(46.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private TextView robotProfileName;

    /* renamed from: D, reason: from kotlin metadata */
    private FoldableTextView robotProfileDescription;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewGroup categoryContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private View divideLine;

    /* renamed from: G, reason: from kotlin metadata */
    private final int iconAlign;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RobotProfileAvatarHeaderData itemData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView avatarIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView tagQQ;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView tagCreator;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView medalTag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"o44/d$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RobtoCreateInfo f422064d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f422065e;

        b(RobtoCreateInfo robtoCreateInfo, d dVar) {
            this.f422064d = robtoCreateInfo;
            this.f422065e = dVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            String str;
            Intrinsics.checkNotNullParameter(widget, "widget");
            String valueOf = String.valueOf(this.f422064d.createUin);
            String uid = this.f422064d.createUid;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = null;
            }
            int i3 = 0;
            boolean z16 = false;
            if (!Intrinsics.areEqual(valueOf, str)) {
                m b16 = com.tencent.qqnt.msg.f.b();
                if (b16 != null) {
                    Intrinsics.checkNotNullExpressionValue(uid, "uid");
                    z16 = Intrinsics.areEqual(b16.isBuddy(uid), Boolean.TRUE);
                }
                if (z16) {
                    i3 = 1;
                } else {
                    i3 = 19;
                }
            }
            ((IProfileCardApi) QRoute.api(IProfileCardApi.class)).openProfileCard(widget.getContext(), new AllInOne(valueOf, i3));
            TextView textView = this.f422065e.tagCreator;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagCreator");
                textView = null;
            }
            VideoReport.reportEvent("clck", textView, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            Intrinsics.checkNotNullParameter(ds5, "ds");
            ds5.setColor(ds5.linkColor);
            ds5.setUnderlineText(false);
        }
    }

    public d() {
        int i3;
        if (Build.VERSION.SDK_INT >= 29) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        this.iconAlign = i3;
    }

    private final void A() {
        int dip2px = ViewUtils.dip2px(16.0f);
        SpannableString spannableString = new SpannableString(HardCodeUtil.qqStr(R.string.zp9));
        Drawable drawable = ContextCompat.getDrawable(getRootView().getContext(), R.drawable.qui_chevron_down_icon_secondary);
        if (drawable != null) {
            drawable.setBounds(0, 0, dip2px, dip2px);
            spannableString.setSpan(new ImageSpan(drawable, this.iconAlign), 0, spannableString.length(), 33);
        }
        SpannableString spannableString2 = new SpannableString(HardCodeUtil.qqStr(R.string.zp_));
        Drawable drawable2 = ContextCompat.getDrawable(getRootView().getContext(), R.drawable.qui_chevron_up_icon_secondary_01);
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, dip2px, dip2px);
            spannableString2.setSpan(new ImageSpan(drawable2, this.iconAlign), 0, spannableString2.length(), 33);
        }
        FoldableTextView foldableTextView = this.robotProfileDescription;
        FoldableTextView foldableTextView2 = null;
        if (foldableTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotProfileDescription");
            foldableTextView = null;
        }
        foldableTextView.setFoldStateText(spannableString);
        FoldableTextView foldableTextView3 = this.robotProfileDescription;
        if (foldableTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotProfileDescription");
        } else {
            foldableTextView2 = foldableTextView3;
        }
        foldableTextView2.setExpandStateText(spannableString2);
    }

    private final void B(String uin, ImageView targetView, com.tencent.mobileqq.proavatar.e config) {
        QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
        qQProAvatarDrawable.r(targetView.getContext(), 1, uin, config);
        targetView.setImageDrawable(qQProAvatarDrawable);
    }

    private final void C() {
        String str;
        List listOf;
        ImageView imageView = this.avatarIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
            imageView = null;
        }
        Context context = imageView.getContext();
        if (context == null) {
            return;
        }
        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
        RobotProfileAvatarHeaderData robotProfileAvatarHeaderData = this.itemData;
        if (robotProfileAvatarHeaderData != null) {
            str = robotProfileAvatarHeaderData.getAvatarUrl();
        } else {
            str = null;
        }
        rFWPicInfo.setUrl(str);
        rFWPicInfo.setLocalPath(null);
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setPicId(rFWPicInfo.getUrl());
        rFWLayerPicInfo.setOriginPicInfo(rFWPicInfo);
        rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(rFWLayerItemMediaInfo);
        RFWLayerLaunchUtil.jumpToGallery$default(context, null, listOf, 0, QQGalleryActivity.class, RobotAvatarLayerFragment.class, null, 0, 128, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G() {
        TextView textView = this.tagCreator;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagCreator");
            textView = null;
        }
        VideoReport.setElementId(textView, "em_bas_founder");
        TextView textView3 = this.tagCreator;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagCreator");
            textView3 = null;
        }
        VideoReport.setElementClickPolicy(textView3, ClickPolicy.REPORT_NONE);
        TextView textView4 = this.tagCreator;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagCreator");
            textView4 = null;
        }
        VideoReport.setElementExposePolicy(textView4, ExposurePolicy.REPORT_FIRST);
        TextView textView5 = this.tagCreator;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagCreator");
        } else {
            textView2 = textView5;
        }
        VideoReport.setElementEndExposePolicy(textView2, EndExposurePolicy.REPORT_NONE);
    }

    private final void H(String uin) {
        e.a o16 = new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(200).e(true).b(true).d(true).m(8).c(true).n(1).o(9);
        ImageView imageView = this.avatarIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
            imageView = null;
        }
        B(uin, imageView, o16.a());
    }

    private final void J() {
        Context context = getRootView().getContext();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        int color = context.getColor(R.color.qui_common_bg_bottom_light);
        gradientDrawable.setColors(new int[]{color, 0});
        getRootView().findViewById(R.id.x8o).setBackground(gradientDrawable);
        getRootView().findViewById(R.id.x8c).setBackgroundColor(color);
    }

    private final void t(RobotProfileAvatarHeaderData item) {
        boolean z16;
        ViewGroup viewGroup = this.categoryContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("categoryContainer");
            viewGroup = null;
        }
        viewGroup.removeAllViews();
        if (item.m().isEmpty()) {
            return;
        }
        int dip2px = ViewUtils.dip2px(8.0f);
        int dip2px2 = ViewUtils.dip2px(4.0f);
        int dip2px3 = ViewUtils.dip2px(10.0f);
        int dip2px4 = ViewUtils.dip2px(8.0f);
        int i3 = 0;
        for (Object obj : item.m()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            RobotLabel robotLabel = (RobotLabel) obj;
            ViewGroup viewGroup2 = this.categoryContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("categoryContainer");
                viewGroup2 = null;
            }
            if (viewGroup2.getChildCount() >= 3) {
                return;
            }
            String str = robotLabel.name;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                ViewGroup viewGroup3 = this.categoryContainer;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("categoryContainer");
                    viewGroup3 = null;
                }
                TextView textView = new TextView(viewGroup3.getContext());
                textView.setIncludeFontPadding(false);
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setPadding(dip2px, dip2px2, dip2px, dip2px2);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                marginLayoutParams.topMargin = dip2px3;
                if (i3 > 0) {
                    marginLayoutParams.setMarginStart(dip2px4);
                }
                textView.setLayoutParams(marginLayoutParams);
                textView.setTextSize(2, 12.0f);
                textView.setTextColor(textView.getContext().getColorStateList(R.color.qui_common_text_primary));
                textView.setBackgroundResource(R.drawable.lit);
                textView.setText(robotLabel.name);
                ViewGroup viewGroup4 = this.categoryContainer;
                if (viewGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("categoryContainer");
                    viewGroup4 = null;
                }
                viewGroup4.addView(textView);
            }
            i3 = i16;
        }
    }

    private final void u(RobtoCreateInfo robotCreateInfo) {
        TextView textView;
        Object firstOrNull;
        String str;
        boolean z16;
        int i3;
        Object firstOrNull2;
        ImageView imageView;
        int i16;
        ImageView imageView2;
        int coerceAtLeast;
        if (robotCreateInfo != null && !TextUtils.isEmpty(robotCreateInfo.createName)) {
            TextView textView2 = this.tagCreator;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagCreator");
                textView2 = null;
            }
            textView2.setVisibility(0);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(HardCodeUtil.qqStr(R.string.ylq));
            String creatorText = robotCreateInfo.createName;
            ArrayList<CreatorIdentity> arrayList = robotCreateInfo.creatorIdentity;
            Intrinsics.checkNotNullExpressionValue(arrayList, "robotCreateInfo.creatorIdentity");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
            CreatorIdentity creatorIdentity = (CreatorIdentity) firstOrNull;
            if (creatorIdentity != null) {
                str = creatorIdentity.smallIcon;
            } else {
                str = null;
            }
            boolean z17 = true;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                i3 = 0;
            } else {
                i3 = L;
            }
            float screenWidth = ViewUtils.getScreenWidth() - K;
            TextView textView3 = this.tagCreator;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagCreator");
                textView3 = null;
            }
            float measureText = (screenWidth - textView3.getPaint().measureText(spannableStringBuilder.toString() + "\u2026")) - i3;
            TextView textView4 = this.tagCreator;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagCreator");
                textView4 = null;
            }
            if (new StaticLayout(creatorText, textView4.getPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getSecondaryHorizontal(creatorText.length()) > measureText) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(r12.getOffsetForHorizontal(0, measureText) - 1, 0);
                Intrinsics.checkNotNullExpressionValue(creatorText, "creatorText");
                String substring = creatorText.substring(0, coerceAtLeast);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                creatorText = substring + "\u2026";
            }
            if (robotCreateInfo.allowJumpProfile && robotCreateInfo.createUin != 0) {
                spannableStringBuilder.append(creatorText, y(robotCreateInfo), 33);
                G();
            } else {
                spannableStringBuilder.append((CharSequence) creatorText);
            }
            TextView textView5 = this.tagCreator;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagCreator");
                textView5 = null;
            }
            textView5.setText(spannableStringBuilder);
            TextView textView6 = this.tagCreator;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagCreator");
                textView6 = null;
            }
            textView6.setTextColor(getRootView().getContext().getColor(R.color.qui_common_text_secondary));
            TextView textView7 = this.tagCreator;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagCreator");
                textView7 = null;
            }
            textView7.setLinkTextColor(getRootView().getContext().getColor(R.color.qui_common_text_link));
            TextView textView8 = this.tagCreator;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagCreator");
                textView8 = null;
            }
            textView8.setMovementMethod(LinkMovementMethod.getInstance());
            ArrayList<CreatorIdentity> arrayList2 = robotCreateInfo.creatorIdentity;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "robotCreateInfo.creatorIdentity");
            firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
            final CreatorIdentity creatorIdentity2 = (CreatorIdentity) firstOrNull2;
            if (creatorIdentity2 != null) {
                String str2 = creatorIdentity2.smallIcon;
                if (str2 != null && str2.length() != 0) {
                    z17 = false;
                }
                if (!z17) {
                    ImageView imageView3 = this.medalTag;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("medalTag");
                        imageView3 = null;
                    }
                    imageView3.setVisibility(0);
                    Option obtain = Option.obtain();
                    ImageView imageView4 = this.medalTag;
                    if (imageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("medalTag");
                        imageView4 = null;
                    }
                    final Option url = obtain.setTargetView(imageView4).setUrl(creatorIdentity2.smallIcon);
                    QQPicLoader.f201806a.d().loadImage(url, new IPicLoadStateListener() { // from class: o44.b
                        @Override // com.tencent.libra.listener.IPicLoadStateListener
                        public final void onStateChange(LoadState loadState, Option option) {
                            d.w(Option.this, loadState, option);
                        }
                    });
                    ImageView imageView5 = this.medalTag;
                    if (imageView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("medalTag");
                        imageView2 = null;
                    } else {
                        imageView2 = imageView5;
                    }
                    imageView2.setOnClickListener(new View.OnClickListener() { // from class: o44.c
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            d.v(CreatorIdentity.this, this, view);
                        }
                    });
                    return;
                }
                ImageView imageView6 = this.medalTag;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("medalTag");
                    i16 = 8;
                    imageView = null;
                } else {
                    imageView = imageView6;
                    i16 = 8;
                }
                imageView.setVisibility(i16);
                return;
            }
            return;
        }
        ImageView imageView7 = this.medalTag;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("medalTag");
            imageView7 = null;
        }
        imageView7.setVisibility(8);
        TextView textView9 = this.tagCreator;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagCreator");
            textView = null;
        } else {
            textView = textView9;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(CreatorIdentity creatorTag, d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(creatorTag, "$creatorTag");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("RobotAvatarHeaderSection", 1, "click medalTag:" + creatorTag.jumpUrl);
        ImageView imageView = this$0.medalTag;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("medalTag");
            imageView = null;
        }
        Intent intent = new Intent(imageView.getContext(), (Class<?>) JumpActivity.class);
        intent.setData(Uri.parse(creatorTag.jumpUrl));
        ImageView imageView3 = this$0.medalTag;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("medalTag");
        } else {
            imageView2 = imageView3;
        }
        imageView2.getContext().startActivity(intent);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Option option, LoadState loadState, Option option2) {
        if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
            QLog.e("RobotAvatarHeaderSection", 1, "load medalTag  state:" + loadState + "  option:" + option);
        }
    }

    private final void x(String name) {
        TextView textView = this.robotProfileName;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotProfileName");
            textView = null;
        }
        textView.setText(TextUtils.concat(name, z()));
        TextView textView3 = this.robotProfileName;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotProfileName");
            textView3 = null;
        }
        TextView textView4 = this.robotProfileName;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotProfileName");
            textView4 = null;
        }
        textView3.setTextColor(textView4.getContext().getColor(R.color.qui_common_text_primary));
        TextView textView5 = this.robotProfileName;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotProfileName");
            textView5 = null;
        }
        float measureText = textView5.getPaint().measureText(name);
        int i3 = J;
        if (measureText > i3) {
            TextView textView6 = this.robotProfileName;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("robotProfileName");
            } else {
                textView2 = textView6;
            }
            textView2.setMaxWidth(i3);
            return;
        }
        TextView textView7 = this.robotProfileName;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotProfileName");
        } else {
            textView2 = textView7;
        }
        textView2.setMaxWidth(I);
    }

    private final ClickableSpan y(RobtoCreateInfo robotCreateInfo) {
        return new b(robotCreateInfo, this);
    }

    private final SpannableString z() {
        SpannableString spannableString = new SpannableString("\u1f916");
        Drawable drawable = ContextCompat.getDrawable(getRootView().getContext(), R.drawable.qui_robot_icon_primary);
        if (drawable != null) {
            drawable.setBounds(ViewUtils.dip2px(4.0f), 0, ViewUtils.dip2px(20.0f), ViewUtils.dip2px(16.0f));
            spannableString.setSpan(new ImageSpan(drawable, this.iconAlign), 0, spannableString.length(), 33);
        }
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable g item2, int position, @Nullable List<Object> payload) {
        String str;
        J();
        Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type com.tencent.robot.profile.data.RobotProfileAvatarHeaderData");
        RobotProfileAvatarHeaderData robotProfileAvatarHeaderData = (RobotProfileAvatarHeaderData) item2;
        x(robotProfileAvatarHeaderData.getName());
        TextView textView = this.tagQQ;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagQQ");
            textView = null;
        }
        TextView textView2 = this.tagQQ;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagQQ");
            textView2 = null;
        }
        boolean z16 = true;
        textView.setText(textView2.getContext().getString(R.string.f222826ek, robotProfileAvatarHeaderData.getRobotUin()));
        TextView textView3 = this.tagQQ;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tagQQ");
            textView3 = null;
        }
        textView3.setTextColor(getRootView().getContext().getColor(R.color.qui_common_text_secondary));
        FoldableTextView foldableTextView = this.robotProfileDescription;
        if (foldableTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotProfileDescription");
            foldableTextView = null;
        }
        foldableTextView.setText(robotProfileAvatarHeaderData.getDesc());
        FoldableTextView foldableTextView2 = this.robotProfileDescription;
        if (foldableTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotProfileDescription");
            foldableTextView2 = null;
        }
        if (robotProfileAvatarHeaderData.getDesc().length() <= 0) {
            z16 = false;
        }
        Boolean valueOf = Boolean.valueOf(z16);
        foldableTextView2.setVisibility(0);
        if (((View) au.a(valueOf, foldableTextView2)) == null) {
            foldableTextView2.setVisibility(8);
        }
        FoldableTextView foldableTextView3 = this.robotProfileDescription;
        if (foldableTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotProfileDescription");
            foldableTextView3 = null;
        }
        ColorStateList colorStateList = getRootView().getContext().getColorStateList(R.color.qui_common_text_secondary);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "rootView.context.getColo\u2026ui_common_text_secondary)");
        foldableTextView3.setTextColor(colorStateList);
        A();
        ImageView imageView = this.avatarIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarIv");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: o44.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.F(d.this, view2);
            }
        });
        RobotProfileAvatarHeaderData robotProfileAvatarHeaderData2 = this.itemData;
        if (robotProfileAvatarHeaderData2 != null) {
            str = robotProfileAvatarHeaderData2.getRobotUid();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, robotProfileAvatarHeaderData.getRobotUid())) {
            H(robotProfileAvatarHeaderData.getRobotUin());
        }
        u(robotProfileAvatarHeaderData.getRobotCreateInfo());
        t(robotProfileAvatarHeaderData);
        this.itemData = robotProfileAvatarHeaderData;
        View view2 = this.divideLine;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("divideLine");
        } else {
            view = view2;
        }
        Boolean valueOf2 = Boolean.valueOf(robotProfileAvatarHeaderData.getDivideLineVisibility());
        view.setVisibility(0);
        if (((View) au.a(valueOf2, view)) == null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getRootView().getContext()) + com.tencent.biz.qui.quisecnavbar.f.g();
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        rootView.setPaddingRelative(rootView.getPaddingStart(), statusBarHeight + ViewUtils.dip2px(140.0f), rootView.getPaddingEnd(), rootView.getPaddingBottom());
        View findViewById = getRootView().findViewById(R.id.t0o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.avatarIv)");
        this.avatarIv = (ImageView) findViewById;
        View findViewById2 = getRootView().findViewById(R.id.f923257k);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tag_qq)");
        this.tagQQ = (TextView) findViewById2;
        View findViewById3 = getRootView().findViewById(R.id.f9218577);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tag_creator)");
        this.tagCreator = (TextView) findViewById3;
        View findViewById4 = getRootView().findViewById(R.id.yza);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.medal_tag)");
        this.medalTag = (ImageView) findViewById4;
        View findViewById5 = getRootView().findViewById(R.id.f7731441);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.robot_profile_name)");
        this.robotProfileName = (TextView) findViewById5;
        View findViewById6 = getRootView().findViewById(R.id.f772643w);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026obot_profile_description)");
        this.robotProfileDescription = (FoldableTextView) findViewById6;
        View findViewById7 = getRootView().findViewById(R.id.f164748tp2);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.id.category_container)");
        this.categoryContainer = (ViewGroup) findViewById7;
        View findViewById8 = getRootView().findViewById(R.id.uj_);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById<View>(R.id.divide_line)");
        this.divideLine = findViewById8;
        A();
    }
}
