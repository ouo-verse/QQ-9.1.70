package com.tencent.mobileqq.search.voicesearch;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.comment.f;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.search.record.RecordParam;
import com.tencent.mobileqq.search.record.SearchAudioRecoder;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.n;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.QUISearchBarResource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.util.QQToastUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u00012\u00020\u00022\u00020\u0003:\u0003\u00ad\u0001GB.\b\u0007\u0012\b\u0010\u00a7\u0001\u001a\u00030\u00a6\u0001\u0012\f\b\u0002\u0010\u00a9\u0001\u001a\u0005\u0018\u00010\u00a8\u0001\u0012\t\b\u0002\u0010\u00aa\u0001\u001a\u00020\u000e\u00a2\u0006\u0006\b\u00ab\u0001\u0010\u00ac\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\b\u0010\u0015\u001a\u00020\bH\u0002J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\bH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J(\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u0010\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\bH\u0002J\b\u0010$\u001a\u00020#H\u0002J\u0018\u0010'\u001a\u00020\b2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020\bH\u0002J\b\u0010)\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020\fH\u0002J\u000e\u0010-\u001a\u00020\b2\u0006\u0010,\u001a\u00020+J\u0006\u0010.\u001a\u00020\bJ\u0006\u0010/\u001a\u00020\bJ\u000e\u00100\u001a\u00020\b2\u0006\u0010&\u001a\u00020#J\u000e\u00103\u001a\u00020\b2\u0006\u00102\u001a\u000201J\u000e\u00106\u001a\u00020\b2\u0006\u00105\u001a\u000204J\u000e\u00109\u001a\u00020\b2\u0006\u00108\u001a\u000207J\b\u0010:\u001a\u00020\bH\u0016J*\u0010A\u001a\u00020\b2\u0006\u0010;\u001a\u00020\u000e2\b\u0010=\u001a\u0004\u0018\u00010<2\u0006\u0010>\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020?H\u0016J\b\u0010B\u001a\u00020\bH\u0016J\u0018\u0010E\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u000e2\u0006\u0010D\u001a\u00020\fH\u0016J\u0018\u0010G\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010F\u001a\u00020\fH\u0016J \u0010H\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\fH\u0016J\u0010\u0010I\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u000e\u0010K\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u000eJ\u0010\u0010M\u001a\u00020\b2\u0006\u0010L\u001a\u00020\u000eH\u0016J\b\u0010N\u001a\u00020\bH\u0016J\u000e\u0010P\u001a\u00020\b2\u0006\u0010O\u001a\u00020\fJ\u0006\u0010Q\u001a\u00020\bJ\u0006\u0010R\u001a\u00020\bJ\u0006\u0010S\u001a\u00020\bR\u0016\u0010U\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010TR\u0016\u0010V\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010TR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010YR\u0016\u0010n\u001a\u00020l8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010mR\u0016\u0010o\u001a\u00020W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010YR\u0016\u0010r\u001a\u00020p8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010qR\u0016\u0010u\u001a\u00020s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010tR\u0016\u0010v\u001a\u00020f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010hR\u0016\u0010w\u001a\u00020s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010tR\u0016\u0010z\u001a\u00020x8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010yR\u0016\u0010}\u001a\u00020{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010|R\u0016\u0010~\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010QR\u0017\u0010\u0080\u0001\u001a\u00020\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0015\u0010\u0081\u0001\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010$R\u0017\u0010\u0082\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010$R\u0017\u0010\u0085\u0001\u001a\u00030\u0083\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u000f\u0010\u0084\u0001R\u0019\u00102\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b*\u0010\u0086\u0001R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010QR\u0017\u0010\u0087\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010QR\u0017\u0010\u0088\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010QR\u0017\u0010\u0089\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010QR\u0017\u0010\u008a\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010QR\u0018\u0010\u008c\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bS\u0010\u008b\u0001R\u0018\u0010\u008e\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008d\u0001\u0010QR\u0018\u0010\u008f\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001f\u0010\u008b\u0001R\u0015\u0010\u0090\u0001\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010QR\u0015\u0010\u0091\u0001\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\"\u0010$R\u0016\u0010\u0092\u0001\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0019\u0010\u008b\u0001R\u0016\u0010\u0094\u0001\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0093\u0001\u0010$R\u0015\u0010\u0095\u0001\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010$R\u001b\u0010\u0098\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R\u001c\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001b\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0017\u0010\u009b\u0001R\u0019\u0010\u009f\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009e\u0001\u0010\u008b\u0001R\u0018\u0010\u00a1\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a0\u0001\u0010QR\u0018\u0010\u00a5\u0001\u001a\u00030\u00a2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001\u00a8\u0006\u00ae\u0001"}, d2 = {"Lcom/tencent/mobileqq/search/voicesearch/VoiceSearchComponent;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/search/record/a;", "Lcom/tencent/biz/qqcircle/widgets/comment/f$b;", "Landroid/graphics/drawable/Drawable;", "J", "Landroid/view/View;", "bgView", "", "K", "Lcom/tencent/mobileqq/widget/search/QUISearchBarResource;", "O", "", "P", "", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "keyboardHeight", "E", "e0", "G", "U", "i0", "l0", "T", "g0", "p0", "sessionId", "errorCode", "errorMsg", "errorDomain", "d0", "delayTimeMillis", "M", "f0", "", "I", "textContent", "isTextInputMode", "V", "W", "X", ExifInterface.LATITUDE_SOUTH, "Landroidx/fragment/app/Fragment;", "fragment", UserInfo.SEX_FEMALE, "L", "N", "setTextInputMode", "Lcom/tencent/mobileqq/search/voicesearch/VoiceSearchComponent$c;", "listener", "setViewListener", "Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", "actionCallback", "setActionCallback", "Lcom/tencent/mobileqq/search/voicesearch/VoiceSearchComponent$Companion$State;", "targetState", "Y", "onRecorderStart", "maxAmplitude", "", "sliceData", "size", "", "time", "d", "onRecorderEnd", "errCode", "errMsg", "a", "text", "c", "e", "b", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "H", "keyboardHeightInPx", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "pageId", "setPageId", "Z", "a0", "b0", "Lcom/tencent/mobileqq/search/voicesearch/VoiceSearchComponent$Companion$State;", "stateBeforeRecording", "currentState", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "interactiveFloatingView", tl.h.F, "Landroid/view/View;", "gradientBackground", "Lcom/tencent/mobileqq/search/voicesearch/AudioVolumeWaveView;", "i", "Lcom/tencent/mobileqq/search/voicesearch/AudioVolumeWaveView;", "volumeWaveView", "Lcom/tencent/mobileqq/search/voicesearch/VoiceSearchAdaptiveSizeTextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/search/voicesearch/VoiceSearchAdaptiveSizeTextView;", "adaptiveSizeTextView", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "inputOperationFeedbackText", "D", "bottomBarArea", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "quiSearchBar", "voiceInputButton", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "voiceInputButtonLottie", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "voiceInputButtonImage", "voiceInputButtonText", "inputModeSwitchButton", "Landroid/widget/EditText;", "Landroid/widget/EditText;", "editTextForKeyboard", "Lcom/tencent/biz/qqcircle/widgets/comment/f;", "Lcom/tencent/biz/qqcircle/widgets/comment/f;", "softKeyboardStateHelper", "isLongPressed", "", "initialY", "threshold", "lastSoftKeyboardHeight", "Lcom/tencent/mobileqq/search/record/SearchAudioRecoder;", "Lcom/tencent/mobileqq/search/record/SearchAudioRecoder;", "recorder", "Lcom/tencent/mobileqq/search/voicesearch/VoiceSearchComponent$c;", "isSoftKeyboardOpening", "isRecording", "inputConfirm", "outputConfirm", "Ljava/lang/String;", "queryText", "c0", "invalidDownEvent", "recordingSessionId", "ENABLE_AUDIO_AI", "ASR_TIMEOUT_MILLIS", "ASR_PROMPT_TEXT", "h0", "SEARCH_DELAY_TIME_MILLIS", "PANEL_CLOSE_TIMEOUT_MILLIS", "j0", "Landroidx/fragment/app/Fragment;", "hostFragment", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "k0", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTaskForFirstWord", "reportTask", "m0", "reportPageId", "n0", "enableComponent", "Ljava/lang/Runnable;", "o0", "Ljava/lang/Runnable;", "panelCloseRunnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class VoiceSearchComponent extends FrameLayout implements com.tencent.mobileqq.search.record.a, f.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private TextView inputOperationFeedbackText;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private LinearLayout bottomBarArea;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private QUISearchBar quiSearchBar;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private LinearLayout voiceInputButton;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private LottieAnimationView voiceInputButtonLottie;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ImageView voiceInputButtonImage;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private TextView voiceInputButtonText;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private ImageView inputModeSwitchButton;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private EditText editTextForKeyboard;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private com.tencent.biz.qqcircle.widgets.comment.f softKeyboardStateHelper;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isLongPressed;

    /* renamed from: N, reason: from kotlin metadata */
    private float initialY;

    /* renamed from: P, reason: from kotlin metadata */
    private final int threshold;

    /* renamed from: Q, reason: from kotlin metadata */
    private int lastSoftKeyboardHeight;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final SearchAudioRecoder recorder;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private c listener;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isTextInputMode;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isSoftKeyboardOpening;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isRecording;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean inputConfirm;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean outputConfirm;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String queryText;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean invalidDownEvent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Companion.State stateBeforeRecording;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String recordingSessionId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Companion.State currentState;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final boolean ENABLE_AUDIO_AI;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout interactiveFloatingView;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final int ASR_TIMEOUT_MILLIS;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String ASR_PROMPT_TEXT;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View gradientBackground;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final int SEARCH_DELAY_TIME_MILLIS;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AudioVolumeWaveView volumeWaveView;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private final int PANEL_CLOSE_TIMEOUT_MILLIS;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Fragment hostFragment;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask reportTaskForFirstWord;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask reportTask;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VoiceSearchAdaptiveSizeTextView adaptiveSizeTextView;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String reportPageId;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private boolean enableComponent;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable panelCloseRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/search/voicesearch/VoiceSearchComponent$a", "Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", "", "onCancel", "", "onClear", "onBack", "", "onSearch", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a implements QUISearchBar.ActionCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onBack() {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "quiSearchBar onBack called!", null);
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "quiSearchBar onCancel called!", null);
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "quiSearchBar onClear called!", null);
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "quiSearchBar onSearch called! jump2SearchDetail:queryText=" + af.b(VoiceSearchComponent.this.queryText, 0, 2, null), null);
            VoiceSearchComponent voiceSearchComponent = VoiceSearchComponent.this;
            voiceSearchComponent.V(voiceSearchComponent.queryText, VoiceSearchComponent.this.isTextInputMode);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/search/voicesearch/VoiceSearchComponent$b", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "quiSearchBar TextWatcher:afterTextChanged called!", null);
            VoiceSearchComponent.this.queryText = String.valueOf(s16);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "quiSearchBar TextWatcher:beforeTextChanged called!", null);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "quiSearchBar TextWatcher:onTextChanged called!", null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0002H&J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u000bH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/search/voicesearch/VoiceSearchComponent$c;", "", "", "textContent", "", "isTextInputMode", "", "b", "", "getPageMode", "a", "", "getReportParams", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface c {
        @NotNull
        String a();

        void b(@NotNull String textContent, boolean isTextInputMode);

        int getPageMode();

        @NotNull
        Map<String, Object> getReportParams();
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285215a;

        static {
            int[] iArr = new int[Companion.State.values().length];
            try {
                iArr[Companion.State.HIDE_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.State.SMALL_VOICE_INPUT_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Companion.State.STANDARD_VOICE_INPUT_BAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Companion.State.STANDARD_TEXT_INPUT_BAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Companion.State.INPUTTING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Companion.State.CANCELLING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f285215a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J(\u0010\u0010\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/search/voicesearch/VoiceSearchComponent$e", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", "", "", "deniedPermissions", "", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "onMultiSceneDialogDenied", "Lcom/tencent/mobileqq/qqpermission/view/a;", "onMultiSceneDialogShow", "onAllGranted", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDeniedWithoutShowDlg", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class e extends QQPermission.BasePermissionsListener {
        e() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "auido permission loadData audio permission ok. ", null);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDeniedWithoutShowDlg(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDeniedWithoutShowDlg(permissions, results);
            QQToast.makeText(VoiceSearchComponent.this.getContext(), R.string.f17677326, 1).show();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(@Nullable PermissionRequestDialog dialog, @Nullable List<String> deniedPermissions) {
            super.onDialogShow(dialog, deniedPermissions);
            af afVar = af.f284993a;
            if (QLog.isDebugVersion()) {
                QLog.d("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 2, "onMultiSceneDialogShow", (Throwable) null);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onMultiSceneDialogDenied() {
            super.onMultiSceneDialogDenied();
            af afVar = af.f284993a;
            if (QLog.isDebugVersion()) {
                QLog.d("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 2, "auido permission onMultiSceneDialogDenied", (Throwable) null);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onMultiSceneDialogShow(@Nullable com.tencent.mobileqq.qqpermission.view.a dialog) {
            super.onMultiSceneDialogShow(dialog);
            af afVar = af.f284993a;
            if (QLog.isDebugVersion()) {
                QLog.d("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 2, "auido permission onMultiSceneDialogShow", (Throwable) null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/search/voicesearch/VoiceSearchComponent$f", "Lcom/tencent/mobileqq/widget/search/QUISearchBarResource;", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "bar", "Landroid/graphics/drawable/Drawable;", "getInputBackground", "getBackground", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class f extends QUISearchBarResource {
        f() {
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        @NotNull
        public Drawable getBackground(@NotNull QUISearchBar bar) {
            Intrinsics.checkNotNullParameter(bar, "bar");
            Drawable background = super.getBackground(bar);
            Intrinsics.checkNotNullExpressionValue(background, "super.getBackground(bar)");
            return background;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        @NotNull
        public Drawable getInputBackground(@NotNull QUISearchBar bar) {
            Intrinsics.checkNotNullParameter(bar, "bar");
            float dpToPx = ViewUtils.dpToPx(10.0f);
            Drawable l3 = ie0.a.f().l(bar.getContext(), R.color.qui_common_fill_standard_primary, new float[]{dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx}, bar.getCurThemeId());
            Intrinsics.checkNotNullExpressionValue(l3, "getInstances().getQuiTok\u2026ThemeId\n                )");
            return l3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/search/voicesearch/VoiceSearchComponent$g", "Lcom/tencent/mobileqq/widget/search/QUISearchBar$ActionCallback;", "", "onCancel", "", "onClear", "onBack", "", "onSearch", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class g implements QUISearchBar.ActionCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f285218a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ VoiceSearchComponent f285219b;

        g(c cVar, VoiceSearchComponent voiceSearchComponent) {
            this.f285218a = cVar;
            this.f285219b = voiceSearchComponent;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onBack() {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "quiSearchBar onBack called!", null);
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "quiSearchBar onCancel called!", null);
            return 0;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "quiSearchBar onClear called!", null);
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "quiSearchBar onSearch called! listener.startSearch:queryText=" + this.f285219b.queryText, null);
            this.f285218a.b(this.f285219b.queryText, this.f285219b.isTextInputMode);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceSearchComponent(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void E(int keyboardHeight) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = keyboardHeight;
            setLayoutParams(marginLayoutParams);
        }
    }

    private final void G() {
        Companion.State state = this.currentState;
        Companion.State state2 = Companion.State.CANCELLING;
        if (state != state2 && state != Companion.State.HIDE_ALL) {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "cancelling called! hashcode=" + hashCode(), null);
            this.currentState = state2;
            this.bottomBarArea.setVisibility(0);
            this.bottomBarArea.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
            if (this.stateBeforeRecording == Companion.State.SMALL_VOICE_INPUT_BAR) {
                ViewExtKt.c(this.bottomBarArea, ViewUtils.dpToPx(12.0f));
            } else {
                ViewExtKt.c(this.bottomBarArea, ViewUtils.dpToPx(24.0f));
            }
            this.quiSearchBar.setVisibility(8);
            this.interactiveFloatingView.setVisibility(0);
            this.voiceInputButtonLottie.setVisibility(8);
            this.voiceInputButtonImage.setVisibility(0);
            if (ThemeUtil.isNowThemeIsNight(null, true, null)) {
                QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "isNowThemeIsNight!", null);
                this.voiceInputButtonImage.setColorFilter(Color.parseColor("#FFFFFF"));
            } else {
                this.voiceInputButtonImage.clearColorFilter();
            }
            this.inputModeSwitchButton.setVisibility(8);
            this.voiceInputButtonText.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.voiceInputButton.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = ViewUtils.dpToPx(0.0f);
            layoutParams2.weight = 1.0f;
            this.voiceInputButton.setLayoutParams(layoutParams2);
            this.voiceInputButton.setBackgroundResource(R.drawable.kwm);
            this.inputOperationFeedbackText.setText("\u677e\u624b\u53d6\u6d88");
        }
    }

    private final boolean I() {
        BusinessConfig businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_BIG_SEARCH, QQPermissionConstants.Business.SCENE.SCENE_BIG_SEARCH);
        Fragment fragment = this.hostFragment;
        if (fragment != null) {
            QQPermission qQPermission = QQPermissionFactory.getQQPermission(fragment, businessConfig);
            Intrinsics.checkNotNullExpressionValue(qQPermission, "getQQPermission(it, config)");
            if (qQPermission.hasPermission(QQPermissionConstants.Business.ID.QQ_BUSINESS_BIG_SEARCH, QQPermissionConstants.Permission.RECORD_AUDIO) == 0) {
                return true;
            }
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.RECORD_AUDIO}, 2, new e());
            return false;
        }
        return false;
    }

    private final Drawable J() {
        int d16 = QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_bottom_light);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.argb(0, Color.red(d16), Color.green(d16), Color.blue(d16)), d16});
        gradientDrawable.setGradientType(0);
        return gradientDrawable;
    }

    private final void K(View bgView) {
        Drawable background = bgView.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        float dpToPx = ViewUtils.dpToPx(10.0f);
        ((GradientDrawable) background).setCornerRadii(new float[]{dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx, dpToPx});
        this.quiSearchBar.setCustomResource(O());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(int delayTimeMillis) {
        boolean z16;
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "doSearch called! delayTimeMillis=" + delayTimeMillis + ", inputConfirm=" + this.inputConfirm + ", outputConfirm=" + this.outputConfirm + ", queryText=" + this.queryText, null);
        Fragment fragment = this.hostFragment;
        if (fragment != null && !fragment.isResumed()) {
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "doSearch called! fragment is not resumed, ignore this search", null);
            f0();
            Y(this.stateBeforeRecording);
            return;
        }
        if (this.inputConfirm && this.outputConfirm) {
            if (this.queryText.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "doSearch called! queryText.isEmpty()=true, show toast:\u672a\u8bc6\u522b\u5230\u5185\u5bb9", null);
                QQToastUtil.showQQToastInUiThread(0, "\u672a\u8bc6\u522b\u5230\u5185\u5bb9");
                Y(this.stateBeforeRecording);
            } else {
                this.isTextInputMode = false;
                final String str = this.queryText;
                this.quiSearchBar.getInputWidget().setText(str);
                postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent$doSearch$4
                    @Override // java.lang.Runnable
                    public void run() {
                        VoiceSearchComponent.Companion.State state;
                        VoiceSearchComponent voiceSearchComponent = VoiceSearchComponent.this;
                        state = voiceSearchComponent.stateBeforeRecording;
                        voiceSearchComponent.Y(state);
                        VoiceSearchComponent voiceSearchComponent2 = VoiceSearchComponent.this;
                        voiceSearchComponent2.V(str, voiceSearchComponent2.isTextInputMode);
                    }
                }, delayTimeMillis);
            }
            f0();
        }
    }

    private final QUISearchBarResource O() {
        return new f();
    }

    private final String P() {
        String str;
        String audioPanelTips;
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
        ap2.b bVar = (ap2.b) ((IUnitedConfigManager) api).loadConfig("qq_search_audio_ai_config");
        af afVar = af.f284993a;
        String str2 = "QS.QQSearch.NetDetail.AI.VoiceSearchComponent";
        if (bVar == null || (str = bVar.getAudioPanelTips()) == null) {
            str = GlobalUtil.DEF_STRING;
        }
        QLog.i(str2, 1, "getDefaultASRText called! text=" + af.a(str, 2), null);
        if (bVar == null || (audioPanelTips = bVar.getAudioPanelTips()) == null) {
            return "";
        }
        return audioPanelTips;
    }

    private final int Q() {
        Object obj;
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
        ap2.b bVar = (ap2.b) ((IUnitedConfigManager) api).loadConfig("qq_search_audio_ai_config");
        af afVar = af.f284993a;
        String str = "QS.QQSearch.NetDetail.AI.VoiceSearchComponent";
        if (bVar != null) {
            obj = Integer.valueOf(bVar.getPanelCloseTimeoutMillis());
        } else {
            obj = GlobalUtil.DEF_STRING;
        }
        QLog.i(str, 1, "getPanelCloseTimeoutMillis called! timeout=" + obj, null);
        if (bVar != null) {
            return bVar.getPanelCloseTimeoutMillis();
        }
        return 2000;
    }

    private final int R() {
        Object obj;
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
        ap2.b bVar = (ap2.b) ((IUnitedConfigManager) api).loadConfig("qq_search_audio_ai_config");
        af afVar = af.f284993a;
        String str = "QS.QQSearch.NetDetail.AI.VoiceSearchComponent";
        if (bVar != null) {
            obj = Integer.valueOf(bVar.getSearchDelayTimeMills());
        } else {
            obj = GlobalUtil.DEF_STRING;
        }
        QLog.i(str, 1, "getSearchDelayTimeMills called! time=" + obj, null);
        if (bVar != null) {
            return bVar.getSearchDelayTimeMills();
        }
        return 500;
    }

    private final String S() {
        if (ap2.a.f26672a.c()) {
            return "\u6309\u4f4f\u8bf4\u8bddAI\u641c\u7d22";
        }
        return "\u6309\u4f4f\u8bf4\u8bdd";
    }

    private final void T() {
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "hideAll called! hashcode=" + hashCode(), null);
        this.currentState = Companion.State.HIDE_ALL;
        this.bottomBarArea.setVisibility(8);
        this.interactiveFloatingView.setVisibility(8);
    }

    private final void U() {
        Companion.State state = this.currentState;
        Companion.State state2 = Companion.State.INPUTTING;
        if (state != state2 && state != Companion.State.HIDE_ALL) {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "inputting called! hashcode=" + hashCode(), null);
            if (this.currentState != Companion.State.CANCELLING) {
                C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent$inputting$2
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
                        VoiceSearchAdaptiveSizeTextView voiceSearchAdaptiveSizeTextView;
                        String str;
                        af afVar2 = af.f284993a;
                        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "currentState != State.CANCELLING, setText(ASR_PROMPT_TEXT)", null);
                        voiceSearchAdaptiveSizeTextView = VoiceSearchComponent.this.adaptiveSizeTextView;
                        str = VoiceSearchComponent.this.ASR_PROMPT_TEXT;
                        voiceSearchAdaptiveSizeTextView.setPrompt(str);
                    }
                });
            }
            this.currentState = state2;
            this.bottomBarArea.setVisibility(0);
            this.bottomBarArea.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
            if (this.stateBeforeRecording == Companion.State.SMALL_VOICE_INPUT_BAR) {
                ViewExtKt.c(this.bottomBarArea, ViewUtils.dpToPx(12.0f));
            } else {
                ViewExtKt.c(this.bottomBarArea, ViewUtils.dpToPx(24.0f));
            }
            this.quiSearchBar.setVisibility(8);
            this.interactiveFloatingView.setVisibility(0);
            this.voiceInputButtonLottie.setVisibility(8);
            this.voiceInputButtonImage.setVisibility(0);
            if (ThemeUtil.isNowThemeIsNight(null, true, null)) {
                QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "isNowThemeIsNight!", null);
                this.voiceInputButtonImage.setColorFilter(Color.parseColor("#FFFFFF"));
            } else {
                this.voiceInputButtonImage.clearColorFilter();
            }
            this.inputModeSwitchButton.setVisibility(8);
            this.voiceInputButtonText.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.voiceInputButton.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.width = ViewUtils.dpToPx(0.0f);
            layoutParams2.weight = 1.0f;
            this.voiceInputButton.setLayoutParams(layoutParams2);
            this.voiceInputButton.setBackgroundResource(R.drawable.kwr);
            this.inputOperationFeedbackText.setText("\u677e\u624b\u641c\u7d22 \u4e0a\u79fb\u53d6\u6d88");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(final String textContent, final boolean isTextInputMode) {
        int i3;
        if (getContext() != null) {
            com.tencent.mobileqq.search.searchdetail.util.k kVar = com.tencent.mobileqq.search.searchdetail.util.k.f284749a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            c cVar = this.listener;
            if (cVar != null) {
                i3 = cVar.getPageMode();
            } else {
                i3 = -1;
            }
            kVar.e(context, textContent, 34, 19, i3, "", new Function0<Unit>() { // from class: com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent$jump2SearchDetail$1$1
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
                    VoiceSearchComponent.c cVar2;
                    cVar2 = VoiceSearchComponent.this.listener;
                    if (cVar2 != null) {
                        cVar2.b(textContent, isTextInputMode);
                    }
                }
            });
        }
    }

    private final void W() {
        int value;
        c cVar = this.listener;
        if (cVar != null) {
            value = cVar.getPageMode();
        } else {
            value = SearchDetailFragment.Companion.PageMode.MODE_NORMAL.getValue();
        }
        if (!SearchDetailFragment.Companion.PageMode.INSTANCE.a(value)) {
            Y(Companion.State.HIDE_ALL);
        } else if (this.isTextInputMode) {
            Y(Companion.State.STANDARD_TEXT_INPUT_BAR);
        } else {
            Y(Companion.State.STANDARD_VOICE_INPUT_BAR);
        }
    }

    private final void X() {
        int value;
        c cVar = this.listener;
        if (cVar != null) {
            value = cVar.getPageMode();
        } else {
            value = SearchDetailFragment.Companion.PageMode.MODE_NORMAL.getValue();
        }
        if (!SearchDetailFragment.Companion.PageMode.INSTANCE.a(value)) {
            Y(Companion.State.SMALL_VOICE_INPUT_BAR);
        } else {
            Y(Companion.State.STANDARD_TEXT_INPUT_BAR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(VoiceSearchComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Companion.State state = this$0.currentState;
        if (state == Companion.State.INPUTTING || state == Companion.State.CANCELLING) {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "panelCloseRunnable executed!", null);
            this$0.Y(this$0.stateBeforeRecording);
            this$0.d0(this$0.recordingSessionId, VoiceSearchErrorCode.FSTRecorderNoFinish.getValue(), "\u7ed3\u675f\u5f55\u52362\u79d2\u5185\u672a\u6536\u5230\u7ed3\u679c\u56de\u8c03", "");
        }
    }

    private final void d0(String sessionId, int errorCode, String errorMsg, String errorDomain) {
        if (n.e(errorCode)) {
            IPerformanceReportTask iPerformanceReportTask = this.reportTask;
            if (iPerformanceReportTask != null) {
                iPerformanceReportTask.setResultCode(0L);
            }
            IPerformanceReportTask iPerformanceReportTask2 = this.reportTask;
            if (iPerformanceReportTask2 != null) {
                iPerformanceReportTask2.setResultMsg("sessionId=" + sessionId);
            }
            IPerformanceReportTask iPerformanceReportTask3 = this.reportTask;
            if (iPerformanceReportTask3 != null) {
                iPerformanceReportTask3.setParam("Key_ErrorDomain", errorDomain);
            }
            IPerformanceReportTask iPerformanceReportTask4 = this.reportTask;
            if (iPerformanceReportTask4 != null) {
                iPerformanceReportTask4.report();
                return;
            }
            return;
        }
        IPerformanceReportTask iPerformanceReportTask5 = this.reportTask;
        if (iPerformanceReportTask5 != null) {
            iPerformanceReportTask5.setResultCode(errorCode);
        }
        IPerformanceReportTask iPerformanceReportTask6 = this.reportTask;
        if (iPerformanceReportTask6 != null) {
            iPerformanceReportTask6.setResultMsg(errorMsg);
        }
        IPerformanceReportTask iPerformanceReportTask7 = this.reportTask;
        if (iPerformanceReportTask7 != null) {
            iPerformanceReportTask7.setParam("Key_ErrorDomain", errorDomain);
        }
        IPerformanceReportTask iPerformanceReportTask8 = this.reportTask;
        if (iPerformanceReportTask8 != null) {
            iPerformanceReportTask8.report();
        }
    }

    private final void e0() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = 0;
            setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0() {
        this.inputConfirm = false;
        this.outputConfirm = false;
        this.queryText = "";
    }

    private final void g0() {
        if (!this.isSoftKeyboardOpening) {
            return;
        }
        Companion.State state = this.currentState;
        Companion.State state2 = Companion.State.SMALL_VOICE_INPUT_BAR;
        if (state == state2) {
            return;
        }
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "showSmallVoiceInputBar called! hashcode=" + hashCode(), null);
        this.currentState = state2;
        this.bottomBarArea.setVisibility(0);
        this.bottomBarArea.setBackgroundResource(R.drawable.qui_common_transparent_bg);
        ViewExtKt.c(this.bottomBarArea, ViewUtils.dpToPx(12.0f));
        this.quiSearchBar.setVisibility(8);
        this.interactiveFloatingView.setVisibility(8);
        this.voiceInputButtonLottie.setVisibility(0);
        this.voiceInputButtonLottie.setRepeatCount(2);
        this.voiceInputButtonLottie.playAnimation();
        this.voiceInputButtonImage.setVisibility(8);
        this.inputModeSwitchButton.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.voiceInputButton.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.width = -2;
        layoutParams2.weight = 0.0f;
        this.voiceInputButton.setLayoutParams(layoutParams2);
        this.voiceInputButton.setBackgroundResource(R.drawable.kwn);
        this.voiceInputButtonText.setVisibility(0);
        this.voiceInputButtonText.setText(S());
        this.voiceInputButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.search.voicesearch.h
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean h06;
                h06 = VoiceSearchComponent.h0(VoiceSearchComponent.this, view, motionEvent);
                return h06;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h0(VoiceSearchComponent this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int action = motionEvent.getAction();
        boolean z16 = false;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        if (this$0.invalidDownEvent) {
                            af afVar = af.f284993a;
                            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton (invalid) MotionEvent.ACTION_CANCEL! from State.INPUTTING, sessionId=" + this$0.recordingSessionId, null);
                            this$0.invalidDownEvent = false;
                            return true;
                        }
                        af afVar2 = af.f284993a;
                        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton MotionEvent.ACTION_CANCEL from State.SHOW_ENTRY! sessionId=" + this$0.recordingSessionId, null);
                        this$0.isLongPressed = false;
                        this$0.recorder.q();
                        this$0.volumeWaveView.c();
                        this$0.inputConfirm = false;
                        this$0.Y(Companion.State.SMALL_VOICE_INPUT_BAR);
                    }
                } else if (this$0.isLongPressed) {
                    if (Math.abs(motionEvent.getY() - this$0.initialY) > this$0.threshold) {
                        this$0.Y(Companion.State.CANCELLING);
                    } else {
                        this$0.Y(Companion.State.INPUTTING);
                    }
                }
            } else {
                if (this$0.invalidDownEvent) {
                    af afVar3 = af.f284993a;
                    QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton (invalid) MotionEvent.ACTION_UP! from State.INPUTTING, sessionId=" + this$0.recordingSessionId, null);
                    this$0.invalidDownEvent = false;
                    return true;
                }
                af afVar4 = af.f284993a;
                QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton MotionEvent.ACTION_UP from State.SHOW_ENTRY! sessionId=" + this$0.recordingSessionId, null);
                this$0.isLongPressed = false;
                this$0.recorder.q();
                this$0.postDelayed(this$0.panelCloseRunnable, (long) this$0.PANEL_CLOSE_TIMEOUT_MILLIS);
                this$0.volumeWaveView.c();
                Companion.State state = this$0.currentState;
                if (state == Companion.State.INPUTTING) {
                    this$0.inputConfirm = true;
                    QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "\u677e\u624b\u65f6\u523b\u662f\u8f93\u5165\u6001, currentState=" + this$0.currentState + ", inputConfirm=" + this$0.inputConfirm, null);
                    this$0.M(0);
                } else if (state == Companion.State.CANCELLING) {
                    this$0.inputConfirm = false;
                    QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "\u677e\u624b\u65f6\u523b\u662f\u53d6\u6d88\u6001, currentState=" + this$0.currentState + ", inputConfirm=" + this$0.inputConfirm, null);
                    this$0.recorder.i(this$0.recordingSessionId);
                    this$0.Y(Companion.State.SMALL_VOICE_INPUT_BAR);
                    this$0.d0(this$0.recordingSessionId, VoiceSearchErrorCode.FSTRecorderCancel.getValue(), ShareJsPlugin.ERRMSG_INVITE_CANCEL, "");
                } else {
                    this$0.inputConfirm = false;
                    QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "Error\uff01\u677e\u624b\u65f6\u523b\u662f\u5176\u4ed6\u72b6\u6001, currentState=" + this$0.currentState + ", inputConfirm=" + this$0.inputConfirm, null);
                    this$0.Y(Companion.State.SMALL_VOICE_INPUT_BAR);
                }
            }
        } else {
            Companion.State state2 = this$0.currentState;
            Companion.State state3 = Companion.State.INPUTTING;
            if (state2 == state3) {
                af afVar5 = af.f284993a;
                QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton (invalid) MotionEvent.ACTION_DOWN! from State.INPUTTING, sessionId=" + this$0.recordingSessionId, null);
                this$0.invalidDownEvent = true;
                return true;
            }
            af afVar6 = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton MotionEvent.ACTION_DOWN! from State.SHOW_ENTRY", null);
            HashMap hashMap = new HashMap();
            if (this$0.reportPageId.length() > 0) {
                z16 = true;
            }
            if (z16) {
                hashMap.put("dt_pgid", this$0.reportPageId);
            }
            VideoReport.reportEvent("dt_clck", view, hashMap);
            this$0.initialY = motionEvent.getY();
            this$0.f0();
            this$0.adaptiveSizeTextView.h();
            if (!this$0.I()) {
                QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton no permission!", null);
                this$0.d0("", VoiceSearchErrorCode.FSTRecorderNotAuth.getValue(), "noAuth", ErrorDomain.RecordError.getValue());
            } else {
                this$0.stateBeforeRecording = Companion.State.SMALL_VOICE_INPUT_BAR;
                this$0.Y(state3);
                this$0.isLongPressed = true;
                this$0.p0();
            }
        }
        return true;
    }

    private final void i0() {
        Companion.State state = this.currentState;
        Companion.State state2 = Companion.State.STANDARD_TEXT_INPUT_BAR;
        if (state == state2) {
            return;
        }
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "showStandardTextInputBar called! hashcode=" + hashCode(), null);
        this.currentState = state2;
        this.isLongPressed = false;
        this.bottomBarArea.setVisibility(0);
        this.bottomBarArea.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        if (this.isSoftKeyboardOpening) {
            ViewExtKt.c(this.bottomBarArea, ViewUtils.dpToPx(12.0f));
        } else {
            ViewExtKt.c(this.bottomBarArea, ViewUtils.dpToPx(24.0f));
        }
        this.quiSearchBar.setVisibility(0);
        this.interactiveFloatingView.setVisibility(8);
        this.voiceInputButtonLottie.setVisibility(8);
        this.voiceInputButtonImage.setVisibility(8);
        this.voiceInputButton.setVisibility(8);
        this.inputModeSwitchButton.setVisibility(0);
        this.inputModeSwitchButton.setColorFilter(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_icon_primary));
        this.inputModeSwitchButton.setImageResource(R.drawable.qui_microphone_on);
        this.inputModeSwitchButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.voicesearch.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceSearchComponent.j0(VoiceSearchComponent.this, view);
            }
        });
        c cVar = this.listener;
        if (cVar != null) {
            this.quiSearchBar.getInputWidget().setText(cVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(final VoiceSearchComponent this$0, View view) {
        Object obj;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isTextInputMode = false;
        if (this$0.isSoftKeyboardOpening) {
            this$0.editTextForKeyboard.clearFocus();
            Context context = this$0.getContext();
            if (context != null) {
                obj = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            } else {
                obj = null;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) obj).hideSoftInputFromWindow(this$0.getWindowToken(), 0);
        }
        this$0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.voicesearch.k
            @Override // java.lang.Runnable
            public final void run() {
                VoiceSearchComponent.k0(VoiceSearchComponent.this);
            }
        }, 60L);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(VoiceSearchComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y(Companion.State.STANDARD_VOICE_INPUT_BAR);
    }

    private final void l0() {
        Object obj;
        if (this.isSoftKeyboardOpening) {
            af afVar = af.f284993a;
            QLog.w("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "showStandardVoiceInputBar called! but keyboard is opening, closing keyboard", null);
            this.editTextForKeyboard.clearFocus();
            Context context = getContext();
            if (context != null) {
                obj = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            } else {
                obj = null;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) obj).hideSoftInputFromWindow(getWindowToken(), 0);
        }
        Companion.State state = this.currentState;
        Companion.State state2 = Companion.State.STANDARD_VOICE_INPUT_BAR;
        if (state == state2) {
            return;
        }
        af afVar2 = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "showStandardVoiceInputBar called! hashcode=" + hashCode(), null);
        this.currentState = state2;
        this.isLongPressed = false;
        this.bottomBarArea.setVisibility(0);
        this.bottomBarArea.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        ViewExtKt.c(this.bottomBarArea, ViewUtils.dpToPx(24.0f));
        this.quiSearchBar.setVisibility(8);
        this.interactiveFloatingView.setVisibility(8);
        this.voiceInputButtonLottie.setVisibility(8);
        this.voiceInputButtonImage.setVisibility(8);
        this.inputModeSwitchButton.setVisibility(0);
        this.inputModeSwitchButton.clearColorFilter();
        this.inputModeSwitchButton.setImageResource(R.drawable.qui_keyboard_circle_aio_oversized);
        this.voiceInputButton.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.voiceInputButton.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.width = ViewUtils.dpToPx(0.0f);
        layoutParams2.weight = 1.0f;
        this.voiceInputButton.setLayoutParams(layoutParams2);
        this.voiceInputButton.setBackgroundResource(R.drawable.kwq);
        this.voiceInputButtonText.setVisibility(0);
        this.voiceInputButtonText.setText("\u6309\u4f4f \u8bf4\u8bdd");
        this.voiceInputButton.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.search.voicesearch.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean m06;
                m06 = VoiceSearchComponent.m0(VoiceSearchComponent.this, view, motionEvent);
                return m06;
            }
        });
        this.inputModeSwitchButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.voicesearch.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceSearchComponent.n0(VoiceSearchComponent.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m0(VoiceSearchComponent this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int action = motionEvent.getAction();
        boolean z16 = false;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        if (this$0.invalidDownEvent) {
                            af afVar = af.f284993a;
                            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton (invalid) MotionEvent.ACTION_CANCEL! from State.INPUTTING, sessionId=" + this$0.recordingSessionId, null);
                            this$0.invalidDownEvent = false;
                            return true;
                        }
                        af afVar2 = af.f284993a;
                        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton MotionEvent.ACTION_CANCEL from State.SHOW_INPUT_BAR! sessionId=" + this$0.recordingSessionId, null);
                        this$0.isLongPressed = false;
                        this$0.recorder.q();
                        this$0.volumeWaveView.c();
                        this$0.inputConfirm = false;
                        this$0.Y(Companion.State.STANDARD_VOICE_INPUT_BAR);
                    }
                } else if (this$0.isLongPressed) {
                    if (Math.abs(motionEvent.getY() - this$0.initialY) > this$0.threshold) {
                        this$0.Y(Companion.State.CANCELLING);
                    } else {
                        this$0.Y(Companion.State.INPUTTING);
                    }
                }
            } else {
                if (this$0.invalidDownEvent) {
                    af afVar3 = af.f284993a;
                    QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton (invalid) MotionEvent.ACTION_UP! from State.INPUTTING, sessionId=" + this$0.recordingSessionId, null);
                    this$0.invalidDownEvent = false;
                    return true;
                }
                af afVar4 = af.f284993a;
                QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton MotionEvent.ACTION_UP from State.SHOW_INPUT_BAR! sessionId=" + this$0.recordingSessionId, null);
                this$0.isLongPressed = false;
                this$0.recorder.q();
                this$0.volumeWaveView.c();
                Companion.State state = this$0.currentState;
                if (state == Companion.State.INPUTTING) {
                    this$0.inputConfirm = true;
                    QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "\u677e\u624b\u65f6\u523b\u662f\u8f93\u5165\u6001, currentState=" + this$0.currentState + ", inputConfirm=" + this$0.inputConfirm, null);
                    this$0.M(0);
                } else if (state == Companion.State.CANCELLING) {
                    this$0.inputConfirm = false;
                    QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "\u677e\u624b\u65f6\u523b\u662f\u53d6\u6d88\u6001, currentState=" + this$0.currentState + ", inputConfirm=" + this$0.inputConfirm, null);
                    this$0.Y(Companion.State.STANDARD_VOICE_INPUT_BAR);
                } else {
                    this$0.inputConfirm = false;
                    QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "Error\uff01\u677e\u624b\u65f6\u523b\u662f\u5176\u4ed6\u72b6\u6001, currentState=" + this$0.currentState + ", inputConfirm=" + this$0.inputConfirm, null);
                    this$0.Y(Companion.State.STANDARD_VOICE_INPUT_BAR);
                }
            }
        } else {
            Companion.State state2 = this$0.currentState;
            Companion.State state3 = Companion.State.INPUTTING;
            if (state2 == state3) {
                af afVar5 = af.f284993a;
                QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton (invalid) MotionEvent.ACTION_DOWN! from State.INPUTTING, sessionId=" + this$0.recordingSessionId, null);
                this$0.invalidDownEvent = true;
                return true;
            }
            af afVar6 = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton MotionEvent.ACTION_DOWN from State.SHOW_INPUT_BAR!", null);
            HashMap hashMap = new HashMap();
            if (this$0.reportPageId.length() > 0) {
                z16 = true;
            }
            if (z16) {
                hashMap.put("dt_pgid", this$0.reportPageId);
            }
            VideoReport.reportEvent("dt_clck", view, hashMap);
            this$0.initialY = motionEvent.getY();
            this$0.f0();
            this$0.adaptiveSizeTextView.h();
            if (!this$0.I()) {
                QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "voiceInputButton no permission!", null);
                this$0.d0("", VoiceSearchErrorCode.FSTRecorderNotAuth.getValue(), "noAuth", ErrorDomain.RecordError.getValue());
            } else {
                this$0.stateBeforeRecording = Companion.State.STANDARD_VOICE_INPUT_BAR;
                this$0.Y(state3);
                this$0.isLongPressed = true;
                this$0.p0();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(final VoiceSearchComponent this$0, View view) {
        Object obj;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y(Companion.State.HIDE_ALL);
        this$0.isTextInputMode = true;
        this$0.editTextForKeyboard.requestFocus();
        this$0.onSoftKeyboardOpened(this$0.lastSoftKeyboardHeight);
        Context context = this$0.getContext();
        if (context != null) {
            obj = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) obj).showSoftInput(this$0.editTextForKeyboard, 0);
        EditText editText = this$0.editTextForKeyboard;
        editText.setSelection(editText.getText().length());
        this$0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.voicesearch.l
            @Override // java.lang.Runnable
            public final void run() {
                VoiceSearchComponent.o0(VoiceSearchComponent.this);
            }
        }, 60L);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map o(VoiceSearchComponent this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c cVar = this$0.listener;
        if (cVar != null) {
            return cVar.getReportParams();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(VoiceSearchComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y(Companion.State.STANDARD_TEXT_INPUT_BAR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map p(VoiceSearchComponent this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c cVar = this$0.listener;
        if (cVar != null) {
            return cVar.getReportParams();
        }
        return null;
    }

    private final void p0() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.recordingSessionId = uuid;
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "\u5f55\u97f3\u5f00\u59cb! sessionId=" + this.recordingSessionId, null);
        this.isRecording = true;
        SearchAudioRecoder searchAudioRecoder = this.recorder;
        Context context = this.voiceInputButton.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "voiceInputButton.context");
        searchAudioRecoder.p(context, new RecordParam(0.0f, 0.0f, 0, 0, 0, 31, null), this.recordingSessionId);
        removeCallbacks(this.panelCloseRunnable);
        Reporters reporters = Reporters.f231995a;
        this.reportTaskForFirstWord = reporters.c().a("search_ai_asr_quality_first_word");
        this.reportTask = reporters.c().a("search_ai_asr_quality");
    }

    public final void F(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.hostFragment = fragment;
    }

    public final void H(int querySource) {
        int value;
        c cVar = this.listener;
        if (cVar != null) {
            value = cVar.getPageMode();
        } else {
            value = SearchDetailFragment.Companion.PageMode.MODE_NORMAL.getValue();
        }
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "changeToInputBarOrHide called! pageMode=" + value + ", isTextInputMode=" + this.isTextInputMode + ", isSoftKeyboardOpenning=" + this.isSoftKeyboardOpening, null);
        if (SearchDetailFragment.Companion.PageMode.INSTANCE.a(value)) {
            if (!this.isTextInputMode) {
                Y(Companion.State.STANDARD_VOICE_INPUT_BAR);
                return;
            } else {
                Y(Companion.State.STANDARD_TEXT_INPUT_BAR);
                return;
            }
        }
        Y(Companion.State.HIDE_ALL);
    }

    public final void L() {
        this.enableComponent = false;
    }

    public final void N() {
        this.enableComponent = true;
    }

    public final void Y(@NotNull Companion.State targetState) {
        Intrinsics.checkNotNullParameter(targetState, "targetState");
        if (!this.ENABLE_AUDIO_AI) {
            T();
            return;
        }
        if (!this.enableComponent) {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "\u9875\u9762\u7981\u7528\u8bed\u97f3\u7ec4\u4ef6, \u5f3a\u5236\u8f6c\u5165hideAll\u72b6\u6001", null);
            T();
            return;
        }
        af afVar2 = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "move state from " + this.currentState + " to " + targetState + ", hashcode=" + hashCode(), null);
        switch (d.f285215a[targetState.ordinal()]) {
            case 1:
                T();
                return;
            case 2:
                g0();
                return;
            case 3:
                l0();
                return;
            case 4:
                i0();
                return;
            case 5:
                U();
                return;
            case 6:
                G();
                return;
            default:
                return;
        }
    }

    public final void Z() {
        this.recorder.o(null);
        this.recorder.n();
    }

    @Override // com.tencent.mobileqq.search.record.a
    public void a(int errCode, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "onRecordAbnormal called! \u5f55\u97f3\u5f02\u5e38: errCode=" + errCode + ", errMsg=" + errMsg, null);
        removeCallbacks(this.panelCloseRunnable);
        f0();
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent$onRecordAbnormal$2
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
                VoiceSearchComponent.Companion.State state;
                VoiceSearchComponent voiceSearchComponent = VoiceSearchComponent.this;
                state = voiceSearchComponent.stateBeforeRecording;
                voiceSearchComponent.Y(state);
            }
        });
        d0(this.recordingSessionId.toString(), errCode, errMsg, ErrorDomain.RecordError.getValue());
    }

    public final void a0() {
        this.softKeyboardStateHelper.s(this);
    }

    @Override // com.tencent.mobileqq.search.record.a
    public void b(@NotNull String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "onSttQueryFinishWithNoVadSeg called! \u672a\u8bc6\u522b\u5230\u5185\u5bb9, sessionId=" + this.recordingSessionId, null);
        removeCallbacks(this.panelCloseRunnable);
        f0();
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent$onSttQueryFinishWithNoVadSeg$2
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
                VoiceSearchComponent.Companion.State state;
                QQToastUtil.showQQToastInUiThread(0, "\u672a\u8bc6\u522b\u5230\u5185\u5bb9");
                VoiceSearchComponent voiceSearchComponent = VoiceSearchComponent.this;
                state = voiceSearchComponent.stateBeforeRecording;
                voiceSearchComponent.Y(state);
            }
        });
        d0(sessionId, 0, "\u672a\u8bc6\u522b\u5230\u5185\u5bb9", ErrorDomain.PTTError.getValue());
    }

    public final void b0() {
        this.softKeyboardStateHelper.s(this);
        this.softKeyboardStateHelper.a(this);
    }

    @Override // com.tencent.mobileqq.search.record.a
    public void c(@NotNull String sessionId, @NotNull final String text) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(text, "text");
        af afVar = af.f284993a;
        boolean z16 = true;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "onSttUpdateText called! sessionId=" + this.recordingSessionId + ", text=" + text, null);
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent$onSttUpdateText$2
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
                VoiceSearchAdaptiveSizeTextView voiceSearchAdaptiveSizeTextView;
                voiceSearchAdaptiveSizeTextView = VoiceSearchComponent.this.adaptiveSizeTextView;
                voiceSearchAdaptiveSizeTextView.setTextWithTypeWriterEffect(text, "onSttUpdateText");
            }
        });
        IPerformanceReportTask iPerformanceReportTask = this.reportTaskForFirstWord;
        if (iPerformanceReportTask == null || iPerformanceReportTask.getIsReported()) {
            z16 = false;
        }
        if (z16) {
            IPerformanceReportTask iPerformanceReportTask2 = this.reportTaskForFirstWord;
            if (iPerformanceReportTask2 != null) {
                iPerformanceReportTask2.setResultMsg("sessionId=" + sessionId + ", text=" + text);
            }
            IPerformanceReportTask iPerformanceReportTask3 = this.reportTaskForFirstWord;
            if (iPerformanceReportTask3 != null) {
                iPerformanceReportTask3.report();
            }
        }
    }

    @Override // com.tencent.mobileqq.search.record.a
    public void d(final int maxAmplitude, @Nullable byte[] sliceData, int size, double time) {
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent$onRecorderSilceEnd$1
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
                AudioVolumeWaveView audioVolumeWaveView;
                audioVolumeWaveView = VoiceSearchComponent.this.volumeWaveView;
                audioVolumeWaveView.d(maxAmplitude);
            }
        });
        if (time >= this.ASR_TIMEOUT_MILLIS) {
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "\u8bed\u97f3\u8f93\u5165\u65f6\u957f\u8d85\u51fa\u9650\u5236\uff0c\u5df2\u505c\u6b62\u6536\u97f3", null);
            this.recorder.q();
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent$onRecorderSilceEnd$3
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
                    AudioVolumeWaveView audioVolumeWaveView;
                    audioVolumeWaveView = VoiceSearchComponent.this.volumeWaveView;
                    audioVolumeWaveView.c();
                    QQToastUtil.showQQToastInUiThread(1, "\u8bed\u97f3\u8f93\u5165\u65f6\u957f\u8d85\u51fa\u9650\u5236\uff0c\u5df2\u505c\u6b62\u6536\u97f3");
                }
            });
            d0(this.recordingSessionId.toString(), VoiceSearchErrorCode.FSTRecorderTimeOut.getValue(), "\u8bed\u97f3\u8f93\u5165\u65f6\u957f\u8d85\u51fa\u9650\u5236\uff0c\u5df2\u505c\u6b62\u6536\u97f3", "");
        }
    }

    @Override // com.tencent.mobileqq.search.record.a
    public void e(@NotNull String sessionId, final int errorCode, @NotNull final String textContent) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(textContent, "textContent");
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "onSttQueryFinish called! sessionId=" + this.recordingSessionId + ", errorCode=" + errorCode + ", text=" + textContent + ", inputConfirm=" + this.inputConfirm + ", isRecording=" + this.isRecording, null);
        if (this.isRecording) {
            QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "onSttQueryFinish called, but isRecording=" + this.isRecording, null);
            this.outputConfirm = true;
            this.queryText = textContent;
            return;
        }
        removeCallbacks(this.panelCloseRunnable);
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.voicesearch.VoiceSearchComponent$onSttQueryFinish$3
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
                VoiceSearchAdaptiveSizeTextView voiceSearchAdaptiveSizeTextView;
                SearchAudioRecoder searchAudioRecoder;
                VoiceSearchComponent.Companion.State state;
                int i3;
                voiceSearchAdaptiveSizeTextView = VoiceSearchComponent.this.adaptiveSizeTextView;
                voiceSearchAdaptiveSizeTextView.setTextWithoutEffects(textContent, "onSttQueryFinish");
                if (n.e(errorCode)) {
                    VoiceSearchComponent.this.outputConfirm = true;
                    VoiceSearchComponent.this.queryText = textContent;
                    VoiceSearchComponent voiceSearchComponent = VoiceSearchComponent.this;
                    i3 = voiceSearchComponent.SEARCH_DELAY_TIME_MILLIS;
                    voiceSearchComponent.M(i3);
                    return;
                }
                af afVar2 = af.f284993a;
                QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "onSttQueryFinish called! errorCode.isSuccess()=false, show toast:\u672a\u8bc6\u522b\u5230\u5185\u5bb9", null);
                QQToastUtil.showQQToastInUiThread(0, "\u672a\u8bc6\u522b\u5230\u5185\u5bb9");
                searchAudioRecoder = VoiceSearchComponent.this.recorder;
                searchAudioRecoder.q();
                VoiceSearchComponent.this.f0();
                VoiceSearchComponent voiceSearchComponent2 = VoiceSearchComponent.this;
                state = voiceSearchComponent2.stateBeforeRecording;
                voiceSearchComponent2.Y(state);
            }
        });
        d0(sessionId, errorCode, "onSttQueryFinish", ErrorDomain.PTTError.getValue());
    }

    @Override // com.tencent.mobileqq.search.record.a
    public void onRecorderEnd() {
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "onRecorderEnd called!", null);
        this.isRecording = false;
    }

    @Override // com.tencent.mobileqq.search.record.a
    public void onRecorderStart() {
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "onRecorderStart called!", null);
    }

    @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
    public void onSoftKeyboardClosed() {
        this.isSoftKeyboardOpening = false;
        e0();
        W();
    }

    @Override // com.tencent.biz.qqcircle.widgets.comment.f.b
    public void onSoftKeyboardOpened(int keyboardHeightInPx) {
        this.lastSoftKeyboardHeight = keyboardHeightInPx;
        this.isSoftKeyboardOpening = true;
        E(keyboardHeightInPx);
        X();
    }

    public final void setActionCallback(@NotNull QUISearchBar.ActionCallback actionCallback) {
        Intrinsics.checkNotNullParameter(actionCallback, "actionCallback");
        this.quiSearchBar.setActionCallback(actionCallback);
    }

    public final void setPageId(@NotNull String pageId) {
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        this.reportPageId = pageId;
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", this.reportPageId);
        VideoReport.setElementParams(this.voiceInputButton, hashMap);
    }

    public final void setTextInputMode(boolean isTextInputMode) {
        this.isTextInputMode = isTextInputMode;
    }

    public final void setViewListener(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        setActionCallback(new g(listener, this));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceSearchComponent(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VoiceSearchComponent(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceSearchComponent(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.stateBeforeRecording = Companion.State.SMALL_VOICE_INPUT_BAR;
        Companion.State state = Companion.State.HIDE_ALL;
        this.currentState = state;
        this.threshold = 150;
        SearchAudioRecoder searchAudioRecoder = new SearchAudioRecoder();
        this.recorder = searchAudioRecoder;
        this.queryText = "";
        this.recordingSessionId = "";
        this.ENABLE_AUDIO_AI = ap2.a.f26672a.a();
        this.ASR_TIMEOUT_MILLIS = 96000;
        this.ASR_PROMPT_TEXT = P();
        this.SEARCH_DELAY_TIME_MILLIS = R();
        this.PANEL_CLOSE_TIMEOUT_MILLIS = Q();
        this.reportPageId = "";
        this.enableComponent = true;
        this.panelCloseRunnable = new Runnable() { // from class: com.tencent.mobileqq.search.voicesearch.d
            @Override // java.lang.Runnable
            public final void run() {
                VoiceSearchComponent.c0(VoiceSearchComponent.this);
            }
        };
        af afVar = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.AI.VoiceSearchComponent", 1, "new VoiceSearchComponent! initializing! hashcode=" + hashCode(), null);
        LayoutInflater.from(context).inflate(R.layout.h3j, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.f1201378q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.voice_\u2026nteractive_floating_view)");
        this.interactiveFloatingView = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.f99865qy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.top_gradient_bg)");
        this.gradientBackground = findViewById2;
        findViewById2.setBackground(J());
        View findViewById3 = findViewById(R.id.f12025792);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.volume_wave_view)");
        this.volumeWaveView = (AudioVolumeWaveView) findViewById3;
        View findViewById4 = findViewById(R.id.swa);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.asr_text)");
        this.adaptiveSizeTextView = (VoiceSearchAdaptiveSizeTextView) findViewById4;
        View findViewById5 = findViewById(R.id.xoq);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.input_operation_feedback_text)");
        this.inputOperationFeedbackText = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.f1201278p);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.voice_\u2026omponent_bottom_bar_area)");
        this.bottomBarArea = (LinearLayout) findViewById6;
        View findViewById7 = findViewById(R.id.f66403aj);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.qui_search_bar)");
        this.quiSearchBar = (QUISearchBar) findViewById7;
        View findViewById8 = findViewById(R.id.f167116l00);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.voice_input_btn)");
        this.voiceInputButton = (LinearLayout) findViewById8;
        View findViewById9 = findViewById(R.id.f1200678j);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.voice_input_btn_lottie)");
        this.voiceInputButtonLottie = (LottieAnimationView) findViewById9;
        View findViewById10 = findViewById(R.id.f1200578i);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.voice_input_btn_img)");
        this.voiceInputButtonImage = (ImageView) findViewById10;
        View findViewById11 = findViewById(R.id.f1200778k);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.voice_input_btn_text)");
        this.voiceInputButtonText = (TextView) findViewById11;
        View findViewById12 = findViewById(R.id.xop);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.input_mode_switch_btn)");
        this.inputModeSwitchButton = (ImageView) findViewById12;
        QuickPinyinEditText inputWidget = this.quiSearchBar.getInputWidget();
        Intrinsics.checkNotNullExpressionValue(inputWidget, "quiSearchBar.inputWidget");
        this.editTextForKeyboard = inputWidget;
        View inputBg = this.quiSearchBar.getInputBg();
        Intrinsics.checkNotNullExpressionValue(inputBg, "quiSearchBar.inputBg");
        K(inputBg);
        searchAudioRecoder.l();
        searchAudioRecoder.o(this);
        com.tencent.biz.qqcircle.widgets.comment.f fVar = new com.tencent.biz.qqcircle.widgets.comment.f(getRootView());
        this.softKeyboardStateHelper = fVar;
        fVar.a(this);
        com.tencent.mobileqq.search.report.a aVar = com.tencent.mobileqq.search.report.a.f283716a;
        com.tencent.mobileqq.search.report.a.b(aVar, "", "em_bas_switch_keyboard", this.editTextForKeyboard, null, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.search.voicesearch.e
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map o16;
                o16 = VoiceSearchComponent.o(VoiceSearchComponent.this, str);
                return o16;
            }
        }, 120, null);
        com.tencent.mobileqq.search.report.a.b(aVar, "", "em_bas_ai_voice_search", this.voiceInputButton, null, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.search.voicesearch.f
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map p16;
                p16 = VoiceSearchComponent.p(VoiceSearchComponent.this, str);
                return p16;
            }
        }, 120, null);
        setActionCallback(new a());
        this.quiSearchBar.getInputWidget().addTextChangedListener(new b());
        Y(state);
    }
}
