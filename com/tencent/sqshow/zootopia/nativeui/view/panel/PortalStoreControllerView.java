package com.tencent.sqshow.zootopia.nativeui.view.panel;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import b94.a;
import b94.d;
import b94.e;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.reward.api.IVasRewardAdApi;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.nativeui.impl.view.panel.PageChangeFrom;
import com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.avatar.loading.view.AvatarNativeUILoading;
import com.tencent.sqshow.zootopia.card.view.ZootopiaDoublePraiseView;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewInitData;
import com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewMode;
import com.tencent.sqshow.zootopia.nativeui.data.CameraKey;
import com.tencent.sqshow.zootopia.nativeui.data.OrientationMode;
import com.tencent.sqshow.zootopia.nativeui.data.q;
import com.tencent.sqshow.zootopia.nativeui.data.repo.PortalStorePanelAllData;
import com.tencent.sqshow.zootopia.nativeui.data.repo.p;
import com.tencent.sqshow.zootopia.nativeui.data.repo.s;
import com.tencent.sqshow.zootopia.nativeui.view.PortalStoreGroupPanelPageData;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreCreateRoleBubbleHelper;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreCreateRoleBubbleView;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreLeftOptView;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreTopOptView;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarPanelErrorView;
import com.tencent.sqshow.zootopia.nativeui.view.control.PortalStorePanelControlView;
import com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.PortalStoreAvatarRecommendController;
import com.tencent.sqshow.zootopia.nativeui.view.page.ZPlanAvatarPreDownloadManager;
import com.tencent.sqshow.zootopia.nativeui.view.title.PortalStoreTitleView;
import com.tencent.sqshow.zootopia.portal.home.ParadiseLifecycleAdapter;
import com.tencent.sqshow.zootopia.portal.shimmer.ShimmerLinearLayout;
import com.tencent.sqshow.zootopia.scene.component.PageDataType;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.widget.reddot.ZPlanRedDotManager;
import com.tencent.state.report.SquareReportConst;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.zplan.world.model.FirstFrameResult;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import m94.DressControllerInitData;
import m94.DressHistoryChangeInfo;
import mqq.util.WeakReference;
import n74.bt;
import org.json.JSONObject;
import pa4.a;
import uv4.af;
import uv4.ak;
import uv4.al;
import uv4.at;
import uv4.az;
import uv4.bk;
import uv4.w;

