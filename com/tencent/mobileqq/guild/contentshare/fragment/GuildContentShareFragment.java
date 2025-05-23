package com.tencent.mobileqq.guild.contentshare.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildContentShareApi;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.extension.h;
import com.tencent.mobileqq.guild.contentshare.AbsGuildContentShareTemplate;
import com.tencent.mobileqq.guild.contentshare.widget.ContentSharePlatformItemView;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.annotation.QQPermissionConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.eh;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yg1.ItemData;

/* compiled from: P */
@QQPermissionConfig(id = QQPermissionConstants.Business.ID.QQ_CHANNEL_CONTENT_SHARE, scene = QQPermissionConstants.Business.SCENE.QQCHANNEL_CONTENT_SHARE_SAVE_ALBUM)
@Metadata(d1 = {"\u0000\u00e2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 \u00ac\u00012\u00020\u00012\u00020\u0002:\u0004\u00ad\u0001\u00ae\u0001B\t\u00a2\u0006\u0006\b\u00aa\u0001\u0010\u00ab\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0003J\b\u0010\u0013\u001a\u00020\u0003H\u0003J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0018\u0010$\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010(\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u001fH\u0002J\b\u0010)\u001a\u00020\u0003H\u0002J\b\u0010*\u001a\u00020\u0003H\u0002J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001bH\u0002J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020-H\u0002J8\u00104\u001a\"\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010201j\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u000102`32\u0006\u0010#\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u001fH\u0002J\u0010\u00107\u001a\u00020\u00032\u0006\u00106\u001a\u000205H\u0016J&\u0010=\u001a\u0004\u0018\u00010\u000b2\u0006\u00109\u001a\u0002082\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010<\u001a\u0004\u0018\u00010-H\u0016J\u001a\u0010>\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010-H\u0016J\u0012\u0010@\u001a\u00020\u00032\b\u0010?\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010C\u001a\u00020\u00032\u0006\u0010B\u001a\u00020AH\u0016J\b\u0010D\u001a\u00020\u0003H\u0016J\"\u0010I\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u001d2\b\u0010H\u001a\u0004\u0018\u00010GH\u0016J\b\u0010J\u001a\u00020\rH\u0016R\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010\\\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010MR\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010gR$\u0010o\u001a\u0012\u0012\u0004\u0012\u00020!0kj\b\u0012\u0004\u0012\u00020!`l8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010nR$\u0010v\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010}\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R*\u0010\u0085\u0001\u001a\u0004\u0018\u00010~8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R+\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001b\u0010\u008f\u0001\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R \u0010\u0093\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190\u0090\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001b\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0018\u0010\u009c\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009b\u0001\u0010bR\u0018\u0010\u009e\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009d\u0001\u0010bR\u0018\u0010\u00a0\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009f\u0001\u0010XR\u0018\u0010\u00a2\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a1\u0001\u0010XR\u0018\u0010\u00a4\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a3\u0001\u0010bR\u0019\u0010\u00a6\u0001\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u00a3\u0001R3\u0010\u00a9\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020201j\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u000202`38\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001\u00a8\u0006\u00af\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/fragment/GuildContentShareFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View$OnClickListener;", "", "Mh", "Ih", "Vh", "Rh", "", HippyTKDListViewAdapter.X, "y", "Landroid/view/View;", "view", "", "Xh", "Jh", "initData", "Wh", "Uh", "Th", "Ph", "Dh", "Oh", "Nh", "Lh", "Ljava/io/File;", "Fh", "Landroid/graphics/Bitmap;", "Eh", "", WinkDengtaReportConstant.Params.REPORT_TEMPLATE_TYPE, "", "Ch", "Lyg1/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "position", "Ah", "yh", "isSuccess", "failReason", OcrConfig.CHINESE, "Yh", "xh", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Bh", "Landroid/os/Bundle;", "bundle", "Kh", "name", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Gh", "Landroid/content/Context;", "context", "onAttach", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "v", NodeProps.ON_CLICK, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "isWrapContent", "Landroidx/constraintlayout/widget/ConstraintLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/constraintlayout/widget/ConstraintLayout;", "contentView", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "buttonClose", "Landroid/widget/Button;", "E", "Landroid/widget/Button;", "buttonSave", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "qqPermission", "G", "pagerContainer", "Landroidx/viewpager2/widget/ViewPager2;", "H", "Landroidx/viewpager2/widget/ViewPager2;", "shareContentViewPager", "Lug1/a;", "I", "Lug1/a;", "shareContentAdapter", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "bottomContainer", "K", "sharePlatformContainer", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "L", "Ljava/util/ArrayList;", "platformItemDataList", "M", "Ljava/lang/Object;", "getShareData", "()Ljava/lang/Object;", "setShareData", "(Ljava/lang/Object;)V", "shareData", "N", "Ljava/lang/Integer;", "Hh", "()Ljava/lang/Integer;", "setShareScene", "(Ljava/lang/Integer;)V", "shareScene", "Lcom/tencent/mobileqq/guild/contentshare/d;", "P", "Lcom/tencent/mobileqq/guild/contentshare/d;", "getContentShareInfo", "()Lcom/tencent/mobileqq/guild/contentshare/d;", "Zh", "(Lcom/tencent/mobileqq/guild/contentshare/d;)V", "contentShareInfo", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/graphics/Bitmap;", "getBlurBitmap", "()Landroid/graphics/Bitmap;", "setBlurBitmap", "(Landroid/graphics/Bitmap;)V", "blurBitmap", BdhLogUtil.LogTag.Tag_Req, "Landroid/os/Bundle;", "paramBundle", "Landroid/util/SparseArray;", ExifInterface.LATITUDE_SOUTH, "Landroid/util/SparseArray;", "cacheFiles", "Lcom/tencent/mobileqq/guild/contentshare/AbsGuildContentShareTemplate;", "T", "Lcom/tencent/mobileqq/guild/contentshare/AbsGuildContentShareTemplate;", "currentSelectedTemplate", "U", "Landroid/view/View;", "currentSelectedTemplateView", "V", "screenHeight", "W", "screenWidth", "X", "downX", "Y", "downY", "Z", "touchSlop", "a0", "isPagerSettling", "b0", "Ljava/util/HashMap;", "dtPageParam", "<init>", "()V", "c0", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildContentShareFragment extends QPublicBaseFragment implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout contentView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView buttonClose;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Button buttonSave;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QQPermission qqPermission;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout pagerContainer;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ViewPager2 shareContentViewPager;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ug1.a shareContentAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private LinearLayout bottomContainer;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private LinearLayout sharePlatformContainer;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Object shareData;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.contentshare.d contentShareInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private Bitmap blurBitmap;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Bundle paramBundle;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private AbsGuildContentShareTemplate currentSelectedTemplate;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private View currentSelectedTemplateView;

    /* renamed from: X, reason: from kotlin metadata */
    private float downX;

    /* renamed from: Y, reason: from kotlin metadata */
    private float downY;

    /* renamed from: Z, reason: from kotlin metadata */
    private int touchSlop;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean isPagerSettling;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<ItemData> platformItemDataList = new ArrayList<>();

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private Integer shareScene = -1;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private SparseArray<File> cacheFiles = new SparseArray<>();

    /* renamed from: V, reason: from kotlin metadata */
    private int screenHeight = BaseApplication.context.getResources().getDisplayMetrics().heightPixels;

    /* renamed from: W, reason: from kotlin metadata */
    private int screenWidth = BaseApplication.context.getResources().getDisplayMetrics().widthPixels;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> dtPageParam = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/fragment/GuildContentShareFragment$b;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "Landroid/view/View;", "page", "", "position", "", "transformPage", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewPager2.PageTransformer {
        @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
        public void transformPage(@NotNull View page, float position) {
            Intrinsics.checkNotNullParameter(page, "page");
            if (position < -1.0f) {
                float f16 = 1;
                float f17 = (0.1f * position) + f16;
                page.setScaleX(f17);
                page.setScaleY(f17);
                page.setAlpha(f16 + (position * 0.2f));
                return;
            }
            if (position <= 0.0f) {
                float f18 = 1;
                float f19 = (0.1f * position) + f18;
                page.setScaleX(f19);
                page.setScaleY(f19);
                page.setAlpha(f18 + (position * 0.2f));
                return;
            }
            if (position <= 1.0f) {
                float f26 = 1;
                float f27 = f26 - (0.1f * position);
                page.setScaleX(f27);
                page.setScaleY(f27);
                page.setAlpha(f26 - (position * 0.2f));
                return;
            }
            if (position > 1.0f) {
                float f28 = 1;
                float f29 = f28 - (0.1f * position);
                page.setScaleX(f29);
                page.setScaleY(f29);
                page.setAlpha(f28 - (position * 0.2f));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/contentshare/fragment/GuildContentShareFragment$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "", "itemPosition", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "getItemOffsets", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, int itemPosition, @NotNull RecyclerView parent) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(parent, "parent");
            outRect.left = ViewUtils.dpToPx(12.5f);
            outRect.right = ViewUtils.dpToPx(12.5f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/contentshare/fragment/GuildContentShareFragment$d", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends ViewPager2.OnPageChangeCallback {
        d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int state) {
            boolean z16;
            super.onPageScrollStateChanged(state);
            GuildContentShareFragment guildContentShareFragment = GuildContentShareFragment.this;
            if (state == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            guildContentShareFragment.isPagerSettling = z16;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            AbsGuildContentShareTemplate absGuildContentShareTemplate;
            super.onPageSelected(position);
            GuildContentShareFragment guildContentShareFragment = GuildContentShareFragment.this;
            ug1.a aVar = guildContentShareFragment.shareContentAdapter;
            View view = null;
            if (aVar != null) {
                absGuildContentShareTemplate = aVar.i0(position);
            } else {
                absGuildContentShareTemplate = null;
            }
            guildContentShareFragment.currentSelectedTemplate = absGuildContentShareTemplate;
            GuildContentShareFragment guildContentShareFragment2 = GuildContentShareFragment.this;
            ug1.a aVar2 = guildContentShareFragment2.shareContentAdapter;
            if (aVar2 != null) {
                view = aVar2.j0(position);
            }
            guildContentShareFragment2.currentSelectedTemplateView = view;
        }
    }

    private final void Ah(ItemData item, int position) {
        File Fh = Fh();
        Bitmap Eh = Eh();
        if (Fh != null && Eh != null) {
            QRouteApi api = QRoute.api(IGuildContentShareApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGuildContentShareApi::class.java)");
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
            IGuildContentShareApi.a.a((IGuildContentShareApi) api, activity, Eh, Fh, item.getPlatformType(), false, 16, null);
            com.tencent.mobileqq.guild.contentshare.d dVar = this.contentShareInfo;
            if (dVar != null) {
                e.f216326a.b(item, position, dVar, this.shareScene);
            }
        }
    }

    private final Bitmap Bh(Bitmap bitmap) {
        Bitmap createBitmap = Bitmap.createBitmap(this.screenWidth, this.screenHeight, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(\n          \u2026onfig.ARGB_8888\n        )");
        Canvas canvas = new Canvas(createBitmap);
        eh.a(bitmap, 100);
        Rect rect = new Rect(0, 0, this.screenWidth, this.screenHeight);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        paint.setShader(null);
        paint.setColor(Color.parseColor("#000000"));
        paint.setAlpha(51);
        canvas.drawRect(0.0f, 0.0f, this.screenWidth, this.screenHeight, paint);
        return createBitmap;
    }

    private final String Ch(int templateType) {
        return "GuildContentShareFragment_" + templateType;
    }

    private final float Dh() {
        if (FontSettingManager.getFontLevel() >= 17.0f) {
            return FontSettingManager.systemMetrics.density / getResources().getDisplayMetrics().density;
        }
        if (this.screenWidth < ViewUtils.dip2px(422.0f)) {
            return 0.8f;
        }
        return 1.0f;
    }

    private final Bitmap Eh() {
        Integer num;
        Bitmap bitmap = null;
        Integer num2 = null;
        if (this.currentSelectedTemplateView != null) {
            AbsGuildContentShareTemplate absGuildContentShareTemplate = this.currentSelectedTemplate;
            if (absGuildContentShareTemplate != null) {
                num = Integer.valueOf(absGuildContentShareTemplate.getCom.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant.Params.REPORT_TEMPLATE_TYPE java.lang.String());
            } else {
                num = null;
            }
            if (num != null) {
                Bitmap f16 = ImageCacheHelper.f98636a.f(Ch(num.intValue()));
                if (f16 != null && !f16.isRecycled()) {
                    return f16;
                }
            }
            IGuildContentShareApi iGuildContentShareApi = (IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class);
            View view = this.currentSelectedTemplateView;
            Intrinsics.checkNotNull(view);
            AbsGuildContentShareTemplate absGuildContentShareTemplate2 = this.currentSelectedTemplate;
            if (absGuildContentShareTemplate2 != null) {
                num2 = absGuildContentShareTemplate2.f();
            }
            bitmap = iGuildContentShareApi.getShareBitmap(view, num2);
            if (num != null) {
                ImageCacheHelper.f98636a.i(Ch(num.intValue()), bitmap, Business.Guild);
            }
        }
        return bitmap;
    }

    private final File Fh() {
        Bitmap Eh = Eh();
        Integer num = null;
        if (Eh == null) {
            return null;
        }
        AbsGuildContentShareTemplate absGuildContentShareTemplate = this.currentSelectedTemplate;
        if (absGuildContentShareTemplate != null) {
            num = Integer.valueOf(absGuildContentShareTemplate.getCom.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant.Params.REPORT_TEMPLATE_TYPE java.lang.String());
        }
        if (num != null) {
            File file = this.cacheFiles.get(num.intValue());
            if (file != null) {
                Intrinsics.checkNotNullExpressionValue(file, "get(key)");
                return file;
            }
        }
        File createCacheFile = ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).createCacheFile(Eh);
        if (num != null) {
            this.cacheFiles.put(num.intValue(), createCacheFile);
        }
        return createCacheFile;
    }

    private final HashMap<String, Object> Gh(int position, String name) {
        QLog.i("GuildContentSharePlatformAdapter", 4, "getDTParams position=" + position + " name=" + name);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sgrp_rank", Integer.valueOf(position));
        hashMap.put("sgrp_share_item", name);
        return hashMap;
    }

    private final void Ih() {
        Bitmap bitmap = this.blurBitmap;
        if (bitmap != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(Bh(bitmap));
            ConstraintLayout constraintLayout = this.contentView;
            if (constraintLayout != null) {
                constraintLayout.setBackgroundDrawable(bitmapDrawable);
            }
        }
    }

    private final void Jh() {
        ViewGroup.LayoutParams layoutParams;
        LinearLayout linearLayout = this.bottomContainer;
        ConstraintLayout.LayoutParams layoutParams2 = null;
        if (linearLayout != null) {
            layoutParams = linearLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 == null) {
            layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        }
        if (this.screenWidth < ViewUtils.dip2px(422.0f)) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = this.screenWidth - ViewUtils.dip2px(60.0f);
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = ViewUtils.dip2px(362.0f);
        }
    }

    private final void Kh(Bundle bundle) {
        VideoReport.addToDetectionWhitelist(requireActivity());
        VideoReport.setPageId(this.contentView, "pg_sgrp_share_img");
        String string = bundle.getString("sgrp_channel_id", "");
        String string2 = bundle.getString("sgrp_sub_channel_id", "");
        Integer num = this.shareScene;
        if (num != null && num.intValue() == 0) {
            this.dtPageParam.put("sgrp_msg_type", Integer.valueOf(bundle.getInt("sgrp_msg_type", 0)));
            this.dtPageParam.put("sgrp_subchannel_type", 1);
        } else if (num != null && num.intValue() == 1) {
            HashMap<String, Object> hashMap = this.dtPageParam;
            String string3 = bundle.getString("sgrp_content_id", "");
            Intrinsics.checkNotNullExpressionValue(string3, "bundle.getString(QQGuild\u2026aram.SGRP_CONTENT_ID, \"\")");
            hashMap.put("sgrp_content_id", string3);
            this.dtPageParam.put("sgrp_subchannel_type", 7);
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setChannelPageParams(this.contentView, string, string2, this.dtPageParam);
    }

    private final void Lh() {
        Button button = this.buttonSave;
        if (button != null) {
            VideoReport.setElementId(button, "em_sgrp_save_img");
            VideoReport.setElementExposePolicy(button, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(button, ClickPolicy.REPORT_NONE);
        }
    }

    private final void Mh() {
        Ih();
        Jh();
        Rh();
        Vh();
    }

    private final void Nh() {
        ImageView imageView = this.buttonClose;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
        Button button = this.buttonSave;
        if (button != null) {
            button.setOnClickListener(this);
        }
    }

    private final void Oh() {
        this.platformItemDataList.add(new ItemData(0, R.drawable.guild_share_icon_friend, "QQ\u597d\u53cb"));
        this.platformItemDataList.add(new ItemData(1, R.drawable.oj5, "\u817e\u8baf\u9891\u9053"));
        this.platformItemDataList.add(new ItemData(2, R.drawable.guild_share_icon_wx, "\u5fae\u4fe1\u597d\u53cb"));
        this.platformItemDataList.add(new ItemData(3, R.drawable.guild_share_icon_wx_circle, "\u670b\u53cb\u5708"));
        this.platformItemDataList.add(new ItemData(4, R.drawable.guild_share_icon_qzone, "QQ\u7a7a\u95f4"));
    }

    private final void Ph() {
        Oh();
        int size = this.platformItemDataList.size();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            boolean z17 = true;
            if (i3 >= size) {
                break;
            }
            ItemData itemData = this.platformItemDataList.get(i3);
            Intrinsics.checkNotNullExpressionValue(itemData, "platformItemDataList[i]");
            final ItemData itemData2 = itemData;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ContentSharePlatformItemView contentSharePlatformItemView = new ContentSharePlatformItemView(requireContext);
            Bundle arguments = getArguments();
            if (arguments == null || !arguments.getBoolean("force_bottom_platform_item_name_color_white")) {
                z17 = false;
            }
            if (z17) {
                contentSharePlatformItemView.b(ContentSharePlatformItemView.INSTANCE.a());
            }
            final HashMap<String, Object> Gh = Gh(itemData2.getPlatformType(), itemData2.getPlatformName());
            contentSharePlatformItemView.e(itemData2);
            contentSharePlatformItemView.setTag(itemData2);
            contentSharePlatformItemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.contentshare.fragment.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildContentShareFragment.Qh(GuildContentShareFragment.this, itemData2, Gh, view);
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
            LinearLayout linearLayout = this.sharePlatformContainer;
            if (linearLayout != null) {
                linearLayout.addView(contentSharePlatformItemView, layoutParams);
            }
            VideoReport.setElementId(contentSharePlatformItemView, "em_sgrp_share_item");
            VideoReport.setElementExposePolicy(contentSharePlatformItemView, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(contentSharePlatformItemView, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent("imp", contentSharePlatformItemView, Gh);
            i3++;
        }
        float Dh = Dh();
        if (Dh == 1.0f) {
            z16 = true;
        }
        if (!z16) {
            QQGuildUIUtil.B(this.sharePlatformContainer, Dh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(GuildContentShareFragment this$0, ItemData data, HashMap dtParams, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(dtParams, "$dtParams");
        this$0.Ah(data, data.getPlatformType());
        VideoReport.reportEvent("clck", view, dtParams);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Rh() {
        ViewGroup.LayoutParams layoutParams;
        ConstraintLayout constraintLayout = this.pagerContainer;
        ConstraintLayout.LayoutParams layoutParams2 = null;
        if (constraintLayout != null) {
            layoutParams = constraintLayout.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 == null) {
            layoutParams2 = new ConstraintLayout.LayoutParams(-1, -1);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getContentShareMaxHeight();
        layoutParams2.bottomToTop = R.id.w2w;
        ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin = (int) (this.screenHeight * 0.04d);
        ConstraintLayout constraintLayout2 = this.pagerContainer;
        if (constraintLayout2 != null) {
            constraintLayout2.setLayoutParams(layoutParams2);
        }
        ConstraintLayout constraintLayout3 = this.pagerContainer;
        if (constraintLayout3 != null) {
            constraintLayout3.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.guild.contentshare.fragment.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean Sh;
                    Sh = GuildContentShareFragment.Sh(GuildContentShareFragment.this, view, motionEvent);
                    return Sh;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Sh(GuildContentShareFragment this$0, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        ViewPager2 viewPager2 = this$0.shareContentViewPager;
        if (viewPager2 == null) {
            return true;
        }
        int action = event.getAction();
        if (action != 0) {
            if (action == 2 && !this$0.Xh(event.getX(), event.getY(), viewPager2)) {
                event.setLocation(event.getX(), this$0.downY);
            }
        } else {
            this$0.downX = event.getX();
            this$0.downY = event.getY();
        }
        if (this$0.isPagerSettling && !this$0.Xh(event.getX(), event.getY(), viewPager2)) {
            return true;
        }
        return viewPager2.dispatchTouchEvent(event);
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void Th() {
        com.tencent.mobileqq.guild.contentshare.d dVar = this.contentShareInfo;
        if (dVar != null) {
            this.shareContentAdapter = new ug1.a(dVar);
        }
        ug1.a aVar = this.shareContentAdapter;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"WrongConstant"})
    public final void Uh() {
        Context context;
        ViewPager2 viewPager2;
        Th();
        ViewPager2 viewPager22 = this.shareContentViewPager;
        if (viewPager22 != null) {
            viewPager22.setAdapter(this.shareContentAdapter);
        }
        ViewPager2 viewPager23 = this.shareContentViewPager;
        if (viewPager23 != null) {
            viewPager23.setPageTransformer(new b());
        }
        ViewPager2 viewPager24 = this.shareContentViewPager;
        if (viewPager24 != null) {
            viewPager24.setOffscreenPageLimit(2);
        }
        ViewPager2 viewPager25 = this.shareContentViewPager;
        if (viewPager25 != null) {
            viewPager25.addItemDecoration(new c());
        }
        int contentShareMaxWidth = ((this.screenWidth - ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getContentShareMaxWidth()) / 2) - vq1.b.c(20);
        if (contentShareMaxWidth > 0 && (viewPager2 = this.shareContentViewPager) != null) {
            ko1.b.c(viewPager2, contentShareMaxWidth, 0, contentShareMaxWidth, 0, 10, null);
        }
        ViewPager2 viewPager26 = this.shareContentViewPager;
        if (viewPager26 != null) {
            viewPager26.registerOnPageChangeCallback(new d());
        }
        ViewPager2 viewPager27 = this.shareContentViewPager;
        if (viewPager27 != null && viewPager27.getChildCount() > 0) {
            View childAt = viewPager27.getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(childAt, "it.getChildAt(0)");
            if (childAt instanceof RecyclerView) {
                ((RecyclerView) childAt).setOverScrollMode(2);
            }
        }
        ViewPager2 viewPager28 = this.shareContentViewPager;
        if (viewPager28 != null) {
            viewPager28.setUserInputEnabled(true);
        }
        ViewPager2 viewPager29 = this.shareContentViewPager;
        if (viewPager29 != null && (context = viewPager29.getContext()) != null) {
            this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        }
    }

    private final void Vh() {
        ViewGroup.LayoutParams layoutParams;
        ViewPager2 viewPager2 = this.shareContentViewPager;
        ConstraintLayout.LayoutParams layoutParams2 = null;
        if (viewPager2 != null) {
            layoutParams = viewPager2.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        }
        if (layoutParams2 == null) {
            layoutParams2 = new ConstraintLayout.LayoutParams(-1, -1);
        }
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getContentShareMaxWidth() + ViewUtils.dip2px(25.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = -1;
        layoutParams2.startToStart = 0;
        layoutParams2.endToEnd = 0;
        ViewPager2 viewPager22 = this.shareContentViewPager;
        if (viewPager22 != null) {
            viewPager22.setLayoutParams(layoutParams2);
        }
    }

    private final void Wh() {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        ImmersiveUtils.clearCoverForStatus(activity.getWindow(), true);
        h.c(this);
        ImmersiveUtils.setStatusTextColor(true, activity.getWindow());
        if (Build.VERSION.SDK_INT >= 26) {
            View decorView = activity.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
        }
    }

    private final boolean Xh(float x16, float y16, View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        if (x16 < i3 || x16 > i3 + view.getWidth() || y16 < i16 || y16 > i16 + view.getHeight()) {
            return false;
        }
        return true;
    }

    private final void Yh() {
        com.tencent.mobileqq.guild.contentshare.d dVar = this.contentShareInfo;
        if (dVar != null) {
            dVar.g(((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getContentShareMaxWidth());
            dVar.f(((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getContentShareMaxHeight());
        }
        Th();
        ViewPager2 viewPager2 = this.shareContentViewPager;
        if (viewPager2 != null) {
            viewPager2.setAdapter(this.shareContentAdapter);
        }
    }

    private final void initData() {
        Bundle bundle;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            bundle = intent.getBundleExtra("guild_content_share_bundle_key");
        } else {
            bundle = null;
        }
        if (bundle != null) {
            this.shareData = bundle.getSerializable("guild_content_share_data_key");
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.putBoolean("force_bottom_platform_item_name_color_white", bundle.getBoolean("force_bottom_platform_item_name_color_white"));
            }
        }
        xg1.b.f447962a.i(bundle, this.shareScene, new GuildContentShareFragment$initData$2(this));
        QLog.i("GuildContentShareFragment", 1, "onAttach shareScene=" + this.shareScene);
    }

    private final void xh() {
        Iterator<Integer> it = ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getTemplates().iterator();
        while (it.hasNext()) {
            ImageCacheHelper.f98636a.m(Ch(it.next().intValue()));
        }
        ImageCacheHelper.f98636a.m("GuildContentShareFragment_BG_BITMAP");
    }

    private final void yh(View view) {
        Bitmap Eh;
        if (this.qqPermission == null) {
            this.qqPermission = QQPermissionFactory.getQQPermission(this);
        }
        QQPermission qQPermission = this.qqPermission;
        if (qQPermission != null && (Eh = Eh()) != null) {
            ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).saveToAlbum(getContext(), qQPermission, Eh, new GuildContentShareFragment$doSave$1$1$1(this, view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh(View view, boolean isSuccess, String failReason) {
        int i3;
        HashMap hashMap = new HashMap();
        AbsGuildContentShareTemplate absGuildContentShareTemplate = this.currentSelectedTemplate;
        if (absGuildContentShareTemplate != null) {
            i3 = absGuildContentShareTemplate.getCom.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant.Params.REPORT_TEMPLATE_TYPE java.lang.String();
        } else {
            i3 = 0;
        }
        hashMap.put("sgrp_rank", Integer.valueOf(i3));
        hashMap.put("sgrp_is_success", Integer.valueOf(isSuccess ? 1 : 0));
        if (!isSuccess && TextUtils.isEmpty(failReason)) {
            failReason = view.getContext().getString(R.string.f142770k_);
        }
        Intrinsics.checkNotNullExpressionValue(failReason, "if (!isSuccess && TextUt\u2026     failReason\n        }");
        hashMap.put(VRReportDefine$ReportParam.FAIL_REASON, failReason);
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }

    @Nullable
    /* renamed from: Hh, reason: from getter */
    public final Integer getShareScene() {
        return this.shareScene;
    }

    public final void Zh(@Nullable com.tencent.mobileqq.guild.contentshare.d dVar) {
        this.contentShareInfo = dVar;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 101 && resultCode == -1) {
            QQToast.makeText(getContext(), 2, R.string.hj9, 1).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Bundle bundle;
        Integer num;
        Intent intent;
        Intent intent2;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        Bitmap bitmap = null;
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            bundle = intent2.getBundleExtra("guild_content_share_bundle_key");
        } else {
            bundle = null;
        }
        this.paramBundle = bundle;
        if (bundle != null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (intent = activity2.getIntent()) != null) {
                num = Integer.valueOf(intent.getIntExtra("guild_content_share_from_key", -1));
            } else {
                num = null;
            }
            this.shareScene = num;
            Object g16 = ImageCacheHelper.f98636a.g("GuildContentShareFragment_BG_BITMAP");
            if (g16 instanceof Bitmap) {
                bitmap = (Bitmap) g16;
            }
            this.blurBitmap = bitmap;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            if (v3.getId() == R.id.wk6) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            } else if (v3.getId() == R.id.w2x) {
                yh(v3);
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.screenHeight = BaseApplication.context.getResources().getDisplayMetrics().heightPixels;
        this.screenWidth = BaseApplication.context.getResources().getDisplayMetrics().widthPixels;
        Mh();
        Yh();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ImageView imageView;
        Button button;
        ConstraintLayout constraintLayout;
        ViewPager2 viewPager2;
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f168053ek0, container, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate;
        this.contentView = constraintLayout2;
        LinearLayout linearLayout2 = null;
        if (constraintLayout2 != null) {
            imageView = (ImageView) constraintLayout2.findViewById(R.id.wk6);
        } else {
            imageView = null;
        }
        this.buttonClose = imageView;
        ConstraintLayout constraintLayout3 = this.contentView;
        if (constraintLayout3 != null) {
            button = (Button) constraintLayout3.findViewById(R.id.w2x);
        } else {
            button = null;
        }
        this.buttonSave = button;
        ConstraintLayout constraintLayout4 = this.contentView;
        if (constraintLayout4 != null) {
            constraintLayout = (ConstraintLayout) constraintLayout4.findViewById(R.id.x4r);
        } else {
            constraintLayout = null;
        }
        this.pagerContainer = constraintLayout;
        ConstraintLayout constraintLayout5 = this.contentView;
        if (constraintLayout5 != null) {
            viewPager2 = (ViewPager2) constraintLayout5.findViewById(R.id.x4q);
        } else {
            viewPager2 = null;
        }
        this.shareContentViewPager = viewPager2;
        ConstraintLayout constraintLayout6 = this.contentView;
        if (constraintLayout6 != null) {
            linearLayout = (LinearLayout) constraintLayout6.findViewById(R.id.w2w);
        } else {
            linearLayout = null;
        }
        this.bottomContainer = linearLayout;
        ConstraintLayout constraintLayout7 = this.contentView;
        if (constraintLayout7 != null) {
            linearLayout2 = (LinearLayout) constraintLayout7.findViewById(R.id.x0k);
        }
        this.sharePlatformContainer = linearLayout2;
        Mh();
        ConstraintLayout constraintLayout8 = this.contentView;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, constraintLayout8);
        return constraintLayout8;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ug1.a aVar = this.shareContentAdapter;
        if (aVar != null) {
            aVar.onDestroy();
        }
        xh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initData();
        Wh();
        Nh();
        Bundle bundle = this.paramBundle;
        if (bundle != null) {
            Kh(bundle);
        }
        Ph();
        Lh();
    }
}
