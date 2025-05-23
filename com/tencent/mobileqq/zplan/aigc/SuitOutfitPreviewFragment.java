package com.tencent.mobileqq.zplan.aigc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import be3.l;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.config.AppSetting;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Exposure;
import com.tencent.filament.zplan.avatar.LensProjection;
import com.tencent.filament.zplan.avatar.LookAt;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment;
import com.tencent.mobileqq.zplan.aigc.SuitParentFragment;
import com.tencent.mobileqq.zplan.aigc.data.LikeData;
import com.tencent.mobileqq.zplan.aigc.data.OutfitItemInfo;
import com.tencent.mobileqq.zplan.aigc.data.SuitAnimationItem;
import com.tencent.mobileqq.zplan.aigc.data.SuitOutfitPreviewBgUrlConfig;
import com.tencent.mobileqq.zplan.aigc.data.ZplanSuitOutfitPreviewConfig;
import com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper;
import com.tencent.mobileqq.zplan.aigc.p011const.ZPlanAIGCStatusCode;
import com.tencent.mobileqq.zplan.aigc.share.SuitOutfitShareDialog;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
import com.tencent.mobileqq.zplan.aigc.utils.SuitOutfitHelper;
import com.tencent.mobileqq.zplan.aigc.viewBinder.SuitOutfitPreviewViewBinder;
import com.tencent.mobileqq.zplan.aigc.vm.SuitOutfitViewModel;
import com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageUploadDownloadUtils;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.aigc.view.SuitPagView;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.RoundRectImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.zplan.common.model.UploadConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import k94.DialogCustomData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import l94.AvatarActionSheetDialogMenuItem;
import l94.e;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00ee\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00f8\u00022\u00020\u0001:\u0006\u00f9\u0002\u00fa\u0002\u00fb\u0002B\t\u00a2\u0006\u0006\b\u00f6\u0002\u0010\u00f7\u0002J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0016\u0010\u0013\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\bH\u0002J\u0014\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0018H\u0002J\b\u0010%\u001a\u00020\u0002H\u0002J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&H\u0002J\u001a\u0010,\u001a\u00020\u00022\u0006\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020\u0006H\u0002J\u0010\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0002J&\u00105\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u0010.\u001a\u00020-2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000203H\u0002J\b\u00106\u001a\u00020/H\u0002J\u0010\u00107\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0002J&\u00108\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u0010.\u001a\u00020-2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000203H\u0002J\u0018\u0010<\u001a\u00020/2\u0006\u00109\u001a\u00020\u00182\u0006\u0010;\u001a\u00020:H\u0002J\u0010\u0010?\u001a\u00020\u00022\u0006\u0010>\u001a\u00020=H\u0002J\u0010\u0010@\u001a\u00020\u00022\u0006\u0010>\u001a\u00020=H\u0002J,\u0010D\u001a\u00020\u00022\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\t2\u0006\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020\u00062\u0006\u0010>\u001a\u00020=H\u0002J\u0010\u0010F\u001a\u00020E2\u0006\u0010A\u001a\u00020\tH\u0002J\u0014\u0010H\u001a\u0004\u0018\u00010\t2\b\u0010G\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010I\u001a\u00020\u0002H\u0002J\b\u0010J\u001a\u00020\u0002H\u0002J\b\u0010K\u001a\u00020\u0018H\u0002J\u0010\u0010M\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u0006H\u0002J\u0018\u0010O\u001a\u00020\u00022\u0006\u0010N\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u0006H\u0002J\u0010\u0010Q\u001a\u00020\u00022\u0006\u0010P\u001a\u00020\tH\u0002J\b\u0010R\u001a\u00020\u0018H\u0002J\b\u0010S\u001a\u00020\u0002H\u0002J\u0010\u0010V\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010TH\u0016J\b\u0010W\u001a\u00020:H\u0014J\b\u0010X\u001a\u00020:H\u0014J\b\u0010Y\u001a\u00020\u0006H\u0014J&\u0010a\u001a\u0004\u0018\u00010`2\u0006\u0010[\u001a\u00020Z2\b\u0010]\u001a\u0004\u0018\u00010\\2\b\u0010_\u001a\u0004\u0018\u00010^H\u0016J\u001a\u0010c\u001a\u00020\u00022\u0006\u0010b\u001a\u00020`2\b\u0010_\u001a\u0004\u0018\u00010^H\u0016J\b\u0010d\u001a\u00020\u0002H\u0016J\b\u0010e\u001a\u00020\u0002H\u0016J\b\u0010f\u001a\u00020\u0002H\u0016J\b\u0010g\u001a\u00020\u0002H\u0016J$\u0010h\u001a\u00020\u00022\u0006\u00102\u001a\u0002012\u0006\u0010.\u001a\u00020-2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000203R\u0016\u0010k\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bm\u0010nR\u001b\u0010u\u001a\u00020p8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u001b\u0010z\u001a\u00020v8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bw\u0010r\u001a\u0004\bx\u0010yR\u001b\u0010}\u001a\u00020v8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b{\u0010r\u001a\u0004\b|\u0010yR\u001e\u0010\u0082\u0001\u001a\u00020~8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\b\u007f\u0010r\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001f\u0010\u0086\u0001\u001a\u00030\u0083\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\bj\u0010r\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001e\u0010\u0089\u0001\u001a\u00020v8FX\u0086\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u0087\u0001\u0010r\u001a\u0005\b\u0088\u0001\u0010yR \u0010\u008e\u0001\u001a\u00030\u008a\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u008b\u0001\u0010r\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001e\u0010\u0091\u0001\u001a\u00020v8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u008f\u0001\u0010r\u001a\u0005\b\u0090\u0001\u0010yR \u0010\u0096\u0001\u001a\u00030\u0092\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0093\u0001\u0010r\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R \u0010\u0099\u0001\u001a\u00030\u008a\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u0097\u0001\u0010r\u001a\u0006\b\u0098\u0001\u0010\u008d\u0001R\u001e\u0010\u009c\u0001\u001a\u00020v8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u009a\u0001\u0010r\u001a\u0005\b\u009b\u0001\u0010yR \u0010\u00a1\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u009e\u0001\u0010r\u001a\u0006\b\u009f\u0001\u0010\u00a0\u0001R \u0010\u00a4\u0001\u001a\u00030\u0092\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a2\u0001\u0010r\u001a\u0006\b\u00a3\u0001\u0010\u0095\u0001R \u0010\u00a7\u0001\u001a\u00030\u008a\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a5\u0001\u0010r\u001a\u0006\b\u00a6\u0001\u0010\u008d\u0001R \u0010\u00ac\u0001\u001a\u00030\u00a8\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00a9\u0001\u0010r\u001a\u0006\b\u00aa\u0001\u0010\u00ab\u0001R \u0010\u00af\u0001\u001a\u00030\u008a\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00ad\u0001\u0010r\u001a\u0006\b\u00ae\u0001\u0010\u008d\u0001R \u0010\u00b2\u0001\u001a\u00030\u008a\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00b0\u0001\u0010r\u001a\u0006\b\u00b1\u0001\u0010\u008d\u0001R \u0010\u00b5\u0001\u001a\u00030\u008a\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00b3\u0001\u0010r\u001a\u0006\b\u00b4\u0001\u0010\u008d\u0001R\u001e\u0010\u00b8\u0001\u001a\u00020v8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00b6\u0001\u0010r\u001a\u0005\b\u00b7\u0001\u0010yR \u0010\u00bb\u0001\u001a\u00030\u008a\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00b9\u0001\u0010r\u001a\u0006\b\u00ba\u0001\u0010\u008d\u0001R \u0010\u00be\u0001\u001a\u00030\u008a\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00bc\u0001\u0010r\u001a\u0006\b\u00bd\u0001\u0010\u008d\u0001R \u0010\u00c1\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00bf\u0001\u0010r\u001a\u0006\b\u00c0\u0001\u0010\u00a0\u0001R \u0010\u00c4\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00c2\u0001\u0010r\u001a\u0006\b\u00c3\u0001\u0010\u00a0\u0001R \u0010\u00c7\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00c5\u0001\u0010r\u001a\u0006\b\u00c6\u0001\u0010\u00a0\u0001R \u0010\u00ca\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00c8\u0001\u0010r\u001a\u0006\b\u00c9\u0001\u0010\u00a0\u0001R \u0010\u00cd\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00cb\u0001\u0010r\u001a\u0006\b\u00cc\u0001\u0010\u00a0\u0001R \u0010\u00d0\u0001\u001a\u00030\u009d\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00ce\u0001\u0010r\u001a\u0006\b\u00cf\u0001\u0010\u00a0\u0001R \u0010\u00d5\u0001\u001a\u00030\u00d1\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00d2\u0001\u0010r\u001a\u0006\b\u00d3\u0001\u0010\u00d4\u0001R \u0010\u00da\u0001\u001a\u00030\u00d6\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0005\b\u00d7\u0001\u0010r\u001a\u0006\b\u00d8\u0001\u0010\u00d9\u0001R\u001e\u0010\u00dd\u0001\u001a\u00020v8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b\u00db\u0001\u0010r\u001a\u0005\b\u00dc\u0001\u0010yR\u001a\u0010\u00e1\u0001\u001a\u00030\u00de\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00df\u0001\u0010\u00e0\u0001R\u001a\u0010\u00e5\u0001\u001a\u00030\u00e2\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00e3\u0001\u0010\u00e4\u0001R\u0019\u0010\u00e8\u0001\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00e6\u0001\u0010\u00e7\u0001R\u0019\u0010\u00ea\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e9\u0001\u0010\u00bc\u0001R\u0019\u0010\u00ec\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00eb\u0001\u0010\u00bc\u0001R\u0019\u0010\u00ee\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ed\u0001\u0010\u00bc\u0001R\u0019\u0010\u00f0\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ef\u0001\u0010\u00bc\u0001R\u0019\u0010\u00f2\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f1\u0001\u0010\u00bc\u0001R\u0019\u0010\u00f4\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f3\u0001\u0010\u00bc\u0001R\u0018\u0010\u00f6\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00f5\u0001\u0010jR\u0018\u0010\u00f8\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00f7\u0001\u0010jR\u001b\u0010\u00fb\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00f9\u0001\u0010\u00fa\u0001R\u0018\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fc\u0001\u0010\u00fd\u0001R\u0019\u0010\u00ff\u0001\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00fe\u0001\u0010\u0087\u0001R\u001a\u0010\u0083\u0002\u001a\u00030\u0080\u00028\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0081\u0002\u0010\u0082\u0002R\u0018\u0010\u0087\u0002\u001a\u00030\u0084\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0085\u0002\u0010\u0086\u0002R\u0017\u0010\u0089\u0002\u001a\u00020\u00188\u0002X\u0082D\u00a2\u0006\b\n\u0006\b\u0088\u0002\u0010\u00fa\u0001R\u0017\u0010\u008b\u0002\u001a\u00020\u00188\u0002X\u0082D\u00a2\u0006\b\n\u0006\b\u008a\u0002\u0010\u00fa\u0001R\u0019\u0010\u008d\u0002\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0002\u0010\u00fa\u0001R'\u0010\u0092\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0005\u0012\u00030\u008f\u00020\u008e\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0002\u0010\u0091\u0002R\u0019\u0010\u0094\u0002\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0093\u0002\u0010\u0087\u0001R\u001c\u0010\u0098\u0002\u001a\u0005\u0018\u00010\u0095\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0002\u0010\u0097\u0002R,\u0010\u00a0\u0002\u001a\u0005\u0018\u00010\u0099\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009a\u0002\u0010\u009b\u0002\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002\"\u0006\b\u009e\u0002\u0010\u009f\u0002R\u001b\u0010\u00a2\u0002\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0002\u0010\u00e7\u0001R+\u0010\u00a9\u0002\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a3\u0002\u0010\u00a4\u0002\u001a\u0006\b\u00a5\u0002\u0010\u00a6\u0002\"\u0006\b\u00a7\u0002\u0010\u00a8\u0002R\u001b\u0010\u00ac\u0002\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00aa\u0002\u0010\u00ab\u0002R\u001b\u0010\u00af\u0002\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ad\u0002\u0010\u00ae\u0002R\u001c\u0010\u00b3\u0002\u001a\u0005\u0018\u00010\u00b0\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b1\u0002\u0010\u00b2\u0002R\u001a\u0010\u00b7\u0002\u001a\u00030\u00b4\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b5\u0002\u0010\u00b6\u0002R\u001c\u0010\u00b9\u0002\u001a\u0005\u0018\u00010\u00b0\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b8\u0002\u0010\u00b2\u0002R\u0019\u0010\u00bb\u0002\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ba\u0002\u0010\u00fa\u0001R\u001b\u0010\u00be\u0002\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bc\u0002\u0010\u00bd\u0002R\u001b\u0010\u00c0\u0002\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bf\u0002\u0010\u00fa\u0001R\u0019\u0010\u00c2\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c1\u0002\u0010\u00bc\u0001R\u0019\u0010\u00c4\u0002\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c3\u0002\u0010\u00fa\u0001R\u001f\u0010\u00c7\u0002\u001a\b\u0012\u0004\u0012\u00020\u00060T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c5\u0002\u0010\u00c6\u0002R\u001f\u0010\u00c9\u0002\u001a\b\u0012\u0004\u0012\u00020\u00060T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c8\u0002\u0010\u00c6\u0002R\u0019\u0010\u00cb\u0002\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ca\u0002\u0010\u00fa\u0001R\u0019\u0010\u00cd\u0002\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cc\u0002\u0010\u00fa\u0001R\u001b\u0010\u00d0\u0002\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ce\u0002\u0010\u00cf\u0002R\u0018\u0010\u00d2\u0002\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00d1\u0002\u0010jR\u0018\u0010\u00d4\u0002\u001a\u00020:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00d3\u0002\u0010jR\u0019\u0010\u00d6\u0002\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d5\u0002\u0010\u00bc\u0001R+\u0010\u00dc\u0002\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d7\u0002\u0010\u00ae\u0002\u001a\u0006\b\u00d8\u0002\u0010\u00d9\u0002\"\u0006\b\u00da\u0002\u0010\u00db\u0002R+\u0010\u00e0\u0002\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00dd\u0002\u0010\u00ae\u0002\u001a\u0006\b\u00de\u0002\u0010\u00d9\u0002\"\u0006\b\u00df\u0002\u0010\u00db\u0002R\u001a\u0010\u00e4\u0002\u001a\u00030\u00e1\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00e2\u0002\u0010\u00e3\u0002R\u001e\u0010\u00e8\u0002\u001a\t\u0012\u0004\u0012\u00020\u00060\u00e5\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00e6\u0002\u0010\u00e7\u0002R$\u0010\u00ec\u0002\u001a\u000f\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00020\u00e9\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ea\u0002\u0010\u00eb\u0002R\u001d\u0010\u00ef\u0002\u001a\b\u0012\u0004\u0012\u00020\u0002038\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ed\u0002\u0010\u00ee\u0002R*\u0010\u00f3\u0002\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00020\u00f0\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f1\u0002\u0010\u00f2\u0002R*\u0010\u00f5\u0002\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00020\u00f0\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00f4\u0002\u0010\u00f2\u0002\u00a8\u0006\u00fc\u0002"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "fk", "gk", "hk", "", "qj", "", "Landroid/graphics/Bitmap;", "Sj", com.tencent.av.ui.ak.f75340i, "Zj", "bk", "Landroid/graphics/drawable/Drawable;", "originalDrawable", "Aj", "Luv4/az;", "storeItems", "cl", "Lqu4/a;", "defaultCharacter", "Uk", "Zk", "", "background", "el", "Wk", "Tk", "Yk", "initView", "rj", "sj", "initViewModel", "jj", "toastWords", "Pk", "Jk", "", "dressedCount", "dl", "Lcom/tencent/mobileqq/zplan/aigc/data/j;", "likeData", "lockNum", "al", "Landroid/content/Context;", "context", "Ll94/c;", "nj", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "avatarPanelChannel", "Lkotlin/Function0;", "backHandler", "mj", "lj", "oj", "Mk", "reason", "", "menuId", "pj", "Lcom/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$b;", "callback", "zk", "Bk", MimeHelper.IMAGE_SUBTYPE_BITMAP, "fName", "isThumbnail", "Fk", "", "kj", "image", "tj", "Xk", "Dk", "uj", "hideFilament", "ek", "isScreenshot", "Qk", "avatarBitmap", "Nk", "getNickName", "Sk", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getContentLayoutId", "getStatusBarColor", "enableRootViewSetFitsSystemWindows", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lk", BdhLogUtil.LogTag.Tag_Conn, "I", "from", "Lfi3/bz;", "D", "Lfi3/bz;", "binding", "Lcom/tencent/mobileqq/zplan/aigc/viewBinder/SuitOutfitPreviewViewBinder;", "E", "Lkotlin/Lazy;", "Bj", "()Lcom/tencent/mobileqq/zplan/aigc/viewBinder/SuitOutfitPreviewViewBinder;", "binder", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "yj", "()Landroid/widget/ImageView;", "backgroundImage", "G", "zj", "backgroundMask", "Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "H", "Fj", "()Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "lightEffectPAG", "Landroidx/constraintlayout/widget/ConstraintLayout;", "ck", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "topArea", "J", "xj", "back", "Landroid/widget/LinearLayout;", "K", "Nj", "()Landroid/widget/LinearLayout;", "moreOutfitBtn", "L", "Mj", "moreInfo", "Landroid/widget/FrameLayout;", "M", "Dj", "()Landroid/widget/FrameLayout;", "filamentContainer", "N", "Vj", "publishOutfitBtn", "P", "Wj", "publishOutfitMask", "Landroid/widget/TextView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Uj", "()Landroid/widget/TextView;", "publishBtnText", BdhLogUtil.LogTag.Tag_Req, "Cj", "changeBackground", ExifInterface.LATITUDE_SOUTH, "Lj", "masterShareBtn", "Landroid/widget/RelativeLayout;", "T", "Ej", "()Landroid/widget/RelativeLayout;", "guestStateGroup", "U", "Oj", "outfitDescription", "V", "Kj", "masterOutfitDescription", "W", "Gj", "likeButton", "X", "Hj", "likeIcon", "Y", "Yj", "shareButton", "Z", "dk", "tryOnOutfitBtn", "a0", "Ij", "likeNumber", "b0", "vj", MessageForQQStory.KEY_AUTHOR_NAME, "c0", "Tj", "outfitTryNum", "d0", "Pj", "outfitDot", "e0", "Qj", "outfitItemNum", "f0", "Rj", "outfitItemNumMaster", "Landroidx/recyclerview/widget/RecyclerView;", "g0", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/widget/RoundRectImageView;", "h0", "wj", "()Lcom/tencent/widget/RoundRectImageView;", "avatarImg", "i0", "Xj", "screenshotImageView", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitOutfitViewModel;", "j0", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitOutfitViewModel;", "vm", "Lwk0/a;", "k0", "Lwk0/a;", "nativeApp", "l0", "Landroid/view/View;", "textureView", "m0", "isFirstFrame", "n0", "isResourceReady", "o0", "isMasterMode", "p0", "filamentInitialized", "q0", "isFirstEnter", "r0", "isLightReady", "s0", "backgroundIndexRangePosition", "t0", "currentImageIndex", "u0", "Ljava/lang/String;", "currentFeedId", "v0", "Lcom/tencent/mobileqq/zplan/aigc/data/j;", "w0", "localeDressCount", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "x0", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "mLayoutManager", "Lzd3/a;", "y0", "Lzd3/a;", "dtReporter", "z0", "guestPageId", "A0", "masterPageId", "B0", "pageId", "", "", "C0", "Ljava/util/Map;", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "D0", "lastClickTime", "Lcom/tencent/mobileqq/zplan/aigc/share/SuitOutfitShareDialog;", "E0", "Lcom/tencent/mobileqq/zplan/aigc/share/SuitOutfitShareDialog;", "suitShareDialog", "Lga4/i;", "F0", "Lga4/i;", "getPanelDialogController", "()Lga4/i;", "Kk", "(Lga4/i;)V", "panelDialogController", "G0", "outfitView", "H0", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Jj", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "Hk", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", "mChannel", "I0", "Lqu4/a;", "currentCharacter", "J0", "Landroid/graphics/Bitmap;", "outfitAvatarImage", "Ljava/io/File;", "K0", "Ljava/io/File;", "outfitAvatarImageFile", "Ljava/util/concurrent/atomic/AtomicBoolean;", "L0", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isPublishing", "M0", "outfitThumbnailImageFile", "N0", "nickName", "O0", "Ljava/lang/Long;", "createTs", "P0", PhotoCategorySummaryInfo.AVATAR_URL, "Q0", "isDressed", "R0", "firstFramePNGPath", "S0", "Ljava/util/List;", "uploadImageStatus", "T0", "urlDrawableLoadStatus", "U0", "avatarCosUrl", "V0", "thumbnailCosUrl", "W0", "Landroid/graphics/drawable/Drawable;", "lastBackgroundDrawable", "X0", "originFilamentViewWidth", "Y0", "originFilamentViewHeight", "Z0", "isFeedMyOwn", ICustomDataEditor.STRING_ARRAY_PARAM_1, "getMaskBitmapForShare", "()Landroid/graphics/Bitmap;", "Ik", "(Landroid/graphics/Bitmap;)V", "maskBitmapForShare", "b1", "getAvatarBitmapForShare", "Gk", "avatarBitmapForShare", "Lcom/tencent/mobileqq/zplan/aigc/helper/b;", "c1", "Lcom/tencent/mobileqq/zplan/aigc/helper/b;", "avatarDressDataManager", "Landroidx/lifecycle/MutableLiveData;", "d1", "Landroidx/lifecycle/MutableLiveData;", "fetchAvatarSuccessEvent", "Lkotlin/Function1;", "e1", "Lkotlin/jvm/functions/Function1;", "onMakeSameStyleClick", "f1", "Lkotlin/jvm/functions/Function0;", "onTryOnBtnClick", "Lkotlin/Function2;", "g1", "Lkotlin/jvm/functions/Function2;", "avatarImageUploadCallBack", "h1", "thumbnailImageUploadCallback", "<init>", "()V", "i1", "a", "b", "SuitOutFitPreviewFromValue", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitOutfitPreviewFragment extends ImmersivePartFragment {

    /* renamed from: j1, reason: collision with root package name */
    private static final CameraParams f329931j1;

    /* renamed from: k1, reason: collision with root package name */
    private static final Map<Integer, String> f329932k1;

    /* renamed from: A0, reason: from kotlin metadata */
    private final String masterPageId;

    /* renamed from: B0, reason: from kotlin metadata */
    private String pageId;

    /* renamed from: C, reason: from kotlin metadata */
    private int from = SuitOutFitPreviewFromValue.FEED_PAGE.getValue();

    /* renamed from: C0, reason: from kotlin metadata */
    private Map<String, Object> pageParams;

    /* renamed from: D, reason: from kotlin metadata */
    private fi3.bz binding;

    /* renamed from: D0, reason: from kotlin metadata */
    private long lastClickTime;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy binder;

    /* renamed from: E0, reason: from kotlin metadata */
    private SuitOutfitShareDialog suitShareDialog;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy backgroundImage;

    /* renamed from: F0, reason: from kotlin metadata */
    private ga4.i panelDialogController;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy backgroundMask;

    /* renamed from: G0, reason: from kotlin metadata */
    private View outfitView;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy lightEffectPAG;

    /* renamed from: H0, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j mChannel;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy topArea;

    /* renamed from: I0, reason: from kotlin metadata */
    private qu4.a currentCharacter;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy back;

    /* renamed from: J0, reason: from kotlin metadata */
    private Bitmap outfitAvatarImage;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy moreOutfitBtn;

    /* renamed from: K0, reason: from kotlin metadata */
    private File outfitAvatarImageFile;

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy moreInfo;

    /* renamed from: L0, reason: from kotlin metadata */
    private AtomicBoolean isPublishing;

    /* renamed from: M, reason: from kotlin metadata */
    private final Lazy filamentContainer;

    /* renamed from: M0, reason: from kotlin metadata */
    private File outfitThumbnailImageFile;

    /* renamed from: N, reason: from kotlin metadata */
    private final Lazy publishOutfitBtn;

    /* renamed from: N0, reason: from kotlin metadata */
    private String nickName;

    /* renamed from: O0, reason: from kotlin metadata */
    private Long createTs;

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy publishOutfitMask;

    /* renamed from: P0, reason: from kotlin metadata */
    private String avatarUrl;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy publishBtnText;

    /* renamed from: Q0, reason: from kotlin metadata */
    private boolean isDressed;

    /* renamed from: R, reason: from kotlin metadata */
    private final Lazy changeBackground;

    /* renamed from: R0, reason: from kotlin metadata */
    private String firstFramePNGPath;

    /* renamed from: S, reason: from kotlin metadata */
    private final Lazy masterShareBtn;

    /* renamed from: S0, reason: from kotlin metadata */
    private List<Boolean> uploadImageStatus;

    /* renamed from: T, reason: from kotlin metadata */
    private final Lazy guestStateGroup;

    /* renamed from: T0, reason: from kotlin metadata */
    private List<Boolean> urlDrawableLoadStatus;

    /* renamed from: U, reason: from kotlin metadata */
    private final Lazy outfitDescription;

    /* renamed from: U0, reason: from kotlin metadata */
    private String avatarCosUrl;

    /* renamed from: V, reason: from kotlin metadata */
    private final Lazy masterOutfitDescription;

    /* renamed from: V0, reason: from kotlin metadata */
    private String thumbnailCosUrl;

    /* renamed from: W, reason: from kotlin metadata */
    private final Lazy likeButton;

    /* renamed from: W0, reason: from kotlin metadata */
    private Drawable lastBackgroundDrawable;

    /* renamed from: X, reason: from kotlin metadata */
    private final Lazy likeIcon;

    /* renamed from: X0, reason: from kotlin metadata */
    private int originFilamentViewWidth;

    /* renamed from: Y, reason: from kotlin metadata */
    private final Lazy shareButton;

    /* renamed from: Y0, reason: from kotlin metadata */
    private int originFilamentViewHeight;

    /* renamed from: Z, reason: from kotlin metadata */
    private final Lazy tryOnOutfitBtn;

    /* renamed from: Z0, reason: from kotlin metadata */
    private boolean isFeedMyOwn;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final Lazy likeNumber;

    /* renamed from: a1, reason: collision with root package name and from kotlin metadata */
    private Bitmap maskBitmapForShare;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final Lazy authorName;

    /* renamed from: b1, reason: collision with root package name and from kotlin metadata */
    private Bitmap avatarBitmapForShare;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final Lazy outfitTryNum;

    /* renamed from: c1, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.zplan.aigc.helper.b avatarDressDataManager;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final Lazy outfitDot;

    /* renamed from: d1, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> fetchAvatarSuccessEvent;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final Lazy outfitItemNum;

    /* renamed from: e1, reason: collision with root package name and from kotlin metadata */
    private final Function1<Long, Unit> onMakeSameStyleClick;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final Lazy outfitItemNumMaster;

    /* renamed from: f1, reason: collision with root package name and from kotlin metadata */
    private final Function0<Unit> onTryOnBtnClick;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final Lazy recyclerView;

    /* renamed from: g1, reason: collision with root package name and from kotlin metadata */
    private final Function2<Boolean, String, Unit> avatarImageUploadCallBack;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final Lazy avatarImg;

    /* renamed from: h1, reason: collision with root package name and from kotlin metadata */
    private final Function2<Boolean, String, Unit> thumbnailImageUploadCallback;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final Lazy screenshotImageView;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private SuitOutfitViewModel vm;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private wk0.a nativeApp;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private View textureView;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstFrame;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private boolean isResourceReady;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private boolean isMasterMode;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private boolean filamentInitialized;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstEnter;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private boolean isLightReady;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private int backgroundIndexRangePosition;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private int currentImageIndex;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private String currentFeedId;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private LikeData likeData;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private long localeDressCount;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private StaggeredGridLayoutManager mLayoutManager;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private final zd3.a dtReporter;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private final String guestPageId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$SuitOutFitPreviewFromValue;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "PUBLISH", "FEED_PAGE", "QZONE", "SCHEME", "LITTLE_WORLD", "DEFAULT", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum SuitOutFitPreviewFromValue {
        PUBLISH(1),
        FEED_PAGE(2),
        QZONE(3),
        SCHEME(4),
        LITTLE_WORLD(5),
        DEFAULT(99);

        private final int value;

        SuitOutFitPreviewFromValue(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$b;", "", "Ljava/io/File;", "imageFile", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void a(File imageFile);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$c", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements l94.e {
        c() {
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$d", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements l94.e {
        d() {
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            String str;
            Intrinsics.checkNotNullParameter(view, "view");
            if (SuitOutfitPreviewFragment.f329932k1.containsKey(Integer.valueOf(menuId))) {
                if (SuitOutfitPreviewFragment.f329932k1.get(Integer.valueOf(menuId)) != null) {
                    str = String.valueOf(SuitOutfitPreviewFragment.f329932k1.get(Integer.valueOf(menuId)));
                } else {
                    str = "";
                }
                SuitOutfitViewModel suitOutfitViewModel = SuitOutfitPreviewFragment.this.vm;
                if (suitOutfitViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    suitOutfitViewModel = null;
                }
                suitOutfitViewModel.y2(String.valueOf(SuitOutfitPreviewFragment.this.currentFeedId), str);
                SuitOutfitPreviewFragment.this.Pk("\u4e3e\u62a5\u6210\u529f\uff0c\u611f\u8c22\u4f60\u7684\u53cd\u9988");
            }
        }

        @Override // l94.e
        public void b(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$e", "Lcom/tencent/mobileqq/zplan/aigc/share/d;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onSuccess", "", "error", "onFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements com.tencent.mobileqq.zplan.aigc.share.d {
        e() {
        }

        @Override // com.tencent.mobileqq.zplan.aigc.share.d
        public void onFailure(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            QLog.e("SuitOutfitPreviewFragment", 1, "download avatar bitmap failed");
            SuitOutfitPreviewFragment.this.Pk("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        }

        @Override // com.tencent.mobileqq.zplan.aigc.share.d
        public void onSuccess(Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            QLog.i("SuitOutfitPreviewFragment", 1, "download avatar bitmap success");
            SuitOutfitPreviewFragment.this.Gk(bitmap);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$f", "Lcom/tencent/mobileqq/zplan/aigc/share/d;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onSuccess", "", "error", "onFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements com.tencent.mobileqq.zplan.aigc.share.d {
        f() {
        }

        @Override // com.tencent.mobileqq.zplan.aigc.share.d
        public void onFailure(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            QLog.e("SuitOutfitPreviewFragment", 1, "download mask bitmap failed");
            SuitOutfitPreviewFragment.this.Pk("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        }

        @Override // com.tencent.mobileqq.zplan.aigc.share.d
        public void onSuccess(Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            QLog.i("SuitOutfitPreviewFragment", 1, "download mask bitmap success");
            SuitOutfitPreviewFragment.this.Ik(bitmap);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$g", "Luk0/e;", "", "type", "eventData", "", "onEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements uk0.e {
        g() {
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            QLog.i("SuitOutfitPreviewFragment", 1, " switchCamera: " + eventData);
            SuitOutfitViewModel suitOutfitViewModel = SuitOutfitPreviewFragment.this.vm;
            if (suitOutfitViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel = null;
            }
            AigcPreviewBusinessScene scene = suitOutfitViewModel.getScene();
            if (scene != null) {
                scene.switchCamera("{\"exposure\":{\"aperture\":16,\"sensitivity\":100.0,\"shutterSpeed\":0.008},\"lensProjection\":{\"aspect\":0.45,\"far\":1000.0,\"focalLength\":120,\"near\":0.05},\"lookAt\":{\"eye\":[0.0,1.0,14.13359],\"target\":[0.0,0.39022,0.0],\"upward\":[0.0,1.0,0.0]}}");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$h", "Luk0/e;", "", "type", "eventData", "", "onEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class h implements uk0.e {
        h() {
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            QLog.i("SuitOutfitPreviewFragment", 1, "FIRST_FRAME_IMAGE_READY image path: " + eventData);
            SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
            JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(eventData);
            String optString = b16 != null ? b16.optString("imagePath") : null;
            if (optString == null) {
                return;
            }
            suitOutfitPreviewFragment.firstFramePNGPath = optString;
            String str = SuitOutfitPreviewFragment.this.firstFramePNGPath;
            if (str == null || str.length() == 0) {
                QLog.e("SuitOutfitPreviewFragment", 1, "pngPath empty");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$i", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class i implements com.tencent.mobileqq.zootopia.api.e<Integer> {
        i() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("SuitOutfitPreviewFragment", 1, "requestAvatarDressData failed: " + message);
            if (SuitOutfitPreviewFragment.this.getContext() != null) {
                SuitOutfitPreviewFragment.this.fetchAvatarSuccessEvent.postValue(Boolean.FALSE);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Integer num) {
            a(num.intValue());
        }

        public void a(int result) {
            QLog.i("SuitOutfitPreviewFragment", 1, "requestAvatarDressData success");
            if (SuitOutfitPreviewFragment.this.getContext() != null) {
                SuitOutfitPreviewFragment.this.fetchAvatarSuccessEvent.postValue(Boolean.TRUE);
            }
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$j", "Lgl0/b;", "", "isSuccess", "downloadSo", "", "errCode", "", "errMsg", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class j implements gl0.b {
        j() {
        }

        @Override // gl0.b
        public void a(boolean isSuccess, boolean downloadSo, int errCode, String errMsg) {
            QLog.i("SuitOutfitPreviewFragment", 1, "onComplete after checkSoAndInitLightSdk " + isSuccess + ", " + downloadSo);
            SuitOutfitPreviewFragment.this.isLightReady = true;
            if (SuitOutfitPreviewFragment.this.getView() != null) {
                SuitOutfitPreviewFragment.this.Fj().x();
                SuitOutfitPreviewFragment.this.Xk();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$k", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class k implements l94.e {
        k() {
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("zplan_clck_type", "cancel");
            linkedHashMap.put("dt_pgid", SuitOutfitPreviewFragment.this.pageId);
            SuitOutfitPreviewFragment.this.dtReporter.t(view, "em_zplan_report_float_layer", linkedHashMap);
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$l", "Ll94/e;", "", "menuType", "menuId", "Landroid/view/View;", "view", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class l implements l94.e {
        l() {
        }

        @Override // l94.e
        public void a(int menuType, int menuId, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // l94.e
        public void b(View view) {
            e.a.a(this, view);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$m", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class m implements URLDrawable.URLDrawableListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLDrawable f329985e;

        m(URLDrawable uRLDrawable) {
            this.f329985e = uRLDrawable;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable urlDrawable, Throwable throwable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            SuitOutfitPreviewFragment.this.Pk("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable urlDrawable, int i3) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            SuitOutfitPreviewFragment.this.lastBackgroundDrawable = this.f329985e;
        }
    }

    static {
        Map<Integer, String> mapOf;
        CameraParams cameraParams = new CameraParams(null, null, null, null, null, 31, null);
        Exposure exposure = new Exposure(0, 0.0d, 0.0d, 7, null);
        exposure.setAperture(16);
        exposure.setSensitivity(100.0d);
        exposure.setShutterSpeed(0.008d);
        cameraParams.setExposure(exposure);
        LookAt lookAt = new LookAt(null, null, null, 7, null);
        lookAt.setEye(new float[]{0.0f, 1.0f, 14.13359f});
        lookAt.setTarget(new float[]{0.0f, 0.39022f, 0.0f});
        lookAt.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        cameraParams.setLookAt(lookAt);
        LensProjection lensProjection = new LensProjection(0.0f, 0.0f, 0, 0.0f, 15, null);
        lensProjection.setAspect(0.45f);
        lensProjection.setFar(1000.0f);
        lensProjection.setFocalLength(120);
        lensProjection.setNear(0.05f);
        cameraParams.setLensProjection(lensProjection);
        f329931j1 = cameraParams;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(2, "\u8272\u60c5\u4f4e\u4fd7"), TuplesKt.to(3, "\u6284\u88ad/\u4fb5\u6743\u6295\u8bc9"), TuplesKt.to(4, "\u5185\u5bb9\u5f15\u4eba\u4e0d\u9002"), TuplesKt.to(5, "\u5176\u4ed6"));
        f329932k1 = mapOf;
    }

    public SuitOutfitPreviewFragment() {
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
        Lazy lazy16;
        Lazy lazy17;
        Lazy lazy18;
        Lazy lazy19;
        Lazy lazy20;
        Lazy lazy21;
        Lazy lazy22;
        Lazy lazy23;
        Lazy lazy24;
        Lazy lazy25;
        Lazy lazy26;
        Lazy lazy27;
        Lazy lazy28;
        Lazy lazy29;
        Lazy lazy30;
        List<Boolean> mutableListOf;
        List<Boolean> mutableListOf2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SuitOutfitPreviewViewBinder>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$binder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitOutfitPreviewViewBinder invoke() {
                return new SuitOutfitPreviewViewBinder();
            }
        });
        this.binder = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$backgroundImage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qbq);
            }
        });
        this.backgroundImage = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$backgroundMask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qbr);
            }
        });
        this.backgroundMask = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<SuitPagView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$lightEffectPAG$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitPagView invoke() {
                return (SuitPagView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.f163472qb0);
            }
        });
        this.lightEffectPAG = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$topArea$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConstraintLayout invoke() {
                return (ConstraintLayout) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qsa);
            }
        });
        this.topArea = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$back$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.pcx);
            }
        });
        this.back = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$moreOutfitBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.q9i);
            }
        });
        this.moreOutfitBtn = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$moreInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.q1x);
            }
        });
        this.moreInfo = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$filamentContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.pjg);
            }
        });
        this.filamentContainer = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$publishOutfitBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qel);
            }
        });
        this.publishOutfitBtn = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$publishOutfitMask$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qem);
            }
        });
        this.publishOutfitMask = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$publishBtnText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qen);
            }
        });
        this.publishBtnText = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$changeBackground$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.piy);
            }
        });
        this.changeBackground = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$masterShareBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.f163457q80);
            }
        });
        this.masterShareBtn = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$guestStateGroup$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RelativeLayout invoke() {
                return (RelativeLayout) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.py5);
            }
        });
        this.guestStateGroup = lazy15;
        lazy16 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$outfitDescription$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qau);
            }
        });
        this.outfitDescription = lazy16;
        lazy17 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$masterOutfitDescription$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qav);
            }
        });
        this.masterOutfitDescription = lazy17;
        lazy18 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$likeButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.q5b);
            }
        });
        this.likeButton = lazy18;
        lazy19 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$likeIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.q57);
            }
        });
        this.likeIcon = lazy19;
        lazy20 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$shareButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.f163522ql0);
            }
        });
        this.shareButton = lazy20;
        lazy21 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$tryOnOutfitBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qsx);
            }
        });
        this.tryOnOutfitBtn = lazy21;
        lazy22 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$likeNumber$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.q0_);
            }
        });
        this.likeNumber = lazy22;
        lazy23 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$authorName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.p_n);
            }
        });
        this.authorName = lazy23;
        lazy24 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$outfitTryNum$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.f163473qb1);
            }
        });
        this.outfitTryNum = lazy24;
        lazy25 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$outfitDot$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qaw);
            }
        });
        this.outfitDot = lazy25;
        lazy26 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$outfitItemNum$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qax);
            }
        });
        this.outfitItemNum = lazy26;
        lazy27 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$outfitItemNumMaster$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qay);
            }
        });
        this.outfitItemNumMaster = lazy27;
        lazy28 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$recyclerView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return (RecyclerView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qaz);
            }
        });
        this.recyclerView = lazy28;
        lazy29 = LazyKt__LazyJVMKt.lazy(new Function0<RoundRectImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$avatarImg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoundRectImageView invoke() {
                return (RoundRectImageView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.p_o);
            }
        });
        this.avatarImg = lazy29;
        lazy30 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$screenshotImageView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitOutfitPreviewFragment.this.requireView().findViewById(R.id.qja);
            }
        });
        this.screenshotImageView = lazy30;
        this.isFirstEnter = true;
        this.backgroundIndexRangePosition = 10000;
        this.likeData = new LikeData(false, 0L, 3, null);
        this.dtReporter = new zd3.a();
        this.guestPageId = "pg_zplan_feed_detail";
        this.masterPageId = "pg_zplan_contribute";
        this.pageId = "pg_zplan_feed_detail";
        this.pageParams = new LinkedHashMap();
        this.isPublishing = new AtomicBoolean(false);
        this.nickName = "";
        this.firstFramePNGPath = "";
        Boolean bool = Boolean.FALSE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(bool, bool);
        this.uploadImageStatus = mutableListOf;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(bool, bool, bool, bool, bool);
        this.urlDrawableLoadStatus = mutableListOf2;
        this.avatarCosUrl = "";
        this.thumbnailCosUrl = "";
        this.avatarDressDataManager = new com.tencent.mobileqq.zplan.aigc.helper.b();
        this.fetchAvatarSuccessEvent = new MutableLiveData<>();
        this.onMakeSameStyleClick = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$onMakeSameStyleClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke(l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j3) {
                if (!NetworkUtil.isNetworkAvailable()) {
                    SuitOutfitPreviewFragment.this.Pk("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                    return;
                }
                String a16 = AIGCHelper.f330685a.a(j3, SuitParentFragment.AigcSuitPreviewFromValue.OUTFIT_DETAIL.getValue());
                ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
                Context requireContext = SuitOutfitPreviewFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                iSchemeApi.launchScheme(requireContext, a16);
            }
        };
        this.onTryOnBtnClick = new SuitOutfitPreviewFragment$onTryOnBtnClick$1(this);
        this.avatarImageUploadCallBack = new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$avatarImageUploadCallBack$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool2, String str) {
                invoke(bool2.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, String url) {
                AtomicBoolean atomicBoolean;
                List list;
                Intrinsics.checkNotNullParameter(url, "url");
                if (!z16) {
                    atomicBoolean = SuitOutfitPreviewFragment.this.isPublishing;
                    atomicBoolean.set(false);
                    final SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$avatarImageUploadCallBack$1.1
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
                            SuitOutfitPreviewFragment.this.ek(false);
                            QLog.e("SuitOutfitPreviewFragment", 1, "publishOutfit failed, upload avatar image to cos filed ");
                            SuitOutfitPreviewFragment.this.Pk("\u7f51\u7edc\u5f02\u5e38");
                        }
                    });
                    return;
                }
                QLog.i("SuitOutfitPreviewFragment", 1, "avatar uploaded url: " + url);
                SuitOutfitPreviewFragment.this.avatarCosUrl = url;
                list = SuitOutfitPreviewFragment.this.uploadImageStatus;
                list.set(1, Boolean.TRUE);
                SuitOutfitPreviewFragment.this.Wk();
            }
        };
        this.thumbnailImageUploadCallback = new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$thumbnailImageUploadCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool2, String str) {
                invoke(bool2.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, String thumbnailUrl) {
                AtomicBoolean atomicBoolean;
                List list;
                Intrinsics.checkNotNullParameter(thumbnailUrl, "thumbnailUrl");
                if (!z16) {
                    atomicBoolean = SuitOutfitPreviewFragment.this.isPublishing;
                    atomicBoolean.set(false);
                    final SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$thumbnailImageUploadCallback$1.1
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
                            SuitOutfitPreviewFragment.this.ek(false);
                            QLog.e("SuitOutfitPreviewFragment", 1, "publishOutfit failed, upload thumbnail image to cos filed ");
                            SuitOutfitPreviewFragment.this.Pk("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                        }
                    });
                    return;
                }
                QLog.i("SuitOutfitPreviewFragment", 1, "thumbnail uploaded url: " + thumbnailUrl);
                SuitOutfitPreviewFragment.this.thumbnailCosUrl = thumbnailUrl;
                list = SuitOutfitPreviewFragment.this.uploadImageStatus;
                list.set(0, Boolean.TRUE);
                SuitOutfitPreviewFragment.this.Wk();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ak(SuitOutfitPreviewFragment this$0, int i3, Double d16, SuitOutfitPreviewFragment$recordAndExportImage$recordListener$1 recordListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recordListener, "$recordListener");
        SuitOutfitViewModel suitOutfitViewModel = this$0.vm;
        SuitOutfitViewModel suitOutfitViewModel2 = null;
        if (suitOutfitViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel = null;
        }
        AigcPreviewBusinessScene scene = suitOutfitViewModel.getScene();
        if (scene != null) {
            SuitOutfitViewModel suitOutfitViewModel3 = this$0.vm;
            if (suitOutfitViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                suitOutfitViewModel2 = suitOutfitViewModel3;
            }
            UEAvatarGender currentGender = suitOutfitViewModel2.getCurrentGender();
            Intrinsics.checkNotNull(currentGender);
            AigcPreviewBusinessScene.recordFrame$default(scene, currentGender, i3, d16.doubleValue(), recordListener, null, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SuitOutfitPreviewViewBinder Bj() {
        return (SuitOutfitPreviewViewBinder) this.binder.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$recordAndExportThumbnailImage$recordListener$1] */
    public final void Bk(final b callback) {
        View view = null;
        if (this.outfitThumbnailImageFile != null) {
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
            if (f16 != null) {
                CorountineFunKt.e(f16, "SuitOutfitPreviewFragment_recordThumbnailImage", null, null, null, new SuitOutfitPreviewFragment$recordAndExportThumbnailImage$1(callback, this, null), 14, null);
                return;
            }
            return;
        }
        final ?? r06 = new com.tencent.filament.zplan.d() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$recordAndExportThumbnailImage$recordListener$1
            @Override // com.tencent.filament.zplan.d
            public void a(byte[] pixels, int width, int height) {
                CoroutineScope f17 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
                if (f17 != null) {
                    CorountineFunKt.e(f17, "SuitOutfitPreviewFragment_recordThumbnailImage", null, null, null, new SuitOutfitPreviewFragment$recordAndExportThumbnailImage$recordListener$1$onRecordFrame$1(width, height, pixels, SuitOutfitPreviewFragment.b.this, this, null), 14, null);
                }
            }
        };
        View view2 = this.textureView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
        } else {
            view = view2;
        }
        view.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.am
            @Override // java.lang.Runnable
            public final void run() {
                SuitOutfitPreviewFragment.Ck(SuitOutfitPreviewFragment.this, r06);
            }
        });
    }

    private final FrameLayout Cj() {
        Object value = this.changeBackground.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-changeBackground>(...)");
        return (FrameLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ck(SuitOutfitPreviewFragment this$0, SuitOutfitPreviewFragment$recordAndExportThumbnailImage$recordListener$1 recordListener) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recordListener, "$recordListener");
        SuitOutfitViewModel suitOutfitViewModel = this$0.vm;
        SuitOutfitViewModel suitOutfitViewModel2 = null;
        if (suitOutfitViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel = null;
        }
        AigcPreviewBusinessScene scene = suitOutfitViewModel.getScene();
        if (scene != null) {
            SuitOutfitViewModel suitOutfitViewModel3 = this$0.vm;
            if (suitOutfitViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                suitOutfitViewModel2 = suitOutfitViewModel3;
            }
            UEAvatarGender currentGender = suitOutfitViewModel2.getCurrentGender();
            Intrinsics.checkNotNull(currentGender);
            AigcPreviewBusinessScene.recordFrame$default(scene, currentGender, 0, 0.0d, recordListener, null, 16, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout Dj() {
        Object value = this.filamentContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-filamentContainer>(...)");
        return (FrameLayout) value;
    }

    private final void Dk() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.ag
            @Override // java.lang.Runnable
            public final void run() {
                SuitOutfitPreviewFragment.Ek(SuitOutfitPreviewFragment.this);
            }
        }, 128, null, true);
    }

    private final RelativeLayout Ej() {
        Object value = this.guestStateGroup.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-guestStateGroup>(...)");
        return (RelativeLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ek(SuitOutfitPreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SuitOutfitViewModel suitOutfitViewModel = this$0.vm;
        SuitOutfitViewModel suitOutfitViewModel2 = null;
        if (suitOutfitViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel = null;
        }
        if (!suitOutfitViewModel.w2(null, false)) {
            QLog.i("SuitOutfitPreviewFragment", 1, "checkSoAndInitLightSdk failed");
            SuitOutfitViewModel suitOutfitViewModel3 = this$0.vm;
            if (suitOutfitViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                suitOutfitViewModel2 = suitOutfitViewModel3;
            }
            suitOutfitViewModel2.X1(new j());
            return;
        }
        this$0.isLightReady = true;
        if (this$0.getView() != null) {
            this$0.Fj().x();
            this$0.Xk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SuitPagView Fj() {
        Object value = this.lightEffectPAG.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-lightEffectPAG>(...)");
        return (SuitPagView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout Gj() {
        Object value = this.likeButton.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-likeButton>(...)");
        return (LinearLayout) value;
    }

    private final ImageView Hj() {
        Object value = this.likeIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-likeIcon>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Ij() {
        Object value = this.likeNumber.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-likeNumber>(...)");
        return (TextView) value;
    }

    private final void Jk() {
        ConstraintLayout ck5 = ck();
        com.tencent.mobileqq.zplan.aigc.utils.a aVar = com.tencent.mobileqq.zplan.aigc.utils.a.f330690a;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ck5.setPadding(0, aVar.c(requireContext), 0, ImmersiveUtils.dpToPx(4.0f));
    }

    private final LinearLayout Kj() {
        Object value = this.masterOutfitDescription.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-masterOutfitDescription>(...)");
        return (LinearLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout Lj() {
        Object value = this.masterShareBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-masterShareBtn>(...)");
        return (LinearLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView Mj() {
        Object value = this.moreInfo.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-moreInfo>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mk(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0<Unit> backHandler) {
        ga4.g a16;
        l94.a aVar = new l94.a();
        aVar.e("\u8bf7\u9009\u62e9\u4e3e\u62a5\u539f\u56e0");
        aVar.b(pj("\u8272\u60c5\u4f4e\u4fd7", 2));
        aVar.b(pj("\u6284\u88ad/\u4fb5\u6743\u6295\u8bc9", 3));
        aVar.b(pj("\u5185\u5bb9\u5f15\u4eba\u4e0d\u9002", 4));
        aVar.b(pj("\u5176\u4ed6", 5));
        aVar.d(new l());
        a16 = ga4.j.f401682a.a(6, avatarPanelChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(null, null, aVar.c(), null, null, 0, 59, null), (r22 & 16) != 0 ? false : false);
        a16.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout Nj() {
        Object value = this.moreOutfitBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-moreOutfitBtn>(...)");
        return (LinearLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nk(final Bitmap avatarBitmap) {
        try {
            if (!isAdded() || getContext() == null || this.maskBitmapForShare == null) {
                return;
            }
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.ai
                @Override // java.lang.Runnable
                public final void run() {
                    SuitOutfitPreviewFragment.Ok(SuitOutfitPreviewFragment.this, avatarBitmap);
                }
            });
        } catch (Exception e16) {
            QLog.i("SuitOutfitPreviewFragment", 2, "showShareDialog error: " + Log.getStackTraceString(e16));
        }
    }

    private final LinearLayout Oj() {
        Object value = this.outfitDescription.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-outfitDescription>(...)");
        return (LinearLayout) value;
    }

    private final TextView Pj() {
        Object value = this.outfitDot.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-outfitDot>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Pk(final String toastWords) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$showStatusToast$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (SuitOutfitPreviewFragment.this.getContext() != null) {
                    QQToast.makeText(SuitOutfitPreviewFragment.this.getContext(), toastWords, 0).show();
                }
            }
        });
    }

    private final TextView Qj() {
        Object value = this.outfitItemNum.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-outfitItemNum>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qk(boolean isScreenshot, boolean isThumbnail) {
        String str;
        SuitOutfitViewModel suitOutfitViewModel = null;
        View view = null;
        if (!isScreenshot) {
            View view2 = this.textureView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureView");
                view2 = null;
            }
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i3 = this.originFilamentViewWidth;
            layoutParams.width = i3;
            int i16 = this.originFilamentViewHeight;
            layoutParams.height = i16;
            QLog.i("SuitOutfitPreviewFragment", 1, "textureView layoutParams width:" + i3 + ", height:" + i16);
            View view3 = this.textureView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureView");
                view3 = null;
            }
            view3.setLayoutParams(layoutParams);
            View view4 = this.textureView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureView");
                view4 = null;
            }
            view4.invalidate();
            View view5 = this.textureView;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureView");
            } else {
                view = view5;
            }
            view.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.aj
                @Override // java.lang.Runnable
                public final void run() {
                    SuitOutfitPreviewFragment.Rk(SuitOutfitPreviewFragment.this);
                }
            });
            return;
        }
        if (isThumbnail) {
            View view6 = this.textureView;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureView");
                view6 = null;
            }
            ViewGroup.LayoutParams layoutParams2 = view6.getLayoutParams();
            layoutParams2.width = 720;
            layoutParams2.height = 720;
            View view7 = this.textureView;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureView");
                view7 = null;
            }
            view7.setLayoutParams(layoutParams2);
            SuitOutfitViewModel suitOutfitViewModel2 = this.vm;
            if (suitOutfitViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel2 = null;
            }
            if (suitOutfitViewModel2.getCurrentGender() == UEAvatarGender.MALE) {
                str = "{\"exposure\":{\"aperture\":16,\"sensitivity\":100.0,\"shutterSpeed\":0.008},\"lensProjection\":{\"aspect\":0.45,\"far\":1000.0,\"focalLength\":120,\"near\":0.05},\"lookAt\":{\"eye\":[0.0,1.0,8.2129],\"target\":[0.0,0.7090301,0.0],\"upward\":[0.0,1.0,0.0]}}";
            } else {
                str = "{\"exposure\":{\"aperture\":16,\"sensitivity\":100.0,\"shutterSpeed\":0.008},\"lensProjection\":{\"aspect\":0.45,\"far\":1000.0,\"focalLength\":120,\"near\":0.05},\"lookAt\":{\"eye\":[0.0,1.0,7.890409],\"target\":[0.0,0.6729,0.0],\"upward\":[0.0,1.0,0.0]}}";
            }
        } else {
            View view8 = this.textureView;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureView");
                view8 = null;
            }
            this.originFilamentViewWidth = view8.getWidth();
            View view9 = this.textureView;
            if (view9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureView");
                view9 = null;
            }
            this.originFilamentViewHeight = view9.getHeight();
            View view10 = this.textureView;
            if (view10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureView");
                view10 = null;
            }
            ViewGroup.LayoutParams layoutParams3 = view10.getLayoutParams();
            layoutParams3.width = 900;
            layoutParams3.height = 1600;
            View view11 = this.textureView;
            if (view11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textureView");
                view11 = null;
            }
            view11.setLayoutParams(layoutParams3);
            SuitOutfitViewModel suitOutfitViewModel3 = this.vm;
            if (suitOutfitViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel3 = null;
            }
            if (suitOutfitViewModel3.getCurrentGender() == UEAvatarGender.MALE) {
                str = "{\"exposure\":{\"aperture\":16,\"sensitivity\":100.0,\"shutterSpeed\":0.008},\"lensProjection\":{\"aspect\":0.45,\"far\":1000.0,\"focalLength\":120,\"near\":0.05},\"lookAt\":{\"eye\":[0.0,1.0,10.03961],\"target\":[0.0,0.739917,0.0],\"upward\":[0.0,1.0,0.0]}}";
            } else {
                str = "{\"exposure\":{\"aperture\":16,\"sensitivity\":100.0,\"shutterSpeed\":0.008},\"lensProjection\":{\"aspect\":0.45,\"far\":1000.0,\"focalLength\":120,\"near\":0.05},\"lookAt\":{\"eye\":[0.0,1.0,9.44758],\"target\":[0.0,0.7013,0.0],\"upward\":[0.0,1.0,0.0]}}";
            }
        }
        View view12 = this.textureView;
        if (view12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            view12 = null;
        }
        view12.invalidate();
        SuitOutfitViewModel suitOutfitViewModel4 = this.vm;
        if (suitOutfitViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            suitOutfitViewModel = suitOutfitViewModel4;
        }
        AigcPreviewBusinessScene scene = suitOutfitViewModel.getScene();
        if (scene != null) {
            scene.switchCamera(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Rj() {
        Object value = this.outfitItemNumMaster.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-outfitItemNumMaster>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rk(SuitOutfitPreviewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SuitOutfitViewModel suitOutfitViewModel = this$0.vm;
        if (suitOutfitViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel = null;
        }
        AigcPreviewBusinessScene scene = suitOutfitViewModel.getScene();
        if (scene != null) {
            scene.switchCamera("{\"exposure\":{\"aperture\":16,\"sensitivity\":100.0,\"shutterSpeed\":0.008},\"lensProjection\":{\"aspect\":0.45,\"far\":1000.0,\"focalLength\":120,\"near\":0.05},\"lookAt\":{\"eye\":[0.0,1.0,14.13359],\"target\":[0.0,0.39022,0.0],\"upward\":[0.0,1.0,0.0]}}");
        }
    }

    private final List<Bitmap> Sj() {
        ImageView partImg;
        Bitmap f16;
        ArrayList arrayList = new ArrayList();
        int min = Math.min(5, getRecyclerView().getChildCount());
        for (int i3 = 0; i3 < min; i3++) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = getRecyclerView().findViewHolderForAdapterPosition(i3);
            if (findViewHolderForAdapterPosition instanceof l.a) {
                partImg = ((l.a) findViewHolderForAdapterPosition).getPartImg();
            } else if (findViewHolderForAdapterPosition instanceof l.c) {
                partImg = ((l.c) findViewHolderForAdapterPosition).getPartImg();
            } else if (findViewHolderForAdapterPosition instanceof l.d) {
                partImg = ((l.d) findViewHolderForAdapterPosition).getPartImg();
            } else {
                partImg = findViewHolderForAdapterPosition instanceof l.e ? ((l.e) findViewHolderForAdapterPosition).getPartImg() : null;
            }
            if (partImg != null && (f16 = com.tencent.mobileqq.zplan.aigc.utils.a.f330690a.f(partImg)) != null) {
                arrayList.add(f16);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sk() {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$switchMasterUIPresenter$1
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
                fi3.bz bzVar;
                LinearLayout Lj;
                LinearLayout Vj;
                bzVar = SuitOutfitPreviewFragment.this.binding;
                if (bzVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bzVar = null;
                }
                bzVar.K.setVisibility(8);
                Lj = SuitOutfitPreviewFragment.this.Lj();
                if (Lj != null) {
                    Lj.setVisibility(0);
                }
                Vj = SuitOutfitPreviewFragment.this.Vj();
                if (Vj == null) {
                    return;
                }
                Vj.setVisibility(8);
            }
        });
    }

    private final TextView Tj() {
        Object value = this.outfitTryNum.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-outfitTryNum>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Tk() {
        String str = this.currentFeedId;
        if (str != null) {
            SuitOutfitViewModel suitOutfitViewModel = this.vm;
            if (suitOutfitViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel = null;
            }
            suitOutfitViewModel.W1(str, new com.tencent.mobileqq.zootopia.api.e<Long>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$tryDeleteFeed$1$1
                public void a(long result) {
                    final SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$tryDeleteFeed$1$1$onResultSuccess$1
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
                            QLog.i("SuitOutfitPreviewFragment", 1, "try delete feed success, feedId " + SuitOutfitPreviewFragment.this.currentFeedId);
                            SuitOutfitPreviewFragment.this.Pk("\u5220\u9664\u6210\u529f");
                            HippyMap hippyMap = new HippyMap();
                            hippyMap.pushString("feedID", SuitOutfitPreviewFragment.this.currentFeedId);
                            HippyQQEngine.dispatchEvent("outfitFeedDeleted", null, hippyMap);
                            SuitOutfitPreviewFragment.this.dtReporter.j(SuitOutfitPreviewFragment.this.currentFeedId);
                            FragmentActivity activity = SuitOutfitPreviewFragment.this.getActivity();
                            if (activity != null) {
                                activity.finish();
                            }
                        }
                    });
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                public void onResultFailure(int error, String message) {
                    QLog.i("SuitOutfitPreviewFragment", 1, "try delete feed failed, error: " + error + ", message: " + message);
                    SuitOutfitPreviewFragment.this.Pk("\u7cfb\u7edf\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                public /* bridge */ /* synthetic */ void onResultSuccess(Long l3) {
                    a(l3.longValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Uj() {
        Object value = this.publishBtnText.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-publishBtnText>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout Vj() {
        Object value = this.publishOutfitBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-publishOutfitBtn>(...)");
        return (LinearLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView Wj() {
        Object value = this.publishOutfitMask.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-publishOutfitMask>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wk() {
        SuitOutfitViewModel suitOutfitViewModel;
        if (this.uploadImageStatus.contains(Boolean.FALSE)) {
            return;
        }
        SuitOutfitViewModel suitOutfitViewModel2 = this.vm;
        SuitOutfitViewModel suitOutfitViewModel3 = null;
        if (suitOutfitViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel = null;
        } else {
            suitOutfitViewModel = suitOutfitViewModel2;
        }
        String str = this.avatarCosUrl;
        String str2 = this.thumbnailCosUrl;
        SuitOutfitViewModel suitOutfitViewModel4 = this.vm;
        if (suitOutfitViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel4 = null;
        }
        String str3 = suitOutfitViewModel4.f2().get(this.currentImageIndex);
        SuitOutfitViewModel suitOutfitViewModel5 = this.vm;
        if (suitOutfitViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            suitOutfitViewModel3 = suitOutfitViewModel5;
        }
        suitOutfitViewModel.x2(str, str2, str3, suitOutfitViewModel3.g2().get(this.currentImageIndex), new nk3.h() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$tryPublishOutfit$1
            @Override // nk3.h
            public void a(ZPlanAIGCStatusCode errCode, String errMsg) {
                AtomicBoolean atomicBoolean;
                Intrinsics.checkNotNullParameter(errCode, "errCode");
                atomicBoolean = SuitOutfitPreviewFragment.this.isPublishing;
                atomicBoolean.set(false);
                final SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$tryPublishOutfit$1$onError$1
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
                        SuitOutfitPreviewFragment.this.ek(false);
                        QLog.e("SuitOutfitPreviewFragment", 1, "publishOutfit failed");
                        SuitOutfitPreviewFragment.this.Pk("\u7cfb\u7edf\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                    }
                });
            }

            @Override // nk3.h
            public void onSuccess(final String feedId) {
                List list;
                AtomicBoolean atomicBoolean;
                Intrinsics.checkNotNullParameter(feedId, "feedId");
                SuitOutfitPreviewFragment.this.currentFeedId = feedId;
                list = SuitOutfitPreviewFragment.this.uploadImageStatus;
                Collections.fill(list, Boolean.FALSE);
                atomicBoolean = SuitOutfitPreviewFragment.this.isPublishing;
                atomicBoolean.set(false);
                final SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$tryPublishOutfit$1$onSuccess$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                        Bitmap bitmap;
                        SuitOutfitPreviewFragment.this.ek(false);
                        SuitOutfitViewModel suitOutfitViewModel6 = null;
                        HippyQQEngine.dispatchEvent("outFitFeedCreated", null, null);
                        QLog.i("SuitOutfitPreviewFragment", 1, "publishOutfit success feedId " + feedId);
                        SuitOutfitPreviewFragment.this.Pk("\u6295\u7a3f\u6210\u529f\uff01\u5feb\u53bb\u5206\u4eab\u7ed9\u597d\u53cb\u5427\uff01");
                        zd3.a aVar = SuitOutfitPreviewFragment.this.dtReporter;
                        SuitOutfitViewModel suitOutfitViewModel7 = SuitOutfitPreviewFragment.this.vm;
                        if (suitOutfitViewModel7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("vm");
                        } else {
                            suitOutfitViewModel6 = suitOutfitViewModel7;
                        }
                        aVar.p(suitOutfitViewModel6.j2());
                        bitmap = SuitOutfitPreviewFragment.this.outfitAvatarImage;
                        if (bitmap != null) {
                            SuitOutfitPreviewFragment.this.Nk(bitmap);
                        }
                        SuitOutfitPreviewFragment.this.Sk();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView Xj() {
        Object value = this.screenshotImageView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-screenshotImageView>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xk() {
        if (this.isFirstEnter && this.isFirstFrame && getView() != null && this.isLightReady) {
            this.isFirstEnter = false;
            SuitPagView.u(Fj(), "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_preview_up_light_start.pag", "https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_preview_up_light_loop.pag", false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout Yj() {
        Object value = this.shareButton.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-shareButton>(...)");
        return (LinearLayout) value;
    }

    private final void Yk() {
        SuitOutfitViewModel suitOutfitViewModel = this.vm;
        if (suitOutfitViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel = null;
        }
        int size = suitOutfitViewModel.f2().size();
        int i3 = this.currentImageIndex + 1;
        this.currentImageIndex = i3;
        if (i3 >= size) {
            this.currentImageIndex = 0;
        }
    }

    private final Bitmap Zj() {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.f159912ih2);
        Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(resources\u2026t_share_good_look_bubble)");
        return decodeResource;
    }

    private final void Zk() {
        String str;
        if (this.isMasterMode) {
            str = this.masterPageId;
        } else {
            str = this.guestPageId;
        }
        this.pageId = str;
    }

    private final List<Bitmap> ak() {
        ArrayList arrayList = new ArrayList();
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.f159930ii4);
        Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(resources\u2026fit_item_bg_icon_octagon)");
        arrayList.add(decodeResource);
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.ii5);
        Intrinsics.checkNotNullExpressionValue(decodeResource2, "decodeResource(resources\u2026it_item_bg_icon_starfish)");
        arrayList.add(decodeResource2);
        Bitmap decodeResource3 = BitmapFactory.decodeResource(getResources(), R.drawable.f159929ii3);
        Intrinsics.checkNotNullExpressionValue(decodeResource3, "decodeResource(resources\u2026tfit_item_bg_icon_flower)");
        arrayList.add(decodeResource3);
        Bitmap decodeResource4 = BitmapFactory.decodeResource(getResources(), R.drawable.f159927ii1);
        Intrinsics.checkNotNullExpressionValue(decodeResource4, "decodeResource(resources\u2026tfit_item_bg_icon_circle)");
        arrayList.add(decodeResource4);
        Bitmap decodeResource5 = BitmapFactory.decodeResource(getResources(), R.drawable.f159928ii2);
        Intrinsics.checkNotNullExpressionValue(decodeResource5, "decodeResource(resources\u2026fit_item_bg_icon_diamond)");
        arrayList.add(decodeResource5);
        return arrayList;
    }

    private final void al(LikeData likeData, boolean lockNum) {
        String valueOf;
        if (likeData.getIsLike()) {
            Hj().setImageResource(R.drawable.i7r);
        } else {
            Hj().setImageResource(R.drawable.f159911ih1);
        }
        if (lockNum) {
            return;
        }
        TextView Ij = Ij();
        if (likeData.getLikeCount() == 0) {
            valueOf = "\u559c\u6b22";
        } else {
            valueOf = String.valueOf(likeData.getLikeCount());
        }
        Ij.setText(valueOf);
    }

    private final Bitmap bk() {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.f159914ih4);
        Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(resources\u2026re_very_goog_look_bubble)");
        return decodeResource;
    }

    private final ConstraintLayout ck() {
        Object value = this.topArea.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-topArea>(...)");
        return (ConstraintLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout dk() {
        Object value = this.tryOnOutfitBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tryOnOutfitBtn>(...)");
        return (LinearLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean el(String background) {
        if (!URLUtil.isHttpsUrl(background)) {
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.i("SuitOutfitPreviewFragment", 1, "background is not web url : " + background);
            return false;
        }
        Context context = getContext();
        URLDrawable drawable = URLDrawable.getDrawable(background, context != null ? SuitOutfitHelper.f330689a.c(context, this.lastBackgroundDrawable) : null);
        if (drawable.getStatus() == 1) {
            this.lastBackgroundDrawable = drawable;
        }
        drawable.setURLDrawableListener(new m(drawable));
        drawable.setDownloadListener(new n());
        yj().setImageDrawable(drawable);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "SuitOutfitPreviewFragment", null, null, null, new SuitOutfitPreviewFragment$updateUrlBg$3(drawable, null), 14, null);
        }
        return true;
    }

    private final void fk() {
        if (this.filamentInitialized) {
            return;
        }
        this.filamentInitialized = true;
        this.nativeApp = FilamentRenderFactory.b(FilamentRenderFactory.f105773b, null, FilamentApiImpl.f369933a.e(), null, null, 12, null);
        gk();
        wk0.a aVar = this.nativeApp;
        View view = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar = null;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        View z16 = aVar.z(requireContext, Boolean.TRUE);
        z16.setZ(-1.0f);
        this.textureView = z16;
        FrameLayout Dj = Dj();
        View view2 = this.textureView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
        } else {
            view = view2;
        }
        Dj.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    private final String getNickName() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String friendNick = ((IFriendNameService) peekAppRuntime.getRuntimeService(IFriendNameService.class, "all")).getFriendNick(peekAppRuntime.getCurrentUin());
        Intrinsics.checkNotNullExpressionValue(friendNick, "app\n            .getRunt\u2026riendNick(app.currentUin)");
        return friendNick;
    }

    private final RecyclerView getRecyclerView() {
        Object value = this.recyclerView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-recyclerView>(...)");
        return (RecyclerView) value;
    }

    private final void hk() {
        if (!NetworkUtil.isNetworkAvailable()) {
            Pk("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        }
        getRecyclerView().setAdapter(new be3.l(new ArrayList(), this.onMakeSameStyleClick, this.onTryOnBtnClick, this.pageParams, this.dtReporter, this.isMasterMode, this.urlDrawableLoadStatus));
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 0);
        this.mLayoutManager = staggeredGridLayoutManager;
        staggeredGridLayoutManager.setGapStrategy(2);
        RecyclerView recyclerView = getRecyclerView();
        StaggeredGridLayoutManager staggeredGridLayoutManager2 = this.mLayoutManager;
        if (staggeredGridLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutManager");
            staggeredGridLayoutManager2 = null;
        }
        recyclerView.setLayoutManager(staggeredGridLayoutManager2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ik(SuitOutfitPreviewFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (hf0.a.b("SuitOutfitPreviewFragment" + this$0.getId(), 300L)) {
            return;
        }
        this$0.Yk();
        SuitOutfitViewModel suitOutfitViewModel = this$0.vm;
        SuitOutfitViewModel suitOutfitViewModel2 = null;
        if (suitOutfitViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel = null;
        }
        this$0.el(suitOutfitViewModel.f2().get(this$0.currentImageIndex));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SuitOutfitViewModel suitOutfitViewModel3 = this$0.vm;
        if (suitOutfitViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            suitOutfitViewModel2 = suitOutfitViewModel3;
        }
        linkedHashMap.put("zplan_background_id", suitOutfitViewModel2.f2().get(this$0.currentImageIndex));
        zd3.a aVar = this$0.dtReporter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        aVar.t(it, "em_zplan_change_theme_image", linkedHashMap);
    }

    private final void initView() {
        wj().setCornerRadiusAndMode(ViewUtils.dpToPx(10.0f), 1);
        this.isPublishing.set(false);
        ViewModel viewModel = new ViewModelProvider(this).get(SuitOutfitViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026fitViewModel::class.java)");
        SuitOutfitViewModel suitOutfitViewModel = (SuitOutfitViewModel) viewModel;
        this.vm = suitOutfitViewModel;
        if (this.isMasterMode) {
            if (suitOutfitViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel = null;
            }
            MutableLiveData<SuitOutfitPreviewBgUrlConfig> p26 = suitOutfitViewModel.p2();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<SuitOutfitPreviewBgUrlConfig, Unit> function1 = new Function1<SuitOutfitPreviewBgUrlConfig, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SuitOutfitPreviewBgUrlConfig suitOutfitPreviewBgUrlConfig) {
                    invoke2(suitOutfitPreviewBgUrlConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SuitOutfitPreviewBgUrlConfig suitOutfitPreviewBgUrlConfig) {
                    int i3;
                    SuitOutfitViewModel suitOutfitViewModel2 = SuitOutfitPreviewFragment.this.vm;
                    SuitOutfitViewModel suitOutfitViewModel3 = null;
                    if (suitOutfitViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                        suitOutfitViewModel2 = null;
                    }
                    int size = suitOutfitViewModel2.f2().size();
                    if (size <= 0) {
                        return;
                    }
                    SuitOutfitPreviewFragment.this.currentImageIndex = Random.INSTANCE.nextInt(0, size);
                    SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                    SuitOutfitViewModel suitOutfitViewModel4 = suitOutfitPreviewFragment.vm;
                    if (suitOutfitViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                    } else {
                        suitOutfitViewModel3 = suitOutfitViewModel4;
                    }
                    List<String> f26 = suitOutfitViewModel3.f2();
                    i3 = SuitOutfitPreviewFragment.this.currentImageIndex;
                    suitOutfitPreviewFragment.el(f26.get(i3));
                }
            };
            p26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.aq
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SuitOutfitPreviewFragment.tk(Function1.this, obj);
                }
            });
        } else {
            if (suitOutfitViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel = null;
            }
            el(suitOutfitViewModel.f2().get(0));
        }
        Cj().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.ar
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitOutfitPreviewFragment.ik(SuitOutfitPreviewFragment.this, view);
            }
        });
        Lj().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.as
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitOutfitPreviewFragment.jk(SuitOutfitPreviewFragment.this, view);
            }
        });
        Jk();
        xj().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.at
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitOutfitPreviewFragment.kk(SuitOutfitPreviewFragment.this, view);
            }
        });
        Nj().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.au
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitOutfitPreviewFragment.lk(SuitOutfitPreviewFragment.this, view);
            }
        });
        Mj().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitOutfitPreviewFragment.mk(SuitOutfitPreviewFragment.this, view);
            }
        });
        Vj().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitOutfitPreviewFragment.nk(SuitOutfitPreviewFragment.this, view);
            }
        });
        Gj().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitOutfitPreviewFragment.ok(SuitOutfitPreviewFragment.this, view);
            }
        });
        this.suitShareDialog = new SuitOutfitShareDialog();
        Yj().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.ad
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitOutfitPreviewFragment.pk(SuitOutfitPreviewFragment.this, view);
            }
        });
        dk().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitOutfitPreviewFragment.rk(SuitOutfitPreviewFragment.this, view);
            }
        });
        jj();
    }

    private final void initViewModel() {
        SuitOutfitViewModel suitOutfitViewModel = this.vm;
        SuitOutfitViewModel suitOutfitViewModel2 = null;
        if (suitOutfitViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel = null;
        }
        suitOutfitViewModel.Z1();
        sj();
        Dk();
        if (this.isMasterMode) {
            MutableLiveData<Boolean> mutableLiveData = this.fetchAvatarSuccessEvent;
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initViewModel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    fi3.bz bzVar;
                    SuitOutfitPreviewViewBinder Bj;
                    TextView Rj;
                    SuitOutfitPreviewFragment.this.isResourceReady = true;
                    SuitOutfitViewModel suitOutfitViewModel3 = SuitOutfitPreviewFragment.this.vm;
                    SuitOutfitViewModel suitOutfitViewModel4 = null;
                    if (suitOutfitViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                        suitOutfitViewModel3 = null;
                    }
                    suitOutfitViewModel3.D2(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.e().b());
                    SuitOutfitPreviewFragment.Vk(SuitOutfitPreviewFragment.this, null, 1, null);
                    bzVar = SuitOutfitPreviewFragment.this.binding;
                    if (bzVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        bzVar = null;
                    }
                    SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                    Bj = suitOutfitPreviewFragment.Bj();
                    LifecycleOwner viewLifecycleOwner2 = suitOutfitPreviewFragment.getViewLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
                    SuitOutfitViewModel suitOutfitViewModel5 = suitOutfitPreviewFragment.vm;
                    if (suitOutfitViewModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                        suitOutfitViewModel5 = null;
                    }
                    Bj.m(viewLifecycleOwner2, bzVar, suitOutfitViewModel5, suitOutfitPreviewFragment.dtReporter);
                    SuitOutfitViewModel suitOutfitViewModel6 = SuitOutfitPreviewFragment.this.vm;
                    if (suitOutfitViewModel6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vm");
                    } else {
                        suitOutfitViewModel4 = suitOutfitViewModel6;
                    }
                    List<uv4.az> n26 = suitOutfitViewModel4.n2();
                    SuitOutfitPreviewFragment.this.cl(n26);
                    Rj = SuitOutfitPreviewFragment.this.Rj();
                    Rj.setText("\u5171 " + n26.size() + " \u4ef6");
                }
            };
            mutableLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.z
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SuitOutfitPreviewFragment.uk(Function1.this, obj);
                }
            });
            if (!com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.f()) {
                this.avatarDressDataManager.g(null, false, new i());
            } else {
                this.fetchAvatarSuccessEvent.postValue(Boolean.TRUE);
            }
            SuitOutfitViewModel suitOutfitViewModel3 = this.vm;
            if (suitOutfitViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel3 = null;
            }
            suitOutfitViewModel3.d2();
            SuitOutfitViewModel suitOutfitViewModel4 = this.vm;
            if (suitOutfitViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                suitOutfitViewModel2 = suitOutfitViewModel4;
            }
            suitOutfitViewModel2.b2();
            return;
        }
        SuitOutfitViewModel suitOutfitViewModel5 = this.vm;
        if (suitOutfitViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel5 = null;
        }
        LiveData<SuitOutfitViewModel.Companion.GetFeedStatus> l26 = suitOutfitViewModel5.l2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<SuitOutfitViewModel.Companion.GetFeedStatus, Unit> function12 = new Function1<SuitOutfitViewModel.Companion.GetFeedStatus, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SuitOutfitViewModel.Companion.GetFeedStatus getFeedStatus) {
                invoke2(getFeedStatus);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SuitOutfitViewModel.Companion.GetFeedStatus getFeedStatus) {
                LinearLayout dk5;
                LinearLayout Yj;
                LinearLayout Gj;
                ImageView Mj;
                LinearLayout Nj;
                if (getFeedStatus == SuitOutfitViewModel.Companion.GetFeedStatus.GET_FEED_STATUS_IS_DELETED) {
                    dk5 = SuitOutfitPreviewFragment.this.dk();
                    dk5.setVisibility(8);
                    Yj = SuitOutfitPreviewFragment.this.Yj();
                    Yj.setVisibility(8);
                    Gj = SuitOutfitPreviewFragment.this.Gj();
                    Gj.setVisibility(8);
                    Mj = SuitOutfitPreviewFragment.this.Mj();
                    Mj.setVisibility(8);
                    Nj = SuitOutfitPreviewFragment.this.Nj();
                    Nj.setVisibility(8);
                    SuitOutfitPreviewFragment.this.Pk("\u8be5\u7a7f\u642d\u4e0d\u5b58\u5728\uff0c\u8bd5\u8bd5\u522b\u7684\u5427\u3002");
                }
            }
        };
        l26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.ak
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitOutfitPreviewFragment.vk(Function1.this, obj);
            }
        });
        SuitOutfitViewModel suitOutfitViewModel6 = this.vm;
        if (suitOutfitViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel6 = null;
        }
        LiveData<bv4.a> o26 = suitOutfitViewModel6.o2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<bv4.a, Unit> function13 = new Function1<bv4.a, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initViewModel$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(bv4.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(bv4.a aVar) {
                RoundRectImageView wj5;
                TextView vj5;
                LikeData likeData;
                List list;
                SuitOutfitPreviewViewBinder Bj;
                fi3.bz bzVar;
                SuitOutfitViewModel suitOutfitViewModel7 = SuitOutfitPreviewFragment.this.vm;
                SuitOutfitViewModel suitOutfitViewModel8 = null;
                if (suitOutfitViewModel7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    suitOutfitViewModel7 = null;
                }
                int i3 = aVar.f29256d.f29261c.f429576e;
                UEAvatarGender uEAvatarGender = UEAvatarGender.FEMALE;
                if (i3 != uEAvatarGender.getIndex()) {
                    uEAvatarGender = UEAvatarGender.MALE;
                }
                suitOutfitViewModel7.D2(uEAvatarGender);
                SuitOutfitPreviewFragment.this.isResourceReady = true;
                SuitOutfitPreviewFragment.this.currentCharacter = aVar.f29256d.f29261c;
                SuitOutfitPreviewFragment.this.Uk(aVar.f29256d.f29261c);
                URLDrawable drawable = URLDrawable.getDrawable(aVar.f29254b.f29273c, com.tencent.mobileqq.zplan.aigc.utils.a.f330690a.e());
                wj5 = SuitOutfitPreviewFragment.this.wj();
                wj5.setImageDrawable(drawable);
                String str = AIGCHelper.f330685a.A(aVar.f29254b.f29272b, 10) + " \u7684\u642d\u914d\u65b9\u6848";
                vj5 = SuitOutfitPreviewFragment.this.vj();
                vj5.setText(str);
                SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                String str2 = aVar.f29254b.f29272b;
                Intrinsics.checkNotNullExpressionValue(str2, "outfitInfo.author.nick");
                suitOutfitPreviewFragment.nickName = str2;
                SuitOutfitPreviewFragment suitOutfitPreviewFragment2 = SuitOutfitPreviewFragment.this;
                String valueOf = String.valueOf(aVar.f29254b.f29271a);
                SuitOutfitViewModel suitOutfitViewModel9 = SuitOutfitPreviewFragment.this.vm;
                if (suitOutfitViewModel9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    suitOutfitViewModel9 = null;
                }
                suitOutfitPreviewFragment2.isFeedMyOwn = Intrinsics.areEqual(valueOf, suitOutfitViewModel9.j2());
                SuitOutfitPreviewFragment.this.localeDressCount = aVar.f29255c.f29267c;
                SuitOutfitPreviewFragment.this.dl(aVar.f29255c.f29267c);
                SuitOutfitPreviewFragment.this.likeData = new LikeData(aVar.f29258f.f29282a, aVar.f29255c.f29266b);
                SuitOutfitViewModel suitOutfitViewModel10 = SuitOutfitPreviewFragment.this.vm;
                if (suitOutfitViewModel10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    suitOutfitViewModel10 = null;
                }
                suitOutfitViewModel10.F2(new LikeData(aVar.f29258f.f29282a, aVar.f29255c.f29266b));
                SuitOutfitPreviewFragment suitOutfitPreviewFragment3 = SuitOutfitPreviewFragment.this;
                likeData = suitOutfitPreviewFragment3.likeData;
                SuitOutfitPreviewFragment.bl(suitOutfitPreviewFragment3, likeData, false, 2, null);
                uv4.az[] storeItems = aVar.f29257e.f29278e;
                SuitOutfitPreviewFragment suitOutfitPreviewFragment4 = SuitOutfitPreviewFragment.this;
                Intrinsics.checkNotNullExpressionValue(storeItems, "storeItems");
                list = ArraysKt___ArraysKt.toList(storeItems);
                suitOutfitPreviewFragment4.cl(list);
                SuitOutfitPreviewFragment.this.createTs = Long.valueOf(aVar.f29255c.f29268d);
                SuitOutfitPreviewFragment.this.avatarUrl = aVar.f29256d.f29259a;
                SuitOutfitPreviewFragment.this.rj();
                SuitOutfitPreviewFragment.this.isDressed = aVar.f29258f.f29283b;
                SuitOutfitPreviewFragment suitOutfitPreviewFragment5 = SuitOutfitPreviewFragment.this;
                String str3 = aVar.f29256d.f29260b;
                Intrinsics.checkNotNullExpressionValue(str3, "outfitInfo.avatar.backgroundUrl");
                suitOutfitPreviewFragment5.el(str3);
                Bj = SuitOutfitPreviewFragment.this.Bj();
                bzVar = SuitOutfitPreviewFragment.this.binding;
                if (bzVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    bzVar = null;
                }
                bv4.f fVar = aVar.f29256d.f29264f;
                SuitOutfitViewModel suitOutfitViewModel11 = SuitOutfitPreviewFragment.this.vm;
                if (suitOutfitViewModel11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                } else {
                    suitOutfitViewModel8 = suitOutfitViewModel11;
                }
                Bj.l(bzVar, fVar, suitOutfitViewModel8);
            }
        };
        o26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.an
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitOutfitPreviewFragment.wk(Function1.this, obj);
            }
        });
        SuitOutfitViewModel suitOutfitViewModel7 = this.vm;
        if (suitOutfitViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel7 = null;
        }
        LiveData<Long> k26 = suitOutfitViewModel7.k2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Long, Unit> function14 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initViewModel$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l3) {
                long j3;
                long j16;
                SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                j3 = suitOutfitPreviewFragment.localeDressCount;
                suitOutfitPreviewFragment.localeDressCount = j3 + 1;
                SuitOutfitPreviewFragment suitOutfitPreviewFragment2 = SuitOutfitPreviewFragment.this;
                j16 = suitOutfitPreviewFragment2.localeDressCount;
                suitOutfitPreviewFragment2.dl(j16);
            }
        };
        k26.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.ao
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitOutfitPreviewFragment.xk(Function1.this, obj);
            }
        });
        SuitOutfitViewModel suitOutfitViewModel8 = this.vm;
        if (suitOutfitViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel8 = null;
        }
        LiveData<LikeData> m26 = suitOutfitViewModel8.m2();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<LikeData, Unit> function15 = new Function1<LikeData, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initViewModel$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LikeData likeData) {
                invoke2(likeData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LikeData likeData) {
                TextView Ij;
                LikeData likeData2;
                LikeData likeData3;
                String valueOf;
                Ij = SuitOutfitPreviewFragment.this.Ij();
                likeData2 = SuitOutfitPreviewFragment.this.likeData;
                if (likeData2.getLikeCount() == 0) {
                    valueOf = "\u559c\u6b22";
                } else {
                    likeData3 = SuitOutfitPreviewFragment.this.likeData;
                    valueOf = String.valueOf(likeData3.getLikeCount());
                }
                Ij.setText(valueOf);
            }
        };
        m26.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.ap
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitOutfitPreviewFragment.yk(Function1.this, obj);
            }
        });
        Context context = getContext();
        if (context != null) {
            SuitOutfitViewModel suitOutfitViewModel9 = this.vm;
            if (suitOutfitViewModel9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                suitOutfitViewModel2 = suitOutfitViewModel9;
            }
            suitOutfitViewModel2.a2(String.valueOf(this.currentFeedId), context);
        }
    }

    private final void jj() {
        fi3.bz bzVar = null;
        if (this.isMasterMode) {
            fi3.bz bzVar2 = this.binding;
            if (bzVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bzVar = bzVar2;
            }
            bzVar.K.setVisibility(j74.b.f409622a.a() ? 8 : 0);
            Kj().setVisibility(0);
            Ej().setVisibility(8);
            Oj().setVisibility(8);
            Mj().setVisibility(8);
            zj().setVisibility(0);
        } else {
            Vj().setVisibility(8);
            fi3.bz bzVar3 = this.binding;
            if (bzVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                bzVar = bzVar3;
            }
            bzVar.K.setVisibility(8);
            Kj().setVisibility(8);
            Ej().setVisibility(0);
            Oj().setVisibility(0);
            Mj().setVisibility(0);
            zj().setVisibility(0);
            zd3.a.y(this.dtReporter, dk(), "ev_zplan_try_clothes_btn", null, null, 12, null);
        }
        QLog.i("SuitOutfitPreviewFragment", 1, "from = " + this.from);
        if (this.from != SuitOutFitPreviewFromValue.FEED_PAGE.getValue()) {
            zd3.a.y(this.dtReporter, Nj(), "em_zplan_more_dressup", null, null, 12, null);
            Nj().setVisibility(0);
        } else {
            Nj().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void jk(SuitOutfitPreviewFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (hf0.a.b("SuitOutfitPreviewFragment" + this$0.getId(), 1000L)) {
            return;
        }
        SuitOutfitShareDialog suitOutfitShareDialog = this$0.suitShareDialog;
        boolean z16 = false;
        if (suitOutfitShareDialog != null && suitOutfitShareDialog.c()) {
            z16 = true;
        }
        if (z16) {
            QLog.i("SuitOutfitPreviewFragment", 1, "dialog is showing");
            return;
        }
        if (!this$0.qj()) {
            QLog.w("SuitOutfitPreviewFragment", 1, "outfit items is loading");
            this$0.Pk("\u8d44\u6e90\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        } else {
            if (this$0.lastBackgroundDrawable == null) {
                QLog.w("SuitOutfitPreviewFragment", 1, "outfit lastBackgroundDrawable is loading");
                this$0.Pk("\u8d44\u6e90\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                return;
            }
            Bitmap bitmap = this$0.outfitAvatarImage;
            if (bitmap != null) {
                this$0.Nk(bitmap);
            }
            zd3.a aVar = this$0.dtReporter;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            zd3.a.v(aVar, it, "em_zplan_share_now", null, 4, null);
        }
    }

    private final byte[] kj(Bitmap bitmap) {
        ByteBuffer allocate = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
        bitmap.copyPixelsToBuffer(allocate);
        byte[] array = allocate.array();
        Intrinsics.checkNotNullExpressionValue(array, "buffer.array()");
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void kk(SuitOutfitPreviewFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitOutfitPreviewFragment$initView$4$1(null), 3, null);
        zd3.a aVar = this$0.dtReporter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zd3.a.v(aVar, it, "em_zplan_back_btn", null, 4, null);
        this$0.requireActivity().finish();
    }

    private final AvatarActionSheetDialogMenuItem lj() {
        return new AvatarActionSheetDialogMenuItem(3, 2, "\u786e\u8ba4\u5220\u9664", new l94.e() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$buildConfirmDeleteItem$1
            @Override // l94.e
            public void a(int menuType, int menuId, View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                if (NetworkUtil.isNetworkAvailable()) {
                    SuitOutfitPreviewFragment.this.Tk();
                } else {
                    final SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$buildConfirmDeleteItem$1$onItemClick$1
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
                            SuitOutfitPreviewFragment.this.Pk("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                        }
                    });
                }
            }

            @Override // l94.e
            public void b(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        }, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lk(SuitOutfitPreviewFragment this$0, View it) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(com.tencent.sqshow.zootopia.utils.ab.INSTANCE.b(), "191")) {
            str = "mqqapi://hippy/open?bundleName%3Dsuperqqshow%26bundleUrl%3Dhttp%3A%2F%2Fzplan-image-1300343094.cos.ap-nanjing.myqcloud.com%2Fhippy%2Fdev_adr.zip%26url%3Dhttps%253A%252F%252Ftest-mweb.superqqshow.qq.com%252Findex.bundle%253Froute%253D%25252FoutfitFeeds%26isStatusBarDarkFont%3Dtrue";
        } else {
            str = "mqqapi://hippy/open?bundleName=superqqshow&url=https%253A%252F%252Fmweb.superqqshow.qq.com%253Froute%253D%25252FoutfitFeeds&isStatusBarDarkFont=true&src_type=app&version=1.0&isAnimated=true&isCustomNightMode=true";
        }
        QLog.i("SuitOutfitPreviewFragment", 1, "hippy jump url: " + str);
        zd3.a aVar = this$0.dtReporter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zd3.a.v(aVar, it, "em_zplan_more_dressup", null, 4, null);
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iSchemeApi.launchScheme(requireContext, str);
        this$0.requireActivity().finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mj(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0<Unit> backHandler) {
        ga4.g a16;
        l94.a aVar = new l94.a();
        aVar.e("\u786e\u8ba4\u5220\u9664\u8fd9\u5957\u7a7f\u642d\u5417\uff1f");
        aVar.b(lj());
        aVar.d(new c());
        a16 = ga4.j.f401682a.a(6, avatarPanelChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(null, null, aVar.c(), null, null, 0, 59, null), (r22 & 16) != 0 ? false : false);
        a16.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mk(SuitOutfitPreviewFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        zd3.a aVar = this$0.dtReporter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zd3.a.v(aVar, it, SquareReportConst.ElementId.ELEMENT_ID_MORE_OPTIONS, null, 4, null);
        View view = this$0.outfitView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ga4.i iVar = new ga4.i((ViewGroup) view);
        com.tencent.sqshow.zootopia.nativeui.data.j jVar = new com.tencent.sqshow.zootopia.nativeui.data.j(null, iVar);
        this$0.mChannel = jVar;
        Intrinsics.checkNotNull(jVar);
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this$0.Lk(jVar, requireContext, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initView$6$1$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        });
        this$0.panelDialogController = iVar;
    }

    private final AvatarActionSheetDialogMenuItem nj(Context context) {
        String string = context.getResources().getString(R.string.xlr);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ing.zplan_bg_eidt_delete)");
        return new AvatarActionSheetDialogMenuItem(3, 2, string, new l94.e() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$buildDeleteItem$1
            @Override // l94.e
            public void a(int menuType, int menuId, View view) {
                View view2;
                Intrinsics.checkNotNullParameter(view, "view");
                SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                view2 = SuitOutfitPreviewFragment.this.outfitView;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
                ga4.i iVar = new ga4.i((ViewGroup) view2);
                SuitOutfitPreviewFragment suitOutfitPreviewFragment2 = SuitOutfitPreviewFragment.this;
                suitOutfitPreviewFragment2.Hk(new com.tencent.sqshow.zootopia.nativeui.data.j(null, iVar));
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel = suitOutfitPreviewFragment2.getMChannel();
                Intrinsics.checkNotNull(mChannel);
                Context requireContext = suitOutfitPreviewFragment2.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                suitOutfitPreviewFragment2.mj(mChannel, requireContext, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$buildDeleteItem$1$onItemClick$1$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                });
                suitOutfitPreviewFragment.Kk(iVar);
            }

            @Override // l94.e
            public void b(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        }, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v9, types: [com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initView$7$thumbnailExportCallback$1] */
    public static final void nk(final SuitOutfitPreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("SuitOutfitPreviewFragment", 1, "publishOutfitBtn");
        if (hf0.a.a("SuitOutfitPreviewFragment" + view.getId()) || this$0.isPublishing.get()) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            this$0.Pk("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
            return;
        }
        this$0.ek(true);
        ImageView Xj = this$0.Xj();
        View view2 = this$0.textureView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            view2 = null;
        }
        Xj.setImageBitmap(((TextureView) view2).getBitmap());
        this$0.isPublishing.set(true);
        final ?? r46 = new b() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initView$7$thumbnailExportCallback$1
            @Override // com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment.b
            public void a(File imageFile) {
                String replace$default;
                String uj5;
                Function2<? super Boolean, ? super String, Unit> function2;
                AtomicBoolean atomicBoolean;
                if (imageFile == null) {
                    final SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initView$7$thumbnailExportCallback$1$onResult$1
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
                            String str;
                            QLog.e("SuitOutfitPreviewFragment", 1, "publishOutfit failed");
                            Context context = SuitOutfitPreviewFragment.this.getContext();
                            if (context == null || (str = context.getString(R.string.i5y)) == null) {
                                str = "";
                            }
                            SuitOutfitPreviewFragment.this.Pk(str);
                            SuitOutfitPreviewFragment.this.ek(false);
                        }
                    });
                    atomicBoolean = SuitOutfitPreviewFragment.this.isPublishing;
                    atomicBoolean.set(false);
                    return;
                }
                String subVersion = AppSetting.f99551k;
                Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
                replace$default = StringsKt__StringsJVMKt.replace$default(subVersion, ".", "", false, 4, (Object) null);
                ZPlanAvatarShpImageUploadDownloadUtils c16 = ZPlanAvatarShpImageUploadDownloadUtils.f331852a.c();
                String absolutePath = imageFile.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "imageFile.absolutePath");
                SuitOutfitViewModel suitOutfitViewModel = SuitOutfitPreviewFragment.this.vm;
                if (suitOutfitViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    suitOutfitViewModel = null;
                }
                String j26 = suitOutfitViewModel.j2();
                uj5 = SuitOutfitPreviewFragment.this.uj();
                String str = "outfit/" + j26 + "/thumbnail_android_" + uj5 + "_" + replace$default + ".png";
                UploadConfig.UploadTarget uploadTarget = UploadConfig.UploadTarget.CDN;
                function2 = SuitOutfitPreviewFragment.this.thumbnailImageUploadCallback;
                c16.k(absolutePath, str, uploadTarget, function2);
            }
        };
        this$0.Qk(true, false);
        this$0.zk(new b() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initView$7$1
            @Override // com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment.b
            public void a(File imageFile) {
                String replace$default;
                String uj5;
                Function2<? super Boolean, ? super String, Unit> function2;
                AtomicBoolean atomicBoolean;
                if (imageFile == null) {
                    final SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                    CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initView$7$1$onResult$1
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
                            String str;
                            QLog.e("SuitOutfitPreviewFragment", 1, "publishOutfit failed, outfit avatar image not exist");
                            Context context = SuitOutfitPreviewFragment.this.getContext();
                            if (context == null || (str = context.getString(R.string.i5y)) == null) {
                                str = "";
                            }
                            SuitOutfitPreviewFragment.this.Pk(str);
                            SuitOutfitPreviewFragment.this.ek(false);
                        }
                    });
                    atomicBoolean = SuitOutfitPreviewFragment.this.isPublishing;
                    atomicBoolean.set(false);
                    return;
                }
                CommonExKt.j(new SuitOutfitPreviewFragment$initView$7$1$onResult$2(SuitOutfitPreviewFragment.this, r46));
                String subVersion = AppSetting.f99551k;
                Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
                replace$default = StringsKt__StringsJVMKt.replace$default(subVersion, ".", "", false, 4, (Object) null);
                ZPlanAvatarShpImageUploadDownloadUtils c16 = ZPlanAvatarShpImageUploadDownloadUtils.f331852a.c();
                String absolutePath = imageFile.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "imageFile.absolutePath");
                SuitOutfitViewModel suitOutfitViewModel = SuitOutfitPreviewFragment.this.vm;
                if (suitOutfitViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    suitOutfitViewModel = null;
                }
                String j26 = suitOutfitViewModel.j2();
                uj5 = SuitOutfitPreviewFragment.this.uj();
                String str = "outfit/" + j26 + "/avatar_android_" + uj5 + "_" + replace$default + ".png";
                UploadConfig.UploadTarget uploadTarget = UploadConfig.UploadTarget.CDN;
                function2 = SuitOutfitPreviewFragment.this.avatarImageUploadCallBack;
                c16.k(absolutePath, str, uploadTarget, function2);
            }
        });
    }

    private final AvatarActionSheetDialogMenuItem oj(Context context) {
        String string = context.getResources().getString(R.string.xvm);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026zplan_suit_outfit_report)");
        return new AvatarActionSheetDialogMenuItem(2, 2, string, new l94.e() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$buildReportItem$1
            @Override // l94.e
            public void a(int menuType, int menuId, View view) {
                View view2;
                Intrinsics.checkNotNullParameter(view, "view");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("zplan_clck_type", "report");
                linkedHashMap.put("dt_pgid", SuitOutfitPreviewFragment.this.pageId);
                SuitOutfitPreviewFragment.this.dtReporter.t(view, "em_zplan_report_float_layer", linkedHashMap);
                SuitOutfitPreviewFragment suitOutfitPreviewFragment = SuitOutfitPreviewFragment.this;
                view2 = SuitOutfitPreviewFragment.this.outfitView;
                Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type android.view.ViewGroup");
                ga4.i iVar = new ga4.i((ViewGroup) view2);
                SuitOutfitPreviewFragment suitOutfitPreviewFragment2 = SuitOutfitPreviewFragment.this;
                suitOutfitPreviewFragment2.Hk(new com.tencent.sqshow.zootopia.nativeui.data.j(null, iVar));
                com.tencent.sqshow.zootopia.nativeui.data.j mChannel = suitOutfitPreviewFragment2.getMChannel();
                Intrinsics.checkNotNull(mChannel);
                Context requireContext = suitOutfitPreviewFragment2.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                suitOutfitPreviewFragment2.Mk(mChannel, requireContext, new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$buildReportItem$1$onItemClick$1$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }
                });
                suitOutfitPreviewFragment.Kk(iVar);
            }

            @Override // l94.e
            public void b(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }
        }, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ok(SuitOutfitPreviewFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SuitOutfitViewModel suitOutfitViewModel = this$0.vm;
        SuitOutfitViewModel suitOutfitViewModel2 = null;
        if (suitOutfitViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel = null;
        }
        suitOutfitViewModel.A2(String.valueOf(this$0.currentFeedId));
        if (this$0.likeData.getIsLike()) {
            this$0.likeData.c(false);
            LikeData likeData = this$0.likeData;
            likeData.d(likeData.getLikeCount() - 1);
        } else {
            this$0.likeData.c(true);
            LikeData likeData2 = this$0.likeData;
            likeData2.d(likeData2.getLikeCount() + 1);
        }
        this$0.al(this$0.likeData, true);
        zd3.a aVar = this$0.dtReporter;
        SuitOutfitViewModel suitOutfitViewModel3 = this$0.vm;
        if (suitOutfitViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            suitOutfitViewModel2 = suitOutfitViewModel3;
        }
        aVar.o(suitOutfitViewModel2.j2(), this$0.likeData.getIsLike());
    }

    private final AvatarActionSheetDialogMenuItem pj(String reason, int menuId) {
        return new AvatarActionSheetDialogMenuItem(2, menuId, reason, new d(), null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pk(final SuitOutfitPreviewFragment this$0, final View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this$0.lastClickTime < 1000) {
            QLog.i("SuitOutfitPreviewFragment", 1, "click interval is too small");
            return;
        }
        this$0.lastClickTime = currentTimeMillis;
        SuitOutfitShareDialog suitOutfitShareDialog = this$0.suitShareDialog;
        boolean z16 = false;
        if (suitOutfitShareDialog != null && suitOutfitShareDialog.c()) {
            z16 = true;
        }
        if (z16) {
            QLog.i("SuitOutfitPreviewFragment", 1, "dialog is showing");
            return;
        }
        if (!this$0.qj()) {
            QLog.w("SuitOutfitPreviewFragment", 1, "outfit items is loading");
            this$0.Pk("\u8d44\u6e90\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        } else if (this$0.lastBackgroundDrawable == null) {
            QLog.w("SuitOutfitPreviewFragment", 1, "outfit lastBackgroundDrawable is loading");
            this$0.Pk("\u8d44\u6e90\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        } else if (this$0.avatarBitmapForShare != null && this$0.maskBitmapForShare != null) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.af
                @Override // java.lang.Runnable
                public final void run() {
                    SuitOutfitPreviewFragment.qk(SuitOutfitPreviewFragment.this, view);
                }
            });
        } else {
            QLog.w("SuitOutfitPreviewFragment", 1, "avatar or mask image is loading");
            this$0.Pk("\u8d44\u6e90\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        }
    }

    private final boolean qj() {
        Iterable until;
        until = RangesKt___RangesKt.until(0, Math.min(5, getRecyclerView().getChildCount()));
        if (!(until instanceof Collection) || !((Collection) until).isEmpty()) {
            Iterator it = until.iterator();
            while (it.hasNext()) {
                if (!this.urlDrawableLoadStatus.get(((IntIterator) it).nextInt()).booleanValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rj() {
        if (this.avatarUrl != null) {
            String str = "avatar_" + this.currentFeedId + ".png";
            com.tencent.mobileqq.zplan.aigc.share.b bVar = com.tencent.mobileqq.zplan.aigc.share.b.f330597a;
            String str2 = this.avatarUrl;
            Intrinsics.checkNotNull(str2);
            bVar.e(str2, str, "suit_outfit_cache_dir", new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rk(final SuitOutfitPreviewFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isResourceReady) {
            if (!this$0.isDressed) {
                SuitOutfitViewModel suitOutfitViewModel = this$0.vm;
                if (suitOutfitViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    suitOutfitViewModel = null;
                }
                suitOutfitViewModel.z2(String.valueOf(this$0.currentFeedId));
                this$0.isDressed = true;
            }
            SuitOutfitViewModel suitOutfitViewModel2 = this$0.vm;
            if (suitOutfitViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel2 = null;
            }
            LiveData<Long> k26 = suitOutfitViewModel2.k2();
            LifecycleOwner viewLifecycleOwner = this$0.getViewLifecycleOwner();
            final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$initView$10$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke2(l3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Long l3) {
                    HippyMap hippyMap = new HippyMap();
                    hippyMap.pushString("feedID", SuitOutfitPreviewFragment.this.currentFeedId);
                    hippyMap.pushString("tryonNum", String.valueOf(l3));
                    HippyQQEngine.dispatchEvent("updateTryonNum", null, hippyMap);
                }
            };
            k26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.ah
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SuitOutfitPreviewFragment.sk(Function1.this, obj);
                }
            });
            SuitOutfitHelper suitOutfitHelper = SuitOutfitHelper.f330689a;
            SuitOutfitViewModel suitOutfitViewModel3 = this$0.vm;
            if (suitOutfitViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel3 = null;
            }
            bv4.a value = suitOutfitViewModel3.o2().getValue();
            String b16 = suitOutfitHelper.b(value != null ? value.f29257e : null, "feeds_samestyle");
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context requireContext = this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            iSchemeApi.launchScheme(requireContext, b16);
            zd3.a aVar = this$0.dtReporter;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            zd3.a.v(aVar, it, "ev_zplan_try_clothes_btn", null, 4, null);
        }
    }

    private final void sj() {
        com.tencent.mobileqq.zplan.aigc.share.b.f330597a.e("https://downv6.qq.com/shadow_qqcamera/zshow/ztp_outfit_template2.png", "ztp_outfit_template2.png", "suit_outfit_cache_dir", new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sk(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tk(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String uj() {
        String format = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "sdf.format(Date())");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uk(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView vj() {
        Object value = this.authorName.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-authorName>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vk(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoundRectImageView wj() {
        Object value = this.avatarImg.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-avatarImg>(...)");
        return (RoundRectImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wk(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xk(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final ImageView yj() {
        Object value = this.backgroundImage.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-backgroundImage>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yk(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final ImageView zj() {
        Object value = this.backgroundMask.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-backgroundMask>(...)");
        return (ImageView) value;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00df  */
    /* JADX WARN: Type inference failed for: r3v8, types: [com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$recordAndExportImage$recordListener$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zk(final b callback) {
        List<SuitAnimationItem> male;
        final Double valueOf;
        View view;
        View view2 = null;
        if (this.outfitAvatarImageFile != null) {
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
            if (f16 != null) {
                CorountineFunKt.e(f16, "SuitOutfitPreviewFragment_recordImage", null, null, null, new SuitOutfitPreviewFragment$recordAndExportImage$1(callback, this, null), 14, null);
                return;
            }
            return;
        }
        SuitOutfitViewModel suitOutfitViewModel = this.vm;
        if (suitOutfitViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel = null;
        }
        ZplanSuitOutfitPreviewConfig value = suitOutfitViewModel.q2().getValue();
        SuitOutfitViewModel suitOutfitViewModel2 = this.vm;
        if (suitOutfitViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel2 = null;
        }
        AigcAnimHelper suitAnimHelper = suitOutfitViewModel2.getSuitAnimHelper();
        Integer valueOf2 = suitAnimHelper != null ? Integer.valueOf(suitAnimHelper.getCurrentAnimIndex()) : null;
        SuitOutfitViewModel suitOutfitViewModel3 = this.vm;
        if (suitOutfitViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            suitOutfitViewModel3 = null;
        }
        if (suitOutfitViewModel3.getCurrentGender() == UEAvatarGender.FEMALE) {
            if (value != null) {
                male = value.getFemale();
            }
            male = null;
        } else {
            if (value != null) {
                male = value.getMale();
            }
            male = null;
        }
        final int i3 = 1;
        if (valueOf2 != null) {
            List<SuitAnimationItem> list = male;
            if (!(list == null || list.isEmpty()) && valueOf2.intValue() < male.size() && valueOf2.intValue() >= 0) {
                SuitAnimationItem suitAnimationItem = male.get(valueOf2.intValue());
                valueOf = suitAnimationItem != null ? Double.valueOf(suitAnimationItem.getBeginTime()) : null;
                QLog.i("SuitOutfitPreviewFragment", 1, "onRecordFrame frameTime: " + valueOf + ", animType: 1");
                final ?? r36 = new com.tencent.filament.zplan.d() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$recordAndExportImage$recordListener$1
                    @Override // com.tencent.filament.zplan.d
                    public void a(byte[] pixels, int width, int height) {
                        CoroutineScope f17 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
                        if (f17 != null) {
                            CorountineFunKt.e(f17, "SuitOutfitPreviewFragment_recordImage", null, null, null, new SuitOutfitPreviewFragment$recordAndExportImage$recordListener$1$onRecordFrame$1(width, height, pixels, SuitOutfitPreviewFragment.b.this, this, null), 14, null);
                        }
                    }
                };
                view = this.textureView;
                if (view != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textureView");
                } else {
                    view2 = view;
                }
                view2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.al
                    @Override // java.lang.Runnable
                    public final void run() {
                        SuitOutfitPreviewFragment.Ak(SuitOutfitPreviewFragment.this, i3, valueOf, r36);
                    }
                });
            }
        }
        valueOf = Double.valueOf(0.0d);
        QLog.i("SuitOutfitPreviewFragment", 1, "onRecordFrame frameTime: " + valueOf + ", animType: 1");
        final SuitOutfitPreviewFragment$recordAndExportImage$recordListener$1 r362 = new com.tencent.filament.zplan.d() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$recordAndExportImage$recordListener$1
            @Override // com.tencent.filament.zplan.d
            public void a(byte[] pixels, int width, int height) {
                CoroutineScope f17 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
                if (f17 != null) {
                    CorountineFunKt.e(f17, "SuitOutfitPreviewFragment_recordImage", null, null, null, new SuitOutfitPreviewFragment$recordAndExportImage$recordListener$1$onRecordFrame$1(width, height, pixels, SuitOutfitPreviewFragment.b.this, this, null), 14, null);
                }
            }
        };
        view = this.textureView;
        if (view != null) {
        }
        view2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.al
            @Override // java.lang.Runnable
            public final void run() {
                SuitOutfitPreviewFragment.Ak(SuitOutfitPreviewFragment.this, i3, valueOf, r362);
            }
        });
    }

    public final void Gk(Bitmap bitmap) {
        this.avatarBitmapForShare = bitmap;
    }

    public final void Hk(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
        this.mChannel = jVar;
    }

    public final void Ik(Bitmap bitmap) {
        this.maskBitmapForShare = bitmap;
    }

    /* renamed from: Jj, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.j getMChannel() {
        return this.mChannel;
    }

    public final void Kk(ga4.i iVar) {
        this.panelDialogController = iVar;
    }

    public final void Lk(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0<Unit> backHandler) {
        ga4.g a16;
        Intrinsics.checkNotNullParameter(avatarPanelChannel, "avatarPanelChannel");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(backHandler, "backHandler");
        l94.a aVar = new l94.a();
        if (this.isFeedMyOwn) {
            aVar.b(nj(context));
        } else {
            aVar.b(oj(context));
        }
        aVar.d(new k());
        a16 = ga4.j.f401682a.a(6, avatarPanelChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : new DialogCustomData(null, null, aVar.c(), null, null, 0, 59, null), (r22 & 16) != 0 ? false : false);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_pgid", this.pageId);
        zd3.a.y(this.dtReporter, a16.getView(), "em_zplan_report_float_layer", linkedHashMap, null, 8, null);
        a16.show();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dg9;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int value;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        QLog.i("SuitOutfitPreviewFragment", 1, " onCreateView");
        fi3.bz g16 = fi3.bz.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        this.outfitView = g16.getRoot();
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (arguments.containsKey("feedId")) {
                this.currentFeedId = arguments.getString("feedId", null);
            } else {
                this.isMasterMode = true;
            }
            if (arguments.containsKey("from")) {
                value = arguments.getInt("from");
            } else {
                value = SuitOutFitPreviewFromValue.FEED_PAGE.getValue();
            }
            this.from = value;
        }
        Zk();
        this.pageParams.put("zplan_feed_detail_entrance", Integer.valueOf(this.from));
        if (this.isMasterMode) {
            Map<String, Object> map = this.pageParams;
            com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
            map.put("zplan_gender", Integer.valueOf(cVar.e().b().getIndex()));
            if (!cVar.f()) {
                this.avatarDressDataManager.e();
            }
        }
        View view = this.outfitView;
        if (view != null) {
            this.dtReporter.c(this, view, this.pageId, this.pageParams);
        }
        return this.outfitView;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        QLog.d("SuitOutfitPreviewFragment", 1, "onResume");
        super.onResume();
        if (this.firstFramePNGPath.length() > 0) {
            Xj().setImageBitmap(BitmapFactory.decodeFile(this.firstFramePNGPath));
        }
        fk();
        Uk(this.currentCharacter);
        wk0.a aVar = this.nativeApp;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar = null;
        }
        aVar.onResume();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        QLog.i("SuitOutfitPreviewFragment", 1, " onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        initView();
        hk();
        initViewModel();
    }

    public final ImageView xj() {
        Object value = this.back.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-back>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fk(Bitmap bitmap, String fName, boolean isThumbnail, b callback) {
        try {
            Context context = getContext();
            File file = new File((context != null ? context.getCacheDir() : null) + "/zplanOutfitResource");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, fName);
            if (file2.exists()) {
                file2.delete();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            if (bitmap != null) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            if (isThumbnail) {
                this.outfitThumbnailImageFile = file2;
            } else {
                this.outfitAvatarImageFile = file2;
            }
            callback.a(file2);
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("SuitOutfitPreviewFragment", 1, "saveScreenshotImage failed");
            callback.a(null);
        }
    }

    private final void gk() {
        QLog.i("SuitOutfitPreviewFragment", 1, "initLoading");
        h hVar = new h();
        wk0.a aVar = this.nativeApp;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar = null;
        }
        aVar.c("onFirstFrameImageReady", hVar);
        SuitOutfitPreviewFragment$initLoading$listener$1 suitOutfitPreviewFragment$initLoading$listener$1 = new SuitOutfitPreviewFragment$initLoading$listener$1(this);
        wk0.a aVar2 = this.nativeApp;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar2 = null;
        }
        aVar2.c("onFirstFrameRenderEnd", suitOutfitPreviewFragment$initLoading$listener$1);
        wk0.a aVar3 = this.nativeApp;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar3 = null;
        }
        aVar3.c("onAllResourceReady", new g());
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenCreated(new SuitOutfitPreviewFragment$initLoading$2(this, suitOutfitPreviewFragment$initLoading$listener$1, null));
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.d("SuitOutfitPreviewFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        this.avatarDressDataManager.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        QLog.d("SuitOutfitPreviewFragment", 1, "onDestroyView");
        super.onDestroyView();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.d("SuitOutfitPreviewFragment", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        super.onPause();
        Xj().setVisibility(0);
        ImageView Xj = Xj();
        View view = this.textureView;
        wk0.a aVar = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            view = null;
        }
        Xj.setImageBitmap(((TextureView) view).getBitmap());
        FrameLayout Dj = Dj();
        View view2 = this.textureView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            view2 = null;
        }
        Dj.removeView(view2);
        wk0.a aVar2 = this.nativeApp;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar2 = null;
        }
        aVar2.onPause();
        wk0.a aVar3 = this.nativeApp;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar3 = null;
        }
        aVar3.removeEventListener("onFirstFrameRenderEnd");
        wk0.a aVar4 = this.nativeApp;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar4 = null;
        }
        aVar4.removeEventListener("onAllResourceReady");
        wk0.a aVar5 = this.nativeApp;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar5 = null;
        }
        aVar5.removeEventListener("onFirstFrameImageReady");
        wk0.a aVar6 = this.nativeApp;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
        } else {
            aVar = aVar6;
        }
        aVar.onDestroy();
        this.filamentInitialized = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ok(SuitOutfitPreviewFragment this$0, Bitmap avatarBitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(avatarBitmap, "$avatarBitmap");
        Bitmap Aj = this$0.Aj(this$0.lastBackgroundDrawable);
        List<Bitmap> Sj = this$0.Sj();
        List<Bitmap> ak5 = this$0.ak();
        Bitmap Zj = this$0.Zj();
        Bitmap bk5 = this$0.bk();
        String nickName = this$0.getNickName();
        this$0.createTs = Long.valueOf(System.currentTimeMillis() / 1000);
        QLog.i("SuitOutfitPreviewFragment", 1, "showShareDialog");
        SuitOutfitShareDialog suitOutfitShareDialog = this$0.suitShareDialog;
        if (suitOutfitShareDialog != null) {
            suitOutfitShareDialog.d(this$0.currentFeedId, this$0.maskBitmapForShare, avatarBitmap, Aj, Sj, ak5, Zj, bk5, this$0.createTs, nickName, this$0.pageParams, this$0.pageId, this$0.dtReporter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uk(qu4.a defaultCharacter) {
        AigcPreviewBusinessScene aigcPreviewBusinessScene;
        List emptyList;
        List emptyList2;
        if (this.isResourceReady && this.filamentInitialized) {
            SuitOutfitViewModel suitOutfitViewModel = this.vm;
            SuitOutfitViewModel suitOutfitViewModel2 = null;
            if (suitOutfitViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel = null;
            }
            AigcAnimHelper suitAnimHelper = suitOutfitViewModel.getSuitAnimHelper();
            SuitOutfitViewModel suitOutfitViewModel3 = this.vm;
            if (suitOutfitViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel3 = null;
            }
            SuitOutfitViewModel suitOutfitViewModel4 = this.vm;
            if (suitOutfitViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel4 = null;
            }
            UEAvatarGender currentGender = suitOutfitViewModel4.getCurrentGender();
            Intrinsics.checkNotNull(currentGender);
            suitOutfitViewModel3.H2(new AigcAnimHelper(currentGender));
            if (suitAnimHelper != null) {
                SuitOutfitViewModel suitOutfitViewModel5 = this.vm;
                if (suitOutfitViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    suitOutfitViewModel5 = null;
                }
                AigcAnimHelper suitAnimHelper2 = suitOutfitViewModel5.getSuitAnimHelper();
                if (suitAnimHelper2 != null) {
                    suitAnimHelper2.F1(suitAnimHelper);
                }
            }
            SuitOutfitViewModel suitOutfitViewModel6 = this.vm;
            if (suitOutfitViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel6 = null;
            }
            if (this.isMasterMode) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                List list = emptyList2;
                int i3 = 1;
                qu4.a aVar = null;
                SuitOutfitViewModel suitOutfitViewModel7 = this.vm;
                if (suitOutfitViewModel7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    suitOutfitViewModel7 = null;
                }
                aigcPreviewBusinessScene = new AigcPreviewBusinessScene(list, i3, aVar, suitOutfitViewModel7.getSuitAnimHelper(), f329931j1, 4, null);
            } else {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                List list2 = emptyList;
                SuitOutfitViewModel suitOutfitViewModel8 = this.vm;
                if (suitOutfitViewModel8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    suitOutfitViewModel8 = null;
                }
                aigcPreviewBusinessScene = new AigcPreviewBusinessScene(list2, 1, defaultCharacter, suitOutfitViewModel8.getSuitAnimHelper(), f329931j1);
            }
            suitOutfitViewModel6.G2(aigcPreviewBusinessScene);
            SuitOutfitViewModel suitOutfitViewModel9 = this.vm;
            if (suitOutfitViewModel9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
                suitOutfitViewModel9 = null;
            }
            if (suitOutfitViewModel9.getScene() == null) {
                return;
            }
            if (suitAnimHelper != null) {
                SuitOutfitViewModel suitOutfitViewModel10 = this.vm;
                if (suitOutfitViewModel10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vm");
                    suitOutfitViewModel10 = null;
                }
                suitOutfitViewModel10.S1(this.isMasterMode, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$tryEnterAigcPreviewScene$2$1
                    public final void invoke(boolean z16) {
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }
                });
            }
            wk0.a aVar2 = this.nativeApp;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
                aVar2 = null;
            }
            SuitOutfitViewModel suitOutfitViewModel11 = this.vm;
            if (suitOutfitViewModel11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vm");
            } else {
                suitOutfitViewModel2 = suitOutfitViewModel11;
            }
            AigcPreviewBusinessScene scene = suitOutfitViewModel2.getScene();
            Intrinsics.checkNotNull(scene);
            int y16 = aVar2.y("", scene);
            QLog.i("SuitOutfitPreviewFragment", 1, " startWithEntry");
            if (y16 != 0) {
                QLog.e("SuitOutfitPreviewFragment", 1, "startWithEntry startRet " + y16 + " is not FIALMENT_APP_STATUS_CREATING");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cl(List<uv4.az> storeItems) {
        Comparator compareBy;
        List<uv4.az> sortedWith;
        int i3;
        int i16 = 2;
        compareBy = ComparisonsKt__ComparisonsKt.compareBy(new Function1<uv4.az, Comparable<?>>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$updateOutfitAdapterData$sortedStoreItems$1
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(uv4.az it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Long.valueOf(-it.f440276c);
            }
        }, new Function1<uv4.az, Comparable<?>>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitOutfitPreviewFragment$updateOutfitAdapterData$sortedStoreItems$2
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(uv4.az it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Integer.valueOf(it.f440290q.f440324a);
            }
        });
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(storeItems, compareBy);
        ArrayList arrayList = new ArrayList();
        for (uv4.az azVar : sortedWith) {
            long j3 = azVar.f440276c;
            if (j3 <= 0 || azVar.I != 8) {
                long j16 = azVar.f440295v;
                if (j16 > 0) {
                    i3 = 3;
                } else {
                    uv4.ba baVar = azVar.f440288o;
                    i3 = ((baVar == null || baVar.f440300a == 0) && azVar.f440287n != null && j16 <= 0) ? i16 : 4;
                }
            } else {
                i3 = 1;
            }
            String str = azVar.f440278e;
            String str2 = azVar.f440279f;
            Intrinsics.checkNotNullExpressionValue(str2, "storeItem.icon");
            String str3 = azVar.f440277d;
            Intrinsics.checkNotNullExpressionValue(str3, "storeItem.name");
            uv4.bc bcVar = azVar.f440287n;
            Integer valueOf = bcVar != null ? Integer.valueOf(bcVar.f440312a) : null;
            uv4.bc bcVar2 = azVar.f440287n;
            Integer valueOf2 = bcVar2 != null ? Integer.valueOf(bcVar2.f440313b) : null;
            uv4.bc bcVar3 = azVar.f440287n;
            arrayList.add(new OutfitItemInfo(i3, "", j3, str, str2, str3, valueOf, valueOf2, bcVar3 != null ? Integer.valueOf(bcVar3.f440314c) : null));
            i16 = 2;
        }
        if (getRecyclerView().getAdapter() != null) {
            RecyclerView.Adapter adapter = getRecyclerView().getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.adapter.SuitOutfitPartAdapter");
            ((be3.l) adapter).setData(arrayList);
        }
        getRecyclerView().invalidate();
        Qj().setText("\u5171 " + arrayList.size() + " \u4ef6");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qk(SuitOutfitPreviewFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bitmap Aj = this$0.Aj(this$0.lastBackgroundDrawable);
        List<Bitmap> Sj = this$0.Sj();
        List<Bitmap> ak5 = this$0.ak();
        Bitmap Zj = this$0.Zj();
        Bitmap bk5 = this$0.bk();
        SuitOutfitShareDialog suitOutfitShareDialog = this$0.suitShareDialog;
        if (suitOutfitShareDialog != null) {
            suitOutfitShareDialog.d(this$0.currentFeedId, this$0.maskBitmapForShare, this$0.avatarBitmapForShare, Aj, Sj, ak5, Zj, bk5, this$0.createTs, this$0.nickName, this$0.pageParams, this$0.pageId, this$0.dtReporter);
        }
        zd3.a aVar = this$0.dtReporter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zd3.a.v(aVar, it, SquareReportConst.ElementId.ELEMENT_ID_POSTER_SHARE, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ek(boolean hideFilament) {
        if (hideFilament) {
            Uj().setText("\u6295\u7a3f\u4e2d...");
            FrameLayout Dj = Dj();
            if (Dj != null) {
                Dj.setVisibility(4);
            }
            ImageView Xj = Xj();
            if (Xj != null) {
                Xj.setVisibility(0);
            }
            ImageView Wj = Wj();
            if (Wj == null) {
                return;
            }
            Wj.setVisibility(0);
            return;
        }
        Qk(false, false);
        View view = this.textureView;
        SuitOutfitViewModel suitOutfitViewModel = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            view = null;
        }
        int i3 = view.getLayoutParams().width;
        View view2 = this.textureView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            view2 = null;
        }
        QLog.i("SuitOutfitPreviewFragment", 1, "textureView layoutParams width:" + i3 + ", height:" + view2.getLayoutParams().height);
        SuitOutfitViewModel suitOutfitViewModel2 = this.vm;
        if (suitOutfitViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
        } else {
            suitOutfitViewModel = suitOutfitViewModel2;
        }
        AigcPreviewBusinessScene scene = suitOutfitViewModel.getScene();
        if (scene != null) {
            scene.runOnViewerThread("showFilament", new SuitOutfitPreviewFragment$hideFilamentView$1(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap tj(Bitmap image) {
        Bitmap e16;
        if (image != null) {
            try {
                e16 = AIGCHelper.f330685a.e(image, kj(image), image.getWidth(), image.getHeight(), true);
            } catch (Exception e17) {
                e17.printStackTrace();
                QLog.e("SuitOutfitPreviewFragment", 1, "generateThumbnailImage failed");
                return null;
            }
        } else {
            e16 = null;
        }
        return AIGCHelper.f330685a.g(e16);
    }

    private final Bitmap Aj(Drawable originalDrawable) {
        Drawable.ConstantState constantState;
        Drawable newDrawable;
        if (originalDrawable == null || (constantState = originalDrawable.mutate().getConstantState()) == null || (newDrawable = constantState.newDrawable()) == null) {
            return null;
        }
        if (newDrawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) newDrawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(newDrawable.getIntrinsicWidth(), newDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        newDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        newDrawable.draw(canvas);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dl(long dressedCount) {
        String str = "";
        if (dressedCount == 0) {
            Pj().setText("");
        } else {
            Pj().setText(" \u00b7 ");
        }
        if (dressedCount > AppConstants.LBS_HELLO_UIN_LONGVALUE) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.1fw", Arrays.copyOf(new Object[]{Double.valueOf(dressedCount / 10000.0d)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            str = format + " \u4eba\u8bd5\u7a7f";
        } else if (dressedCount != 0) {
            str = dressedCount + " \u4eba\u8bd5\u7a7f";
        }
        Tj().setText(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Vk(SuitOutfitPreviewFragment suitOutfitPreviewFragment, qu4.a aVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            aVar = null;
        }
        suitOutfitPreviewFragment.Uk(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void bl(SuitOutfitPreviewFragment suitOutfitPreviewFragment, LikeData likeData, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        suitOutfitPreviewFragment.al(likeData, z16);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitOutfitPreviewFragment$n", "Lcom/tencent/image/URLDrawable$DownloadListener;", "", "onFileDownloadStarted", "", "fileSize", "onFileDownloadSucceed", "", "errorCode", "onFileDownloadFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class n implements URLDrawable.DownloadListener {
        n() {
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadFailed(int errorCode) {
            SuitOutfitPreviewFragment.this.Pk("\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadStarted() {
        }

        @Override // com.tencent.image.URLDrawable.DownloadListener
        public void onFileDownloadSucceed(long fileSize) {
        }
    }
}
