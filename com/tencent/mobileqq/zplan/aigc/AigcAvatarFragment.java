package com.tencent.mobileqq.zplan.aigc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.filament.zplan.avatar.CameraParams;
import com.tencent.filament.zplan.avatar.Exposure;
import com.tencent.filament.zplan.avatar.LensProjection;
import com.tencent.filament.zplan.avatar.LookAt;
import com.tencent.filament.zplan.manager.FilamentRenderFactory;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zootopia.portal.aigc.preview.AigcPreviewBusinessScene;
import com.tencent.mobileqq.zplan.aigc.SuitParentFragment;
import com.tencent.mobileqq.zplan.aigc.data.AIGCFeedItemInfo2;
import com.tencent.mobileqq.zplan.aigc.data.Imagery;
import com.tencent.mobileqq.zplan.aigc.data.SuitWhiteModelItem;
import com.tencent.mobileqq.zplan.aigc.helper.AigcAnimHelper;
import com.tencent.mobileqq.zplan.aigc.view.SuitCreateLoadingView;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCreateTechFragmentViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.aigc.view.SuitPagView;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.avatar.filament.anim.PortalAnimHelper;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.widget.RoundRectImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;
import org.json.JSONObject;
import wc3.LocalUgcPath;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00f2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001a\u0018\u0000 \u00c7\u00012\u00020\u00012\u00020\u0002:\u0002\u00c8\u0001B\t\u00a2\u0006\u0006\b\u00c5\u0001\u0010\u00c6\u0001J\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\u0018\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bJ&\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020\tH\u0016J\u0018\u0010 \u001a\u00020\r2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bJ\b\u0010!\u001a\u00020\rH\u0002J\b\u0010\"\u001a\u00020\rH\u0002J\u0018\u0010&\u001a\u00020\r2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0006H\u0002J\b\u0010'\u001a\u00020\rH\u0002J\b\u0010(\u001a\u00020\rH\u0002J\b\u0010)\u001a\u00020\rH\u0002J0\u0010-\u001a\u00020\r2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*2\b\b\u0002\u0010,\u001a\u00020\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bH\u0002J\u0010\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020.H\u0002J\b\u00101\u001a\u00020\rH\u0002J\u0010\u00104\u001a\u00020\r2\u0006\u00103\u001a\u000202H\u0002J\b\u00105\u001a\u00020\rH\u0002J\b\u00106\u001a\u00020\rH\u0002J\u0010\u00107\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u0006H\u0002J\u0010\u00108\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u0006H\u0002J\b\u00109\u001a\u00020\rH\u0002J\u0010\u0010;\u001a\u00020\r2\u0006\u0010:\u001a\u00020.H\u0002J\b\u0010<\u001a\u00020\rH\u0002J\u0012\u0010>\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020.H\u0002R\u001b\u0010D\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001b\u0010I\u001a\u00020E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010A\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010A\u001a\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010A\u001a\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010A\u001a\u0004\bV\u0010WR\u001b\u0010[\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bY\u0010A\u001a\u0004\bZ\u0010WR\u001b\u0010`\u001a\u00020\\8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b]\u0010A\u001a\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bb\u0010A\u001a\u0004\bc\u0010dR\u001b\u0010j\u001a\u00020f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bg\u0010A\u001a\u0004\bh\u0010iR\u001b\u0010m\u001a\u00020a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bk\u0010A\u001a\u0004\bl\u0010dR\u001b\u0010r\u001a\u00020n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bo\u0010A\u001a\u0004\bp\u0010qR\u001b\u0010u\u001a\u00020a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bs\u0010A\u001a\u0004\bt\u0010dR\u001b\u0010x\u001a\u00020a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bv\u0010A\u001a\u0004\bw\u0010dR\u001b\u0010{\u001a\u00020n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\by\u0010A\u001a\u0004\bz\u0010qR\u0016\u0010\u007f\u001a\u00020|8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b}\u0010~R\u001a\u0010\u0083\u0001\u001a\u00030\u0080\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008d\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0019\u0010\u008f\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008e\u0001\u0010\u008c\u0001R\u001a\u0010\u0093\u0001\u001a\u00030\u0090\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001b\u0010\u0096\u0001\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008c\u0001\u0010\u0095\u0001R\u001b\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0019\u0010\u009d\u0001\u001a\u00030\u009b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009c\u0001\u0010bR\u001e\u0010\u00a1\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u009e\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u001e\u0010\u00a5\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u00a2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001R\u0019\u0010\u00a7\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a6\u0001\u0010\u008c\u0001R\u0019\u0010\u00a9\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u008c\u0001R\u001f\u0010\u00ac\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u00ab\u0001R\u001b\u0010\u00ae\u0001\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ad\u0001\u0010\u0089\u0001R\u001c\u0010\u00b2\u0001\u001a\u0005\u0018\u00010\u00af\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u00b1\u0001R\u0019\u0010\u00b4\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u008c\u0001R\u0019\u0010\u00b6\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u008c\u0001R\u001b\u0010\u00b9\u0001\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b7\u0001\u0010\u00b8\u0001R\u0019\u0010\u00bb\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u008c\u0001R\u0019\u0010\u00be\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bc\u0001\u0010\u00bd\u0001R\u0019\u0010\u00c0\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bf\u0001\u0010\u008c\u0001R\u0019\u0010\u00c2\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c1\u0001\u0010\u008c\u0001R\u0019\u0010\u00c4\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c3\u0001\u0010\u008c\u0001\u00a8\u0006\u00c9\u0001"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/AigcAvatarFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/zplan/aigc/SuitParentFragment$b;", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "getStatusBarColor", "", "enableRootViewSetFitsSystemWindows", "Lcom/tencent/mobileqq/zootopia/api/e;", "cb", "", "Ci", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "hidden", "onHiddenChanged", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackPressed", "oi", "pi", "qi", "Luv4/az;", "storeItem", "avatarType", "Fi", "initViewModel", "si", "Gi", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "gender", "userCacheRsp", "Xh", "", "itemId", "Th", "Wh", "Lcom/tencent/mobileqq/zplan/aigc/data/c;", "feedItemInfo", "Vh", "Bi", "initView", "Di", "Zh", "Ai", "toastWords", "Ei", "Uh", "actionType", WidgetCacheLunarData.YI, "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "ni", "()Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel;", "vm", "Landroid/widget/FrameLayout;", "D", "fi", "()Landroid/widget/FrameLayout;", "filamentContainer", "Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "E", "gi", "()Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "lightEffectPAG", "Lcom/tencent/mobileqq/zplan/aigc/view/SuitCreateLoadingView;", UserInfo.SEX_FEMALE, "hi", "()Lcom/tencent/mobileqq/zplan/aigc/view/SuitCreateLoadingView;", "loadingView", "Landroid/widget/LinearLayout;", "G", "ii", "()Landroid/widget/LinearLayout;", "makeSameStyle", "H", WidgetCacheLunarData.JI, "makeSameStyleGrey", "Landroidx/constraintlayout/widget/ConstraintLayout;", "I", "ki", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "parentView", "Landroid/widget/TextView;", "J", "li", "()Landroid/widget/TextView;", "promptDesc", "Lcom/tencent/widget/RoundRectImageView;", "K", "bi", "()Lcom/tencent/widget/RoundRectImageView;", "creatorDetail", "L", "ci", "creatorName", "Landroid/widget/ImageView;", "M", "di", "()Landroid/widget/ImageView;", "detailIcon", "N", "ei", "detailText", "P", "ai", "aiTv", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mi", "screenshotImageView", "Landroid/graphics/drawable/Drawable;", BdhLogUtil.LogTag.Tag_Req, "Landroid/graphics/drawable/Drawable;", "bgShadowDrawable", "Lwk0/a;", ExifInterface.LATITUDE_SOUTH, "Lwk0/a;", "nativeApp", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;", "T", "Lcom/tencent/mobileqq/zootopia/portal/aigc/preview/AigcPreviewBusinessScene;", "scene", "U", "Landroid/view/View;", "textureView", "V", "Z", "isFirstFrame", "W", "isLoadingSuccess", "Lcom/tencent/mobileqq/zplan/aigc/helper/b;", "X", "Lcom/tencent/mobileqq/zplan/aigc/helper/b;", "avatarDressDataManager", "Y", "Lcom/tencent/mobileqq/zootopia/api/UEAvatarGender;", "originGender", "targetGender", "a0", "Ljava/lang/Integer;", "whiteModelGender", "", "b0", "lastClickTime", "Landroidx/lifecycle/MutableLiveData;", "c0", "Landroidx/lifecycle/MutableLiveData;", "_fetchAvatarSuccessEvent", "Landroidx/lifecycle/LiveData;", "d0", "Landroidx/lifecycle/LiveData;", "fetchAvatarSuccessEvent", "e0", "mismatchVersion", "f0", "mismatchGender", "g0", "Ljava/util/List;", "prepareResourcesDownloadStatus", "h0", "parentview", "Lzd3/a;", "i0", "Lzd3/a;", "dtReporter", "j0", "needRestoreAvatar", "k0", "filamentInitialized", "l0", "Luv4/az;", "currentFeedItemInfo", "m0", "hasEnterScene", "n0", "Ljava/lang/String;", "firstFramePNGPath", "o0", "isFirstEnter", "p0", "isBacking", "q0", "isResourceReady", "<init>", "()V", "r0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AigcAvatarFragment extends ImmersivePartFragment implements SuitParentFragment.b {

    /* renamed from: s0, reason: collision with root package name */
    private static final CameraParams f329836s0;

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy filamentContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy lightEffectPAG;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy loadingView;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy makeSameStyle;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy makeSameStyleGrey;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy parentView;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy promptDesc;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy creatorDetail;

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy creatorName;

    /* renamed from: M, reason: from kotlin metadata */
    private final Lazy detailIcon;

    /* renamed from: N, reason: from kotlin metadata */
    private final Lazy detailText;

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy aiTv;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy screenshotImageView;

    /* renamed from: R, reason: from kotlin metadata */
    private Drawable bgShadowDrawable;

    /* renamed from: S, reason: from kotlin metadata */
    private wk0.a nativeApp;

    /* renamed from: T, reason: from kotlin metadata */
    private AigcPreviewBusinessScene scene;

    /* renamed from: U, reason: from kotlin metadata */
    private View textureView;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isFirstFrame;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean isLoadingSuccess;

    /* renamed from: X, reason: from kotlin metadata */
    private com.tencent.mobileqq.zplan.aigc.helper.b avatarDressDataManager;

    /* renamed from: Y, reason: from kotlin metadata */
    private UEAvatarGender originGender;

    /* renamed from: Z, reason: from kotlin metadata */
    private UEAvatarGender targetGender;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private Integer whiteModelGender;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private long lastClickTime;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> _fetchAvatarSuccessEvent;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Boolean> fetchAvatarSuccessEvent;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private boolean mismatchVersion;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private boolean mismatchGender;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private List<Boolean> prepareResourcesDownloadStatus;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private View parentview;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private zd3.a dtReporter;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private boolean needRestoreAvatar;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean filamentInitialized;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private uv4.az currentFeedItemInfo;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private boolean hasEnterScene;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private String firstFramePNGPath;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstEnter;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private boolean isBacking;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private boolean isResourceReady;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/AigcAvatarFragment$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<Integer> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Integer> f329855e;

        b(com.tencent.mobileqq.zootopia.api.e<Integer> eVar) {
            this.f329855e = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("AigcAvatarFragment", 1, "requestAvatarDressData failed: " + message);
            if (!AigcAvatarFragment.this.isBacking) {
                AigcAvatarFragment.this._fetchAvatarSuccessEvent.postValue(Boolean.FALSE);
            }
            com.tencent.mobileqq.zootopia.api.e<Integer> eVar = this.f329855e;
            if (eVar != null) {
                eVar.onResultSuccess(Integer.valueOf(error));
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Integer num) {
            a(num.intValue());
        }

        public void a(int result) {
            QLog.i("AigcAvatarFragment", 1, "requestAvatarDressData success");
            if (!AigcAvatarFragment.this.isBacking) {
                AigcAvatarFragment.this._fetchAvatarSuccessEvent.postValue(Boolean.TRUE);
            }
            com.tencent.mobileqq.zootopia.api.e<Integer> eVar = this.f329855e;
            if (eVar != null) {
                eVar.onResultSuccess(Integer.valueOf(result));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/AigcAvatarFragment$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<Integer> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<Integer> f329856d;

        c(com.tencent.mobileqq.zootopia.api.e<Integer> eVar) {
            this.f329856d = eVar;
        }

        public void a(int result) {
            com.tencent.mobileqq.zootopia.api.e<Integer> eVar = this.f329856d;
            if (eVar != null) {
                eVar.onResultSuccess(Integer.valueOf(result));
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Integer num) {
            a(num.intValue());
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("AigcAvatarFragment", 1, "restore AvatarDataCenter failed");
            com.tencent.mobileqq.zootopia.api.e<Integer> eVar = this.f329856d;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/AigcAvatarFragment$d", "Luk0/e;", "", "type", "eventData", "", "onEvent", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements uk0.e {
        d() {
        }

        @Override // uk0.e
        public void onEvent(String type, String eventData) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            QLog.i("AigcAvatarFragment", 1, "FIRST_FRAME_IMAGE_READY image path: " + eventData);
            AigcAvatarFragment aigcAvatarFragment = AigcAvatarFragment.this;
            JSONObject b16 = com.tencent.zplan.common.utils.h.f385294a.b(eventData);
            String optString = b16 != null ? b16.optString("imagePath") : null;
            if (optString == null) {
                return;
            }
            aigcAvatarFragment.firstFramePNGPath = optString;
            String str = AigcAvatarFragment.this.firstFramePNGPath;
            if (str == null || str.length() == 0) {
                QLog.e("AigcAvatarFragment", 1, "pngPath empty");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/AigcAvatarFragment$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<Integer> {
        e() {
        }

        public void a(int result) {
            AigcAvatarFragment.this.requireActivity().overridePendingTransition(0, 0);
            AigcAvatarFragment.this.requireActivity().finish();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Integer num) {
            a(num.intValue());
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("AigcAvatarFragment", 1, "restore AvatarDataCenter failed");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/aigc/AigcAvatarFragment$f", "Lcom/tencent/mobileqq/zootopia/api/e;", "", "result", "", "a", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements com.tencent.mobileqq.zootopia.api.e<Integer> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f329860e;

        f(int i3) {
            this.f329860e = i3;
        }

        public void a(int result) {
            QLog.i("AigcAvatarFragment", 1, "requestAvatarDressData success");
            if (AigcAvatarFragment.this.isBacking) {
                return;
            }
            uv4.az azVar = AigcAvatarFragment.this.currentFeedItemInfo;
            if (azVar != null) {
                AigcAvatarFragment.this.Fi(azVar, this.f329860e);
            }
            f94.c.d(f94.c.f398021a, false, 1, null);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("AigcAvatarFragment", 1, "requestAvatarDressData failed: " + message);
            AigcAvatarFragment.this.Ei("\u670d\u88c5\u751f\u6210\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public /* bridge */ /* synthetic */ void onResultSuccess(Integer num) {
            a(num.intValue());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/aigc/AigcAvatarFragment$g", "Lcom/tencent/mobileqq/zplan/aigc/view/SuitCreateLoadingView$b;", "", "onRetry", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements SuitCreateLoadingView.b {
        g() {
        }

        @Override // com.tencent.mobileqq.zplan.aigc.view.SuitCreateLoadingView.b
        public void onRetry() {
            SuitCreateTechFragmentViewModel.c3(AigcAvatarFragment.this.ni(), null, 1, null);
            AigcAvatarFragment.this.ni().f3();
            AigcAvatarFragment.this.ni().h2();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/zplan/aigc/AigcAvatarFragment$h", "Landroid/view/ActionMode$Callback;", "Landroid/view/ActionMode;", "mode", "Landroid/view/Menu;", "menu", "", "onCreateActionMode", "onPrepareActionMode", "", "onDestroyActionMode", "Landroid/view/MenuItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "onActionItemClicked", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class h implements ActionMode.Callback {
        h() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            zd3.a aVar;
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(item, "item");
            if (item.getItemId() != 16908321 || (aVar = AigcAvatarFragment.this.dtReporter) == null) {
                return false;
            }
            aVar.f();
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(menu, "menu");
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(menu, "menu");
            return true;
        }
    }

    static {
        CameraParams cameraParams = new CameraParams(null, null, null, null, null, 31, null);
        Exposure exposure = new Exposure(0, 0.0d, 0.0d, 7, null);
        exposure.setAperture(16);
        exposure.setSensitivity(100.0d);
        exposure.setShutterSpeed(0.008d);
        cameraParams.setExposure(exposure);
        LookAt lookAt = new LookAt(null, null, null, 7, null);
        lookAt.setEye(new float[]{0.0f, 1.0f, 14.03359f});
        lookAt.setTarget(new float[]{0.0f, 0.46022f, 0.0f});
        lookAt.setUpward(new float[]{0.0f, 1.0f, 0.0f});
        cameraParams.setLookAt(lookAt);
        LensProjection lensProjection = new LensProjection(0.0f, 0.0f, 0, 0.0f, 15, null);
        lensProjection.setAspect(0.45f);
        lensProjection.setFar(1000.0f);
        lensProjection.setFocalLength(120);
        lensProjection.setNear(0.05f);
        cameraParams.setLensProjection(lensProjection);
        f329836s0 = cameraParams;
    }

    public AigcAvatarFragment() {
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
        List<Boolean> mutableListOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SuitCreateTechFragmentViewModel>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitCreateTechFragmentViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(AigcAvatarFragment.this.requireParentFragment()).get(SuitCreateTechFragmentViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026entViewModel::class.java)");
                return (SuitCreateTechFragmentViewModel) viewModel;
            }
        });
        this.vm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$filamentContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) AigcAvatarFragment.this.requireView().findViewById(R.id.p_i);
            }
        });
        this.filamentContainer = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<SuitPagView>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$lightEffectPAG$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitPagView invoke() {
                return (SuitPagView) AigcAvatarFragment.this.requireView().findViewById(R.id.p_j);
            }
        });
        this.lightEffectPAG = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<SuitCreateLoadingView>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$loadingView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitCreateLoadingView invoke() {
                return (SuitCreateLoadingView) AigcAvatarFragment.this.requireView().findViewById(R.id.qol);
            }
        });
        this.loadingView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$makeSameStyle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) AigcAvatarFragment.this.requireView().findViewById(R.id.q7k);
            }
        });
        this.makeSameStyle = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$makeSameStyleGrey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                return (LinearLayout) AigcAvatarFragment.this.requireView().findViewById(R.id.q7l);
            }
        });
        this.makeSameStyleGrey = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$parentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConstraintLayout invoke() {
                return (ConstraintLayout) AigcAvatarFragment.this.requireView().findViewById(R.id.p_h);
            }
        });
        this.parentView = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$promptDesc$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) AigcAvatarFragment.this.requireView().findViewById(R.id.p_v);
            }
        });
        this.promptDesc = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<RoundRectImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$creatorDetail$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoundRectImageView invoke() {
                return (RoundRectImageView) AigcAvatarFragment.this.requireView().findViewById(R.id.p_p);
            }
        });
        this.creatorDetail = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$creatorName$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) AigcAvatarFragment.this.requireView().findViewById(R.id.p_q);
            }
        });
        this.creatorName = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$detailIcon$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) AigcAvatarFragment.this.requireView().findViewById(R.id.p_r);
            }
        });
        this.detailIcon = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$detailText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) AigcAvatarFragment.this.requireView().findViewById(R.id.p_u);
            }
        });
        this.detailText = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$aiTv$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) AigcAvatarFragment.this.requireView().findViewById(R.id.p_g);
            }
        });
        this.aiTv = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$screenshotImageView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) AigcAvatarFragment.this.requireView().findViewById(R.id.qja);
            }
        });
        this.screenshotImageView = lazy14;
        this.avatarDressDataManager = new com.tencent.mobileqq.zplan.aigc.helper.b();
        this.whiteModelGender = 0;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._fetchAvatarSuccessEvent = mutableLiveData;
        this.fetchAvatarSuccessEvent = mutableLiveData;
        this.mismatchGender = true;
        Boolean bool = Boolean.FALSE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(bool, bool);
        this.prepareResourcesDownloadStatus = mutableListOf;
        this.needRestoreAvatar = true;
        this.firstFramePNGPath = "";
        this.isFirstEnter = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ai() {
        hi().d();
        fi().setVisibility(4);
        gi().setVisibility(4);
        ii().setVisibility(4);
        ai().setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Bi() {
        String str;
        QLog.i("AigcAvatarFragment", 1, "resourceReadyCallback ");
        hi().g();
        hi().setVisibility(8);
        this.isLoadingSuccess = true;
        Gi();
        gi().setVisibility(0);
        ii().setVisibility(0);
        ai().setVisibility(0);
        ji().setVisibility(!this.mismatchGender && !this.mismatchVersion ? 8 : 0);
        this.isResourceReady = true;
        AIGCFeedItemInfo2 value = ni().s2().getValue();
        if (!this.mismatchVersion) {
            if ((value != null ? value.getStoreItemInfo() : null) != null) {
                this.currentFeedItemInfo = value.getStoreItemInfo();
                Fi(value.getStoreItemInfo(), ni().getAvatarType());
                if (value.getStoreItemInfo().I == 7) {
                    Ei("\u670d\u88c5\u751f\u6210\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
                }
                if (this.mismatchGender) {
                    if (this.targetGender == UEAvatarGender.FEMALE) {
                        str = "\u8be5\u670d\u88c5\u4ec5\u4f9b\u5973\u751f\u4f7f\u7528";
                    } else {
                        str = "\u8be5\u670d\u88c5\u4ec5\u4f9b\u7537\u751f\u4f7f\u7528";
                    }
                    Ei(str);
                }
                Uh();
            }
        }
        Ei("\u5f53\u524d\u7248\u672c\u4e0d\u652f\u6301");
        if (this.mismatchGender) {
        }
        Uh();
    }

    private final void Di(int itemId) {
        String str;
        int b26 = ni().b2(String.valueOf(itemId));
        QLog.d("AigcAvatarFragment", 1, " setDetailText " + b26 + "," + itemId);
        if (b26 == 0) {
            str = "\u5f53\u524d\u7248\u672c\u4e0d\u652f\u6301";
        } else if (b26 == 1) {
            str = "\u5973\u751f\u5f62\u8c61\u53ef\u7528";
        } else if (b26 != 2) {
            str = "\u7537\u5973\u5f62\u8c61\u901a\u7528";
        } else {
            str = "\u7537\u751f\u5f62\u8c61\u53ef\u7528";
        }
        ei().setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ei(final String toastWords) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$showStatusToast$1
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
                if (AigcAvatarFragment.this.getContext() != null) {
                    QQToast.makeText(AigcAvatarFragment.this.getContext(), toastWords, 0).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Fi(uv4.az storeItem, int avatarType) {
        PortalAnimHelper portalAnimHelper;
        List listOf;
        if (this.isResourceReady && this.filamentInitialized && !this.hasEnterScene) {
            LocalUgcPath localUgcPath = new LocalUgcPath("", storeItem);
            if (this.targetGender != null) {
                UEAvatarGender uEAvatarGender = this.targetGender;
                Intrinsics.checkNotNull(uEAvatarGender);
                portalAnimHelper = new AigcAnimHelper(uEAvatarGender);
            } else {
                portalAnimHelper = new PortalAnimHelper();
            }
            PortalAnimHelper portalAnimHelper2 = portalAnimHelper;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(localUgcPath);
            this.scene = new AigcPreviewBusinessScene(listOf, avatarType, null, portalAnimHelper2, f329836s0, 4, null);
            wk0.a aVar = this.nativeApp;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
                aVar = null;
            }
            AigcPreviewBusinessScene aigcPreviewBusinessScene = this.scene;
            Intrinsics.checkNotNull(aigcPreviewBusinessScene);
            int y16 = aVar.y("", aigcPreviewBusinessScene);
            this.hasEnterScene = true;
            if (y16 != 0) {
                QLog.e("AigcAvatarFragment", 1, "startWithEntry startRet " + y16 + " is not FIALMENT_APP_STATUS_CREATING");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gi() {
        if (this.isFirstEnter && this.isLoadingSuccess && this.isFirstFrame) {
            this.isFirstEnter = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Th(String itemId) {
        UEAvatarGender uEAvatarGender;
        UEAvatarGender uEAvatarGender2;
        UEAvatarGender uEAvatarGender3;
        UEAvatarGender uEAvatarGender4;
        int b26 = ni().b2(itemId);
        UEAvatarGender uEAvatarGender5 = null;
        boolean z16 = true;
        if (b26 == 0) {
            this.targetGender = null;
            this.mismatchVersion = true;
            QLog.e("AigcAvatarFragment", 1, "ugc white model " + itemId + " mismatch current qq version");
            return false;
        }
        if (b26 == 1) {
            boolean z17 = (ni().getUseCacheAvatarDataRsp() && (uEAvatarGender2 = this.originGender) == this.targetGender && uEAvatarGender2 == UEAvatarGender.FEMALE) ? false : true;
            if (ni().getUseCacheAvatarDataRsp() && (uEAvatarGender = this.originGender) != this.targetGender && uEAvatarGender == UEAvatarGender.FEMALE) {
                this.needRestoreAvatar = false;
                ni().m3(1);
            }
            UEAvatarGender uEAvatarGender6 = UEAvatarGender.FEMALE;
            this.targetGender = uEAvatarGender6;
            if (ni().getUseCacheAvatarDataRsp() && this.originGender == uEAvatarGender6) {
                this.mismatchGender = false;
            }
            return z17;
        }
        if (b26 != 2) {
            if (b26 != 3) {
                return false;
            }
            if (ni().getUseCacheAvatarDataRsp()) {
                if (this.originGender != this.targetGender) {
                    ni().m3(1);
                } else {
                    z16 = false;
                }
                uEAvatarGender5 = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.e().b();
            }
            this.targetGender = uEAvatarGender5;
            this.mismatchGender = false;
            return z16;
        }
        boolean z18 = (ni().getUseCacheAvatarDataRsp() && (uEAvatarGender4 = this.originGender) == this.targetGender && uEAvatarGender4 == UEAvatarGender.MALE) ? false : true;
        if (ni().getUseCacheAvatarDataRsp() && (uEAvatarGender3 = this.originGender) != this.targetGender && uEAvatarGender3 == UEAvatarGender.MALE) {
            this.needRestoreAvatar = false;
            ni().m3(1);
        }
        UEAvatarGender uEAvatarGender7 = UEAvatarGender.MALE;
        this.targetGender = uEAvatarGender7;
        if (ni().getUseCacheAvatarDataRsp() && this.originGender == uEAvatarGender7) {
            this.mismatchGender = false;
        }
        return z18;
    }

    private final void Uh() {
        zd3.a aVar;
        yi("imp");
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        Fragment parentFragment2 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        if (!((SuitParentFragment) parentFragment).Gi(((SuitParentFragment) parentFragment2).getAvatarFrom()) || (aVar = this.dtReporter) == null) {
            return;
        }
        Fragment parentFragment3 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        aVar.w("dt_imp", ((SuitParentFragment) parentFragment3).ii());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh(AIGCFeedItemInfo2 feedItemInfo) {
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        int avatarFrom = ((SuitParentFragment) parentFragment).getAvatarFrom();
        Fragment parentFragment2 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        Fragment parentFragment3 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        ((SuitParentFragment) parentFragment2).Xh(((SuitParentFragment) parentFragment3).Gi(avatarFrom));
        QLog.i("AigcAvatarFragment", 1, "feedSuccessCallBack ");
        initView();
    }

    private final void Wh() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AigcAvatarFragment$fetchAigcResource$1(this, null), 3, null);
    }

    private final void Xh(UEAvatarGender gender, boolean userCacheRsp, com.tencent.mobileqq.zootopia.api.e<Integer> cb5) {
        QLog.i("AigcAvatarFragment", 1, "fetchAvatarData");
        if (userCacheRsp) {
            if (!this.isBacking) {
                this._fetchAvatarSuccessEvent.postValue(Boolean.TRUE);
            }
            if (cb5 != null) {
                cb5.onResultSuccess(0);
            }
            QLog.i("AigcAvatarFragment", 1, "fetchAvatarData userCacheRsp success");
            return;
        }
        this.avatarDressDataManager.g(gender, userCacheRsp, new b(cb5));
    }

    private final void Zh(int itemId) {
        List<SuitWhiteModelItem> r26;
        QLog.i("AigcAvatarFragment", 1, " findSelectWhiteItem " + itemId);
        if (this.targetGender == UEAvatarGender.MALE) {
            r26 = ni().O2();
        } else {
            r26 = ni().r2();
        }
        if (r26 != null) {
            for (SuitWhiteModelItem suitWhiteModelItem : r26) {
                QLog.i("AigcAvatarFragment", 1, " findSelectWhiteItem " + itemId + "  " + suitWhiteModelItem.getItemId());
                if (Intrinsics.areEqual(suitWhiteModelItem.getItemId(), String.valueOf(itemId))) {
                    ni().E3(suitWhiteModelItem);
                }
            }
        }
    }

    private final TextView ai() {
        Object value = this.aiTv.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-aiTv>(...)");
        return (TextView) value;
    }

    private final RoundRectImageView bi() {
        Object value = this.creatorDetail.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-creatorDetail>(...)");
        return (RoundRectImageView) value;
    }

    private final TextView ci() {
        Object value = this.creatorName.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-creatorName>(...)");
        return (TextView) value;
    }

    private final ImageView di() {
        Object value = this.detailIcon.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-detailIcon>(...)");
        return (ImageView) value;
    }

    private final TextView ei() {
        Object value = this.detailText.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-detailText>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout fi() {
        Object value = this.filamentContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-filamentContainer>(...)");
        return (FrameLayout) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SuitPagView gi() {
        Object value = this.lightEffectPAG.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-lightEffectPAG>(...)");
        return (SuitPagView) value;
    }

    private final SuitCreateLoadingView hi() {
        Object value = this.loadingView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingView>(...)");
        return (SuitCreateLoadingView) value;
    }

    private final LinearLayout ii() {
        Object value = this.makeSameStyle.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-makeSameStyle>(...)");
        return (LinearLayout) value;
    }

    private final void initView() {
        AIGCFeedItemInfo2 showFeedInfo = ni().getShowFeedInfo();
        if (showFeedInfo != null) {
            li().setText(showFeedInfo.getDesc());
            ci().setText(showFeedInfo.getAuthorName());
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            bi().setCornerRadiusAndMode(ViewUtils.dpToPx(8.5f), 1);
            bi().setImageDrawable(URLDrawable.getDrawable(showFeedInfo.getAuthorHeaderUrl(), obtain));
            URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
            obtain2.mLoadingDrawable = drawable;
            obtain2.mFailedDrawable = drawable;
            if (showFeedInfo.getClothImgUrl() != null && !Intrinsics.areEqual(showFeedInfo.getClothImgUrl(), "")) {
                URLDrawable drawable2 = URLDrawable.getDrawable(showFeedInfo.getClothImgUrl(), obtain2);
                ni().q3(drawable2);
                di().setImageDrawable(drawable2);
            }
            uv4.az storeItemInfo = showFeedInfo.getStoreItemInfo();
            int i3 = storeItemInfo != null ? storeItemInfo.f440275b : 0;
            Zh(i3);
            Di(i3);
        }
    }

    private final void initViewModel() {
        LiveData<AIGCFeedItemInfo2> s26 = ni().s2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<AIGCFeedItemInfo2, Unit> function1 = new Function1<AIGCFeedItemInfo2, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AIGCFeedItemInfo2 aIGCFeedItemInfo2) {
                invoke2(aIGCFeedItemInfo2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AIGCFeedItemInfo2 aIGCFeedItemInfo2) {
                List list;
                List list2;
                boolean Th;
                UEAvatarGender uEAvatarGender;
                if ((aIGCFeedItemInfo2 != null ? aIGCFeedItemInfo2.getStoreItemInfo() : null) != null) {
                    AigcAvatarFragment.this.Vh(aIGCFeedItemInfo2);
                    list = AigcAvatarFragment.this.prepareResourcesDownloadStatus;
                    list.set(1, Boolean.TRUE);
                    list2 = AigcAvatarFragment.this.prepareResourcesDownloadStatus;
                    if (((Boolean) list2.get(0)).booleanValue()) {
                        AigcAvatarFragment aigcAvatarFragment = AigcAvatarFragment.this;
                        Th = aigcAvatarFragment.Th(String.valueOf(aigcAvatarFragment.ni().getCurrentItemId()));
                        if (Th) {
                            QLog.i("AigcAvatarFragment", 1, "fetchAvatarData ");
                            AigcAvatarFragment aigcAvatarFragment2 = AigcAvatarFragment.this;
                            uEAvatarGender = aigcAvatarFragment2.targetGender;
                            AigcAvatarFragment.Yh(aigcAvatarFragment2, uEAvatarGender, false, null, 4, null);
                            return;
                        }
                        QLog.i("AigcAvatarFragment", 1, "resourceReadyCallback ");
                        AigcAvatarFragment.this.Bi();
                        return;
                    }
                    return;
                }
                zd3.a aVar = AigcAvatarFragment.this.dtReporter;
                if (aVar != null) {
                    aVar.e(1);
                }
                AigcAvatarFragment.this.Ai();
            }
        };
        s26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AigcAvatarFragment.ri(Function1.this, obj);
            }
        });
    }

    private final LinearLayout ji() {
        Object value = this.makeSameStyleGrey.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-makeSameStyleGrey>(...)");
        return (LinearLayout) value;
    }

    private final ConstraintLayout ki() {
        Object value = this.parentView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-parentView>(...)");
        return (ConstraintLayout) value;
    }

    private final TextView li() {
        Object value = this.promptDesc.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-promptDesc>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView mi() {
        Object value = this.screenshotImageView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-screenshotImageView>(...)");
        return (ImageView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SuitCreateTechFragmentViewModel ni() {
        return (SuitCreateTechFragmentViewModel) this.vm.getValue();
    }

    private final void pi() {
        if (this.filamentInitialized) {
            return;
        }
        this.filamentInitialized = true;
        this.nativeApp = FilamentRenderFactory.b(FilamentRenderFactory.f105773b, null, FilamentApiImpl.f369933a.e(), null, null, 12, null);
        qi();
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
        FrameLayout fi5 = fi();
        View view2 = this.textureView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
        } else {
            view = view2;
        }
        fi5.addView(view, new FrameLayout.LayoutParams(-1, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(final AigcAvatarFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.textureView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textureView");
            view = null;
        }
        final Bitmap bitmap = ((TextureView) view).getBitmap();
        t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$onPause$1$1
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
                ImageView mi5;
                ImageView mi6;
                FrameLayout fi5;
                View view2;
                mi5 = AigcAvatarFragment.this.mi();
                mi5.setVisibility(0);
                mi6 = AigcAvatarFragment.this.mi();
                mi6.setImageBitmap(bitmap);
                fi5 = AigcAvatarFragment.this.fi();
                view2 = AigcAvatarFragment.this.textureView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textureView");
                    view2 = null;
                }
                fi5.removeView(view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(AigcAvatarFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (hf0.a.a("AigcAvatarFragment" + view.getId())) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this$0.lastClickTime < 1000) {
            QLog.i("AigcAvatarFragment", 1, "not click too much");
            this$0.lastClickTime = currentTimeMillis;
            return;
        }
        this$0.lastClickTime = currentTimeMillis;
        if (this$0.ni().J2().getValue() != null) {
            Long value = this$0.ni().J2().getValue();
            Intrinsics.checkNotNull(value);
            if (value.longValue() < 1) {
                QLog.i("AigcAvatarFragment", 1, "makeSameStyle ticketNum is not much");
                Context context = this$0.getContext();
                if (context != null) {
                    Fragment parentFragment = this$0.getParentFragment();
                    Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                    String string = context.getResources().getString(R.string.xkp);
                    Intrinsics.checkNotNullExpressionValue(string, "it1.resources.getString(\u2026lan_aigc_ticket_as_title)");
                    ((SuitParentFragment) parentFragment).Ri(context, string);
                    return;
                }
                return;
            }
        }
        QLog.i("AigcAvatarFragment", 1, " makeSameStyle ");
        if (this$0.mismatchVersion) {
            this$0.Ei("\u6027\u522b\u4e0d\u7b26\uff0c\u65e0\u6cd5\u5236\u4f5c");
            return;
        }
        zi(this$0, null, 1, null);
        if (this$0.mismatchGender) {
            this$0.Ei("\u6027\u522b\u4e0d\u7b26\uff0c\u65e0\u6cd5\u5236\u4f5c");
        } else {
            this$0.si();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(Resources resources, int i3, final AigcAvatarFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Bitmap decodeResource = BitmapFactory.decodeResource(resources, i3);
        Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(res, resId)");
        t74.l.f435563a.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$onViewCreated$5$1
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
                Fragment parentFragment = AigcAvatarFragment.this.getParentFragment();
                SuitParentFragment suitParentFragment = parentFragment instanceof SuitParentFragment ? (SuitParentFragment) parentFragment : null;
                if (suitParentFragment != null) {
                    suitParentFragment.aj(decodeResource);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void xi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void yi(String actionType) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_gender_align", Integer.valueOf(!this.mismatchGender ? 1 : 0));
        if (Intrinsics.areEqual(actionType, "imp")) {
            zd3.a aVar = this.dtReporter;
            if (aVar != null) {
                zd3.a.y(aVar, ii(), "em_zplan_samestyle", linkedHashMap, null, 8, null);
                return;
            }
            return;
        }
        zd3.a aVar2 = this.dtReporter;
        if (aVar2 != null) {
            aVar2.t(ii(), "em_zplan_samestyle", linkedHashMap);
        }
    }

    public final void Ci(com.tencent.mobileqq.zootopia.api.e<Integer> cb5) {
        UEAvatarGender uEAvatarGender = this.originGender;
        if (uEAvatarGender != this.targetGender && this.needRestoreAvatar) {
            Xh(uEAvatarGender, false, cb5);
        } else if (cb5 != null) {
            cb5.onResultSuccess(0);
        }
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
        return R.layout.d9r;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.mobileqq.zplan.aigc.SuitParentFragment.b
    public boolean onBackPressed() {
        QLog.i("AigcAvatarFragment", 1, "onBackPressed");
        if (this.isBacking) {
            return true;
        }
        this.isBacking = true;
        Ci(new e());
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        if (onCreateView == null) {
            onCreateView = null;
        }
        this.parentview = onCreateView;
        Fragment parentFragment = getParentFragment();
        SuitParentFragment suitParentFragment = parentFragment instanceof SuitParentFragment ? (SuitParentFragment) parentFragment : null;
        this.dtReporter = suitParentFragment != null ? suitParentFragment.getDtReporter() : null;
        return onCreateView;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        QLog.d("AigcAvatarFragment", 1, "onHiddenChanged~~~" + hidden);
        if (hidden) {
            onPause();
        } else {
            onResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        QLog.d("AigcAvatarFragment", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        super.onPause();
        if (this.filamentInitialized) {
            wk0.a aVar = null;
            if (this.hasEnterScene) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        AigcAvatarFragment.ti(AigcAvatarFragment.this);
                    }
                }, 16, null, true);
            }
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
            } else {
                aVar = aVar4;
            }
            aVar.onDestroy();
            this.filamentInitialized = false;
            this.hasEnterScene = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a0, code lost:
    
        if (r2 == false) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b6  */
    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResume() {
        QLog.d("AigcAvatarFragment", 1, "onResume");
        super.onResume();
        this.isBacking = false;
        if (ImmersiveUtils.couldSetStatusTextColor()) {
            ImmersiveUtils.setStatusTextColor(true, requireActivity().getWindow());
        }
        if (this.firstFramePNGPath.length() > 0) {
            mi().setImageBitmap(BitmapFactory.decodeFile(this.firstFramePNGPath));
        }
        wk0.a aVar = null;
        SuitCreateTechFragmentViewModel.c3(ni(), null, 1, null);
        pi();
        if (this.isResourceReady) {
            this.originGender = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.e().b();
            int b26 = ni().b2(String.valueOf(ni().getCurrentItemId()));
            QLog.d("AigcAvatarFragment", 1, " onResume check gender " + b26);
            LinearLayout ji5 = ji();
            int i3 = 8;
            if (b26 == 1 || b26 == 2) {
                boolean z16 = this.originGender != this.targetGender;
                this.mismatchGender = z16;
            } else if (b26 != 3) {
                this.mismatchGender = true;
                i3 = 0;
                ji5.setVisibility(i3);
                if (!this.mismatchGender) {
                    this.avatarDressDataManager.g(this.targetGender, false, new f(2));
                } else {
                    uv4.az azVar = this.currentFeedItemInfo;
                    if (azVar != null) {
                        Fi(azVar, ni().getAvatarType());
                    }
                }
            } else {
                this.mismatchGender = false;
                ji5.setVisibility(i3);
                if (!this.mismatchGender) {
                }
            }
        }
        wk0.a aVar2 = this.nativeApp;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
        } else {
            aVar = aVar2;
        }
        aVar.onResume();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        QLog.i("AigcAvatarFragment", 1, " onViewCreated");
        ki().setBackgroundDrawable(URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/Android/zplan_suit_aigc_avatar_bg.png", (URLDrawable.URLDrawableOptions) null));
        this.avatarDressDataManager.e();
        ii().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AigcAvatarFragment.ui(AigcAvatarFragment.this, view2);
            }
        });
        if (ni().getUseCacheAvatarDataRsp()) {
            com.tencent.sqshow.zootopia.nativeui.data.c cVar = com.tencent.sqshow.zootopia.nativeui.data.c.f370920a;
            this.originGender = cVar.e().b();
            this.targetGender = cVar.n();
        }
        ni().m3(2);
        fi().setVisibility(4);
        hi().i();
        hi().j();
        hi().setOnRetryListener(new g());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        Unit unit = Unit.INSTANCE;
        URLDrawable drawable2 = URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/zplan_aigc_v2_button_shadow_bg.png", obtain);
        Intrinsics.checkNotNullExpressionValue(drawable2, "getDrawable(\n           \u2026ANSPARENT;\n            })");
        this.bgShadowDrawable = drawable2;
        SuitCreateLoadingView hi5 = hi();
        Drawable drawable3 = this.bgShadowDrawable;
        if (drawable3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bgShadowDrawable");
            drawable3 = null;
        }
        hi5.setShadowDrawable(drawable3);
        li().setCustomSelectionActionModeCallback(new h());
        Context context = getContext();
        final Resources resources = context != null ? context.getResources() : null;
        final int i3 = R.drawable.ihy;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.b
            @Override // java.lang.Runnable
            public final void run() {
                AigcAvatarFragment.vi(resources, i3, this);
            }
        }, 16, null, true);
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        ((SuitParentFragment) parentFragment).Vh(true);
        pi();
        LiveData<Boolean> I2 = ni().I2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$onViewCreated$6
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
            public final void invoke2(Boolean success) {
                SuitPagView gi5;
                List list;
                List list2;
                boolean Th;
                UEAvatarGender uEAvatarGender;
                QLog.i("AigcAvatarFragment", 1, " successEvent " + success);
                Intrinsics.checkNotNullExpressionValue(success, "success");
                if (success.booleanValue()) {
                    gi5 = AigcAvatarFragment.this.gi();
                    gi5.x();
                    list = AigcAvatarFragment.this.prepareResourcesDownloadStatus;
                    list.set(0, Boolean.TRUE);
                    list2 = AigcAvatarFragment.this.prepareResourcesDownloadStatus;
                    if (((Boolean) list2.get(1)).booleanValue()) {
                        AigcAvatarFragment aigcAvatarFragment = AigcAvatarFragment.this;
                        Th = aigcAvatarFragment.Th(String.valueOf(aigcAvatarFragment.ni().getCurrentItemId()));
                        if (Th) {
                            QLog.i("AigcAvatarFragment", 1, "fetchAvatarData ");
                            AigcAvatarFragment aigcAvatarFragment2 = AigcAvatarFragment.this;
                            uEAvatarGender = aigcAvatarFragment2.targetGender;
                            AigcAvatarFragment.Yh(aigcAvatarFragment2, uEAvatarGender, false, null, 4, null);
                            return;
                        }
                        QLog.i("AigcAvatarFragment", 1, "resourceReadyCallback ");
                        if (AigcAvatarFragment.this.ni().getForceUseSavedAvatar()) {
                            AigcAvatarFragment.this.ni().m3(1);
                        }
                        AigcAvatarFragment.this.Bi();
                        return;
                    }
                    return;
                }
                zd3.a aVar = AigcAvatarFragment.this.dtReporter;
                if (aVar != null) {
                    aVar.e(2);
                }
                AigcAvatarFragment.this.Ai();
            }
        };
        I2.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AigcAvatarFragment.wi(Function1.this, obj);
            }
        });
        LiveData<Boolean> liveData = this.fetchAvatarSuccessEvent;
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$onViewCreated$7
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
            public final void invoke2(Boolean success) {
                QLog.i("AigcAvatarFragment", 1, "fetchAvatarSuccessEvent " + success);
                Intrinsics.checkNotNullExpressionValue(success, "success");
                if (!success.booleanValue()) {
                    zd3.a aVar = AigcAvatarFragment.this.dtReporter;
                    if (aVar != null) {
                        aVar.e(3);
                    }
                    AigcAvatarFragment.this.Ai();
                    return;
                }
                AigcAvatarFragment aigcAvatarFragment = AigcAvatarFragment.this;
                aigcAvatarFragment.mismatchGender = aigcAvatarFragment.ni().v2() != com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex();
                AigcAvatarFragment.this.Bi();
                f94.c.d(f94.c.f398021a, false, 1, null);
            }
        };
        liveData.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AigcAvatarFragment.xi(Function1.this, obj);
            }
        });
        ni().f3();
        Wh();
    }

    private final void qi() {
        QLog.i("AigcAvatarFragment", 1, "initLoading");
        d dVar = new d();
        wk0.a aVar = this.nativeApp;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar = null;
        }
        aVar.c("onFirstFrameImageReady", dVar);
        AigcAvatarFragment$initLoading$listener$1 aigcAvatarFragment$initLoading$listener$1 = new AigcAvatarFragment$initLoading$listener$1(this);
        wk0.a aVar2 = this.nativeApp;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nativeApp");
            aVar2 = null;
        }
        aVar2.c("onFirstFrameRenderEnd", aigcAvatarFragment$initLoading$listener$1);
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenCreated(new AigcAvatarFragment$initLoading$1(this, aigcAvatarFragment$initLoading$listener$1, null));
    }

    public final void oi(com.tencent.mobileqq.zootopia.api.e<Integer> cb5) {
        this.isBacking = true;
        Ci(new c(cb5));
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QLog.d("AigcAvatarFragment", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        super.onDestroy();
        this.avatarDressDataManager.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        QLog.d("AigcAvatarFragment", 1, "onDestroyView");
        super.onDestroyView();
    }

    private final void si() {
        QLog.d("AigcAvatarFragment", 1, "jumpCreateResultTab");
        AIGCFeedItemInfo2 showFeedInfo = ni().getShowFeedInfo();
        if (TextUtils.isEmpty(showFeedInfo != null ? showFeedInfo.getDesc() : null)) {
            QLog.d("AigcAvatarFragment", 1, "desc is null ");
            return;
        }
        AIGCFeedItemInfo2 showFeedInfo2 = ni().getShowFeedInfo();
        if (showFeedInfo2 != null) {
            uv4.az storeItemInfo = showFeedInfo2.getStoreItemInfo();
            Zh(storeItemInfo != null ? storeItemInfo.f440275b : 0);
        }
        if (ni().getSelectedWhiteModelItem() != null) {
            AIGCFeedItemInfo2 showFeedInfo3 = ni().getShowFeedInfo();
            final Imagery imagery = new Imagery(0, 0, null, showFeedInfo3 != null ? showFeedInfo3.getDesc() : null, null, null, null, null, 246, null);
            QLog.d("AigcAvatarFragment", 1, "jumpCreateResultTab " + imagery.getDescription() + " ");
            Fragment parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
            ((SuitParentFragment) parentFragment).Di(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.AigcAvatarFragment$jumpCreateResultTab$2$1
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
                    Fragment parentFragment2 = AigcAvatarFragment.this.getParentFragment();
                    Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                    ((SuitParentFragment) parentFragment2).Vi(imagery, false, false);
                }
            }, false);
        }
    }

    static /* synthetic */ void zi(AigcAvatarFragment aigcAvatarFragment, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "click";
        }
        aigcAvatarFragment.yi(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Yh(AigcAvatarFragment aigcAvatarFragment, UEAvatarGender uEAvatarGender, boolean z16, com.tencent.mobileqq.zootopia.api.e eVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            uEAvatarGender = null;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        if ((i3 & 4) != 0) {
            eVar = null;
        }
        aigcAvatarFragment.Xh(uEAvatarGender, z16, eVar);
    }
}
