package com.tencent.biz.pubaccount.weishi.verticalvideo.vas;

import NS_MOBILE_FEEDS.s_button;
import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaGdtAdInfo;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.ad.tangram.views.floattips.AdFloatTipsViewContainer;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.WSVerticalDataManager;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.f;
import com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.GdtAdWSCountDownLayout;
import com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.GdtAdWSItemView;
import com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.card.GdtAdWSCardView;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.biz.pubaccount.weishi.verticalvideo.vas.shake.VasAdvShakeButton;
import com.tencent.biz.pubaccount.weishi.verticalvideo.vas.shake.VasAdvShakeIconView;
import com.tencent.biz.pubaccount.weishi.verticalvideo.vas.shake.VasAdvShakeWrapper;
import com.tencent.biz.pubaccount.weishi.view.WSRoundedImageView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.canvas.components.danmaku.GdtDanmakuPresenter;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mvvm.g;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.adv.api.IVasAdvApi;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.LandingPageParams;
import com.tencent.mobileqq.vas.adv.web.api.IVasAdvWeb;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;
import tencent.gdt.qq_common;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 C2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0011B\u001d\u0012\b\u0010\u00b0\u0001\u001a\u00030\u00af\u0001\u0012\b\u0010\u00b2\u0001\u001a\u00030\u00b1\u0001\u00a2\u0006\u0006\b\u00b3\u0001\u0010\u00b4\u0001J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\tH\u0016J9\u0010\"\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0016\u0010!\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010 0\u001f\"\u0004\u0018\u00010 H\u0016\u00a2\u0006\u0004\b\"\u0010#J\b\u0010$\u001a\u00020\u0007H\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u001bH\u0002J\b\u0010'\u001a\u00020\u0007H\u0002J\b\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\n\u0010*\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010+\u001a\u00020\u0007H\u0002J\b\u0010,\u001a\u00020\u0007H\u0002J\b\u0010-\u001a\u00020\u0007H\u0002J\b\u0010.\u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020\u0007H\u0002J\b\u00100\u001a\u00020\u0007H\u0002J\b\u00101\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\b\u00103\u001a\u00020\u0014H\u0002J\b\u00104\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u00020\u0014H\u0002J\u0010\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u0016H\u0002J\b\u00108\u001a\u00020\u0007H\u0002J\b\u00109\u001a\u00020\u0007H\u0002J\b\u0010:\u001a\u00020\u0007H\u0002J\b\u0010;\u001a\u00020\u0007H\u0002J\b\u0010<\u001a\u00020\u0007H\u0002J\b\u0010=\u001a\u00020\u0007H\u0002J\n\u0010>\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010?\u001a\u00020\u0007H\u0002J\b\u0010@\u001a\u00020\u0007H\u0002J\u001c\u0010C\u001a\u00020\u00072\b\u0010A\u001a\u0004\u0018\u00010\u001b2\b\u0010B\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010D\u001a\u00020\u0007H\u0002J\u0019\u0010G\u001a\u00020F2\b\u0010E\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010J\u001a\u00020\u00142\u0006\u0010I\u001a\u00020FH\u0002J\u0010\u0010K\u001a\u00020\u00142\u0006\u0010I\u001a\u00020FH\u0002J\n\u0010M\u001a\u0004\u0018\u00010LH\u0002J\u0010\u0010N\u001a\u00020\u00142\u0006\u0010I\u001a\u00020FH\u0002J\b\u0010O\u001a\u00020\u0007H\u0002J\u0018\u0010Q\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u00142\u0006\u0010I\u001a\u00020FH\u0002J\b\u0010R\u001a\u00020\u0007H\u0002J\b\u0010S\u001a\u00020\u0007H\u0002J\b\u0010T\u001a\u00020\u0007H\u0002J\b\u0010U\u001a\u00020\u0007H\u0002J\u0012\u0010W\u001a\u0004\u0018\u00010\u001b2\u0006\u0010V\u001a\u00020\tH\u0002J\u001a\u0010Y\u001a\u00020\u00142\u0006\u0010V\u001a\u00020\t2\b\u0010X\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010Z\u001a\u00020\u0014H\u0002J\b\u0010[\u001a\u00020\u0014H\u0002R\u0018\u0010]\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\\R\u0018\u0010`\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010dR\u0018\u0010h\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010jR\u0018\u0010n\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010o8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010pR\u0018\u0010t\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010sR\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00107R\u0018\u0010w\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010vR\u0018\u0010z\u001a\u0004\u0018\u00010x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010yR\u0018\u0010}\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010|R\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u007fR\u001c\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001b\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b[\u0010\u0083\u0001R\u001b\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bN\u0010\u0087\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u0087\u0001R\u0019\u0010\u008b\u0001\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010|R$\u0010\u008e\u0001\u001a\u000e\u0012\u0007\u0012\u0005\u0018\u00010\u0081\u0001\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b(\u0010\u008d\u0001R\u0019\u0010\u008f\u0001\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010|R\u001b\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b5\u0010\u0083\u0001R\u001b\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b+\u0010\u0092\u0001R\u001b\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b;\u0010\u0083\u0001R\u001a\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b1\u0010\u0095\u0001R\u001b\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bT\u0010\u0098\u0001R\u001b\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b4\u0010\u009b\u0001R\u001c\u0010\u00a0\u0001\u001a\u0005\u0018\u00010\u009d\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u009f\u0001R\u001b\u0010\u00a3\u0001\u001a\u0005\u0018\u00010\u00a1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b<\u0010\u00a2\u0001R\u0017\u0010\u00a6\u0001\u001a\u00030\u00a4\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b3\u0010\u00a5\u0001R\u0017\u0010\u00a9\u0001\u001a\u00030\u00a7\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bU\u0010\u00a8\u0001R\u0017\u0010\u00aa\u0001\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010(R \u0010\u00ae\u0001\u001a\t\u0012\u0004\u0012\u00020\u00140\u00ab\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00ad\u0001\u00a8\u0006\u00b5\u0001"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/VasAdvWSVerticalItemView;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/b;", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Subscriber;", "Landroid/view/View$OnClickListener;", "Landroid/os/Handler$Callback;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "itemData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "currentPosition", "onPageSelected", "f", "type", "e", "c", "d", "a", "Landroid/os/Message;", "msg", "", "handleMessage", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "position", "setPosition", "", "eventKey", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;", "callback", "", "", "data", "onVasEvent", "(Ljava/lang/String;Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;[Ljava/lang/Object;)V", "recycle", "desc", "T", "N", "Z", UserInfo.SEX_FEMALE, "B", "c0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "O", "E", "Y", "e0", "a0", "j0", "g0", "b0", "inflatedView", "I", "w", "o0", "P", "d0", "i0", "p0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "H", ExifInterface.LATITUDE_SOUTH, "iconUrl", "iconTitle", "n0", "G", "id", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/VasAdvWSVerticalClickAreaId;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Integer;)Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/VasAdvWSVerticalClickAreaId;", TemplateParser.KEY_COMPONENT_ID, HippyTKDListViewAdapter.X, "K", "Lcom/tencent/biz/pubaccount/weishi/player/WSPlayerManager;", "D", "W", "q0", "autoDownloadApp", "L", "M", "l0", "f0", "k0", "key", BdhLogUtil.LogTag.Tag_Conn, "value", "J", "y", "V", "Ljava/lang/String;", "h5AdUrl", "Lcom/tencent/biz/ui/TouchWebView;", "Lcom/tencent/biz/ui/TouchWebView;", "webView", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "wsItemData", "LUserGrowth/stSimpleMetaFeed;", "LUserGrowth/stSimpleMetaFeed;", "feedData", "LUserGrowth/stSimpleMetaGdtAdInfo;", "LUserGrowth/stSimpleMetaGdtAdInfo;", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "pbAdInfo", "Lcom/tencent/gdtad/aditem/GdtAd;", "Lcom/tencent/gdtad/aditem/GdtAd;", "gdtAd", "Lw10/a;", "Lw10/a;", "shakeConfig", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/shake/VasAdvShakeWrapper;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/shake/VasAdvShakeWrapper;", "shakeWrapper", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/gdt/GdtAdWSItemView;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/gdt/GdtAdWSItemView;", "rootContainer", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "adContentContainer", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "adWidgetContainer", "Lcom/tencent/biz/pubaccount/weishi/view/WSRoundedImageView;", "Lcom/tencent/biz/pubaccount/weishi/view/WSRoundedImageView;", "logoView", "Landroid/widget/TextView;", "U", "Landroid/widget/TextView;", "nameView", "descriptionView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "adIconView", "X", "negativeFeedbackView", "industryLabelContainer", "", "Ljava/util/List;", "industryLabelViews", "adBtnView", "adBtnTextViewOriginStyle", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/shake/VasAdvShakeButton;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/shake/VasAdvShakeButton;", "adBtnTextViewLargeStyle", "adBtnTextViewFloatStyle", "Landroid/view/View;", "adBtnArrowFloatStyle", "Lcom/tencent/image/URLImageView;", "Lcom/tencent/image/URLImageView;", "marketingPendantView", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/gdt/GdtAdWSCountDownLayout;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/gdt/GdtAdWSCountDownLayout;", "countdownLayout", "Lcom/tencent/gdtad/views/canvas/components/danmaku/GdtDanmakuPresenter;", "h0", "Lcom/tencent/gdtad/views/canvas/components/danmaku/GdtDanmakuPresenter;", "danmakuView", "Lcom/tencent/ad/tangram/views/floattips/AdFloatTipsViewContainer;", "Lcom/tencent/ad/tangram/views/floattips/AdFloatTipsViewContainer;", "floatTipsContainer", "Landroid/os/Handler;", "Landroid/os/Handler;", "mainHandler", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "showButtonRunnable", "mIsPageSeleted", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "m0", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "exposureResultCallback", "Landroid/content/Context;", "context", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;", "holder", "<init>", "(Landroid/content/Context;Lcom/tencent/biz/pubaccount/weishi/verticalvideo/holder/au;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class VasAdvWSVerticalItemView extends com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b implements VasAdvWebEvent.Subscriber, View.OnClickListener, Handler.Callback {

    /* renamed from: o0, reason: collision with root package name */
    private static final int f82340o0 = Color.parseColor("#66FFFFFF");

    /* renamed from: p0, reason: collision with root package name */
    private static final int f82341p0 = ViewCompat.generateViewId();

    /* renamed from: q0, reason: collision with root package name */
    private static final int f82342q0 = ViewCompat.generateViewId();

    /* renamed from: F, reason: from kotlin metadata */
    private String h5AdUrl;

    /* renamed from: G, reason: from kotlin metadata */
    private TouchWebView webView;

    /* renamed from: H, reason: from kotlin metadata */
    private j wsItemData;

    /* renamed from: I, reason: from kotlin metadata */
    private stSimpleMetaFeed feedData;

    /* renamed from: J, reason: from kotlin metadata */
    private stSimpleMetaGdtAdInfo adInfo;

    /* renamed from: K, reason: from kotlin metadata */
    private qq_ad_get.QQAdGetRsp.AdInfo pbAdInfo;

    /* renamed from: L, reason: from kotlin metadata */
    private GdtAd gdtAd;

    /* renamed from: M, reason: from kotlin metadata */
    private w10.a shakeConfig;

    /* renamed from: N, reason: from kotlin metadata */
    private VasAdvShakeWrapper shakeWrapper;

    /* renamed from: P, reason: from kotlin metadata */
    private int position;

    /* renamed from: Q, reason: from kotlin metadata */
    private GdtAdWSItemView rootContainer;

    /* renamed from: R, reason: from kotlin metadata */
    private LinearLayout adContentContainer;

    /* renamed from: S, reason: from kotlin metadata */
    private ViewGroup adWidgetContainer;

    /* renamed from: T, reason: from kotlin metadata */
    private WSRoundedImageView logoView;

    /* renamed from: U, reason: from kotlin metadata */
    private TextView nameView;

    /* renamed from: V, reason: from kotlin metadata */
    private TextView descriptionView;

    /* renamed from: W, reason: from kotlin metadata */
    private ImageView adIconView;

    /* renamed from: X, reason: from kotlin metadata */
    private ImageView negativeFeedbackView;

    /* renamed from: Y, reason: from kotlin metadata */
    private ViewGroup industryLabelContainer;

    /* renamed from: Z, reason: from kotlin metadata */
    private List<TextView> industryLabelViews;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private ViewGroup adBtnView;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private TextView adBtnTextViewOriginStyle;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private VasAdvShakeButton adBtnTextViewLargeStyle;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private TextView adBtnTextViewFloatStyle;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private View adBtnArrowFloatStyle;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private URLImageView marketingPendantView;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private GdtAdWSCountDownLayout countdownLayout;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private GdtDanmakuPresenter danmakuView;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private AdFloatTipsViewContainer floatTipsContainer;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private final Handler mainHandler;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final Runnable showButtonRunnable;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPageSeleted;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private VasResultCallback<Boolean> exposureResultCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/vas/VasAdvWSVerticalItemView$b", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "", "result", "", "a", "(Ljava/lang/Boolean;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements VasResultCallback<Boolean> {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(Boolean result) {
            stSimpleMetaGdtAdInfo stsimplemetagdtadinfo = VasAdvWSVerticalItemView.this.adInfo;
            if (stsimplemetagdtadinfo == null) {
                return;
            }
            stsimplemetagdtadinfo.isGdtAdImpressionReport = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasAdvWSVerticalItemView(Context context, au holder) {
        super(context, holder);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(holder, "holder");
        this.position = -1;
        this.mainHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.showButtonRunnable = new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.vas.b
            @Override // java.lang.Runnable
            public final void run() {
                VasAdvWSVerticalItemView.X(VasAdvWSVerticalItemView.this);
            }
        };
        this.exposureResultCallback = new b();
    }

    private final VasAdvWSVerticalClickAreaId A(Integer id5) {
        ImageView imageView = this.adIconView;
        if (Intrinsics.areEqual(id5, imageView != null ? Integer.valueOf(imageView.getId()) : null)) {
            return VasAdvWSVerticalClickAreaId.AD_ICON;
        }
        WSRoundedImageView wSRoundedImageView = this.logoView;
        if (Intrinsics.areEqual(id5, wSRoundedImageView != null ? Integer.valueOf(wSRoundedImageView.getId()) : null)) {
            return VasAdvWSVerticalClickAreaId.HOST_AVATAR;
        }
        TextView textView = this.nameView;
        if (Intrinsics.areEqual(id5, textView != null ? Integer.valueOf(textView.getId()) : null)) {
            return VasAdvWSVerticalClickAreaId.HOST_NAME;
        }
        TextView textView2 = this.descriptionView;
        if (Intrinsics.areEqual(id5, textView2 != null ? Integer.valueOf(textView2.getId()) : null)) {
            return VasAdvWSVerticalClickAreaId.AD_DESCRIPTION;
        }
        View view = this.adBtnArrowFloatStyle;
        if (Intrinsics.areEqual(id5, view != null ? Integer.valueOf(view.getId()) : null)) {
            return VasAdvWSVerticalClickAreaId.AD_BUTTON;
        }
        TextView textView3 = this.adBtnTextViewFloatStyle;
        if (Intrinsics.areEqual(id5, textView3 != null ? Integer.valueOf(textView3.getId()) : null)) {
            return VasAdvWSVerticalClickAreaId.AD_BUTTON;
        }
        TextView textView4 = this.adBtnTextViewOriginStyle;
        if (Intrinsics.areEqual(id5, textView4 != null ? Integer.valueOf(textView4.getId()) : null)) {
            return VasAdvWSVerticalClickAreaId.AD_BUTTON;
        }
        VasAdvShakeButton vasAdvShakeButton = this.adBtnTextViewLargeStyle;
        if (Intrinsics.areEqual(id5, vasAdvShakeButton != null ? Integer.valueOf(vasAdvShakeButton.getId()) : null)) {
            return VasAdvWSVerticalClickAreaId.AD_BUTTON;
        }
        ViewGroup viewGroup = this.industryLabelContainer;
        if (Intrinsics.areEqual(id5, viewGroup != null ? Integer.valueOf(viewGroup.getId()) : null)) {
            return VasAdvWSVerticalClickAreaId.INDUSTRY_LABEL;
        }
        ImageView imageView2 = this.negativeFeedbackView;
        if (Intrinsics.areEqual(id5, imageView2 != null ? Integer.valueOf(imageView2.getId()) : null)) {
            return VasAdvWSVerticalClickAreaId.NEGATIVE_FEEDBACK;
        }
        GdtAdWSCountDownLayout gdtAdWSCountDownLayout = this.countdownLayout;
        if (Intrinsics.areEqual(id5, gdtAdWSCountDownLayout != null ? Integer.valueOf(gdtAdWSCountDownLayout.getId()) : null)) {
            return VasAdvWSVerticalClickAreaId.COUNTDOWN_WIDGET;
        }
        URLImageView uRLImageView = this.marketingPendantView;
        if (Intrinsics.areEqual(id5, uRLImageView != null ? Integer.valueOf(uRLImageView.getId()) : null)) {
            return VasAdvWSVerticalClickAreaId.MARKETING_PENDANT_WIDGET;
        }
        GdtDanmakuPresenter gdtDanmakuPresenter = this.danmakuView;
        if (Intrinsics.areEqual(id5, gdtDanmakuPresenter != null ? Integer.valueOf(gdtDanmakuPresenter.getId()) : null)) {
            return VasAdvWSVerticalClickAreaId.DANMAKU_WIDGET;
        }
        if (id5 != null && id5.intValue() == R.id.vlx) {
            return VasAdvWSVerticalClickAreaId.AD_FLOAT_APP_TIPS;
        }
        int i3 = GdtAdWSCardView.f82060f;
        if (id5 != null && id5.intValue() == i3) {
            return VasAdvWSVerticalClickAreaId.CARD_VIEW_AVATAR;
        }
        int i16 = GdtAdWSCardView.D;
        if (id5 != null && id5.intValue() == i16) {
            return VasAdvWSVerticalClickAreaId.CARD_VIEW_NAME;
        }
        int i17 = GdtAdWSCardView.f82059e;
        if (id5 != null && id5.intValue() == i17) {
            return VasAdvWSVerticalClickAreaId.CARD_VIEW_BG;
        }
        int i18 = GdtAdWSCardView.C;
        if (id5 != null && id5.intValue() == i18) {
            return VasAdvWSVerticalClickAreaId.CARD_VIEW_BUTTON;
        }
        int i19 = GdtAdWSCardView.f82063m;
        if (id5 != null && id5.intValue() == i19) {
            return VasAdvWSVerticalClickAreaId.CARD_VIEW_DESC;
        }
        int i26 = GdtAdWSCardView.f82062i;
        if (id5 != null && id5.intValue() == i26) {
            return VasAdvWSVerticalClickAreaId.CARD_VIEW_LABELS;
        }
        int i27 = com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.f82051a;
        if (id5 != null && id5.intValue() == i27) {
            return VasAdvWSVerticalClickAreaId.CARD_VIEW_COUNTDOWN;
        }
        int i28 = com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.f82052b;
        if (id5 != null && id5.intValue() == i28) {
            return VasAdvWSVerticalClickAreaId.CARD_VIEW_MARKET_PENDANT;
        }
        return VasAdvWSVerticalClickAreaId.AD_VIDEO;
    }

    private final View B() {
        if (com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.c(this.gdtAd)) {
            return this.countdownLayout;
        }
        if (com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.e(this.gdtAd)) {
            return this.marketingPendantView;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
    
        if (r0.isValid() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String C(int key) {
        GdtAd gdtAd;
        List<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> expMap;
        GdtAd gdtAd2 = this.gdtAd;
        boolean z16 = gdtAd2 != null;
        if (z16 && (gdtAd = this.gdtAd) != null && (expMap = gdtAd.getExpMap()) != null) {
            int size = expMap.size();
            for (int i3 = 0; i3 < size; i3++) {
                qq_ad_get.QQAdGetRsp.AdInfo.ExpParam expParam = expMap.get(i3);
                if (expParam != null && key == expParam.key.get()) {
                    return expParam.value.get();
                }
            }
        }
        return "";
    }

    private final WSPlayerManager D() {
        f adapter;
        WSVerticalPageFragment wSVerticalPageFragment = this.f82125i;
        if (wSVerticalPageFragment == null || (adapter = wSVerticalPageFragment.getAdapter()) == null) {
            return null;
        }
        return adapter.y();
    }

    private final void E() {
        GdtAdWSItemView gdtAdWSItemView = this.rootContainer;
        ViewGroup viewGroup = gdtAdWSItemView != null ? (ViewGroup) gdtAdWSItemView.findViewById(f82341p0) : null;
        if (viewGroup == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.i(new WeakReference(viewGroup), AdUIUtils.dp2px(279.0f, viewGroup.getResources()), true);
    }

    private final void F() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.h(new WeakReference(this.adContentContainer), 1.0f, 0.0f, 8);
        com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.h(new WeakReference(B()), 1.0f, 0.0f, 8);
    }

    private final void G() {
        GdtAdWSItemView gdtAdWSItemView = this.rootContainer;
        View findViewById = gdtAdWSItemView != null ? gdtAdWSItemView.findViewById(f82342q0) : null;
        if (findViewById == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.h(new WeakReference(findViewById), 1.0f, 0.0f, 8);
    }

    private final void H() {
        w10.a aVar = this.shakeConfig;
        if (aVar == null) {
            return;
        }
        if (aVar.getShowShakeIcon() && aVar.getShowBtnIconNow()) {
            n0(aVar.getShakeIconUrl(), aVar.getShakeIconTitle());
        }
        VasAdvShakeButton vasAdvShakeButton = this.adBtnTextViewLargeStyle;
        if (vasAdvShakeButton != null) {
            vasAdvShakeButton.setIconResUrl(aVar.getShakeIconUrl());
        }
        if (aVar.getShowBtnIconNow()) {
            Context mContext = this.C;
            Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
            GdtAd gdtAd = this.gdtAd;
            this.shakeWrapper = new VasAdvShakeWrapper(mContext, gdtAd != null ? gdtAd.info : null, new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.vas.VasAdvWSVerticalItemView$initShake$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    VasAdvWSVerticalItemView.this.L(false, VasAdvWSVerticalClickAreaId.AD_SHAKE);
                }
            });
            VasAdvShakeButton vasAdvShakeButton2 = this.adBtnTextViewLargeStyle;
            if (vasAdvShakeButton2 != null) {
                vasAdvShakeButton2.setIconVisibility(0);
            }
            this.mainHandler.sendEmptyMessageDelayed(5, 3000L);
            return;
        }
        this.mainHandler.sendEmptyMessageDelayed(6, aVar.getShakeDelayTime() * 1000);
    }

    private final boolean K(VasAdvWSVerticalClickAreaId componentID) {
        return componentID == VasAdvWSVerticalClickAreaId.HOST_AVATAR || componentID == VasAdvWSVerticalClickAreaId.HOST_NAME || componentID == VasAdvWSVerticalClickAreaId.AD_DESCRIPTION || componentID == VasAdvWSVerticalClickAreaId.AD_BUTTON || componentID == VasAdvWSVerticalClickAreaId.AD_ICON || componentID == VasAdvWSVerticalClickAreaId.AD_FLOAT_APP_TIPS || componentID == VasAdvWSVerticalClickAreaId.CARD_VIEW_DESC || componentID == VasAdvWSVerticalClickAreaId.CARD_VIEW_BUTTON || componentID == VasAdvWSVerticalClickAreaId.CARD_VIEW_BG || componentID == VasAdvWSVerticalClickAreaId.CARD_VIEW_NAME || componentID == VasAdvWSVerticalClickAreaId.CARD_VIEW_AVATAR || componentID == VasAdvWSVerticalClickAreaId.AD_VIDEO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(boolean autoDownloadApp, VasAdvWSVerticalClickAreaId componentID) {
        if (W(componentID)) {
            q0();
            return;
        }
        if (x(componentID)) {
            Context context = this.C;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) context;
            GdtAd gdtAd = this.gdtAd;
            if (gdtAd != null) {
                stSimpleMetaGdtAdInfo stsimplemetagdtadinfo = this.adInfo;
                if (stsimplemetagdtadinfo != null) {
                    stsimplemetagdtadinfo.isGdtAdclicked = true;
                }
                ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).toLandingPage(activity, new LandingPageParams(gdtAd, 8, componentID.getValue(), autoDownloadApp, "biz_src_gzh_weishi", V()));
            }
            com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.a.g(this.f82125i, this.wsItemData, componentID);
        }
    }

    private final void M() {
        stSimpleMetaGdtAdInfo stsimplemetagdtadinfo = this.adInfo;
        if (stsimplemetagdtadinfo != null ? stsimplemetagdtadinfo.isGdtAdImpressionReport : true) {
            return;
        }
        String str = stsimplemetagdtadinfo != null ? stsimplemetagdtadinfo.impressionUrl : null;
        if (str == null || this.pbAdInfo == null) {
            return;
        }
        String str2 = str + "&slot=" + (this.position + 1);
        IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
        View mItemView = this.D;
        Intrinsics.checkNotNullExpressionValue(mItemView, "mItemView");
        iVasAdvApi.doExposure(str2, mItemView, this.pbAdInfo, this.exposureResultCallback);
    }

    private final void N() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.a aVar = com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.a.f81865a;
        boolean z16 = false;
        aVar.c(this.f82125i, this.wsItemData, false, false);
        aVar.i(this.f82125i, this.wsItemData);
        stSimpleMetaFeed stsimplemetafeed = this.feedData;
        if (stsimplemetafeed != null && stsimplemetafeed.gdt_ad_type == 1) {
            if ((stsimplemetafeed != null ? stsimplemetafeed.gdt_ad_info : null) != null) {
                stSimpleMetaGdtAdInfo stsimplemetagdtadinfo = this.adInfo;
                if (stsimplemetagdtadinfo != null && stsimplemetagdtadinfo.isGdtAdOriginalImpressionReport) {
                    z16 = true;
                }
                if (!z16) {
                    IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
                    Context mContext = this.C;
                    Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
                    stSimpleMetaFeed stsimplemetafeed2 = this.feedData;
                    boolean doOriginalExposure = iVasAdvApi.doOriginalExposure(mContext, stsimplemetafeed2 != null ? stsimplemetafeed2.gdt_ad_info : null, this.pbAdInfo, this.position + 1);
                    stSimpleMetaGdtAdInfo stsimplemetagdtadinfo2 = this.adInfo;
                    if (stsimplemetagdtadinfo2 != null) {
                        stsimplemetagdtadinfo2.isGdtAdOriginalImpressionReport = doOriginalExposure;
                    }
                }
                M();
            }
        }
    }

    private final void O() {
        LinearLayout linearLayout = this.adContentContainer;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
        }
        LinearLayout linearLayout2 = this.adContentContainer;
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setVisibility(0);
    }

    private final void P() {
        TextView textView = this.adBtnTextViewFloatStyle;
        if (textView != null) {
            textView.setVisibility(8);
        }
        View view = this.adBtnArrowFloatStyle;
        if (view != null) {
            view.setVisibility(8);
        }
        TextView textView2 = this.adBtnTextViewOriginStyle;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        VasAdvShakeButton vasAdvShakeButton = this.adBtnTextViewLargeStyle;
        if (vasAdvShakeButton == null) {
            return;
        }
        vasAdvShakeButton.setVisibility(8);
    }

    private final void Q() {
        this.mainHandler.removeCallbacksAndMessages(null);
        R();
        O();
        S();
    }

    private final void R() {
        URLImageView uRLImageView = this.marketingPendantView;
        if (uRLImageView != null) {
            uRLImageView.clearAnimation();
        }
        URLImageView uRLImageView2 = this.marketingPendantView;
        if (uRLImageView2 != null) {
            uRLImageView2.setVisibility(8);
        }
        GdtAdWSCountDownLayout gdtAdWSCountDownLayout = this.countdownLayout;
        if (gdtAdWSCountDownLayout != null) {
            gdtAdWSCountDownLayout.clearAnimation();
        }
        GdtAdWSCountDownLayout gdtAdWSCountDownLayout2 = this.countdownLayout;
        if (gdtAdWSCountDownLayout2 != null) {
            gdtAdWSCountDownLayout2.l();
        }
        GdtAdWSCountDownLayout gdtAdWSCountDownLayout3 = this.countdownLayout;
        if (gdtAdWSCountDownLayout3 != null) {
            gdtAdWSCountDownLayout3.setVisibility(8);
        }
        ViewGroup viewGroup = this.industryLabelContainer;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        GdtDanmakuPresenter gdtDanmakuPresenter = this.danmakuView;
        if (gdtDanmakuPresenter != null) {
            gdtDanmakuPresenter.setVisibility(8);
        }
        GdtDanmakuPresenter gdtDanmakuPresenter2 = this.danmakuView;
        if (gdtDanmakuPresenter2 != null) {
            gdtDanmakuPresenter2.n();
        }
        GdtAdWSItemView gdtAdWSItemView = this.rootContainer;
        ViewGroup viewGroup2 = gdtAdWSItemView != null ? (ViewGroup) gdtAdWSItemView.findViewById(f82341p0) : null;
        if (viewGroup2 != null) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.g(viewGroup2);
            GdtAdWSItemView gdtAdWSItemView2 = this.rootContainer;
            if (gdtAdWSItemView2 != null) {
                gdtAdWSItemView2.removeView(viewGroup2);
            }
        }
    }

    private final void S() {
        View findViewById;
        GdtAdWSItemView gdtAdWSItemView;
        VasAdvShakeButton vasAdvShakeButton = this.adBtnTextViewLargeStyle;
        if (vasAdvShakeButton != null) {
            vasAdvShakeButton.a();
        }
        VasAdvShakeWrapper vasAdvShakeWrapper = this.shakeWrapper;
        if (vasAdvShakeWrapper != null) {
            vasAdvShakeWrapper.f();
        }
        this.shakeWrapper = null;
        GdtAdWSItemView gdtAdWSItemView2 = this.rootContainer;
        if (gdtAdWSItemView2 == null || (findViewById = gdtAdWSItemView2.findViewById(f82342q0)) == null || (gdtAdWSItemView = this.rootContainer) == null) {
            return;
        }
        gdtAdWSItemView.removeView(findViewById);
    }

    private final void T(String desc) {
        Context context = this.C;
        if (context != null) {
            ImageView imageView = this.adIconView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            String str = desc + "  <img src=\"ad_icon\">";
            Context context2 = this.C;
            final BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeResource(context2 != null ? context2.getResources() : null, R.drawable.odg));
            bitmapDrawable.setBounds(0, 0, AdUIUtils.dp2px(28.0f, context.getResources()), AdUIUtils.dp2px(15.0f, context.getResources()));
            TextView textView = this.descriptionView;
            if (textView == null) {
                return;
            }
            textView.setText(HtmlCompat.fromHtml(str, 63, new Html.ImageGetter() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.vas.c
                @Override // android.text.Html.ImageGetter
                public final Drawable getDrawable(String str2) {
                    Drawable U;
                    U = VasAdvWSVerticalItemView.U(bitmapDrawable, str2);
                    return U;
                }
            }, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable U(BitmapDrawable d16, String str) {
        Intrinsics.checkNotNullParameter(d16, "$d");
        return d16;
    }

    private final boolean W(VasAdvWSVerticalClickAreaId componentID) {
        int screenHeight = AdUIUtils.getScreenHeight(this.C);
        GdtAdWSItemView gdtAdWSItemView = this.rootContainer;
        float a16 = gdtAdWSItemView != null ? gdtAdWSItemView.a() : Float.NEGATIVE_INFINITY;
        GdtAd gdtAd = this.gdtAd;
        return componentID == VasAdvWSVerticalClickAreaId.AD_VIDEO && a16 < (((float) 1) - (gdtAd != null ? ((float) gdtAd.getClickAreaFromBottom()) / 100.0f : Float.NEGATIVE_INFINITY)) * ((float) screenHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(VasAdvWSVerticalItemView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup viewGroup = this$0.adBtnView;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(0);
    }

    private final void Y() {
        GdtLog.i("VasAdvWSVerticalItemView", "[showComponentsInCardContainerWithAnimation]");
        GdtAdWSItemView gdtAdWSItemView = this.rootContainer;
        ViewGroup viewGroup = gdtAdWSItemView != null ? (ViewGroup) gdtAdWSItemView.findViewById(f82341p0) : null;
        if (viewGroup == null) {
            viewGroup = com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.f(this.C, this.gdtAd, z(), this.shakeConfig, new WeakReference(this));
            if (viewGroup == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AdUIUtils.dp2px(279.0f, viewGroup.getResources()), -2);
            layoutParams.bottomMargin = AdUIUtils.dp2px(15.5f, viewGroup.getResources());
            layoutParams.leftMargin = AdUIUtils.dp2px(15.0f, viewGroup.getResources());
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            viewGroup.setLayoutParams(layoutParams);
            viewGroup.setId(f82341p0);
            GdtAdWSItemView gdtAdWSItemView2 = this.rootContainer;
            if (gdtAdWSItemView2 != null) {
                gdtAdWSItemView2.addView(viewGroup);
            }
        }
        int dp2px = AdUIUtils.dp2px(279.0f, viewGroup.getResources());
        viewGroup.setVisibility(0);
        com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.i(new WeakReference(viewGroup), dp2px, false);
    }

    private final void Z() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.h(new WeakReference(this.adContentContainer), 0.0f, 1.0f, 0);
        com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.h(new WeakReference(B()), 0.0f, 1.0f, 0);
    }

    private final void a0() {
        GdtAdWSCountDownLayout gdtAdWSCountDownLayout = this.countdownLayout;
        if (gdtAdWSCountDownLayout != null) {
            GdtAd gdtAd = this.gdtAd;
            gdtAdWSCountDownLayout.n(gdtAd != null ? gdtAd.getCountdownTimeSecs() : Integer.MIN_VALUE);
        }
        GdtAdWSCountDownLayout gdtAdWSCountDownLayout2 = this.countdownLayout;
        if (gdtAdWSCountDownLayout2 == null) {
            return;
        }
        gdtAdWSCountDownLayout2.setVisibility(0);
    }

    private final boolean b0() {
        GdtDanmakuPresenter gdtDanmakuPresenter = this.danmakuView;
        if (gdtDanmakuPresenter == null) {
            return false;
        }
        try {
            IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
            stSimpleMetaGdtAdInfo stsimplemetagdtadinfo = this.adInfo;
            String[] gdtDanmakuStrContents = iVasAdvApi.getGdtDanmakuStrContents(stsimplemetagdtadinfo != null ? stsimplemetagdtadinfo.gdtTangramAdJson : null);
            boolean z16 = true;
            if (gdtDanmakuStrContents != null) {
                if (!(gdtDanmakuStrContents.length == 0)) {
                    z16 = false;
                }
            }
            if (z16) {
                if (gdtDanmakuPresenter.k()) {
                    gdtDanmakuPresenter.n();
                }
                gdtDanmakuPresenter.setVisibility(8);
                return false;
            }
            gdtDanmakuPresenter.j(AdUIUtils.getScreenWidth(this.C), gdtDanmakuStrContents);
            boolean m3 = gdtDanmakuPresenter.m();
            gdtDanmakuPresenter.setVisibility(m3 ? 0 : 8);
            return m3;
        } catch (Throwable th5) {
            GdtLog.e("VasAdvWSVerticalItemView", "fail to get danmaku contents", th5);
            gdtDanmakuPresenter.setVisibility(8);
            return false;
        }
    }

    private final void c0() {
        b0();
        if (com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.c(this.gdtAd)) {
            a0();
        } else if (com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.e(this.gdtAd)) {
            j0();
        }
        if (com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.d(this.gdtAd)) {
            g0();
        }
        this.mainHandler.sendEmptyMessageDelayed(1, 6000L);
    }

    private final void d0() {
        Context context = this.C;
        float dp2px = AdUIUtils.dp2px(4.0f, context != null ? context.getResources() : null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(2136233044);
        gradientDrawable.setCornerRadii(new float[]{dp2px, dp2px, 0.0f, 0.0f, 0.0f, 0.0f, dp2px, dp2px});
        TextView textView = this.adBtnTextViewFloatStyle;
        if (textView != null) {
            g.a(textView, gradientDrawable);
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(2136233044);
        gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, dp2px, dp2px, dp2px, dp2px, 0.0f, 0.0f});
        View view = this.adBtnArrowFloatStyle;
        if (view != null) {
            g.a(view, gradientDrawable2);
        }
        TextView textView2 = this.adBtnTextViewFloatStyle;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        View view2 = this.adBtnArrowFloatStyle;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(0);
    }

    private final void e0() {
        List<qq_common.FloatingTip> floatingTips;
        View appTipsView;
        View industrialView;
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd == null || (floatingTips = gdtAd.getFloatingTips()) == null) {
            return;
        }
        if (floatingTips.isEmpty()) {
            AdFloatTipsViewContainer adFloatTipsViewContainer = this.floatTipsContainer;
            if (adFloatTipsViewContainer != null) {
                adFloatTipsViewContainer.onRecycle();
                return;
            }
            return;
        }
        Object obj = this.f82126m.f82127d;
        com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b bVar = obj instanceof com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b ? (com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b) obj : null;
        com.tencent.biz.pubaccount.weishi.baseui.b<j> k3 = bVar != null ? bVar.k() : null;
        if (k3 == null) {
            return;
        }
        AdFloatTipsViewContainer.Params params = null;
        AdFloatTipsViewContainer.Params params2 = null;
        for (qq_common.FloatingTip floatingTip : floatingTips) {
            AdFloatTipsViewContainer.Params params3 = new AdFloatTipsViewContainer.Params();
            params3.text = floatingTip.text.get();
            params3.textColor = Color.parseColor("#FFFFFFFF");
            Context context = this.C;
            params3.textSize = AdUIUtils.dp2px(9.0f, context != null ? context.getResources() : null);
            Context context2 = this.C;
            params3.iconSize = AdUIUtils.dp2px(9.0f, context2 != null ? context2.getResources() : null);
            params3.iconUrl = floatingTip.icon_url.get();
            if (floatingTip.type.get() == 1) {
                params = params3;
            } else if (floatingTip.type.get() == 2) {
                params2 = params3;
            }
        }
        AdFloatTipsViewContainer adFloatTipsViewContainer2 = this.floatTipsContainer;
        if (adFloatTipsViewContainer2 == null) {
            AdFloatTipsViewContainer adFloatTipsViewContainer3 = new AdFloatTipsViewContainer(this.C, params, params2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(3, R.id.f1181873g);
            Context context3 = this.C;
            int dp2px = AdUIUtils.dp2px(8.0f, context3 != null ? context3.getResources() : null);
            Context context4 = this.C;
            int dp2px2 = AdUIUtils.dp2px(10.0f, context4 != null ? context4.getResources() : null);
            Context context5 = this.C;
            int dp2px3 = AdUIUtils.dp2px(8.0f, context5 != null ? context5.getResources() : null);
            Context context6 = this.C;
            layoutParams.setMargins(dp2px, dp2px2, dp2px3, AdUIUtils.dp2px(10.0f, context6 != null ? context6.getResources() : null));
            adFloatTipsViewContainer3.setLayoutParams(layoutParams);
            k3.o(adFloatTipsViewContainer3);
            this.floatTipsContainer = adFloatTipsViewContainer3;
            GdtLog.i("VasAdvWSVerticalItemView", "[showFloatTips] container is added");
        } else {
            if (adFloatTipsViewContainer2 != null) {
                adFloatTipsViewContainer2.resetTipsView(params, params2);
            }
            GdtLog.i("VasAdvWSVerticalItemView", "[showFloatTips] container is reused");
        }
        AdFloatTipsViewContainer adFloatTipsViewContainer4 = this.floatTipsContainer;
        if (adFloatTipsViewContainer4 != null && (industrialView = adFloatTipsViewContainer4.getIndustrialView()) != null) {
            industrialView.setOnClickListener(null);
        }
        AdFloatTipsViewContainer adFloatTipsViewContainer5 = this.floatTipsContainer;
        View appTipsView2 = adFloatTipsViewContainer5 != null ? adFloatTipsViewContainer5.getAppTipsView() : null;
        if (appTipsView2 != null) {
            appTipsView2.setId(R.id.vlx);
        }
        AdFloatTipsViewContainer adFloatTipsViewContainer6 = this.floatTipsContainer;
        if (adFloatTipsViewContainer6 == null || (appTipsView = adFloatTipsViewContainer6.getAppTipsView()) == null) {
            return;
        }
        appTipsView.setOnClickListener(this);
    }

    private final void f0() {
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null) {
            touchWebView.setVisibility(0);
        }
        LinearLayout linearLayout = this.adContentContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(4);
        }
        ImageView imageView = this.negativeFeedbackView;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void g0() {
        List<TextView> list;
        Object orNull;
        boolean z16;
        boolean isBlank;
        List<String> industryLabels = ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).getIndustryLabels(this.pbAdInfo);
        if (industryLabels != null && (list = this.industryLabelViews) != null) {
            int i3 = 0;
            for (Object obj : list) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                TextView textView = (TextView) obj;
                if (textView != null) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(industryLabels, i3);
                    String str = (String) orNull;
                    if (str != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(str);
                        if (!isBlank) {
                            z16 = false;
                            textView.setVisibility(z16 ? 0 : 8);
                            textView.setText(str);
                        }
                    }
                    z16 = true;
                    textView.setVisibility(z16 ? 0 : 8);
                    textView.setText(str);
                }
                i3 = i16;
            }
        }
        ViewGroup viewGroup = this.industryLabelContainer;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(0);
    }

    private final void i0() {
        float dp2px = AdUIUtils.dp2px(50.0f, this.C.getResources());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-11250604);
        gradientDrawable.setCornerRadius(dp2px);
        VasAdvShakeButton vasAdvShakeButton = this.adBtnTextViewLargeStyle;
        if (vasAdvShakeButton != null) {
            g.a(vasAdvShakeButton, gradientDrawable);
        }
        VasAdvShakeButton vasAdvShakeButton2 = this.adBtnTextViewLargeStyle;
        if (vasAdvShakeButton2 != null) {
            vasAdvShakeButton2.setVisibility(0);
        }
        this.mainHandler.sendEmptyMessageDelayed(3, 3000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020 A[Catch: all -> 0x002c, TryCatch #0 {all -> 0x002c, blocks: (B:5:0x0007, B:7:0x000b, B:10:0x0014, B:15:0x0020, B:18:0x0024), top: B:4:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0024 A[Catch: all -> 0x002c, TRY_LEAVE, TryCatch #0 {all -> 0x002c, blocks: (B:5:0x0007, B:7:0x000b, B:10:0x0014, B:15:0x0020, B:18:0x0024), top: B:4:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean j0() {
        boolean z16;
        URLImageView uRLImageView = this.marketingPendantView;
        if (uRLImageView == null) {
            return false;
        }
        try {
            GdtAd gdtAd = this.gdtAd;
            String marketPendantImageUrl = gdtAd != null ? gdtAd.getMarketPendantImageUrl() : null;
            if (marketPendantImageUrl != null && marketPendantImageUrl.length() != 0) {
                z16 = false;
                if (!z16) {
                    uRLImageView.setVisibility(8);
                    return false;
                }
                uRLImageView.setImageURL(marketPendantImageUrl);
                uRLImageView.setVisibility(0);
                return true;
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Throwable th5) {
            GdtLog.e("VasAdvWSVerticalItemView", "fail to get marketing pendant url", th5);
            uRLImageView.setVisibility(8);
            return false;
        }
    }

    private final void k0() {
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null) {
            touchWebView.setVisibility(8);
        }
        LinearLayout linearLayout = this.adContentContainer;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        ImageView imageView = this.negativeFeedbackView;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(0);
    }

    private final void l0() {
        VasAdvShakeWrapper vasAdvShakeWrapper = this.shakeWrapper;
        if (vasAdvShakeWrapper != null) {
            vasAdvShakeWrapper.g();
        }
        AdFeedbackDialogFragment.Listener listener = new AdFeedbackDialogFragment.Listener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.vas.a
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                VasAdvWSVerticalItemView.m0(VasAdvWSVerticalItemView.this, result);
            }
        };
        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
        Context context = this.C;
        adFeedbackParams.activity = new WeakReference<>(context instanceof Activity ? (Activity) context : null);
        adFeedbackParams.listener = new WeakReference<>(listener);
        adFeedbackParams.f61346ad = new GdtAd(this.pbAdInfo);
        adFeedbackParams.styleId = 0;
        adFeedbackParams.isDarkMode = QQTheme.isNowThemeIsNight();
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
        } catch (Throwable th5) {
            QLog.e("VasAdvWSVerticalItemView", 1, "showNegativeFeedback", th5);
        }
        ImageView imageView = this.negativeFeedbackView;
        if (imageView == null) {
            return;
        }
        imageView.setTag(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(VasAdvWSVerticalItemView this$0, AdFeedbackDialogFragment.Result result) {
        f adapter;
        AdError adError;
        AdError adError2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VasAdvShakeWrapper vasAdvShakeWrapper = this$0.shakeWrapper;
        if (vasAdvShakeWrapper != null) {
            vasAdvShakeWrapper.e();
        }
        boolean z16 = false;
        if (result != null && (adError2 = result.result) != null && adError2.getErrorCode() == 0) {
            z16 = true;
        }
        if (!z16) {
            GdtLog.i("VasAdvWSVerticalItemView", "[onResult] fail, errorCode=" + ((result == null || (adError = result.result) == null) ? null : Integer.valueOf(adError.getErrorCode())));
            return;
        }
        if (result.action == 3) {
            WSVerticalPageFragment wSVerticalPageFragment = this$0.f82125i;
            if (wSVerticalPageFragment != null && (adapter = wSVerticalPageFragment.getAdapter()) != null) {
                adapter.removeItem(this$0.position);
            }
            GdtLog.i("VasAdvWSVerticalItemView", "[onResult] hide ad");
        }
    }

    private final void n0(String iconUrl, String iconTitle) {
        VasAdvShakeIconView vasAdvShakeIconView = new VasAdvShakeIconView(this.C, null, 0, 0, 14, null);
        vasAdvShakeIconView.setData(iconUrl, iconTitle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        vasAdvShakeIconView.setLayoutParams(layoutParams);
        vasAdvShakeIconView.setId(f82342q0);
        GdtAdWSItemView gdtAdWSItemView = this.rootContainer;
        if (gdtAdWSItemView != null) {
            gdtAdWSItemView.addView(vasAdvShakeIconView);
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.h(new WeakReference(vasAdvShakeIconView), 0.0f, 1.0f, 0);
    }

    private final void o0() {
        if (this.C == null) {
            return;
        }
        p0();
        P();
        if (y()) {
            d0();
        } else {
            i0();
        }
    }

    private final void p0() {
        String z16 = z();
        TextView textView = this.adBtnTextViewOriginStyle;
        if (textView != null) {
            textView.setText(z16);
        }
        TextView textView2 = this.adBtnTextViewFloatStyle;
        if (textView2 != null) {
            textView2.setText(z16);
        }
        VasAdvShakeButton vasAdvShakeButton = this.adBtnTextViewLargeStyle;
        if (vasAdvShakeButton != null) {
            vasAdvShakeButton.setText(z16);
        }
        stSimpleMetaFeed stsimplemetafeed = this.feedData;
        stNewIconStyle stnewiconstyle = stsimplemetafeed != null ? stsimplemetafeed.new_icon : null;
        if (stnewiconstyle == null) {
            return;
        }
        stnewiconstyle.title = z16;
    }

    private final void q0() {
        WSPlayerManager D = D();
        Integer valueOf = D != null ? Integer.valueOf(D.k0()) : null;
        if (valueOf != null && valueOf.intValue() == 3) {
            GdtLog.i("VasAdvWSVerticalItemView", "[updateVideoState] pause");
            D.K0();
            return;
        }
        if (valueOf != null && valueOf.intValue() == 5) {
            GdtLog.i("VasAdvWSVerticalItemView", "[updateVideoState] start");
            D.O0();
        } else {
            if (valueOf == null) {
                GdtLog.i("VasAdvWSVerticalItemView", "[updateVideoState] null");
                return;
            }
            GdtLog.i("VasAdvWSVerticalItemView", "[updateVideoState] " + valueOf);
        }
    }

    private final void w() {
        GdtAdWSItemView gdtAdWSItemView;
        TouchWebView touchWebView = this.webView;
        if (touchWebView == null || (gdtAdWSItemView = this.rootContainer) == null) {
            return;
        }
        gdtAdWSItemView.addView(touchWebView);
    }

    private final boolean x(VasAdvWSVerticalClickAreaId componentID) {
        if (componentID == VasAdvWSVerticalClickAreaId.AD_SHAKE) {
            return true;
        }
        GdtAd gdtAd = this.gdtAd;
        Integer valueOf = gdtAd != null ? Integer.valueOf(gdtAd.getClickMode()) : null;
        if (valueOf != null && valueOf.intValue() == 10) {
            return true;
        }
        if (valueOf != null && valueOf.intValue() == 13) {
            if (componentID == VasAdvWSVerticalClickAreaId.AD_BUTTON || componentID == VasAdvWSVerticalClickAreaId.AD_FLOAT_APP_TIPS || componentID == VasAdvWSVerticalClickAreaId.CARD_VIEW_BUTTON || componentID == VasAdvWSVerticalClickAreaId.AD_VIDEO) {
                return true;
            }
        } else if (valueOf != null && valueOf.intValue() == 11) {
            if (K(componentID) || componentID == VasAdvWSVerticalClickAreaId.DANMAKU_WIDGET || componentID == VasAdvWSVerticalClickAreaId.MARKETING_PENDANT_WIDGET || componentID == VasAdvWSVerticalClickAreaId.COUNTDOWN_WIDGET || componentID == VasAdvWSVerticalClickAreaId.INDUSTRY_LABEL || componentID == VasAdvWSVerticalClickAreaId.CARD_VIEW_MARKET_PENDANT || componentID == VasAdvWSVerticalClickAreaId.CARD_VIEW_COUNTDOWN || componentID == VasAdvWSVerticalClickAreaId.CARD_VIEW_LABELS) {
                return true;
            }
        } else {
            if (valueOf != null && valueOf.intValue() == 12) {
                return K(componentID);
            }
            return K(componentID);
        }
        return false;
    }

    private final boolean y() {
        GdtAd gdtAd = this.gdtAd;
        if (gdtAd != null && gdtAd.canBidAdShake()) {
            return false;
        }
        return J(113084, "1") || J(113084, "3");
    }

    private final String z() {
        s_button s_buttonVar;
        s_button s_buttonVar2;
        qq_ad_get.QQAdGetRsp.AdInfo.AppInfo appInfo;
        PBStringField pBStringField;
        PBUInt32Field pBUInt32Field;
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.pbAdInfo;
        boolean z16 = false;
        if (adInfo != null && (pBUInt32Field = adInfo.product_type) != null && pBUInt32Field.get() == 12) {
            z16 = true;
        }
        qq_ad_get.QQAdGetRsp.AdInfo adInfo2 = this.pbAdInfo;
        String str = (adInfo2 == null || (appInfo = adInfo2.app_info) == null || (pBStringField = appInfo.app_package_name) == null) ? null : pBStringField.get();
        IVasAdvApi iVasAdvApi = (IVasAdvApi) QRoute.api(IVasAdvApi.class);
        Context mContext = this.C;
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        boolean isAppInstalled = iVasAdvApi.isAppInstalled(mContext, str);
        if (z16) {
            if (isAppInstalled) {
                return this.C.getString(R.string.n1q);
            }
            return this.C.getString(R.string.vki);
        }
        stSimpleMetaGdtAdInfo stsimplemetagdtadinfo = this.adInfo;
        if (!TextUtils.isEmpty((stsimplemetagdtadinfo == null || (s_buttonVar2 = stsimplemetagdtadinfo.bottomButton) == null) ? null : s_buttonVar2.text)) {
            stSimpleMetaGdtAdInfo stsimplemetagdtadinfo2 = this.adInfo;
            if (stsimplemetagdtadinfo2 == null || (s_buttonVar = stsimplemetagdtadinfo2.bottomButton) == null) {
                return null;
            }
            return s_buttonVar.text;
        }
        return this.C.getString(R.string.v6d);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void a() {
        super.a();
        String i3 = WSVerticalDataManager.j().i();
        this.h5AdUrl = i3;
        Context context = this.C;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (!TextUtils.isEmpty(i3) && activity != null) {
            this.webView = ((IVasAdvWeb) QRoute.api(IVasAdvWeb.class)).getWebView(activity);
        }
        this.D.setOnClickListener(this);
        ViewStub viewStub = (ViewStub) this.D.findViewById(R.id.f1181473c);
        if (viewStub != null) {
            viewStub.setLayoutResource(R.layout.f169170i31);
            View inflate = viewStub.inflate();
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate()");
            I(inflate);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void c() {
        ((IVasAdvWeb) QRoute.api(IVasAdvWeb.class)).unsubscribe("ws_video_ad_h5_cover", this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void e(int type) {
        GdtLog.i("VasAdvWSVerticalItemView", "[updateUi] " + this.position);
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void f(int currentPosition) {
        super.f(currentPosition);
        GdtLog.i("VasAdvWSVerticalItemView", "[onPageUnselected]");
        Q();
        this.mIsPageSeleted = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a6, code lost:
    
        return false;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        GdtLog.i("VasAdvWSVerticalItemView", "[handleMessage]" + msg2.what);
        switch (msg2.what) {
            case 1:
                F();
                Y();
                com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.a.d(com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.a.f81865a, this.f82125i, this.wsItemData, true, false, 8, null);
                break;
            case 2:
                Z();
                E();
                com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.a.k(this.f82125i, this.wsItemData);
                break;
            case 3:
                com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.b.j(new WeakReference(this.adBtnTextViewLargeStyle), -11250604, -8437761);
                com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.a.f81865a.c(this.f82125i, this.wsItemData, false, true);
                break;
            case 4:
                ViewGroup viewGroup = this.adBtnView;
                if (viewGroup != null) {
                    viewGroup.setVisibility(0);
                    break;
                }
                break;
            case 5:
                G();
                VasAdvShakeButton vasAdvShakeButton = this.adBtnTextViewLargeStyle;
                if (vasAdvShakeButton != null) {
                    VasAdvShakeButton.d(vasAdvShakeButton, 0, 0, 3, null);
                    break;
                }
                break;
            case 6:
                Context mContext = this.C;
                Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
                GdtAd gdtAd = this.gdtAd;
                this.shakeWrapper = new VasAdvShakeWrapper(mContext, gdtAd != null ? gdtAd.info : null, new Function0<Unit>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.vas.VasAdvWSVerticalItemView$handleMessage$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        VasAdvWSVerticalItemView.this.L(false, VasAdvWSVerticalClickAreaId.AD_SHAKE);
                    }
                });
                VasAdvShakeButton vasAdvShakeButton2 = this.adBtnTextViewLargeStyle;
                if (vasAdvShakeButton2 != null) {
                    vasAdvShakeButton2.setIconVisibility(0);
                }
                VasAdvShakeButton vasAdvShakeButton3 = this.adBtnTextViewLargeStyle;
                if (vasAdvShakeButton3 != null) {
                    VasAdvShakeButton.d(vasAdvShakeButton3, 0, 0, 3, null);
                    break;
                }
                break;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        stSimpleMetaFeed stsimplemetafeed = this.feedData;
        if (stsimplemetafeed != null && stsimplemetafeed.gdt_ad_type == 1) {
            if ((stsimplemetafeed != null ? stsimplemetafeed.gdt_ad_info : null) != null) {
                M();
            }
        }
        VasAdvWSVerticalClickAreaId A = A(v3 != null ? Integer.valueOf(v3.getId()) : null);
        GdtLog.i("VasAdvWSVerticalItemView", "click on pos " + A.name());
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.y_i) {
            l0();
            return;
        }
        int i3 = GdtAdWSCardView.f82061h;
        if (valueOf != null && valueOf.intValue() == i3) {
            this.mainHandler.sendEmptyMessage(2);
        } else if (valueOf != null && valueOf.intValue() == R.id.yrf) {
            L(true, A);
        } else {
            L(false, A);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void onPageSelected(int currentPosition) {
        GdtLog.i("VasAdvWSVerticalItemView", "[onPageSelected]");
        if (this.mIsPageSeleted) {
            return;
        }
        GdtLog.i("VasAdvWSVerticalItemView", "[onPageSelected] init and show");
        this.mIsPageSeleted = true;
        N();
        c0();
        o0();
        H();
    }

    @Override // com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Subscriber
    public void onVasEvent(String eventKey, VasAdvWebEvent.Callback callback, Object... data) {
        Integer num;
        Intrinsics.checkNotNullParameter(eventKey, "eventKey");
        Intrinsics.checkNotNullParameter(data, "data");
        int hashCode = eventKey.hashCode();
        if (hashCode == -62987789) {
            if (eventKey.equals("notify_web_status")) {
                Object obj = data[0];
                num = obj instanceof Integer ? (Integer) obj : null;
                if (num != null && num.intValue() == 2) {
                    f0();
                    return;
                } else {
                    k0();
                    return;
                }
            }
            return;
        }
        if (hashCode != -39557675) {
            if (hashCode == 1540946822 && eventKey.equals("handle_web_click")) {
                Object obj2 = data[0];
                num = obj2 instanceof Integer ? (Integer) obj2 : null;
                if (num != null && num.intValue() == 0) {
                    L(false, VasAdvWSVerticalClickAreaId.AD_VIDEO);
                    return;
                }
                if ((((num != null && num.intValue() == 1) || (num != null && num.intValue() == 2)) || (num != null && num.intValue() == 3)) || (num != null && num.intValue() == 4)) {
                    r4 = true;
                }
                if (r4) {
                    L(true, VasAdvWSVerticalClickAreaId.AD_BUTTON);
                    return;
                } else {
                    if (num != null && num.intValue() == 5) {
                        l0();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (eventKey.equals("get_gdt_ad_data")) {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo = this.pbAdInfo;
            String convertPbToJson = adInfo != null ? ((IVasAdvApi) QRoute.api(IVasAdvApi.class)).convertPbToJson(adInfo) : null;
            if (convertPbToJson == null || convertPbToJson.length() == 0) {
                if (callback != null) {
                    callback.onResult(null, "adInfo is null");
                }
            } else if (callback != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("adInfo", convertPbToJson);
                callback.onResult(jSONObject, null);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    /* renamed from: q */
    public void setData(j itemData) {
        super.setData(itemData);
        this.wsItemData = itemData;
        this.feedData = itemData != null ? itemData.e() : null;
        this.adInfo = itemData != null ? itemData.a() : null;
        this.pbAdInfo = com.tencent.biz.pubaccount.weishi.verticalvideo.gdt.a.d(this.feedData);
        GdtAd gdtAd = new GdtAd(this.pbAdInfo);
        this.shakeConfig = gdtAd.canBidAdShake() ? new w10.a(gdtAd) : null;
        this.gdtAd = gdtAd;
        stSimpleMetaFeed stsimplemetafeed = this.feedData;
        if (stsimplemetafeed != null) {
            WSRoundedImageView wSRoundedImageView = this.logoView;
            if (wSRoundedImageView != null) {
                WSPicLoader g16 = WSPicLoader.g();
                Context context = this.C;
                stSimpleMetaPerson stsimplemetaperson = stsimplemetafeed.poster;
                g16.j(context, wSRoundedImageView, stsimplemetaperson != null ? stsimplemetaperson.avatar : null);
            }
            TextView textView = this.nameView;
            if (textView != null) {
                stSimpleMetaPerson stsimplemetaperson2 = stsimplemetafeed.poster;
                textView.setText(stsimplemetaperson2 != null ? stsimplemetaperson2.nick : null);
            }
            String str = stsimplemetafeed.feed_desc;
            Intrinsics.checkNotNullExpressionValue(str, "it.feed_desc");
            T(str);
            e0();
        }
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null) {
            ((IVasAdvWeb) QRoute.api(IVasAdvWeb.class)).subscribe("ws_video_ad_h5_cover", this);
            if (touchWebView.getUrl() != null) {
                touchWebView.clearHistory();
            }
            touchWebView.loadUrl(this.h5AdUrl);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void recycle() {
        Q();
        this.mIsPageSeleted = false;
        this.countdownLayout = null;
        this.danmakuView = null;
        super.recycle();
    }

    @Override // com.tencent.biz.pubaccount.weishi.verticalvideo.holder.b, com.tencent.biz.pubaccount.weishi.baseui.c
    public void setPosition(int position) {
        super.setPosition(position);
        this.position = position;
    }

    private final void I(View inflatedView) {
        List<TextView> mutableListOf;
        GdtAdWSItemView gdtAdWSItemView = (GdtAdWSItemView) inflatedView.findViewById(R.id.f1182573n);
        this.rootContainer = gdtAdWSItemView;
        if (gdtAdWSItemView != null) {
            gdtAdWSItemView.setOnClickListener(this);
        }
        this.adContentContainer = (LinearLayout) inflatedView.findViewById(R.id.yrf);
        this.adWidgetContainer = (ViewGroup) inflatedView.findViewById(R.id.f760740o);
        WSRoundedImageView wSRoundedImageView = (WSRoundedImageView) inflatedView.findViewById(R.id.f75163y8);
        this.logoView = wSRoundedImageView;
        if (wSRoundedImageView != null) {
            wSRoundedImageView.setStrokeWidth(8);
            wSRoundedImageView.setStrokeColor(f82340o0);
            wSRoundedImageView.setOnClickListener(this);
        }
        TextView textView = (TextView) inflatedView.findViewById(R.id.f112416nv);
        this.nameView = textView;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        TextView textView2 = (TextView) inflatedView.findViewById(R.id.f112406nu);
        this.descriptionView = textView2;
        if (textView2 != null) {
            textView2.setOnClickListener(this);
        }
        ImageView imageView = (ImageView) inflatedView.findViewById(R.id.y_i);
        this.negativeFeedbackView = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        this.adBtnView = (ViewGroup) inflatedView.findViewById(R.id.f112356np);
        TextView textView3 = (TextView) inflatedView.findViewById(R.id.f112396nt);
        this.adBtnTextViewOriginStyle = textView3;
        if (textView3 != null) {
            textView3.setOnClickListener(this);
        }
        VasAdvShakeButton vasAdvShakeButton = (VasAdvShakeButton) inflatedView.findViewById(R.id.f112386ns);
        this.adBtnTextViewLargeStyle = vasAdvShakeButton;
        if (vasAdvShakeButton != null) {
            vasAdvShakeButton.setOnClickListener(this);
        }
        TextView textView4 = (TextView) inflatedView.findViewById(R.id.f112376nr);
        this.adBtnTextViewFloatStyle = textView4;
        if (textView4 != null) {
            textView4.setOnClickListener(this);
        }
        View findViewById = inflatedView.findViewById(R.id.f112366nq);
        this.adBtnArrowFloatStyle = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        ImageView imageView2 = (ImageView) inflatedView.findViewById(R.id.vli);
        this.adIconView = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(this);
        }
        GdtAdWSCountDownLayout gdtAdWSCountDownLayout = (GdtAdWSCountDownLayout) inflatedView.findViewById(R.id.f116316ye);
        this.countdownLayout = gdtAdWSCountDownLayout;
        if (gdtAdWSCountDownLayout != null) {
            gdtAdWSCountDownLayout.setOnClickListener(this);
        }
        URLImageView uRLImageView = (URLImageView) inflatedView.findViewById(R.id.f116336yg);
        this.marketingPendantView = uRLImageView;
        if (uRLImageView != null) {
            uRLImageView.setOnClickListener(this);
        }
        ViewGroup viewGroup = (ViewGroup) inflatedView.findViewById(R.id.yop);
        this.industryLabelContainer = viewGroup;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf((TextView) inflatedView.findViewById(R.id.vmf), (TextView) inflatedView.findViewById(R.id.vmg), (TextView) inflatedView.findViewById(R.id.vmh));
        this.industryLabelViews = mutableListOf;
        GdtDanmakuPresenter gdtDanmakuPresenter = (GdtDanmakuPresenter) inflatedView.findViewById(R.id.f116326yf);
        this.danmakuView = gdtDanmakuPresenter;
        if (gdtDanmakuPresenter != null) {
            gdtDanmakuPresenter.setOnClickListener(this);
        }
        w();
    }

    private final boolean J(int key, String value) {
        return value != null && value.equals(C(key));
    }

    private final boolean V() {
        return J(113490, "1");
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void d() {
    }
}
