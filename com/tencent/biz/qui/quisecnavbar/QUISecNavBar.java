package com.tencent.biz.qui.quisecnavbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlurViewWrapper;
import com.tencent.theme.SkinnableView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\r\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B,\b\u0007\u0012\b\u0010\u00bd\u0001\u001a\u00030\u00bc\u0001\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\t\b\u0002\u0010\u00be\u0001\u001a\u00020)\u00a2\u0006\u0006\b\u00bf\u0001\u0010\u00c0\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u001a\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\u0018\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0002J\u001a\u0010+\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\r2\b\b\u0002\u0010*\u001a\u00020)H\u0002J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010#\u001a\u00020,2\u0006\u0010-\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\u0012\u00101\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010,H\u0016J\u000e\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u000202J\u000e\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u000205J\u000e\u00108\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dJ\u0016\u0010:\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u00109\u001a\u00020)J\u000e\u0010;\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010<\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010>\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010=\u001a\u00020)J&\u0010A\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\r2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010*\u001a\u00020)H\u0007J\u000e\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020BJ\u000e\u0010F\u001a\u00020\u00042\u0006\u0010E\u001a\u00020BJ\u0016\u0010I\u001a\u00020\u00042\u0006\u0010H\u001a\u00020G2\u0006\u0010E\u001a\u00020BJ\u000e\u0010L\u001a\u00020\u00042\u0006\u0010K\u001a\u00020JJ\u0016\u0010N\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020M2\u0006\u0010K\u001a\u00020\u0002J\u0016\u0010O\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020M2\u0006\u0010-\u001a\u00020\rJ\u0016\u0010R\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020M2\u0006\u0010Q\u001a\u00020PJ\u0016\u0010T\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020M2\u0006\u0010S\u001a\u00020\rJ\u0016\u0010U\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010S\u001a\u00020\rJ\u0016\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\rJ\u000e\u0010X\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\rJ\u000e\u0010Y\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020MJ\u0010\u0010Z\u001a\u0004\u0018\u00010,2\u0006\u0010\u001e\u001a\u00020\u001dJ\b\u0010[\u001a\u00020\u0004H\u0016R\u001b\u0010^\u001a\u00020\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010\\\u001a\u0004\b0\u0010]R\u001b\u0010`\u001a\u00020\u00018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010\\\u001a\u0004\b_\u0010]R\u001b\u0010d\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\ba\u0010\\\u001a\u0004\bb\u0010cR\u001b\u0010h\u001a\u00020e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010\\\u001a\u0004\bf\u0010gR\u001b\u0010k\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bi\u0010\\\u001a\u0004\bj\u0010cR\u001b\u0010p\u001a\u00020l8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bm\u0010\\\u001a\u0004\bn\u0010oR\u001b\u0010t\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\\\u001a\u0004\br\u0010sR\u001b\u0010v\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\\\u001a\u0004\bu\u0010sR\u001b\u0010x\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\\\u001a\u0004\bw\u0010sR\u001b\u0010z\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\\\u001a\u0004\by\u0010sR\u001b\u0010|\u001a\u00020q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\\\u001a\u0004\b{\u0010sR\u001b\u0010\u007f\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\\\u001a\u0004\b}\u0010~R\u001e\u0010\u0082\u0001\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\b\u0014\u0010\\\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001d\u0010\u0084\u0001\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\r\n\u0004\b\u0011\u0010\\\u001a\u0005\b\u0083\u0001\u0010~R\u001c\u0010\u0085\u0001\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\\\u001a\u0004\bm\u0010~R0\u0010\u008b\u0001\u001a\u00020)2\u0007\u0010\u0086\u0001\u001a\u00020)8\u0006@FX\u0086\u000e\u00a2\u0006\u0016\n\u0004\b\u0017\u0010\u0014\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R'\u0010\u008e\u0001\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\b\u0016\u0010\u0014\u001a\u0006\b\u008c\u0001\u0010\u0088\u0001\"\u0006\b\u008d\u0001\u0010\u008a\u0001R6\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006@FX\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0015\u0010\u0090\u0001\u001a\u0005\bi\u0010\u0091\u0001\"\u0006\b\u0092\u0001\u0010\u0093\u0001R8\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006@FX\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0090\u0001\u001a\u0006\b\u0096\u0001\u0010\u0091\u0001\"\u0006\b\u0097\u0001\u0010\u0093\u0001R6\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u008f\u00012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0006@FX\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\b\u0010\u0090\u0001\u001a\u0005\ba\u0010\u0091\u0001\"\u0006\b\u0099\u0001\u0010\u0093\u0001R8\u0010\u009f\u0001\u001a\u00020)2\u0007\u0010\u0086\u0001\u001a\u00020)8\u0006@FX\u0086\u000e\u00a2\u0006\u001e\n\u0004\b4\u0010\u0014\u0012\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0006\b\u009b\u0001\u0010\u0088\u0001\"\u0006\b\u009c\u0001\u0010\u008a\u0001R8\u0010\u00a3\u0001\u001a\u00020)2\u0007\u0010\u0086\u0001\u001a\u00020)8\u0006@FX\u0086\u000e\u00a2\u0006\u001e\n\u0004\b7\u0010\u0014\u0012\u0006\b\u00a2\u0001\u0010\u009e\u0001\u001a\u0006\b\u00a0\u0001\u0010\u0088\u0001\"\u0006\b\u00a1\u0001\u0010\u008a\u0001R8\u0010\u00a7\u0001\u001a\u00020)2\u0007\u0010\u0086\u0001\u001a\u00020)8\u0006@FX\u0086\u000e\u00a2\u0006\u001e\n\u0004\b.\u0010\u0014\u0012\u0006\b\u00a6\u0001\u0010\u009e\u0001\u001a\u0006\b\u00a4\u0001\u0010\u0088\u0001\"\u0006\b\u00a5\u0001\u0010\u008a\u0001R(\u0010\u00ad\u0001\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b'\u0010\u00a8\u0001\u001a\u0006\b\u00a9\u0001\u0010\u00aa\u0001\"\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u001b\u0010\u00b0\u0001\u001a\u0005\u0018\u00010\u00ae\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\t\u0010\u00af\u0001R_\u0010\u00b9\u0001\u001a9\u0012\u0015\u0012\u00130,\u00a2\u0006\u000e\b\u00b2\u0001\u0012\t\b\u00b3\u0001\u0012\u0004\b\b(0\u0012\u0015\u0012\u00130M\u00a2\u0006\u000e\b\u00b2\u0001\u0012\t\b\u00b3\u0001\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00b1\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\"\u0010\u00b4\u0001\u001a\u0006\b\u00b5\u0001\u0010\u00b6\u0001\"\u0006\b\u00b7\u0001\u0010\u00b8\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u00bb\u0001\u00a8\u0006\u00c1\u0001"}, d2 = {"Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/theme/SkinnableView;", "", "E", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "V", "H", "Landroid/content/res/TypedArray;", "typedArray", "", RedTouchConst.PicDownload.ISCIRCLE, UserInfo.SEX_FEMALE, "G", "J", "D", BdhLogUtil.LogTag.Tag_Conn, "I", "N", "M", "L", "K", "Landroid/widget/TextView;", "textView", "needClick", "O", "Lcom/tencent/biz/qui/quisecnavbar/b;", "action", "Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Y", "W", "view", "X", "Landroid/view/Window;", "window", "U", "isInit", "", "clearColor", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", NodeProps.ENABLED, "T", VasPerfReportUtils.WHILE_UPDATE_ITEM, "v", NodeProps.ON_CLICK, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, BdhLogUtil.LogTag.Tag_Req, "Landroidx/fragment/app/Fragment;", "fragment", ExifInterface.LATITUDE_SOUTH, "d", "index", "e", "setLeftIconWithCircle", "setRightIconWithCircle", "resId", "setRightIconRes", "needBlur", "bgView", "setBlur", "", com.tencent.luggage.wxa.c8.c.f123400v, "setTitleBlurAlpha", "destAlpha", "setTitleAlpha", "", "duration", "setTitleAlphaWithAnim", "Lcom/tencent/biz/qui/quisecnavbar/c;", "listener", "setTitleAnimListener", "Lcom/tencent/biz/qui/quisecnavbar/BaseAction;", "setBaseClickListener", "setBaseViewEnabled", "", "description", "setBaseViewDescription", NodeProps.VISIBLE, "setBaseViewVisible", "setRightIconVisible", "setRightIconEnabled", "isVisible", "setRightIconLayoutVisible", "g", h.F, "onThemeChanged", "Lkotlin/Lazy;", "()Landroid/widget/RelativeLayout;", "mRoot", HippyTKDListViewAdapter.X, "mTitleRoot", "f", "w", "()Landroid/view/View;", "mTitleBg", "Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "j", "()Lcom/tencent/qui/quiblurview/QQBlurViewWrapper;", "mBlurView", "i", "k", "mBorder", "Landroid/widget/LinearLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "()Landroid/widget/LinearLayout;", "mRightLayout", "Landroid/widget/RelativeLayout$LayoutParams;", "p", "()Landroid/widget/RelativeLayout$LayoutParams;", "mLeftIconLayoutParams", DomainData.DOMAIN_NAME, "mLeftCircleIconLayoutParams", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mLeftTextLayoutParams", "l", "mCenterLayoutParams", "t", "mRightLayoutParams", "r", "()Landroid/widget/TextView;", "mLeftTextView", "o", "()Landroid/widget/ImageView;", "mLeftIcon", "u", "mRightTextView", "mCenterTextView", "value", "getLeftImageRes", "()I", "setLeftImageRes", "(I)V", "leftImageRes", "getLeftImageResInTransParent", "setLeftImageResInTransParent", "leftImageResInTransParent", "", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "setLeftText", "(Ljava/lang/CharSequence;)V", "leftText", "P", "y", "setRightText", "rightText", "setCenterText", "centerText", "getLeftType", "setLeftType", "getLeftType$annotations", "()V", "leftType", "getCenterType", "setCenterType", "getCenterType$annotations", "centerType", "getRightType", "setRightType", "getRightType$annotations", "rightType", "Z", "getAutoAdaptTransparent", "()Z", "setAutoAdaptTransparent", "(Z)V", "autoAdaptTransparent", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "mAnimator", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/jvm/functions/Function2;", "getOnBaseTitleBarClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnBaseTitleBarClickListener", "(Lkotlin/jvm/functions/Function2;)V", "onBaseTitleBarClickListener", "a0", "Landroid/util/AttributeSet;", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "QUISecNavBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class QUISecNavBar extends RelativeLayout implements View.OnClickListener, SkinnableView {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy mLeftIconLayoutParams;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy mLeftCircleIconLayoutParams;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy mLeftTextLayoutParams;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy mCenterLayoutParams;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy mRightLayoutParams;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy mLeftTextView;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy mLeftIcon;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy mRightTextView;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy mCenterTextView;

    /* renamed from: L, reason: from kotlin metadata */
    private int leftImageRes;

    /* renamed from: M, reason: from kotlin metadata */
    private int leftImageResInTransParent;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private CharSequence leftText;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private CharSequence rightText;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private CharSequence centerText;

    /* renamed from: R, reason: from kotlin metadata */
    private int leftType;

    /* renamed from: S, reason: from kotlin metadata */
    private int centerType;

    /* renamed from: T, reason: from kotlin metadata */
    private int rightType;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean autoAdaptTransparent;

    /* renamed from: V, reason: from kotlin metadata */
    private ValueAnimator mAnimator;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private Function2<? super View, ? super BaseAction, Unit> onBaseTitleBarClickListener;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final AttributeSet attrs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy mRoot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy mTitleRoot;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy mTitleBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy mBlurView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Lazy mBorder;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy mRightLayout;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007\u00b8\u0006\u0000"}, d2 = {"com/tencent/biz/qui/quisecnavbar/QUISecNavBar$setTitleAlphaWithAnim$1$1", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "QUISecNavBar_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f95254e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f95255f;

        b(long j3, boolean z16) {
            this.f95254e = j3;
            this.f95255f = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            QUISecNavBar.b(QUISecNavBar.this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            QUISecNavBar.b(QUISecNavBar.this);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/biz/qui/quisecnavbar/QUISecNavBar$setTitleAlphaWithAnim$1$2"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f95257e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f95258f;

        c(long j3, boolean z16) {
            this.f95257e = j3;
            this.f95258f = z16;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            QUISecNavBar qUISecNavBar = QUISecNavBar.this;
            Intrinsics.checkNotNullExpressionValue(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            if (animatedValue != null) {
                qUISecNavBar.setTitleAlpha(((Float) animatedValue).floatValue());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    @JvmOverloads
    public QUISecNavBar(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    private final void A(boolean isInit, int clearColor) {
        QQBlurViewWrapper j3 = j();
        j3.setVisibility(0);
        View a16 = ge0.a.a(j3);
        Context context = j3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        e.c(j3, a16, clearColor, context);
        if (isInit) {
            j3.setAlpha(0.0f);
        }
        w().setBackgroundColor(0);
    }

    static /* synthetic */ void B(QUISecNavBar qUISecNavBar, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        qUISecNavBar.A(z16, i3);
    }

    private final void C(TypedArray typedArray) {
        CharSequence string = typedArray.getString(g.f95284d0);
        if (string == null) {
            string = this.centerText;
        }
        setCenterText(string);
        boolean z16 = false;
        m().setVisibility(0);
        if (x().indexOfChild(m()) != -1) {
            z16 = true;
        }
        if (!z16) {
            x().addView(m(), l());
        }
    }

    private final void D() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(this.attrs, g.f95282c0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026R.styleable.QUISecNavBar)");
        ud0.d.g("QUISecNavBar", ud0.d.f438811e, "initCenterView centerType: " + this.centerType);
        int i3 = this.centerType;
        if (i3 != 0) {
            if (i3 == 1) {
                C(obtainStyledAttributes);
            }
        } else {
            I();
        }
        obtainStyledAttributes.recycle();
    }

    private final void E() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        addView(j());
        addView(w());
        addView(v());
        v().addView(x());
        addView(k());
        setOnClickListener(a.f95252d);
    }

    private final void F(TypedArray typedArray, boolean isCircle) {
        setLeftImageRes(typedArray.getResourceId(g.f95288f0, this.leftImageRes));
        int i3 = this.leftImageRes;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!e.e(i3, context)) {
            return;
        }
        setLeftIconWithCircle(isCircle);
    }

    private final void G(TypedArray typedArray) {
        CharSequence string = typedArray.getString(g.f95290g0);
        if (string == null) {
            string = this.leftText;
        }
        setLeftText(string);
        boolean z16 = false;
        r().setVisibility(0);
        o().setVisibility(8);
        e.a(r());
        if (x().indexOfChild(r()) != -1) {
            z16 = true;
        }
        if (!z16) {
            x().addView(r(), q());
        }
    }

    private final void H() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(this.attrs, g.f95282c0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026R.styleable.QUISecNavBar)");
        ud0.d.g("QUISecNavBar", ud0.d.f438811e, "initLeftView leftType: " + this.leftType);
        int i3 = this.leftType;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        F(obtainStyledAttributes, true);
                    }
                } else {
                    F(obtainStyledAttributes, false);
                }
            } else {
                G(obtainStyledAttributes);
            }
        } else {
            J();
        }
        obtainStyledAttributes.recycle();
    }

    private final void I() {
        m().setVisibility(8);
    }

    private final void J() {
        r().setVisibility(8);
        o().setVisibility(8);
    }

    private final void K() {
        u().setVisibility(8);
        s().setVisibility(8);
    }

    private final void L() {
        boolean z16;
        u().setVisibility(8);
        if (x().indexOfChild(s()) != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            x().addView(s());
        }
        s().setVisibility(0);
    }

    private final void M(TypedArray typedArray) {
        CharSequence string = typedArray.getString(g.f95294i0);
        if (string == null) {
            string = this.rightText;
        }
        setRightText(string);
        boolean z16 = false;
        u().setVisibility(0);
        s().setVisibility(8);
        e.a(u());
        if (x().indexOfChild(u()) != -1) {
            z16 = true;
        }
        if (!z16) {
            x().addView(u(), t());
        }
    }

    private final void N() {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(this.attrs, g.f95282c0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026R.styleable.QUISecNavBar)");
        ud0.d.g("QUISecNavBar", ud0.d.f438811e, "initRightViews rightType: " + this.rightType);
        int i3 = this.rightType;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    L();
                }
            } else {
                M(obtainStyledAttributes);
            }
        } else {
            K();
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(TextView textView, boolean needClick) {
        textView.setSingleLine(true);
        textView.setTextSize(0, f.f());
        if (needClick) {
            textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_nav_secondary_selector));
            textView.setOnClickListener(this);
        } else {
            textView.setTextColor(textView.getResources().getColorStateList(R.color.qui_common_text_nav_secondary));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void P(QUISecNavBar qUISecNavBar, TextView textView, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        qUISecNavBar.O(textView, z16);
    }

    private final void Q(AttributeSet attrs) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, g.f95282c0);
        setLeftType(obtainStyledAttributes.getInt(g.f95292h0, this.leftType));
        setRightType(obtainStyledAttributes.getInt(g.f95296j0, this.rightType));
        setCenterType(obtainStyledAttributes.getInt(g.f95286e0, this.centerType));
        obtainStyledAttributes.recycle();
    }

    private final void T(View view, boolean enabled) {
        float f16;
        view.setEnabled(enabled);
        if (enabled) {
            f16 = 1.0f;
        } else {
            f16 = 0.3f;
        }
        view.setAlpha(f16);
    }

    private final void U(Window window) {
        RFWImmersiveUtils.setImmersiveLayout(window, false);
        RFWImmersiveUtils.setTransparentStatusBar(window);
        V();
    }

    private final void V() {
        int statusBarHeight = RFWImmersiveUtils.getStatusBarHeight(getContext());
        ud0.d.g("QUISecNavBar", ud0.d.f438811e, "statusBarHeight: " + statusBarHeight);
        v().setPadding(0, statusBarHeight, 0, 0);
        w().setLayoutParams(new RelativeLayout.LayoutParams(-1, f.g() + statusBarHeight));
        j().setLayoutParams(new RelativeLayout.LayoutParams(-1, f.g() + statusBarHeight));
    }

    private final void W() {
        ud0.d.a("QUISecNavBar", ud0.d.f438811e, "\u67d3\u6210\u6d45\u8272");
        if (!ge0.b.a(o())) {
            o().setImageResource(this.leftImageRes);
        }
        r().setTextColor(getResources().getColorStateList(R.color.qui_common_text_nav_secondary));
        m().setTextColor(getResources().getColorStateList(R.color.qui_common_text_nav_secondary));
        u().setTextColor(getResources().getColorStateList(R.color.qui_common_text_nav_secondary));
        int childCount = s().getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = s().getChildAt(i3);
            Object tag = childAt.getTag(R.id.f98785o1);
            if ((childAt instanceof ImageView) && (tag instanceof com.tencent.biz.qui.quisecnavbar.b)) {
                ImageView imageView = (ImageView) childAt;
                if (!ge0.b.a(imageView)) {
                    com.tencent.biz.qui.quisecnavbar.b bVar = (com.tencent.biz.qui.quisecnavbar.b) tag;
                    int drawable = bVar.getDrawable();
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    if (e.e(drawable, context)) {
                        imageView.setImageResource(bVar.getDrawable());
                    }
                }
            }
        }
    }

    private final void X(ImageView view, boolean isCircle) {
        if (isCircle) {
            ge0.b.c(view, view, view.getDrawable());
            view.setBackgroundResource(R.drawable.f162590lv2);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f.d(), f.d());
            layoutParams.setMargins(f.c(), 0, 0, 0);
            Unit unit = Unit.INSTANCE;
            view.setLayoutParams(layoutParams);
            ge0.b.b(view, true);
            return;
        }
        view.setScaleType(ImageView.ScaleType.CENTER);
        view.setBackgroundResource(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(f.h(), f.h());
        layoutParams2.setMargins(f.k(), 0, 0, 0);
        Unit unit2 = Unit.INSTANCE;
        view.setLayoutParams(layoutParams2);
        ge0.b.b(view, false);
    }

    private final void Y() {
        if (!ge0.b.a(o())) {
            int i3 = this.leftImageResInTransParent;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (e.e(i3, context)) {
                o().setImageResource(this.leftImageResInTransParent);
            }
        }
        r().setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary));
        m().setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary));
        u().setTextColor(getResources().getColorStateList(R.color.qui_common_text_primary));
        int childCount = s().getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = s().getChildAt(i16);
            Object tag = childAt.getTag(R.id.f98785o1);
            if ((childAt instanceof ImageView) && (tag instanceof com.tencent.biz.qui.quisecnavbar.b)) {
                ImageView imageView = (ImageView) childAt;
                if (!ge0.b.a(imageView)) {
                    com.tencent.biz.qui.quisecnavbar.b bVar = (com.tencent.biz.qui.quisecnavbar.b) tag;
                    int d16 = bVar.d();
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    if (e.e(d16, context2)) {
                        imageView.setImageResource(bVar.d());
                    }
                }
            }
        }
    }

    public static final /* synthetic */ com.tencent.biz.qui.quisecnavbar.c b(QUISecNavBar qUISecNavBar) {
        qUISecNavBar.getClass();
        return null;
    }

    private final QQBlurViewWrapper j() {
        return (QQBlurViewWrapper) this.mBlurView.getValue();
    }

    private final View k() {
        return (View) this.mBorder.getValue();
    }

    private final RelativeLayout.LayoutParams l() {
        return (RelativeLayout.LayoutParams) this.mCenterLayoutParams.getValue();
    }

    private final TextView m() {
        return (TextView) this.mCenterTextView.getValue();
    }

    private final RelativeLayout.LayoutParams n() {
        return (RelativeLayout.LayoutParams) this.mLeftCircleIconLayoutParams.getValue();
    }

    private final ImageView o() {
        return (ImageView) this.mLeftIcon.getValue();
    }

    private final RelativeLayout.LayoutParams p() {
        return (RelativeLayout.LayoutParams) this.mLeftIconLayoutParams.getValue();
    }

    private final RelativeLayout.LayoutParams q() {
        return (RelativeLayout.LayoutParams) this.mLeftTextLayoutParams.getValue();
    }

    private final TextView r() {
        return (TextView) this.mLeftTextView.getValue();
    }

    private final LinearLayout s() {
        return (LinearLayout) this.mRightLayout.getValue();
    }

    public static /* synthetic */ void setBlur$default(QUISecNavBar qUISecNavBar, boolean z16, View view, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            view = null;
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        qUISecNavBar.setBlur(z16, view, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RelativeLayout.LayoutParams t() {
        return (RelativeLayout.LayoutParams) this.mRightLayoutParams.getValue();
    }

    private final TextView u() {
        return (TextView) this.mRightTextView.getValue();
    }

    private final void updateView() {
        if (ge0.a.a(j()) == null) {
            return;
        }
        QUISecNavBarBlurUtil qUISecNavBarBlurUtil = QUISecNavBarBlurUtil.f95260b;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!qUISecNavBarBlurUtil.b(context)) {
            j().setVisibility(8);
            w().setBackgroundResource(R.drawable.qui_bg_nav_secondary);
        } else {
            B(this, false, 0, 2, null);
        }
    }

    private final RelativeLayout v() {
        return (RelativeLayout) this.mRoot.getValue();
    }

    private final View w() {
        return (View) this.mTitleBg.getValue();
    }

    private final RelativeLayout x() {
        return (RelativeLayout) this.mTitleRoot.getValue();
    }

    private final ImageView z(com.tencent.biz.qui.quisecnavbar.b action) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(action.getDrawable());
        X(imageView, action.c());
        imageView.setTag(R.id.f98785o1, action);
        imageView.setContentDescription(action.b());
        imageView.setOnClickListener(this);
        return imageView;
    }

    public final void R(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        U(window);
    }

    public final void S(@NotNull Fragment fragment) {
        Window window;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            window = activity.getWindow();
        } else {
            window = null;
        }
        if (window == null) {
            ud0.d.b("QUISecNavBar", ud0.d.f438811e, "window is null");
        } else {
            U(window);
        }
    }

    public final void d(@NotNull com.tencent.biz.qui.quisecnavbar.b action) {
        Intrinsics.checkNotNullParameter(action, "action");
        int drawable = action.getDrawable();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!e.e(drawable, context)) {
            return;
        }
        int childCount = s().getChildCount();
        if (childCount >= 3) {
            ud0.d.b("QUISecNavBar", ud0.d.f438811e, "three icons in the right layout at most");
        } else {
            e(action, childCount);
        }
    }

    public final void e(@NotNull com.tencent.biz.qui.quisecnavbar.b action, int index) {
        Intrinsics.checkNotNullParameter(action, "action");
        int drawable = action.getDrawable();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!e.e(drawable, context)) {
            return;
        }
        if (index >= 3) {
            ud0.d.b("QUISecNavBar", ud0.d.f438811e, "three icons in the right layout at most");
            return;
        }
        try {
            s().addView(z(action), index);
        } catch (IndexOutOfBoundsException e16) {
            ud0.d.b("QUISecNavBar", ud0.d.f438810d, "Unable to add view at the index " + e16);
        }
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final CharSequence getCenterText() {
        return this.centerText;
    }

    @NotNull
    public final View g(@NotNull BaseAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        int i3 = d.f95265e[action.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        return u();
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return m();
            }
            return o();
        }
        return r();
    }

    @Nullable
    public final View h(@NotNull com.tencent.biz.qui.quisecnavbar.b action) {
        Intrinsics.checkNotNullParameter(action, "action");
        int childCount = s().getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = s().getChildAt(i3);
            Object tag = childAt.getTag(R.id.f98785o1);
            if ((tag instanceof com.tencent.biz.qui.quisecnavbar.b) && Intrinsics.areEqual(tag, action)) {
                return childAt;
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final CharSequence getLeftText() {
        return this.leftText;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Object obj;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            obj = v3.getTag(R.id.f98785o1);
        } else {
            obj = null;
        }
        if (obj instanceof com.tencent.biz.qui.quisecnavbar.b) {
            ((com.tencent.biz.qui.quisecnavbar.b) obj).a(v3);
        } else {
            Function2<? super View, ? super BaseAction, Unit> function2 = this.onBaseTitleBarClickListener;
            if (function2 != null) {
                if (Intrinsics.areEqual(v3, r())) {
                    function2.invoke(v3, BaseAction.ACTION_LEFT_TEXT);
                } else if (Intrinsics.areEqual(v3, o())) {
                    function2.invoke(v3, BaseAction.ACTION_LEFT_BUTTON);
                } else if (Intrinsics.areEqual(v3, u())) {
                    function2.invoke(v3, BaseAction.ACTION_RIGHT_TEXT);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        updateView();
    }

    public final void setAutoAdaptTransparent(boolean z16) {
        this.autoAdaptTransparent = z16;
    }

    public final void setBaseClickListener(@NotNull BaseAction action, @NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(listener, "listener");
        int i3 = d.f95261a[action.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    u().setOnClickListener(listener);
                    return;
                }
                return;
            }
            o().setOnClickListener(listener);
            return;
        }
        r().setOnClickListener(listener);
    }

    public final void setBaseViewDescription(@NotNull BaseAction action, @NotNull String description) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(description, "description");
        int i3 = d.f95263c[action.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        m().setContentDescription(description);
                        return;
                    }
                    return;
                }
                u().setContentDescription(description);
                return;
            }
            o().setContentDescription(description);
            return;
        }
        r().setContentDescription(description);
    }

    public final void setBaseViewEnabled(@NotNull BaseAction action, boolean enabled) {
        Intrinsics.checkNotNullParameter(action, "action");
        int i3 = d.f95262b[action.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        T(m(), enabled);
                        return;
                    }
                    return;
                }
                T(u(), enabled);
                return;
            }
            T(o(), enabled);
            return;
        }
        T(r(), enabled);
    }

    public final void setBaseViewVisible(@NotNull BaseAction action, boolean visible) {
        Intrinsics.checkNotNullParameter(action, "action");
        int i3 = d.f95264d[action.ordinal()];
        int i16 = 0;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        TextView m3 = m();
                        if (!visible) {
                            i16 = 8;
                        }
                        m3.setVisibility(i16);
                        return;
                    }
                    return;
                }
                TextView u16 = u();
                if (!visible) {
                    i16 = 8;
                }
                u16.setVisibility(i16);
                return;
            }
            ImageView o16 = o();
            if (!visible) {
                i16 = 8;
            }
            o16.setVisibility(i16);
            return;
        }
        TextView r16 = r();
        if (!visible) {
            i16 = 8;
        }
        r16.setVisibility(i16);
    }

    @JvmOverloads
    public final void setBlur(boolean z16) {
        setBlur$default(this, z16, null, 0, 6, null);
    }

    public final void setCenterText(@Nullable CharSequence charSequence) {
        this.centerText = charSequence;
        m().setText(charSequence);
    }

    public final void setCenterType(int i3) {
        this.centerType = i3;
        D();
    }

    public final void setLeftIconWithCircle(boolean isCircle) {
        boolean z16;
        o().setVisibility(0);
        r().setVisibility(8);
        if (x().indexOfChild(o()) != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            x().addView(o(), p());
        }
        if (isCircle) {
            ImageView o16 = o();
            ge0.b.c(o16, o16, o16.getDrawable());
            o16.setBackgroundResource(R.drawable.f162590lv2);
            o16.setLayoutParams(n());
            ge0.b.b(o16, true);
            return;
        }
        ImageView o17 = o();
        o17.setScaleType(ImageView.ScaleType.CENTER);
        o17.setBackgroundResource(0);
        o17.setLayoutParams(p());
        ge0.b.b(o17, false);
    }

    public final void setLeftImageRes(int i3) {
        this.leftImageRes = i3;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (e.e(i3, context)) {
            o().setImageResource(i3);
            ImageView o16 = o();
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            o16.setContentDescription(context2.getResources().getString(R.string.f2172060d));
        }
    }

    public final void setLeftImageResInTransParent(int i3) {
        this.leftImageResInTransParent = i3;
    }

    public final void setLeftText(@Nullable CharSequence charSequence) {
        this.leftText = charSequence;
        r().setText(charSequence);
    }

    public final void setLeftType(int i3) {
        this.leftType = i3;
        H();
    }

    public final void setOnBaseTitleBarClickListener(@Nullable Function2<? super View, ? super BaseAction, Unit> function2) {
        this.onBaseTitleBarClickListener = function2;
    }

    public final void setRightIconEnabled(@NotNull com.tencent.biz.qui.quisecnavbar.b action, boolean enabled) {
        Intrinsics.checkNotNullParameter(action, "action");
        int childCount = s().getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = s().getChildAt(i3);
            Object tag = childAt.getTag(R.id.f98785o1);
            if ((tag instanceof com.tencent.biz.qui.quisecnavbar.b) && Intrinsics.areEqual(tag, action)) {
                T(childAt, enabled);
            }
        }
    }

    public final void setRightIconLayoutVisible(boolean isVisible) {
        int i3;
        LinearLayout s16 = s();
        if (isVisible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        s16.setVisibility(i3);
    }

    public final void setRightIconRes(@NotNull com.tencent.biz.qui.quisecnavbar.b action, int resId) {
        Intrinsics.checkNotNullParameter(action, "action");
        int childCount = s().getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = s().getChildAt(i3);
            Object tag = childAt.getTag(R.id.f98785o1);
            if ((childAt instanceof ImageView) && (tag instanceof com.tencent.biz.qui.quisecnavbar.b) && Intrinsics.areEqual(tag, action)) {
                ((ImageView) childAt).setImageResource(resId);
            }
        }
    }

    public final void setRightIconVisible(@NotNull com.tencent.biz.qui.quisecnavbar.b action, boolean visible) {
        int i3;
        Intrinsics.checkNotNullParameter(action, "action");
        int childCount = s().getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = s().getChildAt(i16);
            Object tag = childAt.getTag(R.id.f98785o1);
            if ((tag instanceof com.tencent.biz.qui.quisecnavbar.b) && Intrinsics.areEqual(tag, action)) {
                if (visible) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                childAt.setVisibility(i3);
            }
        }
    }

    public final void setRightIconWithCircle(boolean isCircle) {
        int childCount = s().getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = s().getChildAt(i3);
            if (childAt instanceof ImageView) {
                X((ImageView) childAt, isCircle);
            }
        }
    }

    public final void setRightText(@Nullable CharSequence charSequence) {
        this.rightText = charSequence;
        u().setText(charSequence);
    }

    public final void setRightType(int i3) {
        this.rightType = i3;
        N();
    }

    public final void setTitleAlpha(float destAlpha) {
        if (destAlpha >= 0 && destAlpha <= 1 && destAlpha != w().getAlpha()) {
            w().setAlpha(destAlpha);
            if (!this.autoAdaptTransparent) {
                return;
            }
            if (destAlpha == 0.0f) {
                Y();
            }
            if (destAlpha == 1.0f) {
                W();
                return;
            }
            return;
        }
        ud0.d.g("QUISecNavBar", ud0.d.f438810d, "invalid alpha");
    }

    public final void setTitleAlphaWithAnim(long duration, float destAlpha) {
        boolean z16;
        ValueAnimator valueAnimator;
        if (destAlpha >= 0 && destAlpha <= 1) {
            ud0.d.g("QUISecNavBar", ud0.d.f438810d, "alpha cur: " + w().getAlpha() + ", dest: " + destAlpha);
            ValueAnimator valueAnimator2 = this.mAnimator;
            if (valueAnimator2 != null && valueAnimator2 != null && valueAnimator2.isRunning() && (valueAnimator = this.mAnimator) != null) {
                valueAnimator.cancel();
            }
            if (destAlpha > w().getAlpha()) {
                z16 = true;
            } else {
                z16 = false;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(w().getAlpha(), destAlpha);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "this");
            ofFloat.setDuration(duration);
            ofFloat.addListener(new b(duration, z16));
            ofFloat.addUpdateListener(new c(duration, z16));
            Unit unit = Unit.INSTANCE;
            this.mAnimator = ofFloat;
            ofFloat.start();
        }
    }

    public final void setTitleAnimListener(@NotNull com.tencent.biz.qui.quisecnavbar.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public final void setTitleBlurAlpha(float alpha) {
        QUISecNavBarBlurUtil qUISecNavBarBlurUtil = QUISecNavBarBlurUtil.f95260b;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (!qUISecNavBarBlurUtil.b(context)) {
            return;
        }
        int i3 = 0;
        float f16 = 0;
        if (alpha >= f16 && alpha <= 1) {
            j().setAlpha(alpha);
            View k3 = k();
            if (alpha <= f16) {
                i3 = 8;
            }
            k3.setVisibility(i3);
        }
    }

    @Nullable
    /* renamed from: y, reason: from getter */
    public final CharSequence getRightText() {
        return this.rightText;
    }

    @JvmOverloads
    public QUISecNavBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @JvmOverloads
    public final void setBlur(boolean z16, @Nullable View view) {
        setBlur$default(this, z16, view, 0, 4, null);
    }

    public /* synthetic */ QUISecNavBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @JvmOverloads
    public final void setBlur(boolean needBlur, @Nullable View bgView, int clearColor) {
        ge0.a.b(j(), bgView);
        QUISecNavBarBlurUtil qUISecNavBarBlurUtil = QUISecNavBarBlurUtil.f95260b;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (qUISecNavBarBlurUtil.b(context)) {
            if (needBlur) {
                A(true, clearColor);
            } else {
                j().setVisibility(8);
                w().setBackgroundResource(R.drawable.qui_bg_nav_secondary);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QUISecNavBar(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Lazy lazy13;
        Lazy lazy14;
        Lazy lazy15;
        Intrinsics.checkNotNullParameter(context, "context");
        this.attrs = attributeSet;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mRoot$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                RelativeLayout relativeLayout = new RelativeLayout(context);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                return relativeLayout;
            }
        });
        this.mRoot = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mTitleRoot$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                RelativeLayout relativeLayout = new RelativeLayout(context);
                relativeLayout.setPadding(0, 0, f.j(), 0);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, f.g()));
                return relativeLayout;
            }
        });
        this.mTitleRoot = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mTitleBg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View view = new View(context);
                view.setId(R.id.f81564ei);
                view.setLayoutParams(new RelativeLayout.LayoutParams(-1, f.g()));
                view.setBackgroundResource(R.drawable.qui_bg_nav_secondary);
                return view;
            }
        });
        this.mTitleBg = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<QQBlurViewWrapper>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mBlurView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QQBlurViewWrapper invoke() {
                QQBlurViewWrapper qQBlurViewWrapper = new QQBlurViewWrapper(context, null, 0, 6, null);
                qQBlurViewWrapper.setLayoutParams(new RelativeLayout.LayoutParams(-1, f.g()));
                qQBlurViewWrapper.setVisibility(8);
                return qQBlurViewWrapper;
            }
        });
        this.mBlurView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mBorder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View view = new View(context);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, f.a());
                layoutParams.addRule(8, R.id.f81564ei);
                Unit unit = Unit.INSTANCE;
                view.setLayoutParams(layoutParams);
                view.setBackgroundResource(R.drawable.qui_common_border_light_bg);
                view.setVisibility(8);
                return view;
            }
        });
        this.mBorder = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mRightLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                RelativeLayout.LayoutParams t16;
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setGravity(8388629);
                linearLayout.setOrientation(0);
                t16 = QUISecNavBar.this.t();
                linearLayout.setLayoutParams(t16);
                return linearLayout;
            }
        });
        this.mRightLayout = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout.LayoutParams>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mLeftIconLayoutParams$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout.LayoutParams invoke() {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f.h(), -1);
                layoutParams.addRule(20);
                layoutParams.addRule(15);
                layoutParams.setMargins(f.i(), 0, 0, 0);
                return layoutParams;
            }
        });
        this.mLeftIconLayoutParams = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout.LayoutParams>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mLeftCircleIconLayoutParams$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout.LayoutParams invoke() {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f.d(), f.d());
                layoutParams.addRule(20);
                layoutParams.addRule(15);
                layoutParams.setMargins(f.j(), 0, 0, 0);
                return layoutParams;
            }
        });
        this.mLeftCircleIconLayoutParams = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout.LayoutParams>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mLeftTextLayoutParams$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout.LayoutParams invoke() {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(20);
                layoutParams.addRule(15);
                layoutParams.setMargins(f.j(), 0, 0, 0);
                return layoutParams;
            }
        });
        this.mLeftTextLayoutParams = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout.LayoutParams>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mCenterLayoutParams$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout.LayoutParams invoke() {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
                layoutParams.addRule(13);
                layoutParams.setMargins(f.b(), 0, f.b(), 0);
                return layoutParams;
            }
        });
        this.mCenterLayoutParams = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout.LayoutParams>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mRightLayoutParams$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout.LayoutParams invoke() {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
                layoutParams.addRule(21);
                layoutParams.addRule(15);
                return layoutParams;
            }
        });
        this.mRightLayoutParams = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mLeftTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                TextView textView = new TextView(context);
                textView.setGravity(8388627);
                QUISecNavBar.P(QUISecNavBar.this, textView, false, 2, null);
                return textView;
            }
        });
        this.mLeftTextView = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mLeftIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER);
                imageView.setOnClickListener(QUISecNavBar.this);
                return imageView;
            }
        });
        this.mLeftIcon = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mRightTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                TextView textView = new TextView(context);
                textView.setGravity(8388629);
                QUISecNavBar.P(QUISecNavBar.this, textView, false, 2, null);
                return textView;
            }
        });
        this.mRightTextView = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBar$mCenterTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                TextView textView = new TextView(context);
                textView.setGravity(17);
                textView.setSingleLine(true);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                QUISecNavBar.this.O(textView, false);
                return textView;
            }
        });
        this.mCenterTextView = lazy15;
        this.leftImageRes = R.drawable.qui_chevron_left_icon_navigation_02_selector;
        E();
        Q(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes5.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        public static final a f95252d = new a();

        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }
}
