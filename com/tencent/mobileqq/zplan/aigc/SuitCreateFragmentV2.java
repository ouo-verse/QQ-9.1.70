package com.tencent.mobileqq.zplan.aigc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.guild.component.marquee.MarqueeTextView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.zootopia.api.UEAvatarGender;
import com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2;
import com.tencent.mobileqq.zplan.aigc.SuitParentFragment;
import com.tencent.mobileqq.zplan.aigc.data.AIGCModelRenderTask;
import com.tencent.mobileqq.zplan.aigc.data.Imagery;
import com.tencent.mobileqq.zplan.aigc.data.SuitWhiteModelItem;
import com.tencent.mobileqq.zplan.aigc.data.TASK_STATUS;
import com.tencent.mobileqq.zplan.aigc.logic.CreatedClothShowLogic;
import com.tencent.mobileqq.zplan.aigc.render.AIGCWhiteModel;
import com.tencent.mobileqq.zplan.aigc.render.g;
import com.tencent.mobileqq.zplan.aigc.utils.AIGCHelper;
import com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager;
import com.tencent.mobileqq.zplan.aigc.view.AIGCViewPagerWithIndicator;
import com.tencent.mobileqq.zplan.aigc.view.SuitCreateLoadingView;
import com.tencent.mobileqq.zplan.aigc.vm.SuitCreateTechFragmentViewModel;
import com.tencent.mobileqq.zplan.portal.aigc.view.AigcWatermarkView;
import com.tencent.mobileqq.zplan.servlet.ZPlanAIGCRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.aigc.view.SuitPagView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import wc3.AigcPreviewParams;
import wc3.ExtraReportParams;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e0\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00e2\u00022\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0004\u00e3\u0002\u00e4\u0002B\t\u00a2\u0006\u0006\b\u00e0\u0002\u0010\u00e1\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J$\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u0017\u001a\u00020\u00072\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0014j\b\u0012\u0004\u0012\u00020\t`\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J \u0010%\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020!H\u0002J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u001dH\u0002J\b\u0010(\u001a\u00020\u0007H\u0002J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\u0007H\u0002J\b\u0010,\u001a\u00020\u0007H\u0002J\b\u0010-\u001a\u00020\u0007H\u0002J \u0010.\u001a\u00020\u00072\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0014j\b\u0012\u0004\u0012\u00020\t`\u0015H\u0002J\u0010\u0010/\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u00101\u001a\u00020\u00072\b\b\u0002\u00100\u001a\u00020\u000fH\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\u0010\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u00104\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020\u0007H\u0002J\u0012\u00109\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u000107H\u0002J\u0012\u0010<\u001a\u00020\u00072\b\u0010;\u001a\u0004\u0018\u00010:H\u0002J\b\u0010=\u001a\u00020\u0007H\u0002J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010?\u001a\u00020>H\u0002J\b\u0010A\u001a\u00020\u0007H\u0002J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u001dH\u0002J\u0010\u0010D\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u001dH\u0002J\u001a\u0010G\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u000f2\b\b\u0002\u0010F\u001a\u00020!H\u0002J\u001a\u0010H\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u000f2\b\b\u0002\u0010F\u001a\u00020!H\u0002J\b\u0010I\u001a\u00020\u0007H\u0002J\u0010\u0010L\u001a\u00020\u00072\u0006\u0010K\u001a\u00020JH\u0002J\"\u0010M\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010:2\u0006\u0010B\u001a\u00020\u001dH\u0002J\u0010\u0010N\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010O\u001a\u00020\u0007H\u0002J\b\u0010P\u001a\u00020\u0007H\u0002J\b\u0010Q\u001a\u00020\u0007H\u0002J\u0018\u0010R\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020>H\u0002J\u0018\u0010S\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020>H\u0002J\u0010\u0010T\u001a\u00020\u00072\u0006\u0010?\u001a\u00020>H\u0002J\b\u0010U\u001a\u00020\u0007H\u0002J`\u0010_\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0014j\b\u0012\u0004\u0012\u00020\t`\u00152\u0006\u0010V\u001a\u00020\u001d2\u0006\u0010W\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020X2\u0006\u0010Z\u001a\u00020\u001d2\b\u0010[\u001a\u0004\u0018\u00010!2\u0006\u0010\\\u001a\u00020\u00192\b\u0010]\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010!H\u0002J\b\u0010`\u001a\u00020\u0007H\u0002J\b\u0010a\u001a\u00020\u0007H\u0002J\b\u0010b\u001a\u00020\u0007H\u0002J\b\u0010c\u001a\u00020\u0007H\u0002J\b\u0010d\u001a\u00020\u0007H\u0002J\b\u0010e\u001a\u00020\u0007H\u0002J\u0010\u0010f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010g\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010i\u001a\u00020\u00072\u0006\u0010h\u001a\u00020\u000fJ\"\u0010j\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010k\u001a\u00020\u0007J\b\u0010l\u001a\u00020\u001dH\u0014J\u000e\u0010o\u001a\b\u0012\u0004\u0012\u00020n0mH\u0016J\b\u0010p\u001a\u00020\u0007H\u0016J\b\u0010q\u001a\u00020\u001dH\u0014J\u0012\u0010t\u001a\u00020\u00072\b\u0010s\u001a\u0004\u0018\u00010rH\u0016J&\u0010y\u001a\u0004\u0018\u00010J2\u0006\u0010v\u001a\u00020u2\b\u0010x\u001a\u0004\u0018\u00010w2\b\u0010s\u001a\u0004\u0018\u00010rH\u0016J\b\u0010z\u001a\u00020\u000fH\u0014J\u0012\u0010|\u001a\u00020\u00072\b\u0010{\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010~\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030}0\u0014j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030}`\u0015H\u0016J\u001a\u0010\u007f\u001a\u00020\u00072\u0006\u0010K\u001a\u00020J2\b\u0010s\u001a\u0004\u0018\u00010rH\u0016J\t\u0010\u0080\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0081\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0082\u0001\u001a\u00020\u000fH\u0016J\u0007\u0010\u0083\u0001\u001a\u00020\u0007J%\u0010\u0086\u0001\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u001d2\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u000f2\t\b\u0002\u0010\u0085\u0001\u001a\u00020\u000fJ\u0007\u0010\u0087\u0001\u001a\u00020\u0007J\u0007\u0010\u0088\u0001\u001a\u00020\u0007J\u0007\u0010\u0089\u0001\u001a\u00020\u0007J\t\u0010\u008a\u0001\u001a\u00020\u0007H\u0016J\u0007\u0010\u008b\u0001\u001a\u00020\u0007R!\u0010\u0091\u0001\u001a\u00030\u008c\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R!\u0010\u0096\u0001\u001a\u00030\u0092\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u008e\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R!\u0010\u009b\u0001\u001a\u00030\u0097\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u008e\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001R!\u0010\u009e\u0001\u001a\u00030\u0097\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u009c\u0001\u0010\u008e\u0001\u001a\u0006\b\u009d\u0001\u0010\u009a\u0001R!\u0010\u00a3\u0001\u001a\u00030\u009f\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a0\u0001\u0010\u008e\u0001\u001a\u0006\b\u00a1\u0001\u0010\u00a2\u0001R!\u0010\u00a6\u0001\u001a\u00030\u009f\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a4\u0001\u0010\u008e\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00a2\u0001R!\u0010\u00a9\u0001\u001a\u00030\u0097\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00a7\u0001\u0010\u008e\u0001\u001a\u0006\b\u00a8\u0001\u0010\u009a\u0001R!\u0010\u00ae\u0001\u001a\u00030\u00aa\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ab\u0001\u0010\u008e\u0001\u001a\u0006\b\u00ac\u0001\u0010\u00ad\u0001R!\u0010\u00b3\u0001\u001a\u00030\u00af\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b0\u0001\u0010\u008e\u0001\u001a\u0006\b\u00b1\u0001\u0010\u00b2\u0001R!\u0010\u00b8\u0001\u001a\u00030\u00b4\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00b5\u0001\u0010\u008e\u0001\u001a\u0006\b\u00b6\u0001\u0010\u00b7\u0001R!\u0010\u00bd\u0001\u001a\u00030\u00b9\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00ba\u0001\u0010\u008e\u0001\u001a\u0006\b\u00bb\u0001\u0010\u00bc\u0001R!\u0010\u00c2\u0001\u001a\u00030\u00be\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00bf\u0001\u0010\u008e\u0001\u001a\u0006\b\u00c0\u0001\u0010\u00c1\u0001R \u0010\u00c6\u0001\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c3\u0001\u0010\u008e\u0001\u001a\u0006\b\u00c4\u0001\u0010\u00c5\u0001R!\u0010\u00cb\u0001\u001a\u00030\u00c7\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00c8\u0001\u0010\u008e\u0001\u001a\u0006\b\u00c9\u0001\u0010\u00ca\u0001R \u0010\u00cf\u0001\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00cc\u0001\u0010\u008e\u0001\u001a\u0006\b\u00cd\u0001\u0010\u00ce\u0001R\u001c\u0010\u00d3\u0001\u001a\u0005\u0018\u00010\u00d0\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d1\u0001\u0010\u00d2\u0001R\u001c\u0010\u00d7\u0001\u001a\u0005\u0018\u00010\u00d4\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d5\u0001\u0010\u00d6\u0001R\u0019\u0010\u00da\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d8\u0001\u0010\u00d9\u0001R\u0019\u0010\u00dc\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00db\u0001\u0010\u00d9\u0001R\u001a\u0010\u00e0\u0001\u001a\u00030\u00dd\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00de\u0001\u0010\u00df\u0001R\u001a\u0010\u00e4\u0001\u001a\u00030\u00e1\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00e2\u0001\u0010\u00e3\u0001R+\u0010\u00eb\u0001\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00e5\u0001\u0010\u00e6\u0001\u001a\u0006\b\u00e7\u0001\u0010\u00e8\u0001\"\u0006\b\u00e9\u0001\u0010\u00ea\u0001R\u001b\u0010\u00ed\u0001\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d9\u0001\u0010\u00ec\u0001R\u0019\u0010\u00ef\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ee\u0001\u0010\u00d9\u0001R!\u0010\u00f4\u0001\u001a\u00030\u00f0\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00f1\u0001\u0010\u008e\u0001\u001a\u0006\b\u00f2\u0001\u0010\u00f3\u0001R!\u0010\u00f7\u0001\u001a\u00030\u00f0\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00f5\u0001\u0010\u008e\u0001\u001a\u0006\b\u00f6\u0001\u0010\u00f3\u0001R!\u0010\u00fc\u0001\u001a\u00030\u00f8\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00f9\u0001\u0010\u008e\u0001\u001a\u0006\b\u00fa\u0001\u0010\u00fb\u0001R \u0010\u00ff\u0001\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u00fd\u0001\u0010\u008e\u0001\u001a\u0006\b\u00fe\u0001\u0010\u00ce\u0001R \u0010\u0082\u0002\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0080\u0002\u0010\u008e\u0001\u001a\u0006\b\u0081\u0002\u0010\u00ce\u0001R \u0010\u0085\u0002\u001a\u00020:8BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0083\u0002\u0010\u008e\u0001\u001a\u0006\b\u0084\u0002\u0010\u00ce\u0001R!\u0010\u0088\u0002\u001a\u00030\u0097\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0086\u0002\u0010\u008e\u0001\u001a\u0006\b\u0087\u0002\u0010\u009a\u0001R!\u0010\u008b\u0002\u001a\u00030\u0097\u00018BX\u0082\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u0089\u0002\u0010\u008e\u0001\u001a\u0006\b\u008a\u0002\u0010\u009a\u0001R,\u0010\u0093\u0002\u001a\u0005\u0018\u00010\u008c\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008d\u0002\u0010\u008e\u0002\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002\"\u0006\b\u0091\u0002\u0010\u0092\u0002R+\u0010\u009a\u0002\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0094\u0002\u0010\u0095\u0002\u001a\u0006\b\u0096\u0002\u0010\u0097\u0002\"\u0006\b\u0098\u0002\u0010\u0099\u0002R\u001d\u0010\u009d\u0002\u001a\b\u0012\u0004\u0012\u00020n0m8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009b\u0002\u0010\u009c\u0002R9\u0010\u00a4\u0002\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0014j\b\u0012\u0004\u0012\u00020\t`\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009e\u0002\u0010\u009f\u0002\u001a\u0006\b\u00a0\u0002\u0010\u00a1\u0002\"\u0006\b\u00a2\u0002\u0010\u00a3\u0002R)\u0010\u00a6\u0002\u001a\u0012\u0012\u0004\u0012\u00020!0\u0014j\b\u0012\u0004\u0012\u00020!`\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a5\u0002\u0010\u009f\u0002R\u0018\u0010\u00aa\u0002\u001a\u00030\u00a7\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a8\u0002\u0010\u00a9\u0002R\u001c\u0010\u00ae\u0002\u001a\u0005\u0018\u00010\u00ab\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0002\u0010\u00ad\u0002R\u001c\u0010\u00b0\u0002\u001a\u0005\u0018\u00010\u00ab\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00af\u0002\u0010\u00ad\u0002R\u001b\u0010\u00b2\u0002\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b1\u0002\u0010\u0095\u0002R\u001b\u0010\u00b4\u0002\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b3\u0002\u0010\u0095\u0002R\u001b\u0010\u00b7\u0002\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b5\u0002\u0010\u00b6\u0002R\u001c\u0010\u00bb\u0002\u001a\u0005\u0018\u00010\u00b8\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b9\u0002\u0010\u00ba\u0002R\u001c\u0010\u00bd\u0002\u001a\u0005\u0018\u00010\u00b8\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bc\u0002\u0010\u00ba\u0002R\u0019\u0010\u00bf\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00be\u0002\u0010\u00d9\u0001R\u0019\u0010\u00c1\u0002\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c0\u0002\u0010\u00d9\u0001R)\u0010\u00c7\u0002\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c2\u0002\u0010\u00ab\u0001\u001a\u0006\b\u00c3\u0002\u0010\u00c4\u0002\"\u0006\b\u00c5\u0002\u0010\u00c6\u0002R)\u0010\u00cb\u0002\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00c8\u0002\u0010\u00ab\u0001\u001a\u0006\b\u00c9\u0002\u0010\u00c4\u0002\"\u0006\b\u00ca\u0002\u0010\u00c6\u0002R\u001f\u0010\u00cf\u0002\u001a\u00020\u001d8\u0006X\u0086D\u00a2\u0006\u0010\n\u0006\b\u00cc\u0002\u0010\u00a7\u0001\u001a\u0006\b\u00cd\u0002\u0010\u00ce\u0002R\u0019\u0010\u00d1\u0002\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00d0\u0002\u0010\u00ab\u0001RL\u0010\u00d7\u0002\u001a7\u0012\u0015\u0012\u00130>\u00a2\u0006\u000e\b\u00d3\u0002\u0012\t\b\u00d4\u0002\u0012\u0004\b\b(?\u0012\u0015\u0012\u00130\u001d\u00a2\u0006\u000e\b\u00d3\u0002\u0012\t\b\u00d4\u0002\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u00070\u00d2\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d5\u0002\u0010\u00d6\u0002RM\u0010\u00da\u0002\u001a8\u0012\u0016\u0012\u001407\u00a2\u0006\u000f\b\u00d3\u0002\u0012\n\b\u00d4\u0002\u0012\u0005\b\b(\u00d8\u0002\u0012\u0015\u0012\u00130\u001d\u00a2\u0006\u000e\b\u00d3\u0002\u0012\t\b\u00d4\u0002\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u00070\u00d2\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00d9\u0002\u0010\u00d6\u0002Rf\u0010\u00df\u0002\u001aQ\u0012\u0015\u0012\u00130\r\u00a2\u0006\u000e\b\u00d3\u0002\u0012\t\b\u00d4\u0002\u0012\u0004\b\b(?\u0012\u0018\u0012\u0016\u0018\u00010:\u00a2\u0006\u000f\b\u00d3\u0002\u0012\n\b\u00d4\u0002\u0012\u0005\b\b(\u00dc\u0002\u0012\u0015\u0012\u00130\u001d\u00a2\u0006\u000e\b\u00d3\u0002\u0012\t\b\u00d4\u0002\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u00070\u00db\u00028\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00dd\u0002\u0010\u00de\u0002\u00a8\u0006\u00e5\u0002"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/zplan/aigc/SuitParentFragment$b;", "Lcom/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$b;", "callback", "", WidgetCacheLunarData.YI, "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "renderTask", "Bj", "jk", "Lcom/tencent/mobileqq/zplan/aigc/data/i;", "imagery", "", "needAnimation", "needClearState", "ek", "kk", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "renderTasks", "mk", "zj", "", "ugcID", "nk", "Hj", "", "icon", "msg", "fk", "", "entranceSource", "gender", "value", "Rj", "resCode", "Aj", "zi", "vj", "wi", "xj", "uj", "yj", "ik", "hk", "isJump", "Yj", "xi", "Ai", "sj", "initView", SensorJsPlugin.SENSOR_INTERVAL_UI, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "lk", "Landroid/widget/ImageView;", "imageView", FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, "jj", "Lcom/tencent/mobileqq/zplan/aigc/data/o;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Ei", "initViewModel", "position", "Di", "Fi", "enable", "str", "Uj", "Wj", "Ej", "Landroid/view/View;", "view", "Gi", "ij", "hj", "Bi", "Ci", "rk", "sk", "qk", "vi", "Bh", "startNum", "count", "Lcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;", "whiteModel", "imageryId", "imageryDescription", "ugcId", "imageryName", "modelItemId", "Ii", "Nj", "Pj", "Oj", "Jj", "Qj", "Mj", "Kj", "Ij", "status", com.tencent.av.ui.ak.f75340i, "ck", "Cj", "getContentLayoutId", "", "Lyd3/e;", "assembleParts", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "getStatusBarColor", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "enableRootViewSetFitsSystemWindows", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onStart", "onResume", "onBackPressed", "rj", "backEvent", "needRefresh", "Sj", "Gj", "Fj", "Dj", "onDestroyView", "Lj", "Lcom/tencent/mobileqq/zplan/aigc/vm/a;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "getActivityVm", "()Lcom/tencent/mobileqq/zplan/aigc/vm/a;", "activityVm", "Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel;", "D", "ej", "()Lcom/tencent/mobileqq/zplan/aigc/vm/SuitCreateTechFragmentViewModel;", "vm", "Landroid/widget/TextView;", "E", "Oi", "()Landroid/widget/TextView;", "createdPromptText", UserInfo.SEX_FEMALE, "Ni", "createdHint", "Landroidx/constraintlayout/widget/ConstraintLayout;", "G", "Qi", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "customizeLayout", "H", "Li", "createShowCustomize", "I", "Ki", "createButton", "Lcom/tencent/mobileqq/guild/component/marquee/MarqueeTextView;", "J", "dj", "()Lcom/tencent/mobileqq/guild/component/marquee/MarqueeTextView;", "tvCustomize", "Lcom/tencent/mobileqq/zplan/portal/aigc/view/AigcWatermarkView;", "K", "Ri", "()Lcom/tencent/mobileqq/zplan/portal/aigc/view/AigcWatermarkView;", "filamentBg", "Lcom/tencent/mobileqq/zplan/aigc/view/AIGCViewPagerWithIndicator;", "L", "Si", "()Lcom/tencent/mobileqq/zplan/aigc/view/AIGCViewPagerWithIndicator;", "filamentContainer", "Landroid/widget/FrameLayout;", "M", "Ji", "()Landroid/widget/FrameLayout;", "aigcMoreBtn", "Lcom/tencent/mobileqq/zplan/aigc/view/SuitCreateLoadingView;", "N", "Vi", "()Lcom/tencent/mobileqq/zplan/aigc/view/SuitCreateLoadingView;", "loadingView", "P", "bj", "()Landroid/view/View;", "suitContentView", "Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Wi", "()Lcom/tencent/sqshow/zootopia/aigc/view/SuitPagView;", "promptRelateBg", BdhLogUtil.LogTag.Tag_Req, "Xi", "()Landroid/widget/ImageView;", "promptRelateBgPng", "Lbe3/p;", ExifInterface.LATITUDE_SOUTH, "Lbe3/p;", "whiteModelAdapter", "Lbe3/j;", "T", "Lbe3/j;", "imageryAdapter", "U", "Z", "isPreviewShowed", "V", "isAdded2", "Lzd3/a;", "W", "Lzd3/a;", "dtReporter", "Landroid/graphics/drawable/Drawable;", "X", "Landroid/graphics/drawable/Drawable;", "bgShadowDrawable", "Y", "Landroid/graphics/Bitmap;", "Yi", "()Landroid/graphics/Bitmap;", "bk", "(Landroid/graphics/Bitmap;)V", "selectPromptBitmap", "Landroid/view/View;", "parentview", "a0", "whiteModelAnimating", "Landroidx/recyclerview/widget/RecyclerView;", "b0", "fj", "()Landroidx/recyclerview/widget/RecyclerView;", "whiteModelList", "c0", "Ti", "imageryList", "Landroid/widget/ViewAnimator;", "d0", "aj", "()Landroid/widget/ViewAnimator;", "subSwitcher", "e0", "Zi", "sourceFly", "f0", "cj", "targetTopFly", "g0", "getTargetCenterFly", "targetCenterFly", "h0", "gj", "whiteModelTitle", "i0", "Ui", "imageryTitle", "Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic;", "j0", "Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic;", "Mi", "()Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic;", "setCreatedClothLogic", "(Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic;)V", "createdClothLogic", "k0", "Ljava/lang/Boolean;", "getFirstInit", "()Ljava/lang/Boolean;", "setFirstInit", "(Ljava/lang/Boolean;)V", "firstInit", "l0", "Ljava/util/List;", "parts", "m0", "Ljava/util/ArrayList;", "Pi", "()Ljava/util/ArrayList;", "setCurrentRenderTasks", "(Ljava/util/ArrayList;)V", "currentRenderTasks", "n0", "tempCurrentAIGCImageUrls", "Lyd3/d;", "o0", "Lyd3/d;", "customPromptInputPart", "", "p0", "Ljava/lang/Float;", "spellClothOriginX", "q0", "spellClothOriginY", "r0", "whiteModelIsAnimating", "s0", "ImageryDispearIsAnimating", "t0", "Lcom/tencent/mobileqq/zplan/aigc/data/i;", "currentImagery", "Landroid/animation/AnimatorSet;", "u0", "Landroid/animation/AnimatorSet;", "clothAnimatorSet", "v0", "whiteModelPressAnimatorSet", "w0", "needRefreshUGCId", "x0", "isJumped", "y0", "getLastTimeToast", "()J", "setLastTimeToast", "(J)V", "lastTimeToast", "z0", "getLastTimeCreateReport", "setLastTimeCreateReport", "lastTimeCreateReport", "A0", "getDefaultInterval", "()I", "defaultInterval", "B0", "lastClickTime", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "C0", "Lkotlin/jvm/functions/Function2;", "onWhiteItemClick", "whiteModelBitmap", "D0", "whiteModelBitmapLoadCallback", "Lkotlin/Function3;", "promotImageView", "E0", "Lkotlin/jvm/functions/Function3;", "onItemImageryClick", "<init>", "()V", "F0", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SuitCreateFragmentV2 extends ImmersivePartFragment implements SimpleEventReceiver<SimpleBaseEvent>, SuitParentFragment.b {

    /* renamed from: A0, reason: from kotlin metadata */
    private final int defaultInterval;

    /* renamed from: B0, reason: from kotlin metadata */
    private long lastClickTime;

    /* renamed from: C */
    private final Lazy activityVm;

    /* renamed from: C0, reason: from kotlin metadata */
    private final Function2<SuitWhiteModelItem, Integer, Unit> onWhiteItemClick;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy vm;

    /* renamed from: D0, reason: from kotlin metadata */
    private final Function2<Bitmap, Integer, Unit> whiteModelBitmapLoadCallback;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy createdPromptText;

    /* renamed from: E0, reason: from kotlin metadata */
    private final Function3<Imagery, ImageView, Integer, Unit> onItemImageryClick;

    /* renamed from: F */
    private final Lazy createdHint;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy customizeLayout;

    /* renamed from: H, reason: from kotlin metadata */
    private final Lazy createShowCustomize;

    /* renamed from: I, reason: from kotlin metadata */
    private final Lazy createButton;

    /* renamed from: J, reason: from kotlin metadata */
    private final Lazy tvCustomize;

    /* renamed from: K, reason: from kotlin metadata */
    private final Lazy filamentBg;

    /* renamed from: L, reason: from kotlin metadata */
    private final Lazy filamentContainer;

    /* renamed from: M, reason: from kotlin metadata */
    private final Lazy aigcMoreBtn;

    /* renamed from: N, reason: from kotlin metadata */
    private final Lazy loadingView;

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy suitContentView;

    /* renamed from: Q */
    private final Lazy promptRelateBg;

    /* renamed from: R */
    private final Lazy promptRelateBgPng;

    /* renamed from: S */
    private be3.p whiteModelAdapter;

    /* renamed from: T, reason: from kotlin metadata */
    private be3.j imageryAdapter;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isPreviewShowed;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isAdded2;

    /* renamed from: W, reason: from kotlin metadata */
    private zd3.a dtReporter;

    /* renamed from: X, reason: from kotlin metadata */
    private Drawable bgShadowDrawable;

    /* renamed from: Y, reason: from kotlin metadata */
    private Bitmap selectPromptBitmap;

    /* renamed from: Z, reason: from kotlin metadata */
    private View parentview;

    /* renamed from: a0, reason: from kotlin metadata */
    private boolean whiteModelAnimating;

    /* renamed from: b0, reason: from kotlin metadata */
    private final Lazy whiteModelList;

    /* renamed from: c0, reason: from kotlin metadata */
    private final Lazy imageryList;

    /* renamed from: d0, reason: from kotlin metadata */
    private final Lazy subSwitcher;

    /* renamed from: e0, reason: from kotlin metadata */
    private final Lazy sourceFly;

    /* renamed from: f0, reason: from kotlin metadata */
    private final Lazy targetTopFly;

    /* renamed from: g0, reason: from kotlin metadata */
    private final Lazy targetCenterFly;

    /* renamed from: h0, reason: from kotlin metadata */
    private final Lazy whiteModelTitle;

    /* renamed from: i0, reason: from kotlin metadata */
    private final Lazy imageryTitle;

    /* renamed from: j0, reason: from kotlin metadata */
    private CreatedClothShowLogic createdClothLogic;

    /* renamed from: k0, reason: from kotlin metadata */
    private Boolean firstInit;

    /* renamed from: l0, reason: from kotlin metadata */
    private final List<yd3.e> parts;

    /* renamed from: m0, reason: from kotlin metadata */
    private ArrayList<AIGCModelRenderTask> currentRenderTasks;

    /* renamed from: n0, reason: from kotlin metadata */
    private ArrayList<String> tempCurrentAIGCImageUrls;

    /* renamed from: o0, reason: from kotlin metadata */
    private final yd3.d customPromptInputPart;

    /* renamed from: p0, reason: from kotlin metadata */
    private Float spellClothOriginX;

    /* renamed from: q0, reason: from kotlin metadata */
    private Float spellClothOriginY;

    /* renamed from: r0, reason: from kotlin metadata */
    private Boolean whiteModelIsAnimating;

    /* renamed from: s0, reason: from kotlin metadata */
    private Boolean ImageryDispearIsAnimating;

    /* renamed from: t0, reason: from kotlin metadata */
    private Imagery currentImagery;

    /* renamed from: u0, reason: from kotlin metadata */
    private AnimatorSet clothAnimatorSet;

    /* renamed from: v0, reason: from kotlin metadata */
    private AnimatorSet whiteModelPressAnimatorSet;

    /* renamed from: w0, reason: from kotlin metadata */
    private boolean needRefreshUGCId;

    /* renamed from: x0, reason: from kotlin metadata */
    private boolean isJumped;

    /* renamed from: y0, reason: from kotlin metadata */
    private long lastTimeToast;

    /* renamed from: z0, reason: from kotlin metadata */
    private long lastTimeCreateReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$d", "Lcom/tencent/mobileqq/zplan/aigc/render/g;", "", "resourcePath", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.zplan.aigc.render.g {

        /* renamed from: b */
        final /* synthetic */ AIGCModelRenderTask f329896b;

        d(AIGCModelRenderTask aIGCModelRenderTask) {
            this.f329896b = aIGCModelRenderTask;
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void a(String resourcePath) {
            Intrinsics.checkNotNullParameter(resourcePath, "resourcePath");
            SuitCreateTechFragmentViewModel ej5 = SuitCreateFragmentV2.this.ej();
            AigcPreviewParams.Companion companion = AigcPreviewParams.INSTANCE;
            SuitWhiteModelItem selectedWhiteModelItem = SuitCreateFragmentV2.this.ej().getSelectedWhiteModelItem();
            uv4.bn data = selectedWhiteModelItem != null ? selectedWhiteModelItem.getData() : null;
            Intrinsics.checkNotNull(data);
            uv4.az azVar = data.f440382g;
            Intrinsics.checkNotNullExpressionValue(azVar, "vm.selectedWhiteModelItem?.data!!.storeItemInfo");
            SuitWhiteModelItem selectedWhiteModelItem2 = SuitCreateFragmentV2.this.ej().getSelectedWhiteModelItem();
            ej5.l3(companion.a(resourcePath, azVar, new ExtraReportParams(TipsElementData.DEFAULT_COLOR, String.valueOf(selectedWhiteModelItem2 != null ? selectedWhiteModelItem2.getItemId() : null), null, 0L, 12, null)));
            long currentTimeMillis = System.currentTimeMillis() - SuitCreateFragmentV2.this.ej().getPerformanceTimeStamp();
            SuitCreateFragmentV2.this.ej().y3(System.currentTimeMillis());
            SuitCreateFragmentV2.this.ej().z3(this.f329896b.getPatternImage().getPrompt());
            QLog.i("aigc_performance", 1, "{performance} generate preview resource time(ms): " + currentTimeMillis);
            SuitCreateFragmentV2.this.isJumped = true;
            Fragment parentFragment = SuitCreateFragmentV2.this.getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
            ((SuitParentFragment) parentFragment).Yi();
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void b(int i3) {
            g.a.e(this, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void c(boolean z16) {
            g.a.f(this, z16);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void d(String str) {
            g.a.c(this, str);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void e(boolean z16, AIGCWhiteModel aIGCWhiteModel) {
            g.a.g(this, z16, aIGCWhiteModel);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void f(int i3) {
            g.a.a(this, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.render.g
        public void onScreenShotResult(Bitmap bitmap) {
            g.a.d(this, bitmap);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$e", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            SuitCreateFragmentV2.this.Ni().setVisibility(8);
            SuitCreateFragmentV2.this.Qi().setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            if (SuitCreateFragmentV2.this.getCreatedClothLogic() != null) {
                SuitCreateFragmentV2 suitCreateFragmentV2 = SuitCreateFragmentV2.this;
                CreatedClothShowLogic createdClothLogic = suitCreateFragmentV2.getCreatedClothLogic();
                Intrinsics.checkNotNull(createdClothLogic);
                AIGCModelRenderTask selectedPatternTask = createdClothLogic.getSelectedPatternTask();
                Intrinsics.checkNotNull(selectedPatternTask);
                suitCreateFragmentV2.Ai(selectedPatternTask);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$f", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            QLog.e("SuitCreateFragmentV2", 1, "translationXYAnimator cancel  ~~~~");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QLog.e("SuitCreateFragmentV2", 1, "translationXYAnimator end  ~~~~");
            SuitCreateFragmentV2.this.whiteModelAnimating = false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$g", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g extends AnimatorListenerAdapter {

        /* renamed from: e */
        final /* synthetic */ Imagery f329900e;

        g(Imagery imagery) {
            this.f329900e = imagery;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QLog.e("SuitCreateFragmentV2", 1, "imageryDispearAnimation end  ~~~~");
            SuitCreateFragmentV2.this.Ti().setVisibility(8);
            SuitCreateFragmentV2.this.Zi().setVisibility(8);
            SuitCreateFragmentV2.this.ek(this.f329900e, true, true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$h", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class h extends AnimatorListenerAdapter {

        /* renamed from: e */
        final /* synthetic */ Imagery f329902e;

        h(Imagery imagery) {
            this.f329902e = imagery;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QLog.e("SuitCreateFragmentV2", 1, "pressDisapearAnimator end  ~~~~");
            SuitCreateFragmentV2.this.ImageryDispearIsAnimating = Boolean.FALSE;
            String description = this.f329902e.getDescription();
            if (description != null) {
                SuitCreateFragmentV2.this.Uj(true, description);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            QLog.e("SuitCreateFragmentV2", 1, "pressDisapearAnimator cancel  ~~~~");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$i", "Lcom/tencent/mobileqq/zplan/aigc/view/SuitCreateLoadingView$b;", "", "onRetry", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class i implements SuitCreateLoadingView.b {
        i() {
        }

        @Override // com.tencent.mobileqq.zplan.aigc.view.SuitCreateLoadingView.b
        public void onRetry() {
            SuitCreateTechFragmentViewModel.c3(SuitCreateFragmentV2.this.ej(), null, 1, null);
            SuitCreateFragmentV2.this.ej().h2();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$j", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class j extends RecyclerView.OnScrollListener {
        j() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traversePage(recyclerView);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$k", "Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic$b;", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class k implements CreatedClothShowLogic.b {

        /* renamed from: b */
        final /* synthetic */ b f329905b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$k$a", "Lcom/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$b;", "", "ugcId", "", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements b {

            /* renamed from: a */
            final /* synthetic */ SuitCreateFragmentV2 f329906a;

            /* renamed from: b */
            final /* synthetic */ b f329907b;

            a(SuitCreateFragmentV2 suitCreateFragmentV2, b bVar) {
                this.f329906a = suitCreateFragmentV2;
                this.f329907b = bVar;
            }

            public static final void d(int i3, SuitCreateFragmentV2 this$0, long j3, b bVar) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (i3 == 0) {
                    this$0.needRefreshUGCId = false;
                    QLog.i("SuitCreateFragmentV2", 1, "processSinglePreviewTask refresh ugcid " + j3 + " ");
                    this$0.ej().G3(j3);
                    this$0.nk(j3);
                }
                if (bVar != null) {
                    bVar.b(i3);
                }
            }

            @Override // com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2.b
            public void a(final long ugcId, final int result) {
                Handler mainHandler = this.f329906a.getMainHandler();
                final SuitCreateFragmentV2 suitCreateFragmentV2 = this.f329906a;
                final b bVar = this.f329907b;
                mainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        SuitCreateFragmentV2.k.a.d(result, suitCreateFragmentV2, ugcId, bVar);
                    }
                });
            }

            @Override // com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2.b
            public void b(int i3) {
                b.a.a(this, i3);
            }
        }

        k(b bVar) {
            this.f329905b = bVar;
        }

        @Override // com.tencent.mobileqq.zplan.aigc.logic.CreatedClothShowLogic.b
        public void a() {
            SuitCreateFragmentV2 suitCreateFragmentV2 = SuitCreateFragmentV2.this;
            suitCreateFragmentV2.yi(new a(suitCreateFragmentV2, this.f329905b));
        }

        @Override // com.tencent.mobileqq.zplan.aigc.logic.CreatedClothShowLogic.b
        public void b(AIGCModelRenderTask aIGCModelRenderTask) {
            CreatedClothShowLogic.b.a.c(this, aIGCModelRenderTask);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.logic.CreatedClothShowLogic.b
        public void c(AIGCModelRenderTask aIGCModelRenderTask, int i3) {
            CreatedClothShowLogic.b.a.b(this, aIGCModelRenderTask, i3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$l", "Lcom/tencent/mobileqq/zplan/aigc/logic/CreatedClothShowLogic$b;", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "renderTask", "", "b", "", "resCode", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class l implements CreatedClothShowLogic.b {
        l() {
        }

        @Override // com.tencent.mobileqq.zplan.aigc.logic.CreatedClothShowLogic.b
        public void a() {
            CreatedClothShowLogic.b.a.a(this);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.logic.CreatedClothShowLogic.b
        public void b(AIGCModelRenderTask renderTask) {
            Intrinsics.checkNotNullParameter(renderTask, "renderTask");
            SuitCreateFragmentV2.this.hk(renderTask);
            SuitCreateFragmentV2.this.jk();
            SuitCreateFragmentV2.this.Kj(renderTask);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.logic.CreatedClothShowLogic.b
        public void c(AIGCModelRenderTask renderTask, int resCode) {
            Intrinsics.checkNotNullParameter(renderTask, "renderTask");
            SuitCreateFragmentV2.this.Aj(renderTask, resCode);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$n", "Lcom/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$b;", "", "result", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class n implements b {
        n() {
        }

        @Override // com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2.b
        public void a(long j3, int i3) {
            b.a.b(this, j3, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2.b
        public void b(int result) {
            QLog.i("SuitCreateFragmentV2", 1, "onPrepareDone " + result);
            if (result == 0) {
                SuitCreateFragmentV2.this.Hj();
                return;
            }
            SuitCreateFragmentV2 suitCreateFragmentV2 = SuitCreateFragmentV2.this;
            suitCreateFragmentV2.mk(suitCreateFragmentV2.Pi());
            SuitCreateFragmentV2.this.yj();
            SuitCreateFragmentV2.this.jk();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$o", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "", "isReverse", "onAnimationStart", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class o extends AnimatorListenerAdapter {

        /* renamed from: e */
        final /* synthetic */ SuitWhiteModelItem f329912e;

        o(SuitWhiteModelItem suitWhiteModelItem) {
            this.f329912e = suitWhiteModelItem;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation, boolean isReverse) {
            super.onAnimationStart(animation, isReverse);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QLog.e("SuitCreateFragmentV2", 1, "whiteModelDispearAnimation End  ~~~~");
            SuitCreateFragmentV2.this.fj().setVisibility(8);
            SuitCreateFragmentV2.this.vi(this.f329912e);
            SuitCreateFragmentV2.this.whiteModelIsAnimating = Boolean.FALSE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$p", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class p extends AnimatorListenerAdapter {

        /* renamed from: e */
        final /* synthetic */ int f329914e;

        /* renamed from: f */
        final /* synthetic */ SuitWhiteModelItem f329915f;

        p(int i3, SuitWhiteModelItem suitWhiteModelItem) {
            this.f329914e = i3;
            this.f329915f = suitWhiteModelItem;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            QLog.e("SuitCreateFragmentV2", 1, "whiteModelPressAnimation End  ~~~~");
            SuitCreateFragmentV2.this.qk(this.f329914e, this.f329915f);
        }
    }

    public SuitCreateFragmentV2() {
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
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zplan.aigc.vm.a>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$activityVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.zplan.aigc.vm.a invoke() {
                ViewModel viewModel = new ViewModelProvider(SuitCreateFragmentV2.this.requireActivity()).get(com.tencent.mobileqq.zplan.aigc.vm.a.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026ityViewModel::class.java)");
                return (com.tencent.mobileqq.zplan.aigc.vm.a) viewModel;
            }
        });
        this.activityVm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<SuitCreateTechFragmentViewModel>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitCreateTechFragmentViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(SuitCreateFragmentV2.this.requireParentFragment()).get(SuitCreateTechFragmentViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026entViewModel::class.java)");
                return (SuitCreateTechFragmentViewModel) viewModel;
            }
        });
        this.vm = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$createdPromptText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.qec);
            }
        });
        this.createdPromptText = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$createdHint$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.pzh);
            }
        });
        this.createdHint = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$customizeLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConstraintLayout invoke() {
                return (ConstraintLayout) SuitCreateFragmentV2.this.requireView().findViewById(R.id.pm9);
            }
        });
        this.customizeLayout = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$createShowCustomize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConstraintLayout invoke() {
                return (ConstraintLayout) SuitCreateFragmentV2.this.requireView().findViewById(R.id.p_w);
            }
        });
        this.createShowCustomize = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$createButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.q0l);
            }
        });
        this.createButton = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<MarqueeTextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$tvCustomize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MarqueeTextView invoke() {
                return (MarqueeTextView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.qub);
            }
        });
        this.tvCustomize = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<AigcWatermarkView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$filamentBg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AigcWatermarkView invoke() {
                return (AigcWatermarkView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.pty);
            }
        });
        this.filamentBg = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<AIGCViewPagerWithIndicator>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$filamentContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AIGCViewPagerWithIndicator invoke() {
                return (AIGCViewPagerWithIndicator) SuitCreateFragmentV2.this.requireView().findViewById(R.id.ptz);
            }
        });
        this.filamentContainer = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$aigcMoreBtn$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout invoke() {
                return (FrameLayout) SuitCreateFragmentV2.this.requireView().findViewById(R.id.p_k);
            }
        });
        this.aigcMoreBtn = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<SuitCreateLoadingView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$loadingView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitCreateLoadingView invoke() {
                return (SuitCreateLoadingView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.qod);
            }
        });
        this.loadingView = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$suitContentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return SuitCreateFragmentV2.this.requireView().findViewById(R.id.qoe);
            }
        });
        this.suitContentView = lazy13;
        lazy14 = LazyKt__LazyJVMKt.lazy(new Function0<SuitPagView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$promptRelateBg$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SuitPagView invoke() {
                return (SuitPagView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.qee);
            }
        });
        this.promptRelateBg = lazy14;
        lazy15 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$promptRelateBgPng$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.qed);
            }
        });
        this.promptRelateBgPng = lazy15;
        lazy16 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$whiteModelList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return (RecyclerView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.qyw);
            }
        });
        this.whiteModelList = lazy16;
        lazy17 = LazyKt__LazyJVMKt.lazy(new Function0<RecyclerView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$imageryList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RecyclerView invoke() {
                return (RecyclerView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.q1i);
            }
        });
        this.imageryList = lazy17;
        lazy18 = LazyKt__LazyJVMKt.lazy(new Function0<ViewAnimator>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$subSwitcher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewAnimator invoke() {
                return (ViewAnimator) SuitCreateFragmentV2.this.requireView().findViewById(R.id.qo_);
            }
        });
        this.subSwitcher = lazy18;
        lazy19 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$sourceFly$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.q_b);
            }
        });
        this.sourceFly = lazy19;
        lazy20 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$targetTopFly$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.qpi);
            }
        });
        this.targetTopFly = lazy20;
        lazy21 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$targetCenterFly$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.qph);
            }
        });
        this.targetCenterFly = lazy21;
        lazy22 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$whiteModelTitle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.qum);
            }
        });
        this.whiteModelTitle = lazy22;
        lazy23 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$imageryTitle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                return (TextView) SuitCreateFragmentV2.this.requireView().findViewById(R.id.qtn);
            }
        });
        this.imageryTitle = lazy23;
        Boolean bool = Boolean.FALSE;
        this.firstInit = bool;
        this.parts = new ArrayList();
        this.currentRenderTasks = new ArrayList<>();
        this.tempCurrentAIGCImageUrls = new ArrayList<>();
        this.customPromptInputPart = new yd3.d();
        this.whiteModelIsAnimating = bool;
        this.ImageryDispearIsAnimating = bool;
        this.needRefreshUGCId = true;
        this.defaultInterval = 1000;
        this.onWhiteItemClick = new Function2<SuitWhiteModelItem, Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$onWhiteItemClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(SuitWhiteModelItem suitWhiteModelItem, Integer num) {
                invoke(suitWhiteModelItem, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(SuitWhiteModelItem item, int i3) {
                long j3;
                boolean z16;
                Intrinsics.checkNotNullParameter(item, "item");
                long currentTimeMillis = System.currentTimeMillis();
                j3 = SuitCreateFragmentV2.this.lastClickTime;
                if (currentTimeMillis - j3 >= 1000) {
                    z16 = SuitCreateFragmentV2.this.whiteModelAnimating;
                    if (!z16) {
                        SuitCreateFragmentV2.this.ej().E3(item);
                        SuitCreateFragmentV2.this.ej().o3(Integer.parseInt(item.getItemId()));
                        QLog.d("SuitCreateFragmentV2", 1, "onWhiteItemClick ");
                        if (SuitCreateFragmentV2.this.ej().J2().getValue() != null) {
                            Long value = SuitCreateFragmentV2.this.ej().J2().getValue();
                            Intrinsics.checkNotNull(value);
                            if (value.longValue() < 1) {
                                Context context = SuitCreateFragmentV2.this.getContext();
                                if (context != null) {
                                    Fragment parentFragment = SuitCreateFragmentV2.this.getParentFragment();
                                    Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                                    String string = context.getResources().getString(R.string.xkp);
                                    Intrinsics.checkNotNullExpressionValue(string, "it1.resources.getString(\u2026lan_aigc_ticket_as_title)");
                                    ((SuitParentFragment) parentFragment).Ri(context, string);
                                    return;
                                }
                                return;
                            }
                        }
                        SuitCreateFragmentV2.this.whiteModelAnimating = true;
                        SuitCreateFragmentV2.this.sk(i3, item);
                        return;
                    }
                    QLog.e("SuitCreateFragmentV2", 1, " whiteModelAnimating ");
                    return;
                }
                QLog.i("SuitCreateFragmentV2", 1, "not click too much");
                SuitCreateFragmentV2.this.lastClickTime = currentTimeMillis;
            }
        };
        this.whiteModelBitmapLoadCallback = new Function2<Bitmap, Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$whiteModelBitmapLoadCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Integer num) {
                invoke(bitmap, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Bitmap bitmap, int i3) {
                Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                SuitCreateFragmentV2.this.ej().y2().put(Integer.valueOf(i3), bitmap);
            }
        };
        this.onItemImageryClick = new Function3<Imagery, ImageView, Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$onItemImageryClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Imagery imagery, ImageView imageView, Integer num) {
                invoke(imagery, imageView, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Imagery imagery, ImageView imageView, int i3) {
                Intrinsics.checkNotNullParameter(imagery, "imagery");
                QLog.d("SuitCreateFragmentV2", 1, "onItemImageryClick " + imagery.getSelectItemID());
                if (SuitCreateFragmentV2.this.ej().J2().getValue() != null) {
                    Long value = SuitCreateFragmentV2.this.ej().J2().getValue();
                    Intrinsics.checkNotNull(value);
                    if (value.longValue() < 1) {
                        QLog.i("SuitCreateFragmentV2", 1, "onItemImageryClick ticketNum is not much");
                        Context context = SuitCreateFragmentV2.this.getContext();
                        if (context != null) {
                            Fragment parentFragment = SuitCreateFragmentV2.this.getParentFragment();
                            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                            String string = context.getResources().getString(R.string.xkp);
                            Intrinsics.checkNotNullExpressionValue(string, "it1.resources.getString(\u2026lan_aigc_ticket_as_title)");
                            ((SuitParentFragment) parentFragment).Ri(context, string);
                            return;
                        }
                        return;
                    }
                }
                if (imagery.getId() != 0 && i3 != -1) {
                    SuitCreateFragmentV2.this.ok(imageView);
                } else if (imagery.getId() == 0) {
                    SuitCreateFragmentV2.this.bk(null);
                }
                SuitCreateFragmentV2.this.ej().D3(imagery);
                SuitCreateFragmentV2 suitCreateFragmentV2 = SuitCreateFragmentV2.this;
                suitCreateFragmentV2.lk(suitCreateFragmentV2.getSelectPromptBitmap());
                SuitCreateFragmentV2.this.ij(imagery, imageView, i3);
            }
        };
    }

    public final void Ai(AIGCModelRenderTask renderTask) {
        ej().y3(System.currentTimeMillis());
        CreatedClothShowLogic createdClothShowLogic = this.createdClothLogic;
        Intrinsics.checkNotNull(createdClothShowLogic);
        createdClothShowLogic.c(renderTask, new d(renderTask));
    }

    public final void Aj(final AIGCModelRenderTask renderTask, int resCode) {
        String str;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("AIGC_ENTRY_SOURCE")) == null) {
            str = "";
        }
        int v26 = ej().v2();
        if (resCode == -111) {
            fk(1, R.string.f169787xl4);
            Rj(str, v26, "em_zplan_net_error_toast");
            PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$processCreatingError$3
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
                    AIGCModelRenderTask.this.o(TASK_STATUS.TASK_STATUS_ERROR_IMG_NETWORK);
                    this.yj();
                }
            });
            return;
        }
        if (resCode == 26066) {
            fk(1, R.string.f169786xl3);
            return;
        }
        if (resCode == 26068) {
            Rj(str, v26, "em_zplan_upper_limit_toast");
            fk(1, R.string.f169785xl2);
            PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$processCreatingError$2
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
                    AIGCModelRenderTask.this.o(TASK_STATUS.TASK_STATUS_ERROR_PROMPT_FORBIDDEN);
                    this.uj();
                }
            });
        } else if (resCode != 26071) {
            Rj(str, v26, "em_zplan_net_error_toast");
            fk(1, R.string.f169787xl4);
            PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$processCreatingError$4
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
                    AIGCModelRenderTask.this.o(TASK_STATUS.TASK_STATUS_ERROR_IMG_NETWORK);
                    this.yj();
                }
            });
        } else {
            fk(1, R.string.f169784xl1);
            Rj(str, v26, "em_zplan_ops_tips_toast");
            PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$processCreatingError$1
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
                    AIGCModelRenderTask.this.o(TASK_STATUS.TASK_STATUS_ERROR_PROMPT_FORBIDDEN);
                    this.xj();
                }
            });
        }
    }

    private final void Bh() {
        Ui().setAlpha(0.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(Ui(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(imageryTitle, \"alpha\", ALPHA_OPAQUE)");
        ofFloat.setDuration(500L);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154377jy);
        loadAnimation.setInterpolator(new DecelerateInterpolator());
        xd3.b bVar = new xd3.b(requireContext(), loadAnimation);
        bVar.getAnimation().setDuration(500L);
        Ti().setLayoutAnimation(bVar);
        Ti().scheduleLayoutAnimation();
        ofFloat.start();
    }

    public final void Bi() {
        Mj();
        xd3.a.f447833a.a(new View[]{Qi(), Ni(), Ji(), Si(), Oi()}, 300L, false, new e());
    }

    public final void Bj(AIGCModelRenderTask renderTask) {
        if (this.currentImagery == null || ej().getSelectedWhiteModelItem() == null) {
            return;
        }
        QLog.i("SuitCreateFragmentV2", 1, "processSinglePreviewTask : " + renderTask.getId() + ", " + renderTask.getUgcID() + ", " + renderTask.getPatternImage().getUgcID());
        CreatedClothShowLogic createdClothShowLogic = this.createdClothLogic;
        if (createdClothShowLogic != null) {
            long ugcID = renderTask.getPatternImage().getUgcID();
            SuitWhiteModelItem selectedWhiteModelItem = ej().getSelectedWhiteModelItem();
            Intrinsics.checkNotNull(selectedWhiteModelItem);
            createdClothShowLogic.r(renderTask, ugcID, selectedWhiteModelItem.getAigcWhiteModel(), new l());
        }
    }

    private final void Ci() {
        xd3.a.f447833a.a(new View[]{Qi(), Ni(), Si(), Oi(), Xi()}, 300L, true, null);
    }

    private final void Di(int position) {
        QLog.i("SuitCreateFragmentV2", 1, "dealFlyAnimation");
        ej().C3(ej().y2().get(Integer.valueOf(position)));
        if (ej().getSelectBitmap() == null) {
            QLog.i("SuitCreateFragmentV2", 1, "vm.selectBitmap is null can not fly");
        } else {
            Fi(position);
            Gi(Zi());
        }
    }

    private final void Ei(SuitWhiteModelItem r95) {
        ArrayList<Imagery> i06;
        ArrayList<Imagery> i07;
        synchronized (ej().x2()) {
            RecyclerView.Adapter adapter = Ti().getAdapter();
            be3.j jVar = adapter instanceof be3.j ? (be3.j) adapter : null;
            if (jVar != null && (i07 = jVar.i0()) != null) {
                i07.clear();
            }
            ArrayList<Imagery> arrayList = ej().x2().get(r95.getItemId());
            QLog.i("SuitCreateFragmentV2", 1, "dealSpellData  imagerys " + (arrayList != null ? Integer.valueOf(arrayList.size()) : null));
            if ((arrayList != null ? Integer.valueOf(arrayList.size()) : null) != null && arrayList.size() != 0 && arrayList.size() % 2 != 0) {
                arrayList.remove(arrayList.size() - 1);
            }
            QLog.i("SuitCreateFragmentV2", 1, "dealSpellData  imagerys filterIndexed " + (arrayList != null ? Integer.valueOf(arrayList.size()) : null));
            if (arrayList != null) {
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Imagery) it.next()).h(r95.getItemId());
                }
                RecyclerView.Adapter adapter2 = Ti().getAdapter();
                be3.j jVar2 = adapter2 instanceof be3.j ? (be3.j) adapter2 : null;
                if (jVar2 != null && (i06 = jVar2.i0()) != null) {
                    i06.addAll(arrayList);
                }
            }
            RecyclerView.Adapter adapter3 = Ti().getAdapter();
            if (adapter3 != null) {
                adapter3.notifyDataSetChanged();
            }
            Bh();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void Fi(int position) {
        RecyclerView.LayoutManager layoutManager = fj().getLayoutManager();
        View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(position) : null;
        ImageView imageView = findViewByPosition != null ? (ImageView) findViewByPosition.findViewById(R.id.q2x) : null;
        int[] iArr = new int[2];
        if (findViewByPosition != null) {
            findViewByPosition.getLocationInWindow(iArr);
        }
        int i3 = iArr[0];
        int i16 = iArr[1];
        Intrinsics.checkNotNull(findViewByPosition);
        findViewByPosition.getLocationInWindow(new int[2]);
        ViewGroup.LayoutParams layoutParams = Zi().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = i16;
        marginLayoutParams.leftMargin = i3 + ImmersiveUtils.dpToPx(11.0f);
        Zi().setImageBitmap(ej().getSelectBitmap());
        Zi().setLayoutParams(marginLayoutParams);
        Zi().setVisibility(0);
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    private final void Gi(final View view) {
        Zi().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.k
            @Override // java.lang.Runnable
            public final void run() {
                SuitCreateFragmentV2.Hi(SuitCreateFragmentV2.this, view);
            }
        });
    }

    public static final void Hi(SuitCreateFragmentV2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        this$0.cj().getLocationInWindow(new int[2]);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat("translationX", r1[0] - this$0.Zi().getX()), PropertyValuesHolder.ofFloat("translationY", r1[1] - this$0.Zi().getY()));
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder, "ofPropertyValuesHolder(\n\u2026ourceFly.y)\n            )");
        ofPropertyValuesHolder.addListener(new f());
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_X, 1.1f), PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_Y, 1.1f));
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder2, "ofPropertyValuesHolder(\n\u2026leY\", 1.1f)\n            )");
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_X, 0.88f), PropertyValuesHolder.ofFloat(BasicAnimation.KeyPath.SCALE_Y, 0.88f));
        Intrinsics.checkNotNullExpressionValue(ofPropertyValuesHolder3, "ofPropertyValuesHolder(\n\u2026eY\", 0.88f)\n            )");
        ofPropertyValuesHolder.setDuration(960L);
        ofPropertyValuesHolder.setInterpolator(new DecelerateInterpolator());
        ofPropertyValuesHolder2.setDuration(360L);
        ofPropertyValuesHolder3.setDuration(600L);
        AnimatorSet animatorSet = new AnimatorSet();
        this$0.clothAnimatorSet = animatorSet;
        animatorSet.playSequentially(ofPropertyValuesHolder2, ofPropertyValuesHolder3);
        animatorSet.playTogether(ofPropertyValuesHolder);
        animatorSet.playTogether(this$0.Vi().f());
        animatorSet.start();
    }

    public final void Hj() {
        int i3 = 0;
        for (Object obj : this.currentRenderTasks) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Bj((AIGCModelRenderTask) obj);
            i3 = i16;
        }
    }

    public final void Ij(AIGCModelRenderTask renderTask) {
        int i3 = 0;
        for (Object obj : Si().d()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            View view = (View) obj;
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager.CustomGridAdapter.MyViewHolder");
            if (((AIGCGridViewPager.b.C9138b) tag).getModelID() == renderTask.getId()) {
                Map<String, Object> x16 = AIGCHelper.f330685a.x(renderTask);
                x16.put("zplan_clothes_pos", Integer.valueOf(i3));
                zd3.a aVar = this.dtReporter;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                    aVar = null;
                }
                aVar.t(view, "em_zplan_clothes_result", x16);
            }
            i3 = i16;
        }
    }

    private final FrameLayout Ji() {
        Object value = this.aigcMoreBtn.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-aigcMoreBtn>(...)");
        return (FrameLayout) value;
    }

    private final void Jj() {
        int childCount = Ti().getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = Ti().getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "imageryList.getChildAt(i)");
            RecyclerView.ViewHolder childViewHolder = Ti().getChildViewHolder(childAt);
            Intrinsics.checkNotNullExpressionValue(childViewHolder, "imageryList.getChildViewHolder(child)");
            zd3.a aVar = this.dtReporter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                aVar = null;
            }
            View view = childViewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
            zd3.a.A(aVar, view, "em_zplan_keywords", null, 4, null);
        }
    }

    private final TextView Ki() {
        Object value = this.createButton.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-createButton>(...)");
        return (TextView) value;
    }

    public final void Kj(AIGCModelRenderTask renderTask) {
        int i3 = 0;
        for (Object obj : Si().d()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            View view = (View) obj;
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager.CustomGridAdapter.MyViewHolder");
            if (((AIGCGridViewPager.b.C9138b) tag).getModelID() == renderTask.getId()) {
                Map<String, Object> x16 = AIGCHelper.f330685a.x(renderTask);
                x16.put("zplan_clothes_pos", Integer.valueOf(i3));
                zd3.a aVar = this.dtReporter;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                    aVar = null;
                }
                zd3.a.y(aVar, view, "em_zplan_clothes_result", x16, null, 8, null);
            }
            i3 = i16;
        }
    }

    private final ConstraintLayout Li() {
        Object value = this.createShowCustomize.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-createShowCustomize>(...)");
        return (ConstraintLayout) value;
    }

    private final void Mj() {
        int i3 = 0;
        for (Object obj : Si().d()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            View view = (View) obj;
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager.CustomGridAdapter.MyViewHolder");
            Map<String, Object> i17 = ((AIGCGridViewPager.b.C9138b) tag).i();
            zd3.a aVar = this.dtReporter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                aVar = null;
            }
            aVar.z(view, "em_zplan_clothes_result", i17);
            i3 = i16;
        }
    }

    public final TextView Ni() {
        Object value = this.createdHint.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-createdHint>(...)");
        return (TextView) value;
    }

    private final TextView Oi() {
        Object value = this.createdPromptText.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-createdPromptText>(...)");
        return (TextView) value;
    }

    private final void Oj() {
        zd3.a aVar;
        zd3.a aVar2;
        int displayedChild = aj().getDisplayedChild();
        if (displayedChild == 0) {
            Qj();
        }
        if (displayedChild == 1) {
            Jj();
            zd3.a aVar3 = this.dtReporter;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                aVar2 = null;
            } else {
                aVar2 = aVar3;
            }
            zd3.a.A(aVar2, Li(), "em_zplan_input_btn", null, 4, null);
        }
        if (displayedChild == 2) {
            Mj();
            zd3.a aVar4 = this.dtReporter;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                aVar = null;
            } else {
                aVar = aVar4;
            }
            zd3.a.A(aVar, Ji(), "em_zplan_clothes_more_btn", null, 4, null);
        }
    }

    private final void Pj() {
        zd3.a aVar;
        zd3.a aVar2;
        int displayedChild = aj().getDisplayedChild();
        if (displayedChild != 0) {
            Qj();
        }
        if (displayedChild != 1) {
            Jj();
            zd3.a aVar3 = this.dtReporter;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                aVar2 = null;
            } else {
                aVar2 = aVar3;
            }
            zd3.a.A(aVar2, Li(), "em_zplan_input_btn", null, 4, null);
        }
        if (displayedChild != 2) {
            zd3.a aVar4 = this.dtReporter;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                aVar = null;
            } else {
                aVar = aVar4;
            }
            zd3.a.A(aVar, Ji(), "em_zplan_clothes_more_btn", null, 4, null);
            Mj();
        }
    }

    public final ConstraintLayout Qi() {
        Object value = this.customizeLayout.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-customizeLayout>(...)");
        return (ConstraintLayout) value;
    }

    private final void Qj() {
        int childCount = fj().getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = fj().getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "whiteModelList.getChildAt(i)");
            RecyclerView.ViewHolder childViewHolder = fj().getChildViewHolder(childAt);
            Intrinsics.checkNotNullExpressionValue(childViewHolder, "whiteModelList.getChildViewHolder(child)");
            zd3.a aVar = this.dtReporter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                aVar = null;
            }
            View view = childViewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "viewHolder.itemView");
            zd3.a.A(aVar, view, "em_zplan_model", null, 4, null);
        }
    }

    private final AigcWatermarkView Ri() {
        Object value = this.filamentBg.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-filamentBg>(...)");
        return (AigcWatermarkView) value;
    }

    private final void Rj(String entranceSource, int gender, String value) {
        if (SystemClock.elapsedRealtime() - this.lastTimeCreateReport > this.defaultInterval) {
            zd3.a aVar = this.dtReporter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                aVar = null;
            }
            aVar.g(entranceSource, gender, value);
            this.lastTimeCreateReport = SystemClock.elapsedRealtime();
        }
    }

    private final AIGCViewPagerWithIndicator Si() {
        Object value = this.filamentContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-filamentContainer>(...)");
        return (AIGCViewPagerWithIndicator) value;
    }

    public final RecyclerView Ti() {
        Object value = this.imageryList.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imageryList>(...)");
        return (RecyclerView) value;
    }

    private final TextView Ui() {
        Object value = this.imageryTitle.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imageryTitle>(...)");
        return (TextView) value;
    }

    public final SuitCreateLoadingView Vi() {
        Object value = this.loadingView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-loadingView>(...)");
        return (SuitCreateLoadingView) value;
    }

    private final SuitPagView Wi() {
        Object value = this.promptRelateBg.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-promptRelateBg>(...)");
        return (SuitPagView) value;
    }

    private final void Wj(boolean enable, String str) {
        QLog.i("SuitCreateFragmentV2", 1, "setCustomiseTextStatus");
        dj().setRightAlphaWidth(ImmersiveUtils.dpToPx(30.0f));
        dj().setTextSize(ImmersiveUtils.dpToPx(14.0f));
        dj().setText(str);
        dj().j();
        if (enable) {
            dj().setTextColor(Color.parseColor("#000000"));
        } else {
            dj().setTextColor(Color.parseColor("#A6A6A6"));
        }
    }

    private final ImageView Xi() {
        Object value = this.promptRelateBgPng.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-promptRelateBgPng>(...)");
        return (ImageView) value;
    }

    private final void Yj(boolean isJump) {
        Si().setOnItemClickListener(new m());
    }

    public final ImageView Zi() {
        Object value = this.sourceFly.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sourceFly>(...)");
        return (ImageView) value;
    }

    private final ViewAnimator aj() {
        Object value = this.subSwitcher.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-subSwitcher>(...)");
        return (ViewAnimator) value;
    }

    public final View bj() {
        Object value = this.suitContentView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-suitContentView>(...)");
        return (View) value;
    }

    private final ImageView cj() {
        Object value = this.targetTopFly.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-targetTopFly>(...)");
        return (ImageView) value;
    }

    private final MarqueeTextView dj() {
        Object value = this.tvCustomize.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvCustomize>(...)");
        return (MarqueeTextView) value;
    }

    public final SuitCreateTechFragmentViewModel ej() {
        return (SuitCreateTechFragmentViewModel) this.vm.getValue();
    }

    public final RecyclerView fj() {
        Object value = this.whiteModelList.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-whiteModelList>(...)");
        return (RecyclerView) value;
    }

    private final void fk(final int icon, final int msg2) {
        if (SystemClock.elapsedRealtime() - this.lastTimeToast > this.defaultInterval) {
            getMainHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.p
                @Override // java.lang.Runnable
                public final void run() {
                    SuitCreateFragmentV2.gk(icon, msg2);
                }
            });
            this.lastTimeToast = SystemClock.elapsedRealtime();
        }
    }

    private final TextView gj() {
        Object value = this.whiteModelTitle.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-whiteModelTitle>(...)");
        return (TextView) value;
    }

    public static final void gk(int i3, int i16) {
        QQToastUtil.showQQToast(i3, i16);
    }

    public final void hj(Imagery imagery) {
        if (aj().getDisplayedChild() == 2) {
            QLog.d("SuitCreateFragmentV2", 1, "imageryDispearAnimation" + aj().getDisplayedChild());
            ek(imagery, true, true);
            return;
        }
        lk(this.selectPromptBitmap);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(Ui(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(imageryTitle, \"alpha\", ALPHA_TRANSPARENT)");
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(Ti(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(imageryList, \"alpha\", ALPHA_TRANSPARENT)");
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(Zi(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(sourceFly, \"alpha\", ALPHA_TRANSPARENT)");
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(Vi(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat4, "ofFloat(loadingView, \"alpha\", ALPHA_TRANSPARENT)");
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(Li(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat5, "ofFloat(createShowCustom\u2026lpha\", ALPHA_TRANSPARENT)");
        ofFloat.setDuration(260L);
        ofFloat2.setDuration(260L);
        ofFloat3.setDuration(260L);
        ofFloat4.setDuration(260L);
        ofFloat5.setDuration(260L);
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5);
        ofFloat2.addListener(new g(imagery));
        animatorSet.start();
    }

    public final void hk(AIGCModelRenderTask renderTask) {
        AIGCHelper.f330685a.B(this.currentRenderTasks, renderTask);
    }

    private final void ik(ArrayList<AIGCModelRenderTask> renderTasks) {
        this.currentRenderTasks = AIGCHelper.f330685a.y(this.currentRenderTasks, renderTasks);
    }

    private final void initView() {
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        Drawable drawable = null;
        SuitParentFragment.Yh((SuitParentFragment) parentFragment, false, 1, null);
        Vi().i();
        Vi().setOnRetryListener(new i());
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable2 = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mLoadingDrawable = drawable2;
        obtain.mFailedDrawable = drawable2;
        Unit unit = Unit.INSTANCE;
        URLDrawable drawable3 = URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/zplan_aigc_v2_button_shadow_bg.png", obtain);
        Intrinsics.checkNotNullExpressionValue(drawable3, "getDrawable(\n           \u2026ANSPARENT;\n            })");
        this.bgShadowDrawable = drawable3;
        SuitCreateLoadingView Vi = Vi();
        Drawable drawable4 = this.bgShadowDrawable;
        if (drawable4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bgShadowDrawable");
        } else {
            drawable = drawable4;
        }
        Vi.setShadowDrawable(drawable);
        this.firstInit = Boolean.TRUE;
        Fragment parentFragment2 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        this.createdClothLogic = ((SuitParentFragment) parentFragment2).getCreatedClothLogic();
        if (ej().getNeedFromNewPreview()) {
            bj().setVisibility(0);
            Imagery selectImagery = ej().getSelectImagery();
            if (selectImagery != null) {
                dk(this, selectImagery, false, false, 6, null);
            }
        } else {
            sj();
            gj().setTypeface(Typeface.defaultFromStyle(1));
            aj().setDisplayedChild(2);
        }
        FrameLayout Ji = Ji();
        if (Ji != null) {
            Ji.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.o
                @Override // java.lang.Runnable
                public final void run() {
                    SuitCreateFragmentV2.mj(SuitCreateFragmentV2.this);
                }
            });
        }
        ZPlanAIGCRequest zPlanAIGCRequest = ZPlanAIGCRequest.f335341a;
        if (zPlanAIGCRequest.c()) {
            com.tencent.mobileqq.zplan.aigc.helper.h hVar = com.tencent.mobileqq.zplan.aigc.helper.h.f330325a;
            hVar.p("GetUGCTemplateInfo" + UEAvatarGender.FEMALE.getIndex(), "");
            hVar.p("GetUGCTemplateInfo" + UEAvatarGender.MALE.getIndex(), "");
            hVar.p("GetImageryDetails", "");
            zPlanAIGCRequest.s(false);
        }
    }

    private final void initViewModel() {
        MutableLiveData<Integer> o26 = ej().o2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                SuitCreateLoadingView Vi;
                if (num != null && num.intValue() == -1) {
                    Vi = SuitCreateFragmentV2.this.Vi();
                    Vi.j();
                }
            }
        };
        o26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitCreateFragmentV2.oj(Function1.this, obj);
            }
        });
        LiveData<Boolean> I2 = ej().I2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$initViewModel$2
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
                SuitCreateLoadingView Vi;
                View bj5;
                SuitCreateLoadingView Vi2;
                View bj6;
                ArrayList<SuitWhiteModelItem> i06;
                ArrayList<SuitWhiteModelItem> i07;
                if (SuitCreateFragmentV2.this.ej().getNeedFromNewPreview()) {
                    return;
                }
                QLog.i("SuitCreateFragmentV2", 1, " successEvent " + success);
                Intrinsics.checkNotNullExpressionValue(success, "success");
                if (success.booleanValue()) {
                    Vi2 = SuitCreateFragmentV2.this.Vi();
                    Vi2.g();
                    bj6 = SuitCreateFragmentV2.this.bj();
                    bj6.setVisibility(0);
                    List<SuitWhiteModelItem> O2 = SuitCreateFragmentV2.this.ej().v2() == UEAvatarGender.MALE.getIndex() ? SuitCreateFragmentV2.this.ej().O2() : SuitCreateFragmentV2.this.ej().r2();
                    if (O2 != null) {
                        SuitCreateFragmentV2 suitCreateFragmentV2 = SuitCreateFragmentV2.this;
                        QLog.i("SuitCreateFragmentV2", 1, "whiteModelList " + O2.size());
                        RecyclerView.Adapter adapter = suitCreateFragmentV2.fj().getAdapter();
                        be3.p pVar = adapter instanceof be3.p ? (be3.p) adapter : null;
                        if (pVar != null && (i07 = pVar.i0()) != null) {
                            i07.clear();
                        }
                        RecyclerView.Adapter adapter2 = suitCreateFragmentV2.fj().getAdapter();
                        be3.p pVar2 = adapter2 instanceof be3.p ? (be3.p) adapter2 : null;
                        if (pVar2 != null && (i06 = pVar2.i0()) != null) {
                            i06.addAll(O2);
                        }
                        RecyclerView.Adapter adapter3 = suitCreateFragmentV2.fj().getAdapter();
                        if (adapter3 != null) {
                            adapter3.notifyDataSetChanged();
                        }
                        suitCreateFragmentV2.rk();
                        return;
                    }
                    return;
                }
                Vi = SuitCreateFragmentV2.this.Vi();
                Vi.d();
                bj5 = SuitCreateFragmentV2.this.bj();
                bj5.setVisibility(4);
            }
        };
        I2.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitCreateFragmentV2.pj(Function1.this, obj);
            }
        });
        MutableLiveData<Imagery> p26 = ej().p2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Imagery, Unit> function13 = new Function1<Imagery, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Imagery imagery) {
                invoke2(imagery);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Imagery promptImagery) {
                Function3 function3;
                function3 = SuitCreateFragmentV2.this.onItemImageryClick;
                Intrinsics.checkNotNullExpressionValue(promptImagery, "promptImagery");
                function3.invoke(promptImagery, null, -1);
            }
        };
        p26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.zplan.aigc.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SuitCreateFragmentV2.qj(Function1.this, obj);
            }
        });
    }

    private final void jj() {
        if (Intrinsics.areEqual(this.firstInit, Boolean.TRUE)) {
            Ui().setTypeface(Typeface.defaultFromStyle(1));
            Drawable drawable = null;
            Vj(this, false, null, 2, null);
            Ki().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuitCreateFragmentV2.kj(SuitCreateFragmentV2.this, view);
                }
            });
            Ti().setLayoutManager(new GridLayoutManager(getContext(), 2, 0, false));
            zd3.a aVar = this.dtReporter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                aVar = null;
            }
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            this.imageryAdapter = new be3.j(aVar, requireContext, this.onItemImageryClick);
            Ti().setAdapter(this.imageryAdapter);
            Ti().addItemDecoration(new de3.a());
            FrameLayout Ji = Ji();
            Drawable drawable2 = this.bgShadowDrawable;
            if (drawable2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bgShadowDrawable");
            } else {
                drawable = drawable2;
            }
            Ji.setBackground(drawable);
            Li().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SuitCreateFragmentV2.lj(SuitCreateFragmentV2.this, view);
                }
            });
        }
        this.firstInit = Boolean.FALSE;
    }

    public final void jk() {
        AIGCViewPagerWithIndicator Si = Si();
        ArrayList<AIGCModelRenderTask> arrayList = this.currentRenderTasks;
        Bitmap selectBitmap = ej().getSelectBitmap();
        zd3.a aVar = this.dtReporter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
            aVar = null;
        }
        AIGCViewPagerWithIndicator.setData$default(Si, arrayList, selectBitmap, false, aVar, 4, null);
        if (AIGCHelper.f330685a.d(this.currentRenderTasks)) {
            if (this.currentRenderTasks.size() == 4) {
                Ji().setVisibility(0);
            }
            this.isPreviewShowed = true;
        }
        Zj(this, false, 1, null);
    }

    public static final void kj(SuitCreateFragmentV2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (hf0.a.a("SuitCreateFragmentV2")) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            this$0.fk(1, R.string.f169787xl4);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this$0.lastClickTime < 1000) {
            QLog.i("SuitCreateFragmentV2", 1, "not click too much");
            this$0.lastClickTime = currentTimeMillis;
        } else {
            this$0.lastClickTime = currentTimeMillis;
            Fragment parentFragment = this$0.getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
            ((SuitParentFragment) parentFragment).Di(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$initSpellView$1$1
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
                    Imagery selectImagery = SuitCreateFragmentV2.this.ej().getSelectImagery();
                    if (selectImagery != null) {
                        SuitCreateFragmentV2.this.hj(selectImagery);
                    }
                }
            }, false);
        }
    }

    private final void kk(Imagery imagery) {
        String str;
        ej().w3(imagery.getId() != 0);
        SuitCreateTechFragmentViewModel ej5 = ej();
        String description = imagery.getDescription();
        if (description == null) {
            description = "";
        }
        ej5.p3(description);
        SuitCreateTechFragmentViewModel ej6 = ej();
        if (!TextUtils.isEmpty(imagery.getName())) {
            str = imagery.getName();
            Intrinsics.checkNotNull(str);
        } else {
            str = "\u81ea\u5b9a\u4e49\u670d\u88c5";
        }
        ej6.u3(str);
        ej().n3(4);
    }

    public static final void lj(SuitCreateFragmentV2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("SuitCreateFragmentV2", 1, "showTextCustomizeView ~~~~");
        if (hf0.a.a("SuitCreateFragmentV2")) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this$0.lastClickTime < 1000) {
            QLog.i("SuitCreateFragmentV2", 1, "not click too much");
            this$0.lastClickTime = currentTimeMillis;
            return;
        }
        this$0.lastClickTime = currentTimeMillis;
        Fragment parentFragment = this$0.getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        ((SuitParentFragment) parentFragment).Di(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2$initSpellView$2$1
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
                yd3.d dVar;
                dVar = SuitCreateFragmentV2.this.customPromptInputPart;
                Bundle bundle = new Bundle();
                SuitCreateFragmentV2 suitCreateFragmentV2 = SuitCreateFragmentV2.this;
                bundle.putLong("ugcid", 0L);
                Imagery selectImagery = suitCreateFragmentV2.ej().getSelectImagery();
                bundle.putString("description", selectImagery != null ? selectImagery.getDescription() : null);
                dVar.C9(bundle);
            }
        }, false);
        zd3.a aVar = this$0.dtReporter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
            aVar = null;
        }
        zd3.a.v(aVar, this$0.Li(), "em_zplan_input_btn", null, 4, null);
    }

    public static final void mj(SuitCreateFragmentV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ji().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitCreateFragmentV2.nj(SuitCreateFragmentV2.this, view);
            }
        });
    }

    public final void mk(ArrayList<AIGCModelRenderTask> renderTasks) {
        Iterator<T> it = renderTasks.iterator();
        while (it.hasNext()) {
            ((AIGCModelRenderTask) it.next()).o(TASK_STATUS.TASK_STATUS_ERROR_IMG_NETWORK);
        }
    }

    public static final void nj(SuitCreateFragmentV2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isAdded2 && this$0.currentRenderTasks.size() < 8) {
            this$0.ui();
            this$0.isAdded2 = true;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("zplan_click_num", 1);
        zd3.a aVar = this$0.dtReporter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
            aVar = null;
        }
        aVar.t(this$0.Ji(), "em_zplan_clothes_more_btn", linkedHashMap);
    }

    public final void nk(long ugcID) {
        QLog.i("SuitCreateFragmentV2", 1, "updateRenderTasksUGCId refresh ugcid " + ej().L2() + ", " + ugcID + " ");
        CreatedClothShowLogic createdClothShowLogic = this.createdClothLogic;
        if (createdClothShowLogic != null) {
            createdClothShowLogic.w(String.valueOf(ugcID));
        }
        for (AIGCModelRenderTask aIGCModelRenderTask : this.currentRenderTasks) {
            aIGCModelRenderTask.p(String.valueOf(ugcID));
            aIGCModelRenderTask.getPatternImage().j(ugcID);
        }
    }

    public static final void oj(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void pj(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void pk(ImageView imageView, SuitCreateFragmentV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bitmap createBitmap = Bitmap.createBitmap(imageView.getWidth(), imageView.getHeight(), Bitmap.Config.ARGB_8888);
        imageView.draw(new Canvas(createBitmap));
        Bitmap bitmap = this$0.selectPromptBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this$0.selectPromptBitmap = createBitmap;
        this$0.ej().A3(this$0.selectPromptBitmap);
    }

    public static final void qj(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void qk(int position, SuitWhiteModelItem r85) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(gj(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(whiteModelTitle,\u2026lpha\", ALPHA_TRANSPARENT)");
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(fj(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(whiteModelList, \u2026lpha\", ALPHA_TRANSPARENT)");
        ofFloat2.addListener(new o(r85));
        AnimatorSet animatorSet = new AnimatorSet();
        ofFloat.setDuration(260L);
        ofFloat2.setDuration(260L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.start();
    }

    public final void rk() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(gj(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(whiteModelTitle, \"alpha\", ALPHA_OPAQUE)");
        ofFloat.setDuration(500L);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154377jy);
        loadAnimation.setInterpolator(new DecelerateInterpolator());
        xd3.b bVar = new xd3.b(requireContext(), loadAnimation);
        bVar.getAnimation().setDuration(500L);
        fj().setLayoutAnimation(bVar);
        fj().scheduleLayoutAnimation();
        ofFloat.start();
    }

    private final void sj() {
        fj().setLayoutManager(new GridLayoutManager(getContext(), 2, 0, false));
        fj().addItemDecoration(new de3.b());
        fj().setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.zplan.aigc.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean tj5;
                tj5 = SuitCreateFragmentV2.tj(SuitCreateFragmentV2.this, view, motionEvent);
                return tj5;
            }
        });
        fj().addOnScrollListener(new j());
        zd3.a aVar = this.dtReporter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
            aVar = null;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        this.whiteModelAdapter = new be3.p(aVar, requireContext, this.onWhiteItemClick, this.whiteModelBitmapLoadCallback);
        fj().setAdapter(this.whiteModelAdapter);
        ej().r3(true);
    }

    public final void sk(int position, SuitWhiteModelItem r102) {
        this.whiteModelIsAnimating = Boolean.TRUE;
        Di(position);
        RecyclerView.LayoutManager layoutManager = fj().getLayoutManager();
        View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(position) : null;
        ImageView imageView = findViewByPosition != null ? (ImageView) findViewByPosition.findViewById(R.id.qyv) : null;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 0.3f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(pressView, \"alpha\", 0f, 0.3f)");
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(pressView, \"alpha\", ALPHA_TRANSPARENT)");
        ofFloat2.addListener(new p(position, r102));
        AnimatorSet animatorSet = new AnimatorSet();
        this.whiteModelPressAnimatorSet = animatorSet;
        ofFloat.setDuration(50L);
        ofFloat2.setDuration(150L);
        animatorSet.playSequentially(ofFloat, ofFloat2);
        animatorSet.start();
    }

    public static final boolean tj(SuitCreateFragmentV2 this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return Intrinsics.areEqual(this$0.whiteModelIsAnimating, Boolean.TRUE);
    }

    private final void vj(Imagery imagery) {
        ej().D3(imagery);
        Imagery selectImagery = ej().getSelectImagery();
        QLog.i("SuitCreateFragmentV2", 1, "onChangeToCreatedClothState2 " + (selectImagery != null ? selectImagery.getDescription() : null));
        wi(imagery);
        this.isPreviewShowed = false;
        Tj(this, 2, false, false, 6, null);
        Ni().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SuitCreateFragmentV2.wj(SuitCreateFragmentV2.this, view);
            }
        });
    }

    private final void wi(Imagery imagery) {
        String str;
        Cj();
        Oi().setText("\u9009\u62e9\u4f60\u559c\u6b22\u7684\u670d\u88c5");
        Drawable drawable = getResources().getDrawable(R.drawable.f159921i60, null);
        if (imagery.getBackgroundUrl() == null) {
            Oi().setTextColor(-16777216);
            Ni().setTextColor(-16777216);
            Oi().setShadowLayer(0.0f, 0.0f, 0.0f, 0);
            Qi().setBackgroundResource(R.drawable.hwu);
        } else {
            drawable = getResources().getDrawable(R.drawable.i6a, null);
            Oi().setTextColor(-1);
            Oi().setShadowLayer(10.0f, 5.0f, 5.0f, Color.parseColor(GameCenterVideoViewController.GRAY_MASK));
            Ni().setTextColor(-1);
            Qi().setBackgroundResource(R.drawable.hwv);
        }
        Imagery imagery2 = this.currentImagery;
        if (imagery2 == null || (str = imagery2.getDescription()) == null) {
            str = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + "  ");
        int dpToPx = ImmersiveUtils.dpToPx(16.0f);
        drawable.setBounds(0, 0, dpToPx, dpToPx);
        spannableStringBuilder.setSpan(new ImageSpan(drawable, 0), spannableStringBuilder.length() + (-1), spannableStringBuilder.length(), 17);
        Ni().setText(spannableStringBuilder);
    }

    public static final void wj(SuitCreateFragmentV2 this$0, View view) {
        String str;
        Imagery selectImagery;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SuitCreateTechFragmentViewModel ej5 = this$0.ej();
        if (ej5 == null || (selectImagery = ej5.getSelectImagery()) == null || (str = selectImagery.getDescription()) == null) {
            str = "";
        }
        linkedHashMap.put("zplan_click_keywords_text", str);
        zd3.a aVar = this$0.dtReporter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
            aVar = null;
        }
        aVar.t(this$0.Ni(), "em_zplan_keywords", linkedHashMap);
        yd3.d dVar = this$0.customPromptInputPart;
        Bundle bundle = new Bundle();
        bundle.putLong("ugcid", 0L);
        Imagery selectImagery2 = this$0.ej().getSelectImagery();
        bundle.putString("description", selectImagery2 != null ? selectImagery2.getDescription() : null);
        dVar.C9(bundle);
    }

    public final void xi() {
        ArrayList arrayList = new ArrayList();
        for (AIGCModelRenderTask aIGCModelRenderTask : this.currentRenderTasks) {
            if (aIGCModelRenderTask.getStatus() == TASK_STATUS.TASK_STATUS_ERROR_IMG_NETWORK) {
                aIGCModelRenderTask.o(TASK_STATUS.TASK_STATUS_NONE);
                arrayList.add(aIGCModelRenderTask);
            }
        }
        jk();
        Imagery imagery = this.currentImagery;
        if (imagery != null) {
            Intrinsics.checkNotNull(imagery);
            vj(imagery);
        }
        zj(new c(arrayList, this));
    }

    public final void yi(b bVar) {
        if (this.needRefreshUGCId) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitCreateFragmentV2$checkAndRefreshUGCId$1(bVar, null), 3, null);
        } else {
            bVar.a(ej().L2(), 0);
        }
    }

    private final void zi() {
        ArrayList<AIGCModelRenderTask> arrayList = this.currentRenderTasks;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            arrayList.clear();
        }
        ArrayList<String> arrayList2 = this.tempCurrentAIGCImageUrls;
        if (arrayList2 != null) {
            Intrinsics.checkNotNull(arrayList2);
            arrayList2.clear();
        }
        this.isAdded2 = false;
        Ji().setVisibility(8);
        Si().f();
    }

    public final void Fj() {
        Zi().setAlpha(1.0f);
        Zi().setVisibility(0);
        Float f16 = this.spellClothOriginX;
        if (f16 != null) {
            Zi().setTranslationX(f16.floatValue());
        }
        Float f17 = this.spellClothOriginY;
        if (f17 != null) {
            Zi().setTranslationY(f17.floatValue());
        }
        RecyclerView.Adapter adapter = Ti().getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        Ti().setVisibility(0);
        Ti().setAlpha(1.0f);
        Ui().setVisibility(0);
        Ui().setAlpha(1.0f);
        Vi().setAlpha(1.0f);
        Li().setAlpha(1.0f);
        Vi().setVisibility(0);
    }

    public final void Gj() {
        QLog.i("SuitCreateFragmentV2", 1, "recoverWhiteModelBeginState");
        AnimatorSet animatorSet = this.whiteModelPressAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        RecyclerView.Adapter adapter = fj().getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        AnimatorSet animatorSet2 = this.clothAnimatorSet;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        SuitParentFragment.Wh((SuitParentFragment) parentFragment, false, 1, null);
        Zi().setTranslationX(0.0f);
        Zi().setTranslationY(0.0f);
        Zi().setVisibility(8);
        fj().setVisibility(0);
        fj().setAlpha(1.0f);
        gj().setVisibility(0);
        gj().setAlpha(1.0f);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(Vi().e());
        animatorSet3.setDuration(1L);
        animatorSet3.start();
        this.needRefreshUGCId = true;
    }

    public final void Lj() {
        int i3 = 0;
        for (Object obj : Si().d()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            View view = (View) obj;
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager.CustomGridAdapter.MyViewHolder");
            Map<String, Object> i17 = ((AIGCGridViewPager.b.C9138b) tag).i();
            zd3.a aVar = this.dtReporter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                aVar = null;
            }
            zd3.a.y(aVar, view, "em_zplan_clothes_result", i17, null, 8, null);
            i3 = i16;
        }
    }

    /* renamed from: Mi, reason: from getter */
    public final CreatedClothShowLogic getCreatedClothLogic() {
        return this.createdClothLogic;
    }

    public final ArrayList<AIGCModelRenderTask> Pi() {
        return this.currentRenderTasks;
    }

    public final void Sj(int position, boolean backEvent, boolean needRefresh) {
        String description;
        QLog.i("SuitCreateFragmentV2", 1, " seletViewStub " + position);
        aj().setDisplayedChild(position);
        ej().o2().postValue(Integer.valueOf(position));
        if (position == 0) {
            Fj();
            Gj();
            Dj();
            QLog.d("SuitCreateFragmentV2", 1, " needFromNewPreview " + ej().getFirstNeedWhiteModel());
            if (!ej().getFirstNeedWhiteModel()) {
                rj();
            }
        } else if (position == 1) {
            Fj();
            if (!backEvent) {
                Ej();
            } else {
                Imagery selectImagery = ej().getSelectImagery();
                if (selectImagery != null && (description = selectImagery.getDescription()) != null) {
                    Uj(true, description);
                }
            }
            Ti().scrollToPosition(0);
        } else if (position == 2) {
            Zi().setVisibility(8);
            com.tencent.mobileqq.zplan.aigc.utils.a.f330690a.h(Wi());
        }
        Nj();
        Pj();
    }

    /* renamed from: Yi, reason: from getter */
    public final Bitmap getSelectPromptBitmap() {
        return this.selectPromptBitmap;
    }

    public final void ak(boolean z16) {
        this.needRefreshUGCId = z16;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<yd3.e> assembleParts() {
        this.parts.add(this.customPromptInputPart);
        return this.parts;
    }

    public final void bk(Bitmap bitmap) {
        this.selectPromptBitmap = bitmap;
    }

    public final void ck(Imagery imagery, boolean needAnimation, boolean needClearState) {
        Intrinsics.checkNotNullParameter(imagery, "imagery");
        QLog.i("SuitCreateFragmentV2", 1, "switchFilamentTab");
        if (imagery.getId() == 0) {
            this.selectPromptBitmap = null;
        }
        ej().v3(true);
        aj().setDisplayedChild(2);
        ek(imagery, needAnimation, needClearState);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dfw;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        return new ArrayList<>();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.mobileqq.zplan.aigc.SuitParentFragment.b
    public boolean onBackPressed() {
        Boolean value = ej().I2().getValue();
        Boolean bool = Boolean.TRUE;
        if (!Intrinsics.areEqual(value, bool)) {
            Fragment parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
            ((SuitParentFragment) parentFragment).Pi();
            return true;
        }
        yd3.d dVar = this.customPromptInputPart;
        if (dVar.com.tencent.mtt.hippy.dom.node.NodeProps.VISIBLE java.lang.String) {
            dVar.x9();
            return true;
        }
        Fragment parentFragment2 = getParentFragment();
        Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        SuitParentFragment suitParentFragment = (SuitParentFragment) parentFragment2;
        ga4.i panelDialogController = suitParentFragment.getPanelDialogController();
        if (panelDialogController != null && panelDialogController.a()) {
            return true;
        }
        if (Intrinsics.areEqual(this.ImageryDispearIsAnimating, bool)) {
            QLog.d("SuitCreateFragmentV2", 1, "ImageryDispearIsAnimating can not back");
            return false;
        }
        if (suitParentFragment.getCreatedClothAnimating()) {
            QLog.d("SuitCreateFragmentV2", 1, "createdClothAnimating can not back");
            return false;
        }
        aj();
        int displayedChild = aj().getDisplayedChild();
        QLog.d("SuitCreateFragmentV2", 1, "index " + displayedChild);
        if (displayedChild <= 0) {
            if (displayedChild != 0) {
                return false;
            }
            Fragment parentFragment3 = getParentFragment();
            Intrinsics.checkNotNull(parentFragment3, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
            ((SuitParentFragment) parentFragment3).Pi();
            return true;
        }
        if (displayedChild == 2 && ej().getNeedFromNewPreview()) {
            QLog.d("SuitCreateFragmentV2", 1, "need return avigc");
            Fragment parentFragment4 = getParentFragment();
            Intrinsics.checkNotNull(parentFragment4, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
            ((SuitParentFragment) parentFragment4).Pi();
            return true;
        }
        Tj(this, displayedChild - 1, true, false, 4, null);
        return true;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r36) {
        super.onCreate(r36);
        Bundle arguments = getArguments();
        if (arguments != null) {
            ej().v3(Intrinsics.areEqual(arguments.getString("source"), "switchFilamentFragment"));
        }
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        this.dtReporter = ((SuitParentFragment) parentFragment).getDtReporter();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup r56, Bundle r65) {
        String str;
        Intent intent;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        requireActivity().overridePendingTransition(R.anim.f154364jl, R.anim.f154362jj);
        FragmentActivity activity = getActivity();
        zd3.a aVar = null;
        ZootopiaActivity zootopiaActivity = activity instanceof ZootopiaActivity ? (ZootopiaActivity) activity : null;
        if (zootopiaActivity != null) {
            zootopiaActivity.M2(R.anim.f154363jk);
        }
        View onCreateView = super.onCreateView(inflater, r56, r65);
        if (onCreateView == null) {
            onCreateView = null;
        }
        this.parentview = onCreateView;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FragmentActivity activity2 = getActivity();
        if (activity2 == null || (intent = activity2.getIntent()) == null || (str = intent.getStringExtra("AIGC_ENTRY_SOURCE")) == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "activity?.intent?.getStr\u2026Entry.ENTRY_SOURCE) ?: \"\"");
        linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        linkedHashMap.put("zplan_gender", Integer.valueOf(ej().v2()));
        View view = this.parentview;
        if (view != null) {
            zd3.a aVar2 = this.dtReporter;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
            } else {
                aVar = aVar2;
            }
            aVar.c(this, view, "pg_zplan_create_new", linkedHashMap);
        }
        VideoReport.setPageId(this.parentview, "pg_zplan_create_new");
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Si().e();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.i("SuitCreateFragmentV2", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        Oj();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.i("SuitCreateFragmentV2", 1, "onResume");
        ej().y2().clear();
        Ri().setZ(-1.0f);
        Ri().setText(MobileQQ.sMobileQQ.getLastLoginUin() + "\u5236\u4f5c\u4e2d");
        if (aj().getDisplayedChild() == 0) {
            Fj();
            Gj();
        }
        Nj();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        initViewModel();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SuitCreateFragmentV2$onViewCreated$1(this, null), 3, null);
    }

    public final void rj() {
        List<SuitWhiteModelItem> r26;
        ArrayList<SuitWhiteModelItem> i06;
        ArrayList<SuitWhiteModelItem> i07;
        sj();
        if (ej().v2() == UEAvatarGender.MALE.getIndex()) {
            r26 = ej().O2();
        } else {
            r26 = ej().r2();
        }
        if (r26 != null) {
            QLog.i("SuitCreateFragmentV2", 1, "whiteModelList " + r26.size());
            RecyclerView.Adapter adapter = fj().getAdapter();
            be3.p pVar = adapter instanceof be3.p ? (be3.p) adapter : null;
            if (pVar != null && (i07 = pVar.i0()) != null) {
                i07.clear();
            }
            RecyclerView.Adapter adapter2 = fj().getAdapter();
            be3.p pVar2 = adapter2 instanceof be3.p ? (be3.p) adapter2 : null;
            if (pVar2 != null && (i06 = pVar2.i0()) != null) {
                i06.addAll(r26);
            }
            RecyclerView.Adapter adapter3 = fj().getAdapter();
            if (adapter3 != null) {
                adapter3.notifyDataSetChanged();
            }
            rk();
        }
        gj().setTypeface(Typeface.defaultFromStyle(1));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$c", "Lcom/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$b;", "", "result", "", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements b {

        /* renamed from: a */
        final /* synthetic */ ArrayList<AIGCModelRenderTask> f329893a;

        /* renamed from: b */
        final /* synthetic */ SuitCreateFragmentV2 f329894b;

        c(ArrayList<AIGCModelRenderTask> arrayList, SuitCreateFragmentV2 suitCreateFragmentV2) {
            this.f329893a = arrayList;
            this.f329894b = suitCreateFragmentV2;
        }

        @Override // com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2.b
        public void a(long j3, int i3) {
            b.a.b(this, j3, i3);
        }

        @Override // com.tencent.mobileqq.zplan.aigc.SuitCreateFragmentV2.b
        public void b(int result) {
            if (result != 0) {
                this.f329894b.mk(this.f329893a);
                this.f329894b.yj();
                this.f329894b.jk();
            } else {
                ArrayList<AIGCModelRenderTask> arrayList = this.f329893a;
                SuitCreateFragmentV2 suitCreateFragmentV2 = this.f329894b;
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    suitCreateFragmentV2.Bj((AIGCModelRenderTask) it.next());
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$m", "Lcom/tencent/mobileqq/zplan/aigc/view/AIGCGridViewPager$c;", "", "index", "Lcom/tencent/mobileqq/zplan/aigc/data/d;", "renderTask", "clickedX", "clickedY", "width", "height", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class m implements AIGCGridViewPager.c {
        m() {
        }

        @Override // com.tencent.mobileqq.zplan.aigc.view.AIGCGridViewPager.c
        public void a(int index, AIGCModelRenderTask renderTask, int clickedX, int clickedY, int width, int height) {
            Intrinsics.checkNotNullParameter(renderTask, "renderTask");
            if (SuitCreateFragmentV2.this.ej().J2().getValue() != null) {
                Long value = SuitCreateFragmentV2.this.ej().J2().getValue();
                Intrinsics.checkNotNull(value);
                if (value.longValue() < 1) {
                    QLog.i("SuitCreateFragmentV2", 1, "filamentContainer ticketNumLiveData not much  ");
                    Context context = SuitCreateFragmentV2.this.getContext();
                    if (context != null) {
                        Fragment parentFragment = SuitCreateFragmentV2.this.getParentFragment();
                        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                        String string = context.getResources().getString(R.string.xkp);
                        Intrinsics.checkNotNullExpressionValue(string, "it1.resources.getString(\u2026lan_aigc_ticket_as_title)");
                        ((SuitParentFragment) parentFragment).Ri(context, string);
                        return;
                    }
                    return;
                }
            }
            if (renderTask.getStatus() != TASK_STATUS.TASK_STATUS_SCREEN_SHOT_SUCCESS) {
                SuitCreateFragmentV2.this.xi();
                return;
            }
            CreatedClothShowLogic createdClothLogic = SuitCreateFragmentV2.this.getCreatedClothLogic();
            if (createdClothLogic != null) {
                createdClothLogic.v(renderTask);
            }
            QLog.i("SuitCreateFragmentV2", 1, "filamentContainer onItemClick " + index + " ~~~~ " + renderTask.getUgcID() + ", " + SuitCreateFragmentV2.this.ej().L2());
            if (clickedX != 0) {
                Fragment parentFragment2 = SuitCreateFragmentV2.this.getParentFragment();
                Intrinsics.checkNotNull(parentFragment2, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
                Bitmap resultImage = renderTask.getResultImage();
                Intrinsics.checkNotNull(resultImage);
                ((SuitParentFragment) parentFragment2).Ph(clickedX, clickedY, resultImage, width, height);
            }
            SuitCreateFragmentV2.this.ej().F3(true);
            SuitCreateFragmentV2.this.Bi();
            SuitCreateFragmentV2.this.Ij(renderTask);
        }
    }

    private final void Ej() {
        QLog.i("SuitCreateFragmentV2", 1, "recoverCustomiseStatus");
        ej().D3(null);
        Vj(this, false, null, 2, null);
    }

    public final void uj() {
        this.isPreviewShowed = false;
        Tj(this, 2, false, false, 6, null);
        Ji().setVisibility(8);
        jk();
    }

    public final void xj() {
        this.isPreviewShowed = false;
        Tj(this, 2, false, false, 6, null);
        Ji().setVisibility(8);
        jk();
    }

    public final void yj() {
        this.isPreviewShowed = false;
        Tj(this, 2, false, false, 6, null);
        Ji().setVisibility(8);
        jk();
        Yj(false);
    }

    private final void zj(b callback) {
        QLog.i("SuitCreateFragmentV2", 1, "preCheckAndUpdateProcess");
        CreatedClothShowLogic createdClothShowLogic = this.createdClothLogic;
        if (createdClothShowLogic != null) {
            createdClothShowLogic.q(new k(callback));
        }
    }

    public final void Cj() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Qi(), Ni(), Wi(), Ji(), Oi());
        Iterator it = arrayListOf.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setAlpha(1.0f);
        }
        this.isJumped = false;
        Ni().setVisibility(0);
        Qi().setVisibility(0);
    }

    public final void Dj() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Qi(), Ni(), Wi(), Ji(), Si(), Xi(), Oi());
        Iterator it = arrayListOf.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setAlpha(1.0f);
        }
        this.isJumped = false;
        Ni().setVisibility(0);
        Qi().setVisibility(0);
    }

    private final ArrayList<AIGCModelRenderTask> Ii(int startNum, int count, AIGCWhiteModel whiteModel, int imageryId, String imageryDescription, long ugcId, String imageryName, String modelItemId) {
        int i3;
        ArrayList<AIGCModelRenderTask> arrayList = new ArrayList<>();
        int i16 = startNum + count;
        int i17 = startNum;
        while (i17 < i16) {
            CreatedClothShowLogic createdClothShowLogic = this.createdClothLogic;
            AIGCModelRenderTask aIGCModelRenderTask = null;
            if (createdClothShowLogic != null) {
                String valueOf = String.valueOf(ugcId);
                Imagery imagery = this.currentImagery;
                i3 = i17;
                aIGCModelRenderTask = createdClothShowLogic.h(i17, whiteModel, imageryId, imageryDescription, ugcId, (r26 & 32) != 0 ? "000001" : valueOf, (r26 & 64) != 0 ? TASK_STATUS.TASK_STATUS_NONE : null, (r26 & 128) != 0 ? null : imagery != null ? imagery.getColor() : null, (r26 & 256) != 0 ? "" : imageryName, (r26 & 512) != 0 ? "" : modelItemId);
            } else {
                i3 = i17;
            }
            if (aIGCModelRenderTask != null) {
                arrayList.add(aIGCModelRenderTask);
            }
            i17 = i3 + 1;
        }
        return arrayList;
    }

    private final void Nj() {
        zd3.a aVar;
        zd3.a aVar2;
        String str;
        zd3.a aVar3;
        Imagery selectImagery;
        int displayedChild = aj().getDisplayedChild();
        if (displayedChild == 1) {
            zd3.a aVar4 = this.dtReporter;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                aVar = null;
            } else {
                aVar = aVar4;
            }
            zd3.a.y(aVar, Li(), "em_zplan_input_btn", null, null, 12, null);
            return;
        }
        if (displayedChild != 2) {
            return;
        }
        zd3.a aVar5 = this.dtReporter;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
            aVar2 = null;
        } else {
            aVar2 = aVar5;
        }
        zd3.a.y(aVar2, Ji(), "em_zplan_clothes_more_btn", null, null, 12, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SuitCreateTechFragmentViewModel ej5 = ej();
        if (ej5 == null || (selectImagery = ej5.getSelectImagery()) == null || (str = selectImagery.getDescription()) == null) {
            str = "";
        }
        linkedHashMap.put("zplan_click_keywords_text", str);
        zd3.a aVar6 = this.dtReporter;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
            aVar3 = null;
        } else {
            aVar3 = aVar6;
        }
        zd3.a.y(aVar3, Ni(), "em_zplan_keywords", linkedHashMap, null, 8, null);
    }

    public final void ek(Imagery imagery, boolean needAnimation, boolean needClearState) {
        if (needClearState) {
            Ci();
            zi();
        }
        this.currentImagery = imagery;
        kk(imagery);
        CreatedClothShowLogic createdClothShowLogic = this.createdClothLogic;
        if (createdClothShowLogic != null) {
            Intrinsics.checkNotNull(createdClothShowLogic);
            createdClothShowLogic.u(createdClothShowLogic.getSafeReqId() + 1);
        }
        if (needAnimation) {
            if (this.selectPromptBitmap == null) {
                Xi().setVisibility(0);
                Wi().setVisibility(8);
            } else {
                Xi().setVisibility(8);
                Wi().setVisibility(0);
            }
        }
        SuitWhiteModelItem selectedWhiteModelItem = ej().getSelectedWhiteModelItem();
        Intrinsics.checkNotNull(selectedWhiteModelItem);
        AIGCWhiteModel aigcWhiteModel = selectedWhiteModelItem.getAigcWhiteModel();
        Imagery imagery2 = this.currentImagery;
        Intrinsics.checkNotNull(imagery2);
        int id5 = imagery2.getId();
        Imagery imagery3 = this.currentImagery;
        Intrinsics.checkNotNull(imagery3);
        String description = imagery3.getDescription();
        long L2 = ej().L2();
        Imagery imagery4 = this.currentImagery;
        Intrinsics.checkNotNull(imagery4);
        String name = imagery4.getName();
        if (name == null) {
            name = "";
        }
        String str = name;
        SuitWhiteModelItem selectedWhiteModelItem2 = ej().getSelectedWhiteModelItem();
        Intrinsics.checkNotNull(selectedWhiteModelItem2);
        ArrayList<AIGCModelRenderTask> Ii = Ii(0, 4, aigcWhiteModel, id5, description, L2, str, selectedWhiteModelItem2.getItemId());
        this.currentRenderTasks.clear();
        this.currentRenderTasks.addAll(Ii);
        Imagery imagery5 = this.currentImagery;
        if (imagery5 != null) {
            Intrinsics.checkNotNull(imagery5);
            vj(imagery5);
            AIGCViewPagerWithIndicator Si = Si();
            ArrayList<AIGCModelRenderTask> arrayList = this.currentRenderTasks;
            Bitmap selectBitmap = ej().getSelectBitmap();
            zd3.a aVar = this.dtReporter;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dtReporter");
                aVar = null;
            }
            Si.setData(arrayList, selectBitmap, needAnimation, aVar);
        }
        zj(new n());
    }

    public final void lk(Bitmap r102) {
        if (r102 == null || r102.isRecycled()) {
            return;
        }
        Wi().q("https://downv6.qq.com/shadow_qqcamera/zshow/aigc_suit_created_background.pag", 0, (r13 & 4) != 0 ? null : 2, (r13 & 8) != 0 ? null : r102, (r13 & 16) != 0 ? null : null);
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        ((SuitParentFragment) parentFragment).aj(r102);
    }

    public final void ok(final ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if ((drawable instanceof URLDrawable) && ((URLDrawable) drawable).getStatus() == 1) {
                imageView.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aigc.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        SuitCreateFragmentV2.pk(imageView, this);
                    }
                });
            }
        }
    }

    private final void ui() {
        SuitWhiteModelItem selectedWhiteModelItem = ej().getSelectedWhiteModelItem();
        Intrinsics.checkNotNull(selectedWhiteModelItem);
        AIGCWhiteModel aigcWhiteModel = selectedWhiteModelItem.getAigcWhiteModel();
        Imagery imagery = this.currentImagery;
        Intrinsics.checkNotNull(imagery);
        int id5 = imagery.getId();
        Imagery imagery2 = this.currentImagery;
        Intrinsics.checkNotNull(imagery2);
        String description = imagery2.getDescription();
        long L2 = ej().L2();
        Imagery imagery3 = this.currentImagery;
        Intrinsics.checkNotNull(imagery3);
        String name = imagery3.getName();
        if (name == null) {
            name = "";
        }
        String str = name;
        SuitWhiteModelItem selectedWhiteModelItem2 = ej().getSelectedWhiteModelItem();
        Intrinsics.checkNotNull(selectedWhiteModelItem2);
        ik(Ii(4, 4, aigcWhiteModel, id5, description, L2, str, selectedWhiteModelItem2.getItemId()));
        jk();
        if (Si().c() != 1) {
            Si().g();
        }
        Hj();
        Ji().setVisibility(8);
        ej().n3(8);
    }

    public final void Uj(boolean enable, String str) {
        if (enable) {
            Ki().setBackgroundResource(R.drawable.i66);
            Wj(true, str);
        } else {
            Ki().setBackgroundResource(R.drawable.i67);
            Xj(this, false, null, 2, null);
        }
        Ki().setEnabled(enable);
    }

    static /* synthetic */ void Vj(SuitCreateFragmentV2 suitCreateFragmentV2, boolean z16, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "\u4f60\u4e5f\u53ef\u4ee5\u81ea\u5b9a\u4e49\u98ce\u683c\u5173\u952e\u8bcd";
        }
        suitCreateFragmentV2.Uj(z16, str);
    }

    static /* synthetic */ void Xj(SuitCreateFragmentV2 suitCreateFragmentV2, boolean z16, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "\u4f60\u4e5f\u53ef\u4ee5\u81ea\u5b9a\u4e49\u98ce\u683c\u5173\u952e\u8bcd";
        }
        suitCreateFragmentV2.Wj(z16, str);
    }

    public final void ij(Imagery imagery, ImageView imageView, int position) {
        if (position != -1) {
            this.ImageryDispearIsAnimating = Boolean.TRUE;
            AnimatorSet animatorSet = new AnimatorSet();
            RecyclerView.LayoutManager layoutManager = Ti().getLayoutManager();
            View findViewByPosition = layoutManager != null ? layoutManager.findViewByPosition(position) : null;
            ImageView imageView2 = findViewByPosition != null ? (ImageView) findViewByPosition.findViewById(R.id.q1g) : null;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 0.3f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(pressView, \"alpha\", 0f, 0.3f)");
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(pressView, \"alpha\", ALPHA_TRANSPARENT)");
            ofFloat2.addListener(new h(imagery));
            ofFloat.setDuration(50L);
            ofFloat2.setDuration(150L);
            animatorSet.playSequentially(ofFloat, ofFloat2);
            animatorSet.start();
            ej().t3(false);
            return;
        }
        hj(imagery);
        ej().t3(true);
    }

    static /* synthetic */ void Zj(SuitCreateFragmentV2 suitCreateFragmentV2, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        suitCreateFragmentV2.Yj(z16);
    }

    public final void vi(SuitWhiteModelItem r75) {
        Tj(this, 1, false, false, 6, null);
        Fragment parentFragment = getParentFragment();
        Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.aigc.SuitParentFragment");
        ((SuitParentFragment) parentFragment).Vh(true);
        jj();
        Ei(r75);
    }

    public static /* synthetic */ void Tj(SuitCreateFragmentV2 suitCreateFragmentV2, int i3, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = false;
        }
        if ((i16 & 4) != 0) {
            z17 = false;
        }
        suitCreateFragmentV2.Sj(i3, z16, z17);
    }

    public static /* synthetic */ void dk(SuitCreateFragmentV2 suitCreateFragmentV2, Imagery imagery, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        suitCreateFragmentV2.ck(imagery, z16, z17);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/SuitCreateFragmentV2$b;", "", "", "ugcId", "", "result", "", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void a(long ugcId, int result);

        void b(int result);

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public static final class a {
            public static void a(b bVar, int i3) {
            }

            public static void b(b bVar, long j3, int i3) {
            }
        }
    }
}