@Metadata(d1 = {"\u0000\u00c4\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00b8\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\b\u0012\u0004\u0012\u00020\u00070\u00062\u00020\b2\u00020\t2\u00020\n:\u0002\u00b9\u0002B-\b\u0007\u0012\u0007\u0010\u001e\u001a\u00030\u00b2\u0002\u0012\f\b\u0002\u0010\u00b4\u0002\u001a\u0005\u0018\u00010\u00b3\u0002\u0012\t\b\u0002\u0010\u00b5\u0002\u001a\u000206\u00a2\u0006\u0006\b\u00b6\u0002\u0010\u00b7\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J,\u0010\"\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\b\u0010%\u001a\u00020\u001fH\u0002J6\u0010)\u001a\u00020\u00112\b\b\u0002\u0010!\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001f2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\b\u0002\u0010(\u001a\u00020\u001fH\u0002J(\u0010/\u001a\u00020\u00112\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010-\u001a\u00020\u00132\b\b\u0002\u0010.\u001a\u00020\u001fH\u0002J\u0018\u00102\u001a\u00020\u00112\u000e\u00101\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010*H\u0002J,\u00105\u001a\u00020\u00112\u0006\u00104\u001a\u0002032\u0006\u0010&\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u001fH\u0002J\u0018\u00108\u001a\u00020\u00112\u000e\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010*H\u0002J\u001a\u0010;\u001a\u00020\u00112\u0006\u00109\u001a\u0002062\b\b\u0003\u0010:\u001a\u00020\u0013H\u0002J\b\u0010<\u001a\u00020\u0011H\u0002J\b\u0010=\u001a\u00020\u0011H\u0002J\b\u0010>\u001a\u00020\u0011H\u0002J\u0012\u0010?\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010@\u001a\u00020\u0011H\u0002J\u0010\u0010A\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010C\u001a\u00020BH\u0016J\u0010\u0010E\u001a\u00020\u00112\u0006\u0010D\u001a\u00020\u0013H\u0016J \u0010I\u001a\u00020\u00112\u0006\u00109\u001a\u0002062\u0006\u0010G\u001a\u00020F2\u0006\u0010H\u001a\u000206H\u0016J\u0010\u0010J\u001a\u00020\u00112\u0006\u00109\u001a\u000206H\u0016J\u0010\u0010L\u001a\u00020\u00112\u0006\u0010K\u001a\u000206H\u0016J\u0010\u0010O\u001a\u00020\u00112\u0006\u0010N\u001a\u00020MH\u0016J\u0006\u0010P\u001a\u00020\u0011J\u0010\u0010R\u001a\u00020\u00112\u0006\u0010Q\u001a\u00020\u001fH\u0016J\u0010\u0010T\u001a\u00020\u00112\u0006\u0010S\u001a\u00020\u001fH\u0016J\b\u0010U\u001a\u00020\u0011H\u0016J\b\u0010W\u001a\u00020VH\u0016J\u0016\u0010Y\u001a\u00020\u00112\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00130*H\u0016J\u0010\u0010\\\u001a\u00020\u00112\u0006\u0010[\u001a\u00020ZH\u0016J\u0010\u0010_\u001a\u00020\u00112\u0006\u0010^\u001a\u00020]H\u0016J\b\u0010`\u001a\u00020\u0011H\u0016J\b\u0010a\u001a\u00020\u0011H\u0016J*\u0010f\u001a\u00020\u00112\u0006\u0010b\u001a\u00020\u001f2\b\u0010c\u001a\u0004\u0018\u00010\u00132\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010dH\u0016J*\u0010g\u001a\u00020\u00112\u0006\u0010b\u001a\u00020\u001f2\b\u0010c\u001a\u0004\u0018\u00010\u00132\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010dH\u0016J*\u0010h\u001a\u00020\u00112\u0006\u0010b\u001a\u00020\u001f2\b\u0010c\u001a\u0004\u0018\u00010\u00132\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010dH\u0016J*\u0010i\u001a\u00020\u00112\u0006\u0010b\u001a\u00020\u001f2\b\u0010c\u001a\u0004\u0018\u00010\u00132\u000e\u0010e\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010dH\u0016J\b\u0010j\u001a\u00020\u001fH\u0016J\b\u0010k\u001a\u00020\u001fH\u0016J\u0018\u0010m\u001a\u00020\u00112\u0006\u0010b\u001a\u00020\u001f2\u0006\u0010l\u001a\u000206H\u0016J\u0010\u0010n\u001a\u00020\u00112\u0006\u0010b\u001a\u00020\u001fH\u0016J\b\u0010o\u001a\u000206H\u0016J \u0010r\u001a\u00020\u001f2\u0006\u0010p\u001a\u00020\u001f2\u000e\u0010q\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010dH\u0016J(\u0010s\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u001f2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0010\u0010t\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\u0007H\u0016J\u001a\u0010w\u001a\u00020\u00112\u0006\u0010u\u001a\u0002062\b\u0010v\u001a\u0004\u0018\u00010\u0013H\u0016J \u0010{\u001a\u00020\u00112\u0006\u0010x\u001a\u00020\u00132\u0006\u0010y\u001a\u00020\u00132\u0006\u0010z\u001a\u00020\u0013H\u0016J\u0010\u0010~\u001a\u00020\u00112\u0006\u0010}\u001a\u00020|H\u0016J\b\u0010\u007f\u001a\u00020\u001fH\u0016J\f\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0016J\t\u0010\u0082\u0001\u001a\u00020VH\u0016J\t\u0010\u0083\u0001\u001a\u00020\u0011H\u0016J\n\u0010\u0085\u0001\u001a\u00030\u0084\u0001H\u0016J\u0015\u0010\u0088\u0001\u001a\u00020\u00112\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0016J#\u0010\u008b\u0001\u001a\u00020\u00112\u0006\u0010:\u001a\u00020\u00132\u0007\u0010\u0089\u0001\u001a\u00020\u001f2\u0007\u0010\u008a\u0001\u001a\u00020\u001fH\u0016J\u0013\u0010\u008e\u0001\u001a\u00020\u00112\b\u0010\u008d\u0001\u001a\u00030\u008c\u0001H\u0016J\u0013\u0010\u0091\u0001\u001a\u00020\u00112\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001H\u0016J\u0013\u0010\u0092\u0001\u001a\u00020\u00112\b\u0010\u0090\u0001\u001a\u00030\u008f\u0001H\u0016J\u001b\u0010\u0095\u0001\u001a\u00020\u00112\b\u0010\u0094\u0001\u001a\u00030\u0093\u00012\u0006\u0010}\u001a\u00020|H\u0016J\n\u0010\u0097\u0001\u001a\u00030\u0096\u0001H\u0016J\u0012\u0010\u0099\u0001\u001a\u00020\u00112\u0007\u0010\u0098\u0001\u001a\u00020\u0013H\u0016J#\u0010\u009b\u0001\u001a\u00020\u00112\u0007\u0010\u009a\u0001\u001a\u00020V2\u0006\u0010:\u001a\u00020\u00132\u0007\u0010\u0089\u0001\u001a\u00020\u001fH\u0016J\u001b\u0010\u009e\u0001\u001a\u00020\u00112\u0007\u0010'\u001a\u00030\u009c\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u001fH\u0016J\n\u0010\u00a0\u0001\u001a\u00030\u009f\u0001H\u0016J\u0012\u0010\u00a2\u0001\u001a\u00020\u00112\u0007\u0010\u00a1\u0001\u001a\u000206H\u0016J\u0015\u0010\u00a3\u0001\u001a\u00020\u00112\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0016J\u0015\u0010\u00a4\u0001\u001a\u00020\u00112\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0016J\n\u0010\u00a6\u0001\u001a\u0005\u0018\u00010\u00a5\u0001J\u0014\u0010\u00a7\u0001\u001a\u00020\u00112\t\b\u0002\u0010'\u001a\u00030\u009c\u0001H\u0007J\u0014\u0010\u00a8\u0001\u001a\u00020\u00112\t\b\u0002\u0010'\u001a\u00030\u009c\u0001H\u0007J\u0011\u0010\u00a9\u0001\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u001fH\u0016J\t\u0010\u00aa\u0001\u001a\u00020\u0001H\u0016J\f\u0010\u00ac\u0001\u001a\u0005\u0018\u00010\u00ab\u0001H\u0016J\f\u0010\u00ae\u0001\u001a\u0005\u0018\u00010\u00ad\u0001H\u0016J\f\u0010\u00b0\u0001\u001a\u0005\u0018\u00010\u00af\u0001H\u0016J\f\u0010\u00b2\u0001\u001a\u0005\u0018\u00010\u00b1\u0001H\u0016J\f\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00b3\u0001H\u0016J\u000b\u0010\u00b5\u0001\u001a\u0004\u0018\u00010BH\u0016J\u000b\u0010\u00b6\u0001\u001a\u0004\u0018\u00010BH\u0016J\u000b\u0010\u00b7\u0001\u001a\u0004\u0018\u00010BH\u0016J\u000b\u0010\u00b8\u0001\u001a\u0004\u0018\u00010BH\u0016J\f\u0010\u00ba\u0001\u001a\u0005\u0018\u00010\u00b9\u0001H\u0016J\f\u0010\u00bc\u0001\u001a\u0005\u0018\u00010\u00bb\u0001H\u0016J\f\u0010\u00be\u0001\u001a\u0005\u0018\u00010\u00bd\u0001H\u0016R\u0018\u0010\u00c2\u0001\u001a\u00030\u00bf\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c0\u0001\u0010\u00c1\u0001R\u001c\u0010\u00c5\u0001\u001a\u0005\u0018\u00010\u00ab\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c3\u0001\u0010\u00c4\u0001R\u001c\u0010\u00c8\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c6\u0001\u0010\u00c7\u0001R\u001c\u0010\u00cb\u0001\u001a\u0005\u0018\u00010\u00b1\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c9\u0001\u0010\u00ca\u0001R\u001c\u0010\u00ce\u0001\u001a\u0005\u0018\u00010\u00af\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cc\u0001\u0010\u00cd\u0001R\u001c\u0010\u00d1\u0001\u001a\u0005\u0018\u00010\u00bd\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cf\u0001\u0010\u00d0\u0001R\u0018\u0010\u00d4\u0001\u001a\u00030\u00d2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u00d3\u0001R\u0018\u0010\u00d7\u0001\u001a\u00030\u00d5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b4\u0001\u0010\u00d6\u0001R\u0016\u0010\u00d9\u0001\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u00d8\u0001R\u001c\u0010\u00dd\u0001\u001a\u0005\u0018\u00010\u00da\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00db\u0001\u0010\u00dc\u0001R\u0018\u0010\u00e1\u0001\u001a\u00030\u00de\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00df\u0001\u0010\u00e0\u0001R\u0017\u0010\u00e4\u0001\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00e2\u0001\u0010\u00e3\u0001R)\u0010\u00e8\u0001\u001a\u0014\u0012\u0004\u0012\u00020+0\u00e5\u0001j\t\u0012\u0004\u0012\u00020+`\u00e6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u00e7\u0001R\u0019\u0010\u00eb\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e9\u0001\u0010\u00ea\u0001R\u001b\u0010\u00ee\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ec\u0001\u0010\u00ed\u0001R\u0018\u0010\u00f2\u0001\u001a\u00030\u00ef\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f0\u0001\u0010\u00f1\u0001R\u0018\u0010\u00f5\u0001\u001a\u00030\u0096\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f3\u0001\u0010\u00f4\u0001R)\u0010\u00fa\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00030\u00f6\u0001j\t\u0012\u0004\u0012\u00020\u0003`\u00f7\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f8\u0001\u0010\u00f9\u0001R\u001b\u0010\u00fc\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a9\u0001\u0010\u00fb\u0001R\u0018\u0010\u0080\u0002\u001a\u00030\u00fd\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00fe\u0001\u0010\u00ff\u0001R\u0018\u0010\u0084\u0002\u001a\u00030\u0081\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0082\u0002\u0010\u0083\u0002R\u0019\u0010\u0087\u0002\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0002\u0010\u0086\u0002R\u0018\u0010\u0088\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bE\u0010\u00ea\u0001R\u0018\u0010\u0089\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\\\u0010\u00ea\u0001R\u0019\u0010\u008c\u0002\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0002\u0010\u008b\u0002R7\u0010\u0090\u0002\u001a \u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020\u001b0\u008d\u0002j\u000f\u0012\u0004\u0012\u00020|\u0012\u0004\u0012\u00020\u001b`\u008e\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u008f\u0002R\u0019\u0010\u0092\u0002\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0002\u0010\u0086\u0002R\u0019\u0010\u0094\u0002\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0093\u0002\u0010\u0086\u0002R\u0019\u0010\u0096\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0002\u0010\u00ea\u0001R\u0019\u0010\u0098\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0097\u0002\u0010\u00ea\u0001R\u0019\u0010\u009a\u0002\u001a\u00020|8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00be\u0001\u0010\u0099\u0002R\u0019\u0010\u009c\u0002\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0002\u0010\u0086\u0002R-\u0010\u009e\u0002\u001a\u0016\u0012\u0005\u0012\u00030\u008c\u00010\u00f6\u0001j\n\u0012\u0005\u0012\u00030\u008c\u0001`\u00f7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0002\u0010\u00f9\u0001R+\u0010\u00a0\u0002\u001a\u0016\u0012\u0005\u0012\u00030\u008f\u00010\u00f6\u0001j\n\u0012\u0005\u0012\u00030\u008f\u0001`\u00f7\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009f\u0002\u0010\u00f9\u0001R\u0019\u0010\u00a2\u0002\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0002\u0010\u0086\u0002R\u0019\u0010\u00a4\u0002\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a3\u0002\u0010\u0086\u0002R\u001e\u0010\u00a8\u0002\u001a\t\u0012\u0004\u0012\u00020\u001b0\u00a5\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a6\u0002\u0010\u00a7\u0002R'\u0010\u00ad\u0002\u001a\u0012\u0012\r\u0012\u000b \u00aa\u0002*\u0004\u0018\u00010\t0\t0\u00a9\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ab\u0002\u0010\u00ac\u0002R\u001f\u0010\u00b1\u0002\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\bY\u0010\u00ae\u0002\u001a\u0006\b\u00af\u0002\u0010\u00b0\u0002\u00a8\u0006\u00ba\u0002"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreControllerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lb94/e;", "Lb94/b;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Lm94/k;", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/w;", "Lpa4/a;", "Lf94/a;", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/a;", "Lga4/i;", "dialogController", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "L0", "Lcom/tencent/sqshow/zootopia/nativeui/data/i;", "data", "", "f1", "", "U0", "k1", "d1", "i1", "e1", "g1", "h1", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/m;", "panelAllData", "Landroid/app/Activity;", "context", "", "skipUpdateDataCenter", "refreshCurrentDress", "X0", "P0", "L1", "l1", "clearDressHistory", "cb", "userCacheRsp", "z1", "", "Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;", "groupList", "selectedIndex", "isFromChangeGender", "B1", "Luv4/bk;", "recommendList", "C1", "Luv4/ak;", "avatarData", UinConfigManager.KEY_HB, "", "ids", Constants.BASE_IN_PLUGIN_ID, "position", "from", ICustomDataEditor.STRING_PARAM_1, "p1", "o1", "J1", "E1", "V0", "Cf", "Landroid/view/View;", "getView", "panelIndex", "T", "", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "I1", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "success", "engineInitFinish", "destroy", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "getCameraId", "selfDressId", "m0", "Lm94/f;", "historyChangeInfo", "U", "", "delayMillis", "P1", "S2", NowProxyConstants.AccountInfoKey.A2, "withAnim", "source", "Lkotlin/Function0;", "callback", "eg", "h3", "A3", "X4", "j6", "B2", "style", "he", ICustomDataEditor.NUMBER_PARAM_1, "v", "enableFinishActivity", "exitPanelCallback", "l7", "c4", "x1", "error", "message", "onResultFailure", "groupId", "categoryId", "typeId", "r9", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "hh", "E", "Lqu4/a;", "x0", "Y", "yd", "Lcom/tencent/sqshow/zootopia/scene/component/PageDataType;", "getType", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onResume", "withoutBlend", "withDelay", "Ya", "Lcom/tencent/sqshow/zootopia/scene/component/d;", "observer", "q0", "Lcom/tencent/sqshow/zootopia/nativeui/data/o;", "l", "qg", ICustomDataEditor.STRING_PARAM_2, "Luv4/al;", "savedAvatarInfo", "O7", "Lb94/d;", ICustomDataEditor.STRING_ARRAY_PARAM_7, "path", "setBackgroundPath", "cameraId", "setCameraId", "Lm94/h;", "waitingUeCallback", "r1", "Lc84/a;", "wc", "orientation", "onOrientationChanged", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lm94/g;", "R0", "Y6", "E9", "P", "T0", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStoreTitleView;", "b", "Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreLeftOptView;", "u", "Lcom/tencent/sqshow/zootopia/nativeui/view/control/PortalStorePanelControlView;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreTopOptView;", "I", "Landroid/widget/RelativeLayout;", "D", "r0", "W", "X", "O", "Lcom/tencent/sqshow/zootopia/portal/shimmer/ShimmerLinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarPanelErrorView;", "w", "Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreCreateRoleBubbleView;", "e0", "Ln74/bt;", "d", "Ln74/bt;", "mBinding", "e", "Lcom/tencent/sqshow/zootopia/nativeui/view/title/PortalStoreTitleView;", "mTopTitileView", "f", "Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreLeftOptView;", "mHistoryView", tl.h.F, "Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreTopOptView;", "mSaveView", "i", "Lcom/tencent/sqshow/zootopia/nativeui/view/control/PortalStorePanelControlView;", "mCategoryView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/nativeui/view/action/PortalStoreCreateRoleBubbleView;", "mCreateRoleBubbleView", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreViewOrientationHelper;", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreViewOrientationHelper;", "mOrientationHelper", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/o;", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/o;", "mViewStatusHelper", "Lga4/i;", "mDialogController", "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/b;", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/nativeui/view/detail/recommend/b;", "mRightOptController", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;", "G", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;", "mPanelGroupDataRepo", "H", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "mChannel", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mAvatarViewDataList", "J", "Ljava/lang/String;", "mSelectedIndex", "K", "Lcom/tencent/sqshow/zootopia/nativeui/view/PortalStoreGroupPanelPageData;", "mSelectedData", "Ld94/a;", "L", "Ld94/a;", "mAvatarViewAdapter", "M", "Lb94/d;", "mDressController", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "N", "Ljava/util/HashSet;", "mListenerPool", "Lcom/tencent/sqshow/zootopia/nativeui/data/i;", "mInitData", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreViewBackHelper;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreViewBackHelper;", "mBackHelper", "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreBrandUIHelper;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreBrandUIHelper;", "mBranchUIHelper", ExifInterface.LATITUDE_SOUTH, "Z", "mClearHistoryFlag", "mPendingCategoryId", "mPendingTypeId", "V", "Lcom/tencent/sqshow/zootopia/nativeui/data/m;", "mInitCameraId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "mPanelDataCache", "a0", "mPanelHasEnter", "b0", "mMainPanelIsShow", "c0", "mServerSelectedGroupId", "d0", "mServerSelectedCategoryId", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "mCurrentGender", "f0", "mInitDataReady", "g0", "mPageDataErrorObserverPool", "h0", "mNativeUIDataListenerPool", "i0", "mNeedManualPgIn", "j0", "mShouldTryDress", "Landroidx/lifecycle/Observer;", "k0", "Landroidx/lifecycle/Observer;", "mPanelDataObserver", "Lmqq/util/WeakReference;", "kotlin.jvm.PlatformType", "l0", "Lmqq/util/WeakReference;", "avatarChangeListener", "Lkotlin/Lazy;", "S0", "()Z", "enableLoadReddotOnSubThread", "Landroid/content/Context;", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "n0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PortalStoreControllerView extends ConstraintLayout implements b94.e, b94.b, ViewPager.OnPageChangeListener, m94.k, com.tencent.mobileqq.zootopia.api.e<w>, pa4.a, f94.a, a {

    /* renamed from: C, reason: from kotlin metadata */
    private final PortalStoreViewOrientationHelper mOrientationHelper;

    /* renamed from: D, reason: from kotlin metadata */
    private final o mViewStatusHelper;

    /* renamed from: E, reason: from kotlin metadata */
    private final ga4.i mDialogController;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.b mRightOptController;

    /* renamed from: G, reason: from kotlin metadata */
    private final p mPanelGroupDataRepo;

    /* renamed from: H, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: I, reason: from kotlin metadata */
    private final ArrayList<PortalStoreGroupPanelPageData> mAvatarViewDataList;

    /* renamed from: J, reason: from kotlin metadata */
    private String mSelectedIndex;

    /* renamed from: K, reason: from kotlin metadata */
    private PortalStoreGroupPanelPageData mSelectedData;

    /* renamed from: L, reason: from kotlin metadata */
    private final d94.a mAvatarViewAdapter;

    /* renamed from: M, reason: from kotlin metadata */
    private final b94.d mDressController;

    /* renamed from: N, reason: from kotlin metadata */
    private final HashSet<b94.b> mListenerPool;

    /* renamed from: P, reason: from kotlin metadata */
    private AvatarNativeViewInitData mInitData;

    /* renamed from: Q, reason: from kotlin metadata */
    private final PortalStoreViewBackHelper mBackHelper;

    /* renamed from: R, reason: from kotlin metadata */
    private final PortalStoreBrandUIHelper mBranchUIHelper;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean mClearHistoryFlag;

    /* renamed from: T, reason: from kotlin metadata */
    private String mPendingCategoryId;

    /* renamed from: U, reason: from kotlin metadata */
    private String mPendingTypeId;

    /* renamed from: V, reason: from kotlin metadata */
    private CameraKey mInitCameraId;

    /* renamed from: W, reason: from kotlin metadata */
    private HashMap<UEAvatarGender, PortalStorePanelAllData> mPanelDataCache;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean mPanelHasEnter;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean mMainPanelIsShow;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String mServerSelectedGroupId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final bt mBinding;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private String mServerSelectedCategoryId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private PortalStoreTitleView mTopTitileView;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private UEAvatarGender mCurrentGender;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private PortalStoreLeftOptView mHistoryView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean mInitDataReady;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private HashSet<com.tencent.sqshow.zootopia.scene.component.d> mPageDataErrorObserverPool;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private PortalStoreTopOptView mSaveView;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final HashSet<com.tencent.sqshow.zootopia.nativeui.data.o> mNativeUIDataListenerPool;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private PortalStorePanelControlView mCategoryView;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedManualPgIn;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private boolean mShouldTryDress;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final Observer<PortalStorePanelAllData> mPanelDataObserver;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<f94.a> avatarChangeListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private PortalStoreCreateRoleBubbleView mCreateRoleBubbleView;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private final Lazy enableLoadReddotOnSubThread;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f371996a;

        static {
            int[] iArr = new int[AvatarNativeViewMode.values().length];
            try {
                iArr[AvatarNativeViewMode.ONLY_MAKE_FACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f371996a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreControllerView$c", "Lb94/c;", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements b94.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AvatarNativeViewInitData f371998b;

        c(AvatarNativeViewInitData avatarNativeViewInitData) {
            this.f371998b = avatarNativeViewInitData;
        }

        @Override // b94.c
        public boolean a() {
            PortalStoreControllerView.this.mInitCameraId.d();
            com.tencent.sqshow.zootopia.nativeui.ue.e.q(PortalStoreControllerView.this.mChannel.getCameraController(), PortalStoreControllerView.this.mInitCameraId, "onBackIconClick", false, 4, null);
            PortalStoreControllerView.this.mSelectedData = null;
            b94.c backHandler = this.f371998b.getBackHandler();
            if (backHandler != null) {
                return backHandler.a();
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreControllerView$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/w;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<w> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<w> f372000e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f372001f;

        d(com.tencent.mobileqq.zootopia.api.e<w> eVar, boolean z16) {
            this.f372000e = eVar;
            this.f372001f = z16;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(w result) {
            b94.d avatarDressController;
            Intrinsics.checkNotNullParameter(result, "result");
            PortalStoreControllerView.this.onResultSuccess(result);
            this.f372000e.onResultSuccess(result);
            if (this.f372001f && (avatarDressController = PortalStoreControllerView.this.mChannel.getAvatarDressController()) != null) {
                d.a.h(avatarDressController, null, false, false, 7, null);
            }
            PortalStoreCreateRoleBubbleHelper portalStoreCreateRoleBubbleHelper = PortalStoreCreateRoleBubbleHelper.f371421a;
            af[] afVarArr = result.f440471l;
            Intrinsics.checkNotNullExpressionValue(afVarArr, "result.bubbleList");
            portalStoreCreateRoleBubbleHelper.k(afVarArr);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            PortalStoreControllerView.this.onResultFailure(error, message);
            this.f372000e.onResultFailure(error, message);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/view/panel/PortalStoreControllerView$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Luv4/w;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<w> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f372002d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PortalStoreControllerView f372003e;

        e(boolean z16, PortalStoreControllerView portalStoreControllerView) {
            this.f372002d = z16;
            this.f372003e = portalStoreControllerView;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(w result) {
            b94.d avatarDressController;
            Intrinsics.checkNotNullParameter(result, "result");
            if (this.f372002d && (avatarDressController = this.f372003e.mChannel.getAvatarDressController()) != null) {
                d.a.h(avatarDressController, null, false, false, 7, null);
            }
            QLog.i("PortalStoreControllerView", 1, "avatarCharacterChanged-onResultSuccess");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("PortalStoreControllerView", 1, "avatarCharacterChanged-onResultFailure error:" + error + ", message:" + message);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreControllerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void B1(List<PortalStoreGroupPanelPageData> groupList, String selectedIndex, boolean isFromChangeGender) {
        Object obj;
        AvatarNativeViewInitData avatarNativeViewInitData = this.mInitData;
        boolean z16 = false;
        if (avatarNativeViewInitData != null && avatarNativeViewInitData.getWithoutUi()) {
            z16 = true;
        }
        if (z16) {
            QLog.i("PortalStoreControllerView", 1, "refreshGroupData withoutUi!");
            return;
        }
        this.mAvatarViewDataList.clear();
        this.mAvatarViewDataList.addAll(groupList);
        this.mAvatarViewAdapter.k(this.mAvatarViewDataList);
        this.mAvatarViewAdapter.notifyDataSetChanged();
        PortalStorePanelControlView portalStorePanelControlView = this.mCategoryView;
        if (portalStorePanelControlView != null) {
            Intrinsics.checkNotNull(portalStorePanelControlView);
            PortalStorePanelControlView.setData$default(portalStorePanelControlView, groupList, selectedIndex, isFromChangeGender, false, 8, null);
            return;
        }
        Iterator<T> it = groupList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((PortalStoreGroupPanelPageData) obj).getIndex(), selectedIndex)) {
                    break;
                }
            }
        }
        if (obj == null) {
            selectedIndex = "";
        }
        T(selectedIndex);
    }

    private final void C1(List<bk> recommendList) {
        com.tencent.sqshow.zootopia.nativeui.data.h uiParam;
        AvatarNativeViewInitData avatarNativeViewInitData = this.mInitData;
        if (!((avatarNativeViewInitData == null || (uiParam = avatarNativeViewInitData.getUiParam()) == null || !uiParam.getShowRecommendBar()) ? false : true)) {
            QLog.i("PortalStoreControllerView", 1, "disable recommendBar");
            return;
        }
        QLog.i("PortalStoreControllerView", 1, "refreshRecommendData size=" + (recommendList != null ? Integer.valueOf(recommendList.size()) : null));
        List<bk> list = recommendList;
        if (list == null || list.isEmpty()) {
            if (this.mRightOptController == null) {
                com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
                ViewStub viewStub = this.mBinding.f418918e;
                Intrinsics.checkNotNullExpressionValue(viewStub, "mBinding.detailViewStub");
                this.mRightOptController = new com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.d(jVar, viewStub);
            }
        } else if (this.mRightOptController == null) {
            com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.mChannel;
            ViewStub viewStub2 = this.mBinding.f418929p;
            Intrinsics.checkNotNullExpressionValue(viewStub2, "mBinding.recommendViewStub");
            this.mRightOptController = new PortalStoreAvatarRecommendController(jVar2, viewStub2);
        }
        this.mChannel.B().postValue(recommendList);
    }

    private final void D1(List<Integer> ids) {
        List<Integer> list = ids;
        if (list == null || list.isEmpty()) {
            QLog.d("PortalStoreControllerView", 1, "refreshRedDotData, ids is null or empty");
            return;
        }
        ZPlanRedDotManager zPlanRedDotManager = ZPlanRedDotManager.f373437a;
        Object[] array = list.toArray(new Integer[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        ZPlanRedDotManager.u(zPlanRedDotManager, (Integer[]) array, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F1(PortalStoreControllerView this$0, boolean z16, String str, Function0 function0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mViewStatusHelper.u(z16, str, function0);
        PortalStorePanelControlView portalStorePanelControlView = this$0.mCategoryView;
        if (portalStorePanelControlView != null) {
            portalStorePanelControlView.x();
        }
        if (PortalStoreCreateRoleBubbleHelper.f371421a.f()) {
            com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.b bVar = this$0.mRightOptController;
            if (bVar != null) {
                bVar.b(false);
            }
        } else {
            com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.b bVar2 = this$0.mRightOptController;
            if (bVar2 != null) {
                bVar2.a(z16);
            }
        }
        this$0.setAlpha(1.0f);
        if (this$0.mMainPanelIsShow) {
            this$0.p1();
        }
        y94.a reporter = this$0.mChannel.getReporter();
        View mContainer = this$0.mBinding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "mBinding.root");
        reporter.i(mContainer, false);
        this$0.mNeedManualPgIn = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(PortalStoreControllerView this$0, boolean z16, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mViewStatusHelper.v(z16, i3);
    }

    private final void J1() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.j
            @Override // java.lang.Runnable
            public final void run() {
                PortalStoreControllerView.K1(PortalStoreControllerView.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(PortalStoreControllerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.traversePage(this$0.mBinding.getMContainer());
    }

    private final com.tencent.sqshow.zootopia.nativeui.data.j L0(ga4.i dialogController) {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = new com.tencent.sqshow.zootopia.nativeui.data.j(new com.tencent.qqnt.avatar.meta.refresh.c(this), this.mDialogController);
        jVar.U(this.mPanelGroupDataRepo);
        return jVar;
    }

    private final void L1() {
        if (this.mShouldTryDress) {
            this.mShouldTryDress = false;
            I1();
        }
    }

    private final void P0(PortalStorePanelAllData panelAllData) {
        this.mChannel.getReporter().o(panelAllData.getGender());
        if (ZPlanQQMC.INSTANCE.enableZPlanFriendDressBuyUinReport()) {
            try {
                String friendUin = new JSONObject(this.mChannel.getSchemeParams()).optString(SquareReportConst.Key.KEY_ZPLAN_FRIEND_UIN, "");
                y94.a reporter = this.mChannel.getReporter();
                Intrinsics.checkNotNullExpressionValue(friendUin, "friendUin");
                reporter.n(friendUin);
            } catch (Throwable th5) {
                QLog.e("PortalStoreControllerView", 1, "bindReportInfo, set friend uin fail.", th5);
            }
        }
        y94.a reporter2 = this.mChannel.getReporter();
        View mContainer = this.mBinding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "mBinding.root");
        reporter2.a(mContainer, "pg_zplan_avatar_mall");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0() {
        ZPlanRedDotManager.f373437a.x();
    }

    private final boolean S0() {
        return ((Boolean) this.enableLoadReddotOnSubThread.getValue()).booleanValue();
    }

    private final String U0() {
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.mChannel;
        jVar.h0(q.f371046a.j(jVar, this.mInitData));
        return this.mChannel.getZplanPageOpenSource();
    }

    private final void V0() {
        AvatarNativeViewInitData avatarNativeViewInitData = this.mInitData;
        if (avatarNativeViewInitData == null) {
            return;
        }
        if (b.f371996a[avatarNativeViewInitData.getNativeViewMode().ordinal()] == 1) {
            if (this.mChannel.getInMakeFace()) {
                this.mBinding.f418926m.l();
                return;
            }
            PortalStorePanelControlView portalStorePanelControlView = this.mCategoryView;
            if (portalStorePanelControlView != null) {
                portalStorePanelControlView.o(this.mChannel);
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.d
                @Override // java.lang.Runnable
                public final void run() {
                    PortalStoreControllerView.W0(PortalStoreControllerView.this);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(PortalStoreControllerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mBinding.f418926m.l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0221, code lost:
    
        if ((r9 != null ? r9.getNativeViewMode() : null) != com.tencent.sqshow.zootopia.nativeui.data.AvatarNativeViewMode.ONLY_MAKE_FACE) goto L85;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void X0(PortalStorePanelAllData panelAllData, Activity context, boolean skipUpdateDataCenter, boolean refreshCurrentDress) {
        Object obj;
        int collectionSizeOrDefault;
        Object obj2;
        String str;
        String str2;
        P0(panelAllData);
        s.f371156a.b(panelAllData.getGender(), panelAllData.getAvatarData());
        this.mPanelDataCache.put(panelAllData.getGender(), panelAllData);
        boolean z16 = true;
        this.mInitDataReady = true;
        hb(panelAllData.getAvatarData(), panelAllData.getClearDressHistory(), skipUpdateDataCenter, refreshCurrentDress);
        at commonCfg = panelAllData.getCommonCfg();
        CameraKey cameraKey = new CameraKey(commonCfg != null ? commonCfg.f440228f : 0, 0, 2, null);
        this.mInitCameraId = cameraKey;
        QLog.i("PortalStoreControllerView", 1, "handlePanelData mInitCameraId " + cameraKey + ", gender:" + panelAllData.getGender());
        if (!this.mChannel.getCameraController().j().c()) {
            this.mChannel.getCameraController().w(this.mInitCameraId, "initCameraId");
        }
        D1(panelAllData.i());
        this.mChannel.c0(panelAllData.getPanelSortData());
        Iterator<T> it = panelAllData.g().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            String str3 = ((PortalStoreGroupPanelPageData) obj).getStoreGrpupCfgV1().f440265a;
            at commonCfg2 = panelAllData.getCommonCfg();
            if (Intrinsics.areEqual(str3, commonCfg2 != null ? commonCfg2.f440229g : null)) {
                break;
            }
        }
        PortalStoreGroupPanelPageData portalStoreGroupPanelPageData = (PortalStoreGroupPanelPageData) obj;
        if (portalStoreGroupPanelPageData != null) {
            String str4 = portalStoreGroupPanelPageData.getStoreGrpupCfgV1().f440265a;
            Intrinsics.checkNotNullExpressionValue(str4, "selectedDataOfServer.storeGrpupCfgV1.id");
            this.mServerSelectedGroupId = str4;
            String str5 = portalStoreGroupPanelPageData.getStoreGrpupCfgV1().f440271g;
            Intrinsics.checkNotNullExpressionValue(str5, "selectedDataOfServer.sto\u2026rpupCfgV1.activeSectionId");
            this.mServerSelectedCategoryId = str5;
        }
        at commonCfg3 = panelAllData.getCommonCfg();
        QLog.i("PortalStoreControllerView", 1, "service active groupId " + (commonCfg3 != null ? commonCfg3.f440229g : null));
        List<PortalStoreGroupPanelPageData> g16 = panelAllData.g();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(g16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (PortalStoreGroupPanelPageData portalStoreGroupPanelPageData2 : g16) {
            arrayList.add(portalStoreGroupPanelPageData2.getStoreGrpupCfgV1().f440265a + MsgSummary.STR_COLON + portalStoreGroupPanelPageData2.getStoreGrpupCfgV1().f440267c);
        }
        QLog.i("PortalStoreControllerView", 1, "group => " + arrayList);
        Iterator<T> it5 = panelAllData.g().iterator();
        while (true) {
            if (it5.hasNext()) {
                obj2 = it5.next();
                if (Intrinsics.areEqual(((PortalStoreGroupPanelPageData) obj2).getIndex(), this.mSelectedIndex)) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        PortalStoreGroupPanelPageData portalStoreGroupPanelPageData3 = (PortalStoreGroupPanelPageData) obj2;
        if ((portalStoreGroupPanelPageData3 == null || (str = portalStoreGroupPanelPageData3.getIndex()) == null) && (portalStoreGroupPanelPageData == null || (str = portalStoreGroupPanelPageData.getIndex()) == null)) {
            str = this.mSelectedIndex;
        }
        B1(panelAllData.g(), str, this.mCurrentGender != panelAllData.getGender());
        bk[] bkVarArr = panelAllData.getAvatarData().f440151g;
        C1(bkVarArr != null ? ArraysKt___ArraysKt.toList(bkVarArr) : null);
        PortalStoreBrandUIHelper portalStoreBrandUIHelper = this.mBranchUIHelper;
        AvatarNativeViewInitData avatarNativeViewInitData = this.mInitData;
        portalStoreBrandUIHelper.d(panelAllData, avatarNativeViewInitData != null ? avatarNativeViewInitData.getBranchId() : null);
        this.mCurrentGender = panelAllData.getGender();
        E1(this.mPanelGroupDataRepo.e().getValue());
        com.tencent.sqshow.zootopia.nativeui.dialog.q qVar = new com.tencent.sqshow.zootopia.nativeui.dialog.q(context, this.mChannel);
        AvatarNativeViewInitData avatarNativeViewInitData2 = this.mInitData;
        if (avatarNativeViewInitData2 == null || (str2 = avatarNativeViewInitData2.getActionParams()) == null) {
            str2 = "";
        }
        qVar.a(str2);
        AvatarNativeViewInitData avatarNativeViewInitData3 = this.mInitData;
        if (avatarNativeViewInitData3 != null) {
            avatarNativeViewInitData3.s("");
        }
        post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.k
            @Override // java.lang.Runnable
            public final void run() {
                PortalStoreControllerView.Z0(PortalStoreControllerView.this);
            }
        });
        if (this.mPanelHasEnter) {
            J1();
        }
        az[] azVarArr = panelAllData.getAvatarData().f440150f;
        if (azVarArr != null) {
            if (!(azVarArr.length == 0)) {
                AvatarNativeViewInitData avatarNativeViewInitData4 = this.mInitData;
            }
            z16 = false;
            this.mShouldTryDress = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(PortalStoreControllerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mMainPanelIsShow) {
            this$0.p1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(PortalStoreControllerView this$0, boolean z16, String str, Function0 function0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PortalStorePanelControlView portalStorePanelControlView = this$0.mCategoryView;
        if (portalStorePanelControlView != null) {
            portalStorePanelControlView.w();
        }
        this$0.mViewStatusHelper.i(z16, str, function0);
        com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.b bVar = this$0.mRightOptController;
        if (bVar != null) {
            bVar.b(z16);
        }
        this$0.o1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(PortalStoreControllerView this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mViewStatusHelper.k(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(PortalStoreControllerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        o.j(this$0.mViewStatusHelper, false, null, null, 6, null);
        this$0.mViewStatusHelper.k(false);
        com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.b bVar = this$0.mRightOptController;
        if (bVar != null) {
            bVar.b(false);
        }
    }

    private final void d1(AvatarNativeViewInitData data) {
        if (data.getUiParam().getShowCategoryBar()) {
            PortalStorePanelControlView portalStorePanelControlView = (PortalStorePanelControlView) this.mBinding.f418916c.inflate().findViewById(R.id.piq);
            portalStorePanelControlView.q(this.mChannel);
            portalStorePanelControlView.i(this);
            this.mCategoryView = portalStorePanelControlView;
        }
    }

    private final void e1(AvatarNativeViewInitData data) {
        if (data.getUiParam().getShowCreateRoleBubble()) {
            PortalStoreCreateRoleBubbleView portalStoreCreateRoleBubbleView = (PortalStoreCreateRoleBubbleView) this.mBinding.f418917d.inflate().findViewById(R.id.f163347pn1);
            portalStoreCreateRoleBubbleView.b(this.mChannel);
            this.mCreateRoleBubbleView = portalStoreCreateRoleBubbleView;
        }
    }

    private final void f1(AvatarNativeViewInitData data) {
        String str;
        Map<String, Object> mutableMapOf;
        com.tencent.sqshow.zootopia.nativeui.data.g reportParam;
        this.mInitData = data;
        LifecycleOwner owner = data.getOwner();
        Activity context = data.getContext();
        this.mChannel.a0(data.getNativeViewMode());
        this.mChannel.d0(data.getSceneComponentAvatar());
        this.mChannel.e0(data.getSceneComponentAvatarV2());
        this.mChannel.V(data.getEngineApi());
        this.mChannel.getCameraController().t(data.getEngineApi());
        this.mChannel.Z(owner);
        this.mChannel.P(context);
        this.mChannel.f0(data.getSchemeParams());
        this.mChannel.b0(data.getInteractParam().getOrientationMode());
        this.mChannel.getReporter().q(data.getZootopiaSource());
        this.mChannel.getReporter().p(true);
        Pair[] pairArr = new Pair[2];
        AvatarNativeViewInitData avatarNativeViewInitData = this.mInitData;
        if (avatarNativeViewInitData == null || (reportParam = avatarNativeViewInitData.getReportParam()) == null || (str = reportParam.getZplanAvatarMallPageType()) == null) {
            str = "1";
        }
        pairArr[0] = TuplesKt.to("zplan_avatar_mall_page_type", str);
        pairArr[1] = TuplesKt.to("zplan_page_open_source", U0());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        this.mChannel.getReporter().m(mutableMapOf);
        this.mViewStatusHelper.s(data.getInteractParam().getOrientationMode());
        this.mDressController.c8(data.D());
        this.mBackHelper.l(data.getBackHandler(), data.getInteractParam().getRetainStyle());
        this.mPanelGroupDataRepo.e().observeForever(this.mPanelDataObserver);
        A1(this, false, true, null, data.getSkipReqDataOnInit(), 5, null);
        com.tencent.sqshow.zootopia.nativeui.data.o listener = data.getListener();
        if (listener != null) {
            qg(listener);
        }
        data.getOwner().getLifecycle().addObserver(new ParadiseLifecycleAdapter(this, data.getOwner()));
    }

    private final void g1(AvatarNativeViewInitData data) {
        if (data.getUiParam().getShowHistoryBar()) {
            PortalStoreLeftOptView portalStoreLeftOptView = (PortalStoreLeftOptView) this.mBinding.f418922i.inflate().findViewById(R.id.pzq);
            portalStoreLeftOptView.n(this.mChannel);
            this.mHistoryView = portalStoreLeftOptView;
        }
    }

    private final void h1(AvatarNativeViewInitData data) {
        if (data.getUiParam().getShowSaveBar()) {
            PortalStoreTopOptView portalStoreTopOptView = (PortalStoreTopOptView) this.mBinding.f418930q.inflate().findViewById(R.id.qj8);
            portalStoreTopOptView.s(this.mChannel);
            this.mSaveView = portalStoreTopOptView;
        }
    }

    private final void hb(ak avatarData, boolean clearDressHistory, boolean skipUpdateDataCenter, boolean refreshCurrentDress) {
        this.mDressController.hb(avatarData, clearDressHistory, skipUpdateDataCenter, refreshCurrentDress);
    }

    private final void i1(AvatarNativeViewInitData data) {
        if (data.getUiParam().getShowTitleBar()) {
            PortalStoreTitleView portalStoreTitleView = (PortalStoreTitleView) this.mBinding.f418931r.inflate().findViewById(R.id.qrx);
            float statusBarHeight = ImmersiveUtils.getStatusBarHeight(data.getContext()) + data.getContext().getResources().getDimension(R.dimen.f122771);
            ViewGroup.LayoutParams layoutParams = portalStoreTitleView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ConstraintLayout.LayoutParams(-2, -1);
            } else {
                Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams ?: LayoutPa\u2026_PARENT\n                )");
            }
            layoutParams.height = (int) statusBarHeight;
            layoutParams.width = -1;
            portalStoreTitleView.setLayoutParams(layoutParams);
            portalStoreTitleView.F0(this.mChannel, new c(data));
            portalStoreTitleView.setOnBackListener(this.mBackHelper);
            this.mTopTitileView = portalStoreTitleView;
        }
    }

    private final void k1(AvatarNativeViewInitData data) {
        if (data.getNativeViewMode() == AvatarNativeViewMode.ONLY_MAKE_FACE) {
            this.mBinding.f418926m.setHintText("\u6b63\u5728\u524d\u5f80\u634f\u8138\uff0c\u6253\u9020\u4f60\u7684\u4e2a\u6027\u5bb9\u8c8c...");
            this.mBinding.f418926m.i(this.mChannel);
            this.mBinding.f418926m.v();
        } else {
            this.mBinding.f418926m.l();
        }
        d1(data);
        i1(data);
        g1(data);
        h1(data);
        e1(data);
    }

    private final boolean l1() {
        Activity attachedActivity = this.mChannel.getAttachedActivity();
        if (attachedActivity == null) {
            return false;
        }
        try {
            return ((IUEActivityLifeCycle) QRoute.api(IUEActivityLifeCycle.class)).isTopEngineActivity(attachedActivity);
        } catch (Exception e16) {
            QLog.e("PortalStoreControllerView", 1, "isTopEngineActivity error", e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(PortalStoreControllerView this$0, PortalStorePanelAllData panelAllData) {
        Activity context;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AvatarNativeViewInitData avatarNativeViewInitData = this$0.mInitData;
        if (avatarNativeViewInitData == null || (context = avatarNativeViewInitData.getContext()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(panelAllData, "panelAllData");
        this$0.X0(panelAllData, context, panelAllData.getFromCache(), panelAllData.getRefreshCurrentDress());
    }

    private final void o1() {
        this.mAvatarViewAdapter.h();
    }

    private final void p1() {
        this.mAvatarViewAdapter.i();
    }

    private final void s1(int position, @PageChangeFrom String from) {
        Object orNull;
        String str;
        QLog.i("PortalStoreControllerView", 1, "notifyPageSelected position:" + position);
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.mAvatarViewDataList, position);
        PortalStoreGroupPanelPageData portalStoreGroupPanelPageData = (PortalStoreGroupPanelPageData) orNull;
        if (portalStoreGroupPanelPageData == null || (str = portalStoreGroupPanelPageData.getIndex()) == null) {
            str = "";
        }
        this.mSelectedIndex = str;
        PortalStorePanelControlView portalStorePanelControlView = this.mCategoryView;
        if (portalStorePanelControlView != null) {
            portalStorePanelControlView.setSelectIndex(str, from);
        }
        PortalStoreTopOptView portalStoreTopOptView = this.mSaveView;
        if (portalStoreTopOptView != null) {
            portalStoreTopOptView.setSelectedData(portalStoreGroupPanelPageData == null ? new PortalStoreGroupPanelPageData(null, null, null, 0, false, null, 63, null) : portalStoreGroupPanelPageData);
        }
        this.mSelectedData = portalStoreGroupPanelPageData;
        this.mAvatarViewAdapter.n(portalStoreGroupPanelPageData, this.mPendingCategoryId, this.mPendingTypeId);
        this.mPendingCategoryId = "";
        this.mPendingTypeId = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(PortalStoreControllerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mChannel.getCameraController().m("onFirstFrame", false, false);
        PortalStoreBrandUIHelper portalStoreBrandUIHelper = this$0.mBranchUIHelper;
        AvatarNativeViewInitData avatarNativeViewInitData = this$0.mInitData;
        portalStoreBrandUIHelper.i(avatarNativeViewInitData != null ? avatarNativeViewInitData.getBranchId() : null, this$0.mPanelHasEnter);
        this$0.V0();
        this$0.L1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w1(PortalStoreControllerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        A1(this$0, false, this$0.mClearHistoryFlag, null, false, 13, null);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.panel.a
    /* renamed from: A, reason: from getter */
    public PortalStorePanelControlView getMCategoryView() {
        return this.mCategoryView;
    }

    @Override // b94.e
    public void A2() {
        ZootopiaDoublePraiseView zootopiaDoublePraiseView = this.mBinding.f418928o;
        Intrinsics.checkNotNullExpressionValue(zootopiaDoublePraiseView, "mBinding.praiseView");
        ZootopiaDoublePraiseView.f(zootopiaDoublePraiseView, 0.0f, 0.0f, 3, null);
    }

    @Override // b94.e
    /* renamed from: B2, reason: from getter */
    public boolean getMPanelHasEnter() {
        return this.mPanelHasEnter;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.panel.a
    public ShimmerLinearLayout C() {
        return this.mBinding.f418933t.f418625b;
    }

    @Override // b94.e
    public void Cf(AvatarNativeViewInitData data) {
        String str;
        DressControllerInitData mInitData;
        ZootopiaSource source;
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("PortalStoreControllerView", 1, "init data:" + data);
        f1(data);
        k1(data);
        onOrientationChanged(getContext().getResources().getConfiguration().orientation);
        f94.c.f398021a.b(this.avatarChangeListener);
        post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.i
            @Override // java.lang.Runnable
            public final void run() {
                PortalStoreControllerView.c1(PortalStoreControllerView.this);
            }
        });
        ZPlanAvatarPreDownloadManager zPlanAvatarPreDownloadManager = ZPlanAvatarPreDownloadManager.f371947a;
        b94.d avatarDressController = this.mChannel.getAvatarDressController();
        if (avatarDressController == null || (mInitData = avatarDressController.getMInitData()) == null || (source = mInitData.getSource()) == null || (str = ah.b(source)) == null) {
            str = "";
        }
        zPlanAvatarPreDownloadManager.p(str);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.panel.a
    public RelativeLayout D() {
        return this.mBinding.f418927n;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.d
    /* renamed from: E, reason: from getter */
    public boolean getMInitDataReady() {
        return this.mInitDataReady;
    }

    public final void E9(m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        b94.d avatarDressController = this.mChannel.getAvatarDressController();
        if (avatarDressController != null) {
            avatarDressController.E9(cb5);
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.panel.a
    /* renamed from: I, reason: from getter */
    public PortalStoreTopOptView getMSaveView() {
        return this.mSaveView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
    
        r1 = kotlin.collections.ArraysKt___ArraysKt.toList(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I1() {
        ak avatarData;
        List<az> list;
        List list2;
        PortalStorePanelAllData portalStorePanelAllData = this.mPanelDataCache.get(this.mCurrentGender);
        if (portalStorePanelAllData == null || (avatarData = portalStorePanelAllData.getAvatarData()) == null || (r1 = avatarData.f440150f) == null || list == null) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        new com.tencent.sqshow.zootopia.nativeui.dialog.q(context, this.mChannel).b(list);
        az[] azVarArr = portalStorePanelAllData.getAvatarData().f440150f;
        Intrinsics.checkNotNullExpressionValue(azVarArr, "panelData.avatarData.needDressList");
        list2 = ArraysKt___ArraysKt.toList(azVarArr);
        QLog.i("PortalStoreControllerView", 1, "tryDress, list=" + r94.b.p(list2));
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.panel.a
    public View O() {
        return this.mBinding.f418925l;
    }

    @Override // b94.e
    public void O7(al savedAvatarInfo, UEAvatarGender gender) {
        Intrinsics.checkNotNullParameter(savedAvatarInfo, "savedAvatarInfo");
        Intrinsics.checkNotNullParameter(gender, "gender");
        s sVar = s.f371156a;
        ak a16 = sVar.a(gender);
        if (a16 != null) {
            a16.f440149e = gender.getIndex();
        }
        ak a17 = sVar.a(gender);
        if (a17 != null) {
            a17.f440146b = savedAvatarInfo;
        }
        PortalStorePanelAllData portalStorePanelAllData = this.mPanelDataCache.get(gender);
        if (portalStorePanelAllData == null) {
            return;
        }
        portalStorePanelAllData.getAvatarData().f440146b = savedAvatarInfo;
        portalStorePanelAllData.getAvatarData().f440149e = gender.getIndex();
        QLog.i("PortalStoreControllerView", 1, "updateSavedAvatarCharacter saveGender:" + gender);
        PortalStoreCreateRoleBubbleHelper.f371421a.d();
    }

    @Override // b94.e
    public void P1(long delayMillis) {
        this.mBinding.f418921h.h(delayMillis);
    }

    public final m94.g R0() {
        return this.mChannel.r().getValue();
    }

    @Override // b94.e
    public void S2() {
        this.mBinding.f418921h.e();
    }

    @Override // b94.b
    public void T(String panelIndex) {
        Object obj;
        Intrinsics.checkNotNullParameter(panelIndex, "panelIndex");
        Iterator<T> it = this.mAvatarViewDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((PortalStoreGroupPanelPageData) obj).getIndex(), panelIndex)) {
                    break;
                }
            }
        }
        PortalStoreGroupPanelPageData portalStoreGroupPanelPageData = (PortalStoreGroupPanelPageData) obj;
        if (portalStoreGroupPanelPageData == null) {
            return;
        }
        this.mSelectedIndex = panelIndex;
        if (!Intrinsics.areEqual(portalStoreGroupPanelPageData, this.mSelectedData)) {
            this.mChannel.i().setValue(null);
        }
        this.mSelectedData = portalStoreGroupPanelPageData;
        PortalStoreTopOptView portalStoreTopOptView = this.mSaveView;
        if (portalStoreTopOptView != null) {
            portalStoreTopOptView.setSelectedData(portalStoreGroupPanelPageData);
        }
        int indexOf = this.mAvatarViewDataList.indexOf(portalStoreGroupPanelPageData);
        if (indexOf >= 0) {
            this.mBinding.f418915b.setCurrentItem(indexOf, false);
            u1(this, indexOf, null, 2, null);
        }
        Iterator<T> it5 = this.mListenerPool.iterator();
        while (it5.hasNext()) {
            ((b94.b) it5.next()).T(panelIndex);
        }
        VideoReport.traversePage(this.mBinding.getMContainer());
    }

    @Override // m94.k
    public void U(DressHistoryChangeInfo historyChangeInfo) {
        Intrinsics.checkNotNullParameter(historyChangeInfo, "historyChangeInfo");
        this.mChannel.r().postValue(historyChangeInfo.getData());
        this.mChannel.q().postValue(historyChangeInfo);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.panel.a
    public View W() {
        return this.mBinding.f418923j;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.panel.a
    public View X() {
        return this.mBinding.f418932s;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.d
    public CameraKey Y() {
        return getCameraId();
    }

    public final void Y6(m94.h cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        b94.d avatarDressController = this.mChannel.getAvatarDressController();
        if (avatarDressController != null) {
            avatarDressController.Y6(cb5);
        }
    }

    @Override // b94.e
    public void Ya(String from, boolean withoutBlend, boolean withDelay) {
        Intrinsics.checkNotNullParameter(from, "from");
        this.mChannel.getCameraController().m(from, withoutBlend, withDelay);
    }

    @Override // b94.e
    /* renamed from: a7, reason: from getter */
    public b94.d getMDressController() {
        return this.mDressController;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.panel.a
    /* renamed from: b, reason: from getter */
    public PortalStoreTitleView getMTopTitileView() {
        return this.mTopTitileView;
    }

    @Override // b94.e
    public void destroy() {
        this.mPanelGroupDataRepo.e().removeObserver(this.mPanelDataObserver);
        PortalStoreTopOptView portalStoreTopOptView = this.mSaveView;
        if (portalStoreTopOptView != null) {
            portalStoreTopOptView.j();
        }
        PortalStoreTitleView portalStoreTitleView = this.mTopTitileView;
        if (portalStoreTitleView != null) {
            portalStoreTitleView.destroy();
        }
        PortalStorePanelControlView portalStorePanelControlView = this.mCategoryView;
        if (portalStorePanelControlView != null) {
            portalStorePanelControlView.w();
        }
        this.mAvatarViewAdapter.destroy();
        this.mDressController.destroy();
        Iterator<T> it = this.mChannel.I().iterator();
        while (it.hasNext()) {
            ((CountDownTimer) it.next()).cancel();
        }
        this.mViewStatusHelper.c();
        f94.c.f398021a.f(this.avatarChangeListener);
        com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.G();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.panel.a
    /* renamed from: e0, reason: from getter */
    public PortalStoreCreateRoleBubbleView getMCreateRoleBubbleView() {
        return this.mCreateRoleBubbleView;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void engineInitFinish(boolean success) {
        QLog.i("PortalStoreControllerView", 1, "engineInitFinish success " + success);
    }

    @Override // b94.e
    public CameraKey getCameraId() {
        CameraKey j3 = this.mChannel.getCameraController().j();
        QLog.i("PortalStoreControllerView", 1, "getCameraId id:" + j3);
        return j3;
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.c
    public PageDataType getType() {
        return PageDataType.AVATAR_MALL;
    }

    @Override // b94.e
    public void he(final boolean withAnim, final int style) {
        post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.f
            @Override // java.lang.Runnable
            public final void run() {
                PortalStoreControllerView.G1(PortalStoreControllerView.this, withAnim, style);
            }
        });
    }

    @Override // b94.e
    public void hh(UEAvatarGender gender) {
        AvatarNativeViewInitData avatarNativeViewInitData;
        Activity context;
        Intrinsics.checkNotNullParameter(gender, "gender");
        QLog.i("PortalStoreControllerView", 1, "resetPanelToTargetGender gender:" + gender);
        ak a16 = s.f371156a.a(gender);
        if (a16 != null) {
            QLog.i("PortalStoreControllerView", 1, "refreshAvatarData ");
            y1(this, a16, true, false, false, 12, null);
        }
        PortalStorePanelAllData portalStorePanelAllData = this.mPanelDataCache.get(gender);
        if (portalStorePanelAllData == null || (avatarNativeViewInitData = this.mInitData) == null || (context = avatarNativeViewInitData.getContext()) == null || gender == this.mCurrentGender) {
            return;
        }
        Y0(this, portalStorePanelAllData, context, false, false, 12, null);
    }

    @Override // b94.e
    /* renamed from: j6, reason: from getter */
    public boolean getMMainPanelIsShow() {
        return this.mMainPanelIsShow;
    }

    @Override // b94.e
    public boolean l7(boolean enableFinishActivity, Function0<Unit> exitPanelCallback) {
        Activity attachedActivity;
        if (this.mBinding.f418926m.getMNativeUiLoadingShow()) {
            QLog.i("PortalStoreControllerView", 1, "handleBackEvent event eat by NativeUiLoading!");
            if (enableFinishActivity && (attachedActivity = this.mChannel.getAttachedActivity()) != null) {
                attachedActivity.finish();
            }
            return true;
        }
        if (this.mBinding.f418921h.getMIsShowing()) {
            QLog.i("PortalStoreControllerView", 1, "handleBackEvent event eat by global loading!");
            return true;
        }
        if (this.mPanelHasEnter) {
            return PortalStoreViewBackHelper.j(this.mBackHelper, enableFinishActivity, exitPanelCallback, 0, 4, null);
        }
        return false;
    }

    @Override // m94.k
    public void m0(List<String> selfDressId) {
        Intrinsics.checkNotNullParameter(selfDressId, "selfDressId");
        QLog.e("PortalStoreControllerView", 1, "onSelfDressChange selfDressId:" + selfDressId);
        this.mChannel.l().setValue(selfDressId);
        com.tencent.sqshow.zootopia.nativeui.ue.n nVar = com.tencent.sqshow.zootopia.nativeui.ue.n.f371383a;
        if (nVar.e().getValue() == null) {
            nVar.i(selfDressId);
        }
        this.mChannel.getCameraController().l(r94.b.d(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.m().b().getAvatarCharacter()));
        az value = this.mChannel.i().getValue();
        if (value == null || selfDressId.contains(r94.b.a(value))) {
            return;
        }
        this.mChannel.i().setValue(null);
    }

    @Override // b94.e
    public void n1(final boolean withAnim) {
        post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.c
            @Override // java.lang.Runnable
            public final void run() {
                PortalStoreControllerView.b1(PortalStoreControllerView.this, withAnim);
            }
        });
    }

    @Override // pa4.a
    public void onDestroy(LifecycleOwner owner) {
        this.mBranchUIHelper.e();
        com.tencent.sqshow.zootopia.nativeui.menu.a.INSTANCE.a().d();
        PortalStoreCreateRoleBubbleHelper.f371421a.c();
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i("PortalStoreControllerView", 1, "onFirstFrame " + result);
        this.mChannel.getUeStatusController().onFirstFrame(result);
        this.mDressController.onFirstFrame(result);
        E1(this.mPanelGroupDataRepo.e().getValue());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.m
            @Override // java.lang.Runnable
            public final void run() {
                PortalStoreControllerView.v1(PortalStoreControllerView.this);
            }
        });
    }

    @Override // b94.e
    public void onOrientationChanged(int orientation) {
        AvatarNativeViewInitData avatarNativeViewInitData = this.mInitData;
        if (avatarNativeViewInitData == null || avatarNativeViewInitData.getInteractParam().getOrientationMode() != OrientationMode.PORTRAIT) {
            this.mOrientationHelper.d(orientation);
            this.mDialogController.h(orientation);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        s1(position, "PageSelected");
    }

    @Override // pa4.a
    public void onPause(LifecycleOwner lifecycleOwner) {
        a.C10993a.a(this, lifecycleOwner);
    }

    @Override // com.tencent.mobileqq.zootopia.api.e
    public void onResultFailure(int error, String message) {
        QLog.e("PortalStoreControllerView", 1, "onResultFailure error:" + error + ", message:" + message);
        Iterator<T> it = this.mNativeUIDataListenerPool.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.nativeui.data.o) it.next()).onFailed(error, message);
        }
        S2();
        if (this.mAvatarViewDataList.isEmpty()) {
            Iterator<T> it5 = this.mPageDataErrorObserverPool.iterator();
            while (it5.hasNext()) {
                ((com.tencent.sqshow.zootopia.scene.component.d) it5.next()).s(this);
            }
            this.mViewStatusHelper.n(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.e
                @Override // java.lang.Runnable
                public final void run() {
                    PortalStoreControllerView.w1(PortalStoreControllerView.this);
                }
            });
        }
    }

    @Override // pa4.a
    public void onResume(LifecycleOwner owner) {
        if (l1()) {
            PortalStorePanelControlView portalStorePanelControlView = this.mCategoryView;
            if (portalStorePanelControlView != null) {
                portalStorePanelControlView.z();
            }
            if (this.mMainPanelIsShow) {
                p1();
            }
            if (!this.mPanelHasEnter) {
                e.a.f(this, "onResume", false, true, 2, null);
            }
            PortalStoreBrandUIHelper portalStoreBrandUIHelper = this.mBranchUIHelper;
            AvatarNativeViewInitData avatarNativeViewInitData = this.mInitData;
            portalStoreBrandUIHelper.i(avatarNativeViewInitData != null ? avatarNativeViewInitData.getBranchId() : null, this.mPanelHasEnter);
        }
        QLog.d("PortalStoreControllerView", 1, " onResume => " + hashCode() + " , " + this);
    }

    @Override // pa4.a
    public void onStart(LifecycleOwner lifecycleOwner) {
        a.C10993a.b(this, lifecycleOwner);
    }

    @Override // pa4.a
    public void onStop(LifecycleOwner owner) {
        String str;
        a.C10993a.c(this, owner);
        PortalStoreBrandUIHelper portalStoreBrandUIHelper = this.mBranchUIHelper;
        AvatarNativeViewInitData avatarNativeViewInitData = this.mInitData;
        if (avatarNativeViewInitData == null || (str = avatarNativeViewInitData.getBranchId()) == null) {
            str = "";
        }
        portalStoreBrandUIHelper.f(str);
    }

    @Override // b94.e
    public void q0(com.tencent.sqshow.zootopia.scene.component.d observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mPageDataErrorObserverPool.add(observer);
    }

    @Override // b94.e
    public void qg(com.tencent.sqshow.zootopia.nativeui.data.o l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mNativeUIDataListenerPool.add(l3);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.panel.a
    public View r0() {
        return this.mBinding.f418915b;
    }

    @Override // b94.e
    public void r1(m94.h cb5, boolean waitingUeCallback) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        b94.d avatarDressController = this.mChannel.getAvatarDressController();
        if (avatarDressController != null) {
            d.a.h(avatarDressController, cb5, waitingUeCallback, false, 4, null);
        }
    }

    @Override // b94.e
    public void r9(String groupId, String categoryId, String typeId) {
        Object obj;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        Intrinsics.checkNotNullParameter(typeId, "typeId");
        QLog.i("PortalStoreControllerView", 1, "jumpToTargetPage groupId:" + groupId + ", categoryId:" + categoryId + ", typeId:" + typeId);
        Iterator<T> it = this.mAvatarViewDataList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((PortalStoreGroupPanelPageData) obj).getStoreGrpupCfgV1().f440265a, groupId)) {
                    break;
                }
            }
        }
        PortalStoreGroupPanelPageData portalStoreGroupPanelPageData = (PortalStoreGroupPanelPageData) obj;
        if (portalStoreGroupPanelPageData == null) {
            return;
        }
        int indexOf = this.mAvatarViewDataList.indexOf(portalStoreGroupPanelPageData);
        this.mPendingCategoryId = categoryId;
        this.mPendingTypeId = typeId;
        boolean areEqual = Intrinsics.areEqual(this.mSelectedData, portalStoreGroupPanelPageData);
        this.mBinding.f418915b.setCurrentItem(indexOf, false);
        if (areEqual) {
            s1(indexOf, "jump");
        }
    }

    @Override // b94.e
    public void s2(com.tencent.sqshow.zootopia.nativeui.data.o l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mNativeUIDataListenerPool.remove(l3);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.c
    public void serviceConnected(boolean connect) {
        QLog.i("PortalStoreControllerView", 1, "serviceConnected connect " + connect);
        this.mDressController.serviceConnected(connect);
        this.mChannel.getUeStatusController().serviceConnected(connect);
    }

    @Override // b94.e
    public void setBackgroundPath(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        PortalStoreBrandUIHelper.h(this.mBranchUIHelper, path, 0, false, null, 14, null);
    }

    @Override // b94.e
    public void setCameraId(CameraKey cameraId, String from, boolean withoutBlend) {
        Intrinsics.checkNotNullParameter(cameraId, "cameraId");
        Intrinsics.checkNotNullParameter(from, "from");
        this.mChannel.getCameraController().p(cameraId, from, withoutBlend);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.panel.a
    /* renamed from: u, reason: from getter */
    public PortalStoreLeftOptView getMHistoryView() {
        return this.mHistoryView;
    }

    @Override // b94.e
    public int v() {
        return this.mBinding.f418927n.getHeight();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.panel.a
    public AvatarPanelErrorView w() {
        return this.mBinding.f418920g;
    }

    @Override // b94.e
    public c84.a wc() {
        AvatarNativeUILoading avatarNativeUILoading = this.mBinding.f418926m;
        Intrinsics.checkNotNullExpressionValue(avatarNativeUILoading, "mBinding.nativeUILoading");
        return avatarNativeUILoading;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.data.d
    public qu4.a x0() {
        AvatarNativeViewInitData avatarNativeViewInitData = this.mInitData;
        boolean z16 = false;
        if (avatarNativeViewInitData != null && avatarNativeViewInitData.getSkipReqDataOnInit()) {
            z16 = true;
        }
        if (z16) {
            return com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.k();
        }
        return com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.v();
    }

    @Override // com.tencent.mobileqq.zootopia.api.e
    /* renamed from: x1, reason: merged with bridge method [inline-methods] */
    public void onResultSuccess(w result) {
        com.tencent.sqshow.zootopia.nativeui.view.detail.recommend.b bVar;
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i("PortalStoreControllerView", 1, "onResultSuccess ");
        Iterator<T> it = this.mNativeUIDataListenerPool.iterator();
        while (it.hasNext()) {
            ((com.tencent.sqshow.zootopia.nativeui.data.o) it.next()).B(result, this.mInitDataReady);
        }
        this.mViewStatusHelper.p();
        S2();
        PortalStoreCreateRoleBubbleHelper portalStoreCreateRoleBubbleHelper = PortalStoreCreateRoleBubbleHelper.f371421a;
        af[] afVarArr = result.f440471l;
        Intrinsics.checkNotNullExpressionValue(afVarArr, "result.bubbleList");
        portalStoreCreateRoleBubbleHelper.k(afVarArr);
        if (!portalStoreCreateRoleBubbleHelper.f() || (bVar = this.mRightOptController) == null) {
            return;
        }
        bVar.b(false);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PortalStoreControllerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // b94.e
    public void A3(final boolean withAnim, final String source, final Function0<Unit> callback) {
        this.mMainPanelIsShow = false;
        post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.b
            @Override // java.lang.Runnable
            public final void run() {
                PortalStoreControllerView.a1(PortalStoreControllerView.this, withAnim, source, callback);
            }
        });
    }

    @Override // f94.a
    public void P(boolean refreshCurrentDress) {
        QLog.i("PortalStoreControllerView", 1, "avatarCharacterChanged");
        c4(refreshCurrentDress, this.mClearHistoryFlag, new e(refreshCurrentDress, this));
    }

    @Override // b94.e
    public void X4(boolean withAnim, String source, Function0<Unit> callback) {
        this.mPanelHasEnter = false;
        this.mMainPanelIsShow = false;
        this.mChannel.a().clear();
        b94.d avatarDressController = this.mChannel.getAvatarDressController();
        if (avatarDressController != null) {
            d.a.i(avatarDressController, null, false, 3, null);
        }
        this.mChannel.getDialogController().f();
        this.mInitCameraId.d();
        com.tencent.sqshow.zootopia.nativeui.ue.e.q(this.mChannel.getCameraController(), this.mInitCameraId, "exitPanel", false, 4, null);
        A3(withAnim, source, callback);
        this.mChannel.i().setValue(null);
        this.mChannel.k().setValue(null);
        if (S0()) {
            t74.l.f435563a.f(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.l
                @Override // java.lang.Runnable
                public final void run() {
                    PortalStoreControllerView.Q0();
                }
            });
        } else {
            ZPlanRedDotManager.f373437a.x();
        }
        y94.a reporter = this.mChannel.getReporter();
        View mContainer = this.mBinding.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "mBinding.root");
        reporter.k(mContainer, false);
        this.mNeedManualPgIn = true;
        this.mChannel.getEngineApi().h(true);
        this.mChannel.getEngineApi().c(false);
    }

    @Override // b94.e
    public void eg(final boolean withAnim, final String source, final Function0<Unit> callback) {
        this.mMainPanelIsShow = true;
        post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.h
            @Override // java.lang.Runnable
            public final void run() {
                PortalStoreControllerView.F1(PortalStoreControllerView.this, withAnim, source, callback);
            }
        });
    }

    @Override // b94.e
    public void h3(boolean withAnim, String source, Function0<Unit> callback) {
        setVisibility(0);
        this.mPanelHasEnter = true;
        a.C0113a.d(this.mChannel.getEngineApi(), null, 1, null);
        e.a.e(this, this.mServerSelectedGroupId, this.mServerSelectedCategoryId, null, 4, null);
        eg(withAnim, source, callback);
        J1();
        this.mChannel.getEngineApi().h(true);
        this.mChannel.getEngineApi().c(true);
    }

    @Override // com.tencent.sqshow.zootopia.scene.component.c
    public void yd() {
        A1(this, false, this.mClearHistoryFlag, null, false, 13, null);
        yb4.e.g(yb4.e.f450058a, null, 0, 3, null);
    }

    public /* synthetic */ PortalStoreControllerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PortalStoreControllerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        bt f16 = bt.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mOrientationHelper = new PortalStoreViewOrientationHelper(this);
        o oVar = new o(this);
        this.mViewStatusHelper = oVar;
        FrameLayout frameLayout = f16.f418919f;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.dialogViewContainer");
        ga4.i iVar = new ga4.i(frameLayout);
        this.mDialogController = iVar;
        p pVar = new p();
        this.mPanelGroupDataRepo = pVar;
        com.tencent.sqshow.zootopia.nativeui.data.j L0 = L0(iVar);
        this.mChannel = L0;
        this.mAvatarViewDataList = new ArrayList<>();
        this.mSelectedIndex = "";
        d94.a aVar = new d94.a(context, L0);
        this.mAvatarViewAdapter = aVar;
        b94.d a16 = com.tencent.sqshow.zootopia.nativeui.ue.q.f371395a.a(pVar);
        this.mDressController = a16;
        this.mListenerPool = new HashSet<>();
        this.mBackHelper = new PortalStoreViewBackHelper(this, iVar, L0);
        this.mBranchUIHelper = new PortalStoreBrandUIHelper(this, oVar);
        this.mPendingCategoryId = "";
        this.mPendingTypeId = "";
        this.mInitCameraId = new CameraKey(0, 0, 2, null);
        this.mPanelDataCache = new HashMap<>();
        this.mServerSelectedGroupId = "";
        this.mServerSelectedCategoryId = "";
        this.mCurrentGender = UEAvatarGender.MALE;
        this.mPageDataErrorObserverPool = new HashSet<>();
        this.mNativeUIDataListenerPool = new HashSet<>();
        this.mPanelDataObserver = new Observer() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                PortalStoreControllerView.m1(PortalStoreControllerView.this, (PortalStorePanelAllData) obj);
            }
        };
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.nativeui.avatar.IRefreshPannelListener");
        this.avatarChangeListener = new WeakReference<>(this);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreControllerView$enableLoadReddotOnSubThread$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(ZPlanQQMC.INSTANCE.enableLoadReddotOnSubThread());
            }
        });
        this.enableLoadReddotOnSubThread = lazy;
        setVisibility(4);
        setClipChildren(false);
        f16.f418915b.setAdapter(aVar);
        f16.f418915b.addOnPageChangeListener(this);
        a16.v9(this);
        L0.Q(a16);
        oVar.l();
        setMotionEventSplittingEnabled(false);
        f16.f418924k.setImageDrawable(ie0.a.f().o(context, R.drawable.ih7, R.color.qui_common_bg_middle_light, 1000));
        ((IVasRewardAdApi) QRoute.api(IVasRewardAdApi.class)).ensureDeviceInfoValid();
    }

    private final void E1(PortalStorePanelAllData data) {
        boolean endsWith$default;
        at commonCfg;
        at commonCfg2;
        at commonCfg3;
        String str = null;
        String str2 = (data == null || (commonCfg3 = data.getCommonCfg()) == null) ? null : commonCfg3.f440225c;
        boolean z16 = true;
        QLog.i("PortalStoreControllerView", 1, "setFilamentBackdrop: commonCfg=" + (data != null ? data.getCommonCfg() : null) + " backgroundImgPath=" + str2);
        AvatarNativeViewInitData avatarNativeViewInitData = this.mInitData;
        if (TextUtils.isEmpty(avatarNativeViewInitData != null ? avatarNativeViewInitData.getBranchId() : null)) {
            return;
        }
        FilamentApiImpl filamentApiImpl = FilamentApiImpl.f369933a;
        if (str2 != null) {
            int i3 = 0;
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(str2, "T_Shop_Common", false, 2, null);
            if (!endsWith$default) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("path", "Game/" + str2 + ".");
                PortalStorePanelAllData value = this.mPanelGroupDataRepo.e().getValue();
                if (value != null && (commonCfg2 = value.getCommonCfg()) != null) {
                    i3 = commonCfg2.f440226d;
                }
                jSONObject.put("isDark", i3);
                PortalStorePanelAllData value2 = this.mPanelGroupDataRepo.e().getValue();
                if (value2 != null && (commonCfg = value2.getCommonCfg()) != null) {
                    z16 = commonCfg.f440227e;
                }
                jSONObject.put("hideGroups", z16);
                str = jSONObject.toString();
            }
        }
        filamentApiImpl.c("SetBackgroundPlane", str);
    }

    static /* synthetic */ void u1(PortalStoreControllerView portalStoreControllerView, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "PanelSelected";
        }
        portalStoreControllerView.s1(i3, str);
    }

    private final void z1(boolean refreshCurrentDress, boolean clearDressHistory, com.tencent.mobileqq.zootopia.api.e<w> cb5, boolean userCacheRsp) {
        String str;
        String str2;
        this.mClearHistoryFlag = clearDressHistory;
        if (this.mAvatarViewDataList.isEmpty()) {
            this.mViewStatusHelper.q();
        } else {
            e.a.h(this, 0L, 1, null);
        }
        com.tencent.mobileqq.zootopia.api.e dVar = cb5 == null ? this : new d(cb5, refreshCurrentDress);
        p pVar = this.mPanelGroupDataRepo;
        AvatarNativeViewInitData avatarNativeViewInitData = this.mInitData;
        if (avatarNativeViewInitData == null || (str = avatarNativeViewInitData.getBranchId()) == null) {
            str = "";
        }
        AvatarNativeViewInitData avatarNativeViewInitData2 = this.mInitData;
        if (avatarNativeViewInitData2 == null || (str2 = avatarNativeViewInitData2.getSchemeParams()) == null) {
            str2 = "";
        }
        AvatarNativeViewInitData avatarNativeViewInitData3 = this.mInitData;
        p.i(pVar, str, null, dVar, clearDressHistory, str2, avatarNativeViewInitData3 != null ? avatarNativeViewInitData3.getSource() : 0, this.mChannel.getEngineApi().getType(), userCacheRsp, this.mChannel, refreshCurrentDress, 2, null);
    }

    @Override // b94.e
    public void c4(boolean refreshCurrentDress, boolean clearDressHistory, com.tencent.mobileqq.zootopia.api.e<w> cb5) {
        A1(this, refreshCurrentDress, clearDressHistory, cb5, false, 8, null);
    }

    static /* synthetic */ void Y0(PortalStoreControllerView portalStoreControllerView, PortalStorePanelAllData portalStorePanelAllData, Activity activity, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        if ((i3 & 8) != 0) {
            z17 = true;
        }
        portalStoreControllerView.X0(portalStorePanelAllData, activity, z16, z17);
    }

    static /* synthetic */ void y1(PortalStoreControllerView portalStoreControllerView, ak akVar, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        if ((i3 & 8) != 0) {
            z18 = true;
        }
        portalStoreControllerView.hb(akVar, z16, z17, z18);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void A1(PortalStoreControllerView portalStoreControllerView, boolean z16, boolean z17, com.tencent.mobileqq.zootopia.api.e eVar, boolean z18, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            eVar = null;
        }
        if ((i3 & 8) != 0) {
            z18 = false;
        }
        portalStoreControllerView.z1(z16, z17, eVar, z18);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.panel.a
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this;
    }

    @Override // b94.e
    public View getView() {
        return this;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
}
