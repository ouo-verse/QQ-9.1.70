package com.tencent.mobileqq.ad.cardad.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.inject.GdtThirdProcessorProxy;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.util.GdtAntiSpamReportHelper;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ad.api.IAdApi;
import com.tencent.mobileqq.ad.cardad.data.aa;
import com.tencent.mobileqq.ad.cardad.data.ab;
import com.tencent.mobileqq.ad.cardad.data.ac;
import com.tencent.mobileqq.ad.cardad.data.x;
import com.tencent.mobileqq.ad.cardad.data.y;
import com.tencent.mobileqq.ad.cardad.data.z;
import com.tencent.mobileqq.ad.cardad.views.CardAdShakeView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.adv.maskad.MaskAdConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000  2\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u0087\u0002\u0088\u0002\u0089\u0002B'\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0083\u0002\u001a\u00030\u00ba\u0001\u0012\n\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u00e9\u0001\u00a2\u0006\u0006\b\u0085\u0002\u0010\u0086\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\b\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0014J\b\u0010\u001d\u001a\u00020\u0013H\u0014J\b\u0010\u001e\u001a\u00020\u0004H\u0014J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0006H\u0014J\b\u0010!\u001a\u00020\u0006H\u0007J\b\u0010\"\u001a\u00020\u0006H\u0007J\b\u0010#\u001a\u00020\u0006H\u0007J\b\u0010$\u001a\u00020\u0006H\u0015J\b\u0010%\u001a\u00020\u0006H\u0016J\b\u0010&\u001a\u00020\u0006H\u0014J\u000e\u0010)\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010,\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0004J\b\u0010.\u001a\u00020-H\u0016J\u0010\u00100\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0010H\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0004J\b\u00102\u001a\u00020\u0006H\u0016J\u001a\u00105\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u00104\u001a\u000203H\u0004J\b\u00106\u001a\u00020\u0006H\u0016J\b\u00107\u001a\u00020\u0006H\u0016J\b\u00108\u001a\u00020\u0006H\u0016J\b\u00109\u001a\u00020\u0006H\u0016J\b\u0010:\u001a\u00020\u0006H\u0016J\b\u0010;\u001a\u00020\u0006H\u0016J\u000e\u0010=\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u000eJ\u000e\u0010?\u001a\u00020\u00062\u0006\u0010>\u001a\u000203J\u0010\u0010@\u001a\u00020\u00062\u0006\u0010>\u001a\u000203H\u0016J\u0010\u0010B\u001a\u00020\u00062\u0006\u0010A\u001a\u000203H\u0016J\u0010\u0010D\u001a\u00020\u00062\u0006\u0010C\u001a\u000203H\u0016J\u0010\u0010F\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u0013H\u0016J\u0010\u0010I\u001a\u00020\u00062\u0006\u0010H\u001a\u00020GH\u0016J\u0010\u0010K\u001a\u00020\u00062\u0006\u0010H\u001a\u00020JH\u0016J\b\u0010L\u001a\u00020\u0004H\u0016J\b\u0010M\u001a\u00020\u0006H\u0016J\u0012\u0010O\u001a\u00020\u00062\b\b\u0002\u0010N\u001a\u000203H\u0016J\b\u0010P\u001a\u00020\u0006H\u0016J\b\u0010Q\u001a\u00020\u0006H\u0016J\b\u0010R\u001a\u00020\u0006H\u0016J\u0006\u0010S\u001a\u00020\u0006J\u0006\u0010T\u001a\u00020\u0006J\u0006\u0010U\u001a\u00020\u0006J\u000e\u0010W\u001a\u00020\u00062\u0006\u0010V\u001a\u000203J\u000e\u0010Y\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u0013J\u000e\u0010[\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0013J\u0010\u0010]\u001a\u00020\u00062\b\b\u0002\u0010\\\u001a\u000203J\u0006\u0010^\u001a\u00020\u0010J\u0006\u0010_\u001a\u000203J\u0010\u0010b\u001a\u00020\u00062\b\u0010a\u001a\u0004\u0018\u00010`J\u0010\u0010d\u001a\u00020\u00062\b\u0010a\u001a\u0004\u0018\u00010cJ\u0006\u0010e\u001a\u00020\u0006J\u0012\u0010h\u001a\u0002032\b\u0010g\u001a\u0004\u0018\u00010fH\u0016R\"\u0010o\u001a\u00020\u00108\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bi\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010u\u001a\u00020\u00018\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u0010x\u001a\u00020\u00018\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b$\u0010p\u001a\u0004\bv\u0010r\"\u0004\bw\u0010tR\"\u0010{\u001a\u00020\u00018\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001b\u0010p\u001a\u0004\by\u0010r\"\u0004\bz\u0010tR'\u0010\u0082\u0001\u001a\u0004\u0018\u00010|8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0014\n\u0004\bS\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R(\u0010\u0085\u0001\u001a\u0004\u0018\u00010|8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0015\n\u0004\b\u000f\u0010}\u001a\u0005\b\u0083\u0001\u0010\u007f\"\u0006\b\u0084\u0001\u0010\u0081\u0001R)\u0010\u0089\u0001\u001a\u0004\u0018\u00010|8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0016\n\u0005\b\u0086\u0001\u0010}\u001a\u0005\b\u0087\u0001\u0010\u007f\"\u0006\b\u0088\u0001\u0010\u0081\u0001R,\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R+\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0006\b\u0092\u0001\u0010\u008c\u0001\u001a\u0005\b/\u0010\u008e\u0001\"\u0006\b\u0093\u0001\u0010\u0090\u0001R+\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\by\u0010\u008c\u0001\u001a\u0006\b\u0095\u0001\u0010\u008e\u0001\"\u0006\b\u0096\u0001\u0010\u0090\u0001R,\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R,\u0010\u00a3\u0001\u001a\u0005\u0018\u00010\u0098\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00a0\u0001\u0010\u009a\u0001\u001a\u0006\b\u00a1\u0001\u0010\u009c\u0001\"\u0006\b\u00a2\u0001\u0010\u009e\u0001R+\u0010\u00a6\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\bq\u0010\u008c\u0001\u001a\u0006\b\u00a4\u0001\u0010\u008e\u0001\"\u0006\b\u00a5\u0001\u0010\u0090\u0001R(\u0010\u00a9\u0001\u001a\u0004\u0018\u00010|8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0015\n\u0004\bk\u0010}\u001a\u0005\b\u00a7\u0001\u0010\u007f\"\u0006\b\u00a8\u0001\u0010\u0081\u0001R(\u0010\u00ac\u0001\u001a\u0004\u0018\u00010\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0015\n\u0005\b\u00aa\u0001\u0010p\u001a\u0005\b\u0099\u0001\u0010r\"\u0005\b\u00ab\u0001\u0010tR,\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00ae\u0001\u0010\u00af\u0001\u001a\u0006\b\u00b0\u0001\u0010\u00b1\u0001\"\u0006\b\u00b2\u0001\u0010\u00b3\u0001R(\u0010\u00b9\u0001\u001a\u00020\t8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b.\u0010\u00b5\u0001\u001a\u0006\b\u0086\u0001\u0010\u00b6\u0001\"\u0006\b\u00b7\u0001\u0010\u00b8\u0001R)\u0010\u00bf\u0001\u001a\u00030\u00ba\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\bL\u0010\u00bb\u0001\u001a\u0006\b\u008b\u0001\u0010\u00bc\u0001\"\u0006\b\u00bd\u0001\u0010\u00be\u0001R'\u0010\u00c4\u0001\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0016\n\u0004\b1\u0010q\u001a\u0006\b\u00c0\u0001\u0010\u00c1\u0001\"\u0006\b\u00c2\u0001\u0010\u00c3\u0001R(\u0010\u00c9\u0001\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u0015\u0010\u00c5\u0001\u001a\u0006\b\u0092\u0001\u0010\u00c6\u0001\"\u0006\b\u00c7\u0001\u0010\u00c8\u0001R(\u0010\u00cb\u0001\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b2\u0010\u00c5\u0001\u001a\u0006\b\u00ae\u0001\u0010\u00c6\u0001\"\u0006\b\u00ca\u0001\u0010\u00c8\u0001R(\u0010\u00ce\u0001\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\bU\u0010\u00c5\u0001\u001a\u0006\b\u00cc\u0001\u0010\u00c6\u0001\"\u0006\b\u00cd\u0001\u0010\u00c8\u0001R(\u0010\u00d1\u0001\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\r\u0010\u00c5\u0001\u001a\u0006\b\u00cf\u0001\u0010\u00c6\u0001\"\u0006\b\u00d0\u0001\u0010\u00c8\u0001R(\u0010\u00d7\u0001\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u00d2\u0001\u0010y\u001a\u0006\b\u00d3\u0001\u0010\u00d4\u0001\"\u0006\b\u00d5\u0001\u0010\u00d6\u0001R)\u0010\u00de\u0001\u001a\u0002038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0018\n\u0006\b\u00d8\u0001\u0010\u00d9\u0001\u001a\u0006\b\u00da\u0001\u0010\u00db\u0001\"\u0006\b\u00dc\u0001\u0010\u00dd\u0001R'\u0010\u00e1\u0001\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0016\n\u0004\b\b\u0010q\u001a\u0006\b\u00df\u0001\u0010\u00c1\u0001\"\u0006\b\u00e0\u0001\u0010\u00c3\u0001R(\u0010\u00e5\u0001\u001a\u00020\u000e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u00e2\u0001\u0010y\u001a\u0006\b\u00e3\u0001\u0010\u00d4\u0001\"\u0006\b\u00e4\u0001\u0010\u00d6\u0001R(\u0010\u00e8\u0001\u001a\u0002038\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u001a\u0010\u00d9\u0001\u001a\u0006\b\u00e6\u0001\u0010\u00db\u0001\"\u0006\b\u00e7\u0001\u0010\u00dd\u0001R+\u0010\u00ee\u0001\u001a\u0005\u0018\u00010\u00e9\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\bT\u0010\u00ea\u0001\u001a\u0006\b\u00a0\u0001\u0010\u00eb\u0001\"\u0006\b\u00ec\u0001\u0010\u00ed\u0001R\u001b\u0010\u00f1\u0001\u001a\u0005\u0018\u00010\u00ef\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0019\u0010\u00f0\u0001R\u001b\u0010\u00f4\u0001\u001a\u0005\u0018\u00010\u00f2\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b8\u0010\u00f3\u0001R\u001a\u0010\u00f6\u0001\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b7\u0010\u00f5\u0001R*\u0010\u00fb\u0001\u001a\u0004\u0018\u00010c8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\u0016\u0010\u00f7\u0001\u001a\u0006\b\u00aa\u0001\u0010\u00f8\u0001\"\u0006\b\u00f9\u0001\u0010\u00fa\u0001R\u001c\u0010\u00ff\u0001\u001a\u0005\u0018\u00010\u00fc\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fd\u0001\u0010\u00fe\u0001R\u0017\u0010\u0082\u0002\u001a\u00030\u0080\u00028\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0007\u0010\u0081\u0002\u00a8\u0006\u008a\u0002"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/CardAdView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "adContent", "", "i0", "W", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "p", "T", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "view", "e", "", DomainData.DOMAIN_NAME, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "g0", "D0", "k", "d0", "b0", tl.h.F, "Y", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "j0", "onLifecycleResume", "onLifecyclePause", "onLifecycleDestroy", "f", "B0", "o0", "Lcom/tencent/mobileqq/ad/cardad/data/y;", "cardAdData", "A0", "colorStr", "y0", "z0", "", "M", "v", NodeProps.ON_CLICK, "P", BdhLogUtil.LogTag.Tag_Req, "", NodeProps.VISIBLE, "p0", "C0", "f0", "e0", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "w0", "x0", "percent", "setVideoAutoPlayRectPercent", "isEnableVideoPlay", "setEnableAutoPlay", "setEnableVideoPlay", "enable", "setPlayIconAlwaysVisible", "isVoiceOn", "setIsVoiceOn", "position", "setVideoStartPosition", "Lcom/tencent/mobileqq/ad/cardad/data/ab;", "callback", "setVideoProgressCallback", "Lcom/tencent/mobileqq/ad/cardad/data/ac;", "setVoiceOnChangeCallback", "N", "r0", "isNeedReport", "t0", "q0", "s0", "X", "i", "c0", ExifInterface.LATITUDE_SOUTH, "enableShake", "setEnableShake", "expoType", "setExpoType", "slot", "setSlot", "isNeed", "setNeedReportAntiSpam", "O", "g", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$b;", "listener", "setFeedbackHideAdListener", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$c;", "setVideoStateListener", "j", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "d", "Landroid/view/View;", "J", "()Landroid/view/View;", "n0", "(Landroid/view/View;)V", "mRootView", "Landroid/widget/FrameLayout;", "I", "()Landroid/widget/FrameLayout;", "m0", "(Landroid/widget/FrameLayout;)V", "mRootContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "k0", "mAdVideoContainer", UserInfo.SEX_FEMALE, "l0", "mMediaContainer", "Landroid/widget/TextView;", "Landroid/widget/TextView;", HippyTKDListViewAdapter.X, "()Landroid/widget/TextView;", "setMAdName", "(Landroid/widget/TextView;)V", "mAdName", "t", "setMAdDesc", "mAdDesc", BdhLogUtil.LogTag.Tag_Conn, "getMAdButton", "setMAdButton", "mAdButton", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "u", "()Landroid/widget/ImageView;", "setMAdIcon", "(Landroid/widget/ImageView;)V", "mAdIcon", "E", "setMAdImage", "mAdImage", "w", "setMAdImageBg", "mAdImageBg", "Landroid/widget/LinearLayout;", "G", "Landroid/widget/LinearLayout;", "getMAdFeedbackContainer", "()Landroid/widget/LinearLayout;", "setMAdFeedbackContainer", "(Landroid/widget/LinearLayout;)V", "mAdFeedbackContainer", "H", "r", "setMAdBtnContainer", "mAdBtnContainer", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setMAdVoiceIcon", "mAdVoiceIcon", ReportConstant.COSTREPORT_PREFIX, "setMAdBtnText", "mAdBtnText", "K", "setMPlayIconContainer", "mPlayIconContainer", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdShakeView;", "L", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdShakeView;", "B", "()Lcom/tencent/mobileqq/ad/cardad/views/CardAdShakeView;", "setMCardAdShakeView", "(Lcom/tencent/mobileqq/ad/cardad/views/CardAdShakeView;)V", "mCardAdShakeView", "Landroid/content/Context;", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mContext", "Lcom/tencent/gdtad/aditem/GdtAd;", "Lcom/tencent/gdtad/aditem/GdtAd;", "()Lcom/tencent/gdtad/aditem/GdtAd;", "setMGdtAd", "(Lcom/tencent/gdtad/aditem/GdtAd;)V", "mGdtAd", "getMExpoType", "()I", "setMExpoType", "(I)V", "mExpoType", "Ljava/lang/String;", "()Ljava/lang/String;", "setMImageUrl", "(Ljava/lang/String;)V", "mImageUrl", "setMVideoUrl", "mVideoUrl", "getMBtnBgColor", "setMBtnBgColor", "mBtnBgColor", "getMBtnTextColor", "setMBtnTextColor", "mBtnTextColor", "U", "y", "()F", "setMAdRadius", "(F)V", "mAdRadius", "V", "Z", "getMEnableShake", "()Z", "setMEnableShake", "(Z)V", "mEnableShake", "getMSlot", "setMSlot", "mSlot", "a0", "getMVideoAutoPlayRectPercent", "setMVideoAutoPlayRectPercent", "mVideoAutoPlayRectPercent", "getMIsEnableAutoPlay", "setMIsEnableAutoPlay", "mIsEnableAutoPlay", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "Lcom/tencent/mobileqq/ad/cardad/data/aa;", "()Lcom/tencent/mobileqq/ad/cardad/data/aa;", "setMReportCallback", "(Lcom/tencent/mobileqq/ad/cardad/data/aa;)V", "mReportCallback", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "Lcom/tencent/ad/tangram/util/AdExposureChecker;", "mAdExpoChecker", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "mAdExpoCallback", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$b;", "mFeedbackHideAdListener", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$c;", "()Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$c;", "setMVideoStateListener", "(Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$c;)V", "mVideoStateListener", "Lcom/tencent/gdtad/util/GdtAntiSpamReportHelper;", "h0", "Lcom/tencent/gdtad/util/GdtAntiSpamReportHelper;", "mGdtAntiSpamReportHelper", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "Lcom/tencent/ad/tangram/views/feedback/AdFeedbackDialogFragment$Listener;", "mAdFeedbackDialogListener", "gdtAd", "reportCallback", "<init>", "(Landroid/content/Context;Lcom/tencent/gdtad/aditem/GdtAd;Lcom/tencent/mobileqq/ad/cardad/data/aa;)V", "a", "b", "c", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public class CardAdView extends FrameLayout implements View.OnClickListener, LifecycleObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TextView mAdButton;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView mAdIcon;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ImageView mAdImage;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ImageView mAdImageBg;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mAdFeedbackContainer;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private LinearLayout mAdBtnContainer;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ImageView mAdVoiceIcon;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView mAdBtnText;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private FrameLayout mPlayIconContainer;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private CardAdShakeView mCardAdShakeView;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private Context mContext;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private GdtAd mGdtAd;

    /* renamed from: P, reason: from kotlin metadata */
    private int mExpoType;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private String mImageUrl;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private String mVideoUrl;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private String mBtnBgColor;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private String mBtnTextColor;

    /* renamed from: U, reason: from kotlin metadata */
    private float mAdRadius;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean mEnableShake;

    /* renamed from: W, reason: from kotlin metadata */
    private int mSlot;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private float mVideoAutoPlayRectPercent;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean mIsEnableAutoPlay;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private aa mReportCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected View mRootView;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdExposureChecker mAdExpoChecker;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected FrameLayout mRootContainer;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdExposureChecker.ExposureCallback mAdExpoCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected FrameLayout mAdVideoContainer;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mFeedbackHideAdListener;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mVideoStateListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected FrameLayout mMediaContainer;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GdtAntiSpamReportHelper mGdtAntiSpamReportHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdName;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AdFeedbackDialogFragment.Listener mAdFeedbackDialogListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView mAdDesc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$a;", "", "", "BTN_BG_COLOR_DEFAULT", "Ljava/lang/String;", "BTN_TEXT_COLOR_DEFAULT", "", "CARD_AD_EXPO_TYPE_DEFAULT", "I", "CARD_AD_EXPO_TYPE_DIRECTLY", "MASK_AD_ACTIVITY_RESULT_CODE", "TAG", "<init>", "()V", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.cardad.views.CardAdView$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$b;", "", "", "b", "g", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface b {
        void b();

        void g();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/ad/cardad/views/CardAdView$c;", "", "", "curProgressMs", "", "a", "onVideoStop", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public interface c {
        void a(long curProgressMs);

        void onVideoStop();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/ad/cardad/views/CardAdView$d", "Lcom/tencent/mobileqq/ad/cardad/views/CardAdShakeView$b;", "", "onShakeComplete", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d implements CardAdShakeView.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardAdView.this);
            }
        }

        @Override // com.tencent.mobileqq.ad.cardad.views.CardAdShakeView.b
        public void onShakeComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                CardAdView cardAdView = CardAdView.this;
                cardAdView.P(cardAdView.I());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/ad/cardad/views/CardAdView$e", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "qqad-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class e implements View.OnAttachStateChangeListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardAdView.this);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NotNull View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
                return;
            }
            Intrinsics.checkNotNullParameter(v3, "v");
            if (com.tencent.mobileqq.ad.cardad.utils.d.d(com.tencent.mobileqq.ad.cardad.utils.d.f186735a, CardAdView.this.I(), false, 2, null) > 0.10000000149011612d) {
                CardAdView.this.f0();
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@NotNull View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
            } else {
                Intrinsics.checkNotNullParameter(v3, "v");
                CardAdView.this.e0();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29304);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 115)) {
            redirector.redirect((short) 115);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardAdView(@NotNull Context context, @NotNull GdtAd gdtAd, @Nullable aa aaVar) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gdtAd, "gdtAd");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, gdtAd, aaVar);
            return;
        }
        this.mContext = context;
        this.mGdtAd = gdtAd;
        this.mImageUrl = "";
        this.mVideoUrl = "";
        this.mBtnBgColor = "";
        this.mBtnTextColor = "";
        this.mAdRadius = -1.0f;
        this.mEnableShake = true;
        this.mSlot = -1;
        this.mVideoAutoPlayRectPercent = 0.5f;
        this.mIsEnableAutoPlay = true;
        this.mReportCallback = aaVar;
        this.mAdFeedbackDialogListener = new AdFeedbackDialogFragment.Listener() { // from class: com.tencent.mobileqq.ad.cardad.views.f
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                CardAdView.a0(CardAdView.this, result);
            }
        };
        Y();
        f();
        W();
        T();
    }

    private final void D0() {
        if (this.mExpoType == 1) {
            QLog.d(q(), 2, "onExposure return: direct expo report type");
            return;
        }
        com.tencent.mobileqq.ad.cardad.utils.b bVar = com.tencent.mobileqq.ad.cardad.utils.b.f186729a;
        if (bVar.e(this.mGdtAd.getTraceId(), this.mGdtAd.getAId())) {
            QLog.d(q(), 1, "onExposure valid report return: has reported");
            return;
        }
        k();
        new GdtThirdProcessorProxy().c2sReportAsync(0, 0, this.mGdtAd.info);
        bVar.h(this.mGdtAd.getTraceId(), this.mGdtAd.getAId());
        aa aaVar = this.mReportCallback;
        if (aaVar != null) {
            aaVar.b(this.mGdtAd);
        }
        QLog.d(q(), 2, "onExposure valid report success:", this.mGdtAd.getTraceId() + util.base64_pad_url + this.mGdtAd.getAId());
    }

    private final void Q() {
        QLog.d(q(), 1, "handleFeedbackClick");
        g0();
    }

    private final void T() {
        if (this.mExpoType == 1) {
            QLog.d(q(), 2, "initExpoChecker return: direct expo report type");
            return;
        }
        if (com.tencent.mobileqq.ad.cardad.utils.d.f186735a.e(this.mGdtAd)) {
            return;
        }
        this.mAdExpoChecker = new AdExposureChecker(this.mGdtAd, new WeakReference(I()));
        this.mAdExpoCallback = new AdExposureChecker.ExposureCallback() { // from class: com.tencent.mobileqq.ad.cardad.views.g
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                CardAdView.U(CardAdView.this, weakReference);
            }
        };
        AdExposureChecker adExposureChecker = this.mAdExpoChecker;
        if (adExposureChecker != null) {
            adExposureChecker.setCallback(new WeakReference<>(this.mAdExpoCallback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(CardAdView this$0, WeakReference weakReference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d(this$0.q(), 2, "onExposure expo checker success");
        this$0.D0();
    }

    private final void W() {
        e(I());
        e(this.mAdName);
        e(this.mAdDesc);
        e(this.mAdButton);
        e(this.mAdIcon);
        e(this.mAdImage);
        e(this.mAdFeedbackContainer);
        e(z());
        e(this.mAdVoiceIcon);
        e(this.mAdBtnContainer);
        addOnAttachStateChangeListener(new e());
        com.tencent.mobileqq.ad.cardad.utils.d.f186735a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.ad.cardad.views.CardAdView$initListener$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) CardAdView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LifecycleOwner p16;
                Lifecycle lifecycle;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                CardAdView cardAdView = CardAdView.this;
                p16 = cardAdView.p(cardAdView.C());
                if (p16 == null || (lifecycle = p16.getLifecycle()) == null) {
                    return;
                }
                lifecycle.addObserver(CardAdView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(CardAdView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(CardAdView this$0, AdFeedbackDialogFragment.Result result) {
        aa aaVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (result == null) {
            return;
        }
        int i3 = result.action;
        if (i3 == 3) {
            b bVar = this$0.mFeedbackHideAdListener;
            if (bVar != null) {
                bVar.g();
            }
            aa aaVar2 = this$0.mReportCallback;
            if (aaVar2 != null) {
                aaVar2.g(this$0.mGdtAd);
            }
            this$0.S();
            return;
        }
        if (i3 == 6 && (aaVar = this$0.mReportCallback) != null) {
            aaVar.c(this$0.mGdtAd);
        }
    }

    private final void b0() {
        aa aaVar = this.mReportCallback;
        if (aaVar != null) {
            aaVar.e(this.mGdtAd);
        }
    }

    private final void d0() {
        if (this.mExpoType != 1) {
            return;
        }
        if (com.tencent.mobileqq.ad.cardad.utils.d.f186735a.e(this.mGdtAd)) {
            QLog.e(q(), 1, "onExposeDirectly cancel: is mask ad");
            return;
        }
        com.tencent.mobileqq.ad.cardad.utils.b bVar = com.tencent.mobileqq.ad.cardad.utils.b.f186729a;
        GdtAd gdtAd = this.mGdtAd;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bVar.f(gdtAd, context, this.mReportCallback, false, this.mSlot);
        GdtAntiSpamReportHelper gdtAntiSpamReportHelper = this.mGdtAntiSpamReportHelper;
        if (gdtAntiSpamReportHelper != null) {
            gdtAntiSpamReportHelper.setExpoTime();
        }
        k();
        new GdtThirdProcessorProxy().c2sReportAsync(0, 0, this.mGdtAd.info);
        aa aaVar = this.mReportCallback;
        if (aaVar != null) {
            aaVar.b(this.mGdtAd);
        }
        QLog.d(q(), 2, "onExposeDirectly report success:", this.mGdtAd.getTraceId() + util.base64_pad_url + this.mGdtAd.getAId());
    }

    private final void e(View view) {
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    private final void g0() {
        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
        Context context = this.mContext;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        adFeedbackParams.activity = new WeakReference<>((Activity) context);
        adFeedbackParams.listener = new WeakReference<>(this.mAdFeedbackDialogListener);
        adFeedbackParams.f61346ad = this.mGdtAd;
        adFeedbackParams.isDarkMode = QQTheme.isNowThemeIsNight();
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
        } catch (Throwable th5) {
            QLog.e(q(), 1, "openAdFeedBackDialog", th5);
        }
        b bVar = this.mFeedbackHideAdListener;
        if (bVar != null) {
            bVar.b();
        }
    }

    private final void h() {
        com.tencent.mobileqq.ad.cardad.utils.b bVar = com.tencent.mobileqq.ad.cardad.utils.b.f186729a;
        String traceId = this.mGdtAd.getTraceId();
        String str = "";
        if (traceId == null) {
            traceId = "";
        }
        if (!bVar.c(traceId)) {
            return;
        }
        d0();
        String traceId2 = this.mGdtAd.getTraceId();
        if (traceId2 != null) {
            str = traceId2;
        }
        bVar.i(str);
    }

    private final void i0(String adContent) {
        ImageView imageView = this.mAdImage;
        if (imageView != null) {
            imageView.setContentDescription("\u5e7f\u544a\u56fe\u7247\uff1a" + adContent);
        }
        z().setContentDescription("\u5e7f\u544a\u89c6\u9891\uff1a" + adContent);
        ImageView imageView2 = this.mAdIcon;
        if (imageView2 != null) {
            imageView2.setContentDescription("\u5e7f\u544a\u5934\u50cf\uff1a" + adContent);
        }
    }

    private final void k() {
        String str;
        if (this.mGdtAntiSpamReportHelper != null) {
            str = "&s=" + GdtAntiSpamReportHelper.getAdAntiSpamForExpoParams(this);
        } else {
            str = "";
        }
        GdtReporter.doCgiReport(this.mGdtAd.getUrlForImpression() + str);
    }

    private final float m() {
        if (this.mAdRadius >= 0.0f) {
            return ViewUtils.pxToDp(r0);
        }
        if (com.tencent.mobileqq.ad.cardad.utils.d.f186735a.g(this.mGdtAd)) {
            return 16.0f;
        }
        return 6.0f;
    }

    private final int n(View view) {
        Integer num;
        if (view != null) {
            int id5 = view.getId();
            x xVar = x.f186705a;
            if (!xVar.c0().containsKey(Integer.valueOf(id5)) || (num = xVar.c0().get(Integer.valueOf(id5))) == null) {
                return 0;
            }
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final LifecycleOwner p(Context context) {
        if (context instanceof LifecycleOwner) {
            return (LifecycleOwner) context;
        }
        return null;
    }

    public static /* synthetic */ void setNeedReportAntiSpam$default(CardAdView cardAdView, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            cardAdView.setNeedReportAntiSpam(z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNeedReportAntiSpam");
    }

    public static /* synthetic */ void u0(CardAdView cardAdView, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                z16 = true;
            }
            cardAdView.t0(z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopVideo");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final ImageView A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (ImageView) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.mAdVoiceIcon;
    }

    public final void A0(@NotNull y cardAdData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, (Object) this, (Object) cardAdData);
            return;
        }
        Intrinsics.checkNotNullParameter(cardAdData, "cardAdData");
        this.mGdtAd = cardAdData.f();
        this.mBtnBgColor = cardAdData.b();
        this.mBtnTextColor = cardAdData.c();
        this.mAdRadius = cardAdData.a();
        this.mEnableShake = cardAdData.d();
        this.mExpoType = cardAdData.e();
        f();
        T();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final CardAdShakeView B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (CardAdShakeView) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.mCardAdShakeView;
    }

    public void B0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            iPatchRedirector.redirect((short) 71, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Context C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (Context) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return this.mContext;
    }

    public void C0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this);
        } else {
            QLog.d("CardAdView", 1, "updateVideoFinishTypeAdClick");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final GdtAd D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (GdtAd) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return this.mGdtAd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return this.mImageUrl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final FrameLayout F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        FrameLayout frameLayout = this.mMediaContainer;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mMediaContainer");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final FrameLayout G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return this.mPlayIconContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final aa H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (aa) iPatchRedirector.redirect((short) 58, (Object) this);
        }
        return this.mReportCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final FrameLayout I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        FrameLayout frameLayout = this.mRootContainer;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        View view = this.mRootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final c K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (c) iPatchRedirector.redirect((short) 60, (Object) this);
        }
        return this.mVideoStateListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return this.mVideoUrl;
    }

    public long M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            return ((Long) iPatchRedirector.redirect((short) 77, (Object) this)).longValue();
        }
        return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    }

    @NotNull
    public String N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            return (String) iPatchRedirector.redirect((short) 96, (Object) this);
        }
        String traceId = this.mGdtAd.getTraceId();
        if (traceId == null) {
            return "";
        }
        return traceId;
    }

    @NotNull
    public final View O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            return (View) iPatchRedirector.redirect((short) 109, (Object) this);
        }
        return F();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P(@NotNull View view) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        int n3 = n(view);
        QLog.d(q(), 1, "handleAdClick posId:", Integer.valueOf(n3));
        com.tencent.mobileqq.ad.cardad.utils.d dVar = com.tencent.mobileqq.ad.cardad.utils.d.f186735a;
        if (dVar.e(this.mGdtAd)) {
            ((IAdApi) QRoute.api(IAdApi.class)).doMaskAdValidExpo(this.mGdtAd);
        } else if (this.mExpoType == 0) {
            AdExposureChecker.onClick(this.mContext, this.mGdtAd, new WeakReference(this.mAdExpoCallback));
        }
        GdtHandler.Params params = new GdtHandler.Params();
        params.f108486ad = this.mGdtAd;
        Context context = this.mContext;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        params.activity = new WeakReference<>((Activity) context);
        params.componentID = n3;
        GdtAntiSpamReportHelper gdtAntiSpamReportHelper = this.mGdtAntiSpamReportHelper;
        if (gdtAntiSpamReportHelper != null) {
            str = gdtAntiSpamReportHelper.getAdAntiSpamForClickParams(this);
        } else {
            str = null;
        }
        params.antiSpamParams = str;
        params.directPlay = true;
        params.videoCeilingSupportedIfNotInstalled = true;
        params.widthHeightRatioOfVideoCeiling = "16:9";
        Bundle bundle = new Bundle();
        bundle.putString(LaunchParam.KEY_REF_ID, "biz_src_gzh_weather");
        params.extra = bundle;
        if (dVar.e(this.mGdtAd)) {
            params.startActivityRequestCode = MaskAdConstants.MASK_AD_ACTIVITY_RESULT_CODE;
        }
        params.videoStartPositionMillis = M();
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(params);
        new GdtThirdProcessorProxy().c2sReportAsync(1, 0, this.mGdtAd.info);
        C0();
        aa aaVar = this.mReportCallback;
        if (aaVar != null) {
            aaVar.f(this.mGdtAd);
        }
    }

    public void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this);
        } else {
            QLog.d(q(), 1, "handleVoiceChange");
        }
    }

    public final void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            iPatchRedirector.redirect((short) 104, (Object) this);
            return;
        }
        QLog.d(q(), 1, "hideAd");
        u0(this, false, 1, null);
        p0(J(), false);
        onDestroy();
    }

    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            iPatchRedirector.redirect((short) 101, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this);
            return;
        }
        View inflate = LayoutInflater.from(this.mContext).inflate(o(), (ViewGroup) this, true);
        if (inflate == null) {
            return;
        }
        n0(inflate);
        View findViewById = J().findViewById(R.id.tmm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026d.card_ad_root_container)");
        m0((FrameLayout) findViewById);
        this.mAdName = (TextView) J().findViewById(R.id.tmi);
        this.mAdDesc = (TextView) J().findViewById(R.id.tm6);
        this.mAdButton = (TextView) J().findViewById(R.id.f164727tm2);
        this.mAdIcon = (ImageView) J().findViewById(R.id.tm_);
        this.mAdImage = (ImageView) J().findViewById(R.id.tmb);
        this.mAdImageBg = (ImageView) J().findViewById(R.id.tmc);
        this.mAdFeedbackContainer = (LinearLayout) J().findViewById(R.id.tm7);
        View findViewById2 = J().findViewById(R.id.tmf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R\u2026.card_ad_media_container)");
        l0((FrameLayout) findViewById2);
        View findViewById3 = J().findViewById(R.id.tn8);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R\u2026.card_ad_video_container)");
        k0((FrameLayout) findViewById3);
        this.mAdVoiceIcon = (ImageView) J().findViewById(R.id.tna);
        this.mPlayIconContainer = (FrameLayout) J().findViewById(R.id.tmk);
        this.mCardAdShakeView = (CardAdShakeView) J().findViewById(R.id.tn5);
        this.mAdBtnContainer = (LinearLayout) J().findViewById(R.id.f164728tm3);
        this.mAdBtnText = (TextView) J().findViewById(R.id.tm5);
        j0();
        l();
        post(new Runnable() { // from class: com.tencent.mobileqq.ad.cardad.views.h
            @Override // java.lang.Runnable
            public final void run() {
                CardAdView.Z(CardAdView.this);
            }
        });
    }

    public final void c0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            iPatchRedirector.redirect((short) 103, (Object) this);
            return;
        }
        if (com.tencent.mobileqq.ad.cardad.utils.d.f186735a.e(this.mGdtAd)) {
            QLog.e(q(), 1, "onExpose cancel: is mask ad");
            return;
        }
        if (this.mExpoType != 0) {
            return;
        }
        com.tencent.mobileqq.ad.cardad.utils.b bVar = com.tencent.mobileqq.ad.cardad.utils.b.f186729a;
        GdtAd gdtAd = this.mGdtAd;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        bVar.f(gdtAd, context, this.mReportCallback, true, this.mSlot);
        GdtAntiSpamReportHelper gdtAntiSpamReportHelper = this.mGdtAntiSpamReportHelper;
        if (gdtAntiSpamReportHelper != null) {
            gdtAntiSpamReportHelper.setExpoTime();
        }
        if (bVar.e(this.mGdtAd.getTraceId(), this.mGdtAd.getAId())) {
            QLog.d(q(), 1, "onExpose return: hasAdValidExpoReported");
            return;
        }
        AdExposureChecker adExposureChecker = this.mAdExpoChecker;
        if (adExposureChecker != null) {
            adExposureChecker.startCheck();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent event) {
        GdtAntiSpamReportHelper gdtAntiSpamReportHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            return ((Boolean) iPatchRedirector.redirect((short) 114, (Object) this, (Object) event)).booleanValue();
        }
        if (event != null && this.mGdtAntiSpamReportHelper != null) {
            int action = event.getAction();
            if (action != 0) {
                if (action == 1 && (gdtAntiSpamReportHelper = this.mGdtAntiSpamReportHelper) != null) {
                    gdtAntiSpamReportHelper.setUpData((int) event.getRawX(), (int) event.getRawY());
                }
            } else {
                GdtAntiSpamReportHelper gdtAntiSpamReportHelper2 = this.mGdtAntiSpamReportHelper;
                if (gdtAntiSpamReportHelper2 != null) {
                    gdtAntiSpamReportHelper2.setDownData((int) event.getRawX(), (int) event.getRawY());
                }
            }
            return super.dispatchTouchEvent(event);
        }
        return super.dispatchTouchEvent(event);
    }

    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this);
            return;
        }
        AdExposureChecker adExposureChecker = this.mAdExpoChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityPause();
        }
        s0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public void f() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this);
            return;
        }
        String videoUrl = this.mGdtAd.getVideoUrl();
        String str2 = "";
        if (videoUrl == null) {
            videoUrl = "";
        }
        this.mVideoUrl = videoUrl;
        GdtImageData imageData = this.mGdtAd.getImageData();
        if (imageData != null) {
            str = imageData.url;
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        this.mImageUrl = str2;
        ImageView imageView = this.mAdImage;
        if (imageView != null) {
            imageView.setImageDrawable(GdtUIUtils.getUrlDrawable(str2));
        }
        TextView textView = this.mAdDesc;
        if (textView != null) {
            textView.setText(this.mGdtAd.getText());
        }
        GdtAd gdtAd = this.mGdtAd;
        Context context = this.mContext;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        String buttonText = gdtAd.getButtonText(GdtUIUtils.canLaunchApp(gdtAd, (Activity) context));
        TextView textView2 = this.mAdButton;
        if (textView2 != null) {
            textView2.setText(buttonText);
        }
        TextView textView3 = this.mAdBtnText;
        if (textView3 != null) {
            textView3.setText(buttonText);
        }
        String advertiser_corporate_image_name = this.mGdtAd.getAdvertiser_corporate_image_name();
        if (TextUtils.isEmpty(advertiser_corporate_image_name)) {
            p0(this.mAdName, false);
        } else {
            TextView textView4 = this.mAdName;
            if (textView4 != null) {
                textView4.setText(advertiser_corporate_image_name);
            }
        }
        String advertiser_corporate_logo = this.mGdtAd.getAdvertiser_corporate_logo();
        if (TextUtils.isEmpty(advertiser_corporate_logo)) {
            p0(this.mAdIcon, false);
            if (TextUtils.isEmpty(advertiser_corporate_image_name)) {
                B0();
            }
        } else {
            ImageView imageView2 = this.mAdIcon;
            if (imageView2 != null) {
                imageView2.setImageDrawable(GdtUIUtils.getUrlDrawable(advertiser_corporate_logo, ViewUtils.dpToPx(18.0f), ViewUtils.dpToPx(18.0f)));
            }
        }
        CardAdShakeView cardAdShakeView = this.mCardAdShakeView;
        if (cardAdShakeView != null) {
            cardAdShakeView.e(true, this.mGdtAd, new d());
        }
        o0();
        y0(this.mBtnBgColor);
        z0(this.mBtnTextColor);
        X();
        i0(String.valueOf(this.mGdtAd.getText()));
    }

    public void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, (Object) this);
            return;
        }
        AdExposureChecker adExposureChecker = this.mAdExpoChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityResume();
        }
        x0();
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            return ((Boolean) iPatchRedirector.redirect((short) 110, (Object) this)).booleanValue();
        }
        if (!z.f186721a.a() && (!this.mGdtAd.canBidAdShake() || !this.mEnableShake)) {
            return false;
        }
        return true;
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 102)) {
            iPatchRedirector.redirect((short) 102, (Object) this);
            return;
        }
        QLog.d(q(), 1, "checkOnExpose:", Integer.valueOf(this.mExpoType));
        if (this.mExpoType == 1) {
            h();
        } else {
            c0();
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            iPatchRedirector.redirect((short) 113, (Object) this);
            return;
        }
        double d16 = com.tencent.mobileqq.ad.cardad.utils.d.d(com.tencent.mobileqq.ad.cardad.utils.d.f186735a, I(), false, 2, null);
        QLog.d("CardAdView", 2, "checkViewVisibility:", Double.valueOf(d16));
        if (d16 > 0.0d) {
            c0();
        }
        if (d16 >= this.mVideoAutoPlayRectPercent) {
            if (this.mIsEnableAutoPlay) {
                r0();
            }
            q0();
            if (this.mExpoType == 1) {
                h();
                return;
            }
            return;
        }
        u0(this, false, 1, null);
        s0();
        if (this.mExpoType == 1) {
            com.tencent.mobileqq.ad.cardad.utils.b bVar = com.tencent.mobileqq.ad.cardad.utils.b.f186729a;
            String traceId = this.mGdtAd.getTraceId();
            if (traceId == null) {
                traceId = "";
            }
            bVar.b(traceId);
        }
    }

    protected void j0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            iPatchRedirector.redirect((short) 66, (Object) this);
        } else {
            F().setBackground(GdtUIUtils.getUrlDrawable("https://qq-weather.cdn-go.cn/hippy-weather/latest/ad-bg.png"));
        }
    }

    protected final void k0(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) frameLayout);
        } else {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.mAdVideoContainer = frameLayout;
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            iPatchRedirector.redirect((short) 65, (Object) this);
            return;
        }
        if (com.tencent.mobileqq.ad.cardad.utils.d.f186735a.f()) {
            I().setBackgroundColor(Color.parseColor("#1A1A1A"));
            TextView textView = this.mAdDesc;
            if (textView != null) {
                textView.setTextColor(-1);
            }
        }
    }

    protected final void l0(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) frameLayout);
        } else {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.mMediaContainer = frameLayout;
        }
    }

    protected final void m0(@NotNull FrameLayout frameLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) frameLayout);
        } else {
            Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
            this.mRootContainer = frameLayout;
        }
    }

    protected final void n0(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mRootView = view;
        }
    }

    protected int o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Integer) iPatchRedirector.redirect((short) 63, (Object) this)).intValue();
        }
        return R.layout.e0x;
    }

    protected void o0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this);
            return;
        }
        QLog.d("CardAdView", 1, "setViewRadius adRadiusDp:", Float.valueOf(m()));
        GdtUIUtils.setViewRadius(I(), m());
        GdtUIUtils.setViewRadius(this.mAdIcon, 9.0f);
        GdtUIUtils.setViewRadius(this.mAdButton, 32.0f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (v3 == this.mAdFeedbackContainer) {
                Q();
            } else if (v3 == this.mAdVoiceIcon) {
                R();
            } else {
                P(v3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    public void onDestroy() {
        Lifecycle lifecycle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, (Object) this);
            return;
        }
        AdExposureChecker adExposureChecker = this.mAdExpoChecker;
        if (adExposureChecker != null) {
            adExposureChecker.onActivityDestroy();
        }
        CardAdShakeView cardAdShakeView = this.mCardAdShakeView;
        if (cardAdShakeView != null) {
            cardAdShakeView.j();
        }
        this.mFeedbackHideAdListener = null;
        LifecycleOwner p16 = p(this.mContext);
        if (p16 != null && (lifecycle = p16.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onLifecycleDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this);
        } else {
            QLog.d("CardAdView", 2, "onLifecycleDestroy");
            onDestroy();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onLifecyclePause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this);
        } else {
            QLog.d("CardAdView", 2, "onLifecyclePause");
            e0();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onLifecycleResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            iPatchRedirector.redirect((short) 67, (Object) this);
        } else {
            QLog.d("CardAdView", 2, "onLifecycleResume");
            f0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p0(@Nullable View view, boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, this, view, Boolean.valueOf(visible));
        } else {
            if (view == null) {
                return;
            }
            if (!visible) {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public String q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return (String) iPatchRedirector.redirect((short) 64, (Object) this);
        }
        return "CardAdView";
    }

    public void q0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            iPatchRedirector.redirect((short) 99, (Object) this);
            return;
        }
        if (!g()) {
            return;
        }
        QLog.d(q(), 1, "startShake");
        CardAdShakeView cardAdShakeView = this.mCardAdShakeView;
        if (cardAdShakeView != null) {
            cardAdShakeView.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final LinearLayout r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.mAdBtnContainer;
    }

    public void r0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            iPatchRedirector.redirect((short) 97, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final TextView s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (TextView) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.mAdBtnText;
    }

    public void s0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            iPatchRedirector.redirect((short) 100, (Object) this);
            return;
        }
        if (!g()) {
            return;
        }
        QLog.d(q(), 1, "stopShake");
        CardAdShakeView cardAdShakeView = this.mCardAdShakeView;
        if (cardAdShakeView != null) {
            cardAdShakeView.t();
        }
    }

    public final void setEnableAutoPlay(boolean isEnableVideoPlay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            iPatchRedirector.redirect((short) 89, (Object) this, isEnableVideoPlay);
        } else {
            this.mIsEnableAutoPlay = isEnableVideoPlay;
        }
    }

    public final void setEnableShake(boolean enableShake) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            iPatchRedirector.redirect((short) 105, (Object) this, enableShake);
        } else {
            this.mEnableShake = enableShake;
        }
    }

    public void setEnableVideoPlay(boolean isEnableVideoPlay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, (Object) this, isEnableVideoPlay);
        }
    }

    public final void setExpoType(int expoType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            iPatchRedirector.redirect((short) 106, (Object) this, expoType);
        } else {
            this.mExpoType = expoType;
        }
    }

    public final void setFeedbackHideAdListener(@Nullable b listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            iPatchRedirector.redirect((short) 111, (Object) this, (Object) listener);
        } else {
            this.mFeedbackHideAdListener = listener;
        }
    }

    public void setIsVoiceOn(boolean isVoiceOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, (Object) this, isVoiceOn);
        }
    }

    public final void setNeedReportAntiSpam(boolean isNeed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, (Object) this, isNeed);
        } else if (isNeed && this.mGdtAntiSpamReportHelper == null) {
            this.mGdtAntiSpamReportHelper = new GdtAntiSpamReportHelper();
        }
    }

    public void setPlayIconAlwaysVisible(boolean enable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 91)) {
            iPatchRedirector.redirect((short) 91, (Object) this, enable);
        }
    }

    public final void setSlot(int slot) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            iPatchRedirector.redirect((short) 107, (Object) this, slot);
        } else {
            this.mSlot = slot;
        }
    }

    public final void setVideoAutoPlayRectPercent(float percent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, this, Float.valueOf(percent));
        } else {
            this.mVideoAutoPlayRectPercent = percent;
        }
    }

    public void setVideoProgressCallback(@NotNull ab callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
        }
    }

    public void setVideoStartPosition(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            iPatchRedirector.redirect((short) 93, (Object) this, position);
        }
    }

    public final void setVideoStateListener(@Nullable c listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            iPatchRedirector.redirect((short) 112, (Object) this, (Object) listener);
        } else {
            this.mVideoStateListener = listener;
        }
    }

    public void setVoiceOnChangeCallback(@NotNull ac callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            iPatchRedirector.redirect((short) 95, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final TextView t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TextView) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mAdDesc;
    }

    public void t0(boolean isNeedReport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, (Object) this, isNeedReport);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final ImageView u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (ImageView) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mAdIcon;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final ImageView v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (ImageView) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mAdImage;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final ImageView w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (ImageView) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mAdImageBg;
    }

    public void w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final TextView x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TextView) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mAdName;
    }

    public void x0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, (Object) this);
        } else {
            if (!g()) {
                return;
            }
            if (com.tencent.mobileqq.ad.cardad.utils.d.d(com.tencent.mobileqq.ad.cardad.utils.d.f186735a, I(), false, 2, null) < 0.5d) {
                QLog.d(q(), 1, "tryToStartShake return: visible area < 0.5");
            } else {
                q0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Float) iPatchRedirector.redirect((short) 48, (Object) this)).floatValue();
        }
        return this.mAdRadius;
    }

    public final void y0(@NotNull String colorStr) {
        boolean startsWith$default;
        int parseLong;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, (Object) this, (Object) colorStr);
            return;
        }
        Intrinsics.checkNotNullParameter(colorStr, "colorStr");
        if (!TextUtils.isEmpty(colorStr)) {
            try {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(colorStr, "#", false, 2, null);
                if (startsWith$default) {
                    parseLong = Color.parseColor(colorStr);
                } else {
                    parseLong = (int) Long.parseLong(colorStr);
                }
                TextView textView = this.mAdButton;
                if (textView != null) {
                    textView.setBackgroundColor(parseLong);
                }
                LinearLayout linearLayout = this.mAdBtnContainer;
                if (linearLayout != null) {
                    linearLayout.setBackgroundColor(parseLong);
                }
                this.mBtnBgColor = colorStr;
                return;
            } catch (Exception e16) {
                QLog.e("CardAdView", 1, "updateBtnBgColor error:", e16);
                return;
            }
        }
        QLog.d("CardAdView", 1, "updateBtnBgColor return: colorStr is empty");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final FrameLayout z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (FrameLayout) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        FrameLayout frameLayout = this.mAdVideoContainer;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mAdVideoContainer");
        return null;
    }

    public final void z0(@NotNull String colorStr) {
        boolean startsWith$default;
        int parseLong;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, (Object) colorStr);
            return;
        }
        Intrinsics.checkNotNullParameter(colorStr, "colorStr");
        if (!TextUtils.isEmpty(colorStr)) {
            try {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(colorStr, "#", false, 2, null);
                if (startsWith$default) {
                    parseLong = Color.parseColor(colorStr);
                } else {
                    parseLong = (int) Long.parseLong(colorStr);
                }
                TextView textView = this.mAdButton;
                if (textView != null) {
                    textView.setTextColor(parseLong);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("CardAdView", 1, "updateBtnTextColor error:", e16);
                return;
            }
        }
        QLog.d("CardAdView", 1, "updateBtnTextColor return: colorStr is empty");
    }
}
