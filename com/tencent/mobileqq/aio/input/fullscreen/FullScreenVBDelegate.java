package com.tencent.mobileqq.aio.input.fullscreen;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenUIState;
import com.tencent.mobileqq.aio.input.fullscreen.f;
import com.tencent.mobileqq.aio.input.fullscreen.m;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.core.EventListener;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2$\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0001j\b\u0012\u0004\u0012\u00020\u0005`\u0006:\u0001?B\u000f\u0012\u0006\u0010N\u001a\u00020\u0004\u00a2\u0006\u0004\bt\u0010MJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u001e\u0010#\u001a\u00020\t2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\"\u001a\u00020!H\u0002J\u0018\u0010&\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020\u0011H\u0002J\b\u0010'\u001a\u00020\tH\u0002J6\u0010/\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u00072\u001a\u0010,\u001a\u0016\u0012\u0004\u0012\u00020*\u0018\u00010)j\n\u0012\u0004\u0012\u00020*\u0018\u0001`+2\b\u0010.\u001a\u0004\u0018\u00010-H\u0002J\u001a\u00100\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010-H\u0002J\"\u00102\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010-H\u0002J\u0014\u00105\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u000103H\u0002J\u001a\u00107\u001a\u00020\t2\b\u00104\u001a\u0004\u0018\u0001032\u0006\u00106\u001a\u00020\u0011H\u0002J%\u0010;\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u0001082\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010>\u001a\u00020\t2\u0006\u0010=\u001a\u00020\u0005H\u0016J\b\u0010?\u001a\u00020\tH\u0016J\u0012\u0010B\u001a\u0004\u0018\u00010\u000f2\u0006\u0010A\u001a\u00020@H\u0016J\u0018\u0010D\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00030C\u0018\u00010\u001eH\u0016J\u0010\u0010F\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0003H\u0016J\b\u0010G\u001a\u00020\tH\u0016R\"\u0010N\u001a\u00020\u00048\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010\u0016R\u0016\u0010R\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010\u0016R\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010\\R\u0018\u0010b\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\\R\u0018\u0010c\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\\R\u0018\u0010d\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\\R\u0016\u0010f\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010eR\u0016\u0010g\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u0016R\u0016\u0010i\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010\u0016R\u0016\u0010j\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u001b\u0010s\u001a\u00020o8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bp\u0010q\u001a\u0004\b^\u0010r\u00a8\u0006u"}, d2 = {"Lcom/tencent/mobileqq/aio/input/fullscreen/FullScreenVBDelegate;", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "", "iconType", "", ExifInterface.LATITUDE_SOUTH, "T", "U", HippyTKDListViewAdapter.X, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/os/Bundle;", UserInfo.SEX_FEMALE, "", "showFullScreenMode", "G", "c0", "K", "Z", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "v", "Landroid/widget/EditText;", "editText", "W", "V", "", "Lcom/tencent/mobileqq/aio/input/fullscreen/c;", "picInfoList", "Lkotlinx/coroutines/CoroutineScope;", "scope", "N", "isSupportPicAbility", "isSupportCameraAbility", "I", "u", "position", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/input/fullscreen/a;", "Lkotlin/collections/ArrayList;", "imageSpanList", "Landroid/text/Editable;", "editable", "O", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, EventListener.KEY_DELTA, "t", "Landroid/view/View;", "view", "E", "isPanelShow", "b0", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "sendBtn", "radius", "e0", "(Lcom/tencent/biz/qui/quibutton/QUIButton;Ljava/lang/Integer;)V", "binding", BdhLogUtil.LogTag.Tag_Req, "a", "Lcom/tencent/mvi/api/ability/d;", "stateCmd", "generateVBState", "Ljava/lang/Class;", "getObserverStates", "state", "H", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "B", "()Lcom/tencent/mobileqq/aio/input/adorn/b;", "a0", "(Lcom/tencent/mobileqq/aio/input/adorn/b;)V", "mHost", "e", "mIsFullScreenMode", "f", "mIsCheckingImageSpanStyle", "Landroid/content/Context;", tl.h.F, "Landroid/content/Context;", "mContext", "i", "Landroid/widget/EditText;", "mEditText", "Landroid/animation/ValueAnimator;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/animation/ValueAnimator;", "mStyleAnimator", BdhLogUtil.LogTag.Tag_Conn, "mIconAlphaAnimator", "D", "mIconTranslationY", "mSendBtnAlphaAnimator", "mSendBtnTranslationY", "mSendBtnTranslationX", "Lcom/tencent/mobileqq/aio/input/inputbar/viewbinding/a;", "mBinding", "mIsSupportPicAbility", "J", "mIsSupportCameraAbility", "mBindingInitialized", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "L", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "mInputLayoutParamSaved", "Lw71/e;", "M", "Lkotlin/Lazy;", "()Lw71/e;", "mIconBinding", "<init>", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class FullScreenVBDelegate implements com.tencent.input.base.mvicompat.c<at.a, InputUIState, com.tencent.mobileqq.aio.input.adorn.b, com.tencent.mobileqq.aio.input.inputbar.viewbinding.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mIconAlphaAnimator;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mIconTranslationY;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mSendBtnAlphaAnimator;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mSendBtnTranslationY;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mSendBtnTranslationX;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.mobileqq.aio.input.inputbar.viewbinding.a mBinding;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mIsSupportPicAbility;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mIsSupportCameraAbility;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mBindingInitialized;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout.LayoutParams mInputLayoutParamSaved;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy mIconBinding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.aio.input.adorn.b mHost;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsFullScreenMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsCheckingImageSpanStyle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private EditText mEditText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator mStyleAnimator;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b<\u0010=R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0014\u0010\u001b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\bR\u0014\u0010!\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0004R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0014\u0010#\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0012R\u0014\u0010$\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\bR\u0014\u0010&\u001a\u00020%8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b(\u0010\bR\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010\u0004R\u0014\u0010*\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0004R\u0014\u0010+\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010\u0004R\u0014\u0010,\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010\u0004R\u0014\u0010-\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010\u0004R\u0014\u0010.\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010\u0004R\u0014\u0010/\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u0010\u0004R\u0014\u00100\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b0\u0010\u0004R\u0014\u00101\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b1\u0010\u0004R\u0014\u00102\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b2\u0010\u0004R\u0014\u00103\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b3\u0010\u0004R\u0014\u00104\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b4\u0010\u0004R\u0014\u00105\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b5\u0010\u0004R\u0014\u00106\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b6\u0010\u0004R\u0014\u00107\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b7\u0010\u0004R\u0014\u00108\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b8\u0010\u0004R\u0014\u00109\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b9\u0010\u0004R\u0014\u0010:\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b:\u0010\u0004R\u0014\u0010;\u001a\u00020%8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b;\u0010'\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/aio/input/fullscreen/FullScreenVBDelegate$a;", "", "", "AIO_IMAGE_DEFAULT_HEIGHT", "I", "AIO_IMAGE_DEFAULT_WIDTH", "", "ALPHA_HIDE_VALUE", UserInfo.SEX_FEMALE, "ALPHA_SHOW_VALUE", "ANIM_TRANSLATION_X_DP", "ANIM_TRANSLATION_Y_DP", "BACKGROUND_ALPHA", "", "CHAR_NEW_LINE", BdhLogUtil.LogTag.Tag_Conn, "", "FULL_SCREEN_BOTTOM_ANIM_DELAY_TIME", "J", "FULL_SCREEN_BOTTOM_ANIM_TIME", "FULL_SCREEN_EDIT_LEFT_MARGIN_DP", "FULL_SCREEN_EDIT_MAX_LINE", "FULL_SCREEN_EDIT_PADDING_BOTTOM_DP", "FULL_SCREEN_EDIT_PADDING_LEFT_DP", "FULL_SCREEN_EDIT_PADDING_RIGHT_DP", "FULL_SCREEN_EDIT_PADDING_TOP_DP", "FULL_SCREEN_EDIT_RIGHT_MARGIN_DP", "FULL_SCREEN_EXTRA_TOP_MARGIN_DP", "FULL_SCREEN_ICON_LAYOUT_LEFT_BOTTOM_DP", "FULL_SCREEN_ICON_LAYOUT_LEFT_MARGIN_DP", "FULL_SCREEN_ROOT_PADDING_BOTTOM_DP", "FULL_SCREEN_ROOT_PADDING_TOP_DP", "FULL_SCREEN_SEND_BTN_BOTTOM_MARGIN_DP", "FULL_SCREEN_SEND_BTN_HEIGHT_DP", "FULL_SCREEN_SEND_BTN_RIGHT_MARGIN_DP", "FULL_SCREEN_STYLE_ANIM_TIME", "INPUT_FULL_SCREEN_TRANSLATION_Z", "", "INPUT_INSERT_IMAGE_SWITCH", "Ljava/lang/String;", "INPUT_TRANSLATION_Z_DEFAULT", "MAX_PIC_NUM", "NORMAL_EDIT_LEFT_MARGIN_DP", "NORMAL_EDIT_MAX_LINE", "NORMAL_EDIT_PADDING_BOTTOM_DP", "NORMAL_EDIT_PADDING_LEFT_DP", "NORMAL_EDIT_PADDING_RIGHT_DP", "NORMAL_EDIT_PADDING_TOP_DP", "NORMAL_EDIT_RIGHT_MARGIN_DP", "NORMAL_ROOT_PADDING_BOTTOM_DP", "NORMAL_ROOT_PADDING_TOP_DP", "NORMAL_ROOT_TOP_MARGIN_DP", "NORMAL_SEND_BTN_BOTTOM_MARGIN_DP", "NORMAL_SEND_BTN_HEIGHT_DP", "NORMAL_SEND_BTN_RIGHT_MARGIN_DP", "REPORT_FULL_SCREEN_CAMERA", "REPORT_FULL_SCREEN_EMOJI", "REPORT_FULL_SCREEN_HIDE", "REPORT_FULL_SCREEN_IMAGE", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.input.fullscreen.FullScreenVBDelegate$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", ReportConstant.COSTREPORT_PREFIX, "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements TextWatcher {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FullScreenVBDelegate.this);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FullScreenVBDelegate.this.x();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) s16);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence text, int start, int count, int after) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, text, Integer.valueOf(start), Integer.valueOf(count), Integer.valueOf(after));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, text, Integer.valueOf(start), Integer.valueOf(before), Integer.valueOf(count));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/input/fullscreen/FullScreenVBDelegate$c", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationRepeat", "onAnimationEnd", "onAnimationStart", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c extends com.tencent.mobileqq.widget.f {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FullScreenVBDelegate.this);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                FullScreenVBDelegate.this.P();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                FullScreenVBDelegate.this.P();
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                FullScreenVBDelegate.this.Q();
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/input/fullscreen/FullScreenVBDelegate$d", "Lee0/b;", "Landroid/content/Context;", "context", "", "buttonType", "sizeType", "f", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class d extends ee0.b {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Integer f189601b;

        d(Integer num) {
            this.f189601b = num;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) num);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // ee0.b
        public int f(@Nullable Context context, int buttonType, int sizeType) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(buttonType), Integer.valueOf(sizeType))).intValue();
            }
            Integer num = this.f189601b;
            if (num != null) {
                return num.intValue();
            }
            return super.f(context, buttonType, sizeType);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55251);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FullScreenVBDelegate(@NotNull com.tencent.mobileqq.aio.input.adorn.b mHost) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(mHost, "mHost");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mHost);
            return;
        }
        this.mHost = mHost;
        this.mIsSupportPicAbility = true;
        this.mIsSupportCameraAbility = true;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new FullScreenVBDelegate$mIconBinding$2(this));
        this.mIconBinding = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int A() {
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        Editable editableText = editText.getEditableText();
        a[] aVarArr = (a[]) editableText.getSpans(0, editableText.length(), a.class);
        if (aVarArr == null) {
            return 0;
        }
        return aVarArr.length;
    }

    private final w71.e C() {
        return (w71.e) this.mIconBinding.getValue();
    }

    private final View E(View view) {
        Object parent;
        if (view == null || view.getParent() == null || (parent = view.getParent()) == null) {
            return null;
        }
        if (parent instanceof LinearLayout) {
            parent = ((LinearLayout) parent).getParent();
        }
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        return (View) parent;
    }

    private final Bundle F() {
        Bundle bundle = new Bundle();
        bundle.putInt("image_span_size", A());
        return bundle;
    }

    private final void G(boolean showFullScreenMode) {
        this.mIsFullScreenMode = showFullScreenMode;
        QLog.i("FullScreenVB", 1, "[handleSetFullScreenMode]: setFullScreenMode " + showFullScreenMode);
        if (showFullScreenMode) {
            Z();
            c0();
        } else {
            v();
        }
    }

    private final void I(boolean isSupportPicAbility, boolean isSupportCameraAbility) {
        if (this.mIsSupportPicAbility == isSupportPicAbility && this.mIsSupportCameraAbility == isSupportCameraAbility) {
            return;
        }
        this.mIsSupportPicAbility = isSupportPicAbility;
        this.mIsSupportCameraAbility = isSupportCameraAbility;
        if (this.mBindingInitialized) {
            ImageView imageView = C().f444788e;
            Boolean valueOf = Boolean.valueOf(isSupportPicAbility);
            imageView.setVisibility(0);
            if (((View) au.a(valueOf, imageView)) == null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = C().f444785b;
            Boolean valueOf2 = Boolean.valueOf(isSupportCameraAbility);
            imageView2.setVisibility(0);
            if (((View) au.a(valueOf2, imageView2)) == null) {
                imageView2.setVisibility(8);
            }
        }
    }

    private final void K() {
        if (this.mStyleAnimator == null) {
            this.mStyleAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        }
        ValueAnimator valueAnimator = this.mStyleAnimator;
        Intrinsics.checkNotNull(valueAnimator);
        valueAnimator.setDuration(200L);
        valueAnimator.removeAllListeners();
        valueAnimator.removeAllUpdateListeners();
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        final View E = E(aVar.getRoot());
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar3;
        }
        final int height = aVar2.getRoot().getHeight();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.aio.input.fullscreen.i
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                FullScreenVBDelegate.L(FullScreenVBDelegate.this, E, height, valueAnimator2);
            }
        });
        valueAnimator.addListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(FullScreenVBDelegate this$0, View view, int i3, ValueAnimator valueAnimator) {
        Drawable drawable;
        Drawable background;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this$0.mBinding;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        ConstraintLayout root = aVar.getRoot();
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this$0.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar3 = null;
        }
        ViewGroup.LayoutParams layoutParams = aVar3.getRoot().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar4 = this$0.mBinding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar4 = null;
        }
        Object parent = aVar4.getRoot().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        int height = ((View) parent).getHeight();
        Context context = this$0.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        float statusBarHeight = ((height - ImmersiveUtils.getStatusBarHeight(context)) - com.tencent.qqnt.util.view.b.f362999a.b(10)) - i3;
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        marginLayoutParams.height = i3 + ((int) (statusBarHeight * ((Float) animatedValue).floatValue()));
        root.setLayoutParams(marginLayoutParams);
        if (view != null && (background = view.getBackground()) != null) {
            drawable = background.mutate();
        } else {
            drawable = null;
        }
        if (drawable != null) {
            Object animatedValue2 = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
            drawable.setAlpha((int) (((Float) animatedValue2).floatValue() * 127.5f));
        }
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar5 = this$0.mBinding;
        if (aVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar5 = null;
        }
        aVar5.getRoot().requestLayout();
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar6 = this$0.mBinding;
        if (aVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar6;
        }
        aVar2.getRoot().invalidate();
    }

    private final void N(List<com.tencent.mobileqq.aio.input.fullscreen.c> picInfoList, CoroutineScope scope) {
        if (picInfoList.isEmpty()) {
            return;
        }
        EditText editText = this.mEditText;
        Context context = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        Editable editableText = editText.getEditableText();
        if (((a[]) editableText.getSpans(0, editableText.length(), a.class)).length + picInfoList.size() <= 20) {
            BuildersKt__Builders_commonKt.launch$default(scope, Dispatchers.getIO(), null, new FullScreenVBDelegate$insertPic$1(picInfoList, editableText, this, null), 2, null);
            return;
        }
        Context context2 = this.mContext;
        if (context2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context = context2;
        }
        QQToast.makeText(context, R.string.yrc, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(int position, ArrayList<a> imageSpanList, Editable editable) {
        boolean z16;
        int i3;
        if (imageSpanList != null && !imageSpanList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || editable == null) {
            return;
        }
        if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("aio_input_insert_image_905_116748503", true)) {
            if (z(position, editable)) {
                editable.insert(position, "\n");
                i3 = 1;
            } else {
                i3 = 0;
            }
            int t16 = t(position, i3, editable);
            Iterator<a> it = imageSpanList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) "\u56fe\u7247");
                spannableStringBuilder.setSpan(next, 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append('\n');
                editable.insert(t16, spannableStringBuilder);
                t16 = t(t16, 3, editable);
            }
        } else {
            if (z(position, editable)) {
                editable.append('\n');
            }
            Iterator<a> it5 = imageSpanList.iterator();
            while (it5.hasNext()) {
                a next2 = it5.next();
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("\u56fe\u7247");
                spannableStringBuilder2.setSpan(next2, 0, spannableStringBuilder2.length(), 33);
                editable.append((CharSequence) spannableStringBuilder2).append('\n');
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("FullScreenVB", 1, "[insertPicAtPosition end]:  editable = " + ((Object) editable) + ", position = " + position);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        ConstraintLayout root = aVar.getRoot();
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = -1;
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        marginLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(context) + com.tencent.qqnt.util.view.b.f362999a.b(10);
        root.setLayoutParams(marginLayoutParams);
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar3 = null;
        }
        aVar3.getRoot().setAlpha(1.0f);
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar4 = this.mBinding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar4;
        }
        aVar2.d().setAlpha(1.0f);
        Y(f.c.f189635d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        QUIButton qUIButton;
        Y(new f.b(true));
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        ConstraintLayout root = aVar.getRoot();
        root.setPadding(root.getPaddingLeft(), 0, root.getPaddingRight(), 0);
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = root.getHeight();
        root.setLayoutParams(marginLayoutParams);
        com.tencent.aio.view_dsl.dsl.f.c(root, true);
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.setGravity(48);
        editText.setMaxLines(100);
        com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
        editText.setPadding(bVar.b(25), bVar.b(61), bVar.b(25), bVar.b(42));
        W(editText);
        ViewGroup.LayoutParams layoutParams2 = editText.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin = 0;
        layoutParams3.topToTop = 0;
        layoutParams3.rightToLeft = -1;
        layoutParams3.rightToRight = 0;
        editText.setLayoutParams(layoutParams3);
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar3 = null;
        }
        View d16 = aVar3.d();
        d16.setVisibility(0);
        d16.setAlpha(0.0f);
        ViewGroup.LayoutParams layoutParams4 = d16.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) layoutParams4;
        ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = bVar.b(30);
        ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = bVar.a(11.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = bVar.b(29);
        if (com.tencent.mobileqq.aio.input.inputbar.compat.e.INSTANCE.a()) {
            if (d16 instanceof QUIButton) {
                qUIButton = (QUIButton) d16;
            } else {
                qUIButton = null;
            }
            f0(this, qUIButton, null, 2, null);
        }
        d16.setLayoutParams(layoutParams5);
        LinearLayout root2 = C().getRoot();
        if (root2.getParent() == null) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar4 = this.mBinding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                aVar2 = aVar4;
            }
            aVar2.getRoot().addView(root2);
        }
        root2.setVisibility(0);
        root2.setAlpha(0.0f);
        T(1);
        T(2);
        T(3);
        T(5);
        Y(f.d.f189636d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(int iconType) {
        HashMap hashMap = new HashMap();
        hashMap.put("resident_operation_entry", Integer.valueOf(iconType));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_enter_full_screen", hashMap);
    }

    private final void T(int iconType) {
        HashMap hashMap = new HashMap();
        hashMap.put("resident_operation_entry", Integer.valueOf(iconType));
        com.tencent.mobileqq.aio.utils.b.q("em_bas_enter_full_screen", hashMap);
    }

    private final void U(int iconType) {
        HashMap hashMap = new HashMap();
        hashMap.put("resident_operation_entry", Integer.valueOf(iconType));
        com.tencent.mobileqq.aio.utils.b.t("em_bas_enter_full_screen", hashMap);
    }

    private final void V(EditText editText) {
        ConstraintLayout.LayoutParams layoutParams = this.mInputLayoutParamSaved;
        if (layoutParams != null) {
            editText.setLayoutParams(layoutParams);
            this.mInputLayoutParamSaved = null;
        }
    }

    private final void W(EditText editText) {
        if (this.mInputLayoutParamSaved == null) {
            ViewGroup.LayoutParams layoutParams = editText.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            this.mInputLayoutParamSaved = new ConstraintLayout.LayoutParams((ConstraintLayout.LayoutParams) layoutParams);
        }
    }

    private final void Z() {
        boolean z16;
        ValueAnimator valueAnimator = this.mStyleAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        QLog.i("FullScreenVB", 1, "[setFullScrrenMode]: start Animatar");
        com.tencent.mobileqq.aio.utils.b.f194119a.p("em_bas_enter_full_screen");
        K();
        if (this.mIconAlphaAnimator == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(C().getRoot(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat.setDuration(100L);
            ofFloat.setStartDelay(100L);
            this.mIconAlphaAnimator = ofFloat;
        }
        if (this.mIconTranslationY == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(C().getRoot(), "translationY", com.tencent.qqnt.util.view.b.f362999a.b(40), 0.0f);
            ofFloat2.setDuration(100L);
            ofFloat2.setStartDelay(100L);
            this.mIconTranslationY = ofFloat2;
        }
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = null;
        if (this.mSendBtnAlphaAnimator == null) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = this.mBinding;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar2 = null;
            }
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(aVar2.d(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
            ofFloat3.setDuration(100L);
            ofFloat3.setStartDelay(100L);
            this.mSendBtnAlphaAnimator = ofFloat3;
        }
        if (this.mSendBtnTranslationX == null) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.mBinding;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                aVar3 = null;
            }
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(aVar3.d(), "translationX", com.tencent.qqnt.util.view.b.f362999a.b(-40), 0.0f);
            ofFloat4.setDuration(100L);
            ofFloat4.setStartDelay(100L);
            this.mSendBtnTranslationX = ofFloat4;
        }
        if (this.mSendBtnTranslationY == null) {
            com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar4 = this.mBinding;
            if (aVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                aVar = aVar4;
            }
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(aVar.d(), "translationY", com.tencent.qqnt.util.view.b.f362999a.b(40), 0.0f);
            ofFloat5.setDuration(100L);
            ofFloat5.setStartDelay(100L);
            this.mSendBtnTranslationY = ofFloat5;
        }
        ValueAnimator valueAnimator2 = this.mStyleAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.start();
        }
        ValueAnimator valueAnimator3 = this.mIconAlphaAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
        ValueAnimator valueAnimator4 = this.mIconTranslationY;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
        ValueAnimator valueAnimator5 = this.mSendBtnAlphaAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.start();
        }
        ValueAnimator valueAnimator6 = this.mSendBtnTranslationX;
        if (valueAnimator6 != null) {
            valueAnimator6.start();
        }
        ValueAnimator valueAnimator7 = this.mSendBtnTranslationY;
        if (valueAnimator7 != null) {
            valueAnimator7.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(View view, boolean isPanelShow) {
        String string;
        if (view == null) {
            return;
        }
        Context context = null;
        if (isPanelShow) {
            Context context2 = this.mContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context2;
            }
            string = context.getString(R.string.f197284jl);
        } else {
            Context context3 = this.mContext;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContext");
            } else {
                context = context3;
            }
            string = context.getString(R.string.f197464k3);
        }
        Intrinsics.checkNotNullExpressionValue(string, "if (isPanelShow) {\n     \u2026_emotion_panel)\n        }");
        view.setContentDescription(string);
    }

    private final void c0() {
        ImageView imageView = C().f444788e;
        Context context = this.mContext;
        Context context2 = null;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.qui_aio_input_full_screen_pic_icon));
        ImageView imageView2 = C().f444785b;
        Context context3 = this.mContext;
        if (context3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context3 = null;
        }
        imageView2.setImageDrawable(ContextCompat.getDrawable(context3, R.drawable.qui_aio_input_full_screen_camera_icon));
        ImageView imageView3 = C().f444786c;
        Context context4 = this.mContext;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        } else {
            context2 = context4;
        }
        imageView3.setImageDrawable(ContextCompat.getDrawable(context2, R.drawable.qui_aio_input_full_screen_emoji_icon));
    }

    private final void e0(QUIButton sendBtn, Integer radius) {
        if (sendBtn != null) {
            sendBtn.setQUIButtonResHelper(new d(radius));
        }
    }

    static /* synthetic */ void f0(FullScreenVBDelegate fullScreenVBDelegate, QUIButton qUIButton, Integer num, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num = null;
        }
        fullScreenVBDelegate.e0(qUIButton, num);
    }

    private final int t(int position, int delta, Editable editable) {
        int i3 = position + delta;
        if (editable == null || i3 <= 0) {
            return 0;
        }
        if (i3 > editable.length()) {
            return editable.length();
        }
        return i3;
    }

    private final void u() {
        boolean z16;
        ValueAnimator valueAnimator = this.mStyleAnimator;
        boolean z17 = true;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            ValueAnimator valueAnimator2 = this.mStyleAnimator;
            if (valueAnimator2 == null || !valueAnimator2.isStarted()) {
                z17 = false;
            }
            if (!z17) {
                return;
            }
        }
        ValueAnimator valueAnimator3 = this.mStyleAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator4 = this.mStyleAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.cancel();
        }
        ValueAnimator valueAnimator5 = this.mIconAlphaAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.cancel();
        }
        ValueAnimator valueAnimator6 = this.mIconTranslationY;
        if (valueAnimator6 != null) {
            valueAnimator6.cancel();
        }
        ValueAnimator valueAnimator7 = this.mSendBtnAlphaAnimator;
        if (valueAnimator7 != null) {
            valueAnimator7.cancel();
        }
        ValueAnimator valueAnimator8 = this.mSendBtnTranslationX;
        if (valueAnimator8 != null) {
            valueAnimator8.cancel();
        }
        ValueAnimator valueAnimator9 = this.mSendBtnTranslationY;
        if (valueAnimator9 != null) {
            valueAnimator9.cancel();
        }
    }

    private final void v() {
        int roundToInt;
        QUIButton qUIButton;
        u();
        com.tencent.mobileqq.aio.utils.b.f194119a.s("em_bas_enter_full_screen");
        Y(new f.b(false));
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar = this.mBinding;
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar = null;
        }
        ConstraintLayout root = aVar.getRoot();
        int paddingLeft = root.getPaddingLeft();
        com.tencent.qqnt.util.view.b bVar = com.tencent.qqnt.util.view.b.f362999a;
        root.setPadding(paddingLeft, bVar.b(6), root.getPaddingRight(), bVar.b(6));
        ViewGroup.LayoutParams layoutParams = root.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.height = -2;
        marginLayoutParams.topMargin = 0;
        root.setLayoutParams(marginLayoutParams);
        com.tencent.aio.view_dsl.dsl.f.c(root, false);
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        editText.setGravity(16);
        editText.setMaxLines(6);
        roundToInt = MathKt__MathJVMKt.roundToInt(Math.abs(editText.getPaint().getFontMetrics().bottom - editText.getPaint().getFontMetrics().top) * editText.getMaxLines());
        editText.setMaxHeight(roundToInt);
        editText.setPadding(bVar.b(11), bVar.b(6), bVar.b(11), bVar.b(6));
        V(editText);
        LinearLayout root2 = C().getRoot();
        if (root2.getParent() != null) {
            root2.removeView(root2);
        }
        root2.setVisibility(8);
        U(1);
        U(2);
        U(3);
        U(5);
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar3 = this.mBinding;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            aVar3 = null;
        }
        View d16 = aVar3.d();
        ViewGroup.LayoutParams layoutParams2 = d16.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams2;
        ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin = bVar.b(16);
        if (com.tencent.mobileqq.aio.input.inputbar.compat.e.INSTANCE.a()) {
            ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = 0;
            ((ViewGroup.MarginLayoutParams) layoutParams3).height = bVar.b(42);
            if (d16 instanceof QUIButton) {
                qUIButton = (QUIButton) d16;
            } else {
                qUIButton = null;
            }
            e0(qUIButton, Integer.valueOf(com.tencent.qqnt.aio.utils.l.b(12)));
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin = bVar.b(3);
            ((ViewGroup.MarginLayoutParams) layoutParams3).height = bVar.b(36);
        }
        d16.setLayoutParams(layoutParams3);
        com.tencent.mobileqq.aio.input.inputbar.viewbinding.a aVar4 = this.mBinding;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            aVar2 = aVar4;
        }
        Intrinsics.checkNotNull(E(aVar2.getRoot()), "null cannot be cast to non-null type android.view.View");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.input.fullscreen.h
            @Override // java.lang.Runnable
            public final void run() {
                FullScreenVBDelegate.w(FullScreenVBDelegate.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(FullScreenVBDelegate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y(f.a.f189633d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        if (this.mIsCheckingImageSpanStyle) {
            return;
        }
        this.mIsCheckingImageSpanStyle = true;
        EditText editText = this.mEditText;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        final Editable editableText = editText.getEditableText();
        a[] imageSpans = (a[]) editableText.getSpans(0, editableText.length(), a.class);
        final Function2<a, a, Integer> function2 = new Function2<a, a, Integer>(editableText) { // from class: com.tencent.mobileqq.aio.input.fullscreen.FullScreenVBDelegate$checkImageSpanStyle$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Editable $editable;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$editable = editableText;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) editableText);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Integer invoke(a aVar, a aVar2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? Integer.valueOf(this.$editable.getSpanStart(aVar) - this.$editable.getSpanStart(aVar2)) : (Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar, (Object) aVar2);
            }
        };
        Arrays.sort(imageSpans, new Comparator() { // from class: com.tencent.mobileqq.aio.input.fullscreen.g
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int y16;
                y16 = FullScreenVBDelegate.y(Function2.this, obj, obj2);
                return y16;
            }
        });
        Intrinsics.checkNotNullExpressionValue(imageSpans, "imageSpans");
        for (a aVar : imageSpans) {
            int spanStart = editableText.getSpanStart(aVar);
            if (spanStart > 0 && editableText.charAt(spanStart - 1) != '\n') {
                editableText.insert(spanStart, "\n");
            }
            int spanEnd = editableText.getSpanEnd(aVar);
            if (spanEnd < editableText.length() && editableText.charAt(spanEnd) != '\n') {
                editableText.insert(spanEnd, "\n");
            }
        }
        this.mIsCheckingImageSpanStyle = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int y(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final boolean z(int position, Editable editable) {
        if (editable == null || position <= 0 || position > editable.length() || editable.charAt(position - 1) == '\n') {
            return false;
        }
        return true;
    }

    @Override // com.tencent.input.base.mvicompat.a
    @NotNull
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.input.adorn.b getMHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.input.adorn.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mHost;
    }

    @Override // com.tencent.input.base.mvicompat.c
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull InputUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof FullScreenUIState.SetFullScreenModeUIState) {
            G(((FullScreenUIState.SetFullScreenModeUIState) state).a());
            return;
        }
        if (state instanceof FullScreenUIState.InsertPicUIState) {
            FullScreenUIState.InsertPicUIState insertPicUIState = (FullScreenUIState.InsertPicUIState) state;
            N(insertPicUIState.a(), insertPicUIState.b());
        } else if (state instanceof FullScreenUIState.UpdateFullScreenAbilityUIState) {
            FullScreenUIState.UpdateFullScreenAbilityUIState updateFullScreenAbilityUIState = (FullScreenUIState.UpdateFullScreenAbilityUIState) state;
            I(updateFullScreenAbilityUIState.b(), updateFullScreenAbilityUIState.a());
        } else if (state instanceof FullScreenUIState.UpdateEmojiContentDescription) {
            b0(C().f444786c, ((FullScreenUIState.UpdateEmojiContentDescription) state).a());
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull com.tencent.mobileqq.aio.input.inputbar.viewbinding.a binding) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) binding);
            return;
        }
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.mBinding = binding;
        this.mEditText = binding.a();
        Context context = binding.getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "binding.root.context");
        this.mContext = context;
    }

    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void Y(@NotNull at.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        } else {
            c.a.f(this, aVar);
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void a() {
        int roundToInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        c.a.b(this);
        EditText editText = this.mEditText;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText = null;
        }
        EditText editText3 = this.mEditText;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText3 = null;
        }
        float f16 = editText3.getPaint().getFontMetrics().bottom;
        EditText editText4 = this.mEditText;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            editText4 = null;
        }
        float abs = Math.abs(f16 - editText4.getPaint().getFontMetrics().top) * 6;
        EditText editText5 = this.mEditText;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            editText2 = editText5;
        }
        roundToInt = MathKt__MathJVMKt.roundToInt(abs);
        editText2.setMaxHeight(roundToInt);
        editText.addTextChangedListener(new b());
    }

    @Override // com.tencent.input.base.mvicompat.a
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public void L0(@NotNull com.tencent.mobileqq.aio.input.adorn.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mHost = bVar;
        }
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void d(@NotNull com.tencent.mvi.api.help.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bVar);
        } else {
            c.a.e(this, bVar);
        }
    }

    @Override // androidx.core.util.Consumer
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void accept(@NotNull InputUIState inputUIState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) inputUIState);
        } else {
            c.a.a(this, inputUIState);
        }
    }

    @Override // com.tencent.mvi.api.ability.c
    @Nullable
    public Bundle generateVBState(@NotNull com.tencent.mvi.api.ability.d stateCmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bundle) iPatchRedirector.redirect((short) 6, (Object) this, (Object) stateCmd);
        }
        Intrinsics.checkNotNullParameter(stateCmd, "stateCmd");
        if (stateCmd instanceof m.b) {
            return F();
        }
        return null;
    }

    @Override // com.tencent.input.base.mvicompat.c
    @Nullable
    public List<Class<? extends InputUIState>> getObserverStates() {
        List<Class<? extends InputUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Class[]{FullScreenUIState.SetFullScreenModeUIState.class, FullScreenUIState.InsertPicUIState.class, FullScreenUIState.UpdateFullScreenAbilityUIState.class, FullScreenUIState.UpdateEmojiContentDescription.class});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.input.base.mvicompat.d
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        c.a.d(this);
        u();
        if (this.mIsFullScreenMode) {
            this.mIsFullScreenMode = false;
            v();
        }
    }
}
