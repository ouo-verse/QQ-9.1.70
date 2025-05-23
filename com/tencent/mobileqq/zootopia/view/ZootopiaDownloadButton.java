package com.tencent.mobileqq.zootopia.view;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaDownloadBarType;
import com.tencent.sqshow.zootopia.data.ZootopiaMapDetail;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.sqshow.zootopia.utils.PagLoader;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.libpag.PAGFile;
import org.libpag.PAGText;
import org.libpag.PAGView;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00bc\u00012\u00020\u00012\u00020\u0002:\u0006\u00bd\u0001\u00be\u0001\u00bf\u0001B\u0015\b\u0016\u0012\b\u0010\u00b4\u0001\u001a\u00030\u00b3\u0001\u00a2\u0006\u0006\b\u00b5\u0001\u0010\u00b6\u0001B!\b\u0016\u0012\b\u0010\u00b4\u0001\u001a\u00030\u00b3\u0001\u0012\n\u0010\u00b8\u0001\u001a\u0005\u0018\u00010\u00b7\u0001\u00a2\u0006\u0006\b\u00b5\u0001\u0010\u00b9\u0001B*\b\u0016\u0012\b\u0010\u00b4\u0001\u001a\u00030\u00b3\u0001\u0012\n\u0010\u00b8\u0001\u001a\u0005\u0018\u00010\u00b7\u0001\u0012\u0007\u0010\u00ba\u0001\u001a\u00020\u0010\u00a2\u0006\u0006\b\u00b5\u0001\u0010\u00bb\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0003J\u001c\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u000e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0018\u001a\u00020\u0003H\u0014J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010 \u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\b\u0010!\u001a\u00020\u001bH\u0016J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%J\u000e\u0010'\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001eJ\u0010\u0010)\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020(H\u0016J\b\u0010*\u001a\u00020\u0003H\u0016J\u000e\u0010-\u001a\u00020\u00032\u0006\u0010,\u001a\u00020+J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020.H\u0016J\u000e\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u000200J\u0012\u00104\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u00105\u001a\u00020\u0003H\u0016J\b\u00106\u001a\u00020\u0003H\u0016J\u0010\u00107\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u00108\u001a\u00020\u0003H\u0016J\b\u00109\u001a\u00020\u0003H\u0016J\u0012\u0010:\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010=\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010;H\u0016J\u000e\u0010?\u001a\u00020\u00032\u0006\u0010>\u001a\u00020+J\u0006\u0010@\u001a\u00020+J\u0012\u0010B\u001a\u0004\u0018\u00010\u001b2\u0006\u0010A\u001a\u00020\u0019H\u0004R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\"\u0010\u000f\u001a\u00020.8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010Q\u001a\u00020K8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b:\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010Y\u001a\u00020R8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010]\u001a\u00020R8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bZ\u0010T\u001a\u0004\b[\u0010V\"\u0004\b\\\u0010XR\"\u0010c\u001a\u00020\u000e8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b^\u0010`\"\u0004\ba\u0010bR\"\u0010j\u001a\u00020d8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\"\u0010n\u001a\u00020.8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bk\u0010F\u001a\u0004\bl\u0010H\"\u0004\bm\u0010JR$\u0010t\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR$\u0010v\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010o\u001a\u0004\b3\u0010q\"\u0004\bu\u0010sR$\u0010y\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010o\u001a\u0004\bw\u0010q\"\u0004\bx\u0010sR$\u0010|\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010o\u001a\u0004\bz\u0010q\"\u0004\b{\u0010sR\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010}R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010~R\u0017\u0010\u0080\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010\u007fR\u001b\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0081\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\\\u0010\u0082\u0001R\u001b\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bI\u0010\u0085\u0001R\u001c\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0087\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R'\u0010\u008f\u0001\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0016\n\u0005\b\u008b\u0001\u0010\u0007\u001a\u0005\bS\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R$\u0010\u0094\u0001\u001a\r \u0091\u0001*\u0005\u0018\u00010\u0090\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0098\u0001\u001a\u00030\u0095\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001b\u0010\u009b\u0001\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009d\u0001\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009a\u0001R\u0018\u0010\u009f\u0001\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009e\u0001\u0010\u007fR,\u0010\u00a5\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001b0\u00a0\u00018\u0004X\u0084\u0004\u00a2\u0006\u0010\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001R\u0018\u0010\u00a9\u0001\u001a\u00030\u00a6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R1\u0010\u001a\u001a\u00020\u00192\u0007\u0010\u00aa\u0001\u001a\u00020\u00198\u0006@FX\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001\u001a\u0006\b\u00ad\u0001\u0010\u00ae\u0001\"\u0006\b\u00af\u0001\u0010\u00b0\u0001R\u0013\u0010\u00b2\u0001\u001a\u00020(8F\u00a2\u0006\u0007\u001a\u0005\bZ\u0010\u00b1\u0001\u00a8\u0006\u00c0\u0001"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "I", "J", "", "allSize", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "diffPatchInfo", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zootopia/view/PercentProgressBar;", "view", "", "progress", BdhLogUtil.LogTag.Tag_Conn, "u", "v", "Lcom/tencent/sqshow/zootopia/data/ZootopiaDownloadBarType;", "pageType", "setButtonType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "status", "", "statusValue", "setStatusText", "Landroid/graphics/drawable/Drawable;", "drawable", "setProgressDrawable", "r", "Lcom/tencent/sqshow/zootopia/data/m;", "mapDetail", "setDownloadSize", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "mapSimpleInfo", "setNormalBackgroundDrwable", "", "setProcess", "setProgressBar", "", "showButtonSubText", "setShowButtonSubText", "Landroid/view/View;", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton$a;", "buttonClickListener", "setButtonStatusListener", "l", "setOnClickListener", "setLoadingStatusStyle", "setPauseStatusStyle", "setCustomStatusStyle", "setCloudModStyle", "B", "f", "Ls84/a;", "style", "setCloudModButtonStyle", "isCloudMod", "setIsInitCloudModType", "y", "buttonStatus", "p", "d", "Lcom/tencent/sqshow/zootopia/data/ZootopiaDownloadBarType;", "e", "Landroid/view/View;", "t", "()Landroid/view/View;", "N", "(Landroid/view/View;)V", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "j", "()Landroid/widget/ImageView;", "G", "(Landroid/widget/ImageView;)V", "loadIcon", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "k", "()Landroid/widget/TextView;", "H", "(Landroid/widget/TextView;)V", "loadStatus", "i", ReportConstant.COSTREPORT_PREFIX, "M", "updateSize", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/zootopia/view/PercentProgressBar;", "()Lcom/tencent/mobileqq/zootopia/view/PercentProgressBar;", "K", "(Lcom/tencent/mobileqq/zootopia/view/PercentProgressBar;)V", "progressBar", "Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", "Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/widget/RoundRelativeLayout;", "L", "(Lcom/tencent/mobileqq/widget/RoundRelativeLayout;)V", "roundView", "D", "g", "E", "backgroundView", "Landroid/graphics/drawable/Drawable;", "getNormalBackground", "()Landroid/graphics/drawable/Drawable;", "setNormalBackground", "(Landroid/graphics/drawable/Drawable;)V", "normalBackground", "setLoadingBackground", "loadingBackground", "getMaintenanceBackground", "setMaintenanceBackground", "maintenanceBackground", "getInvalidBackground", "setInvalidBackground", "invalidBackground", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton$a;", "Lcom/tencent/mobileqq/z1/download/diffpatch/ZPlanMapDiffPatchInfo;", "Z", "isShowButtonSubText", "Lorg/libpag/PAGView;", "Lorg/libpag/PAGView;", "buttonLoadedPagAnim", "Lorg/libpag/PAGFile;", "Lorg/libpag/PAGFile;", "pagFile", "Landroid/view/ViewStub;", "P", "Landroid/view/ViewStub;", "animPlaceHolder", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()I", "setCurProgress", "(I)V", "curProgress", "Lcom/tencent/sqshow/zootopia/utils/PagLoader;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/sqshow/zootopia/utils/PagLoader;", "pagLoader", "Lcom/tencent/mobileqq/zootopia/utils/e;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zootopia/utils/e;", "fastClickUtils", "T", "Ls84/a;", "buttonStyle", "U", "cloudModBtnStyle", "V", "isInitCloudModType", "", "W", "Ljava/util/Map;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/util/Map;", "statusTextMap", "Lorg/libpag/PAGView$PAGViewListener;", "a0", "Lorg/libpag/PAGView$PAGViewListener;", "pagListener", "value", "b0", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "o", "()Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "setStatus", "(Lcom/tencent/sqshow/zootopia/data/ButtonStatus;)V", "()F", "currentProcess", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "c0", "a", "b", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public class ZootopiaDownloadButton extends RelativeLayout implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    protected RoundRelativeLayout roundView;

    /* renamed from: D, reason: from kotlin metadata */
    protected View backgroundView;

    /* renamed from: E, reason: from kotlin metadata */
    private Drawable normalBackground;

    /* renamed from: F, reason: from kotlin metadata */
    private Drawable loadingBackground;

    /* renamed from: G, reason: from kotlin metadata */
    private Drawable maintenanceBackground;

    /* renamed from: H, reason: from kotlin metadata */
    private Drawable invalidBackground;

    /* renamed from: I, reason: from kotlin metadata */
    private a buttonClickListener;

    /* renamed from: J, reason: from kotlin metadata */
    private long allSize;

    /* renamed from: K, reason: from kotlin metadata */
    private ZPlanMapDiffPatchInfo diffPatchInfo;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isShowButtonSubText;

    /* renamed from: M, reason: from kotlin metadata */
    private PAGView buttonLoadedPagAnim;

    /* renamed from: N, reason: from kotlin metadata */
    private PAGFile pagFile;

    /* renamed from: P, reason: from kotlin metadata */
    private ViewStub animPlaceHolder;

    /* renamed from: Q, reason: from kotlin metadata */
    private int curProgress;

    /* renamed from: R, reason: from kotlin metadata */
    private PagLoader pagLoader;

    /* renamed from: S, reason: from kotlin metadata */
    private final com.tencent.mobileqq.zootopia.utils.e fastClickUtils;

    /* renamed from: T, reason: from kotlin metadata */
    private s84.a buttonStyle;

    /* renamed from: U, reason: from kotlin metadata */
    private volatile s84.a cloudModBtnStyle;

    /* renamed from: V, reason: from kotlin metadata */
    private volatile boolean isInitCloudModType;

    /* renamed from: W, reason: from kotlin metadata */
    private final Map<ButtonStatus, String> statusTextMap;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final PAGView.PAGViewListener pagListener;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ButtonStatus status;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ZootopiaDownloadBarType pageType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    protected View view;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    protected ImageView loadIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    protected TextView loadStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    protected TextView updateSize;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    protected PercentProgressBar progressBar;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton$a;", "", "Landroid/view/View;", "view", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "type", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface a {
        void a(View view, ButtonStatus type);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton$c;", "Lcom/tencent/sqshow/zootopia/utils/PagLoader$b;", "", "result", "", "onComplete", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "d", "Lmqq/util/WeakReference;", "mButton", "button", "<init>", "(Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements PagLoader.b {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZootopiaDownloadButton> mButton;

        public c(ZootopiaDownloadButton zootopiaDownloadButton) {
            this.mButton = new WeakReference<>(zootopiaDownloadButton);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(c this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ZootopiaDownloadButton zootopiaDownloadButton = this$0.mButton.get();
            if (zootopiaDownloadButton != null) {
                Context context = zootopiaDownloadButton.getContext();
                if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                    zootopiaDownloadButton.w();
                } else {
                    QLog.d("ZootopiaDownloadButton", 4, "activity is finishing");
                }
            }
        }

        @Override // com.tencent.sqshow.zootopia.utils.PagLoader.b
        public void onComplete(boolean result) {
            if (result) {
                QLog.d("ZootopiaDownloadButton", 4, "loadPag success");
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZootopiaDownloadButton.c.b(ZootopiaDownloadButton.c.this);
                    }
                });
            } else {
                QLog.e("ZootopiaDownloadButton", 4, "loadPag failed");
            }
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f329631a;

        static {
            int[] iArr = new int[ButtonStatus.values().length];
            try {
                iArr[ButtonStatus.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonStatus.UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonStatus.LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonStatus.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ButtonStatus.WAITING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ButtonStatus.MAINTENANCE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ButtonStatus.APPOINTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ButtonStatus.PHONE_MODEL_INVALID.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ButtonStatus.ONLY_DOWNLOAD.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ButtonStatus.INVALID.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            f329631a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton$e", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "pagView", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements PAGView.PAGViewListener {
        e() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView pagView) {
            Intrinsics.checkNotNullParameter(pagView, "pagView");
            PAGView pAGView = ZootopiaDownloadButton.this.buttonLoadedPagAnim;
            if (pAGView == null) {
                return;
            }
            pAGView.setVisibility(4);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView pagView) {
            Intrinsics.checkNotNullParameter(pagView, "pagView");
            PAGView pAGView = ZootopiaDownloadButton.this.buttonLoadedPagAnim;
            if (pAGView != null) {
                pAGView.stop();
            }
            PAGView pAGView2 = ZootopiaDownloadButton.this.buttonLoadedPagAnim;
            if (pAGView2 != null) {
                pAGView2.setVisibility(4);
            }
            ZootopiaDownloadButton.this.n().setVisibility(0);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView pagView) {
            Intrinsics.checkNotNullParameter(pagView, "pagView");
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView pagView) {
            Intrinsics.checkNotNullParameter(pagView, "pagView");
            ZootopiaDownloadButton.this.n().setVisibility(8);
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView pagView) {
            Intrinsics.checkNotNullParameter(pagView, "pagView");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDownloadButton(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(ZootopiaDownloadButton this$0, PercentProgressBar view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        if (this$0.status == ButtonStatus.LOADING) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            view.setProgress(((Integer) animatedValue).intValue());
        }
    }

    private final void F(long allSize, ZPlanMapDiffPatchInfo diffPatchInfo) {
        pv4.e diffPatchInfo2;
        if (!this.isShowButtonSubText) {
            s().setVisibility(8);
            return;
        }
        this.allSize = allSize;
        this.diffPatchInfo = diffPatchInfo;
        if (this.status != ButtonStatus.PAUSE) {
            String a16 = t74.a.a(allSize);
            long j3 = (diffPatchInfo == null || (diffPatchInfo2 = diffPatchInfo.diffPatchInfo()) == null) ? 0L : diffPatchInfo2.f427590b;
            if (j3 > 0 && ZPlanMapDiffPatchInfo.INSTANCE.a()) {
                s().setText(t74.a.a(j3));
            } else {
                s().setText(a16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I() {
        PAGFile pAGFile = this.pagFile;
        if (pAGFile == null) {
            return;
        }
        PAGText textData = pAGFile != null ? pAGFile.getTextData(0) : null;
        if (textData != null) {
            textData.text = p(ButtonStatus.LOADED);
            textData.fontFamily = "monospace";
            PAGFile pAGFile2 = this.pagFile;
            if (pAGFile2 != null) {
                pAGFile2.replaceText(0, textData);
            }
        }
    }

    private final void J() {
        if (this.isShowButtonSubText) {
            int progress = m().getProgress();
            int i3 = this.curProgress;
            if (progress >= i3) {
                i3 = m().getProgress();
            }
            this.curProgress = i3;
            s().setVisibility(0);
            s().setText(this.curProgress + "%");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        View inflate;
        if (this.pagLoader.d()) {
            if (this.buttonLoadedPagAnim == null) {
                ViewStub viewStub = this.animPlaceHolder;
                this.buttonLoadedPagAnim = (viewStub == null || (inflate = viewStub.inflate()) == null) ? null : (PAGView) inflate.findViewById(R.id.phd);
            }
            com.tencent.mobileqq.zootopia.utils.c.f329552a.b(this.pageType, new Function1<PAGFile, Unit>() { // from class: com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton$initPagView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PAGFile pAGFile) {
                    invoke2(pAGFile);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PAGFile pAGFile) {
                    ZootopiaDownloadButton.this.pagFile = pAGFile;
                    ZootopiaDownloadButton.this.I();
                }
            });
        }
    }

    private final void x() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.d78, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026mon_download, this, true)");
        N(inflate);
        View findViewById = t().findViewById(R.id.pkm);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.cloud_mod_icon)");
        G((ImageView) findViewById);
        View findViewById2 = t().findViewById(R.id.qzd);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.zootopia_btn_status)");
        H((TextView) findViewById2);
        View findViewById3 = t().findViewById(R.id.r0k);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.zootopia_download_filesize)");
        M((TextView) findViewById3);
        View findViewById4 = t().findViewById(R.id.f163604r11);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.z\u2026opia_percent_progressBar)");
        K((PercentProgressBar) findViewById4);
        this.animPlaceHolder = (ViewStub) t().findViewById(R.id.phe);
        View findViewById5 = t().findViewById(R.id.r0j);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.zootopia_download_button)");
        L((RoundRelativeLayout) findViewById5);
        View findViewById6 = t().findViewById(R.id.r0v);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.zootopia_load_background)");
        E(findViewById6);
        u();
        v();
        super.setOnClickListener(this);
    }

    private final void z() {
        if (this.pagLoader.d()) {
            w();
        } else {
            QLog.i("ZootopiaDownloadButton", 4, "pag is not loaded waiting loading");
            this.pagLoader.f(getContext(), new c(this));
        }
    }

    protected void A() {
        PAGFile pAGFile;
        PAGView pAGView = this.buttonLoadedPagAnim;
        if (pAGView != null && (pAGFile = this.pagFile) != null) {
            if (pAGView != null) {
                pAGView.setComposition(pAGFile);
                pAGView.flush();
                pAGView.setRepeatCount(1);
                pAGView.removeListener(this.pagListener);
                pAGView.addListener(this.pagListener);
                pAGView.setVisibility(0);
                pAGView.setProgress(0.0d);
                if (!pAGView.isPlaying()) {
                    pAGView.play();
                }
            }
            setCustomStatusStyle(this.status);
            return;
        }
        setCustomStatusStyle(this.status);
    }

    public void B() {
        if (getIsInitCloudModType()) {
            m84.b.g(k(), TipsElementData.DEFAULT_COLOR);
            j().setVisibility(8);
            k().setTypeface(Typeface.defaultFromStyle(0));
            v();
        }
    }

    protected final void E(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.backgroundView = view;
    }

    protected final void G(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.loadIcon = imageView;
    }

    protected final void H(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.loadStatus = textView;
    }

    protected final void K(PercentProgressBar percentProgressBar) {
        Intrinsics.checkNotNullParameter(percentProgressBar, "<set-?>");
        this.progressBar = percentProgressBar;
    }

    protected final void L(RoundRelativeLayout roundRelativeLayout) {
        Intrinsics.checkNotNullParameter(roundRelativeLayout, "<set-?>");
        this.roundView = roundRelativeLayout;
    }

    protected final void M(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.updateSize = textView;
    }

    protected final void N(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.view = view;
    }

    public Drawable f(ButtonStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        switch (d.f329631a[status.ordinal()]) {
            case 3:
            case 4:
            case 5:
                return this.loadingBackground;
            case 6:
            case 7:
            case 8:
            case 9:
                return this.maintenanceBackground;
            case 10:
                return this.invalidBackground;
            default:
                return this.normalBackground;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final View g() {
        View view = this.backgroundView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backgroundView");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h, reason: from getter */
    public final int getCurProgress() {
        return this.curProgress;
    }

    public final float i() {
        return m().getProgress() / 100.0f;
    }

    protected final ImageView j() {
        ImageView imageView = this.loadIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadIcon");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView k() {
        TextView textView = this.loadStatus;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadStatus");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l, reason: from getter */
    public final Drawable getLoadingBackground() {
        return this.loadingBackground;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final PercentProgressBar m() {
        PercentProgressBar percentProgressBar = this.progressBar;
        if (percentProgressBar != null) {
            return percentProgressBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        return null;
    }

    protected final RoundRelativeLayout n() {
        RoundRelativeLayout roundRelativeLayout = this.roundView;
        if (roundRelativeLayout != null) {
            return roundRelativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("roundView");
        return null;
    }

    /* renamed from: o, reason: from getter */
    public final ButtonStatus getStatus() {
        return this.status;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.fastClickUtils.a() || (aVar = this.buttonClickListener) == null) {
            return;
        }
        aVar.a(this, this.status);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String p(ButtonStatus buttonStatus) {
        Intrinsics.checkNotNullParameter(buttonStatus, "buttonStatus");
        if (this.statusTextMap.containsKey(buttonStatus)) {
            return this.statusTextMap.get(buttonStatus);
        }
        return getResources().getString(R.string.xav);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map<ButtonStatus, String> q() {
        return this.statusTextMap;
    }

    public String r() {
        ButtonStatus buttonStatus = this.status;
        if (buttonStatus == ButtonStatus.LOADING) {
            String a16 = m().a();
            Intrinsics.checkNotNullExpressionValue(a16, "{\n            progressBar.percentText\n        }");
            return a16;
        }
        String str = this.statusTextMap.get(buttonStatus);
        return str == null ? k().getText().toString() : str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TextView s() {
        TextView textView = this.updateSize;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("updateSize");
        return null;
    }

    public final void setButtonStatusListener(a buttonClickListener) {
        Intrinsics.checkNotNullParameter(buttonClickListener, "buttonClickListener");
        this.buttonClickListener = buttonClickListener;
    }

    public final void setButtonType(ZootopiaDownloadBarType pageType) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        this.pageType = pageType;
        v();
        z();
        invalidate();
    }

    public void setCloudModStyle() {
        Typeface defaultFromStyle;
        k().setText(this.statusTextMap.get(ButtonStatus.CLOUD_GAME));
        m84.b.g(k(), this.cloudModBtnStyle.getTextColor());
        k().setTextSize(this.cloudModBtnStyle.getTextSize());
        TextView k3 = k();
        if (this.cloudModBtnStyle.getIsTextBold()) {
            defaultFromStyle = Typeface.defaultFromStyle(1);
        } else {
            defaultFromStyle = Typeface.defaultFromStyle(0);
        }
        k3.setTypeface(defaultFromStyle);
        g().setBackground(AppCompatResources.getDrawable(getRootView().getContext(), this.cloudModBtnStyle.getLoadingBackgroundID()));
        s().setVisibility(8);
        k().setVisibility(0);
        m().setVisibility(0);
        j().setVisibility(0);
        m().setTextVisible(false);
        ViewGroup.LayoutParams layoutParams = j().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.width = ViewUtils.dpToPx(this.cloudModBtnStyle.getIconWidth());
        layoutParams2.height = ViewUtils.dpToPx(this.cloudModBtnStyle.getIconHeight());
        layoutParams2.setMargins(0, 0, ViewUtils.dpToPx(this.cloudModBtnStyle.getIconRightMargin()), 0);
        j().setLayoutParams(layoutParams2);
    }

    public void setCustomStatusStyle(ButtonStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        k().setText(p(status));
        m().setProgress(0);
        this.curProgress = 0;
        int i3 = d.f329631a[status.ordinal()];
        if (i3 != 1 && i3 != 2) {
            s().setVisibility(8);
        } else {
            s().setVisibility(0);
            F(this.allSize, this.diffPatchInfo);
        }
        k().setVisibility(0);
        m().setVisibility(4);
        g().setBackground(f(status));
    }

    public final void setDownloadSize(ZootopiaMapDetail mapDetail) {
        Intrinsics.checkNotNullParameter(mapDetail, "mapDetail");
        F(mapDetail.getModVersionSimpleData().getDataSize(), mapDetail.getDiffPatchInfo());
    }

    public final void setIsInitCloudModType(boolean isCloudMod) {
        this.isInitCloudModType = isCloudMod;
    }

    public void setLoadingStatusStyle() {
        k().setVisibility(8);
        s().setVisibility(8);
        m().setVisibility(0);
        m().setTextVisible(true);
        setProcess(m().getProgress() / 100.0f);
        g().setBackground(null);
        m().setBackground(this.loadingBackground);
    }

    public final void setNormalBackgroundDrwable(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.normalBackground = drawable;
    }

    public void setPauseStatusStyle() {
        k().setText(this.statusTextMap.get(ButtonStatus.PAUSE));
        J();
        s().setVisibility(8);
        k().setVisibility(0);
        g().setBackground(null);
        m().setVisibility(0);
        m().setTextVisible(false);
        m().setBackground(this.loadingBackground);
    }

    public void setProgressBar() {
        m().setProgress(this.curProgress);
        if (this.status == ButtonStatus.PAUSE) {
            J();
        }
    }

    public final void setShowButtonSubText(boolean showButtonSubText) {
        this.isShowButtonSubText = showButtonSubText;
    }

    public final void setStatus(ButtonStatus value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ButtonStatus buttonStatus = this.status;
        this.status = value;
        ButtonStatus buttonStatus2 = ButtonStatus.LOADING;
        if (value == buttonStatus2) {
            setLoadingStatusStyle();
            return;
        }
        if (value == ButtonStatus.PAUSE) {
            setPauseStatusStyle();
            return;
        }
        if (value == ButtonStatus.LOADED && buttonStatus == buttonStatus2) {
            A();
        } else if (value == ButtonStatus.CLOUD_GAME) {
            setCloudModStyle();
        } else {
            setCustomStatusStyle(value);
        }
    }

    public final void setStatusText(ButtonStatus status, String statusValue) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (statusValue == null || Intrinsics.areEqual(statusValue, this.statusTextMap.get(status))) {
            return;
        }
        this.statusTextMap.put(status, statusValue);
        if (ButtonStatus.LOADED == status) {
            I();
            ButtonStatus buttonStatus = this.status;
            if (buttonStatus == status) {
                setStatus(buttonStatus);
            }
        }
    }

    protected final View t() {
        View view = this.view;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("view");
        return null;
    }

    public void u() {
        this.normalBackground = AppCompatResources.getDrawable(getRootView().getContext(), R.drawable.gz8);
        this.maintenanceBackground = AppCompatResources.getDrawable(getRootView().getContext(), R.drawable.gz7);
        this.invalidBackground = AppCompatResources.getDrawable(getRootView().getContext(), R.drawable.gz5);
    }

    public void v() {
        s84.a a16 = s84.c.f433498a.a(this.pageType);
        this.buttonStyle = a16;
        if (a16 == null) {
            return;
        }
        m().setPaintSize(a16.getTextSize());
        k().setTextSize(a16.getTextSize());
        k().setTypeface(Typeface.MONOSPACE);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = ViewUtils.dpToPx(a16.getWidth());
        layoutParams.height = ViewUtils.dpToPx(a16.getHeight());
        layoutParams.addRule(13);
        n().f316195e = ViewUtils.dpToPx(a16.getRadius());
        n().f316197h = 15;
        n().setLayoutParams(layoutParams);
        this.loadingBackground = AppCompatResources.getDrawable(getRootView().getContext(), a16.getLoadingBackgroundID());
        g().setBackground(this.normalBackground);
        g().setVisibility(0);
        QLog.d("ZootopiaDownloadButton", 1, "initButtonStyle " + this.buttonStyle);
    }

    /* renamed from: y, reason: from getter */
    public final boolean getIsInitCloudModType() {
        return this.isInitCloudModType;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDownloadButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void C(final PercentProgressBar view, int progress) {
        ValueAnimator duration = ValueAnimator.ofInt(view.getProgress(), progress).setDuration(200L);
        duration.setInterpolator(new LinearInterpolator());
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.zootopia.view.p
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZootopiaDownloadButton.D(ZootopiaDownloadButton.this, view, valueAnimator);
            }
        });
        duration.start();
    }

    public final void setDownloadSize(ZootopiaMapSimpleInfo mapSimpleInfo) {
        Intrinsics.checkNotNullParameter(mapSimpleInfo, "mapSimpleInfo");
        F(mapSimpleInfo.getSimpleVerInfo().getModVersionSimpleData().getDataSize(), mapSimpleInfo.getSimpleVerInfo().getDiffPatchInfo());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDownloadButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Map<ButtonStatus, String> mutableMapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.pageType = ZootopiaDownloadBarType.LIST_DOWNLOAD_BAR;
        this.isShowButtonSubText = true;
        this.pagLoader = PagLoader.c();
        this.fastClickUtils = new com.tencent.mobileqq.zootopia.utils.e();
        this.cloudModBtnStyle = s84.c.f433498a.b();
        ButtonStatus buttonStatus = ButtonStatus.INIT;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(buttonStatus, "\u52a0\u8f7d\u8fdb\u5165"), new Pair(ButtonStatus.WAITING, "\u7b49\u5f85\u4e0b\u8f7d"), new Pair(ButtonStatus.LOADING, "\u52a0\u8f7d\u4e2d"), new Pair(ButtonStatus.LOADED, "\u7acb\u5373\u8fdb\u5165"), new Pair(ButtonStatus.UPDATE, "\u66f4\u65b0"), new Pair(ButtonStatus.MAINTENANCE, "\u7ef4\u62a4\u4e2d"), new Pair(ButtonStatus.UPDATE_SYSTEM, "\u5347\u7ea7QQ"), new Pair(ButtonStatus.PAUSE, "\u5df2\u6682\u505c"), new Pair(ButtonStatus.INVALID, "\u5df2\u4e0b\u67b6"), new Pair(ButtonStatus.APPOINTED, "\u5df2\u9884\u7ea6"), new Pair(ButtonStatus.CAN_APPOINTMENT, "\u7acb\u5373\u9884\u7ea6"), new Pair(ButtonStatus.CLOUD_GAME, "\u79d2\u73a9"), new Pair(ButtonStatus.ONLY_DOWNLOAD, "\u5f85\u5f00\u542f"));
        this.statusTextMap = mutableMapOf;
        this.pagListener = new e();
        this.status = buttonStatus;
        x();
        z();
    }

    public final void setProgressDrawable(Drawable drawable) {
        if (drawable != null) {
            m().setProgressDrawable(drawable);
        }
    }

    public void setCloudModButtonStyle(s84.a style) {
        if (style == null) {
            return;
        }
        this.cloudModBtnStyle = style;
    }

    public void setProcess(float progress) {
        this.curProgress = (int) (100 * progress);
        ButtonStatus buttonStatus = this.status;
        if (buttonStatus == ButtonStatus.LOADING) {
            C(m(), this.curProgress);
            return;
        }
        if (progress > 0.0f && buttonStatus == ButtonStatus.INIT) {
            setStatus(ButtonStatus.PAUSE);
        }
        setProgressBar();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l3) {
    }
}
